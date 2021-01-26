import {RouteConfig} from 'vue-router';

import BaseRouteConfig from '@/router/BaseRouteConfig';
import module from '@/router/ModuleImport';


class RouteConfigBox {
    public routers: RouteConfig[] = [];
    public configs: BaseRouteConfig[] = [];

    public constructor() {
        this.routers = [
            {
                path: '/',
                redirect: '/login',
            },
            {
                path: '/login',
                name: 'login',
                component: () => import('@/views/Login.vue'),
            },
        ];
        this.initialize();
    }

    public add(route: RouteConfig): void {
        this.routers.push(route);
        // GroupMemberListPane
    }

    public getRouters(): RouteConfig[] {
        return this.routers;
    }

    public getRouteConfigs(): BaseRouteConfig[] {
        return this.configs;
    }

    public addRouteConfig(config: BaseRouteConfig) {
        this.configs.push(config);
        for (const r of config.getRoutes()) {
            this.add(r as RouteConfig);
        }
    }

    private initialize(): void {
        // this.add(routeConfig);
        for (const m of module) {
            this.addRouteConfig(m);
        }
    }
}

export default new RouteConfigBox();
