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
        Correspondencia C = null;
        String nomeDestinatario = null;
        String numeroDestinatario = null;
        String autorizadoDestinatario = null;
        int tipoCorrespondencia = 2;
        String empresaPacote = null;
        int contemRecibo = 0;
        String funcionario = null;
        boolean recibo = false;
        boolean isDef = false;

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

        //verifica se o destinatario existe
        Destinatario destinatario = new Destinatario(nomeDestinatario, numeroDestinatario);
        Destinatario D = (Destinatario) DDao.listarObjeto(destinatario);

        if(D != null){

            do{
                try {
                    tipoCorrespondencia = Integer.parseInt(leDados("Informe a natureza da correspondencia:\n[0 - Pacote\n1 - Carta]: "));

                    if(tipoCorrespondencia > 1){
                        JOptionPane.showMessageDialog(null, "Opcao invalida. Tente novamente!");
                    }
                }catch(CampoVazioException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage() + " novamente");
                }

            }while(tipoCorrespondencia > 1);

            if(tipoCorrespondencia == 0){
                do{
                    try{
                        empresaPacote = leDados("Informe a empresa remetente: ");
                    }catch(CampoVazioException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage() + " novamente");
                    }
                }while(empresaPacote == null || empresaPacote.equals("0"));

                C = new Pacote(D,empresaPacote);

            }else if(tipoCorrespondencia == 1){
                do {
                    try{
                        contemRecibo = Integer.parseInt(leDados("A carta carta contem recibo?[0/1] "));
                    }catch(CampoVazioException ex){
                        JOptionPane.showMessageDialog(null, ex.getMessage() + " novamente");
                    }
                    if(contemRecibo > 1){
                        JOptionPane.showMessageDialog(null,"Atenha-se às opções [0/1]");
                    }
                }while(contemRecibo > 1);

               if(contemRecibo == 1){
                   recibo = true;
               }

               C = new Carta(D, recibo);
            }

            do {
                try{
                    funcionario = leDados("Informe o nome do funcionario que recebeu a correspondencia: ");
                }catch(CampoVazioException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage() + " novamente");
                }
            }while(funcionario == null || funcionario.equals("0"));

            Movimento M = new Movimento(C, funcionario);
            MDao.criar(M);
            JOptionPane.showMessageDialog(null, "Entrada registrada");

        }else{
            JOptionPane.showMessageDialog(null, "Usuario nao cadastrado");
        }
    }
}
