public class Main {
    public static void main(String[] args) {

        Jogo jogo = new Jogo();

        jogo.jogador.vida = 100;
        jogo.monstro.vida = 120;

        jogo.jogador.ataque = 15;
        jogo.monstro.ataque = 14;

        jogo.jogador.defesa = 12;

        jogo.jogador.cura = 15;
        jogo.jogador.verificaCura = 3;

        jogo.jogador.cliqueDefesa = false;
        jogo.jogador.sair = true;

        jogo.Principal();
    }
}
