import TagData from '@/views/layout/component/tag/TagData';

class TagViewData {

    public active: string = '';
    public items: TagData[] = [];

    private map: Map<string, TagData> = new Map<string, TagData>();
    private selectedEvents: any[] = [];
    private deletedEvents: any[] = [];


    public addSelectedEvent(selected: (data: TagData) => void) {
        this.selectedEvents.push(selected);
    }

    public addOrSelectTag(key: string, title: string) {
        let data = this.map.get(key);
        this.setSelectTagKey(key);
        if (data) {
            // no
        } else {
            data = new TagData();
            data.key = key;
            data.title = title;

            this.map.set(key, data);
            this.items.push(data);
        }
    }

    public selectTagByKey(key: string) {
        const data = this.map.get(key);
        if (data) {
            this.selectTag(data);
        }
    }

    public removeAllTag() {
        for (const data of this.items) {
            if (data) {
                this.map.delete(data.key);
            }
        }
        this.items = [];
    }

    public removeOtherTagByKey(key: string) {
        const data = this.map.get(key);
        this.removeAllTag();
        if (data) {
            this.map.set(key, data);
            this.items.push(data);
        }
    }

    public removeTagByKey(key: string) {
        const data = this.map.get(key);
        if (data) {
            this.map.delete(key);
            const index = this.items.indexOf(data);
            if (index > -1) {
                this.items.splice(index, 1);
            }
            if (this.active === key) {
                const length = this.items.length;

                if (length > 0) {
                    const lastIndex = length - 1;
                    let showIndex = index - 1;
                    if (showIndex < 0) {
                        showIndex = 0;
                    } else if (showIndex > lastIndex) {
                        showIndex = lastIndex;
                    }
                    const item = this.items[showIndex];
                    this.selectTag(item);
                }
            }
        }
    }

    public selectTag(data: TagData) {
        if (data) {
            if (this.active !== data.key) {
                // this.active = data.key;
                for (const c of this.selectedEvents) {
                    if (typeof c === 'function') {
                        c(data);
                    }
                }
            }
        }
    }

    public setSelectTagKey(key: string) {
        this.active = key;
    }
}

export default TagViewData;
