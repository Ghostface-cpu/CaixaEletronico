
package CaixaEletronicoController;

import CaixaEletronicoModel.Conta;
import CaixaEletronicoView.CaixaEletronicoView;

import javax.swing.*;
import java.text.NumberFormat;
import java.util.Locale;

public class CaixaEletronicoController {

    private Conta conta;
    private CaixaEletronicoView tela;

    private NumberFormat moeda =
        NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    public CaixaEletronicoController(
        Conta conta,
        CaixaEletronicoView tela
    ) {
        this.conta = conta;
        this.tela = tela;

        tela.getBtnDepositar().addActionListener(
            e -> depositar()
        );

        tela.getBtnSacar().addActionListener(
            e -> sacar()
        );

        tela.getBtnExtrato().addActionListener(
            e -> tela.mostrarExtrato()
        );
    }

    private double lerValor() {

        String texto = tela.getTxtValor()
            .getText().trim().replace(",", ".");

        double valor = Double.parseDouble(texto);

        if (!Double.isFinite(valor)) {
            throw new NumberFormatException();
        }

        return valor;
    }

    private void depositar() {

        try {

            double valor = lerValor();

            conta.depositar(valor);

            tela.atualizarSaldo(conta.getSaldo());

            tela.adicionarExtrato(
                "Depósito: " + moeda.format(valor)
            );

            tela.limparCampo();

            JOptionPane.showMessageDialog(
                tela,
                "Depósito realizado com sucesso!"
            );

        } catch (NumberFormatException erro) {

            JOptionPane.showMessageDialog(
                tela,
                "Digite um valor numérico válido."
            );

        } catch (IllegalArgumentException erro) {

            JOptionPane.showMessageDialog(
                tela,
                erro.getMessage()
            );
        }
    }

    private void sacar() {

        try {

            double valor = lerValor();

            int[] notas = conta.sacar(valor);

            tela.atualizarSaldo(conta.getSaldo());

            tela.adicionarExtrato(
                "Saque: " + moeda.format(valor)
            );

            tela.adicionarExtrato(
                notas[0] + " nota(s) de R$ 100"
            );

            tela.adicionarExtrato(
                notas[1] + " nota(s) de R$ 50"
            );

            tela.adicionarExtrato(
                notas[2] + " nota(s) de R$ 10"
            );

            tela.limparCampo();

            JOptionPane.showMessageDialog(
                tela,
                "Saque realizado com sucesso!\n\n"
                + "Notas de R$ 100: " + notas[0] + "\n"
                + "Notas de R$ 50: " + notas[1] + "\n"
                + "Notas de R$ 10: " + notas[2]
            );

        } catch (NumberFormatException erro) {

            JOptionPane.showMessageDialog(
                tela,
                "Digite um valor numérico válido."
            );

        } catch (IllegalArgumentException erro) {

            JOptionPane.showMessageDialog(
                tela,
                erro.getMessage()
            );
        }
    }
}
