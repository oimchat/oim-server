import NavMenuData from '@/views/layout/component/side/NavMenuData';
import SideLogoData from '@/views/layout/component/side/SideLogoData';

class SideData {

    public showLogo: boolean = true;
    public navMenu: NavMenuData = new NavMenuData();
    public logoData: SideLogoData = new SideLogoData();
    public collapse: boolean = false;

}

export default SideData;
