import NavTabData from '@/views/layout/component/top/NavTabData';

class NavTabViewData {

    public active: string = '';
    public items: NavTabData[] = [];
    private selectedEvents: any[] = [];


    public addSelectedEvent(selected: (key: string) => void) {
        this.selectedEvents.push(selected);
    }

    public doSelect(key: string) {
        if (key) {
            if (this.active !== key) {
                // this.active = data.key;
                for (const c of this.selectedEvents) {
                    if (typeof c === 'function') {
                        c(key);
                    }
                }
            }
        }
    }
}

export default NavTabViewData;
