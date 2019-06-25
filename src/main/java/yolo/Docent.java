package yolo;

import javax.print.DocFlavor;

public class Docent extends Persoon implements KortingskaartHouder{

    private String afdeling;
    private String afkorting;

    public Docent(String bsn, String vnaam, String anaam, Datum datum, char geslacht, String afdeling, String afkorting){
        super(bsn,vnaam,anaam,datum,geslacht);
        this.afdeling = afdeling;
        this.afkorting = afkorting;
    }

    public String getAfdeling() {
        return afdeling;
    }

    public String getAfkorting() {
        return afkorting;
    }

    public void setAfdeling(String afdeling) {
        this.afdeling = afdeling;
    }

    public void setAfkorting(String afkorting) {
        this.afkorting = afkorting;
    }

    @Override
    public String toString() {
        String gegevens1 = super.toString() + "Afdeling: " + getAfdeling() + ". \n" + "Afkorting: " + getAfkorting() + ". \n";
        return gegevens1;
    }

    @Override
    public double geefKortingsPercentage() {
        return 0.25;        //25% Korting voor Docenten.
    }

    @Override
    public boolean heeftMaximum() {
        return true;        //Docenten hebben wel een maximum korting
    }

    @Override
    public double geefMaximum() {
        return 1.00;        //De maximum korting is €1.00
    }
}
