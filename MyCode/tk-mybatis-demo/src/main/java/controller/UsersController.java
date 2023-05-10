package controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/users")
public class UsersController {
    @GetMapping("/all")
    public List<String> getAll() {
        return Arrays.asList("Hi");
    }
}
