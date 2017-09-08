package mural.escolar.view;

import javax.swing.JOptionPane;
import mural.escolar.controller.AlunoController;
import mural.escolar.controller.ProfessorController;

/**
 *
 * @author Lucas Vieira
 */
public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form MuralEscolar
     */
    public LoginForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelLogin = new javax.swing.JPanel();
        LBLemail = new javax.swing.JLabel();
        TXTemail = new javax.swing.JTextField();
        LBLsenha = new javax.swing.JLabel();
        BTNlogin = new javax.swing.JButton();
        BTNforgotPass = new javax.swing.JButton();
        TXTsenha = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        LBLemail.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        LBLemail.setText("E-mail:");

        LBLsenha.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        LBLsenha.setText("Senha:");

        BTNlogin.setText("Log in");
        BTNlogin.setBorder(null);
        BTNlogin.setBorderPainted(false);
        BTNlogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BTNlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNloginActionPerformed(evt);
            }
        });

        BTNforgotPass.setText("Forgot Password?");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo2.png"))); // NOI18N

        javax.swing.GroupLayout PainelLoginLayout = new javax.swing.GroupLayout(PainelLogin);
        PainelLogin.setLayout(PainelLoginLayout);
        PainelLoginLayout.setHorizontalGroup(
            PainelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLoginLayout.createSequentialGroup()
                .addGroup(PainelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelLoginLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel2))
                    .addGroup(PainelLoginLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(PainelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LBLemail)
                            .addComponent(TXTemail)
                            .addComponent(LBLsenha)
                            .addComponent(TXTsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BTNlogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BTNforgotPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        PainelLoginLayout.setVerticalGroup(
            PainelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelLoginLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addGap(31, 31, 31)
                .addComponent(LBLemail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TXTemail, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LBLsenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TXTsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BTNlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BTNforgotPass, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BTNloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNloginActionPerformed
        // Pegar email e senha do Form
        String email = TXTemail.getText();
        String senha = TXTsenha.getText();
        
        // VERIFICAR EMAIL E SENHA 
        // chamar db
        AlunoController controllerAluno = new AlunoController();
        ProfessorController controllerProf = new ProfessorController();
        
        String emailAdmin = "admin@gmail.com";
        String senhaAdmin = "123456";
        if(emailAdmin.equals(TXTemail.getText()) && senhaAdmin.equals(TXTsenha.getText())){
            Home nF = new Home();
            nF.setVisible(true);
            dispose();
        }else if(controllerAluno.login(email, senha) == 1) {     
            // SE FOR ADMIN CHAMA A HOME
            Home nF = new Home();
            nF.setVisible(true);
            dispose();
        }else if(controllerProf.login(email, senha) == 1){
            Home nF = new Home();
            nF.setVisible(true);
            dispose();
        }else {
            JOptionPane.showMessageDialog(null, "E-mail or password incorrect");
        }
        
    }//GEN-LAST:event_BTNloginActionPerformed

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNforgotPass;
    private javax.swing.JButton BTNlogin;
    private javax.swing.JLabel LBLemail;
    private javax.swing.JLabel LBLsenha;
    private javax.swing.JPanel PainelLogin;
    private javax.swing.JTextField TXTemail;
    private javax.swing.JPasswordField TXTsenha;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
