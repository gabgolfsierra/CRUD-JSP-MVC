
<%@ page import="com.crud.domain.Aluno" %>
<%
    int alunoId = Integer.parseInt(request.getParameter("id"));
    Aluno aluno = AlunoDAO.getRegistroById(alunoId);
%>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Aluno</title>
</head>
<body>
<h1>Editar Aluno</h1>
<form action="editar_aluno.jsp" method="post">
    <!-- Campos do formulário preenchidos com os dados do aluno -->
    <input type="hidden" name="id" value="<%= aluno.getId() %>">
    <label>Nome:</label>
    <input type="text" name="nome" value="<%= aluno.getNome() %>">
    <br>
    <label>Sobrenome:</label>
    <input type="text" name="sobrenome" value="<%= aluno.getSobrenome() %>">
    <br>
    <label>Matrícula:</label>
    <input type="text" name="matricula" value="<%= aluno.getMatricula() %>">
    <br>
    <input type="submit" value="Salvar">
</form>
</body>
</html>
