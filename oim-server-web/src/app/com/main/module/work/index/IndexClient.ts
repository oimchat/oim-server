import BaseClient from '@/app/com/main/module/BaseClient';
import Md5Util from '@/app/lib/util/Md5Util';
import IndexFunction from '@/app/com/main/function/work/index/IndexPath';

class IndexClient extends BaseClient {

    public login(account: string, password: string, back: (data: any) => void) {
        password = Md5Util.lower32(password);
        this.post(IndexFunction.login.getUrl(), {account, password}, back, true);
    }

    public functionList(back: (data: any) => void) {
        this.post(IndexFunction.functionList.getUrl(), {}, back, true);
    }
}

export default new IndexClient();
