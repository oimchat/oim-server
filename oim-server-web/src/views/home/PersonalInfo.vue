<template>
    <el-card>
        <div slot="header" class="clearfix">
            <span>个人信息</span>
        </div>
        <div class="user-profile">
            <div class="box-center">
                <pan-thumb :image="user.avatar" :height="'100px'" :width="'100px'" :hoverable="false">
                    <div>Hello</div>
                    {{ '欢迎' }}
                </pan-thumb>
            </div>
            <div class="box-center">
                <div class="user-name text-center">{{ user.account }}</div>
                <div class="user-role text-center text-muted">{{ user.nickname}}</div>
            </div>
        </div>
        <div class="user-bio">
            <div class="user-education user-bio-section">
                <div class="user-bio-section-header"><span>详情</span></div>
                <div class="user-bio-section-body">
                    <div class="text-muted">
                        <label>数字账号：</label>
                        <span>{{user.number}}</span>
                    </div>
                    <div class="text-muted">
                        <label>姓名：</label>
                        <span>{{user.name}}</span>
                    </div>
                    <div class="text-muted">
                        <label>手机：</label>
                        <span>{{user.mobile}}</span>
                    </div>
                    <div class="text-muted">
                        <label>邮箱：</label>
                        <span>{{user.email}}</span>
                    </div>
                    <div class="text-muted">
                        <label>性别：</label>
                        <span v-if="user.gender==='1'">男</span>
                        <span v-if="user.gender==='2'">女</span>
                        <span v-if="user.gender==='3'">保密</span>
                    </div>

                    <div class="text-muted">
                        <label>个性签名：</label>
                        <span>{{user.signature}}</span>
                    </div>
                    <div class="text-muted">
                        <label>故乡：</label>
                        <span>{{user.homeAddress}}</span>
                    </div>
                    <div class="text-muted">
                        <label>所在地：</label>
                        <span>{{user.locationAddress}}</span>
                    </div>
                    <div class="text-muted">
                        <label>简介：</label>
                        <span>{{user.introduce}}</span>
                    </div>
                </div>
            </div>

            <div class="user-skills user-bio-section">
                <div class="user-bio-section-header">
                    <span>角色</span>
                </div>
                <div class="user-bio-section-body">
                    <div class="progress-item">
                        <template v-for="item of user.userRoleInfos">
                            {{item.roleName}}、
                        </template>
                    </div>
                </div>
            </div>
        </div>
    </el-card>
</template>

<script lang="ts">
    import {Component, Emit, Inject, Model, Prop, Provide, Vue, Watch} from 'vue-property-decorator';
    import PanThumb from '@/views/component/panthumb/PanThumb.vue';
    import Admin from '@/app/com/main/module/work/system/data/Admin';

    @Component({
        components: {
            PanThumb,
        },
    })
    export default class PersonalInfo extends Vue {
        @Prop({
            type: Object,
            required: false,
            default: () => ({}),
        })
        private user!: {};


        public created() {
            // no
        }

        public mounted() {
            // no
        }
    }
</script>

<style lang="scss" scoped>
    .box-center {
        margin: 0 auto;
        display: table;
    }

    .text-muted {
        color: #777;
    }

    .user-profile {
        .user-name {
            font-weight: bold;
        }

        .box-center {
            padding-top: 10px;
        }

        .user-role {
            padding-top: 10px;
            font-weight: 400;
            font-size: 14px;
        }

        .box-social {
            padding-top: 30px;

            .el-table {
                border-top: 1px solid #dfe6ec;
            }
        }

        .user-follow {
            padding-top: 20px;
        }
    }

    .user-bio {
        margin-top: 20px;
        color: #606266;

        span {
            padding-left: 4px;
        }

        .user-bio-section {
            font-size: 14px;
            padding: 15px 0;

            .user-bio-section-header {
                border-bottom: 1px solid #dfe6ec;
                padding-bottom: 10px;
                margin-bottom: 10px;
                font-weight: bold;
            }
        }
    }
</style>
