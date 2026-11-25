
package CaixaEletronicoModel;

public class Conta {

    private double saldo;

    public Conta() {
        saldo = 1000.00;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {

        if (valor <= 0) {
            throw new IllegalArgumentException(
                "O valor deve ser maior que zero."
            );
        }

        saldo += valor;
    }

    public int[] sacar(double valor) {

        if (valor <= 0) {
            throw new IllegalArgumentException(
                "O valor deve ser maior que zero."
            );

        } else if (valor > saldo) {
            throw new IllegalArgumentException(
                "Saldo insuficiente."
            );

        } else if (valor > 1000) {
            throw new IllegalArgumentException(
                "O saque máximo por operação é R$ 1.000,00."
            );

        } else if (valor % 10 != 0) {
            throw new IllegalArgumentException(
                "O saque deve ser múltiplo de 10."
            );
        }

        int restante = (int) valor;

        int notas100 = restante / 100;
        restante = restante % 100;

        int notas50 = restante / 50;
        restante = restante % 50;

        int notas10 = restante / 10;

        saldo -= valor;

        return new int[] {
            notas100, notas50, notas10
        };
    }
}
