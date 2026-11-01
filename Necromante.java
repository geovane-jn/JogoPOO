import java.util.Random;

public class Necromante extends Inimigo {
    public Necromante() {
        super("Necromante", 900, 180, new Escudo(5));
    }

    @Override
    public void fraseApresentacao() {
        System.out.println("As sombras vão consumir a sua alma!");
    }

    @Override
    public void fraseMorte() {
        System.out.println("A escuridão... nunca morre...");
    }

    @Override
    public void fazAtaque(Criatura criatura) {
        Random rd = new Random();
        int sorteio = rd.nextInt(100);

        if (sorteio < 20) {
            System.out.println(getNome() + " tentou conjurar uma magia sombria, mas falhou e não atacou!");
        } else if (sorteio < 50) {
            int danoCritico = getAtaque() + 100;
            System.out.println(getNome() + " lançou uma Explosão Necrótica CRÍTICA!");
            criatura.tomaDano(danoCritico);
        } else {
            System.out.println(getNome() + " atacou com o seu cajado!");
            criatura.tomaDano(getAtaque());
        }
    }
}