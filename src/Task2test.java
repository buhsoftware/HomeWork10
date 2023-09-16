import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Task2test {
    public static void main(String[] args) {

        ArrayList<User> users = new ArrayList<>();
        String[] splitArray;

        try(FileInputStream fileInputStream = new FileInputStream("task2.txt"))
        {
            Scanner scanner = new Scanner(fileInputStream);

            if (scanner.hasNext())
                scanner.nextLine();

            while (scanner.hasNext())
            {
                String line = scanner.nextLine();
                splitArray = line.split(" ");
                users.add(new User(splitArray[0],Integer.valueOf(splitArray[1])));
            }

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(users);

            System.out.println(json);

            scanner.close();
        }
        catch (IOException ex)
        {System.out.println(ex.getMessage());}
    }
}

class User
{
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
