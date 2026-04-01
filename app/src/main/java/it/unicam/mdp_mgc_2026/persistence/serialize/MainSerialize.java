package it.unicam.mdp_mgc_2026.persistence.serialize;

import it.unicam.mdp_mgc_2026.annotations.Persona;

import java.io.*;

public class MainSerialize {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Persona p = new Persona("Michele", "Loreti", "ADQEDFQEWF");

        ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream("loreti.dat")));
        out.writeObject(p);
        out.close();

        ObjectInputStream in = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream ("loreti.dat")));
        Persona p2 = (Persona) in.readObject();
        in.close();
        System.out.println(p.equals(p2));
        System.out.println(p2);

    }
}
