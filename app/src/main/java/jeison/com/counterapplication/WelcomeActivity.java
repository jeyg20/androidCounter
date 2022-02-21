package jeison.com.counterapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        initViews();
        initListeners();
    }

    private void initViews(){
        button = (Button) findViewById(R.id.button_home);
    }

    private void initListeners(){
        button.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext() , HomeActivity.class);
            startActivity(intent);
        });
    }
}

