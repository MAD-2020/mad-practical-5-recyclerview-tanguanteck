package sg.edu.np.mad.mad_recyclerview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DemoAdaptor extends RecyclerView.Adapter<DemoViewHolder> {
    ArrayList<String> data;
    private Context diacontext;

    public DemoAdaptor(ArrayList<String> input, Context context){

        data = input;
        diacontext = context;
    }
    public DemoViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.todolist, parent, false);
        return new DemoViewHolder(item);
    }

    public void onBindViewHolder(final DemoViewHolder holder, int position){
        final String s = data.get(position);
        holder.txt.setText(s);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(diacontext);
                final View main = LayoutInflater.from(diacontext).inflate(R.layout.delete,null);
                builder.setTitle("Delete");
                builder.setView(main);
                builder.setMessage("Are you sure you want to delete" + s + "?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        data.remove(holder.getLayoutPosition());
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog alert = builder.create();
                alert.show();


            }
        });


    }
    public int getItemCount(){

        return data.size();
    }
}
