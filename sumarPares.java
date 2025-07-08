/**
 * Programa para identificar y sumar los números pares en un rango de 1 a n.
 * Solicita al usuario un número entero positivo 'n' y calcula la suma de todos
 * los números pares desde 1 hasta 'n'.
 *
 * @author Omar Ali Fuertes
 */
import java.util.Scanner;

public class sumarPares {

    /**
     * Punto de entrada principal del programa.
     * <p>
     * Este método solicita un número al usuario, valida que sea positivo,
     * itera desde 1 hasta ese número, suma los que son pares y finalmente
     * imprime el resultado en la consola.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args) {
        // Se crea un objeto Scanner para leer la entrada del teclado.
        Scanner sc = new Scanner(System.in);

        // Se solicita al usuario que ingrese un número límite.
        System.out.print("Ingrese un número: ");
        int limite = sc.nextInt();

        // Se valida que el número ingresado sea positivo.
        if (limite <= 0) {
            System.out.println("Por favor, ingrese un número mayor a cero.");
        } else {
            // Variable para almacenar la suma acumulada de los números pares.
            int suma = 0;

            // Bucle 'for' para iterar desde 1 hasta el límite definido por el usuario.
            for (int i = 1; i <= limite; i++) {
                // Se comprueba si el número actual (i) es par.
                // Un número es par si el residuo de su división entre 2 es 0.
                if (i % 2 == 0) {
                    // Si es par, se añade a la suma total.
                    suma += i;
                }
            }
            // Se muestra el resultado final en la consola.
            System.out.println("La suma de los números pares entre 1 y " + limite + " es: " + suma);
        }

        // Es una buena práctica cerrar el Scanner para liberar recursos.
        sc.close();
    }
}