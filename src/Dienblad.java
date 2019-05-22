import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Dienblad {
    private ArrayList<Artikel> artikelen;
    private Persoon persoon;

    public Dienblad() {
        this.artikelen = new ArrayList<>();
    }

    public Dienblad(Persoon persoon){
        this();
        this.persoon = persoon;
    }

    public void voegToe(Artikel artikel) {
        this.artikelen.add(artikel);
    }

    public int getAantalArtikelen() {
        return artikelen.size();
    }

    public Double getTotaalPrijs() {
        double totaal = 0.00;

        for(int i = 0; i <= getAantalArtikelen(); i++){
            totaal += artikelen.get(i).getPrice();
        }
        return totaal;
    }

    public Persoon getPersoon() {
        return persoon;
    }

    public void setPersoon(Persoon persoon) {
        this.persoon = persoon;
    }
}

