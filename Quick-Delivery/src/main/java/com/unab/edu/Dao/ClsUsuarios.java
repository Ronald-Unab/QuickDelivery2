/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.Dao;


import com.unab.edu.Entidades.Usuarios;
import com.unab.edu.quick.delivery.conexion.conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author PC
 */

public class ClsUsuarios {
    conexion conectarclase = new conexion();
    Connection conectar = conectarclase.retornarConexion();

    public boolean LoguinUsuarios(String usuario, String Pass) {
        ArrayList<Usuarios> ListaUsuarios = new ArrayList<>();
        ArrayList<Usuarios> ListarContra = new ArrayList<>();
        try {
            CallableStatement st = conectar.prepareCall("call sp_loguin (?,?)");

            st.setString("LcorreoUsuario", usuario);
            st.setString("LcontraUsuario", Pass);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Usuarios us = new Usuarios();
                us.setCorreoU(rs.getNString("correoU"));
                us.setContraU(rs.getNString("contraU"));
                ListaUsuarios.add(us);
            }
            String usuariodebasedatos = null;
            String passdebasededatos = null;
            for (var iterador : ListaUsuarios) {
                usuariodebasedatos = iterador.getCorreoU();
                passdebasededatos = iterador.getContraU();

            }

            CallableStatement st2 = conectar.prepareCall("call sp_cripPass(?)");
            st2.setString("cripContra", Pass);
            ResultSet rs2 = st2.executeQuery();
            while (rs2.next()) {
                Usuarios escrip = new Usuarios();

                escrip.setContraU(rs2.getNString("crip"));
                ListarContra.add(escrip);
            }

            String passcrip = null;
            for (var iterador : ListarContra) {

                passcrip = iterador.getContraU();

                Pass = passcrip;

            }

            if (usuariodebasedatos != null && passdebasededatos != null) {
                if (usuariodebasedatos.equals(usuario) && passdebasededatos.equals(Pass)) {
                    return true;
                }
            }
            conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
        return false;
    }
    
}
