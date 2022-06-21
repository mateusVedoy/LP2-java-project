package view;

import javax.swing.*;
import controle.Comando;
import model.Correspondencia;
import model.Destinatario;
import model.Movimento;
import model.dao.CorrespondenciaDAO;
import model.dao.DestinatarioDAO;
import model.dao.MovimentoDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InterfaceRegistrarSaida extends InterfaceBase implements Comando {

    public void executar() {
        //TODO: implementar as ações necessárias para registrar a entrega de uma correspondencia
        DestinatarioDAO DDao = new DestinatarioDAO();
        MovimentoDAO MDao = new MovimentoDAO();
        CorrespondenciaDAO CDao = new CorrespondenciaDAO();
        String nomeDestinatario = null;
        String numeroDestinatario = null;
        String autorizadoDestinatario = null;

        do {
            try{
                numeroDestinatario = leDados("Informe o numero do apto: ");
            }catch(CampoVazioException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage() + " novamente");
            }
        }while(numeroDestinatario == null || numeroDestinatario.equals("0"));

//        List<Correspondencia> Clist =  CDao.listarTodos();
//        Iterator<Correspondencia> itC = Clist.iterator();

//        while(itC.hasNext()){
//            System.out.println(itC.next());
//        }

//        for (Iterator iterator = contatos.iterator(); iterator.hasNext(); ) {
//            ContatoT c = (ContatoT) iterator.next();
//            System.out.println (c.getNome());
//        }

    }
}
