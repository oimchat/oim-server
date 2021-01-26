<template>
    <div class="app-container common-list-pane">
        <el-card>
            <div slot="header">
                <span>系统用户列表</span>
            </div>
            <div class="common-list-pane-search" style="margin-bottom: 20px">
                <el-row>
                    <el-col :span="20" style="float: left">
                        <el-form ref="form" :inline="true" label-width="80px">
                            <el-form-item label="名称">
                                <el-input v-model="query.queryText" placeholder="输入名称"></el-input>
                            </el-form-item>
                        </el-form>
                    </el-col>
                    <el-col :span="4">
                        <div style="margin-left: 20px;margin-bottom: 10px;">
                            <el-button @click="queryList" type="primary">搜索</el-button>
                            <el-button @click="showAdd" type="primary">新增</el-button>
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
                            type="index"
                            width="50">
                    </el-table-column>
                    <el-table-column
                            prop="name"
                            label="姓名">
                    </el-table-column>
                    <el-table-column
                            prop="nickname"
                            label="昵称">
                    </el-table-column>
                    <el-table-column
                            prop="number"
                            label="数字账号">
                    </el-table-column>
                    <el-table-column
                            prop="account"
                            label="帐号">
                    </el-table-column>
                    <el-table-column
                            prop="email"
                            label="邮箱">
                    </el-table-column>
                    <el-table-column
                            label="是否禁用">
                        <template slot-scope="scope">
                            <span v-if="scope.row.isDisable===0">启用</span>
                            <span v-if="scope.row.isDisable===1">停用</span>
                        </template>
                    </el-table-column>
                    <el-table-column
                            label="角色"
                            width="180">
                        <template slot-scope="scope">
                            <ul>
                                <template v-for="r of scope.row.userRoleInfos">
                                    <li>{{r.roleName}}</li>
                                </template>
                            </ul>
                        </template>
                    </el-table-column>
                    <el-table-column
                            fixed="right"
                            label="操作"
                            width="220">
                        <template slot-scope="scope">
                            <el-button @click="handleEdit(scope.row)" type="text" size="mini">编辑</el-button>
                            <el-button @click="handleUpdatePassword(scope.row)" type="text" size="mini">修改密码</el-button>
                            <el-button @click="handleSetToGeneral(scope.row)" type="text" size="mini">取消管理员</el-button>
                            <template v-if="scope.row.isDisable===0">
                                <el-button @click="handleUpdateIsDisable(scope.row,1)"
                                           type="text"
                                           size="mini"
                                           style="color: #fa4359">
                                    停用
                                </el-button>
                            </template>
                            <template v-if="scope.row.isDisable===1">
                                <el-button @click="handleUpdateIsDisable(scope.row,0)"
                                           type="text"
                                           size="mini"
                                           style="color: #fa4359">
                                    启用
                                </el-button>
                            </template>
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

        <el-dialog title="新增用户" :visible.sync="addVisible" width="1200px">
            <admin-add ref="addView" @on-done="addDone"></admin-add>
        </el-dialog>

        <el-dialog title="用户编辑" :visible.sync="editVisible" width="1200px">
            <admin-update ref="editView" :data-id="editId" @on-done="editDone"></admin-update>
        </el-dialog>
        <el-dialog title="修改密码" :visible.sync="updatePasswordVisible">
            <user-update-password :data-id="editId" @on-done="hiddenUpdatePassword"></user-update-password>
        </el-dialog>
    </div>
</template>

<script lang="ts">
    import {Component, Emit, Inject, Model, Prop, Provide, Vue, Watch} from 'vue-property-decorator';
    import AdminAdd from '@/views/module/work/system/admin/AdminAdd.vue';
    import AdminUpdate from '@/views/module/work/system/admin/AdminUpdate.vue';

    import Page from '@/app/com/common/data/Page';

    import AdminClient from '@/app/com/main/module/work/system/AdminClient';
    import AdminQuery from '@/app/com/main/module/work/system/data/AdminQuery';

    import UserUpdatePassword from '@/views/module/work/user/UserUpdatePassword.vue';

    @Component({
        components: {
            AdminUpdate,
            AdminAdd,
            UserUpdatePassword,
        },
    })
    export default class AdminList extends Vue {
        private list: any[] = [];

        private page: Page = new Page();
        private query: AdminQuery = new AdminQuery();

        private editVisible: boolean = false;
        private editId: string = '';

        private updatePasswordVisible: boolean = false;

        private addVisible: boolean = false;

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
            AdminClient.list(query, page, (result) => {
                const info = result.info;
                const body = result.body;
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
                    // no
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


        public handleSetToGeneral(data: any) {
            const own = this;

            if (data && data.id) {
                const id = data.id;
                AdminClient.setToGeneral(id, (result) => {
                    const info = result.info;
                    if (info && info.success) {
                        own.loadList();
                    }
                });
            }
        }

        public handleUpdateIsDisable(data: any, isDisable: number) {
            const own = this;
            if (data && data.id) {
                const id = data.id;
                AdminClient.updateIsDisable(id, isDisable, (result) => {
                    const info = result.info;
                    if (info && info.success) {
                        own.loadList();
                    }
                });
            }
        }

        public handleUpdatePassword(data: any) {
            const id = (data) ? data.id : '';
            this.editId = id;
            this.showUpdatePassword();
        }

        public showUpdatePassword() {
            this.updatePasswordVisible = true;
        }

        public hiddenUpdatePassword() {
            this.updatePasswordVisible = false;
        }

        public showAdd() {
            this.addVisible = true;
        }

        public hiddenAdd() {
            this.addVisible = false;
        }

        public addDone(done: boolean) {
            this.hiddenAdd();
            this.loadList();
        }

    }
</script>

<style scoped>

</style>
