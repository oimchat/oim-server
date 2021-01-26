import Path from '@/app/com/common/permission/Path';

class ServerDeployPath {
    public service: string = 'work-portal';
    public deployInfo: Path = new Path(this.service, '/portal/v1/config/server/deploy.info');
}

export default new ServerDeployPath();
