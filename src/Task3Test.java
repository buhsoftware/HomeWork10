import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Task3Test {
    public static void main(String[] args) {
        try(FileInputStream fileInputStream = new FileInputStream("words.txt"))
        {
            Scanner scanner = new Scanner(fileInputStream);

            String[] splitArray;
            Integer count;
            HashMap<String, Integer> myHashMap = new HashMap<>();

            while (scanner.hasNext())
            {
                String line = scanner.nextLine();
                splitArray = line.split(" ");
                for (String str : splitArray) {
                    count = myHashMap.get(str);
                    if (count == null)
                    {myHashMap.put(str,1);}
                    else{
                        count++;
                        myHashMap.put(str,count);
                    }
                }
            }

            List list = new ArrayList(myHashMap.entrySet());
            Collections.sort(list, (Comparator<Map.Entry<String, Integer>>) (a, b) -> b.getValue() - a.getValue());
            System.out.println("list = " + list);
            scanner.close();
        }
        catch (IOException ex)
        {System.out.println(ex.getMessage());}
    }
}
