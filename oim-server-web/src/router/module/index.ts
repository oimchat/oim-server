import BaseRouteConfig from '@/router/BaseRouteConfig';

import Index from '@/router/module/index/Index';
import PermissionRoute from '@/router/module/system/PermissionRoute';
import UserManageRoute from '@/router/module/system/UserManageRoute';


class Routes extends BaseRouteConfig {

    public getKey(): string {
        return 'userManager';
    }

    public getRoutes(): [] {
        const array: any = [
            Index,
            PermissionRoute,
            UserManageRoute,
        ];
        return array;
    }

    public getTitle(): string {
        return '系统管理';
    }

}

export default new Routes();
