package restaurant.restaurantback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.restaurantback.model.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {

   public Food findFoodByDescription(String description);

}
