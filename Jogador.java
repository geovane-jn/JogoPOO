import java.util.Scanner;

public class Jogador extends Criatura {
    private Arma[] armas;

    public Jogador(String nome, Arma[] armas) {
        super(nome, 1000);
        this.armas = armas;
    }

    @Override
    public void fazAtaque(Criatura criatura) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha sua arma:");
            int n = 1;
            for (Arma arma : armas) {
                System.out.print(n + ") ");
                arma.mensagem();
                n++;
            }

            int escolha = sc.nextInt();
            while (escolha < 1 || escolha > n - 1) {
                System.out.print("Número inválido. Digite novamente: ");
                escolha = sc.nextInt();
            }

            Arma armaEscolhida = armas[escolha - 1];
            if (!armaEscolhida.temMunicao()) {
                System.out.println("A arma escolhida não tem mais munição! Escolha outra.");
            } else {
                armaEscolhida.fazAtaque(criatura);
                break;
            }
        }
    }

    public void restaurarJogador() {
        this.restaurarVida();
        for (Arma arma : armas) {
            arma.restaurarMunicao();
        }
    }

    public void receberUpgradeFinal() {
        System.out.println("\n*** UPGRADE ANTES DA BATALHA FINAL! ***");
        this.setVidaInicial(this.getVidaInicial() + 300);
        for (Arma arma : armas) {
            arma.aumentarAtaque(50);
        }
        System.out.println(getNome() + " recebeu +300 de vida máxima e +50 de dano em todas as armas!\n");
    }

    @Override
    public void fraseApresentacao() {
        System.out.println("Não contava com minha astúcia!");
    }

    @Override
    public void fraseMorte() {
        System.out.println("pipipipipipipipi");
    }
}