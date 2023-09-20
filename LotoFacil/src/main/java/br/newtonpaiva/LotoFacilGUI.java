package br.newtonpaiva;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class LotoFacilGUI extends JFrame{
    // Atributos
    private JPanel painel = new JPanel();
    private JLabel jLabelMensagem = new JLabel("Escolha um tipo de aposta para começar");
    private JButton jButtonAposta1 = new JButton("Aposta de 0 a 100");
    private JButton jButtonAposta2 = new JButton("Aposta de A á Z");
    private JButton jButtonAposta3 = new JButton("Aposta em par ou ímpar");
    
    // Construtor
    public LotoFacilGUI(){
        this.setTitle("Loto Fácil - Interface Gráfica");
        this.setSize(400,250);
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        painel.setBackground(new Color(255,255,255));
        painel.add(jLabelMensagem);
        painel.add(jButtonAposta1); painel.add(jButtonAposta2); painel.add(jButtonAposta3);
        this.getContentPane().add(painel);
        this.setLocationRelativeTo(null); // Centralizar janela
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true); // Exibir janela

        // Aposta 1
            // Faça com que esse código aceite somente leitura de números
        jButtonAposta1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aposta = JOptionPane.showInputDialog(null,
                        "Digite um número de 0 a 100");

                try {
                    int numeroApostado = Integer.parseInt(aposta);
                    if (numeroApostado >= 0 && numeroApostado <= 100) {
                        Random rnd = new Random();
                        int sorteio = rnd.nextInt(101);

                        if (numeroApostado == sorteio) {
                            JOptionPane.showMessageDialog(null, "Você ganhou R$ 1.000,00 reais");
                        } else {
                            JOptionPane.showMessageDialog(null, "Que pena, você perdeu! O número sorteado foi: " + sorteio);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor, digite um número entre 0 e 100.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, digite um número válido.");
                }
            }
        });
       
        // Aposta 2
        jButtonAposta2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char letraViciada = 'J';
                String aposta = JOptionPane.showInputDialog(null, 
                        "Digite uma letra de A á Z");
                char letraApostada = aposta.charAt(0);
                Character letraApostadaMaiusculo =  Character.toUpperCase(letraApostada);

                if(Character.isLetter(letraApostada)) {
                    if(letraApostadaMaiusculo == letraViciada) {
                        JOptionPane.showMessageDialog(null, "Você ganhou R$ 500,00 reais.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Que pena, você perdeu! A letra sorteada foi: " + letraViciada);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, digite uma letra válida.");
                }

            }
        });

        // Aposta 3
        jButtonAposta3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aposta = JOptionPane.showInputDialog(null,
                        "Digite um número qualquer");

                try {
                    int numeroApostado = Integer.parseInt(aposta);

                    if (numeroApostado % 2 == 0) {
                        JOptionPane.showMessageDialog(null, "Você ganhou R$ 100,00 reais.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Que pena, você perdeu! O número sorteado era par.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, digite um número válido.");
                }
            }
        });

    }
    public static void main(String[] args) {new LotoFacilGUI();}
}