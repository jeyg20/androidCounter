package jeison.com.counterapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

import jeison.com.counterapplication.R;
import jeison.com.counterapplication.model.Counter;

public class CounterAdapter extends RecyclerView.Adapter<CounterAdapter.ViewHolder> {

    private ArrayList<Counter> counterList;

    public CounterAdapter(ArrayList<Counter> counterList) {
        this.counterList = counterList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView counterTxt;
        private TextView counterNum;

        public ViewHolder(final View view) {
            super(view);
            counterTxt = view.findViewById(R.id.tv_counter_def);
            counterNum = view.findViewById(R.id.tv_counter_time);
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
    }

    @Override
    public int getItemCount() {
        return counterList.size();
    }
}

