package br.maua.model;

import br.maua.enums.Profissoes;
import br.maua.enums.Racas;
/**
 * Classe do modelo de personagem <br>
 * Inclui somente construtor, getters, setters e toString
 * @author Andre Lebrao 18.00356-7
 * @author Joao Guilherme Jatoba 18.01790-8
 * @since 24/11/2020
 */
public class Personagem {
    private String nome;
    private String raca;
    private String prof;
    private int mana, atq, atqMag, def, defMag, vel, destreza, exp, nivel;

    /**
     * Metodo construtor da classe Personagem (Usa raca e Profissao como enums)
     * @param nome String Nome do personagem
     * @param raca enum tipo RACA: Raca do personagem
     * @param prof enum tipo PROFISSAO: Profissao do personagem
     * @param mana int Atributo do personagem: Mana
     * @param atq int Atributo do personagem: Ataque
     * @param atqMag int Atributo do personagem: Ataque Magico
     * @param def int Atributo do personagem: Defesa
     * @param defMag int Atributo do personagem: Defesa Magica
     * @param vel int Atributo do personagem: Velocidade
     * @param destreza int Atributo do personagem: Destreza
     * @param exp intExperiencia do personagem
     * @param nivel int Nivel do personagem
     */
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

    /**
     * Metodo construtor da classe Personagem (Usa raca e Profissao como strings)
     * @param nome String Nome do personagem
     * @param raca String Raca do personagem
     * @param prof String Profissao do personagem
     * @param mana int Atributo do personagem: Mana
     * @param atq int Atributo do personagem: Ataque
     * @param atqMag int Atributo do personagem: Ataque Magico
     * @param def int Atributo do personagem: Defesa
     * @param defMag int Atributo do personagem: Defesa Magica
     * @param vel int Atributo do personagem: Velocidade
     * @param destreza int Atributo do personagem: Destreza
     * @param exp intExperiencia do personagem
     * @param nivel int Nivel do personagem
     */
    public Personagem(String nome, String raca, String prof, int mana, int atq, int atqMag, int def, int defMag, int vel, int destreza, int exp, int nivel) {
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

    /**
     *
     * @return Nome do personagem
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return Raca do personagem
     */
    public String getRaca() {
        return raca;
    }

    /**
     *
     * @return Profissao do personagem
     */
    public String getProf() {
        return prof;
    }

    /**
     *
     * @return mana do personagem
     */
    public int getMana() {
        return mana;
    }

    /**
     *
     * @return Ataque do personagem
     */
    public int getAtq() {
        return atq;
    }
    /**
     *
     * @return Ataque Magico do personagem
     */
    public int getAtqMag() {
        return atqMag;
    }
    /**
     *
     * @return Defesa do personagem
     */
    public int getDef() {
        return def;
    }
    /**
     *
     * @return Defesa Magica do personagem
     */
    public int getDefMag() {
        return defMag;
    }
    /**
     *
     * @return Velocidade do personagem
     */
    public int getVel() {
        return vel;
    }
    /**
     *
     * @return Destreza do personagem
     */
    public int getDestreza() {
        return destreza;
    }
    /**
     *
     * @return Experiencia do personagem
     */
    public int getExp() {
        return exp;
    }
    /**
     *
     * @return Nivel do personagem
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Determina o nome do personagem
     * @param nome Novo nome do personagem
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Determina a raca do personagem
     * @param raca Nova raca do personagem
     */
    public void setRaca(String raca) {
        this.raca = raca;
    }

    /**
     * Determina a profissao do personagem
     * @param prof Nova profissao do personagem
     */
    public void setProf(String prof) {
        this.prof = prof;
    }

    /**
     * Determina mana do personagem
     * @param mana Novo mana do personagem
     */
    public void setMana(int mana) {
        this.mana = mana;
    }

    /**
     * Determina o ataque do personagem
     * @param atq Novo ataque do personagem
     */
    public void setAtq(int atq) {
        this.atq = atq;
    }

    /**
     * Determina o ataque magico do personagem
     * @param atqMag Novo ataque magico do personagem
     */
    public void setAtqMag(int atqMag) {
        this.atqMag = atqMag;
    }

    /**
     * Determina a defesa do personagem
     * @param def Nova defesa do personagem
     */
    public void setDef(int def) {
        this.def = def;
    }

    /**
     * Determina a defesa magica do personagem
     * @param defMag Novo defesa magica do personagem
     */
    public void setDefMag(int defMag) {
        this.defMag = defMag;
    }

    /**
     * Determina a velocidade do personagem
     * @param vel Nova velocidade do personagem
     */
    public void setVel(int vel) {
        this.vel = vel;
    }

    /**
     * Determina a destreza do personagem
     * @param destreza Nova destreza do personagem
     */
    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    /**
     * Determina a experiencia do personagem
     * @param exp Nova experiencia do personagem
     */
    public void setExp(int exp) {
        this.exp = exp;
    }

    /**
     * Determina o nivel do personagem
     * @param nivel Novo nivel do personagem
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }


    /**
     *
     * @return String com representacao de todas variaveis da classe
     */
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
