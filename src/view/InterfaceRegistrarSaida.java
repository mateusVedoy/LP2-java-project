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
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

public class InterfaceRegistrarSaida extends InterfaceBase implements Comando {

    public void executar() {
        //TODO: implementar as ações necessárias para registrar a entrega de uma correspondencia
        DestinatarioDAO DDao = new DestinatarioDAO();
        MovimentoDAO MDao = new MovimentoDAO();
        CorrespondenciaDAO CDao = new CorrespondenciaDAO();
        Destinatario D = null;
        Destinatario destinatario = null;
        String nomeDestinatario = null;
        String numeroDestinatario = null;
        String autorizadoDestinatario = null;
        int naturezaOpcao = 0;
        String quemRetira = null;
        String quemRegistra = null;

        List<Movimento> movimentosList = new ArrayList<Movimento>();
        List<Movimento> movimentosListPorDestinatario = new ArrayList<Movimento>();
        List<String> autorizadosdestinatarioList = new ArrayList<String>();

        do {
            try {
                numeroDestinatario = leDados("Informe o numero do imovel: ");
            } catch (CampoVazioException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage() + " novamente");
            }
        } while (numeroDestinatario == null || numeroDestinatario.equals("0"));

        movimentosList = MDao.listarTodos();

        //listando correspondencias nao entregues do endereco passado
        for (Movimento mcl : movimentosList) {
            if (mcl.getCorrespondencia().getDestino().getNumeroImovel().equals(numeroDestinatario)) {
                if (!mcl.getCorrespondencia().getStatus()) {
                    movimentosListPorDestinatario.add(mcl);
                }
            }
        }

        if (movimentosListPorDestinatario.size() > 0) {
            JOptionPane.showMessageDialog(null, "Ha correspondencias pendentes. Pressione OK para prosseguir");
            do {
                do {
                    try {
                        nomeDestinatario = leDados("Informe o nome do destinatario: ");
                    } catch (CampoVazioException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage() + " novamente");
                    }
                } while (nomeDestinatario == null || nomeDestinatario.equals("0"));

                destinatario = new Destinatario(nomeDestinatario, numeroDestinatario);
                D = (Destinatario) DDao.listarObjeto(destinatario);
                if (D == null) {
                    JOptionPane.showMessageDialog(null, "Destinatario invalido!");
                }
            } while (D == null);

            do {
                try {
                    naturezaOpcao = Integer.parseInt(leDados("Quem retira é destinatario(0) ou autorizado(1): "));
                    if (naturezaOpcao > 1 || naturezaOpcao < 0) {
                        JOptionPane.showMessageDialog(null, "Atenha-se a uma opção válida");
                    }
                } catch (CampoVazioException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage() + " novamente");
                }
            } while (naturezaOpcao > 1 || naturezaOpcao < 0);

            if (naturezaOpcao == 0) {

                quemRetira = nomeDestinatario;

            } else if (naturezaOpcao == 1) {
                int indexOfAutorizado = -1;
                do {
                    do {
                        try{
                            autorizadoDestinatario = leDados("Informe o autorizado: ");
                        }catch(CampoVazioException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage() + " novamente");
                        }
                    }while(autorizadoDestinatario == null || autorizadoDestinatario.equals("0"));

                    //verificar se autorizado está na relação do usuario
                    autorizadosdestinatarioList = D.getAutorizados();

                    indexOfAutorizado = autorizadosdestinatarioList.indexOf(autorizadoDestinatario);

                    if (indexOfAutorizado == -1) {
                        JOptionPane.showMessageDialog(null, "Autorizado nao encontrado");
                    } else {
                        quemRetira = autorizadoDestinatario;
                    }
                } while (indexOfAutorizado == -1);
            }

            //recupera nome do funcionario
            do{
                try{
                    quemRegistra = leDados("Informe o funcionario do movimento: ");
                }catch(CampoVazioException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage() + " novamente");
                }
            }while(quemRegistra == null || quemRegistra.equals("0"));

            //marcar correspondencias do endereco passado como entregues
//            for(Movimento mld: movimentosListPorDestinatario){
//                mld.getCorrespondencia().setStatus(true);
//            }

            //criar movimento de saída
            for(Movimento mld: movimentosListPorDestinatario){
                Movimento M = new Movimento(mld.getCorrespondencia(), quemRetira, quemRegistra);
//                mld.getCorrespondencia().setStatus(true);
//                mld.setQuemRegistra(quemRegistra);
//                mld.setQuemRetira(quemRetira);
//                mld.setData(new GregorianCalendar());
            }
            JOptionPane.showMessageDialog(null, "Correspondencias entregues e movimento(s) de saída criado(s)");
        }else {
            JOptionPane.showMessageDialog(null, "Não há correspondencias pendentes para o numero de imovel informado");
        }
    }
}
