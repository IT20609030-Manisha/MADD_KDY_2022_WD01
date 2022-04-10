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

import com.example.navidrawer.AdminDashboard;
import com.example.navidrawer.R;
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
        Button btnHowToUse = view.findViewById(R.id.btn_HowToUse);

        //set Listners
        //How to use
        btnHowToUse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), AdminDashboard.class));
            }
        });
        //Donations
        return view;


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //binding = null;
    }
}