import {UploadOption} from '@/app/lib/upload/UploadOption';

export default class UploadTool {

    public upload(option: UploadOption) {

        const own = this;
        if (typeof XMLHttpRequest === 'undefined') {
            return;
        }

        const xhr: XMLHttpRequest = new XMLHttpRequest();
        const action = option.action;

        if (xhr.upload) {
            xhr.upload.onprogress = (e: ProgressEvent) => {
                let percent = 0;
                if (e.total > 0) {
                    percent = e.loaded / e.total * 100;
                }
                option.progress(e);
            };
        }

        const formData = new FormData();

        if (option.data) {
            Object.keys(option.data).map((key) => {
                formData.append(key, option.data[key]);
            });
        }
        if (option.file) {
            formData.append(option.filename, option.file);
        }
        xhr.onerror = (e: ProgressEvent) => {
            option.error(own.getError(action, option, xhr), own.getBody(xhr));
        };

        xhr.onload = function onload() {
            if (xhr.status < 200 || xhr.status >= 300) {
                return option.error(own.getError(action, option, xhr), own.getBody(xhr));
            }

            option.success(own.getBody(xhr));
        };

        xhr.open('post', action, true);

        if (option.withCredentials && 'withCredentials' in xhr) {
            xhr.withCredentials = true;
        }

        const headers = option.headers || {};

        // if (headers['X-Requested-With'] !== null) {
        //   xhr.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
        // }
        for (const item in headers) {
            if (headers.hasOwnProperty(item) && headers[item] !== null) {
                xhr.setRequestHeader(item, headers[item]);
            }
        }
        xhr.send(formData);
    }
    private getError(action: string, option: any, xhr: XMLHttpRequest) {
        const msg = `fail to post ${action} ${xhr.status}'`;
        const err: any = new Error(msg);
        err.status = xhr.status;
        err.method = 'post';
        err.url = action;
        return err;
    }

    private getBody(xhr: XMLHttpRequest): any {
        const text = xhr.responseText || xhr.response;
        if (!text) {
            return text;
        }

        try {
            return JSON.parse(text);
        } catch (e) {
            return text;
        }
    }
}
