package sparta.milestone14.mind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class signIn extends AppCompatActivity {

    EditText username, password;
    DBtools DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_sign_in);

        username = (EditText) findViewById(R.id.editTextUsernameLogin);
        password = (EditText) findViewById(R.id.editTextPasswordLogin);
        DB = new DBtools(this);

    }

    public void backClick (View view){
        finish();
    }

    public void loginClick (View view){

        String user = username.getText().toString();
        String pass = password.getText().toString();

        if(user.equals("") || pass.equals("")) {
            Toast.makeText(this, "Please enter all required informations", Toast.LENGTH_SHORT).show();
        }
        else{
            Boolean checkuserpass = DB.checkUsernamePassword(user, pass);
            if(checkuserpass == true){
                Toast.makeText(this, "Logged in", Toast.LENGTH_SHORT).show();
                Intent toDashboard = new Intent(getApplicationContext(), Dashboard.class);
                toDashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                toDashboard.putExtra("username", user);
                startActivity(toDashboard);
                finish();
            }
            else{
                Toast.makeText(this, "Wrong username or password", Toast.LENGTH_SHORT).show();
            }
        }
    }
}