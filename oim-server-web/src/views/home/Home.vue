<template>
    <div class="app-container">
        <el-row :gutter="20">

            <el-col :span="10" :xs="24">
                <el-card>
                    <el-row>
                        <el-button @click="showUpdatePassword" type="warning">修改密码</el-button>
                        <el-button @click="handleEdit" type="primary">编辑信息</el-button>
                    </el-row>
                </el-card>
                <personal-info :user="user"></personal-info>
            </el-col>
            <el-col :span="6" :xs="24">
            </el-col>
        </el-row>
        <el-dialog title="修改密码" :visible.sync="updatePasswordVisible">
            <update-password @on-done="hiddenUpdatePassword"></update-password>
        </el-dialog>
        <el-dialog title="编辑用户" :visible.sync="editVisible">
            <user-update ref="editView" :data-id="editId" @on-done="editDone"></user-update>
        </el-dialog>
    </div>
</template>

<script lang="ts">
    import {Component, Emit, Inject, Model, Prop, Provide, Vue, Watch} from 'vue-property-decorator';
    import PersonalInfo from '@/views/home/PersonalInfo.vue';
    import UpdatePassword from '@/views/home/UpdatePassword.vue';
    import UserUpdate from '@/views/module/work/user/UserUpdate.vue';
    import PersonalClient from '@/app/com/main/module/work/personal/PersonalClient';
    import Admin from '@/app/com/main/module/work/system/data/Admin';
    import UserInfoUtil from '@/app/com/main/util/UserInfoUtil';
    import AdminClient from '@/app/com/main/module/work/system/AdminClient';

    @Component({
        components: {
            PersonalInfo,
            UpdatePassword,
            UserUpdate,
        },
    })
    export default class Home extends Vue {
        private activeTab: string = '';
        private updatePasswordVisible: boolean = false;
        private user: Admin = new Admin();
        private editVisible: boolean = false;
        private editId: string = '';

        public created() {
            // no
        }

        public mounted() {
            // no
            this.load();
        }

        public setUser(user: Admin) {
            this.user = user;
            this.editId = user.id;
            UserInfoUtil.handleAvatar(user);
        }

        public load() {
            const own = this;
            PersonalClient.get((result) => {
                const user: Admin = result.body;
                if (user) {
                    own.loadAdmin(user.id);
                }
            });
        }

        public loadAdmin(userId: string) {
            const own = this;
            AdminClient.getById(userId, (result) => {
                const user: Admin = result.body;
                if (user) {
                    own.setUser(user);
                }
            });
        }

        public showUpdatePassword() {
            this.updatePasswordVisible = true;
        }

        public hiddenUpdatePassword() {
            this.updatePasswordVisible = false;
        }


        public showUpdateEdit() {
            this.editVisible = true;
        }

        public hiddenUpdateEdit() {
            this.editVisible = false;
        }

        public editDone() {
            const own = this;
            own.load();
            this.hiddenUpdateEdit();
        }

        public handleEdit() {
            const own = this;
            PersonalClient.get((result) => {
                const user: Admin = result.body;
                if (user) {
                    own.setUser(user);
                    own.showUpdateEdit();
                }
            });
        }
    }
</script>

<style scoped>

</style>
