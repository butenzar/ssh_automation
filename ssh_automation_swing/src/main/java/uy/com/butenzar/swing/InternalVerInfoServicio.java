/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.butenzar.swing;


import java.util.List;
import javax.swing.*;
import java.util.ArrayList;
import uy.com.butenzar.util.ImagenPanel;
import uy.com.butenzar.util.SharedListSelectionListener;
import uy.com.butenzar.util.SwingComponentUtil;


/**
 *
 * @author mpi
 */
public class InternalVerInfoServicio extends javax.swing.JInternalFrame {

    DefaultListModel modelServicesAMostrar = new DefaultListModel();
    BasicAction fileBasicAction;
    SwingComponentUtil components;

    /**
     * Creates new form InternalVerInfoServicio
     */
    public InternalVerInfoServicio(String tit, DataCategory pCategory, IPublicationController pController) {

        DataService dataService;
        components = new SwingComponentUtil();

        if (pController == null) {
            publicationController = CentralServerFactory.getIPublicationController();
        } else {
            publicationController = pController;
        }

        initComponents();

        pnlSelectService.setSize(150, pnlSelectService.getHeight());
        title = tit;

        setCboCity();

        switch (title) {
            case SwingComponentUtil.CTE_TIT_SELECCIONAR_SERVICIO:
                pnlSelectService.setVisible(true);

                setEditableFilds(false);

                if (pCategory != null) {
                    List<DataService> listServices = publicationController.getServices();

                    //Para cada servicio de la categoria seleccionada anteriormente
                    for (DataService ds : listServices) {
                        for (DataCategory dc : ds.getCategoryList()) {
                            if (dc.getName().equals(pCategory.getName())) { // Se deberia controlar al insertar una categoria que no haya otra con mismo nombre??
                                modelServicesAMostrar.addElement(ds);
                                break;
                            }
                        }
                    }
                    jListServices.setModel(modelServicesAMostrar);
                    jListServices.getSelectionModel().addListSelectionListener(new SharedListSelectionListener());
                }
                break;
            case SwingComponentUtil.CTE_TIT_VER_SERVICIO:
                pnlSelectService.setVisible(false);

                setEditableFilds(false);

                dataService = publicationController.getSelectedService();
                loadData(dataService);
                break;
            case SwingComponentUtil.CTE_TIT_ACTUALIZAR_SERVICIO:

                //Panel de la izquierda con lista es visible.
                pnlSelectService.setVisible(true);

                loadServiceList();

                //////////////////////////////////
                //Los campos son editables dado que estamos en actualizar servicio.
                setEditableFilds(true);

                break;
        }
    }

    private void loadServiceList() {
        //SE carga la lista de servicios del sistema en el listado.
        List<DataService> listServices = publicationController.getServices();

        modelServicesAMostrar.removeAllElements();

        for (DataService listServiceItem : listServices) {
            modelServicesAMostrar.addElement(listServiceItem);
        }

        jListServices.setModel(modelServicesAMostrar);
    }

    private void setCboCity() {
        List<DataCity> listDataCity = publicationController.getCities();
        listDataCity.add(0, new DataCity(SwingComponentUtil.CTE_ITEM_SELECCIONAR, ""));
        cboCityO.setModel(new javax.swing.DefaultComboBoxModel(listDataCity.toArray()));
        cboCityD.setModel(new javax.swing.DefaultComboBoxModel(listDataCity.toArray()));

        cboCityO.setSelectedIndex(0);
        cboCityD.setSelectedIndex(0);

    }

    private void cleanFields() {
        txtName.setText("");
        txtProvider.setText("");
        cboCityO.setSelectedIndex(0);
        cboCityD.setSelectedIndex(0);
        txtDesc.setText("");
        txtPrecio.setText("");
        jListCategories.setModel(new DefaultListModel());
        if (pnlImg != null && pnlImg.getComponents().length > 0) {
            pnlImg.remove(0);
            pnlImg.repaint();
        }
        if (pnlImg1 != null && pnlImg1.getComponents().length > 0) {
            pnlImg1.remove(0);
            pnlImg1.repaint();
        }
        if (pnlImg3 != null && pnlImg3.getComponents().length > 0) {
            pnlImg3.remove(0);
            pnlImg3.repaint();
        }
    }

    private void loadData(DataService selectedService) {

        if (selectedService != null) {
            txtName.setText(selectedService.getName());
            txtProvider.setText(selectedService.getProviderNickname());
            cboCityO.setSelectedItem(selectedService.getFrom());
            txtDesc.setText(selectedService.getDescription());
            if (selectedService.getTo() != null) {
                cboCityD.setSelectedItem(selectedService.getTo());
            }
            txtPrecio.setText(String.valueOf(selectedService.getPrice()));

            loadCategories(selectedService);

            List<String> listImg = selectedService.getImagePathList();
            if (listImg != null && !listImg.isEmpty()) {

                ImagenPanel img1 = new ImagenPanel(listImg.get(0));
                if (pnlImg.getComponents().length > 0) {
                    pnlImg.remove(0);
                }
                pnlImg.add(img1);
                pnlImg.repaint();

                if (listImg.size() > 1) {
                    ImagenPanel img2 = new ImagenPanel(listImg.get(1));
                    if (pnlImg1.getComponents().length > 0) {
                        pnlImg1.remove(0);
                    }
                    pnlImg1.add(img2);
                    pnlImg1.repaint();
                }
                if (listImg.size() > 2) {
                    ImagenPanel img3 = new ImagenPanel(listImg.get(2));
                    if (pnlImg3.getComponents().length > 0) {
                        pnlImg3.remove(0);
                    }
                    pnlImg3.add(img3);
                    pnlImg3.repaint();
                }
            }
        }
    }

    private void setEditableFilds(Boolean editable) {
        txtName.setEditable(false); //El nombre nunca se debería poder editar
        txtProvider.setEditable(false); //El nombre de proveedor nunca se debiera poder editar.
        txtDesc.setEditable(editable);
        cboCityO.setEnabled(editable);
        cboCityD.setEnabled(editable);
        txtPrecio.setEditable(editable);
        btnUpdate.setVisible(editable);
        btnAddCat.setVisible(editable);
        btnRemCat.setVisible(editable);
        btnAddCat.setEnabled(false);
        btnRemCat.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        PanelInformacionServicio = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtProvider = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jListCategories = new javax.swing.JList();
        btnUpdate = new javax.swing.JButton();
        cboCityO = new javax.swing.JComboBox();
        cboCityD = new javax.swing.JComboBox();
        btnAddCat = new javax.swing.JButton();
        btnRemCat = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDesc = new javax.swing.JTextArea();
        pnlImg = new javax.swing.JPanel();
        pnlImg1 = new javax.swing.JPanel();
        pnlImg3 = new javax.swing.JPanel();
        pnlSelectService = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListServices = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ver Informacion Servicio");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel2.setText("Nombre");

        jLabel3.setText("Proveedor");

        jLabel4.setText("Ciudad Origen");

        jLabel5.setText("Destino");

        jLabel6.setText("Descripcion");

        jLabel7.setText("Precio");

        txtName.setEditable(false);

        txtProvider.setEditable(false);

        txtPrecio.setEditable(false);

        jLabel8.setText("Categorias");

        jListCategories.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        btnUpdate.setText("Actualizar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        cboCityO.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboCityD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAddCat.setText("Agregar");
        btnAddCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCatActionPerformed(evt);
            }
        });

        btnRemCat.setText("Quitar");
        btnRemCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemCatActionPerformed(evt);
            }
        });

        txtDesc.setColumns(20);
        txtDesc.setRows(5);
        jScrollPane2.setViewportView(txtDesc);

        javax.swing.GroupLayout pnlImgLayout = new javax.swing.GroupLayout(pnlImg);
        pnlImg.setLayout(pnlImgLayout);
        pnlImgLayout.setHorizontalGroup(
            pnlImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 153, Short.MAX_VALUE)
        );
        pnlImgLayout.setVerticalGroup(
            pnlImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 153, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlImg1Layout = new javax.swing.GroupLayout(pnlImg1);
        pnlImg1.setLayout(pnlImg1Layout);
        pnlImg1Layout.setHorizontalGroup(
            pnlImg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 153, Short.MAX_VALUE)
        );
        pnlImg1Layout.setVerticalGroup(
            pnlImg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 153, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlImg3Layout = new javax.swing.GroupLayout(pnlImg3);
        pnlImg3.setLayout(pnlImg3Layout);
        pnlImg3Layout.setHorizontalGroup(
            pnlImg3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 142, Short.MAX_VALUE)
        );
        pnlImg3Layout.setVerticalGroup(
            pnlImg3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 144, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelInformacionServicioLayout = new javax.swing.GroupLayout(PanelInformacionServicio);
        PanelInformacionServicio.setLayout(PanelInformacionServicioLayout);
        PanelInformacionServicioLayout.setHorizontalGroup(
            PanelInformacionServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInformacionServicioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelInformacionServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelInformacionServicioLayout.createSequentialGroup()
                        .addGroup(PanelInformacionServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(92, 92, 92)
                        .addGroup(PanelInformacionServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelInformacionServicioLayout.createSequentialGroup()
                                .addGroup(PanelInformacionServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtProvider, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboCityO, 0, 214, Short.MAX_VALUE))
                                .addGap(40, 40, 40)
                                .addGroup(PanelInformacionServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(PanelInformacionServicioLayout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelInformacionServicioLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cboCityD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(PanelInformacionServicioLayout.createSequentialGroup()
                                .addComponent(jListCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(PanelInformacionServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnRemCat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAddCat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2))
                        .addContainerGap(43, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInformacionServicioLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(PanelInformacionServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInformacionServicioLayout.createSequentialGroup()
                                .addComponent(pnlImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(pnlImg1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(pnlImg3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInformacionServicioLayout.createSequentialGroup()
                                .addComponent(btnUpdate)
                                .addGap(307, 307, 307))))))
        );
        PanelInformacionServicioLayout.setVerticalGroup(
            PanelInformacionServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInformacionServicioLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(PanelInformacionServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(24, 24, 24)
                .addGroup(PanelInformacionServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelInformacionServicioLayout.createSequentialGroup()
                        .addGroup(PanelInformacionServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtProvider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelInformacionServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(cboCityO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboCityD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelInformacionServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelInformacionServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jListCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(PanelInformacionServicioLayout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(btnAddCat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemCat)))
                .addGap(18, 18, 18)
                .addGroup(PanelInformacionServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlImg1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlImg3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btnUpdate)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jListServices.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jListServices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListServicesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListServices);

        jLabel1.setText("Seleccione un Servicio");

        javax.swing.GroupLayout pnlSelectServiceLayout = new javax.swing.GroupLayout(pnlSelectService);
        pnlSelectService.setLayout(pnlSelectServiceLayout);
        pnlSelectServiceLayout.setHorizontalGroup(
            pnlSelectServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelectServiceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSelectServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSelectServiceLayout.setVerticalGroup(
            pnlSelectServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelectServiceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlSelectService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelInformacionServicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlSelectService, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelInformacionServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 28, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadCategories(DataService dataS) {
        List<DataCategory> listCategory = dataS.getCategoryList();

        DefaultListModel modelListCategory = new DefaultListModel();

        for (DataCategory dc : listCategory) {
            modelListCategory.addElement(dc);
        }

        jListCategories.setModel(modelListCategory);
    }


    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        try {

            GeneralUtil.notNullOrEmpty(txtDesc.getText(), "La descripción del servicio es requerida");
            GeneralUtil.notNullOrEmpty(txtPrecio.getText(), "El precio del servicio es requerido");

            float serviceAmount = GeneralUtil.generalConverter(txtPrecio.getText(), "El monto ingresado no tiene formato correcto", Double.class).floatValue();
            if (serviceAmount <= 0F) {
                throw new IllegalArgumentException("El precio del servicio debe ser positivo");
            }

            DataCity from = (DataCity) cboCityO.getSelectedItem();
            if (from.getName().contains(SwingComponentUtil.CTE_ITEM_SELECCIONAR)) {
                from = null;
            }
            GeneralUtil.notNullOrEmpty(from, "Se debe haber seleccionado una ciudad de origen.");

            DataCity to = (DataCity) cboCityD.getSelectedItem();
            if (to.getName().contains(SwingComponentUtil.CTE_ITEM_SELECCIONAR)) {
                to = null;
            }

            List<DataCategory> listCategory = new ArrayList<>();
            for (int i = 0; i < jListCategories.getModel().getSize(); i++) {
                listCategory.add((DataCategory) jListCategories.getModel().getElementAt(i));
            }

            publicationController.updateService(txtDesc.getText(), publicationController.getSelectedService().getImagePathList(),
                    serviceAmount, from, to, listCategory);
            components.infoBox("El servicio se actualizó correctamente", "Éxito");
            cleanFields();
            loadServiceList();
        } catch (IllegalArgumentException e) {
            components.errorBox(e.getMessage(), "Alerta");

        } catch (Exception e) {
            components.errorBox(GeneralUtil.GENERIC_ERROR_MSG, "Alerta");

        }


    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jListServicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListServicesMouseClicked
        try {
            if (evt.getClickCount() == 2) {
                if (title.equals(SwingComponentUtil.CTE_TIT_ACTUALIZAR_SERVICIO)) {

                    DataService selectedService = (DataService) jListServices.getSelectedValue();
                    if (selectedService != null) {
                        publicationController.selectedService(selectedService);
                    }

                    cleanFields();
                    loadData(selectedService);

                    btnAddCat.setEnabled(true);
                    btnRemCat.setEnabled(true);

                } else if (title.equals(SwingComponentUtil.CTE_TIT_SELECCIONAR_SERVICIO)) {
                    DataService selectedService = (DataService) jListServices.getSelectedValue();

                    cleanFields();
                    loadData(selectedService);
                }
            }
        } catch (IllegalArgumentException e) {
            components.errorBox(e.getMessage(), "Alerta");

        } catch (Exception e) {
            components.errorBox(GeneralUtil.GENERIC_ERROR_MSG, "Alerta");

        }
    }//GEN-LAST:event_jListServicesMouseClicked

    private void btnRemCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemCatActionPerformed
        try {

            DataCategory selectedCat = (DataCategory) jListCategories.getSelectedValue();
            if (selectedCat == null) {
                components.errorBox("Debe seleccionar una categoria para eliminarla", "Alerta");
                return;
            } else {
                DefaultListModel model = (DefaultListModel) jListCategories.getModel();
                List<DataCategory> listCategory = jListCategories.getSelectedValuesList();
                for (DataCategory dc : listCategory) {
                    if (selectedCat.equals(dc)) {
                        model.removeElement(dc);
                        break;
                    }
                }
            }

        } catch (IllegalArgumentException e) {
            components.errorBox(e.getMessage(), "Alerta");

        } catch (Exception e) {
            components.errorBox(GeneralUtil.GENERIC_ERROR_MSG, "Alerta");

        }
    }//GEN-LAST:event_btnRemCatActionPerformed

    private void btnAddCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCatActionPerformed
        try {
            List<DataCategory> listCategoryOnService = new ArrayList<>();
            DefaultListModel modelListCategory = null;

            ICategoryController categoryController = CentralServerFactory.getICategoryController();
            List<DataCategory> listCategoryOnSystem = categoryController.getCategories();

            if (listCategoryOnSystem != null && !listCategoryOnSystem.isEmpty()) {

                modelListCategory = (DefaultListModel) jListCategories.getModel();
                List<DataCategory> listCategory = new ArrayList<>();
                for (int i = 0; i < jListCategories.getModel().getSize(); i++) {
                    DataCategory dataCate = (DataCategory)jListCategories.getModel().getElementAt(i);
                    listCategoryOnService.add(dataCate);
                    listCategoryOnSystem.remove(dataCate);
                }
            }

            Object[] list = listCategoryOnSystem.toArray();
            JComboBox jcb = new JComboBox(list);
            jcb.setEditable(false);
            JOptionPane.showMessageDialog(null, jcb, "Seleccione una categoría", JOptionPane.QUESTION_MESSAGE);

            DataCategory dataCategorySelected = (DataCategory) jcb.getSelectedItem();
            if (dataCategorySelected != null && modelListCategory != null) {
                for (DataCategory dc : listCategoryOnService) {
                    if (dataCategorySelected.equals(dc)) {
                        components.errorBox("La categoría seleccionada ya se encuentra en el servicio", "Alerta");
                        break;
                    }
                }
                modelListCategory.addElement(dataCategorySelected);
            }

        } catch (IllegalArgumentException e) {
            components.errorBox(e.getMessage(), "Alerta");

        } catch (Exception e) {
            components.errorBox(GeneralUtil.GENERIC_ERROR_MSG, "Alerta");

        }
    }//GEN-LAST:event_btnAddCatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelInformacionServicio;
    private javax.swing.JButton btnAddCat;
    private javax.swing.JButton btnRemCat;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cboCityD;
    private javax.swing.JComboBox cboCityO;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList jListCategories;
    private javax.swing.JList jListServices;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pnlImg;
    private javax.swing.JPanel pnlImg1;
    private javax.swing.JPanel pnlImg3;
    private javax.swing.JPanel pnlSelectService;
    private javax.swing.JTextArea txtDesc;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProvider;
    // End of variables declaration//GEN-END:variables
}
