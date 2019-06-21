package model;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Usuario.findAll", query = "SELECT obj FROM Usuario obj"),
        @NamedQuery(name = "Usuario.findByNome", query = "SELECT obj FROM Usuario obj WHERE obj.nome = :nome")
})
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String email;
    private String senha;
    private int idade;

    @OneToMany(mappedBy = "usuario")
    private List<Telefone> telefones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", idade=" + idade +
                '}';
    }
}
