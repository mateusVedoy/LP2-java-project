package model.dao;

import model.Pacote;

import java.util.ArrayList;
import java.util.List;

public class PacoteDAO implements OperacoesDAO {

    static List<Pacote> PacoteArr = new ArrayList<Pacote>();

    public void criar(Object obj){
        Pacote P = (Pacote) obj;
        PacoteArr.add(P);
        CorrespondenciaDAO.CorrespondenciaArr.add(P);
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
        return PacoteArr;
    }

    @Override
    public Object listarObjeto(Object obj) {
        Pacote P = (Pacote) obj;
        boolean isDef = PacoteArr.contains(P);
        if(isDef){
            int indexP = PacoteArr.indexOf(P);
            return PacoteArr.get(indexP);
        }else{
            return null;
        }
    }
}
