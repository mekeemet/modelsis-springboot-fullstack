package com.test.modelsisspringbootfullstack.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
@Data @AllArgsConstructor @NoArgsConstructor @ToString
@Entity
public  class Utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private boolean actived;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles=new ArrayList<>();
//    @OneToMany(mappedBy = "appUser", fetch = FetchType.LAZY)
//    private Collection<Task> tasks;


}
