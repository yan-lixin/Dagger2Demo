package com.daggerandroid.sample;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.daggerandroid.sample.databinding.FragmentMainBinding;
import com.daggerandroid.sample.entity.Student;

import javax.inject.Inject;

/**
 * Copyright (c), 2018-2019
 *
 * @author: lixin
 * Date: 2019/4/12
 * Description:
 */
public class MainFragment extends Fragment {

    @Inject
    Student mStudent;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentMainBinding binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_main,
                container,
                false
        );
        binding.setStudent(mStudent);
        return binding.getRoot();
    }

}
