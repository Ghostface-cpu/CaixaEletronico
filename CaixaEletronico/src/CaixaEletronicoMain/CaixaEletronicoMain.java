package CaixaEletronicoMain;

import CaixaEletronicoModel.Conta;
import CaixaEletronicoView.CaixaEletronicoView;
import CaixaEletronicoController.CaixaEletronicoController;
import javax.swing.SwingUtilities;

public class CaixaEletronicoMain {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            Conta conta = new Conta();

            CaixaEletronicoView tela = new CaixaEletronicoView();

            new CaixaEletronicoController(conta, tela);

            tela.setVisible(true);
        });
    }
}