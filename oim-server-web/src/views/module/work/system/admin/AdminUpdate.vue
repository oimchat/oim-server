<template>
    <div>
        <div>
            <el-row style="height: 100%">
                <el-col :span="10">
                    <el-card>
                        <el-form ref="form" :model="data" :rules="ruleValidate"
                                 :label-position="'right'"
                                 label-width="120px">
                            <el-card>
                                <div slot="header">
                                    <span>基本信息</span>
                                </div>
                                <div>
                                    <el-form-item label="姓名：" prop="name">
                                        <el-input v-model="data.name" placeholder="姓名" type="text"/>
                                    </el-form-item>
                                    <el-form-item label="账号：" prop="account">
                                        <el-input v-model="data.account" placeholder="账号" type="text"/>
                                    </el-form-item>
                                    <el-form-item label="昵称：" prop="nickname">
                                        <el-input v-model="data.nickname" placeholder="昵称" type="text"/>
                                    </el-form-item>
                                    <el-form-item label="手机：" prop="mobile">
                                        <el-input v-model="data.mobile" placeholder="手机" type="text"/>
                                    </el-form-item>
                                    <el-form-item label="邮箱：" prop="email">
                                        <el-input v-model="data.email" placeholder="邮箱" type="text"/>
                                    </el-form-item>
                                    <el-form-item label="性别：" prop="gender">
                                        <el-select v-model="data.gender">
                                            <el-option value="1" :label="'男'"/>
                                            <el-option value="2" :label="'女'"/>
                                            <el-option value="3" :label="'保密'"/>
                                        </el-select>
                                    </el-form-item>
                                    <el-form-item label="状态：" prop="isDisable">
                                        <el-radio-group v-model="data.isDisable">
                                            <el-radio :label="0">启用</el-radio>
                                            <el-radio :label="1">禁用</el-radio>
                                        </el-radio-group>
                                    </el-form-item>
                                </div>
                            </el-card>
                            <el-card>
                                <div slot="header">
                                    <span>扩展信息</span>
                                </div>
                                <div>
                                    <el-form-item label="个性签名：" prop="signature">
                                        <el-input v-model="data.signature" placeholder="个性签名" type="textarea"/>
                                    </el-form-item>
                                    <el-form-item label="qq：" prop="qq">
                                        <el-input v-model="data.qq" placeholder="QQ" type="text"/>
                                    </el-form-item>
                                    <el-form-item label="出生日期：" prop="birthDate">
                                        <el-date-picker
                                                v-model="data.birthDate"
                                                :start-date="new Date()"
                                                type="date"
                                                value-format="yyyy-MM-dd"
                                                placeholder="出生日期">
                                        </el-date-picker>
                                    </el-form-item>
                                    <el-form-item label="故乡：" prop="homeAddress">
                                        <el-input v-model="data.homeAddress" placeholder="故乡" type="text"/>
                                    </el-form-item>
                                    <el-form-item label="所在地：" prop="locationAddress">
                                        <el-input v-model="data.locationAddress" placeholder="所在地" type="text"/>
                                    </el-form-item>
                                    <el-form-item label="星座：" prop="constellationCode">
                                        <el-select v-model="data.constellationCode">
                                            <el-option value="" :label="'保密'"/>
                                            <el-option value="1" :label="'白羊座'"/>
                                            <el-option value="2" :label="'金牛座'"/>
                                            <el-option value="3" :label="'双子座'"/>
                                            <el-option value="4" :label="'巨蟹座'"/>
                                            <el-option value="5" :label="'狮子座'"/>
                                            <el-option value="6" :label="'处女座'"/>
                                            <el-option value="7" :label="'天秤座'"/>
                                            <el-option value="8" :label="'天蝎座'"/>
                                            <el-option value="9" :label="'射手座'"/>
                                            <el-option value="10" :label="'魔羯座'"/>
                                            <el-option value="11" :label="'水瓶座'"/>
                                            <el-option value="12" :label="'双鱼座'"/>
                                        </el-select>
                                    </el-form-item>
                                    <el-form-item label="血型：" prop="blood">
                                        <el-select v-model="data.blood">
                                            <el-option value="" :label="'保密'"/>
                                            <el-option value="A" :label="'A型'"/>
                                            <el-option value="B" :label="'B型'"/>
                                            <el-option value="AB" :label="'AB型'"/>
                                            <el-option value="O" :label="'O型'"/>
                                            <el-option value="other" :label="'其他血型'"/>
                                        </el-select>
                                    </el-form-item>
                                    <el-form-item label="简介：" prop="introduce">
                                        <el-input v-model="data.introduce" placeholder="介绍" type="textarea"/>
                                    </el-form-item>
                                </div>
                            </el-card>
                        </el-form>
                    </el-card>

                </el-col>
                <el-col :span="14">
                    <el-card>
                        <div slot="header">
                            <span>用户角色</span>
                        </div>
                        <div style="height: 400px">
                            <el-transfer
                                    :titles="['所有角色', '已选角色']"
                                    v-model="roleIds"
                                    :props="{
                                          key: 'id',
                                          label: 'name'
                                        }"
                                    :data="roles">
                            </el-transfer>
                        </div>
                    </el-card>
                </el-col>
            </el-row>
        </div>
        <div slot="footer" class="edit-dialog-footer" style="margin-top: 15px">
            <el-button @click="cancel">取消</el-button>
            <el-button type="primary" :loading="saveLoading" @click="save">保存</el-button>
        </div>
    </div>
</template>

<script lang="ts">
    import {Component, Emit, Inject, Model, Prop, Provide, Vue, Watch} from 'vue-property-decorator';
    import UserNew from '@/app/com/main/module/work/user/data/UserNew';

    import AdminClient from '@/app/com/main/module/work/system/AdminClient';
    import Md5Util from '@/app/lib/util/Md5Util';
    import Role from '@/app/com/main/module/work/system/bean/Role';

    import RoleClient from '@/app/com/main/module/work/system/RoleClient';
    import Admin from '@/app/com/main/module/work/system/data/Admin';

    @Component({
        components: {},
    })
    export default class AdminUpdate extends Vue {
        private saveLoading: boolean = false;

        @Prop({
            type: String,
            required: false,
            default: () => '',
        })
        private dataId!: string;
        private data: Admin = new Admin();


        private ruleValidate = {
            name: [
                {required: true, message: '姓名不能为空', trigger: 'blur'},
            ],
            account: [
                {required: true, message: '账号不能为空', trigger: 'blur'},
                {min: 4, message: '4-32位', trigger: 'blur'},
                {max: 32, message: '4-32位', trigger: 'blur'},
                {
                    validator: (rule: any, value: any, callback: any) => {
                        if (/^[0-9]*$/.test(value)) {
                            callback(new Error('不能纯数字'));
                        } else {
                            callback();
                        }
                    }, trigger: 'blur',
                },
                {pattern: /^[\u4E00-\u9FA5-_A-Za-z0-9]+$/, message: '4-16位字母数字组合或者字母、下划线', trigger: 'blur'},
                {validator: this.isAccountExist, trigger: 'blur'},
            ],
            email: [
                {validator: this.isEmailExist, trigger: 'blur'},
                {email: true, message: '邮箱格式不对', trigger: 'blur'},
            ],
            mobile: [
                {
                    pattern: /^1[3456789]\d{9}$/,
                    message: '手机号格式不对',
                    trigger: 'blur',
                },
                {validator: this.isMobileExist, trigger: 'blur'},
            ],
        };


        private roles: Role[] = [];
        private roleIds: string[] = [];

        public mounted() {
            // no

            this.loadAllRoles();
            this.load();
        }

        public setData(data: Admin) {
            this.data = data;
            if (data) {
                const ids: string[] = [];
                for (const v of data.userRoleInfos) {
                    ids.push(v.roleId);
                }
                this.setRoleIds(ids);
            }
        }

        public setDataId(id: string) {
            this.dataId = id;
            this.loadAllRoles();
            this.load();
        }

        public cancel() {
            this.onDone(false);
        }

        public save(): void {
            const own = this;
            const data = this.data;
            const roleIds = this.roleIds;
            (this.$refs as any).form.validate((valid: boolean) => {
                if (valid) {
                    own.saveLoading = true;
                    AdminClient.addOrUpdate(data, roleIds, (result) => {
                        const info = result.info;
                        if (info && info.success) {
                            own.onDone(true);
                            own.setData(new Admin());
                            own.setRoles([]);
                        }
                        own.saveLoading = false;
                    });
                }
            });
        }

        @Emit('on-done')
        public onDone(done: boolean) {
            // no
            const own = this;
            own.saveLoading = false;
        }

        public load() {
            const own = this;
            const id = own.dataId;
            if (id) {
                AdminClient.getById(id, (result) => {
                    const info = result.info;
                    const body = result.body;
                    if (info && info.success && body) {
                        const r: Admin = body;
                        own.setData(r);
                    }
                });
            } else {
                this.data = new Admin();
            }
        }

        @Watch('dataId')
        public dataIdValue(id: string) {
            this.load();
            this.loadAllRoles();
        }

        public setRoles(roles: Role[]) {
            this.roles = roles;
        }

        public setRoleIds(roleIds: string[]) {
            this.roleIds = roleIds;
        }

        public loadAllRoles() {
            const own = this;
            RoleClient.allList((result) => {
                const body = result.body;
                if (body && body.items) {
                    const roles: Role[] = body.items;
                    own.setRoles(roles);
                }
            });
        }

        private isAccountExist(rule: any, value: any, callback: any) {
            const id = this.data.id;
            AdminClient.isAccountExist(id, this.data.account, (data: any) => {
                const body = data.body;
                if (body.exist === true) {
                    return callback(new Error('账号已存在！'));
                } else {
                    callback();
                }
            });
        }

        private isEmailExist(rule: any, value: any, callback: any) {
            AdminClient.isEmailExist(this.data.id, this.data.email, (data: any) => {
                const body = data.body;
                if (body.exist === true) {
                    return callback(new Error('邮箱已存在！'));
                } else {
                    callback();
                }
            });
        }

        private isMobileExist(rule: any, value: any, callback: any) {
            AdminClient.isMobileExist(this.data.id, this.data.mobile, (data: any) => {
                const body = data.body;
                if (body.exist === true) {
                    return callback(new Error('手机已存在！'));
                } else {
                    callback();
                }
            });
        }
    }
</script>

<style scoped>

</style>
