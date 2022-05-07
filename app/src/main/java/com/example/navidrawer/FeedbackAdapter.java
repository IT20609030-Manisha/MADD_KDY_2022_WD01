package com.example.navidrawer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navidrawer.model.FeedbackCls;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;


public class FeedbackAdapter extends FirebaseRecyclerAdapter<FeedbackCls, FeedbackAdapter.myViewHolder>{

    /**
     * Initialize a {@Link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@Link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public FeedbackAdapter(@NonNull FirebaseRecyclerOptions<FeedbackCls> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull FeedbackCls model) {
        holder.name.setText(model.getName());
        holder.email.setText(model.getEmail());
        holder.message.setText(model.getMessage());

        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.name.getContext())
                        .setContentHolder(new ViewHolder(R.layout.update_popup))
                        .setExpanded(true,1200)
                        .create();

                dialogPlus.show();
            }
        });

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feedback_item,parent,false);
        return new myViewHolder(view);
    }


    class myViewHolder extends RecyclerView.ViewHolder{

        TextView name,email,message;

        Button btnEdit, btnDelete;



        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.txtName);
            email = (TextView) itemView.findViewById(R.id.txtEmail);
            message = (TextView) itemView.findViewById(R.id.txtMessage);

            btnEdit = (Button) itemView.findViewById(R.id.btnEdit);
            btnDelete = (Button) itemView.findViewById(R.id.btnDelete);
        }
    }

    /*public abstract class FirebaseRecycleAdapter<T, T1> {
        public FirebaseRecycleAdapter(FirebaseRecyclerOptions<FeedbackCls> options) {
        }

        protected abstract void onBindVieHolder(@NonNull FeedbackAdapter.myViewHolder holder, int position, @NonNull FeedbackCls fdbck);

        @NonNull
        public abstract FeedbackAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType);
    }*/

}
