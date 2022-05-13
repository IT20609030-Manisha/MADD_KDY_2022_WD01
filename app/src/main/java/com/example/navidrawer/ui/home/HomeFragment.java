package com.example.navidrawer.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.navidrawer.AddDonation;
import com.example.navidrawer.AdminDashboard;
import com.example.navidrawer.FeedbackView;
import com.example.navidrawer.Page12AllReviews;
import com.example.navidrawer.Page1LoginMain;
import com.example.navidrawer.R;
import com.example.navidrawer.RecyclerviewDisplayFoodList;
import com.example.navidrawer.VacancyUserView;
import com.example.navidrawer.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    //private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        /*HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;*/

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //Create Buttons

        Button btnFindFood = view.findViewById(R.id.btnFindFood);
        Button btnDonations = view.findViewById(R.id.btnDonations);
        Button btnFeed = view.findViewById(R.id.btn_Feed);
        Button btnVacancies = view.findViewById(R.id.btn_Vacancies);
        Button btnRateUs = view.findViewById(R.id.btn_rateUs);

        //set Listners

        //Find Food
        btnFindFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), RecyclerviewDisplayFoodList.class));
            }
        });

        //Donations
        btnDonations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), AddDonation.class));
            }
        });

        //Feedbacks
        btnFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), FeedbackView.class));
            }
        });

        //Vacancies
        btnVacancies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), VacancyUserView.class));
            }
        });

        //Rate Us
        btnRateUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), Page12AllReviews.class));
            }
        });

        return view;


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //binding = null;
    }
}