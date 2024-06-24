
package vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class AdminUI extends javax.swing.JFrame {

   private ArrayList<Usuario> listaUsuarios;
    private File baseDatos; // Simulación de base de datos (archivo de texto)

    public AdminUI() {
        initComponents();
        baseDatos = new File("usuarios.txt");
        cargarUsuariosDesdeArchivo();
    }
     // Método para cargar usuarios desde el archivo
    private void cargarUsuariosDesdeArchivo() {
        listaUsuarios = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(baseDatos));
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombre = datos[0];
                String tipo = datos[1];
                listaUsuarios.add(new Usuario(nombre, tipo));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
// Método para guardar usuarios en el archivo
    private void guardarUsuariosEnArchivo() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(baseDatos));
            for (Usuario usuario : listaUsuarios) {
                writer.write(usuario.getNombre() + "," + usuario.getTipo() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para mostrar usuarios según el tipo filtrado
    private void mostrarUsuariosFiltrados(String tipo) {
        StringBuilder sb = new StringBuilder();
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getTipo().equalsIgnoreCase(tipo)) {
                sb.append(usuario.getNombre()).append(" - ").append(usuario.getTipo()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(this, "Usuarios filtrados por " + tipo + ":\n" + sb.toString());
    }

    // Método para eliminar un usuario
    private void eliminarUsuario(String nombreUsuario) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombre().equalsIgnoreCase(nombreUsuario)) {
                listaUsuarios.remove(usuario);
                JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente.");
                guardarUsuariosEnArchivo();
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Usuario no encontrado.");
    }

    // Método para modificar un usuario
    private void modificarUsuario(String nombreUsuario, String nuevoNombre, String nuevoTipo) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombre().equalsIgnoreCase(nombreUsuario)) {
                usuario.setNombre(nuevoNombre);
                usuario.setTipo(nuevoTipo);
                JOptionPane.showMessageDialog(this, "Usuario modificado correctamente.");
                guardarUsuariosEnArchivo();
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Usuario no encontrado.");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // </editor-fold>
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        usuarioLabel = new javax.swing.JLabel();
        usuarioLabel1 = new javax.swing.JLabel();
        contraseñaLabel2 = new javax.swing.JLabel();
        nombreUsuarioTextField = new javax.swing.JTextField();
        nombreUsuarioTextField1 = new javax.swing.JTextField();
        listadetramitesButton = new javax.swing.JButton();
        mainTitleLabel = new javax.swing.JLabel();
        listadedependienteButton1 = new javax.swing.JButton();
        crearusuarioButton2 = new javax.swing.JButton();
        listadeusuariosButton3 = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        usuarioLabel.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        usuarioLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        usuarioLabel1.setText("Usuario");

        contraseñaLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        contraseñaLabel2.setText("Contraseña");

        nombreUsuarioTextField.setToolTipText("");
        nombreUsuarioTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreUsuarioTextFieldActionPerformed(evt);
            }
        });

        nombreUsuarioTextField1.setToolTipText("");
        nombreUsuarioTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreUsuarioTextField1ActionPerformed(evt);
            }
        });

        listadetramitesButton.setBackground(new java.awt.Color(0, 0, 0));
        listadetramitesButton.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        listadetramitesButton.setForeground(new java.awt.Color(255, 255, 255));
        listadetramitesButton.setText("LISTA DE TRÁMITES");
        listadetramitesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listadetramitesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listadetramitesButtonActionPerformed(evt);
            }
        });

        mainTitleLabel.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        mainTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        mainTitleLabel.setText("SISTEMA DE ADMINISTRACIÓN DE USUARIOS");
        mainTitleLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        listadedependienteButton1.setBackground(new java.awt.Color(0, 0, 0));
        listadedependienteButton1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        listadedependienteButton1.setForeground(new java.awt.Color(255, 255, 255));
        listadedependienteButton1.setText("LISTA DE DEPENDENCIAS");
        listadedependienteButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listadedependienteButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listadedependienteButton1ActionPerformed(evt);
            }
        });

        crearusuarioButton2.setBackground(new java.awt.Color(0, 0, 0));
        crearusuarioButton2.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        crearusuarioButton2.setForeground(new java.awt.Color(255, 255, 255));
        crearusuarioButton2.setText("CREAR USUARIO");
        crearusuarioButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        crearusuarioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearusuarioButton2ActionPerformed(evt);
            }
        });

        listadeusuariosButton3.setBackground(new java.awt.Color(0, 0, 0));
        listadeusuariosButton3.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        listadeusuariosButton3.setForeground(new java.awt.Color(255, 255, 255));
        listadeusuariosButton3.setText("LISTA DE USUARIOS");
        listadeusuariosButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listadeusuariosButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listadeusuariosButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(contraseñaLabel2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usuarioLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nombreUsuarioTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                    .addComponent(nombreUsuarioTextField1))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mainTitleLabel)
                            .addComponent(usuarioLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(58, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(listadetramitesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listadedependienteButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(crearusuarioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listadeusuariosButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(mainTitleLabel)
                .addGap(35, 35, 35)
                .addComponent(usuarioLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreUsuarioTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarioLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contraseñaLabel2)
                    .addComponent(nombreUsuarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listadetramitesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(crearusuarioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listadeusuariosButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listadedependienteButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void initComponents() {

        listadetramitesButton = new javax.swing.JButton();
        mainTitleLabel = new javax.swing.JLabel();
        listadedependienteButton1 = new javax.swing.JButton();
        crearusuarioButton2 = new javax.swing.JButton();
        listadeusuariosButton3 = new javax.swing.JButton();
        usuarioLabel1 = new javax.swing.JLabel();
        contraseñaLabel2 = new javax.swing.JLabel();
        nombreUsuarioTextField = new javax.swing.JTextField();
        nombreUsuarioTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listadetramitesButton.setBackground(new java.awt.Color(0, 0, 0));
        listadetramitesButton.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        listadetramitesButton.setForeground(new java.awt.Color(255, 255, 255));
        listadetramitesButton.setText("LISTA DE TRÁMITES");
        listadetramitesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listadetramitesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listadetramitesButtonActionPerformed(evt);
            }
        });

        mainTitleLabel.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        mainTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        mainTitleLabel.setText("SISTEMA DE ADMINISTRACIÓN DE USUARIOS");
        mainTitleLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        listadedependienteButton1.setBackground(new java.awt.Color(0, 0, 0));
        listadedependienteButton1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        listadedependienteButton1.setForeground(new java.awt.Color(255, 255, 255));
        listadedependienteButton1.setText("LISTA DE DEPENDENCIAS");
        listadedependienteButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listadedependienteButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listadedependienteButton1ActionPerformed(evt);
            }
        });

        crearusuarioButton2.setBackground(new java.awt.Color(0, 0, 0));
        crearusuarioButton2.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        crearusuarioButton2.setForeground(new java.awt.Color(255, 255, 255));
        crearusuarioButton2.setText("CREAR USUARIO");
        crearusuarioButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        crearusuarioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearusuarioButton2ActionPerformed(evt);
            }
        });

        listadeusuariosButton3.setBackground(new java.awt.Color(0, 0, 0));
        listadeusuariosButton3.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        listadeusuariosButton3.setForeground(new java.awt.Color(255, 255, 255));
        listadeusuariosButton3.setText("LISTA DE USUARIOS");
        listadeusuariosButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listadeusuariosButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listadeusuariosButton3ActionPerformed(evt);
            }
        });

        usuarioLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        usuarioLabel1.setText("Usuario");

        contraseñaLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        contraseñaLabel2.setText("Contraseña");

        nombreUsuarioTextField.setToolTipText("");
        nombreUsuarioTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreUsuarioTextFieldActionPerformed(evt);
            }
        });

        nombreUsuarioTextField1.setToolTipText("");
        nombreUsuarioTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreUsuarioTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(contraseñaLabel2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usuarioLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nombreUsuarioTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                    .addComponent(nombreUsuarioTextField1))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mainTitleLabel)
                            .addComponent(usuarioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(58, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(listadetramitesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listadedependienteButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(crearusuarioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listadeusuariosButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(mainTitleLabel)
                .addGap(35, 35, 35)
                .addComponent(usuarioLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreUsuarioTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarioLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contraseñaLabel2)
                    .addComponent(nombreUsuarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listadetramitesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(crearusuarioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listadeusuariosButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listadedependienteButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>  
    private void nombreUsuarioTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreUsuarioTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreUsuarioTextFieldActionPerformed

    private void nombreUsuarioTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreUsuarioTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreUsuarioTextField1ActionPerformed

    private void listadetramitesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listadetramitesButtonActionPerformed
        SegTramiteUI frmSegTramite = new SegTramiteUI();
        frmSegTramite.setVisible(true); // hide
    }//GEN-LAST:event_listadetramitesButtonActionPerformed

    private void listadedependienteButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listadedependienteButton1ActionPerformed
        ListadedependenciasUI listadependencia=new ListadedependenciasUI();
        listadependencia.setVisible(true);
    }//GEN-LAST:event_listadedependienteButton1ActionPerformed

    private void crearusuarioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearusuarioButton2ActionPerformed
       CrearusuarioUI  crear=new CrearusuarioUI();
       crear.setVisible(true);
       
    }//GEN-LAST:event_crearusuarioButton2ActionPerformed

    private void listadeusuariosButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listadeusuariosButton3ActionPerformed
      
        ListaUsuarioUI listausuario=new ListaUsuarioUI();
        listausuario.setVisible(true);
         


            
    }//GEN-LAST:event_listadeusuariosButton3ActionPerformed
// Método para mostrar el menú de usuarios
    private void mostrarMenuUsuarios() {
        String[] opciones = {"Filtrar por Empleados", "Filtrar por Externos", "Filtrar por Admins", "Eliminar Usuario", "Modificar Usuario"};
        String opcionSeleccionada = (String) JOptionPane.showInputDialog(this, "Seleccione una opción", "Gestión de Usuarios", JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

        if (opcionSeleccionada != null) {
            switch (opcionSeleccionada) {
                case "Filtrar por Empleados":
                    mostrarUsuariosFiltrados("Empleado");
                    break;
                case "Filtrar por Externos":
                    mostrarUsuariosFiltrados("Externo");
                    break;
                case "Filtrar por Admins":
                    mostrarUsuariosFiltrados("Admin");
                    break;
                case "Eliminar Usuario":
                    String nombreEliminar = JOptionPane.showInputDialog(this, "Ingrese el nombre del usuario a eliminar:");
                    if (nombreEliminar != null && !nombreEliminar.isEmpty()) {
                        eliminarUsuario(nombreEliminar);
                    } else {
                        JOptionPane.showMessageDialog(this, "Nombre de usuario no válido.");
                    }
                    break;
                case "Modificar Usuario":
                    String nombreModificar = JOptionPane.showInputDialog(this, "Ingrese el nombre del usuario a modificar:");
                    if (nombreModificar != null && !nombreModificar.isEmpty()) {
                        String nuevoNombre = JOptionPane.showInputDialog(this, "Ingrese el nuevo nombre:");
                        String nuevoTipo = JOptionPane.showInputDialog(this, "Ingrese el nuevo tipo (Empleado, Externo o Admin):");
                        if (nuevoNombre != null && nuevoTipo != null && !nuevoNombre.isEmpty() && !nuevoTipo.isEmpty()) {
                            modificarUsuario(nombreModificar, nuevoNombre, nuevoTipo);
                        } else {
                            JOptionPane.showMessageDialog(this, "Datos no válidos.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Nombre de usuario no válido.");
                    }
                    break;
                default:
                    break;
            }
        }
    }
    // Clase interna para representar usuarios
    private class Usuario {
        private String nombre;
        private String tipo;

        public Usuario(String nombre, String tipo) {
            this.nombre = nombre;
            this.tipo = tipo;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
      try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel contraseñaLabel2;
    private javax.swing.JButton crearusuarioButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton listadedependienteButton1;
    private javax.swing.JButton listadetramitesButton;
    private javax.swing.JButton listadeusuariosButton3;
    private javax.swing.JLabel mainTitleLabel;
    private javax.swing.JTextField nombreUsuarioTextField;
    private javax.swing.JTextField nombreUsuarioTextField1;
    private javax.swing.JLabel usuarioLabel;
    private javax.swing.JLabel usuarioLabel1;
    // End of variables declaration//GEN-END:variables
}
