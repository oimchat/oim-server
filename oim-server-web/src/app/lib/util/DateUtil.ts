export default class DateUtil {
    public static format(format: string, date: Date) {
        /*
         * format="yyyy-MM-dd hh:mm:ss";
         */
        const map: Map<string, number> = new Map<string, number>();
        map.set('M+', date.getMonth() + 1);
        map.set('d+', date.getDate());
        map.set('h+', date.getHours());
        map.set('m+', date.getMinutes());
        map.set('s+', date.getSeconds());
        map.set('q+', Math.floor((date.getMonth() + 3) / 3));
        map.set('S', date.getMilliseconds());
        // const o = {
        //     "M+": date.getMonth() + 1,
        //     "d+": date.getDate(),
        //     "h+": date.getHours(),
        //     "m+": date.getMinutes(),
        //     "s+": date.getSeconds(),
        //     "q+": Math.floor((date.getMonth() + 3) / 3),
        //     "S": date.getMilliseconds()
        // };
        if (/(y+)/.test(format)) {
            format = format.replace(RegExp.$1, (date.getFullYear() + '').substring(4 - RegExp.$1.length));
        }
        const keys = map.keys();
        for (const key of keys) {
            if (new RegExp('(' + key + ')').test(format)) {
                let no: number = 0;
                const value = map.get(key);
                if (value) {
                    no = value;
                }
                const v0 = '' + no;
                const v1 = '00' + no;
                const v2 = '' + no;
                format = format.replace(RegExp.$1, RegExp.$1.length === 1 ? v0 : v1.substring(v2.length));
            }
        }

        // for (const k in o) {
        //     if (new RegExp('(' + k + ')').test(format)) {
        //         format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ('00' + o[k]).substring(('' + o[k]).length));
        //     }
        // }
        return format;
    }
}
