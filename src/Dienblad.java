import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Dienblad {
    private ArrayList<Artikel> artikelen;
    private Persoon persoon;
    private String totaalToString;

    public Dienblad() {
        this.persoon = new Persoon("123456789","OCTO","TENTAKEL",new Datum(0,0,0),'m');
        this.artikelen = new ArrayList<>();
    }

    public Dienblad(Persoon persoon){
        this.persoon = persoon;
        artikelen = new ArrayList<>();
    }

    public void voegToe(Artikel artikel) {
        this.artikelen.add(artikel);
    }

    public int getAantalArtikelen() {
        return artikelen.size();
    }

    public String getTotaalPrijs() {
        double totaal = 0;
        for(int i = 0; i <= getAantalArtikelen(); i++){
            totaal = totaal + artikelen.get(i).getPrice();
        }
        totaalToString = Double.toString(totaal);
        return "De totaalprijs bedraagd: " + totaalToString + " euro";
    }

    public double getPrijsDienblad() {
        double prijsDienblad = 0;
        for(int i = 0; i <= getAantalArtikelen(); i++){
            prijsDienblad = prijsDienblad + artikelen.get(i).getPrice();
        }
        return prijsDienblad;
    }

    public Persoon getPersoon() {
        return persoon;
    }

    public void setPersoon(Persoon persoon) {
        this.persoon = persoon;
    }
}

