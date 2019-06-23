public class KantineMedewerker extends Persoon {

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
}
