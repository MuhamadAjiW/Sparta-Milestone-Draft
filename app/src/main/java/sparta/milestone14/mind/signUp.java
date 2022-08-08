package sparta.milestone14.mind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class signUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_sign_up);
    }

    public void backClick (View view){
        finish();
    }

    public void signUpClick (View view){

    }

    public void signInClick (View view){
        Intent toSignIn = new Intent(getApplicationContext(), signIn.class);
        startActivity(toSignIn);
    }
}