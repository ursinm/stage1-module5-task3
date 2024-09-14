package com.epam.mjc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class CollectionServiceTest {

    @Test
    void filterEvenNumbersTest() {
        // Тест с обычными значениями
        List<Integer> numbers = List.of(1, 6, 10, 5, 100, 1005, 125);
        List<Integer> expected = List.of(6, 10, 100);

        List<Integer> result = new CollectionService().filterEvenNumbers(numbers);
        assertEquals(expected, result);
        
        // Тест с пустым списком
        numbers = List.of();
        expected = List.of();
        result = new CollectionService().filterEvenNumbers(numbers);
        assertEquals(expected, result);

        // Тест, когда все числа нечетные
        numbers = List.of(1, 3, 5, 7);
        expected = List.of();
        result = new CollectionService().filterEvenNumbers(numbers);
        assertEquals(expected, result);
    }

    @Test
    void toUpperCaseCollectionTest() {
        // Тест с обычными значениями
        List<String> list = List.of("Hello", "mjc", "school");
        List<String> expected = List.of("HELLO", "MJC", "SCHOOL");

        List<String> result = new CollectionService().toUpperCaseCollection(list);
        assertEquals(expected, result);
        
        // Тест с пустым списком
        list = List.of();
        expected = List.of();
        result = new CollectionService().toUpperCaseCollection(list);
        assertEquals(expected, result);

        // Тест с уже верхним регистром
        list = List.of("HELLO", "MJC", "SCHOOL");
        expected = List.of("HELLO", "MJC", "SCHOOL");
        result = new CollectionService().toUpperCaseCollection(list);
        assertEquals(expected, result);
    }

    @Test
    void findMaxTest() {
        // Тест с обычными значениями
        List<Integer> numbers = List.of(1, 6, 10, 5, 100, 1005, 125);
        Optional<Integer> expected = Optional.of(1005);

        Optional<Integer> result = new CollectionService().findMax(numbers);
        assertEquals(expected, result);
        
        // Тест с пустым списком (ожидаем Optional.empty())
        numbers = List.of();
        expected = Optional.empty();
        result = new CollectionService().findMax(numbers);
        assertEquals(expected, result);

        // Тест с одинаковыми значениями
        numbers = List.of(2, 2, 2, 2);
        expected = Optional.of(2);
        result = new CollectionService().findMax(numbers);
        assertEquals(expected, result);
    }

    @Test
    void findMinTest() {
        // Тест с обычными значениями
        List<Integer> numbers = List.of(1, 6, 10, 5, 100, 1005, 125);
        List<Integer> numbers2 = List.of(9192, 1255, 5857, 123, 2, 6);

        List<List<Integer>> lists = List.of(numbers, numbers2);

        Optional<Integer> expected = Optional.of(1);

        Optional<Integer> result = new CollectionService().findMin(lists);
        assertEquals(expected, result);

        // Тест с пустыми вложенными списками
        lists = List.of(List.of(), List.of());
        expected = Optional.empty();
        result = new CollectionService().findMin(lists);
        assertEquals(expected, result);

        // Тест с вложенными списками, содержащими одинаковые элементы
        lists = List.of(List.of(5, 5), List.of(5));
        expected = Optional.of(5);
        result = new CollectionService().findMin(lists);
        assertEquals(expected, result);
    }

    @Test
    void sumTest() {
        // Тест с обычными значениями
        List<Integer> numbers = List.of(1, 6, 10, 5, 100, 1005, 125);
        Integer expected = 1252;

        Integer result = new CollectionService().sum(numbers);
        assertEquals(expected, result);
        
        // Тест с пустым списком (сумма должна быть 0)
        numbers = List.of();
        expected = 0;
        result = new CollectionService().sum(numbers);
        assertEquals(expected, result);

        // Тест с одинаковыми элементами
        numbers = List.of(2, 2, 2);
        expected = 6;
        result = new CollectionService().sum(numbers);
        assertEquals(expected, result);
    }
}
