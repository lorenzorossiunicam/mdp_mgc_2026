package it.unicam.mdp_mgc_2026.annotations;

public class MainAnnotations {

    public static void main(String[] args) {
        deprecations();
    }

    //@SuppressWarnings("deprecation")
    private static void deprecations() {
        Persona lr = new Persona("Lorenzo", "Rossi", "RSSLNZ87R43F443K");
        lr.setEta(44.5);
        System.out.println("Finito");
        //System.out.println(lr.getClass().getAnnotation(Revisore.class));
    }
}
