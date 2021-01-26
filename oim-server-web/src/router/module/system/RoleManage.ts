export default {
    path: '/work/role',
    component: () => import('@/views/Main.vue'),
    meta: {
        title: '角色管理',
    },
    children: [
        {
            path: '/role/list',
            name: 'role.list',
            component: () => import('@/views/Index.vue'),
            meta: {
                title: '列表',
            },
        },
        {
            path: '/role/function',
            name: 'role.function',
            component: () => import('@/views/Index.vue'),
            meta: {
                title: '角色权限',
            },
        },
    ],
};
