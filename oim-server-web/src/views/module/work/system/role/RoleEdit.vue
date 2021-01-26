<template>
    <div>
        <div>
            <el-row style="height: 100%">
                <el-col :span="10">
                    <el-card>
                        <div slot="header">
                            <span>角色信息</span>
                        </div>
                        <div>
                            <el-form ref="form" :model="data" :rules="ruleValidate">
                                <el-form-item label="角色名称" prop="name">
                                    <el-input v-model="data.name"
                                              type="text"
                                              placeholder="角色名称">
                                    </el-input>
                                </el-form-item>
                                <el-form-item label="简介" prop="introduce">
                                    <el-input v-model="data.introduce"
                                              type="text"
                                              placeholder="简介">
                                    </el-input>
                                </el-form-item>
                                <el-form-item label="状态" prop="isDisable">
                                    <el-radio-group v-model="data.isDisable">
                                        <el-radio :label="0">启用</el-radio>
                                        <el-radio :label="1">禁用</el-radio>
                                    </el-radio-group>
                                </el-form-item>
                            </el-form>
                        </div>
                    </el-card>

                </el-col>
                <el-col :span="14">
                    <el-card>
                        <div slot="header">
                            <span>角色权限</span>
                        </div>
                        <div style="height: 400px">
                            <function-select-tree :data="functionSelectTreeData"></function-select-tree>
                        </div>
                    </el-card>
                </el-col>
            </el-row>
        </div>
        <div slot="footer" class="edit-dialog-footer" style="margin-top: 15px">
            <el-button @click="cancel">取消</el-button>
            <el-button type="primary" :loading="saveLoading" @click="save">保存</el-button>
        </div>
    </div>
</template>

<script lang="ts">
    import {Component, Emit, Inject, Model, Prop, Provide, Vue, Watch} from 'vue-property-decorator';
    import FunctionSelectTree from '@/views/module/work/system/function/FunctionSelectTree.vue';
    import FunctionSelectTreeData from '@/views/module/work/system/function/FunctionSelectTreeData';

    import Role from '@/app/com/main/module/work/system/bean/Role';
    import RoleClient from '@/app/com/main/module/work/system/RoleClient';

    @Component({
        components: {
            FunctionSelectTree,
        },
    })
    export default class RoleEdit extends Vue {
        private saveLoading: boolean = false;

        @Prop({
            type: String,
            required: false,
            default: () => '',
        })
        private dataId!: string;
        private data: Role = new Role();
        private ruleValidate = {
            name: [
                {required: true, message: '名称不能为空', trigger: 'blur'},
            ],
        };
        private functionSelectTreeData: FunctionSelectTreeData = new FunctionSelectTreeData();

        public mounted() {
            this.load();
        }

        public setData(data: Role) {
            this.data = data;
        }

        public setFunctionIds(functionIds: string[]) {
            this.functionSelectTreeData.setSelectIds(functionIds);
        }

        public setDataId(id: string) {
            this.dataId = id;
            this.load();
        }

        public cancel() {
            this.onDone(false);
        }

        public save(): void {
            const own = this;
            const data = this.data;
            const functionIds = this.functionSelectTreeData.getSelectIds();
            (this.$refs as any).form.validate((valid: boolean) => {
                if (valid) {
                    own.saveLoading = true;
                    RoleClient.addOrUpdate(data, functionIds, (result) => {
                        const info = result.info;
                        if (info && info.success) {
                            own.onDone(true);
                        }
                        own.saveLoading = false;
                    });
                }
            });
        }

        @Emit('on-done')
        public onDone(done: boolean) {
            // no
            const own = this;
            own.saveLoading = false;
        }

        public load() {
            const own = this;
            const id = own.dataId;
            if (id) {
                RoleClient.getById(id, (data) => {
                    const info = data.info;
                    const body = data.body;
                    if (info && info.success && body) {
                        const r: Role = body;
                        own.setData(r);
                    }
                });

                RoleClient.getRoleFunctionList(id, (data) => {
                    const info = data.info;
                    const body = data.body;
                    if (info && info.success && body) {
                        const items: any[] = body.items;
                        const ids: string[] = [];
                        if (items) {
                            for (const v of items) {
                                if (v.functionId) {
                                    ids.push(v.functionId);
                                }
                            }
                        }
                        own.setFunctionIds(ids);
                    }
                });
            } else {
                this.data = new Role();
                own.setFunctionIds([]);
            }
        }

        @Watch('dataId')
        public dataIdValue(id: string) {
            this.load();
        }
    }
</script>

<style scoped>

</style>
