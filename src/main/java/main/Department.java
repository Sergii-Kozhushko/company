package main;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import staff.AEmployee;

import java.util.ArrayList;

/**
 * main.Department.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 21-Mar-2023 13:40
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {
   private String name;
   private ArrayList<AEmployee> employees = new ArrayList<>();
   private AEmployee chef;
}
