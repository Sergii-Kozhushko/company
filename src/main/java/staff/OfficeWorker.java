/**
 * OfficeWorker.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 21-Mar-2023 15:06
 */

package staff;

public class OfficeWorker extends AEmployee {
    @Override
    public String toString() {
        return super.toString() + ", должность: сотрудник офиса";
    }

}
