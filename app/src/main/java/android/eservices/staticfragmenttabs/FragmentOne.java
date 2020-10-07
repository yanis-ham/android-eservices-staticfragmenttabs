package android.eservices.staticfragmenttabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;


public class FragmentOne extends Fragment{

    public static final String TAB_NAME = "ADD TO COUNTER";
    static Button buttonIncrement;

    public FragmentOne() {

    }

    public static FragmentOne newInstance() {
        FragmentOne fragmentOne = new FragmentOne();
        return fragmentOne;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_one, container, false);


        buttonIncrement = v.findViewById(R.id.button_increment);
        buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                ((MainActivity)getActivity()).OnButtonSelected(buttonIncrement,1);
            }
        });

        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    public interface OnButtonSelectedListener {
        public void OnButtonSelected(Button buttonIncrement, int idButton);
    }

}
