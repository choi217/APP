package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.View;
import android.widget.Button;

public class teacher_mainpage extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_teacher_mainpage, container, false);
    }
}