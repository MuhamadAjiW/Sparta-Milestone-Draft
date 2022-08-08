package sparta.milestone14.mind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home);
    }

    public void exitClick (View view){
        finish();
        System.exit(0);
    }

    public void signUpClick (View view){
        Intent toSignUp = new Intent(getApplicationContext(), signUp.class);
        startActivity(toSignUp);
    }

    public void signInClick (View view){
        Intent toSignIn = new Intent(getApplicationContext(), signIn.class);
        startActivity(toSignIn);
    }
}