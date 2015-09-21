/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.butenzar.datatype;

/**
 *
 * @author Bruno Szilagyi
 */
public class DataFile {
    private final String name;
    private final String description;
 
    /**
     * Constructor.
     * @param nameIn
     * @param descIn
     */
    public DataFile(final String nameIn, final String descIn) {
        this.name = nameIn;
        this.description = descIn;
    }

    /**
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * @return the description
     */
    public final String getDescription() {
        return description;
    }
}
