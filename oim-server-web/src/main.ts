import Vue from 'vue';
import App from './App.vue';
import './registerServiceWorker';
import routerManager from './router/RouterManager';
import store from './store';
import './quasar';

Vue.config.productionTip = false;
import Element from 'element-ui';
import './styles/element-variables.scss';
import '@/styles/index.scss';

Vue.use(Element);
const router = routerManager.getRouter();
new Vue({
    router,
    store,
    render: (h) => h(App),
}).$mount('#app');

import platformInitialize from '@/platform/initialize/PlatformInitialize';

platformInitialize.initialize();
