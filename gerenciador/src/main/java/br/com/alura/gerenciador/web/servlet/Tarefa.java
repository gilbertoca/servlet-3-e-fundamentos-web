
package br.com.alura.gerenciador.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gilberto.andrade
 */
public interface Tarefa {
    public String executa(HttpServletRequest req, HttpServletResponse resp);
}
