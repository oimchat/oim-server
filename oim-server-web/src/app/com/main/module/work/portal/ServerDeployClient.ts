import BaseClient from '@/app/com/main/module/BaseClient';
import ServerDeployPath from '@/app/com/main/function/work/portal/ServerDeployPath';

class ServerDeployClient extends BaseClient {

    public deployInfo(back: (data: any) => void) {
        this.post(ServerDeployPath.deployInfo.getUrl(), {}, back, false);
    }
}

export default new ServerDeployClient();
