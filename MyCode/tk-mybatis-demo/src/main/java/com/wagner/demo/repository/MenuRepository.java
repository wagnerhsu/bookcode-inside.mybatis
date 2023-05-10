package com.wagner.demo.repository;

import com.wagner.demo.po.Menu;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ExampleMapper;

public interface MenuRepository extends BaseMapper<Menu>, ExampleMapper<Menu> {

}
