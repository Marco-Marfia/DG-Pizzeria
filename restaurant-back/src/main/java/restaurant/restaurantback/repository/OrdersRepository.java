package restaurant.restaurantback.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.restaurantback.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

   public List<Orders> findOrdersByUserId(Long id);

}
