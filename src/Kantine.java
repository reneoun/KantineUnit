public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;

    public Kantine() {
        kassarij = new KassaRij();
        kassa = new Kassa(kassarij);
    }

    public void loopPakSluitAan() {
        Dienblad dienblad = new Dienblad();
        dienblad.voegToe(new Artikel("dildo", 5.99));
        dienblad.voegToe(new Artikel("buttplug", 9.99));
        kassarij.sluitAchteraan(dienblad);
    }

    public void verwerkRijVoorKassa() {
        while(kassarij.erIsEenRij()) {
            kassa.rekenAf(kassarij.eerstePersoonInRij());
        }
    }

    public double hoeveelheidGeldInKassa() {
        return kassa.hoeveelheidGeldInKassa();
    }

    public int aantalArtikelen() {
        return kassa.aantalArtikelen();
    }

    public void resetKassa() {
        kassa.resetKassa();
    }
}