package it.unicam.mdp_mgc_2026.interfaccegrafiche.tris;

import it.unicam.mdp_mgc_2026.interfaccegrafiche.swing.Player;

public class Tris {

    private Player[][] griglia = new Player[3][3];
    private Player p1,p2;
    private Player turno;

    public Tris(Player p1, Player p2){
        if (p1 == null || p2 == null || p1.equals(p2)) throw new IllegalArgumentException();
        this.p1 = p1;
        this.p2 = p2;
        if(Math.random() < 0.5){
            turno = p1;
        }else  {
            turno = p2;
        }
    }


    public boolean mossa(int r, int c){
        if(r<0 || r>2 || c<0 || c>2 || griglia[r][c] != null){
            return false;
        }
        griglia[r][c] = turno;
        cambioTurno();
        return true;
    }

    private void cambioTurno(){
        turno = turno.equals(p1) ? p2 : p1;
    }

    public Player checkVittoria(){
        //Righe
        if (griglia[0][0] == griglia[0][1] && griglia[0][1] == griglia[0][2]){
            return griglia[0][0];
        }
        if (griglia[1][0] == griglia[1][1] && griglia[1][1] == griglia[1][2]){
            return griglia[1][0];
        }
        if (griglia[2][0] == griglia[2][1] && griglia[2][1] == griglia[2][2]){
            return griglia[2][0];
        }
        //Colonne
        if (griglia[0][0] == griglia[1][0] && griglia[1][0] == griglia[2][0]){
            return griglia[0][0];
        }
        if (griglia[0][1] == griglia[1][1] && griglia[1][1] == griglia[2][1]){
            return griglia[0][1];
        }
        if (griglia[0][2] == griglia[1][2] && griglia[1][2] == griglia[2][2]){
            return griglia[0][2];
        }
        //Diagonali
        if (griglia[0][0] == griglia[1][1] && griglia[1][1] == griglia[2][2]){
            return griglia[0][0];
        }
        if (griglia[0][2] == griglia[1][1] && griglia[1][1] == griglia[2][0]){
            return griglia[0][2];
        }
        //Altrimenti
        return null;
    }

    public boolean isPiena(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (griglia[i][j] == null) return false;
            }
        }
        return true;
    }

    public Player getTurno(){
        return turno;
    }

    public Player[][] getGriglia(){
        return griglia;
    }

    public static void main(String[] args) {
        Player p1 = new Player("1", "P1");
        Player p2 = new Player("2", "P2");
        Tris t = new Tris(p1, p2);
        t.mossa(0, 0);
        t.mossa(1, 1);
        t.mossa(0, 1);
        t.mossa(2, 2);
        t.mossa(0, 2);
        System.out.println(t.checkVittoria());
    }
}
