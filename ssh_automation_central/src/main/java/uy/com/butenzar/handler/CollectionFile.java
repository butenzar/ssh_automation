/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.butenzar.handler;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import uy.com.butenzar.common.File;

/**
 *
 * @author Bruno Szilagyi
 */
public class CollectionFile {
    private static CollectionFile instance = null;
    private final Map<String,File> fileMap;


    /**
     * Constructor.
     */
    private CollectionFile(){
        fileMap = new HashMap<>();
    }

    /**
     * Se añade el file al mapa con la clave name
     * @param fileToAdd
     */
    public void addFile(File fileToAdd){
        String key = fileToAdd.getName();

        fileMap.put(key, fileToAdd);
    }

    /**
     * Remueve el archivo del mapa.
     * @param fileToRemove
     */
    public void removeFile(String objKey){
       fileMap.remove(objKey);
    }

    /**
     * Se obtiene el archivo a partir de su nombre.
     * @param name
     * @return
     */
    public File getFile(final String name){
        String key = name;

        return fileMap.get(key);
    }

    /**
     * Retorna todos los File en el sistema.
     * @return
     */
    public Collection<File> getFileList(){
        return fileMap.values();
    }

    /**
     *
     * @return la instancia única de CollectionNode
     */
    public static CollectionFile getInstance() {

        // Lazy initialization - Singleton
        if(instance == null){
            instance = new CollectionFile();
        }

        return instance;
    }
}
