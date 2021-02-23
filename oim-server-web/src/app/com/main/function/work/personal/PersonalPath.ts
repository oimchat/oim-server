import Path from '@/app/com/common/permission/Path';

class PersonalPath {
    public service: string = 'manage';
    public get: Path = new Path(this.service, '/v1/personal/info/get');
    public updatePassword: Path = new Path(this.service, '/v1/personal/info/update.password');
}

export default new PersonalPath();
