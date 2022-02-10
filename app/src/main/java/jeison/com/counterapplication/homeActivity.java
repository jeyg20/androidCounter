package jeison.com.counterapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import jeison.com.counterapplication.adapter.CounterAdapter;
import jeison.com.counterapplication.model.Counter;

public class homeActivity extends AppCompatActivity {
    private ArrayList<Counter> countersList;
    private RecyclerView recyclerView;
    private TextView totalCounters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView  = findViewById(R.id.rvCounters);
        totalCounters = findViewById(R.id.tv_total_counter_val);

        countersList = new ArrayList<>();

        setDef();
        setAdapter();

        int listLength = countersList.size();

        totalCounters.setText(String.valueOf(listLength));
    }

    private void setAdapter() {
        CounterAdapter adapter = new CounterAdapter(countersList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setDef() {
        countersList.add(new Counter("Cups of coffee", 0));
        countersList.add(new Counter("Records played", 0));
        countersList.add(new Counter("Number of times I’ve forgotten my mother’s name " +
                "because I was high on Frugelés.", 0));
        countersList.add(new Counter("Apples eaten", 0));

    }
}