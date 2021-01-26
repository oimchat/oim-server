import UserPath from '@/app/com/main/function/work/user/UserPath';

export default {
    path: '/work/user',
    component: () => import('@/views/Main.vue'),
    meta: {
        title: '用户管理',
    },
    children: [
        {
            path: 'list',
            name: 'user.list',
            component: () => import('@/views/module/work/user/UserList.vue'),
            meta: {
                title: '用户列表',
                url: UserPath.list,
            },
        },
    ],
};
