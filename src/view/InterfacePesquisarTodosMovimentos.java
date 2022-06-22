package view;

import controle.Comando;
import model.Movimento;
import model.dao.MovimentoDAO;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class InterfacePesquisarTodosMovimentos extends InterfaceBase implements Comando {
    @Override
    public void executar() {
        //TODO: implementar as ações necessárias para pesquisar todos os movimentos
        MovimentoDAO MDao = new MovimentoDAO();
        List<Movimento> movimentosList = new ArrayList<Movimento>();
        List<Movimento> movimentosListPorFuncionario = new ArrayList<Movimento>();
        String funcionario = null;

        do {
            try{
                funcionario = leDados("Informe o funcionario para buscar os movimentos: ");
            }catch(CampoVazioException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage() + " novamente");
            }
        }while(funcionario == null || funcionario.equals("0"));

        movimentosList = MDao.listarTodos();

        for (Movimento mov: movimentosList){
            if(mov.getQuemRegistra().equals(funcionario)){
                movimentosListPorFuncionario.add(mov);
            }
        }

        if(movimentosListPorFuncionario.size() == 0){
            JOptionPane.showMessageDialog(null, "Nao ha movimentos registrados");
        }else {
            JOptionPane.showMessageDialog(null, "Movimentos deste funcionário: \n"+movimentosListPorFuncionario);
        }
    }

}
