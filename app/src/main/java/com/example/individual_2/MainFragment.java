package com.example.individual_2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.individual_2.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {
    private FragmentMainBinding binding;
    public static final int YES = 0;
    public static final int NO = 1;



    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false);

        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                handleRadioButtonSelection(checkedId);
            }
        });

        binding.closeAppBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeApp();
            }
        });



        return binding.getRoot();




    }

    private void handleRadioButtonSelection(int checkedId) {
        if (checkedId == R.id.radio_button_yes) {
            binding.fragmentHeader.setText(R.string.yes_message);
        } else if (checkedId == R.id.radio_button_no) {
            binding.fragmentHeader.setText(R.string.no_message);
        }
        // No need for a default case here as we've covered both radio buttons.
    }

    private void closeApp() {
        // This will close the entire app (use cautiously)
        System.exit(0);
    }




}