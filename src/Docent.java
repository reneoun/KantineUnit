import javax.print.DocFlavor;

public class Docent extends Persoon {

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

    public String toString() {
        return "Docent "+voornaam+" is net naar binnengekomen.";
    }
}