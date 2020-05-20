package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

public class Corporation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Integer ruc;
    @NotNull
    private String address;
    @NotNull
    private String phone;
    @OneToOne
    @JoinColumn(name="userProfile_id")
    private User user;
}
