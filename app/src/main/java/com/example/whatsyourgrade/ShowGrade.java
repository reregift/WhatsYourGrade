package com.example.whatsyourgrade;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.widget.TextView;

public class ShowGrade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_grade);
        Intent intent = getIntent();
        String Name_output = intent.getStringExtra("Name_value");
        String Score_output = intent.getStringExtra("Score_value");

        TextView t = (TextView) findViewById(R.id.Name_show);
        TextView t2 = (TextView) findViewById(R.id.score_show);
        t.setText(Name_output);
        t2.setText(Score_output);


    }
}
