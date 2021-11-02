package com.tms.lesson14.prog00Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

/**
 * 0. Создать коллекцию класса ArrayList наполнить ее элементами рандомными элементами типа Integer.
 *
 * С помощью Stream'ов:
 * 	- Удалить дубликаты
 * 	- Вывести все четные элементы в диапазоне от 7 до 17 (включительно)
 * 	- Каждый элемент умножить на 2
 * 	- Отсортировать и вывести на экран первых 4 элемента
 * 	- Вывести количество элементов в стриме
 * 	- Вывести среднее арифметическое всех чисел в стриме
 */
public class StreamMain {
    public static void main(String[] args) {
        // Создаём коллекцию
        List<Integer> randomArray = new ArrayList<>();

        // Заполняем ее рандомными элементами типа Integer
        for (int i = 0; i < 50; i++) {
            randomArray.add((int) (Math.random() * (100 - 1)) + 1); // Формула (Math.random()*(b-a))+a) = [a; b)
        }
        System.out.println(randomArray);

        // Создаём distinctInts - коллекция, в которую будем сохранять результат преобразования randomArray. Далее используем стримы
        List<Integer> distinctInts = randomArray
                .stream()
                .distinct() // Удаление дубликатов. Элементы сравниваются с использованием equals(). Поэтому необходимо, чтобы элементы потока использовали правильную реализацию этого метода
                .collect(Collectors.toList());

        System.out.println();
        System.out.println("Коллекция без дубликатов: ");
        System.out.println(distinctInts);

        // Вывести все четные элементы в диапазоне от 7 до 17 (включительно)
        List<Integer> evenInts = randomArray
                .stream()
                .filter(n -> n % 2 == 0) // оставляет только четные числа
                .filter(n -> n > 7 && n <= 17)
                .collect(Collectors.toList());

        System.out.println();
        System.out.println("Все четные элементы в диапазоне от 7 до 17 (включительно): ");
        System.out.println(evenInts);

        // Каждый элемент умножить на 2. Отсортировать и вывести на экран первых 4 элемента
        List<Integer> fourFirstInts = randomArray
                .stream()
                .map(n -> n * 2)
                .sorted()
                .limit(4)
                .collect(Collectors.toList());

        System.out.println();
        System.out.println("Первые 4 элемента отсортированной коллекции (все элементы исходной коллекции умножены на 2): ");
        System.out.println(fourFirstInts);

        // Вывести количество элементов в стриме
        System.out.println();
        System.out.println("Количество элементов в стриме: " + randomArray.stream().count());

        // Вывести среднее арифметическое всех чисел в стриме
        OptionalDouble average = randomArray.stream().mapToInt(Integer::intValue).average();

        System.out.println();
        if (average.isPresent()) {
            System.out.println("Среднее арифметическое всех чисел в стриме " + average.getAsDouble());
        } else {
            System.out.println("Nothing!");
        }
    }
}
