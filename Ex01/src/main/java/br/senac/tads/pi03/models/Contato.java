package br.senac.tads.pi03.models;

public class Contato {

    private int id;
    private String nome;
    private String nasc;
    private String telefone;
    private String email;
    private String horario;

    public Contato(Integer id, String nome, String nasc, String telefone, String email, String horario) {
        this.id = id;
        this.nome = nome;
        this.nasc = nasc;
        this.telefone = telefone;
        this.email = email;
        this.horario = horario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNasc() {
        return nasc;
    }

    public void setNasc(String nasc) {
        this.nasc = nasc;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    
}
