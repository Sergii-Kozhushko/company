/**
 * Manager.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 21-Mar-2023 22:22
 */

package staff;

public class Manager extends AEmployee{
    @Override
    public String toString() {
        return super.toString() + ", должность: менеджер";
    }

}
