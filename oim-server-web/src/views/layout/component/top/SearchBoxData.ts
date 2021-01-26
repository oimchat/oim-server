import SearchData from '@/views/layout/component/top/SearchData';

class SearchBoxData {

    public items: SearchData[] = [];
    // private weightMap: Map<string, number> = new Map<string, number>();
    //
    // public addKeyWeight(key: string, weight: number) {
    //     this.weightMap.set(key, weight);
    // }
    //
    // public removeKeyWeight(key: string) {
    //     this.weightMap.delete(key);
    // }

    private selectedEvents: any[] = [];


    public addSelectedEvent(selected: (data: SearchData) => void) {
        this.selectedEvents.push(selected);
    }

    public selectData(data: SearchData) {
        if (data) {
            for (const c of this.selectedEvents) {
                if (typeof c === 'function') {
                    c(data);
                }
            }
        }
    }
}

export default SearchBoxData;
