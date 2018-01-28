package com.alltej.oauthservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "USER_ACCOUNTS")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;
    private Boolean active;

    public Account( String username, String password, boolean active ) {
        this.username = username;
        this.password = password;
        this.active = active;
    }
}
