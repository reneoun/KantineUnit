package yolo;

public class Persoon {
    String bsn;
    String voornaam;
    String achternaam;
    Datum geboortedatum;
    char geslacht;
    Betaalwijze betaalwijze;

    public Persoon(String b, String v, String a, Datum d, char g){
        bsn = b;
        voornaam = v;
        achternaam = a;
        geboortedatum = d;
        geslacht = Character.toLowerCase(g);

        if (!(geslacht == 'm' || geslacht == 'v')){
            System.out.println("Je hebt geen m of v ingevuld, LUL!");
        }
    }

    public Persoon(){
        bsn = "0000000000";
        voornaam = "Niemand";
        achternaam = "GeenAchternaam";
        geboortedatum = new Datum(0,0,0);
        geslacht = 'o';
    }

    public String getGeslacht() {
        if (this.geslacht == 'm') return "Man";
        else if (this.geslacht == 'v') return "Vrouw";
        else return "Onbekend";
    }

    public void setBetaalwijze(Betaalwijze betaalwijze) {
        this.betaalwijze = betaalwijze;
    }

    public Betaalwijze getBetaalwijze() {
        return betaalwijze;
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

    @Override
    public String toString() {
        return this.voornaam+" "+this.achternaam+" "+this.bsn+" "+geboortedatum.getDatumAsString()+" "+getGeslacht();
    }
}
