package restaurant.restaurantback.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurant.restaurantback.model.User;
import restaurant.restaurantback.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/restaurant/user")
@CrossOrigin("http://localhost:5173")
public class UserController {

   @Autowired
   UserService userService;

   @GetMapping("/all")
   public ResponseEntity<List<User>> getAllFood() {
      if (userService.getAllUsers() == null)
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);// 204

      return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
   }

   @GetMapping("/find/{id}")
   public ResponseEntity<User> getUserById(@PathVariable long id) {
      if (userService.getUserById(id) == null)
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);

      return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
   }

   @PostMapping("/login")
   public ResponseEntity<User> userLogin(@RequestBody User user) {
      User userEmail = userService.getUserByEmail(user.getEmail());

      if (userEmail != null && userEmail.getPassword().equals(user.getPassword()))
         return new ResponseEntity<>(userEmail, HttpStatus.OK);

      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }

   @PostMapping("/create")
   public ResponseEntity<User> createUser(@RequestBody User user) {
      if (userService.createUser(user) == null)
         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

      return new ResponseEntity<>(user, HttpStatus.CREATED);
   }

   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteUserById(@PathVariable long id) {
      if (userService.deleteUserById(id) == false)
         return new ResponseEntity<>("l'utente non esiste", HttpStatus.NOT_FOUND);

      return new ResponseEntity<>("utente eliminato", HttpStatus.OK);
   }

   @PutMapping("/update")
   public ResponseEntity<User> updateUser(@RequestBody User newUser) {
      if (userService.updateUser(newUser) == null)
         return new ResponseEntity<User>(HttpStatus.NOT_FOUND);

      return new ResponseEntity<User>(userService.updateUser(newUser), HttpStatus.OK);
   }
}