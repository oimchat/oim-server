import FunctionInfo from '@/app/com/main/module/work/system/bean/FunctionInfo';

class FunctionTreeNode extends FunctionInfo {

    public children: FunctionTreeNode[] = [];
}

export default FunctionTreeNode;
