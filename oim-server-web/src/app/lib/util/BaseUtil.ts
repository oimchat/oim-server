import GUID from '../GUID';

class BaseUtil {

    public static isEmpty(value: any): boolean {
        let empty = false;
        if (value instanceof Array) {
            empty = value.length <= 0;
        } else {
            empty = BaseUtil.trim(value) === '' || value === undefined || value === null || value === 'undefined' || value === 'null' || value === '&nbsp;';
        }
        return empty;
    }

    public static isNotEmpty(value: any): boolean {
        return !BaseUtil.isEmpty(value);
    }


    public static getUUID(): string {
        const guid: GUID = new GUID();
        let uuid: string = guid.toString();
        uuid = uuid.replace(/-/g, '');
        return uuid;
    }

    public static getTimestamp(): number {
        const timestamp = new Date().getTime();
        return timestamp;
    }

    /******************************************************************************
     * json和对象相关方法start                                                      *
     ******************************************************************************/

    /**
     * 对象转成json字符串
     * @param {type} value
     * @returns {String}
     */
    public static objectToJson(value: object): string {
        if (BaseUtil.isEmpty(value)) {
            return '';
        }
        const json = JSON.stringify(value);
        return json;
    }

    /**
     * 将json字符串转成json对象
     * @param {type} json
     * @returns {undefined|Function}
     */
    public static jsonToObject<T>(json: string): T {
        let value;
        if (!BaseUtil.isEmpty(json)) {
            try {
                value = (new Function('return ' + json))();
            } catch (e) {
                // do something
            }
        }
        return value;
    }

    /******************************************************************************
     * json和对象相关方法end                                                       *
     ******************************************************************************/


    /******************************************************************************
     * String 相关方法end                                                       *
     ******************************************************************************/

    public static trim(text: string): string {
        const exp = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
        return text === null ? '' : (text + '').replace(exp, '');
    }

    public static moreFilter(text: string, size: number) {
        let value = '';
        if (BaseUtil.isEmpty(text)) {
            return value;
        }
        if (text.length > size) {
            value = text.slice(0, size);
            value += '...';
            return value;
        } else {
            return text;
        }
    }

    public static moreUtf8Filter(text: string, size: number) {
        let value = '';
        if (BaseUtil.isEmpty(text)) {
            return value;
        }
        if (BaseUtil.lengthByUtf8(text) > size) {
            value = BaseUtil.substringByUtf8(text, 0, size);
            value += '...';
            return value;
        } else {
            return text;
        }
    }

    /**
     * 获取字符utf8长度，中文按2字节算
     * @param text
     * @returns {Number}
     */
    public static lengthByUtf8(text: any) {
        let realLength = 0;
        if (text) {
            const length = text.length;
            let charCode = -1;
            for (let i = 0; i < length; i++) {
                charCode = text.charCodeAt(i);
                if (charCode >= 0 && charCode <= 128) {
                    realLength += 1;
                } else {
                    realLength += 2;
                }
            }
        }
        return realLength;
    }

    /**
     * 按utf8格式截取字符，英文数字按1字符算，汉字按2算
     * @param text 原字符
     * @param start 开始位置
     * @param length 截字数
     */
    public static substringByUtf8(text: any, start: number, length: number) {
        // 定位开始位置
        let startUtf8: number = 0;
        let charCode: number = -1;
        let i = 0;
        let end = start + length;
        while (start > 0) {
            charCode = text.charCodeAt(i);
            if (charCode >= 0 && charCode <= 128) {// 健盘字符，每次-1
                start -= 1;
            } else {// 非健盘字符，每次-2
                start -= 2;
            }
            i++;
            startUtf8++;
        }

        // 定位给束位置
        let endUtf8: number = 0;
        while (end > start) {
            charCode = text.charCodeAt(i);
            if (charCode >= 0 && charCode <= 128) {// 健盘字符，每次-1
                end -= 1;
            } else {// 非健盘字符，每次-2
                end -= 2;
            }
            i++;
            endUtf8++;
        }
        return text.substring(startUtf8, endUtf8);
    }


    /******************************************************************************
     * String 相关方法end                                                       *
     ******************************************************************************/


    public static addURLParameter(url: string, param: string): string {
        if (param && url) {
            if (url.indexOf('?') === -1) {
                url += '?';
            } else {
                url += '&';
            }
            url += param;
            url = url.replace('&&', '&');
            url = url.replace('??', '?');
            url = url.replace('?&', '?');
        }
        return url;
    }
}

export default BaseUtil;
