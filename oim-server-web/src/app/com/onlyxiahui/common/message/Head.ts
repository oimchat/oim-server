

export default class Head {

    /**
     * 消息的id，标识消息的唯一性
     */
    public key: string = '';
    /**
     * 请求接口名称
     */
    public name: string = '';
    /**
     * 请求动作类型
     */
    public action: string = '';
    /**
     * 请求方法
     */
    public method: string = '';
    /**
     * 请求接口版本
     */
    public version: string = '';
    /**
     * 响应时间
     */
    public timestamp: number = 0;
}
