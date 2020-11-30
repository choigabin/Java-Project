package kr.hs.emirim.gaebi.java_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

public class ChoiceActivity extends AppCompatActivity {

    private ImageButton studentBtn;
    private ImageButton teacherBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_choice);

        studentBtn = findViewById(R.id.studentBtn);
        studentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoiceActivity.this, StudentActivity.class);
                startActivity(intent);
            }
        });

        teacherBtn = findViewById(R.id.teacherBtn);
        teacherBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoiceActivity.this, TeacherActivity.class);
                startActivity(intent);
            }
        });

    }
}