import axios, {AxiosRequestConfig, AxiosResponse} from 'axios';
import HttpHandler from '@/app/lib/http/HttpHandler';

class HttpClient {

    private httpHandler: HttpHandler = ({
        handleRequest(request: AxiosRequestConfig): void {
            // no
        },
        handleResponse(response: AxiosResponse, back?: (data: any) => void, prompt?: boolean): void {
            const value = response.data;
            if (typeof (back) === 'function') {
                back(value);
            }
        },
        handleError(error: any, back?: (data: any) => void, prompt?: boolean): void {
            // no
        },
        handlePrompt(message: string): void {
            // no
        },
    });
    private client = axios.create({
        baseURL: '/',
        timeout: 100000,
    });

    private responseError = ((error: any) => {
        return Promise.reject(error);
        // return (error);
    });

    private responseHandler = ((response: any) => {
        const status = response.status;
        const headers = response.headers;
        return response;
    });

    constructor() {
        this.init();
    }

    public setBaseURL(url: string) {
        this.client = axios.create({
            baseURL: url,
            timeout: 100000,
        });
        this.init();
    }

    public post(url: string, data: object, back?: (data: any) => void, prompt?: boolean): void {
        // 同步方式 var res =  await axios.post('')// 这里的res就是你axios请求回来的结果了
        const own = this;
        this.client.post(url, data).then((response) => {
            own.httpHandler.handleResponse(response, back, prompt);
        }).catch((error: any) => {
            own.httpHandler.handleError(error, back, prompt);
        });
    }

    public setHttpHandler(httpHandler: HttpHandler): void {
        this.httpHandler = httpHandler;
    }

    private init(): void {
        // 错误处理
        const own = this;
        this.client.interceptors.response.use(own.responseHandler, own.responseError);
        this.client.interceptors.request.use((request) => {
            own.httpHandler.handleRequest(request);
            return request;
        }, (error) => {
            return Promise.reject(error);
        });
    }
}

export default new HttpClient();
