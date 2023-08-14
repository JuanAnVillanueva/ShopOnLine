/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.poo_shop_on_line;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author CS09
 */
public class Venta {
    private ArrayList <Producto> listaProd;
    private Cliente cliente;
    private static int cantVenta = 1090;
    private static int nroFact;
    private LocalDate fecha;
    
    

    public Venta(Cliente cliente,LocalDate fecha) {
        this.cliente = cliente;
        this.cantVenta++ ;
        this.nroFact++;
        this.fecha = fecha;
    }
    
    public void agregarProducto(ArrayList<Producto> p){
        this.listaProd = p;
    }
    
    public double calcularTotal(){
        double totalPrecio = 0;
        for(Producto Prod : listaProd){
            totalPrecio +=Prod.getPrecio();
        }
        return totalPrecio;
    }
    public void imprimirFactura(){
        System.out.println("numero de venta............: "+cantVenta+
                "|.............fecha: "+fecha);
        System.out.println(cliente.toString());
        System.out.println("");
        System.out.println("productos");
        System.out.println(listaProd.toString());
        System.out.println("total a pagar: "+calcularTotal());
    }
}
