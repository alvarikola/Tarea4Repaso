package tarearepaso4;

public class TareaRepaso4 {

    public static void main(String[] args) {
        // Crear el fondo compartido con un límite de 2000
        FondoCompartido fondo = new FondoCompartido(2000);

        // Crear y lanzar hilos recolectores
        for (int i = 1; i <= 3; i++) { // Ajusta el número de recolectores
            new Thread(new Recolector(fondo, "Recolector-" + i)).start();
        }

        // Crear y lanzar hilos consumidores
        for (int i = 1; i <= 2; i++) { // Ajusta el número de consumidores
            new Thread(new Consumidor(fondo, "Consumidor-" + i)).start();
        }
    }
}
