package com.crud.dao;

import com.crud.domain.Aluno;
import org.postgresql.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.crud.dao.Provider.*;

public class AlunoDao {

    public static Connection getConnection(){
        Connection con = null;

        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connURL,username,pwd);
        }catch(Exception e){
            System.out.println(e);
        }
        return con;
    }


    public class AlunoDAO {

        public void insertAluno(){
            Aluno aluno = null;
            try {
                Connection con = null;
                PreparedStatement ps = con.prepareStatement("INSERT INTO crud.aluno VALUES ( ?, ?, ?) ");
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    aluno.setNome(rs.getString("nome"));
                    aluno.setSobrenome(rs.getString("sobrenome"));

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }

        public Aluno getRegistroById(int id){
            Aluno aluno = null;
            try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("SELECT * FROM crud.aluno WHERE id = ?");
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    aluno = new Aluno();
                    aluno.setId(rs.getInt("id"));
                    aluno.setNome(rs.getString("nome"));
                    aluno.setSobrenome(rs.getString("sobrenome"));
                    aluno.setMatricula(rs.getInt("matricula"));
                }
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return aluno;
        }
    }



    public static List<Aluno> getAllAlunos(){
        List<Aluno> list = new ArrayList<Aluno>();

        try{
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM crud.aluno");
            ResultSet rs = ps.executeQuery();


            while(rs.next()){
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setSobrenome(rs.getString("sobrenome"));
                aluno.setMatricula(rs.getInt("matricula"));
                list.add(aluno);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return list;





    }



}
