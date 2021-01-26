<template>
    <div class="sidebar-logo-container" :class="{'collapse':collapse}">
        <transition name="sidebarLogoFade">
            <router-link v-if="collapse" key="collapse" class="sidebar-logo-link" to="/">
                <img v-if="data.logo" :src="data.logo" class="sidebar-logo">
                <h1 v-else class="sidebar-title">{{ data.title }} </h1>
            </router-link>
            <router-link v-else key="expand" class="sidebar-logo-link" to="/">
                <img v-if="data.logo" :src="data.logo" class="sidebar-logo">
                <h1 class="sidebar-title">{{ data.title }} </h1>
            </router-link>
        </transition>
    </div>
</template>

<script lang="ts">
    import {Component, Emit, Inject, Model, Prop, Provide, Vue, Watch} from 'vue-property-decorator';
    import SideLogoData from '@/views/layout/component/side/SideLogoData';

    @Component({
        components: {},
    })
    export default class SideLogo extends Vue {

        @Prop({
            type: SideLogoData,
            required: false,
            default: () => new SideLogoData(),
        })
        private data!: SideLogoData;

        @Prop({
            type: Boolean,
            required: false,
            default: () => false,
        })
        private collapse!: boolean;


    }
</script>

<style lang="scss" scoped>
    .sidebarLogoFade-enter-active {
        transition: opacity 1.5s;
    }

    .sidebarLogoFade-enter,
    .sidebarLogoFade-leave-to {
        opacity: 0;
    }

    .sidebar-logo-container {
        position: relative;
        width: 100%;
        height: 50px;
        line-height: 50px;
        background: #2b2f3a;
        text-align: center;
        overflow: hidden;

        & .sidebar-logo-link {
            height: 100%;
            width: 100%;

            & .sidebar-logo {
                width: 32px;
                height: 32px;
                vertical-align: middle;
                margin-right: 12px;
            }

            & .sidebar-title {
                display: inline-block;
                margin: 0;
                color: #fff;
                font-weight: 600;
                line-height: 50px;
                font-size: 14px;
                font-family: Avenir, Helvetica Neue, Arial, Helvetica, sans-serif;
                vertical-align: middle;
            }
        }

        &.collapse {
            .sidebar-logo {
                margin-right: 0px;
            }
        }
    }
</style>
