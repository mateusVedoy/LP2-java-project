package view;

import controle.Comando;
import model.Destinatario;
import model.dao.DestinatarioDAO;

import javax.swing.*;

public class InterfaceInserirAutorizado extends InterfaceBase implements Comando {
    @Override
    public void executar() {
    //TODO: implementar as ações necessárias para inserir uma pessoa na lista de autorizados do Destinatário
        DestinatarioDAO DDao = new DestinatarioDAO();
        String nomeDestinatario = null;
        String nomeAutorizado = null;
        String numeroImovelDestinatario = null;

        do {
            try{
                nomeDestinatario = leDados("Informe o nome do destinatario a ter pessoa autorizada cadastrada: ");
            }catch(CampoVazioException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage() + " novamente");
            }
        }while(nomeDestinatario == null || nomeDestinatario.equals("0"));

        do {
            try{
                numeroImovelDestinatario = leDados("Informe o numero do imóvel do destinatario: ");
            }catch(CampoVazioException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage() + " novamente");
            }
        }while(numeroImovelDestinatario == null || numeroImovelDestinatario.equals("0"));

        Destinatario destinatario = new Destinatario(nomeDestinatario, numeroImovelDestinatario);
        Destinatario returnD = (Destinatario) DDao.listaObjeto(destinatario);

        if(returnD == null){
            JOptionPane.showMessageDialog(null, "Usuario nao encontrado para adicionar autorizado!");
        }else{
            do {
                try{
                    nomeAutorizado = leDados("Informe o nome do autorizado: ");
                }catch(CampoVazioException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage() + " novamente");
                }
            }while(nomeAutorizado == null || nomeAutorizado.equals("0"));

            returnD.addAutorizado(nomeAutorizado);
            DDao.deletar(returnD);
            DDao.criar(returnD);
            JOptionPane.showMessageDialog(null, "Autorizado adicionado ao destinatario");
        }
    }
}
