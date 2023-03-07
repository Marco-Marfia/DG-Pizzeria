package restaurant.restaurantback.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurant.restaurantback.model.Food;
import restaurant.restaurantback.service.FoodService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/restaurant/food")
@CrossOrigin("http://localhost:5173")
public class FoodController {

   @Autowired
   FoodService foodService;

   @GetMapping("/all")
   public ResponseEntity<List<Food>> getAllFood() {
      if (foodService.getAllFood() == null) 
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);// 204
      
      return new ResponseEntity<>(foodService.getAllFood(), HttpStatus.OK);
   }

   @GetMapping("/find/{id}")
   public ResponseEntity<Food> getFoodById(@PathVariable long id) {
      if (foodService.getFoodById(id) == null) 
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      
      return new ResponseEntity<>(foodService.getFoodById(id), HttpStatus.OK);
   }

   @PostMapping("/create")
   public ResponseEntity<String> createFood(@RequestBody Food food) {
      if (foodService.createFood(food) == null) 
         return new ResponseEntity<>("piatto già esistente", HttpStatus.BAD_REQUEST);
      
      return new ResponseEntity<>("piatto creato", HttpStatus.CREATED);
   }

   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteFoodById(@PathVariable long id) {
      if (foodService.deleteFoodById(id) == false) 
         return new ResponseEntity<>("il piatto non esiste", HttpStatus.NOT_FOUND);
      
      return new ResponseEntity<>("piatto eliminato", HttpStatus.OK);
   }

   @PutMapping("/update")
   public ResponseEntity<Food> updateFood(@RequestBody Food newFood) {
      if (foodService.updateFood(newFood) == null) 
         return new ResponseEntity<Food>(HttpStatus.NOT_FOUND);
      
      return new ResponseEntity<Food>(foodService.updateFood(newFood), HttpStatus.OK);
   }
}