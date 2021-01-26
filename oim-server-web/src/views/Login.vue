<template>
    <div class="login-container">
        <el-form ref="loginForm" :model="loginForm" :rules="loginRules" class="login-form" autocomplete="on"
                 label-position="left">

            <div class="title-container">
                <h3 class="title">登录</h3>
            </div>

            <el-form-item prop="username">
        <span class="svg-container">
            <i class="fa fa-user" aria-hidden="true"></i>
        </span>
                <el-input
                        ref="username"
                        v-model="loginForm.username"
                        placeholder="Username"
                        name="username"
                        type="text"
                        tabindex="1"
                        autocomplete="on"
                />
            </el-form-item>

            <el-tooltip v-model="capsTooltip" content="Caps lock is On" placement="right" manual>
                <el-form-item prop="password">
          <span class="svg-container">
            <i class="fa fa-lock" aria-hidden="true"></i>
          </span>
                    <el-input
                            :key="passwordType"
                            ref="password"
                            v-model="loginForm.password"
                            :type="passwordType"
                            placeholder="Password"
                            name="password"
                            tabindex="2"
                            autocomplete="on"
                            @keyup.native="checkCapslock"
                            @blur="capsTooltip = false"
                            @keyup.enter.native="handleLogin"
                    />
                    <span class="show-pwd" @click="showPassword">
            <i :class="passwordType === 'password' ? 'fa fa-eye-slash' : 'fa fa-eye'"/>
          </span>
                </el-form-item>
            </el-tooltip>

            <el-button :loading="loading"
                       type="primary"
                       style="width:100%;margin-bottom:30px;"
                       @click.native.prevent="handleLogin">Login
            </el-button>
        </el-form>
    </div>
</template>

<script lang="ts">
    import {Component, Emit, Inject, Model, Prop, Provide, Vue, Watch} from 'vue-property-decorator';
    import SvgIcon from '@/views/component/svgicon/SvgIcon.vue';

    import indexClient from '@/app/com/main/module/work/index/IndexClient';
    import RouterUtil from '@/views/util/RouterUtil';
    import Auth from '@/app/com/common/auth/Auth';

    @Component({
        components: {
            SvgIcon,
        },
    })
    export default class Login extends Vue {
        private passwordType = 'password';
        private capsTooltip = false;
        private loading = false;
        private validateUsername: any = ((rule: any, value: any, callback: any) => {
            if (value.length < 6) {
                callback(new Error('The username can not be less than 6 digits'));
            } else {
                callback();
            }
        });
        private validatePassword: any = ((rule: any, value: any, callback: any) => {
            if (value.length < 6) {
                callback(new Error('The password can not be less than 6 digits'));
            } else {
                callback();
            }
        });

        private loginForm = {
            username: '',
            password: '',
        };
        private loginRules = {
            username: [{required: true, trigger: 'blur', message: '不能为空！'}],
            password: [{required: true, trigger: 'blur', message: '不能为空！'}],
        };


        private created() {
            // window.addEventListener('storage', this.afterQRScan)
        }

        private mounted() {
            if (this.loginForm.username === '') {
                (this.$refs as any).username.focus();
            } else if (this.loginForm.password === '') {
                (this.$refs as any).password.focus();
            }
            if (Auth.isLogin()) {
                RouterUtil.toByPath('/main');
            }
        }

        private destroyed() {
            // window.removeEventListener('storage', this.afterQRScan)
        }

        private checkCapslock(e: any) {
            const {key} = e;
            this.capsTooltip = key && key.length === 1 && (key >= 'A' && key <= 'Z');
        }

        private showPassword() {
            if (this.passwordType === 'password') {
                this.passwordType = '';
            } else {
                this.passwordType = 'password';
            }
            this.$nextTick(() => {
                (this.$refs as any).password.focus();
            });
        }

        private handleLogin() {
            const own = this;
            const loginData = this.loginForm;
            (this.$refs as any).loginForm.validate((valid: boolean) => {
                if (valid) {
                    own.loading = true;
                    indexClient.login(loginData.username, loginData.password, (result) => {
                        const info = result.info;
                        const body = result.body;
                        if (info && info.success && body) {
                            const user = body.user;
                            const token = body.token;
                            Auth.setLogin(true);
                            Auth.setToken(token);
                            Auth.setUserId(user.id);
                            RouterUtil.toByPath('/main');
                        }
                        own.loading = false;
                    });
                } else {
                    return false;
                }
            });
        }
    }
</script>

<style lang="scss">
    $bg: #283443;
    $light_gray: #fff;
    $cursor: #fff;

    @supports (-webkit-mask: none) and (not (cater-color: $cursor)) {
        .login-container .el-input input {
            color: $cursor;
        }
    }

    /* reset element-ui css */
    .login-container {
        .el-input {
            display: inline-block;
            height: 47px;
            width: 85%;

            input {
                background: transparent;
                border: 0px;
                -webkit-appearance: none;
                border-radius: 0px;
                padding: 12px 5px 12px 15px;
                color: $light_gray;
                height: 47px;
                caret-color: $cursor;

                &:-webkit-autofill {
                    box-shadow: 0 0 0px 1000px $bg inset !important;
                    -webkit-text-fill-color: $cursor !important;
                }
            }
        }

        .el-form-item {
            border: 1px solid rgba(255, 255, 255, 0.1);
            background: rgba(0, 0, 0, 0.1);
            border-radius: 5px;
            color: #454545;
        }
    }
</style>

<style lang="scss" scoped>
    $bg: #2d3a4b;
    $dark_gray: #889aa4;
    $light_gray: #eee;

    .login-container {
        min-height: 100%;
        width: 100%;
        background-color: $bg;
        overflow: hidden;

        .login-form {
            position: relative;
            width: 520px;
            max-width: 100%;
            padding: 160px 35px 0;
            margin: 0 auto;
            overflow: hidden;
        }

        .tips {
            font-size: 14px;
            color: #fff;
            margin-bottom: 10px;

            span {
                &:first-of-type {
                    margin-right: 16px;
                }
            }
        }

        .svg-container {
            padding: 6px 5px 6px 15px;
            color: $dark_gray;
            /*vertical-align: middle;*/
            /*width: 30px;*/
            /*display: inline-block;*/
            /*width: 1em;*/
            /*height: 1em;*/
        }

        .title-container {
            position: relative;

            .title {
                font-size: 26px;
                color: $light_gray;
                margin: 0px auto 40px auto;
                text-align: center;
                font-weight: bold;
            }
        }

        .show-pwd {
            position: absolute;
            right: 10px;
            top: 7px;
            font-size: 16px;
            color: $dark_gray;
            cursor: pointer;
            user-select: none;
        }

        .thirdparty-button {
            position: absolute;
            right: 0;
            bottom: 6px;
        }

        @media only screen and (max-width: 470px) {
            .thirdparty-button {
                display: none;
            }
        }
    }
</style>
