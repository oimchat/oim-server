import NavMenuItemData from '@/views/layout/component/side/NavMenuItemData';

class NavMenuData {

    public collapse: boolean = false;
    public activeMenu: string = '';
    public textColor: string = '#bfcbd9';
    public backgroundColor: string = '#304156';
    public activeTextColor: string = '#409EFF';
    public items: NavMenuItemData[] = [];
}

export default NavMenuData;
