package restaurant.restaurantback.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurant.restaurantback.model.Orders;
import restaurant.restaurantback.service.OrdersService;

@RestController
@RequestMapping("/api/restaurant/orders")
@CrossOrigin("http://localhost:5173")
public class OrdersController {

   @Autowired
   OrdersService ordersService;

   @GetMapping("/all")
   public ResponseEntity<List<Orders>> getAllOrders() {
      if (ordersService.getAllOrders() == null)
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);// 204

      return new ResponseEntity<>(ordersService.getAllOrders(), HttpStatus.OK);
   }

   @GetMapping("/find/{id}")
   public ResponseEntity<Orders> getOrderById(@PathVariable long id) {
      if (ordersService.getOrderById(id) == null)
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);

      return new ResponseEntity<>(ordersService.getOrderById(id), HttpStatus.OK);
   }

   @GetMapping("/user/find/{id}")
   public ResponseEntity<List<Orders>> getOrdersByUserId(@PathVariable String id) {
      long idUser = Long.parseLong(id);

      if (ordersService.getOrdersByUserId(idUser) == null)
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);

      return new ResponseEntity<>(ordersService.getOrdersByUserId(idUser), HttpStatus.OK);
   }

   @PostMapping("/create")
   public ResponseEntity<Orders> createOrders(@RequestBody Orders orders) {
      if (ordersService.createOrder(orders) == null)
         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

      return new ResponseEntity<>(orders, HttpStatus.CREATED);
   }

   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteOrderById(@PathVariable long id) {
      if (ordersService.deleteOrderById(id) == false)
         return new ResponseEntity<>("l'ordine non esiste", HttpStatus.NOT_FOUND);

      return new ResponseEntity<>("ordine eliminato", HttpStatus.OK);
   }

   @PutMapping("/update")
   public ResponseEntity<Orders> updateFood(@RequestBody Orders newOrders) {
      if (ordersService.updateOrder(newOrders) == null)
         return new ResponseEntity<Orders>(HttpStatus.NOT_FOUND);

      return new ResponseEntity<Orders>(ordersService.updateOrder(newOrders), HttpStatus.OK);
   }
}