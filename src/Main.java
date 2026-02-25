import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Commandpass cm = new Commandpass();
        DB db = new DB();

        while (true) {
            String in = sc.nextLine();

            Command cmd = cm.parse(in);
            try{

                switch (cmd.type) {

                    case PUT:
                        db.put(cmd.key, cmd.value, cmd.ttl);
                        break;

                    case GET:
                        System.out.println( db.get(cmd.key));
                        break;

                    case DELETE:
                        db.delete(cmd.key);
                        break;

                    case START:
                        db.start();
                        break;

                    case STOP:
                        db.stop();
                        break;

                    case EXIT:
                        return;
                }}catch (RuntimeException e) {  // 🔹 catch block
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}