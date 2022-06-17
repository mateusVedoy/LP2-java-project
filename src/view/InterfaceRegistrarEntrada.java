package view;

import javax.swing.*;
import controle.Comando;
import controle.Processador;
import model.*;
import model.dao.DestinatarioDAO;
import model.dao.MovimentoDAO;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public class InterfaceRegistrarEntrada extends InterfaceBase implements Comando {

    public void executar() {
        DestinatarioDAO DDao = new DestinatarioDAO();
        MovimentoDAO MDao = new MovimentoDAO();
        String nomeDestinatario = null;
        String numeroDestinatario = null;
        String autorizadoDestinatario = null;

       do {
           try{
               nomeDestinatario = leDados("Informe o nome do destinatario da correspondencia: ");
           }catch(CampoVazioException ex){
               JOptionPane.showMessageDialog(null, ex.getMessage() + " novamente");
           }
       }while(nomeDestinatario == null || nomeDestinatario.equals("0"));

        do {
            try{
                numeroDestinatario = leDados("Informe o numero da residencia desse destinatario: ");
            }catch(CampoVazioException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage() + " novamente");
            }
        }while(numeroDestinatario == null || numeroDestinatario.equals("0"));

        Destinatario destinatario = new Destinatario(nomeDestinatario, numeroDestinatario);
        Destinatario D = (Destinatario) DDao.listaObjeto(destinatario);

        if(D != null){
            Correspondencia correspondencia = new Correspondencia(destinatario);

            do {
                try{
                    autorizadoDestinatario = leDados("Informe quem recebeu a entrega: ");
                }catch(CampoVazioException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage() + " novamente");
                }
            }while(autorizadoDestinatario == null || autorizadoDestinatario.equals("0"));

            List autorizados = D.getAutorizados();
            boolean isDef = autorizados.contains(autorizadoDestinatario);

            if(isDef){
                Movimento M = new Movimento(correspondencia, autorizadoDestinatario);
                MDao.criar(M);
                JOptionPane.showMessageDialog(null, "Movimento registrado");
            }else{
                JOptionPane.showMessageDialog(null, "Pessoa autorizada não cadastrada");
            }

        }else{
            JOptionPane.showMessageDialog(null, "Usuario nao cadastrado");
        }
    }
}
