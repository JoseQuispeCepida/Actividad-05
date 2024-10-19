package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listar(){
        List<Persona>datos = new ArrayList<>();
        String sql = "SELECT * FROM persona";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
        
            while (rs.next()) {
                Persona p = new Persona();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setCorreo(rs.getString(3));
                p.setTel(rs.getString(4));
                datos.add(p);
            }
        } catch (Exception e){            
        } 
        return datos;
    } 
    
    public int agregar(Persona p){
        String sql = "insert into persona (nombres,Correo,Telefono) values (?,?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,p.getNom());
            ps.setString(2,p.getCorreo());
            ps.setString(3,p.getTel());
            ps.executeUpdate();
        } catch (Exception e){           
        }
        return 1;
    }
    
    public int Actualizar(Persona p){
        int r = 0;
        String sql = "update persona set Nombres=?, correo=?, Telefono=? Where Id=?";
        try{
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,p.getNom());
            ps.setString(2,p.getCorreo());
            ps.setString(3,p.getTel());
            ps.setInt(4,p.getId());
            r = ps.executeUpdate();
            if (r == 1){
                return 1;
            }else{
                return 0;
            }
        } catch (Exception e){            
        }
        return r;
    }
    
    public void delete (int id){
        String sql = "delete from persona where id ="+id;
        try{
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){           
        }
    }
}
