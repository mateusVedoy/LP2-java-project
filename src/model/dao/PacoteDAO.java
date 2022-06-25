package model.dao;

import model.Carta;
import model.Pacote;

import java.util.ArrayList;
import java.util.List;

public class PacoteDAO extends CorrespondenciaDAO implements OperacoesDAO {
    static List<Pacote> PacoteArr = new ArrayList<Pacote>();

    public void criar(Object obj){
        Pacote P = (Pacote) obj;
        super.criar(obj);
        PacoteArr.add(P);
    }

    @Override
    public void deletar(Object obj) {
        Pacote P = (Pacote) obj;
        boolean isPDefined = PacoteArr.contains(P);
        if(isPDefined){
            PacoteArr.remove(P);
        }
    }

    @Override
    public void editar(Object obj, Object newObj) {
        Pacote P = (Pacote) obj;
        Pacote NP = (Pacote) newObj;
        PacoteArr.remove(P);
        PacoteArr.add(NP);
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
