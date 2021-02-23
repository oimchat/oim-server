export default class NavMenuItemData {


    public text: string = '';
    public icon: string = '';
    public hidden: boolean = false;
    // public path: string = '';
    public key: string = '';
    public children: NavMenuItemData[] = [];
    private clicks: any[] = [];
    public click: (e: any) => void = (e) => {
        this.doClick(e);
    }

    public addClickEvent(click: (data: NavMenuItemData, e: any) => void) {
        if (this.clicks.indexOf(click) < 0) {
            this.clicks.push(click);
        }
    }

    private doClick(e: any) {
        for (const c of this.clicks) {
            if (typeof c === 'function') {
                c(this, e);
            }
        }
    }
}
