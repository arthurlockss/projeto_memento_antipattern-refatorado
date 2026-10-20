package br.venson.net.designpatterns.memento;

public class Main {

    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        GerenciadorSave save = new GerenciadorSave();

        // 1. Jogador joga na Fase 1
        jogo.jogar("Fase 1", 3, 100, 10.0, 20.0);

        // 2. Cria checkpoint e entrega ao Caretaker
        save.salvar(jogo.salvar());
        System.out.println("Apos salvar:      " + jogo);

        // 3. Jogador avança para a Fase 2 (estado muda)
        jogo.jogar("Fase 2", 1, 450, 80.0, 15.0);
        System.out.println("Depois de jogar:  " + jogo);

        // 4. Jogador recupera o checkpoint salvo anteriormente
        Checkpoint checkpoint = save.restaurar();
        if (checkpoint != null) {
            jogo.restaurar(checkpoint);
        }
        System.out.println("Apos restaurar:   " + jogo);
    }
}
