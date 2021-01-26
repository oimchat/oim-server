class GUID {

    private static getNewGUIDString() {
        // your favourite guid generation function could go here
        // ex: http://stackoverflow.com/a/8809472/188246

        // return "xxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx".replace(/[xy]/g, function(e) {
        //     var t = 16 * Math.random() | 0
        //         , a = "x" === e ? t : 3 & t | 8;
        //     return a.toString(16)
        // }).toUpperCase();

        let d = new Date().getTime();
        if (window.performance && typeof window.performance.now === 'function') {
            d += performance.now(); // use high-precision timer if available
        }
        return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, (c) => {
            const r = (d + Math.random() * 16) % 16 | 0;
            d = Math.floor(d / 16);
            return (c === 'x' ? r : (r & 0x3 | 0x8)).toString(16);
        });
    }

    private readonly id: string;

    constructor(id?: string) {
        this.id = id || GUID.getNewGUIDString();
    }

    public toString() {
        return this.id;
    }
}

export default GUID;
