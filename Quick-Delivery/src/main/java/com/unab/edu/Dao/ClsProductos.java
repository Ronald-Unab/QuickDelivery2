/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.Dao;

import com.unab.edu.Entidades.Productos;
import com.unab.edu.quick.delivery.conexion.conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author orell
 */
public class ClsProductos {

    conexion conectarclase = new conexion();
    Connection conectar = conectarclase.retornarConexion();

    public void AgregarProductos(Productos Prod) {
        try {
            CallableStatement Statement = conectar.prepareCall(" call sp_IngresarProducto(?,?,?,?,?)");
            Statement.setString("NombreProd", Prod.getNombre());
            Statement.setInt("CantidadProd", Prod.getCantidad());
            Statement.setString("DescripcionProd", Prod.getDescripcion());
            Statement.setString("Categoria", Prod.getCategoria());
            Statement.setDouble("PrecioPrdd", Prod.getPrecioP());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "PRODUCTO GUARDADO");
            conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

//    public void BorrarPersonas(Persona Per) {
//        try {
//            CallableStatement Statement = conectar.prepareCall(" call SP_D_Persona(?)");
//            Statement.setInt("PIdPersonas", Per.getIdPersona());
//            Statement.execute();
//            JOptionPane.showMessageDialog(null, "PERSONA ELIMINADA");
//            conectar.close();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }
//
//    public void ActualizarPersona(Persona Per) {
//        try {
//            CallableStatement Statement = conectar.prepareCall(" call SP_U_Persona(?,?,?,?,?)");
//            Statement.setInt("PIdPersona", Per.getIdPersona());
//            Statement.setString("PNombre", Per.getNombre());
//            Statement.setString("PApellido", Per.getApellido());
//            Statement.setInt("PEdad", Per.getEdad());
//            Statement.setString("PSexo", Per.getSexo());
//            Statement.execute();
//            conectar.close();
//            JOptionPane.showMessageDialog(null, "PERSONA ACTUALIZADA");
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }
    
    public ArrayList<Productos> MostrarProductos() {
        ArrayList<Productos> Productos = new ArrayList<>();
        try {
            CallableStatement Statement = conectar.prepareCall("call SP_SProducto()");
            ResultSet resultadoDeConsulta = Statement.executeQuery();

            while (resultadoDeConsulta.next()) {
                Productos prod = new Productos();
                prod.setIdProducto(resultadoDeConsulta.getInt("idProducto"));
                prod.setNombre(resultadoDeConsulta.getString("nombreP"));
                prod.setCantidad(resultadoDeConsulta.getInt("cantidadProducto"));
                prod.setDescripcion(resultadoDeConsulta.getNString("descripcionP"));
                prod.setCategoria(resultadoDeConsulta.getNString("categoria"));
                prod.setPrecioP(resultadoDeConsulta.getDouble("precioP"));

                Productos.add(prod);
            }
            conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return Productos;
    }
}
