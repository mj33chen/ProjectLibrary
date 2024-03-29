/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaPresentacion;


import javax.swing.*;
import java.io.IOException;

/**
 *
 * @author mingjian
 */
public class VistaLibro extends javax.swing.JPanel
{

    private boolean create;

    private boolean modify;

    private boolean modeCreate = true;
    private ControladorPresentacion controlPre;
    private VistaColeccionLibros vistaCL;

    private ControladorPresentacion cp;

    public VistaLibro()
    {
        initComponents();
        this.setVisible(true);
        this.create = true;
        this.modify = false;
    }



    public boolean consultModeCreate()
    {
        return this.create;
    }

    public boolean consultModeModify()
    {
        return this.modify;
    }


    public void setControllers(ControladorPresentacion controlPre)
    {
        this.controlPre = controlPre;
    }

    public void setVista()
    {
        this.vistaCL = vistaCL;
    }

    public void setMode(boolean mode)
    {
        this.modeCreate = mode;
        {
            if(modeCreate)
            {
                editId.setText("");
                editTitulo.setText("");
                editAutor.setText("");
                buttonAccept.setText("Crear");
            }
            else
            {
                buttonAccept.setText("Modificar");
            }
        }
    }

    public void loadLibro(String idLibro) throws IOException
    {
        String[] libro = controlPre.getLibro(idLibro);
        editId.setText(libro[0]);
        editTitulo.setText(libro[1]);
        editAutor.setText(libro[2]);

    }

    public void rebootLabel()
    {
        editId.setText("");
        editTitulo.setText("");
        editAutor.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents()
    {

        editId = new javax.swing.JTextField();
        editTitulo = new javax.swing.JTextField();
        editAutor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        buttonAccept = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        notifyLabel = new javax.swing.JPanel();
        notify = new javax.swing.JLabel();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        setMaximumSize(new java.awt.Dimension(716, 424));
        setMinimumSize(new java.awt.Dimension(716, 424));

        buttonAccept.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buttonAccept.setText("Crear");
        buttonAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAcceptActionPerformed(evt);
            }
        });

        buttonCancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buttonCancel.setText("Cancelar");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Libro:");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel3.setText("Identificador:");

        jLabel2.setText("Autor:");

        jLabel1.setText("Titulo:");


        notifyLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 40, 204), 0));
        notify.setForeground(new java.awt.Color(35, 204, 32));
        notify.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        notify.setText("");

        javax.swing.GroupLayout notifyLabelLayout = new javax.swing.GroupLayout(notifyLabel);
        notifyLabel.setLayout(notifyLabelLayout);
        notifyLabelLayout.setHorizontalGroup(
                notifyLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(notifyLabelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(notify , javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
                                .addContainerGap())
        );
        notifyLabelLayout.setVerticalGroup(
                notifyLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(notify , javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(85, 85, 85)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel1))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(editId)
                                                        .addComponent(editAutor)
                                                        .addComponent(editTitulo)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(buttonAccept)
                                                                .addGap(71, 71, 71)
                                                                .addComponent(buttonCancel)))))

                                .addContainerGap(338, Short.MAX_VALUE))
                        .addComponent(notifyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)




        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(notifyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(editTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(editAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(editId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttonAccept)
                                        .addComponent(buttonCancel))
                                .addContainerGap(87, Short.MAX_VALUE))
        );
    }// </editor-fold>

    // private methods 

    private void buttonAcceptActionPerformed(java.awt.event.ActionEvent evt)
    {

        if (editAutor.getText().equals("") || editId.getText().equals("") || editTitulo.getText().equals(""))
        {
            notify.setText("");
            JOptionPane.showMessageDialog(this, "ERROR: Te faltan datos ): ", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if(modeCreate)
        {
            /*controlPre.anadirLibro(Integer.parseInt(editId.getText()), editTitulo.getText(),
                                    editAutor.getText());*/
            vistaCL.updateBooks();
            notify.setText("Libro anadido a la biblioteca.");
            rebootLabel();
            this.create = true;
        }
        else
        {
            /*controlPre.modificarLibro(Integer.parseInt(editId.getText()), editTitulo.getText(),
                                    editAutor.getText());*/
            notify.setText("Libro modificado correctamente.");
            this.modify = true;
        }
    }

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt)
    {
        rebootLabel();
        notify.setText("Libro no ha sido anadido correctamente.");
    }


    // Variables declaration - do not modify
    private javax.swing.JButton buttonAccept;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField editId;
    private javax.swing.JTextField editTitulo;
    private javax.swing.JTextField editAutor;
    private javax.swing.JLabel notify;
    private javax.swing.JPanel notifyLabel;
    // End of variables declaration
}
