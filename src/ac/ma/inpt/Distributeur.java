package ac.ma.inpt;

import java.util.ArrayList;
import java.util.Scanner;

public class Distributeur implements Runnable {
    String emplacement;
    int id;
    ArrayList<Commande> commandes;
    ArrayList<Boisson> boissons;
    ArrayList<Technologie_de_communication> technologie_de_communications;
    Controlleur controlleur;

    public Distributeur(int id, String emplacement) {
        this.emplacement = emplacement;
        this.id = id;
        controlleur = new Controlleur();
        commandes = new ArrayList<>();
        boissons = new ArrayList<>();
        technologie_de_communications = new ArrayList<>();
    }

    public void ajouterBoisson(Boisson boisson) {
        boissons.add(boisson);
    }

    public void ajouterTechnologie_de_communication(Technologie_de_communication technologie_de_communication) {
        technologie_de_communications.add(technologie_de_communication);
    }

    void afficherBoissons() {
        for (Boisson boisson : boissons) {
            System.out.println("\n" + boisson);
        }
    }

    void envoyerMessage(String message) {
        for (Technologie_de_communication tech : technologie_de_communications) {
            tech.envoyerMessage(message);
        }
    }

    void donnerBoisson(Commande commande) {
        System.out.println("boisson Rendu  :  " + commande.boisson.nom + ((commande.boisson.avecSucre) ? " avec Sucre" : "  "));
    }

    void rendreMonnaie(int monnaierendu) {
        System.out.println("monnai rendu  : " + monnaierendu);
    }

    void commander() {
        if (!controlleur.verifierEtat()) {
            System.out.println("machine necessite maintenance");
            for (Technologie_de_communication tech : technologie_de_communications) {
                tech.envoyerMessage("machine necessite reparation");
            }
        }
        int id = -1;
        boolean avecSuccre = false;
        String input = "";
        int iteration = 0;
        Scanner sc = new Scanner(System.in);
        afficherBoissons();
        while (id > boissons.size()-1 || id < 0) {
            if (iteration > 0)
                System.out.println("Choix invalide . on va ressayer");
            System.out.println("merci d'entrer le numero de votre choix : ");
            id = sc.nextInt();
            sc.nextLine();
            iteration++;
        }
        iteration = 0;
        while (!(input.equals("oui") || input.equals("non"))) {
            if (iteration++ > 0)
                System.out.println("Choix invalide . on va ressaye");
            System.out.println("voulez vous de succre avec votre boisson : oui/non");
            input = sc.nextLine();
            avecSuccre = input.equals("oui") || (input.equals("non") ? false : false);
        }

        Boisson boisson = null;
        try {
            boisson = (Boisson) boissons.get(id).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        boisson.setAvecSucre(avecSuccre);
        int montant = 0;
        while (montant < boisson.prix) {
            System.out.println("inserer monnaie : ou bien inserer 0 pour annuler");
            int in = sc.nextInt();
            montant += Math.max(in, 0);
            if (in == 0) {
                System.out.println("on va quitter ");
                rendreMonnaie(montant);
                return;
            }
        }

        Commande commande = new Commande(montant, boisson);
        if (commande.monnaierendu > 0) {
            rendreMonnaie(commande.monnaierendu);
        }
        controlleur.effectuerRequette();
        donnerBoisson(commande);
        commandes.add(commande);

    }

    public void voirStatistiques() {
        controlleur.donnerStatistiques(commandes);
    }

    @Override
    public void run() {
        commander();
    }
}
