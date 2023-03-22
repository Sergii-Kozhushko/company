package staff;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.Generator;
import main.Rating;

/**
 * Employee.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 21-Mar-2023 13:40
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class AEmployee implements Comparable<AEmployee>, IEmployee {
   private String name;
   private int age;
   private int salary;
   private Rating rating;


   @Override
   public void recalculateSalary() {
      salary = salary + salary/100 * rating.getValue();
   }

   @Override
   public int compareTo(AEmployee o) {
      int result = this.name.compareTo(o.name);
      if (result == 0){
         result = this.age - o.age;
      }
      if (result == 0){
         result = this.salary - o.salary;
      }
      return result;
   }

   @Override
   public String toString() {
      return
                name + '\'' +
              ", " + age +
              " лет, зп=" + salary +
              "EUR, rating=" + rating
              ;
   }
}
