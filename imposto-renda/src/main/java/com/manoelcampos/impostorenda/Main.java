package com.manoelcampos.impostorenda;

public class Main {
    public static void main(String[] args) {
        PessoaFisica pf = new PessoaFisica();
        pf.setId(1);
        pf.setNome("Manoel Campos");
        pf.setSalarioBruto(5000);
        pf.setDeducaoPorDependente(1000);
        pf.setGastosSaude(500);
        pf.setGastosEducacao(500);
        System.out.println("Imposto Pessoa Física: Nome "+pf.getNome() +" "+ pf.calcularImposto());

        PessoaJuridica pj = new PessoaJuridica();
        pj.setId(2);
        pj.setNome("Empresa X");
        pj.setLucro(50000);
        pj.setValorProdutosAdquiridos(10000);
        System.out.println("Imposto Pessoa "+pj.getNome()+" Jurídica: " + pj.calcularImposto());
    }
}