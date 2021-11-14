package br.upis.programacaoweb;

import java.util.Calendar;
import java.util.Date;

public class Pessoa {

    private String nome;
    private Date nascimento;
    private Email email;

    private int idade;

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public int getIdade() {

        Calendar calNascimento = Calendar.getInstance();

        calNascimento.setTime(nascimento);

        int anoNascimento = calNascimento.get(Calendar.YEAR);

        Calendar calHoje = Calendar.getInstance();

        int anoHoje = calHoje.get(Calendar.YEAR);

        int idade = anoHoje - anoNascimento;

        calNascimento.add(Calendar.YEAR, idade);

        if(calNascimento.after(calHoje)) {
            return idade - 1;
        }

        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return this.nome + " " + this.nascimento;
    }
}
