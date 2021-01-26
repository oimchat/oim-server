import ContentInfo from '@/app/com/onlyxiahui/common/message/ContentInfo';

export default class Info {
    /**
     * 消息状态：成功：true、失败：false
     */
    public success: boolean = true;
    /**
     * 程序错误信息集合（主要是程序级别错误，如：字段错误、不能为空等）
     */
    public errors: ContentInfo[] = [];
    /**
     * 业务错误信息集合（主要是业务中错误，如：账号错误、密码错误等）
     */
    public warnings: ContentInfo[] = [];
    /**
     * 成功的消息提醒
     */
    public prompts: ContentInfo[] = [];


    public addError(code: string, text: string): void {
        const data: ContentInfo = new ContentInfo();
        data.code = code;
        data.text = text;
        this.errors.push(data);
        this.success = (this.isEmpty(this.errors) && this.isEmpty(this.warnings));
    }

    public addWarning(code: string, text: string) {
        const data: ContentInfo = new ContentInfo();
        data.code = code;
        data.text = text;
        this.warnings.push(data);
        this.success = (this.isEmpty(this.errors) && this.isEmpty(this.warnings));
    }

    public addPrompt(code: string, text: string) {
        const data: ContentInfo = new ContentInfo();
        data.code = code;
        data.text = text;
        this.prompts.push(data);
    }


    private isEmpty(list: ContentInfo[]): boolean {
        return (!list) || list.length <= 0;
    }
}
