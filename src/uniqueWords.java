import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Locale;

public class uniqueWords {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();
        String fileName = "C:\\Users\\SMM-02\\Downloads\\sample.txt"; // Replace with your file path

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    System.out.println(word);
                }
                for(String word : words){
                    if(!word.isEmpty()){
                        hs.add(word.toLowerCase());
                    }

                }
                System.out.println(hs);
                System.out.println("______________________________________________________________");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(hs.size());

    }
}
