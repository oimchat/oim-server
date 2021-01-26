import BaseClient from '@/app/com/main/module/BaseClient';
import Page from '@/app/com/common/data/Page';
import User from '@/app/com/main/module/work/user/bean/User';
import Md5Util from '@/app/lib/util/Md5Util';
import UserFunction from '@/app/com/main/function/work/user/UserPath';

class UserClient extends BaseClient {

    public list(query: any, page: Page, back: (data: any) => void) {
        this.post(UserFunction.list.getUrl(), {query, page}, back, true);
    }

    public addOrUpdate(user: User, back: (data: any) => void) {
        this.post(UserFunction.addOrUpdate.getUrl(), user, back, true);
    }

    public getById(id: string, back: (data: any) => void) {
        this.post(UserFunction.getById.getUrl(), {id}, back, true);
    }

    public isAccountExist(id: string,
                          account: string,
                          back: (data: any) => void) {
        const data = {id, account};
        this.post(UserFunction.isExist.getUrl(), data, back, true);
    }

    public isEmailExist(id: string,
                        email: string,
                        back: (data: any) => void) {
        const data = {id, email};
        this.post(UserFunction.isExist.getUrl(), data, back, true);
    }

    public isMobileExist(id: string,
                         mobile: string,
                         back: (data: any) => void) {
        const data = {id, mobile};
        this.post(UserFunction.isExist.getUrl(), data, back, true);
    }

    public isExist(id: string,
                   account: string,
                   email: string,
                   mobile: string,
                   back: (data: any) => void) {
        const data = {id, account, email, mobile};
        this.post(UserFunction.isExist.getUrl(), data, back, true);
    }

    public updatePassword(id: string, password: string, back: (data: any) => void) {
        password = Md5Util.lower32(password);
        this.post(UserFunction.updatePassword.getUrl(), {id, password}, back, true);
    }

    public updateIsDisable(id: string, isDisable: number, back: (data: any) => void) {
        this.post(UserFunction.updateIsDisable.getUrl(), {id, isDisable}, back, true);
    }

    public setToAdmin(id: string, back: (data: any) => void) {
        this.post(UserFunction.setToAdmin.getUrl(), {id}, back, true);
    }
}

export default new UserClient();
