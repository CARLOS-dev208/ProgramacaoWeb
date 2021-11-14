package br.upis.programacaoweb;

public class Email {

    private String endereco;

    public Email() {

    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return endereco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (endereco == null ? 0 : endereco.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        Email obj = (Email) o;
        return this.endereco.equals(obj.endereco);
    }
}

