<template>
    <div :class="{'show':show}" class="header-search">
        <el-select
                ref="headerSearchSelect"
                v-model="search"
                :remote-method="querySearch"
                filterable
                default-first-option
                remote
                placeholder="Search"
                class="header-search-select"
                @change="change"
        >
            <el-option v-for="v in options" :key="v.item.key" :value="v.item" :label="v.item.title"/>
        </el-select>
    </div>
</template>

<script lang="ts">
    import {Component, Emit, Inject, Model, Prop, Provide, Vue, Watch} from 'vue-property-decorator';
    import SvgIcon from '@/views/component/svgicon/SvgIcon.vue';
    import Fuse from 'fuse.js';
    import SearchBoxData from '@/views/layout/component/top/SearchBoxData';
    import SearchData from '@/views/layout/component/top/SearchData';

    @Component({
        components: {
            SvgIcon,
        },
    })
    export default class SearchBoxView extends Vue {

        @Prop({
            type: SearchBoxData,
            required: false,
            default: () => new SearchBoxData(),
        })
        private data!: SearchBoxData;
        private search = '';
        private options = [];
        private show = true;
        private fuse: any = {};

        public mounted() {
            this.initFuse(this.data.items);
        }

        public click() {
            this.show = !this.show;
            if (this.show) {
                const v: any = this.$refs.headerSearchSelect;
                if (v) {
                    v.focus();
                }
            }
        }

        public close() {
            const v: any = this.$refs.headerSearchSelect;
            if (v) {
                v.blur();
            }
            this.options = [];
            this.show = false;
        }


        public change(val: SearchData) {
            this.data.selectData(val);
            this.search = '';
            this.options = [];
            this.$nextTick(() => {
                this.show = false;
            });
        }


        public initFuse(list: any[]) {
            this.fuse = new Fuse(list, {
                shouldSort: true,
                threshold: 0.4,
                location: 0,
                distance: 100,
                maxPatternLength: 32,
                minMatchCharLength: 1,
                keys: [{
                    name: 'title',
                    weight: 0.7,
                }, {
                    name: 'key',
                    weight: 0.3,
                }],
            });
        }

        public querySearch(query: any) {
            if (query !== '' && this.fuse) {
                this.options = this.fuse.search(query);
            } else {
                this.options = [];
            }
        }

        @Watch('show')
        public showValue(value: boolean) {
            if (value) {
                document.body.addEventListener('click', this.close);
            } else {
                document.body.removeEventListener('click', this.close);
            }
        }

        @Watch('data.items')
        public searchPoolValue(list: any) {
            this.initFuse(list);
        }
    }
</script>

<style scoped>
</style>

