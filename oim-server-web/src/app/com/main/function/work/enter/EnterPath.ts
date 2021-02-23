import Path from '@/app/com/common/permission/Path';

class EnterPath {
    public service: string = 'manage';
    public login: Path = new Path(this.service, '/v1/home/enter/login');
    public functionList: Path = new Path(this.service, '/v1/home/enter/function.list');
}

export default new EnterPath();
