import java.util.Random;

public abstract class Arma {
    private String nome;
    private int ataque;
    private int chance;
    private boolean usaMunicao;
    private int municao;
    private int municaoInicial;

    public Arma(String nome, int ataque, int chance, int municao) {
        this.nome = nome;
        this.ataque = ataque;
        this.chance = chance;
        this.usaMunicao = true;
        this.municao = municao;
        this.municaoInicial = municao;
    }

    public Arma(String nome, int ataque, int chance) {
        this.nome = nome;
        this.ataque = ataque;
        this.chance = chance;
        this.usaMunicao = false;
    }

    public Arma(String nome, int ataque) {
        this.nome = nome;
        this.ataque = ataque;
        this.chance = 100;
        this.usaMunicao = false;
    }

    public void mensagem() {
        String textoMunicao = this.usaMunicao ? String.valueOf(this.municao) : "Infinita";
        System.out.println(this.nome + " - dano: " + this.ataque +
                " - chance: " + this.chance + "%" +
                " - munição: " + textoMunicao);
    }

    public boolean temMunicao() {
        return !this.usaMunicao || this.municao > 0;
    }

    public void restaurarMunicao() {
        if (this.usaMunicao) {
            this.municao = this.municaoInicial;
        }
    }

    public void aumentarAtaque(int bonus) {
        this.ataque += bonus;
    }

    public void fazAtaque(Criatura criatura) {
        if (this.usaMunicao) {
            if (this.municao <= 0) {
                System.out.println("Esta arma está sem munição!");
                return;
            }
            this.municao--;
        }

        Random rd = new Random();
        int sorteio = rd.nextInt(100);
        if (sorteio < this.chance) {
            criatura.tomaDano(this.ataque);
        } else {
            System.out.println("Errou!");
        }
    }
}