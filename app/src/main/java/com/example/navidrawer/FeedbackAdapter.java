package com.example.navidrawer;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navidrawer.model.FeedbackCls;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;


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
    protected void onBindViewHolder(@NonNull myViewHolder holder, final int position, @NonNull FeedbackCls model) {
        holder.name.setText(model.getName());
        holder.email.setText(model.getEmail());
        holder.message.setText(model.getMessage());

        //Update
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.name.getContext())
                        .setContentHolder(new ViewHolder(R.layout.update_popup))
                        .setExpanded(true,1200)
                        .create();

                //dialogPlus.show();

                View view1 = dialogPlus.getHolderView();

                EditText name = view1.findViewById(R.id.txtName);
                EditText email = view1.findViewById(R.id.txtEmail);
                EditText message = view1.findViewById(R.id.txtMessage);

                Button btnUpdate = view1.findViewById(R.id.btnUpdate);

                name.setText(model.getName());
                email.setText(model.getEmail());
                message.setText(model.getMessage());

                dialogPlus.show();

                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map<String,Object> map = new HashMap<>();
                        map.put("name",name.getText().toString());
                        map.put("email",email.getText().toString());
                        map.put("message",message.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("FeedbackCls")
                                .child(getRef(holder.getAdapterPosition()).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(holder.name.getContext(), "Data Updated Successfully.", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(Exception e) {
                                        Toast.makeText(holder.name.getContext(), "Error While Updating.", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                });
                    }
                });
            }
        });

        //Delete
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.name.getContext());
                builder.setTitle("Are you Sure?");
                builder.setMessage("Deleted data cannot be Undo.");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        FirebaseDatabase.getInstance().getReference().child("FeedbackCls")
                                .child(getRef(holder.getAdapterPosition()).getKey()).removeValue();

                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Toast.makeText(holder.name.getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
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
