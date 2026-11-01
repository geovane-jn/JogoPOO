public class Armagedon extends Inimigo {

    public Armagedon() {
        super("Demonion", 500, 200, new Escudo(10) );
    }

	@Override
	public void fraseApresentacao() {
		System.out.println("Eu sou o terrível!");
	}

	@Override
	public void fraseMorte() {
		System.out.println("Eu vou me vingar!");
	}

    
}
