package br.venson.net.designpatterns.memento;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Caretaker no padrão Memento.
 * 
 * É responsável por armazenar o histórico de checkpoints (snapshots)
 * sem conhecer o conteúdo interno ou os atributos armazenados (Interface Estreita).
 */
public class GerenciadorSave {

    private final Deque<Checkpoint> checkpoints = new ArrayDeque<>();

    public void salvar(Checkpoint checkpoint) {
        if (checkpoint != null) {
            checkpoints.push(checkpoint);
        }
    }

    public Checkpoint restaurar() {
        if (checkpoints.isEmpty()) {
            System.out.println("Nenhum checkpoint salvo.");
            return null;
        }
        return checkpoints.pop();
    }
}
