class FunctionSelectTreeData {

    public selectIds: string[] = [];
    public getSelectIds: () => string[] = (() => {
        return [];
    });

    public setSelectIds: (selectIds: string[]) => void = ((selectIds: string[]) => {
        // no
    });
}

export default FunctionSelectTreeData;
