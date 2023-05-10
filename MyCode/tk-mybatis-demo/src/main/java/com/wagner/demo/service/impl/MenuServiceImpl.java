package com.wagner.demo.service.impl;

import com.wagner.demo.po.Menu;
import com.wagner.demo.repository.MenuRepository;
import com.wagner.demo.service.IMenuService;
import com.wagner.demo.vo.MenuVO;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MenuServiceImpl implements IMenuService {
    private final MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public List<MenuVO> getMenu(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String today = StringUtils.isEmpty(date) ? format.format(new Date()) : date;
        Example example = new Example(Menu.class);
        example.createCriteria().andGreaterThanOrEqualTo("createAt", today + " 00:00:00")
                .andLessThanOrEqualTo("createAt", today + " 23:59:59");
        example.setOrderByClause("sort asc");
        List<Menu> menuList = menuRepository.selectByExample(example);
        List<MenuVO> menuVOList = new ArrayList<>();
        menuList.forEach(menu -> {
            MenuVO menuVO = new MenuVO();
            BeanUtils.copyProperties(menu, menuVO);
            menuVOList.add(menuVO);
        });
        return menuVOList;
    }
}
