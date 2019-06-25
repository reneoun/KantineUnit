package yolo;



public class KantineMedewerker extends Persoon implements KortingskaartHouder {

    private int mederwerkersnummer;
    private boolean kassawaardig;

    public KantineMedewerker(String bsn, String vnaam, String anaam, Datum datum, char geslacht, int mederwerkersnummer, boolean kassawaardig) {
        super(bsn,vnaam,anaam,datum,geslacht);
        this.mederwerkersnummer = mederwerkersnummer;
        this.kassawaardig = kassawaardig;
    }

    public boolean isKassawaardig() {
        return kassawaardig;
    }

    public int getMederwerkersnummer() {
        return mederwerkersnummer;
    }

    public void setKassawaardig(boolean kassawaardig) {
        this.kassawaardig = kassawaardig;
    }

    public void setMederwerkersnummer(int mederwerkersnummer) {
        this.mederwerkersnummer = mederwerkersnummer;
    }

    public String toString() {
        String kw = "";
        if(kassawaardig){
            kw = "ja";
        }
        else{
            kw = "nee";
        }
        String gegevens3 = super.toString() + "Medewerkersnummer: " + getMederwerkersnummer() + ". \n" + "Kassawaardig: " + kw;
        return gegevens3;
    }

    @Override
    public double geefKortingsPercentage() {
        return 0.35;    // 35% korting voor Kantine Medewerkers.
    }

    @Override
    public boolean heeftMaximum() {
        return false;   // Kantine Medewerkers hebben geen maximum
    }

    @Override
    public double geefMaximum() {
        return 0;       //Eigenlijk N.V.T.
    }
}
