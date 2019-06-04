import java.lang.*;

public class KantineSimulatie_1 {

    private Kantine kantine;


    public static final int DAGEN = 50;

    public KantineSimulatie_1() {
        kantine = new Kantine();
    }

    public void simuleer(int dagen) {
        for(int i = 0; i <= dagen; i++) {
            for(int j = 0; j < (10 + i); j++){
                kantine.loopPakSluitAan();
            }
            try {
                Thread.sleep(500);
            } catch (Exception e){
                System.out.println(e);
            }
            kantine.verwerkRijVoorKassa();
            System.out.println("De kassa bevat: " + kantine.hoeveelheidGeldInKassa() + " euro.");
            System.out.println("De kantine beschikt over: " + kantine.aantalArtikelen() + " artikelen.");
            kantine.resetKassa();
        }
    }
    public static void main(String[] args) {
        int dagen;

        if (args.length == 0) {
            dagen = DAGEN;
        } else {
            dagen = Integer.parseInt(args[0]);
        }
        KantineSimulatie_1 kantinesimulatie = new KantineSimulatie_1();
        kantinesimulatie.simuleer(dagen);
    }

}