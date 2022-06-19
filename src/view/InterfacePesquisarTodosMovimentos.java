package view;

import controle.Comando;
import model.dao.MovimentoDAO;

import javax.swing.*;
import java.util.List;

public class InterfacePesquisarTodosMovimentos extends InterfaceBase implements Comando {
    @Override
    public void executar() {
        //TODO: implementar as ações necessárias para pesquisar todos os movimentos
        MovimentoDAO MDao = new MovimentoDAO();
        List movimentos = MDao.listarTodos();
        if(movimentos == null){
            JOptionPane.showMessageDialog(null, "Nao ha movimentos registrados");
        }else {
            JOptionPane.showMessageDialog(null, movimentos);
        }
    }

}
