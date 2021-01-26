import FunctionPath from '@/app/com/main/function/work/system/FunctionPath';
import RolePath from '@/app/com/main/function/work/system/RolePath';
import AdminPath from '@/app/com/main/function/work/system/AdminPath';

export default {
    path: '/work/system',
    component: () => import('@/views/Main.vue'),
    meta: {
        title: '系统管理',
    },
    children: [
        {
            path: 'function.list',
            name: 'system.function.list',
            component: () => import('@/views/module/work/system/function/FunctionTree.vue'),
            meta: {
                title: '功能列表',
                url: FunctionPath.allList,
            },
        },
        {
            path: 'role.list',
            name: 'system.role.list',
            component: () => import('@/views/module/work/system/role/RoleList.vue'),
            meta: {
                title: '角色列表',
                url: RolePath.list,
            },
        },
        {
            path: 'admin.list',
            name: 'system.admin.list',
            component: () => import('@/views/module/work/system/admin/AdminList.vue'),
            meta: {
                title: '管理员列表',
                url: AdminPath.list,
            },
        },
    ],
};
