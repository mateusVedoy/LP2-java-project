package model.dao;

import java.sql.SQLException;
import java.util.List;
/*
 * OperacoesDAO.java
 *
 * Created on 16 de Outubro de 2006, 21:21
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author kborges
 */
public interface OperacoesDAO {
    
    public void criar(Object obj);
    
    public void deletar(Object obj);

    public void editar(Object obj, Object newObj);

    public List listarTodos();

    public Object listarObjeto(Object obj);
    
}
