<template>
    <div :class="classData" class="app-wrapper">
        <div v-if="false" class="drawer-bg" @click="handleClickOutside"/>
        <side-pane :data="sideData" class="sidebar-container"/>
        <div :class="{hasTagsView:true}" class="main-container">
            <div :class="{'fixed-header':true}">
                <nav-bar
                    :opened="!sideData.collapse"
                    :nav-tab="data.navTab"
                    :personal="data.personal"
                    :search-box-data="data.searchBoxData"
                    @toggle-click="toggleClick"
                ></nav-bar>
                <tag-view :data="data.tagViewData"></tag-view>
            </div>
            <container/>
            <right-pane>

            </right-pane>
        </div>
    </div>
</template>

<script lang="ts">
import {Component, Emit, Inject, Model, Prop, Provide, Vue, Watch} from 'vue-property-decorator';

import SidePane from '@/views/layout/component/side/SidePane.vue';
import NavBar from '@/views/layout/component/NavBar.vue';
import RightPane from '@/views/layout/component/right/RightPane.vue';
import Container from '@/views/layout/component/Container.vue';
import TagView from '@/views/layout/component/tag/TagView.vue';

import SideData from '@/views/layout/component/side/SideData';
import TagViewData from '@/views/layout/component/tag/TagViewData';
import LayoutData from '@/views/layout/LayoutData';

import routeConfigBox from '@/router/RouteConfigBox';
import RouteMenuUtil from '@/views/util/RouteMenuUtil';
import RouterUtil from '@/views/util/RouterUtil';
import PersonalMenu from '@/views/layout/component/PersonalMenu';
import PersonalClient from '@/app/com/main/module/work/personal/PersonalClient';
import User from '@/app/com/main/module/work/user/bean/User';
import UserInfoUtil from '@/app/com/main/util/UserInfoUtil';
import Auth from '@/app/com/common/auth/Auth';
import EnterClient from '@/app/com/main/module/work/enter/EnterClient';
import FunctionInfo from '@/app/com/main/module/work/system/bean/FunctionInfo';
import PermissionBox from '@/app/com/common/permission/PermissionBox';

@Component({
    components: {
        NavBar,
        Container,
        SidePane,
        RightPane,
        TagView,
    },
})
export default class Layout extends Vue {
    private data: LayoutData = new LayoutData();
    private sideData: SideData = this.data.sideData;

    public mounted() {
        // no
        this.initializeData();
    }

    public created() {
        // no
        this.initializeView();
    }

    public handleClickOutside() {
        // no
    }

    public toggleClick() {
        this.sideData.collapse = !this.sideData.collapse;
        this.sideData.navMenu.collapse = this.sideData.collapse;
    }

    @Watch('$route')
    public routeValue(route: any) {
        if (route.path.startsWith('/redirect/')) {
            return;
        }
        this.data.selectedMenuKey(route.path);
    }

    public initializeView() {
        const own = this;
        this.sideData.logoData.title = '后台管理';
        this.sideData.logoData.logo = 'https://wpimg.wallstcn.com/69a1c46c-eb1c-4b46-8bd4-e9e686ef5251.png';

        this.data.addSelectedEvent((key) => {
            this.$router.push({path: key});
        });

        const logoutMenu: PersonalMenu = new PersonalMenu();
        logoutMenu.title = '退出';
        logoutMenu.addClickEvent((m) => {
            // no
            Auth.logout();
            RouterUtil.toByPath('/login');
        });
        this.data.personal.menus.push(logoutMenu);
    }

    public initializeData() {
        this.initializeFunction();
        this.initializePersonal();
    }

    public initializeFunction() {
        const own = this;
        PermissionBox.clear();
        EnterClient.functionList((result) => {
            const info = result.info;
            const body = result.body;
            if (info && info.success && body) {
                const items: FunctionInfo[] = body.items;
                if (items) {
                    for (const v of items) {
                        PermissionBox.put(v.service, v.path);
                    }
                    own.initializeMenu();
                    own.initializeTab();
                }
            }
        });
    }

    public initializeTab() {
        this.data.selectedMenuKey(this.$route.path);
    }

    public initializePersonal() {
        const own = this;
        PersonalClient.get((data) => {
            if (data.body) {
                const user: User = data.body;
                UserInfoUtil.handleAvatar(user);
                own.data.personal.avatar = user.avatar;
            }
        });
    }

    public initializeMenu() {
        const tabMap: Map<string, any> = new Map<string, any>();
        const menuMap: Map<string, any[]> = new Map<string, any[]>();
        const configs = routeConfigBox.getRouteConfigs();
        for (const c of configs) {
            const key = c.getKey();
            const menus = RouteMenuUtil.convertMenus(c.getRoutes());
            let tab = tabMap.get(c.getKey());
            if (!tab) {
                tab = {key: key, title: c.getTitle()};
                tabMap.set(key, tab);
            }
            let ms = menuMap.get(c.getKey());
            if (!ms) {
                ms = [];
                menuMap.set(key, ms);
            }
            for (const m of menus) {
                ms.push(m);
            }
        }
        for (const key of tabMap.keys()) {
            const tab = tabMap.get(key);
            const ms = menuMap.get(key);
            if (ms && ms.length > 0) {
                this.data.addTab(tab.key, tab.title, ms);
            }
        }
    }

    get classData() {
        return {
            hideSidebar: this.sideData.collapse,
            openSidebar: !this.sideData.collapse,
            withoutAnimation: this.sideData.collapse,
        };
    }
}
</script>

<style lang="scss" scoped>
@import "~@/styles/mixin.scss";
@import "~@/styles/variables.scss";

.app-wrapper {
    @include clearfix;
    position: relative;
    height: 100%;
    width: 100%;

    &.mobile.openSidebar {
        position: fixed;
        top: 0;
    }
}

.drawer-bg {
    background: #000;
    opacity: 0.3;
    width: 100%;
    top: 0;
    height: 100%;
    position: absolute;
    z-index: 999;
}

.fixed-header {
    position: fixed;
    top: 0;
    right: 0;
    z-index: 9;
    width: calc(100% - #{$sideBarWidth});
    transition: width 0.28s;
}

.hideSidebar .fixed-header {
    width: calc(100% - 54px)
}

.mobile .fixed-header {
    width: 100%;
}
</style>

