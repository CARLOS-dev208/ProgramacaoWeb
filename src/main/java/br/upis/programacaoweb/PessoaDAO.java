package br.upis.programacaoweb;

import br.upis.programacaoweb.connectionFactory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {
    private final Connection connection;

    public PessoaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }


    public void salvar(Pessoa pessoa) {
        String sql = "insert into pessoa (nome,email, datanascimento) values (?,?,?)";
        transformandoObjParaBanco(pessoa, sql, false);
    }

    public List<Pessoa> getLista() {
        try {
            List<Pessoa> pessoas = new ArrayList<>();
            PreparedStatement stmt = this.connection.
                    prepareStatement("select * from pessoa");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Contato
                Pessoa pessoa = new Pessoa();
                pessoa.setNome(rs.getString("nome"));
                pessoa.setEmail(new Email(rs.getString("email")));
                pessoa.setNascimento(rs.getDate("dataNascimento"));

                // adicionando o objeto à lista
                pessoas.add(pessoa);
            }
            rs.close();
            stmt.close();
            return pessoas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void remove(Pessoa pessoa) {
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from pessoa where email = ?" );
            stmt.setString(1, pessoa.getEmail().getEndereco());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void altera(Pessoa pessoa) {
        String sql = "update pessoa set nome=?, email=?, datanascimento=? where email=?";
        transformandoObjParaBanco(pessoa, sql, true);
    }

    private void transformandoObjParaBanco(Pessoa pessoa, String sql, Boolean isAtualiza) {
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getEmail().getEndereco());
            stmt.setDate(3, new Date(pessoa.getNascimento().getTime()));
            if(isAtualiza){
                stmt.setString(4, pessoa.getEmail().getEndereco());
            }
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
