package controller;

import com.wagner.demo.service.IMenuService;
import lombok.extern.slf4j.Slf4j;
import lombok.var;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
public class HomeController {

    private final IMenuService menuService;

    public HomeController(IMenuService menuService) {

        this.menuService = menuService;
    }

    @GetMapping("/")
    public List<String> index() {
        var menu = menuService.getMenu("2019-08-29 07:14:44");
        log.info("getMenu:{}", menu);
        return Arrays.asList("Hello World!");
    }
}