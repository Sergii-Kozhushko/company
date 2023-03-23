package main;

/**
 * main.Main.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 21-Mar-2023 14:07
 */

//1. class main.Company имя и лист департаментов
//2. Энам Департаменты с 5 макисмум департаментами
//3. Класс Эплои с полями имя позраст зарплата и рейтинг
//4. Энам рейтинг
//если рейтинг A то +20%
//B +15%
//C +5%
//D 0%
//E -5%
//5. Класс генератор который создает Эмплои и засовывет его в рандомный
// департамент с рандомным рейтингом и зарплатой
//Эмплои должен иметьспособность сравниматься по всем полям кроме ретинга
//6. Сделать отдельный компаратор который сортирует по рейтингу

//7. В классе Мэйн надо прописать только один метод с параметром
// количеством сотрудников который с генерирует весь этот процесс
// выведет на экран Сотрудника с зп ДО и После

public class ApplicationStart {
   public static void main(String[] args) {

      Company company = Generator.createCompany(24);

      company.printStaffByDepartments();
      company.recalculateSalaries();
      //company.printStaffOneList();// Печатает всех сотрудников без сортировки
      company.printStaffSortByRating();
   }

}
