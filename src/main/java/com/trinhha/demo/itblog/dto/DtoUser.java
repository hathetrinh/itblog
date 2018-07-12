package com.trinhha.demo.itblog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class DtoUser {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "create_at")
    private Date createAt;

    @Column(name = "expired")
    private boolean expired;
}
