package com.alexander.modelo;

import com.alexander.config.Conexion;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public class ProductoDAO extends Conexion{

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r=0;
   

    public Producto listarId(int id) {
        Producto pro = new Producto();
        String sql = "select * from producto where IdProducto=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pro.setId(rs.getInt(1));
                pro.setNombres(rs.getString(2));
                pro.setFoto(rs.getBinaryStream(3));
                pro.setDescripcion(rs.getString(4));
                pro.setPrecio(rs.getDouble(5));
                pro.setStock(rs.getInt(6));                
            }
        } catch (Exception e) {
        }
        return pro;
    }

    public List listar() {
        List<Producto>productos=new ArrayList();
        String sql = "SELECT * from producto";
        try {            
            ps = getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto pro = new Producto();
                pro.setId(rs.getInt(1));
                pro.setNombres(rs.getString(2));
                pro.setFoto(rs.getBinaryStream(3));
                pro.setDescripcion(rs.getString(4));
                pro.setPrecio(rs.getDouble(5));
                pro.setStock(rs.getInt(6));                
                productos.add(pro);
            }
        } catch (Exception e) {
        }
        return productos;
    }
    
    
    public List listarG(){
        List<Producto>productos=new ArrayList();
        String sql = "Select * from producto where Nombres like 'Gorra%'";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Producto p=new Producto();
                p.setId(rs.getInt(1));
                p.setNombres(rs.getString(2));
                p.setFoto(rs.getBinaryStream(3));
                p.setDescripcion(rs.getString(4));
                p.setPrecio(rs.getDouble(5));
                p.setStock(rs.getInt(6));
                productos.add(p);
                
            }
        }catch(Exception e){
            
        }
        return productos ;
    }

    public void listarImg(int id, HttpServletResponse response) {
        String sql = "select * from producto where IdProducto=" + id;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            outputStream = response.getOutputStream();
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                inputStream = rs.getBinaryStream("Foto");
            }
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            int i = 0;
            while ((i = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(i);
            }
        } catch (Exception e) {
        }
    }
    
    
}
