class Config {

    private dev: string = 'http://127.0.0.1:10000/manage';
    private test: string = 'http://127.0.0.1:10000/manage';
    private pro: string = '/manage';

    public getBaseUrl(): string {
        let url = this.pro;
        if (process.env.NODE_ENV === 'development') {
            url = this.dev;
        } else if (process.env.NODE_ENV === 'test') {
            url = this.test;
        } else if (process.env.NODE_ENV === 'production') {
            url = this.pro;
        }
        return url;
    }
}

export default new Config();
