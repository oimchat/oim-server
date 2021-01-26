import Path from '@/app/com/common/permission/Path';

class UserPath {
    public service: string = 'work-user';
    public list: Path = new Path(this.service, '/v1/user/info/list');
    public addOrUpdate: Path = new Path(this.service, '/v1/user/info/add.or.update');
    public getById: Path = new Path(this.service, '/v1/user/info/get.by.id');
    public isExist: Path = new Path(this.service, '/v1/user/info/is.exist');
    public updatePassword: Path = new Path(this.service, '/v1/user/info/update.password');
    public updateIsDisable: Path = new Path(this.service, '/v1/user/info/update.is.disable');
    public setToAdmin: Path = new Path(this.service, '/v1/user/info/set.to.admin');
}

export default new UserPath();
