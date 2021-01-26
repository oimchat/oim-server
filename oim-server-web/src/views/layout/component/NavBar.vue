<template>
    <div class="navbar">
        <hamburger id="hamburger-container"
                   :is-active="opened"
                   class="hamburger-container"
                   @toggleClick="toggleSideBar"/>

        <!-- <breadcrumb id="breadcrumb-container" class="breadcrumb-container"/>-->
        <nav-tab :data="navTab" class="top-menu-container"></nav-tab>
        <div class="right-menu">
            <template>
                <header-search :data="searchBoxData" id="header-search" class="right-menu-item"/>

                <!--                <error-log class="errLog-container right-function-item hover-effect"/>-->

                <!--                <screenfull id="screenfull" class="right-function-item hover-effect"/>-->

                <el-tooltip content="Global Size" effect="dark" placement="bottom">
                    <!--                    <size-select id="size-select" class="right-function-item hover-effect"/>-->
                </el-tooltip>

            </template>

            <el-dropdown class="avatar-container right-menu-item hover-effect" trigger="click">
                <div class="avatar-wrapper">
                    <img :src="personal.avatar"
                         class="user-avatar">
                    <i class="el-icon-caret-bottom"/>
                </div>
                <el-dropdown-menu slot="dropdown">
                    <template v-for="item of personal.menus">
                        <el-dropdown-item @click.native="item.click">
                            <span style="display:block;">{{item.title}}</span>
                        </el-dropdown-item>
                    </template>
                </el-dropdown-menu>
            </el-dropdown>
        </div>
    </div>
</template>

<script lang="ts">
    import {Component, Emit, Inject, Model, Prop, Provide, Vue, Watch} from 'vue-property-decorator';

    import Hamburger from '@/views/layout/component/top/Hamburger.vue';
    import HeaderSearch from '@/views/layout/component/top/SearchBoxView.vue';
    import Breadcrumb from '@/views/layout/component/top/Breadcrumb.vue';
    import TagView from '@/views/layout/component/tag/TagView.vue';
    import NavTab from '@/views/layout/component/top/NavTabView.vue';
    import NavTabViewData from '@/views/layout/component/top/NavTabViewData';
    import PersonalData from '@/views/layout/component/PersonalData';
    import SearchBoxData from '@/views/layout/component/top/SearchBoxData';

    @Component({
        components: {
            Hamburger,
            Breadcrumb,
            HeaderSearch,
            TagView,
            NavTab,
        },
    })
    export default class NavBar extends Vue {
        @Prop({
            type: Boolean,
            required: false,
            default: () => false,
        })
        private opened!: boolean;

        @Prop({
            type: NavTabViewData,
            required: false,
            default: () => new NavTabViewData(),
        })
        private navTab!: NavTabViewData;

        @Prop({
            type: PersonalData,
            required: false,
            default: () => new PersonalData(),
        })
        private personal!: PersonalData;

        @Prop({
            type: SearchBoxData,
            required: false,
            default: () => new SearchBoxData(),
        })
        private searchBoxData!: SearchBoxData;

        @Emit('toggle-click')
        public toggleSideBar() {
            // no
        }
    }
</script>

<style lang="scss" scoped>
    .navbar {
        height: 50px;
        overflow: hidden;
        position: relative;
        background: #fff;
        box-shadow: 0 1px 4px rgba(0, 21, 41, .08);

        .hamburger-container {
            line-height: 46px;
            height: 100%;
            float: left;
            cursor: pointer;
            transition: background .3s;
            -webkit-tap-highlight-color: transparent;

            &:hover {
                background: rgba(0, 0, 0, .025)
            }
        }

        .breadcrumb-container {
            float: left;
        }

        .top-menu-container {
            float: left;
            height: 48px;
            width: calc(100% - 500px);
        }

        .errLog-container {
            display: inline-block;
            vertical-align: top;
        }

        .right-menu {
            float: right;
            height: 100%;
            line-height: 50px;

            &:focus {
                outline: none;
            }

            .right-menu-item {
                display: inline-block;
                padding: 0 8px;
                height: 100%;
                font-size: 18px;
                color: #5a5e66;
                vertical-align: text-bottom;

                &.hover-effect {
                    cursor: pointer;
                    transition: background .3s;

                    &:hover {
                        background: rgba(0, 0, 0, .025)
                    }
                }
            }

            .avatar-container {
                margin-right: 30px;

                .avatar-wrapper {
                    margin-top: 5px;
                    position: relative;

                    .user-avatar {
                        cursor: pointer;
                        width: 40px;
                        height: 40px;
                        border-radius: 10px;
                    }

                    .el-icon-caret-bottom {
                        cursor: pointer;
                        position: absolute;
                        right: -20px;
                        top: 25px;
                        font-size: 12px;
                    }
                }
            }
        }
    }
</style>
