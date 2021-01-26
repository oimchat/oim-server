export default class Page {
    public size: number = 100;
    public number: number = 1;
    public totalCount: number = 0;
    public totalPage: number = 0;


    public setNumber(pageNumber: number) {
        this.number = pageNumber;
    }

    public getNumber(): number {
        if (this.getTotalPage() <= 0) {
            return this.getTotalPage();
        }
        return this.number;
    }

    public getSize(): number {
        return this.size;
    }

    public setSize(size: number) {
        if (size > 0) {
            this.size = size;
        }
    }

    public getTotalCount(): number {
        return this.totalCount;
    }

    public setTotalCount(totalCount: number) {
        this.totalCount = totalCount;
    }

    public getTotalPage(): number {
        if (this.getTotalCount() > 0) {
            this.totalPage = this.getTotalCount() / this.getSize();
            if (this.getTotalCount() % this.getSize() > 0) {
                this.totalPage = this.totalPage + 1;
            }
        }
        return this.totalPage;
    }
}
