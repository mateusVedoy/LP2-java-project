package view;

import controle.Comando;
import model.Destinatario;
import model.dao.DestinatarioDAO;

import java.util.*;
import javax.swing.*;

public class InterfaceInserirDestinatario extends InterfaceBase implements Comando {
    @Override
    public void executar() {
        //TODO: implementar as ações necessárias para cadastrar um Destinatário
        DestinatarioDAO DDao = new DestinatarioDAO();
        Destinatario destinatario;
        String nomeDestinatario = null;
        String numeroImovelDestinatario = null;

        do {
            try{
                nomeDestinatario = leDados("Informe o nome do novo destinatario");
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

        destinatario = new Destinatario(nomeDestinatario, numeroImovelDestinatario);
        Destinatario D = (Destinatario) DDao.listarObjeto(destinatario);
        if(D != null){
            JOptionPane.showMessageDialog(null, "Destinatario cadastrado anteriormente");
        }else{
            DDao.criar(destinatario);
        }
    }
}
