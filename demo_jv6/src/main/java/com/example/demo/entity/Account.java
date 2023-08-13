package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.Service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Accounts")
public class Account implements Serializable {

    @Id
    private String username;

    @Column
    private String password;

    @Column(nullable = true, length = 50)
    private String fullname;

    @Column(nullable = true, length = 50)
    private String email;

    @Column(nullable = true)
    private String photo;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "account")
    List<Authority> authorities;

}
