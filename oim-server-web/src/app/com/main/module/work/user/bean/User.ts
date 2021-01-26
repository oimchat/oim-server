export default class User {

    public id: string = '';
    public number: string = ''; // 数字帐号
    public account: string = ''; // 帐号
    public email: string = ''; // 电子信箱
    public mobile: string = ''; // 手机

    // /基本信息

    public head: string = ''; // 照片
    public avatar: string = ''; // 自定义照片，（当用户选择系统头像时为空）
    public nickname: string = ''; // 昵称
    public name: string = ''; // 姓名
    public spell: string = '';
    public simpleSpell: string = '';
    public gender: string = ''; // 性别 1:男 2：女 3：保密 4:男->女过程中 5：女->男过程中

    public telephone: string = ''; // 联系电话
    public homeAddress: string = ''; // 家庭地址
    public locationAddress: string = ''; // 所在地址
    public homeZipCode: string = ''; // 邮政编码
    public locationZipCode: string = ''; // 邮政编码
    public constellationCode: string = ''; // 星座

    public blood: string = ''; // 血型
    public birthDate: string = ''; // 出生日期
    public age: string = ''; // 年龄
    public identityCard: string = ''; // 身份证号码

    public maritalStatus: string = ''; // 婚姻状况: 1:未婚 2:已婚

    public nativePlace: string = ''; // 籍贯
    public nationName: string = ''; // 民族
    public politicsStatus: string = ''; // 政治面貌
    public introduce: string = ''; // 介绍
    public remark: string = ''; // 备注

    public qq: string = ''; // qq

    public education: string = ''; // 学历
    public school: string = ''; // 毕业学校
    public professional: string = ''; // 专业
    public graduationDate: string = ''; // 毕业时间

    public workDate: string = ''; // 参加工作时间
    public signature: string = '';

    public type: string = '';
    public isDisable: number = 0;

}
