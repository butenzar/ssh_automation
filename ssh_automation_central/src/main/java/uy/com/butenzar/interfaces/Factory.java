package uy.com.butenzar.interfaces;

import uy.com.butenzar.controller.FileBasicAction;
import uy.com.butenzar.controller.JschSshAction;

/**
 *
 * @author Bruno Szilagyi
 */
public final class Factory {

    private static Factory instance = null;

    /**
     * Constructor.
     */
    private Factory() {

    };

    /**
     * Se obtiene una instancia de JschSshAction.
     * @return
     */
    public static SshAction getJschSshAction() {
        return new JschSshAction();
    }

    /**
     * Se obtiene una instancia de FileBasicAction.
     * @return
     */
    public static BasicAction getFileBasicAction() {
        return new FileBasicAction();
    }
    
    /**
     *
     * @return la instancia única de Factory
     */
    public static Factory getInstance() {

        // Lazy initialization - Singleton
        if (instance == null) {
            instance = new Factory();
        }

        return instance;
    }
}
