// Programa para generar números aleatorios 
// Con diferentes metodos
// Creado por: Omar Ali Fuertes

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.security.SecureRandom;

public class GenerarNumerosAleatorios {
    
    public static void main(String[] args) {
        System.out.println("=== GENERADORES DE NUMEROS ALEATORIOS ===");
        
        // Diferentes tipos de generadores
        demostrarMathRandom();
        demostrarRandomClass();
        demostrarThreadLocalRandom();
        demostrarSecureRandom();

        // Ejemplos practicos de uso
        ejemplosPracticos();
        
    }

    // 1.- Math.random() - Metodo mas simple
    public static void demostrarMathRandom() {
        System.out.println("Generando números aleatorios con Math.random()...");
        System.out.println("Números aleatorios entre 0.0 y 1.0:");
        for (int i = 0; i < 10; i++) {
            System.out.println(Math.random());
        }

        // Generar enteros en un rango
        System.out.println("\nNúmeros aleatorios entre 0 y 100:");
        for (int i = 0; i < 10; i++) {
            int numero = (int) (Math.random() * 101);
            System.out.println(numero + " ");
        }
        System.out.println("\n");
    }

    // 2.- Clase Random - Mas Control y opciones
    public static void demostrarRandomClass() {
        System.out.println("Generando números aleatorios con la clase Random...");
        Random random = new Random();

        // Semilla para reproducibilidad
        System.out.println("\nUsando una semilla (12345) para reproducibilidad:");
        Random randomSemilla = new Random(12345);
        for (int i = 0; i < 5; i++) {
            System.out.print(randomSemilla.nextInt(100) + " ");
        }
        System.out.println("\n -> Siempre serán los mismos 5 números si la semilla es 12345");

        System.out.println("\nEnteros aleatorios");
        for (int i = 0; i < 5; i++) {
            System.out.println(random.nextInt() + " ");
        }   
        
        System.out.println("\nEnteros en rango 0 y 100");
        for (int i = 0; i < 5; i++) {
            System.out.println(random.nextInt(100) + " ");
        }

        System.out.println("\nNumeros aleatorios entre 0 y 1");
        for (int i = 0; i < 5; i++) {
            System.out.printf("%.4f ", random.nextDouble());
        }

        System.out.println("\nBooleanos");
        for (int i = 0; i < 5; i++) {
            System.out.println(random.nextBoolean() + " ");
        }

        System.out.println("\nGaussianos (Distribution Normal)");
        for (int i = 0; i < 5; i++) {
            System.out.println(random.nextGaussian() + " ");
        }
        System.out.println("\n");
    }

    // 3.- ThreadLocalRandom - Para aplicaciones multihilo
    public static void demostrarThreadLocalRandom() {
        System.out.println("Generando números aleatorios con ThreadLocalRandom...");
        ThreadLocalRandom random = ThreadLocalRandom.current();
        
        System.out.println("Enteros aleatorios en rango 10 a 50");
        for (int i = 0; i < 5; i++) {
            System.out.print(random.nextInt(10, 51) + " ");
        }

        System.out.println("\nDoubles aleatorios en rango 0 a 1");
        for (int i = 0; i < 5; i++) {
            System.out.printf("%.4f ", random.nextDouble(0, 1));
        }

        System.out.println("\nLongs en rango 100 a 1000");
        for (int i = 0; i < 5; i++) {
            System.out.println(random.nextLong(100, 1000) + " ");
        }
        System.out.println("\n");
    }

    // 4.- SecureRandom - Para aplicaciones criptográficas
    public static void demostrarSecureRandom() {
        System.out.println("Generando números aleatorios con SecureRandom...");
        SecureRandom random = new SecureRandom();

        System.out.println("Numeros seguros para criptografia");
        for (int i = 0; i < 5; i++) {
            System.out.print(random.nextInt(1000) + " ");
        }

        // Generando bytes aleatorios
        byte[] bytes = new byte[8];
        random.nextBytes(bytes);
        System.out.println("\nBytes aleatorios");
        for (byte b : bytes) {
            System.out.printf("%02x", b);
        }
        System.out.println("\n");
    }

    // Ejemplos practicos de uso
    public static void ejemplosPracticos() {
        System.out.println("Ejemplos practicos de uso...");

        // Simulacion de dados
        simulacionDados();

        // Selección aleatoria de elementos
        seleccionAleatoria();

        // Generación de contraseñas
        generarPassword();

        // Distribución personalizada
        distribucionPersonalizada();

        // Mezclar listas
        mezclarLista();
    }

    public static void simulacionDados() {
        System.out.println("Simulacion de dados...");
        Random random = new Random();
        int[] frecuencia = new int[6];
        int tiradas = 1000;

        for (int i = 0; i < tiradas; i++) {
            int dado = random.nextInt(6) + 1;
            frecuencia[dado - 1]++;
        }

        System.out.println("Resultado de " + tiradas + " tiradas:");
        for (int i = 0; i < 6; i++) {
            System.out.printf("Cara %d: %d veces (%.1f%%)\n",
             i + 1, frecuencia[i], (frecuencia[i] * 100.0) / tiradas);
        }
        System.out.println();
    }

    public static void seleccionAleatoria() {
        System.out.println("Selección aleatoria de elementos...");
        String[] nombres = {"Ana", "Carlos", "María", "Juan", "Laura", "Pedro"};
        Random random = new Random();

        System.out.println("Selección aleatoria de elementos:");
        for (int i = 0; i < 3; i++) {
            int indice = random.nextInt(nombres.length);
            System.out.println("- " + nombres[indice]);
        }
        System.out.println();
    }

    public static void generarPassword() {
        System.out.println("Generando contraseñas...");
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        int longitud = 12;
        for (int i = 0; i < longitud; i++) {
            int indice = random.nextInt(caracteres.length());
            password.append(caracteres.charAt(indice));
        }

        System.out.println("Contraseña generada: " + password.toString());
        System.out.println();
    }

    public static void distribucionPersonalizada() {
        System.out.println("Distribución personalizada (mas probabilidad de numeros bajos)");
        Random random = new Random();
        int[] frecuencias = new int[10];

        for (int i = 0; i < 1000; i++) {
            // Distribucion exponencial inversa
            double r = random.nextDouble();
            int numero = (int)(Math.pow(r, 3) * 10);
            if (numero < 10) {
                frecuencias[numero]++;
            }
        }

        System.out.println("Frecuencias de los números de 0 a 9:");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d: %s (%d)\n", i, "*".repeat(frecuencias[i]/10), frecuencias[i]);
        }
        System.out.println();
    }

    public static void mezclarLista() {
        System.out.println("Mezclando listas...");
        List<String> cartas = Arrays.asList(
            "As♠", "Rey♠", "Reina♠", "Jota♠", "10♠",
            "As♥", "Rey♥", "Reina♥", "Jota♥", "10♥"
        );

        System.out.println("Orden original:" + cartas);

        List<String> cartasMezcladas = new ArrayList<>(cartas);
        Collections.shuffle(cartasMezcladas);

        System.out.println("Orden mezclado:" + cartasMezcladas);

        // Mezclar con semilla especifica
        Collections.shuffle(cartasMezcladas, new Random(42));
        System.out.println("Orden mezclado con semilla:" + cartasMezcladas);
    }

    // Los métodos numeroEnRango y decimalEnRango se han eliminado por ineficientes.
    // Es mejor usar una única instancia de Random como se muestra en los ejemplos de arriba.
}
