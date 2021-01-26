import UserClient from '@/app/com/main/module/work/user/UserClient';

class UserCheck {

    public data: any = {};
    public updateValidate = {
        name: [
            {required: true, message: '姓名不能为空', trigger: 'blur'},
        ],
        account: [
            {required: true, message: '账号不能为空', trigger: 'blur'},
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

    private isAccountExist(rule: any, value: any, callback: any) {
        const id = this.data.id;
        UserClient.isAccountExist(id, value, (data: any) => {
            const body = data.body;
            if (body.exist === true) {
                return callback(new Error('账号已存在！'));
            } else {
                callback();
            }
        });
    }

    private isEmailExist(rule: any, value: any, callback: any) {
        UserClient.isEmailExist(this.data.id, this.data.account, (data: any) => {
            const body = data.body;
            if (body.exist === true) {
                return callback(new Error('邮箱已存在！'));
            } else {
                callback();
            }
        });
    }

    private isMobileExist(rule: any, value: any, callback: any) {
        UserClient.isMobileExist(this.data.id, this.data.account, (data: any) => {
            const body = data.body;
            if (body.exist === true) {
                return callback(new Error('手机已存在！'));
            } else {
                callback();
            }
        });
    }
}

export default UserCheck;
