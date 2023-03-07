package restaurant.restaurantback.model;

import java.util.List;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "userSystem")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @Length(min = 3)
   private String username;

   private String password;

   @Column(unique = true)
   private String email;

   @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
   @JsonIgnore
   private List<Orders> orders;

   public User(@Length(min = 3) String username, String password, String email, List<Orders> orders) {
      this.username = username;
      this.password = password;
      this.email = email;
      this.orders = orders;
   }
}
