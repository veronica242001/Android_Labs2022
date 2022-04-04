package com.example.myapp.lab1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapp.R;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;
    private AppCompatEditText editText;
    public static final String EXTRA_MESSAGE = "MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//--------aici vom initializa toate elementele
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);

//--- R este o clasa care ne spune ca vrem sa accesam o resursa
//--- un Listener: asculta pe un anumit element si cand se produce un eveniment pe care il specificam, realizeaza o anumita actiune
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = "";
                if (editText.getText() != null) {
                    str = editText.getText().toString();

                    if(str.isEmpty()){
                        showErrorPopup();
                    }
                    else{
                        gotoSecondActivity(str);
                    }
                }
//                textView.setText(getString(R.string.hello)+" "+str);


            }
        });
    }
        private void gotoSecondActivity( String extra){
            Intent intent =  new Intent( this, SecondActivity.class);
//--- informatiile sunt stocate sub forma perechi cheie-valoare
            intent.putExtra(EXTRA_MESSAGE, extra);
            startActivity(intent);
        }
        private void showErrorPopup(){
        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage(R.string.error_msg)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
        }

}