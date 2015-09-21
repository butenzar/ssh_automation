/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.butenzar.interfaces;

import java.util.List;
import uy.com.butenzar.exception.UnsupportedClassTypeException;

/**
 *
 * @author Bruno Szilagyi
 */
public interface BasicAction {

    /**
     * Añade el objeto a la colección del sistema que pertenece.
     * @param objToAdd
     * @throws UnsupportedClassTypeException
     */
    void addToCollection(Object objToAdd) throws UnsupportedClassTypeException;

    /**
     * Remueve el objeto de la colección del sistema a la cual pertenece.
     * @param objToRemove
     */
    void removeFromCollection(Object objToRemove) throws UnsupportedClassTypeException;

    /**
     * Retorna la DataCollection acorde a quien lo implemente.
     * @return
     */
    List<?> getCollection();
}
