import {AxiosRequestConfig, AxiosResponse} from 'axios';

interface HttpHandler {

    handleRequest(request: AxiosRequestConfig): void;

    handleResponse(response: AxiosResponse, back?: (data: any) => void, prompt?: boolean): void;

    handleError(error: any, back?: (data: any) => void, prompt?: boolean): void;

    handlePrompt(message: string): void;
}

export default HttpHandler;
