package jeison.com.counterapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

public class homeActivity extends AppCompatActivity {


    private loadingFragment loadingFragment = new loadingFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.home_fragment, loadingFragment).commit();
    }
}