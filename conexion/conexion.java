/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.quick.delivery.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author PC
 */
public class conexion {
     private Connection conexion; 
    
    public conexion()
    {
        
        try
        {
            
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/appcajero","root","root");
            
            System.out.println("Conectado a la BD");
        
        }
        catch(Exception e)
        {
        
            System.out.println("Error de Conexion" + e);
            
        }
        
    }
    
    public Connection retornarConexion()
    {
        return conexion;
    }
}
