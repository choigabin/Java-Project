package kr.hs.emirim.gaebi.java_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

    private Button joinBtn;
    private Button loginBtn;
    private EditText join_email, join_password;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        //파이어베이스 계정 권한 생성
        mAuth = FirebaseAuth.getInstance();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference bbf = database.getReference("bbf");

        join_email = findViewById(R.id.join_email);
        join_password = findViewById(R.id.join_password);

        findViewById(R.id.joinBtn).setOnClickListener(onClickListener);
        findViewById(R.id.loginBtn).setOnClickListener(onClickListener);

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.joinBtn:
                    Intent intent = new Intent(LoginActivity.this, JoinActivity.class);
                    startActivity(intent);
                    break;
                case R.id.loginBtn:
                    signIn();
            }
        }
    };
    private void signIn() {
        //xml에 선언한 login_email(EditText)의 텍스트를 String타입으로 변환하여 email 변수에 넣어줌
        String email = ((EditText)findViewById(R.id.join_email)).getText().toString();
        //xml에 선언한 login_password(EditText)의 텍스트를 String타입으로 변환하여 password 변수에 넣어줌
        String password = ((EditText)findViewById(R.id.join_password)).getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(LoginActivity.this, "로그인 성공!", Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                        } else {
                            if(task.getException() != null) {
                                Toast.makeText(LoginActivity.this, "로그인에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, JoinActivity.class);
                                startActivity(intent);
                            }
                        }
                    }
                });
    }

}
