package tarearepaso4;

public class FondoCompartido {
    private int fondoActual;
    private final int limiteMaximo;

    public FondoCompartido(int limiteMaximo) {
        this.fondoActual = 0;
        this.limiteMaximo = limiteMaximo;
    }

    // Método sincronizado para recolectar dinero
    public synchronized void recolectar(int cantidad, String nombreRecolector) {
        while (fondoActual + cantidad > limiteMaximo) {
            try {
                System.out.printf("%s espera, el fondo actual (%d) + cantidad (%d) excede el límite (%d).\n",
                        nombreRecolector, fondoActual, cantidad, limiteMaximo);
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        fondoActual += cantidad;
        System.out.printf("%s recolectó %d. Fondo actual: %d.\n", nombreRecolector, cantidad, fondoActual);
        notifyAll(); // Notificar a los consumidores
    }

    // Método sincronizado para consumir dinero
    public synchronized void consumir(int cantidad, String nombreConsumidor) {
        while (fondoActual < cantidad) {
            try {
                System.out.printf("%s espera, el fondo actual (%d) es menor que la cantidad necesaria (%d).\n",
                        nombreConsumidor, fondoActual, cantidad);
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        fondoActual -= cantidad;
        System.out.printf("%s retiró %d. Fondo actual: %d.\n", nombreConsumidor, cantidad, fondoActual);
        notifyAll(); // Notificar a los recolectores
    }
}
