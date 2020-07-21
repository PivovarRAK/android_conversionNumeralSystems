package com.example.myapplication;

public class ConversionClass {

    public static String s = "";
    public static String s1 = "";


    // Vorkomma Int -> Binaer
    public static void convertIntegerToBinary(int n) {
        if (n == 0) return;
        convertIntegerToBinary(n / 2);
        s = s + String.valueOf(n % 2);
    }
    //Vorkomma int -> oktal
    public static void convertIntegerToOktal(int n) {
        if (n == 0) return;
        convertIntegerToOktal(n / 8);
        s = s + String.valueOf(n % 8);
    }

    //Vorkomma Int -> Hexa
    public static void convertIntegerToHexadecimal(int n) {
        char e;
        if (n == 0) return;
        convertIntegerToHexadecimal(n / 16);
        int a = n % 16;
        if (a > 9) {
            switch (a) {
                case 10:
                    a = 'A';
                    break;
                case 11:
                    a = 'B';
                    break;
                case 12:
                    a = 'C';
                    break;
                case 13:
                    a = 'D';
                    break;
                case 14:
                    a = 'E';
                    break;
                case 15:
                    a = 'F';
                    break;
            }
            e = (char) a;
            s = s + e;

        } else
            s = s + String.valueOf(a);
    }

    //Nachkomma Double -> Binaer
    public static void convertDoubleFractionalPartToBinary(double f) {
        double e;
        if (s.isEmpty()) s = s + 0;
        s = s + "."; // Hier wird das "Kommapunkt" in den String für die Binärzahl gesetzt.
        while (f != 0) {
            e = f * 2;
            s = s + String.valueOf((int) e);
            f = e - (int) e;
        }

    }
    // Nachkomma Double -> Oktal
    public static void convertDoubleFractionalPartToOktal(double f) {
        double e;
        if (s.isEmpty()) s = s + 0;
        s = s + "."; // Hier wird das "Kommapunkt" in den String für die Oktalzahl gesetzt.
        while (f != 0) {
            e = f * 8;
            s = s + String.valueOf((int) e);
            f = e - (int) e;
        }

    }
    // Nachkomma Double -> Hexa
    public static void convertDoubleFractionalPartToHexadecimal(double f) {
        double e;
        char a;
        if (s.isEmpty()) s = s + 0;
        s = s + "."; // Hier wird das "Kommapunkt" in den String für die Hexadezimalzahl gesetzt.
        while (f != 0) {
            e = f * 16;
            f = e - (int) e;
            if ((int) e > 9) {
                switch ((int) e) {
                    case 10:
                        e = 'A';
                        break;
                    case 11:
                        e = 'B';
                        break;
                    case 12:
                        e = 'C';
                        break;
                    case 13:
                        e = 'D';
                        break;
                    case 14:
                        e = 'E';
                        break;
                    case 15:
                        e = 'F';
                        break;
                }
                a = (char) e;
                s = s + a;
            } else
                s = s + String.valueOf((int) e);
        }

    }
    // Vorkomma Binaer -> Decimal
    public static void convertBinaryToDecimal(String binary_s) {
        int l = binary_s.length(); //Beispiel: 1010 -> l ist 4
        int ziffer;
        int zahl = 0;
        for (int i = 1; i <= l; i++) {
            ziffer = Integer.parseInt(String.valueOf(binary_s.charAt(i - 1)));
            zahl = zahl + (int) (ziffer * Math.pow(2., l - i));
        }
        s = String.valueOf(zahl);
    }

    // Nachkomma Binaer -> Decimal
    public static void convertBinaryFraktionalPartToDecimal(String binary_s) {
        int l = binary_s.length(); //Beispiel: 101 -> l ist 3
        int ziffer;
        double zahl = 0.;
        for (int i = 1; i <= l; i++) {
            ziffer = Integer.parseInt(String.valueOf(binary_s.charAt(i - 1)));
            zahl = zahl + ziffer * Math.pow(2., -i);
        }
        if (s.isEmpty())
            s = (s + String.valueOf(zahl)).replace(".", ",");
        else {
            double z = Double.parseDouble(s);
            s = (String.valueOf((z + zahl))).replace(".", ",");
        }

    }


    public static void convertOktalToDecimal(String oktal_s) {
        int l = oktal_s.length(); //Beispiel: 11147 -> l ist 5
        int ziffer;
        int zahl = 0;
        for (int i = 1; i <= l; i++) {
            ziffer = Integer.parseInt(String.valueOf(oktal_s.charAt(i - 1)));
            zahl = zahl + (int) (ziffer * Math.pow(8., l - i));
        }
        s = String.valueOf(zahl);
    }

    public static void convertOktalFraktionalPartToDecimal(String oktal_s) {
        int l = oktal_s.length(); //Beispiel: 5 -> l ist 1
        int ziffer;
        double zahl = 0.;
        for (int i = 1; i <= l; i++) {
            ziffer = Integer.parseInt(String.valueOf(oktal_s.charAt(i - 1)));
            zahl = zahl + ziffer * Math.pow(8., -i);
        }
        if (s.isEmpty())
            s = (s + String.valueOf(zahl));
        else {
            double z = Double.parseDouble(s);
            s = (String.valueOf((z + zahl)));
        }

    }

    public static void convertHexadecimalToDecimal(String hexadecimal_s) {
        int l = hexadecimal_s.length(); //Beispiel: C12A7 -> l ist 5
        int ziffer;
        int zahl = 0;
        for (int i = 1; i <= l; i++) {
            if (hexadecimal_s.charAt(i - 1) == 'A' || hexadecimal_s.charAt(i - 1) == 'a')
                ziffer = 10;
            else if (hexadecimal_s.charAt(i - 1) == 'B' || hexadecimal_s.charAt(i - 1) == 'b')
                ziffer = 11;
            else if (hexadecimal_s.charAt(i - 1) == 'C' || hexadecimal_s.charAt(i - 1) == 'c')
                ziffer = 12;
            else if (hexadecimal_s.charAt(i - 1) == 'D' || hexadecimal_s.charAt(i - 1) == 'd')
                ziffer = 13;
            else if (hexadecimal_s.charAt(i - 1) == 'E' || hexadecimal_s.charAt(i - 1) == 'e')
                ziffer = 14;
            else if (hexadecimal_s.charAt(i - 1) == 'F' || hexadecimal_s.charAt(i - 1) == 'f')
                ziffer = 15;
            else
                ziffer = Integer.parseInt(String.valueOf(hexadecimal_s.charAt(i - 1)));
            zahl = zahl + (int) (ziffer * Math.pow(16., l - i));
        }
        s = String.valueOf(zahl);
    }

    public static void convertHexadecimalFraktionalPartToDecimal(String hexadecimal_s) {
        int l = hexadecimal_s.length(); //Beispiel: B -> l ist 1
        int ziffer;
        double zahl = 0.;
        for (int i = 1; i <= l; i++) {
            if (hexadecimal_s.charAt(i - 1) == 'A' || hexadecimal_s.charAt(i - 1) == 'a')
                ziffer = 10;
            else if (hexadecimal_s.charAt(i - 1) == 'B' || hexadecimal_s.charAt(i - 1) == 'b')
                ziffer = 11;
            else if (hexadecimal_s.charAt(i - 1) == 'C' || hexadecimal_s.charAt(i - 1) == 'c')
                ziffer = 12;
            else if (hexadecimal_s.charAt(i - 1) == 'D' || hexadecimal_s.charAt(i - 1) == 'd')
                ziffer = 13;
            else if (hexadecimal_s.charAt(i - 1) == 'E' || hexadecimal_s.charAt(i - 1) == 'e')
                ziffer = 14;
            else if (hexadecimal_s.charAt(i - 1) == 'F' || hexadecimal_s.charAt(i - 1) == 'f')
                ziffer = 15;
            else
                ziffer = Integer.parseInt(String.valueOf(hexadecimal_s.charAt(i - 1)));
            zahl = zahl + ziffer * Math.pow(16., -i);
        }
        if (s.isEmpty())
            s = (s + String.valueOf(zahl));
        else {
            double z = Double.parseDouble(s);
            s = (String.valueOf((z + zahl)));
        }

    }


    public static void convertOktalToBinary(String ein) {
        convertOktalToDecimal(ein);
        int n = Integer.parseInt(s);
        s = "";
        convertIntegerToBinary(n);
    }

    public static void convertOktalFraktionalPartToBinary(String ein) {
        s1 = s;
        s = "0";
        convertOktalFraktionalPartToDecimal(ein);
        String[] teil = s.split("\\.");
        s = s1;
        convertDoubleFractionalPartToBinary(Double.parseDouble("0." + teil[1]));
    }

    public static void convertBinaryToOktal(String ein) {
        convertBinaryToDecimal(ein);
        int n = Integer.parseInt(s);
        s = "";
        convertIntegerToOktal(n);
    }

    public static void convertBinaryFraktionalPartToOktal(String ein) {
        s1 = s;
        s = "0";
        convertBinaryFraktionalPartToDecimal(ein);
        String[] teil = s.split(",");
        s = s1;
        convertDoubleFractionalPartToOktal(Double.parseDouble("0." + teil[1]));
    }

    public static void convertBinaryToHexadecimal(String ein) {
        convertBinaryToDecimal(ein);
        int n = Integer.parseInt(s);
        s = "";
        convertIntegerToHexadecimal(n);
    }

    public static void convertBinaryFraktionalPartToHexadecimal(String ein) {
        s1 = s;
        s = "0";
        convertBinaryFraktionalPartToDecimal(ein);
        String[] teil = s.split(",");
        s = s1;
        convertDoubleFractionalPartToHexadecimal(Double.parseDouble("0." + teil[1]));
    }

    public static void convertHexadecimalToOktal(String ein) {
        convertHexadecimalToDecimal(ein);
        int n = Integer.parseInt(s);
        s = "";
        convertIntegerToOktal(n);
    }

    public static void convertHexadecimalFraktionalPartToOktal(String ein) {
        s1 = s;
        s = "0";
        convertHexadecimalFraktionalPartToDecimal(ein);
        String[] teil = s.split("\\.");
        s = s1;
        convertDoubleFractionalPartToOktal(Double.parseDouble("0." + teil[1]));
    }

    public static void convertOktalToHexadecimal(String ein) {
        convertOktalToDecimal(ein);
        int n = Integer.parseInt(s);
        s = "";
        convertIntegerToHexadecimal(n);
    }

    public static void convertOktalFraktionalPartToHexadecimal(String ein) {
        s1 = s;
        s = "0";
        convertOktalFraktionalPartToDecimal(ein);
        String[] teil = s.split("\\.");
        s = s1;
        convertDoubleFractionalPartToHexadecimal(Double.parseDouble("0." + teil[1]));
    }

    public static void convertHexadecimalToBinary(String ein) {
        convertHexadecimalToDecimal(ein);
        int n = Integer.parseInt(s);
        s = "";
        convertIntegerToBinary(n);
    }

    public static void convertHexadecimalFraktionalPartToBinary(String ein) {
        s1 = s;
        s = "0";
        convertHexadecimalFraktionalPartToDecimal(ein);
        String[] teil = s.split("\\.");
        s = s1;
        convertDoubleFractionalPartToBinary(Double.parseDouble("0." + teil[1]));
    }

}
