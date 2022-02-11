package jeison.com.counterapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

import jeison.com.counterapplication.R;
import jeison.com.counterapplication.models.Counter;

public class CounterAdapter extends RecyclerView.Adapter<CounterAdapter.ViewHolder> {

    private ArrayList<Counter> counterList;

    public CounterAdapter(ArrayList<Counter> counterList) {
        this.counterList = counterList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView counterTxt;
        private final TextView counterNum;
        private final Button sumCounter;
        private final Button subtractCounter;

        public ViewHolder(final View view) {
            super(view);
            counterTxt = view.findViewById(R.id.tv_counter_def);
            counterNum = view.findViewById(R.id.tv_counter_time);
            sumCounter = view.findViewById(R.id.iv_sum_counter);
            subtractCounter = view.findViewById(R.id.iv_subtract_counter);
        }
    }

    @NonNull
    @Override
    public CounterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_counter
                , parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CounterAdapter.ViewHolder holder, int position) {
        String definition = counterList.get(position).getDefinition();
        holder.counterTxt.setText(definition);

        int counterTime = counterList.get(position).getCounterTime();
        holder.counterNum.setText(String.valueOf(counterTime));

        // counters val addition and subtraction
        holder.sumCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = Integer.parseInt(holder.counterNum.getText().toString());
                number++;
                holder.counterNum.setText(String.valueOf(number));
            }
        });

        holder.subtractCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = Integer.parseInt(holder.counterNum.getText().toString());
                if (number <= 0) {
                    number = 0;
                } else {
                    number--;
                    holder.counterNum.setText(String.valueOf(number));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return counterList.size();
    }
}

