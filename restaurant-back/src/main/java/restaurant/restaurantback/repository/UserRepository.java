package restaurant.restaurantback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.restaurantback.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

   public User findUserByEmail(String email);

   public User findUserByPassword(String password);

}
