package it.unicam.mdp_mgc_2026.interfaccegrafiche.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Swing_Ex {


    private void esempioBase(){
        JFrame win;
        win = new JFrame("MGC_MDP_2025");
        Container c = win.getContentPane();
        c.add(new JLabel("Buon Lezione"));
        win.setSize(200,200);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setVisible(true);
    }

    private void esempioComponenti(LayoutManager style){
        JFrame win;
        win = new JFrame("MGC_MDP_2025");
        Container c = win.getContentPane();
        c.setLayout(style);
        c.add(new JLabel("Buon Lezione"));
        c.add(new JTextField(12));
        c.add(new JButton("Bottone"));
        c.add(new JCheckBox("CheckBox"));
        ButtonGroup group = new ButtonGroup();
        JRadioButton rb1 = new JRadioButton("Opzione 1");
        JRadioButton rb2 = new JRadioButton("Opzione 2");
        group.add(rb1);
        group.add(rb2);
        c.add(rb1);
        c.add(rb2);
        String lista[]=new String[10];
        for(int i=0;i<lista.length;i++)
            lista[i]="Elemento␣numero␣"+i;
        JComboBox cBox= new JComboBox(lista);
        c.add(cBox);
        win.setSize(180,250);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setVisible(true);
    }

    public class MouseSpy implements MouseListener
    {
        public void mouseClicked(MouseEvent e) {
            System.out.println
                    ("Click␣su␣("+e.getX()+","+e.getY()+")");
        }
        public void mousePressed(MouseEvent e) {
            System.out.println
                    ("Premuto␣su␣("+e.getX()+","+e.getY()+")");
        }
        public void mouseReleased(MouseEvent e) {
            System.out.println
                    ("Rilasciato␣su␣("+e.getX()+","+e.getY()+")");
        }
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
    }

    private void esempioEventiBase() {
        JFrame frame = new JFrame("MouseTest");
        frame.addMouseListener(new MouseSpy());
        frame.setSize(200,200);
        frame.setVisible(true);
    }

    private void esempioEventi() {
        JFrame frame = new JFrame("Benvenuto!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 150);
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel label = new JLabel("Inserisci il tuo nome:");
        JTextField textField = new JTextField(15);
        JButton button = new JButton("OK");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = textField.getText().trim();
                if (!nome.isEmpty()) {
                    JOptionPane.showMessageDialog(frame,
                            "Ciao " + nome + ", hai proprio un bel nome!",
                            "Saluto",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Per favore, inserisci un nome.",
                            "Attenzione",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        panel.add(label);
        panel.add(textField);
        panel.add(button);
        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String args[])
    {
        Swing_Ex swing = new Swing_Ex();
        swing.esempioBase();
        //swing.esempioComponenti(new FlowLayout(FlowLayout.LEFT));
        //swing.esempioComponenti(new GridLayout(3,3));
        //swing.esempioComponenti(new BorderLayout());
        //swing.esempioEventiBase();
        //swing.esempioEventi();
    }



}
