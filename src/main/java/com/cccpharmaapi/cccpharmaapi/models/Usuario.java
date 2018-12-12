package com.cccpharmaapi.cccpharmaapi.models;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private int permissao;

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPermissao() {
        return permissao;
    }

    public void setPermissao(int permissao) {
        this.permissao = permissao;
    }
}
