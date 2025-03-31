
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("\n" + "==".repeat(18) + "  Torre de hannoi  " + "==".repeat(18) + "\n");
        System.out.println("\tSeja bem-vindo ao jogo Torre de Hannoi!");
        System.out.println("\tSeu objetivo é passar todos os anéis da torre 1 para a torre 3, \n\tmas cuidado, não é possível colocar anéis maiores em cima de anéis menores.\n");
        
        int quantAneis = Utils.inputInt("\tQual a quantidade de anéis que deseja jogar? ");

        int quantMovTotais = 0;
        int torrePrincipal[] = new int[quantAneis], torreAuxiliar[] = new int[quantAneis], torreDestino[] = new int[quantAneis];
        String torreFull[] = new String[quantAneis];
        for (int i = 0; i < quantAneis; i++) {
            torreFull[i] = " ".repeat(quantAneis-i)+"=".repeat(i*2+3)+" ".repeat(quantAneis-i);
            torrePrincipal[i] = i+1;
            torreAuxiliar[i] = 0;
            torreDestino[i] = 0;
        }

        System.out.println("""
                \n\tPara movimentar um anel, passe o número da torre que deseja mudar\n\te em seguida a torre destino! Ex. 12 -> Torre 1 para Torre 2.
                """);

        showTowers(torrePrincipal, torreAuxiliar, torreDestino, torreFull, quantAneis);
        

        while (true) { 
            String mov = Utils.input("Qual será o movimento? ");
            if (!validateMov(mov)){
                System.out.println("\nMovimento Inválido! Tente novamente.\n");
                continue;
            }

            if (verifyMov(mov, torrePrincipal, torreAuxiliar, torreDestino)) {
                doMove(mov, torrePrincipal, torreAuxiliar, torreDestino);
                showTowers(torrePrincipal, torreAuxiliar, torreDestino, torreFull, quantAneis);

                quantMovTotais++;
            } else {
                System.out.println("\nMovimento inválido! Tente novamente.\n");
            }

            if (verifyWin(torreDestino)) {
                System.out.println("\n" + "=".repeat(91) + "\n");
                System.out.println("\tParabéns! Você Ganhou.");
                System.out.println("\tTotal de movimentos: " + quantMovTotais);
                System.out.println("\tQuantidade ideal de movimentos: "+Math.round((Math.pow(2, quantAneis)-1)));
                System.out.println("\n" + "=".repeat(91) + "\n");
                break;
            }
        }
    }

    private static boolean verifyWin(int[] torreDestino){
        for (int i = 0; i < torreDestino.length; i++) {
            if (torreDestino[i] == 0) {
                return false;
            }
        }
        return true;
    }

    private static void doMove(String mov, int[] torrePrincipal, int[] torreAuxiliar, int[] torreDestino){
        String[] vetorMov = mov.split("");
        int[] torreMov;
        int[] torreDes;

        switch (vetorMov[0]) {
            case "1" -> {
                torreMov = torrePrincipal;
            }
            case "2" -> {
                torreMov = torreAuxiliar;
            }
            case "3" -> {
                torreMov = torreDestino;
            }
            default -> throw new AssertionError();
        }

        switch (vetorMov[1]) {
            case "1" -> {
                torreDes = torrePrincipal;
            }
            case "2" -> {
                torreDes = torreAuxiliar;
            }
            case "3" -> {
                torreDes = torreDestino;
            }
            default -> throw new AssertionError();
        }

        for (int i = torreMov.length - 1; i >= 0; i--) {
            if (torreDes[i] == 0){
                torreDes[i] = getFirstRing(torreMov);
                for (int c = 0; c < torreMov.length; c++) {
                    if (torreMov[c] == getFirstRing(torreMov)) {
                        torreMov[c] = 0;
                        break;
                    }
                }
                break;
            }
        }
    }

    private static boolean verifyMov(String mov, int[] torrePrincipal, int[] torreAuxiliar, int[] torreDestino){
        String[] vetorMov = mov.split("");
        int[] torreMov;
        int[] torreDes;

        switch (vetorMov[0]) {
            case "1" -> {
                torreMov = torrePrincipal;
            }
            case "2" -> {
                torreMov = torreAuxiliar;
            }
            case "3" -> {
                torreMov = torreDestino;
            }
            default -> throw new AssertionError();
        }

        switch (vetorMov[1]) {
            case "1" -> {
                torreDes = torrePrincipal;
            }
            case "2" -> {
                torreDes = torreAuxiliar;
            }
            case "3" -> {
                torreDes = torreDestino;
            }
            default -> throw new AssertionError();
        }

        if (!isEmpty(torreMov)) {
            return false;
        } 

        if (getFirstRing(torreDes) > 0) {
            if (getFirstRing(torreMov) > getFirstRing(torreDes)) {
                return false;
            }
        }

        return !(torreMov == torreDes);
    }

    private static int getFirstRing(int[] torre){
        for (int i = 0; i < torre.length; i++) {
            if (torre[i] != 0) {
                return torre[i];
            }
        }
        return 0;
    }

    private static boolean isEmpty(int[] torre){
        for (int i = 0; i < torre.length; i++) {
            if (torre[i] != 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean validateMov(String mov){
        String[] vetorMov = mov.split("");
        String possibles = "123";
        return ((vetorMov.length == 2) && possibles.contains(vetorMov[0]) && possibles.contains(vetorMov[1]));
    }

    private static void showTowers(int[] torrePrincipal, int[] torreAuxiliar, int[] torreDestino, String[] torreFull, int quantAneis){
        System.out.println("\n" + "=".repeat(91) + "\n");
        for (int i = 0; i < torrePrincipal.length; i++) {
            if (torrePrincipal[i]!= 0) {
                System.out.print("  " + torreFull[torrePrincipal[i]-1] + "\t\t");
            } else {
                System.out.print("  " + " ".repeat(quantAneis+1) + "|" + " ".repeat(quantAneis+1) + "\t\t");
            }

            if (torreAuxiliar[i]!= 0) {
                System.out.print("  " + torreFull[torreAuxiliar[i]-1] + "\t\t");
            } else {
                System.out.print("  " + " ".repeat(quantAneis+1) + "|" + " ".repeat(quantAneis+1) + "\t\t");
            }

            if (torreDestino[i]!= 0) {
                System.out.print("  " + torreFull[torreDestino[i]-1] + "\t\t");
            } else {
                System.out.print("  " + " ".repeat(quantAneis+1) + "|" + " ".repeat(quantAneis+1) + "\t\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
