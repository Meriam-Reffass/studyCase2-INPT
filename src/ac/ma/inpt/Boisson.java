package ac.ma.inpt;

public class Boisson implements Cloneable {
    static int counter;
    int id = counter++;
    String nom;
    int prix;
    boolean avecSucre;

    public Boisson(String nom, int prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public void setAvecSucre(boolean avecSucre) {
        this.avecSucre = avecSucre;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return id +
                " - " + nom +
                " pour " + prix
                ;
    }
}
