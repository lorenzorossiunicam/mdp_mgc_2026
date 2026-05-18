package it.unicam.mdp_mgc_2026.interfaccegrafiche.tris;

import it.unicam.mdp_mgc_2026.interfaccegrafiche.swing.Player;

import javax.swing.*;
import java.awt.*;

public class TrisGUI extends JFrame {

    private JLabel p1,p2;
    private JTextField pt1,pt2;
    private JButton play,restart;
    private JButton[][] grigliaV = new JButton[3][3];
    private Tris partita;
    private JLabel console;

    public TrisGUI(){
        super("Tris");
        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        createMenu();
        createGriglia();
        this.setVisible(true);
    }

    private void createGriglia() {
        JPanel griglia = new JPanel();
        griglia.setLayout(new GridLayout(3,3));
        griglia.setPreferredSize(new Dimension(300, 300));
        Font font = new Font("Arial", Font.BOLD, 48);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton("");
                button.setFont(font);
                button.setFocusPainted(false);
                button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                final int row = i;
                final int col = j;
                button.addActionListener(e -> gestisciMossa(row, col));
                grigliaV[i][j] = button;
                griglia.add(button);
            }
        }
        abilitaGriglia(false);
        this.add(griglia,BorderLayout.CENTER);
    }

    private void abilitaGriglia(boolean b) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grigliaV[i][j].setEnabled(b);
            }
        }
    }

    private void gestisciMossa(int row, int col) {
        Player p = partita.getTurno();
        boolean mossa = partita.mossa(row, col);
        if (mossa){
            grigliaV[row][col].setText(p.getId());
        }
        p = partita.checkVittoria();
        if (p==null) {avanzaTurno();}
        else {
            vittoria();
        }
    }

    private void vittoria() {
        console.setText("Player " + partita.getTurno() + " vince!");
        abilitaGriglia(false);
    }

    private void createMenu() {
        JPanel menu = new JPanel();
        menu.setLayout(new FlowLayout());
        p1 = new JLabel("X");
        p2 = new JLabel("O");
        pt1 = new JTextField(3);
        pt2 = new JTextField(3);
        console = new JLabel("");
        play = new JButton("Play");
        play.addActionListener(e -> creaPartita());
        menu.add(p1);
        menu.add(pt1);
        menu.add(p2);
        menu.add(pt2);
        menu.add(play);
        menu.add(console);
        this.add(menu,BorderLayout.NORTH);
    }

    private void creaPartita(){
        play.setText("Restart");
        partita = new Tris(new Player("X",pt1.getText()),new Player("O", pt2.getText()));
        avanzaTurno();
        abilitaGriglia(true);
    }

    private void avanzaTurno() {
        console.setText("Tocca a Player "+partita.getTurno()+" clicca una cella vuota");
    }

    public static void main(String[] args) {
        new TrisGUI();
    }

}
