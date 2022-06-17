package model.dao;

import model.Correspondencia;

import java.util.ArrayList;
import java.util.List;

public class CorrespondenciaDAO  {

    static List<Correspondencia> CorrespondenciaArr = new ArrayList<Correspondencia>();

    public void criar(Object obj) {
        Correspondencia C = (Correspondencia) obj;
        CorrespondenciaArr.add(C);
    }

    public void deletar(Object obj) {
        Correspondencia C = (Correspondencia) obj;
    }

    public boolean editar(Object obj, String dado) {
        return false;
    }

    public List listarTodos() {
        return CorrespondenciaArr;
    }

    public Object listaObjeto(Object obj) {
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
