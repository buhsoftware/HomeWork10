import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Task1Test {
    public static void main(String[] args) {
        try(FileInputStream fileInputStream = new FileInputStream("task1.txt"))
        {
            Scanner scanner = new Scanner(fileInputStream);
            String regex = "^[(]?[0-9]{3}[)-] ?[0-9]{3}-[0-9]{4}$";

            while (scanner.hasNext())
            {
                String line = scanner.nextLine();
                if (Pattern.matches(regex,line))
                System.out.println(line);
            }
            scanner.close();
        }
        catch (IOException ex)
        {System.out.println(ex.getMessage());}
    }
}
