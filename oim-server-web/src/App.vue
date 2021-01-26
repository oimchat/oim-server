<template>
    <div id="app">
        <router-view/>
    </div>
</template>
<script lang="ts">
    import './styles/icon/materialdesign-webfont/css/materialdesignicons.css';
    import './styles/icon/fontawesome/css/all.css';
    import './styles/layout.css';
    import './styles/common.scss';
    import Vue from 'vue';
    import Component from 'vue-class-component';

    @Component({
        components: {},
    })
    export default class App extends Vue {
    }
</script>
<style lang="scss">
    body, html {
        height: 100%
    }

    .main {
        width: 100%;
        height: 100%;
    }

    #app {
        width: 100%;
        height: 100%;
        border-radius: 4px;
    }

    .el-notification__title {
        line-height: 1.75rem;

        h2 {

        }
    }
</style>
