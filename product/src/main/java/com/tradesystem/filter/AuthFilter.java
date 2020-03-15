package com.tradesystem.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Base64;

@WebFilter(urlPatterns = "/login")
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest rq, ServletResponse rs, FilterChain chain) throws IOException, ServletException {
        var header = ((HttpServletRequest) rq).getHeader("Authorization");


        var loginAndPass = header.split(" ")[1];
        loginAndPass = new String(Base64.getDecoder().decode(loginAndPass), "UTF-8");
        var loginAndPassArr = loginAndPass.split(":");
        var login = loginAndPassArr[0];
        var password = loginAndPassArr[1];

        if (login.equals("admin") && password.equals("admin")) {
            chain.doFilter(rq, rs);
        } else {
            ((HttpServletResponse) rs).setStatus(401);
        }
    }
}
