package com.example.hellofx.models;

public class Vagao {

    protected char indexVagao;
    protected int tipoCarga;
    protected String nomeCarga;
    protected double qtd;

    public Vagao(char indexVagao, String nomeCarga, double qtd) {
        this.indexVagao = indexVagao;
        this.tipoCarga = 0;
        this.nomeCarga = nomeCarga;
        this.qtd = qtd;
    }


    public char getIndexVagao() {
        return this.indexVagao;
    }

    public void setIndexVagao(char indexVagao) {
        this.indexVagao = indexVagao;
    }

    public int getTipoCarga() {
        return this.tipoCarga;
    }

    public void setTipoCarga(int tipoCarga) {
        this.tipoCarga = tipoCarga;
    }

    public String getNomeCarga() {
        return this.nomeCarga;
    }

    public void setNomeCarga(String nomeCarga) {
        this.nomeCarga = nomeCarga;
    }

    public double getQtd() {
        return this.qtd;
    }

    public void setQtd(double qtd) {
        this.qtd = qtd;
    }

    @Override
    public String toString() {
        return "{" +
                " indexVagao='" + getIndexVagao() + "'" +
                ", tipoCarga='" + getTipoCarga() + "'" +
                ", nomeCarga='" + getNomeCarga() + "'" +
                ", qtd='" + getQtd() + "'" +
                "}";
    }
}
