package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "John", "Doe"));
        employees.add(new Employee(2, "Jane", "Doe"));
        employees.add(new Employee(1, "John", "Doe"));
        employees.add(new Employee(3, "Janberk", "Ozkan"));
        employees.add(new Employee(2, "Jane", "Doe"));

        List<Employee> duplicates = findDuplicates(employees);
        System.out.println("Duplicates: " + duplicates);

        Map<Integer, Employee> uniques = findUniques(employees);
        System.out.println("Uniques: " + uniques);

        List<Employee> nonDuplicates = removeDuplicates(employees);
        System.out.println("Non-duplicates: " + nonDuplicates);
    }

    public static List<Employee> findDuplicates(List<Employee> employees) {
        Set<Employee> uniqueSet = new HashSet<>();
        List<Employee> duplicateList = new LinkedList<>();

        for (Employee employee : employees) {
            if (employee != null) {
                if (!uniqueSet.add(employee)) {
                    if (!duplicateList.contains(employee)) {
                        duplicateList.add(employee);
                    }
                }
            }
        }

        return duplicateList;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Map<Integer, Employee> uniques = new HashMap<>();

        for (Employee employee : employees) {
            if (employee != null) {
                int id = employee.getId();
                if (!uniques.containsKey(id)) {
                    uniques.put(id, employee);
                }
            }
        }

        return uniques;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        List<Employee> duplicates = findDuplicates(employees);
        Map<Integer, Employee> uniques = findUniques(employees);
        List<Employee> onlyUnique = new LinkedList<>(uniques.values());
        onlyUnique.removeAll(duplicates);
        return onlyUnique;
    }
}
