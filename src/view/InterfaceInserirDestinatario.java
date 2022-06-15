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
                nomeDestinatario = leDados("Informe o nome do novo destinatário: ");
            }catch(CampoVazioException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage() + " novamente");
            }
        }while(nomeDestinatario == null || nomeDestinatario.equals("0"));

        do {
            try{
                numeroImovelDestinatario = leDados("Informe o número do imóvel do destinatário: ");
            }catch(CampoVazioException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage() + " novamente");
            }
        }while(numeroImovelDestinatario == null || numeroImovelDestinatario.equals("0"));

        destinatario = new Destinatario(nomeDestinatario, numeroImovelDestinatario);

        DDao.inserir(destinatario);

        System.out.println(DDao.pesquisar());
    }
}
