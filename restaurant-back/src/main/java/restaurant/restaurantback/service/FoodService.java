package restaurant.restaurantback.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurant.restaurantback.model.Food;
import restaurant.restaurantback.repository.FoodRepository;

@Service
public class FoodService {

   @Autowired
   FoodRepository foodRepository;

   /* get all */
   public List<Food> getAllFood() {
      List<Food> allFood = foodRepository.findAll();
      if (allFood.size() == 0)
         return null;

      return allFood;
   }

   /* get by id */
   public Food getFoodById(long id) {
      Optional<Food> foodOpt = foodRepository.findById(id);
      if (foodOpt.isPresent())
         return foodOpt.get();

      return null;
   }

   /* create */
   public Food createFood(Food food) {
      Food foodDescr = foodRepository.findFoodByDescription(food.getDescription());
      if (foodDescr != null)
         return null;

      return foodRepository.save(food);
   }

   /* delete */
   public boolean deleteFoodById(long id) {
      Food food = getFoodById(id);
      if (food != null) {
         foodRepository.deleteById(id);
         return true;
      }
      return false;
   }

   /* update */
   public Food updateFood(Food newFood) {
      Food oldFood = getFoodById(newFood.getId());

      if (oldFood != null) {
         oldFood.setName(newFood.getName());
         oldFood.setPrice(newFood.getPrice());
         oldFood.setDescription(newFood.getDescription());
         oldFood.setImgPath(newFood.getImgPath());
         return foodRepository.save(oldFood);
      }

      return null;
   }
}
