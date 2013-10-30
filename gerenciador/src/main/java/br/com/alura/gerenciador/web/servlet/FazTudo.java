package br.com.alura.gerenciador.web.servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gilberto.andrade
 */
@WebServlet(urlPatterns = "/fazTudo")
public class FazTudo extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tarefa = req.getParameter("tarefa");
        if (tarefa == null) {
            throw new IllegalArgumentException("Você esqueceu de passar a tarefa.");
        }
        String nomeDaClasse = "br.com.alura.gerenciador.web.servlet." + tarefa;
        try {
            Class type = Class.forName(nomeDaClasse);
            Tarefa instancia;
            instancia = (Tarefa) type.newInstance();
            String pagina = instancia.executa(req, resp);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(pagina);
            requestDispatcher.forward(req, resp);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(FazTudo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
