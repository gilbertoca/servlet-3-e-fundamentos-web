package br.com.alura.gerenciador.web.servlet;

import javax.servlet.http.Cookie;

/**
 *
 * @author gilberto.andrade
 */
public class Cookies {

    private final Cookie[] cookies;

    public Cookies(Cookie[] cookies) {
        this.cookies = cookies;
    }

    public Cookie getUsuarioLogado() {
        if (cookies == null) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("usuarioLogado")) {
                return cookie;
            }
        }
        return null;
    }
}
