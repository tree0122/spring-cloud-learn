package com.tree.user.service.domain;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserRepository {

    private ArrayList<User> list = Lists.newArrayList();

    public User getById(Integer id){
        Optional<User> first = list.stream()
                .filter(u -> u.getId() == id)
                .findFirst();
        return first.orElse(User.builder().build());
    }

    @PostConstruct
    private void init(){
        list.add(User.builder().id(1).age(16).name("lily").build());
    }
}
