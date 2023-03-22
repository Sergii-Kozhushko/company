/**
 * CEO.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 21-Mar-2023 15:04
 */

package staff;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class CEO extends AEmployee{
   private ArrayList<Assistant> assistants = new ArrayList<>();

   public void doMeeting(){
      System.out.println("Ceo makes meeting");
   }

   @Override
   public String toString() {
      return super.toString() + ", должность: CEO";
   }
}
