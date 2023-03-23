package main;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import staff.AEmployee;
import staff.Assistant;
import staff.CEO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * main.Company.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 21-Mar-2023 13:38
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    private String name;
    private ArrayList<Department> departments = new ArrayList<>();

    public boolean isCEO(AEmployee employee){
        return employee.getClass() == CEO.class;
    }

    // метод пересчитывает зарплаты сотрудников в завсисимости от рейтинга
    public void recalculateSalaries() {
        for (Department department : departments) {
            ArrayList<AEmployee> elist = department.getEmployees();
            AEmployee manager = department.getChef();
            manager.recalculateSalary();
            if (isCEO(manager)){
                ArrayList<Assistant> alist = ((CEO)manager).getAssistants();
                for (Assistant assistant : alist){
                    assistant.recalculateSalary();
                }
            }

            for (AEmployee employee : elist) {
                employee.recalculateSalary();
            }
        }
    }

    // распечатать отделы, руководителей отделов и их сотрудников
    public void printStaffByDepartments() {
        System.out.println("Компания \"" + name + "\"");
        for (Department department : departments) {
            System.out.print("  Отдел \"" + department.getName() + "\". ");
            System.out.println("Руководитель \"" + department.getChef() + "\"");
            ArrayList<AEmployee> elist = department.getEmployees();
            System.out.println("    Сотрудники:");
            for (int i = 0; i < elist.size(); i++) {
                System.out.printf("      %2d. %-70s%n", i + 1, elist.get(i));
            }
            System.out.println();
        }
    }

    // просто распечатать всех сотруднкиов одним списком
    public void printStaffOneList() {
        System.out.println("Компания \"" + name + "\"");
        int counter = 1;
        for (Department department : departments) {
            System.out.printf("%2d. %-70s%n", counter, department.getChef());
            ArrayList<AEmployee> elist = department.getEmployees();
            for (AEmployee employee : elist) {
                System.out.printf("%2d. %-70s%n", counter, employee);
                counter++;
            }
            counter++;
        }
    }

    // получить список всех сотрудников компании
    public ArrayList<AEmployee> getStaffInOneList() {
        ArrayList<AEmployee> result = new ArrayList<>();
        for (Department department : departments) {
            ArrayList<AEmployee> elist = department.getEmployees();
            result.addAll(elist);
            result.add(department.getChef());
            // добавляем ассистентов гендиректора
            if (isCEO(department.getChef())) {
                ArrayList<Assistant> assistants = ((CEO) department.getChef()).getAssistants();
                result.addAll(assistants);
            }
        }
        return result;
    }

    // распечатать сотрудников, сортировка по рейтингу
    public void printStaffSortByRating() {
        ArrayList<AEmployee> list = getStaffInOneList();
        Comparator<AEmployee> comparator = (o1, o2) ->
                o2.getRating().getValue() - o1.getRating().getValue();
        Collections.sort(list, comparator);
        System.out.println("Компания \"" + name + "\". Список сотрудников, отсортированных по рейтингу");
        int counter = 1;
        for (AEmployee employee : list) {
            System.out.printf("%2d. %-70s%n", counter, employee);
            counter++;
        }
    }

}
