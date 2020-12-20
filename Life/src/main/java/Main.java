import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        String pathIn = args[0];
        String pathOut = args[1];
        int cycle = Integer.parseInt(args[2]);

        Character[][] life = ReadFile.readFile("src/main/resources/" + pathIn);
        //===========================================================================================

       long start = System.currentTimeMillis();
        OneLife oneLife = new OneLife(life,cycle);
        oneLife.lifeBegin();
        long finish = System.currentTimeMillis();
        System.out.println("Однопоточка равна = " + (finish - start));

        long startTo = System.currentTimeMillis();
        MultiLife startMulty = new MultiLife(life, cycle);
        startMulty.startMulti();
        long finishTo = System.currentTimeMillis();
        System.out.println("Многопоточка равна = " + (finishTo - startTo));

        WriteFile.writeFile("src/main/resources/" + pathOut, life);

    }
}
