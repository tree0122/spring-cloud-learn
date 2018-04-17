package com.tree.user.service.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private Integer id;

    private Integer age;

    private String name;
}
