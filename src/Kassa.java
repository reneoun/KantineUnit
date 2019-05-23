import java.util.Iterator;

public class Kassa {

    private KassaRij kassaRij;
    private double omzet;
    private int aantalArtikelenAf;

    public Kassa(KassaRij kassarij) {
        this.kassaRij = kassarij;
        omzet = 0;
        aantalArtikelenAf = 0;
    }

    public void rekenAf(Dienblad klant) {
        omzet += klant.getPrijsDienblad();
        aantalArtikelenAf += klant.getAantalArtikelen();
    }

    public int aantalArtikelen() {
        return aantalArtikelenAf;
    }

    public double hoeveelheidGeldInKassa() {
        return omzet;
    }

    public void resetKassa() {
        omzet = 0;
        aantalArtikelenAf = 0;
    }
}