/*
 * Name:        Nathan Craig
 * Date:        4/10/19
 * Description: Fragment file for the fragment_friends
 */
package com.e.rulesoftheroadproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class fragment_flash_cards extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_flash_cards, container, false);
        return rootView;
    }
}
