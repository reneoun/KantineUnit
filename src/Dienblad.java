import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Dienblad {
    private ArrayList<Artikel> artikelen;
    private Persoon persoon;
    private String totaalToString;

    public Dienblad() {
        this.artikelen = new ArrayList();
    }

    public Dienblad(Persoon persoon){
        this.persoon = persoon;
    }

    public void voegToe(Artikel artikel) {
        this.artikelen.add(artikel);
    }

    public int getAantalArtikelen() {
        return artikelen.size();
    }

    public String getTotaalPrijs() {
        double totaal = 0;
        double prijs = 0;
        totaalToString = Double.toString(totaal);

        for(int i = 0; i <= getAantalArtikelen(); i++){
            totaal = totaal + artikelen.get(i).getPrice();
        }
        return "De totaalprijs bedraagd: " + totaalToString + " euro";
    }

    public Persoon getPersoon() {
        return persoon;
    }

    public void setPersoon(Persoon persoon) {
        this.persoon = persoon;
    }
}

