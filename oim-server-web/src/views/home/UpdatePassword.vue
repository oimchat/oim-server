<template>
    <div>
        <el-form ref="form" :model="data" :rules="passwordValidate">
            <el-form-item label="原密码" prop="oldPassword">
                <el-input v-model="data.oldPassword" type="password" placeholder="请输入现在使用的密码"></el-input>
            </el-form-item>
            <el-form-item label="新密码" prop="newPassword">
                <el-input v-model="data.newPassword" type="password" placeholder="请输入新密码，至少6位字符"></el-input>
            </el-form-item>
            <el-form-item label="确认新密码" prop="repeatPassword">
                <el-input v-model="data.repeatPassword" :type="'password'" placeholder="请再次输入新密码"></el-input>
            </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
            <el-button @click="cancel">取消</el-button>
            <el-button type="primary" :loading="saveLoading" @click="save">保存</el-button>
        </div>
    </div>
</template>

<script lang="ts">
import {Component, Emit, Inject, Model, Prop, Provide, Vue, Watch} from 'vue-property-decorator';
import PersonalClient from '@/app/com/main/module/work/personal/PersonalClient';

@Component({
    components: {},
})
export default class UpdatePassword extends Vue {
    private data = {
        oldPassword: '',
        newPassword: '',
        repeatPassword: '',
    };

    private passwordValidate = {
        oldPassword: [
            {required: true, message: '请输入原密码', trigger: 'blur'},
        ],
        newPassword: [
            {required: true, message: '请输入新密码', trigger: 'blur'},
            {min: 6, message: '请至少输入6个字符', trigger: 'blur'},
            {max: 32, message: '最多输入32个字符', trigger: 'blur'},
        ],
        repeatPassword: [
            {required: true, message: '请再次输入新密码', trigger: 'blur'},
            {validator: this.validRepeatPassword, trigger: 'blur'},
        ],
    };
    private saveLoading: boolean = false;

    public cancel() {
        this.onDone();
    }

    public save(): void {
        const own = this;
        const data = this.data;
        (this.$refs as any).form.validate((valid: boolean) => {
            if (valid) {
                own.saveLoading = true;
                PersonalClient.updatePassword(data.newPassword, data.oldPassword, (result) => {
                    const info = result.info;
                    if (info && info.success) {
                        own.onDone();
                    }
                    own.saveLoading = false;
                });
            }
        });
    }

    @Emit('on-done')
    public onDone() {
        // no
    }

    private validRepeatPassword(rule: any, value: any, callback: any) {
        if (value !== this.data.newPassword) {
            callback(new Error('两次输入密码不一致'));
        } else {
            callback();
        }
    }
}
</script>

<style scoped>
.dialog-footer {
    text-align: right;
}
</style>
