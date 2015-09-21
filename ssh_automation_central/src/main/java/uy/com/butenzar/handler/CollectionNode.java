/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.butenzar.handler;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import uy.com.butenzar.common.Node;

/**
 *
 * @author Bruno Szilagyi
 */
public class CollectionNode {

    private static CollectionNode instance = null;
    private final Map<String,Node> nodesMap;

    /**
     * Constructor.
     */
    private CollectionNode(){
        nodesMap = new HashMap<>();
    }

    /**
     * Se añade el nodo al mapa con la clave id+host
     * @param nodeToAdd
     */
    public void addNode(Node nodeToAdd){
        String key = nodeToAdd.getIdentifier().toString() + nodeToAdd.getHost();

        nodesMap.put(key, nodeToAdd);
    }

    /**
     * Se obtiene el nodo a partir de los parámetros.
     * @param host
     * @param id
     * @return
     */
    public Node getNode(String host, Integer id){
        String key = id.toString() + host;

        return nodesMap.get(key);
    }

    /**
     * Retorna todos los Nodes en el sistema.
     * @return
     */
    public Collection<Node> getNodeList(){
        return nodesMap.values();
    }

    /**
     *
     * @return la instancia única de CollectionNode
     */
    public static CollectionNode getInstance() {

        // Lazy initialization - Singleton
        if(instance == null){
            instance = new CollectionNode();
        }

        return instance;
    }
}
