import Vue from 'vue';
import Router, {RouterOptions, RouteConfig, Route, NavigationGuard, RawLocation} from 'vue-router';
import {Dictionary} from 'vue-router/types/router';
import routeConfigBox from '@/router/RouteConfigBox';
import RouterAuth from '@/router/RouterAuth';

class RouterManager {

    private routerOptions: RouterOptions = {
        // mode: 'history',
        // base: process.env.BASE_URL,
        routes: routeConfigBox.getRouters(),
    };
    private router: Router = new Router(this.routerOptions);
    private skips: string[] = [];
    private defaultRouteName: string = '';
    private intercept: boolean = false;
    private routerAuth: RouterAuth = {
        isAuth(): boolean {
            return false;
        },
    };

    public constructor() {
        this.initialize();
    }

    public setRouterAuth(routerAuth: RouterAuth): void {
        this.routerAuth = routerAuth;
    }

    public setSkips(skips: string[]): void {
        this.skips = skips;
    }

    public setDefaultRouteName(defaultRouteName: string): void {
        this.defaultRouteName = defaultRouteName;
    }

    public setIntercept(intercept: boolean): void {
        this.intercept = intercept;
    }

    public getRouter(): Router {
        return this.router;
    }

    private initialize() {
        Vue.use(Router);
        const own = this;
        this.router.beforeEach((to: Route, from: Route, next: any): void => {
            const isLogin = (own.routerAuth) ? own.routerAuth.isAuth() : false;
            const name = to.name;
            const defaultRouteName = own.defaultRouteName;
            let intercept: boolean = own.intercept;
            const skips = own.skips;
            const hasSkips = (skips && skips.length > 0);
            if (hasSkips && intercept) {
                for (const skip of skips) {
                    if (skip === name) {
                        intercept = false;
                        break;
                    }
                }
            }

            if (name) {
                if (isLogin || !intercept) {
                    next();
                } else {
                    const data: Dictionary<string> = {to: to.name + '', from: from.name + ''};
                    const route = {name: defaultRouteName, params: data};
                    next(route);
                }
            } else {
                next({
                    name: defaultRouteName,
                });
            }
        });
    }
}

export default new RouterManager();
