import PermissionBox from '@/app/com/common/permission/PermissionBox';

class Path {

    constructor(
        public service: string,
        public path: string) {
    }

    public has(): boolean {
        return PermissionBox.has(this.service, this.path);
    }

    public getPath(): string {
        return this.path;
    }

    public getService(): string {
        return this.service;
    }

    public getUrl(): string {
        return this.service + this.path;
    }
}

export default Path;
