package view;

import controle.*;
import model.Correspondencia;
import model.Destinatario;
import model.Movimento;
import model.dao.DestinatarioDAO;
import model.dao.MovimentoDAO;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class InterfacePesquisarMovimentosDestinatario extends InterfaceBase implements Comando{
    public void executar() {
        //TODO: implementar as ações necessárias para pesquisar todos os movimentos de um determinado destinatário
        MovimentoDAO MDao = new MovimentoDAO();
        DestinatarioDAO DDao = new DestinatarioDAO();
        String nomeDestinatario = null;
        String nroDestinatario = null;
        List<Movimento> movimentosList = new ArrayList<Movimento>();
        List<Movimento> movimentosListPorDestinatario = new ArrayList<Movimento>();
        List<Correspondencia> movimentosListCorr = new ArrayList<Correspondencia>();

        do {
            try{
                nomeDestinatario = leDados("Informe o nome do destinatario para buscar os movimentos: ");
            }catch(CampoVazioException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage() + " novamente");
            }
        }while(nomeDestinatario == null || nomeDestinatario.equals("0"));

        do {
            try{
                nroDestinatario = leDados("Informe o numero do endereco do destinatario: ");
            }catch(CampoVazioException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage() + " novamente");
            }
        }while(nroDestinatario == null || nroDestinatario.equals("0"));

        //verifica se o destinatario existe
        Destinatario destinatario = new Destinatario(nomeDestinatario, nroDestinatario);
        Destinatario D = (Destinatario) DDao.listarObjeto(destinatario);

        if(D != null){
            movimentosList = MDao.listarTodos();

            for(Movimento movCorr: movimentosList){
                if(movCorr.getCorrespondencia().getDestino().equals(D)){
                    movimentosListPorDestinatario.add(movCorr);
                }
            }

            if(movimentosListPorDestinatario.size() > 0){
                JOptionPane.showMessageDialog(null, "Movimentos deste destinatario: \n"+movimentosListPorDestinatario);
            }else{
                JOptionPane.showMessageDialog(null, "Não há movimentos para o destinatario");
            }

        }else{
            JOptionPane.showMessageDialog(null, "Destinatario nao encontrado!");
        }
    }

}
