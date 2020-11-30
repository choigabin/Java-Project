package kr.hs.emirim.gaebi.java_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

public class Choicesub_teacherActivity extends AppCompatActivity {

    private ImageButton backBtn;
    private ImageButton calBtn;
    private ImageButton docBtn;
    private ImageButton inBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_choicesub_teacher);

        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Choicesub_teacherActivity.this, TeacherActivity.class);
                startActivity(intent);
            }
        });

        calBtn = findViewById(R.id.calBtn);
        calBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Choicesub_teacherActivity.this, Calender_teacherActivity.class);
                startActivity(intent);
            }
        });

        docBtn = findViewById(R.id.docBtn);
        docBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Choicesub_teacherActivity.this, Choicesub_teacherActivity.class);
                startActivity(intent);
            }
        });

        inBtn = findViewById(R.id.inBtn);
        inBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Choicesub_teacherActivity.this, Checkinfo_teacherActivity.class);
                startActivity(intent);
            }
        });
    }
}