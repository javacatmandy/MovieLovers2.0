package MovieLovers20;

import java.beans.JavaBean;

//@JsonIgnoreProperties(ignoreUnknown = true)
@JavaBean
public class Actor {
    /*
    "id": "nm0000204",
      "resultType": "Name",
      "image": "https://m.media-amazon.com/images/M/MV5BYzU0ZGRhZWItMGJlNy00YzlkLWIzOWYtNDA2NzlhMDg3YjMwXkEyXkFqcGdeQXVyMDM2NDM2MQ@@._V1_Ratio1.0000_AL_.jpg",
      "title": "Natalie Portman",
      "description": "Actress, Black Swan (2010)"
     */
    private String searchName;
    private String title;//actor name
    private String description;//actor description+moviename+movieyear
    private String image;
    public Actor() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override //override toString method for print testing
    public String toString() {
        return "Actors{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
