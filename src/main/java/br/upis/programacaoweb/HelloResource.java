package br.upis.programacaoweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/login")
public class HelloResource extends HttpServlet {

    private List<String> login = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        String login = req.getParameter("conta");
        String senha = req.getParameter("senha");

        if(login.equals("admin") && senha.equals("admin")){
            this.login.add("Success: ".concat(login.concat(" - ").concat(senha)));
        }else {
            this.login.add("Error: ".concat(login.concat(" - ").concat(senha)));
        }

        for (String l : this.login) {
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<body>");
            out.println(l);
            out.println("</body>");
            out.println("</html>");

        }
    }
}