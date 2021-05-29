package ac.ma.inpt;

import java.util.ArrayList;

public class Controlleur implements  Runnable {

    public Controlleur() {
    }

    //doit retourner true tant que le distributeur est en bon etat
    boolean verifierEtat() {
        return true;
    }

    boolean effectuerRequette() {
        return true;
    }

    void donnerStatistiques(ArrayList<Commande> commandes) {
        int somme = 0;
        for (Commande commande : commandes
        ) {
            somme += commande.boisson.prix;
        }
        System.out.println("total des ventes = " + somme);
        System.out.println("nombre des ventes total " + commandes.size());
    }

    @Override
    public void run() {
        verifierEtat();
        notify();
    }
}
