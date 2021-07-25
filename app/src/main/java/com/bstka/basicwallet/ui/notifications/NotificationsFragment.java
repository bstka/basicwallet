package com.bstka.basicwallet.ui.notifications;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bstka.basicwallet.R;
import com.bstka.basicwallet.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        LinearLayout GrandParents = (LinearLayout) binding.GrandParents;
//        final TextView textView = binding.textNotifications;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String[][]>() {
            @Override
            public void onChanged(@Nullable String[][] s) {
                for (int i = 0; i < s.length; i++) {

                    LinearLayout Parents = (LinearLayout) new LinearLayout(getContext());
                    Parents.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    Parents.setOrientation(LinearLayout.VERTICAL);
                    Parents.setPadding(10 ,20, 10, 20);

                    LinearLayout ChildLayout = (LinearLayout) new LinearLayout(getContext());
                    ChildLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    ChildLayout.setOrientation(LinearLayout.HORIZONTAL);

                    TextView DateText = new TextView(getContext());
                    DateText.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f));
                    DateText.setTextSize(14);
                    DateText.setText(s[i][1]);
                    DateText.setTextColor(Color.parseColor("#000000"));

                    TextView StatusText = new TextView(getContext());
                    StatusText.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 0));
                    StatusText.setTextSize(16);
                    StatusText.setText(s[i][0]);
                    switch (s[i][0]) {
                        case "SUCCESS" : {
                            StatusText.setTextColor(Color.parseColor("#00ff00"));
                            break;
                        }

                        case "FAILED" : {
                            StatusText.setTextColor(Color.parseColor("#ff0000"));
                            break;
                        }

                        default: {
                            StatusText.setTextColor(Color.parseColor("#000000"));
                        }
                    }

                    TextView DescText = new TextView(getContext());
                    DescText.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    DescText.setTextSize(20);
                    DescText.setText(s[i][2]);
                    DescText.setTextColor(Color.parseColor("#000000"));

                    ChildLayout.addView(DateText, 0);
                    ChildLayout.addView(StatusText, 1);
                    Parents.addView(ChildLayout, 0);
                    Parents.addView(DescText, 1);
                    GrandParents.addView(Parents);
                }
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