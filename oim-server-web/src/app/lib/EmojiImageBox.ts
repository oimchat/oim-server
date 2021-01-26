class EmojiImageBox {
    private keyMap: Map<string, {
        code: string,
        key: string,
        picture: string,
    }> = new Map<string, {
        code: string,
        key: string,
        picture: string,
    }>();


    private codeMap: Map<string, {
        code: string,
        key: string,
        picture: string,
    }> = new Map<string, {
        code: string,
        key: string,
        picture: string,
    }>();

    private mappingMap: Map<string, string> = new Map<string, string>();

    constructor() {
        this.init();
    }

    public put(data: any) {
        if (data && data.key && data.picture) {
            this.keyMap.set(data.key, data);
            this.codeMap.set(data.code, data);
        }
    }


    public getList(): Array<{
        code: string,
        key: string,
        picture: string,
    }> {
        const map = this.codeMap;
        const list: Array<{ code: string, key: string, picture: string }> = [];
        if (map) {
            const allList = map.values();
            for (const ud of allList) {
                list.push(ud);
            }
        }
        return list;
    }


    public getByCode(code: string): { code: string, key: string, picture: string } {
        const data: any = this.codeMap.get(code);
        return data;
    }

    public getByKey(code: string): { code: string, key: string, picture: string } {
        const data: any = this.codeMap.get(code);
        return data;
    }

    public getPictureByKey(key: string): string {
        let picture = '';
        const data: any = this.keyMap.get(key);
        if (data) {
            picture = data.picture;
        }
        return picture;
    }

    private init() {

        this.put({code: '0xde00', key: '😀', picture: '0x1f600.png'});
        this.put({code: '0xde01', key: '😁', picture: '0x1f601.png'});
        this.put({code: '0xde02', key: '😂', picture: '0x1f602.png'});
        this.put({code: '0xde03', key: '😃', picture: '0x1f603.png'});
        this.put({code: '0xde04', key: '😄', picture: '0x1f604.png'});
        this.put({code: '0xde05', key: '😅', picture: '0x1f605.png'});
        this.put({code: '0xde06', key: '😆', picture: '0x1f606.png'});
        this.put({code: '0xde07', key: '😇', picture: '0x1f607.png'});
        this.put({code: '0xde08', key: '😈', picture: '0x1f608.png'});
        this.put({code: '0xde09', key: '😉', picture: '0x1f609.png'});
        this.put({code: '0xde0a', key: '😊', picture: '0x1f60a.png'});
        this.put({code: '0xde0b', key: '😋', picture: '0x1f60b.png'});
        this.put({code: '0xde0c', key: '😌', picture: '0x1f60c.png'});
        this.put({code: '0xde0d', key: '😍', picture: '0x1f60d.png'});
        this.put({code: '0xde0e', key: '😎', picture: '0x1f60e.png'});
        this.put({code: '0xde0f', key: '😏', picture: '0x1f60f.png'});
        this.put({code: '0xde10', key: '😐', picture: '0x1f610.png'});
        this.put({code: '0xde11', key: '😑', picture: '0x1f611.png'});
        this.put({code: '0xde12', key: '😒', picture: '0x1f612.png'});
        this.put({code: '0xde13', key: '😓', picture: '0x1f613.png'});
        this.put({code: '0xde14', key: '😔', picture: '0x1f614.png'});
        this.put({code: '0xde15', key: '😕', picture: '0x1f615.png'});
        this.put({code: '0xde16', key: '😖', picture: '0x1f616.png'});
        this.put({code: '0xde17', key: '😗', picture: '0x1f617.png'});
        this.put({code: '0xde18', key: '😘', picture: '0x1f618.png'});
        this.put({code: '0xde19', key: '😙', picture: '0x1f619.png'});
        this.put({code: '0xde1a', key: '😚', picture: '0x1f61a.png'});
        this.put({code: '0xde1b', key: '😛', picture: '0x1f61b.png'});
        this.put({code: '0xde1c', key: '😜', picture: '0x1f61c.png'});
        this.put({code: '0xde1d', key: '😝', picture: '0x1f61d.png'});
        this.put({code: '0xde1e', key: '😞', picture: '0x1f61e.png'});
        this.put({code: '0xde1f', key: '😟', picture: '0x1f61f.png'});
        this.put({code: '0xde20', key: '😠', picture: '0x1f620.png'});
        this.put({code: '0xde21', key: '😡', picture: '0x1f621.png'});
        this.put({code: '0xde22', key: '😢', picture: '0x1f622.png'});
        this.put({code: '0xde23', key: '😣', picture: '0x1f623.png'});
        this.put({code: '0xde24', key: '😤', picture: '0x1f624.png'});
        this.put({code: '0xde25', key: '😥', picture: '0x1f625.png'});
        this.put({code: '0xde26', key: '😦', picture: '0x1f626.png'});
        this.put({code: '0xde27', key: '😧', picture: '0x1f627.png'});
        this.put({code: '0xde28', key: '😨', picture: '0x1f628.png'});
        this.put({code: '0xde29', key: '😩', picture: '0x1f629.png'});
        this.put({code: '0xde2a', key: '😪', picture: '0x1f62a.png'});
        this.put({code: '0xde2b', key: '😫', picture: '0x1f62b.png'});
        this.put({code: '0xde2c', key: '😬', picture: '0x1f62c.png'});
        this.put({code: '0xde2d', key: '😭', picture: '0x1f62d.png'});
        this.put({code: '0xde2e', key: '😮', picture: '0x1f62e.png'});
        this.put({code: '0xde2f', key: '😯', picture: '0x1f62f.png'});
        this.put({code: '0xde30', key: '😰', picture: '0x1f630.png'});
        this.put({code: '0xde31', key: '😱', picture: '0x1f631.png'});
        this.put({code: '0xde32', key: '😲', picture: '0x1f632.png'});
        this.put({code: '0xde33', key: '😳', picture: '0x1f633.png'});
        this.put({code: '0xde34', key: '😴', picture: '0x1f634.png'});
        this.put({code: '0xde35', key: '😵', picture: '0x1f635.png'});
        this.put({code: '0xde36', key: '😶', picture: '0x1f636.png'});
        this.put({code: '0xde37', key: '😷', picture: '0x1f637.png'});
        this.put({code: '0xde38', key: '😸', picture: '0x1f638.png'});
        this.put({code: '0xde39', key: '😹', picture: '0x1f639.png'});
        this.put({code: '0xde3a', key: '😺', picture: '0x1f63a.png'});
        this.put({code: '0xde3b', key: '😻', picture: '0x1f63b.png'});
        this.put({code: '0xde3c', key: '😼', picture: '0x1f63c.png'});
        this.put({code: '0xde3d', key: '😽', picture: '0x1f63d.png'});
        this.put({code: '0xde3e', key: '😾', picture: '0x1f63e.png'});
        this.put({code: '0xde3f', key: '😿', picture: '0x1f63f.png'});
        this.put({code: '0xde40', key: '🙀', picture: '0x1f640.png'});
        this.put({code: '0xde41', key: '🙁', picture: '0x1f641.png'});
        this.put({code: '0xde42', key: '🙂', picture: '0x1f642.png'});
        this.put({code: '0xde43', key: '🙃', picture: '0x1f643.png'});
        this.put({code: '0xde44', key: '🙄', picture: '0x1f644.png'});
        this.put({code: '0xde45', key: '🙅', picture: '0x1f645.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙅‍♀', picture: '0x1f6450x2640.png'});
        this.put({code: '0xfe0f', key: '🙅‍♀️', picture: '0x1f6450x2640.png'});

        this.put({code: '0x2642', key: '🙅‍♂', picture: '0x1f6450x2642.png'});
        this.put({code: '0xfe0f', key: '🙅‍♂️', picture: '0x1f6450x2642.png'});


        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🙅🏻', picture: '0x1f6450x1f3fb.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙅🏻‍♀', picture: '0x1f6450x1f3fb0x2640.png'});
        this.put({code: '0xfe0f', key: '🙅🏻‍♀️', picture: '0x1f6450x1f3fb0x2640.png'});

        this.put({code: '0x2642', key: '🙅🏻‍♂', picture: '0x1f6450x1f3fb0x2642.png'});
        this.put({code: '0xfe0f', key: '🙅🏻‍♂️', picture: '0x1f6450x1f3fb0x2642.png'});


        this.put({code: '0xdffc', key: '🙅🏼', picture: '0x1f6450x1f3fc.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙅🏼‍♀', picture: '0x1f6450x1f3fc0x2640.png'});
        this.put({code: '0xfe0f', key: '🙅🏼‍♀️', picture: '0x1f6450x1f3fc0x2640.png'});

        this.put({code: '0x2642', key: '🙅🏼‍♂', picture: '0x1f6450x1f3fc0x2642.png'});
        this.put({code: '0xfe0f', key: '🙅🏼‍♂️', picture: '0x1f6450x1f3fc0x2642.png'});


        this.put({code: '0xdffd', key: '🙅🏽', picture: '0x1f6450x1f3fd.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙅🏽‍♀', picture: '0x1f6450x1f3fd0x2640.png'});
        this.put({code: '0xfe0f', key: '🙅🏽‍♀️', picture: '0x1f6450x1f3fd0x2640.png'});

        this.put({code: '0x2642', key: '🙅🏽‍♂', picture: '0x1f6450x1f3fd0x2642.png'});
        this.put({code: '0xfe0f', key: '🙅🏽‍♂️', picture: '0x1f6450x1f3fd0x2642.png'});


        this.put({code: '0xdffe', key: '🙅🏾', picture: '0x1f6450x1f3fe.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙅🏾‍♀', picture: '0x1f6450x1f3fe0x2640.png'});
        this.put({code: '0xfe0f', key: '🙅🏾‍♀️', picture: '0x1f6450x1f3fe0x2640.png'});

        this.put({code: '0x2642', key: '🙅🏾‍♂', picture: '0x1f6450x1f3fe0x2642.png'});
        this.put({code: '0xfe0f', key: '🙅🏾‍♂️', picture: '0x1f6450x1f3fe0x2642.png'});


        this.put({code: '0xdfff', key: '🙅🏿', picture: '0x1f6450x1f3ff.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙅🏿‍♀', picture: '0x1f6450x1f3ff0x2640.png'});
        this.put({code: '0xfe0f', key: '🙅🏿‍♀️', picture: '0x1f6450x1f3ff0x2640.png'});

        this.put({code: '0x2642', key: '🙅🏿‍♂', picture: '0x1f6450x1f3ff0x2642.png'});
        this.put({code: '0xfe0f', key: '🙅🏿‍♂️', picture: '0x1f6450x1f3ff0x2642.png'});


        this.put({code: '0xde46', key: '🙆', picture: '0x1f646.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙆‍♀', picture: '0x1f6460x2640.png'});
        this.put({code: '0xfe0f', key: '🙆‍♀️', picture: '0x1f6460x2640.png'});

        this.put({code: '0x2642', key: '🙆‍♂', picture: '0x1f6460x2642.png'});
        this.put({code: '0xfe0f', key: '🙆‍♂️', picture: '0x1f6460x2642.png'});


        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🙆🏻', picture: '0x1f6460x1f3fb.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙆🏻‍♀', picture: '0x1f6460x1f3fb0x2640.png'});
        this.put({code: '0xfe0f', key: '🙆🏻‍♀️', picture: '0x1f6460x1f3fb0x2640.png'});

        this.put({code: '0x2642', key: '🙆🏻‍♂', picture: '0x1f6460x1f3fb0x2642.png'});
        this.put({code: '0xfe0f', key: '🙆🏻‍♂️', picture: '0x1f6460x1f3fb0x2642.png'});


        this.put({code: '0xdffc', key: '🙆🏼', picture: '0x1f6460x1f3fc.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙆🏼‍♀', picture: '0x1f6460x1f3fc0x2640.png'});
        this.put({code: '0xfe0f', key: '🙆🏼‍♀️', picture: '0x1f6460x1f3fc0x2640.png'});

        this.put({code: '0x2642', key: '🙆🏼‍♂', picture: '0x1f6460x1f3fc0x2642.png'});
        this.put({code: '0xfe0f', key: '🙆🏼‍♂️', picture: '0x1f6460x1f3fc0x2642.png'});


        this.put({code: '0xdffd', key: '🙆🏽', picture: '0x1f6460x1f3fd.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙆🏽‍♀', picture: '0x1f6460x1f3fd0x2640.png'});
        this.put({code: '0xfe0f', key: '🙆🏽‍♀️', picture: '0x1f6460x1f3fd0x2640.png'});

        this.put({code: '0x2642', key: '🙆🏽‍♂', picture: '0x1f6460x1f3fd0x2642.png'});
        this.put({code: '0xfe0f', key: '🙆🏽‍♂️', picture: '0x1f6460x1f3fd0x2642.png'});


        this.put({code: '0xdffe', key: '🙆🏾', picture: '0x1f6460x1f3fe.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙆🏾‍♀', picture: '0x1f6460x1f3fe0x2640.png'});
        this.put({code: '0xfe0f', key: '🙆🏾‍♀️', picture: '0x1f6460x1f3fe0x2640.png'});

        this.put({code: '0x2642', key: '🙆🏾‍♂', picture: '0x1f6460x1f3fe0x2642.png'});
        this.put({code: '0xfe0f', key: '🙆🏾‍♂️', picture: '0x1f6460x1f3fe0x2642.png'});


        this.put({code: '0xdfff', key: '🙆🏿', picture: '0x1f6460x1f3ff.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙆🏿‍♀', picture: '0x1f6460x1f3ff0x2640.png'});
        this.put({code: '0xfe0f', key: '🙆🏿‍♀️', picture: '0x1f6460x1f3ff0x2640.png'});

        this.put({code: '0x2642', key: '🙆🏿‍♂', picture: '0x1f6460x1f3ff0x2642.png'});
        this.put({code: '0xfe0f', key: '🙆🏿‍♂️', picture: '0x1f6460x1f3ff0x2642.png'});


        this.put({code: '0xde47', key: '🙇', picture: '0x1f647.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙇‍♀', picture: '0x1f6470x2640.png'});
        this.put({code: '0xfe0f', key: '🙇‍♀️', picture: '0x1f6470x2640.png'});

        this.put({code: '0x2642', key: '🙇‍♂', picture: '0x1f6470x2642.png'});
        this.put({code: '0xfe0f', key: '🙇‍♂️', picture: '0x1f6470x2642.png'});


        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🙇🏻', picture: '0x1f6470x1f3fb.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙇🏻‍♀', picture: '0x1f6470x1f3fb0x2640.png'});
        this.put({code: '0xfe0f', key: '🙇🏻‍♀️', picture: '0x1f6470x1f3fb0x2640.png'});

        this.put({code: '0x2642', key: '🙇🏻‍♂', picture: '0x1f6470x1f3fb0x2642.png'});
        this.put({code: '0xfe0f', key: '🙇🏻‍♂️', picture: '0x1f6470x1f3fb0x2642.png'});


        this.put({code: '0xdffc', key: '🙇🏼', picture: '0x1f6470x1f3fc.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙇🏼‍♀', picture: '0x1f6470x1f3fc0x2640.png'});
        this.put({code: '0xfe0f', key: '🙇🏼‍♀️', picture: '0x1f6470x1f3fc0x2640.png'});

        this.put({code: '0x2642', key: '🙇🏼‍♂', picture: '0x1f6470x1f3fc0x2642.png'});
        this.put({code: '0xfe0f', key: '🙇🏼‍♂️', picture: '0x1f6470x1f3fc0x2642.png'});


        this.put({code: '0xdffd', key: '🙇🏽', picture: '0x1f6470x1f3fd.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙇🏽‍♀', picture: '0x1f6470x1f3fd0x2640.png'});
        this.put({code: '0xfe0f', key: '🙇🏽‍♀️', picture: '0x1f6470x1f3fd0x2640.png'});

        this.put({code: '0x2642', key: '🙇🏽‍♂', picture: '0x1f6470x1f3fd0x2642.png'});
        this.put({code: '0xfe0f', key: '🙇🏽‍♂️', picture: '0x1f6470x1f3fd0x2642.png'});


        this.put({code: '0xdffe', key: '🙇🏾', picture: '0x1f6470x1f3fe.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙇🏾‍♀', picture: '0x1f6470x1f3fe0x2640.png'});
        this.put({code: '0xfe0f', key: '🙇🏾‍♀️', picture: '0x1f6470x1f3fe0x2640.png'});

        this.put({code: '0x2642', key: '🙇🏾‍♂', picture: '0x1f6470x1f3fe0x2642.png'});
        this.put({code: '0xfe0f', key: '🙇🏾‍♂️', picture: '0x1f6470x1f3fe0x2642.png'});


        this.put({code: '0xdfff', key: '🙇🏿', picture: '0x1f6470x1f3ff.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙇🏿‍♀', picture: '0x1f6470x1f3ff0x2640.png'});
        this.put({code: '0xfe0f', key: '🙇🏿‍♀️', picture: '0x1f6470x1f3ff0x2640.png'});

        this.put({code: '0x2642', key: '🙇🏿‍♂', picture: '0x1f6470x1f3ff0x2642.png'});
        this.put({code: '0xfe0f', key: '🙇🏿‍♂️', picture: '0x1f6470x1f3ff0x2642.png'});


        this.put({code: '0xde48', key: '🙈', picture: '0x1f648.png'});
        this.put({code: '0xde49', key: '🙉', picture: '0x1f649.png'});
        this.put({code: '0xde4a', key: '🙊', picture: '0x1f64a.png'});
        this.put({code: '0xde4b', key: '🙋', picture: '0x1f64b.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙋‍♀', picture: '0x1f64b0x2640.png'});
        this.put({code: '0xfe0f', key: '🙋‍♀️', picture: '0x1f64b0x2640.png'});

        this.put({code: '0x2642', key: '🙋‍♂', picture: '0x1f64b0x2642.png'});
        this.put({code: '0xfe0f', key: '🙋‍♂️', picture: '0x1f64b0x2642.png'});


        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🙋🏻', picture: '0x1f64b0x1f3fb.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙋🏻‍♀', picture: '0x1f64b0x1f3fb0x2640.png'});
        this.put({code: '0xfe0f', key: '🙋🏻‍♀️', picture: '0x1f64b0x1f3fb0x2640.png'});

        this.put({code: '0x2642', key: '🙋🏻‍♂', picture: '0x1f64b0x1f3fb0x2642.png'});
        this.put({code: '0xfe0f', key: '🙋🏻‍♂️', picture: '0x1f64b0x1f3fb0x2642.png'});


        this.put({code: '0xdffc', key: '🙋🏼', picture: '0x1f64b0x1f3fc.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙋🏼‍♀', picture: '0x1f64b0x1f3fc0x2640.png'});
        this.put({code: '0xfe0f', key: '🙋🏼‍♀️', picture: '0x1f64b0x1f3fc0x2640.png'});

        this.put({code: '0x2642', key: '🙋🏼‍♂', picture: '0x1f64b0x1f3fc0x2642.png'});
        this.put({code: '0xfe0f', key: '🙋🏼‍♂️', picture: '0x1f64b0x1f3fc0x2642.png'});


        this.put({code: '0xdffd', key: '🙋🏽', picture: '0x1f64b0x1f3fd.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙋🏽‍♀', picture: '0x1f64b0x1f3fd0x2640.png'});
        this.put({code: '0xfe0f', key: '🙋🏽‍♀️', picture: '0x1f64b0x1f3fd0x2640.png'});

        this.put({code: '0x2642', key: '🙋🏽‍♂', picture: '0x1f64b0x1f3fd0x2642.png'});
        this.put({code: '0xfe0f', key: '🙋🏽‍♂️', picture: '0x1f64b0x1f3fd0x2642.png'});


        this.put({code: '0xdffe', key: '🙋🏾', picture: '0x1f64b0x1f3fe.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙋🏾‍♀', picture: '0x1f64b0x1f3fe0x2640.png'});
        this.put({code: '0xfe0f', key: '🙋🏾‍♀️', picture: '0x1f64b0x1f3fe0x2640.png'});

        this.put({code: '0x2642', key: '🙋🏾‍♂', picture: '0x1f64b0x1f3fe0x2642.png'});
        this.put({code: '0xfe0f', key: '🙋🏾‍♂️', picture: '0x1f64b0x1f3fe0x2642.png'});


        this.put({code: '0xdfff', key: '🙋🏿', picture: '0x1f64b0x1f3ff.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙋🏿‍♀', picture: '0x1f64b0x1f3ff0x2640.png'});
        this.put({code: '0xfe0f', key: '🙋🏿‍♀️', picture: '0x1f64b0x1f3ff0x2640.png'});

        this.put({code: '0x2642', key: '🙋🏿‍♂', picture: '0x1f64b0x1f3ff0x2642.png'});
        this.put({code: '0xfe0f', key: '🙋🏿‍♂️', picture: '0x1f64b0x1f3ff0x2642.png'});


        this.put({code: '0xde4c', key: '🙌', picture: '0x1f64c.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🙌🏻', picture: '0x1f64c0x1f3fb.png'});
        this.put({code: '0xdffc', key: '🙌🏼', picture: '0x1f64c0x1f3fc.png'});
        this.put({code: '0xdffd', key: '🙌🏽', picture: '0x1f64c0x1f3fd.png'});
        this.put({code: '0xdffe', key: '🙌🏾', picture: '0x1f64c0x1f3fe.png'});
        this.put({code: '0xdfff', key: '🙌🏿', picture: '0x1f64c0x1f3ff.png'});


        this.put({code: '0xde4d', key: '🙍', picture: '0x1f64d.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙍‍♀', picture: '0x1f64d0x2640.png'});
        this.put({code: '0xfe0f', key: '🙍‍♀️', picture: '0x1f64d0x2640.png'});

        this.put({code: '0x2642', key: '🙍‍♂', picture: '0x1f64d0x2642.png'});
        this.put({code: '0xfe0f', key: '🙍‍♂️', picture: '0x1f64d0x2642.png'});


        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🙍🏻', picture: '0x1f64d0x1f3fb.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙍🏻‍♀', picture: '0x1f64d0x1f3fb0x2640.png'});
        this.put({code: '0xfe0f', key: '🙍🏻‍♀️', picture: '0x1f64d0x1f3fb0x2640.png'});

        this.put({code: '0x2642', key: '🙍🏻‍♂', picture: '0x1f64d0x1f3fb0x2642.png'});
        this.put({code: '0xfe0f', key: '🙍🏻‍♂️', picture: '0x1f64d0x1f3fb0x2642.png'});


        this.put({code: '0xdffc', key: '🙍🏼', picture: '0x1f64d0x1f3fc.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙍🏼‍♀', picture: '0x1f64d0x1f3fc0x2640.png'});
        this.put({code: '0xfe0f', key: '🙍🏼‍♀️', picture: '0x1f64d0x1f3fc0x2640.png'});

        this.put({code: '0x2642', key: '🙍🏼‍♂', picture: '0x1f64d0x1f3fc0x2642.png'});
        this.put({code: '0xfe0f', key: '🙍🏼‍♂️', picture: '0x1f64d0x1f3fc0x2642.png'});


        this.put({code: '0xdffd', key: '🙍🏽', picture: '0x1f64d0x1f3fd.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙍🏽‍♀', picture: '0x1f64d0x1f3fd0x2640.png'});
        this.put({code: '0xfe0f', key: '🙍🏽‍♀️', picture: '0x1f64d0x1f3fd0x2640.png'});

        this.put({code: '0x2642', key: '🙍🏽‍♂', picture: '0x1f64d0x1f3fd0x2642.png'});
        this.put({code: '0xfe0f', key: '🙍🏽‍♂️', picture: '0x1f64d0x1f3fd0x2642.png'});


        this.put({code: '0xdffe', key: '🙍🏾', picture: '0x1f64d0x1f3fe.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙍🏾‍♀', picture: '0x1f64d0x1f3fe0x2640.png'});
        this.put({code: '0xfe0f', key: '🙍🏾‍♀️', picture: '0x1f64d0x1f3fe0x2640.png'});

        this.put({code: '0x2642', key: '🙍🏾‍♂', picture: '0x1f64d0x1f3fe0x2642.png'});
        this.put({code: '0xfe0f', key: '🙍🏾‍♂️', picture: '0x1f64d0x1f3fe0x2642.png'});


        this.put({code: '0xdfff', key: '🙍🏿', picture: '0x1f64d0x1f3ff.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙍🏿‍♀', picture: '0x1f64d0x1f3ff0x2640.png'});
        this.put({code: '0xfe0f', key: '🙍🏿‍♀️', picture: '0x1f64d0x1f3ff0x2640.png'});

        this.put({code: '0x2642', key: '🙍🏿‍♂', picture: '0x1f64d0x1f3ff0x2642.png'});
        this.put({code: '0xfe0f', key: '🙍🏿‍♂️', picture: '0x1f64d0x1f3ff0x2642.png'});


        this.put({code: '0xde4e', key: '🙎', picture: '0x1f64e.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙎‍♀', picture: '0x1f64e0x2640.png'});
        this.put({code: '0xfe0f', key: '🙎‍♀️', picture: '0x1f64e0x2640.png'});

        this.put({code: '0x2642', key: '🙎‍♂', picture: '0x1f64e0x2642.png'});
        this.put({code: '0xfe0f', key: '🙎‍♂️', picture: '0x1f64e0x2642.png'});


        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🙎🏻', picture: '0x1f64e0x1f3fb.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙎🏻‍♀', picture: '0x1f64e0x1f3fb0x2640.png'});
        this.put({code: '0xfe0f', key: '🙎🏻‍♀️', picture: '0x1f64e0x1f3fb0x2640.png'});

        this.put({code: '0x2642', key: '🙎🏻‍♂', picture: '0x1f64e0x1f3fb0x2642.png'});
        this.put({code: '0xfe0f', key: '🙎🏻‍♂️', picture: '0x1f64e0x1f3fb0x2642.png'});


        this.put({code: '0xdffc', key: '🙎🏼', picture: '0x1f64e0x1f3fc.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙎🏼‍♀', picture: '0x1f64e0x1f3fc0x2640.png'});
        this.put({code: '0xfe0f', key: '🙎🏼‍♀️', picture: '0x1f64e0x1f3fc0x2640.png'});

        this.put({code: '0x2642', key: '🙎🏼‍♂', picture: '0x1f64e0x1f3fc0x2642.png'});
        this.put({code: '0xfe0f', key: '🙎🏼‍♂️', picture: '0x1f64e0x1f3fc0x2642.png'});


        this.put({code: '0xdffd', key: '🙎🏽', picture: '0x1f64e0x1f3fd.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙎🏽‍♀', picture: '0x1f64e0x1f3fd0x2640.png'});
        this.put({code: '0xfe0f', key: '🙎🏽‍♀️', picture: '0x1f64e0x1f3fd0x2640.png'});

        this.put({code: '0x2642', key: '🙎🏽‍♂', picture: '0x1f64e0x1f3fd0x2642.png'});
        this.put({code: '0xfe0f', key: '🙎🏽‍♂️', picture: '0x1f64e0x1f3fd0x2642.png'});


        this.put({code: '0xdffe', key: '🙎🏾', picture: '0x1f64e0x1f3fe.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙎🏾‍♀', picture: '0x1f64e0x1f3fe0x2640.png'});
        this.put({code: '0xfe0f', key: '🙎🏾‍♀️', picture: '0x1f64e0x1f3fe0x2640.png'});

        this.put({code: '0x2642', key: '🙎🏾‍♂', picture: '0x1f64e0x1f3fe0x2642.png'});
        this.put({code: '0xfe0f', key: '🙎🏾‍♂️', picture: '0x1f64e0x1f3fe0x2642.png'});


        this.put({code: '0xdfff', key: '🙎🏿', picture: '0x1f64e0x1f3ff.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🙎🏿‍♀', picture: '0x1f64e0x1f3ff0x2640.png'});
        this.put({code: '0xfe0f', key: '🙎🏿‍♀️', picture: '0x1f64e0x1f3ff0x2640.png'});

        this.put({code: '0x2642', key: '🙎🏿‍♂', picture: '0x1f64e0x1f3ff0x2642.png'});
        this.put({code: '0xfe0f', key: '🙎🏿‍♂️', picture: '0x1f64e0x1f3ff0x2642.png'});


        this.put({code: '0xde4f', key: '🙏', picture: '0x1f64f.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🙏🏻', picture: '0x1f64f0x1f3fb.png'});
        this.put({code: '0xdffc', key: '🙏🏼', picture: '0x1f64f0x1f3fc.png'});
        this.put({code: '0xdffd', key: '🙏🏽', picture: '0x1f64f0x1f3fd.png'});
        this.put({code: '0xdffe', key: '🙏🏾', picture: '0x1f64f0x1f3fe.png'});
        this.put({code: '0xdfff', key: '🙏🏿', picture: '0x1f64f0x1f3ff.png'});


        this.put({code: '0x00a9', key: '©', picture: '0x00a9.png'});
        this.put({code: '0xfe0f', key: '©️', picture: '0x00a9.png'});

        this.put({code: '0x00ae', key: '®', picture: '0x00ae.png'});
        this.put({code: '0xfe0f', key: '®️', picture: '0x00ae.png'});

        this.put({code: '0x203c', key: '‼', picture: '0x203c.png'});
        this.put({code: '0xfe0f', key: '‼️', picture: '0x203c.png'});

        this.put({code: '0x2049', key: '⁉', picture: '0x2049.png'});
        this.put({code: '0xfe0f', key: '⁉️', picture: '0x2049.png'});

        this.put({code: '0x2122', key: '™', picture: '0x2122.png'});
        this.put({code: '0xfe0f', key: '™️', picture: '0x2122.png'});

        this.put({code: '0x2139', key: 'ℹ', picture: '0x2139.png'});
        this.put({code: '0xfe0f', key: 'ℹ️', picture: '0x2139.png'});

        this.put({code: '0x2194', key: '↔', picture: '0x2194.png'});
        this.put({code: '0xfe0f', key: '↔️', picture: '0x2194.png'});

        this.put({code: '0x2195', key: '↕', picture: '0x2195.png'});
        this.put({code: '0xfe0f', key: '↕️', picture: '0x2195.png'});

        this.put({code: '0x2196', key: '↖', picture: '0x2196.png'});
        this.put({code: '0xfe0f', key: '↖️', picture: '0x2196.png'});

        this.put({code: '0x2197', key: '↗', picture: '0x2197.png'});
        this.put({code: '0xfe0f', key: '↗️', picture: '0x2197.png'});

        this.put({code: '0x2198', key: '↘', picture: '0x2198.png'});
        this.put({code: '0xfe0f', key: '↘️', picture: '0x2198.png'});

        this.put({code: '0x2199', key: '↙', picture: '0x2199.png'});
        this.put({code: '0xfe0f', key: '↙️', picture: '0x2199.png'});

        this.put({code: '0x21a9', key: '↩', picture: '0x21a9.png'});
        this.put({code: '0xfe0f', key: '↩️', picture: '0x21a9.png'});

        this.put({code: '0x21aa', key: '↪', picture: '0x21aa.png'});
        this.put({code: '0xfe0f', key: '↪️', picture: '0x21aa.png'});

        this.put({code: '0x231a', key: '⌚', picture: '0x231a.png'});
        this.put({code: '0x231b', key: '⌛', picture: '0x231b.png'});
        this.put({code: '0x2328', key: '⌨', picture: '0x2328.png'});
        this.put({code: '0xfe0f', key: '⌨️', picture: '0x2328.png'});

        this.put({code: '0x23cf', key: '⏏', picture: '0x23cf.png'});
        this.put({code: '0xfe0f', key: '⏏️', picture: '0x23cf.png'});

        this.put({code: '0x23e9', key: '⏩', picture: '0x23e9.png'});
        this.put({code: '0x23ea', key: '⏪', picture: '0x23ea.png'});
        this.put({code: '0x23eb', key: '⏫', picture: '0x23eb.png'});
        this.put({code: '0x23ec', key: '⏬', picture: '0x23ec.png'});
        this.put({code: '0x23ed', key: '⏭', picture: '0x23ed.png'});
        this.put({code: '0xfe0f', key: '⏭️', picture: '0x23ed.png'});

        this.put({code: '0x23ee', key: '⏮', picture: '0x23ee.png'});
        this.put({code: '0xfe0f', key: '⏮️', picture: '0x23ee.png'});

        this.put({code: '0x23ef', key: '⏯', picture: '0x23ef.png'});
        this.put({code: '0xfe0f', key: '⏯️', picture: '0x23ef.png'});

        this.put({code: '0x23f0', key: '⏰', picture: '0x23f0.png'});
        this.put({code: '0x23f1', key: '⏱', picture: '0x23f1.png'});
        this.put({code: '0xfe0f', key: '⏱️', picture: '0x23f1.png'});

        this.put({code: '0x23f2', key: '⏲', picture: '0x23f2.png'});
        this.put({code: '0xfe0f', key: '⏲️', picture: '0x23f2.png'});

        this.put({code: '0x23f3', key: '⏳', picture: '0x23f3.png'});
        this.put({code: '0x23f8', key: '⏸', picture: '0x23f8.png'});
        this.put({code: '0xfe0f', key: '⏸️', picture: '0x23f8.png'});

        this.put({code: '0x23f9', key: '⏹', picture: '0x23f9.png'});
        this.put({code: '0xfe0f', key: '⏹️', picture: '0x23f9.png'});

        this.put({code: '0x23fa', key: '⏺', picture: '0x23fa.png'});
        this.put({code: '0xfe0f', key: '⏺️', picture: '0x23fa.png'});

        this.put({code: '0x24c2', key: 'Ⓜ', picture: '0x24c2.png'});
        this.put({code: '0xfe0f', key: 'Ⓜ️', picture: '0x24c2.png'});

        this.put({code: '0x25aa', key: '▪', picture: '0x25aa.png'});
        this.put({code: '0xfe0f', key: '▪️', picture: '0x25aa.png'});

        this.put({code: '0x25ab', key: '▫', picture: '0x25ab.png'});
        this.put({code: '0xfe0f', key: '▫️', picture: '0x25ab.png'});

        this.put({code: '0x25b6', key: '▶', picture: '0x25b6.png'});
        this.put({code: '0xfe0f', key: '▶️', picture: '0x25b6.png'});

        this.put({code: '0x25c0', key: '◀', picture: '0x25c0.png'});
        this.put({code: '0xfe0f', key: '◀️', picture: '0x25c0.png'});

        this.put({code: '0x25fb', key: '◻', picture: '0x25fb.png'});
        this.put({code: '0xfe0f', key: '◻️', picture: '0x25fb.png'});

        this.put({code: '0x25fc', key: '◼', picture: '0x25fc.png'});
        this.put({code: '0xfe0f', key: '◼️', picture: '0x25fc.png'});

        this.put({code: '0x25fd', key: '◽', picture: '0x25fd.png'});
        this.put({code: '0x25fe', key: '◾', picture: '0x25fe.png'});
        this.put({code: '0x2600', key: '☀', picture: '0x2600.png'});
        this.put({code: '0xfe0f', key: '☀️', picture: '0x2600.png'});

        this.put({code: '0x2601', key: '☁', picture: '0x2601.png'});
        this.put({code: '0xfe0f', key: '☁️', picture: '0x2601.png'});

        this.put({code: '0x2602', key: '☂', picture: '0x2602.png'});
        this.put({code: '0xfe0f', key: '☂️', picture: '0x2602.png'});

        this.put({code: '0x2603', key: '☃', picture: '0x2603.png'});
        this.put({code: '0xfe0f', key: '☃️', picture: '0x2603.png'});

        this.put({code: '0x2604', key: '☄', picture: '0x2604.png'});
        this.put({code: '0xfe0f', key: '☄️', picture: '0x2604.png'});

        this.put({code: '0x260e', key: '☎', picture: '0x260e.png'});
        this.put({code: '0xfe0f', key: '☎️', picture: '0x260e.png'});

        this.put({code: '0x2611', key: '☑', picture: '0x2611.png'});
        this.put({code: '0xfe0f', key: '☑️', picture: '0x2611.png'});

        this.put({code: '0x2614', key: '☔', picture: '0x2614.png'});
        this.put({code: '0x2615', key: '☕', picture: '0x2615.png'});
        this.put({code: '0x2618', key: '☘', picture: '0x2618.png'});
        this.put({code: '0xfe0f', key: '☘️', picture: '0x2618.png'});

        this.put({code: '0x261d', key: '☝', picture: '0x261d.png'});
        this.put({code: '0xfe0f', key: '☝️', picture: '0x261d.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '☝🏻', picture: '0x261d0x1f3fb.png'});
        this.put({code: '0xdffc', key: '☝🏼', picture: '0x261d0x1f3fc.png'});
        this.put({code: '0xdffd', key: '☝🏽', picture: '0x261d0x1f3fd.png'});
        this.put({code: '0xdffe', key: '☝🏾', picture: '0x261d0x1f3fe.png'});
        this.put({code: '0xdfff', key: '☝🏿', picture: '0x261d0x1f3ff.png'});


        this.put({code: '0x2620', key: '☠', picture: '0x2620.png'});
        this.put({code: '0xfe0f', key: '☠️', picture: '0x2620.png'});

        this.put({code: '0x2622', key: '☢', picture: '0x2622.png'});
        this.put({code: '0xfe0f', key: '☢️', picture: '0x2622.png'});

        this.put({code: '0x2623', key: '☣', picture: '0x2623.png'});
        this.put({code: '0xfe0f', key: '☣️', picture: '0x2623.png'});

        this.put({code: '0x2626', key: '☦', picture: '0x2626.png'});
        this.put({code: '0xfe0f', key: '☦️', picture: '0x2626.png'});

        this.put({code: '0x262a', key: '☪', picture: '0x262a.png'});
        this.put({code: '0xfe0f', key: '☪️', picture: '0x262a.png'});

        this.put({code: '0x262e', key: '☮', picture: '0x262e.png'});
        this.put({code: '0xfe0f', key: '☮️', picture: '0x262e.png'});

        this.put({code: '0x262f', key: '☯', picture: '0x262f.png'});
        this.put({code: '0xfe0f', key: '☯️', picture: '0x262f.png'});

        this.put({code: '0x2638', key: '☸', picture: '0x2638.png'});
        this.put({code: '0xfe0f', key: '☸️', picture: '0x2638.png'});

        this.put({code: '0x2639', key: '☹', picture: '0x2639.png'});
        this.put({code: '0xfe0f', key: '☹️', picture: '0x2639.png'});

        this.put({code: '0x263a', key: '☺', picture: '0x263a.png'});
        this.put({code: '0xfe0f', key: '☺️', picture: '0x263a.png'});

        this.put({code: '0x2640', key: '♀', picture: '0x2640.png'});
        this.put({code: '0xfe0f', key: '♀️', picture: '0x2640.png'});

        this.put({code: '0x2642', key: '♂', picture: '0x2642.png'});
        this.put({code: '0xfe0f', key: '♂️', picture: '0x2642.png'});

        this.put({code: '0x2648', key: '♈', picture: '0x2648.png'});
        this.put({code: '0x2649', key: '♉', picture: '0x2649.png'});
        this.put({code: '0x264a', key: '♊', picture: '0x264a.png'});
        this.put({code: '0x264b', key: '♋', picture: '0x264b.png'});
        this.put({code: '0x264c', key: '♌', picture: '0x264c.png'});
        this.put({code: '0x264d', key: '♍', picture: '0x264d.png'});
        this.put({code: '0x264e', key: '♎', picture: '0x264e.png'});
        this.put({code: '0x264f', key: '♏', picture: '0x264f.png'});
        this.put({code: '0x2650', key: '♐', picture: '0x2650.png'});
        this.put({code: '0x2651', key: '♑', picture: '0x2651.png'});
        this.put({code: '0x2652', key: '♒', picture: '0x2652.png'});
        this.put({code: '0x2653', key: '♓', picture: '0x2653.png'});
        this.put({code: '0x2660', key: '♠', picture: '0x2660.png'});
        this.put({code: '0xfe0f', key: '♠️', picture: '0x2660.png'});

        this.put({code: '0x2663', key: '♣', picture: '0x2663.png'});
        this.put({code: '0xfe0f', key: '♣️', picture: '0x2663.png'});

        this.put({code: '0x2665', key: '♥', picture: '0x2665.png'});
        this.put({code: '0xfe0f', key: '♥️', picture: '0x2665.png'});

        this.put({code: '0x2666', key: '♦', picture: '0x2666.png'});
        this.put({code: '0xfe0f', key: '♦️', picture: '0x2666.png'});

        this.put({code: '0x2668', key: '♨', picture: '0x2668.png'});
        this.put({code: '0xfe0f', key: '♨️', picture: '0x2668.png'});

        this.put({code: '0x267b', key: '♻', picture: '0x267b.png'});
        this.put({code: '0xfe0f', key: '♻️', picture: '0x267b.png'});

        this.put({code: '0x267f', key: '♿', picture: '0x267f.png'});
        this.put({code: '0x2692', key: '⚒', picture: '0x2692.png'});
        this.put({code: '0xfe0f', key: '⚒️', picture: '0x2692.png'});

        this.put({code: '0x2693', key: '⚓', picture: '0x2693.png'});
        this.put({code: '0x2694', key: '⚔', picture: '0x2694.png'});
        this.put({code: '0xfe0f', key: '⚔️', picture: '0x2694.png'});

        this.put({code: '0x2695', key: '⚕', picture: '0x2695.png'});
        this.put({code: '0xfe0f', key: '⚕️', picture: '0x2695.png'});

        this.put({code: '0x2696', key: '⚖', picture: '0x2696.png'});
        this.put({code: '0xfe0f', key: '⚖️', picture: '0x2696.png'});

        this.put({code: '0x2697', key: '⚗', picture: '0x2697.png'});
        this.put({code: '0xfe0f', key: '⚗️', picture: '0x2697.png'});

        this.put({code: '0x2699', key: '⚙', picture: '0x2699.png'});
        this.put({code: '0xfe0f', key: '⚙️', picture: '0x2699.png'});

        this.put({code: '0x269b', key: '⚛', picture: '0x269b.png'});
        this.put({code: '0xfe0f', key: '⚛️', picture: '0x269b.png'});

        this.put({code: '0x269c', key: '⚜', picture: '0x269c.png'});
        this.put({code: '0xfe0f', key: '⚜️', picture: '0x269c.png'});

        this.put({code: '0x26a0', key: '⚠', picture: '0x26a0.png'});
        this.put({code: '0xfe0f', key: '⚠️', picture: '0x26a0.png'});

        this.put({code: '0x26a1', key: '⚡', picture: '0x26a1.png'});
        this.put({code: '0x26aa', key: '⚪', picture: '0x26aa.png'});
        this.put({code: '0x26ab', key: '⚫', picture: '0x26ab.png'});
        this.put({code: '0x26b0', key: '⚰', picture: '0x26b0.png'});
        this.put({code: '0xfe0f', key: '⚰️', picture: '0x26b0.png'});

        this.put({code: '0x26b1', key: '⚱', picture: '0x26b1.png'});
        this.put({code: '0xfe0f', key: '⚱️', picture: '0x26b1.png'});

        this.put({code: '0x26bd', key: '⚽', picture: '0x26bd.png'});
        this.put({code: '0x26be', key: '⚾', picture: '0x26be.png'});
        this.put({code: '0x26c4', key: '⛄', picture: '0x26c4.png'});
        this.put({code: '0x26c5', key: '⛅', picture: '0x26c5.png'});
        this.put({code: '0x26c8', key: '⛈', picture: '0x26c8.png'});
        this.put({code: '0xfe0f', key: '⛈️', picture: '0x26c8.png'});

        this.put({code: '0x26ce', key: '⛎', picture: '0x26ce.png'});
        this.put({code: '0x26cf', key: '⛏', picture: '0x26cf.png'});
        this.put({code: '0xfe0f', key: '⛏️', picture: '0x26cf.png'});

        this.put({code: '0x26d1', key: '⛑', picture: '0x26d1.png'});
        this.put({code: '0xfe0f', key: '⛑️', picture: '0x26d1.png'});

        this.put({code: '0x26d3', key: '⛓', picture: '0x26d3.png'});
        this.put({code: '0xfe0f', key: '⛓️', picture: '0x26d3.png'});

        this.put({code: '0x26d4', key: '⛔', picture: '0x26d4.png'});
        this.put({code: '0x26e9', key: '⛩', picture: '0x26e9.png'});
        this.put({code: '0xfe0f', key: '⛩️', picture: '0x26e9.png'});

        this.put({code: '0x26ea', key: '⛪', picture: '0x26ea.png'});
        this.put({code: '0x26f0', key: '⛰', picture: '0x26f0.png'});
        this.put({code: '0xfe0f', key: '⛰️', picture: '0x26f0.png'});

        this.put({code: '0x26f1', key: '⛱', picture: '0x26f1.png'});
        this.put({code: '0xfe0f', key: '⛱️', picture: '0x26f1.png'});

        this.put({code: '0x26f2', key: '⛲', picture: '0x26f2.png'});
        this.put({code: '0x26f3', key: '⛳', picture: '0x26f3.png'});
        this.put({code: '0x26f4', key: '⛴', picture: '0x26f4.png'});
        this.put({code: '0xfe0f', key: '⛴️', picture: '0x26f4.png'});

        this.put({code: '0x26f5', key: '⛵', picture: '0x26f5.png'});
        this.put({code: '0x26f7', key: '⛷', picture: '0x26f7.png'});
        this.put({code: '0xfe0f', key: '⛷️', picture: '0x26f7.png'});

        this.put({code: '0x26f8', key: '⛸', picture: '0x26f8.png'});
        this.put({code: '0xfe0f', key: '⛸️', picture: '0x26f8.png'});

        this.put({code: '0x26f9', key: '⛹', picture: '0x26f9.png'});
        this.put({code: '0xfe0f', key: '⛹️', picture: '0x26f9.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640'});
        this.put({code: '0xfe0f', key: '⛹️‍♀️', picture: '0x26f90x2640.png'});

        this.put({code: '0x2642'});
        this.put({code: '0xfe0f', key: '⛹️‍♂️', picture: '0x26f90x2642.png'});


        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '⛹‍♀', picture: '0x26f90x2640.png'});
        this.put({code: '0x2642', key: '⛹‍♂', picture: '0x26f90x2642.png'});

        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '⛹🏻', picture: '0x26f90x1f3fb.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '⛹🏻‍♀', picture: '0x26f90x1f3fb0x2640.png'});
        this.put({code: '0xfe0f', key: '⛹🏻‍♀️', picture: '0x26f90x1f3fb0x2640.png'});

        this.put({code: '0x2642', key: '⛹🏻‍♂', picture: '0x26f90x1f3fb0x2642.png'});
        this.put({code: '0xfe0f', key: '⛹🏻‍♂️', picture: '0x26f90x1f3fb0x2642.png'});


        this.put({code: '0xdffc', key: '⛹🏼', picture: '0x26f90x1f3fc.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '⛹🏼‍♀', picture: '0x26f90x1f3fc0x2640.png'});
        this.put({code: '0xfe0f', key: '⛹🏼‍♀️', picture: '0x26f90x1f3fc0x2640.png'});

        this.put({code: '0x2642', key: '⛹🏼‍♂', picture: '0x26f90x1f3fc0x2642.png'});
        this.put({code: '0xfe0f', key: '⛹🏼‍♂️', picture: '0x26f90x1f3fc0x2642.png'});


        this.put({code: '0xdffd', key: '⛹🏽', picture: '0x26f90x1f3fd.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '⛹🏽‍♀', picture: '0x26f90x1f3fd0x2640.png'});
        this.put({code: '0xfe0f', key: '⛹🏽‍♀️', picture: '0x26f90x1f3fd0x2640.png'});

        this.put({code: '0x2642', key: '⛹🏽‍♂', picture: '0x26f90x1f3fd0x2642.png'});
        this.put({code: '0xfe0f', key: '⛹🏽‍♂️', picture: '0x26f90x1f3fd0x2642.png'});


        this.put({code: '0xdffe', key: '⛹🏾', picture: '0x26f90x1f3fe.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '⛹🏾‍♀', picture: '0x26f90x1f3fe0x2640.png'});
        this.put({code: '0xfe0f', key: '⛹🏾‍♀️', picture: '0x26f90x1f3fe0x2640.png'});

        this.put({code: '0x2642', key: '⛹🏾‍♂', picture: '0x26f90x1f3fe0x2642.png'});
        this.put({code: '0xfe0f', key: '⛹🏾‍♂️', picture: '0x26f90x1f3fe0x2642.png'});


        this.put({code: '0xdfff', key: '⛹🏿', picture: '0x26f90x1f3ff.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '⛹🏿‍♀', picture: '0x26f90x1f3ff0x2640.png'});
        this.put({code: '0xfe0f', key: '⛹🏿‍♀️', picture: '0x26f90x1f3ff0x2640.png'});

        this.put({code: '0x2642', key: '⛹🏿‍♂', picture: '0x26f90x1f3ff0x2642.png'});
        this.put({code: '0xfe0f', key: '⛹🏿‍♂️', picture: '0x26f90x1f3ff0x2642.png'});


        this.put({code: '0x26fa', key: '⛺', picture: '0x26fa.png'});
        this.put({code: '0x26fd', key: '⛽', picture: '0x26fd.png'});
        this.put({code: '0x2702', key: '✂', picture: '0x2702.png'});
        this.put({code: '0xfe0f', key: '✂️', picture: '0x2702.png'});

        this.put({code: '0x2705', key: '✅', picture: '0x2705.png'});
        this.put({code: '0x2708', key: '✈', picture: '0x2708.png'});
        this.put({code: '0xfe0f', key: '✈️', picture: '0x2708.png'});

        this.put({code: '0x2709', key: '✉', picture: '0x2709.png'});
        this.put({code: '0xfe0f', key: '✉️', picture: '0x2709.png'});

        this.put({code: '0x270a', key: '✊', picture: '0x270a.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '✊🏻', picture: '0x270a0x1f3fb.png'});
        this.put({code: '0xdffc', key: '✊🏼', picture: '0x270a0x1f3fc.png'});
        this.put({code: '0xdffd', key: '✊🏽', picture: '0x270a0x1f3fd.png'});
        this.put({code: '0xdffe', key: '✊🏾', picture: '0x270a0x1f3fe.png'});
        this.put({code: '0xdfff', key: '✊🏿', picture: '0x270a0x1f3ff.png'});


        this.put({code: '0x270b', key: '✋', picture: '0x270b.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '✋🏻', picture: '0x270b0x1f3fb.png'});
        this.put({code: '0xdffc', key: '✋🏼', picture: '0x270b0x1f3fc.png'});
        this.put({code: '0xdffd', key: '✋🏽', picture: '0x270b0x1f3fd.png'});
        this.put({code: '0xdffe', key: '✋🏾', picture: '0x270b0x1f3fe.png'});
        this.put({code: '0xdfff', key: '✋🏿', picture: '0x270b0x1f3ff.png'});


        this.put({code: '0x270c', key: '✌', picture: '0x270c.png'});
        this.put({code: '0xfe0f', key: '✌️', picture: '0x270c.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '✌🏻', picture: '0x270c0x1f3fb.png'});
        this.put({code: '0xdffc', key: '✌🏼', picture: '0x270c0x1f3fc.png'});
        this.put({code: '0xdffd', key: '✌🏽', picture: '0x270c0x1f3fd.png'});
        this.put({code: '0xdffe', key: '✌🏾', picture: '0x270c0x1f3fe.png'});
        this.put({code: '0xdfff', key: '✌🏿', picture: '0x270c0x1f3ff.png'});


        this.put({code: '0x270d', key: '✍', picture: '0x270d.png'});
        this.put({code: '0xfe0f', key: '✍️', picture: '0x270d.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '✍🏻', picture: '0x270d0x1f3fb.png'});
        this.put({code: '0xdffc', key: '✍🏼', picture: '0x270d0x1f3fc.png'});
        this.put({code: '0xdffd', key: '✍🏽', picture: '0x270d0x1f3fd.png'});
        this.put({code: '0xdffe', key: '✍🏾', picture: '0x270d0x1f3fe.png'});
        this.put({code: '0xdfff', key: '✍🏿', picture: '0x270d0x1f3ff.png'});


        this.put({code: '0x270f', key: '✏', picture: '0x270f.png'});
        this.put({code: '0xfe0f', key: '✏️', picture: '0x270f.png'});

        this.put({code: '0x2712', key: '✒', picture: '0x2712.png'});
        this.put({code: '0xfe0f', key: '✒️', picture: '0x2712.png'});

        this.put({code: '0x2714', key: '✔', picture: '0x2714.png'});
        this.put({code: '0xfe0f', key: '✔️', picture: '0x2714.png'});

        this.put({code: '0x2716', key: '✖', picture: '0x2716.png'});
        this.put({code: '0xfe0f', key: '✖️', picture: '0x2716.png'});

        this.put({code: '0x271d', key: '✝', picture: '0x271d.png'});
        this.put({code: '0xfe0f', key: '✝️', picture: '0x271d.png'});

        this.put({code: '0x2721', key: '✡', picture: '0x2721.png'});
        this.put({code: '0xfe0f', key: '✡️', picture: '0x2721.png'});

        this.put({code: '0x2728', key: '✨', picture: '0x2728.png'});
        this.put({code: '0x2733', key: '✳', picture: '0x2733.png'});
        this.put({code: '0xfe0f', key: '✳️', picture: '0x2733.png'});

        this.put({code: '0x2734', key: '✴', picture: '0x2734.png'});
        this.put({code: '0xfe0f', key: '✴️', picture: '0x2734.png'});

        this.put({code: '0x2744', key: '❄', picture: '0x2744.png'});
        this.put({code: '0xfe0f', key: '❄️', picture: '0x2744.png'});

        this.put({code: '0x2747', key: '❇', picture: '0x2747.png'});
        this.put({code: '0xfe0f', key: '❇️', picture: '0x2747.png'});

        this.put({code: '0x274c', key: '❌', picture: '0x274c.png'});
        this.put({code: '0x274e', key: '❎', picture: '0x274e.png'});
        this.put({code: '0x2753', key: '❓', picture: '0x2753.png'});
        this.put({code: '0x2754', key: '❔', picture: '0x2754.png'});
        this.put({code: '0x2755', key: '❕', picture: '0x2755.png'});
        this.put({code: '0x2757', key: '❗', picture: '0x2757.png'});
        this.put({code: '0x2763', key: '❣', picture: '0x2763.png'});
        this.put({code: '0xfe0f', key: '❣️', picture: '0x2763.png'});

        this.put({code: '0x2764', key: '❤', picture: '0x2764.png'});
        this.put({code: '0xfe0f', key: '❤️', picture: '0x2764.png'});

        this.put({code: '0x2795', key: '➕', picture: '0x2795.png'});
        this.put({code: '0x2796', key: '➖', picture: '0x2796.png'});
        this.put({code: '0x2797', key: '➗', picture: '0x2797.png'});
        this.put({code: '0x27a1', key: '➡', picture: '0x27a1.png'});
        this.put({code: '0xfe0f', key: '➡️', picture: '0x27a1.png'});

        this.put({code: '0x27b0', key: '➰', picture: '0x27b0.png'});
        this.put({code: '0x27bf', key: '➿', picture: '0x27bf.png'});
        this.put({code: '0x2934', key: '⤴', picture: '0x2934.png'});
        this.put({code: '0xfe0f', key: '⤴️', picture: '0x2934.png'});

        this.put({code: '0x2935', key: '⤵', picture: '0x2935.png'});
        this.put({code: '0xfe0f', key: '⤵️', picture: '0x2935.png'});

        this.put({code: '0x2b05', key: '⬅', picture: '0x2b05.png'});
        this.put({code: '0xfe0f', key: '⬅️', picture: '0x2b05.png'});

        this.put({code: '0x2b06', key: '⬆', picture: '0x2b06.png'});
        this.put({code: '0xfe0f', key: '⬆️', picture: '0x2b06.png'});

        this.put({code: '0x2b07', key: '⬇', picture: '0x2b07.png'});
        this.put({code: '0xfe0f', key: '⬇️', picture: '0x2b07.png'});

        this.put({code: '0x2b1b', key: '⬛', picture: '0x2b1b.png'});
        this.put({code: '0x2b1c', key: '⬜', picture: '0x2b1c.png'});
        this.put({code: '0x2b50', key: '⭐', picture: '0x2b50.png'});
        this.put({code: '0x2b55', key: '⭕', picture: '0x2b55.png'});
        this.put({code: '0x3030', key: '〰', picture: '0x3030.png'});
        this.put({code: '0xfe0f', key: '〰️', picture: '0x3030.png'});

        this.put({code: '0x303d', key: '〽', picture: '0x303d.png'});
        this.put({code: '0xfe0f', key: '〽️', picture: '0x303d.png'});

        this.put({code: '0x3297', key: '㊗', picture: '0x3297.png'});
        this.put({code: '0xfe0f', key: '㊗️', picture: '0x3297.png'});

        this.put({code: '0x3299', key: '㊙', picture: '0x3299.png'});
        this.put({code: '0xfe0f', key: '㊙️', picture: '0x3299.png'});

        this.put({code: '0x0023'});
        this.put({code: '0x20e3', key: '#⃣', picture: '0x00230x20e3.png'});
        this.put({code: '0xfe0f'});
        this.put({code: '0x20e3', key: '#️⃣', picture: '0x00230x20e3.png'});


        this.put({code: '0x002a'});
        this.put({code: '0x20e3', key: '*⃣', picture: '0x002a0x20e3.png'});
        this.put({code: '0xfe0f'});
        this.put({code: '0x20e3', key: '*️⃣', picture: '0x002a0x20e3.png'});


        this.put({code: '0x0030'});
        this.put({code: '0x20e3', key: '0⃣', picture: '0x00300x20e3.png'});
        this.put({code: '0xfe0f'});
        this.put({code: '0x20e3', key: '0️⃣', picture: '0x00300x20e3.png'});


        this.put({code: '0x0031'});
        this.put({code: '0x20e3', key: '1⃣', picture: '0x00310x20e3.png'});
        this.put({code: '0xfe0f'});
        this.put({code: '0x20e3', key: '1️⃣', picture: '0x00310x20e3.png'});


        this.put({code: '0x0032'});
        this.put({code: '0x20e3', key: '2⃣', picture: '0x00320x20e3.png'});
        this.put({code: '0xfe0f'});
        this.put({code: '0x20e3', key: '2️⃣', picture: '0x00320x20e3.png'});


        this.put({code: '0x0033'});
        this.put({code: '0x20e3', key: '3⃣', picture: '0x00330x20e3.png'});
        this.put({code: '0xfe0f'});
        this.put({code: '0x20e3', key: '3️⃣', picture: '0x00330x20e3.png'});


        this.put({code: '0x0034'});
        this.put({code: '0x20e3', key: '4⃣', picture: '0x00340x20e3.png'});
        this.put({code: '0xfe0f'});
        this.put({code: '0x20e3', key: '4️⃣', picture: '0x00340x20e3.png'});


        this.put({code: '0x0035'});
        this.put({code: '0x20e3', key: '5⃣', picture: '0x00350x20e3.png'});
        this.put({code: '0xfe0f'});
        this.put({code: '0x20e3', key: '5️⃣', picture: '0x00350x20e3.png'});


        this.put({code: '0x0036'});
        this.put({code: '0x20e3', key: '6⃣', picture: '0x00360x20e3.png'});
        this.put({code: '0xfe0f'});
        this.put({code: '0x20e3', key: '6️⃣', picture: '0x00360x20e3.png'});


        this.put({code: '0x0037'});
        this.put({code: '0x20e3', key: '7⃣', picture: '0x00370x20e3.png'});
        this.put({code: '0xfe0f'});
        this.put({code: '0x20e3', key: '7️⃣', picture: '0x00370x20e3.png'});


        this.put({code: '0x0038'});
        this.put({code: '0x20e3', key: '8⃣', picture: '0x00380x20e3.png'});
        this.put({code: '0xfe0f'});
        this.put({code: '0x20e3', key: '8️⃣', picture: '0x00380x20e3.png'});


        this.put({code: '0x0039'});
        this.put({code: '0x20e3', key: '9⃣', picture: '0x00390x20e3.png'});
        this.put({code: '0xfe0f'});
        this.put({code: '0x20e3', key: '9️⃣', picture: '0x00390x20e3.png'});


        this.put({code: '0xd83c'});
        this.put({code: '0xdc04', key: '🀄', picture: '0x1f004.png'});
        this.put({code: '0xdccf', key: '🃏', picture: '0x1f0cf.png'});
        this.put({code: '0xdd70', key: '🅰', picture: '0x1f170.png'});
        this.put({code: '0xfe0f', key: '🅰️', picture: '0x1f170.png'});

        this.put({code: '0xdd71', key: '🅱', picture: '0x1f171.png'});
        this.put({code: '0xfe0f', key: '🅱️', picture: '0x1f171.png'});

        this.put({code: '0xdd7e', key: '🅾', picture: '0x1f17e.png'});
        this.put({code: '0xfe0f', key: '🅾️', picture: '0x1f17e.png'});

        this.put({code: '0xdd7f', key: '🅿', picture: '0x1f17f.png'});
        this.put({code: '0xfe0f', key: '🅿️', picture: '0x1f17f.png'});

        this.put({code: '0xdd8e', key: '🆎', picture: '0x1f18e.png'});
        this.put({code: '0xdd91', key: '🆑', picture: '0x1f191.png'});
        this.put({code: '0xdd92', key: '🆒', picture: '0x1f192.png'});
        this.put({code: '0xdd93', key: '🆓', picture: '0x1f193.png'});
        this.put({code: '0xdd94', key: '🆔', picture: '0x1f194.png'});
        this.put({code: '0xdd95', key: '🆕', picture: '0x1f195.png'});
        this.put({code: '0xdd96', key: '🆖', picture: '0x1f196.png'});
        this.put({code: '0xdd97', key: '🆗', picture: '0x1f197.png'});
        this.put({code: '0xdd98', key: '🆘', picture: '0x1f198.png'});
        this.put({code: '0xdd99', key: '🆙', picture: '0x1f199.png'});
        this.put({code: '0xdd9a', key: '🆚', picture: '0x1f19a.png'});
        this.put({code: '0xde01', key: '🈁', picture: '0x1f201.png'});
        this.put({code: '0xde02', key: '🈂', picture: '0x1f202.png'});
        this.put({code: '0xfe0f', key: '🈂️', picture: '0x1f202.png'});

        this.put({code: '0xde1a', key: '🈚', picture: '0x1f21a.png'});
        this.put({code: '0xde2f', key: '🈯', picture: '0x1f22f.png'});
        this.put({code: '0xde32', key: '🈲', picture: '0x1f232.png'});
        this.put({code: '0xde33', key: '🈳', picture: '0x1f233.png'});
        this.put({code: '0xde34', key: '🈴', picture: '0x1f234.png'});
        this.put({code: '0xde35', key: '🈵', picture: '0x1f235.png'});
        this.put({code: '0xde36', key: '🈶', picture: '0x1f236.png'});
        this.put({code: '0xde37', key: '🈷', picture: '0x1f237.png'});
        this.put({code: '0xfe0f', key: '🈷️', picture: '0x1f237.png'});

        this.put({code: '0xde38', key: '🈸', picture: '0x1f238.png'});
        this.put({code: '0xde39', key: '🈹', picture: '0x1f239.png'});
        this.put({code: '0xde3a', key: '🈺', picture: '0x1f23a.png'});
        this.put({code: '0xde50', key: '🉐', picture: '0x1f250.png'});
        this.put({code: '0xde51', key: '🉑', picture: '0x1f251.png'});
        this.put({code: '0xdf00', key: '🌀', picture: '0x1f300.png'});
        this.put({code: '0xdf01', key: '🌁', picture: '0x1f301.png'});
        this.put({code: '0xdf02', key: '🌂', picture: '0x1f302.png'});
        this.put({code: '0xdf03', key: '🌃', picture: '0x1f303.png'});
        this.put({code: '0xdf04', key: '🌄', picture: '0x1f304.png'});
        this.put({code: '0xdf05', key: '🌅', picture: '0x1f305.png'});
        this.put({code: '0xdf06', key: '🌆', picture: '0x1f306.png'});
        this.put({code: '0xdf07', key: '🌇', picture: '0x1f307.png'});
        this.put({code: '0xdf08', key: '🌈', picture: '0x1f308.png'});
        this.put({code: '0xdf09', key: '🌉', picture: '0x1f309.png'});
        this.put({code: '0xdf0a', key: '🌊', picture: '0x1f30a.png'});
        this.put({code: '0xdf0b', key: '🌋', picture: '0x1f30b.png'});
        this.put({code: '0xdf0c', key: '🌌', picture: '0x1f30c.png'});
        this.put({code: '0xdf0d', key: '🌍', picture: '0x1f30d.png'});
        this.put({code: '0xdf0e', key: '🌎', picture: '0x1f30e.png'});
        this.put({code: '0xdf0f', key: '🌏', picture: '0x1f30f.png'});
        this.put({code: '0xdf10', key: '🌐', picture: '0x1f310.png'});
        this.put({code: '0xdf11', key: '🌑', picture: '0x1f311.png'});
        this.put({code: '0xdf12', key: '🌒', picture: '0x1f312.png'});
        this.put({code: '0xdf13', key: '🌓', picture: '0x1f313.png'});
        this.put({code: '0xdf14', key: '🌔', picture: '0x1f314.png'});
        this.put({code: '0xdf15', key: '🌕', picture: '0x1f315.png'});
        this.put({code: '0xdf16', key: '🌖', picture: '0x1f316.png'});
        this.put({code: '0xdf17', key: '🌗', picture: '0x1f317.png'});
        this.put({code: '0xdf18', key: '🌘', picture: '0x1f318.png'});
        this.put({code: '0xdf19', key: '🌙', picture: '0x1f319.png'});
        this.put({code: '0xdf1a', key: '🌚', picture: '0x1f31a.png'});
        this.put({code: '0xdf1b', key: '🌛', picture: '0x1f31b.png'});
        this.put({code: '0xdf1c', key: '🌜', picture: '0x1f31c.png'});
        this.put({code: '0xdf1d', key: '🌝', picture: '0x1f31d.png'});
        this.put({code: '0xdf1e', key: '🌞', picture: '0x1f31e.png'});
        this.put({code: '0xdf1f', key: '🌟', picture: '0x1f31f.png'});
        this.put({code: '0xdf20', key: '🌠', picture: '0x1f320.png'});
        this.put({code: '0xdf21', key: '🌡', picture: '0x1f321.png'});
        this.put({code: '0xfe0f', key: '🌡️', picture: '0x1f321.png'});

        this.put({code: '0xdf24', key: '🌤', picture: '0x1f324.png'});
        this.put({code: '0xfe0f', key: '🌤️', picture: '0x1f324.png'});

        this.put({code: '0xdf25', key: '🌥', picture: '0x1f325.png'});
        this.put({code: '0xfe0f', key: '🌥️', picture: '0x1f325.png'});

        this.put({code: '0xdf26', key: '🌦', picture: '0x1f326.png'});
        this.put({code: '0xfe0f', key: '🌦️', picture: '0x1f326.png'});

        this.put({code: '0xdf27', key: '🌧', picture: '0x1f327.png'});
        this.put({code: '0xfe0f', key: '🌧️', picture: '0x1f327.png'});

        this.put({code: '0xdf28', key: '🌨', picture: '0x1f328.png'});
        this.put({code: '0xfe0f', key: '🌨️', picture: '0x1f328.png'});

        this.put({code: '0xdf29', key: '🌩', picture: '0x1f329.png'});
        this.put({code: '0xfe0f', key: '🌩️', picture: '0x1f329.png'});

        this.put({code: '0xdf2a', key: '🌪', picture: '0x1f32a.png'});
        this.put({code: '0xfe0f', key: '🌪️', picture: '0x1f32a.png'});

        this.put({code: '0xdf2b', key: '🌫', picture: '0x1f32b.png'});
        this.put({code: '0xfe0f', key: '🌫️', picture: '0x1f32b.png'});

        this.put({code: '0xdf2c', key: '🌬', picture: '0x1f32c.png'});
        this.put({code: '0xfe0f', key: '🌬️', picture: '0x1f32c.png'});

        this.put({code: '0xdf2d', key: '🌭', picture: '0x1f32d.png'});
        this.put({code: '0xdf2e', key: '🌮', picture: '0x1f32e.png'});
        this.put({code: '0xdf2f', key: '🌯', picture: '0x1f32f.png'});
        this.put({code: '0xdf30', key: '🌰', picture: '0x1f330.png'});
        this.put({code: '0xdf31', key: '🌱', picture: '0x1f331.png'});
        this.put({code: '0xdf32', key: '🌲', picture: '0x1f332.png'});
        this.put({code: '0xdf33', key: '🌳', picture: '0x1f333.png'});
        this.put({code: '0xdf34', key: '🌴', picture: '0x1f334.png'});
        this.put({code: '0xdf35', key: '🌵', picture: '0x1f335.png'});
        this.put({code: '0xdf36', key: '🌶', picture: '0x1f336.png'});
        this.put({code: '0xfe0f', key: '🌶️', picture: '0x1f336.png'});

        this.put({code: '0xdf37', key: '🌷', picture: '0x1f337.png'});
        this.put({code: '0xdf38', key: '🌸', picture: '0x1f338.png'});
        this.put({code: '0xdf39', key: '🌹', picture: '0x1f339.png'});
        this.put({code: '0xdf3a', key: '🌺', picture: '0x1f33a.png'});
        this.put({code: '0xdf3b', key: '🌻', picture: '0x1f33b.png'});
        this.put({code: '0xdf3c', key: '🌼', picture: '0x1f33c.png'});
        this.put({code: '0xdf3d', key: '🌽', picture: '0x1f33d.png'});
        this.put({code: '0xdf3e', key: '🌾', picture: '0x1f33e.png'});
        this.put({code: '0xdf3f', key: '🌿', picture: '0x1f33f.png'});
        this.put({code: '0xdf40', key: '🍀', picture: '0x1f340.png'});
        this.put({code: '0xdf41', key: '🍁', picture: '0x1f341.png'});
        this.put({code: '0xdf42', key: '🍂', picture: '0x1f342.png'});
        this.put({code: '0xdf43', key: '🍃', picture: '0x1f343.png'});
        this.put({code: '0xdf44', key: '🍄', picture: '0x1f344.png'});
        this.put({code: '0xdf45', key: '🍅', picture: '0x1f345.png'});
        this.put({code: '0xdf46', key: '🍆', picture: '0x1f346.png'});
        this.put({code: '0xdf47', key: '🍇', picture: '0x1f347.png'});
        this.put({code: '0xdf48', key: '🍈', picture: '0x1f348.png'});
        this.put({code: '0xdf49', key: '🍉', picture: '0x1f349.png'});
        this.put({code: '0xdf4a', key: '🍊', picture: '0x1f34a.png'});
        this.put({code: '0xdf4b', key: '🍋', picture: '0x1f34b.png'});
        this.put({code: '0xdf4c', key: '🍌', picture: '0x1f34c.png'});
        this.put({code: '0xdf4d', key: '🍍', picture: '0x1f34d.png'});
        this.put({code: '0xdf4e', key: '🍎', picture: '0x1f34e.png'});
        this.put({code: '0xdf4f', key: '🍏', picture: '0x1f34f.png'});
        this.put({code: '0xdf50', key: '🍐', picture: '0x1f350.png'});
        this.put({code: '0xdf51', key: '🍑', picture: '0x1f351.png'});
        this.put({code: '0xdf52', key: '🍒', picture: '0x1f352.png'});
        this.put({code: '0xdf53', key: '🍓', picture: '0x1f353.png'});
        this.put({code: '0xdf54', key: '🍔', picture: '0x1f354.png'});
        this.put({code: '0xdf55', key: '🍕', picture: '0x1f355.png'});
        this.put({code: '0xdf56', key: '🍖', picture: '0x1f356.png'});
        this.put({code: '0xdf57', key: '🍗', picture: '0x1f357.png'});
        this.put({code: '0xdf58', key: '🍘', picture: '0x1f358.png'});
        this.put({code: '0xdf59', key: '🍙', picture: '0x1f359.png'});
        this.put({code: '0xdf5a', key: '🍚', picture: '0x1f35a.png'});
        this.put({code: '0xdf5b', key: '🍛', picture: '0x1f35b.png'});
        this.put({code: '0xdf5c', key: '🍜', picture: '0x1f35c.png'});
        this.put({code: '0xdf5d', key: '🍝', picture: '0x1f35d.png'});
        this.put({code: '0xdf5e', key: '🍞', picture: '0x1f35e.png'});
        this.put({code: '0xdf5f', key: '🍟', picture: '0x1f35f.png'});
        this.put({code: '0xdf60', key: '🍠', picture: '0x1f360.png'});
        this.put({code: '0xdf61', key: '🍡', picture: '0x1f361.png'});
        this.put({code: '0xdf62', key: '🍢', picture: '0x1f362.png'});
        this.put({code: '0xdf63', key: '🍣', picture: '0x1f363.png'});
        this.put({code: '0xdf64', key: '🍤', picture: '0x1f364.png'});
        this.put({code: '0xdf65', key: '🍥', picture: '0x1f365.png'});
        this.put({code: '0xdf66', key: '🍦', picture: '0x1f366.png'});
        this.put({code: '0xdf67', key: '🍧', picture: '0x1f367.png'});
        this.put({code: '0xdf68', key: '🍨', picture: '0x1f368.png'});
        this.put({code: '0xdf69', key: '🍩', picture: '0x1f369.png'});
        this.put({code: '0xdf6a', key: '🍪', picture: '0x1f36a.png'});
        this.put({code: '0xdf6b', key: '🍫', picture: '0x1f36b.png'});
        this.put({code: '0xdf6c', key: '🍬', picture: '0x1f36c.png'});
        this.put({code: '0xdf6d', key: '🍭', picture: '0x1f36d.png'});
        this.put({code: '0xdf6e', key: '🍮', picture: '0x1f36e.png'});
        this.put({code: '0xdf6f', key: '🍯', picture: '0x1f36f.png'});
        this.put({code: '0xdf70', key: '🍰', picture: '0x1f370.png'});
        this.put({code: '0xdf71', key: '🍱', picture: '0x1f371.png'});
        this.put({code: '0xdf72', key: '🍲', picture: '0x1f372.png'});
        this.put({code: '0xdf73', key: '🍳', picture: '0x1f373.png'});
        this.put({code: '0xdf74', key: '🍴', picture: '0x1f374.png'});
        this.put({code: '0xdf75', key: '🍵', picture: '0x1f375.png'});
        this.put({code: '0xdf76', key: '🍶', picture: '0x1f376.png'});
        this.put({code: '0xdf77', key: '🍷', picture: '0x1f377.png'});
        this.put({code: '0xdf78', key: '🍸', picture: '0x1f378.png'});
        this.put({code: '0xdf79', key: '🍹', picture: '0x1f379.png'});
        this.put({code: '0xdf7a', key: '🍺', picture: '0x1f37a.png'});
        this.put({code: '0xdf7b', key: '🍻', picture: '0x1f37b.png'});
        this.put({code: '0xdf7c', key: '🍼', picture: '0x1f37c.png'});
        this.put({code: '0xdf7d', key: '🍽', picture: '0x1f37d.png'});
        this.put({code: '0xfe0f', key: '🍽️', picture: '0x1f37d.png'});

        this.put({code: '0xdf7e', key: '🍾', picture: '0x1f37e.png'});
        this.put({code: '0xdf7f', key: '🍿', picture: '0x1f37f.png'});
        this.put({code: '0xdf80', key: '🎀', picture: '0x1f380.png'});
        this.put({code: '0xdf81', key: '🎁', picture: '0x1f381.png'});
        this.put({code: '0xdf82', key: '🎂', picture: '0x1f382.png'});
        this.put({code: '0xdf83', key: '🎃', picture: '0x1f383.png'});
        this.put({code: '0xdf84', key: '🎄', picture: '0x1f384.png'});
        this.put({code: '0xdf85', key: '🎅', picture: '0x1f385.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🎅🏻', picture: '0x1f3850x1f3fb.png'});
        this.put({code: '0xdffc', key: '🎅🏼', picture: '0x1f3850x1f3fc.png'});
        this.put({code: '0xdffd', key: '🎅🏽', picture: '0x1f3850x1f3fd.png'});
        this.put({code: '0xdffe', key: '🎅🏾', picture: '0x1f3850x1f3fe.png'});
        this.put({code: '0xdfff', key: '🎅🏿', picture: '0x1f3850x1f3ff.png'});


        this.put({code: '0xdf86', key: '🎆', picture: '0x1f386.png'});
        this.put({code: '0xdf87', key: '🎇', picture: '0x1f387.png'});
        this.put({code: '0xdf88', key: '🎈', picture: '0x1f388.png'});
        this.put({code: '0xdf89', key: '🎉', picture: '0x1f389.png'});
        this.put({code: '0xdf8a', key: '🎊', picture: '0x1f38a.png'});
        this.put({code: '0xdf8b', key: '🎋', picture: '0x1f38b.png'});
        this.put({code: '0xdf8c', key: '🎌', picture: '0x1f38c.png'});
        this.put({code: '0xdf8d', key: '🎍', picture: '0x1f38d.png'});
        this.put({code: '0xdf8e', key: '🎎', picture: '0x1f38e.png'});
        this.put({code: '0xdf8f', key: '🎏', picture: '0x1f38f.png'});
        this.put({code: '0xdf90', key: '🎐', picture: '0x1f390.png'});
        this.put({code: '0xdf91', key: '🎑', picture: '0x1f391.png'});
        this.put({code: '0xdf92', key: '🎒', picture: '0x1f392.png'});
        this.put({code: '0xdf93', key: '🎓', picture: '0x1f393.png'});
        this.put({code: '0xdf96', key: '🎖', picture: '0x1f396.png'});
        this.put({code: '0xfe0f', key: '🎖️', picture: '0x1f396.png'});

        this.put({code: '0xdf97', key: '🎗', picture: '0x1f397.png'});
        this.put({code: '0xfe0f', key: '🎗️', picture: '0x1f397.png'});

        this.put({code: '0xdf99', key: '🎙', picture: '0x1f399.png'});
        this.put({code: '0xfe0f', key: '🎙️', picture: '0x1f399.png'});

        this.put({code: '0xdf9a', key: '🎚', picture: '0x1f39a.png'});
        this.put({code: '0xfe0f', key: '🎚️', picture: '0x1f39a.png'});

        this.put({code: '0xdf9b', key: '🎛', picture: '0x1f39b.png'});
        this.put({code: '0xfe0f', key: '🎛️', picture: '0x1f39b.png'});

        this.put({code: '0xdf9e', key: '🎞', picture: '0x1f39e.png'});
        this.put({code: '0xfe0f', key: '🎞️', picture: '0x1f39e.png'});

        this.put({code: '0xdf9f', key: '🎟', picture: '0x1f39f.png'});
        this.put({code: '0xfe0f', key: '🎟️', picture: '0x1f39f.png'});

        this.put({code: '0xdfa0', key: '🎠', picture: '0x1f3a0.png'});
        this.put({code: '0xdfa1', key: '🎡', picture: '0x1f3a1.png'});
        this.put({code: '0xdfa2', key: '🎢', picture: '0x1f3a2.png'});
        this.put({code: '0xdfa3', key: '🎣', picture: '0x1f3a3.png'});
        this.put({code: '0xdfa4', key: '🎤', picture: '0x1f3a4.png'});
        this.put({code: '0xdfa5', key: '🎥', picture: '0x1f3a5.png'});
        this.put({code: '0xdfa6', key: '🎦', picture: '0x1f3a6.png'});
        this.put({code: '0xdfa7', key: '🎧', picture: '0x1f3a7.png'});
        this.put({code: '0xdfa8', key: '🎨', picture: '0x1f3a8.png'});
        this.put({code: '0xdfa9', key: '🎩', picture: '0x1f3a9.png'});
        this.put({code: '0xdfaa', key: '🎪', picture: '0x1f3aa.png'});
        this.put({code: '0xdfab', key: '🎫', picture: '0x1f3ab.png'});
        this.put({code: '0xdfac', key: '🎬', picture: '0x1f3ac.png'});
        this.put({code: '0xdfad', key: '🎭', picture: '0x1f3ad.png'});
        this.put({code: '0xdfae', key: '🎮', picture: '0x1f3ae.png'});
        this.put({code: '0xdfaf', key: '🎯', picture: '0x1f3af.png'});
        this.put({code: '0xdfb0', key: '🎰', picture: '0x1f3b0.png'});
        this.put({code: '0xdfb1', key: '🎱', picture: '0x1f3b1.png'});
        this.put({code: '0xdfb2', key: '🎲', picture: '0x1f3b2.png'});
        this.put({code: '0xdfb3', key: '🎳', picture: '0x1f3b3.png'});
        this.put({code: '0xdfb4', key: '🎴', picture: '0x1f3b4.png'});
        this.put({code: '0xdfb5', key: '🎵', picture: '0x1f3b5.png'});
        this.put({code: '0xdfb6', key: '🎶', picture: '0x1f3b6.png'});
        this.put({code: '0xdfb7', key: '🎷', picture: '0x1f3b7.png'});
        this.put({code: '0xdfb8', key: '🎸', picture: '0x1f3b8.png'});
        this.put({code: '0xdfb9', key: '🎹', picture: '0x1f3b9.png'});
        this.put({code: '0xdfba', key: '🎺', picture: '0x1f3ba.png'});
        this.put({code: '0xdfbb', key: '🎻', picture: '0x1f3bb.png'});
        this.put({code: '0xdfbc', key: '🎼', picture: '0x1f3bc.png'});
        this.put({code: '0xdfbd', key: '🎽', picture: '0x1f3bd.png'});
        this.put({code: '0xdfbe', key: '🎾', picture: '0x1f3be.png'});
        this.put({code: '0xdfbf', key: '🎿', picture: '0x1f3bf.png'});
        this.put({code: '0xdfc0', key: '🏀', picture: '0x1f3c0.png'});
        this.put({code: '0xdfc1', key: '🏁', picture: '0x1f3c1.png'});
        this.put({code: '0xdfc2', key: '🏂', picture: '0x1f3c2.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🏂🏻', picture: '0x1f3c20x1f3fb.png'});
        this.put({code: '0xdffc', key: '🏂🏼', picture: '0x1f3c20x1f3fc.png'});
        this.put({code: '0xdffd', key: '🏂🏽', picture: '0x1f3c20x1f3fd.png'});
        this.put({code: '0xdffe', key: '🏂🏾', picture: '0x1f3c20x1f3fe.png'});
        this.put({code: '0xdfff', key: '🏂🏿', picture: '0x1f3c20x1f3ff.png'});


        this.put({code: '0xdfc3', key: '🏃', picture: '0x1f3c3.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🏃‍♀', picture: '0x1f3c30x2640.png'});
        this.put({code: '0xfe0f', key: '🏃‍♀️', picture: '0x1f3c30x2640.png'});

        this.put({code: '0x2642', key: '🏃‍♂', picture: '0x1f3c30x2642.png'});
        this.put({code: '0xfe0f', key: '🏃‍♂️', picture: '0x1f3c30x2642.png'});


        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🏃🏻', picture: '0x1f3c30x1f3fb.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🏃🏻‍♀', picture: '0x1f3c30x1f3fb0x2640.png'});
        this.put({code: '0xfe0f', key: '🏃🏻‍♀️', picture: '0x1f3c30x1f3fb0x2640.png'});

        this.put({code: '0x2642', key: '🏃🏻‍♂', picture: '0x1f3c30x1f3fb0x2642.png'});
        this.put({code: '0xfe0f', key: '🏃🏻‍♂️', picture: '0x1f3c30x1f3fb0x2642.png'});


        this.put({code: '0xdffc', key: '🏃🏼', picture: '0x1f3c30x1f3fc.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🏃🏼‍♀', picture: '0x1f3c30x1f3fc0x2640.png'});
        this.put({code: '0xfe0f', key: '🏃🏼‍♀️', picture: '0x1f3c30x1f3fc0x2640.png'});

        this.put({code: '0x2642', key: '🏃🏼‍♂', picture: '0x1f3c30x1f3fc0x2642.png'});
        this.put({code: '0xfe0f', key: '🏃🏼‍♂️', picture: '0x1f3c30x1f3fc0x2642.png'});


        this.put({code: '0xdffd', key: '🏃🏽', picture: '0x1f3c30x1f3fd.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🏃🏽‍♀', picture: '0x1f3c30x1f3fd0x2640.png'});
        this.put({code: '0xfe0f', key: '🏃🏽‍♀️', picture: '0x1f3c30x1f3fd0x2640.png'});

        this.put({code: '0x2642', key: '🏃🏽‍♂', picture: '0x1f3c30x1f3fd0x2642.png'});
        this.put({code: '0xfe0f', key: '🏃🏽‍♂️', picture: '0x1f3c30x1f3fd0x2642.png'});


        this.put({code: '0xdffe', key: '🏃🏾', picture: '0x1f3c30x1f3fe.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🏃🏾‍♀', picture: '0x1f3c30x1f3fe0x2640.png'});
        this.put({code: '0xfe0f', key: '🏃🏾‍♀️', picture: '0x1f3c30x1f3fe0x2640.png'});

        this.put({code: '0x2642', key: '🏃🏾‍♂', picture: '0x1f3c30x1f3fe0x2642.png'});
        this.put({code: '0xfe0f', key: '🏃🏾‍♂️', picture: '0x1f3c30x1f3fe0x2642.png'});


        this.put({code: '0xdfff', key: '🏃🏿', picture: '0x1f3c30x1f3ff.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🏃🏿‍♀', picture: '0x1f3c30x1f3ff0x2640.png'});
        this.put({code: '0xfe0f', key: '🏃🏿‍♀️', picture: '0x1f3c30x1f3ff0x2640.png'});

        this.put({code: '0x2642', key: '🏃🏿‍♂', picture: '0x1f3c30x1f3ff0x2642.png'});
        this.put({code: '0xfe0f', key: '🏃🏿‍♂️', picture: '0x1f3c30x1f3ff0x2642.png'});


        this.put({code: '0xdfc4', key: '🏄', picture: '0x1f3c4.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🏄‍♀', picture: '0x1f3c40x2640.png'});
        this.put({code: '0xfe0f', key: '🏄‍♀️', picture: '0x1f3c40x2640.png'});

        this.put({code: '0x2642', key: '🏄‍♂', picture: '0x1f3c40x2642.png'});
        this.put({code: '0xfe0f', key: '🏄‍♂️', picture: '0x1f3c40x2642.png'});


        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🏄🏻', picture: '0x1f3c40x1f3fb.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🏄🏻‍♀', picture: '0x1f3c40x1f3fb0x2640.png'});
        this.put({code: '0xfe0f', key: '🏄🏻‍♀️', picture: '0x1f3c40x1f3fb0x2640.png'});

        this.put({code: '0x2642', key: '🏄🏻‍♂', picture: '0x1f3c40x1f3fb0x2642.png'});
        this.put({code: '0xfe0f', key: '🏄🏻‍♂️', picture: '0x1f3c40x1f3fb0x2642.png'});


        this.put({code: '0xdffc', key: '🏄🏼', picture: '0x1f3c40x1f3fc.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🏄🏼‍♀', picture: '0x1f3c40x1f3fc0x2640.png'});
        this.put({code: '0xfe0f', key: '🏄🏼‍♀️', picture: '0x1f3c40x1f3fc0x2640.png'});

        this.put({code: '0x2642', key: '🏄🏼‍♂', picture: '0x1f3c40x1f3fc0x2642.png'});
        this.put({code: '0xfe0f', key: '🏄🏼‍♂️', picture: '0x1f3c40x1f3fc0x2642.png'});


        this.put({code: '0xdffd', key: '🏄🏽', picture: '0x1f3c40x1f3fd.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🏄🏽‍♀', picture: '0x1f3c40x1f3fd0x2640.png'});
        this.put({code: '0xfe0f', key: '🏄🏽‍♀️', picture: '0x1f3c40x1f3fd0x2640.png'});

        this.put({code: '0x2642', key: '🏄🏽‍♂', picture: '0x1f3c40x1f3fd0x2642.png'});
        this.put({code: '0xfe0f', key: '🏄🏽‍♂️', picture: '0x1f3c40x1f3fd0x2642.png'});


        this.put({code: '0xdffe', key: '🏄🏾', picture: '0x1f3c40x1f3fe.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🏄🏾‍♀', picture: '0x1f3c40x1f3fe0x2640.png'});
        this.put({code: '0xfe0f', key: '🏄🏾‍♀️', picture: '0x1f3c40x1f3fe0x2640.png'});

        this.put({code: '0x2642', key: '🏄🏾‍♂', picture: '0x1f3c40x1f3fe0x2642.png'});
        this.put({code: '0xfe0f', key: '🏄🏾‍♂️', picture: '0x1f3c40x1f3fe0x2642.png'});


        this.put({code: '0xdfff', key: '🏄🏿', picture: '0x1f3c40x1f3ff.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🏄🏿‍♀', picture: '0x1f3c40x1f3ff0x2640.png'});
        this.put({code: '0xfe0f', key: '🏄🏿‍♀️', picture: '0x1f3c40x1f3ff0x2640.png'});

        this.put({code: '0x2642', key: '🏄🏿‍♂', picture: '0x1f3c40x1f3ff0x2642.png'});
        this.put({code: '0xfe0f', key: '🏄🏿‍♂️', picture: '0x1f3c40x1f3ff0x2642.png'});


        this.put({code: '0xdfc5', key: '🏅', picture: '0x1f3c5.png'});
        this.put({code: '0xdfc6', key: '🏆', picture: '0x1f3c6.png'});
        this.put({code: '0xdfc7', key: '🏇', picture: '0x1f3c7.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🏇🏻', picture: '0x1f3c70x1f3fb.png'});
        this.put({code: '0xdffc', key: '🏇🏼', picture: '0x1f3c70x1f3fc.png'});
        this.put({code: '0xdffd', key: '🏇🏽', picture: '0x1f3c70x1f3fd.png'});
        this.put({code: '0xdffe', key: '🏇🏾', picture: '0x1f3c70x1f3fe.png'});
        this.put({code: '0xdfff', key: '🏇🏿', picture: '0x1f3c70x1f3ff.png'});


        this.put({code: '0xdfc8', key: '🏈', picture: '0x1f3c8.png'});
        this.put({code: '0xdfc9', key: '🏉', picture: '0x1f3c9.png'});
        this.put({code: '0xdfca', key: '🏊', picture: '0x1f3ca.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🏊‍♀', picture: '0x1f3ca0x2640.png'});
        this.put({code: '0xfe0f', key: '🏊‍♀️', picture: '0x1f3ca0x2640.png'});

        this.put({code: '0x2642', key: '🏊‍♂', picture: '0x1f3ca0x2642.png'});
        this.put({code: '0xfe0f', key: '🏊‍♂️', picture: '0x1f3ca0x2642.png'});


        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🏊🏻', picture: '0x1f3ca0x1f3fb.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🏊🏻‍♀', picture: '0x1f3ca0x1f3fb0x2640.png'});
        this.put({code: '0xfe0f', key: '🏊🏻‍♀️', picture: '0x1f3ca0x1f3fb0x2640.png'});

        this.put({code: '0x2642', key: '🏊🏻‍♂', picture: '0x1f3ca0x1f3fb0x2642.png'});
        this.put({code: '0xfe0f', key: '🏊🏻‍♂️', picture: '0x1f3ca0x1f3fb0x2642.png'});


        this.put({code: '0xdffc', key: '🏊🏼', picture: '0x1f3ca0x1f3fc.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🏊🏼‍♀', picture: '0x1f3ca0x1f3fc0x2640.png'});
        this.put({code: '0xfe0f', key: '🏊🏼‍♀️', picture: '0x1f3ca0x1f3fc0x2640.png'});

        this.put({code: '0x2642', key: '🏊🏼‍♂', picture: '0x1f3ca0x1f3fc0x2642.png'});
        this.put({code: '0xfe0f', key: '🏊🏼‍♂️', picture: '0x1f3ca0x1f3fc0x2642.png'});


        this.put({code: '0xdffd', key: '🏊🏽', picture: '0x1f3ca0x1f3fd.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🏊🏽‍♀', picture: '0x1f3ca0x1f3fd0x2640.png'});
        this.put({code: '0xfe0f', key: '🏊🏽‍♀️', picture: '0x1f3ca0x1f3fd0x2640.png'});

        this.put({code: '0x2642', key: '🏊🏽‍♂', picture: '0x1f3ca0x1f3fd0x2642.png'});
        this.put({code: '0xfe0f', key: '🏊🏽‍♂️', picture: '0x1f3ca0x1f3fd0x2642.png'});


        this.put({code: '0xdffe', key: '🏊🏾', picture: '0x1f3ca0x1f3fe.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🏊🏾‍♀', picture: '0x1f3ca0x1f3fe0x2640.png'});
        this.put({code: '0xfe0f', key: '🏊🏾‍♀️', picture: '0x1f3ca0x1f3fe0x2640.png'});

        this.put({code: '0x2642', key: '🏊🏾‍♂', picture: '0x1f3ca0x1f3fe0x2642.png'});
        this.put({code: '0xfe0f', key: '🏊🏾‍♂️', picture: '0x1f3ca0x1f3fe0x2642.png'});


        this.put({code: '0xdfff', key: '🏊🏿', picture: '0x1f3ca0x1f3ff.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🏊🏿‍♀', picture: '0x1f3ca0x1f3ff0x2640.png'});
        this.put({code: '0xfe0f', key: '🏊🏿‍♀️', picture: '0x1f3ca0x1f3ff0x2640.png'});

        this.put({code: '0x2642', key: '🏊🏿‍♂', picture: '0x1f3ca0x1f3ff0x2642.png'});
        this.put({code: '0xfe0f', key: '🏊🏿‍♂️', picture: '0x1f3ca0x1f3ff0x2642.png'});


        this.put({code: '0xdfcb', key: '🏋', picture: '0x1f3cb.png'});
        this.put({code: '0xfe0f', key: '🏋️', picture: '0x1f3cb.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640'});
        this.put({code: '0xfe0f', key: '🏋️‍♀️', picture: '0x1f3cb0x2640.png'});

        this.put({code: '0x2642'});
        this.put({code: '0xfe0f', key: '🏋️‍♂️', picture: '0x1f3cb0x2642.png'});


        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🏋‍♀', picture: '0x1f3cb0x2640.png'});
        this.put({code: '0x2642', key: '🏋‍♂', picture: '0x1f3cb0x2642.png'});

        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🏋🏻', picture: '0x1f3cb0x1f3fb.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🏋🏻‍♀', picture: '0x1f3cb0x1f3fb0x2640.png'});
        this.put({code: '0xfe0f', key: '🏋🏻‍♀️', picture: '0x1f3cb0x1f3fb0x2640.png'});

        this.put({code: '0x2642', key: '🏋🏻‍♂', picture: '0x1f3cb0x1f3fb0x2642.png'});
        this.put({code: '0xfe0f', key: '🏋🏻‍♂️', picture: '0x1f3cb0x1f3fb0x2642.png'});


        this.put({code: '0xdffc', key: '🏋🏼', picture: '0x1f3cb0x1f3fc.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🏋🏼‍♀', picture: '0x1f3cb0x1f3fc0x2640.png'});
        this.put({code: '0xfe0f', key: '🏋🏼‍♀️', picture: '0x1f3cb0x1f3fc0x2640.png'});

        this.put({code: '0x2642', key: '🏋🏼‍♂', picture: '0x1f3cb0x1f3fc0x2642.png'});
        this.put({code: '0xfe0f', key: '🏋🏼‍♂️', picture: '0x1f3cb0x1f3fc0x2642.png'});


        this.put({code: '0xdffd', key: '🏋🏽', picture: '0x1f3cb0x1f3fd.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🏋🏽‍♀', picture: '0x1f3cb0x1f3fd0x2640.png'});
        this.put({code: '0xfe0f', key: '🏋🏽‍♀️', picture: '0x1f3cb0x1f3fd0x2640.png'});

        this.put({code: '0x2642', key: '🏋🏽‍♂', picture: '0x1f3cb0x1f3fd0x2642.png'});
        this.put({code: '0xfe0f', key: '🏋🏽‍♂️', picture: '0x1f3cb0x1f3fd0x2642.png'});


        this.put({code: '0xdffe', key: '🏋🏾', picture: '0x1f3cb0x1f3fe.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🏋🏾‍♀', picture: '0x1f3cb0x1f3fe0x2640.png'});
        this.put({code: '0xfe0f', key: '🏋🏾‍♀️', picture: '0x1f3cb0x1f3fe0x2640.png'});

        this.put({code: '0x2642', key: '🏋🏾‍♂', picture: '0x1f3cb0x1f3fe0x2642.png'});
        this.put({code: '0xfe0f', key: '🏋🏾‍♂️', picture: '0x1f3cb0x1f3fe0x2642.png'});


        this.put({code: '0xdfff', key: '🏋🏿', picture: '0x1f3cb0x1f3ff.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🏋🏿‍♀', picture: '0x1f3cb0x1f3ff0x2640.png'});
        this.put({code: '0xfe0f', key: '🏋🏿‍♀️', picture: '0x1f3cb0x1f3ff0x2640.png'});

        this.put({code: '0x2642', key: '🏋🏿‍♂', picture: '0x1f3cb0x1f3ff0x2642.png'});
        this.put({code: '0xfe0f', key: '🏋🏿‍♂️', picture: '0x1f3cb0x1f3ff0x2642.png'});


        this.put({code: '0xdfcc', key: '🏌', picture: '0x1f3cc.png'});
        this.put({code: '0xfe0f', key: '🏌️', picture: '0x1f3cc.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640'});
        this.put({code: '0xfe0f', key: '🏌️‍♀️', picture: '0x1f3cc0x2640.png'});

        this.put({code: '0x2642'});
        this.put({code: '0xfe0f', key: '🏌️‍♂️', picture: '0x1f3cc0x2642.png'});


        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🏌‍♀', picture: '0x1f3cc0x2640.png'});
        this.put({code: '0x2642', key: '🏌‍♂', picture: '0x1f3cc0x2642.png'});

        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🏌🏻', picture: '0x1f3cc0x1f3fb.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🏌🏻‍♀', picture: '0x1f3cc0x1f3fb0x2640.png'});
        this.put({code: '0xfe0f', key: '🏌🏻‍♀️', picture: '0x1f3cc0x1f3fb0x2640.png'});

        this.put({code: '0x2642', key: '🏌🏻‍♂', picture: '0x1f3cc0x1f3fb0x2642.png'});
        this.put({code: '0xfe0f', key: '🏌🏻‍♂️', picture: '0x1f3cc0x1f3fb0x2642.png'});


        this.put({code: '0xdffc', key: '🏌🏼', picture: '0x1f3cc0x1f3fc.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🏌🏼‍♀', picture: '0x1f3cc0x1f3fc0x2640.png'});
        this.put({code: '0xfe0f', key: '🏌🏼‍♀️', picture: '0x1f3cc0x1f3fc0x2640.png'});

        this.put({code: '0x2642', key: '🏌🏼‍♂', picture: '0x1f3cc0x1f3fc0x2642.png'});
        this.put({code: '0xfe0f', key: '🏌🏼‍♂️', picture: '0x1f3cc0x1f3fc0x2642.png'});


        this.put({code: '0xdffd', key: '🏌🏽', picture: '0x1f3cc0x1f3fd.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🏌🏽‍♀', picture: '0x1f3cc0x1f3fd0x2640.png'});
        this.put({code: '0xfe0f', key: '🏌🏽‍♀️', picture: '0x1f3cc0x1f3fd0x2640.png'});

        this.put({code: '0x2642', key: '🏌🏽‍♂', picture: '0x1f3cc0x1f3fd0x2642.png'});
        this.put({code: '0xfe0f', key: '🏌🏽‍♂️', picture: '0x1f3cc0x1f3fd0x2642.png'});


        this.put({code: '0xdffe', key: '🏌🏾', picture: '0x1f3cc0x1f3fe.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🏌🏾‍♀', picture: '0x1f3cc0x1f3fe0x2640.png'});
        this.put({code: '0xfe0f', key: '🏌🏾‍♀️', picture: '0x1f3cc0x1f3fe0x2640.png'});

        this.put({code: '0x2642', key: '🏌🏾‍♂', picture: '0x1f3cc0x1f3fe0x2642.png'});
        this.put({code: '0xfe0f', key: '🏌🏾‍♂️', picture: '0x1f3cc0x1f3fe0x2642.png'});


        this.put({code: '0xdfff', key: '🏌🏿', picture: '0x1f3cc0x1f3ff.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🏌🏿‍♀', picture: '0x1f3cc0x1f3ff0x2640.png'});
        this.put({code: '0xfe0f', key: '🏌🏿‍♀️', picture: '0x1f3cc0x1f3ff0x2640.png'});

        this.put({code: '0x2642', key: '🏌🏿‍♂', picture: '0x1f3cc0x1f3ff0x2642.png'});
        this.put({code: '0xfe0f', key: '🏌🏿‍♂️', picture: '0x1f3cc0x1f3ff0x2642.png'});


        this.put({code: '0xdfcd', key: '🏍', picture: '0x1f3cd.png'});
        this.put({code: '0xfe0f', key: '🏍️', picture: '0x1f3cd.png'});

        this.put({code: '0xdfce', key: '🏎', picture: '0x1f3ce.png'});
        this.put({code: '0xfe0f', key: '🏎️', picture: '0x1f3ce.png'});

        this.put({code: '0xdfcf', key: '🏏', picture: '0x1f3cf.png'});
        this.put({code: '0xdfd0', key: '🏐', picture: '0x1f3d0.png'});
        this.put({code: '0xdfd1', key: '🏑', picture: '0x1f3d1.png'});
        this.put({code: '0xdfd2', key: '🏒', picture: '0x1f3d2.png'});
        this.put({code: '0xdfd3', key: '🏓', picture: '0x1f3d3.png'});
        this.put({code: '0xdfd4', key: '🏔', picture: '0x1f3d4.png'});
        this.put({code: '0xfe0f', key: '🏔️', picture: '0x1f3d4.png'});

        this.put({code: '0xdfd5', key: '🏕', picture: '0x1f3d5.png'});
        this.put({code: '0xfe0f', key: '🏕️', picture: '0x1f3d5.png'});

        this.put({code: '0xdfd6', key: '🏖', picture: '0x1f3d6.png'});
        this.put({code: '0xfe0f', key: '🏖️', picture: '0x1f3d6.png'});

        this.put({code: '0xdfd7', key: '🏗', picture: '0x1f3d7.png'});
        this.put({code: '0xfe0f', key: '🏗️', picture: '0x1f3d7.png'});

        this.put({code: '0xdfd8', key: '🏘', picture: '0x1f3d8.png'});
        this.put({code: '0xfe0f', key: '🏘️', picture: '0x1f3d8.png'});

        this.put({code: '0xdfd9', key: '🏙', picture: '0x1f3d9.png'});
        this.put({code: '0xfe0f', key: '🏙️', picture: '0x1f3d9.png'});

        this.put({code: '0xdfda', key: '🏚', picture: '0x1f3da.png'});
        this.put({code: '0xfe0f', key: '🏚️', picture: '0x1f3da.png'});

        this.put({code: '0xdfdb', key: '🏛', picture: '0x1f3db.png'});
        this.put({code: '0xfe0f', key: '🏛️', picture: '0x1f3db.png'});

        this.put({code: '0xdfdc', key: '🏜', picture: '0x1f3dc.png'});
        this.put({code: '0xfe0f', key: '🏜️', picture: '0x1f3dc.png'});

        this.put({code: '0xdfdd', key: '🏝', picture: '0x1f3dd.png'});
        this.put({code: '0xfe0f', key: '🏝️', picture: '0x1f3dd.png'});

        this.put({code: '0xdfde', key: '🏞', picture: '0x1f3de.png'});
        this.put({code: '0xfe0f', key: '🏞️', picture: '0x1f3de.png'});

        this.put({code: '0xdfdf', key: '🏟', picture: '0x1f3df.png'});
        this.put({code: '0xfe0f', key: '🏟️', picture: '0x1f3df.png'});

        this.put({code: '0xdfe0', key: '🏠', picture: '0x1f3e0.png'});
        this.put({code: '0xdfe1', key: '🏡', picture: '0x1f3e1.png'});
        this.put({code: '0xdfe2', key: '🏢', picture: '0x1f3e2.png'});
        this.put({code: '0xdfe3', key: '🏣', picture: '0x1f3e3.png'});
        this.put({code: '0xdfe4', key: '🏤', picture: '0x1f3e4.png'});
        this.put({code: '0xdfe5', key: '🏥', picture: '0x1f3e5.png'});
        this.put({code: '0xdfe6', key: '🏦', picture: '0x1f3e6.png'});
        this.put({code: '0xdfe7', key: '🏧', picture: '0x1f3e7.png'});
        this.put({code: '0xdfe8', key: '🏨', picture: '0x1f3e8.png'});
        this.put({code: '0xdfe9', key: '🏩', picture: '0x1f3e9.png'});
        this.put({code: '0xdfea', key: '🏪', picture: '0x1f3ea.png'});
        this.put({code: '0xdfeb', key: '🏫', picture: '0x1f3eb.png'});
        this.put({code: '0xdfec', key: '🏬', picture: '0x1f3ec.png'});
        this.put({code: '0xdfed', key: '🏭', picture: '0x1f3ed.png'});
        this.put({code: '0xdfee', key: '🏮', picture: '0x1f3ee.png'});
        this.put({code: '0xdfef', key: '🏯', picture: '0x1f3ef.png'});
        this.put({code: '0xdff0', key: '🏰', picture: '0x1f3f0.png'});
        this.put({code: '0xdff3', key: '🏳', picture: '0x1f3f3.png'});
        this.put({code: '0xfe0f', key: '🏳️', picture: '0x1f3f3.png'});
        this.put({code: '0x200d'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdf08', key: '🏳️‍🌈', picture: '0x1f3f30x1f308.png'});


        this.put({code: '0x200d'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdf08', key: '🏳‍🌈', picture: '0x1f3f30x1f308.png'});


        this.put({code: '0xdff4', key: '🏴', picture: '0x1f3f4.png'});
        this.put({code: '0xdff5', key: '🏵', picture: '0x1f3f5.png'});
        this.put({code: '0xfe0f', key: '🏵️', picture: '0x1f3f5.png'});

        this.put({code: '0xdff7', key: '🏷', picture: '0x1f3f7.png'});
        this.put({code: '0xfe0f', key: '🏷️', picture: '0x1f3f7.png'});

        this.put({code: '0xdff8', key: '🏸', picture: '0x1f3f8.png'});
        this.put({code: '0xdff9', key: '🏹', picture: '0x1f3f9.png'});
        this.put({code: '0xdffa', key: '🏺', picture: '0x1f3fa.png'});
        this.put({code: '0xdffb', key: '🏻', picture: '0x1f3fb.png'});
        this.put({code: '0xdffc', key: '🏼', picture: '0x1f3fc.png'});
        this.put({code: '0xdffd', key: '🏽', picture: '0x1f3fd.png'});
        this.put({code: '0xdffe', key: '🏾', picture: '0x1f3fe.png'});
        this.put({code: '0xdfff', key: '🏿', picture: '0x1f3ff.png'});
        this.put({code: '0xdde6'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdde8', key: '🇦🇨', picture: '0x1f1e60x1f1e8.png'});
        this.put({code: '0xdde9', key: '🇦🇩', picture: '0x1f1e60x1f1e9.png'});
        this.put({code: '0xddea', key: '🇦🇪', picture: '0x1f1e60x1f1ea.png'});
        this.put({code: '0xddeb', key: '🇦🇫', picture: '0x1f1e60x1f1eb.png'});
        this.put({code: '0xddec', key: '🇦🇬', picture: '0x1f1e60x1f1ec.png'});
        this.put({code: '0xddee', key: '🇦🇮', picture: '0x1f1e60x1f1ee.png'});
        this.put({code: '0xddf1', key: '🇦🇱', picture: '0x1f1e60x1f1f1.png'});
        this.put({code: '0xddf2', key: '🇦🇲', picture: '0x1f1e60x1f1f2.png'});
        this.put({code: '0xddf4', key: '🇦🇴', picture: '0x1f1e60x1f1f4.png'});
        this.put({code: '0xddf6', key: '🇦🇶', picture: '0x1f1e60x1f1f6.png'});
        this.put({code: '0xddf7', key: '🇦🇷', picture: '0x1f1e60x1f1f7.png'});
        this.put({code: '0xddf8', key: '🇦🇸', picture: '0x1f1e60x1f1f8.png'});
        this.put({code: '0xddf9', key: '🇦🇹', picture: '0x1f1e60x1f1f9.png'});
        this.put({code: '0xddfa', key: '🇦🇺', picture: '0x1f1e60x1f1fa.png'});
        this.put({code: '0xddfc', key: '🇦🇼', picture: '0x1f1e60x1f1fc.png'});
        this.put({code: '0xddfd', key: '🇦🇽', picture: '0x1f1e60x1f1fd.png'});
        this.put({code: '0xddff', key: '🇦🇿', picture: '0x1f1e60x1f1ff.png'});


        this.put({code: '0xdde7'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdde6', key: '🇧🇦', picture: '0x1f1e70x1f1e6.png'});
        this.put({code: '0xdde7', key: '🇧🇧', picture: '0x1f1e70x1f1e7.png'});
        this.put({code: '0xdde9', key: '🇧🇩', picture: '0x1f1e70x1f1e9.png'});
        this.put({code: '0xddea', key: '🇧🇪', picture: '0x1f1e70x1f1ea.png'});
        this.put({code: '0xddeb', key: '🇧🇫', picture: '0x1f1e70x1f1eb.png'});
        this.put({code: '0xddec', key: '🇧🇬', picture: '0x1f1e70x1f1ec.png'});
        this.put({code: '0xdded', key: '🇧🇭', picture: '0x1f1e70x1f1ed.png'});
        this.put({code: '0xddee', key: '🇧🇮', picture: '0x1f1e70x1f1ee.png'});
        this.put({code: '0xddef', key: '🇧🇯', picture: '0x1f1e70x1f1ef.png'});
        this.put({code: '0xddf1', key: '🇧🇱', picture: '0x1f1e70x1f1f1.png'});
        this.put({code: '0xddf2', key: '🇧🇲', picture: '0x1f1e70x1f1f2.png'});
        this.put({code: '0xddf3', key: '🇧🇳', picture: '0x1f1e70x1f1f3.png'});
        this.put({code: '0xddf4', key: '🇧🇴', picture: '0x1f1e70x1f1f4.png'});
        this.put({code: '0xddf6', key: '🇧🇶', picture: '0x1f1e70x1f1f6.png'});
        this.put({code: '0xddf7', key: '🇧🇷', picture: '0x1f1e70x1f1f7.png'});
        this.put({code: '0xddf8', key: '🇧🇸', picture: '0x1f1e70x1f1f8.png'});
        this.put({code: '0xddf9', key: '🇧🇹', picture: '0x1f1e70x1f1f9.png'});
        this.put({code: '0xddfb', key: '🇧🇻', picture: '0x1f1e70x1f1fb.png'});
        this.put({code: '0xddfc', key: '🇧🇼', picture: '0x1f1e70x1f1fc.png'});
        this.put({code: '0xddfe', key: '🇧🇾', picture: '0x1f1e70x1f1fe.png'});
        this.put({code: '0xddff', key: '🇧🇿', picture: '0x1f1e70x1f1ff.png'});


        this.put({code: '0xdde8'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdde6', key: '🇨🇦', picture: '0x1f1e80x1f1e6.png'});
        this.put({code: '0xdde8', key: '🇨🇨', picture: '0x1f1e80x1f1e8.png'});
        this.put({code: '0xdde9', key: '🇨🇩', picture: '0x1f1e80x1f1e9.png'});
        this.put({code: '0xddeb', key: '🇨🇫', picture: '0x1f1e80x1f1eb.png'});
        this.put({code: '0xddec', key: '🇨🇬', picture: '0x1f1e80x1f1ec.png'});
        this.put({code: '0xdded', key: '🇨🇭', picture: '0x1f1e80x1f1ed.png'});
        this.put({code: '0xddee', key: '🇨🇮', picture: '0x1f1e80x1f1ee.png'});
        this.put({code: '0xddf0', key: '🇨🇰', picture: '0x1f1e80x1f1f0.png'});
        this.put({code: '0xddf1', key: '🇨🇱', picture: '0x1f1e80x1f1f1.png'});
        this.put({code: '0xddf2', key: '🇨🇲', picture: '0x1f1e80x1f1f2.png'});
        this.put({code: '0xddf3', key: '🇨🇳', picture: '0x1f1e80x1f1f3.png'});
        this.put({code: '0xddf4', key: '🇨🇴', picture: '0x1f1e80x1f1f4.png'});
        this.put({code: '0xddf5', key: '🇨🇵', picture: '0x1f1e80x1f1f5.png'});
        this.put({code: '0xddf7', key: '🇨🇷', picture: '0x1f1e80x1f1f7.png'});
        this.put({code: '0xddfa', key: '🇨🇺', picture: '0x1f1e80x1f1fa.png'});
        this.put({code: '0xddfb', key: '🇨🇻', picture: '0x1f1e80x1f1fb.png'});
        this.put({code: '0xddfc', key: '🇨🇼', picture: '0x1f1e80x1f1fc.png'});
        this.put({code: '0xddfd', key: '🇨🇽', picture: '0x1f1e80x1f1fd.png'});
        this.put({code: '0xddfe', key: '🇨🇾', picture: '0x1f1e80x1f1fe.png'});
        this.put({code: '0xddff', key: '🇨🇿', picture: '0x1f1e80x1f1ff.png'});


        this.put({code: '0xdde9'});
        this.put({code: '0xd83c'});
        this.put({code: '0xddea', key: '🇩🇪', picture: '0x1f1e90x1f1ea.png'});
        this.put({code: '0xddec', key: '🇩🇬', picture: '0x1f1e90x1f1ec.png'});
        this.put({code: '0xddef', key: '🇩🇯', picture: '0x1f1e90x1f1ef.png'});
        this.put({code: '0xddf0', key: '🇩🇰', picture: '0x1f1e90x1f1f0.png'});
        this.put({code: '0xddf2', key: '🇩🇲', picture: '0x1f1e90x1f1f2.png'});
        this.put({code: '0xddf4', key: '🇩🇴', picture: '0x1f1e90x1f1f4.png'});
        this.put({code: '0xddff', key: '🇩🇿', picture: '0x1f1e90x1f1ff.png'});


        this.put({code: '0xddea'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdde6', key: '🇪🇦', picture: '0x1f1ea0x1f1e6.png'});
        this.put({code: '0xdde8', key: '🇪🇨', picture: '0x1f1ea0x1f1e8.png'});
        this.put({code: '0xddea', key: '🇪🇪', picture: '0x1f1ea0x1f1ea.png'});
        this.put({code: '0xddec', key: '🇪🇬', picture: '0x1f1ea0x1f1ec.png'});
        this.put({code: '0xdded', key: '🇪🇭', picture: '0x1f1ea0x1f1ed.png'});
        this.put({code: '0xddf7', key: '🇪🇷', picture: '0x1f1ea0x1f1f7.png'});
        this.put({code: '0xddf8', key: '🇪🇸', picture: '0x1f1ea0x1f1f8.png'});
        this.put({code: '0xddf9', key: '🇪🇹', picture: '0x1f1ea0x1f1f9.png'});
        this.put({code: '0xddfa', key: '🇪🇺', picture: '0x1f1ea0x1f1fa.png'});


        this.put({code: '0xddeb'});
        this.put({code: '0xd83c'});
        this.put({code: '0xddee', key: '🇫🇮', picture: '0x1f1eb0x1f1ee.png'});
        this.put({code: '0xddef', key: '🇫🇯', picture: '0x1f1eb0x1f1ef.png'});
        this.put({code: '0xddf0', key: '🇫🇰', picture: '0x1f1eb0x1f1f0.png'});
        this.put({code: '0xddf2', key: '🇫🇲', picture: '0x1f1eb0x1f1f2.png'});
        this.put({code: '0xddf4', key: '🇫🇴', picture: '0x1f1eb0x1f1f4.png'});
        this.put({code: '0xddf7', key: '🇫🇷', picture: '0x1f1eb0x1f1f7.png'});


        this.put({code: '0xddec'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdde6', key: '🇬🇦', picture: '0x1f1ec0x1f1e6.png'});
        this.put({code: '0xdde7', key: '🇬🇧', picture: '0x1f1ec0x1f1e7.png'});
        this.put({code: '0xdde9', key: '🇬🇩', picture: '0x1f1ec0x1f1e9.png'});
        this.put({code: '0xddea', key: '🇬🇪', picture: '0x1f1ec0x1f1ea.png'});
        this.put({code: '0xddeb', key: '🇬🇫', picture: '0x1f1ec0x1f1eb.png'});
        this.put({code: '0xddec', key: '🇬🇬', picture: '0x1f1ec0x1f1ec.png'});
        this.put({code: '0xdded', key: '🇬🇭', picture: '0x1f1ec0x1f1ed.png'});
        this.put({code: '0xddee', key: '🇬🇮', picture: '0x1f1ec0x1f1ee.png'});
        this.put({code: '0xddf1', key: '🇬🇱', picture: '0x1f1ec0x1f1f1.png'});
        this.put({code: '0xddf2', key: '🇬🇲', picture: '0x1f1ec0x1f1f2.png'});
        this.put({code: '0xddf3', key: '🇬🇳', picture: '0x1f1ec0x1f1f3.png'});
        this.put({code: '0xddf5', key: '🇬🇵', picture: '0x1f1ec0x1f1f5.png'});
        this.put({code: '0xddf6', key: '🇬🇶', picture: '0x1f1ec0x1f1f6.png'});
        this.put({code: '0xddf7', key: '🇬🇷', picture: '0x1f1ec0x1f1f7.png'});
        this.put({code: '0xddf8', key: '🇬🇸', picture: '0x1f1ec0x1f1f8.png'});
        this.put({code: '0xddf9', key: '🇬🇹', picture: '0x1f1ec0x1f1f9.png'});
        this.put({code: '0xddfa', key: '🇬🇺', picture: '0x1f1ec0x1f1fa.png'});
        this.put({code: '0xddfc', key: '🇬🇼', picture: '0x1f1ec0x1f1fc.png'});
        this.put({code: '0xddfe', key: '🇬🇾', picture: '0x1f1ec0x1f1fe.png'});


        this.put({code: '0xdded'});
        this.put({code: '0xd83c'});
        this.put({code: '0xddf0', key: '🇭🇰', picture: '0x1f1ed0x1f1f0.png'});
        this.put({code: '0xddf2', key: '🇭🇲', picture: '0x1f1ed0x1f1f2.png'});
        this.put({code: '0xddf3', key: '🇭🇳', picture: '0x1f1ed0x1f1f3.png'});
        this.put({code: '0xddf7', key: '🇭🇷', picture: '0x1f1ed0x1f1f7.png'});
        this.put({code: '0xddf9', key: '🇭🇹', picture: '0x1f1ed0x1f1f9.png'});
        this.put({code: '0xddfa', key: '🇭🇺', picture: '0x1f1ed0x1f1fa.png'});


        this.put({code: '0xddee'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdde8', key: '🇮🇨', picture: '0x1f1ee0x1f1e8.png'});
        this.put({code: '0xdde9', key: '🇮🇩', picture: '0x1f1ee0x1f1e9.png'});
        this.put({code: '0xddea', key: '🇮🇪', picture: '0x1f1ee0x1f1ea.png'});
        this.put({code: '0xddf1', key: '🇮🇱', picture: '0x1f1ee0x1f1f1.png'});
        this.put({code: '0xddf2', key: '🇮🇲', picture: '0x1f1ee0x1f1f2.png'});
        this.put({code: '0xddf3', key: '🇮🇳', picture: '0x1f1ee0x1f1f3.png'});
        this.put({code: '0xddf4', key: '🇮🇴', picture: '0x1f1ee0x1f1f4.png'});
        this.put({code: '0xddf6', key: '🇮🇶', picture: '0x1f1ee0x1f1f6.png'});
        this.put({code: '0xddf7', key: '🇮🇷', picture: '0x1f1ee0x1f1f7.png'});
        this.put({code: '0xddf8', key: '🇮🇸', picture: '0x1f1ee0x1f1f8.png'});
        this.put({code: '0xddf9', key: '🇮🇹', picture: '0x1f1ee0x1f1f9.png'});


        this.put({code: '0xddef'});
        this.put({code: '0xd83c'});
        this.put({code: '0xddea', key: '🇯🇪', picture: '0x1f1ef0x1f1ea.png'});
        this.put({code: '0xddf2', key: '🇯🇲', picture: '0x1f1ef0x1f1f2.png'});
        this.put({code: '0xddf4', key: '🇯🇴', picture: '0x1f1ef0x1f1f4.png'});
        this.put({code: '0xddf5', key: '🇯🇵', picture: '0x1f1ef0x1f1f5.png'});


        this.put({code: '0xddf0'});
        this.put({code: '0xd83c'});
        this.put({code: '0xddea', key: '🇰🇪', picture: '0x1f1f00x1f1ea.png'});
        this.put({code: '0xddec', key: '🇰🇬', picture: '0x1f1f00x1f1ec.png'});
        this.put({code: '0xdded', key: '🇰🇭', picture: '0x1f1f00x1f1ed.png'});
        this.put({code: '0xddee', key: '🇰🇮', picture: '0x1f1f00x1f1ee.png'});
        this.put({code: '0xddf2', key: '🇰🇲', picture: '0x1f1f00x1f1f2.png'});
        this.put({code: '0xddf3', key: '🇰🇳', picture: '0x1f1f00x1f1f3.png'});
        this.put({code: '0xddf5', key: '🇰🇵', picture: '0x1f1f00x1f1f5.png'});
        this.put({code: '0xddf7', key: '🇰🇷', picture: '0x1f1f00x1f1f7.png'});
        this.put({code: '0xddfc', key: '🇰🇼', picture: '0x1f1f00x1f1fc.png'});
        this.put({code: '0xddfe', key: '🇰🇾', picture: '0x1f1f00x1f1fe.png'});
        this.put({code: '0xddff', key: '🇰🇿', picture: '0x1f1f00x1f1ff.png'});


        this.put({code: '0xddf1'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdde6', key: '🇱🇦', picture: '0x1f1f10x1f1e6.png'});
        this.put({code: '0xdde7', key: '🇱🇧', picture: '0x1f1f10x1f1e7.png'});
        this.put({code: '0xdde8', key: '🇱🇨', picture: '0x1f1f10x1f1e8.png'});
        this.put({code: '0xddee', key: '🇱🇮', picture: '0x1f1f10x1f1ee.png'});
        this.put({code: '0xddf0', key: '🇱🇰', picture: '0x1f1f10x1f1f0.png'});
        this.put({code: '0xddf7', key: '🇱🇷', picture: '0x1f1f10x1f1f7.png'});
        this.put({code: '0xddf8', key: '🇱🇸', picture: '0x1f1f10x1f1f8.png'});
        this.put({code: '0xddf9', key: '🇱🇹', picture: '0x1f1f10x1f1f9.png'});
        this.put({code: '0xddfa', key: '🇱🇺', picture: '0x1f1f10x1f1fa.png'});
        this.put({code: '0xddfb', key: '🇱🇻', picture: '0x1f1f10x1f1fb.png'});
        this.put({code: '0xddfe', key: '🇱🇾', picture: '0x1f1f10x1f1fe.png'});


        this.put({code: '0xddf2'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdde6', key: '🇲🇦', picture: '0x1f1f20x1f1e6.png'});
        this.put({code: '0xdde8', key: '🇲🇨', picture: '0x1f1f20x1f1e8.png'});
        this.put({code: '0xdde9', key: '🇲🇩', picture: '0x1f1f20x1f1e9.png'});
        this.put({code: '0xddea', key: '🇲🇪', picture: '0x1f1f20x1f1ea.png'});
        this.put({code: '0xddeb', key: '🇲🇫', picture: '0x1f1f20x1f1eb.png'});
        this.put({code: '0xddec', key: '🇲🇬', picture: '0x1f1f20x1f1ec.png'});
        this.put({code: '0xdded', key: '🇲🇭', picture: '0x1f1f20x1f1ed.png'});
        this.put({code: '0xddf0', key: '🇲🇰', picture: '0x1f1f20x1f1f0.png'});
        this.put({code: '0xddf1', key: '🇲🇱', picture: '0x1f1f20x1f1f1.png'});
        this.put({code: '0xddf2', key: '🇲🇲', picture: '0x1f1f20x1f1f2.png'});
        this.put({code: '0xddf3', key: '🇲🇳', picture: '0x1f1f20x1f1f3.png'});
        this.put({code: '0xddf4', key: '🇲🇴', picture: '0x1f1f20x1f1f4.png'});
        this.put({code: '0xddf5', key: '🇲🇵', picture: '0x1f1f20x1f1f5.png'});
        this.put({code: '0xddf6', key: '🇲🇶', picture: '0x1f1f20x1f1f6.png'});
        this.put({code: '0xddf7', key: '🇲🇷', picture: '0x1f1f20x1f1f7.png'});
        this.put({code: '0xddf8', key: '🇲🇸', picture: '0x1f1f20x1f1f8.png'});
        this.put({code: '0xddf9', key: '🇲🇹', picture: '0x1f1f20x1f1f9.png'});
        this.put({code: '0xddfa', key: '🇲🇺', picture: '0x1f1f20x1f1fa.png'});
        this.put({code: '0xddfb', key: '🇲🇻', picture: '0x1f1f20x1f1fb.png'});
        this.put({code: '0xddfc', key: '🇲🇼', picture: '0x1f1f20x1f1fc.png'});
        this.put({code: '0xddfd', key: '🇲🇽', picture: '0x1f1f20x1f1fd.png'});
        this.put({code: '0xddfe', key: '🇲🇾', picture: '0x1f1f20x1f1fe.png'});
        this.put({code: '0xddff', key: '🇲🇿', picture: '0x1f1f20x1f1ff.png'});


        this.put({code: '0xddf3'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdde6', key: '🇳🇦', picture: '0x1f1f30x1f1e6.png'});
        this.put({code: '0xdde8', key: '🇳🇨', picture: '0x1f1f30x1f1e8.png'});
        this.put({code: '0xddea', key: '🇳🇪', picture: '0x1f1f30x1f1ea.png'});
        this.put({code: '0xddeb', key: '🇳🇫', picture: '0x1f1f30x1f1eb.png'});
        this.put({code: '0xddec', key: '🇳🇬', picture: '0x1f1f30x1f1ec.png'});
        this.put({code: '0xddee', key: '🇳🇮', picture: '0x1f1f30x1f1ee.png'});
        this.put({code: '0xddf1', key: '🇳🇱', picture: '0x1f1f30x1f1f1.png'});
        this.put({code: '0xddf4', key: '🇳🇴', picture: '0x1f1f30x1f1f4.png'});
        this.put({code: '0xddf5', key: '🇳🇵', picture: '0x1f1f30x1f1f5.png'});
        this.put({code: '0xddf7', key: '🇳🇷', picture: '0x1f1f30x1f1f7.png'});
        this.put({code: '0xddfa', key: '🇳🇺', picture: '0x1f1f30x1f1fa.png'});
        this.put({code: '0xddff', key: '🇳🇿', picture: '0x1f1f30x1f1ff.png'});


        this.put({code: '0xddf4'});
        this.put({code: '0xd83c'});
        this.put({code: '0xddf2', key: '🇴🇲', picture: '0x1f1f40x1f1f2.png'});


        this.put({code: '0xddf5'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdde6', key: '🇵🇦', picture: '0x1f1f50x1f1e6.png'});
        this.put({code: '0xddea', key: '🇵🇪', picture: '0x1f1f50x1f1ea.png'});
        this.put({code: '0xddeb', key: '🇵🇫', picture: '0x1f1f50x1f1eb.png'});
        this.put({code: '0xddec', key: '🇵🇬', picture: '0x1f1f50x1f1ec.png'});
        this.put({code: '0xdded', key: '🇵🇭', picture: '0x1f1f50x1f1ed.png'});
        this.put({code: '0xddf0', key: '🇵🇰', picture: '0x1f1f50x1f1f0.png'});
        this.put({code: '0xddf1', key: '🇵🇱', picture: '0x1f1f50x1f1f1.png'});
        this.put({code: '0xddf2', key: '🇵🇲', picture: '0x1f1f50x1f1f2.png'});
        this.put({code: '0xddf3', key: '🇵🇳', picture: '0x1f1f50x1f1f3.png'});
        this.put({code: '0xddf7', key: '🇵🇷', picture: '0x1f1f50x1f1f7.png'});
        this.put({code: '0xddf8', key: '🇵🇸', picture: '0x1f1f50x1f1f8.png'});
        this.put({code: '0xddf9', key: '🇵🇹', picture: '0x1f1f50x1f1f9.png'});
        this.put({code: '0xddfc', key: '🇵🇼', picture: '0x1f1f50x1f1fc.png'});
        this.put({code: '0xddfe', key: '🇵🇾', picture: '0x1f1f50x1f1fe.png'});


        this.put({code: '0xddf6'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdde6', key: '🇶🇦', picture: '0x1f1f60x1f1e6.png'});


        this.put({code: '0xddf7'});
        this.put({code: '0xd83c'});
        this.put({code: '0xddea', key: '🇷🇪', picture: '0x1f1f70x1f1ea.png'});
        this.put({code: '0xddf4', key: '🇷🇴', picture: '0x1f1f70x1f1f4.png'});
        this.put({code: '0xddf8', key: '🇷🇸', picture: '0x1f1f70x1f1f8.png'});
        this.put({code: '0xddfa', key: '🇷🇺', picture: '0x1f1f70x1f1fa.png'});
        this.put({code: '0xddfc', key: '🇷🇼', picture: '0x1f1f70x1f1fc.png'});


        this.put({code: '0xddf8'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdde6', key: '🇸🇦', picture: '0x1f1f80x1f1e6.png'});
        this.put({code: '0xdde7', key: '🇸🇧', picture: '0x1f1f80x1f1e7.png'});
        this.put({code: '0xdde8', key: '🇸🇨', picture: '0x1f1f80x1f1e8.png'});
        this.put({code: '0xdde9', key: '🇸🇩', picture: '0x1f1f80x1f1e9.png'});
        this.put({code: '0xddea', key: '🇸🇪', picture: '0x1f1f80x1f1ea.png'});
        this.put({code: '0xddec', key: '🇸🇬', picture: '0x1f1f80x1f1ec.png'});
        this.put({code: '0xdded', key: '🇸🇭', picture: '0x1f1f80x1f1ed.png'});
        this.put({code: '0xddee', key: '🇸🇮', picture: '0x1f1f80x1f1ee.png'});
        this.put({code: '0xddef', key: '🇸🇯', picture: '0x1f1f80x1f1ef.png'});
        this.put({code: '0xddf0', key: '🇸🇰', picture: '0x1f1f80x1f1f0.png'});
        this.put({code: '0xddf1', key: '🇸🇱', picture: '0x1f1f80x1f1f1.png'});
        this.put({code: '0xddf2', key: '🇸🇲', picture: '0x1f1f80x1f1f2.png'});
        this.put({code: '0xddf3', key: '🇸🇳', picture: '0x1f1f80x1f1f3.png'});
        this.put({code: '0xddf4', key: '🇸🇴', picture: '0x1f1f80x1f1f4.png'});
        this.put({code: '0xddf7', key: '🇸🇷', picture: '0x1f1f80x1f1f7.png'});
        this.put({code: '0xddf8', key: '🇸🇸', picture: '0x1f1f80x1f1f8.png'});
        this.put({code: '0xddf9', key: '🇸🇹', picture: '0x1f1f80x1f1f9.png'});
        this.put({code: '0xddfb', key: '🇸🇻', picture: '0x1f1f80x1f1fb.png'});
        this.put({code: '0xddfd', key: '🇸🇽', picture: '0x1f1f80x1f1fd.png'});
        this.put({code: '0xddfe', key: '🇸🇾', picture: '0x1f1f80x1f1fe.png'});
        this.put({code: '0xddff', key: '🇸🇿', picture: '0x1f1f80x1f1ff.png'});


        this.put({code: '0xddf9'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdde6', key: '🇹🇦', picture: '0x1f1f90x1f1e6.png'});
        this.put({code: '0xdde8', key: '🇹🇨', picture: '0x1f1f90x1f1e8.png'});
        this.put({code: '0xdde9', key: '🇹🇩', picture: '0x1f1f90x1f1e9.png'});
        this.put({code: '0xddeb', key: '🇹🇫', picture: '0x1f1f90x1f1eb.png'});
        this.put({code: '0xddec', key: '🇹🇬', picture: '0x1f1f90x1f1ec.png'});
        this.put({code: '0xdded', key: '🇹🇭', picture: '0x1f1f90x1f1ed.png'});
        this.put({code: '0xddef', key: '🇹🇯', picture: '0x1f1f90x1f1ef.png'});
        this.put({code: '0xddf0', key: '🇹🇰', picture: '0x1f1f90x1f1f0.png'});
        this.put({code: '0xddf1', key: '🇹🇱', picture: '0x1f1f90x1f1f1.png'});
        this.put({code: '0xddf2', key: '🇹🇲', picture: '0x1f1f90x1f1f2.png'});
        this.put({code: '0xddf3', key: '🇹🇳', picture: '0x1f1f90x1f1f3.png'});
        this.put({code: '0xddf4', key: '🇹🇴', picture: '0x1f1f90x1f1f4.png'});
        this.put({code: '0xddf7', key: '🇹🇷', picture: '0x1f1f90x1f1f7.png'});
        this.put({code: '0xddf9', key: '🇹🇹', picture: '0x1f1f90x1f1f9.png'});
        this.put({code: '0xddfb', key: '🇹🇻', picture: '0x1f1f90x1f1fb.png'});
        this.put({code: '0xddff', key: '🇹🇿', picture: '0x1f1f90x1f1ff.png'});


        this.put({code: '0xddfa'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdde6', key: '🇺🇦', picture: '0x1f1fa0x1f1e6.png'});
        this.put({code: '0xddec', key: '🇺🇬', picture: '0x1f1fa0x1f1ec.png'});
        this.put({code: '0xddf2', key: '🇺🇲', picture: '0x1f1fa0x1f1f2.png'});
        this.put({code: '0xddf8', key: '🇺🇸', picture: '0x1f1fa0x1f1f8.png'});
        this.put({code: '0xddfe', key: '🇺🇾', picture: '0x1f1fa0x1f1fe.png'});
        this.put({code: '0xddff', key: '🇺🇿', picture: '0x1f1fa0x1f1ff.png'});


        this.put({code: '0xddfb'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdde6', key: '🇻🇦', picture: '0x1f1fb0x1f1e6.png'});
        this.put({code: '0xdde8', key: '🇻🇨', picture: '0x1f1fb0x1f1e8.png'});
        this.put({code: '0xddea', key: '🇻🇪', picture: '0x1f1fb0x1f1ea.png'});
        this.put({code: '0xddec', key: '🇻🇬', picture: '0x1f1fb0x1f1ec.png'});
        this.put({code: '0xddee', key: '🇻🇮', picture: '0x1f1fb0x1f1ee.png'});
        this.put({code: '0xddf3', key: '🇻🇳', picture: '0x1f1fb0x1f1f3.png'});
        this.put({code: '0xddfa', key: '🇻🇺', picture: '0x1f1fb0x1f1fa.png'});


        this.put({code: '0xddfc'});
        this.put({code: '0xd83c'});
        this.put({code: '0xddeb', key: '🇼🇫', picture: '0x1f1fc0x1f1eb.png'});
        this.put({code: '0xddf8', key: '🇼🇸', picture: '0x1f1fc0x1f1f8.png'});


        this.put({code: '0xddfd'});
        this.put({code: '0xd83c'});
        this.put({code: '0xddf0', key: '🇽🇰', picture: '0x1f1fd0x1f1f0.png'});


        this.put({code: '0xddfe'});
        this.put({code: '0xd83c'});
        this.put({code: '0xddea', key: '🇾🇪', picture: '0x1f1fe0x1f1ea.png'});
        this.put({code: '0xddf9', key: '🇾🇹', picture: '0x1f1fe0x1f1f9.png'});


        this.put({code: '0xddff'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdde6', key: '🇿🇦', picture: '0x1f1ff0x1f1e6.png'});
        this.put({code: '0xddf2', key: '🇿🇲', picture: '0x1f1ff0x1f1f2.png'});
        this.put({code: '0xddfc', key: '🇿🇼', picture: '0x1f1ff0x1f1fc.png'});


        this.put({code: '0xd83d'});
        this.put({code: '0xdc00', key: '🐀', picture: '0x1f400.png'});
        this.put({code: '0xdc01', key: '🐁', picture: '0x1f401.png'});
        this.put({code: '0xdc02', key: '🐂', picture: '0x1f402.png'});
        this.put({code: '0xdc03', key: '🐃', picture: '0x1f403.png'});
        this.put({code: '0xdc04', key: '🐄', picture: '0x1f404.png'});
        this.put({code: '0xdc05', key: '🐅', picture: '0x1f405.png'});
        this.put({code: '0xdc06', key: '🐆', picture: '0x1f406.png'});
        this.put({code: '0xdc07', key: '🐇', picture: '0x1f407.png'});
        this.put({code: '0xdc08', key: '🐈', picture: '0x1f408.png'});
        this.put({code: '0xdc09', key: '🐉', picture: '0x1f409.png'});
        this.put({code: '0xdc0a', key: '🐊', picture: '0x1f40a.png'});
        this.put({code: '0xdc0b', key: '🐋', picture: '0x1f40b.png'});
        this.put({code: '0xdc0c', key: '🐌', picture: '0x1f40c.png'});
        this.put({code: '0xdc0d', key: '🐍', picture: '0x1f40d.png'});
        this.put({code: '0xdc0e', key: '🐎', picture: '0x1f40e.png'});
        this.put({code: '0xdc0f', key: '🐏', picture: '0x1f40f.png'});
        this.put({code: '0xdc10', key: '🐐', picture: '0x1f410.png'});
        this.put({code: '0xdc11', key: '🐑', picture: '0x1f411.png'});
        this.put({code: '0xdc12', key: '🐒', picture: '0x1f412.png'});
        this.put({code: '0xdc13', key: '🐓', picture: '0x1f413.png'});
        this.put({code: '0xdc14', key: '🐔', picture: '0x1f414.png'});
        this.put({code: '0xdc15', key: '🐕', picture: '0x1f415.png'});
        this.put({code: '0xdc16', key: '🐖', picture: '0x1f416.png'});
        this.put({code: '0xdc17', key: '🐗', picture: '0x1f417.png'});
        this.put({code: '0xdc18', key: '🐘', picture: '0x1f418.png'});
        this.put({code: '0xdc19', key: '🐙', picture: '0x1f419.png'});
        this.put({code: '0xdc1a', key: '🐚', picture: '0x1f41a.png'});
        this.put({code: '0xdc1b', key: '🐛', picture: '0x1f41b.png'});
        this.put({code: '0xdc1c', key: '🐜', picture: '0x1f41c.png'});
        this.put({code: '0xdc1d', key: '🐝', picture: '0x1f41d.png'});
        this.put({code: '0xdc1e', key: '🐞', picture: '0x1f41e.png'});
        this.put({code: '0xdc1f', key: '🐟', picture: '0x1f41f.png'});
        this.put({code: '0xdc20', key: '🐠', picture: '0x1f420.png'});
        this.put({code: '0xdc21', key: '🐡', picture: '0x1f421.png'});
        this.put({code: '0xdc22', key: '🐢', picture: '0x1f422.png'});
        this.put({code: '0xdc23', key: '🐣', picture: '0x1f423.png'});
        this.put({code: '0xdc24', key: '🐤', picture: '0x1f424.png'});
        this.put({code: '0xdc25', key: '🐥', picture: '0x1f425.png'});
        this.put({code: '0xdc26', key: '🐦', picture: '0x1f426.png'});
        this.put({code: '0xdc27', key: '🐧', picture: '0x1f427.png'});
        this.put({code: '0xdc28', key: '🐨', picture: '0x1f428.png'});
        this.put({code: '0xdc29', key: '🐩', picture: '0x1f429.png'});
        this.put({code: '0xdc2a', key: '🐪', picture: '0x1f42a.png'});
        this.put({code: '0xdc2b', key: '🐫', picture: '0x1f42b.png'});
        this.put({code: '0xdc2c', key: '🐬', picture: '0x1f42c.png'});
        this.put({code: '0xdc2d', key: '🐭', picture: '0x1f42d.png'});
        this.put({code: '0xdc2e', key: '🐮', picture: '0x1f42e.png'});
        this.put({code: '0xdc2f', key: '🐯', picture: '0x1f42f.png'});
        this.put({code: '0xdc30', key: '🐰', picture: '0x1f430.png'});
        this.put({code: '0xdc31', key: '🐱', picture: '0x1f431.png'});
        this.put({code: '0xdc32', key: '🐲', picture: '0x1f432.png'});
        this.put({code: '0xdc33', key: '🐳', picture: '0x1f433.png'});
        this.put({code: '0xdc34', key: '🐴', picture: '0x1f434.png'});
        this.put({code: '0xdc35', key: '🐵', picture: '0x1f435.png'});
        this.put({code: '0xdc36', key: '🐶', picture: '0x1f436.png'});
        this.put({code: '0xdc37', key: '🐷', picture: '0x1f437.png'});
        this.put({code: '0xdc38', key: '🐸', picture: '0x1f438.png'});
        this.put({code: '0xdc39', key: '🐹', picture: '0x1f439.png'});
        this.put({code: '0xdc3a', key: '🐺', picture: '0x1f43a.png'});
        this.put({code: '0xdc3b', key: '🐻', picture: '0x1f43b.png'});
        this.put({code: '0xdc3c', key: '🐼', picture: '0x1f43c.png'});
        this.put({code: '0xdc3d', key: '🐽', picture: '0x1f43d.png'});
        this.put({code: '0xdc3e', key: '🐾', picture: '0x1f43e.png'});
        this.put({code: '0xdc3f', key: '🐿', picture: '0x1f43f.png'});
        this.put({code: '0xfe0f', key: '🐿️', picture: '0x1f43f.png'});

        this.put({code: '0xdc40', key: '👀', picture: '0x1f440.png'});
        this.put({code: '0xdc41', key: '👁', picture: '0x1f441.png'});
        this.put({code: '0xfe0f', key: '👁️', picture: '0x1f441.png'});
        this.put({code: '0x200d'});
        this.put({code: '0xd83d'});
        this.put({code: '0xdde8'});
        this.put({code: '0xfe0f', key: '👁️‍🗨️', picture: '0x1f4410x1f5e8.png'});


        this.put({code: '0x200d'});
        this.put({code: '0xd83d'});
        this.put({code: '0xdde8', key: '👁‍🗨', picture: '0x1f4410x1f5e8.png'});


        this.put({code: '0xdc42', key: '👂', picture: '0x1f442.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '👂🏻', picture: '0x1f4420x1f3fb.png'});
        this.put({code: '0xdffc', key: '👂🏼', picture: '0x1f4420x1f3fc.png'});
        this.put({code: '0xdffd', key: '👂🏽', picture: '0x1f4420x1f3fd.png'});
        this.put({code: '0xdffe', key: '👂🏾', picture: '0x1f4420x1f3fe.png'});
        this.put({code: '0xdfff', key: '👂🏿', picture: '0x1f4420x1f3ff.png'});


        this.put({code: '0xdc43', key: '👃', picture: '0x1f443.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '👃🏻', picture: '0x1f4430x1f3fb.png'});
        this.put({code: '0xdffc', key: '👃🏼', picture: '0x1f4430x1f3fc.png'});
        this.put({code: '0xdffd', key: '👃🏽', picture: '0x1f4430x1f3fd.png'});
        this.put({code: '0xdffe', key: '👃🏾', picture: '0x1f4430x1f3fe.png'});
        this.put({code: '0xdfff', key: '👃🏿', picture: '0x1f4430x1f3ff.png'});


        this.put({code: '0xdc44', key: '👄', picture: '0x1f444.png'});
        this.put({code: '0xdc45', key: '👅', picture: '0x1f445.png'});
        this.put({code: '0xdc46', key: '👆', picture: '0x1f446.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '👆🏻', picture: '0x1f4460x1f3fb.png'});
        this.put({code: '0xdffc', key: '👆🏼', picture: '0x1f4460x1f3fc.png'});
        this.put({code: '0xdffd', key: '👆🏽', picture: '0x1f4460x1f3fd.png'});
        this.put({code: '0xdffe', key: '👆🏾', picture: '0x1f4460x1f3fe.png'});
        this.put({code: '0xdfff', key: '👆🏿', picture: '0x1f4460x1f3ff.png'});


        this.put({code: '0xdc47', key: '👇', picture: '0x1f447.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '👇🏻', picture: '0x1f4470x1f3fb.png'});
        this.put({code: '0xdffc', key: '👇🏼', picture: '0x1f4470x1f3fc.png'});
        this.put({code: '0xdffd', key: '👇🏽', picture: '0x1f4470x1f3fd.png'});
        this.put({code: '0xdffe', key: '👇🏾', picture: '0x1f4470x1f3fe.png'});
        this.put({code: '0xdfff', key: '👇🏿', picture: '0x1f4470x1f3ff.png'});


        this.put({code: '0xdc48', key: '👈', picture: '0x1f448.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '👈🏻', picture: '0x1f4480x1f3fb.png'});
        this.put({code: '0xdffc', key: '👈🏼', picture: '0x1f4480x1f3fc.png'});
        this.put({code: '0xdffd', key: '👈🏽', picture: '0x1f4480x1f3fd.png'});
        this.put({code: '0xdffe', key: '👈🏾', picture: '0x1f4480x1f3fe.png'});
        this.put({code: '0xdfff', key: '👈🏿', picture: '0x1f4480x1f3ff.png'});


        this.put({code: '0xdc49', key: '👉', picture: '0x1f449.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '👉🏻', picture: '0x1f4490x1f3fb.png'});
        this.put({code: '0xdffc', key: '👉🏼', picture: '0x1f4490x1f3fc.png'});
        this.put({code: '0xdffd', key: '👉🏽', picture: '0x1f4490x1f3fd.png'});
        this.put({code: '0xdffe', key: '👉🏾', picture: '0x1f4490x1f3fe.png'});
        this.put({code: '0xdfff', key: '👉🏿', picture: '0x1f4490x1f3ff.png'});


        this.put({code: '0xdc4a', key: '👊', picture: '0x1f44a.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '👊🏻', picture: '0x1f44a0x1f3fb.png'});
        this.put({code: '0xdffc', key: '👊🏼', picture: '0x1f44a0x1f3fc.png'});
        this.put({code: '0xdffd', key: '👊🏽', picture: '0x1f44a0x1f3fd.png'});
        this.put({code: '0xdffe', key: '👊🏾', picture: '0x1f44a0x1f3fe.png'});
        this.put({code: '0xdfff', key: '👊🏿', picture: '0x1f44a0x1f3ff.png'});


        this.put({code: '0xdc4b', key: '👋', picture: '0x1f44b.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '👋🏻', picture: '0x1f44b0x1f3fb.png'});
        this.put({code: '0xdffc', key: '👋🏼', picture: '0x1f44b0x1f3fc.png'});
        this.put({code: '0xdffd', key: '👋🏽', picture: '0x1f44b0x1f3fd.png'});
        this.put({code: '0xdffe', key: '👋🏾', picture: '0x1f44b0x1f3fe.png'});
        this.put({code: '0xdfff', key: '👋🏿', picture: '0x1f44b0x1f3ff.png'});


        this.put({code: '0xdc4c', key: '👌', picture: '0x1f44c.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '👌🏻', picture: '0x1f44c0x1f3fb.png'});
        this.put({code: '0xdffc', key: '👌🏼', picture: '0x1f44c0x1f3fc.png'});
        this.put({code: '0xdffd', key: '👌🏽', picture: '0x1f44c0x1f3fd.png'});
        this.put({code: '0xdffe', key: '👌🏾', picture: '0x1f44c0x1f3fe.png'});
        this.put({code: '0xdfff', key: '👌🏿', picture: '0x1f44c0x1f3ff.png'});


        this.put({code: '0xdc4d', key: '👍', picture: '0x1f44d.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '👍🏻', picture: '0x1f44d0x1f3fb.png'});
        this.put({code: '0xdffc', key: '👍🏼', picture: '0x1f44d0x1f3fc.png'});
        this.put({code: '0xdffd', key: '👍🏽', picture: '0x1f44d0x1f3fd.png'});
        this.put({code: '0xdffe', key: '👍🏾', picture: '0x1f44d0x1f3fe.png'});
        this.put({code: '0xdfff', key: '👍🏿', picture: '0x1f44d0x1f3ff.png'});


        this.put({code: '0xdc4e', key: '👎', picture: '0x1f44e.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '👎🏻', picture: '0x1f44e0x1f3fb.png'});
        this.put({code: '0xdffc', key: '👎🏼', picture: '0x1f44e0x1f3fc.png'});
        this.put({code: '0xdffd', key: '👎🏽', picture: '0x1f44e0x1f3fd.png'});
        this.put({code: '0xdffe', key: '👎🏾', picture: '0x1f44e0x1f3fe.png'});
        this.put({code: '0xdfff', key: '👎🏿', picture: '0x1f44e0x1f3ff.png'});


        this.put({code: '0xdc4f', key: '👏', picture: '0x1f44f.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '👏🏻', picture: '0x1f44f0x1f3fb.png'});
        this.put({code: '0xdffc', key: '👏🏼', picture: '0x1f44f0x1f3fc.png'});
        this.put({code: '0xdffd', key: '👏🏽', picture: '0x1f44f0x1f3fd.png'});
        this.put({code: '0xdffe', key: '👏🏾', picture: '0x1f44f0x1f3fe.png'});
        this.put({code: '0xdfff', key: '👏🏿', picture: '0x1f44f0x1f3ff.png'});


        this.put({code: '0xdc50', key: '👐', picture: '0x1f450.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '👐🏻', picture: '0x1f4500x1f3fb.png'});
        this.put({code: '0xdffc', key: '👐🏼', picture: '0x1f4500x1f3fc.png'});
        this.put({code: '0xdffd', key: '👐🏽', picture: '0x1f4500x1f3fd.png'});
        this.put({code: '0xdffe', key: '👐🏾', picture: '0x1f4500x1f3fe.png'});
        this.put({code: '0xdfff', key: '👐🏿', picture: '0x1f4500x1f3ff.png'});


        this.put({code: '0xdc51', key: '👑', picture: '0x1f451.png'});
        this.put({code: '0xdc52', key: '👒', picture: '0x1f452.png'});
        this.put({code: '0xdc53', key: '👓', picture: '0x1f453.png'});
        this.put({code: '0xdc54', key: '👔', picture: '0x1f454.png'});
        this.put({code: '0xdc55', key: '👕', picture: '0x1f455.png'});
        this.put({code: '0xdc56', key: '👖', picture: '0x1f456.png'});
        this.put({code: '0xdc57', key: '👗', picture: '0x1f457.png'});
        this.put({code: '0xdc58', key: '👘', picture: '0x1f458.png'});
        this.put({code: '0xdc59', key: '👙', picture: '0x1f459.png'});
        this.put({code: '0xdc5a', key: '👚', picture: '0x1f45a.png'});
        this.put({code: '0xdc5b', key: '👛', picture: '0x1f45b.png'});
        this.put({code: '0xdc5c', key: '👜', picture: '0x1f45c.png'});
        this.put({code: '0xdc5d', key: '👝', picture: '0x1f45d.png'});
        this.put({code: '0xdc5e', key: '👞', picture: '0x1f45e.png'});
        this.put({code: '0xdc5f', key: '👟', picture: '0x1f45f.png'});
        this.put({code: '0xdc60', key: '👠', picture: '0x1f460.png'});
        this.put({code: '0xdc61', key: '👡', picture: '0x1f461.png'});
        this.put({code: '0xdc62', key: '👢', picture: '0x1f462.png'});
        this.put({code: '0xdc63', key: '👣', picture: '0x1f463.png'});
        this.put({code: '0xdc64', key: '👤', picture: '0x1f464.png'});
        this.put({code: '0xdc65', key: '👥', picture: '0x1f465.png'});
        this.put({code: '0xdc66', key: '👦', picture: '0x1f466.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '👦🏻', picture: '0x1f4660x1f3fb.png'});
        this.put({code: '0xdffc', key: '👦🏼', picture: '0x1f4660x1f3fc.png'});
        this.put({code: '0xdffd', key: '👦🏽', picture: '0x1f4660x1f3fd.png'});
        this.put({code: '0xdffe', key: '👦🏾', picture: '0x1f4660x1f3fe.png'});
        this.put({code: '0xdfff', key: '👦🏿', picture: '0x1f4660x1f3ff.png'});


        this.put({code: '0xdc67', key: '👧', picture: '0x1f467.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '👧🏻', picture: '0x1f4670x1f3fb.png'});
        this.put({code: '0xdffc', key: '👧🏼', picture: '0x1f4670x1f3fc.png'});
        this.put({code: '0xdffd', key: '👧🏽', picture: '0x1f4670x1f3fd.png'});
        this.put({code: '0xdffe', key: '👧🏾', picture: '0x1f4670x1f3fe.png'});
        this.put({code: '0xdfff', key: '👧🏿', picture: '0x1f4670x1f3ff.png'});


        this.put({code: '0xdc68', key: '👨', picture: '0x1f468.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2695', key: '👨‍⚕', picture: '0x1f4680x2695.png'});
        this.put({code: '0xfe0f', key: '👨‍⚕️', picture: '0x1f4680x2695.png'});

        this.put({code: '0x2696', key: '👨‍⚖', picture: '0x1f4680x2696.png'});
        this.put({code: '0xfe0f', key: '👨‍⚖️', picture: '0x1f4680x2696.png'});

        this.put({code: '0x2708', key: '👨‍✈', picture: '0x1f4680x2708.png'});
        this.put({code: '0xfe0f', key: '👨‍✈️', picture: '0x1f4680x2708.png'});

        this.put({code: '0xd83c'});
        this.put({code: '0xdf3e', key: '👨‍🌾', picture: '0x1f4680x1f33e.png'});
        this.put({code: '0xdf73', key: '👨‍🍳', picture: '0x1f4680x1f373.png'});
        this.put({code: '0xdf93', key: '👨‍🎓', picture: '0x1f4680x1f393.png'});
        this.put({code: '0xdfa4', key: '👨‍🎤', picture: '0x1f4680x1f3a4.png'});
        this.put({code: '0xdfa8', key: '👨‍🎨', picture: '0x1f4680x1f3a8.png'});
        this.put({code: '0xdfeb', key: '👨‍🏫', picture: '0x1f4680x1f3eb.png'});
        this.put({code: '0xdfed', key: '👨‍🏭', picture: '0x1f4680x1f3ed.png'});

        this.put({code: '0xd83d'});
        this.put({code: '0xdc66', key: '👨‍👦', picture: '0x1f4680x1f466.png'});
        this.put({code: '0x200d'});
        this.put({code: '0xd83d'});
        this.put({code: '0xdc66', key: '👨‍👦‍👦', picture: '0x1f4680x1f4660x1f466.png'});


        this.put({code: '0xdc67', key: '👨‍👧', picture: '0x1f4680x1f467.png'});
        this.put({code: '0x200d'});
        this.put({code: '0xd83d'});
        this.put({code: '0xdc66', key: '👨‍👧‍👦', picture: '0x1f4680x1f4670x1f466.png'});
        this.put({code: '0xdc67', key: '👨‍👧‍👧', picture: '0x1f4680x1f4670x1f467.png'});


        this.put({code: '0xdcbb', key: '👨‍💻', picture: '0x1f4680x1f4bb.png'});
        this.put({code: '0xdcbc', key: '👨‍💼', picture: '0x1f4680x1f4bc.png'});
        this.put({code: '0xdd27', key: '👨‍🔧', picture: '0x1f4680x1f527.png'});
        this.put({code: '0xdd2c', key: '👨‍🔬', picture: '0x1f4680x1f52c.png'});
        this.put({code: '0xde80', key: '👨‍🚀', picture: '0x1f4680x1f680.png'});
        this.put({code: '0xde92', key: '👨‍🚒', picture: '0x1f4680x1f692.png'});
        this.put({code: '0xdc68'});
        this.put({code: '0x200d'});
        this.put({code: '0xd83d'});
        this.put({code: '0xdc66', key: '👨‍👨‍👦', picture: '0x1f4680x1f4680x1f466.png'});
        this.put({code: '0x200d'});
        this.put({code: '0xd83d'});
        this.put({code: '0xdc66', key: '👨‍👨‍👦‍👦', picture: '0x1f4680x1f4680x1f4660x1f466.png'});


        this.put({code: '0xdc67', key: '👨‍👨‍👧', picture: '0x1f4680x1f4680x1f467.png'});
        this.put({code: '0x200d'});
        this.put({code: '0xd83d'});
        this.put({code: '0xdc66', key: '👨‍👨‍👧‍👦', picture: '0x1f4680x1f4680x1f4670x1f466.png'});
        this.put({code: '0xdc67', key: '👨‍👨‍👧‍👧', picture: '0x1f4680x1f4680x1f4670x1f467.png'});


        this.put({code: '0xdc69'});
        this.put({code: '0x200d'});
        this.put({code: '0xd83d'});
        this.put({code: '0xdc66', key: '👨‍👩‍👦', picture: '0x1f4680x1f4690x1f466.png'});
        this.put({code: '0x200d'});
        this.put({code: '0xd83d'});
        this.put({code: '0xdc66', key: '👨‍👩‍👦‍👦', picture: '0x1f4680x1f4690x1f4660x1f466.png'});


        this.put({code: '0xdc67', key: '👨‍👩‍👧', picture: '0x1f4680x1f4690x1f467.png'});
        this.put({code: '0x200d'});
        this.put({code: '0xd83d'});
        this.put({code: '0xdc66', key: '👨‍👩‍👧‍👦', picture: '0x1f4680x1f4690x1f4670x1f466.png'});
        this.put({code: '0xdc67', key: '👨‍👩‍👧‍👧', picture: '0x1f4680x1f4690x1f4670x1f467.png'});


        this.put({code: '0x2764'});
        this.put({code: '0x200d'});
        this.put({code: '0xd83d'});
        this.put({code: '0xdc68', key: '👨‍❤‍👨', picture: '0x1f4680x27640x1f468.png'});
        this.put({code: '0xdc8b'});
        this.put({code: '0x200d'});
        this.put({code: '0xd83d'});
        this.put({code: '0xdc68', key: '👨‍❤‍💋‍👨', picture: '0x1f4680x27640x1f48b0x1f468.png'});


        this.put({code: '0xfe0f'});
        this.put({code: '0x200d'});
        this.put({code: '0xd83d'});
        this.put({code: '0xdc68', key: '👨‍❤️‍👨', picture: '0x1f4680x27640x1f468.png'});
        this.put({code: '0xdc8b'});
        this.put({code: '0x200d'});
        this.put({code: '0xd83d'});
        this.put({code: '0xdc68', key: '👨‍❤️‍💋‍👨', picture: '0x1f4680x27640x1f48b0x1f468.png'});


        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '👨🏻', picture: '0x1f4680x1f3fb.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2695', key: '👨🏻‍⚕', picture: '0x1f4680x1f3fb0x2695.png'});
        this.put({code: '0xfe0f', key: '👨🏻‍⚕️', picture: '0x1f4680x1f3fb0x2695.png'});

        this.put({code: '0x2696', key: '👨🏻‍⚖', picture: '0x1f4680x1f3fb0x2696.png'});
        this.put({code: '0xfe0f', key: '👨🏻‍⚖️', picture: '0x1f4680x1f3fb0x2696.png'});

        this.put({code: '0x2708', key: '👨🏻‍✈', picture: '0x1f4680x1f3fb0x2708.png'});
        this.put({code: '0xfe0f', key: '👨🏻‍✈️', picture: '0x1f4680x1f3fb0x2708.png'});

        this.put({code: '0xd83c'});
        this.put({code: '0xdf3e', key: '👨🏻‍🌾', picture: '0x1f4680x1f3fb0x1f33e.png'});
        this.put({code: '0xdf73', key: '👨🏻‍🍳', picture: '0x1f4680x1f3fb0x1f373.png'});
        this.put({code: '0xdf93', key: '👨🏻‍🎓', picture: '0x1f4680x1f3fb0x1f393.png'});
        this.put({code: '0xdfa4', key: '👨🏻‍🎤', picture: '0x1f4680x1f3fb0x1f3a4.png'});
        this.put({code: '0xdfa8', key: '👨🏻‍🎨', picture: '0x1f4680x1f3fb0x1f3a8.png'});
        this.put({code: '0xdfeb', key: '👨🏻‍🏫', picture: '0x1f4680x1f3fb0x1f3eb.png'});
        this.put({code: '0xdfed', key: '👨🏻‍🏭', picture: '0x1f4680x1f3fb0x1f3ed.png'});

        this.put({code: '0xd83d'});
        this.put({code: '0xdcbb', key: '👨🏻‍💻', picture: '0x1f4680x1f3fb0x1f4bb.png'});
        this.put({code: '0xdcbc', key: '👨🏻‍💼', picture: '0x1f4680x1f3fb0x1f4bc.png'});
        this.put({code: '0xdd27', key: '👨🏻‍🔧', picture: '0x1f4680x1f3fb0x1f527.png'});
        this.put({code: '0xdd2c', key: '👨🏻‍🔬', picture: '0x1f4680x1f3fb0x1f52c.png'});
        this.put({code: '0xde80', key: '👨🏻‍🚀', picture: '0x1f4680x1f3fb0x1f680.png'});
        this.put({code: '0xde92', key: '👨🏻‍🚒', picture: '0x1f4680x1f3fb0x1f692.png'});


        this.put({code: '0xdffc', key: '👨🏼', picture: '0x1f4680x1f3fc.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2695', key: '👨🏼‍⚕', picture: '0x1f4680x1f3fc0x2695.png'});
        this.put({code: '0xfe0f', key: '👨🏼‍⚕️', picture: '0x1f4680x1f3fc0x2695.png'});

        this.put({code: '0x2696', key: '👨🏼‍⚖', picture: '0x1f4680x1f3fc0x2696.png'});
        this.put({code: '0xfe0f', key: '👨🏼‍⚖️', picture: '0x1f4680x1f3fc0x2696.png'});

        this.put({code: '0x2708', key: '👨🏼‍✈', picture: '0x1f4680x1f3fc0x2708.png'});
        this.put({code: '0xfe0f', key: '👨🏼‍✈️', picture: '0x1f4680x1f3fc0x2708.png'});

        this.put({code: '0xd83c'});
        this.put({code: '0xdf3e', key: '👨🏼‍🌾', picture: '0x1f4680x1f3fc0x1f33e.png'});
        this.put({code: '0xdf73', key: '👨🏼‍🍳', picture: '0x1f4680x1f3fc0x1f373.png'});
        this.put({code: '0xdf93', key: '👨🏼‍🎓', picture: '0x1f4680x1f3fc0x1f393.png'});
        this.put({code: '0xdfa4', key: '👨🏼‍🎤', picture: '0x1f4680x1f3fc0x1f3a4.png'});
        this.put({code: '0xdfa8', key: '👨🏼‍🎨', picture: '0x1f4680x1f3fc0x1f3a8.png'});
        this.put({code: '0xdfeb', key: '👨🏼‍🏫', picture: '0x1f4680x1f3fc0x1f3eb.png'});
        this.put({code: '0xdfed', key: '👨🏼‍🏭', picture: '0x1f4680x1f3fc0x1f3ed.png'});

        this.put({code: '0xd83d'});
        this.put({code: '0xdcbb', key: '👨🏼‍💻', picture: '0x1f4680x1f3fc0x1f4bb.png'});
        this.put({code: '0xdcbc', key: '👨🏼‍💼', picture: '0x1f4680x1f3fc0x1f4bc.png'});
        this.put({code: '0xdd27', key: '👨🏼‍🔧', picture: '0x1f4680x1f3fc0x1f527.png'});
        this.put({code: '0xdd2c', key: '👨🏼‍🔬', picture: '0x1f4680x1f3fc0x1f52c.png'});
        this.put({code: '0xde80', key: '👨🏼‍🚀', picture: '0x1f4680x1f3fc0x1f680.png'});
        this.put({code: '0xde92', key: '👨🏼‍🚒', picture: '0x1f4680x1f3fc0x1f692.png'});


        this.put({code: '0xdffd', key: '👨🏽', picture: '0x1f4680x1f3fd.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2695', key: '👨🏽‍⚕', picture: '0x1f4680x1f3fd0x2695.png'});
        this.put({code: '0xfe0f', key: '👨🏽‍⚕️', picture: '0x1f4680x1f3fd0x2695.png'});

        this.put({code: '0x2696', key: '👨🏽‍⚖', picture: '0x1f4680x1f3fd0x2696.png'});
        this.put({code: '0xfe0f', key: '👨🏽‍⚖️', picture: '0x1f4680x1f3fd0x2696.png'});

        this.put({code: '0x2708', key: '👨🏽‍✈', picture: '0x1f4680x1f3fd0x2708.png'});
        this.put({code: '0xfe0f', key: '👨🏽‍✈️', picture: '0x1f4680x1f3fd0x2708.png'});

        this.put({code: '0xd83c'});
        this.put({code: '0xdf3e', key: '👨🏽‍🌾', picture: '0x1f4680x1f3fd0x1f33e.png'});
        this.put({code: '0xdf73', key: '👨🏽‍🍳', picture: '0x1f4680x1f3fd0x1f373.png'});
        this.put({code: '0xdf93', key: '👨🏽‍🎓', picture: '0x1f4680x1f3fd0x1f393.png'});
        this.put({code: '0xdfa4', key: '👨🏽‍🎤', picture: '0x1f4680x1f3fd0x1f3a4.png'});
        this.put({code: '0xdfa8', key: '👨🏽‍🎨', picture: '0x1f4680x1f3fd0x1f3a8.png'});
        this.put({code: '0xdfeb', key: '👨🏽‍🏫', picture: '0x1f4680x1f3fd0x1f3eb.png'});
        this.put({code: '0xdfed', key: '👨🏽‍🏭', picture: '0x1f4680x1f3fd0x1f3ed.png'});

        this.put({code: '0xd83d'});
        this.put({code: '0xdcbb', key: '👨🏽‍💻', picture: '0x1f4680x1f3fd0x1f4bb.png'});
        this.put({code: '0xdcbc', key: '👨🏽‍💼', picture: '0x1f4680x1f3fd0x1f4bc.png'});
        this.put({code: '0xdd27', key: '👨🏽‍🔧', picture: '0x1f4680x1f3fd0x1f527.png'});
        this.put({code: '0xdd2c', key: '👨🏽‍🔬', picture: '0x1f4680x1f3fd0x1f52c.png'});
        this.put({code: '0xde80', key: '👨🏽‍🚀', picture: '0x1f4680x1f3fd0x1f680.png'});
        this.put({code: '0xde92', key: '👨🏽‍🚒', picture: '0x1f4680x1f3fd0x1f692.png'});


        this.put({code: '0xdffe', key: '👨🏾', picture: '0x1f4680x1f3fe.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2695', key: '👨🏾‍⚕', picture: '0x1f4680x1f3fe0x2695.png'});
        this.put({code: '0xfe0f', key: '👨🏾‍⚕️', picture: '0x1f4680x1f3fe0x2695.png'});

        this.put({code: '0x2696', key: '👨🏾‍⚖', picture: '0x1f4680x1f3fe0x2696.png'});
        this.put({code: '0xfe0f', key: '👨🏾‍⚖️', picture: '0x1f4680x1f3fe0x2696.png'});

        this.put({code: '0x2708', key: '👨🏾‍✈', picture: '0x1f4680x1f3fe0x2708.png'});
        this.put({code: '0xfe0f', key: '👨🏾‍✈️', picture: '0x1f4680x1f3fe0x2708.png'});

        this.put({code: '0xd83c'});
        this.put({code: '0xdf3e', key: '👨🏾‍🌾', picture: '0x1f4680x1f3fe0x1f33e.png'});
        this.put({code: '0xdf73', key: '👨🏾‍🍳', picture: '0x1f4680x1f3fe0x1f373.png'});
        this.put({code: '0xdf93', key: '👨🏾‍🎓', picture: '0x1f4680x1f3fe0x1f393.png'});
        this.put({code: '0xdfa4', key: '👨🏾‍🎤', picture: '0x1f4680x1f3fe0x1f3a4.png'});
        this.put({code: '0xdfa8', key: '👨🏾‍🎨', picture: '0x1f4680x1f3fe0x1f3a8.png'});
        this.put({code: '0xdfeb', key: '👨🏾‍🏫', picture: '0x1f4680x1f3fe0x1f3eb.png'});
        this.put({code: '0xdfed', key: '👨🏾‍🏭', picture: '0x1f4680x1f3fe0x1f3ed.png'});

        this.put({code: '0xd83d'});
        this.put({code: '0xdcbb', key: '👨🏾‍💻', picture: '0x1f4680x1f3fe0x1f4bb.png'});
        this.put({code: '0xdcbc', key: '👨🏾‍💼', picture: '0x1f4680x1f3fe0x1f4bc.png'});
        this.put({code: '0xdd27', key: '👨🏾‍🔧', picture: '0x1f4680x1f3fe0x1f527.png'});
        this.put({code: '0xdd2c', key: '👨🏾‍🔬', picture: '0x1f4680x1f3fe0x1f52c.png'});
        this.put({code: '0xde80', key: '👨🏾‍🚀', picture: '0x1f4680x1f3fe0x1f680.png'});
        this.put({code: '0xde92', key: '👨🏾‍🚒', picture: '0x1f4680x1f3fe0x1f692.png'});


        this.put({code: '0xdfff', key: '👨🏿', picture: '0x1f4680x1f3ff.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2695', key: '👨🏿‍⚕', picture: '0x1f4680x1f3ff0x2695.png'});
        this.put({code: '0xfe0f', key: '👨🏿‍⚕️', picture: '0x1f4680x1f3ff0x2695.png'});

        this.put({code: '0x2696', key: '👨🏿‍⚖', picture: '0x1f4680x1f3ff0x2696.png'});
        this.put({code: '0xfe0f', key: '👨🏿‍⚖️', picture: '0x1f4680x1f3ff0x2696.png'});

        this.put({code: '0x2708', key: '👨🏿‍✈', picture: '0x1f4680x1f3ff0x2708.png'});
        this.put({code: '0xfe0f', key: '👨🏿‍✈️', picture: '0x1f4680x1f3ff0x2708.png'});

        this.put({code: '0xd83c'});
        this.put({code: '0xdf3e', key: '👨🏿‍🌾', picture: '0x1f4680x1f3ff0x1f33e.png'});
        this.put({code: '0xdf73', key: '👨🏿‍🍳', picture: '0x1f4680x1f3ff0x1f373.png'});
        this.put({code: '0xdf93', key: '👨🏿‍🎓', picture: '0x1f4680x1f3ff0x1f393.png'});
        this.put({code: '0xdfa4', key: '👨🏿‍🎤', picture: '0x1f4680x1f3ff0x1f3a4.png'});
        this.put({code: '0xdfa8', key: '👨🏿‍🎨', picture: '0x1f4680x1f3ff0x1f3a8.png'});
        this.put({code: '0xdfeb', key: '👨🏿‍🏫', picture: '0x1f4680x1f3ff0x1f3eb.png'});
        this.put({code: '0xdfed', key: '👨🏿‍🏭', picture: '0x1f4680x1f3ff0x1f3ed.png'});

        this.put({code: '0xd83d'});
        this.put({code: '0xdcbb', key: '👨🏿‍💻', picture: '0x1f4680x1f3ff0x1f4bb.png'});
        this.put({code: '0xdcbc', key: '👨🏿‍💼', picture: '0x1f4680x1f3ff0x1f4bc.png'});
        this.put({code: '0xdd27', key: '👨🏿‍🔧', picture: '0x1f4680x1f3ff0x1f527.png'});
        this.put({code: '0xdd2c', key: '👨🏿‍🔬', picture: '0x1f4680x1f3ff0x1f52c.png'});
        this.put({code: '0xde80', key: '👨🏿‍🚀', picture: '0x1f4680x1f3ff0x1f680.png'});
        this.put({code: '0xde92', key: '👨🏿‍🚒', picture: '0x1f4680x1f3ff0x1f692.png'});


        this.put({code: '0xdc69', key: '👩', picture: '0x1f469.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2695', key: '👩‍⚕', picture: '0x1f4690x2695.png'});
        this.put({code: '0xfe0f', key: '👩‍⚕️', picture: '0x1f4690x2695.png'});

        this.put({code: '0x2696', key: '👩‍⚖', picture: '0x1f4690x2696.png'});
        this.put({code: '0xfe0f', key: '👩‍⚖️', picture: '0x1f4690x2696.png'});

        this.put({code: '0x2708', key: '👩‍✈', picture: '0x1f4690x2708.png'});
        this.put({code: '0xfe0f', key: '👩‍✈️', picture: '0x1f4690x2708.png'});

        this.put({code: '0xd83c'});
        this.put({code: '0xdf3e', key: '👩‍🌾', picture: '0x1f4690x1f33e.png'});
        this.put({code: '0xdf73', key: '👩‍🍳', picture: '0x1f4690x1f373.png'});
        this.put({code: '0xdf93', key: '👩‍🎓', picture: '0x1f4690x1f393.png'});
        this.put({code: '0xdfa4', key: '👩‍🎤', picture: '0x1f4690x1f3a4.png'});
        this.put({code: '0xdfa8', key: '👩‍🎨', picture: '0x1f4690x1f3a8.png'});
        this.put({code: '0xdfeb', key: '👩‍🏫', picture: '0x1f4690x1f3eb.png'});
        this.put({code: '0xdfed', key: '👩‍🏭', picture: '0x1f4690x1f3ed.png'});

        this.put({code: '0xd83d'});
        this.put({code: '0xdc66', key: '👩‍👦', picture: '0x1f4690x1f466.png'});
        this.put({code: '0x200d'});
        this.put({code: '0xd83d'});
        this.put({code: '0xdc66', key: '👩‍👦‍👦', picture: '0x1f4690x1f4660x1f466.png'});


        this.put({code: '0xdc67', key: '👩‍👧', picture: '0x1f4690x1f467.png'});
        this.put({code: '0x200d'});
        this.put({code: '0xd83d'});
        this.put({code: '0xdc66', key: '👩‍👧‍👦', picture: '0x1f4690x1f4670x1f466.png'});
        this.put({code: '0xdc67', key: '👩‍👧‍👧', picture: '0x1f4690x1f4670x1f467.png'});


        this.put({code: '0xdcbb', key: '👩‍💻', picture: '0x1f4690x1f4bb.png'});
        this.put({code: '0xdcbc', key: '👩‍💼', picture: '0x1f4690x1f4bc.png'});
        this.put({code: '0xdd27', key: '👩‍🔧', picture: '0x1f4690x1f527.png'});
        this.put({code: '0xdd2c', key: '👩‍🔬', picture: '0x1f4690x1f52c.png'});
        this.put({code: '0xde80', key: '👩‍🚀', picture: '0x1f4690x1f680.png'});
        this.put({code: '0xde92', key: '👩‍🚒', picture: '0x1f4690x1f692.png'});
        this.put({code: '0xdc69'});
        this.put({code: '0x200d'});
        this.put({code: '0xd83d'});
        this.put({code: '0xdc66', key: '👩‍👩‍👦', picture: '0x1f4690x1f4690x1f466.png'});
        this.put({code: '0x200d'});
        this.put({code: '0xd83d'});
        this.put({code: '0xdc66', key: '👩‍👩‍👦‍👦', picture: '0x1f4690x1f4690x1f4660x1f466.png'});


        this.put({code: '0xdc67', key: '👩‍👩‍👧', picture: '0x1f4690x1f4690x1f467.png'});
        this.put({code: '0x200d'});
        this.put({code: '0xd83d'});
        this.put({code: '0xdc66', key: '👩‍👩‍👧‍👦', picture: '0x1f4690x1f4690x1f4670x1f466.png'});
        this.put({code: '0xdc67', key: '👩‍👩‍👧‍👧', picture: '0x1f4690x1f4690x1f4670x1f467.png'});


        this.put({code: '0x2764'});
        this.put({code: '0x200d'});
        this.put({code: '0xd83d'});
        this.put({code: '0xdc68', key: '👩‍❤‍👨', picture: '0x1f4690x27640x1f468.png'});
        this.put({code: '0xdc69', key: '👩‍❤‍👩', picture: '0x1f4690x27640x1f469.png'});
        this.put({code: '0xdc8b'});
        this.put({code: '0x200d'});
        this.put({code: '0xd83d'});
        this.put({code: '0xdc68', key: '👩‍❤‍💋‍👨', picture: '0x1f4690x27640x1f48b0x1f468.png'});
        this.put({code: '0xdc69', key: '👩‍❤‍💋‍👩', picture: '0x1f4690x27640x1f48b0x1f469.png'});


        this.put({code: '0xfe0f'});
        this.put({code: '0x200d'});
        this.put({code: '0xd83d'});
        this.put({code: '0xdc68', key: '👩‍❤️‍👨', picture: '0x1f4690x27640x1f468.png'});
        this.put({code: '0xdc69', key: '👩‍❤️‍👩', picture: '0x1f4690x27640x1f469.png'});
        this.put({code: '0xdc8b'});
        this.put({code: '0x200d'});
        this.put({code: '0xd83d'});
        this.put({code: '0xdc68', key: '👩‍❤️‍💋‍👨', picture: '0x1f4690x27640x1f48b0x1f468.png'});
        this.put({code: '0xdc69', key: '👩‍❤️‍💋‍👩', picture: '0x1f4690x27640x1f48b0x1f469.png'});


        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '👩🏻', picture: '0x1f4690x1f3fb.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2695', key: '👩🏻‍⚕', picture: '0x1f4690x1f3fb0x2695.png'});
        this.put({code: '0xfe0f', key: '👩🏻‍⚕️', picture: '0x1f4690x1f3fb0x2695.png'});

        this.put({code: '0x2696', key: '👩🏻‍⚖', picture: '0x1f4690x1f3fb0x2696.png'});
        this.put({code: '0xfe0f', key: '👩🏻‍⚖️', picture: '0x1f4690x1f3fb0x2696.png'});

        this.put({code: '0x2708', key: '👩🏻‍✈', picture: '0x1f4690x1f3fb0x2708.png'});
        this.put({code: '0xfe0f', key: '👩🏻‍✈️', picture: '0x1f4690x1f3fb0x2708.png'});

        this.put({code: '0xd83c'});
        this.put({code: '0xdf3e', key: '👩🏻‍🌾', picture: '0x1f4690x1f3fb0x1f33e.png'});
        this.put({code: '0xdf73', key: '👩🏻‍🍳', picture: '0x1f4690x1f3fb0x1f373.png'});
        this.put({code: '0xdf93', key: '👩🏻‍🎓', picture: '0x1f4690x1f3fb0x1f393.png'});
        this.put({code: '0xdfa4', key: '👩🏻‍🎤', picture: '0x1f4690x1f3fb0x1f3a4.png'});
        this.put({code: '0xdfa8', key: '👩🏻‍🎨', picture: '0x1f4690x1f3fb0x1f3a8.png'});
        this.put({code: '0xdfeb', key: '👩🏻‍🏫', picture: '0x1f4690x1f3fb0x1f3eb.png'});
        this.put({code: '0xdfed', key: '👩🏻‍🏭', picture: '0x1f4690x1f3fb0x1f3ed.png'});

        this.put({code: '0xd83d'});
        this.put({code: '0xdcbb', key: '👩🏻‍💻', picture: '0x1f4690x1f3fb0x1f4bb.png'});
        this.put({code: '0xdcbc', key: '👩🏻‍💼', picture: '0x1f4690x1f3fb0x1f4bc.png'});
        this.put({code: '0xdd27', key: '👩🏻‍🔧', picture: '0x1f4690x1f3fb0x1f527.png'});
        this.put({code: '0xdd2c', key: '👩🏻‍🔬', picture: '0x1f4690x1f3fb0x1f52c.png'});
        this.put({code: '0xde80', key: '👩🏻‍🚀', picture: '0x1f4690x1f3fb0x1f680.png'});
        this.put({code: '0xde92', key: '👩🏻‍🚒', picture: '0x1f4690x1f3fb0x1f692.png'});


        this.put({code: '0xdffc', key: '👩🏼', picture: '0x1f4690x1f3fc.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2695', key: '👩🏼‍⚕', picture: '0x1f4690x1f3fc0x2695.png'});
        this.put({code: '0xfe0f', key: '👩🏼‍⚕️', picture: '0x1f4690x1f3fc0x2695.png'});

        this.put({code: '0x2696', key: '👩🏼‍⚖', picture: '0x1f4690x1f3fc0x2696.png'});
        this.put({code: '0xfe0f', key: '👩🏼‍⚖️', picture: '0x1f4690x1f3fc0x2696.png'});

        this.put({code: '0x2708', key: '👩🏼‍✈', picture: '0x1f4690x1f3fc0x2708.png'});
        this.put({code: '0xfe0f', key: '👩🏼‍✈️', picture: '0x1f4690x1f3fc0x2708.png'});

        this.put({code: '0xd83c'});
        this.put({code: '0xdf3e', key: '👩🏼‍🌾', picture: '0x1f4690x1f3fc0x1f33e.png'});
        this.put({code: '0xdf73', key: '👩🏼‍🍳', picture: '0x1f4690x1f3fc0x1f373.png'});
        this.put({code: '0xdf93', key: '👩🏼‍🎓', picture: '0x1f4690x1f3fc0x1f393.png'});
        this.put({code: '0xdfa4', key: '👩🏼‍🎤', picture: '0x1f4690x1f3fc0x1f3a4.png'});
        this.put({code: '0xdfa8', key: '👩🏼‍🎨', picture: '0x1f4690x1f3fc0x1f3a8.png'});
        this.put({code: '0xdfeb', key: '👩🏼‍🏫', picture: '0x1f4690x1f3fc0x1f3eb.png'});
        this.put({code: '0xdfed', key: '👩🏼‍🏭', picture: '0x1f4690x1f3fc0x1f3ed.png'});

        this.put({code: '0xd83d'});
        this.put({code: '0xdcbb', key: '👩🏼‍💻', picture: '0x1f4690x1f3fc0x1f4bb.png'});
        this.put({code: '0xdcbc', key: '👩🏼‍💼', picture: '0x1f4690x1f3fc0x1f4bc.png'});
        this.put({code: '0xdd27', key: '👩🏼‍🔧', picture: '0x1f4690x1f3fc0x1f527.png'});
        this.put({code: '0xdd2c', key: '👩🏼‍🔬', picture: '0x1f4690x1f3fc0x1f52c.png'});
        this.put({code: '0xde80', key: '👩🏼‍🚀', picture: '0x1f4690x1f3fc0x1f680.png'});
        this.put({code: '0xde92', key: '👩🏼‍🚒', picture: '0x1f4690x1f3fc0x1f692.png'});


        this.put({code: '0xdffd', key: '👩🏽', picture: '0x1f4690x1f3fd.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2695', key: '👩🏽‍⚕', picture: '0x1f4690x1f3fd0x2695.png'});
        this.put({code: '0xfe0f', key: '👩🏽‍⚕️', picture: '0x1f4690x1f3fd0x2695.png'});

        this.put({code: '0x2696', key: '👩🏽‍⚖', picture: '0x1f4690x1f3fd0x2696.png'});
        this.put({code: '0xfe0f', key: '👩🏽‍⚖️', picture: '0x1f4690x1f3fd0x2696.png'});

        this.put({code: '0x2708', key: '👩🏽‍✈', picture: '0x1f4690x1f3fd0x2708.png'});
        this.put({code: '0xfe0f', key: '👩🏽‍✈️', picture: '0x1f4690x1f3fd0x2708.png'});

        this.put({code: '0xd83c'});
        this.put({code: '0xdf3e', key: '👩🏽‍🌾', picture: '0x1f4690x1f3fd0x1f33e.png'});
        this.put({code: '0xdf73', key: '👩🏽‍🍳', picture: '0x1f4690x1f3fd0x1f373.png'});
        this.put({code: '0xdf93', key: '👩🏽‍🎓', picture: '0x1f4690x1f3fd0x1f393.png'});
        this.put({code: '0xdfa4', key: '👩🏽‍🎤', picture: '0x1f4690x1f3fd0x1f3a4.png'});
        this.put({code: '0xdfa8', key: '👩🏽‍🎨', picture: '0x1f4690x1f3fd0x1f3a8.png'});
        this.put({code: '0xdfeb', key: '👩🏽‍🏫', picture: '0x1f4690x1f3fd0x1f3eb.png'});
        this.put({code: '0xdfed', key: '👩🏽‍🏭', picture: '0x1f4690x1f3fd0x1f3ed.png'});

        this.put({code: '0xd83d'});
        this.put({code: '0xdcbb', key: '👩🏽‍💻', picture: '0x1f4690x1f3fd0x1f4bb.png'});
        this.put({code: '0xdcbc', key: '👩🏽‍💼', picture: '0x1f4690x1f3fd0x1f4bc.png'});
        this.put({code: '0xdd27', key: '👩🏽‍🔧', picture: '0x1f4690x1f3fd0x1f527.png'});
        this.put({code: '0xdd2c', key: '👩🏽‍🔬', picture: '0x1f4690x1f3fd0x1f52c.png'});
        this.put({code: '0xde80', key: '👩🏽‍🚀', picture: '0x1f4690x1f3fd0x1f680.png'});
        this.put({code: '0xde92', key: '👩🏽‍🚒', picture: '0x1f4690x1f3fd0x1f692.png'});


        this.put({code: '0xdffe', key: '👩🏾', picture: '0x1f4690x1f3fe.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2695', key: '👩🏾‍⚕', picture: '0x1f4690x1f3fe0x2695.png'});
        this.put({code: '0xfe0f', key: '👩🏾‍⚕️', picture: '0x1f4690x1f3fe0x2695.png'});

        this.put({code: '0x2696', key: '👩🏾‍⚖', picture: '0x1f4690x1f3fe0x2696.png'});
        this.put({code: '0xfe0f', key: '👩🏾‍⚖️', picture: '0x1f4690x1f3fe0x2696.png'});

        this.put({code: '0x2708', key: '👩🏾‍✈', picture: '0x1f4690x1f3fe0x2708.png'});
        this.put({code: '0xfe0f', key: '👩🏾‍✈️', picture: '0x1f4690x1f3fe0x2708.png'});

        this.put({code: '0xd83c'});
        this.put({code: '0xdf3e', key: '👩🏾‍🌾', picture: '0x1f4690x1f3fe0x1f33e.png'});
        this.put({code: '0xdf73', key: '👩🏾‍🍳', picture: '0x1f4690x1f3fe0x1f373.png'});
        this.put({code: '0xdf93', key: '👩🏾‍🎓', picture: '0x1f4690x1f3fe0x1f393.png'});
        this.put({code: '0xdfa4', key: '👩🏾‍🎤', picture: '0x1f4690x1f3fe0x1f3a4.png'});
        this.put({code: '0xdfa8', key: '👩🏾‍🎨', picture: '0x1f4690x1f3fe0x1f3a8.png'});
        this.put({code: '0xdfeb', key: '👩🏾‍🏫', picture: '0x1f4690x1f3fe0x1f3eb.png'});
        this.put({code: '0xdfed', key: '👩🏾‍🏭', picture: '0x1f4690x1f3fe0x1f3ed.png'});

        this.put({code: '0xd83d'});
        this.put({code: '0xdcbb', key: '👩🏾‍💻', picture: '0x1f4690x1f3fe0x1f4bb.png'});
        this.put({code: '0xdcbc', key: '👩🏾‍💼', picture: '0x1f4690x1f3fe0x1f4bc.png'});
        this.put({code: '0xdd27', key: '👩🏾‍🔧', picture: '0x1f4690x1f3fe0x1f527.png'});
        this.put({code: '0xdd2c', key: '👩🏾‍🔬', picture: '0x1f4690x1f3fe0x1f52c.png'});
        this.put({code: '0xde80', key: '👩🏾‍🚀', picture: '0x1f4690x1f3fe0x1f680.png'});
        this.put({code: '0xde92', key: '👩🏾‍🚒', picture: '0x1f4690x1f3fe0x1f692.png'});


        this.put({code: '0xdfff', key: '👩🏿', picture: '0x1f4690x1f3ff.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2695', key: '👩🏿‍⚕', picture: '0x1f4690x1f3ff0x2695.png'});
        this.put({code: '0xfe0f', key: '👩🏿‍⚕️', picture: '0x1f4690x1f3ff0x2695.png'});

        this.put({code: '0x2696', key: '👩🏿‍⚖', picture: '0x1f4690x1f3ff0x2696.png'});
        this.put({code: '0xfe0f', key: '👩🏿‍⚖️', picture: '0x1f4690x1f3ff0x2696.png'});

        this.put({code: '0x2708', key: '👩🏿‍✈', picture: '0x1f4690x1f3ff0x2708.png'});
        this.put({code: '0xfe0f', key: '👩🏿‍✈️', picture: '0x1f4690x1f3ff0x2708.png'});

        this.put({code: '0xd83c'});
        this.put({code: '0xdf3e', key: '👩🏿‍🌾', picture: '0x1f4690x1f3ff0x1f33e.png'});
        this.put({code: '0xdf73', key: '👩🏿‍🍳', picture: '0x1f4690x1f3ff0x1f373.png'});
        this.put({code: '0xdf93', key: '👩🏿‍🎓', picture: '0x1f4690x1f3ff0x1f393.png'});
        this.put({code: '0xdfa4', key: '👩🏿‍🎤', picture: '0x1f4690x1f3ff0x1f3a4.png'});
        this.put({code: '0xdfa8', key: '👩🏿‍🎨', picture: '0x1f4690x1f3ff0x1f3a8.png'});
        this.put({code: '0xdfeb', key: '👩🏿‍🏫', picture: '0x1f4690x1f3ff0x1f3eb.png'});
        this.put({code: '0xdfed', key: '👩🏿‍🏭', picture: '0x1f4690x1f3ff0x1f3ed.png'});

        this.put({code: '0xd83d'});
        this.put({code: '0xdcbb', key: '👩🏿‍💻', picture: '0x1f4690x1f3ff0x1f4bb.png'});
        this.put({code: '0xdcbc', key: '👩🏿‍💼', picture: '0x1f4690x1f3ff0x1f4bc.png'});
        this.put({code: '0xdd27', key: '👩🏿‍🔧', picture: '0x1f4690x1f3ff0x1f527.png'});
        this.put({code: '0xdd2c', key: '👩🏿‍🔬', picture: '0x1f4690x1f3ff0x1f52c.png'});
        this.put({code: '0xde80', key: '👩🏿‍🚀', picture: '0x1f4690x1f3ff0x1f680.png'});
        this.put({code: '0xde92', key: '👩🏿‍🚒', picture: '0x1f4690x1f3ff0x1f692.png'});


        this.put({code: '0xdc6a', key: '👪', picture: '0x1f46a.png'});
        this.put({code: '0xdc6b', key: '👫', picture: '0x1f46b.png'});
        this.put({code: '0xdc6c', key: '👬', picture: '0x1f46c.png'});
        this.put({code: '0xdc6d', key: '👭', picture: '0x1f46d.png'});
        this.put({code: '0xdc6e', key: '👮', picture: '0x1f46e.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '👮‍♀', picture: '0x1f46e0x2640.png'});
        this.put({code: '0xfe0f', key: '👮‍♀️', picture: '0x1f46e0x2640.png'});

        this.put({code: '0x2642', key: '👮‍♂', picture: '0x1f46e0x2642.png'});
        this.put({code: '0xfe0f', key: '👮‍♂️', picture: '0x1f46e0x2642.png'});


        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '👮🏻', picture: '0x1f46e0x1f3fb.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '👮🏻‍♀', picture: '0x1f46e0x1f3fb0x2640.png'});
        this.put({code: '0xfe0f', key: '👮🏻‍♀️', picture: '0x1f46e0x1f3fb0x2640.png'});

        this.put({code: '0x2642', key: '👮🏻‍♂', picture: '0x1f46e0x1f3fb0x2642.png'});
        this.put({code: '0xfe0f', key: '👮🏻‍♂️', picture: '0x1f46e0x1f3fb0x2642.png'});


        this.put({code: '0xdffc', key: '👮🏼', picture: '0x1f46e0x1f3fc.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '👮🏼‍♀', picture: '0x1f46e0x1f3fc0x2640.png'});
        this.put({code: '0xfe0f', key: '👮🏼‍♀️', picture: '0x1f46e0x1f3fc0x2640.png'});

        this.put({code: '0x2642', key: '👮🏼‍♂', picture: '0x1f46e0x1f3fc0x2642.png'});
        this.put({code: '0xfe0f', key: '👮🏼‍♂️', picture: '0x1f46e0x1f3fc0x2642.png'});


        this.put({code: '0xdffd', key: '👮🏽', picture: '0x1f46e0x1f3fd.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '👮🏽‍♀', picture: '0x1f46e0x1f3fd0x2640.png'});
        this.put({code: '0xfe0f', key: '👮🏽‍♀️', picture: '0x1f46e0x1f3fd0x2640.png'});

        this.put({code: '0x2642', key: '👮🏽‍♂', picture: '0x1f46e0x1f3fd0x2642.png'});
        this.put({code: '0xfe0f', key: '👮🏽‍♂️', picture: '0x1f46e0x1f3fd0x2642.png'});


        this.put({code: '0xdffe', key: '👮🏾', picture: '0x1f46e0x1f3fe.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '👮🏾‍♀', picture: '0x1f46e0x1f3fe0x2640.png'});
        this.put({code: '0xfe0f', key: '👮🏾‍♀️', picture: '0x1f46e0x1f3fe0x2640.png'});

        this.put({code: '0x2642', key: '👮🏾‍♂', picture: '0x1f46e0x1f3fe0x2642.png'});
        this.put({code: '0xfe0f', key: '👮🏾‍♂️', picture: '0x1f46e0x1f3fe0x2642.png'});


        this.put({code: '0xdfff', key: '👮🏿', picture: '0x1f46e0x1f3ff.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '👮🏿‍♀', picture: '0x1f46e0x1f3ff0x2640.png'});
        this.put({code: '0xfe0f', key: '👮🏿‍♀️', picture: '0x1f46e0x1f3ff0x2640.png'});

        this.put({code: '0x2642', key: '👮🏿‍♂', picture: '0x1f46e0x1f3ff0x2642.png'});
        this.put({code: '0xfe0f', key: '👮🏿‍♂️', picture: '0x1f46e0x1f3ff0x2642.png'});


        this.put({code: '0xdc6f', key: '👯', picture: '0x1f46f.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '👯‍♀', picture: '0x1f46f0x2640.png'});
        this.put({code: '0xfe0f', key: '👯‍♀️', picture: '0x1f46f0x2640.png'});

        this.put({code: '0x2642', key: '👯‍♂', picture: '0x1f46f0x2642.png'});
        this.put({code: '0xfe0f', key: '👯‍♂️', picture: '0x1f46f0x2642.png'});


        this.put({code: '0xdc70', key: '👰', picture: '0x1f470.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '👰🏻', picture: '0x1f4700x1f3fb.png'});
        this.put({code: '0xdffc', key: '👰🏼', picture: '0x1f4700x1f3fc.png'});
        this.put({code: '0xdffd', key: '👰🏽', picture: '0x1f4700x1f3fd.png'});
        this.put({code: '0xdffe', key: '👰🏾', picture: '0x1f4700x1f3fe.png'});
        this.put({code: '0xdfff', key: '👰🏿', picture: '0x1f4700x1f3ff.png'});


        this.put({code: '0xdc71', key: '👱', picture: '0x1f471.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '👱‍♀', picture: '0x1f4710x2640.png'});
        this.put({code: '0xfe0f', key: '👱‍♀️', picture: '0x1f4710x2640.png'});

        this.put({code: '0x2642', key: '👱‍♂', picture: '0x1f4710x2642.png'});
        this.put({code: '0xfe0f', key: '👱‍♂️', picture: '0x1f4710x2642.png'});


        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '👱🏻', picture: '0x1f4710x1f3fb.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '👱🏻‍♀', picture: '0x1f4710x1f3fb0x2640.png'});
        this.put({code: '0xfe0f', key: '👱🏻‍♀️', picture: '0x1f4710x1f3fb0x2640.png'});

        this.put({code: '0x2642', key: '👱🏻‍♂', picture: '0x1f4710x1f3fb0x2642.png'});
        this.put({code: '0xfe0f', key: '👱🏻‍♂️', picture: '0x1f4710x1f3fb0x2642.png'});


        this.put({code: '0xdffc', key: '👱🏼', picture: '0x1f4710x1f3fc.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '👱🏼‍♀', picture: '0x1f4710x1f3fc0x2640.png'});
        this.put({code: '0xfe0f', key: '👱🏼‍♀️', picture: '0x1f4710x1f3fc0x2640.png'});

        this.put({code: '0x2642', key: '👱🏼‍♂', picture: '0x1f4710x1f3fc0x2642.png'});
        this.put({code: '0xfe0f', key: '👱🏼‍♂️', picture: '0x1f4710x1f3fc0x2642.png'});


        this.put({code: '0xdffd', key: '👱🏽', picture: '0x1f4710x1f3fd.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '👱🏽‍♀', picture: '0x1f4710x1f3fd0x2640.png'});
        this.put({code: '0xfe0f', key: '👱🏽‍♀️', picture: '0x1f4710x1f3fd0x2640.png'});

        this.put({code: '0x2642', key: '👱🏽‍♂', picture: '0x1f4710x1f3fd0x2642.png'});
        this.put({code: '0xfe0f', key: '👱🏽‍♂️', picture: '0x1f4710x1f3fd0x2642.png'});


        this.put({code: '0xdffe', key: '👱🏾', picture: '0x1f4710x1f3fe.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '👱🏾‍♀', picture: '0x1f4710x1f3fe0x2640.png'});
        this.put({code: '0xfe0f', key: '👱🏾‍♀️', picture: '0x1f4710x1f3fe0x2640.png'});

        this.put({code: '0x2642', key: '👱🏾‍♂', picture: '0x1f4710x1f3fe0x2642.png'});
        this.put({code: '0xfe0f', key: '👱🏾‍♂️', picture: '0x1f4710x1f3fe0x2642.png'});


        this.put({code: '0xdfff', key: '👱🏿', picture: '0x1f4710x1f3ff.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '👱🏿‍♀', picture: '0x1f4710x1f3ff0x2640.png'});
        this.put({code: '0xfe0f', key: '👱🏿‍♀️', picture: '0x1f4710x1f3ff0x2640.png'});

        this.put({code: '0x2642', key: '👱🏿‍♂', picture: '0x1f4710x1f3ff0x2642.png'});
        this.put({code: '0xfe0f', key: '👱🏿‍♂️', picture: '0x1f4710x1f3ff0x2642.png'});


        this.put({code: '0xdc72', key: '👲', picture: '0x1f472.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '👲🏻', picture: '0x1f4720x1f3fb.png'});
        this.put({code: '0xdffc', key: '👲🏼', picture: '0x1f4720x1f3fc.png'});
        this.put({code: '0xdffd', key: '👲🏽', picture: '0x1f4720x1f3fd.png'});
        this.put({code: '0xdffe', key: '👲🏾', picture: '0x1f4720x1f3fe.png'});
        this.put({code: '0xdfff', key: '👲🏿', picture: '0x1f4720x1f3ff.png'});


        this.put({code: '0xdc73', key: '👳', picture: '0x1f473.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '👳‍♀', picture: '0x1f4730x2640.png'});
        this.put({code: '0xfe0f', key: '👳‍♀️', picture: '0x1f4730x2640.png'});

        this.put({code: '0x2642', key: '👳‍♂', picture: '0x1f4730x2642.png'});
        this.put({code: '0xfe0f', key: '👳‍♂️', picture: '0x1f4730x2642.png'});


        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '👳🏻', picture: '0x1f4730x1f3fb.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '👳🏻‍♀', picture: '0x1f4730x1f3fb0x2640.png'});
        this.put({code: '0xfe0f', key: '👳🏻‍♀️', picture: '0x1f4730x1f3fb0x2640.png'});

        this.put({code: '0x2642', key: '👳🏻‍♂', picture: '0x1f4730x1f3fb0x2642.png'});
        this.put({code: '0xfe0f', key: '👳🏻‍♂️', picture: '0x1f4730x1f3fb0x2642.png'});


        this.put({code: '0xdffc', key: '👳🏼', picture: '0x1f4730x1f3fc.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '👳🏼‍♀', picture: '0x1f4730x1f3fc0x2640.png'});
        this.put({code: '0xfe0f', key: '👳🏼‍♀️', picture: '0x1f4730x1f3fc0x2640.png'});

        this.put({code: '0x2642', key: '👳🏼‍♂', picture: '0x1f4730x1f3fc0x2642.png'});
        this.put({code: '0xfe0f', key: '👳🏼‍♂️', picture: '0x1f4730x1f3fc0x2642.png'});


        this.put({code: '0xdffd', key: '👳🏽', picture: '0x1f4730x1f3fd.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '👳🏽‍♀', picture: '0x1f4730x1f3fd0x2640.png'});
        this.put({code: '0xfe0f', key: '👳🏽‍♀️', picture: '0x1f4730x1f3fd0x2640.png'});

        this.put({code: '0x2642', key: '👳🏽‍♂', picture: '0x1f4730x1f3fd0x2642.png'});
        this.put({code: '0xfe0f', key: '👳🏽‍♂️', picture: '0x1f4730x1f3fd0x2642.png'});


        this.put({code: '0xdffe', key: '👳🏾', picture: '0x1f4730x1f3fe.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '👳🏾‍♀', picture: '0x1f4730x1f3fe0x2640.png'});
        this.put({code: '0xfe0f', key: '👳🏾‍♀️', picture: '0x1f4730x1f3fe0x2640.png'});

        this.put({code: '0x2642', key: '👳🏾‍♂', picture: '0x1f4730x1f3fe0x2642.png'});
        this.put({code: '0xfe0f', key: '👳🏾‍♂️', picture: '0x1f4730x1f3fe0x2642.png'});


        this.put({code: '0xdfff', key: '👳🏿', picture: '0x1f4730x1f3ff.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '👳🏿‍♀', picture: '0x1f4730x1f3ff0x2640.png'});
        this.put({code: '0xfe0f', key: '👳🏿‍♀️', picture: '0x1f4730x1f3ff0x2640.png'});

        this.put({code: '0x2642', key: '👳🏿‍♂', picture: '0x1f4730x1f3ff0x2642.png'});
        this.put({code: '0xfe0f', key: '👳🏿‍♂️', picture: '0x1f4730x1f3ff0x2642.png'});


        this.put({code: '0xdc74', key: '👴', picture: '0x1f474.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '👴🏻', picture: '0x1f4740x1f3fb.png'});
        this.put({code: '0xdffc', key: '👴🏼', picture: '0x1f4740x1f3fc.png'});
        this.put({code: '0xdffd', key: '👴🏽', picture: '0x1f4740x1f3fd.png'});
        this.put({code: '0xdffe', key: '👴🏾', picture: '0x1f4740x1f3fe.png'});
        this.put({code: '0xdfff', key: '👴🏿', picture: '0x1f4740x1f3ff.png'});


        this.put({code: '0xdc75', key: '👵', picture: '0x1f475.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '👵🏻', picture: '0x1f4750x1f3fb.png'});
        this.put({code: '0xdffc', key: '👵🏼', picture: '0x1f4750x1f3fc.png'});
        this.put({code: '0xdffd', key: '👵🏽', picture: '0x1f4750x1f3fd.png'});
        this.put({code: '0xdffe', key: '👵🏾', picture: '0x1f4750x1f3fe.png'});
        this.put({code: '0xdfff', key: '👵🏿', picture: '0x1f4750x1f3ff.png'});


        this.put({code: '0xdc76', key: '👶', picture: '0x1f476.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '👶🏻', picture: '0x1f4760x1f3fb.png'});
        this.put({code: '0xdffc', key: '👶🏼', picture: '0x1f4760x1f3fc.png'});
        this.put({code: '0xdffd', key: '👶🏽', picture: '0x1f4760x1f3fd.png'});
        this.put({code: '0xdffe', key: '👶🏾', picture: '0x1f4760x1f3fe.png'});
        this.put({code: '0xdfff', key: '👶🏿', picture: '0x1f4760x1f3ff.png'});


        this.put({code: '0xdc77', key: '👷', picture: '0x1f477.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '👷‍♀', picture: '0x1f4770x2640.png'});
        this.put({code: '0xfe0f', key: '👷‍♀️', picture: '0x1f4770x2640.png'});

        this.put({code: '0x2642', key: '👷‍♂', picture: '0x1f4770x2642.png'});
        this.put({code: '0xfe0f', key: '👷‍♂️', picture: '0x1f4770x2642.png'});


        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '👷🏻', picture: '0x1f4770x1f3fb.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '👷🏻‍♀', picture: '0x1f4770x1f3fb0x2640.png'});
        this.put({code: '0xfe0f', key: '👷🏻‍♀️', picture: '0x1f4770x1f3fb0x2640.png'});

        this.put({code: '0x2642', key: '👷🏻‍♂', picture: '0x1f4770x1f3fb0x2642.png'});
        this.put({code: '0xfe0f', key: '👷🏻‍♂️', picture: '0x1f4770x1f3fb0x2642.png'});


        this.put({code: '0xdffc', key: '👷🏼', picture: '0x1f4770x1f3fc.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '👷🏼‍♀', picture: '0x1f4770x1f3fc0x2640.png'});
        this.put({code: '0xfe0f', key: '👷🏼‍♀️', picture: '0x1f4770x1f3fc0x2640.png'});

        this.put({code: '0x2642', key: '👷🏼‍♂', picture: '0x1f4770x1f3fc0x2642.png'});
        this.put({code: '0xfe0f', key: '👷🏼‍♂️', picture: '0x1f4770x1f3fc0x2642.png'});


        this.put({code: '0xdffd', key: '👷🏽', picture: '0x1f4770x1f3fd.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '👷🏽‍♀', picture: '0x1f4770x1f3fd0x2640.png'});
        this.put({code: '0xfe0f', key: '👷🏽‍♀️', picture: '0x1f4770x1f3fd0x2640.png'});

        this.put({code: '0x2642', key: '👷🏽‍♂', picture: '0x1f4770x1f3fd0x2642.png'});
        this.put({code: '0xfe0f', key: '👷🏽‍♂️', picture: '0x1f4770x1f3fd0x2642.png'});


        this.put({code: '0xdffe', key: '👷🏾', picture: '0x1f4770x1f3fe.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '👷🏾‍♀', picture: '0x1f4770x1f3fe0x2640.png'});
        this.put({code: '0xfe0f', key: '👷🏾‍♀️', picture: '0x1f4770x1f3fe0x2640.png'});

        this.put({code: '0x2642', key: '👷🏾‍♂', picture: '0x1f4770x1f3fe0x2642.png'});
        this.put({code: '0xfe0f', key: '👷🏾‍♂️', picture: '0x1f4770x1f3fe0x2642.png'});


        this.put({code: '0xdfff', key: '👷🏿', picture: '0x1f4770x1f3ff.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '👷🏿‍♀', picture: '0x1f4770x1f3ff0x2640.png'});
        this.put({code: '0xfe0f', key: '👷🏿‍♀️', picture: '0x1f4770x1f3ff0x2640.png'});

        this.put({code: '0x2642', key: '👷🏿‍♂', picture: '0x1f4770x1f3ff0x2642.png'});
        this.put({code: '0xfe0f', key: '👷🏿‍♂️', picture: '0x1f4770x1f3ff0x2642.png'});


        this.put({code: '0xdc78', key: '👸', picture: '0x1f478.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '👸🏻', picture: '0x1f4780x1f3fb.png'});
        this.put({code: '0xdffc', key: '👸🏼', picture: '0x1f4780x1f3fc.png'});
        this.put({code: '0xdffd', key: '👸🏽', picture: '0x1f4780x1f3fd.png'});
        this.put({code: '0xdffe', key: '👸🏾', picture: '0x1f4780x1f3fe.png'});
        this.put({code: '0xdfff', key: '👸🏿', picture: '0x1f4780x1f3ff.png'});


        this.put({code: '0xdc79', key: '👹', picture: '0x1f479.png'});
        this.put({code: '0xdc7a', key: '👺', picture: '0x1f47a.png'});
        this.put({code: '0xdc7b', key: '👻', picture: '0x1f47b.png'});
        this.put({code: '0xdc7c', key: '👼', picture: '0x1f47c.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '👼🏻', picture: '0x1f47c0x1f3fb.png'});
        this.put({code: '0xdffc', key: '👼🏼', picture: '0x1f47c0x1f3fc.png'});
        this.put({code: '0xdffd', key: '👼🏽', picture: '0x1f47c0x1f3fd.png'});
        this.put({code: '0xdffe', key: '👼🏾', picture: '0x1f47c0x1f3fe.png'});
        this.put({code: '0xdfff', key: '👼🏿', picture: '0x1f47c0x1f3ff.png'});


        this.put({code: '0xdc7d', key: '👽', picture: '0x1f47d.png'});
        this.put({code: '0xdc7e', key: '👾', picture: '0x1f47e.png'});
        this.put({code: '0xdc7f', key: '👿', picture: '0x1f47f.png'});
        this.put({code: '0xdc80', key: '💀', picture: '0x1f480.png'});
        this.put({code: '0xdc81', key: '💁', picture: '0x1f481.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '💁‍♀', picture: '0x1f4810x2640.png'});
        this.put({code: '0xfe0f', key: '💁‍♀️', picture: '0x1f4810x2640.png'});

        this.put({code: '0x2642', key: '💁‍♂', picture: '0x1f4810x2642.png'});
        this.put({code: '0xfe0f', key: '💁‍♂️', picture: '0x1f4810x2642.png'});


        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '💁🏻', picture: '0x1f4810x1f3fb.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '💁🏻‍♀', picture: '0x1f4810x1f3fb0x2640.png'});
        this.put({code: '0xfe0f', key: '💁🏻‍♀️', picture: '0x1f4810x1f3fb0x2640.png'});

        this.put({code: '0x2642', key: '💁🏻‍♂', picture: '0x1f4810x1f3fb0x2642.png'});
        this.put({code: '0xfe0f', key: '💁🏻‍♂️', picture: '0x1f4810x1f3fb0x2642.png'});


        this.put({code: '0xdffc', key: '💁🏼', picture: '0x1f4810x1f3fc.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '💁🏼‍♀', picture: '0x1f4810x1f3fc0x2640.png'});
        this.put({code: '0xfe0f', key: '💁🏼‍♀️', picture: '0x1f4810x1f3fc0x2640.png'});

        this.put({code: '0x2642', key: '💁🏼‍♂', picture: '0x1f4810x1f3fc0x2642.png'});
        this.put({code: '0xfe0f', key: '💁🏼‍♂️', picture: '0x1f4810x1f3fc0x2642.png'});


        this.put({code: '0xdffd', key: '💁🏽', picture: '0x1f4810x1f3fd.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '💁🏽‍♀', picture: '0x1f4810x1f3fd0x2640.png'});
        this.put({code: '0xfe0f', key: '💁🏽‍♀️', picture: '0x1f4810x1f3fd0x2640.png'});

        this.put({code: '0x2642', key: '💁🏽‍♂', picture: '0x1f4810x1f3fd0x2642.png'});
        this.put({code: '0xfe0f', key: '💁🏽‍♂️', picture: '0x1f4810x1f3fd0x2642.png'});


        this.put({code: '0xdffe', key: '💁🏾', picture: '0x1f4810x1f3fe.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '💁🏾‍♀', picture: '0x1f4810x1f3fe0x2640.png'});
        this.put({code: '0xfe0f', key: '💁🏾‍♀️', picture: '0x1f4810x1f3fe0x2640.png'});

        this.put({code: '0x2642', key: '💁🏾‍♂', picture: '0x1f4810x1f3fe0x2642.png'});
        this.put({code: '0xfe0f', key: '💁🏾‍♂️', picture: '0x1f4810x1f3fe0x2642.png'});


        this.put({code: '0xdfff', key: '💁🏿', picture: '0x1f4810x1f3ff.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '💁🏿‍♀', picture: '0x1f4810x1f3ff0x2640.png'});
        this.put({code: '0xfe0f', key: '💁🏿‍♀️', picture: '0x1f4810x1f3ff0x2640.png'});

        this.put({code: '0x2642', key: '💁🏿‍♂', picture: '0x1f4810x1f3ff0x2642.png'});
        this.put({code: '0xfe0f', key: '💁🏿‍♂️', picture: '0x1f4810x1f3ff0x2642.png'});


        this.put({code: '0xdc82', key: '💂', picture: '0x1f482.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '💂‍♀', picture: '0x1f4820x2640.png'});
        this.put({code: '0xfe0f', key: '💂‍♀️', picture: '0x1f4820x2640.png'});

        this.put({code: '0x2642', key: '💂‍♂', picture: '0x1f4820x2642.png'});
        this.put({code: '0xfe0f', key: '💂‍♂️', picture: '0x1f4820x2642.png'});


        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '💂🏻', picture: '0x1f4820x1f3fb.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '💂🏻‍♀', picture: '0x1f4820x1f3fb0x2640.png'});
        this.put({code: '0xfe0f', key: '💂🏻‍♀️', picture: '0x1f4820x1f3fb0x2640.png'});

        this.put({code: '0x2642', key: '💂🏻‍♂', picture: '0x1f4820x1f3fb0x2642.png'});
        this.put({code: '0xfe0f', key: '💂🏻‍♂️', picture: '0x1f4820x1f3fb0x2642.png'});


        this.put({code: '0xdffc', key: '💂🏼', picture: '0x1f4820x1f3fc.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '💂🏼‍♀', picture: '0x1f4820x1f3fc0x2640.png'});
        this.put({code: '0xfe0f', key: '💂🏼‍♀️', picture: '0x1f4820x1f3fc0x2640.png'});

        this.put({code: '0x2642', key: '💂🏼‍♂', picture: '0x1f4820x1f3fc0x2642.png'});
        this.put({code: '0xfe0f', key: '💂🏼‍♂️', picture: '0x1f4820x1f3fc0x2642.png'});


        this.put({code: '0xdffd', key: '💂🏽', picture: '0x1f4820x1f3fd.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '💂🏽‍♀', picture: '0x1f4820x1f3fd0x2640.png'});
        this.put({code: '0xfe0f', key: '💂🏽‍♀️', picture: '0x1f4820x1f3fd0x2640.png'});

        this.put({code: '0x2642', key: '💂🏽‍♂', picture: '0x1f4820x1f3fd0x2642.png'});
        this.put({code: '0xfe0f', key: '💂🏽‍♂️', picture: '0x1f4820x1f3fd0x2642.png'});


        this.put({code: '0xdffe', key: '💂🏾', picture: '0x1f4820x1f3fe.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '💂🏾‍♀', picture: '0x1f4820x1f3fe0x2640.png'});
        this.put({code: '0xfe0f', key: '💂🏾‍♀️', picture: '0x1f4820x1f3fe0x2640.png'});

        this.put({code: '0x2642', key: '💂🏾‍♂', picture: '0x1f4820x1f3fe0x2642.png'});
        this.put({code: '0xfe0f', key: '💂🏾‍♂️', picture: '0x1f4820x1f3fe0x2642.png'});


        this.put({code: '0xdfff', key: '💂🏿', picture: '0x1f4820x1f3ff.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '💂🏿‍♀', picture: '0x1f4820x1f3ff0x2640.png'});
        this.put({code: '0xfe0f', key: '💂🏿‍♀️', picture: '0x1f4820x1f3ff0x2640.png'});

        this.put({code: '0x2642', key: '💂🏿‍♂', picture: '0x1f4820x1f3ff0x2642.png'});
        this.put({code: '0xfe0f', key: '💂🏿‍♂️', picture: '0x1f4820x1f3ff0x2642.png'});


        this.put({code: '0xdc83', key: '💃', picture: '0x1f483.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '💃🏻', picture: '0x1f4830x1f3fb.png'});
        this.put({code: '0xdffc', key: '💃🏼', picture: '0x1f4830x1f3fc.png'});
        this.put({code: '0xdffd', key: '💃🏽', picture: '0x1f4830x1f3fd.png'});
        this.put({code: '0xdffe', key: '💃🏾', picture: '0x1f4830x1f3fe.png'});
        this.put({code: '0xdfff', key: '💃🏿', picture: '0x1f4830x1f3ff.png'});


        this.put({code: '0xdc84', key: '💄', picture: '0x1f484.png'});
        this.put({code: '0xdc85', key: '💅', picture: '0x1f485.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '💅🏻', picture: '0x1f4850x1f3fb.png'});
        this.put({code: '0xdffc', key: '💅🏼', picture: '0x1f4850x1f3fc.png'});
        this.put({code: '0xdffd', key: '💅🏽', picture: '0x1f4850x1f3fd.png'});
        this.put({code: '0xdffe', key: '💅🏾', picture: '0x1f4850x1f3fe.png'});
        this.put({code: '0xdfff', key: '💅🏿', picture: '0x1f4850x1f3ff.png'});


        this.put({code: '0xdc86', key: '💆', picture: '0x1f486.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '💆‍♀', picture: '0x1f4860x2640.png'});
        this.put({code: '0xfe0f', key: '💆‍♀️', picture: '0x1f4860x2640.png'});

        this.put({code: '0x2642', key: '💆‍♂', picture: '0x1f4860x2642.png'});
        this.put({code: '0xfe0f', key: '💆‍♂️', picture: '0x1f4860x2642.png'});


        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '💆🏻', picture: '0x1f4860x1f3fb.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '💆🏻‍♀', picture: '0x1f4860x1f3fb0x2640.png'});
        this.put({code: '0xfe0f', key: '💆🏻‍♀️', picture: '0x1f4860x1f3fb0x2640.png'});

        this.put({code: '0x2642', key: '💆🏻‍♂', picture: '0x1f4860x1f3fb0x2642.png'});
        this.put({code: '0xfe0f', key: '💆🏻‍♂️', picture: '0x1f4860x1f3fb0x2642.png'});


        this.put({code: '0xdffc', key: '💆🏼', picture: '0x1f4860x1f3fc.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '💆🏼‍♀', picture: '0x1f4860x1f3fc0x2640.png'});
        this.put({code: '0xfe0f', key: '💆🏼‍♀️', picture: '0x1f4860x1f3fc0x2640.png'});

        this.put({code: '0x2642', key: '💆🏼‍♂', picture: '0x1f4860x1f3fc0x2642.png'});
        this.put({code: '0xfe0f', key: '💆🏼‍♂️', picture: '0x1f4860x1f3fc0x2642.png'});


        this.put({code: '0xdffd', key: '💆🏽', picture: '0x1f4860x1f3fd.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '💆🏽‍♀', picture: '0x1f4860x1f3fd0x2640.png'});
        this.put({code: '0xfe0f', key: '💆🏽‍♀️', picture: '0x1f4860x1f3fd0x2640.png'});

        this.put({code: '0x2642', key: '💆🏽‍♂', picture: '0x1f4860x1f3fd0x2642.png'});
        this.put({code: '0xfe0f', key: '💆🏽‍♂️', picture: '0x1f4860x1f3fd0x2642.png'});


        this.put({code: '0xdffe', key: '💆🏾', picture: '0x1f4860x1f3fe.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '💆🏾‍♀', picture: '0x1f4860x1f3fe0x2640.png'});
        this.put({code: '0xfe0f', key: '💆🏾‍♀️', picture: '0x1f4860x1f3fe0x2640.png'});

        this.put({code: '0x2642', key: '💆🏾‍♂', picture: '0x1f4860x1f3fe0x2642.png'});
        this.put({code: '0xfe0f', key: '💆🏾‍♂️', picture: '0x1f4860x1f3fe0x2642.png'});


        this.put({code: '0xdfff', key: '💆🏿', picture: '0x1f4860x1f3ff.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '💆🏿‍♀', picture: '0x1f4860x1f3ff0x2640.png'});
        this.put({code: '0xfe0f', key: '💆🏿‍♀️', picture: '0x1f4860x1f3ff0x2640.png'});

        this.put({code: '0x2642', key: '💆🏿‍♂', picture: '0x1f4860x1f3ff0x2642.png'});
        this.put({code: '0xfe0f', key: '💆🏿‍♂️', picture: '0x1f4860x1f3ff0x2642.png'});


        this.put({code: '0xdc87', key: '💇', picture: '0x1f487.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '💇‍♀', picture: '0x1f4870x2640.png'});
        this.put({code: '0xfe0f', key: '💇‍♀️', picture: '0x1f4870x2640.png'});

        this.put({code: '0x2642', key: '💇‍♂', picture: '0x1f4870x2642.png'});
        this.put({code: '0xfe0f', key: '💇‍♂️', picture: '0x1f4870x2642.png'});


        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '💇🏻', picture: '0x1f4870x1f3fb.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '💇🏻‍♀', picture: '0x1f4870x1f3fb0x2640.png'});
        this.put({code: '0xfe0f', key: '💇🏻‍♀️', picture: '0x1f4870x1f3fb0x2640.png'});

        this.put({code: '0x2642', key: '💇🏻‍♂', picture: '0x1f4870x1f3fb0x2642.png'});
        this.put({code: '0xfe0f', key: '💇🏻‍♂️', picture: '0x1f4870x1f3fb0x2642.png'});


        this.put({code: '0xdffc', key: '💇🏼', picture: '0x1f4870x1f3fc.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '💇🏼‍♀', picture: '0x1f4870x1f3fc0x2640.png'});
        this.put({code: '0xfe0f', key: '💇🏼‍♀️', picture: '0x1f4870x1f3fc0x2640.png'});

        this.put({code: '0x2642', key: '💇🏼‍♂', picture: '0x1f4870x1f3fc0x2642.png'});
        this.put({code: '0xfe0f', key: '💇🏼‍♂️', picture: '0x1f4870x1f3fc0x2642.png'});


        this.put({code: '0xdffd', key: '💇🏽', picture: '0x1f4870x1f3fd.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '💇🏽‍♀', picture: '0x1f4870x1f3fd0x2640.png'});
        this.put({code: '0xfe0f', key: '💇🏽‍♀️', picture: '0x1f4870x1f3fd0x2640.png'});

        this.put({code: '0x2642', key: '💇🏽‍♂', picture: '0x1f4870x1f3fd0x2642.png'});
        this.put({code: '0xfe0f', key: '💇🏽‍♂️', picture: '0x1f4870x1f3fd0x2642.png'});


        this.put({code: '0xdffe', key: '💇🏾', picture: '0x1f4870x1f3fe.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '💇🏾‍♀', picture: '0x1f4870x1f3fe0x2640.png'});
        this.put({code: '0xfe0f', key: '💇🏾‍♀️', picture: '0x1f4870x1f3fe0x2640.png'});

        this.put({code: '0x2642', key: '💇🏾‍♂', picture: '0x1f4870x1f3fe0x2642.png'});
        this.put({code: '0xfe0f', key: '💇🏾‍♂️', picture: '0x1f4870x1f3fe0x2642.png'});


        this.put({code: '0xdfff', key: '💇🏿', picture: '0x1f4870x1f3ff.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '💇🏿‍♀', picture: '0x1f4870x1f3ff0x2640.png'});
        this.put({code: '0xfe0f', key: '💇🏿‍♀️', picture: '0x1f4870x1f3ff0x2640.png'});

        this.put({code: '0x2642', key: '💇🏿‍♂', picture: '0x1f4870x1f3ff0x2642.png'});
        this.put({code: '0xfe0f', key: '💇🏿‍♂️', picture: '0x1f4870x1f3ff0x2642.png'});


        this.put({code: '0xdc88', key: '💈', picture: '0x1f488.png'});
        this.put({code: '0xdc89', key: '💉', picture: '0x1f489.png'});
        this.put({code: '0xdc8a', key: '💊', picture: '0x1f48a.png'});
        this.put({code: '0xdc8b', key: '💋', picture: '0x1f48b.png'});
        this.put({code: '0xdc8c', key: '💌', picture: '0x1f48c.png'});
        this.put({code: '0xdc8d', key: '💍', picture: '0x1f48d.png'});
        this.put({code: '0xdc8e', key: '💎', picture: '0x1f48e.png'});
        this.put({code: '0xdc8f', key: '💏', picture: '0x1f48f.png'});
        this.put({code: '0xdc90', key: '💐', picture: '0x1f490.png'});
        this.put({code: '0xdc91', key: '💑', picture: '0x1f491.png'});
        this.put({code: '0xdc92', key: '💒', picture: '0x1f492.png'});
        this.put({code: '0xdc93', key: '💓', picture: '0x1f493.png'});
        this.put({code: '0xdc94', key: '💔', picture: '0x1f494.png'});
        this.put({code: '0xdc95', key: '💕', picture: '0x1f495.png'});
        this.put({code: '0xdc96', key: '💖', picture: '0x1f496.png'});
        this.put({code: '0xdc97', key: '💗', picture: '0x1f497.png'});
        this.put({code: '0xdc98', key: '💘', picture: '0x1f498.png'});
        this.put({code: '0xdc99', key: '💙', picture: '0x1f499.png'});
        this.put({code: '0xdc9a', key: '💚', picture: '0x1f49a.png'});
        this.put({code: '0xdc9b', key: '💛', picture: '0x1f49b.png'});
        this.put({code: '0xdc9c', key: '💜', picture: '0x1f49c.png'});
        this.put({code: '0xdc9d', key: '💝', picture: '0x1f49d.png'});
        this.put({code: '0xdc9e', key: '💞', picture: '0x1f49e.png'});
        this.put({code: '0xdc9f', key: '💟', picture: '0x1f49f.png'});
        this.put({code: '0xdca0', key: '💠', picture: '0x1f4a0.png'});
        this.put({code: '0xdca1', key: '💡', picture: '0x1f4a1.png'});
        this.put({code: '0xdca2', key: '💢', picture: '0x1f4a2.png'});
        this.put({code: '0xdca3', key: '💣', picture: '0x1f4a3.png'});
        this.put({code: '0xdca4', key: '💤', picture: '0x1f4a4.png'});
        this.put({code: '0xdca5', key: '💥', picture: '0x1f4a5.png'});
        this.put({code: '0xdca6', key: '💦', picture: '0x1f4a6.png'});
        this.put({code: '0xdca7', key: '💧', picture: '0x1f4a7.png'});
        this.put({code: '0xdca8', key: '💨', picture: '0x1f4a8.png'});
        this.put({code: '0xdca9', key: '💩', picture: '0x1f4a9.png'});
        this.put({code: '0xdcaa', key: '💪', picture: '0x1f4aa.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '💪🏻', picture: '0x1f4aa0x1f3fb.png'});
        this.put({code: '0xdffc', key: '💪🏼', picture: '0x1f4aa0x1f3fc.png'});
        this.put({code: '0xdffd', key: '💪🏽', picture: '0x1f4aa0x1f3fd.png'});
        this.put({code: '0xdffe', key: '💪🏾', picture: '0x1f4aa0x1f3fe.png'});
        this.put({code: '0xdfff', key: '💪🏿', picture: '0x1f4aa0x1f3ff.png'});


        this.put({code: '0xdcab', key: '💫', picture: '0x1f4ab.png'});
        this.put({code: '0xdcac', key: '💬', picture: '0x1f4ac.png'});
        this.put({code: '0xdcad', key: '💭', picture: '0x1f4ad.png'});
        this.put({code: '0xdcae', key: '💮', picture: '0x1f4ae.png'});
        this.put({code: '0xdcaf', key: '💯', picture: '0x1f4af.png'});
        this.put({code: '0xdcb0', key: '💰', picture: '0x1f4b0.png'});
        this.put({code: '0xdcb1', key: '💱', picture: '0x1f4b1.png'});
        this.put({code: '0xdcb2', key: '💲', picture: '0x1f4b2.png'});
        this.put({code: '0xdcb3', key: '💳', picture: '0x1f4b3.png'});
        this.put({code: '0xdcb4', key: '💴', picture: '0x1f4b4.png'});
        this.put({code: '0xdcb5', key: '💵', picture: '0x1f4b5.png'});
        this.put({code: '0xdcb6', key: '💶', picture: '0x1f4b6.png'});
        this.put({code: '0xdcb7', key: '💷', picture: '0x1f4b7.png'});
        this.put({code: '0xdcb8', key: '💸', picture: '0x1f4b8.png'});
        this.put({code: '0xdcb9', key: '💹', picture: '0x1f4b9.png'});
        this.put({code: '0xdcba', key: '💺', picture: '0x1f4ba.png'});
        this.put({code: '0xdcbb', key: '💻', picture: '0x1f4bb.png'});
        this.put({code: '0xdcbc', key: '💼', picture: '0x1f4bc.png'});
        this.put({code: '0xdcbd', key: '💽', picture: '0x1f4bd.png'});
        this.put({code: '0xdcbe', key: '💾', picture: '0x1f4be.png'});
        this.put({code: '0xdcbf', key: '💿', picture: '0x1f4bf.png'});
        this.put({code: '0xdcc0', key: '📀', picture: '0x1f4c0.png'});
        this.put({code: '0xdcc1', key: '📁', picture: '0x1f4c1.png'});
        this.put({code: '0xdcc2', key: '📂', picture: '0x1f4c2.png'});
        this.put({code: '0xdcc3', key: '📃', picture: '0x1f4c3.png'});
        this.put({code: '0xdcc4', key: '📄', picture: '0x1f4c4.png'});
        this.put({code: '0xdcc5', key: '📅', picture: '0x1f4c5.png'});
        this.put({code: '0xdcc6', key: '📆', picture: '0x1f4c6.png'});
        this.put({code: '0xdcc7', key: '📇', picture: '0x1f4c7.png'});
        this.put({code: '0xdcc8', key: '📈', picture: '0x1f4c8.png'});
        this.put({code: '0xdcc9', key: '📉', picture: '0x1f4c9.png'});
        this.put({code: '0xdcca', key: '📊', picture: '0x1f4ca.png'});
        this.put({code: '0xdccb', key: '📋', picture: '0x1f4cb.png'});
        this.put({code: '0xdccc', key: '📌', picture: '0x1f4cc.png'});
        this.put({code: '0xdccd', key: '📍', picture: '0x1f4cd.png'});
        this.put({code: '0xdcce', key: '📎', picture: '0x1f4ce.png'});
        this.put({code: '0xdccf', key: '📏', picture: '0x1f4cf.png'});
        this.put({code: '0xdcd0', key: '📐', picture: '0x1f4d0.png'});
        this.put({code: '0xdcd1', key: '📑', picture: '0x1f4d1.png'});
        this.put({code: '0xdcd2', key: '📒', picture: '0x1f4d2.png'});
        this.put({code: '0xdcd3', key: '📓', picture: '0x1f4d3.png'});
        this.put({code: '0xdcd4', key: '📔', picture: '0x1f4d4.png'});
        this.put({code: '0xdcd5', key: '📕', picture: '0x1f4d5.png'});
        this.put({code: '0xdcd6', key: '📖', picture: '0x1f4d6.png'});
        this.put({code: '0xdcd7', key: '📗', picture: '0x1f4d7.png'});
        this.put({code: '0xdcd8', key: '📘', picture: '0x1f4d8.png'});
        this.put({code: '0xdcd9', key: '📙', picture: '0x1f4d9.png'});
        this.put({code: '0xdcda', key: '📚', picture: '0x1f4da.png'});
        this.put({code: '0xdcdb', key: '📛', picture: '0x1f4db.png'});
        this.put({code: '0xdcdc', key: '📜', picture: '0x1f4dc.png'});
        this.put({code: '0xdcdd', key: '📝', picture: '0x1f4dd.png'});
        this.put({code: '0xdcde', key: '📞', picture: '0x1f4de.png'});
        this.put({code: '0xdcdf', key: '📟', picture: '0x1f4df.png'});
        this.put({code: '0xdce0', key: '📠', picture: '0x1f4e0.png'});
        this.put({code: '0xdce1', key: '📡', picture: '0x1f4e1.png'});
        this.put({code: '0xdce2', key: '📢', picture: '0x1f4e2.png'});
        this.put({code: '0xdce3', key: '📣', picture: '0x1f4e3.png'});
        this.put({code: '0xdce4', key: '📤', picture: '0x1f4e4.png'});
        this.put({code: '0xdce5', key: '📥', picture: '0x1f4e5.png'});
        this.put({code: '0xdce6', key: '📦', picture: '0x1f4e6.png'});
        this.put({code: '0xdce7', key: '📧', picture: '0x1f4e7.png'});
        this.put({code: '0xdce8', key: '📨', picture: '0x1f4e8.png'});
        this.put({code: '0xdce9', key: '📩', picture: '0x1f4e9.png'});
        this.put({code: '0xdcea', key: '📪', picture: '0x1f4ea.png'});
        this.put({code: '0xdceb', key: '📫', picture: '0x1f4eb.png'});
        this.put({code: '0xdcec', key: '📬', picture: '0x1f4ec.png'});
        this.put({code: '0xdced', key: '📭', picture: '0x1f4ed.png'});
        this.put({code: '0xdcee', key: '📮', picture: '0x1f4ee.png'});
        this.put({code: '0xdcef', key: '📯', picture: '0x1f4ef.png'});
        this.put({code: '0xdcf0', key: '📰', picture: '0x1f4f0.png'});
        this.put({code: '0xdcf1', key: '📱', picture: '0x1f4f1.png'});
        this.put({code: '0xdcf2', key: '📲', picture: '0x1f4f2.png'});
        this.put({code: '0xdcf3', key: '📳', picture: '0x1f4f3.png'});
        this.put({code: '0xdcf4', key: '📴', picture: '0x1f4f4.png'});
        this.put({code: '0xdcf5', key: '📵', picture: '0x1f4f5.png'});
        this.put({code: '0xdcf6', key: '📶', picture: '0x1f4f6.png'});
        this.put({code: '0xdcf7', key: '📷', picture: '0x1f4f7.png'});
        this.put({code: '0xdcf8', key: '📸', picture: '0x1f4f8.png'});
        this.put({code: '0xdcf9', key: '📹', picture: '0x1f4f9.png'});
        this.put({code: '0xdcfa', key: '📺', picture: '0x1f4fa.png'});
        this.put({code: '0xdcfb', key: '📻', picture: '0x1f4fb.png'});
        this.put({code: '0xdcfc', key: '📼', picture: '0x1f4fc.png'});
        this.put({code: '0xdcfd', key: '📽', picture: '0x1f4fd.png'});
        this.put({code: '0xfe0f', key: '📽️', picture: '0x1f4fd.png'});

        this.put({code: '0xdcff', key: '📿', picture: '0x1f4ff.png'});
        this.put({code: '0xdd00', key: '🔀', picture: '0x1f500.png'});
        this.put({code: '0xdd01', key: '🔁', picture: '0x1f501.png'});
        this.put({code: '0xdd02', key: '🔂', picture: '0x1f502.png'});
        this.put({code: '0xdd03', key: '🔃', picture: '0x1f503.png'});
        this.put({code: '0xdd04', key: '🔄', picture: '0x1f504.png'});
        this.put({code: '0xdd05', key: '🔅', picture: '0x1f505.png'});
        this.put({code: '0xdd06', key: '🔆', picture: '0x1f506.png'});
        this.put({code: '0xdd07', key: '🔇', picture: '0x1f507.png'});
        this.put({code: '0xdd08', key: '🔈', picture: '0x1f508.png'});
        this.put({code: '0xdd09', key: '🔉', picture: '0x1f509.png'});
        this.put({code: '0xdd0a', key: '🔊', picture: '0x1f50a.png'});
        this.put({code: '0xdd0b', key: '🔋', picture: '0x1f50b.png'});
        this.put({code: '0xdd0c', key: '🔌', picture: '0x1f50c.png'});
        this.put({code: '0xdd0d', key: '🔍', picture: '0x1f50d.png'});
        this.put({code: '0xdd0e', key: '🔎', picture: '0x1f50e.png'});
        this.put({code: '0xdd0f', key: '🔏', picture: '0x1f50f.png'});
        this.put({code: '0xdd10', key: '🔐', picture: '0x1f510.png'});
        this.put({code: '0xdd11', key: '🔑', picture: '0x1f511.png'});
        this.put({code: '0xdd12', key: '🔒', picture: '0x1f512.png'});
        this.put({code: '0xdd13', key: '🔓', picture: '0x1f513.png'});
        this.put({code: '0xdd14', key: '🔔', picture: '0x1f514.png'});
        this.put({code: '0xdd15', key: '🔕', picture: '0x1f515.png'});
        this.put({code: '0xdd16', key: '🔖', picture: '0x1f516.png'});
        this.put({code: '0xdd17', key: '🔗', picture: '0x1f517.png'});
        this.put({code: '0xdd18', key: '🔘', picture: '0x1f518.png'});
        this.put({code: '0xdd19', key: '🔙', picture: '0x1f519.png'});
        this.put({code: '0xdd1a', key: '🔚', picture: '0x1f51a.png'});
        this.put({code: '0xdd1b', key: '🔛', picture: '0x1f51b.png'});
        this.put({code: '0xdd1c', key: '🔜', picture: '0x1f51c.png'});
        this.put({code: '0xdd1d', key: '🔝', picture: '0x1f51d.png'});
        this.put({code: '0xdd1e', key: '🔞', picture: '0x1f51e.png'});
        this.put({code: '0xdd1f', key: '🔟', picture: '0x1f51f.png'});
        this.put({code: '0xdd20', key: '🔠', picture: '0x1f520.png'});
        this.put({code: '0xdd21', key: '🔡', picture: '0x1f521.png'});
        this.put({code: '0xdd22', key: '🔢', picture: '0x1f522.png'});
        this.put({code: '0xdd23', key: '🔣', picture: '0x1f523.png'});
        this.put({code: '0xdd24', key: '🔤', picture: '0x1f524.png'});
        this.put({code: '0xdd25', key: '🔥', picture: '0x1f525.png'});
        this.put({code: '0xdd26', key: '🔦', picture: '0x1f526.png'});
        this.put({code: '0xdd27', key: '🔧', picture: '0x1f527.png'});
        this.put({code: '0xdd28', key: '🔨', picture: '0x1f528.png'});
        this.put({code: '0xdd29', key: '🔩', picture: '0x1f529.png'});
        this.put({code: '0xdd2a', key: '🔪', picture: '0x1f52a.png'});
        this.put({code: '0xdd2b', key: '🔫', picture: '0x1f52b.png'});
        this.put({code: '0xdd2c', key: '🔬', picture: '0x1f52c.png'});
        this.put({code: '0xdd2d', key: '🔭', picture: '0x1f52d.png'});
        this.put({code: '0xdd2e', key: '🔮', picture: '0x1f52e.png'});
        this.put({code: '0xdd2f', key: '🔯', picture: '0x1f52f.png'});
        this.put({code: '0xdd30', key: '🔰', picture: '0x1f530.png'});
        this.put({code: '0xdd31', key: '🔱', picture: '0x1f531.png'});
        this.put({code: '0xdd32', key: '🔲', picture: '0x1f532.png'});
        this.put({code: '0xdd33', key: '🔳', picture: '0x1f533.png'});
        this.put({code: '0xdd34', key: '🔴', picture: '0x1f534.png'});
        this.put({code: '0xdd35', key: '🔵', picture: '0x1f535.png'});
        this.put({code: '0xdd36', key: '🔶', picture: '0x1f536.png'});
        this.put({code: '0xdd37', key: '🔷', picture: '0x1f537.png'});
        this.put({code: '0xdd38', key: '🔸', picture: '0x1f538.png'});
        this.put({code: '0xdd39', key: '🔹', picture: '0x1f539.png'});
        this.put({code: '0xdd3a', key: '🔺', picture: '0x1f53a.png'});
        this.put({code: '0xdd3b', key: '🔻', picture: '0x1f53b.png'});
        this.put({code: '0xdd3c', key: '🔼', picture: '0x1f53c.png'});
        this.put({code: '0xdd3d', key: '🔽', picture: '0x1f53d.png'});
        this.put({code: '0xdd49', key: '🕉', picture: '0x1f549.png'});
        this.put({code: '0xfe0f', key: '🕉️', picture: '0x1f549.png'});

        this.put({code: '0xdd4a', key: '🕊', picture: '0x1f54a.png'});
        this.put({code: '0xfe0f', key: '🕊️', picture: '0x1f54a.png'});

        this.put({code: '0xdd4b', key: '🕋', picture: '0x1f54b.png'});
        this.put({code: '0xdd4c', key: '🕌', picture: '0x1f54c.png'});
        this.put({code: '0xdd4d', key: '🕍', picture: '0x1f54d.png'});
        this.put({code: '0xdd4e', key: '🕎', picture: '0x1f54e.png'});
        this.put({code: '0xdd50', key: '🕐', picture: '0x1f550.png'});
        this.put({code: '0xdd51', key: '🕑', picture: '0x1f551.png'});
        this.put({code: '0xdd52', key: '🕒', picture: '0x1f552.png'});
        this.put({code: '0xdd53', key: '🕓', picture: '0x1f553.png'});
        this.put({code: '0xdd54', key: '🕔', picture: '0x1f554.png'});
        this.put({code: '0xdd55', key: '🕕', picture: '0x1f555.png'});
        this.put({code: '0xdd56', key: '🕖', picture: '0x1f556.png'});
        this.put({code: '0xdd57', key: '🕗', picture: '0x1f557.png'});
        this.put({code: '0xdd58', key: '🕘', picture: '0x1f558.png'});
        this.put({code: '0xdd59', key: '🕙', picture: '0x1f559.png'});
        this.put({code: '0xdd5a', key: '🕚', picture: '0x1f55a.png'});
        this.put({code: '0xdd5b', key: '🕛', picture: '0x1f55b.png'});
        this.put({code: '0xdd5c', key: '🕜', picture: '0x1f55c.png'});
        this.put({code: '0xdd5d', key: '🕝', picture: '0x1f55d.png'});
        this.put({code: '0xdd5e', key: '🕞', picture: '0x1f55e.png'});
        this.put({code: '0xdd5f', key: '🕟', picture: '0x1f55f.png'});
        this.put({code: '0xdd60', key: '🕠', picture: '0x1f560.png'});
        this.put({code: '0xdd61', key: '🕡', picture: '0x1f561.png'});
        this.put({code: '0xdd62', key: '🕢', picture: '0x1f562.png'});
        this.put({code: '0xdd63', key: '🕣', picture: '0x1f563.png'});
        this.put({code: '0xdd64', key: '🕤', picture: '0x1f564.png'});
        this.put({code: '0xdd65', key: '🕥', picture: '0x1f565.png'});
        this.put({code: '0xdd66', key: '🕦', picture: '0x1f566.png'});
        this.put({code: '0xdd67', key: '🕧', picture: '0x1f567.png'});
        this.put({code: '0xdd6f', key: '🕯', picture: '0x1f56f.png'});
        this.put({code: '0xfe0f', key: '🕯️', picture: '0x1f56f.png'});

        this.put({code: '0xdd70', key: '🕰', picture: '0x1f570.png'});
        this.put({code: '0xfe0f', key: '🕰️', picture: '0x1f570.png'});

        this.put({code: '0xdd73', key: '🕳', picture: '0x1f573.png'});
        this.put({code: '0xfe0f', key: '🕳️', picture: '0x1f573.png'});

        this.put({code: '0xdd74', key: '🕴', picture: '0x1f574.png'});
        this.put({code: '0xfe0f', key: '🕴️', picture: '0x1f574.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🕴🏻', picture: '0x1f5740x1f3fb.png'});
        this.put({code: '0xdffc', key: '🕴🏼', picture: '0x1f5740x1f3fc.png'});
        this.put({code: '0xdffd', key: '🕴🏽', picture: '0x1f5740x1f3fd.png'});
        this.put({code: '0xdffe', key: '🕴🏾', picture: '0x1f5740x1f3fe.png'});
        this.put({code: '0xdfff', key: '🕴🏿', picture: '0x1f5740x1f3ff.png'});


        this.put({code: '0xdd75', key: '🕵', picture: '0x1f575.png'});
        this.put({code: '0xfe0f', key: '🕵️', picture: '0x1f575.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640'});
        this.put({code: '0xfe0f', key: '🕵️‍♀️', picture: '0x1f5750x2640.png'});

        this.put({code: '0x2642'});
        this.put({code: '0xfe0f', key: '🕵️‍♂️', picture: '0x1f5750x2642.png'});


        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🕵‍♀', picture: '0x1f5750x2640.png'});
        this.put({code: '0x2642', key: '🕵‍♂', picture: '0x1f5750x2642.png'});

        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🕵🏻', picture: '0x1f5750x1f3fb.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🕵🏻‍♀', picture: '0x1f5750x1f3fb0x2640.png'});
        this.put({code: '0xfe0f', key: '🕵🏻‍♀️', picture: '0x1f5750x1f3fb0x2640.png'});

        this.put({code: '0x2642', key: '🕵🏻‍♂', picture: '0x1f5750x1f3fb0x2642.png'});
        this.put({code: '0xfe0f', key: '🕵🏻‍♂️', picture: '0x1f5750x1f3fb0x2642.png'});


        this.put({code: '0xdffc', key: '🕵🏼', picture: '0x1f5750x1f3fc.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🕵🏼‍♀', picture: '0x1f5750x1f3fc0x2640.png'});
        this.put({code: '0xfe0f', key: '🕵🏼‍♀️', picture: '0x1f5750x1f3fc0x2640.png'});

        this.put({code: '0x2642', key: '🕵🏼‍♂', picture: '0x1f5750x1f3fc0x2642.png'});
        this.put({code: '0xfe0f', key: '🕵🏼‍♂️', picture: '0x1f5750x1f3fc0x2642.png'});


        this.put({code: '0xdffd', key: '🕵🏽', picture: '0x1f5750x1f3fd.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🕵🏽‍♀', picture: '0x1f5750x1f3fd0x2640.png'});
        this.put({code: '0xfe0f', key: '🕵🏽‍♀️', picture: '0x1f5750x1f3fd0x2640.png'});

        this.put({code: '0x2642', key: '🕵🏽‍♂', picture: '0x1f5750x1f3fd0x2642.png'});
        this.put({code: '0xfe0f', key: '🕵🏽‍♂️', picture: '0x1f5750x1f3fd0x2642.png'});


        this.put({code: '0xdffe', key: '🕵🏾', picture: '0x1f5750x1f3fe.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🕵🏾‍♀', picture: '0x1f5750x1f3fe0x2640.png'});
        this.put({code: '0xfe0f', key: '🕵🏾‍♀️', picture: '0x1f5750x1f3fe0x2640.png'});

        this.put({code: '0x2642', key: '🕵🏾‍♂', picture: '0x1f5750x1f3fe0x2642.png'});
        this.put({code: '0xfe0f', key: '🕵🏾‍♂️', picture: '0x1f5750x1f3fe0x2642.png'});


        this.put({code: '0xdfff', key: '🕵🏿', picture: '0x1f5750x1f3ff.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🕵🏿‍♀', picture: '0x1f5750x1f3ff0x2640.png'});
        this.put({code: '0xfe0f', key: '🕵🏿‍♀️', picture: '0x1f5750x1f3ff0x2640.png'});

        this.put({code: '0x2642', key: '🕵🏿‍♂', picture: '0x1f5750x1f3ff0x2642.png'});
        this.put({code: '0xfe0f', key: '🕵🏿‍♂️', picture: '0x1f5750x1f3ff0x2642.png'});


        this.put({code: '0xdd76', key: '🕶', picture: '0x1f576.png'});
        this.put({code: '0xfe0f', key: '🕶️', picture: '0x1f576.png'});

        this.put({code: '0xdd77', key: '🕷', picture: '0x1f577.png'});
        this.put({code: '0xfe0f', key: '🕷️', picture: '0x1f577.png'});

        this.put({code: '0xdd78', key: '🕸', picture: '0x1f578.png'});
        this.put({code: '0xfe0f', key: '🕸️', picture: '0x1f578.png'});

        this.put({code: '0xdd79', key: '🕹', picture: '0x1f579.png'});
        this.put({code: '0xfe0f', key: '🕹️', picture: '0x1f579.png'});

        this.put({code: '0xdd7a', key: '🕺', picture: '0x1f57a.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🕺🏻', picture: '0x1f57a0x1f3fb.png'});
        this.put({code: '0xdffc', key: '🕺🏼', picture: '0x1f57a0x1f3fc.png'});
        this.put({code: '0xdffd', key: '🕺🏽', picture: '0x1f57a0x1f3fd.png'});
        this.put({code: '0xdffe', key: '🕺🏾', picture: '0x1f57a0x1f3fe.png'});
        this.put({code: '0xdfff', key: '🕺🏿', picture: '0x1f57a0x1f3ff.png'});


        this.put({code: '0xdd87', key: '🖇', picture: '0x1f587.png'});
        this.put({code: '0xfe0f', key: '🖇️', picture: '0x1f587.png'});

        this.put({code: '0xdd8a', key: '🖊', picture: '0x1f58a.png'});
        this.put({code: '0xfe0f', key: '🖊️', picture: '0x1f58a.png'});

        this.put({code: '0xdd8b', key: '🖋', picture: '0x1f58b.png'});
        this.put({code: '0xfe0f', key: '🖋️', picture: '0x1f58b.png'});

        this.put({code: '0xdd8c', key: '🖌', picture: '0x1f58c.png'});
        this.put({code: '0xfe0f', key: '🖌️', picture: '0x1f58c.png'});

        this.put({code: '0xdd8d', key: '🖍', picture: '0x1f58d.png'});
        this.put({code: '0xfe0f', key: '🖍️', picture: '0x1f58d.png'});

        this.put({code: '0xdd90', key: '🖐', picture: '0x1f590.png'});
        this.put({code: '0xfe0f', key: '🖐️', picture: '0x1f590.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🖐🏻', picture: '0x1f5900x1f3fb.png'});
        this.put({code: '0xdffc', key: '🖐🏼', picture: '0x1f5900x1f3fc.png'});
        this.put({code: '0xdffd', key: '🖐🏽', picture: '0x1f5900x1f3fd.png'});
        this.put({code: '0xdffe', key: '🖐🏾', picture: '0x1f5900x1f3fe.png'});
        this.put({code: '0xdfff', key: '🖐🏿', picture: '0x1f5900x1f3ff.png'});


        this.put({code: '0xdd95', key: '🖕', picture: '0x1f595.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🖕🏻', picture: '0x1f5950x1f3fb.png'});
        this.put({code: '0xdffc', key: '🖕🏼', picture: '0x1f5950x1f3fc.png'});
        this.put({code: '0xdffd', key: '🖕🏽', picture: '0x1f5950x1f3fd.png'});
        this.put({code: '0xdffe', key: '🖕🏾', picture: '0x1f5950x1f3fe.png'});
        this.put({code: '0xdfff', key: '🖕🏿', picture: '0x1f5950x1f3ff.png'});


        this.put({code: '0xdd96', key: '🖖', picture: '0x1f596.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🖖🏻', picture: '0x1f5960x1f3fb.png'});
        this.put({code: '0xdffc', key: '🖖🏼', picture: '0x1f5960x1f3fc.png'});
        this.put({code: '0xdffd', key: '🖖🏽', picture: '0x1f5960x1f3fd.png'});
        this.put({code: '0xdffe', key: '🖖🏾', picture: '0x1f5960x1f3fe.png'});
        this.put({code: '0xdfff', key: '🖖🏿', picture: '0x1f5960x1f3ff.png'});


        this.put({code: '0xdda4', key: '🖤', picture: '0x1f5a4.png'});
        this.put({code: '0xdda5', key: '🖥', picture: '0x1f5a5.png'});
        this.put({code: '0xfe0f', key: '🖥️', picture: '0x1f5a5.png'});

        this.put({code: '0xdda8', key: '🖨', picture: '0x1f5a8.png'});
        this.put({code: '0xfe0f', key: '🖨️', picture: '0x1f5a8.png'});

        this.put({code: '0xddb1', key: '🖱', picture: '0x1f5b1.png'});
        this.put({code: '0xfe0f', key: '🖱️', picture: '0x1f5b1.png'});

        this.put({code: '0xddb2', key: '🖲', picture: '0x1f5b2.png'});
        this.put({code: '0xfe0f', key: '🖲️', picture: '0x1f5b2.png'});

        this.put({code: '0xddbc', key: '🖼', picture: '0x1f5bc.png'});
        this.put({code: '0xfe0f', key: '🖼️', picture: '0x1f5bc.png'});

        this.put({code: '0xddc2', key: '🗂', picture: '0x1f5c2.png'});
        this.put({code: '0xfe0f', key: '🗂️', picture: '0x1f5c2.png'});

        this.put({code: '0xddc3', key: '🗃', picture: '0x1f5c3.png'});
        this.put({code: '0xfe0f', key: '🗃️', picture: '0x1f5c3.png'});

        this.put({code: '0xddc4', key: '🗄', picture: '0x1f5c4.png'});
        this.put({code: '0xfe0f', key: '🗄️', picture: '0x1f5c4.png'});

        this.put({code: '0xddd1', key: '🗑', picture: '0x1f5d1.png'});
        this.put({code: '0xfe0f', key: '🗑️', picture: '0x1f5d1.png'});

        this.put({code: '0xddd2', key: '🗒', picture: '0x1f5d2.png'});
        this.put({code: '0xfe0f', key: '🗒️', picture: '0x1f5d2.png'});

        this.put({code: '0xddd3', key: '🗓', picture: '0x1f5d3.png'});
        this.put({code: '0xfe0f', key: '🗓️', picture: '0x1f5d3.png'});

        this.put({code: '0xdddc', key: '🗜', picture: '0x1f5dc.png'});
        this.put({code: '0xfe0f', key: '🗜️', picture: '0x1f5dc.png'});

        this.put({code: '0xdddd', key: '🗝', picture: '0x1f5dd.png'});
        this.put({code: '0xfe0f', key: '🗝️', picture: '0x1f5dd.png'});

        this.put({code: '0xddde', key: '🗞', picture: '0x1f5de.png'});
        this.put({code: '0xfe0f', key: '🗞️', picture: '0x1f5de.png'});

        this.put({code: '0xdde1', key: '🗡', picture: '0x1f5e1.png'});
        this.put({code: '0xfe0f', key: '🗡️', picture: '0x1f5e1.png'});

        this.put({code: '0xdde3', key: '🗣', picture: '0x1f5e3.png'});
        this.put({code: '0xfe0f', key: '🗣️', picture: '0x1f5e3.png'});

        this.put({code: '0xdde8', key: '🗨', picture: '0x1f5e8.png'});
        this.put({code: '0xfe0f', key: '🗨️', picture: '0x1f5e8.png'});

        this.put({code: '0xddef', key: '🗯', picture: '0x1f5ef.png'});
        this.put({code: '0xfe0f', key: '🗯️', picture: '0x1f5ef.png'});

        this.put({code: '0xddf3', key: '🗳', picture: '0x1f5f3.png'});
        this.put({code: '0xfe0f', key: '🗳️', picture: '0x1f5f3.png'});

        this.put({code: '0xddfa', key: '🗺', picture: '0x1f5fa.png'});
        this.put({code: '0xfe0f', key: '🗺️', picture: '0x1f5fa.png'});

        this.put({code: '0xddfb', key: '🗻', picture: '0x1f5fb.png'});
        this.put({code: '0xddfc', key: '🗼', picture: '0x1f5fc.png'});
        this.put({code: '0xddfd', key: '🗽', picture: '0x1f5fd.png'});
        this.put({code: '0xddfe', key: '🗾', picture: '0x1f5fe.png'});
        this.put({code: '0xddff', key: '🗿', picture: '0x1f5ff.png'});


        this.put({code: '0xde80', key: '🚀', picture: '0x1f680.png'});
        this.put({code: '0xde81', key: '🚁', picture: '0x1f681.png'});
        this.put({code: '0xde82', key: '🚂', picture: '0x1f682.png'});
        this.put({code: '0xde83', key: '🚃', picture: '0x1f683.png'});
        this.put({code: '0xde84', key: '🚄', picture: '0x1f684.png'});
        this.put({code: '0xde85', key: '🚅', picture: '0x1f685.png'});
        this.put({code: '0xde86', key: '🚆', picture: '0x1f686.png'});
        this.put({code: '0xde87', key: '🚇', picture: '0x1f687.png'});
        this.put({code: '0xde88', key: '🚈', picture: '0x1f688.png'});
        this.put({code: '0xde89', key: '🚉', picture: '0x1f689.png'});
        this.put({code: '0xde8a', key: '🚊', picture: '0x1f68a.png'});
        this.put({code: '0xde8b', key: '🚋', picture: '0x1f68b.png'});
        this.put({code: '0xde8c', key: '🚌', picture: '0x1f68c.png'});
        this.put({code: '0xde8d', key: '🚍', picture: '0x1f68d.png'});
        this.put({code: '0xde8e', key: '🚎', picture: '0x1f68e.png'});
        this.put({code: '0xde8f', key: '🚏', picture: '0x1f68f.png'});
        this.put({code: '0xde90', key: '🚐', picture: '0x1f690.png'});
        this.put({code: '0xde91', key: '🚑', picture: '0x1f691.png'});
        this.put({code: '0xde92', key: '🚒', picture: '0x1f692.png'});
        this.put({code: '0xde93', key: '🚓', picture: '0x1f693.png'});
        this.put({code: '0xde94', key: '🚔', picture: '0x1f694.png'});
        this.put({code: '0xde95', key: '🚕', picture: '0x1f695.png'});
        this.put({code: '0xde96', key: '🚖', picture: '0x1f696.png'});
        this.put({code: '0xde97', key: '🚗', picture: '0x1f697.png'});
        this.put({code: '0xde98', key: '🚘', picture: '0x1f698.png'});
        this.put({code: '0xde99', key: '🚙', picture: '0x1f699.png'});
        this.put({code: '0xde9a', key: '🚚', picture: '0x1f69a.png'});
        this.put({code: '0xde9b', key: '🚛', picture: '0x1f69b.png'});
        this.put({code: '0xde9c', key: '🚜', picture: '0x1f69c.png'});
        this.put({code: '0xde9d', key: '🚝', picture: '0x1f69d.png'});
        this.put({code: '0xde9e', key: '🚞', picture: '0x1f69e.png'});
        this.put({code: '0xde9f', key: '🚟', picture: '0x1f69f.png'});
        this.put({code: '0xdea0', key: '🚠', picture: '0x1f6a0.png'});
        this.put({code: '0xdea1', key: '🚡', picture: '0x1f6a1.png'});
        this.put({code: '0xdea2', key: '🚢', picture: '0x1f6a2.png'});
        this.put({code: '0xdea3', key: '🚣', picture: '0x1f6a3.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🚣‍♀', picture: '0x1f6a30x2640.png'});
        this.put({code: '0xfe0f', key: '🚣‍♀️', picture: '0x1f6a30x2640.png'});

        this.put({code: '0x2642', key: '🚣‍♂', picture: '0x1f6a30x2642.png'});
        this.put({code: '0xfe0f', key: '🚣‍♂️', picture: '0x1f6a30x2642.png'});


        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🚣🏻', picture: '0x1f6a30x1f3fb.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🚣🏻‍♀', picture: '0x1f6a30x1f3fb0x2640.png'});
        this.put({code: '0xfe0f', key: '🚣🏻‍♀️', picture: '0x1f6a30x1f3fb0x2640.png'});

        this.put({code: '0x2642', key: '🚣🏻‍♂', picture: '0x1f6a30x1f3fb0x2642.png'});
        this.put({code: '0xfe0f', key: '🚣🏻‍♂️', picture: '0x1f6a30x1f3fb0x2642.png'});


        this.put({code: '0xdffc', key: '🚣🏼', picture: '0x1f6a30x1f3fc.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🚣🏼‍♀', picture: '0x1f6a30x1f3fc0x2640.png'});
        this.put({code: '0xfe0f', key: '🚣🏼‍♀️', picture: '0x1f6a30x1f3fc0x2640.png'});

        this.put({code: '0x2642', key: '🚣🏼‍♂', picture: '0x1f6a30x1f3fc0x2642.png'});
        this.put({code: '0xfe0f', key: '🚣🏼‍♂️', picture: '0x1f6a30x1f3fc0x2642.png'});


        this.put({code: '0xdffd', key: '🚣🏽', picture: '0x1f6a30x1f3fd.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🚣🏽‍♀', picture: '0x1f6a30x1f3fd0x2640.png'});
        this.put({code: '0xfe0f', key: '🚣🏽‍♀️', picture: '0x1f6a30x1f3fd0x2640.png'});

        this.put({code: '0x2642', key: '🚣🏽‍♂', picture: '0x1f6a30x1f3fd0x2642.png'});
        this.put({code: '0xfe0f', key: '🚣🏽‍♂️', picture: '0x1f6a30x1f3fd0x2642.png'});


        this.put({code: '0xdffe', key: '🚣🏾', picture: '0x1f6a30x1f3fe.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🚣🏾‍♀', picture: '0x1f6a30x1f3fe0x2640.png'});
        this.put({code: '0xfe0f', key: '🚣🏾‍♀️', picture: '0x1f6a30x1f3fe0x2640.png'});

        this.put({code: '0x2642', key: '🚣🏾‍♂', picture: '0x1f6a30x1f3fe0x2642.png'});
        this.put({code: '0xfe0f', key: '🚣🏾‍♂️', picture: '0x1f6a30x1f3fe0x2642.png'});


        this.put({code: '0xdfff', key: '🚣🏿', picture: '0x1f6a30x1f3ff.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🚣🏿‍♀', picture: '0x1f6a30x1f3ff0x2640.png'});
        this.put({code: '0xfe0f', key: '🚣🏿‍♀️', picture: '0x1f6a30x1f3ff0x2640.png'});

        this.put({code: '0x2642', key: '🚣🏿‍♂', picture: '0x1f6a30x1f3ff0x2642.png'});
        this.put({code: '0xfe0f', key: '🚣🏿‍♂️', picture: '0x1f6a30x1f3ff0x2642.png'});


        this.put({code: '0xdea4', key: '🚤', picture: '0x1f6a4.png'});
        this.put({code: '0xdea5', key: '🚥', picture: '0x1f6a5.png'});
        this.put({code: '0xdea6', key: '🚦', picture: '0x1f6a6.png'});
        this.put({code: '0xdea7', key: '🚧', picture: '0x1f6a7.png'});
        this.put({code: '0xdea8', key: '🚨', picture: '0x1f6a8.png'});
        this.put({code: '0xdea9', key: '🚩', picture: '0x1f6a9.png'});
        this.put({code: '0xdeaa', key: '🚪', picture: '0x1f6aa.png'});
        this.put({code: '0xdeab', key: '🚫', picture: '0x1f6ab.png'});
        this.put({code: '0xdeac', key: '🚬', picture: '0x1f6ac.png'});
        this.put({code: '0xdead', key: '🚭', picture: '0x1f6ad.png'});
        this.put({code: '0xdeae', key: '🚮', picture: '0x1f6ae.png'});
        this.put({code: '0xdeaf', key: '🚯', picture: '0x1f6af.png'});
        this.put({code: '0xdeb0', key: '🚰', picture: '0x1f6b0.png'});
        this.put({code: '0xdeb1', key: '🚱', picture: '0x1f6b1.png'});
        this.put({code: '0xdeb2', key: '🚲', picture: '0x1f6b2.png'});
        this.put({code: '0xdeb3', key: '🚳', picture: '0x1f6b3.png'});
        this.put({code: '0xdeb4', key: '🚴', picture: '0x1f6b4.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🚴‍♀', picture: '0x1f6b40x2640.png'});
        this.put({code: '0xfe0f', key: '🚴‍♀️', picture: '0x1f6b40x2640.png'});

        this.put({code: '0x2642', key: '🚴‍♂', picture: '0x1f6b40x2642.png'});
        this.put({code: '0xfe0f', key: '🚴‍♂️', picture: '0x1f6b40x2642.png'});


        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🚴🏻', picture: '0x1f6b40x1f3fb.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🚴🏻‍♀', picture: '0x1f6b40x1f3fb0x2640.png'});
        this.put({code: '0xfe0f', key: '🚴🏻‍♀️', picture: '0x1f6b40x1f3fb0x2640.png'});

        this.put({code: '0x2642', key: '🚴🏻‍♂', picture: '0x1f6b40x1f3fb0x2642.png'});
        this.put({code: '0xfe0f', key: '🚴🏻‍♂️', picture: '0x1f6b40x1f3fb0x2642.png'});


        this.put({code: '0xdffc', key: '🚴🏼', picture: '0x1f6b40x1f3fc.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🚴🏼‍♀', picture: '0x1f6b40x1f3fc0x2640.png'});
        this.put({code: '0xfe0f', key: '🚴🏼‍♀️', picture: '0x1f6b40x1f3fc0x2640.png'});

        this.put({code: '0x2642', key: '🚴🏼‍♂', picture: '0x1f6b40x1f3fc0x2642.png'});
        this.put({code: '0xfe0f', key: '🚴🏼‍♂️', picture: '0x1f6b40x1f3fc0x2642.png'});


        this.put({code: '0xdffd', key: '🚴🏽', picture: '0x1f6b40x1f3fd.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🚴🏽‍♀', picture: '0x1f6b40x1f3fd0x2640.png'});
        this.put({code: '0xfe0f', key: '🚴🏽‍♀️', picture: '0x1f6b40x1f3fd0x2640.png'});

        this.put({code: '0x2642', key: '🚴🏽‍♂', picture: '0x1f6b40x1f3fd0x2642.png'});
        this.put({code: '0xfe0f', key: '🚴🏽‍♂️', picture: '0x1f6b40x1f3fd0x2642.png'});


        this.put({code: '0xdffe', key: '🚴🏾', picture: '0x1f6b40x1f3fe.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🚴🏾‍♀', picture: '0x1f6b40x1f3fe0x2640.png'});
        this.put({code: '0xfe0f', key: '🚴🏾‍♀️', picture: '0x1f6b40x1f3fe0x2640.png'});

        this.put({code: '0x2642', key: '🚴🏾‍♂', picture: '0x1f6b40x1f3fe0x2642.png'});
        this.put({code: '0xfe0f', key: '🚴🏾‍♂️', picture: '0x1f6b40x1f3fe0x2642.png'});


        this.put({code: '0xdfff', key: '🚴🏿', picture: '0x1f6b40x1f3ff.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🚴🏿‍♀', picture: '0x1f6b40x1f3ff0x2640.png'});
        this.put({code: '0xfe0f', key: '🚴🏿‍♀️', picture: '0x1f6b40x1f3ff0x2640.png'});

        this.put({code: '0x2642', key: '🚴🏿‍♂', picture: '0x1f6b40x1f3ff0x2642.png'});
        this.put({code: '0xfe0f', key: '🚴🏿‍♂️', picture: '0x1f6b40x1f3ff0x2642.png'});


        this.put({code: '0xdeb5', key: '🚵', picture: '0x1f6b5.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🚵‍♀', picture: '0x1f6b50x2640.png'});
        this.put({code: '0xfe0f', key: '🚵‍♀️', picture: '0x1f6b50x2640.png'});

        this.put({code: '0x2642', key: '🚵‍♂', picture: '0x1f6b50x2642.png'});
        this.put({code: '0xfe0f', key: '🚵‍♂️', picture: '0x1f6b50x2642.png'});


        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🚵🏻', picture: '0x1f6b50x1f3fb.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🚵🏻‍♀', picture: '0x1f6b50x1f3fb0x2640.png'});
        this.put({code: '0xfe0f', key: '🚵🏻‍♀️', picture: '0x1f6b50x1f3fb0x2640.png'});

        this.put({code: '0x2642', key: '🚵🏻‍♂', picture: '0x1f6b50x1f3fb0x2642.png'});
        this.put({code: '0xfe0f', key: '🚵🏻‍♂️', picture: '0x1f6b50x1f3fb0x2642.png'});


        this.put({code: '0xdffc', key: '🚵🏼', picture: '0x1f6b50x1f3fc.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🚵🏼‍♀', picture: '0x1f6b50x1f3fc0x2640.png'});
        this.put({code: '0xfe0f', key: '🚵🏼‍♀️', picture: '0x1f6b50x1f3fc0x2640.png'});

        this.put({code: '0x2642', key: '🚵🏼‍♂', picture: '0x1f6b50x1f3fc0x2642.png'});
        this.put({code: '0xfe0f', key: '🚵🏼‍♂️', picture: '0x1f6b50x1f3fc0x2642.png'});


        this.put({code: '0xdffd', key: '🚵🏽', picture: '0x1f6b50x1f3fd.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🚵🏽‍♀', picture: '0x1f6b50x1f3fd0x2640.png'});
        this.put({code: '0xfe0f', key: '🚵🏽‍♀️', picture: '0x1f6b50x1f3fd0x2640.png'});

        this.put({code: '0x2642', key: '🚵🏽‍♂', picture: '0x1f6b50x1f3fd0x2642.png'});
        this.put({code: '0xfe0f', key: '🚵🏽‍♂️', picture: '0x1f6b50x1f3fd0x2642.png'});


        this.put({code: '0xdffe', key: '🚵🏾', picture: '0x1f6b50x1f3fe.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🚵🏾‍♀', picture: '0x1f6b50x1f3fe0x2640.png'});
        this.put({code: '0xfe0f', key: '🚵🏾‍♀️', picture: '0x1f6b50x1f3fe0x2640.png'});

        this.put({code: '0x2642', key: '🚵🏾‍♂', picture: '0x1f6b50x1f3fe0x2642.png'});
        this.put({code: '0xfe0f', key: '🚵🏾‍♂️', picture: '0x1f6b50x1f3fe0x2642.png'});


        this.put({code: '0xdfff', key: '🚵🏿', picture: '0x1f6b50x1f3ff.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🚵🏿‍♀', picture: '0x1f6b50x1f3ff0x2640.png'});
        this.put({code: '0xfe0f', key: '🚵🏿‍♀️', picture: '0x1f6b50x1f3ff0x2640.png'});

        this.put({code: '0x2642', key: '🚵🏿‍♂', picture: '0x1f6b50x1f3ff0x2642.png'});
        this.put({code: '0xfe0f', key: '🚵🏿‍♂️', picture: '0x1f6b50x1f3ff0x2642.png'});


        this.put({code: '0xdeb6', key: '🚶', picture: '0x1f6b6.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🚶‍♀', picture: '0x1f6b60x2640.png'});
        this.put({code: '0xfe0f', key: '🚶‍♀️', picture: '0x1f6b60x2640.png'});

        this.put({code: '0x2642', key: '🚶‍♂', picture: '0x1f6b60x2642.png'});
        this.put({code: '0xfe0f', key: '🚶‍♂️', picture: '0x1f6b60x2642.png'});


        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🚶🏻', picture: '0x1f6b60x1f3fb.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🚶🏻‍♀', picture: '0x1f6b60x1f3fb0x2640.png'});
        this.put({code: '0xfe0f', key: '🚶🏻‍♀️', picture: '0x1f6b60x1f3fb0x2640.png'});

        this.put({code: '0x2642', key: '🚶🏻‍♂', picture: '0x1f6b60x1f3fb0x2642.png'});
        this.put({code: '0xfe0f', key: '🚶🏻‍♂️', picture: '0x1f6b60x1f3fb0x2642.png'});


        this.put({code: '0xdffc', key: '🚶🏼', picture: '0x1f6b60x1f3fc.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🚶🏼‍♀', picture: '0x1f6b60x1f3fc0x2640.png'});
        this.put({code: '0xfe0f', key: '🚶🏼‍♀️', picture: '0x1f6b60x1f3fc0x2640.png'});

        this.put({code: '0x2642', key: '🚶🏼‍♂', picture: '0x1f6b60x1f3fc0x2642.png'});
        this.put({code: '0xfe0f', key: '🚶🏼‍♂️', picture: '0x1f6b60x1f3fc0x2642.png'});


        this.put({code: '0xdffd', key: '🚶🏽', picture: '0x1f6b60x1f3fd.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🚶🏽‍♀', picture: '0x1f6b60x1f3fd0x2640.png'});
        this.put({code: '0xfe0f', key: '🚶🏽‍♀️', picture: '0x1f6b60x1f3fd0x2640.png'});

        this.put({code: '0x2642', key: '🚶🏽‍♂', picture: '0x1f6b60x1f3fd0x2642.png'});
        this.put({code: '0xfe0f', key: '🚶🏽‍♂️', picture: '0x1f6b60x1f3fd0x2642.png'});


        this.put({code: '0xdffe', key: '🚶🏾', picture: '0x1f6b60x1f3fe.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🚶🏾‍♀', picture: '0x1f6b60x1f3fe0x2640.png'});
        this.put({code: '0xfe0f', key: '🚶🏾‍♀️', picture: '0x1f6b60x1f3fe0x2640.png'});

        this.put({code: '0x2642', key: '🚶🏾‍♂', picture: '0x1f6b60x1f3fe0x2642.png'});
        this.put({code: '0xfe0f', key: '🚶🏾‍♂️', picture: '0x1f6b60x1f3fe0x2642.png'});


        this.put({code: '0xdfff', key: '🚶🏿', picture: '0x1f6b60x1f3ff.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🚶🏿‍♀', picture: '0x1f6b60x1f3ff0x2640.png'});
        this.put({code: '0xfe0f', key: '🚶🏿‍♀️', picture: '0x1f6b60x1f3ff0x2640.png'});

        this.put({code: '0x2642', key: '🚶🏿‍♂', picture: '0x1f6b60x1f3ff0x2642.png'});
        this.put({code: '0xfe0f', key: '🚶🏿‍♂️', picture: '0x1f6b60x1f3ff0x2642.png'});


        this.put({code: '0xdeb7', key: '🚷', picture: '0x1f6b7.png'});
        this.put({code: '0xdeb8', key: '🚸', picture: '0x1f6b8.png'});
        this.put({code: '0xdeb9', key: '🚹', picture: '0x1f6b9.png'});
        this.put({code: '0xdeba', key: '🚺', picture: '0x1f6ba.png'});
        this.put({code: '0xdebb', key: '🚻', picture: '0x1f6bb.png'});
        this.put({code: '0xdebc', key: '🚼', picture: '0x1f6bc.png'});
        this.put({code: '0xdebd', key: '🚽', picture: '0x1f6bd.png'});
        this.put({code: '0xdebe', key: '🚾', picture: '0x1f6be.png'});
        this.put({code: '0xdebf', key: '🚿', picture: '0x1f6bf.png'});
        this.put({code: '0xdec0', key: '🛀', picture: '0x1f6c0.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🛀🏻', picture: '0x1f6c00x1f3fb.png'});
        this.put({code: '0xdffc', key: '🛀🏼', picture: '0x1f6c00x1f3fc.png'});
        this.put({code: '0xdffd', key: '🛀🏽', picture: '0x1f6c00x1f3fd.png'});
        this.put({code: '0xdffe', key: '🛀🏾', picture: '0x1f6c00x1f3fe.png'});
        this.put({code: '0xdfff', key: '🛀🏿', picture: '0x1f6c00x1f3ff.png'});


        this.put({code: '0xdec1', key: '🛁', picture: '0x1f6c1.png'});
        this.put({code: '0xdec2', key: '🛂', picture: '0x1f6c2.png'});
        this.put({code: '0xdec3', key: '🛃', picture: '0x1f6c3.png'});
        this.put({code: '0xdec4', key: '🛄', picture: '0x1f6c4.png'});
        this.put({code: '0xdec5', key: '🛅', picture: '0x1f6c5.png'});
        this.put({code: '0xdecb', key: '🛋', picture: '0x1f6cb.png'});
        this.put({code: '0xfe0f', key: '🛋️', picture: '0x1f6cb.png'});

        this.put({code: '0xdecc', key: '🛌', picture: '0x1f6cc.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🛌🏻', picture: '0x1f6cc0x1f3fb.png'});
        this.put({code: '0xdffc', key: '🛌🏼', picture: '0x1f6cc0x1f3fc.png'});
        this.put({code: '0xdffd', key: '🛌🏽', picture: '0x1f6cc0x1f3fd.png'});
        this.put({code: '0xdffe', key: '🛌🏾', picture: '0x1f6cc0x1f3fe.png'});
        this.put({code: '0xdfff', key: '🛌🏿', picture: '0x1f6cc0x1f3ff.png'});


        this.put({code: '0xdecd', key: '🛍', picture: '0x1f6cd.png'});
        this.put({code: '0xfe0f', key: '🛍️', picture: '0x1f6cd.png'});

        this.put({code: '0xdece', key: '🛎', picture: '0x1f6ce.png'});
        this.put({code: '0xfe0f', key: '🛎️', picture: '0x1f6ce.png'});

        this.put({code: '0xdecf', key: '🛏', picture: '0x1f6cf.png'});
        this.put({code: '0xfe0f', key: '🛏️', picture: '0x1f6cf.png'});

        this.put({code: '0xded0', key: '🛐', picture: '0x1f6d0.png'});
        this.put({code: '0xded1', key: '🛑', picture: '0x1f6d1.png'});
        this.put({code: '0xded2', key: '🛒', picture: '0x1f6d2.png'});
        this.put({code: '0xdee0', key: '🛠', picture: '0x1f6e0.png'});
        this.put({code: '0xfe0f', key: '🛠️', picture: '0x1f6e0.png'});

        this.put({code: '0xdee1', key: '🛡', picture: '0x1f6e1.png'});
        this.put({code: '0xfe0f', key: '🛡️', picture: '0x1f6e1.png'});

        this.put({code: '0xdee2', key: '🛢', picture: '0x1f6e2.png'});
        this.put({code: '0xfe0f', key: '🛢️', picture: '0x1f6e2.png'});

        this.put({code: '0xdee3', key: '🛣', picture: '0x1f6e3.png'});
        this.put({code: '0xfe0f', key: '🛣️', picture: '0x1f6e3.png'});

        this.put({code: '0xdee4', key: '🛤', picture: '0x1f6e4.png'});
        this.put({code: '0xfe0f', key: '🛤️', picture: '0x1f6e4.png'});

        this.put({code: '0xdee5', key: '🛥', picture: '0x1f6e5.png'});
        this.put({code: '0xfe0f', key: '🛥️', picture: '0x1f6e5.png'});

        this.put({code: '0xdee9', key: '🛩', picture: '0x1f6e9.png'});
        this.put({code: '0xfe0f', key: '🛩️', picture: '0x1f6e9.png'});

        this.put({code: '0xdeeb', key: '🛫', picture: '0x1f6eb.png'});
        this.put({code: '0xdeec', key: '🛬', picture: '0x1f6ec.png'});
        this.put({code: '0xdef0', key: '🛰', picture: '0x1f6f0.png'});
        this.put({code: '0xfe0f', key: '🛰️', picture: '0x1f6f0.png'});

        this.put({code: '0xdef3', key: '🛳', picture: '0x1f6f3.png'});
        this.put({code: '0xfe0f', key: '🛳️', picture: '0x1f6f3.png'});

        this.put({code: '0xdef4', key: '🛴', picture: '0x1f6f4.png'});
        this.put({code: '0xdef5', key: '🛵', picture: '0x1f6f5.png'});
        this.put({code: '0xdef6', key: '🛶', picture: '0x1f6f6.png'});

        this.put({code: '0xd83e'});
        this.put({code: '0xdd10', key: '🤐', picture: '0x1f910.png'});
        this.put({code: '0xdd11', key: '🤑', picture: '0x1f911.png'});
        this.put({code: '0xdd12', key: '🤒', picture: '0x1f912.png'});
        this.put({code: '0xdd13', key: '🤓', picture: '0x1f913.png'});
        this.put({code: '0xdd14', key: '🤔', picture: '0x1f914.png'});
        this.put({code: '0xdd15', key: '🤕', picture: '0x1f915.png'});
        this.put({code: '0xdd16', key: '🤖', picture: '0x1f916.png'});
        this.put({code: '0xdd17', key: '🤗', picture: '0x1f917.png'});
        this.put({code: '0xdd18', key: '🤘', picture: '0x1f918.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🤘🏻', picture: '0x1f9180x1f3fb.png'});
        this.put({code: '0xdffc', key: '🤘🏼', picture: '0x1f9180x1f3fc.png'});
        this.put({code: '0xdffd', key: '🤘🏽', picture: '0x1f9180x1f3fd.png'});
        this.put({code: '0xdffe', key: '🤘🏾', picture: '0x1f9180x1f3fe.png'});
        this.put({code: '0xdfff', key: '🤘🏿', picture: '0x1f9180x1f3ff.png'});


        this.put({code: '0xdd19', key: '🤙', picture: '0x1f919.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🤙🏻', picture: '0x1f9190x1f3fb.png'});
        this.put({code: '0xdffc', key: '🤙🏼', picture: '0x1f9190x1f3fc.png'});
        this.put({code: '0xdffd', key: '🤙🏽', picture: '0x1f9190x1f3fd.png'});
        this.put({code: '0xdffe', key: '🤙🏾', picture: '0x1f9190x1f3fe.png'});
        this.put({code: '0xdfff', key: '🤙🏿', picture: '0x1f9190x1f3ff.png'});


        this.put({code: '0xdd1a', key: '🤚', picture: '0x1f91a.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🤚🏻', picture: '0x1f91a0x1f3fb.png'});
        this.put({code: '0xdffc', key: '🤚🏼', picture: '0x1f91a0x1f3fc.png'});
        this.put({code: '0xdffd', key: '🤚🏽', picture: '0x1f91a0x1f3fd.png'});
        this.put({code: '0xdffe', key: '🤚🏾', picture: '0x1f91a0x1f3fe.png'});
        this.put({code: '0xdfff', key: '🤚🏿', picture: '0x1f91a0x1f3ff.png'});


        this.put({code: '0xdd1b', key: '🤛', picture: '0x1f91b.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🤛🏻', picture: '0x1f91b0x1f3fb.png'});
        this.put({code: '0xdffc', key: '🤛🏼', picture: '0x1f91b0x1f3fc.png'});
        this.put({code: '0xdffd', key: '🤛🏽', picture: '0x1f91b0x1f3fd.png'});
        this.put({code: '0xdffe', key: '🤛🏾', picture: '0x1f91b0x1f3fe.png'});
        this.put({code: '0xdfff', key: '🤛🏿', picture: '0x1f91b0x1f3ff.png'});


        this.put({code: '0xdd1c', key: '🤜', picture: '0x1f91c.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🤜🏻', picture: '0x1f91c0x1f3fb.png'});
        this.put({code: '0xdffc', key: '🤜🏼', picture: '0x1f91c0x1f3fc.png'});
        this.put({code: '0xdffd', key: '🤜🏽', picture: '0x1f91c0x1f3fd.png'});
        this.put({code: '0xdffe', key: '🤜🏾', picture: '0x1f91c0x1f3fe.png'});
        this.put({code: '0xdfff', key: '🤜🏿', picture: '0x1f91c0x1f3ff.png'});


        this.put({code: '0xdd1d', key: '🤝', picture: '0x1f91d.png'});
        this.put({code: '0xdd1e', key: '🤞', picture: '0x1f91e.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🤞🏻', picture: '0x1f91e0x1f3fb.png'});
        this.put({code: '0xdffc', key: '🤞🏼', picture: '0x1f91e0x1f3fc.png'});
        this.put({code: '0xdffd', key: '🤞🏽', picture: '0x1f91e0x1f3fd.png'});
        this.put({code: '0xdffe', key: '🤞🏾', picture: '0x1f91e0x1f3fe.png'});
        this.put({code: '0xdfff', key: '🤞🏿', picture: '0x1f91e0x1f3ff.png'});


        this.put({code: '0xdd20', key: '🤠', picture: '0x1f920.png'});
        this.put({code: '0xdd21', key: '🤡', picture: '0x1f921.png'});
        this.put({code: '0xdd22', key: '🤢', picture: '0x1f922.png'});
        this.put({code: '0xdd23', key: '🤣', picture: '0x1f923.png'});
        this.put({code: '0xdd24', key: '🤤', picture: '0x1f924.png'});
        this.put({code: '0xdd25', key: '🤥', picture: '0x1f925.png'});
        this.put({code: '0xdd26', key: '🤦', picture: '0x1f926.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤦‍♀', picture: '0x1f9260x2640.png'});
        this.put({code: '0xfe0f', key: '🤦‍♀️', picture: '0x1f9260x2640.png'});

        this.put({code: '0x2642', key: '🤦‍♂', picture: '0x1f9260x2642.png'});
        this.put({code: '0xfe0f', key: '🤦‍♂️', picture: '0x1f9260x2642.png'});


        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🤦🏻', picture: '0x1f9260x1f3fb.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤦🏻‍♀', picture: '0x1f9260x1f3fb0x2640.png'});
        this.put({code: '0xfe0f', key: '🤦🏻‍♀️', picture: '0x1f9260x1f3fb0x2640.png'});

        this.put({code: '0x2642', key: '🤦🏻‍♂', picture: '0x1f9260x1f3fb0x2642.png'});
        this.put({code: '0xfe0f', key: '🤦🏻‍♂️', picture: '0x1f9260x1f3fb0x2642.png'});


        this.put({code: '0xdffc', key: '🤦🏼', picture: '0x1f9260x1f3fc.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤦🏼‍♀', picture: '0x1f9260x1f3fc0x2640.png'});
        this.put({code: '0xfe0f', key: '🤦🏼‍♀️', picture: '0x1f9260x1f3fc0x2640.png'});

        this.put({code: '0x2642', key: '🤦🏼‍♂', picture: '0x1f9260x1f3fc0x2642.png'});
        this.put({code: '0xfe0f', key: '🤦🏼‍♂️', picture: '0x1f9260x1f3fc0x2642.png'});


        this.put({code: '0xdffd', key: '🤦🏽', picture: '0x1f9260x1f3fd.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤦🏽‍♀', picture: '0x1f9260x1f3fd0x2640.png'});
        this.put({code: '0xfe0f', key: '🤦🏽‍♀️', picture: '0x1f9260x1f3fd0x2640.png'});

        this.put({code: '0x2642', key: '🤦🏽‍♂', picture: '0x1f9260x1f3fd0x2642.png'});
        this.put({code: '0xfe0f', key: '🤦🏽‍♂️', picture: '0x1f9260x1f3fd0x2642.png'});


        this.put({code: '0xdffe', key: '🤦🏾', picture: '0x1f9260x1f3fe.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤦🏾‍♀', picture: '0x1f9260x1f3fe0x2640.png'});
        this.put({code: '0xfe0f', key: '🤦🏾‍♀️', picture: '0x1f9260x1f3fe0x2640.png'});

        this.put({code: '0x2642', key: '🤦🏾‍♂', picture: '0x1f9260x1f3fe0x2642.png'});
        this.put({code: '0xfe0f', key: '🤦🏾‍♂️', picture: '0x1f9260x1f3fe0x2642.png'});


        this.put({code: '0xdfff', key: '🤦🏿', picture: '0x1f9260x1f3ff.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤦🏿‍♀', picture: '0x1f9260x1f3ff0x2640.png'});
        this.put({code: '0xfe0f', key: '🤦🏿‍♀️', picture: '0x1f9260x1f3ff0x2640.png'});

        this.put({code: '0x2642', key: '🤦🏿‍♂', picture: '0x1f9260x1f3ff0x2642.png'});
        this.put({code: '0xfe0f', key: '🤦🏿‍♂️', picture: '0x1f9260x1f3ff0x2642.png'});


        this.put({code: '0xdd27', key: '🤧', picture: '0x1f927.png'});
        this.put({code: '0xdd30', key: '🤰', picture: '0x1f930.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🤰🏻', picture: '0x1f9300x1f3fb.png'});
        this.put({code: '0xdffc', key: '🤰🏼', picture: '0x1f9300x1f3fc.png'});
        this.put({code: '0xdffd', key: '🤰🏽', picture: '0x1f9300x1f3fd.png'});
        this.put({code: '0xdffe', key: '🤰🏾', picture: '0x1f9300x1f3fe.png'});
        this.put({code: '0xdfff', key: '🤰🏿', picture: '0x1f9300x1f3ff.png'});


        this.put({code: '0xdd33', key: '🤳', picture: '0x1f933.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🤳🏻', picture: '0x1f9330x1f3fb.png'});
        this.put({code: '0xdffc', key: '🤳🏼', picture: '0x1f9330x1f3fc.png'});
        this.put({code: '0xdffd', key: '🤳🏽', picture: '0x1f9330x1f3fd.png'});
        this.put({code: '0xdffe', key: '🤳🏾', picture: '0x1f9330x1f3fe.png'});
        this.put({code: '0xdfff', key: '🤳🏿', picture: '0x1f9330x1f3ff.png'});


        this.put({code: '0xdd34', key: '🤴', picture: '0x1f934.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🤴🏻', picture: '0x1f9340x1f3fb.png'});
        this.put({code: '0xdffc', key: '🤴🏼', picture: '0x1f9340x1f3fc.png'});
        this.put({code: '0xdffd', key: '🤴🏽', picture: '0x1f9340x1f3fd.png'});
        this.put({code: '0xdffe', key: '🤴🏾', picture: '0x1f9340x1f3fe.png'});
        this.put({code: '0xdfff', key: '🤴🏿', picture: '0x1f9340x1f3ff.png'});


        this.put({code: '0xdd35', key: '🤵', picture: '0x1f935.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🤵🏻', picture: '0x1f9350x1f3fb.png'});
        this.put({code: '0xdffc', key: '🤵🏼', picture: '0x1f9350x1f3fc.png'});
        this.put({code: '0xdffd', key: '🤵🏽', picture: '0x1f9350x1f3fd.png'});
        this.put({code: '0xdffe', key: '🤵🏾', picture: '0x1f9350x1f3fe.png'});
        this.put({code: '0xdfff', key: '🤵🏿', picture: '0x1f9350x1f3ff.png'});


        this.put({code: '0xdd36', key: '🤶', picture: '0x1f936.png'});
        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🤶🏻', picture: '0x1f9360x1f3fb.png'});
        this.put({code: '0xdffc', key: '🤶🏼', picture: '0x1f9360x1f3fc.png'});
        this.put({code: '0xdffd', key: '🤶🏽', picture: '0x1f9360x1f3fd.png'});
        this.put({code: '0xdffe', key: '🤶🏾', picture: '0x1f9360x1f3fe.png'});
        this.put({code: '0xdfff', key: '🤶🏿', picture: '0x1f9360x1f3ff.png'});


        this.put({code: '0xdd37', key: '🤷', picture: '0x1f937.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤷‍♀', picture: '0x1f9370x2640.png'});
        this.put({code: '0xfe0f', key: '🤷‍♀️', picture: '0x1f9370x2640.png'});

        this.put({code: '0x2642', key: '🤷‍♂', picture: '0x1f9370x2642.png'});
        this.put({code: '0xfe0f', key: '🤷‍♂️', picture: '0x1f9370x2642.png'});


        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🤷🏻', picture: '0x1f9370x1f3fb.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤷🏻‍♀', picture: '0x1f9370x1f3fb0x2640.png'});
        this.put({code: '0xfe0f', key: '🤷🏻‍♀️', picture: '0x1f9370x1f3fb0x2640.png'});

        this.put({code: '0x2642', key: '🤷🏻‍♂', picture: '0x1f9370x1f3fb0x2642.png'});
        this.put({code: '0xfe0f', key: '🤷🏻‍♂️', picture: '0x1f9370x1f3fb0x2642.png'});


        this.put({code: '0xdffc', key: '🤷🏼', picture: '0x1f9370x1f3fc.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤷🏼‍♀', picture: '0x1f9370x1f3fc0x2640.png'});
        this.put({code: '0xfe0f', key: '🤷🏼‍♀️', picture: '0x1f9370x1f3fc0x2640.png'});

        this.put({code: '0x2642', key: '🤷🏼‍♂', picture: '0x1f9370x1f3fc0x2642.png'});
        this.put({code: '0xfe0f', key: '🤷🏼‍♂️', picture: '0x1f9370x1f3fc0x2642.png'});


        this.put({code: '0xdffd', key: '🤷🏽', picture: '0x1f9370x1f3fd.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤷🏽‍♀', picture: '0x1f9370x1f3fd0x2640.png'});
        this.put({code: '0xfe0f', key: '🤷🏽‍♀️', picture: '0x1f9370x1f3fd0x2640.png'});

        this.put({code: '0x2642', key: '🤷🏽‍♂', picture: '0x1f9370x1f3fd0x2642.png'});
        this.put({code: '0xfe0f', key: '🤷🏽‍♂️', picture: '0x1f9370x1f3fd0x2642.png'});


        this.put({code: '0xdffe', key: '🤷🏾', picture: '0x1f9370x1f3fe.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤷🏾‍♀', picture: '0x1f9370x1f3fe0x2640.png'});
        this.put({code: '0xfe0f', key: '🤷🏾‍♀️', picture: '0x1f9370x1f3fe0x2640.png'});

        this.put({code: '0x2642', key: '🤷🏾‍♂', picture: '0x1f9370x1f3fe0x2642.png'});
        this.put({code: '0xfe0f', key: '🤷🏾‍♂️', picture: '0x1f9370x1f3fe0x2642.png'});


        this.put({code: '0xdfff', key: '🤷🏿', picture: '0x1f9370x1f3ff.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤷🏿‍♀', picture: '0x1f9370x1f3ff0x2640.png'});
        this.put({code: '0xfe0f', key: '🤷🏿‍♀️', picture: '0x1f9370x1f3ff0x2640.png'});

        this.put({code: '0x2642', key: '🤷🏿‍♂', picture: '0x1f9370x1f3ff0x2642.png'});
        this.put({code: '0xfe0f', key: '🤷🏿‍♂️', picture: '0x1f9370x1f3ff0x2642.png'});


        this.put({code: '0xdd38', key: '🤸', picture: '0x1f938.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤸‍♀', picture: '0x1f9380x2640.png'});
        this.put({code: '0xfe0f', key: '🤸‍♀️', picture: '0x1f9380x2640.png'});

        this.put({code: '0x2642', key: '🤸‍♂', picture: '0x1f9380x2642.png'});
        this.put({code: '0xfe0f', key: '🤸‍♂️', picture: '0x1f9380x2642.png'});


        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🤸🏻', picture: '0x1f9380x1f3fb.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤸🏻‍♀', picture: '0x1f9380x1f3fb0x2640.png'});
        this.put({code: '0xfe0f', key: '🤸🏻‍♀️', picture: '0x1f9380x1f3fb0x2640.png'});

        this.put({code: '0x2642', key: '🤸🏻‍♂', picture: '0x1f9380x1f3fb0x2642.png'});
        this.put({code: '0xfe0f', key: '🤸🏻‍♂️', picture: '0x1f9380x1f3fb0x2642.png'});


        this.put({code: '0xdffc', key: '🤸🏼', picture: '0x1f9380x1f3fc.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤸🏼‍♀', picture: '0x1f9380x1f3fc0x2640.png'});
        this.put({code: '0xfe0f', key: '🤸🏼‍♀️', picture: '0x1f9380x1f3fc0x2640.png'});

        this.put({code: '0x2642', key: '🤸🏼‍♂', picture: '0x1f9380x1f3fc0x2642.png'});
        this.put({code: '0xfe0f', key: '🤸🏼‍♂️', picture: '0x1f9380x1f3fc0x2642.png'});


        this.put({code: '0xdffd', key: '🤸🏽', picture: '0x1f9380x1f3fd.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤸🏽‍♀', picture: '0x1f9380x1f3fd0x2640.png'});
        this.put({code: '0xfe0f', key: '🤸🏽‍♀️', picture: '0x1f9380x1f3fd0x2640.png'});

        this.put({code: '0x2642', key: '🤸🏽‍♂', picture: '0x1f9380x1f3fd0x2642.png'});
        this.put({code: '0xfe0f', key: '🤸🏽‍♂️', picture: '0x1f9380x1f3fd0x2642.png'});


        this.put({code: '0xdffe', key: '🤸🏾', picture: '0x1f9380x1f3fe.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤸🏾‍♀', picture: '0x1f9380x1f3fe0x2640.png'});
        this.put({code: '0xfe0f', key: '🤸🏾‍♀️', picture: '0x1f9380x1f3fe0x2640.png'});

        this.put({code: '0x2642', key: '🤸🏾‍♂', picture: '0x1f9380x1f3fe0x2642.png'});
        this.put({code: '0xfe0f', key: '🤸🏾‍♂️', picture: '0x1f9380x1f3fe0x2642.png'});


        this.put({code: '0xdfff', key: '🤸🏿', picture: '0x1f9380x1f3ff.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤸🏿‍♀', picture: '0x1f9380x1f3ff0x2640.png'});
        this.put({code: '0xfe0f', key: '🤸🏿‍♀️', picture: '0x1f9380x1f3ff0x2640.png'});

        this.put({code: '0x2642', key: '🤸🏿‍♂', picture: '0x1f9380x1f3ff0x2642.png'});
        this.put({code: '0xfe0f', key: '🤸🏿‍♂️', picture: '0x1f9380x1f3ff0x2642.png'});


        this.put({code: '0xdd39', key: '🤹', picture: '0x1f939.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤹‍♀', picture: '0x1f9390x2640.png'});
        this.put({code: '0xfe0f', key: '🤹‍♀️', picture: '0x1f9390x2640.png'});

        this.put({code: '0x2642', key: '🤹‍♂', picture: '0x1f9390x2642.png'});
        this.put({code: '0xfe0f', key: '🤹‍♂️', picture: '0x1f9390x2642.png'});


        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🤹🏻', picture: '0x1f9390x1f3fb.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤹🏻‍♀', picture: '0x1f9390x1f3fb0x2640.png'});
        this.put({code: '0xfe0f', key: '🤹🏻‍♀️', picture: '0x1f9390x1f3fb0x2640.png'});

        this.put({code: '0x2642', key: '🤹🏻‍♂', picture: '0x1f9390x1f3fb0x2642.png'});
        this.put({code: '0xfe0f', key: '🤹🏻‍♂️', picture: '0x1f9390x1f3fb0x2642.png'});


        this.put({code: '0xdffc', key: '🤹🏼', picture: '0x1f9390x1f3fc.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤹🏼‍♀', picture: '0x1f9390x1f3fc0x2640.png'});
        this.put({code: '0xfe0f', key: '🤹🏼‍♀️', picture: '0x1f9390x1f3fc0x2640.png'});

        this.put({code: '0x2642', key: '🤹🏼‍♂', picture: '0x1f9390x1f3fc0x2642.png'});
        this.put({code: '0xfe0f', key: '🤹🏼‍♂️', picture: '0x1f9390x1f3fc0x2642.png'});


        this.put({code: '0xdffd', key: '🤹🏽', picture: '0x1f9390x1f3fd.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤹🏽‍♀', picture: '0x1f9390x1f3fd0x2640.png'});
        this.put({code: '0xfe0f', key: '🤹🏽‍♀️', picture: '0x1f9390x1f3fd0x2640.png'});

        this.put({code: '0x2642', key: '🤹🏽‍♂', picture: '0x1f9390x1f3fd0x2642.png'});
        this.put({code: '0xfe0f', key: '🤹🏽‍♂️', picture: '0x1f9390x1f3fd0x2642.png'});


        this.put({code: '0xdffe', key: '🤹🏾', picture: '0x1f9390x1f3fe.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤹🏾‍♀', picture: '0x1f9390x1f3fe0x2640.png'});
        this.put({code: '0xfe0f', key: '🤹🏾‍♀️', picture: '0x1f9390x1f3fe0x2640.png'});

        this.put({code: '0x2642', key: '🤹🏾‍♂', picture: '0x1f9390x1f3fe0x2642.png'});
        this.put({code: '0xfe0f', key: '🤹🏾‍♂️', picture: '0x1f9390x1f3fe0x2642.png'});


        this.put({code: '0xdfff', key: '🤹🏿', picture: '0x1f9390x1f3ff.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤹🏿‍♀', picture: '0x1f9390x1f3ff0x2640.png'});
        this.put({code: '0xfe0f', key: '🤹🏿‍♀️', picture: '0x1f9390x1f3ff0x2640.png'});

        this.put({code: '0x2642', key: '🤹🏿‍♂', picture: '0x1f9390x1f3ff0x2642.png'});
        this.put({code: '0xfe0f', key: '🤹🏿‍♂️', picture: '0x1f9390x1f3ff0x2642.png'});


        this.put({code: '0xdd3a', key: '🤺', picture: '0x1f93a.png'});
        this.put({code: '0xdd3c', key: '🤼', picture: '0x1f93c.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤼‍♀', picture: '0x1f93c0x2640.png'});
        this.put({code: '0xfe0f', key: '🤼‍♀️', picture: '0x1f93c0x2640.png'});

        this.put({code: '0x2642', key: '🤼‍♂', picture: '0x1f93c0x2642.png'});
        this.put({code: '0xfe0f', key: '🤼‍♂️', picture: '0x1f93c0x2642.png'});


        this.put({code: '0xdd3d', key: '🤽', picture: '0x1f93d.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤽‍♀', picture: '0x1f93d0x2640.png'});
        this.put({code: '0xfe0f', key: '🤽‍♀️', picture: '0x1f93d0x2640.png'});

        this.put({code: '0x2642', key: '🤽‍♂', picture: '0x1f93d0x2642.png'});
        this.put({code: '0xfe0f', key: '🤽‍♂️', picture: '0x1f93d0x2642.png'});


        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🤽🏻', picture: '0x1f93d0x1f3fb.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤽🏻‍♀', picture: '0x1f93d0x1f3fb0x2640.png'});
        this.put({code: '0xfe0f', key: '🤽🏻‍♀️', picture: '0x1f93d0x1f3fb0x2640.png'});

        this.put({code: '0x2642', key: '🤽🏻‍♂', picture: '0x1f93d0x1f3fb0x2642.png'});
        this.put({code: '0xfe0f', key: '🤽🏻‍♂️', picture: '0x1f93d0x1f3fb0x2642.png'});


        this.put({code: '0xdffc', key: '🤽🏼', picture: '0x1f93d0x1f3fc.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤽🏼‍♀', picture: '0x1f93d0x1f3fc0x2640.png'});
        this.put({code: '0xfe0f', key: '🤽🏼‍♀️', picture: '0x1f93d0x1f3fc0x2640.png'});

        this.put({code: '0x2642', key: '🤽🏼‍♂', picture: '0x1f93d0x1f3fc0x2642.png'});
        this.put({code: '0xfe0f', key: '🤽🏼‍♂️', picture: '0x1f93d0x1f3fc0x2642.png'});


        this.put({code: '0xdffd', key: '🤽🏽', picture: '0x1f93d0x1f3fd.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤽🏽‍♀', picture: '0x1f93d0x1f3fd0x2640.png'});
        this.put({code: '0xfe0f', key: '🤽🏽‍♀️', picture: '0x1f93d0x1f3fd0x2640.png'});

        this.put({code: '0x2642', key: '🤽🏽‍♂', picture: '0x1f93d0x1f3fd0x2642.png'});
        this.put({code: '0xfe0f', key: '🤽🏽‍♂️', picture: '0x1f93d0x1f3fd0x2642.png'});


        this.put({code: '0xdffe', key: '🤽🏾', picture: '0x1f93d0x1f3fe.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤽🏾‍♀', picture: '0x1f93d0x1f3fe0x2640.png'});
        this.put({code: '0xfe0f', key: '🤽🏾‍♀️', picture: '0x1f93d0x1f3fe0x2640.png'});

        this.put({code: '0x2642', key: '🤽🏾‍♂', picture: '0x1f93d0x1f3fe0x2642.png'});
        this.put({code: '0xfe0f', key: '🤽🏾‍♂️', picture: '0x1f93d0x1f3fe0x2642.png'});


        this.put({code: '0xdfff', key: '🤽🏿', picture: '0x1f93d0x1f3ff.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤽🏿‍♀', picture: '0x1f93d0x1f3ff0x2640.png'});
        this.put({code: '0xfe0f', key: '🤽🏿‍♀️', picture: '0x1f93d0x1f3ff0x2640.png'});

        this.put({code: '0x2642', key: '🤽🏿‍♂', picture: '0x1f93d0x1f3ff0x2642.png'});
        this.put({code: '0xfe0f', key: '🤽🏿‍♂️', picture: '0x1f93d0x1f3ff0x2642.png'});


        this.put({code: '0xdd3e', key: '🤾', picture: '0x1f93e.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤾‍♀', picture: '0x1f93e0x2640.png'});
        this.put({code: '0xfe0f', key: '🤾‍♀️', picture: '0x1f93e0x2640.png'});

        this.put({code: '0x2642', key: '🤾‍♂', picture: '0x1f93e0x2642.png'});
        this.put({code: '0xfe0f', key: '🤾‍♂️', picture: '0x1f93e0x2642.png'});


        this.put({code: '0xd83c'});
        this.put({code: '0xdffb', key: '🤾🏻', picture: '0x1f93e0x1f3fb.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤾🏻‍♀', picture: '0x1f93e0x1f3fb0x2640.png'});
        this.put({code: '0xfe0f', key: '🤾🏻‍♀️', picture: '0x1f93e0x1f3fb0x2640.png'});

        this.put({code: '0x2642', key: '🤾🏻‍♂', picture: '0x1f93e0x1f3fb0x2642.png'});
        this.put({code: '0xfe0f', key: '🤾🏻‍♂️', picture: '0x1f93e0x1f3fb0x2642.png'});


        this.put({code: '0xdffc', key: '🤾🏼', picture: '0x1f93e0x1f3fc.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤾🏼‍♀', picture: '0x1f93e0x1f3fc0x2640.png'});
        this.put({code: '0xfe0f', key: '🤾🏼‍♀️', picture: '0x1f93e0x1f3fc0x2640.png'});

        this.put({code: '0x2642', key: '🤾🏼‍♂', picture: '0x1f93e0x1f3fc0x2642.png'});
        this.put({code: '0xfe0f', key: '🤾🏼‍♂️', picture: '0x1f93e0x1f3fc0x2642.png'});


        this.put({code: '0xdffd', key: '🤾🏽', picture: '0x1f93e0x1f3fd.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤾🏽‍♀', picture: '0x1f93e0x1f3fd0x2640.png'});
        this.put({code: '0xfe0f', key: '🤾🏽‍♀️', picture: '0x1f93e0x1f3fd0x2640.png'});

        this.put({code: '0x2642', key: '🤾🏽‍♂', picture: '0x1f93e0x1f3fd0x2642.png'});
        this.put({code: '0xfe0f', key: '🤾🏽‍♂️', picture: '0x1f93e0x1f3fd0x2642.png'});


        this.put({code: '0xdffe', key: '🤾🏾', picture: '0x1f93e0x1f3fe.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤾🏾‍♀', picture: '0x1f93e0x1f3fe0x2640.png'});
        this.put({code: '0xfe0f', key: '🤾🏾‍♀️', picture: '0x1f93e0x1f3fe0x2640.png'});

        this.put({code: '0x2642', key: '🤾🏾‍♂', picture: '0x1f93e0x1f3fe0x2642.png'});
        this.put({code: '0xfe0f', key: '🤾🏾‍♂️', picture: '0x1f93e0x1f3fe0x2642.png'});


        this.put({code: '0xdfff', key: '🤾🏿', picture: '0x1f93e0x1f3ff.png'});
        this.put({code: '0x200d'});
        this.put({code: '0x2640', key: '🤾🏿‍♀', picture: '0x1f93e0x1f3ff0x2640.png'});
        this.put({code: '0xfe0f', key: '🤾🏿‍♀️', picture: '0x1f93e0x1f3ff0x2640.png'});

        this.put({code: '0x2642', key: '🤾🏿‍♂', picture: '0x1f93e0x1f3ff0x2642.png'});
        this.put({code: '0xfe0f', key: '🤾🏿‍♂️', picture: '0x1f93e0x1f3ff0x2642.png'});


        this.put({code: '0xdd40', key: '🥀', picture: '0x1f940.png'});
        this.put({code: '0xdd41', key: '🥁', picture: '0x1f941.png'});
        this.put({code: '0xdd42', key: '🥂', picture: '0x1f942.png'});
        this.put({code: '0xdd43', key: '🥃', picture: '0x1f943.png'});
        this.put({code: '0xdd44', key: '🥄', picture: '0x1f944.png'});
        this.put({code: '0xdd45', key: '🥅', picture: '0x1f945.png'});
        this.put({code: '0xdd47', key: '🥇', picture: '0x1f947.png'});
        this.put({code: '0xdd48', key: '🥈', picture: '0x1f948.png'});
        this.put({code: '0xdd49', key: '🥉', picture: '0x1f949.png'});
        this.put({code: '0xdd4a', key: '🥊', picture: '0x1f94a.png'});
        this.put({code: '0xdd4b', key: '🥋', picture: '0x1f94b.png'});
        this.put({code: '0xdd50', key: '🥐', picture: '0x1f950.png'});
        this.put({code: '0xdd51', key: '🥑', picture: '0x1f951.png'});
        this.put({code: '0xdd52', key: '🥒', picture: '0x1f952.png'});
        this.put({code: '0xdd53', key: '🥓', picture: '0x1f953.png'});
        this.put({code: '0xdd54', key: '🥔', picture: '0x1f954.png'});
        this.put({code: '0xdd55', key: '🥕', picture: '0x1f955.png'});
        this.put({code: '0xdd56', key: '🥖', picture: '0x1f956.png'});
        this.put({code: '0xdd57', key: '🥗', picture: '0x1f957.png'});
        this.put({code: '0xdd58', key: '🥘', picture: '0x1f958.png'});
        this.put({code: '0xdd59', key: '🥙', picture: '0x1f959.png'});
        this.put({code: '0xdd5a', key: '🥚', picture: '0x1f95a.png'});
        this.put({code: '0xdd5b', key: '🥛', picture: '0x1f95b.png'});
        this.put({code: '0xdd5c', key: '🥜', picture: '0x1f95c.png'});
        this.put({code: '0xdd5d', key: '🥝', picture: '0x1f95d.png'});
        this.put({code: '0xdd5e', key: '🥞', picture: '0x1f95e.png'});
        this.put({code: '0xdd80', key: '🦀', picture: '0x1f980.png'});
        this.put({code: '0xdd81', key: '🦁', picture: '0x1f981.png'});
        this.put({code: '0xdd82', key: '🦂', picture: '0x1f982.png'});
        this.put({code: '0xdd83', key: '🦃', picture: '0x1f983.png'});
        this.put({code: '0xdd84', key: '🦄', picture: '0x1f984.png'});
        this.put({code: '0xdd85', key: '🦅', picture: '0x1f985.png'});
        this.put({code: '0xdd86', key: '🦆', picture: '0x1f986.png'});
        this.put({code: '0xdd87', key: '🦇', picture: '0x1f987.png'});
        this.put({code: '0xdd88', key: '🦈', picture: '0x1f988.png'});
        this.put({code: '0xdd89', key: '🦉', picture: '0x1f989.png'});
        this.put({code: '0xdd8a', key: '🦊', picture: '0x1f98a.png'});
        this.put({code: '0xdd8b', key: '🦋', picture: '0x1f98b.png'});
        this.put({code: '0xdd8c', key: '🦌', picture: '0x1f98c.png'});
        this.put({code: '0xdd8d', key: '🦍', picture: '0x1f98d.png'});
        this.put({code: '0xdd8e', key: '🦎', picture: '0x1f98e.png'});
        this.put({code: '0xdd8f', key: '🦏', picture: '0x1f98f.png'});
        this.put({code: '0xdd90', key: '🦐', picture: '0x1f990.png'});
        this.put({code: '0xdd91', key: '🦑', picture: '0x1f991.png'});
        this.put({code: '0xddc0', key: '🧀', picture: '0x1f9c0.png'});

    }
}

export default new EmojiImageBox();
