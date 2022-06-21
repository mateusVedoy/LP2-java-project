package view;

import controle.Comando;
import model.*;
import model.dao.CorrespondenciaDAO;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InterfacePesquisarCorrespondencia extends InterfaceBase implements Comando{

    @Override
    public void executar() {
        //TODO: implementar as ações necessárias para pesquisar se existem correspondências não entregues para um determinado destinatário, identificando se são cartas ou pacotes
        String destinatario = null;
        CorrespondenciaDAO CDao = new CorrespondenciaDAO();
        List<Correspondencia> Clist = new ArrayList<Correspondencia>();

        do {
            try{
                destinatario = leDados("Informe o destinatario para buscar as correspondencias abertas: ");

            }catch(CampoVazioException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage() + " novamente");
            }
        }while(destinatario == null || destinatario.equals("0"));

        Clist = CDao.listarTodos();

        System.out.println(CDao.listarTodos());

//        Iterator itC = Clist.iterator();
//
//        while(itC.hasNext()){
//            System.out.println(itC.hasNext());
//        }
    }

}
