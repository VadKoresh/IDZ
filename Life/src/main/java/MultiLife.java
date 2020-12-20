public class MultiLife {

    private int countProccessor;
    private int countCycle;
    private Character[][] life;
    private Character[][] lifeAfter;

    public MultiLife(Character[][] life, int countCycle) {
        this.life = life;
        this.countCycle = countCycle;
        lifeAfter = new Character[life.length][life.length];
    }

    public void startMulti() throws InterruptedException {

        countProccessor = Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[countProccessor];

        Task4Thread task = new Task4Thread(life, lifeAfter, countProccessor);
        for (int cycle = 0; cycle < countCycle; cycle++) {
            for (int i = 0; i < threads.length; i++) {
                threads[i] = new Thread(task, String.valueOf(i));
                threads[i].start();
            }

            for (int i = 0; i < threads.length; i++) {
                threads[i].join();
            }

            Processing.arrayCopy(lifeAfter, life);

        }
    }
}
