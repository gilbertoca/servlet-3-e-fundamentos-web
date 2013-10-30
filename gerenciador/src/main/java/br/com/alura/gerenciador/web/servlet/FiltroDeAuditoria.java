package br.com.alura.gerenciador.web.servlet;

import br.com.alura.gerenciador.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gilberto.andrade
 */
@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        String usuario = "<deslogado>";
        if (usuarioLogado != null) {
            usuario = usuarioLogado.getEmail();
        }
        System.out.println("Usuario " + usuario + " acessando a URI " + req.getRequestURI());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

}
