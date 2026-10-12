package Validaciones;

import java.util.Scanner;

public class Validaciones {
public int ValidarEntero(Scanner sc) {
    while (true) {
        try {
            String entrada = sc.nextLine().trim();
            if (entrada.isEmpty()) continue;
            return Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese un dígito numérico válido:");
        }
    }
}

public Double ValidarDecimal(Scanner sc) {
    while (true) {
        try {
            String entrada = sc.nextLine().trim();
            if (entrada.isEmpty()) continue;
            return Double.parseDouble(entrada);
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese un dígito decimal válido (use punto para decimales):");
        }
    }
}

public String ValidarTexto(Scanner sc) {
    while (true) {
        String entrada = sc.nextLine().trim();
        if (!entrada.isEmpty()) {
            return entrada;
        }
        System.out.println("El campo no puede estar vacío. Por favor ingrese un texto válido:");
    }
}
}