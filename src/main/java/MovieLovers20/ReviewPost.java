package MovieLovers20;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class ReviewPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer userId;//foreign key
    @NotEmpty(message = "The movieTitle was not entered.")
    private String movieTitle;
    @NotEmpty(message = "The content was not entered.")
    //@Size(min = 20, max = 200, message = "The content must minimum 20 characters and maximum 200 characters")
    private String content;

    public ReviewPost() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    @Override
    public String toString() {
        return "ReviewPost{" +
                "id=" + id +
                ", userId=" + userId +
                ", movieTitle='" + movieTitle + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
