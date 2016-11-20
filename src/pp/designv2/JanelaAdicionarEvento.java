/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp.designv2;

import pp.negocio.*;
import java.util.*;
import java.time.*;
import javax.swing.JOptionPane;
//import com.toedter.calendar.*;
/**
 *
 * @author Utilizador
 */
public class JanelaAdicionarEvento extends javax.swing.JFrame {
    private Sistema sistema;
    private Condominio condo;
    private AgendaFinal agenda;
    private EventoData2 evento;
    private ListarFracoes lf;
    private ListarEventos lv;
    
    /**
     * Creates new form JanelaAdicionarEvento
     */
    public JanelaAdicionarEvento(Sistema sistema, Condominio condominio, EventoData2 evento, ListarFracoes lf, ListarEventos lv) {
        initComponents();
        setSize(901, 748);
        this.sistema = sistema;
        this.agenda = agenda;
        this.condo = condominio;
        this.evento = evento;
        this.lf = lf;
        this.lv = lv;
        
        this.setResizable(true);
        setTitle("Adicionar Evento");
        
    }
    /*
     public JanelaAdicionarEvento(Sistema sistema, EventoData2 evento, ListarEventos lv) {
        initComponents();
        setSize(800, 600);
        this.setResizable(true);
        this.sistema = sistema;
        this.agenda = agenda;
        this.evento = evento;
        this.lv = lv;
    }
    */
    private EventoData2 selecTipodeEvento(){
        EventoData2 evento = null;
        
        if(limpezaBtn.isSelected()){
            evento = new Limpeza();
        } 
        
        if(manutencaoBtn.isSelected()){
             evento = new Manutencao();
      
        } 
        
        if(reuniaoBtn.isSelected()){
          
              evento = new Reuniao();
        }
        return evento;
    }

    private void fechar() {
        dispose();
    }
    
     private boolean registoNovo() {
        //Se utililizador == null consideramos que é um novo registo
        return evento == null;
    }
    
    private void criarEvento(){
        
        if(eventosGroup.getSelection() == null){
            JOptionPane.showMessageDialog(this, "Por favor selecione o tipo de evento!"); 
            return;
        }
        
        if (staffField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza o staff por favor!");            
            staffField.requestFocus();
            return;
        }
        
        
        if(registoNovo()){
        Date data = calendario.getDate();
        EventoData2 evento = selecTipodeEvento();
        evento.setNotas(notasArea.getText());
        evento.setStaff(staffField.getText());
        evento.setData(data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        if(condo != null){
        condo.getAgenda().addEvento(evento);
        }
        sistema.getListaEventos().add(evento);
        } else{
           Date data = calendario.getDate();
           evento.setNotas(notasArea.getText());
           evento.setStaff(staffField.getText());
           evento.setData(data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
           
            
            
            
        }
        if(lf != null) lf.atualizar();
        if (lv != null) lv.atualizar();  
        JOptionPane.showMessageDialog(this, "Registo guardado com sucesso.");
        fechar();
        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        eventosGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        notasArea = new javax.swing.JTextArea();
        staffField = new javax.swing.JTextField();
        limpezaBtn = new javax.swing.JRadioButton();
        manutencaoBtn = new javax.swing.JRadioButton();
        reuniaoBtn = new javax.swing.JRadioButton();
        okBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        calendario = new com.toedter.calendar.JCalendar();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tipo de Evento:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 42, 90, 16);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Data:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 120, 31, 16);

        jLabel3.setText("Staff:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(36, 350, 32, 16);

        jLabel4.setText("Notas:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(36, 461, 37, 16);

        notasArea.setColumns(20);
        notasArea.setRows(5);
        jScrollPane1.setViewportView(notasArea);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(160, 450, 253, 145);
        getContentPane().add(staffField);
        staffField.setBounds(150, 350, 270, 60);

        eventosGroup.add(limpezaBtn);
        limpezaBtn.setText("Limpeza");
        getContentPane().add(limpezaBtn);
        limpezaBtn.setBounds(204, 42, 75, 25);

        eventosGroup.add(manutencaoBtn);
        manutencaoBtn.setText("Manutenção");
        getContentPane().add(manutencaoBtn);
        manutencaoBtn.setBounds(345, 42, 97, 25);

        eventosGroup.add(reuniaoBtn);
        reuniaoBtn.setText("Reunião");
        getContentPane().add(reuniaoBtn);
        reuniaoBtn.setBounds(506, 42, 75, 25);

        okBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pp/designbonus/accept.png"))); // NOI18N
        okBtn.setText("Confirmar");
        okBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnActionPerformed(evt);
            }
        });
        getContentPane().add(okBtn);
        okBtn.setBounds(180, 630, 140, 40);

        cancelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pp/designbonus/cancel.png"))); // NOI18N
        cancelBtn.setText("Cancelar");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });
        getContentPane().add(cancelBtn);
        cancelBtn.setBounds(460, 630, 140, 40);
        getContentPane().add(calendario);
        calendario.setBounds(430, 130, 191, 155);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pp/designbonus/1312323.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 900, 760);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtnActionPerformed
        criarEvento();     // TODO add your handling code here:
    }//GEN-LAST:event_okBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        fechar();        // TODO add your handling code here:
    }//GEN-LAST:event_cancelBtnActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JCalendar calendario;
    private javax.swing.JButton cancelBtn;
    private javax.swing.ButtonGroup eventosGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton limpezaBtn;
    private javax.swing.JRadioButton manutencaoBtn;
    private javax.swing.JTextArea notasArea;
    private javax.swing.JButton okBtn;
    private javax.swing.JRadioButton reuniaoBtn;
    private javax.swing.JTextField staffField;
    // End of variables declaration//GEN-END:variables
}
