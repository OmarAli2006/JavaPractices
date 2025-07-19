// Programa para gestionar una tienda
// Creado por: Omar Ali Fuertes
import java.util.Scanner;
import java.util.ArrayList;

// clase Producto
class Producto {
    private String nombre;
    private int cantidad;
    private double precio;

    // Constructor
    public Producto(String nombre, int cantidad, double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }
}

// clase Tienda
public class Tienda {
    private ArrayList<Producto> inventario;

    // Constructor
    public Tienda() {
        inventario = new ArrayList<>();
    }

    // Métodos para agregar productos a la tienda
    public void agregarProducto(Producto producto) {
        inventario.add(producto);
        System.out.println("Producto agregado con éxito " + producto.getNombre());
    }
    
    // Metodo para mostrar los productos de la tienda
    public void mostrarInventario() {
        if (inventario.isEmpty()) {
            System.out.println("La tienda está vacía.");
        } else {
            for (Producto producto : inventario) {
                System.out.println(producto);
            }
        }
    }

    // Metodo para buscar un producto en la tienda
    public Producto buscarProducto(String nombre) {
        for (Producto producto : inventario) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

    // Metodo para vender un producto de la tienda
    public void venderProducto(String nombre, int cantidadVendida) {
        Producto producto = buscarProducto(nombre);
        if (producto == null) {
            System.out.println("No se encontró el producto.");
        } else if (producto.getCantidad() < cantidadVendida) {
            System.out.println("No hay stock suficiente.");
        } else {
            producto.setCantidad(producto.getCantidad() - cantidadVendida);
            System.out.println("Producto vendido con éxito. " + cantidadVendida + " unidades vendidas.");
        }
    }

    // Metodo para eliminar un producto
    public void eliminarProducto(String nombre) {
        Producto producto = buscarProducto(nombre);
        if (producto == null) {
            System.out.println("No se encontró el producto.");
        } else {
            inventario.remove(producto);
            System.out.println("Producto eliminado con éxito.");
        }
    }

    // Metodo Principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tienda tienda = new Tienda();
        boolean salir = false;

        while(!salir) {
            System.out.println("SISTEMA DE GESTION DE INVENTARIO DE PRODUCTOS");
            System.out.println("----------------------------------------------");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Buscar producto");
            System.out.println("4. Vender producto");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la cantidad del producto: ");
                    int cantidad = scanner.nextInt();
                    System.out.print("Ingrese el precio del producto: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine(); // Consumir el salto de línea pendiente
                    tienda.agregarProducto(new Producto(nombre, cantidad, precio));
                    break;
                case 2:
                    tienda.mostrarInventario();
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombreBusqueda = scanner.nextLine();
                    Producto productoBusqueda = tienda.buscarProducto(nombreBusqueda);
                    if (productoBusqueda == null) {
                        System.out.println("No se encontró el producto.");
                    } else {
                        System.out.println(productoBusqueda);
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombreVenta = scanner.nextLine();
                    System.out.print("Ingrese la cantidad a vender: ");
                    int cantidadVendida = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea pendiente
                    tienda.venderProducto(nombreVenta, cantidadVendida);
                    break;
                case 5:
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombreEliminar = scanner.nextLine();
                    tienda.eliminarProducto(nombreEliminar);
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
            System.out.println("----------------------------------------------");
        }
        scanner.close();
    }   
}
// Fin del programa
