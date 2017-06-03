package com.example.kir.rp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import java.net.HttpURLConnection;
import java.net.*;
import java.io.*;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*TextView ModeView = (TextView)findViewById(R.id.ModeView);
        TextView SwingView = (TextView)findViewById(R.id.SwingView);
        TextView SpeedView = (TextView)findViewById(R.id.SpeedView);
        ModeView.setText("Охлаждение");
        SwingView.setText("Авто");
        SpeedView.setText("Авто");*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void TempPlusButtonOnClick(View view) {
        TextView tempView = (TextView)findViewById(R.id.tempView);
        String temp = tempView.getText().toString();
        temp = temp.substring(0,2);
        int tempNum = Integer.parseInt(temp);

        if (tempNum < 30) {
            tempNum++;
        }

        tempView.setText(Integer.toString(tempNum)+"°C");
    }

    public void TempMinusButtonOnClick(View view) {
        TextView tempView = (TextView)findViewById(R.id.tempView);
        String temp = tempView.getText().toString();
        temp = temp.substring(0,2);
        int tempNum = Integer.parseInt(temp);

        if (tempNum > 16) {
            tempNum--;
        }

        tempView.setText(Integer.toString(tempNum)+"°C");
    }

    public void PowerButtonOnClick(View view) {
        Button PowerButton = (Button)findViewById(R.id.PowerButton);
        String Power = PowerButton.getText().toString();

        switch(Power) {
            case "Включить":
                PowerButton.setText("Выключить");
                break;
            case "Выключить":
                PowerButton.setText("Включить");
                break;
            default:
                PowerButton.setText("Включить");
                break;
        }
    }

    public void ModeButtonOnClick(View view) {
        TextView ModeView = (TextView)findViewById(R.id.ModeView);
        String Mode = ModeView.getText().toString();

        switch(Mode) {
            case "Охлаждение":
                ModeView.setText("Обогрев");
                break;
            case "Обогрев":
                ModeView.setText("Охлаждение");
                break;
            default:
                ModeView.setText("Охлаждение");
                break;
        }
    }

    public void SwingButtonOnClick(View view) {
        TextView SwingView = (TextView)findViewById(R.id.SwingView);
        String Swing = SwingView.getText().toString();

        switch(Swing) {
            case "Авто":
                SwingView.setText("Вверх");
                break;
            case "Вверх":
                SwingView.setText("Мид");
                break;
            case "Мид":
                SwingView.setText("Вниз");
                break;
            case "Вниз":
                SwingView.setText("Авто");
                break;
            default:
                SwingView.setText("Авто");
                break;
        }
    }

    public void SpeedButtonOnClick(View view) {
        TextView SpeedView = (TextView)findViewById(R.id.SpeedView);
        String Speed = SpeedView.getText().toString();

        switch(Speed) {
            case "Авто":
                SpeedView.setText("Высокая");
                break;
            case "Высокая":
                SpeedView.setText("Средняя");
                break;
            case "Средняя":
                SpeedView.setText("Низкая");
                break;
            case "Низкая":
                SpeedView.setText("Авто");
                break;
            default:
                SpeedView.setText("Авто");
                break;
        }
    }

    public void RozetkaButtonOnClick(View view) {
        Button RozetkaButton = (Button)findViewById(R.id.RozetkaButton);
        String Power = RozetkaButton.getText().toString();

        switch(Power) {
            case "Включить":
                RozetkaButton.setText("Выключить");
                try {
                URL url = new URL("http://192.168.100.12/cgi-bin/main.cgi?up14");
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                }
                catch  (Exception ex){

                }
                break;
            case "Выключить":
                RozetkaButton.setText("Включить");
                try {
                    URL url = new URL("http://192.168.100.12/cgi-bin/main.cgi?up14");
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                }
                catch  (Exception ex){

                }
                break;
            default:
                RozetkaButton.setText("Включить");
                break;
        }
    }

    public void LampaButtonOnClick(View view) {
        Button LampaButton = (Button)findViewById(R.id.LampaButton);
        String Power = LampaButton.getText().toString();

        switch(Power) {
            case "Включить":
                LampaButton.setText("Выключить");
                /*try {
                    URL url = new URL("http://192.168.100.12/cgi-bin/main.cgi?up14");
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                }
                catch  (Exception ex){

                }*/
                break;
            case "Выключить":
                LampaButton.setText("Включить");
                SendUrl("http://192.168.100.12/cgi-bin/main.cgi?up14");
                break;
            default:
                LampaButton.setText("Включить");
                break;
        }
    }

    public void SendUrl(String urlText){
        try {
            URL url = new URL(urlText);
            url.openConnection();
        }
        catch  (Exception ex) {

        }
    }
}
