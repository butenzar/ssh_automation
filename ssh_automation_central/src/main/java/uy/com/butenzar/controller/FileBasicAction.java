/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.butenzar.controller;

import java.util.ArrayList;
import java.util.List;
import uy.com.butenzar.common.File;
import uy.com.butenzar.datatype.DataFile;
import uy.com.butenzar.exception.UnsupportedClassTypeException;
import uy.com.butenzar.handler.CollectionFile;
import uy.com.butenzar.interfaces.BasicAction;

/**
 *
 * @author Bruno Szilagyi
 */
public class FileBasicAction implements BasicAction{

    private final CollectionFile collectionFile;

    /**
     * Constructor.
     */
    public FileBasicAction() {
        collectionFile = CollectionFile.getInstance();
    }

    @Override
    public final void addToCollection(final Object objToAdd)
    throws UnsupportedClassTypeException {
        if (objToAdd instanceof DataFile) {

            final DataFile dataFile = (DataFile) objToAdd;
            final File fileToAdd = new File();

            //TODO añadir validaciones sobre los campos del DATAFILE.

            fileToAdd.setName(dataFile.getName());
            fileToAdd.setDescription(dataFile.getDescription());

            collectionFile.addFile(fileToAdd);
        } else {
            throw new UnsupportedClassTypeException("Solamente se soporta"
                    + " el tipo DataFile");
        }
    }

    @Override
    public final void removeFromCollection(final Object objToRemove)
    throws UnsupportedClassTypeException {
        if (objToRemove instanceof DataFile) {
            DataFile dataFileToRem = (DataFile) objToRemove;
            
            collectionFile.removeFile(dataFileToRem.getName());
            
            //TODO remover las asociaciones archivo-nodo.
            
        } else {
            throw new UnsupportedClassTypeException("Solamente se soporta"
                    + " el tipo DataFile");
        }
    }

    @Override
    public List<?> getCollection() {

        List<DataFile> retList = new ArrayList<>();

        collectionFile.getFileList().stream().
                forEach(file -> retList.add(file.toData()));

        return retList;
    }


}
