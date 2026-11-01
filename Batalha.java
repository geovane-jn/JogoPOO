public class Batalha {
    private Criatura jogador;
    private Criatura inimigo;

    public Batalha(Criatura jogador, Criatura inimigo) {
        this.jogador = jogador;
        this.inimigo = inimigo;
    }

    public boolean executar() {
        System.out.println("\nComeça a Batalha contra " + inimigo.getNome());
        System.out.println("################\n");

        jogador.fraseApresentacao();
        inimigo.fraseApresentacao();

        while (true) {
            jogador.mostraVida();
            inimigo.mostraVida();

            jogador.fazAtaque(inimigo);

            if (inimigo.estaVivo()) {
                inimigo.fazAtaque(jogador);
            }

            if (!jogador.estaVivo()) {
                jogador.fraseMorte();
                System.out.println(inimigo.getNome() + " venceu.");
                return false;
            }

            if (!inimigo.estaVivo()) {
                inimigo.fraseMorte();
                System.out.println(jogador.getNome() + " venceu.");
                return true;
            }

            jogador.upgrade();
            inimigo.upgrade();
        }
    }
}