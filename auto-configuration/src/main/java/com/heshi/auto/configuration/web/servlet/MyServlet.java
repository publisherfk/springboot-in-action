package com.heshi.auto.configuration.web.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "myServlet", urlPatterns = "/my/servlet", asyncSupported = true)
public class MyServlet extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(MyServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        AsyncContext context = req.startAsync();
        context.start(() -> {
            try {
                resp.getWriter().write("hello world by write");
                context.complete();
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        });
    }
}
