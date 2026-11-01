public class Demovilous extends Inimigo {
    private boolean upgraded = false;
    private int vidaCritica = 200;

    public Demovilous() {
        super("Demovilous", 800, 60, new Esquiva(20));
    }

    @Override
    public void fraseApresentacao() {
        System.out.println("Você é um fracassado... HAHAHA");
    }

    @Override
    public void fraseMorte() {
        System.out.println("NUNCA É UM FIM...");
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            if (vidaCritica(vidaCritica)) {
                System.out.println(getNome() + " está turbinado!");
                upgraded = true;
                setDefesa(new Escudo(30));
                setAtaque(200);
            }
        }
    }
}