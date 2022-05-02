package com.example.navidrawer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.Calendar;

public class AddDonation extends AppCompatActivity {
    FirebaseDatabase mDatabase;
    DatabaseReference mRef;
    FirebaseStorage mStorage;
    ImageButton imageButton;
    EditText edtDonName, edtLocation, edtFoodTitle, edtFoodQty, edtExpDate, edtNote;
    Button btnAddDonation;
    RadioButton rbPrefood, rbBeverages;
    private static final int Gllery_Code = 1;
    Uri imageUrl = null;
    ProgressDialog progressDialog;
    private int mDate, mMonth, mYear;

    //method to clear all user inputs
    private void clearControls(){
        edtDonName.setText("");
        edtLocation.setText("");
        edtFoodTitle.setText("");
        edtFoodQty.setText("");
        edtExpDate.setText("");
        edtNote.setText("");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_donation);

        this.setTitle("Donations Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageButton = findViewById(R.id.ibDonateImg);
        edtDonName = findViewById(R.id.etDonorName);
        edtLocation = findViewById(R.id.etDonorLocation);
        edtFoodTitle = findViewById(R.id.etFoodTitle);
        edtFoodQty = findViewById(R.id.etFoodQuantity);
        edtExpDate = findViewById(R.id.etExpiryDate);
        edtNote = findViewById(R.id.etSpecialNote);
        btnAddDonation = findViewById(R.id.btnSubmitDonation);
        rbPrefood = findViewById(R.id.prepFood);
        rbBeverages = findViewById(R.id.bever);

        mDatabase = FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference().child("Donation");
        mStorage = FirebaseStorage.getInstance();
        progressDialog = new ProgressDialog(this);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,Gllery_Code);
            }
        });

        //date picker
        edtExpDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar Cal = Calendar.getInstance();
                mDate = Cal.get(Calendar.DATE);
                mMonth = Cal.get(Calendar.MONTH);
                mYear = Cal.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog = new DatePickerDialog(AddDonation.this, android.R.style.Theme_DeviceDefault_Dialog, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int date) {
                        edtExpDate.setText(date + "/" + month + "/" + year);

                    }
                } , mYear, mMonth, mDate);
                //disable previous dates
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis()-1000);
                datePickerDialog.show();
            }
        });

    }//end of onCreate

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == Gllery_Code && resultCode == RESULT_OK){
            imageUrl = data.getData();
            imageButton.setImageURI(imageUrl);
        }

        btnAddDonation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String DonorName = edtDonName.getText().toString().trim();
                String DonorLocation = edtLocation.getText().toString().trim();
                String FoodTitle = edtFoodTitle.getText().toString().trim();
                String Quantity = edtFoodQty.getText().toString().trim();
                String ExpiryDate = edtExpDate.getText().toString().trim();
                String SpNote = edtNote.getText().toString().trim();
                String Status = "Pending".trim();
                //radio
                String preFood = rbPrefood.getText().toString().trim();
                String beverages = rbBeverages.getText().toString().trim();

                if(!DonorName.isEmpty() && !DonorLocation.isEmpty() && !FoodTitle.isEmpty() && !Quantity.isEmpty() && !ExpiryDate.isEmpty() && imageUrl != null){
                    progressDialog.setTitle("Uploading...");
                    progressDialog.show();

                    StorageReference filepath = mStorage.getReference().child("donationPost").child(imageUrl.getLastPathSegment()); //imagePost - DonationPost
                    filepath.putFile(imageUrl).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Task<Uri> downloadUrl = taskSnapshot.getStorage().getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    String t = task.getResult().toString();

                                    DatabaseReference newPost = mRef.push();

                                    newPost.child("DonorName").setValue(DonorName);
                                    newPost.child("DonorLocation").setValue(DonorLocation);
                                    newPost.child("FoodTitle").setValue(FoodTitle);
                                    newPost.child("Quantity").setValue(Quantity);
                                    newPost.child("ExpDate").setValue(ExpiryDate);
                                    newPost.child("SpecialNote").setValue(SpNote);
                                    newPost.child("Status").setValue(Status);
                                    newPost.child("image").setValue(task.getResult().toString());
                                    //radio
                                    if(rbPrefood.isChecked()){
                                        newPost.child("Category").setValue(preFood);
                                    }
                                    else{
                                        newPost.child("Category").setValue(beverages);
                                    }
                                    progressDialog.dismiss();
                                    clearControls();
                                    Toast.makeText(getApplicationContext(),"Donation added successfully",Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    });
                }
            }
        });
    }
}