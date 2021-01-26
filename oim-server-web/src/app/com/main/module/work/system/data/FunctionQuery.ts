class FunctionQuery {
    /**
     * 菜单id
     */
    public id: string = '';

    /**
     * 上级菜单id
     */
    public superId: string = '';

    /**
     * 是否禁用 0：启用 1：停用
     */
    public isDisable: number = 0;

    /**
     * 名称模糊条件
     */
    public likeName: string = '';

    /**
     * 条件包含的id
     */
    public ids: string[] = [];

    /**
     * 条件排除的id
     */
    public outIds: string[] = [];
}

export default FunctionQuery;
