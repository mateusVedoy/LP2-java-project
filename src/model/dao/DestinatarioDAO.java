package model.dao;

import model.Destinatario;
import java.util.ArrayList;
import java.util.List;

public class DestinatarioDAO implements OperacoesDAO {

    static List<Destinatario> DestinatariosArr = new ArrayList<Destinatario>();

    public void criar(Object obj) {
        Destinatario D = (Destinatario) obj;
        DestinatariosArr.add(D);
    }

    public void deletar(Object obj) {
        Destinatario D = (Destinatario) obj;
        boolean isDDefined = DestinatariosArr.contains(D);
        if(isDDefined){
            DestinatariosArr.remove(D);
        }
    }

    public boolean editar(Object obj, String dado)  {

        Destinatario D = (Destinatario) obj;
        return true;
    }

    public List listarTodos() {
        return DestinatariosArr;
    }

    public Object listarObjeto(Object obj) {
        Destinatario D = (Destinatario) obj;
        boolean isDef = DestinatariosArr.contains(D);
        if(isDef){
            int  indexDest = DestinatariosArr.indexOf(D);
            Destinatario auxDest = DestinatariosArr.get(indexDest);
            return auxDest;
        }else{
            return null;
        }
    }
}
