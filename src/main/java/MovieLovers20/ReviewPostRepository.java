package MovieLovers20;

import org.springframework.data.repository.CrudRepository;

//an interface inherited form CrudRepository
public interface ReviewPostRepository extends CrudRepository<ReviewPost, Integer> {
    public ReviewPost findByUserId(Integer userID);//an abstract method will implement later

}
