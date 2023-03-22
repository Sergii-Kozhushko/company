/**
 * EmployeeFactory.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 22-Mar-2023 11:35
 */

package staff;

public class EmployeeFactory {
   public AEmployee createEmployee(String position){
      switch (position){
         case ("Assistant") -> {
            return new Assistant();
         }
         case ("CEO") -> {
            return new CEO();
         }
         case ("Manager") -> {
            return new Manager();
         }
         case ("OfficeWorker") -> {
            return new OfficeWorker();
         }
         case ("Trainee") -> {
            return new Trainee();
         }
      }
      return null;
   }

}
