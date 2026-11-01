public class Armagedon extends Inimigo {
    public Armagedon() {
        super("Armagedon", 600, 150, new DefesaMista(10, 20));
    }

    @Override
    public void fraseApresentacao() {
        System.out.println("Eu sou o maioral...");
    }

    @Override
    public void fraseMorte() {
        System.out.println("Eu voltarei...");
    }
}