package restaurant.restaurantback.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurant.restaurantback.model.User;
import restaurant.restaurantback.repository.UserRepository;

@Service
public class UserService {

   @Autowired
   UserRepository userRepository;

   /* get all */
   public List<User> getAllUsers() {
      List<User> allUser = userRepository.findAll();

      if (allUser.size() == 0)
         return null;

      return allUser;
   }

   /* get by id */
   public User getUserById(long id) {
      Optional<User> userOpt = userRepository.findById(id);

      if (userOpt.isPresent())
         return userOpt.get();

      return null;
   }

   /* get user by email */
   public User getUserByEmail(String email) {
      User userEmail = userRepository.findUserByEmail(email);

      if (userEmail != null)
         return userEmail;

      return null;
   }

   /* get user by password */
   public User getUserByPassword(String password) {
      User userPass = userRepository.findUserByPassword(password);

      if (userPass != null)
         return userPass;

      return null;
   }

   /* create */
   public User createUser(User user) {
      User userEmail = userRepository.findUserByEmail(user.getEmail());

      if (userEmail != null)
         return null;

      return userRepository.save(user);
   }

   /* delete */
   public boolean deleteUserById(long id) {
      User user = getUserById(id);

      if (user != null) {
         userRepository.deleteById(id);
         return true;
      }
      return false;
   }

   /* update */
   public User updateUser(User newUser) {
      User oldUser = getUserById(newUser.getId());

      if (oldUser != null) {
         oldUser.setEmail(newUser.getEmail());
         oldUser.setPassword(newUser.getPassword());
         oldUser.setUsername(newUser.getUsername());
         return userRepository.save(oldUser);
      }
      return null;
   }
}