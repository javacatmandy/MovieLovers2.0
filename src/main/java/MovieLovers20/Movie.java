package MovieLovers20;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.beans.JavaBean;

//@JsonIgnoreProperties(ignoreUnknown = true)
@JavaBean
public class Movie implements Comparable<Movie> {
    private String backdrop_path;
    private String title;
    //private String name;
    private String original_language;
    private String overview;
    private Double vote_average;

    public Movie() {
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }

    @Override
    public String toString(){
        return "Movie { "+
                "genre = "+ title +'\'' +
                ", Title = "+ original_language + '\''+
                overview + '\''+
                vote_average + '\''+" } ";
    }
    //override the comparable method to sort the api obj by vote_average
    @Override
    public int compareTo(Movie m) {
        return this.getVote_average().compareTo(m.getVote_average());
    }


}
