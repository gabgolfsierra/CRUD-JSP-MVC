<%@ page import="com.crud.dao.AlunoDao, com.crud.domain.*, java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View of Alunos</title>
</head>
<body>

<h1>Listagem de Alunos</h1>

<%
    List<Aluno> list = AlunoDao.getAllAlunos();
    request.setAttribute("list", list);

%>

<table>
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Sobrenome</th>
        <th>Matricula</th>
            <% for (Aluno aluno : list) { %>
        <tr>
        <td><%= aluno.getId() %></td>
        <td><%= aluno.getNome() %></td>
        <td><%= aluno.getSobrenome() %></td>
        <td><%= aluno.getMatricula() %></td>
    <td><a href="editform.jsp">Editar</a></td>
    <td><a href="deleteform.jsp">Excluir</a></td>
        </tr>
            <% } %>
</table>
<a href="#">Adicionar novo usuario</a>
</body>
</html>

