/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.butenzar.common;

/**
 *
 * @author Bruno Szilagyi
 */
public class FileNode {

    /**
     * Archivo de la asociación.
     */
    private File asociatedFile;

    /**
     * Nodo de la asociación.
     */
    private Node asociatedNode;

    /**
     * Refiere a la ubicación del archivo dentro del nodo asociado.
     */
    private String filePathInNode;

    /**
     * Constructor.
     * @param asociatedFileIn
     * @param asociatedNodeIn
     * @param filePathInNodeIn
     */
    public FileNode(final File asociatedFileIn, final Node asociatedNodeIn,
            final String filePathInNodeIn) {

        this.asociatedFile = asociatedFileIn;
        this.asociatedNode = asociatedNodeIn;
        this.filePathInNode = filePathInNodeIn;
    }
    /**
     * @return the asociatedFile
     */
    public final File getAsociatedFile() {
        return asociatedFile;
    }

    /**
     * @param asociatedFileIn the asociatedFile to set
     */
    public final void setAsociatedFile(final File asociatedFileIn) {
        this.asociatedFile = asociatedFileIn;
    }

    /**
     * @return the asociatedNode
     */
    public final Node getAsociatedNode() {
        return asociatedNode;
    }

    /**
     * @param asociatedNodeIn the asociatedNode to set
     */
    public final void setAsociatedNode(final Node asociatedNodeIn) {
        this.asociatedNode = asociatedNodeIn;
    }

    /**
     * @return the filePathInNode
     */
    public final String getFilePathInNode() {
        return filePathInNode;
    }

    /**
     * @param filePathInNodeIn the filePathInNode to set
     */
    public final void setFilePathInNode(final String filePathInNodeIn) {
        this.filePathInNode = filePathInNodeIn;
    }
}
