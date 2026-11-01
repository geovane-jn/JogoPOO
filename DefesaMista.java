import java.util.Random;

public class DefesaMista extends Defesa {
    private int chanceEsquiva;
    private int reducao;

    public DefesaMista(int chanceEsquiva, int reducao) {
        if (chanceEsquiva < 0) chanceEsquiva = 0;
        if (chanceEsquiva > 100) chanceEsquiva = 100;
        this.chanceEsquiva = chanceEsquiva;

        if (reducao < 0) reducao = 0;
        this.reducao = reducao;
    }

    @Override
    public int danoReduzido(int dano) {
        Random rd = new Random();
        int sorteio = rd.nextInt(100);
        if (sorteio < this.chanceEsquiva) {
            System.out.println("Esquivou com a Defesa Mista!!");
            return 0;
        }
        System.out.println("Bloqueou " + this.reducao + " de dano com a Defesa Mista!");
        if (dano < this.reducao) {
            return 0;
        }
        return dano - this.reducao;
    }
}