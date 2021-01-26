import BaseClient from '@/app/com/main/module/BaseClient';
import Page from '@/app/com/common/data/Page';
import Role from '@/app/com/main/module/work/system/bean/Role';
import RolePath from '@/app/com/main/function/work/system/RolePath';

class RoleClient extends BaseClient {

    public list(query: any, page: Page, back: (data: any) => void) {
        this.post(RolePath.list.getUrl(), {query, page}, back, true);
    }

    public addOrUpdate(role: Role, functionIds: string[], back: (data: any) => void) {
        this.post(RolePath.addOrUpdate.getUrl(), {role, functionIds}, back, true);
    }

    public getById(id: string, back: (data: any) => void) {
        this.post(RolePath.getById.getUrl(), {id}, back, true);
    }

    public deleteById(id: string, back: (data: any) => void) {
        this.post(RolePath.deleteById.getUrl(), {id}, back, true);
    }

    public allList(back: (data: any) => void) {
        this.post(RolePath.allList.getUrl(), {}, back, true);
    }

    public getRoleFunctionList(id: string, back: (data: any) => void) {
        this.post(RolePath.roleFunctionList.getUrl(), {id}, back, true);
    }
}

export default new RoleClient();
