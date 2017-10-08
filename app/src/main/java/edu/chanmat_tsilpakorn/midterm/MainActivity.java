package edu.chanmat_tsilpakorn.midterm;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText NameEditText,ScoreEditText;
    private Button FindButton,ExitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NameEditText = (EditText) findViewById(R.id.editText);
        ScoreEditText = (EditText) findViewById(R.id.editText2);
        FindButton = (Button) findViewById(R.id.find);
        ExitButton = (Button) findViewById(R.id.exit);
        FindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (NameEditText.getText().toString().equals("") && ScoreEditText.getText().toString().equals("")){
                NameEditText.setError("ป้อนชื่อ");
                ScoreEditText.setError("ป้อนชื่อ");
            }
            else if (NameEditText.getText().toString().equals("") ){
                    NameEditText.setError("ป้อนชื่อ");

                }
            else if ( ScoreEditText.getText().toString().equals("")){

                    ScoreEditText.setError("ป้อนชื่อ");
                }
            else{
                Integer score = Integer.valueOf(ScoreEditText.getText().toString());
                String result = cal(score);
                String result2 = String.format("%s", result);
                String name = NameEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("name",name);
                intent.putExtra("result2",result2);
                startActivity(intent);
            }


            }
        });
        ExitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Confirm Exit");
                dialog.setMessage("แน่ใจว่าต้องการออกจากแอพ?");
                dialog.setPositiveButton("ออก", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                dialog.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
            }
        });

    }
    private String cal(Integer score){
        String grade = " ";
        if (score>=80){
            grade = "A";
        }else if (score>=70){
            grade = "B";
        }else if (score>=60){
            grade = "C";
        }else if (score>=50){
            grade = "D";
        }else{
            grade = "F";
        }
        return grade;
    }
}
