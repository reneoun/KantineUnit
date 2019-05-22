import java.util.Iterator;

public class Kassa {

    private KassaRij kassaRij;
    private double omzet;
    private int aantalArtikelenAf;

    /**
     * Constructor
     */
    public Kassa(KassaRij kassarij) {
        // method body omitted
        this.kassaRij = kassarij;
        omzet = 0;
        aantalArtikelenAf = 0;
    }

    /**
     * Vraag het aantal artikelen en de totaalprijs op.
     * Tel deze gegevens op bij de controletotalen die voor
     * de kassa worden bijgehouden. De implementatie wordt
     * later vervangen door een echte betaling door de persoon.
     *
     * @param klant die moet afrekenen
     */
    public void rekenAf(Dienblad klant) {
        // method body omitted
        omzet += klant.getPrijsDienblad();
        aantalArtikelenAf += klant.getAantalArtikelen();
    }

    /**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd,
     * vanaf het moment dat de methode resetWaarden is aangeroepen.
     *
     * @return aantal artikelen
     */
    public int aantalArtikelen() {
        // method body omitted
        return aantalArtikelenAf;
    }

    /**
     * Geeft het totaalbedrag van alle artikelen die de kass
     * zijn gepasseerd, vanaf het moment dat de methode
     * resetKassa is aangeroepen.
     *
     * @return hoeveelheid geld in de kassa
     */
    public double hoeveelheidGeldInKassa() {
        // method body omitted
        return omzet;
    }

    /**
     * reset de waarden van het aantal gepasseerde artikelen en
     * de totale hoeveelheid geld in de kassa.
     */
    public void resetKassa() {
        // method body omitted
        omzet = 0;
        aantalArtikelenAf = 0;
    }
}