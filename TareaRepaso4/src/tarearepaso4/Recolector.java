package tarearepaso4;

import java.util.Random;

public class Recolector implements Runnable{
    private final FondoCompartido fondo;
    private final String nombre;
    private final Random random = new Random();

    public Recolector(FondoCompartido fondo, String nombre) {
        this.fondo = fondo;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        while (true) {
            int cantidad = 10 + random.nextInt(91); // Recolectar entre 10 y 100
            try {
                Thread.sleep(100 + random.nextInt(400)); // Esperar entre 100 y 500 ms
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            fondo.recolectar(cantidad, nombre);
        }
    }
}
