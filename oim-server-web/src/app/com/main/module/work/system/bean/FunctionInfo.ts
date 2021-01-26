class FunctionInfo {
    /**
     * 菜单id
     */
    public id: string = '';

    /**
     * 上级菜单id
     */
    public superId: string = '';

    /**
     *
     */
    public service: string = '';

    /**
     * 是否禁用 0：启用 1：停用
     */
    public isDisable: number = 0;

    /**
     * 名称
     */
    public name: string = '';

    /**
     * 功能地址
     */
    public path: string = '';
}

export default FunctionInfo;
