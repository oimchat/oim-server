import Path from '@/app/com/common/permission/Path';

class FunctionPath {
    public service: string = 'manage';
    public allList: Path = new Path(this.service, '/v1/system/function/all.list');
    public updateIsDisable: Path = new Path(this.service, '/v1/system/function/update.is.disable');
    public getList: Path = new Path(this.service, '/v1/system/function/get.list');
}

export default new FunctionPath();
