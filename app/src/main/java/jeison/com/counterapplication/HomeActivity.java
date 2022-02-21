package jeison.com.counterapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import jeison.com.counterapplication.adapters.CounterAdapter;
import jeison.com.counterapplication.models.Counter;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView totalCounters;

    private final ArrayList<Counter> countersList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViews();

        createCounters();
        setAdapter();
        setTotalCounters();
    }

    private void initViews(){
        recyclerView  = findViewById(R.id.rvCounters);
        totalCounters = findViewById(R.id.tvTotalCounterVal);
    }

    private void setTotalCounters(){
        totalCounters.setText(String.valueOf(countersList.size()));
    }

    private void setAdapter() {
        CounterAdapter adapter = new CounterAdapter(countersList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void createCounters() {
        countersList.add(new Counter("Cups of coffee", 0));
        countersList.add(new Counter("Records played", 0));
        countersList.add(new Counter("Number of times I’ve forgotten my mother’s name " +
                "because I was high on Frugelés.", 0));
        countersList.add(new Counter("Apples eaten", 0));

    }
}