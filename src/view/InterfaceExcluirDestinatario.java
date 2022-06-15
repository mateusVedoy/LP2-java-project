package view;

import controle.Comando;
import model.Destinatario;
import model.dao.DestinatarioDAO;

import javax.swing.*;

public class InterfaceExcluirDestinatario extends InterfaceBase implements Comando {

    @Override
    public void executar() {
        //TODO: implementar as ações necessárias para excluir um destinatário
        DestinatarioDAO DDao = new DestinatarioDAO();
        String nomeDestinatario = null;
        String numeroImovelDestinatario = null;

        do {
            try{
                nomeDestinatario = leDados("Informe o nome do destinatário a ser deletado");
            }catch(CampoVazioException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage() + " novamente");
            }
        }while(nomeDestinatario == null || nomeDestinatario.equals("0"));

        do {
            try{
                numeroImovelDestinatario = leDados("Informe o numero do imovel do destinatário a ser deletado");
            }catch(CampoVazioException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage() + " novamente");
            }
        }while(numeroImovelDestinatario == null || numeroImovelDestinatario.equals("0"));

        Destinatario D = new Destinatario(nomeDestinatario, numeroImovelDestinatario);

        DDao.excluir(D);
        System.out.println("Destinatários ainda cadastrados: \n");
        System.out.println(DDao.pesquisar());
    }
}
