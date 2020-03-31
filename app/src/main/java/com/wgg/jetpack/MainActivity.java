package com.wgg.jetpack;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

import com.wgg.jetpack.databinding.ActivityMainBinding;
import com.wgg.jetpack.viewmodel.MainViewModel;

/**
 * @author Final_Statics
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    /**
     * DataBinding
     */
    private ActivityMainBinding binding;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainViewModel = new MainViewModel(this.getApplication());
        binding.setData(mainViewModel);
        binding.setLifecycleOwner(this);

    }
    public static final int[] COLORS = {Color.BLACK,Color.DKGRAY,Color.GRAY,Color.WHITE,Color.RED,
            Color.GREEN,Color.BLUE,Color.YELLOW,Color.CYAN,Color.MAGENTA,Color.TRANSPARENT};
    private int i = 0;
    public void onclick(@NonNull View view) {
        int length = COLORS.length;
        i = (++i == length) ? 0 : i;
        Log.i(TAG, "onclick: i = " + i);
        ImageButton imageButton = (ImageButton)view;
        VectorDrawableCompat vectorDrawableCompat = VectorDrawableCompat.create(getResources(),
                R.drawable.ic_shuaige, getTheme());
        vectorDrawableCompat.setTint(COLORS[i]);
        imageButton.setImageDrawable(vectorDrawableCompat);
    }
}
