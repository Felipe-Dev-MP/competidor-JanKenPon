package com.felipe.jokenpo.meujogador;

import io.github.guisso.jankenpon.AbstractPlayer;
import io.github.guisso.jankenpon.Move;
import java.util.Random;

public class MeuJogador
        extends AbstractPlayer{

    @Override
    public String getDeveloperName(){
        return "Felipe Madureira";
    }

    private Move minhaUltimaJogada = null;
    private final Random random = new Random();
    
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
            this.minhaUltimaJogada = Move.ROCK;
            return this.minhaUltimaJogada;
        }

        boolean euVenci = (getJogadaVencedora(opponentPreviousMove) == minhaUltimaJogada);
        boolean empate = (minhaUltimaJogada == opponentPreviousMove);

        Move minhaProximaJogada;

        if(euVenci){
           if (random.nextInt(100) < 80){ 
                Move contraAtaqueEsperado = getJogadaVencedora(minhaUltimaJogada);
                minhaProximaJogada = getJogadaVencedora(contraAtaqueEsperado);
            } else {
                minhaProximaJogada = getJogadaVencedora(minhaUltimaJogada);
            }

        }else if(empate){
            if (random.nextInt(100) < 75){
                minhaProximaJogada = getJogadaVencedora(opponentPreviousMove);
            }else{
                minhaProximaJogada = opponentPreviousMove;
            }

        }else{
            minhaProximaJogada = getJogadaVencedora(opponentPreviousMove);
        }

        this.minhaUltimaJogada = minhaProximaJogada;
        return this.minhaUltimaJogada;
    }
}
