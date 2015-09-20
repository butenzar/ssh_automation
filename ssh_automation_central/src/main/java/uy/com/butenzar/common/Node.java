package uy.com.butenzar.common;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Bruno Szilagyi
 */
public class Node {

    private Integer identifier;
    private String name;
    private String description;
    private String host;

    /**
     * Asociación con los archivos.
     */
    private final List<FileNode> fileAssociationList;

    /**
     * Lista de nodos hijos.
     */
    private final List<Node> childNodeList;
    private Node parentNode;

    public Node(){
        this.fileAssociationList = new ArrayList<>();
        this.childNodeList = new ArrayList<>();
        this.parentNode = null;
    }

    @Override
    public String toString() {
        return this.name + " - " + this.host;
    }

    /**
     * Se añade la asociación de archivo nodo.
     * @param fileAssociation
     */
    public void addFileAssociation(FileNode fileAssociation){
        fileAssociationList.add(fileAssociation);
    }

    public void addChildNode(Node childNodeToAdd){
        childNodeList.add(childNodeToAdd);
    }

    /**
     * @return the identifier
     */
    public Integer getIdentifier() {
        return identifier;
    }

    /**
     * @param identifier the identifier to set
     */
    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }


    /**
     * @return the parentNode
     */
    public Node getParentNode() {
        return parentNode;
    }

    /**
     * @param parentNode the parentNode to set
     */
    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    /**
     * @return the childNodeList
     */
    public List<Node> getChildNodeList() {
        return childNodeList;
    }


}
