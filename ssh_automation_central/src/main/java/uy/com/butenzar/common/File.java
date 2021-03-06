package uy.com.butenzar.common;

import java.util.ArrayList;
import java.util.List;
import uy.com.butenzar.datatype.DataFile;

/**
 *
 * @author Bruno Szilagyi
 */
public class File {

    /**
     * Nombre del archivo.
     */
    private String name;

    /**
     * Descripción del archivo.
     */
    private String description;

    private final List<FileNode> nodeAssociationList;

    /**
     * Constructor
     */
    public File(){
        nodeAssociationList = new ArrayList<>();
    }

    /**
     * Crea y retorna un DataFile a partir de los datos del Objecto.
     * @return
     */
    public DataFile toData(){
        return new DataFile(this.name, this.description);
    }
    
    public void addNodeAsociation(FileNode nodeToAsociate){
        nodeAssociationList.add(nodeToAsociate);
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
     * @return the nodeAssociationList
     */
    public List<FileNode> getNodeAssociationList() {
        return nodeAssociationList;
    }
}
