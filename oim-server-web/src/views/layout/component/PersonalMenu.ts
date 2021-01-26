class PersonalMenu {

    public title: string = '';
    public click: (e: any) => void = ((e) => {
        this.doClick(e);
    });
    private clicks: any[] = [];

    public addClickEvent(click: (data: PersonalMenu, e: any) => void) {
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

export default PersonalMenu;
