package com.example.whatsyourgrade;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText NameInput ;
    private EditText ScoreInput;
    private Button GradeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NameInput = (EditText) findViewById(R.id.Name_edittext);
        ScoreInput = (EditText) findViewById(R.id.Score_edittext);



        GradeButton = (Button) findViewById(R.id.Grade_button);
        GradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check validate
/*                EditText Name1 = (EditText)findViewById(R.id.Name_edittext);
                EditText Score1 = (EditText)findViewById(R.id.Score_edittext);
                if(Name1.getText().toString().length() == 0 )
                    Name1.setError("ป้อนชื่อ");
                if(Score1.getText().toString().length() == 0 )
                    Score1.setError("ป้อนคะแนน");*/

                String Nametext = NameInput.getText().toString();
                String Scoretext = ScoreInput.getText().toString();
                if(NameInput.getText().length() == 0 )
                    NameInput.setError("ป้อนชื่อ");
                else if (ScoreInput.length() == 0 )
                    ScoreInput.setError("ป้อนคะแนน");
                else if(NameInput.getText().length() == 0 || ScoreInput.length() == 0) {NameInput.setError("ป้อนชื่อ");
                    ScoreInput.setError("ป้อนคะแนน");


                }else{






                double Score = Double.valueOf(Scoretext);
                String ScoreAnswer = getScore(Score);


                Intent intent = new Intent(MainActivity.this,ShowGrade.class);
                intent.putExtra("Name_value",Nametext);
                intent.putExtra("Score_value",ScoreAnswer);
                startActivity(intent);
                }
            }
        });






        //Exit
        Button exitButton =  (Button) findViewById(R.id.Exit_button);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Confirm Exit")
                        .setMessage("แน่ใจว่าต้องการออกจากแอพ")
                        .setCancelable(false)
                        .setPositiveButton("ยกเลิก", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("ออก", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                MainActivity.this.finish();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    private String getScore(double score) {
        String Scoreanswer = "";
        if(score >= 80){
            Scoreanswer = "A";
        }else if (score < 70 && score <79){
            Scoreanswer = "B";
        }else if (score < 60 && score <69){
            Scoreanswer = "C";
        }else if(score < 50 && score <59){
            Scoreanswer = "D";
        }else{
            Scoreanswer = "F";
        }
        return Scoreanswer;
    }


}
