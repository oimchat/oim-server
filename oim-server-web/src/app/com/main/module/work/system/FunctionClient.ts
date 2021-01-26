import BaseClient from '@/app/com/main/module/BaseClient';
import FunctionQuery from '@/app/com/main/module/work/system/data/FunctionQuery';
import FunctionPath from '@/app/com/main/function/work/system/FunctionPath';

class FunctionClient extends BaseClient {

    public allList(back: (data: any) => void) {
        this.post(FunctionPath.allList.getUrl(), {}, back, true);
    }

    public updateIsDisable(id: string, isDisable: string, back: (data: any) => void) {
        this.post(FunctionPath.updateIsDisable.getUrl(), {id, isDisable}, back, true);
    }

    public getList(query: FunctionQuery, back: (data: any) => void) {
        this.post(FunctionPath.getList.getUrl(), {query}, back, true);
    }
}

export default new FunctionClient();
