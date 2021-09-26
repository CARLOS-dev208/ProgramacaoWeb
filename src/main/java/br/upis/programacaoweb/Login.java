package br.upis.programacaoweb;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/login")
public class Login extends HttpServlet {

    private List<String> logins = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session;
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");

        if(login.equals("admin") && senha.equals("admin")){
            this.logins.add("Success: ".concat(login.concat(" - ").concat(senha)));
            session = req.getSession();
            session.setMaxInactiveInterval(10);
        }else {
            this.logins.add("Error: ".concat(login.concat(" - ").concat(senha)));
        }
        req.setAttribute("logins", logins);
        RequestDispatcher dispacther = req.getRequestDispatcher("login.jsp");
        dispacther.forward(req, resp);
    }
}