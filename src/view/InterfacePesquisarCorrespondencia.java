package view;

import com.sun.source.tree.CaseTree;
import controle.Comando;
import model.*;
import model.dao.CartaDAO;
import model.dao.CorrespondenciaDAO;
import model.dao.DestinatarioDAO;
import model.dao.PacoteDAO;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InterfacePesquisarCorrespondencia extends InterfaceBase implements Comando{

    @Override
    public void executar() {
        //TODO: implementar as ações necessárias para pesquisar se existem correspondências não entregues para um determinado destinatário, identificando se são cartas ou pacotes
        String numeroDestinatario = null;
        String nomeDestinatario = null;
        DestinatarioDAO DDao = new DestinatarioDAO();
        CartaDAO CtDao = new CartaDAO();
        PacoteDAO PDao = new PacoteDAO();
        List<Pacote> pacoteList = new ArrayList<Pacote>();
        List<Carta> cartaList = new ArrayList<Carta>();
        List<Carta> auxCartaList = new ArrayList<Carta>();
        List<Pacote> auxPacoteList = new ArrayList<Pacote>();
        List<Correspondencia> correspondenciasList = new ArrayList<Correspondencia>();

        do {
            try{
                nomeDestinatario = leDados("Informe o nome do destinatario para buscar as correspondencias abertas: ");

            }catch(CampoVazioException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage() + " novamente");
            }
        }while(nomeDestinatario == null || nomeDestinatario.equals("0"));

        do {
            try{
                numeroDestinatario = leDados("Informe o numero da residencia do destinarario para buscar as correspondencias abertas: ");

            }catch(CampoVazioException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage() + " novamente");
            }
        }while(numeroDestinatario == null || numeroDestinatario.equals("0"));

        //verifica se o destinatario existe
        Destinatario destinatario = new Destinatario(nomeDestinatario, numeroDestinatario);
        Destinatario D = (Destinatario) DDao.listarObjeto(destinatario);

        if(D != null){
            pacoteList = PDao.listarTodos();
            cartaList = CtDao.listarTodos();

            if(pacoteList != null) {
                for (Pacote pct: pacoteList){
                    if(pct.getDestino() == D){
                        if(!pct.getStatus()) {
                            auxPacoteList.add(pct);
                        }
                    }
                }
            }

            if(cartaList != null){
                for (Carta ct: cartaList){
                    if(ct.getDestino() == D){
                        if(!ct.getStatus()){
                            auxCartaList.add(ct);
                        }
                    }
                }
            }

            if(auxPacoteList.size() == 0 && auxCartaList.size() == 0){
                JOptionPane.showMessageDialog(null, "Não há correspondencias para o destinatario");
            }else if(auxPacoteList.size() != 0 && auxCartaList.size() == 0){
                JOptionPane.showMessageDialog(null, "O destinatario possui Pacotes: \n"+pacoteList);
            }else if(auxPacoteList.size() == 0 && auxCartaList.size() > 0){
                JOptionPane.showMessageDialog(null, "O destinatario possui Cartas: \n"+cartaList);
            }else{
                correspondenciasList.addAll(cartaList);
                correspondenciasList.addAll(pacoteList);
                JOptionPane.showMessageDialog(null, "O destinatario possui cartas e pacotes: \n"+correspondenciasList);
            }
            auxCartaList.clear();
            auxPacoteList.clear();
        }else{
            JOptionPane.showMessageDialog(null, "Usuario nao cadastrado");
        }
    }

}
