import java.util.Scanner;

public class Utils {
    public static String input(String message){
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextLine();
    }

    public static int inputInt(String message){
        while (true) { 
            String x = input(message);
            try {
                int y = Integer.parseInt(x);
                if (y<=0) {
                    throw new Exception();
                }
                return y;
            } catch (Exception e) {
                System.out.println("\n\tResposta Inválida. Tente Novamente!\n");
            }
        }
    }

}
