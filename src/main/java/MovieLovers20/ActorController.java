package MovieLovers20;


import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class ActorController {
    @GetMapping("/movie_by_actor") //mapping an input searching form on url /movie_by_actor
    public  String SearchForm( Model model){
        model.addAttribute("actorSearch", new Actor());//create a model to store the input value, the name user want to search
        return "API_movie_by_actor";//render the view of form on this page
    }
    @Bean
    public RestTemplate restTemplateActor(RestTemplateBuilder builder){
        return builder.build();
    }
    @PostMapping("/movie_by_actor")
    public String getActor(@ModelAttribute("actorSearch") Actor actorSearch, Model model){
        List<Actor> actorList = new ArrayList<Actor>();//create an arraylist to store the actor objs
        RestTemplate restTemplate = new RestTemplate();
//        if(actorSearch == null){
//            return "redirect:/movie_by_actor";
//        }
//       else {
            String response = restTemplate.getForObject(("https://imdb-api.com/en/API/SearchName/k_d3dwxcvw/" + actorSearch.getSearchName()),
                    String.class);
            JSONObject root = new JSONObject(response);
            JSONArray data = root.getJSONArray("results");

            //loop the each obj value from API JSON data
            for (int i = 0; i < data.length(); i++) {
                JSONObject jsonActor = data.getJSONObject(i);

                String title = jsonActor.getString("title");
                String description = jsonActor.getString("description");
                String image = jsonActor.getString("image");

                //create a String array, split the description by comma to extract actor name and stored in array index 0
                String[] details = description.split(",");

                //only filter the data obj of who is actor or actress
                //create a field instance of Actor class to make sure only add the filtered obj into the arraylist
                if (description != null && (details[0].equals("Actor") || details[0].equals("Actress"))) {
                    Actor actor = new Actor();
                    actor.setTitle(title);
                    actor.setDescription(description);
                    actor.setImage(image);
                    actorList.add(actor);
                    //System.out.println("Testing*****************************"+ actorList.get(0).getImage());
                }
            }
            model.addAttribute("actorList", actorList);//bind the result arraylist to model later show to user

            return "API_movie_by_actor";
//        }
    }
}//class
