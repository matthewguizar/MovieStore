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
    public Movie getMovie(String name){
        for (int i = 0; i < this.movies.size(); i++) {
            if (this.movies.get(i).getName().equals(name)){
                return new Movie(this.movies.get(i));
            }
        }
        return null;
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
        if (movies.isEmpty()) {
            throw new IllegalStateException("store not in valid state to perform action");
        }
        if (!(action.equals("sell") || action.equals("rent") || action.equals("return"))){
            throw new IllegalArgumentException("MUST BE SELL RENT OR RETURN");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null/blank");
        }
        for (int i = 0; i < this.movies.size(); i++) {
            if (this.movies.get(i).getName().equals(name)){
                switch(action){
                    case "sell": this.movies.remove(i);
                    if (!(movies.get(i).isAvailable())) {
                        throw new IllegalStateException("Movie is not in stock");
                    }
                    break;
                    case "rent": this.movies.get(i).setAvailable(false);
                    break;
                    case "return": this.movies.get(i).setAvailable(true);
                    break;
                }
            }
        }
    }

   
    public String toString() {
        String temp = "";
        for (int i = 0; i < this.movies.size(); i++) {
            temp += this.movies.get(i).toString();
            temp += "\n\n";
            
        }
        return temp;
    }


}
