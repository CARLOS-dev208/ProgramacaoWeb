package br.upis.programacaoweb;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/cadastroPessoa")
public class CadastroPessoa extends HttpServlet {

    private final Map<Email, Pessoa> map = new HashMap<>();

    @Override
    public void init() {
        List<Pessoa> listar = listar();
        listar.forEach(pessoa -> map.put(pessoa.getEmail(), pessoa));
        getServletContext().setAttribute("pessoas", map);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Pessoa person = (Pessoa)req.getAttribute("pessoaBean");

        Email email = person.getEmail();

        if(map.containsKey(email) && req.getParameter("acao") != null) {

            if(req.getParameter("acao").equals("editar")) {
                altera(person);
                map.replace(email, person);
            }

            if(req.getParameter("acao").equals("excluir")) {
                remove(person);
                map.remove(email);
            }
        }else {
            gravar(person);
            map.put(email, person);
        }

        req.getRequestDispatcher("Historico.jsp").forward(req, resp);
    }

    private void gravar(Pessoa person){
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.salvar(person);
    }

    private List<Pessoa> listar(){
        PessoaDAO pessoaDAO = new PessoaDAO();
        return  pessoaDAO.getLista();
    }

    private void remove(Pessoa person){
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.remove(person);
    }

    private void altera(Pessoa person){
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.altera(person);
    }

}