package com.trinhha.demo.itblog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User implements Serializable {

    @Id
    @Column(name = "user_id")
    @GeneratedValue
    private int id;

    @Column(name = "email")
    @NotEmpty(message = "Please insert value for [EMAIL]")
    private String email;

    @Column(name = "password")
    @NotEmpty(message = "Please insert value for [PASSWORD]")
    @Length(min = 5, message = "Your password must be at least 5 characters")
    private String password;

    @Temporal(TemporalType.DATE)
    @Column(name = "create_at")
    private Date createAt;

    @Column(name = "expired")
    private boolean expired;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles = new LinkedHashSet<>();
}
