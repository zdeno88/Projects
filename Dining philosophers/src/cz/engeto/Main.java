package cz.engeto;

public class Main {

    public static void main(String[] args) {
        ChopStick[] chopStick = new ChopStick[10];
        for (int i = 0; i < chopStick.length; i++) {
            chopStick[i] = new ChopStick(i);
        }
        Philosopher[] philosopher = new Philosopher[10];
        for (int i = 0; i < philosopher.length; i++) {
            if (i < philosopher.length - 1) {
                philosopher[i] = new Philosopher(i, chopStick[i], chopStick[i + 1]);
                Thread thread = new Thread(philosopher[i]);
                thread.setName(String.valueOf(i));
                thread.start();
            } else {
                philosopher[i] = new Philosopher(i, chopStick[0], chopStick[i]);
                Thread thread = new Thread(philosopher[i]);
                thread.setName(String.valueOf(i));
                thread.start();
            }
        }

    }
}
