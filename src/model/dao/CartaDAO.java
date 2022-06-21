package model.dao;

import model.Carta;

import java.util.ArrayList;
import java.util.List;

public class CartaDAO extends CorrespondenciaDAO implements OperacoesDAO{
    static List<Carta> CartaArr = new ArrayList<Carta>();

    public void criar(Object obj){
        Carta C = (Carta) obj;
        super.criar(obj);
        CartaArr.add(C);
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
        return CartaArr;
    }

    @Override
    public Object listarObjeto(Object obj) {
        return null;
    }
}
