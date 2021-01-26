<template>
    <el-scrollbar ref="scrollContainer" :vertical="false" class="scroll-container" @wheel.native.prevent="handleScroll">
        <slot/>
    </el-scrollbar>
</template>

<script lang="ts">
    import {Component, Emit, Inject, Model, Prop, Provide, Vue, Watch} from 'vue-property-decorator';

    @Component({
        components: {},
    })
    export default class TagScrollPane extends Vue {
        private left: number = 0;

        public mounted() {
            this.scrollWrapper.addEventListener('scroll', this.emitScroll, true);
        }

        public handleScroll(e: any) {
            const eventDelta = e.wheelDelta || -e.deltaY * 40;
            const $scrollWrapper = this.scrollWrapper;
            $scrollWrapper.scrollLeft = $scrollWrapper.scrollLeft + eventDelta / 4;
        }

        public emitScroll() {
            this.$emit('scroll');
        }

        public beforeDestroy() {
            this.scrollWrapper.removeEventListener('scroll', this.emitScroll);
        }

        public moveToTarget(currentTag: any) {
            const tagAndTagSpacing = 4;
            const v: any = this.$refs.scrollContainer;
            const $container = v.$el;
            const $containerWidth = $container.offsetWidth;
            const $scrollWrapper = this.scrollWrapper;
            const tagList = this.$parent.$refs.tag as any[];
            if (tagList) {
                let firstTag = null;
                let lastTag = null;

                // find first tag and last tag
                if (tagList.length > 0) {
                    firstTag = tagList[0];
                    lastTag = tagList[tagList.length - 1];
                }

                if (firstTag === currentTag) {
                    $scrollWrapper.scrollLeft = 0;
                } else if (lastTag === currentTag) {
                    $scrollWrapper.scrollLeft = $scrollWrapper.scrollWidth - $containerWidth;
                } else {
                    // find preTag and nextTag
                    const currentIndex = tagList.findIndex((item) => (item === currentTag));
                    const prevTag = tagList[currentIndex - 1];
                    const nextTag = tagList[currentIndex + 1];

                    // the tag's offsetLeft after of nextTag
                    // const afterNextTagOffsetLeft = nextTag.$el.offsetLeft + nextTag.$el.offsetWidth + tagAndTagSpacing;
                    const afterNextTagOffsetLeft = nextTag.offsetLeft + nextTag.offsetWidth + tagAndTagSpacing;

                    // the tag's offsetLeft before of prevTag
                    // const beforePrevTagOffsetLeft = prevTag.$el.offsetLeft - tagAndTagSpacing;
                    const beforePrevTagOffsetLeft = prevTag.offsetLeft - tagAndTagSpacing;

                    if (afterNextTagOffsetLeft > $scrollWrapper.scrollLeft + $containerWidth) {
                        $scrollWrapper.scrollLeft = afterNextTagOffsetLeft - $containerWidth;
                    } else if (beforePrevTagOffsetLeft < $scrollWrapper.scrollLeft) {
                        $scrollWrapper.scrollLeft = beforePrevTagOffsetLeft;
                    }
                }
            }
        }

        get scrollWrapper() {
            const v: any = this.$refs.scrollContainer;
            return v.$refs.wrap;
        }
    }
</script>

<style lang="scss" scoped>
    .scroll-container {
        white-space: nowrap;
        position: relative;
        overflow: hidden;
        width: 100%;

        /deep/ {
            .el-scrollbar__bar {
                bottom: 0px;
            }

            .el-scrollbar__wrap {
                height: 49px;
            }
        }
    }
</style>
