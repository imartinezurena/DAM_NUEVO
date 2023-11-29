package unidad2Hilos;

public class ClaseLift implements Runnable {
    private int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount;

    public ClaseLift() {
    }

    public ClaseLift(int countDown) {
        this.countDown = countDown;
    }

    @Override
    public void run() {
        while (countDown > 0) {
            System.out.println("#" + id + " (" + countDown + ")");
            countDown--;
        }
        System.out.println("Lanzamiento (" + id + ")");
    }

    public static void main(String[] args) {
        ClaseLift launch = new ClaseLift();
        launch.run();
        ClaseLift launch1 = new ClaseLift();
        launch1.run();
        ClaseLift launch2 = new ClaseLift();
        launch2.run();
        ClaseLift launch3 = new ClaseLift();
        launch3.run();
        System.out.println("Comienza la cuenta atrás!");
    }
}
