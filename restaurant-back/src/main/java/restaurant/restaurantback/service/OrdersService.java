package restaurant.restaurantback.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurant.restaurantback.model.Orders;
import restaurant.restaurantback.repository.OrdersRepository;

@Service
public class OrdersService {

   @Autowired
   OrdersRepository ordersRepository;

   /* get all */
   public List<Orders> getAllOrders() {
      List<Orders> allOrders = ordersRepository.findAll();
      if (allOrders.size() == 0)
         return null;

      return allOrders;
   }

   /* get by id */
   public Orders getOrderById(long id) {
      Optional<Orders> ordersOpt = ordersRepository.findById(id);
      if (ordersOpt.isPresent())
         return ordersOpt.get();

      return null;
   }

   /* orders's user */
   public List<Orders> getOrdersByUserId(long id) {
      List<Orders> allOrders = getAllOrders();
      List<Orders> userOrders = new ArrayList<Orders>();

      for (Orders order : allOrders) {
         if (order.getUser().getId() == id) {
            userOrders.add(order);
         }
      }

      if (userOrders.isEmpty())
         return null;

      return userOrders;
   }

   /* create */
   public Orders createOrder(Orders order) {
      if (order.getFoods().size() == 0 || order.getUser() == null)
         return null;

      return ordersRepository.save(order);
   }

   /* delete */
   public boolean deleteOrderById(long id) {
      Orders order = getOrderById(id);

      if (order != null) {
         ordersRepository.deleteById(id);
         return true;
      }
      return false;
   }

   /* update */
   public Orders updateOrder(Orders newOrder) {
      Orders oldOrder = getOrderById(newOrder.getId());

      if (oldOrder != null) {
         oldOrder.setFoods(newOrder.getFoods());
         oldOrder.setUser(newOrder.getUser());
         return ordersRepository.save(oldOrder);
      }
      return null;
   }
}