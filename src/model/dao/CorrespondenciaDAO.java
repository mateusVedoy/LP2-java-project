package model.dao;

import model.Correspondencia;

import java.util.ArrayList;
import java.util.List;

public class CorrespondenciaDAO implements OperacoesDAO {

    static List<Correspondencia> CorrespondenciaArr = new ArrayList<Correspondencia>();

    public void criar(Object obj) {
        Correspondencia C = (Correspondencia) obj;
        CorrespondenciaArr.add(C);
    }

    public void deletar(Object obj) {
        Correspondencia C = (Correspondencia) obj;
    }

    public void editar(Object obj, Object newObj) {

    }

    public List listarTodos() {
        return CorrespondenciaArr;
    }

    public Object listarObjeto(Object obj) {
        Correspondencia C = (Correspondencia) obj;
        boolean isDef = CorrespondenciaArr.contains(C);
        if(isDef){
            int indexC = CorrespondenciaArr.indexOf(C);
            Correspondencia auxC = CorrespondenciaArr.get(indexC);
            return auxC;
        }else{
            return null;
        }
    }
}
