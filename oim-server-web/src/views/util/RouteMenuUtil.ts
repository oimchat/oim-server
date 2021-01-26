import NavMenuItemData from '@/views/layout/component/side/NavMenuItemData';
import Path from '@/app/com/common/permission/Path';


class RouteMenuUtil {

    public static convertMenus(routes: []): NavMenuItemData[] {
        const menus: NavMenuItemData[] = [];
        if (routes && routes.length > 0) {
            for (const r of routes) {
                if (r) {
                    const menu = RouteMenuUtil.convertMenu('', r);
                    if (menu) {
                        menus.push(menu);
                    }
                }
            }
        }
        return menus;
    }

    public static convertMenu(superKey: string, route: any): NavMenuItemData {
        let data: any;

        const meta = route.meta;
        let hasAuth: boolean = true;

        let title = '菜单';
        let icon = '';

        if (meta) {
            title = meta.title;
            icon = meta.icon;
            const url: Path = meta.url;
            if (url) {
                hasAuth = url.has();
            }
        }

        if (hasAuth) {
            const path: string = route.path;
            const item = new NavMenuItemData();
            item.title = title;
            item.icon = icon;
            item.key = (path.startsWith('/')) ? path : superKey + '/' + path;

            const children = route.children;
            if (children && children.length > 0) {
                for (const c of children) {
                    const node = RouteMenuUtil.convertMenu(item.key, c);
                    if (node) {
                        item.nodes.push(node);
                    }
                }
                if (item.nodes.length > 0) {
                    data = item;
                }
            } else {
                data = item;
            }
        }
        return data;
    }
}

export default RouteMenuUtil;
