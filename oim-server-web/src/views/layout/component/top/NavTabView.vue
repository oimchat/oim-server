<template>
    <div class="menu-wrap">
        <ul ref="menuWrap" class="menu el-menu--horizontal el-menu">
            <template v-for="item of data.items">
                <li
                        ref="tab"
                        :id="item.key"
                        tabindex="0"
                        class="el-menu-item"
                        :class="{
                                  'is-active': data.active===item.key,
                                  'is-disabled': false,
                                  'is-home': 1 === 0
                                }">
                    <div @click.stop="handleSelect(item.key)" class="menu-item">{{item.title}}</div>
                </li>
            </template>
        </ul>
        <el-dropdown>
            <span class="el-dropdown-link" v-show="showMenu">
              更多<i class="el-icon-arrow-down el-icon--right"></i>
            </span>
            <el-dropdown-menu slot="dropdown" class="g-dropdown-menu">
                <template v-for="item of menus">
                    <el-dropdown-item
                            @click.native="handleSelect(item.key)"
                            :class="{
                                  'is-active': data.active===item.key,
                                  'is-disabled': false,
                                  'is-home': 1 === 0
                                }">
                        {{ item.title }}
                    </el-dropdown-item>
                </template>
            </el-dropdown-menu>
        </el-dropdown>
    </div>

</template>

<script lang="ts">
    import {Component, Emit, Inject, Model, Prop, Provide, Vue, Watch} from 'vue-property-decorator';
    import NavTabViewData from '@/views/layout/component/top/NavTabViewData';
    import NavTabData from '@/views/layout/component/top/NavTabData';

    @Component({
        components: {},
    })
    export default class NavTabView extends Vue {
        @Prop({
            type: NavTabViewData,
            required: false,
            default: () => new NavTabViewData(),
        })
        private data!: NavTabViewData;

        private menus: NavTabViewData[] = [];

        public mounted() {
            this.updateMenus();
        }

        public created() {
            const own = this;
            window.onresize = () => {
                own.updateMenus();
            };
        }

        public handleSelect(key: string) {
            // console.log(key);
            this.data.doSelect(key);
        }


        public updateMenus() {
            const own = this;
            const menuWrap: any = this.$refs.menuWrap;
            const tabs = own.$refs.tab as any[];
            if (tabs) {
                const width = menuWrap.clientWidth;

                this.menus = [];
                const map: Map<string, NavTabData> = new Map<string, NavTabData>();
                for (const item of this.data.items) {
                    map.set(item.key, item);
                }
                let nodeWidth = 0;
                const nodes = [];
                for (const tab of tabs) {
                    let full = false;
                    if (nodeWidth < width) {
                        nodeWidth += tab.clientWidth;
                    }
                    if (nodeWidth >= width) {
                        full = true;
                    }
                    if (full) {
                        const key = tab.id;
                        const d: any = map.get(key);
                        if (d) {
                            this.menus.push(d);
                        }
                    }
                }
            }
        }

        get showMenu(): boolean {
            return this.menus && this.menus.length > 0;
        }
    }
</script>
<style lang="scss" scoped>
    $topmenuHeight: 50px;
    .menu-wrap {
        height: $topmenuHeight;
        position: relative;

        .el-dropdown {
            position: absolute;
            z-index: 3;
            right: -47px;
            top: 50%;
            transform: translateY(-50%);
            cursor: pointer;
        }
    }

    .menu {
        overflow: auto;

        &.el-menu.el-menu--horizontal {
            border-bottom: none
        }

        .el-menu-item {
            // width: 116px;
            width: 100px;
            text-align: center;
            text-overflow: ellipsis;
            overflow: hidden;
            position: relative;
            height: $topmenuHeight;
            line-height: $topmenuHeight;
            transition: none;
            color: #2C3749;
            border-bottom: none;
            padding: 0 10px;

            .menu-item {
                vertical-align: top;
                height: 100%;
                box-sizing: border-box;
                display: inline-block;
                transition: border-color .3s,
                background-color .3s, color .3s;
                border-bottom: 2px solid #fff;
                position: relative;
            }

            &.is-active {
                color: #4D7AFF;
                border-bottom: none;

                .menu-item {
                    border-bottom: 2px solid #4D7AFF;
                    color: #4D7AFF;
                }
            }

            &.is-home {
                // padding-left: 35px;
                &::after {
                    content: ' ';
                    position: absolute;
                    display: inline-block;
                    height: 30px;
                    width: 1px;
                    background: #D0D0D0;
                    right: 0;
                    top: 50%;
                    transform: translateY(-50%);
                }
            }

            .hamburger-container {
                position: absolute;
                top: 50%;
                left: 19px;
                transform: translateY(-50%);
                z-index: 111;
            }

            &.is-disabled {
                color: #bbb;
                opacity: 1;
                cursor: default;
            }
        }
    }

    .g-dropdown-menu {
        color: #373942;
        font-size: 14px;

        .is-active.el-dropdown-menu__item:not(.is-disabled) {
            color: #4D7AFF;
        }

        .el-dropdown-menu__item:focus,
        .el-dropdown-menu__item:not(.is-disabled):hover {
            background-color: #ecf5ff;
            color: #4D7AFF
        }
    }
</style>
<style scoped>
    .top-menu {
    }
</style>
