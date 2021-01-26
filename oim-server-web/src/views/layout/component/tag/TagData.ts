class TagData {

    public title: string = '';
    public key: string = '';
    private clicks: any[] = [];
    public click: (e: any) => void = (e) => {
        this.doClick(e);
    }

    public addClickEvent(click: (data: TagData, e: any) => void) {
        this.clicks.push(click);
    }

    private doClick(e: any) {
        for (const c of this.clicks) {
            if (typeof c === 'function') {
                c(this, e);
            }
        }
    }
}

export default TagData;
