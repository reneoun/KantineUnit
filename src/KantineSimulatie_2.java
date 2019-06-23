import java.util.*;

public class KantineSimulatie_2 {

    //Array van personen
    public ArrayList<Persoon> personen = new ArrayList<>();

    // kantine
    private Kantine kantine;

    // kantineaanbod
    private KantineAanbod kantineaanbod;

    // random generator
    private Random random;

    // aantal artikelen
    private static final int AANTAL_ARTIKELEN = 4;

    // artikelen
    private static final String[] artikelnamen = new String[]
        {"Koffie", "Broodje pindakaas", "Broodje kaas", "Appelsap"};

    // prijzen
    private static double[] artikelprijzen = new double[]{1.50, 2.10, 1.65, 1.65};

    // minimum en maximum aantal artikelen per soort
    private static final int MIN_ARTIKELEN_PER_SOORT = 10000;
    private static final int MAX_ARTIKELEN_PER_SOORT = 20000;

    // minimum en maximum aantal personen per dag
    private static final int MIN_PERSONEN_PER_DAG = 50;
    private static final int MAX_PERSONEN_PER_DAG = 100;

    // minimum en maximum artikelen per persoon
    private static final int MIN_ARTIKELEN_PER_PERSOON = 1;
    private static final int MAX_ARTIKELEN_PER_PERSOON = 4;

    /**
     * Constructor
     *
     */
    public KantineSimulatie_2() {
        kantine = new Kantine();
        random = new Random();
        int[] hoeveelheden = getRandomArray(
            AANTAL_ARTIKELEN,
            MIN_ARTIKELEN_PER_SOORT,
            MAX_ARTIKELEN_PER_SOORT);
        kantineaanbod = new KantineAanbod(
            artikelnamen, artikelprijzen, hoeveelheden, MIN_ARTIKELEN_PER_SOORT);

        kantine.setKantineAanbod(kantineaanbod);
    }

    /**
     * Methode om een array van random getallen liggend tussen
     * min en max van de gegeven lengte te genereren
     *
     * @param lengte
     * @param min
     * @param max
     * @return De array met random getallen
     */
    private int[] getRandomArray(int lengte, int min, int max) {
        int[] temp = new int[lengte];
        for(int i = 0; i < lengte ;i++) {
            temp[i] = getRandomValue(min, max);
        }

        return temp;
    }

    /**
     * Methode om een random getal tussen min(incl)
     * en max(incl) te genereren.
     *
     * @param min
     * @param max
     * @return Een random getal
     */
    private int getRandomValue(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * Methode om op basis van een array van indexen voor de array
     * artikelnamen de bijhorende array van artikelnamen te maken
     *
     * @param indexen
     * @return De array met artikelnamen
     */
    private String[] geefArtikelNamen(int[] indexen) {
        String[] artikelen = new String[indexen.length];

        for(int i = 0; i < indexen.length; i++) {
            artikelen[i] = artikelnamen[indexen[i]];

        }

        return artikelen;
    }

    /**
     * Deze methode simuleert een aantal dagen
     * in het verloop van de kantine
     *
     * @param dagen
     */
    public void simuleer(int dagen) {
        // for lus voor dagen
        for(int i = 0; i < dagen; i++) {

            // bedenk hoeveel personen vandaag binnen lopen
            int aantalpersonen = getRandomValue(MIN_PERSONEN_PER_DAG,MAX_PERSONEN_PER_DAG) ;

            // 100 personen worden hier gemaakt
            for (int x = 0; x < 100; x++){

                String bsn = "bsnnmmr"+x;
                String vnaam = "voornaam"+x;
                String anaam = "achternaam"+x;
                Datum datum = new Datum(x%28,x%12,2000);
                Contant contant = new Contant();
                Pinpas pinpas = new Pinpas();

                int manOfVrouw = getRandomValue(0,1);
                char geslacht = ' ';
                if (manOfVrouw == 0) geslacht = 'M';
                else if (manOfVrouw == 1) geslacht = 'V';


                // 89 Studenten worden hier gemaakt.
                if (x<89) {

                    int studentenummer = Integer.valueOf("" + ((x + 8) % 8) + "420" + ((x + 11) % 11));
                    String studierichting = "";
                    int random = getRandomValue(1, 3);
                    if (random == 1) {
                        studierichting = "NSE";
                    } else if (random == 2) {
                        studierichting = "SE";
                    } else {
                        studierichting = "Bitm";
                    }
                    Student student = new Student(studentenummer,studierichting,bsn,vnaam,anaam,datum,geslacht);

                    pinpas.setKredietLimiet((double) getRandomValue(6,50));         //We geven hier een student een pinpas met geld.
                    student.setBetaalwijze(pinpas);

                    personen.add(student);
                }

                // 10 Docenten worden hiero gemaakt
                else if (x<99) {
                    String alphabet = "QWERTYUIOPASDFGHJKLZXCVBNM";
                    String afdeling = "";
                    String afkorting = "";
                    int random = getRandomValue(1, 3);
                    if (random == 1) {
                        afdeling = "Talen";
                    } else if (random == 2) {
                        afdeling = "Management";
                    } else {
                        afdeling = "Programmeren";
                    }
                    for (int s = 0; s < 4; s++) {
                        afkorting += alphabet.charAt(getRandomValue(0,25));
                    }
                    Docent docent = new Docent(bsn,vnaam,anaam,datum,geslacht,afdeling,afkorting);

                    pinpas.setKredietLimiet((double) getRandomValue(6,50));         //We geven hier een Docent een pinpas met geld.
                    docent.setBetaalwijze(pinpas);

                    personen.add(docent);
                }

                // 1 Kantinemedewerker wordt hier gemaakt
                else {
                    int medewerkersnummer = Integer.valueOf("" + ((x + 8) % 8) + "420" + ((x + 11) % 11));
                    int r = getRandomValue(0,1);
                    boolean kassawaardig;
                    if (r==0) kassawaardig = true;
                    else kassawaardig = false;
                    KantineMedewerker kantineMedewerker = new KantineMedewerker(bsn,vnaam,anaam,datum,geslacht,medewerkersnummer,kassawaardig);

                    contant.setSaldo((double) getRandomValue(2,20));            // We geven hier een Kantine Medewerker contant geld.
                    kantineMedewerker.setBetaalwijze(contant);

                    personen.add(kantineMedewerker);
                }


            }


            // laat de personen maar komen...
            for(int j = 0; j < aantalpersonen; j++) {


                // maak persoon en dienblad aan, koppel ze
                // en bedenk hoeveel artikelen worden gepakt
                Random rndm = new Random();
                int r = rndm.nextInt(100);

                Dienblad dienblad = new Dienblad();
                dienblad.setPersoon(personen.get(r));



                int aantalartikelen = getRandomValue(MIN_ARTIKELEN_PER_PERSOON,MAX_ARTIKELEN_PER_PERSOON);

                // genereer de "artikelnummers", dit zijn indexen
                // van de artikelnamen
                int[] tepakken = getRandomArray(
                    aantalartikelen, 0, AANTAL_ARTIKELEN-1);

                // vind de artikelnamen op basis van
                // de indexen hierboven
                String[] artikelen = geefArtikelNamen(tepakken);

                // loop de kantine binnen, pak de gewenste
                // artikelen, sluit aan
                kantine.loopPakSluitAan(personen.get(r),artikelen);
            }

            try{
                Thread.sleep(500);
            }catch (Exception e) {
                System.out.println(e);
            }

            // verwerk rij voor de kassa
            kantine.verwerkRijVoorKassa();

            // druk de dagtotalen af en hoeveel personen binnen
            // zijn gekomen(printf gebruiken)
            System.out.println("Dag "+(i+1)+": Omzet van "+(Math.round(kantine.hoeveelheidGeldInKassa()*100))/100+" euro & "+kantine.aantalArtikelen()+" artikel afgerekend.");



            // reset de kassa voor de volgende dag
            kantine.resetKassa();
        }
    }


    public static void main(String[] args) {
        KantineSimulatie_2 kantineSimulatie = new KantineSimulatie_2();
        kantineSimulatie.simuleer(15);

        int[] getallen = {45, 56, 34, 39, 40, 31};
        double[] omzet = {567.70, 498.25, 458.90};
        double[] omzetPeriode = {321.35, 450.50, 210.45, 190.85, 193.25, 159.90, 214.25, 220.90, 201.90, 242.70, 260.35};

        System.out.println(Administratie.berekenGemiddeldAantal(getallen));     //gem = 40.8333
        System.out.println(Administratie.berekenGemiddeldeOmzet(omzet));        //gem = 508.2833
//        System.out.printf(Administratie.berekenDagOmzet(omzetPeriode));

    }

}