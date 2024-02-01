package org.example;

import java.util.*;

public class Attestat {
private String model;
private int ram;
private int storage;
private String os;
private String color;


public Attestat(String model, int ram, int storage, String os, String color) {
    this.model = model;
    this.ram = ram;
    this.storage = storage;
    this.os = os;
    this.color = color;
}

public String getModel() {
    return model;
}

public int getRam() {
    return ram;
}

public int getStorage() {
    return storage;
}

public String getOs() {
    return os;
}

public String getColor() {
    return color;
}

public static void main(String[] args) {
    Set<Attestat> notebooks = new HashSet<>();
    notebooks.add(new Attestat("Notebook1", 8, 500, "Windows 10", "Black"));
    notebooks.add(new Attestat("Notebook2", 16, 1000, "Windows 10", "Silver"));
    notebooks.add(new Attestat("Notebook3", 4, 256, "Windows 7", "White"));
    notebooks.add(new Attestat("Notebook4", 8, 500, "MacOS", "Silver"));
    notebooks.add(new Attestat("Notebook5", 16, 1000, "Windows 10", "Black"));

    Map<String, String> filterCriteria = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    System.out.println("Введите номер критерия фильтрации:");
    System.out.println("1 - ОЗУ");
    System.out.println("2 - Объем ЖД");
    System.out.println("3 - Операционная система");
    System.out.println("4 - Цвет");
    String criterionNumber = scanner.nextLine();

    System.out.println("Введите минимальное значение для выбранного критерия:");
    String criterionValue = scanner.nextLine();

    filterCriteria.put(criterionNumber, criterionValue);

    filterAndPrintNotebooks(notebooks, filterCriteria);
    scanner.close();
}

public static void filterAndPrintNotebooks(Set<Attestat> notebooks, Map<String, String> filterCriteria) {
    for (Attestat notebook : notebooks) {
        boolean passFilter = true;

        for (Map.Entry<String, String> entry : filterCriteria.entrySet()) {
            String criterionNumber = entry.getKey();
            String criterionValue = entry.getValue();

            switch (criterionNumber) {
                case "1": // ОЗУ
                    if (notebook.getRam() < Integer.parseInt(criterionValue)) {
                        passFilter = false;
                    }
                    break;
                case "2": // Объем ЖД
                    if (notebook.getStorage() < Integer.parseInt(criterionValue)) {
                        passFilter = false;
                    }
                    break;
                case "3": // Операционная система
                    if (!notebook.getOs().equals(criterionValue)) {
                        passFilter = false;
                    }
                    break;
                case "4": // Цвет
                    if (!notebook.getColor().equals(criterionValue)) {
                        passFilter = false;
                    }
                    break;
            }
        }

        if (passFilter) {
            System.out.println(notebook.getModel());
        }
    }
  }
}