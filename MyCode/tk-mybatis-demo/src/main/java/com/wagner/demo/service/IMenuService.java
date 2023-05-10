package com.wagner.demo.service;

import com.wagner.demo.vo.MenuVO;

import java.util.List;

public interface IMenuService {
    List<MenuVO> getMenu(String date);
}
