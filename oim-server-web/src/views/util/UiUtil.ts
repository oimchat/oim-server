export class UiUtil {

    public static hasClass(ele: any, cls: any) {
        return !!ele.className.match(new RegExp('(\\s|^)' + cls + '(\\s|$)'));
    }

    public static addClass(ele: any, cls: any) {
        if (!UiUtil.hasClass(ele, cls)) {
            ele.className += ' ' + cls;
        }
    }


    public static removeClass(ele: any, cls: any) {
        if (UiUtil.hasClass(ele, cls)) {
            const reg = new RegExp('(\\s|^)' + cls + '(\\s|$)');
            ele.className = ele.className.replace(reg, ' ');
        }
    }
}
