package sg.edu.np.mad.mad_recyclerview;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class DemoViewHolder extends RecyclerView.ViewHolder{
    TextView txt;
    CheckBox cb;

    public DemoViewHolder(View itemView){
        super(itemView);
        txt = itemView.findViewById(R.id.textToDo);
        cb = itemView.findViewById(R.id.checkboxTodo);
    }

}
