<template>
    <div style="height: 100%">
        <q-list bordered>
            <template v-for="name of names">
                <q-item clickable v-ripple>
                    <q-item-section avatar>
                        <q-icon color="primary" name="bluetooth"/>
                    </q-item-section>

                    <q-item-section>{{name}}</q-item-section>
                </q-item>
            </template>
        </q-list>
        <el-card class="box-card">
            <div slot="header" class="clearfix">
                <span>卡片名称</span>
                <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>
            </div>
            <div v-for="o in 4" :key="o" class="text item">
                {{'列表内容 ' + o }}
            </div>
        </el-card>
        <el-button type="text" @click="dialogVisible = true">点击打开 Dialog</el-button>

        <el-dialog
                title="提示"
                :visible.sync="dialogVisible"
                width="30%"
                :before-close="handleClose">
            <span>这是一段信息</span>
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
              </span>
        </el-dialog>
    </div>


</template>

<script lang="ts">
    import {Component, Emit, Inject, Model, Prop, Provide, Vue, Watch} from 'vue-property-decorator';

    @Component({
        components: {},
    })
    export default class index extends Vue {
        private names: string[] = [];
        private dialogVisible: boolean = false;

        public created() {
            // no
            for (let i = 0; i < 200; i++) {
                this.names.push('哈哈哈' + i);
            }
        }

        public handleClose(done: any) {
            this.$confirm('确认关闭？')
                .then(_ => {
                    done();
                })
                .catch(_ => {
                });
        }
    }
</script>

<style scoped>

</style>
