package br.com.alura.gerenciador.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gilberto.andrade
 */
public class Logout implements Tarefa {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        session.removeAttribute("usuarioLogado");
        return "/WEB-INF/paginas/logout.html";
    }
}
