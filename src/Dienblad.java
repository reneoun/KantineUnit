import java.util.Stack;

public class Dienblad {
    private Stack<Artikel> artikelen;
    private Persoon persoon;
    double totaalPrijs = 0;
    double prijsDienblad = 0;


    public Dienblad() {
        this.artikelen = new Stack<>();
    }

    public Dienblad(Artikel artikel){
        this();
        this.artikelen.push(artikel);
    }

    public void voegToe(Artikel artikel) {
        this.artikelen.push(artikel);
    }

    public int getAantalArtikelen() {
        return artikelen.size();
    }

    public String getTotaalPrijs() {
        for(int i = 0; i <= getAantalArtikelen(); i++){
            totaalPrijs = totaalPrijs + artikelen.get(i).getPrice();
        }
        String totaalToString = Double.toString(totaalPrijs);
        return "De totaalprijs bedraagd: " + totaalToString + " euro";
    }

    public double getPrijsDienblad() {
        for(int i = 0; i < getAantalArtikelen(); i++){
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

