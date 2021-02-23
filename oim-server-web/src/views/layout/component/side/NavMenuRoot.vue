<template>
    <div>
        <template v-if="!hasNodes">
            <el-menu-item :index="index"
                          @click="onClick"
            >
                <i :class="data.icon"></i>
                {{data.text}}
            </el-menu-item>
        </template>
        <template v-else>
            <el-submenu :index="index">
                <template slot="title">
                    <i :class="data.icon"></i>
                    <span slot="title">{{data.text}}</span>
                </template>
                <template v-if="hasNodes" v-for="(node,index) in data.children">
                    <nav-menu-item
                        :index="getChildrenIndex(index)"
                        :data="node"
                    />
                </template>
            </el-submenu>
        </template>
    </div>
</template>

<script lang="ts">
import {Component, Emit, Inject, Model, Prop, Provide, Vue, Watch} from 'vue-property-decorator';


import NavMenuItemData from './NavMenuItemData';
import NavMenuItem from '@/views/layout/component/side/NavMenuItem.vue';


@Component({
    components: {
        NavMenuItem,
    },
})
export default class NavMenuRoot extends Vue {
    @Prop({
        type: NavMenuItemData,
        required: true,
        default: () => new NavMenuItemData(),
    })
    private data!: NavMenuItemData;


    @Prop({
        type: String,
        required: false,
        default: () => '0',
    })
    private index!: string;

    @Prop({
        type: Boolean,
        required: false,
        default: () => false,
    })
    private isNest!: boolean;

    @Prop({
        type: String,
        required: false,
        default: () => '',
    })
    private basePath!: string;

    get hasNodes(): boolean {
        let has = false;
        if (this.data.children) {
            has = this.data.children.length > 0;
        }
        return has;
    }

    get classData() {
        return {};
    }

    private onClick(e: any) {
        const data = this.data;
        if (data && typeof data.click === 'function') {
            data.click(e);
        }
    }

    private getChildrenIndex(index: number): string {
        const i = this.index + '-' + index;
        return i;
    }
}
</script>

<style lang="scss" scoped>

</style>
