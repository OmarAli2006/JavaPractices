// Programa para practicar el patron de diseño abstract factory
// Creado por: Omar Ali Fuertes

import java.util.Locale;

// Productos Abstractos
/**
 * Define la interfaz para un producto de tipo botón.
 */
interface Button {
    void paint();
}

/**
 * Define la interfaz para un producto de tipo casilla de verificación.
 */
interface Checkbox {
    void paint();
}

// Productos Concretos para Windows
class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Renderizando botón estilo Windows.");
    }
}

class WindowsCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Renderizando checkbox estilo Windows.");
    }
}

// Productos Concretos para Mac
class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Renderizando botón estilo Mac.");
    }
}

class MacCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Renderizando checkbox estilo macOS.");
    }
}

// Productos concretos para linux
class LinuxButton implements Button {
    @Override
    public void paint() {
        System.out.println("Renderizando botón estilo Linux.");
    }
}

class LinuxCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Renderizando checkbox estilo Linux.");
    }
}

// Abstract Factory
/**
 * La interfaz de la fábrica abstracta declara un conjunto de métodos
 * para crear cada uno de los productos abstractos.
 */
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Fabricas Concretas
/**
 * Fábrica concreta para crear objetos GUI para Windows.
 */
class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
 
    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

/**
 * Fábrica concreta para crear objetos GUI para macOS.
 */
class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }
 
    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

/**
 * Fábrica concreta para crear objetos GUI para Linux.
 */
class LinuxFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new LinuxButton();
    }
 
    @Override
    public Checkbox createCheckbox() {
        return new LinuxCheckbox();
    }
}

// Cliente para usar la fabrica
/**
 * El cliente trabaja con fábricas y productos a través de sus interfaces abstractas.
 * No conoce las implementaciones concretas.
 */
class Application {
    private final Button button;
    private final Checkbox checkbox;
 
    public Application(GUIFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }
 
    public void paint() {
        button.paint();
        checkbox.paint();
    }
}

/**
 * Clase principal que configura y ejecuta la aplicación.
 * Demuestra el uso del patrón Abstract Factory.
 */
public class ApplicationConfigurator {

    /**
     * Enum para representar los sistemas operativos soportados.
     * Facilita la selección de la fábrica y mejora la legibilidad.
     */
    private enum OperatingSystem {
        WINDOWS, MACOS, LINUX, UNKNOWN
    }

    /**
     * Determina el sistema operativo actual de forma más robusta.
     * @return el enum OperatingSystem correspondiente.
     */
    private static OperatingSystem getCurrentOS() {
        String osName = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
        if (osName.contains("win")) {
            return OperatingSystem.WINDOWS;
        } else if (osName.contains("mac") || osName.contains("darwin")) {
            return OperatingSystem.MACOS;
        } else if (osName.contains("nux")) {
            return OperatingSystem.LINUX;
        }
        return OperatingSystem.UNKNOWN;
    }

    /**
     * Método de ayuda para demostrar la creación de una GUI con una fábrica específica.
     * @param factory La fábrica a utilizar.
     * @param osName El nombre del SO para mostrar en la salida.
     */
    private static void demonstrateFactory(GUIFactory factory, String osName) {
        System.out.printf("\n--- Probando GUI de %s ---%n", osName);
        Application app = new Application(factory);
        app.paint();
    }

    public static void main(String[] args) {
        GUIFactory factory;
        OperatingSystem os = getCurrentOS();

        System.out.println("El sistema operativo detectado es: " + os);
        System.out.println("Configurando la aplicación para el SO actual...");

        // Determinar qué fábrica usar basado en el sistema operativo
        switch (os) {
            case WINDOWS:
                factory = new WindowsFactory();
                break;
            case MACOS:
                factory = new MacFactory();
                break;
            case LINUX:
            case UNKNOWN: // Por defecto, se usa Linux para SO desconocidos o similares a Unix
            default:
                factory = new LinuxFactory();
                break;
        }

        // Crear y ejecutar la aplicación con la fábrica correcta
        Application application = new Application(factory);
        application.paint();

        // Demostración explícita con cada fábrica para fines de prueba
        System.out.println("\n\n--- Demostración explícita con cada fábrica ---");
        demonstrateFactory(new WindowsFactory(), "Windows");
        demonstrateFactory(new MacFactory(), "macOS");
        demonstrateFactory(new LinuxFactory(), "Linux");
    }
}
