package ac.ma.inpt;

public class Technologie_de_communication {
    String type;

    public Technologie_de_communication(String type) {
        this.type=type;
    }

    void envoyerMessage(String message) {
        System.out.println("envoi de message '"+message+"' en utilisant la technologie " + type);
    }

    void recevoirMessage() {
        System.out.println("reception de message  en utilisant la technologie " + type);

    }
}
