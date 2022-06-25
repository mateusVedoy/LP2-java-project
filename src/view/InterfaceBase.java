package view;

import controle.Processador;

import javax.swing.*;

public class InterfaceBase {

    public static String leDados(String mensagem) throws CampoVazioException {
        String opcao = JOptionPane.showInputDialog(null, mensagem);
        if(opcao == null) Processador.direcionar("0");
        if (opcao.contains(" ") || opcao.length() == 0) {
            throw new CampoVazioException(mensagem);
        } else {
            return opcao;
        }
    }

}
