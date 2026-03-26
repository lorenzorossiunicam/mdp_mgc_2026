package it.unicam.mdp_mgc_2026.annotations;

import java.lang.annotation.*;

/**
 * Questa annotation riporta il nome del revisore del codice sorgente di una applicazione.
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
//@Target(ElementType.FIELD)
public @interface Revisore{
    String nome() default "Lorenzo Rossi";
    String data();
}
