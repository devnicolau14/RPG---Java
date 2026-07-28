import java.util.Random;
import java.util.Scanner;

public class Jogo {
    Personagem monstro = new Personagem();
    Personagem jogador = new Personagem();
    Scanner s = new Scanner(System.in);

    public void Atacar() {
        System.out.println("==========================");

        int danoJog = jogador.ataque;
        monstro.vida -= danoJog;

        if (monstro.vida < 0) {
            monstro.vida = 0;
        }

        System.out.println("O Monstro recebeu " + danoJog + " de dano");
        System.out.println("A vida do Monstro é " + monstro.vida + "HP!\n");

        VerificarVitoria();

        int danoMon = monstro.ataque;

        if (jogador.cliqueDefesa == true) {
            danoMon = monstro.ataque - jogador.defesa;
        } else if (monstro.vida > 0) {
            jogador.vida -= danoMon;

            System.out.println("O Jogador recebeu " + danoMon + " de dano");
            System.out.println("A vida do Jogador é " + jogador.vida + "HP!\n");
        }

        VerificarVitoria();
        System.out.println("==========================\n");
    }

    public void Defender() {
        System.out.println("==========================");

        jogador.cliqueDefesa = true;

        int danoMon = monstro.ataque;

        if (jogador.cliqueDefesa == true) {
            danoMon = monstro.ataque - jogador.defesa;
        }

        if (monstro.vida > 0) {
            jogador.vida -= danoMon;

            System.out.println("O Jogador recebeu " + danoMon + " de dano");
            System.out.println("A vida do Jogador é " + jogador.vida + "HP!\n");
        }

        VerificarVitoria();

        jogador.cliqueDefesa = false;

        System.out.println("==========================\n");
    }

    public void VerificarVitoria() {
        if (jogador.vida <= 0) {
            System.out.println("=-=-= GAME OVER =-=-=\n");
            jogador.sair = false;
        } else if (monstro.vida <= 0) {
            System.out.println("===== VICTORY =====\n");
            jogador.sair = false;
        }
    }

    public void Curar() {
        System.out.println("==========================");

        if (jogador.verificaCura > 0 && jogador.vida <= 85) {

            jogador.vida += jogador.cura;
            jogador.verificaCura--;

            System.out.println("Sua vida agora é " + jogador.vida + "HP!");
            System.out.println("Você ainda tem " + jogador.verificaCura + " curas disponíveis!");

            int danoMon = monstro.ataque;

            if (jogador.cliqueDefesa == true) {
                danoMon = monstro.ataque - jogador.defesa;
            }

            if (monstro.vida > 0) {
                jogador.vida -= danoMon;

                System.out.println("O Jogador recebeu " + danoMon + " de dano");
                System.out.println("A vida do Jogador é " + jogador.vida + "HP!\n");
            }

        } else if (jogador.vida > 85) {
            System.out.println("Sua vida está muito cheia, é impossível se curar!\n");
        } else if (jogador.verificaCura <= 0) {
            System.out.println("Você não tem mais curas disponíveis!\n");
        }

        VerificarVitoria();
        System.out.println("==========================\n");
    }

    public void MostrarStatus() {
        System.out.println("====== STATUS DO RPG ======\n");
        System.out.println("Vida do Monstro: " + monstro.vida + "HP");
        System.out.println("Vida do Jogador: " + jogador.vida + "HP\n");

        System.out.println("Curas restantes: " + jogador.verificaCura);
        System.out.println("Ataque do Jogador: " + jogador.ataque);
        System.out.println("Ataque do Monstro: " + monstro.ataque);
        System.out.println("Cura do Jogador: " + jogador.cura);

        System.out.println("===========================\n");
    }

    public void Principal() {

        Random r = new Random();

        while (jogador.sair) {

            try {

                jogador.ataque = r.nextInt(11) + 10;
                monstro.ataque = r.nextInt(6) + 10;

                System.out.println("==========================");
                System.out.println("\tBATALHA DE RPG");
                System.out.println("==========================\n");

                System.out.println("Escolha uma opção:\n");
                System.out.println("1 - Atacar");
                System.out.println("2 - Defender");
                System.out.println("3 - Curar");
                System.out.println("4 - Mostrar Status");
                System.out.println("0 - Desistir\n");

                int opcao = s.nextInt();
                s.nextLine();

                switch (opcao) {

                    case 1:
                        Atacar();
                        break;

                    case 2:
                        Defender();
                        break;

                    case 3:
                        Curar();
                        break;

                    case 4:
                        MostrarStatus();
                        break;

                    case 0:
                        System.out.println("Você desistiu do jogo!");
                        System.out.println("=-=-= GAME OVER =-=-=\n");
                        jogador.sair = false;
                        break;

                    default:
                        System.out.println("Opção inválida! Por favor tente novamente.");
                        break;
                }

            } catch (Exception e) {
                s.nextLine();
                System.out.println("Opção inválida! Por favor tente novamente.");
            }
        }
    }
}