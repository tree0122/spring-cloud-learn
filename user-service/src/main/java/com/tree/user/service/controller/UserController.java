package com.tree.user.service.controller;

import com.tree.user.service.domain.User;
import com.tree.user.service.domain.UserRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private UserRepository userRepository;

    @RequestMapping(value = "index", method = {RequestMethod.GET, RequestMethod.POST})
    public User index(){
        User lucy = User.builder()
                .id(1)
                .name("lucy")
                .age(18)
                .build();
        return lucy;
    }

    @RequestMapping("{id}")
    public User get(@PathVariable("id") Integer id){
        return userRepository.getById(id);
    }
}
