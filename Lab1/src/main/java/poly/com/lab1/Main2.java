package poly.com.lab1;

class Task implements Runnable {
    private String name;

    Task(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(name + " - bước " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
}

public class Main2 {
    public static void main(String[] args) {
        new Thread(new Task("A")).start();
        new Thread(new Task("B")).start();
    }
}

