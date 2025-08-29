/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1;


/**
 *
 * @author 6289632
 */
public class ZipCode {
    public int Zip;
   
    public ZipCode(int Zip) {
        if (Zip > 99999 || Zip < 0) {
            System.out.println("Zip code must be between 00000 and 99999");
        }
        this.Zip = Zip;
    }

    public ZipCode(String barcode) {
        boolean valid = true;
        if (barcode.length() != 27) {
            System.out.println("Barcode length isn't 27");
            valid = false;
        } else if (barcode.charAt(0) != '1' || barcode.charAt(barcode.length() - 1) != '1') {
            System.out.println("First or last digit of the barcode isn't 1");
            valid = false;
        }
        for (int i = 0; i < barcode.length(); i++) {
            if (barcode.charAt(i) != '0' && barcode.charAt(i) != '1') {
                System.out.println("Barcode isn't binary");
                valid = false;
                break;
            }
        }
        if (valid) {
            Zip = parseBarCode(barcode);
        }
    }
   
    public String GetBarCode() {
        String barcode = "1";
        String zip = String.format("%05d", this.Zip);
       
        for (int i = 0; i < zip.length(); i++) {
           
            switch (zip.charAt(i)) {
                case '0' ->
                    barcode += "11000";
                case '1' ->
                    barcode += "00011";
                case '2' ->
                    barcode += "00101";
                case '3' ->
                    barcode += "00110";
                case '4' ->
                    barcode += "01001";
                case '5' ->
                    barcode += "01010";
                case '6' ->
                    barcode += "01100";
                case '7' ->
                    barcode += "10001";
                case '8' ->
                    barcode += "10010";
                case '9' ->
                    barcode += "10100";
            }
           
        }
        barcode += "1";
        return barcode;
    }
   
    private int parseBarCode(String barcode) {
        String zipcode = "";
        int zipCode = 0;
       
        barcode = barcode.substring(1, barcode.length() - 1);
        boolean valid = true;
        for (int i = 0; i <= barcode.length() - 5; i += 5) {
            if (!valid) {
                break;
            }
            String temp = barcode.substring(i, i + 5);
            switch (temp) {
                case "11000" ->
                    zipcode += "0";                            
                case "00011" ->
                    zipcode  += "1";                
                case "00101" ->
                    zipcode += "2";
                case "00110" ->
                    zipcode += "3";
                case "01001" ->
                    zipcode += "4";
                case "01010" ->
                    zipcode += "5";
                case "01100" ->
                    zipcode += "6";
                case "10001" ->
                    zipcode += "7";
                case "10010" ->
                    zipcode += "8";
                case "10100" ->
                    zipcode += "9";
                default -> {
                    System.out.println("Invalid barcode");
                    valid = false;}
            }
        }
       
       if (zipcode.length() == 5) {
           zipCode = Integer.parseInt(zipcode);
       }  else {
           System.out.println("Error");
           return -1;
       }
        return zipCode;
    }
}