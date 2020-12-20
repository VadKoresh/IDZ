public class Processing {

    public static Character rezult(Character[][] life, int i, int j) {
        int count = 0;
        Character rezult = null;
        int bufferK = 0;
        int bufferL = 0;
        for (int k = i - 1; k <= i + 1; k++) {
            bufferK = k;
            if (bufferK < 0) {
                bufferK = life.length - 1;
            } else if (bufferK > life.length - 1) {
                bufferK = 0;
            }

            for (int l = j - 1; l <= j + 1; l++) {
                bufferL = l;
                if (bufferK == i && bufferL == j) {
                    continue;
                }
                if (bufferL < 0) {
                    bufferL = life.length - 1;
                } else if (bufferL > life.length - 1) {
                    bufferL = 0;
                }
                if (life[bufferK][bufferL].equals("X")) {
                    count++;
                }
            }
        }

        if ((life[i][j].equals("-") && count != 3) || (life[i][j].equals("X") && (count < 2 || count > 3))) {
            rezult = '-';
        } else if ((life[i][j].equals("X") && (count == 2 || count == 3)) || (life[i][j].equals("-") && count == 3)) {
            rezult = 'X';
        }
        return rezult;
    }

    public static void arrayCopy(Character[][] lifeAfter, Character[][] life) {
        for (int i = 0; i < lifeAfter.length; i++) {
            System.arraycopy(lifeAfter[i], 0, life[i], 0, lifeAfter[i].length);
        }
    }
}
