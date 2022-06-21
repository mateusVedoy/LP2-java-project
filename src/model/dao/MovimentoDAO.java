package model.dao;

import model.Movimento;

import java.util.ArrayList;
import java.util.List;

public class MovimentoDAO implements OperacoesDAO {

    static List<Movimento> MovimentosArr = new ArrayList<Movimento>();

    public void criar(Object obj){
        Movimento M = (Movimento) obj;
        MovimentosArr.add(M);
    }

    @Override
    public void deletar(Object obj) {

    }

    @Override
    public boolean editar(Object obj, String dado) {
        return false;
    }

    @Override
    public List listarTodos() {
        return MovimentosArr;
    }

    @Override
    public Object listarObjeto(Object obj) {
        return null;
    }
}