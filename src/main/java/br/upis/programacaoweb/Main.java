package br.upis.programacaoweb;

import br.upis.programacaoweb.connectionFactory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection con = new ConnectionFactory().getConnection();
        System.out.println("Conexão aberta! "+ con.getClientInfo());

        String sql = "insert into pessoa " +
                "(nome,email,dataNascimento) " +
                "values (?,?,?)";


        PreparedStatement stmt = con.prepareStatement(sql);


        stmt.setString(1, "contato@caelum.com.br");
        stmt.setString(2, "R. Vergueiro 3185 cj57");
        stmt.setDate(3, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));

        stmt.execute();
        stmt.close();
        System.out.println("Gravado!");
        con.close();
    }

}
