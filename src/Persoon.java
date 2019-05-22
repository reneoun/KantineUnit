public class Persoon {
    String bsn;
    String voornaam;
    String achternaam;
    Datum geboortedatum;
    Character geslacht;

    public Persoon(String b, String v, String a, Datum d, Character g){
        bsn = b;
        voornaam = v;
        achternaam = a;
        geboortedatum = d;
        geslacht = Character.toLowerCase(g);

        if (!(geslacht == 'm' && geslacht == 'v')){
            System.out.println("Je hebt geen m of v ingevuld, LUL!");
        }
    }

    public String getGeslacht() {
        if (this.geslacht == 'm') return "Man";
        else if (this.geslacht == 'v') return "Vrouw";
        else return "";
    }

    public String getGeboortedatum() {
        return geboortedatum.getDatumAsString();
    }

    public String getAchternaam() {
        return achternaam;
    }

    public String getBsn() {
        return bsn;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public void setBsn(String bsn) {
        this.bsn = bsn;
    }

    public void setGeboortedatum(Datum geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public void setGeslacht(Character geslacht) {
        this.geslacht = geslacht;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

}
