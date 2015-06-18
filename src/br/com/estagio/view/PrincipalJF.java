/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagio.view;

import br.com.estagio.view.util.FundoTela;
import java.awt.Frame;
import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 *
 * @author victor
 */
public class PrincipalJF extends javax.swing.JFrame {
    
    FundoTela desktop;
    VagaJF vagaJF;
    CandidatoJF candidatoJF;
    VagaCandidatoJF vagaCandidatoJF;
    CandidatoVagaJF candidatoVagaJF;
    
    public PrincipalJF() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new GridLayout());
      desktop = new FundoTela("Imagens/estagio.jpg");
      getContentPane().add(desktop);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jM_Gerenciar = new javax.swing.JMenu();
        jM_Empresa = new javax.swing.JMenuItem();
        jM_Candidato = new javax.swing.JMenuItem();
        jM_Vaga = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jM_candidatoVaga = new javax.swing.JMenuItem();
        jM_vagaCandidato = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estagiando");

        jM_Gerenciar.setText("Gerenciar");
        jM_Gerenciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jM_GerenciarActionPerformed(evt);
            }
        });

        jM_Empresa.setText("Empresa");
        jM_Empresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jM_EmpresaActionPerformed(evt);
            }
        });
        jM_Gerenciar.add(jM_Empresa);

        jM_Candidato.setText("Candidato");
        jM_Candidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jM_CandidatoActionPerformed(evt);
            }
        });
        jM_Gerenciar.add(jM_Candidato);

        jM_Vaga.setText("Vaga");
        jM_Vaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jM_VagaActionPerformed(evt);
            }
        });
        jM_Gerenciar.add(jM_Vaga);

        jMenuBar1.add(jM_Gerenciar);

        jMenu2.setText("Consultar");

        jM_candidatoVaga.setText("Candidatos");
        jM_candidatoVaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jM_candidatoVagaActionPerformed(evt);
            }
        });
        jMenu2.add(jM_candidatoVaga);

        jM_vagaCandidato.setText("Vagas");
        jM_vagaCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jM_vagaCandidatoActionPerformed(evt);
            }
        });
        jMenu2.add(jM_vagaCandidato);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jM_VagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jM_VagaActionPerformed
       
        vagaJF = new VagaJF();
        desktop.add(vagaJF);
        vagaJF.setVisible(true);
    }//GEN-LAST:event_jM_VagaActionPerformed

    private void jM_GerenciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jM_GerenciarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jM_GerenciarActionPerformed

    private void jM_CandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jM_CandidatoActionPerformed
        candidatoJF = new CandidatoJF();
        desktop.add(candidatoJF);
        candidatoJF.setVisible(true);
    }//GEN-LAST:event_jM_CandidatoActionPerformed

    private void jM_vagaCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jM_vagaCandidatoActionPerformed
      vagaCandidatoJF = new VagaCandidatoJF();
      desktop.add(vagaCandidatoJF);
      vagaCandidatoJF.setVisible(true);
    }//GEN-LAST:event_jM_vagaCandidatoActionPerformed

    private void jM_EmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jM_EmpresaActionPerformed
     
    }//GEN-LAST:event_jM_EmpresaActionPerformed

    private void jM_candidatoVagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jM_candidatoVagaActionPerformed
      candidatoVagaJF = new CandidatoVagaJF();
      desktop.add(candidatoVagaJF);
      candidatoVagaJF.setVisible(true);
    }//GEN-LAST:event_jM_candidatoVagaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalJF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jM_Candidato;
    private javax.swing.JMenuItem jM_Empresa;
    private javax.swing.JMenu jM_Gerenciar;
    private javax.swing.JMenuItem jM_Vaga;
    private javax.swing.JMenuItem jM_candidatoVaga;
    private javax.swing.JMenuItem jM_vagaCandidato;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
