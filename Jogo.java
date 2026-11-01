public class Jogo {
    public static void main(String[] args){

        Arma[] armas = {
            new Faca(),
            new ArcoEFlecha(),
            new Porrete(),
            new Pistola()
        };

        Criatura jogador = new Jogador("Ludovica", armas);
        Criatura inimigo = new Demovilous();

        System.out.println("Começa a Batalha");
        System.out.println("################\n");
    
        jogador.fraseApresentacao();
        inimigo.fraseApresentacao();
        
        while(true){
            jogador.mostraVida();
            inimigo.mostraVida();

            jogador.fazAtaque(inimigo);
            if( inimigo.estaVivo() ){
                inimigo.fazAtaque(jogador);
            }

            if( !jogador.estaVivo() ){
                jogador.fraseMorte();
                System.out.println(inimigo.getNome() + " venceu.");
                break;
            }
            if( !inimigo.estaVivo() ){
                inimigo.fraseMorte();
                System.out.println(jogador.getNome() + " venceu.");
                break;
            }

            jogador.upgrade();
            inimigo.upgrade();
        }
    }
}