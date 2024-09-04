package com.manoelcampos.impostorenda;

public class PessoaFisica extends Pessoa implements Imposto {
    private double salarioBruto;
    private double deducaoPorDependente;
    private double gastosSaude;

    public double getGastosEducacao() {
        return gastosEducacao;
    }

    public void setGastosEducacao(double gastosEducacao) {
        this.gastosEducacao = gastosEducacao;
    }

    public double getGastosSaude() {
        return gastosSaude;
    }

    public void setGastosSaude(double gastosSaude) {
        this.gastosSaude = gastosSaude;
    }

    public double getDeducaoPorDependente() {
        return deducaoPorDependente;
    }

    public void setDeducaoPorDependente(double deducaoPorDependente) {
        this.deducaoPorDependente = deducaoPorDependente;
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    private double gastosEducacao;

    // Adicione getters e setters para os campos acima

    @Override
    public double calcular() {
        double aliquotaIRPF = 0.11;
        double aliquotaINSS = 0.11;
        double inss = salarioBruto * aliquotaINSS;
        double irParcial = (salarioBruto - deducaoPorDependente - inss) * aliquotaIRPF;
        double ir = irParcial - (gastosSaude + gastosEducacao);
        return inss + Math.max(0, ir); // Adiciona o INSS ao valor máximo entre 0 e o IR calculado
    }

    @Override
    public double calcularImposto() {
            double imposto = calcular();
            return imposto < 0 ? 0 : imposto;
        }
    }
