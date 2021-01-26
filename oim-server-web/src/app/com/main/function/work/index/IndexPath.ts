import Path from '@/app/com/common/permission/Path';

class IndexPath {
    public service: string = 'work-user';
    public login: Path = new Path(this.service, '/v1/index/system/login');
    public functionList: Path = new Path(this.service, '/v1/system/index/function.list');
}

export default new IndexPath();
