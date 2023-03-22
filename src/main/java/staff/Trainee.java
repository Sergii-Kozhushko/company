package staff;

import lombok.Getter;
import staff.AEmployee;

/**
 * staff.Trainee.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 21-Mar-2023 15:01
 */

@Getter
public class Trainee extends AEmployee {
   int trialPeriod; // monthes
   @Override
   public String toString() {
      return super.toString() + ", должность: стажер";
   }

}
