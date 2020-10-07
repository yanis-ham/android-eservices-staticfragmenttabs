package android.eservices.staticfragmenttabs;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;


import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import static java.lang.String.format;

public class MainActivity extends AppCompatActivity implements FragmentOne.OnButtonSelectedListener{

    private ViewPager2 viewPager;
    private int currentCounter = 0;
    private TextView counterTextView;
    private FragmentStateAdapter pagerAdapter;
    private String stringAffiche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViewPagerAndTabs();

        TabLayout tabLayout = findViewById(R.id.tablayout);
        new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText("FRAGMENT " + (position + 1));
                    }
                }
        ).attach();


    }

    private void setupViewPagerAndTabs() {
        viewPager = findViewById(R.id.tab_viewpager);
        pagerAdapter = new FragmentStateAdapter(this) {
            @Override
            public int getItemCount() {
                return 2;
            }

            @NonNull
            @Override
            public Fragment createFragment(int position) {
                if(position == 0){
                    return new FragmentOne();
                }else{
                    return new FragmentTwo();
                }
            }
        };
        viewPager.setAdapter(pagerAdapter);

        stringAffiche = getString(R.string.counter_text);

        counterTextView = findViewById(R.id.counter_textview);

    }

    @Override
    public void OnButtonSelected(Button buttonIncrement, int idButton) {
        if(idButton == 1){
            currentCounter+=1;
        }else{
            currentCounter-=1;
        }

        counterTextView.setText(format(stringAffiche,currentCounter));
    }

}
