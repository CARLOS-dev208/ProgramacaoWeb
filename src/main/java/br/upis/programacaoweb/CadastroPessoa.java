package br.upis.programacaoweb;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/cadastroPessoa")
public class CadastroPessoa extends HttpServlet {

    private Map<Email, Pessoa> map = new HashMap<>();

    @Override
    public void init() throws ServletException {
        getServletContext().setAttribute("pessoas", map);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Pessoa person = (Pessoa)req.getAttribute("pessoaBean");

        Email email = person.getEmail();

        if(map.containsKey(email) && req.getParameter("acao") != null) {

            if(req.getParameter("acao").equals("editar")) {
                map.replace(email, person);
            }

            if(req.getParameter("acao").equals("excluir")) {
                map.remove(email);
            }
        }else {
            map.put(email, person);
        }

        req.getRequestDispatcher("Historico.jsp").forward(req, resp);
    }
}