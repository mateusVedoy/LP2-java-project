package view;

import controle.Comando;
import model.Destinatario;
import model.dao.DestinatarioDAO;

import javax.swing.*;

public class InterfacePesquisarDestinatario extends InterfaceBase implements Comando{

    @Override
    public void executar() {
        //TODO: implementar as ações necessárias para pesquisar os dados de um Destinatário
        String nomeDestinatario = null;
        String numeroImovelDestinatario = null;
        DestinatarioDAO DDao = new DestinatarioDAO();

        do {
            try{
                nomeDestinatario = leDados("Informe destinatario para pesquisar");
            }catch(CampoVazioException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage() + " novamente");
            }
        }while(nomeDestinatario == null || nomeDestinatario.equals("0"));

        do {
            try{
                numeroImovelDestinatario = leDados("Informe o numero do imovel do destinatario");
            }catch(CampoVazioException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage() + " novamente");
            }
        }while(numeroImovelDestinatario == null || numeroImovelDestinatario.equals("0"));

        Destinatario destinatario = new Destinatario(nomeDestinatario, numeroImovelDestinatario);

        Destinatario returnD = (Destinatario) DDao.listarObjeto(destinatario);

        if(returnD != null){
            JOptionPane.showMessageDialog(null, returnD);
        }else {
            JOptionPane.showMessageDialog(null, "Usuario nao encontrado!");
        }
    }
}
