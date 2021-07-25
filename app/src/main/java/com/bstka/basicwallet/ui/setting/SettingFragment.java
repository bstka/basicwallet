package com.bstka.basicwallet.ui.setting;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bstka.basicwallet.ProfileActivity;
import com.bstka.basicwallet.R;
import com.bstka.basicwallet.databinding.FragmentNotificationsBinding;
import com.bstka.basicwallet.databinding.SettingFragmentBinding;
import com.bstka.basicwallet.ui.notifications.NotificationsViewModel;

public class SettingFragment extends Fragment {

    private SettingViewModel settingViewModel;
    private SettingFragmentBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        settingViewModel =
                new ViewModelProvider(this).get(SettingViewModel.class);

        binding = SettingFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.ProfileLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newActivity = new Intent(getContext(), ProfileActivity.class);
                startActivity(newActivity);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}