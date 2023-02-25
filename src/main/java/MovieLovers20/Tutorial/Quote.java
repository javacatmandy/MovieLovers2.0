package MovieLovers20.Tutorial;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {
    private String content;
    private String author;

    public Quote(){

    }
    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }

    @Override
    public String toString(){
        return "Quote { "+
                "content = "+content+'\'' +
                ", author = "+author+" } ";
    }
}