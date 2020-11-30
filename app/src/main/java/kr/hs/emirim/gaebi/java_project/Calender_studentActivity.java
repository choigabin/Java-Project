package kr.hs.emirim.gaebi.java_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class Calender_studentActivity extends AppCompatActivity {

    private ImageButton backBtn;
    private Button addschBtn;
    private ImageButton calBtn;
    private ImageButton docBtn;
    private ImageButton inBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_calender_student);

        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calender_studentActivity.this, StudentActivity.class);
                startActivity(intent);
            }
        });

        addschBtn = findViewById(R.id.addschBtn);
        addschBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calender_studentActivity.this, Addschedule_studentActivity.class);
                startActivity(intent);
            }
        });
        calBtn = findViewById(R.id.calBtn);
        calBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calender_studentActivity.this, Calender_studentActivity.class);
                startActivity(intent);
            }
        });

        docBtn = findViewById(R.id.docBtn);
        docBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calender_studentActivity.this, Choicesub_studentActivity.class);
                startActivity(intent);
            }
        });

        inBtn = findViewById(R.id.inBtn);
        inBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calender_studentActivity.this, Checkinfo_studentActivity.class);
                startActivity(intent);
            }
        });
    }
}