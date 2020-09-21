package studentTracking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentTracking.dao.IMenuDao;
import studentTracking.model.Menu;
import studentTracking.service.IMenuService;

import java.util.List;

@Service("menuService")
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private IMenuDao menuDao;

    /**
     * 获取所有的管理员菜单
     *
     * @return
     */
    @Override
    public List<Menu> listMenu() {

        //获取一级菜单
        List<Menu> mainMenu = menuDao.listMainMenu();
        //获取子菜单



        return mainMenu;
    }
}
