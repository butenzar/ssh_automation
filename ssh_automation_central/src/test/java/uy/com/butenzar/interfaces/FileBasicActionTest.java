/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.butenzar.interfaces;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import static org.junit.Assert.fail;
import org.junit.BeforeClass;
import org.junit.Test;
import uy.com.butenzar.datatype.DataFile;
import uy.com.butenzar.exception.UnsupportedClassTypeException;
import uy.com.butenzar.handler.CollectionFile;

/**
 *
 * @author Bruno Szilagyi
 */
public class FileBasicActionTest {

    /**
     * Implementación de la interfaz Para la coleccion de Files.
     */
    private static BasicAction basicActionFile;

    /**
     * Estructura que mantiene la colección de Files del sistema.
     */
    private static CollectionFile collectionFile;

    /**
     * Iniciación de los componentes.
     */
    @BeforeClass
    public static void oneTimeSetUp() {
        basicActionFile = Factory.getFileBasicAction();
        collectionFile = CollectionFile.getInstance();
        Logger.getLogger("BeforeClass - BasicActionTest").log(
            Level.INFO, "Se inicializan el FileBasicAction y la coleccion de "
                    + "files.");
    }

    /**
     * Caso que comprueba un Alta de File con datos correctos.
     *
     */
    @Test
    public final void testAddToFileCollection() {

        final DataFile dataFile = new DataFile("Geopos Server.log",
                "Log del servidor de Geopos");
        try {
            basicActionFile.addToCollection(dataFile);
        } catch (Exception e) {
            fail();
        }


        //Se verifica que existe el objeto.
        Assert.assertNotNull(collectionFile.getFile(dataFile.getName()));
        Logger.getLogger(getClass().getName()).log(
            Level.INFO, "Ejecución de exitosa.");
    }

    /**
     * Test of removeFromCollection method, of class BasicAction.
     */
    @Test
    public final void testRemoveFromCollection() {
        final DataFile dataFile = new DataFile("Geopos promo.log",
                "Log del servidor de Geopos");

        try {
            basicActionFile.addToCollection(dataFile);
            basicActionFile.removeFromCollection(dataFile);
        } catch (UnsupportedClassTypeException e) {
            fail();
        } finally {
          //Se verifica que no existe el objeto.
          Assert.assertNull(collectionFile.getFile(dataFile.getName()));
          Logger.getLogger(getClass().getName()).log(
            Level.INFO, "Ejecución de exitosa.");
        }

    }

    @Test
    public final void getFileCollection() {
        final DataFile dataFile = new DataFile("Geopos promo.log",
                "Log del servidor de Geopos");

        try {
            basicActionFile.addToCollection(dataFile);
        } catch (UnsupportedClassTypeException e) {
            fail();
        }

        final List<DataFile> sysFiles =
                (List<DataFile>) basicActionFile.getCollection();

        Assert.assertTrue(!sysFiles.isEmpty());

        Logger.getLogger(getClass().getName()).log(
            Level.INFO, "La lista es: " + sysFiles);
        Logger.getLogger(getClass().getName()).log(
            Level.INFO, "Ejecución de exitosa.");
    }

}
