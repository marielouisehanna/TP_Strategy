// Main class to test the Chain of Responsibility
public class Utilisateur {
    public static void main(String[] args) {
        ObjetBase vehicule1 = new Vehicule("Auto++ KT500 used vehicle in good condition");
        System.out.println(vehicule1.getDescription());

        ObjetBase modele1 = new Modele("KT400", "Spacious and comfortable vehicle");
        ObjetBase vehicule2 = new Vehicule(null);
        vehicule2.setSuivant(modele1);
        System.out.println(vehicule2.getDescription());

        ObjetBase marque1 = new Marque("Auto++", "The brand of cars", "of high quality");
        ObjetBase modele2 = new Modele("KT700", null);
        modele2.setSuivant(marque1);

        ObjetBase vehicule3 = new Vehicule(null);
        vehicule3.setSuivant(modele2);
        System.out.println(vehicule3.getDescription());

        ObjetBase vehicule4 = new Vehicule(null);
        System.out.println(vehicule4.getDescription());
    }
}

// Abstract base class for Chain of Responsibility
abstract class ObjetBase {
    protected ObjetBase suivant;

    private String descriptionParDefaut() {
        return "description par defaut";
    }

    protected abstract String description();

    public String getDescription() {
        String result = this.description();
        if (result != null) return result;
        if (suivant != null) return suivant.getDescription();
        return this.descriptionParDefaut();
    }

    public void setSuivant(ObjetBase suivant) {
        this.suivant = suivant;
    }
}

// Concrete class for vehicles
class Vehicule extends ObjetBase {
    String description;

    public Vehicule(String description) {
        this.description = description;
    }

    protected String description() {
        return description;
    }
}

// Concrete class for models
class Modele extends ObjetBase {
    String nom_modele, description;

    public Modele(String nom_modele, String description) {
        this.nom_modele = nom_modele;
        this.description = description;
    }

    protected String description() {
        if (nom_modele != null && description != null)
            return "modele " + nom_modele + ": " + description;
        return null;
    }
}

// Concrete class for brands
class Marque extends ObjetBase {
    String nom_marque, nom_modele, description;

    public Marque(String nom_marque, String nom_modele, String description) {
        this.nom_marque = nom_marque;
        this.nom_modele = nom_modele;
        this.description = description;
    }

    protected String description() {
        if (nom_marque != null && nom_modele != null && description != null)
            return "marque " + nom_marque + ": " + nom_modele + description;
        return null;
    }
}
