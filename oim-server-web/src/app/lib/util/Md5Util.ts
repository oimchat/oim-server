import {Md5} from 'md5-typescript';

export default class Md5Util {
    public static lower32(text: string): string {
        return Md5.init(text);
    }
}
