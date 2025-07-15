// Programa para gestionar una tienda de electronica
// Creado por: Omar Ali Fuertes

//  Clase abstracta para representar un producto

abstract class ProductoElectronico {
    protected String id;
    protected String marca;
    protected double precio;
    protected int garantiaMeses;

    public ProductoElectronico(String id, String marca, 
    double precio, int garantiaMeses) {
        this.id = id;
        this.marca = marca;
        this.precio = precio;
        this.garantiaMeses = garantiaMeses;
    }

    // Metodos getter (encapsulamiento)
    public String getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrecio() {
        return precio;
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    // Metodo Abstracto para polimorfismo
    public abstract String getDetalles();
}

// Clase concreta para telefonos (herencia)
class Telefono extends ProductoElectronico {
    private int almacenamientoGB;
    private String sistemaOperativo;

    // Constructor
    public Telefono(String id, String marca, double precio, int garantiaMeses,
    int almacenamientoGB, String sistemaOperativo) {
        super(id, marca, precio, garantiaMeses);
        this.almacenamientoGB = almacenamientoGB;
        this.sistemaOperativo = sistemaOperativo;
    }

    @Override
    public String getDetalles() {
        return "Marca: " + marca + ", Precio: " + precio + ", Garantia: " + garantiaMeses +
        "GB de Almacenamiento" + almacenamientoGB + "GB" + "Sistema Operativo: " + sistemaOperativo;
    }
}

// Clase concreta para computadoras (herencia)
class Laptop extends ProductoElectronico {
    private double tamanoPantalla;
    private int ramGb;

    // Constructor
    public Laptop(String id, String marca, double precio, int garantiaMeses,
    double tamanoPantalla, int ramGb) {
        super(id, marca, precio, garantiaMeses);
        this.tamanoPantalla = tamanoPantalla;
        this.ramGb = ramGb;
    }

    @Override
    public String getDetalles() {
        return "Marca: " + marca + ", Precio: " + precio + ", Garantia: " + garantiaMeses +
        "GB de RAM" + ramGb + "GB" + "Tamaño de Pantalla: " + tamanoPantalla + "inches";
    }
}

// Clase pára gestionar una venta
class Venta {
    private String idVenta;
    private ProductoElectronico producto;
    private int cantidad;
    private double total;

    // Constructor
    public Venta(String idVenta, ProductoElectronico producto, int cantidad, double total) {
        this.idVenta = idVenta;
        this.producto = producto;
        this.cantidad = cantidad;
        this.total = producto.getPrecio() * cantidad;
    }

    public void mostrarResumen() {
        System.out.println("Resumen de la venta:");
        System.out.println("Venta #" + idVenta + ":"
        + producto.getDetalles());
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Total: " + total);
    }

    public double getTotal() {
        return total;
    }
}

// Clase principal para probar el sistema
public class TiendaElectronica {
    public static void main(String[] args) {
        // Creamos un objeto de la clase Producto
        Telefono telefono1 = new Telefono("T1", "Samsung", 1000, 12, 128, "Android");
        Laptop laptop1 = new Laptop("L1", "Dell", 500, 12, 15.6, 8);

        // Crear una venta
        Venta venta1 = new Venta("V1", telefono1, 2, 2000);
        Venta venta2 = new Venta("V2", laptop1, 1, 500);

        // Mostrar el resumen de la venta
        venta1.mostrarResumen();
        venta2.mostrarResumen();

        // Mostrar el total de la venta
        System.out.println("Total: " + venta1.getTotal() + venta2.getTotal());
    }
}
