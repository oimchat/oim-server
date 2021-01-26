class LocalLangUtil {
    public localRead = (key: string) => {
        return localStorage.getItem(key) || '';
    }
}

export default new LocalLangUtil();
