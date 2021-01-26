<template>
    <div style="height:100%;overflow-y: auto">
        <el-tree ref="tree"
                 :data="tree"
                 :props="defaultProps"
                 @node-click="handleNodeClick"
                 default-expand-all
                 show-checkbox
                 node-key="id"
        >
        </el-tree>
    </div>
</template>

<script lang="ts">
    import {Component, Emit, Inject, Model, Prop, Provide, Vue, Watch} from 'vue-property-decorator';
    import FunctionClient from '@/app/com/main/module/work/system/FunctionClient';
    import BaseUtil from '@/app/lib/util/BaseUtil';
    import FunctionTreeNode from '@/app/com/main/module/work/system/data/FunctionTreeNode';
    import FunctionSelectTreeData from '@/views/module/work/system/function/FunctionSelectTreeData';

    @Component({
        components: {},
    })
    export default class FunctionSelectTree extends Vue {
        @Prop({
            type: FunctionSelectTreeData,
            required: false,
            default: () => new FunctionSelectTreeData(),
        })
        private data!: FunctionSelectTreeData;
        private tree: FunctionTreeNode[] = [];

        private defaultProps = {
            children: 'children',
            label: 'name',
        };

        public mounted() {
            const own = this;
            this.load();
            this.data.getSelectIds = (() => {
                return own.getCheckedKeys();
            });
            this.data.setSelectIds = ((ids: string[]) => {
                return own.setCheckedKeys(ids);
            });
        }

        public load(): void {
            const own = this;
            FunctionClient.allList((data) => {
                const info = data.info;
                const body = data.body;
                if (info && info.success && body) {
                    const list: FunctionTreeNode[] = body.items;
                    own.setList(list);
                }
            });
        }

        public setList(list: FunctionTreeNode[]) {
            this.tree = [];
            const baseList = this.tree;
            if (list) {
                const map: Map<string, FunctionTreeNode> = new Map<string, FunctionTreeNode>();
                const length = list.length;
                for (let i = 0; i < length; i++) {
                    const menu = list[i];
                    map.set(menu.id, menu);
                    if ('0' === menu.superId || BaseUtil.isEmpty(menu.superId)) {
                        baseList.push(menu);
                    }
                }
                for (let i = 0; i < length; i++) {
                    const menu = list[i];
                    const superId = menu.superId;
                    const superMenu = map.get(superId);
                    if (superMenu) {
                        if (!superMenu.children) {
                            superMenu.children = [];
                        }
                        superMenu.children.push(menu);
                    }
                }
            }
        }

        public handleNodeClick(data: FunctionTreeNode) {
            // no
        }

        public setCheckedKeys(keys: string[]) {
            (this.$refs as any).tree.setCheckedKeys(keys);
        }

        public getCheckedKeys() {
            const keys: string[] = (this.$refs as any).tree.getCheckedKeys();
            return keys;
        }
    }
</script>

<style scoped>

</style>
