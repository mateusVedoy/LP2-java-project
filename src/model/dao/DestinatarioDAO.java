package model.dao;

import model.Destinatario;
import java.util.ArrayList;
import java.util.List;

public class DestinatarioDAO implements OperacoesDAO {

    static List<Destinatario> DestinatariosArr = new ArrayList<Destinatario>();

    public void inserir(Object obj) {
        Destinatario D = (Destinatario) obj;
        DestinatariosArr.add(D);
    }

    public void excluir(Object obj) {
        Destinatario D = (Destinatario) obj;
        boolean isDDefined = DestinatariosArr.contains(D);
        if(isDDefined){
            DestinatariosArr.remove(D);
            System.out.println("destinatário excluido com sucesso");
        }else{
            System.out.println("Destinatário desconhecido!");
        }
    }

    public void editar(Object newObj)  {
        Destinatario D = (Destinatario) newObj;
    }

    public List pesquisar() {
        return DestinatariosArr;
    }
}
