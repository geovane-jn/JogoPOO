public class Demovilous extends Inimigo {

    public Demovilous() {
        super("Malignus", 800, 60);
    }

	@Override
	public void fraseApresentacao() {
        System.out.println("Você é um fracassado...  HAHAHA");
	}

	@Override
	public void fraseMorte() {
        System.out.println("EU VOLTAREEEEEEEEI...");
	}


	//Upgrade
	private boolean upgraded = false;
	private int vidaCritica = 200;
	@Override
	public void upgrade(){
		if( !upgraded ){
			if( vidaCritica(vidaCritica) ){
				System.out.println(getNome() + " está turbinado!");
				upgraded = true;
				setDefesa(new Escudo(40));
				setAtaque(200);
			}
		}
	}
    
}
