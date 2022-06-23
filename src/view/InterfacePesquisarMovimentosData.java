package view;

import controle.Comando;
import model.Movimento;
import model.dao.MovimentoDAO;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class InterfacePesquisarMovimentosData extends InterfaceBase implements Comando {
    @Override
    public void executar() {
        //TODO: implementar as ações necessárias para pesquisar todos os movimentos realizados em uma determinada data
        MovimentoDAO MDao = new MovimentoDAO();
        List<Movimento> movimentosList = new ArrayList<Movimento>();
        List<Movimento> movimentosListPorData = new ArrayList<Movimento>();

        String data = null;

        do{
            try{
                data = leDados("Informe a data a ser pesquisada formato dd/m/yyyy");
            }catch(CampoVazioException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage() + " novamente");
            }
        }while(data == null || data.equals("0"));

        movimentosList = MDao.listarTodos();

        for(Movimento M: movimentosList){
            Calendar dt = M.getData();
            String MDt = (dt.get(Calendar.DAY_OF_MONTH) +"/"+ (dt.get(Calendar.MONTH)+1) + "/" + dt.get(Calendar.YEAR)).toString();
            if(MDt.equals(data)){
                movimentosListPorData.add(M);
            }
        }

        if(movimentosListPorData.size() > 0){
            JOptionPane.showMessageDialog(null, "Movimentos para data: \n"+ movimentosListPorData);
        }else{
            JOptionPane.showMessageDialog(null, "Não ha movimentos para data");
        }
    }

}
