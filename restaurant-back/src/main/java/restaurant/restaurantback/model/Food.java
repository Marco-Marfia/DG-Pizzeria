package restaurant.restaurantback.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @Column(unique = true)
   @NotNull
   private String name;

   @NotNull
   private String imgPath;

   @NotNull
   private String description;

   @NotNull
   private double price;

   @ManyToMany(mappedBy = "foods", cascade = CascadeType.ALL)
   @JsonIgnore
   private List<Orders> orders;

   public Food(String name, String imgPath, String description, double price, List<Orders> orders) {
      this.name = name;
      this.imgPath = imgPath;
      this.description = description;
      this.price = price;
      this.orders = orders;
   }
}
