<template>
    <el-card :style="'height: '+getHeight+'px;overflow: hidden'">
        <el-row style="height: 50%">
            <el-col :span="8">
                <el-card>
                    <div slot="header">
                        <span>功能列表</span>
                    </div>
                    <div :style="'height: '+(getHeight-150)+'px;overflow-y: auto'">
                        <el-tree :data="tree"
                                 :props="defaultProps"
                                 @node-click="handleNodeClick"
                                 default-expand-all
                        >
                        </el-tree>
                    </div>
                </el-card>
            </el-col>
            <el-col :span="16">
                <el-card>
                    <div slot="header">
                        <span>功能详情</span>
                    </div>
                    <div style="margin-top: 25px;">
                        <p><span>名称：</span>{{data.name}}</p>
                    </div>
                    <div style="margin-top: 25px;">
                        <p><span>地址：</span>{{data.path}}</p>
                    </div>
                </el-card>
            </el-col>
        </el-row>

    </el-card>
</template>

<script lang="ts">
    import {Component, Emit, Inject, Model, Prop, Provide, Vue, Watch} from 'vue-property-decorator';
    import FunctionClient from '@/app/com/main/module/work/system/FunctionClient';
    import FunctionInfo from '@/app/com/main/module/work/system/bean/FunctionInfo';
    import BaseUtil from '@/app/lib/util/BaseUtil';
    import FunctionTreeNode from '@/app/com/main/module/work/system/data/FunctionTreeNode';

    @Component({
        components: {},
    })
    export default class FunctionTree extends Vue {

        private tree: FunctionTreeNode[] = [];
        private data: FunctionTreeNode = new FunctionTreeNode();
        private defaultProps = {
            children: 'children',
            label: 'name',
        };

        public mounted() {
            this.load();
        }

        public load(): void {
            const own = this;
            FunctionClient.allList((result) => {
                const info = result.info;
                const body = result.body;
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
            this.data = data;
        }

        get getHeight(): number {
            const height = document.documentElement.clientHeight;
            return height - 100;
        }
    }
</script>

<style scoped>

</style>
