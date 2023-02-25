package MovieLovers20;


import org.json.JSONArray;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

import java.util.*; //import for the List implements and the Collections.sort method will use

@Controller
public class ShowtimesController {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
    @GetMapping("/daily_recommendation")
    public String getMovie(Model model){
        List<Movie> movieList = new ArrayList<Movie>();//create a List implement by ArrayList to store movie objs
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("https://api.themoviedb.org/3/trending/all/day?api_key=6218b17e84fa922def0efde5a70885e4",
                                                    String.class);
        JSONObject root = new JSONObject(response);
        JSONArray data = root.getJSONArray("results");//fetch the results array of the api for processing

        //loop the JSONArray data
        for(int i = 0; i < data.length(); i++){
            JSONObject jsonMovie = data.getJSONObject(i);
            Movie movie = new Movie();//a new instance of movie to store the data from API JSONObject

            if(jsonMovie.has("title")) { //only fetch the data of the obj which key is title
                String backdrop_path = jsonMovie.getString("backdrop_path");
                String title = jsonMovie.getString("title");
                String original_language = jsonMovie.getString("original_language");
                String overview = jsonMovie.getString("overview");
                Double vote_average = jsonMovie.getDouble("vote_average");//score out of 10

                //set the feching data into movie instance
                movie.setBackdrop_path(backdrop_path);
                movie.setTitle(title);
                movie.setOriginal_language(original_language);
                movie.setOverview(overview);
                movie.setVote_average(vote_average);

                //add the processed movie obj with data in the arraylist
                movieList.add(movie);
            }

            //sort the movie objs from highest value to lowest value
            //in order to show the recommandation movies for user from the best one
            Collections.sort(movieList, Collections.reverseOrder());
        }
        model.addAttribute("movieList", movieList); //add the movielist to model will use in thymeleaf

//        model.addAttribute("response", movieList.get(0));
//        model.addAttribute("response1", movieList.get(1));
//        model.addAttribute("response2", movieList.get(2));
        //model.addAttribute("response2", movieList.get(3));
        //System.out.println(response);
        return "API_showtimes";
    }
}//class
