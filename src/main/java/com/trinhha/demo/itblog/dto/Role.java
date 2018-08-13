package com.trinhha.demo.itblog.dto;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;

@Entity
@Data
@Table(name = "role")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Role implements Serializable {

    @Id
    @Column(name = "role_id")
    @GeneratedValue
    private int id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "description")
    private String description;

}
