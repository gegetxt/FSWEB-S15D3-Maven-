package org.example;

import org.example.entity.Employee;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

    public static List<Employee> findDuplicates(List<Employee> employees) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Employee> employeeMap = new HashMap<>();
        List<Employee> duplicates = new LinkedList<>();

        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }

            int id = employee.getId();
            countMap.put(id, countMap.getOrDefault(id, 0) + 1);
            employeeMap.putIfAbsent(id, employee);

            if (countMap.get(id) == 2) {
                duplicates.add(employeeMap.get(id));
            }
        }

        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Map<Integer, Employee> uniqueMap = new HashMap<>();

        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            uniqueMap.putIfAbsent(employee.getId(), employee);
        }

        return uniqueMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Employee> employeeMap = new HashMap<>();

        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }

            int id = employee.getId();
            countMap.put(id, countMap.getOrDefault(id, 0) + 1);
            employeeMap.putIfAbsent(id, employee);
        }

        List<Employee> result = new LinkedList<>();

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(employeeMap.get(entry.getKey()));
            }
        }

        return result;
    }
}