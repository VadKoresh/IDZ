public class OneLife {

    private Character[][] life;
    private int countCycle;

    public OneLife(Character[][] lifeTo, int countCycle) {
        this.life = lifeTo;
        this.countCycle = countCycle;
    }

    public void lifeBegin() {
        Character[][] lifeAfter = new Character[life.length][life.length];

        for (int cycle = 0; cycle < countCycle; cycle++) {

            for (int i = 0; i < life.length; i++) {
                for (int j = 0; j < life[i].length; j++) {
                    lifeAfter[i][j] = Processing.rezult(life, i, j);
                }
            }

            Processing.arrayCopy(lifeAfter, life);
        }
    }
}
