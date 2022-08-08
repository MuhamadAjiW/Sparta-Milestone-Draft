package sparta.milestone14.mind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class signUp extends AppCompatActivity {

    EditText username, password, name;
    DBtools DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_sign_up);

        username = (EditText) findViewById(R.id.editTextUsernameSignup);
        password = (EditText) findViewById(R.id.editTextPasswordSignup);
        name = (EditText) findViewById(R.id.editTextNameSignup);
        DB = new DBtools(this);
    }

    public void backClick (View view){
        finish();
    }



    public void signUpClick (View view){
        String user = username.getText().toString();
        String pass = password.getText().toString();
        String nickN = name.getText().toString();

        if(user.equals("") || pass.equals("") || name.equals("")) {
            Toast.makeText(this, "Please enter all required informations", Toast.LENGTH_SHORT).show();
        }
        else {
            Boolean checkUser = DB.checkUsername(user);
            if(checkUser==false){
                Boolean insert = DB.insertData(user, pass, nickN);
                if(insert==true){
                    Toast.makeText(this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                    Intent toSignIn = new Intent(getApplicationContext(), signIn.class);
                    startActivity(toSignIn);
                    finish();
                }
                else {
                    Toast.makeText(this, "Registration Failed", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(this, "User already exists", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void signInClick (View view){
        Intent toSignIn = new Intent(getApplicationContext(), signIn.class);
        startActivity(toSignIn);
    }
}