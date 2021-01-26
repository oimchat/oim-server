export default class StringUtil {

    /**
     * 是否小写
     * @param text
     */
    public static isLowerCase(text: string): boolean {
        const reg = /^[a-z]+$/;
        return reg.test(text);
    }

    /**
     * 是否大写
     * @param text
     */
    public static isUpperCase(text: string): boolean {
        const reg = /^[A-Z]+$/;
        return reg.test(text);
    }

    /**
     * 是否字母
     * @param text
     */
    public static isAlphabet(text: string): boolean {
        const reg = /^[A-Za-z]+$/;
        return reg.test(text);
    }

    /**
     * 是否String
     * @param text
     */
    public static isString(text: any): boolean {
        return typeof text === 'string' || text instanceof String;
    }
}
