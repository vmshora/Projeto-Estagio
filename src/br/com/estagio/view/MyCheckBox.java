/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagio.view;

import br.com.estagio.factory.EntityManagerUtil;
import br.com.estagio.model.Habilidade;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author victor
 */
public class MyCheckBox extends JFrame {
 
 //private JCheckBox java, php, csharp, c;
 private JLabel linguagens = new JLabel("Linguagens selecionadas: ");
 int numberCheckBox = 30;
 private JCheckBox[] checkBoxList = new JCheckBox[numberCheckBox];
 List<Habilidade> listHabilidade;
   
 public MyCheckBox(){
  super("Que Linguagens Deseja Aprender ?");
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setSize(400,100);
  setLayout( new FlowLayout() );
  
  
      
  EntityManager em = EntityManagerUtil.getEntityManager();
  em.getTransaction().begin();
  
  Query q = em.createQuery("select h from Habilidade h");
        listHabilidade = q.getResultList();
       // System.out.println(listHabilidade.size());
        
      
         for(Habilidade h:listHabilidade){
          checkBoxList[h.getId()] = new JCheckBox(h.getDescricao());
          add(checkBoxList[h.getId()]);
         
        }
  //yourPanel.add(checkBoxList[i]);
  //Criando os JCheckBox
  /*java = new JCheckBox("Java");
  php = new JCheckBox("PHP");
  csharp = new JCheckBox("C#");
  c = new JCheckBox("C");*/
  
  
  //Criando e adicionando o handler
  /* CheckBoxHandler tratador = new CheckBoxHandler();
  java.addItemListener(tratador);
  php.addItemListener(tratador);
  csharp.addItemListener(tratador);
  c.addItemListener(tratador);*/
  
  //Adicionando os JCheckBox no Layout
  /*add(java);
  add(php);
  add(csharp);
  add(c);
  add(linguagens);*/

  setVisible(true);
 }
 
 /*private class CheckBoxHandler implements ItemListener{
  private String texto = ""; 
  
   @Override
  public void itemStateChanged(ItemEvent evento) {
  texto = "";
  if(java.isSelected())
  texto += "Java ";
  
  if(php.isSelected())
  texto += "PHP ";
  
  if(csharp.isSelected())
  texto += "C# ";
  
  if(c.isSelected())
  texto += "C ";
  
  linguagens.setText("Linguagens selecionadas: "+texto);
  }
 }*/
}
