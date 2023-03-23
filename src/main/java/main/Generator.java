package main;

import staff.*;

import java.util.ArrayList;
import java.util.Random;

/**
 * main.Generator.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 21-Mar-2023 13:49
 */

public class Generator {
    public static final int DEPARTMENTS_NUMBER = 5; // количество отделов
    // in order of importance
    public static final String[] DEPARTMENT_NAMES =
            {"Управление", "Разработчики", "Отдел QA", "Отдел продаж", "Бугалтерия", "Учебный отдел", "Логистика"};
    public static final String[] COMPANY_NAMES =
            {"MyCompany", "Microsoft", "JetBrains", "Epam", "Adobe", "Ubisoft"};// примеры компаний

    // сгенерировать общие параметры сотрудника - имя, зп, возраст
    public static void generateGeneralValues(AEmployee employee) {
        Random random = new Random();
        employee.setName(generateRandomFullName());
        employee.setAge(random.nextInt(18, 60));
        int minSalary = 3_000, maxSalary = 5_000;
        if (CEO.class.equals(employee.getClass())) {
            minSalary = 10_000;
            maxSalary = 50_000;
        }
        if (Manager.class.equals(employee.getClass())) {
            minSalary = 4_000;
            maxSalary = 6_000;
        }
        if (OfficeWorker.class.equals(employee.getClass())) {
            minSalary = 3_000;
            maxSalary = 5_000;
        }
        if (Trainee.class.equals(employee.getClass())) {
            minSalary = 1_000;
            maxSalary = 2_000;
        }
        employee.setSalary(random.nextInt(minSalary, maxSalary));
        employee.setRating(generateRandomRating());
    }

    // создать компанию, отделы, наполнить отделы
    public static Company createCompany(int employeesNumber) {
        // создаем компанию
        Random random = new Random();
        Company company = new Company();
        company.setName(COMPANY_NAMES[random.nextInt(COMPANY_NAMES.length - 1)]);

        // создаем отделы
        ArrayList<Department> departments = new ArrayList<>(5);
        company.setDepartments(departments);
        EmployeeFactory employeeFactory = new EmployeeFactory();

        // среднее число сотрудников на каждый отдел
        int avgEmployeesNumber = employeesNumber / DEPARTMENTS_NUMBER;

        // создаем отдел управления с гендиректором
        Department departmentMain = new Department();
        departmentMain.setName(DEPARTMENT_NAMES[0]);
        CEO ceo = (CEO) employeeFactory.createEmployee("CEO");
        generateGeneralValues(ceo);
        // можем ли взять ассистента гендиректора? Добиваем остатком после формирования отделов
        if (employeesNumber > 5) {
            int assistantsNumber = employeesNumber % DEPARTMENTS_NUMBER;
            for (int i = 1; i < assistantsNumber; i++) {
                Assistant assistant = (Assistant) employeeFactory.createEmployee("Assistant");
                generateGeneralValues(assistant);
                ceo.getAssistants().add(assistant);
                employeesNumber--;
            }
        }
        employeesNumber--;// CEO
        departmentMain.setChef(ceo);
        departments.add(departmentMain);

        // создаем остальные отделы
        for (int i = 1; i < DEPARTMENTS_NUMBER; i++) {
            Department department = new Department();
            department.setName(DEPARTMENT_NAMES[i]);
            // создаем начальника отдела
            Manager manager = (Manager) employeeFactory.createEmployee("Manager");
            generateGeneralValues(manager);
            department.setChef(manager);
            employeesNumber--;

            // обычные сотрудники офиса
            for (int j = 1; j < avgEmployeesNumber; j++) {
                OfficeWorker officeWorker = (OfficeWorker) employeeFactory.createEmployee("OfficeWorker");
                generateGeneralValues(officeWorker);
                department.getEmployees().add(officeWorker);
                employeesNumber--;
            }

            // если количество сотрудников на отдел > 3, то добавляем 1-го стажера
            if (avgEmployeesNumber > 3) {
                Trainee trainee = (Trainee) employeeFactory.createEmployee("Trainee");
                generateGeneralValues(trainee);
                department.getEmployees().add(trainee);
                employeesNumber--;
            }
            departments.add(department);
        }
        return company;
    }


    public static Rating generateRandomRating() {
        Random random = new Random();
        int r = random.nextInt(0, Rating.values().length);
        Rating result = Rating.values()[r];
        return result;
    }

    public static String generateRandomFullName() {
        return generateRandomName() + " " + generateRandomName();
    }

    // метод генерирует рандомное имя, с заглавной буквой, гласные стоят на 3-м и 5-м месте, так осмысленней
    public static String generateRandomName() {
        String symbolsVowel = "aeiouy";
        String symbolsConsonant = "bcdfghjklmnpqrstvwxz";
        String capitalSymbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        char[] arrayVowel = symbolsVowel.toCharArray();
        char[] arrayConsonant = symbolsConsonant.toCharArray();
        ArrayList<String> arrayList = new ArrayList<>();
        Random random = new Random();
        int n = random.nextInt(3, 10);
        for (int i = 0; i < n; i++) {
            if (i == 2 || i == 4) {
                arrayList.add(i, String.valueOf(arrayVowel[random.nextInt(arrayVowel.length)]));
            } else {
                arrayList.add(i, String.valueOf(arrayConsonant[random.nextInt(arrayConsonant.length)]));
            }
        }

        String result = String.valueOf(capitalSymbols.charAt(random.nextInt(capitalSymbols.length())));
        for (int i = 0; i < arrayList.size(); i++) {
            result += arrayList.get(i);
        }
        return result;
    }

}
