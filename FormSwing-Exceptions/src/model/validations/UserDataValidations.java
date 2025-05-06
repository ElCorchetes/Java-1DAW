/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import exceptions.InvalidDocumentException;
import exceptions.InvalidDateFormatException;

/**
 *
 * @author alainlozgar
 */
public class UserDataValidations {

    /**
     * Funcion que válida si el documento (NIF principalmente) es correcto
     * @param typeDoc indica el tipo de documento (NIF = 1, ...)
     * @param id indica el codigo del documento
     * @return devuelve true o false dependiendo si el documento es válido
     */
    public static void checkId(int typeDoc, String id) throws InvalidDocumentException {
        boolean idOk = false;
        String[] letter = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
        
        if (id.length() > 9 || id.length() < 9){
            throw new InvalidDocumentException("Out of range id");
        }
        
        String numsId = id.substring(0,8);
        String letterId = id.substring(8,9);
        if(!(isAlphabetic(letterId))){
            throw new InvalidDocumentException("Not alphabetic");
        }
        if (!(isNumeric(numsId))){
            throw new InvalidDocumentException("Not numeric");
        }
        if (!(letter[Integer.parseInt(numsId) % 23].equals(letterId))){
            throw new InvalidDocumentException("Invalid letter");
        }
    }

    /**
     * Funcion que valida si el formato de la fecha es: dd/mm/yyyy
     * @param date String con la fecha que se desea comprobar
     * @return devuelve true o false dependiendo si el formato es correcto o no
     */
    public static void checkFormatDate(String date) throws InvalidDateFormatException {
        String[] dateSplited = date.split("[/]");
        int dateSplitedLeng = dateSplited.length;
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        boolean leapYear = false;
        
        if (dateSplitedLeng > 3 || dateSplitedLeng < 3) {
            throw new InvalidDateFormatException("Invalid date length");
        }

        for (int i = 0; i < dateSplitedLeng; i++) {
            if(!(isNumeric(dateSplited[i]))){
                throw new InvalidDateFormatException("Not numeric");
            }
        }
        int day = Integer.parseInt(dateSplited[0]);
        int month = Integer.parseInt(dateSplited[1]);
        long year = Integer.parseInt(dateSplited[2]);

        if(month > 12){
            throw new InvalidDateFormatException("Invalid month");
        }
        
        if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
            if(month == 2){
                if((day-1) > (monthDays[month-1])){
                    throw new InvalidDateFormatException("Invalid day");
                }
            }
        } else if (day > (monthDays[month-1])){
            throw new InvalidDateFormatException("Invalid day");
        }
    }

    /**
     * Funcion que calcula tu edad actual segun la del sistema
     * @param birthDate String con la edad en formato dd/mm/yyyy
     * @return devuelve la edad, en caso de formato incorrecto -1
     */
    public static int calculateAge(String birthDate){
        try{
            checkFormatDate(birthDate);
            //int currentYear = (int) (((System.currentTimeMillis()/1000)/31557600)+1970);
            long totalDays = (System.currentTimeMillis()/86400000);
            int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            int day = 1;
            int month = 1;
            int year = 1970;

            for (long i = 0; i < totalDays; i++) {
                day++;
                if (day > monthDays[month-1]) {
                    day = 1;
                    month++;
                    if (month > 12) {
                        month = 1;
                        year++;
                        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
                            totalDays -= 1;
                        }
                    }
                }
            }
            

            String[] dateSplited = birthDate.split("[/]");
            int birthDay = Integer.parseInt(dateSplited[0]);
            int birthMonth = Integer.parseInt(dateSplited[1]);
            int birthYear = Integer.parseInt(dateSplited[2]);

           if ((birthMonth - month) < 0) {
                return year - birthYear;
            }else if((birthDay - day <= 0) && ((birthMonth - month) <= 0)){
                return year - birthYear;
            }else {
                return (year - birthYear) - 1;
            }
        }catch(Exception InvalidDateFormatException){
            return -1;
        }
    }

    /**
     * Funcion que valida si el codigo postal es correcto
     * @param zip indica el codigo postal en formato String
     * @return devuelve true o false dependiendo si el codigo postal es correcto
     */
    public static boolean checkPostalCode(String zip){
        if (zip.length() > 5 || zip.length() < 5){
            return false;
        }
        if(!(isNumeric(zip))){
            return false;
        }
        int province = Integer.parseInt(zip.substring(0,2));
        if (province > 52 || province <= 00){
            return false;
        }
        return true;
    }

    /**
     * Funcion que valida si un string contiene únicamente numerous
     * @param str indica el string numerico
     * @return devuelve true o false dependiendo si el string tiene numeros
     */
    public static boolean isNumeric(String str){
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)){
                case '0':
                    break;
                case '1':
                    break;
                case '2':
                    break;
                case '3':
                    break;
                case '4':
                    break;
                case '5':
                    break;
                case '6':
                    break;
                case '7':
                    break;
                case '8':
                    break;
                case '9':
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    /**
     * Funcion que valida si un string contiene únicamente letras
     * @param str indica el string letras
     * @return devuelve true o false dependiendo si el string tiene letras
     */
    public static boolean isAlphabetic(String str){
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)){
                case 'a':
                    break;
                case 'b':
                    break;
                case 'c':
                    break;
                case 'd':
                    break;
                case 'e':
                    break;
                case 'f':
                    break;
                case 'g':
                    break;
                case 'h':
                    break;
                case 'i':
                    break;
                case 'j':
                    break;
                case 'k':
                    break;
                case 'l':
                    break;
                case 'm':
                    break;
                case 'n':
                    break;
                case 'o':
                    break;
                case 'p':
                    break;
                case 'q':
                    break;
                case 'r':
                    break;
                case 's':
                    break;
                case 't':
                    break;
                case 'u':
                    break;
                case 'w':
                    break;
                case 'x':
                    break;
                case 'y':
                    break;
                case 'z':
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    /**
     * Funcion que valida si un email es correcto
     * @param email el email como un String
     * @return devuelve true o false dependiendo si el email es correcto
     */
    public static boolean checkEmail(String email){
        String[] tld = {"com","es","net","cat","edu","org"};
        int at = 0;
        int dot = 0;
        boolean emailOk = false;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@'){
                at++;
            }
            if (email.charAt(i) == '.'){
                dot++;
            }
            if (email.charAt(i) == ' ') {
                return emailOk;
            }
        }

        if (at > 1 || at < 1){
            return emailOk;
        }

        if (dot > 2 || dot < 1){
            return emailOk;
        }
        
        String[] emailSplited = email.split("[@\\.]");
        
        if (emailSplited[1].length() < 1 || emailSplited[0].length() < 1) {
            return emailOk;
        }
        
        if (dot == 1) {

            for (int i = 0; i < tld.length; i++) {
                if (emailSplited[2].equals(tld[i])){
                    emailOk = true;
                }
            }
        }else {
            for (int i = 0; i < tld.length; i++) {
                if (emailSplited[3].equals(tld[i])){
                    emailOk = true;
                }
            }
        }

        return emailOk;
    }

    /**
     * Funcion que valida si un nombre es logico
     * @param name el nombre como un string
     * @return devuelve true o false dependiendo si el nombre es logico
     */
    public static boolean checkName(String name){
        if (name.length() > 15 || name.length() < 1){
            return false;
        }
        if (!(isAlphabetic(name))){
            return false;
        }
        return true;
    }
}
