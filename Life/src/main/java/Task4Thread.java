public class Task4Thread implements Runnable{
    private Character[][] life;
    private Character[][] lifeAfter;
    private int countThreads;

    public Task4Thread(Character[][] lifeto, Character [][] lifeAfter, int countThreads) {
        this.life = lifeto;
        this.countThreads = countThreads;
        this.lifeAfter = lifeAfter;
    }

    @Override
    public void run() {
        int numberThread = Integer.parseInt(Thread.currentThread().getName());

        for (int i = numberThread; i < life.length; i += countThreads) {
            for (int j = 0; j < life[i].length; j++) {
                lifeAfter[i][j] = Processing.rezult(life, i, j);
            }
        }
    }
}


