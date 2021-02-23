<template>
    <div :class="{'has-logo':data.showLogo}">
        <side-logo v-if="data.showLogo" :data="data.logoData" :collapse="data.collapse"/>
        <nav-menu :data="data.navMenu"/>
    </div>
</template>

<script lang="ts">
    import {Component, Emit, Inject, Model, Prop, Provide, Vue, Watch} from 'vue-property-decorator';

    import NavMenu from '@/views/layout/component/side/NavMenu.vue';
    import SideLogo from '@/views/layout/component/side/SideLogo.vue';
    import OpenLink from '@/views/layout/component/side/OpenLink.vue';
    import NavMenuData from '@/views/layout/component/side/NavMenuData';
    import NavMenuItemData from '@/views/layout/component/side/NavMenuItemData';
    import SideData from '@/views/layout/component/side/SideData';

    @Component({
        components: {
            NavMenu,
            SideLogo,
            OpenLink,
        },
    })
    export default class SidePane extends Vue {
        @Prop({
            type: SideData,
            required: true,
            default: () => new SideData(),
        })
        private data!: SideData;


        public mounted() {
            //
        }

        @Watch('data.collapse')
        public collapseValue(newValue: boolean) {
            const navMenu: NavMenuData = this.data.navMenu;
           // navMenu.collapse = this.data.collapse;
        }

        get showLogo() {
            return true;
        }
    }
</script>

<style scoped>

</style>
