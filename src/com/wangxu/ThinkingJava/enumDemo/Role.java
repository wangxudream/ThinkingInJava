package com.wangxu.ThinkingJava.enumDemo;


public enum Role {
    ROOT(1, "Root"), ADMIN(2, "Admin"), VISITOR(3, "Visitor");

    private Integer id;
    private String name;

    Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
