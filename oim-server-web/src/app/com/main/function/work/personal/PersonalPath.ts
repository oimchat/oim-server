import Path from '@/app/com/common/permission/Path';

class PersonalPath {
    public service: string = 'work-user';
    public get: Path = new Path(this.service, '/v1/personal/info/get');
    public updatePassword: Path = new Path(this.service, '/v1/personal/info/get');
}

export default new PersonalPath();
