import BaseUtil from '@/app/lib/util/BaseUtil';

export default class BaseCache {

    private hasCache: boolean = (!BaseUtil.isEmpty(window) && !BaseUtil.isEmpty(window.localStorage));
    private map: Map<any, any> = new Map<any, any>();

    public constructor(protected baseKey?: string) {
        if (!this.baseKey) {
            this.baseKey = 'cache';
        }
    }

    public get(key: string) {
        let object;
        const saveKey = this.getKey(key);
        if (this.hasCache) {
            const storageString: any = localStorage.getItem(saveKey);
            if (!BaseUtil.isEmpty(storageString)) {
                object = JSON.parse(storageString); // 转成json
            }
        } else {
            object = this.map.get(saveKey);
        }
        return object;
    }

    public put(key: string, value: any) {
        const saveKey = this.getKey(key);
        if (!BaseUtil.isEmpty(value)) {
            if (this.hasCache) {
                if (typeof (value) === 'string') {
                    // no
                }
                if (typeof (value) === 'number') {
                    // no
                }
                if (typeof (value) === 'boolean') {
                    // no
                }
                const text = JSON.stringify(value);
                localStorage.setItem(saveKey, text);
            } else {
                this.map.set(saveKey, value);
            }
        }
    }

    public remove(key: string) {
        const saveKey = this.getKey(key);
        localStorage.removeItem(saveKey);
        this.map.delete(saveKey);
    }

    private getKey(key: string): string {
        const k = this.baseKey + ':' + key;
        return k;
    }
}
