export default {
    path: '/main',
    component: () => import('@/views/Main.vue'),
    meta: {
        title: '主页',
    },
    redirect: '/main/index',
    children: [
        {
            path: 'index',
            name: 'main.index',
            component: () => import('@/views/home/Home.vue'),
            meta: {
                title: '首页',
            },
        },
    ],
};
