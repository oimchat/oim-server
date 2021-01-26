<template>
    <el-scrollbar wrap-class="scrollbar-wrapper">
        <el-menu
                :default-active="data.activeMenu"
                :collapse="data.collapse"
                :unique-opened="false"
                :collapse-transition="false"
                :background-color="data.backgroundColor"
                :text-color="data.textColor"
                :active-text-color="data.activeTextColor"
                mode="vertical"
        >
            <template v-for="item in data.items">
                <nav-menu-item
                        :key="item.key"
                        :data="item"/>
            </template>
        </el-menu>
    </el-scrollbar>
</template>

<script lang="ts">
    import {Component, Emit, Inject, Model, Prop, Provide, Vue, Watch} from 'vue-property-decorator';
    import NavMenuItem from '@/views/layout/component/side/NavMenuItem.vue';
    import NavMenuData from '@/views/layout/component/side/NavMenuData';

    @Component({
        components: {
            NavMenuItem,
        },
    })
    export default class NavMenu extends Vue {
        @Prop({
            type: NavMenuData,
            required: true,
            default: () => new NavMenuData(),
        })
        private data!: NavMenuData;
    }
</script>

<style scoped>

</style>
