import User from '@/app/com/main/module/work/user/bean/User';

class UserNew extends User {
    public password: string = '';
    public tempPassword: string = '';
    public repeatPassword: string = '';
}

export default UserNew;
