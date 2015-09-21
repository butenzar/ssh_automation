/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.butenzar.handler;


import junit.framework.Assert;
import org.junit.Test;
import uy.com.butenzar.common.File;
import uy.com.butenzar.common.FileNode;
import uy.com.butenzar.common.Node;

/**
 *
 * @author Bruno Szilagyi
 */
public class NodeHandlerTest {

    /**
     * Handler de Nodos.
     */
    private static final CollectionNode NODEHANDLER = CollectionNode.getInstance();
    /**
     * Identificador del nodo 99.
     */
    private static final Integer NODEID = 99;
    private static final String NODEHOST = "192.168.250.49";

    /**
     * Constructor.
     */
    public NodeHandlerTest() {

        //Provisorio

        final Node node99 = new Node();
        node99.setIdentifier(NODEID);
        node99.setDescription("Local 99 ambiente QA GEOCOM");
        node99.setHost(NODEHOST);
        node99.setName("Local 99");
        node99.setParentNode(null);


        final File file1 = new File();
        file1.setName("server.log");
        file1.setDescription("Server log de Jboss - BackOffice");

        final FileNode fileNodeAssociation =
                new FileNode(file1, node99, "Home/geocom");

        file1.addNodeAsociation(fileNodeAssociation);
        node99.addFileAssociation(fileNodeAssociation);

        NODEHANDLER.addNode(node99);

    }

    /**
     * Test of addNode method, of class CollectionNode.
     */
    @Test
    public void testAddNode() {
    }

    /**
     * Test of getNode method, of class CollectionNode.
     */
    @Test
    public final void testGetNode() {
        final Node nodeResult = NODEHANDLER.getNode(NODEHOST, NODEID);

        Assert.assertEquals(NODEID, nodeResult.getIdentifier());
        Assert.assertEquals(NODEHOST, nodeResult.getHost());
    }

    /**
     * Test of getNodeList method, of class CollectionNode.
     */
    @Test
    public final void testGetNodeList() {
        Assert.assertNotNull(NODEHANDLER.getNodeList());
    }

    /**
     * Test of getInstance method, of class CollectionNode.
     */
    @Test
    public final void testGetInstance() {
       Assert.assertEquals(CollectionNode.getInstance(),
               CollectionNode.getInstance());
    }

}
