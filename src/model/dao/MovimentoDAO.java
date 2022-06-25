package model.dao;

import model.Correspondencia;
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
        Movimento M = (Movimento) obj;
        boolean isMDefined = MovimentosArr.contains(M);
        if(isMDefined){
            MovimentosArr.remove(M);
        }
    }

    @Override
    public void editar(Object obj, Object newObj) {
        Movimento M = (Movimento) obj;
        Movimento NM = (Movimento) newObj;
        MovimentosArr.remove(M);
        MovimentosArr.add(NM);
    }

    @Override
    public List listarTodos() {
        return MovimentosArr;
    }

    @Override
    public Object listarObjeto(Object obj) {
        Movimento M = (Movimento) obj;
        boolean isDef = MovimentosArr.contains(M);
        if(isDef){
            int indexM = MovimentosArr.indexOf(M);
            Movimento auxM = MovimentosArr.get(indexM);
            return auxM;
        }else{
            return null;
        }
    }
}
