package com.epam.mjc;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectionService {

    // 1. Фильтрация четных чисел
    public List<Integer> filterEvenNumbers(List<Integer> list) {
        return list.stream()
                   .filter(n -> n % 2 == 0) // Фильтруем только четные числа
                   .collect(Collectors.toList()); // Собираем результат в список
    }

    // 2. Преобразование всех строк в верхний регистр
    public List<String> toUpperCaseCollection(List<String> list) {
        return list.stream()
                   .map(String::toUpperCase) // Преобразуем каждую строку в верхний регистр
                   .collect(Collectors.toList()); // Собираем результат в список
    }

    // 3. Поиск максимального значения
    public Optional<Integer> findMax(List<Integer> list) {
        return list.stream()
                   .max(Integer::compareTo); // Находим максимальное значение
    }

    // 4. Поиск минимального значения среди вложенных списков
    public Optional<Integer> findMin(List<List<Integer>> list) {
        return list.stream()
                   .flatMap(List::stream) // Разворачиваем список списков в поток элементов
                   .min(Integer::compareTo); // Находим минимальное значение
    }

    // 5. Подсчет суммы всех элементов
    public Integer sum(List<Integer> list) {
        return list.stream()
                   .reduce(0, Integer::sum); // Складываем все элементы, начиная с 0
    }
}
