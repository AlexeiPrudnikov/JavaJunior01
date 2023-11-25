import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static final int SIZE = 10;
    public static final int MAX_VALUE = 1_000;
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
    }
}