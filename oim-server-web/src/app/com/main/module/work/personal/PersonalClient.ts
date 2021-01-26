import BaseClient from '@/app/com/main/module/BaseClient';
import PersonalFunction from '@/app/com/main/function/work/personal/PersonalPath';
import Md5Util from '@/app/lib/util/Md5Util';

class PersonalClient extends BaseClient {

    public get(back: (data: any) => void) {
        this.post(PersonalFunction.get.getUrl(), {}, back, true);
    }

    public updatePassword(newPassword: string, oldPassword: string, back: (data: any) => void) {
        newPassword = Md5Util.lower32(newPassword);
        oldPassword = Md5Util.lower32(oldPassword);
        this.post(PersonalFunction.updatePassword.getUrl(), {newPassword, oldPassword}, back, true);
    }
}

export default new PersonalClient();
