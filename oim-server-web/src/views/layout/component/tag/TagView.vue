<template>
    <div id="tags-view-container" class="tags-view-container">
        <tag-scroll-pane ref="scrollPane" class="tags-view-wrapper">
            <template v-for=" tag in data.items">
                <label ref="tag"
                       :id="tag.key"
                       @contextmenu.prevent="openMenu(tag,$event)"
                       @click="onClick(tag)"
                       :class="(isActive(tag.key)?'active':'')+' tags-view-item'">
                    {{tag.title}}
                    <span @click.prevent.stop="onClose(tag)" class="el-icon-close"/>
                </label>
            </template>

        </tag-scroll-pane>
        <ul v-show="contextMenu.visible" :style="{left:contextMenu.left+'px',top:contextMenu.top+'px'}"
            class="contextmenu">
            <li @click="onMenuClose">关闭</li>
            <li @click="onMenuCloseOther">关闭其他</li>
            <li @click="onMenuCloseAll">全部关闭</li>
        </ul>
    </div>
</template>

<script lang="ts">
    import {Component, Emit, Inject, Model, Prop, Provide, Vue, Watch} from 'vue-property-decorator';

    import TagScrollPane from '@/views/layout/component/tag/TagScrollPane.vue';
    import TagData from '@/views/layout/component/tag/TagData';
    import TagViewData from '@/views/layout/component/tag/TagViewData';

    @Component({
        components: {
            TagScrollPane,
        },
    })
    export default class TagView extends Vue {
        @Prop({
            type: TagViewData,
            required: true,
            default: () => new TagViewData(),
        })
        private data!: TagViewData;

        private contextMenu = {
            visible: false,
            top: 0,
            left: 0,
        };

        private selectedTag: string = '';

        public isActive(key: string) {
            return this.data.active === key;
        }

        public onClick(tag: TagData) {
            this.data.selectTag(tag);
        }

        public onClose(tag: TagData) {
            this.data.removeTagByKey(tag.key);
        }

        public onMenuClose() {
            this.data.removeTagByKey(this.selectedTag);
            this.closeMenu();
        }

        public onMenuCloseOther() {
            this.data.removeOtherTagByKey(this.selectedTag);
            this.closeMenu();
        }

        public onMenuCloseAll() {
            this.data.removeAllTag();
            this.closeMenu();
        }

        public openMenu(tag: any, e: any) {

            const v: any = this.$el;
            const menuMinWidth = 105;
            const offsetLeft = this.$el.getBoundingClientRect().left;
            const offsetWidth = v.offsetWidth;
            const maxLeft = offsetWidth - menuMinWidth;
            const left = e.clientX - offsetLeft + 15; // 15: margin right
            const contextMenu = this.contextMenu;
            if (left > maxLeft) {
                contextMenu.left = maxLeft;
            } else {
                contextMenu.left = left;
            }
            contextMenu.top = e.clientY;
            contextMenu.visible = true;
            this.selectedTag = tag.key;
        }

        public closeMenu() {
            this.contextMenu.visible = false;
        }

        public handleScroll() {
            this.closeMenu();
        }

        public moveToCurrentTag() {
            const own = this;
            this.$nextTick(() => {
                const tags = own.$refs.tag as any[];
                for (const tag of tags) {
                    if (tag.id === own.data.active) {
                        const v: any = own.$refs.scrollPane;
                        v.moveToTarget(tag);
                        // when query is different then update
                        break;
                    }
                }
            });
        }

        @Watch('contextMenu.visible')
        public visible(value: boolean) {
            if (value) {
                document.body.addEventListener('click', this.closeMenu);
            } else {
                document.body.removeEventListener('click', this.closeMenu);
            }
        }

        @Watch('data.active')
        public active(active: string) {
            this.moveToCurrentTag();
        }
    }
</script>

<style lang="scss" scoped>
    .tags-view-container {
        height: 36px;
        width: 100%;
        background: #f1f0f0;
        border-bottom: 1px solid #d8dce5;
        box-shadow: 0 1px 5px 0 rgba(0, 0, 0, 0.15), 0 7px 9px 0 rgba(0, 0, 0, 0.05);

        .tags-view-wrapper {
            .tags-view-item {
                display: inline-block;
                position: relative;
                cursor: pointer;
                /*height: 26px;*/
                /*line-height: 26px;*/
                /*border: 1px solid #d8dce5;*/
                color: #495060;
                background: #fff;
                padding: 0 8px;
                font-size: 12px;
                /*margin-left: 5px;*/
                /*margin-top: 4px;*/

                height: 32px;
                line-height: 32px;
                border: 1px solid #e8eaec !important;
                /*color: #515a6e !important;*/


                margin: 2px 4px 2px 0;
                border-radius: 3px;
                vertical-align: middle;
                opacity: 1;
                overflow: hidden;

                &:first-of-type {
                    margin-left: 15px;
                }

                &:last-of-type {
                    margin-right: 15px;
                }

                &.active {
                    background-color: #42b983;
                    color: #fff;
                    border-color: #42b983;

                    &::before {
                        content: '';
                        background: #fff;
                        display: inline-block;
                        width: 8px;
                        height: 8px;
                        border-radius: 50%;
                        position: relative;
                        margin-right: 2px;
                    }
                }
            }
        }

        .contextmenu {
            margin: 0;
            background: #fff;
            z-index: 3000;
            position: absolute;
            list-style-type: none;
            padding: 5px 0;
            border-radius: 4px;
            font-size: 12px;
            font-weight: 400;
            color: #333;
            box-shadow: 2px 2px 3px 0 rgba(0, 0, 0, .3);

            li {
                margin: 0;
                padding: 7px 16px;
                cursor: pointer;

                &:hover {
                    background: #eee;
                }
            }
        }
    }
</style>

<style lang="scss">
    //reset element css of el-icon-close
    .tags-view-wrapper {
        .tags-view-item {
            .el-icon-close {
                width: 16px;
                height: 16px;
                vertical-align: 2px;
                border-radius: 50%;
                text-align: center;
                transition: all .3s cubic-bezier(.645, .045, .355, 1);
                transform-origin: 100% 50%;

                &:before {
                    transform: scale(.6);
                    display: inline-block;
                    vertical-align: -3px;
                }

                &:hover {
                    background-color: #b4bccc;
                    color: #fff;
                }
            }
        }
    }
</style>

