import java.time.LocalDate;

public class Kassa {

    private KassaRij kassaRij;
    private double omzet;
    private int aantalArtikelenDoor;
    private javax.persistence.EntityManager manager;

    public Kassa(KassaRij kassarij, javax.persistence.EntityManager manager) {
        this.kassaRij = kassarij;
        omzet = 0;
        aantalArtikelenDoor = 0;
        this.manager = manager;
    }

    public void rekenAf(Dienblad klant){

        Persoon persoon = klant.getPersoon();

        double totaal = 0;          //Word totaalprijs van het dienblad
        int aantalArtikel = 0;      //Het aantal artikelen van het dienblad

        LocalDate datum = LocalDate.now();
        Factuur factuur = new Factuur(klant,datum);

        omzet += factuur.getTotaal();
    }

    public int aantalArtikelen() {
        return aantalArtikelenDoor;
    }

    public double hoeveelheidGeldInKassa() {
        return omzet;
    }

    public void resetKassa() {
        omzet = 0;
        aantalArtikelenDoor = 0;
    }
}