import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import models.Movie;
import models.Store;

public class Main {
    static Store store = new Store();
    public static void main(String[] args) {
        System.out.println("\n********************JAVA VIDEO STORE********************\n");
       
        
        try{
            loadMovies("movies.txt");
            System.out.println("Movies Loaded\n\n");
            System.out.println(store);
            manageMovies();
        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void manageMovies(){
        Scanner scan = new Scanner(System.in);
        while (true){
            System.out.println("\nWould you like to \n\ta) purchase\n\tb) rent \n\tc) return");
            String response = scan.nextLine();

            if (!(response.equals("a") || response.equals("b") || response.equals("c"))) {
                scan.close();
                break;
            }

            System.out.print("Enter the name of the movie: ");
            String name = scan.nextLine();
            if (name.isBlank()) {
                System.out.println("\n\nInvalid input. Please try again.");
                continue;
            }
            switch( response) {
                case "a":
                if (!(store.getMovie(name).isAvailable())) {
                    System.out.println("\n\n\n\nThe movie is not available.");
                    continue;
                }
                 store.action(name, "sell"); break;
                case "b": store.action(name, "rent"); break;
                case "c": store.action(name, "return"); break;
            }
            System.out.println("\n\nUpdated movies\n\n" + store);
        }
    }

    public static void loadMovies(String fileName) throws FileNotFoundException{
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scanFile = new Scanner(fis);

        while (scanFile.hasNextLine()) {
            String line = scanFile.nextLine();
            String[] words = line.split("--");
            store.addMovie(new Movie(words[0], words[1], Double.parseDouble(words[2])));
        }
        scanFile.close();
    }

}
