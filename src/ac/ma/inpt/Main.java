package ac.ma.inpt;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Distributeur distributeur   = new Distributeur(1,"Salle de jeux");
        distributeur.ajouterBoisson(new Boisson("The",5));
        distributeur.ajouterBoisson(new Boisson("Cafe",7));
        distributeur.ajouterBoisson(new Boisson("Cafe au lait",7));


        distributeur.ajouterTechnologie_de_communication(new Technologie_de_communication("zigbee"));


        new  Thread(distributeur).start();

        System.out.println("on va voir les statistiques maintenant");
        distributeur.voirStatistiques();


        System.out.println("on va maintenant envoyer un message sur les tech ...");
        distributeur.envoyerMessage("machine en bon etat");

    }
}
