/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.butenzar.interfaces;

import org.junit.Assert;
import static org.junit.Assert.fail;
import org.junit.Test;
import uy.com.butenzar.datatype.DataFile;
import uy.com.butenzar.exception.UnsupportedClassTypeException;
import uy.com.butenzar.handler.CollectionFile;

/**
 *
 * @author Bruno Szilagyi
 */
public class BasicActionTest {

    /**
     * Implementación de la interfaz Para la coleccion de Files.
     */
    private final transient BasicAction basicActionFile;

    /**
     * Estructura que mantiene la colección de Files del sistema.
     */
    private final transient CollectionFile collectionFile;
 
    /**
     * Constructor.
     */
    public BasicActionTest() {
        basicActionFile = Factory.getFileBasicAction();
        collectionFile = CollectionFile.getInstance();
    }

    /**
     * Caso que comprueba un Alta de File con datos correctos.
     * @throws Exception
     */
    @Test
    public final void testAddToFileCollection() throws Exception {

        final DataFile dataFile = new DataFile("Geopos Server.log",
                "Log del servidor de Geopos");

        basicActionFile.addToCollection(dataFile);

        //Se verifica que existe el objeto.
        Assert.assertNotNull(collectionFile.getFile(dataFile.getName()));

    }

    /**
     * Test of removeFromCollection method, of class BasicAction.
     */
    @Test
    public void testRemoveFromCollection() {
        final DataFile dataFile = new DataFile("Geopos promo.log",
                "Log del servidor de Geopos");

        try {
            basicActionFile.addToCollection(dataFile);
            basicActionFile.removeFromCollection(dataFile);
        }
        catch (UnsupportedClassTypeException e) {
            fail();
        }
        finally {
          //Se verifica que no existe el objeto.
          Assert.assertNull(collectionFile.getFile(dataFile.getName()));
        }

    }

}
