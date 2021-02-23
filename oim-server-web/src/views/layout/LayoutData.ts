import SideData from '@/views/layout/component/side/SideData';
import TagViewData from '@/views/layout/component/tag/TagViewData';
import NavMenuItemData from '@/views/layout/component/side/NavMenuItemData';
import NavTabViewData from '@/views/layout/component/top/NavTabViewData';
import NavTabData from '@/views/layout/component/top/NavTabData';
import PersonalData from '@/views/layout/component/PersonalData';
import SearchBoxData from '@/views/layout/component/top/SearchBoxData';
import SearchData from '@/views/layout/component/top/SearchData';

class LayoutData {
    public sideData: SideData = new SideData();
    public tagViewData: TagViewData = new TagViewData();
    public navTab: NavTabViewData = new NavTabViewData();
    public personal: PersonalData = new PersonalData();
    public searchBoxData: SearchBoxData = new SearchBoxData();

    private menuMap: Map<string, NavMenuItemData> = new Map<string, NavMenuItemData>();

    private tabMenusMap: Map<string, NavMenuItemData[]> = new Map<string, NavMenuItemData[]>();
    private menuTabKeyMap: Map<string, string> = new Map<string, string>();

    private selectedEvents: any[] = [];


    private navMenuItemClick: (data: NavMenuItemData, e: any) => void = ((data: NavMenuItemData, e: any) => {
        if (this.sideData.navMenu.activeMenu !== data.key) {
            this.doSelected(data.key);
        }
    });

    constructor() {
        this.initialize();
    }

    public addTab(key: string, title: string, menus: NavMenuItemData[]) {
        const data: NavTabData = new NavTabData();
        data.key = key;
        data.title = title;
        this.navTab.items.push(data);
        this.tabMenusMap.set(key, menus);
        if (menus) {
            for (const m of menus) {
                this.setSearchData(m, '');
                this.setMenuTabKey(key, m);
                this.setNavMenuItemDataClickEvent(m);
            }
        }
    }

    public addNavMenuItemData(data: NavMenuItemData) {
        if (data) {
            this.sideData.navMenu.items.push(data);
            this.setNavMenuItemDataClickEvent(data);
        }
    }

    public addSelectedEvent(selected: (key: string) => void) {
        if (this.selectedEvents.indexOf(selected) < 0) {
            this.selectedEvents.push(selected);
        }
    }

    public selectedMenuKey(key: string) {
        this.sideData.navMenu.activeMenu = key;
        const data = this.menuMap.get(key);
        if (data) {
            this.tagViewData.addOrSelectTag(key, data.text);
        }
        const tabKey = this.menuTabKeyMap.get(key);
        if (tabKey) {
            this.selectedTabKey(tabKey);
        }
    }

    public selectedTabKey(key: string) {
        if (this.navTab.active !== key) {
            this.navTab.active = key;
            const menus = this.tabMenusMap.get(key);
            if (menus) {
                this.sideData.navMenu.items = menus;
            } else {
                this.sideData.navMenu.items = [];
            }
        }
    }

    private initialize(): void {
        const own = this;
        this.tagViewData.addSelectedEvent((data) => {
            this.doSelected(data.key);
        });
        this.navTab.addSelectedEvent((key) => {
            this.selectedTabKey(key);
        });
        this.searchBoxData.addSelectedEvent((data) => {
            if (own.tagViewData.active !== data.key) {
                this.doSelected(data.key);
            }
        });
    }

    private setNavMenuItemDataClickEvent(data: NavMenuItemData) {
        if (data) {
            this.menuMap.set(data.key, data);
            const hasNodes = (data.children && data.children.length > 0);
            if (hasNodes) {
                for (const item of data.children) {
                    this.setNavMenuItemDataClickEvent(item);
                }
            } else {
                data.addClickEvent(this.navMenuItemClick);
            }
        }
    }

    private setSearchData(data: NavMenuItemData, superTitle: string) {
        if (data) {
            const has = this.menuMap.has(data.key);
            if (!has) {
                let title = data.text;
                title = (superTitle) ? (superTitle + ' > ' + title) : title;

                const hasNodes = (data.children && data.children.length > 0);
                if (hasNodes) {
                    for (const item of data.children) {
                        this.setSearchData(item, title);
                    }
                } else {
                    const sd: SearchData = new SearchData();
                    sd.key = data.key;
                    sd.title = title;
                    this.searchBoxData.items.push(sd);
                }
            }
        }
    }

    private setMenuTabKey(tabKey: string, data: NavMenuItemData) {
        if (data) {
            this.menuTabKeyMap.set(data.key, tabKey);
            const hasNodes = (data.children && data.children.length > 0);
            if (hasNodes) {
                for (const item of data.children) {
                    this.setMenuTabKey(tabKey, item);
                }
            }
        }
    }

    private doSelected(key: string) {
        for (const c of this.selectedEvents) {
            if (typeof c === 'function') {
                c(key);
            }
        }
    }
}

export default LayoutData;
