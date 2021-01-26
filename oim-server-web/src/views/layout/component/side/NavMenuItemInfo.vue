<script lang="ts">
import {Component, Emit, Inject, Model, Prop, Provide, Vue, Watch} from 'vue-property-decorator';

@Component({
    components: {},
    props: {
        icon: {
            type: String,
            default: '',
        },
        title: {
            type: String,
            default: '',
        },
    },
})
export default class SideMenuItem extends Vue {
    @Prop({
        type: String,
        required: false,
        default: () => '',
    })
    private icon!: string;

    @Prop({
        type: String,
        required: false,
        default: () => '',
    })
    private title!: string;

    public render(h: any, context: any) {
        const icon = this.icon;
        const title = this.title;
        const nodes = [];
        if (icon) {
            nodes.push(h('svg-icon', {
                iconClass: icon,
            }));
        }

        if (title) {
            nodes.push(h('span', {
                slot: title,
            }, title));
        }
        return h('div', {}, title);
    }
}
</script>

