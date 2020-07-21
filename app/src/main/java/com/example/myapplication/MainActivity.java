package com.example.myapplication;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView input_dec, input_hex, input_okt, input_bin;
    Button reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input_bin.setText("");
                input_hex.setText("");
                input_okt.setText("");
                ConversionClass.s = "";
                input_dec.setText("");

            }
        });
        setupOnChangeListeners();
    }


    private void setupUI(){
        input_dec = findViewById(R.id.et_input_decimal);
        input_okt = findViewById(R.id.et_input_oktal);
        input_bin = findViewById(R.id.et_input_binary);
        input_hex = findViewById(R.id.et_input_hexa);
        reset = findViewById(R.id.btn_reset);
    }


    private void setupOnChangeListeners(){

        input_okt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                        if(input_okt.isFocused()){
                        if(!input_okt.getText().toString().equals("")) {
                            if (input_okt.getText().toString().contains(".0") ||
                                    input_okt.getText().toString().contains(".1") ||
                                    input_okt.getText().toString().contains(".2") ||
                                    input_okt.getText().toString().contains(".3") ||
                                    input_okt.getText().toString().contains(".4") ||
                                    input_okt.getText().toString().contains(".5") ||
                                    input_okt.getText().toString().contains(".6") ||
                                    input_okt.getText().toString().contains(".7")
                            ) {
                                //input_okt.setText(input_okt.getText().toString().replace(",","."));
                                String[] split = input_okt.getText().toString().split("\\.");
                                String vorkomma = split[0];
                                String nachkomma =  split[1];
                                ConversionClass.convertOktalToBinary(vorkomma);
                                ConversionClass.convertOktalFraktionalPartToBinary(nachkomma);
                                String oktal_to_binary = ConversionClass.s;
                                ConversionClass.s = "";
                                ConversionClass.convertOktalToHexadecimal(vorkomma);
                                ConversionClass.convertOktalFraktionalPartToHexadecimal(nachkomma);
                                String oktal_to_hexa = ConversionClass.s;
                                ConversionClass.s = "";
                                ConversionClass.convertOktalToDecimal(vorkomma);
                                ConversionClass.convertOktalFraktionalPartToDecimal(nachkomma);
                                String oktal_to_decimal = ConversionClass.s;
                                ConversionClass.s = "";
                                input_hex.setText(oktal_to_hexa);
                                input_bin.setText(oktal_to_binary);
                                input_dec.setText(oktal_to_decimal);
                            } else {
                                Toast.makeText(MainActivity.this, "Bitte Kommastelle eingeben (.0)", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(MainActivity.this, "Bitte Angaben machen.", Toast.LENGTH_SHORT).show();
                        }

                    }}
                });


        input_bin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                        if(input_bin.isFocused()){
                        if(!input_bin.getText().toString().equals("")) {
                            //input_bin.setText(input_bin.getText().toString().replace(",","."));
                            if (input_bin.getText().toString().contains(".1") ||
                                    input_bin.getText().toString().contains(".0") ) {
                                String[] split = input_bin.getText().toString().split("\\.");
                                String vorkomma = split[0];
                                String nachkomma = split[1];
                                ConversionClass.convertBinaryToHexadecimal(vorkomma);
                                ConversionClass.convertBinaryFraktionalPartToHexadecimal(nachkomma);
                                String binary_to_hex_vor = ConversionClass.s;
                                ConversionClass.s = "";
                                ConversionClass.convertBinaryToOktal(vorkomma);
                                ConversionClass.convertBinaryFraktionalPartToOktal(nachkomma);
                                String binary_to_oktal = ConversionClass.s;
                                ConversionClass.s = "";
                                ConversionClass.convertBinaryToDecimal(vorkomma);
                                ConversionClass.convertBinaryFraktionalPartToDecimal(nachkomma);
                                String binary_to_decimal = ConversionClass.s;
                                ConversionClass.s = "";
                                input_hex.setText(binary_to_hex_vor);
                                input_dec.setText(binary_to_decimal);
                                input_okt.setText(binary_to_oktal);
                            } else {
                                Toast.makeText(MainActivity.this, "Bitte Kommastelle eingeben (.0)", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(MainActivity.this, "Bitte Angaben machen.", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
                                         });



        input_dec.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                        if(input_dec.isFocused()){
                        if(!input_dec.getText().toString().equals("")) {
                            //input_dec.setText(input_dec.getText().toString().replace(",","."));
                            if (input_dec.getText().toString().contains(".0") ||
                                    input_dec.getText().toString().contains(".1") ||
                                    input_dec.getText().toString().contains(".2") ||
                                    input_dec.getText().toString().contains(".3") ||
                                    input_dec.getText().toString().contains(".4") ||
                                    input_dec.getText().toString().contains(".5") ||
                                    input_dec.getText().toString().contains(".6") ||
                                    input_dec.getText().toString().contains(".7") ||
                                    input_dec.getText().toString().contains(".8") ||
                                    input_dec.getText().toString().contains(".9")) {
                                String[] split = input_dec.getText().toString().split("\\.");
                                String vorkomma = split[0];
                                String nachkomma = "0." + split[1];
                                ConversionClass.convertIntegerToHexadecimal(Integer.parseInt(vorkomma));
                                ConversionClass.convertDoubleFractionalPartToHexadecimal(Double.parseDouble(nachkomma));
                                String hexa_vor = ConversionClass.s;
                                ConversionClass.s = "";
                                ConversionClass.convertIntegerToOktal(Integer.parseInt(vorkomma));
                                ConversionClass.convertDoubleFractionalPartToOktal(Double.parseDouble(nachkomma));
                                String oktal_vor = ConversionClass.s;
                                ConversionClass.s = "";
                                ConversionClass.convertIntegerToBinary(Integer.parseInt(vorkomma));
                                ConversionClass.convertDoubleFractionalPartToBinary(Double.parseDouble(nachkomma));
                                String dec_to_bin = ConversionClass.s;
                                ConversionClass.s = "";
                                input_hex.setText(hexa_vor);
                                input_bin.setText(dec_to_bin);
                                //input_bin.setText(ConversionDecimalToBinary.convertIntegerToBinary(Integer.parseInt(vorkomma)) + "" + ConversionDecimalToBinary.convertDoubleFractionalPartToBinary(Double.parseDouble(nachkomma)));
                                input_okt.setText(oktal_vor);
                            } else {
                                Toast.makeText(MainActivity.this, "Bitte Kommastelle eingeben (.0)", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(MainActivity.this, "Bitte Angaben machen.", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
            });

        input_hex.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                        if(input_hex.isFocused()){
                        if(!input_hex.getText().toString().equals("")) {
                            if (input_hex.getText().toString().contains(".0") ||
                                    input_hex.getText().toString().contains(".1") ||
                                    input_hex.getText().toString().contains(".2") ||
                                    input_hex.getText().toString().contains(".3") ||
                                    input_hex.getText().toString().contains(".4") ||
                                    input_hex.getText().toString().contains(".5") ||
                                    input_hex.getText().toString().contains(".6") ||
                                    input_hex.getText().toString().contains(".7") ||
                                    input_hex.getText().toString().contains(".8") ||
                                    input_hex.getText().toString().contains(".9") ||
                                    input_hex.getText().toString().contains(".A") ||
                                    input_hex.getText().toString().contains(".B") ||
                                    input_hex.getText().toString().contains(".C") ||
                                    input_hex.getText().toString().contains(".D") ||
                                    input_hex.getText().toString().contains(".E") ||
                                    input_hex.getText().toString().contains(".F")) {
                                String[] split = input_hex.getText().toString().split("\\.");
                                String vorkomma = split[0];
                                String nachkomma = split[1];
                                ConversionClass.convertHexadecimalToBinary(vorkomma);
                                ConversionClass.convertHexadecimalFraktionalPartToBinary(nachkomma);
                                String hex_to_binary = ConversionClass.s;
                                ConversionClass.s = "";
                                ConversionClass.convertHexadecimalToOktal(vorkomma);
                                ConversionClass.convertHexadecimalFraktionalPartToOktal(nachkomma);
                                String hexa_to_oktal = ConversionClass.s;
                                ConversionClass.s = "";
                                ConversionClass.convertHexadecimalToDecimal(vorkomma);
                                ConversionClass.convertHexadecimalFraktionalPartToDecimal(nachkomma);
                                String hexa_to_decimal = ConversionClass.s;
                                ConversionClass.s = "";
                                input_bin.setText(hex_to_binary);
                                input_dec.setText(hexa_to_decimal);
                                input_okt.setText(hexa_to_oktal);
                            } else {
                                Toast.makeText(MainActivity.this, "Bitte Kommastelle eingeben (.0)", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(MainActivity.this, "Bitte Angaben machen.", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
            });}
        }
/*
    private void setupClickListeners(){

        // Oktal eingabe

        convert_okt.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if(!input_okt.getText().toString().equals("")) {
                    if (input_okt.getText().toString().contains(".")) {
                        input_okt.setText(input_okt.getText().toString().replace(",","."));
                        String[] split = input_okt.getText().toString().split("\\.");
                        String vorkomma = split[0];
                        String nachkomma =  split[1];
                        tester.setText(nachkomma);
                        String nachkomma2 = split[1];
                        ConversionClass.convertOktalToBinary(vorkomma);
                        ConversionClass.convertOktalFraktionalPartToBinary(nachkomma);
                        String oktal_to_binary = ConversionClass.s;
                        ConversionClass.s = "";
                        ConversionClass.convertOktalToHexadecimal(vorkomma);
                       ConversionClass.convertOktalFraktionalPartToHexadecimal(nachkomma);
                        String oktal_to_hexa = ConversionClass.s;
                        ConversionClass.s = "";
                        ConversionClass.convertOktalToDecimal(vorkomma);
                        ConversionClass.convertOktalFraktionalPartToDecimal(nachkomma);
                        String oktal_to_decimal = ConversionClass.s;
                        ConversionClass.s = "";
                        input_hex.setText(oktal_to_hexa);
                        input_bin.setText(oktal_to_binary);
                        input_dec.setText(oktal_to_decimal);
                    } else {
                        Toast.makeText(MainActivity.this, "Bitte Kommastelle eingeben (.0)", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Bitte Angaben machen.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //Hexadezimal eingabe
        convert_hex.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if(!input_hex.getText().toString().equals("")) {
                    if (input_hex.getText().toString().contains(".")) {
                        String[] split = input_hex.getText().toString().split("\\.");
                        String vorkomma = split[0];
                        String nachkomma = split[1];
                        tester.setText(nachkomma);
                        ConversionClass.convertHexadecimalToBinary(vorkomma);
                        ConversionClass.convertHexadecimalFraktionalPartToBinary(nachkomma);
                        String hex_to_binary = ConversionClass.s;
                        ConversionClass.s = "";
                        ConversionClass.convertHexadecimalToOktal(vorkomma);
                        ConversionClass.convertHexadecimalFraktionalPartToOktal(nachkomma);
                        String hexa_to_oktal = ConversionClass.s;
                        ConversionClass.s = "";
                        ConversionClass.convertHexadecimalToDecimal(vorkomma);
                        ConversionClass.convertHexadecimalFraktionalPartToDecimal(nachkomma);
                        String hexa_to_decimal = ConversionClass.s;
                        ConversionClass.s = "";
                        input_bin.setText(hex_to_binary);
                        input_dec.setText(hexa_to_decimal);
                        input_okt.setText(hexa_to_oktal);
                    } else {
                        Toast.makeText(MainActivity.this, "Bitte Kommastelle eingeben (.0)", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Bitte Angaben machen.", Toast.LENGTH_SHORT).show();
                }

            }
        });


        //Binärzahl eingabe
        convert_bin.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if(!input_bin.getText().toString().equals("")) {
                    input_bin.setText(input_bin.getText().toString().replace(",","."));
                    if (input_bin.getText().toString().contains(".")) {
                        String[] split = input_bin.getText().toString().split("\\.");
                        String vorkomma = split[0];
                        String nachkomma = split[1];
                        tester.setText(nachkomma);
                        ConversionClass.convertBinaryToHexadecimal(vorkomma);
                        ConversionClass.convertBinaryFraktionalPartToHexadecimal(nachkomma);
                        String binary_to_hex_vor = ConversionClass.s;
                        ConversionClass.s = "";
                        ConversionClass.convertBinaryToOktal(vorkomma);
                        ConversionClass.convertBinaryFraktionalPartToOktal(nachkomma);
                        String binary_to_oktal = ConversionClass.s;
                        ConversionClass.s = "";
                        ConversionClass.convertBinaryToDecimal(vorkomma);
                        ConversionClass.convertBinaryFraktionalPartToDecimal(nachkomma);
                        String binary_to_decimal = ConversionClass.s;
                        ConversionClass.s = "";
                        input_hex.setText(binary_to_hex_vor);
                        input_dec.setText(binary_to_decimal);
                        input_okt.setText(binary_to_oktal);
                    } else {
                        Toast.makeText(MainActivity.this, "Bitte Kommastelle eingeben (.0)", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Bitte Angaben machen.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //Dezimalzahl eingabe
        convert_dec.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if(!input_dec.getText().toString().equals("")) {
                    input_dec.setText(input_dec.getText().toString().replace(",","."));
                    if (input_dec.getText().toString().contains(".")) {
                        String[] split = input_dec.getText().toString().split("\\.");
                        String vorkomma = split[0];
                        String nachkomma = "0." + split[1];
                        tester.setText(nachkomma);
                        ConversionClass.convertIntegerToHexadecimal(Integer.parseInt(vorkomma));
                        ConversionClass.convertDoubleFractionalPartToHexadecimal(Double.parseDouble(nachkomma));
                        String hexa_vor = ConversionClass.s;
                        ConversionClass.s = "";
                        ConversionClass.convertIntegerToOktal(Integer.parseInt(vorkomma));
                        ConversionClass.convertDoubleFractionalPartToOktal(Double.parseDouble(nachkomma));
                        String oktal_vor = ConversionClass.s;
                        ConversionClass.s = "";
                        ConversionClass.convertIntegerToBinary(Integer.parseInt(vorkomma));
                        ConversionClass.convertDoubleFractionalPartToBinary(Double.parseDouble(nachkomma));
                        String dec_to_bin = ConversionClass.s;
                        ConversionClass.s = "";
                        input_hex.setText(hexa_vor);
                        input_bin.setText(dec_to_bin);
                        //input_bin.setText(ConversionDecimalToBinary.convertIntegerToBinary(Integer.parseInt(vorkomma)) + "" + ConversionDecimalToBinary.convertDoubleFractionalPartToBinary(Double.parseDouble(nachkomma)));
                        input_okt.setText(oktal_vor);
                    } else {
                        Toast.makeText(MainActivity.this, "Bitte Kommastelle eingeben (.0)", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Bitte Angaben machen.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input_bin.setText("");
                input_hex.setText("");
                input_okt.setText("");
                ConversionClass.s = "";
                input_dec.setText("");

            }
        });
    }
}
//Punkteverteilung
//
//1. Lauffähigkeit mit Anzeige der umgerechneten Ergebnisse           20/20
//
//2. Mit dem Anfangsassistenten von Android Studio ist das
//   Grundgerüst für eine Applikation erstellt                         5/5
//
//3. Erstellen der graphischen Benutzeroberfläche mit dem
//   Zeicheneditor von Android Studio.                                10/10
//
//4. Widgets im Java-Code identifizieren                               5/5
//
//5. Auslesen der Eingabe                                             10/10
//
//6. Implementierung der Verknüpfungen
//   "Schaltflächenen – Handlerfunktionen" für Umrechnung und Reset   10/10
//
//7. Implementierung der Klasse ConversionDecimalToBinary mit
//   Aufruf der Methoden oder Einbau einer eigenen Klasse bzw.
//   Methoden für die Konvertierung                                   25/25
//
//8. Ausgabe des Binärzahl mit Nachkommastellen                       15/15
//
//
//                                                        Gesamt:    100/100
// Note: sehr gut
*/
