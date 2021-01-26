class PermissionBox {

    private map: Map<string, Map<string, string>> = new Map<string, Map<string, string>>();
    private useService: boolean = true;

    public setUseService(useService: boolean): void {
        this.useService = useService;
    }

    public isUseService(): boolean {
        return this.useService;
    }

    public put(service: string, path: string) {
        if (!this.isUseService()) {
            service = 'all';
        }
        if (service && path) {
            let itemMap = this.map.get(service);
            if (!itemMap) {
                itemMap = new Map<string, string>();
                this.map.set(service, itemMap);
            }
            itemMap.set(path, '');
        }
    }

    public has(service: string, path: string): boolean {
        let has = false;
        if (!this.isUseService()) {
            service = 'all';
        }
        if (service && path) {
            const itemMap = this.map.get(service);
            if (itemMap) {
                has = itemMap.has(path);
            }
        }
        return has;
    }

    public clear(): void {
        this.map.clear();
    }
}

export default new PermissionBox();
