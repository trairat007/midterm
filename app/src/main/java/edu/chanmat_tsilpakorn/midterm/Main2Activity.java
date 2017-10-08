package edu.chanmat_tsilpakorn.midterm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private TextView name1,grade1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String grade = intent.getStringExtra("result2");
        name1 = (TextView) findViewById(R.id.name3);
        grade1 = (TextView) findViewById(R.id.grade3);
        name1.setText(name);
        grade1.setText(grade);
    }
}
