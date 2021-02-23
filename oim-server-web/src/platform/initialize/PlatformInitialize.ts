import httpClient from '@/app/lib/http/HttpClient';
import {AxiosRequestConfig, AxiosResponse} from 'axios';
import BaseUtil from '@/app/lib/util/BaseUtil';
import Prompt from '@/platform/common/Prompt';
import auth from '@/app/com/common/auth/Auth';
import routerManager from '@/router/RouterManager';
import config from '@/platform/config/Config';
import Head from '@/app/com/onlyxiahui/common/message/Head';
import InfoMessage from '@/app/com/onlyxiahui/common/message/InfoMessage';
import Info from '@/app/com/onlyxiahui/common/message/Info';
import ServerDeployClient from '@/app/com/main/module/work/portal/ServerDeployClient';
import PermissionBox from '@/app/com/common/permission/PermissionBox';

class PlatformInitialize {

    public constructor() {
        this.loadConfig();
    }

    public initialize(): void {
        this.initializeView();
        this.initializeApp();
        this.initializeConfig();
    }

    public initializeView() {
        // no
    }

    public initializeApp() {
        // no
        httpClient.setHttpHandler({
            handleRequest(request: AxiosRequestConfig): void {
                // 让每个请求携带token-- ['X-Token']为自定义key 请根据实际情况自行修改
                request.headers.token = auth.getToken();
                request.headers.source = auth.getUserId();
            },
            handleResponse(response: AxiosResponse, back?: (data: any) => void, prompt?: boolean): void {
                const value = response.data;
                if (typeof (back) === 'function') {
                    back(value);
                }
                const hasBack = (typeof back === 'function');
                if (prompt || !hasBack) {
                    // 需要提示
                    if (!BaseUtil.isEmpty(value)) {
                        const info = value.info;
                        if (info && !info.success) {
                            Prompt.message(info, '', '失败！');
                        }
                    }
                }
            },
            handleError(error: any, back?: (data: any) => void, prompt?: boolean): void {
                let message = '网络异常';
                if (error.response) {
                    message = error.message;
                    const response = error.response;
                    const status = response.status;

                    switch (status) {
                        case 400:
                            message = '400！';
                            break;
                        case 401:
                            message = '401！';
                            break;
                        case 403:
                            message = '403！';
                            break;
                        case 404:
                            message = '404！';
                            break;
                        case 500:
                            message = '服务异常！';
                            break;
                        default:
                    }
                } else {
                    const m = error.message;
                    if (m === 'Network Error') {
                        message = '网络错误或者连接超时请稍后重试！';
                    } else {
                        message = m;
                    }
                }
                const hasBack = (typeof back === 'function');
                if (typeof (back) === 'function') {
                    const serverHead: Head = new Head();
                    const m: InfoMessage<Head> = new InfoMessage<Head>();
                    m.head = serverHead;
                    m.info = new Info();
                    m.info.addError('1.000', message);
                    back(m);
                }
                if (prompt || !hasBack) {
                    Prompt.error(message);
                }
            },
            handlePrompt(message: string): void {
                Prompt.error(message);
            },
        });
    }

    private initializeConfig() {
        // no
    }

    private loadConfig() {
        // no
        const url = config.getBaseUrl();
        httpClient.setBaseURL(url);

        routerManager.setRouterAuth({
            isAuth(): boolean {
                return auth.isLogin();
            },
        });
        routerManager.setDefaultRouteName('login');
        routerManager.setSkips(['login']);
        routerManager.setIntercept(true);

        // ServerDeployClient.deployInfo((result) => {
        //     const info = result.info;
        //     const body = result.body;
        //     if (info && info.success && body) {
        //         const type = body.deployType;
        //         if ('1' === type || '2' === type) {
        //             PermissionBox.setUseService(false);
        //         } else {
        //             PermissionBox.setUseService(true);
        //         }
        //     }
        // });
    }
}


export default new PlatformInitialize();
