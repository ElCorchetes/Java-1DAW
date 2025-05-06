/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.console;
import model.validations.UserDataValidations;

import java.util.Scanner;
import model.validations.UserDataValidations;

/**
 *
 * @author alainlozgar
 */
public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        input.useDelimiter("\n");
        String opt = "";

        do {
            System.out.println("\n--- Menú de Validaciones ---");
            System.out.println("1. Validar NIF/NIE");
            System.out.println("2. Validar Formato de Fecha");
            System.out.println("3. Calcular Edad");
            System.out.println("4. Validar Código Postal");
            System.out.println("5. Validar Si es Numérico");
            System.out.println("6. Validar Si es Alfabético");
            System.out.println("7. Validar Email");
            System.out.println("8. Validar Nombre");
            System.out.println("Z. Salir");
            System.out.print("Elige una opción: ");

            opt = input.next().toUpperCase(); // Leer la opción del usuario

            switch (opt) {
                case "1":
                    testCheckId();
                    break;
                case "2":
                    testFormatDate();
                    break;
                case "3":
                    testCalculateAge();
                    break;
                case "4":
                    testCheckPostalCode();
                    break;
                case "5":
                    testIsNumeric();
                    break;
                case "6":
                    testIsAlphabetic();
                    break;
                case "7":
                    testCheckEmail();
                    break;
                case "8":
                    checkName();
                    break;
                case "Z":
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (!opt.equals("Z"));
    }

    static void testCheckId() {
        System.out.println("Enter your NIF");
        String nif = input.next();
//        boolean idOk = UserDataValidations.checkId(1,nif);
//        if (idOk){
//            System.out.println("ID Correct");
//        }else {
//            System.out.println("Wrong ID");
//        }
    }

    static void testFormatDate() {
        System.out.println("Enter a Date: ");
        String date = input.next();
//        boolean datechk = UserDataValidations.checkFormatDate(date);
//        if (datechk){
//            System.out.println("Formato correcto");
//        }else {
//            System.out.println("Formato incorrecto");
//        }
    }

    static void testCalculateAge() {
        System.out.println("Enter your birth date: ");
        String birthDate = input.next();
        int age = UserDataValidations.calculateAge(birthDate);
        System.out.println("The age is " + age);
    }

    static void testCheckPostalCode() {
        System.out.println("Enter your postal code: ");
        String postalCode = input.next();
        if (UserDataValidations.checkPostalCode(postalCode)){
            System.out.println("Postal code correcto");
        }else {
            System.out.println("Postal code incorrecto");
        }
    }

    static void testIsNumeric() {
        System.out.println("Enter a String: ");
        String str = input.next();
        boolean num = UserDataValidations.isNumeric(str);
        if (num){
            System.out.println("Numero correcto");
        }else {
            System.out.println("Numero incorrecto");
        }
    }

    static void testIsAlphabetic(){
        System.out.println("Enter a String: ");
        String str = input.next();
        boolean alph = UserDataValidations.isAlphabetic(str);
        if (alph){
            System.out.println("Alphabetic correcto");
        }
        else {
            System.out.println("Alphabetic incorrecto");
        }
    }

    static void testCheckEmail() {
        System.out.println("Enter your email: ");
        String email = input.next();
        if(UserDataValidations.checkEmail(email)){
            System.out.println("Email correcto");
        } else {
            System.out.println("Email incorrecto");
        }
    }

    static void checkName(){
        System.out.println("Enter your name: ");
        String name = input.next();
        if (UserDataValidations.checkName(name)){
            System.out.println("Name correcto");
        } else {
            System.out.println("Name incorrecto");
        }
    }
}
