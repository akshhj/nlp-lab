import java.util.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter regex: ");
        String regex = sc.nextLine();
        Pattern p = Pattern.compile(regex);
        System.out.print("Enter string: ");
        String str = sc.nextLine();
        System.out.println(p.matcher(str).matches() ? "String matches pattern." : "String does not match pattern.");
        
    }
}
