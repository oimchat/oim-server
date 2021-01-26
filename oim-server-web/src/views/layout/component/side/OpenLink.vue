<template>
    <component :is="type" v-bind="linkProps(to)">
        <slot/>
    </component>
</template>

<script lang="ts">
    import {Component, Emit, Inject, Model, Prop, Provide, Vue, Watch} from 'vue-property-decorator';
    import StringValidateUtil from '@/app/base/util/StringValidateUtil';


    @Component({
        components: {},
    })
    export default class OpenLink extends Vue {
        @Prop({
            type: String,
            required: false,
            default: () => (''),
        })
        private to!: string;

        public linkProps(to: string) {
            if (this.isExternal) {
                return {
                    href: to,
                    target: '_blank',
                    rel: 'noopener',
                };
            }
            return {
                to,
            };
        }

        get isExternal() {
            return StringValidateUtil.isExternal(this.to);
        }

        get type() {
            if (this.isExternal) {
                return 'a';
            }
            return 'router-link';
        }
    }
</script>

<style scoped>

</style>
