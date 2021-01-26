import httpClient from '@/app/lib/http/HttpClient';
import Message from '@/app/com/onlyxiahui/common/message/Message';

export default class BaseClient {

    public post(url: string, data: object, back?: (data: any) => void, prompt?: boolean): void {
        const message: Message<any> = Message.build('', '');
        message.body = data;
        httpClient.post(url, message, back, prompt);
    }
}
