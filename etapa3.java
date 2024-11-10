public class etapa3 {

    public static void main(String[] args) {

        cruzamentoBinarios("11010101", "10111011", 4);

    }

    public static void cruzamentoBinarios(String binario1, String binario2, int numeroCorte) {
        String[] listaB1 = binario1.split("");
        String binario1Parte1 = "";
        String binario1Parte2 = "";

        String[] listaB2 = binario2.split("");
        String binario2Parte1 = "";
        String binario2Parte2 = "";

        for (int i = 0; i < listaB1.length; i++) {
            if (i < numeroCorte) {
                binario1Parte1 = binario1Parte1 + listaB1[i];
            }
        }

        for (int i = 0; i < listaB2.length; i++) {
            if (i >= numeroCorte) {
                binario2Parte2 = binario2Parte2 + listaB2[i];
            }
        }

        System.out.println();
        System.out.println("============ Binários cruzados ============");
        System.out.println();
        System.out.println(binario1Parte1 + " " + binario2Parte2);
        System.out.println(binario2Parte1 + " " + binario1Parte2);
        System.out.println();
        System.out.println("===========================================");
        System.out.println();
    }
}
