package tarearepaso4;

import java.util.Random;

public class Consumidor implements Runnable {
    private final FondoCompartido fondo;
    private final String nombre;
    private final Random random = new Random();

    public Consumidor(FondoCompartido fondo, String nombre) {
        this.fondo = fondo;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        while (true) {
            int cantidad = 10 + random.nextInt(31); // Consumir entre 10 y 40
            try {
                Thread.sleep(20 + random.nextInt(281)); // Esperar entre 20 y 300 ms
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            fondo.consumir(cantidad, nombre);
        }
    }
}
