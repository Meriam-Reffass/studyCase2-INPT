package ac.ma.inpt;

import java.time.LocalDateTime;

public class Commande {
    static int counter = 0;
    int id = counter++;
    LocalDateTime dateHeure = LocalDateTime.now();
    int monnaierendu;
    int sommeIntroduite;
    Boisson boisson;

    public Commande(int sommeIntroduite, Boisson boisson) {
        this.sommeIntroduite = sommeIntroduite;
        this.boisson = boisson;
        monnaierendu = sommeIntroduite - boisson.prix  ;
    }



}
