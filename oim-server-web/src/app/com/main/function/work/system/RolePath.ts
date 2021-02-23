import Path from '@/app/com/common/permission/Path';

class RolePath {
    public service: string = 'manage';
    public list: Path = new Path(this.service, '/v1/system/role/list');
    public addOrUpdate: Path = new Path(this.service, '/v1/system/role/add.or.update');
    public getById: Path = new Path(this.service, '/v1/system/role/get.by.id');
    public deleteById: Path = new Path(this.service, '/v1/system/role/delete.by.id');
    public allList: Path = new Path(this.service, '/v1/system/role/all.list');
    public roleFunctionList: Path = new Path(this.service, '/v1/system/role/role.function.list');
}

export default new RolePath();
