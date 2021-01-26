import Info from '@/app/com/onlyxiahui/common/message/Info';
import Message from '@/app/com/onlyxiahui/common/message/Message';

import Head from '@/app/com/onlyxiahui/common/message/Head';


export default class InfoMessage<H extends Head> extends Message<H> {

    public static build(action: string, method: string): InfoMessage<Head> {
        const head: Head = new Head();
        head.action = action;
        head.method = method;
        const me: InfoMessage<Head> = new InfoMessage<Head>();
        me.head = head;
        return me;
    }

    public info!: Info;
}
