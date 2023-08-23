
package com.mycompany.poo_shop_on_line;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class mein {
    public static void main(String[] args) {
        Remera[] remera = new Remera[8];
        cargarRemera(remera);
        Pantalon[] pantalon = new Pantalon[6];
        cargarPantalon(pantalon);
        Accesorio[] accesorio = new Accesorio[6];
        cargarAccesorio(accesorio);
        Scanner lector = new Scanner(System.in);
        System.out.println("cuantas ventas aras");
        int num = lector.nextInt();
        Venta[] venta = new Venta[num-1];
        for (int i = 0; i < num; i++) {
            cargarVenta(remera, pantalon, accesorio, lector);
        }
    }

    private static void cargarRemera(Remera[] remera) {
        remera[0] = new Remera("blanco", 7500.00, "S");
        remera[1] = new Remera("negro", 7000.00, "S");
        remera[2] = new Remera("blanco", 7500.00, "M");
        remera[3] = new Remera("negro", 7000.00, "M");
        remera[4] = new Remera("blanco", 7500.00, "L");
        remera[5] = new Remera("negro", 7000.00, "L");
        remera[6] = new Remera("blanco", 7500.00, "XL");
        remera[7] = new Remera("negro", 7000.00, "XL");  
    }

    private static void cargarPantalon(Pantalon[] pantalon) {
       pantalon[0] = new Pantalon("azul", 7500.00, 4, "Oxford");
       pantalon[1] = new Pantalon("negro", 7500.00, 5, "Oxford");
       pantalon[2] = new Pantalon("azul", 7500.00, 4, "Skinny");
       pantalon[3] = new Pantalon("negro", 7500.00, 5, "Skinny");
       pantalon[4] = new Pantalon("azul", 7500.00, 4, "Recto");
       pantalon[5] = new Pantalon("negro", 7500.00, 5, "Recto");
    }

    private static void cargarAccesorio(Accesorio[] accesorio) {
        accesorio[0] = new Accesorio("collar", 8500.00, "Acero", 15);
        accesorio[1] = new Accesorio("pulsera", 7500.00, "Acero", 15);
        accesorio[2] = new Accesorio("collar", 8500.00, "Plata", 15);
        accesorio[3] = new Accesorio("pulsera", 7500.00, "Plata", 15);
        accesorio[4] = new Accesorio("collar", 8500.00, "Oro", 15);
        accesorio[5] = new Accesorio("pulsera", 7500.00, "Oro", 15);
    }

    private static void cargarVenta(Remera[] remera, Pantalon[] pantalon, Accesorio[] accesorio,Scanner lector) {
        System.out.println("Ingresamos las credenciales de el cliente: ");
        Cliente cliente = cargarCliente(lector);
        Venta venta = null;
        LocalDate hoy = LocalDate.now();
        venta = new Venta(cliente, hoy);
        System.out.println("Cuantos productos vas a ingresar en la compra: ");
        int candP = lector.nextInt();
        ArrayList<Producto> productos = new ArrayList<>();
        for (int i = 0; i < candP; i++) {
           mostrarProduntos(remera, pantalon, accesorio, lector, productos, venta); 
        }
        venta.agregarProducto(productos);
        venta.imprimirFactura();
    }
    
    private static Cliente cargarCliente(Scanner lector) {
        System.out.println("Cual es su nombre");
        String nom = lector.next();
        System.out.println("Cual es su apellido ");
        String ape = lector.next();
        System.out.println("Cual es su dni ");
        int DNI = lector.nextInt();   
        Cliente cliente = new Cliente(nom, ape, DNI);
        return cliente;
    }
    
    private static void mostrarProduntos(Remera[] remera, Pantalon[] pantalon, Accesorio[] accesorio, Scanner lector, ArrayList<Producto> productos, Venta venta) {
        System.out.println("Que tipo de producto busca\n"
                + "1) Remeras'\n"
                + "2) Pantalones\n"
                + "3) Accesorios");
        int res = lector.nextInt();
        switch (res) {
            case 1:
                productos.add(MostrarRemeras(remera,lector,productos));
                break;
            case 2:
                productos.add(MostrarPantalones(pantalon, lector));
                break;
            case 3:
                productos.add(MostrarAccesorios(accesorio, lector));
                break;
        }
    }

    private static Remera MostrarRemeras(Remera[] remera, Scanner lector, ArrayList<Producto> productos) {
       Remera producto = null;
        System.out.println("Que talle esta buscando:\n"
                + "S\n"
                + "M\n"
                + "L\n"
                + "XL");
        String res = lector.next();
        int i = 0;
        for (Remera re : remera) {
            if (re.getTalle().equals(res)) {
                i++;
                System.out.println(i +") "+re.toString()); 
            }
        }
        System.out.println("Que procto quieres comprar:");
        int res1 = lector.nextInt();
        i=0;
        for(Remera re : remera){
            if(re.getTalle().equals (res)){
                i++;
                if (i == res1) {
                    System.out.println(re.getPrecio());
                    
                    producto = new Remera(re.getDesc(),re.getPrecio(),re.getTalle());
                }
            }
        }
        return producto;
    }

    private static Pantalon MostrarPantalones(Pantalon[] pantalon, Scanner lector) {
        Pantalon producto = null;
        System.out.println("Que talle esta buscando:\n"
                + "4\n"
                + "5");
        int res = lector.nextInt();
        int i = 0;
        for(Pantalon pa : pantalon){
            if(pa.getTalle() == res){
                i++;
                System.out.println(i+") "+pa.toString());
            }
        }
        System.out.println("Que procto quieres comprar:");
        int res1 = lector.nextInt();
        i=0;
        for(Pantalon pa : pantalon){
            if(pa.getTalle() == res){
                i++;
                if (i == res1) {
                    producto = new Pantalon(pa.getDesc(),pa.getPrecio(),pa.getTalle(),pa.getModelo());
                }
            }
        }
        return producto;
    }

    private static Accesorio MostrarAccesorios(Accesorio[] accesorio, Scanner lector) {
        Accesorio producto = null;
        System.out.println("Que tipo de accesorio busca:\n"
                + "collar\n"
                + "pulsera\n");
        String res = lector.next();
        int i = 0;
        for(Accesorio ac : accesorio){
            if(ac.getDesc().equals(ac)){
                i++;
                System.out.println(i+") "+ac.toString());
            }
        }
        System.out.println("Que procto quieres comprar:");
        int res1 = lector.nextInt();
        i=0;
        for(Accesorio ac : accesorio){
            i++;
            if(ac.getDesc().equals(res)){
                if(i == res1){
                    producto = new Accesorio(ac.getDesc(),ac.getPrecio(),ac.getMetal(),ac.getGramo());
                }
            }
        }
        return producto;
    }
}
