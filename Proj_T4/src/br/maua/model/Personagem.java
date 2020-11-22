package br.maua.model;

import br.maua.enums.Profissoes;
import br.maua.enums.Racas;

public class Personagem {
    private String nome, urlFoto;
    private int mana, atq, atqMag, def, defMag, vel, destreza, exp, nivel;
    private Profissoes prof;
    private Racas raca;

    public String getNome() {
        return nome;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public int getMana() {
        return mana;
    }

    public int getAtq() {
        return atq;
    }

    public int getAtqMag() {
        return atqMag;
    }

    public int getDef() {
        return def;
    }

    public int getDefMag() {
        return defMag;
    }

    public int getVel() {
        return vel;
    }

    public int getDestreza() {
        return destreza;
    }

    public int getExp() {
        return exp;
    }

    public int getNivel() {
        return nivel;
    }

    public Profissoes getProf() {
        return prof;
    }

    public Racas getRaca() {
        return raca;
    }

    @Override
    public String toString() {
        return '\n' +"Personagem:" +'\n' +
                "Nome = " + nome + '\n' +
                "Raca = " + raca +'\n'+
                "Profissao = " + prof +'\n' +
                "Mana = " + mana +'\n' +
                "Ataque = " + atq +'\n' +
                "Ataquq Magico = " + atqMag +'\n' +
                "Defesa = " + def +'\n' +
                "Defesa Magica = " + defMag +'\n' +
                "Velocidade = " + vel +'\n' +
                "Destreza = "+destreza +'\n' +
                "Experiencia = " + exp +'\n' +
                "Nivel = " + nivel +'\n'+
                '\n';
    }
}
