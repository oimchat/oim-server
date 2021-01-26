<template>
    <div>
        <template v-if="!hasNodes">
            <el-menu-item @click="data.click"
                          :index="data.key"
                          :class="{'submenu-title-noDropdown':!isNest}">
                <template slot="title">
                    <i :class="data.icon + ' svg-external-icon svg-icon'"></i>
                    <span slot='title'>{{data.title}}</span>
                </template>
            </el-menu-item>
        </template>
        <el-submenu v-else :index="data.key" popper-append-to-body>
            <template slot="title">
                <i :class="data.icon + ' svg-external-icon svg-icon'"></i>
                <span slot='title'>{{data.title}}</span>
            </template>
            <template v-if="hasNodes" v-for="node in data.nodes">
                <nav-menu-item
                        :key="node.key"
                        :data="node"
                        :is-nest="true"
                        class="nest-menu"
                />
            </template>
        </el-submenu>
    </div>
</template>

<script lang="ts">
    import {Component, Emit, Inject, Model, Prop, Provide, Vue, Watch} from 'vue-property-decorator';


    import path from 'path';
    import StringValidateUtil from '@/app/base/util/StringValidateUtil';

    import NavMenuItemData from './NavMenuItemData';


    @Component({
        components: {},
    })
    export default class NavMenuItem extends Vue {
        @Prop({
            type: NavMenuItemData,
            required: true,
            default: () => new NavMenuItemData(),
        })
        private data!: NavMenuItemData;

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
            if (this.data.nodes) {
                has = this.data.nodes.length > 0;
            }
            return has;
        }

        get classData() {
            return {};
        }
    }
</script>

<style scoped>
    .svg-icon {
        width: 1em;
        height: 1em;
        vertical-align: -0.15em;
        fill: currentColor;
        overflow: hidden;
        font-size: 24px;
    }

    .svg-external-icon {
        /*background-color: currentColor;*/
        mask-size: cover !important;
        /*display: inline-block;*/
    }
</style>
