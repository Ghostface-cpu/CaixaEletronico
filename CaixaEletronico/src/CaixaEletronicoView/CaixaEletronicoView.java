
package CaixaEletronicoView;

import javax.swing.*;
import java.awt.*;

public class CaixaEletronicoView extends JFrame {

    private JLabel lblSaldo;
    private JTextField txtValor;
    private JTextArea txtExtrato;

    private JButton btnDepositar;
    private JButton btnSacar;
    private JButton btnExtrato;

    public CaixaEletronicoView() {

        setTitle("Banco ETEC - Caixa Eletrônico");
        setSize(600, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        getContentPane().setBackground(
            new Color(242, 245, 249)
        );

        JLabel titulo = new JLabel("BANCO ETEC");
        titulo.setBounds(30, 20, 300, 40);
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        add(titulo);

        JLabel textoSaldo = new JLabel("SALDO DISPONÍVEL:");
        textoSaldo.setBounds(30, 85, 200, 25);
        add(textoSaldo);

        lblSaldo = new JLabel("R$ 1.000,00");
        lblSaldo.setBounds(30, 115, 300, 40);
        lblSaldo.setFont(new Font("Arial", Font.BOLD, 25));
        lblSaldo.setForeground(new Color(20, 105, 70));
        add(lblSaldo);

        JLabel textoValor = new JLabel("Valor da operação:");
        textoValor.setBounds(30, 180, 200, 25);
        add(textoValor);

        txtValor = new JTextField();
        txtValor.setBounds(30, 210, 520, 35);
        add(txtValor);

        btnDepositar = new JButton("DEPOSITAR");
        btnDepositar.setBounds(30, 270, 150, 35);
        add(btnDepositar);

        btnSacar = new JButton("SACAR");
        btnSacar.setBounds(200, 270, 150, 35);
        add(btnSacar);

        btnExtrato = new JButton("EXTRATO");
        btnExtrato.setBounds(370, 270, 150, 35);
        add(btnExtrato);

        JLabel textoExtrato = new JLabel("EXTRATO DE OPERAÇÕES");
        textoExtrato.setBounds(30, 325, 250, 25);
        textoExtrato.setFont(new Font("Arial", Font.BOLD, 14));
        add(textoExtrato);

        txtExtrato = new JTextArea();
        txtExtrato.setEditable(false);

        JScrollPane scroll = new JScrollPane(txtExtrato);
        scroll.setBounds(30, 355, 520, 105);
        add(scroll);
    }

    public JTextField getTxtValor() {
        return txtValor;
    }

    public JButton getBtnDepositar() {
        return btnDepositar;
    }

    public JButton getBtnSacar() {
        return btnSacar;
    }

    public JButton getBtnExtrato() {
        return btnExtrato;
    }

    public void atualizarSaldo(double saldo) {
        lblSaldo.setText(
            String.format(java.util.Locale.forLanguageTag("pt-BR"),
                "R$ %.2f", saldo)
        );
    }

    public void adicionarExtrato(String texto) {
        txtExtrato.append(texto + "\n");
    }

    public void limparCampo() {
        txtValor.setText("");
    }
    
    public void mostrarExtrato() {
        String extrato = txtExtrato.getText();

        if (extrato.isEmpty()) {
            extrato = "Nenhuma operação realizada.";
        }

        JOptionPane.showMessageDialog(
            this,
            extrato,
            "Extrato de operações",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
