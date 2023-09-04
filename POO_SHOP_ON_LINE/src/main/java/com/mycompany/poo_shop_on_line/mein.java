package com.mycompany.poo_shop_on_line;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class mein {
    public static void main(String[] args) {
        // Crear arrays para almacenar productos
        Remera[] remera = new Remera[8];
        cargarRemera(remera);

        Pantalon[] pantalon = new Pantalon[6];
        cargarPantalon(pantalon);

        Accesorio[] accesorio = new Accesorio[6];
        cargarAccesorio(accesorio);

        // Configurar entrada del usuario
        Scanner lector = new Scanner(System.in);

        System.out.println("Cuantas ventas harás:");
        int num = lector.nextInt();

        // Crear un array para almacenar ventas
        Venta[] venta = new Venta[num - 1];
        cargarVenta(remera, pantalon, accesorio, lector);
    }

    private static void cargarRemera(Remera[] remera) {
        // Cargar datos de remeras en el array
        // Aquí se crean objetos de tipo Remera y se almacenan en el array 'remera'
        // También se muestra el precio de cada remera
        remera[0] = new Remera("blanco", 7500.00, "S");
        remera[1] = new Remera("negro", 7000.00, "S");
        remera[2] = new Remera("blanco", 7500.00, "M");
        remera[3] = new Remera("negro", 7000.00, "M");
        remera[4] = new Remera("blanco", 7500.00, "L");
        remera[5] = new Remera("negro", 7000.00, "L");
        remera[6] = new Remera("blanco", 7500.00, "XL");
        remera[7] = new Remera("negro", 7000.00, "XL");

        System.out.println("Remeras:");
        for (Remera re : remera) {
            System.out.println("Precio: " + re.getPrecio());
        }
    }

    private static void cargarPantalon(Pantalon[] pantalon) {
        // Cargar datos de pantalones en el array
        // Aquí se crean objetos de tipo Pantalon y se almacenan en el array 'pantalon'
        // También se muestra el precio de cada pantalón
        pantalon[0] = new Pantalon("azul", 7500.00, 4, "Oxford");
        pantalon[1] = new Pantalon("negro", 7500.00, 5, "Oxford");
        pantalon[2] = new Pantalon("azul", 7500.00, 4, "Skinny");
        pantalon[3] = new Pantalon("negro", 7500.00, 5, "Skinny");
        pantalon[4] = new Pantalon("azul", 7500.00, 4, "Recto");
        pantalon[5] = new Pantalon("negro", 7500.00, 5, "Recto");

        System.out.println("Pantalones:");
        for (Pantalon pa : pantalon) {
            System.out.println("Precio: " + pa.getPrecio());
        }
    }

    private static void cargarAccesorio(Accesorio[] accesorio) {
        // Cargar datos de accesorios en el array
        // Aquí se crean objetos de tipo Accesorio y se almacenan en el array 'accesorio'
        // También se muestra el precio de cada accesorio
        accesorio[0] = new Accesorio("collar", 8500.00, "Acero", 15);
        accesorio[1] = new Accesorio("pulsera", 7500.00, "Acero", 15);
        accesorio[2] = new Accesorio("collar", 8500.00, "Plata", 15);
        accesorio[3] = new Accesorio("pulsera", 7500.00, "Plata", 15);
        accesorio[4] = new Accesorio("collar", 8500.00, "Oro", 15);
        accesorio[5] = new Accesorio("pulsera", 7500.00, "Oro", 15);

        System.out.println("Accesorios:");
        for (Accesorio ac : accesorio) {
            System.out.println("Precio: " + ac.getPrecio());
        }
    }

    private static void cargarVenta(Remera[] remera, Pantalon[] pantalon, Accesorio[] accesorio, Scanner lector) {
        // Realizar la carga de una venta
        // Se crea un objeto de tipo Cliente, se configura la fecha actual y se inicia una venta
        System.out.println("Ingresamos las credenciales de el cliente:");
        Cliente cliente = cargarCliente(lector);
        LocalDate hoy = LocalDate.now();
        Venta venta = new Venta(cliente, hoy);

        System.out.println("Cuantos productos vas a ingresar en la compra: ");
        int candP = lector.nextInt();

        ArrayList<Producto> productos = new ArrayList<>();
        mostrarProductos(remera, pantalon, accesorio, lector, productos, venta);
    }

    private static Cliente cargarCliente(Scanner lector) {
        // Capturar información del cliente
        System.out.println("¿Cuál es su nombre?");
        String nom = lector.next();
        System.out.println("¿Cuál es su apellido?");
        String ape = lector.next();
        System.out.println("¿Cuál es su DNI?");
        int DNI = lector.nextInt();

        // Crear un objeto de tipo Cliente
        Cliente cliente = new Cliente(nom, ape, DNI);
        return cliente;
    }

    private static void mostrarProductos(Remera[] remera, Pantalon[] pantalon, Accesorio[] accesorio, Scanner lector, ArrayList<Producto> productos, Venta venta) {
        // Mostrar productos disponibles y permitir al cliente seleccionar productos para la venta
        System.out.println("¿Qué tipo de producto busca?\n"
                + "1) Remeras\n"
                + "2) Pantalones\n"
                + "3) Accesorios");
        int res = lector.nextInt();
        switch (res) {
            case 1:
                productos.add(mostrarRemeras(remera, lector, productos));
                break;
            case 2:
                productos.add(mostrarPantalones(pantalon, lector));
                break;
            case 3:
                productos.add(mostrarAccesorios(accesorio, lector));
                break;
        }
        venta.agregarProductos(productos);
        venta.imprimirFactura();
    }

    private static Remera mostrarRemeras(Remera[] remera, Scanner lector, ArrayList<Producto> productos) {
        // Mostrar remeras disponibles y permitir al cliente seleccionar una
        Remera producto = null;
        System.out.println("¿Qué talle está buscando?\n"
                + "S\n"
                + "M\n"
                + "L\n"
                + "XL");
        String res = lector.next();
        int i = 0;
        for (Remera re : remera) {
            if (re.getTalle().equals(res)) {
                i++;
                System.out.println(i + ") " + re.toString());
            }
        }
        System.out.println("¿Qué producto quieres comprar?");
        int res1 = lector.nextInt();
        i = 0;
        for (Remera re : remera) {
            if (re.getTalle().equals(res)) {
                i++;
                if (i == res1) {
                    System.out.println("Precio: " + re.getPrecio());

                    // Crear un objeto Remera para el producto seleccionado
                    producto = new Remera(re.getDesc(), re.getPrecio(), re.getTalle());
                }
            }
        }
        return producto;
    }

    private static Pantalon mostrarPantalones(Pantalon[] pantalon, Scanner lector) {
        // Mostrar pantalones disponibles y permitir al cliente seleccionar uno
        Pantalon producto = null;
        System.out.println("¿Qué talle está buscando?\n"
                + "4\n"
                + "5");
        int res = lector.nextInt();
        int i = 0;
        for (Pantalon pa : pantalon) {
            if (pa.getTalle() == res) {
                i++;
                System.out.println(i + ") " + pa.toString());
            }
        }
        System.out.println("¿Qué producto quieres comprar?");
        int res1 = lector.nextInt();
        i = 0;
        for (Pantalon pa : pantalon) {
            if (pa.getTalle() == res) {
                i++;
                if (i == res1) {
                    // Crear un objeto Pantalon para el producto seleccionado
                    producto = new Pantalon(pa.getDesc(), pa.getPrecio(), pa.getTalle(), pa.getModelo());
                }
            }
        }
        return producto;
    }

    private static Accesorio mostrarAccesorios(Accesorio[] accesorio, Scanner lector) {
        // Mostrar accesorios disponibles y permitir al cliente seleccionar uno
        Accesorio producto = null;
        System.out.println("¿Qué tipo de accesorio busca?\n"
                + "collar\n"
                + "pulsera\n");
        String res = lector.next();
        int i = 0;
        for (Accesorio ac : accesorio) {
            if (ac.getDesc().equals(ac)) {
                i++;
                System.out.println(i + ") " + ac.toString());
            }
        }
        System.out.println("¿Qué producto quieres comprar?");
        int res1 = lector.nextInt();
        i = 0;
        for (Accesorio ac : accesorio) {
            i++;
            if (ac.getDesc().equals(res)) {
                if (i == res1) {
                    // Crear un objeto Accesorio para el producto seleccionado
                    producto = new Accesorio(ac.getDesc(), ac.getPrecio(), ac.getMetal(), ac.getGramo());
                }
            }
        }
        return producto;
    }
}
