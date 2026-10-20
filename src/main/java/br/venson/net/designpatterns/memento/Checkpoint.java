package br.venson.net.designpatterns.memento;

/**
 * Interface estreita (Narrow Interface) do padrão Memento.
 * 
 * O Caretaker (GerenciadorSave) enxerga apenas esta interface marcadora,
 * não tendo acesso a nenhum detalhe de implementação nem aos atributos internos do estado.
 */
public interface Checkpoint {
}
