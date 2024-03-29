package vista;

import controlador.Controlador_cuidadores;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Guias;
import controlador.Controlador_guias;
import java.util.Date;
import modelo.Cuidadores;
/**
 * Frame Guia_vista que me permite visualizar gráficamente el crud de la clase Guias
 *
 * @author Diego
 * @version 1.0
 */
public class Guia_vista extends javax.swing.JInternalFrame {
/**
 * Variables globales
 */
    int mod;
    private List<Guias> tareas;
    private static int bandera_encontrado = 0;
    private static int bandera_buscar = 0;
    public static int bandera_guia_orden = 0;
    private static int bandera_crear_editar = 0;
/**
 * Constructor del Frame
 */
    public Guia_vista() {
        initComponents();
        txtDe.setEditable(false);
        txtNc.setEditable(false);
        txtNe.setEditable(false);
        dt_fechaIn.setEnabled(false);
        elemento_guardar.setEnabled(false);
        btn_cancelar.setEnabled(false);
        this.cargar_lista_de_tareas();

    }
/**
 * Método que me permite cargar en una tabla los datos de los guías
 */
    private void cargar_lista_de_tareas() {
        try {

            this.tareas = Controlador_guias.cargarArbol();
            DefaultTableModel dtm = (DefaultTableModel) elemento_tabla.getModel();
            dtm.setRowCount(0);
            for (int i = 0; i < this.tareas.size(); i++) {
                String mes = "";
                String dia = "";
                if ((this.tareas.get(i).getFechaIn().getMonth() + 1) < 10) {
                    mes = "0" + (this.tareas.get(i).getFechaIn().getMonth() + 1);
                } else {
                    mes = "" + (this.tareas.get(i).getFechaIn().getMonth() + 1);
                }
                if (this.tareas.get(i).getFechaIn().getDate() < 10) {
                    dia = "0" + this.tareas.get(i).getFechaIn().getDate();
                } else {
                    dia = "" + this.tareas.get(i).getFechaIn().getDate();
                }
                dtm.addRow(new Object[]{
                    this.tareas.get(i).getNombre(),
                    this.tareas.get(i).getDireccion(),
                    this.tareas.get(i).getTelf(),
                    (this.tareas.get(i).getFechaIn().getYear() + 1900)
                    + "-" + mes
                    + "-" + dia

                });
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Ha surgido un error");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButton1 = new javax.swing.JRadioButton();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jLabel5 = new javax.swing.JLabel();
        btnbuscar = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        elemento_tabla = new javax.swing.JTable();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNe = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        elemento_guardar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        txtDe = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        dt_fechaIn = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        cb_ordenar = new javax.swing.JComboBox();
        cb_crud = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        jLabel5.setText("Busqueda por");

        setClosable(true);
        setIconifiable(true);
        setTitle("Guías");
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        elemento_tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre del guía", "Dirección", "Teléfono", "Fecha Ingreso"
            }
        ));
        jScrollPane1.setViewportView(elemento_tabla);

        jTabbedPane1.addTab("Listado", jScrollPane1);

        jLabel1.setText("Nombre del Guía");

        jLabel2.setText("Dirección");

        jLabel4.setText("Teléfono");

        elemento_guardar.setText("Guardar");
        elemento_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elemento_guardarActionPerformed(evt);
            }
        });

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        jLabel8.setText("Fecha");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dt_fechaIn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDe)
                            .addComponent(txtNc, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(elemento_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(125, 125, 125))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dt_fechaIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(elemento_guardar)
                    .addComponent(btn_cancelar))
                .addGap(237, 237, 237))
        );

        jTabbedPane2.addTab("Insertar/Modificar", jPanel1);

        jLabel3.setText("Nombre del Guía:");

        cb_ordenar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "nombre Ascendente", "nombre Descendente", "dirección Ascendente", "dirección Descendente" }));
        cb_ordenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ordenarActionPerformed(evt);
            }
        });

        cb_crud.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Crear", "Editar", "Listar", "Eliminar" }));
        cb_crud.setSelectedIndex(2);
        cb_crud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_crudActionPerformed(evt);
            }
        });

        jLabel6.setText("Ordenar por:");

        jLabel7.setText("¿Qué operación desea realizar?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cb_ordenar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_crud, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnbuscar)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_ordenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_crud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed

        try {

            bandera_encontrado = 0;
            if (!txtbuscar.getText().isEmpty()) {
                bandera_buscar = 1;
                this.tareas = Controlador_guias.recuperarPorId(txtbuscar.getText());
                if (!tareas.isEmpty()) {
                    bandera_encontrado = 1;

                    DefaultTableModel dtm = (DefaultTableModel) elemento_tabla.getModel();
                    dtm.setRowCount(0);
                    for (int i = 0; i < this.tareas.size(); i++) {
                        String mes = "";
                        String dia = "";
                        if ((this.tareas.get(i).getFechaIn().getMonth() + 1) < 10) {
                            mes = "0" + (this.tareas.get(i).getFechaIn().getMonth() + 1);
                        } else {
                            mes = "" + (this.tareas.get(i).getFechaIn().getMonth() + 1);
                        }
                        if (this.tareas.get(i).getFechaIn().getDate() < 10) {
                            dia = "0" + this.tareas.get(i).getFechaIn().getDate();
                        } else {
                            dia = "" + this.tareas.get(i).getFechaIn().getDate();
                        }
                        dtm.addRow(new Object[]{
                            this.tareas.get(i).getNombre(),
                            this.tareas.get(i).getDireccion(),
                            this.tareas.get(i).getTelf(),
                            (this.tareas.get(i).getFechaIn().getYear() + 1900)
                            + "-" + mes
                            + "-" + dia

                        });
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha encontrado ninguna coincidencia\nPuede insertar la nueva especie ahora");
                }

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
        }


    }//GEN-LAST:event_btnbuscarActionPerformed

    private void elemento_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elemento_guardarActionPerformed
        try {
            if (mod == 1) {
                if (dt_fechaIn.getDate() != null) {
                    Controlador_guias.editar(txtNe.getText(), txtNc.getText(), txtDe.getText(), dt_fechaIn.getDate());
                    System.out.println(txtNe.getText());
                    txtNe.setText("");
                    txtNc.setText("");
                    txtDe.setText("");
                    dt_fechaIn.setDate(null);
                    txtDe.setEditable(false);
                    txtNc.setEditable(false);
                    txtNe.setEditable(false);
                    dt_fechaIn.setEnabled(false);
                    elemento_guardar.setEnabled(false);
                    btn_cancelar.setEnabled(false);
                    cb_crud.setEnabled(true);
                    bandera_crear_editar = 0;
                    cargar_lista_de_tareas();
                } else {
                    JOptionPane.showMessageDialog(null, "No deje el campo de fecha vacio");
                }

            } else {
                if (!txtNe.getText().isEmpty() && dt_fechaIn.getDate() != null) {

                    int ban_repetido = 0;
                    this.tareas = Controlador_guias.cargarArbol();
                    for (Guias tarea : tareas) {

                        if (txtNe.getText().equalsIgnoreCase(tarea.getNombre())) {

                            ban_repetido = 1;
                        }
                    }
                    if (ban_repetido == 0) {
                        List<Cuidadores> listaCuidadores;
                        int ban_cuidador_existe = 0;
                        listaCuidadores = Controlador_cuidadores.cargarArbol();
                        for (Cuidadores listaCuidadore : listaCuidadores) {
                            if (listaCuidadore.getNombre().equalsIgnoreCase(txtNe.getText())) {
                                ban_cuidador_existe = 1;
                            }
                        }
                        if (ban_cuidador_existe == 0) {
                            this.guardar();
                            txtNe.setText("");
                            txtNc.setText("");
                            txtDe.setText("");
                            dt_fechaIn.setDate(null);
                            txtDe.setEditable(false);
                            txtNc.setEditable(false);
                            txtNe.setEditable(false);
                            dt_fechaIn.setEnabled(false);
                            elemento_guardar.setEnabled(false);
                            btn_cancelar.setEnabled(false);
                            cb_crud.setEnabled(true);
                            bandera_crear_editar = 0;
                        } else {
                            JOptionPane.showMessageDialog(null, "Este empleado ya existe y es un Cuidador");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "El guía ya existe");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese el nombre y la fecha al menos");
                }

            }
        } catch (Exception e) {
        }


    }//GEN-LAST:event_elemento_guardarActionPerformed

    private void cb_crudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_crudActionPerformed
        try {
            switch (cb_crud.getSelectedItem().toString()) {
                case "Crear":

                    if (bandera_encontrado == 0 && bandera_buscar == 1) {
                        txtDe.setEditable(true);
                        txtNc.setEditable(true);
                        txtNe.setEditable(true);
                        dt_fechaIn.setEnabled(true);
                        elemento_guardar.setEnabled(true);
                        btn_cancelar.setEnabled(true);
                        elemento_guardar.setText("Insertar");
                        cb_crud.setEnabled(false);
                        bandera_buscar = 0;
                        bandera_crear_editar = 1;
                        mod = 0;
                    }

                    break;
                case "Editar":

                    if (bandera_encontrado == 1 && bandera_buscar == 1) {

                        txtNc.setEditable(true);
                        txtDe.setEditable(true);
                        dt_fechaIn.setEnabled(true);

                        elemento_guardar.setEnabled(true);
                        elemento_guardar.setText("Guardar");
                        btn_cancelar.setEnabled(true);
                        cb_crud.setEnabled(false);

                        Guias es = this.tareas.get(0);

                        txtNe.setText(es.getNombre());
                        txtNc.setText(es.getDireccion());
                        txtDe.setText(es.getTelf());
                        dt_fechaIn.setDate(es.getFechaIn());
                        mod = 1;
                        bandera_buscar = 0;
                        bandera_crear_editar = 1;
                    }

                    break;
                case "Listar":
                    this.cargar_lista_de_tareas();

                    bandera_buscar = 0;
                    break;

                case "Eliminar":
                    if (bandera_encontrado == 1 && bandera_buscar == 1) {

                        String idc = (String) elemento_tabla.getValueAt(0, 0);

                        tareas = Controlador_guias.eliminar(idc);
                        DefaultTableModel dtm = (DefaultTableModel) elemento_tabla.getModel();
                        dtm.setRowCount(0);
                        for (int i = 0; i < this.tareas.size(); i++) {
                            String mes = "";
                            String dia = "";
                            if ((this.tareas.get(i).getFechaIn().getMonth() + 1) < 10) {
                                mes = "0" + (this.tareas.get(i).getFechaIn().getMonth() + 1);
                            } else {
                                mes = "" + (this.tareas.get(i).getFechaIn().getMonth() + 1);
                            }
                            if (this.tareas.get(i).getFechaIn().getDate() < 10) {
                                dia = "0" + this.tareas.get(i).getFechaIn().getDate();
                            } else {
                                dia = "" + this.tareas.get(i).getFechaIn().getDate();
                            }
                            dtm.addRow(new Object[]{
                                this.tareas.get(i).getNombre(),
                                this.tareas.get(i).getDireccion(),
                                this.tareas.get(i).getTelf(),
                                (this.tareas.get(i).getFechaIn().getYear() + 1900)
                                + "-" + mes
                                + "-" + dia

                            });
                        }
                    }

                    bandera_buscar = 0;
                    break;
                default:
                    bandera_buscar = 0;
                    System.out.println("Listar");
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_cb_crudActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        txtNe.setText("");
        txtNc.setText("");
        txtDe.setText("");
        dt_fechaIn.setEnabled(true);
        txtDe.setEditable(false);
        txtNc.setEditable(false);
        txtNe.setEditable(false);
        dt_fechaIn.setEnabled(false);
        elemento_guardar.setEnabled(false);
        btn_cancelar.setEnabled(false);
        cb_crud.setEnabled(true);
        bandera_crear_editar = 0;

        cargar_lista_de_tareas();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void cb_ordenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ordenarActionPerformed
        switch (cb_ordenar.getSelectedItem().toString()) {

            case "nombre Ascendente":
                try {
                    //revisar si ocurre bug en el ordenamiento es por esta condición
                    if ((bandera_buscar == 0 || bandera_encontrado == 0) && bandera_crear_editar == 0) {

                        this.tareas = Controlador_guias.ordenarAsc();
                    }

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
                }
                break;
            case "nombre Descendente":

                try {
                    if ((bandera_buscar == 0 || bandera_encontrado == 0) && bandera_crear_editar == 0) {
                        this.tareas = Controlador_guias.ordenarDes();
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
                }
                break;
            case "dirección Ascendente":
                if ((bandera_buscar == 0 || bandera_encontrado == 0) && bandera_crear_editar == 0) {
                    bandera_guia_orden = 1;
                    this.tareas = Controlador_guias.ordenarAsc();
                    bandera_guia_orden = 0;
                }
                break;
            case "dirección Descendente":
                if ((bandera_buscar == 0 || bandera_encontrado == 0) && bandera_crear_editar == 0) {
                    bandera_guia_orden = 1;
                    this.tareas = Controlador_guias.ordenarDes();
                    bandera_guia_orden = 0;
                }
                break;
            default:

        }
        DefaultTableModel dtm = (DefaultTableModel) elemento_tabla.getModel();
        dtm.setRowCount(0);
        for (int i = 0; i < this.tareas.size(); i++) {
            String mes = "";
            String dia = "";
            if ((this.tareas.get(i).getFechaIn().getMonth() + 1) < 10) {
                mes = "0" + (this.tareas.get(i).getFechaIn().getMonth() + 1);
            } else {
                mes = "" + (this.tareas.get(i).getFechaIn().getMonth() + 1);
            }
            if (this.tareas.get(i).getFechaIn().getDate() < 10) {
                dia = "0" + this.tareas.get(i).getFechaIn().getDate();
            } else {
                dia = "" + this.tareas.get(i).getFechaIn().getDate();
            }
            dtm.addRow(new Object[]{
                this.tareas.get(i).getNombre(),
                this.tareas.get(i).getDireccion(),
                this.tareas.get(i).getTelf(),
                (this.tareas.get(i).getFechaIn().getYear() + 1900)
                + "-" + mes
                + "-" + dia

            });
        }

    }//GEN-LAST:event_cb_ordenarActionPerformed
   /**
    * Método que me permite guardar los datos de un guía a través del controlador
    */
    private void guardar() {
        String nombre = txtNe.getText();
        String direccion = txtNc.getText();
        String telefono = txtDe.getText();
        Date fechaIn = dt_fechaIn.getDate();
        Controlador_guias.guardarArbol(nombre, direccion, telefono, fechaIn);
        System.out.println("");
        cargar_lista_de_tareas();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JComboBox cb_crud;
    private javax.swing.JComboBox cb_ordenar;
    private com.toedter.calendar.JDateChooser dt_fechaIn;
    private javax.swing.JButton elemento_guardar;
    private javax.swing.JTable elemento_tabla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField txtDe;
    private javax.swing.JTextField txtNc;
    private javax.swing.JTextField txtNe;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
