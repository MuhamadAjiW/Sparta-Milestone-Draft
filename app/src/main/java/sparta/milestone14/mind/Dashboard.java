package sparta.milestone14.mind;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class Dashboard extends AppCompatActivity {

    DBtools DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Bundle extras = getIntent().getExtras();
        String username = extras.getString("username");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        DB = new DBtools(this);
        int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        TextView welcome = findViewById(R.id.welcomeText);
        TextView greeting = findViewById(R.id.greetingText);

        if (currentHour >= 2 && currentHour <= 10){
            String greet = "Good Morning";
            greeting.setText(greet);
        }
        else
            if (currentHour >= 11 && currentHour <= 16){
                String greet = "Good Afternoon";
                greeting.setText(greet);
            }
            else {
                String greet = "Good Evening";
                greeting.setText(greet);
            }

        String name = DB.getName(username);
        welcome.setText(name);

    }
}