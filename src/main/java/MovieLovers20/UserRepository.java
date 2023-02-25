package MovieLovers20;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


//this will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete

//an interface inherited form CrudRepository
public interface UserRepository extends CrudRepository<User, Integer> {

    //an abstract method with signatures.
    public User findByPasswordAndEmail(String password, String email);


}
