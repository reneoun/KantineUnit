import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;
    public String[] artikelnamen = {"RoomKaas","Tonijn","Octopoes","Tepelhaar","Soep","Energy Blikjes","Shit"};
    public double[] artikelprijzen = {6.66,3.21,5.45,4.20,6.45,9.12,5.21};

    public Kantine() {
        kassarij = new KassaRij();
        kassa = new Kassa(kassarij);

    }

    public void loopPakSluitAan() {
        Dienblad dienblad = new Dienblad();
        int t = ThreadLocalRandom.current().nextInt(1,6+1);
        for (int s = 0; s < t; s++) {
            int x = ThreadLocalRandom.current().nextInt(1,6+1);
            dienblad.voegToe(new Artikel(artikelnamen[x],artikelprijzen[x]));
        }
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