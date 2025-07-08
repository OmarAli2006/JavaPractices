/**
 * Ejercicio de programación usando POO para simular la gestión de una Biblioteca de libros.
 *
 * @author Omar Ali Fuertes
 */

import java.util.ArrayList;
import java.util.List;

// Clase Libro
class Libro {
    private String titulo;
    private String autor;
    private int anioPublicacion;

    // Constructor
    public Libro(String titulo, String autor, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    // Método toString para imprimir información del libro
    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", Año: " + anioPublicacion;
    }
}

// Clase Biblioteca
class Biblioteca {
    private List<Libro> libros; // Lista para almacenar los libros

    // Constructor
    public Biblioteca() {
        libros = new ArrayList<>();
    }

    // Método para agregar un libro
    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("Libro agregado: " + libro.getTitulo());
    }

    // Método para buscar un libro por título
    public Libro buscarPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro; // Devuelve el libro si se encuentra
            }
        }
        return null; // Retorna null si no se encuentra
    }

    // Método para mostrar todos los libros
    public void mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("La biblioteca está vacía.");
        } else {
            System.out.println("Libros en la biblioteca:");
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        }
    }
}

// Clase principal para probar la aplicación
public class GestionarBiblioteca {
    public static void main(String[] args) {
        // Creamos una instancia de la biblioteca
        Biblioteca biblioteca = new Biblioteca();

        // Creamos algunos libros
        Libro libro1 = new Libro("El Quijote", "Miguel de Cervantes", 1605);
        Libro libro2 = new Libro("Cien años de soledad", "Gabriel García Márquez", 1967);
        Libro libro3 = new Libro("1984", "George Orwell", 1949);

        // Agregamos libros a la biblioteca
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);

        // Mostramos todos los libros
        biblioteca.mostrarLibros();

        // Buscamos un libro por título
        System.out.println("\nBuscando libro...");
        String tituloBuscado = "1984";
        Libro libroEncontrado = biblioteca.buscarPorTitulo(tituloBuscado);
        if (libroEncontrado != null) {
            System.out.println("Libro encontrado: " + libroEncontrado);
        } else {
            System.out.println("Libro no encontrado: " + tituloBuscado);
        }
    }
}