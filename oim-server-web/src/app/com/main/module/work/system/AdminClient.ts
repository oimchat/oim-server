import BaseClient from '@/app/com/main/module/BaseClient';
import Page from '@/app/com/common/data/Page';
import User from '@/app/com/main/module/work/user/bean/User';
import AdminPath from '@/app/com/main/function/work/system/AdminPath';
import Md5Util from '@/app/lib/util/Md5Util';

class AdminClient extends BaseClient {

    public list(query: any, page: Page, back: (data: any) => void) {
        this.post(AdminPath.list.getUrl(), {query, page}, back, true);
    }

    public addOrUpdate(user: User, roleIds: string[], back: (data: any) => void) {
        this.post(AdminPath.addOrUpdate.getUrl(), {user, roleIds}, back, true);
    }

    public getById(id: string, back: (data: any) => void) {
        this.post(AdminPath.getById.getUrl(), {id}, back, true);
    }

    public isAccountExist(id: string,
                          account: string,
                          back: (data: any) => void) {
        const data = {id, account};
        this.post(AdminPath.isExist.getUrl(), data, back, true);
    }

    public isEmailExist(id: string,
                        email: string,
                        back: (data: any) => void) {
        const data = {id, email};
        this.post(AdminPath.isExist.getUrl(), data, back, true);
    }

    public isMobileExist(id: string,
                         mobile: string,
                         back: (data: any) => void) {
        const data = {id, mobile};
        this.post(AdminPath.isExist.getUrl(), data, back, true);
    }

    public isExist(id: string,
                   account: string,
                   email: string,
                   mobile: string,
                   back: (data: any) => void) {
        const data = {id, account, email, mobile};
        this.post(AdminPath.isExist.getUrl(), data, back, true);
    }

    public updatePassword(id: string, password: string, back: (data: any) => void) {
        password = Md5Util.lower32(password);
        this.post(AdminPath.updatePassword.getUrl(), {id, password}, back, true);
    }

    public updateIsDisable(id: string, isDisable: number, back: (data: any) => void) {
        this.post(AdminPath.updateIsDisable.getUrl(), {id, isDisable}, back, true);
    }

    public setToGeneral(id: string, back: (data: any) => void) {
        this.post(AdminPath.setToGeneral.getUrl(), {id}, back, true);
    }
}

export default new AdminClient();
