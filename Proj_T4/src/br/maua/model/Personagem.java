package br.maua.model;

import br.maua.enums.Profissoes;
import br.maua.enums.Racas;

public class Personagem {
    private String nome;
    private String raca;
    private String prof;
    private int mana, atq, atqMag, def, defMag, vel, destreza, exp, nivel;

    public Personagem(String nome, Racas raca, Profissoes prof, int mana, int atq, int atqMag, int def, int defMag, int vel, int destreza, int exp, int nivel) {
        this.nome = nome;
        this.raca = raca.toString();
        this.prof = prof.toString();
        this.mana = mana;
        this.atq = atq;
        this.atqMag = atqMag;
        this.def = def;
        this.defMag = defMag;
        this.vel = vel;
        this.destreza = destreza;
        this.exp = exp;
        this.nivel = nivel;
    }
    public Personagem(String nome, String raca, String prof, int mana, int atq, int atqMag, int def, int defMag,
                      int vel, int destreza, int exp, int nivel) {
        this.nome = nome;
        this.raca = raca;
        this.prof = prof;
        this.mana = mana;
        this.atq = atq;
        this.atqMag = atqMag;
        this.def = def;
        this.defMag = defMag;
        this.vel = vel;
        this.destreza = destreza;
        this.exp = exp;
        this.nivel = nivel;
    }


    public String getNome() {
        return nome;
    }
    public String getRaca() {
        return raca;
    }
    public String getProf() {
        return prof;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setAtq(int atq) {
        this.atq = atq;
    }

    public void setAtqMag(int atqMag) {
        this.atqMag = atqMag;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setDefMag(int defMag) {
        this.defMag = defMag;
    }

    public void setVel(int vel) {
        this.vel = vel;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
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



    @Override
    public String toString() {
        return '\n'+"Personagem:" +'\n' +
                '\t'+"Nome = " + nome + '\n' +
                '\t'+"Raca = " + raca +'\n'+
                '\t'+"Profissao = " + prof +'\n' +
                '\t'+"Mana = " + mana +'\n' +
                '\t'+"Ataque = " + atq +'\n' +
                '\t'+"Ataque Magico = " + atqMag +'\n' +
                '\t'+"Defesa = " + def +'\n' +
                '\t'+"Defesa Magica = " + defMag +'\n' +
                '\t'+"Velocidade = " + vel +'\n' +
                '\t'+"Destreza = "+destreza +'\n' +
                '\t'+"Experiencia = " + exp +'\n' +
                '\t'+"Nivel = " + nivel +'\n';
    }
}
