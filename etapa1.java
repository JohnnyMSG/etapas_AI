import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

public class etapa1 {

    public static void main(String[] args) {

        ArrayList<Integer> vetores = gerarVetores(50);

        calculoMatematico(vetores);

    }

    public static ArrayList<Integer> gerarVetores(int tamanho) {
        ArrayList<Integer> vetores = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i < tamanho + 1; i++) {
            Integer vetor = random.nextInt(101);
            vetores.add(vetor);
        }

        System.out.println(vetores);
        return vetores;
    }

    public static void calculoMatematico(ArrayList<Integer> listVetores) {

        for (int i = 0; i < listVetores.size(); i++) {

            int x = listVetores.get(i);
            double resultado = Math.abs(x * Math.sin(Math.sqrt(Math.abs (x))));

            System.out.println();
            System.out.println();
            System.out.println("============ Posição " + (i + 1) + " ============");
            System.out.println();
            System.out.println("Número a ser calculado: " + x);
            System.out.println();
            System.out.println("Math.abs(" + x + " * Math.sin(Math.sqrt(Math.abs(" + x + "))))");
            System.out.println();
            System.out.println("Resultado: " + resultado);
            System.out.println();
            System.out.println("====================================");
            System.out.println();

        }
    }

}
