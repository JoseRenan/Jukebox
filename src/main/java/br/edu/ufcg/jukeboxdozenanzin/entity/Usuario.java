package br.edu.ufcg.jukeboxdozenanzin.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

    private Integer usuarioId;
    private String email;
    private String password;
    private String nome;

    public Usuario(String email, String password, String nome) {
        this.email = email;
        this.password = password;
        this.nome = nome;
    }

    public Usuario () {}

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk_usuario")
    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Column(name = "email", unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
