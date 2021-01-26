<template>
    <div class="app-container common-list-pane">
        <el-card>
            <div slot="header">
                <span>角色列表</span>
            </div>
            <div class="common-list-pane-search" style="margin-bottom: 20px">
                <el-row>
                    <el-col :span="20" style="float: left">
                        <el-form ref="form" :inline="true" label-width="80px">
                            <el-form-item label="名称">
                                <el-input v-model="query.likeName" placeholder="输入名称"></el-input>
                            </el-form-item>
                        </el-form>
                    </el-col>
                    <el-col :span="4">
                        <div style="margin-left: 20px;margin-bottom: 10px;">
                            <el-button @click="queryList" type="primary">搜索</el-button>
                            <el-button @click="handleEdit" type="primary">新增</el-button>
                        </div>
                    </el-col>
                </el-row>
            </div>
            <div>
                <el-table
                        :data="list"
                        height="500"
                        border
                        style="width: 100%">
                    <el-table-column
                            prop="name"
                            label="名称"
                            width="180">
                    </el-table-column>
                    <el-table-column
                            prop="introduce"
                            label="介绍">
                    </el-table-column>
                    <el-table-column
                            fixed="right"
                            label="操作"
                            width="100">
                        <template slot-scope="scope">
                            <el-button @click="handleEdit(scope.row)" type="text" size="mini">编辑</el-button>
                            <el-button @click="handleDelete(scope.row)" type="text" size="mini" style="color: #fa4359">
                                删除
                            </el-button>
                        </template>
                    </el-table-column>
                </el-table>
            </div>
            <div class="common-list-pane-pagination">
                <el-pagination
                        @size-change="handleSizeChange"
                        @current-change="handleCurrentChange"
                        :current-page="page.number"
                        :page-sizes="[100, 200, 300, 400]"
                        :page-size="page.size"
                        layout="total, sizes, prev, pager, next, jumper"
                        :total="page.totalCount">
                </el-pagination>
            </div>
        </el-card>

        <el-dialog title="角色编辑" :visible.sync="editVisible">
            <role-edit ref="editView" :data-id="editId" @on-done="editDone"></role-edit>
        </el-dialog>
    </div>
</template>

<script lang="ts">
    import {Component, Emit, Inject, Model, Prop, Provide, Vue, Watch} from 'vue-property-decorator';
    import RoleEdit from '@/views/module/work/system/role/RoleEdit.vue';

    import Page from '@/app/com/common/data/Page';

    import RoleClient from '@/app/com/main/module/work/system/RoleClient';
    import RoleQuery from '@/app/com/main/module/work/system/data/RoleQuery';

    @Component({
        components: {
            RoleEdit,
        },
    })
    export default class RoleList extends Vue {
        private list: any[] = [];

        private page: Page = new Page();
        private query: RoleQuery = new RoleQuery();

        private editVisible: boolean = false;
        private editId: string = '';

        public mounted() {
            this.loadList();
        }

        public handleSizeChange(size: number) {
            this.page.size = size;
            this.loadList();
        }

        public handleCurrentChange(pageNumber: number) {
            this.page.number = pageNumber;
            this.loadList();
        }

        public setList(list: any[]) {
            this.list = list;
        }

        public setPage(page: Page) {
            if (page) {
                this.page = page;
            }
        }

        public queryList() {
            const own = this;
            const page = own.page;
            page.number = 1;

            this.loadList();
        }

        public loadList() {
            const own = this;
            const page = own.page;
            const query = own.query;
            RoleClient.list(query, page, (data) => {
                const info = data.info;
                const body = data.body;
                if (info && info.success && body) {
                    const list: any[] = body.items;
                    const p: Page = body.page;
                    own.setPage(p);
                    own.setList(list);
                }
            });
        }

        public handleEdit(data: any) {
            const id = (data) ? data.id : '';
            this.editId = id;
            this.showEdit();
            // (this.$refs as any).editView.setDataId(id);
        }

        public handleDelete(data: any) {
            if (data) {
                const id = (data) ? data.id : '';
                const own = this;
                this.$confirm('此操作将永久删除该数据, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning',
                }).then(() => {
                    RoleClient.deleteById(id, (result) => {
                        const info = result.info;
                        if (info && info.success) {
                            own.loadList();
                        }
                    });
                }).catch(() => {
                    // no
                });
            }
        }

        public showEdit() {
            this.editVisible = true;
        }

        public hiddenEdit() {
            this.editVisible = false;
        }

        public editDone(done: boolean) {
            this.hiddenEdit();
            this.loadList();
        }
    }
</script>

<style scoped>

</style>
