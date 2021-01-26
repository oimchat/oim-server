import Path from '@/app/com/common/permission/Path';

class AdminPath {
    public service: string = 'work-user';
    public list: Path = new Path(this.service, '/v1/system/admin/list');
    public addOrUpdate: Path = new Path(this.service, '/v1/system/admin/add.or.update');
    public getById: Path = new Path(this.service, '/v1/system/admin/get.by.id');
    public isExist: Path = new Path(this.service, '/v1/system/admin/is.exist');
    public updatePassword: Path = new Path(this.service, '/v1/system/admin/update.password');
    public updateIsDisable: Path = new Path(this.service, '/v1/system/admin/update.is.disable');
    public setToGeneral: Path = new Path(this.service, '/v1/system/admin/set.to.general');
}

export default new AdminPath();
