import BaseClient from '@/app/com/main/module/BaseClient';
import Md5Util from '@/app/lib/util/Md5Util';
import EnterPath from '@/app/com/main/function/work/enter/EnterPath';

class EnterClient extends BaseClient {

    public login(account: string, password: string, back: (data: any) => void) {
        password = Md5Util.lower32(password);
        this.post(EnterPath.login.getUrl(), {account, password}, back, true);
    }

    public functionList(back: (data: any) => void) {
        this.post(EnterPath.functionList.getUrl(), {}, back, true);
    }
}

export default new EnterClient();
