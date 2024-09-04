package com.manoelcampos.impostorenda;

public class PessoaJuridica extends Pessoa implements Imposto {
    private double lucro;
    private double valorProdutosAdquiridos;

    public double getLucro() {
        return lucro;
    }

    public void setLucro(double lucro) {
        this.lucro = lucro;
    }

    public double getValorProdutosAdquiridos() {
        return valorProdutosAdquiridos;
    }

    public void setValorProdutosAdquiridos(double valorProdutosAdquiridos) {
        this.valorProdutosAdquiridos = valorProdutosAdquiridos;
    }
// Adicione getters e setters para os campos acima

    @Override
    public double calcular() {
        double aliquotaIRPJ = 0.15;
        double aliquotaAdicional = 0.1;
        double aliquotaCSLL = 0.09;
        double aliquotaICMS = 0.05;
        double limiteCobrancaIR = 20000;

        double irParcial = lucro * aliquotaIRPJ;
        double irExcedente = Math.max(0, irParcial - limiteCobrancaIR);
        double ir = irParcial + irExcedente * aliquotaAdicional;
        double csll = lucro * aliquotaCSLL;
        double icms = valorProdutosAdquiridos * aliquotaICMS;

        return ir + csll + icms;
    }

    @Override
    public double calcularImposto() {
        return calcular();
    }
}