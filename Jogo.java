import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome do jogador: ");
        String nomeJogador = sc.nextLine();

        System.out.println("\nEscolha uma arma de curta distância:");
        System.out.println("1) Faca (dano: 50 - chance: 100%)");
        System.out.println("2) Espada (dano: 80 - chance: 85%)");
        System.out.println("3) Porrete (dano: 60 - chance: 90%)");
        int escCurta = sc.nextInt();
        while (escCurta < 1 || escCurta > 3) {
            System.out.print("Opção inválida. Digite novamente: ");
            escCurta = sc.nextInt();
        }
        Arma armaCurta;
        if (escCurta == 1) {
            armaCurta = new Faca();
        } else if (escCurta == 2) {
            armaCurta = new Espada();
        } else {
            armaCurta = new Porrete();
        }

        System.out.println("\nEscolha uma arma de longa distância:");
        System.out.println("1) Arco e flecha (dano: 200 - chance: 60% - munição: 5)");
        System.out.println("2) Pistola (dano: 150 - chance: 80% - munição: 4)");
        int escLonga = sc.nextInt();
        while (escLonga < 1 || escLonga > 2) {
            System.out.print("Opção inválida. Digite novamente: ");
            escLonga = sc.nextInt();
        }
        Arma armaLonga = (escLonga == 1) ? new ArcoEFlecha() : new Pistola();

        Arma[] armasEscolhidas = { armaCurta, armaLonga };
        Jogador jogador = new Jogador(nomeJogador, armasEscolhidas);

        Criatura[] inimigos = {
                new Demovilous(),
                new Armagedon(),
                new Necromante()
        };

        String[] resultados = new String[inimigos.length];
        int batalhasRealizadas = 0;

        for (int i = 0; i < inimigos.length; i++) {
            if (i == 2) {
                jogador.receberUpgradeFinal();
            }

            Batalha batalha = new Batalha(jogador, inimigos[i]);
            boolean venceu = batalha.executar();
            batalhasRealizadas++;

            if (venceu) {
                resultados[i] = "Batalha " + (i + 1) + " (" + jogador.getNome() + " vs " + inimigos[i].getNome() + "): Vitória de " + jogador.getNome();
                jogador.restaurarJogador();
            } else {
                resultados[i] = "Batalha " + (i + 1) + " (" + jogador.getNome() + " vs " + inimigos[i].getNome() + "): Derrota (" + inimigos[i].getNome() + " venceu)";
                break;
            }
        }

        System.out.println("\n=== RESULTADO DAS BATALHAS ===");
        for (int i = 0; i < batalhasRealizadas; i++) {
            System.out.println(resultados[i]);
        }
    }
}