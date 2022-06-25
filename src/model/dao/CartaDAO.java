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
        Carta C = (Carta) obj;
        boolean isCDefined = CartaArr.contains(C);
        if(isCDefined){
            CartaArr.remove(C);
        }
    }

    @Override
    public void editar(Object obj, Object newObj) {
        Carta C = (Carta) obj;
        Carta NC = (Carta) newObj;
        CartaArr.remove(C);
        CartaArr.add(NC);
    }

    @Override
    public List listarTodos() {
        return CartaArr;
    }

    @Override
    public Object listarObjeto(Object obj) {
        Carta C = (Carta) obj;
        boolean isCDefined = CartaArr.contains(C);
        if(isCDefined){
            int indexC = CartaArr.indexOf(C);
            Carta auxC = CartaArr.get(indexC);
            return auxC;
        }else{
            return null;
        }
    }
}
