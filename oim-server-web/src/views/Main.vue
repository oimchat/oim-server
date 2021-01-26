<template>
    <layout></layout>
</template>

<script lang="ts">
    import {Component, Emit, Inject, Model, Prop, Provide, Vue, Watch} from 'vue-property-decorator';

    import Layout from '@/views/layout/Layout.vue';

    @Component({
        components: {
            Layout,
        },
    })
    export default class Main extends Vue {
    }
</script>

<style lang="scss" scoped>

</style>
