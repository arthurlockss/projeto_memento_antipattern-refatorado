package br.venson.net.designpatterns.memento;

/**
 * Originator no padrão Memento.
 * 
 * É responsável por manter o estado do jogo, criar snapshots imutáveis (salvar)
 * e restaurar seu estado interno a partir de um Checkpoint (restaurar).
 */
public class Jogo {

    private String fase;
    private int vidas;
    private int pontuacao;
    private double x;
    private double y;

    public void jogar(String fase, int vidas, int pontuacao, double x, double y) {
        this.fase = fase;
        this.vidas = vidas;
        this.pontuacao = pontuacao;
        this.x = x;
        this.y = y;
    }

    /**
     * Cria um snapshot imutável do estado atual do jogo.
     * Retorna a interface estreita Checkpoint para quem estiver chamando.
     */
    public Checkpoint salvar() {
        return new JogoCheckpoint(fase, vidas, pontuacao, x, y);
    }

    /**
     * Restaura o estado interno a partir de um Checkpoint.
     * Apenas o Originator conhece a estrutura concreta JogoCheckpoint (Interface Ampla).
     */
    public void restaurar(Checkpoint checkpoint) {
        if (!(checkpoint instanceof JogoCheckpoint memento)) {
            throw new IllegalArgumentException("Checkpoint inválido ou incompatível.");
        }
        this.fase = memento.fase();
        this.vidas = memento.vidas();
        this.pontuacao = memento.pontuacao();
        this.x = memento.x();
        this.y = memento.y();
    }

    /**
     * Implementação concreta do Memento (Wide Interface).
     * Sendo um record privado interno, garante imutabilidade por design (Java 17+)
     * e impede qualquer classe externa de inspecionar ou alterar os dados salvos.
     */
    private record JogoCheckpoint(
            String fase,
            int vidas,
            int pontuacao,
            double x,
            double y
    ) implements Checkpoint {
    }

    // Getters mantidos apenas para leitura/consulta externa de estado (ex.: interface gráfica, HUD)
    // Sem nenhum setter exposto, preservando totalmente o encapsulamento.

    public String getFase() {
        return fase;
    }

    public int getVidas() {
        return vidas;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Jogo{fase=" + fase + ", vidas=" + vidas + ", pontuacao=" + pontuacao
                + ", x=" + x + ", y=" + y + "}";
    }
}
