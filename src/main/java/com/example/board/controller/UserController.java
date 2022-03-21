package com.example.board.controller;

import com.example.board.controller.dto.user.UserJoinRequestDto;
import com.example.board.domain.User;
import com.example.board.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public String join(UserJoinRequestDto requestDto) {
        System.out.println("!23123123");
        userService.join(requestDto);
        return "redirect:/users";
    }

    @GetMapping("users/form")
    public String home(){
        return "user/form";
    }

    @GetMapping("/users")
    public String userList(Model model) {
        List<User> users = userService.findUsers();
        model.addAttribute("users", users);
        return "/user/list";
    }

    @GetMapping("users/{userId}")
    public String profile(@PathVariable String userId, Model model) {
        User user = userService.findByUserId(userId);
        model.addAttribute("user", user);
        return "user/profile";
    }

}
