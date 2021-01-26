class Role {

    public id: string = '';
    /**
     * 名称
     */
    public name: string = '';


    public introduce: string = '';

    /**
     * 是否禁用 0：启用 1：停用
     */

    public isDisable: number = 0;


    public grade: number = 0;
}

export default Role;
