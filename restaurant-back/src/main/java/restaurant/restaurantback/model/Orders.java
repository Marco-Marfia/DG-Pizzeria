package restaurant.restaurantback.model;

import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   private LocalDate dateOrder = LocalDate.now();

   @ManyToOne
   @NotNull
   @ToString.Exclude
   private User user;

   @ManyToMany
   @NotNull
   @ToString.Exclude
   private List<Food> foods;

   public Orders(LocalDate dateOrder, @NotNull User user, @NotNull List<Food> foods) {
      this.dateOrder = dateOrder;
      this.user = user;
      this.foods = foods;
   }
   
}
