enum Commandtype {
    PUT, GET, DELETE, START, STOP, EXIT   // fixed command values
}

class Command {
    Commandtype type;
    Integer key;
    String value;
    long ttl;
}

public class Commandpass {

    private Command Command;

    public Command parse(String input) {

        // split by space
        String[] tok = input.trim().split(" ");

        Command m = new Command();

        // convert string to enum
        m.type = Commandtype.valueOf(tok[0].toUpperCase());

        if (m.type == Commandtype.PUT) {
            m.key = Integer.parseInt(tok[1]);
            m.value = tok[2];
            m.ttl = (tok.length == 4) ? Long.parseLong(tok[3]) : -1;
        } else if (m.type == Commandtype.GET || m.type == Commandtype.DELETE) {
            m.key = Integer.parseInt(tok[1]);
        }
        // EXIT needs nothing

        return m;
    }
}
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("Enter command: ");
//        String input = sc.nextLine();
//
//        Commandpass mp = new Commandpass();
//        Command m = mp.parse(input);
//
//        System.out.println("Type  : " + m.type);
//        System.out.println("Key   : " + m.key);
//        System.out.println("Value : " + m.value);
//    }
//}