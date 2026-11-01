import java.util.Scanner;
import java.util.Random;
public class Jogador extends Criatura {

    private Arma[] armas;

    public Jogador(String nome, Arma[] armas ) {
        super(nome, 1000);
        this.armas = armas;
    }

	@Override
	public void fazAtaque(Criatura criatura) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Escolha sua arma:");
        int n = 1;
        for( Arma arma : armas ){
            System.out.print( n + ") " );
            arma.mensagem();
            n++;
        }
        
        int escolha = sc.nextInt();
        while( escolha < 1 || escolha > n - 1 ) {
            System.out.print("Número inválido. Digite novamente: ");
            escolha = sc.nextInt();
        }
        
        armas[escolha-1].fazAtaque(criatura);

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
