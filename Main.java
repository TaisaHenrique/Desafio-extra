class Personagem {

    String nome;
    int vida;
    int ataque;

    public Personagem(String nome, int vida, int ataque) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void receberDano(int dano) {
        vida -= dano;

        if (vida < 0) {
            vida = 0;
        }
    }
}

class Batalha {

    Personagem personagem1;
    Personagem personagem2;
    int rodada;

    public Batalha(Personagem personagem1, Personagem personagem2) {
        this.personagem1 = personagem1;
        this.personagem2 = personagem2;
        this.rodada = 1;
    }

    public void iniciarBatalha() {

        while (personagem1.estaVivo() && personagem2.estaVivo()) {

            System.out.println("======== RODADA " + rodada + " ========");

            personagem2.receberDano(personagem1.ataque);

            System.out.println(personagem1.nome + " atacou "
                    + personagem2.nome
                    + " e causou "
                    + personagem1.ataque
                    + " pontos de dano.");

            System.out.println("Vida restante de "
                    + personagem2.nome
                    + ": "
                    + personagem2.vida);

            if (personagem2.estaVivo()) {

                personagem1.receberDano(personagem2.ataque);

                System.out.println(personagem2.nome + " atacou "
                        + personagem1.nome
                        + " e causou "
                        + personagem2.ataque
                        + " pontos de dano.");

                System.out.println("Vida restante de "
                        + personagem1.nome
                        + ": "
                        + personagem1.vida);
            }

            System.out.println();

            rodada++;
        }
    }
    
    public void exibirVencedor() {

        if (personagem1.estaVivo()) {
            System.out.println("🏆 O vencedor foi: " + personagem1.nome);
        }

        else if (personagem2.estaVivo()) {
            System.out.println("🏆 O vencedor foi: " + personagem2.nome);
        }

        else {
            System.out.println("⚔️ A batalha terminou em empate!");
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Personagem p1 = new Personagem("Leon", 120, 28);
        Personagem p2 = new Personagem("Drako", 95, 35);

        Batalha batalha = new Batalha(p1, p2);

        batalha.iniciarBatalha();

        batalha.exibirVencedor();
    }
}