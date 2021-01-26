import Head from '@/app/com/onlyxiahui/common/message/Head';

export default class Message<H extends Head> {

    public static build(action: string, method: string): Message<Head> {
        const head: Head = new Head();
        head.action = action;
        head.method = method;
        const me: Message<Head> = new Message<Head>();
        me.head = head;
        return me;
    }

    public head!: H;
    public body: any;
}
