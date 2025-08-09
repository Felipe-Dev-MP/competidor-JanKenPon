package com.felipe.jokenpo.meujogador;

import io.github.guisso.jankenpon.AbstractPlayer;
import io.github.guisso.jankenpon.Move;

public class MeuJogador
        extends AbstractPlayer{

    @Override
    public String getDeveloperName(){
        return "Felipe Madureira";
    }

    private Move minhaUltimaJogada = null;
    
    private Move getJogadaVencedora(Move jogada){
        switch (jogada) {
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
    
    @Override
    public Move makeMyMove(Move opponentPreviousMove){

        if (opponentPreviousMove == Move.NONE){
            this.minhaUltimaJogada = Move.SCISSORS;
            return this.minhaUltimaJogada;
        }

        boolean euVenci = (getJogadaVencedora(opponentPreviousMove) == minhaUltimaJogada);
        boolean empate = (minhaUltimaJogada == opponentPreviousMove);

        Move minhaProximaJogada;

        if(euVenci){
            Move contraAtaqueEsperado = getJogadaVencedora(minhaUltimaJogada);
            minhaProximaJogada = getJogadaVencedora(contraAtaqueEsperado);

        }else if(empate){
            minhaProximaJogada = getJogadaVencedora(opponentPreviousMove);

        }else{
            minhaProximaJogada = getJogadaVencedora(opponentPreviousMove);
        }

        this.minhaUltimaJogada = minhaProximaJogada;
        return this.minhaUltimaJogada;
    }
}
