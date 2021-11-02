package com.tms.lesson14.prog01Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1. Создать коллекцию класса ArrayList со значениями имен всех студентов в группе
 *
 * С помощью Stream'ов:
 * 	- Вернуть количество количество людей с вашим именем (вне зависимости от верхнего/нижнего регистра букв)
 * 	- Выбрать все имена, начинающиеся на "а" (вне зависимости от верхнего/нижнего регистра букв)
 * 	- Отсортировать и вернуть первый элемент коллекции или "Empty", если коллекция пуста
 */
public class StreamMain {
    public static void main(String[] args) {
        // Создаём коллекцию
        List<String> arrayOfNames = new ArrayList<>();
        arrayOfNames.add("Алина");
        arrayOfNames.add("Дмитрий");
        arrayOfNames.add("Мария");
        arrayOfNames.add("Стас");
        arrayOfNames.add("Анатолий");
        arrayOfNames.add("Виталий");
        arrayOfNames.add("Антон");
        arrayOfNames.add("Александр");
        arrayOfNames.add("Кирилл");
        arrayOfNames.add("Александр");
        arrayOfNames.add("Ольга");
        arrayOfNames.add("Владимир");
        arrayOfNames.add("Кирилл");
        arrayOfNames.add("Валентин");
        arrayOfNames.add("Павел");

        // Вернуть количество людей с вашим именем (вне зависимости от верхнего/нижнего регистра букв)
        System.out.println("Количество людей с именем Алина: " + arrayOfNames
                .stream()
                .filter(n -> n.equalsIgnoreCase("алина"))
                .count());

        // Выбрать все имена, начинающиеся на "а" (вне зависимости от верхнего/нижнего регистра букв)
        System.out.println("Имена, начинающиеся на \"а\": " + arrayOfNames
                .stream()
                .filter(n -> n.toLowerCase().startsWith("а"))
                .collect(Collectors.toList()));

        // Отсортировать и вернуть первый элемент коллекции или "Empty", если коллекция пуста
        List<String> sortedArray = arrayOfNames
                .stream()
                .sorted()
                .limit(1)
                .collect(Collectors.toList());

        if (null == sortedArray || sortedArray.isEmpty()) {
            System.out.println("Empty");
        }
        else {
            System.out.println("Первый элемент в отсортированной коллекции: " + sortedArray);
        }
    }
}
