import java.util.concurrent.Semaphore;

public class Main implements Runnable {
    // Se crea el objeto tipo Semaphore, y se le pone un límite de 4
    Semaphore cliente = new Semaphore(4);

    public static void main(String[] args)  {


        // Se crean los 10 hilos
        Main sb = new Main();
        for(int i=0; i<10; i++) {
            new Thread(sb).start();

        }

    }

    /**
     * Se crea el acquire y el release para decir donde irá el semáforo, dentro se coloca dos String
     * para saber cuando empieza y termina cada hilo.
     */
    @Override
    public void run() {

        try {
            cliente.acquire();
            System.out.println(Thread.currentThread().getName() + "Está siendo atendido");
            Thread.sleep((int) (Math.random()*10000));
            System.out.println(Thread.currentThread().getName() + "Ha terminado de ser atendido");
            cliente.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}