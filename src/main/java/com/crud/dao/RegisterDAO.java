package com.crud.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegisterDao {
    private String dburl="jdbc:mysql://localhost:3306/userdb";
    private String dbuname="root";
    private String dbpassword="password";
    private String dbdriver="com.mysql.jdbc.Driver";
    public void loadDriver(String dbDriver){
        try {
            Class.forName(dbDriver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection(){
        Connection con=null;
        try {
            con = DriverManager.getConnection(dburl, dbuname, dbpassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    public String insert(Aluno aluno){
        loadDriver(dbdriver);
        Connection con=getConnection();
        String sql="INSERT INTO Aluno(nome, matricula) VALUES (?, ?)";
        String result="Dados adicionados";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, aluno.getNomeCompleto());
            ps.setString(2, aluno.getMatricula());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            result="Dados falharam na adição";
        }
        return result;
    }
    public List<Aluno> readAll(){
        loadDriver(dbdriver);
        Connection con = getConnection();
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM Aluno";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno(rs.getString("nome"), rs.getString("matricula"));
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alunos;
    }
    public String update(Aluno aluno){
        loadDriver(dbdriver);
        Connection con = getConnection();
        String sql = "UPDATE alunos SET nome = ?, matricula = ? WHERE id = ?";
        String result = "Dados atualizados";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, aluno.getNomeCompleto());
            ps.setString(2, aluno.getMatricula());
            ps.setString(3, aluno.getId());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                result = "Nenhum registro atualizado";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result = "Falha na atualização dos dados";
        }
        return result;
    }
    public String delete(int id){
        loadDriver(dbdriver);
        Connection con = getConnection();
        String sql = "DELETE FROM alunos WHERE id = ?";
        String result = "Dados excluídos";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                result = "Nenhum registro excluído";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result = "Erro";
        }
        return result;
    }


}
