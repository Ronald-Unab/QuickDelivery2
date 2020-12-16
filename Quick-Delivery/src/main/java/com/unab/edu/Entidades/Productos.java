/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.Entidades;

import lombok.Data;

/**
 *
 * @author PC
 */
@Data
public class Productos {

    protected int idProducto;
    protected String nombre;
    protected double precioP;
    protected String categoria;
    protected int cantidad;
    protected String descripcion;
}
