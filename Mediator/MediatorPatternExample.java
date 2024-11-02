// Mediator Interface
abstract class DirecteurDeDialogue {
    public abstract void Change(Widget widget);
}

// Concrete Mediator
class DirecteurDeDlgPolice extends DirecteurDeDialogue {
    private BoiteDeListe liste;
    private ChampDeSaisie champ;

    public void CreeWidgets() {
        this.liste = new BoiteDeListe(this);
        this.champ = new ChampDeSaisie(this);
    }

    public void WidgetChange(Widget widget) {
        if (widget == liste) {
            String selectedText = liste.AcqSelection();
            champ.InstalTexte(selectedText);
        } else if (widget == champ) {
            // Additional logic for `ChampDeSaisie` changes, if needed
        }
    }

    @Override
    public void Change(Widget widget) {
        WidgetChange(widget);
    }
}

// Colleague Interface
abstract class Widget {
    protected DirecteurDeDialogue directeur;

    public Widget(DirecteurDeDialogue directeur) {
        this.directeur = directeur;
    }

    public abstract void Change();
}

// Concrete Colleague: BoiteDeListe (List Box)
class BoiteDeListe extends Widget {
    public BoiteDeListe(DirecteurDeDialogue directeur) {
        super(directeur);
    }

    public String AcqSelection() {
        return "Selected Item from List Box"; // Placeholder text for selected item
    }

    @Override
    public void Change() {
        directeur.Change(this);
    }
}

// Concrete Colleague: ChampDeSaisie (Text Field)
class ChampDeSaisie extends Widget {
    private String texte;

    public ChampDeSaisie(DirecteurDeDialogue directeur) {
        super(directeur);
    }

    public void InstalTexte(String texte) {
        this.texte = texte;
        System.out.println("Text Field updated with: " + texte);
    }

    @Override
    public void Change() {
        directeur.Change(this);
    }
}

// Client Code
public class MediatorPatternExample {
    public static void main(String[] args) {
        DirecteurDeDlgPolice mediator = new DirecteurDeDlgPolice();
        mediator.CreeWidgets();

        // Simulate a change in BoiteDeListe (List Box)
        mediator.liste.Change();

        // Optionally, simulate a change in ChampDeSaisie (Text Field)
        mediator.champ.Change();
    }
}
