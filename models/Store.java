package models;

import java.util.ArrayList;
import java.util.Collection;

public class Store {
    private ArrayList<Movie> movies;

    public Store() {
        this.movies = new ArrayList<Movie>();
    }

    public Movie getMovie(int index){
        return new Movie(this.movies.get(index));
    }

    public void setMovie(int index, Movie movie ){
        this.movies.set(index, new Movie(movie));
    }

    public void addMovie(Movie movie) {
        this.movies.add(new Movie(movie));
    }

    //loops through movies array list and then action decides what is being performed
    //instead of using three functions to find movie in list, it's done once
    public void action(String name, String action){
        for (int i = 0; i < this.movies.size(); i++) {
            if (this.movies.get(i).getName().equals(name)){
                switch(action){
                    case "sell": this.movies.remove(i);
                    break;
                    case "rent": this.movies.get(i).setAvailable(false);
                    break;
                    case "return": this.movies.get(i).setAvailable(true);
                    break;
                }
            }
        }
    }

    


}
