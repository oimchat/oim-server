import BaseCache from '@/app/com/onlyxiahui/common/cache/BaseCache';
import BaseUtil from '@/app/lib/util/BaseUtil';

class Auth {
    public account: string = '';
    public password: string = '';

    private baseCache: BaseCache = new BaseCache();
    private map: Map<string, string> = new Map<string, string>();
    private login: boolean = false;
    private tokenKey = 'auth.token';
    private userIdKey = 'auth.userId';

    public isLogin(): boolean {
        const token = this.getToken();
        return BaseUtil.isNotEmpty(token);
    }

    public setLogin(isLogin: boolean): void {
        this.login = isLogin;
    }

    public setToken(token: string): void {
        this.map.set(this.tokenKey, token);
        this.baseCache.put(this.tokenKey, token);
    }

    public setUserId(userId: string): void {
        this.map.set(this.userIdKey, userId);
        this.baseCache.put(this.userIdKey, userId);
    }

    public getToken(): string {
        // let token: any = this.map.get(this.tokenKey);
        let token: any = this.baseCache.get(this.tokenKey);
        if (!token) {
            token = '';
        }
        return token;
    }

    public getUserId(): string {
        // let userId: any = this.map.get(this.userIdKey);
        let userId: any = this.baseCache.get(this.userIdKey);
        if (!userId) {
            userId = '';
        }
        return userId;
    }

    public removeToken(): void {
        this.map.delete(this.tokenKey);
        this.baseCache.remove(this.tokenKey);
    }

    public removeUserId(): void {
        this.map.delete(this.userIdKey);
        this.baseCache.remove(this.userIdKey);
    }

    public logout(): void {
        this.removeToken();
        this.removeUserId();
    }
}

export default new Auth();
