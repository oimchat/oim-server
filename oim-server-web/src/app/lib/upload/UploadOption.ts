export class UploadOption {

    public headers: any;
    public withCredentials: boolean = false;
    public file: File | null = null;
    public data: any;
    public filename: string = '';
    public action: string = '';

    constructor(protected onSuccess?: (result: any, file: File | null) => void, protected onError?: (result: any, file: File | null) => void, protected onProgress?: (e: ProgressEvent, file: File | null) => void) {

    }


    public success(result: any): void {
        // no
        if (typeof this.onSuccess === 'function') {
            this.onSuccess(result, this.file);
        }
    }

    public error(error: Error, result: any): void {
        // no
        if (typeof this.onError === 'function') {
            this.onError(result, this.file);
        }
    }

    public progress(e: ProgressEvent): void {
        // no
        if (typeof this.onProgress === 'function') {
            this.onProgress(e, this.file);
        }
    }
}
