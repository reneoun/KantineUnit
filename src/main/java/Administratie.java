public class Administratie {

    private static final int DAYS_IN_WEEK = 7;

    private Administratie(){
    }

    /**
     * Deze methode berekent van de int array aantal de gemiddelde waarde
     *
     * @param aantal
     * @return het gemiddelde
     */
    public static double berekenGemiddeldAantal(int[] aantal) {
        // method body omitted
        double sum = 0;
        for (int i : aantal) {
            sum += i;
        }
        return (sum/aantal.length);
    }

    /**
     * Deze methode berekent van de double array omzet de gemiddelde waarde
     *
     * @param omzet
     * @return het gemiddelde
     */
    public static double berekenGemiddeldeOmzet(double[] omzet) {
        // method body omitted
        double sum = 0;
        for (double i : omzet) {
            sum += i;
        }
        return (sum/omzet.length);
    }

    /**
     * Methode om dagomzet uit te rekenen
     *
     * @param omzet
     * @return array (7 elementen) met dagomzetten
     */

    public static double[] berekenDagOmzet(double[] omzet) {
        double[] temp = new double[7];
        for(int i = 0; i < DAYS_IN_WEEK; i++) {
            boolean b = true;
            int j = 0;
            while( b ) {
                if ((i+7*j) > omzet.length-1) b = false;
                else {
                    temp[i] += omzet[i + 7 * j];
                    j++;
                }
                // omitted
            }
        }
        return temp;
    }
}
