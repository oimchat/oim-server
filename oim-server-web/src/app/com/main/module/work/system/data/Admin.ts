import User from '@/app/com/main/module/work/user/bean/User';
import UserRoleInfo from '@/app/com/main/module/work/system/data/UserRoleInfo';

class Admin extends User {

    public userRoleInfos: UserRoleInfo[] = [];
}

export default Admin;
