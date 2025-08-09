package com.felipe.jokenpo.meujogador;

import io.github.guisso.jankenpon.AbstractPlayer;
import io.github.guisso.jankenpon.Move;

public class MeuJogador
        extends AbstractPlayer {

    @Override
    public String getDeveloperName() {
        return "Felipe Madureira";
    }

    private int contagemGeralPedra = 0;
    private int contagemGeralPapel = 0;
    private int contagemGeralTesoura = 0;
    
    private Move encontrarMovimentoMaisFrequente() {
        if (contagemGeralPedra >= contagemGeralPapel && contagemGeralPedra >= contagemGeralTesoura) {
            return Move.ROCK;
        } else if (contagemGeralPapel >= contagemGeralPedra && contagemGeralPapel >= contagemGeralTesoura) {
            return Move.PAPER;
        } else {
            return Move.SCISSORS;
        }
    }
    
    @Override
    public Move makeMyMove(Move opponentPreviousMove) {

        if (opponentPreviousMove == Move.NONE) {
            return Move.ROCK;
        }
        
        switch (opponentPreviousMove) {
            case ROCK:
                contagemGeralPedra++;
                break;
            case PAPER:
                contagemGeralPapel++;
                break;
            case SCISSORS:
                contagemGeralTesoura++;
                break;
        }

        Move movimentoMaisFrequente = encontrarMovimentoMaisFrequente();

        switch (movimentoMaisFrequente) {
            case ROCK:
                return Move.PAPER;
            case PAPER:
                return Move.SCISSORS;
            case SCISSORS:
                return Move.ROCK;
            default:
                return Move.ROCK;
        }
    }
}
