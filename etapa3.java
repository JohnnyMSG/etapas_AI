import java.util.Random;

public class etapa3 {

    public static void main(String[] args) {

        cruzamentoBinarios("11010101", "10111011");

    }

    public static void cruzamentoBinarios(String binario1, String binario2) {
        Random random = new Random();

        int tamanhoDoBinario1 = binario1.length();
        int tamanhoDoBinario2 = binario2.length();

        if (tamanhoDoBinario1 > tamanhoDoBinario2) {
            int diferenca = tamanhoDoBinario1 - tamanhoDoBinario2;

            for (int i = 0; i < diferenca; i++) {
                System.out.print(i);
                binario2 = "0" + binario2;
            }

        } else if (tamanhoDoBinario2 > tamanhoDoBinario1) {
            int diferenca = tamanhoDoBinario2 - tamanhoDoBinario1;

            for (int i = 0; i < diferenca; i++) {
                System.out.print(i);
                binario1 = "0" + binario1;
            }
        }

        int numeroCorte = random.nextInt(tamanhoDoBinario1);

        String[] listaB1 = binario1.split("");
        String binario1Parte1 = "";

        String[] listaB2 = binario2.split("");
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
        System.out.println("Seu corte ficou na casa: " + numeroCorte);
        System.out.println();
        System.out.println(binario1Parte1 + " " + binario2Parte2);
        System.out.println();
        System.out.println("===========================================");
        System.out.println();
    }
}
