package com.qwc.sample.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

/**
 * 文件上传servlet
 *
 * @author GeekQWC
 */
@WebServlet(urlPatterns = "/file/upload")
@MultipartConfig
public class FileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        Collection<Part> parts = req.getParts();
        for (Part part : parts) {
            part.write("/" + part.getName() + ".txt");
        }
        out.println("总共上传了" + parts.size() + "个文件");
        out.flush();
    }
}
