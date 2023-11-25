import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static final int SIZE = 1000;
    public static final int MAX_VALUE = 1_000_000;
    public static final int MIN_VALUE = 1;

    public static void main(String[] args) {
        /**
         * 0.1. Посмотреть разные статьи на Хабр.ру про Stream API
         * 0.2. Посмотреть видеоролики на YouTube.com Тагира Валеева про Stream API
         *
         * 1. Создать список из 1_000 рандомных чисел от 1 до 1_000_000
         * 1.1 Найти максимальное
         * 2.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
         * 2.3 Найти количество чисел, квадрат которых меньше, чем 100_000
         *
         * 2. Создать класс Employee (Сотрудник) с полями: String name, int age, double salary, String department
         * 2.1 Создать список из 10-20 сотрудников
         * 2.2 Вывести список всех различных отделов (department) по списку сотрудников
         * 2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
         * 2.4 * Из списка сотрудников с помощью стрима создать Map<String, List<Employee>> с отделами и сотрудниками внутри отдела
         * 2.5 * Из списока сорудников с помощью стрима создать Map<String, Double> с отделами и средней зарплатой внутри отдела
         */
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            numbers.add(random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE);
        }
        System.out.println("==========");
        System.out.println("Создать список из 1_000 рандомных чисел от 1 до 1_000_000");
        System.out.println(numbers);
        System.out.println("==========");
        System.out.printf("Максимальное число: %d\n", numbers.stream().max(Integer::compareTo).get());
        System.out.println("==========");
        System.out.println("Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать");
        System.out.println(numbers.stream()
                .filter(x -> x > 500_000)
                .mapToLong(x -> x.intValue() * 5 - 150)
                .sum());
        System.out.println("==========");
        System.out.println("Найти количество чисел, квадрат которых меньше, чем 100_000");
        System.out.println(numbers.stream()
                .filter(x -> Math.pow(x, 2) < 100_000)
                .count());
        System.out.println("==========");
        System.out.println("Создать список из 10-20 сотрудников");
        List<Employee> employees = Arrays.asList(
                new Employee("Иванов", 40, 100000, "Руководство"),
                new Employee("Петров", 41, 20000.3, "Подбор персонала"),
                new Employee("Сидоров", 35, 12340, "Служба безопасности"),
                new Employee("Бочкин", 20, 7000, "Менеджмент"),
                new Employee("Кочкин", 22, 4230.5, "Служба безопасности"),
                new Employee("Козлов", 29, 1000.5, "Менеджмент"),
                new Employee("Собакин", 50, 13450.9, "Служба безопасности"),
                new Employee("Белый", 31, 1430.5, "Подбор персонала"),
                new Employee("Черный", 46, 5600.5, "Подбор персонала"),
                new Employee("Батонов", 27, 100000, "Руководство"),
                new Employee("Курицын", 31, 12100.5, "Подбор персонала"),
                new Employee("Рогов", 35, 14300.5, "Менеджмент"),
                new Employee("Коровин", 35, 1780.5, "Менеджмент"),
                new Employee("Птицын", 58, 5050.5, "Подбор персонала"),
                new Employee("Наливайко", 46, 90000, "Руководство"),
                new Employee("Попов", 30, 10000.7, "Подбор персонала"),
                new Employee("Стулов", 29, 32070.3, "Подбор персонала"),
                new Employee("Столов", 38, 17600.8, "Подбор персонала"),
                new Employee("Кольев", 55, 80000, "Руководство"),
                new Employee("Баранов", 43, 5000, "Служба безопасности"),
                new Employee("Полкин", 19, 2000, "Служба безопасности")
        );
        System.out.println(employees);
        System.out.println("==========");
        System.out.println("Вывести список всех различных отделов (department) по списку сотрудников");
        System.out.println(employees.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList()));
        System.out.println("==========");
        System.out.println("Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%");
        System.out.println("Было: " + employees);
        employees.stream().filter(employee -> employee.getSalary() < 10000).forEach(employee -> employee.setSalary(employee.getSalary() * 1.2));
        System.out.println("Стало: " + employees);
        System.out.println("==========");
        System.out.println("Из списка сотрудников с помощью стрима создать Map<String, List<Employee>> с отделами и сотрудниками внутри отдела");
        Map<String, List<Employee>> firm = employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment));
        for (String key: firm.keySet()) {
            System.out.println(key + ":" + firm.get(key));
        }
        System.out.println();
        System.out.println("==========");
        System.out.println("Из списока сорудников с помощью стрима создать Map<String, Double> с отделами и средней зарплатой внутри отдела");
        Map<String, Double> salary = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        for (String key: salary.keySet()) {
            System.out.println(key + ":" + salary.get(key));
        }
    }
}