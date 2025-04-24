package ch14.exam;

public class ThreadExample {
    public static void main(String[] args) {
        MovieThread mt = new MovieThread();
        MusicRunnable mr = new MusicRunnable();

        mr.thread.start();
        mt.thread.start();
    }
}
