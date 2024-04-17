package com.crud.domain;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/Register")
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Register(){

        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());

    }

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nomeCompleto=request.getParameter("nomeCompleto");
        String matricula=request.getParameter("matricula");
        doGet(request, response);
        Aluno aluno =new Aluno(nomeCompleto, matricula);
        RegisterDao rDao=new RegisterDao();
        String result=rDao.insert(aluno);
        response.getWriter().print(result);
    }
    public void destroy() {
    }
}