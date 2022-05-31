package com.laptrinhjavaweb.entity;

import com.laptrinhjavaweb.security.ERole;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;
    public RoleEntity() {
    }
    public RoleEntity(ERole name) {
        this.name = name;
    }
    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}
