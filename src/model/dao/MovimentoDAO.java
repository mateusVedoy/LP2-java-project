package model.dao;

import model.Movimento;

import java.util.ArrayList;
import java.util.List;

public class MovimentoDAO {

    static List<Movimento> MovimentoArr = new ArrayList<Movimento>();

    public void criar(Object obj){
        Movimento M = (Movimento) obj;
        MovimentoArr.add(M);
    }
}
