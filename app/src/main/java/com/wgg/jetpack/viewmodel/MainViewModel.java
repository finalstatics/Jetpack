package com.wgg.jetpack.viewmodel;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

import com.wgg.jetpack.MainActivity;
import com.wgg.jetpack.R;

/**
 * @author Final_Statics
 */
public class MainViewModel extends AndroidViewModel {

    private static final String TAG = "MainViewModel";

    /**
     * 文字
     */
    public MutableLiveData<String> textInfo;
    /**
     * 上下文
     */
    private Context context;
    /**
     * 图片按钮资源
     */
    public MutableLiveData<Integer> imageBottonSrc;

    /**
     * AndroidViewModel和ViewModel区别在于：
     * 前者需要Context环境参数，后者不需要Context环境参数
     * @param application
     */
    public MainViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();
        Drawable drawable = context.getResources().getDrawable(R.drawable.ic_shuaige);
        imageBottonSrc = new MutableLiveData<>();
        imageBottonSrc.setValue(R.drawable.ic_shuaige);
    }

    public MutableLiveData<String> getTextInfo() {
        if (textInfo == null){
            textInfo = new MutableLiveData<>();
            textInfo.setValue("");
        }
        return textInfo;
    }

    public void appendStr(String textStr) {
        textInfo.setValue(textInfo.getValue() + textStr);
    }
    public void backpaceStr() {
        int length = textInfo.getValue().length();
        if (length > 0){
            textInfo.setValue(textInfo.getValue().substring(0,length-1));
        }
    }
    public void clear() {
        textInfo.setValue("");
    }

    public static final int[] COLORS = {Color.BLACK,Color.DKGRAY,Color.GRAY,Color.WHITE,Color.RED,
            Color.GREEN,Color.BLUE,Color.YELLOW,Color.CYAN,Color.MAGENTA,Color.TRANSPARENT};
    private int i = 0;
    public void changeImageBottonSrc() {
        i = (++i == COLORS.length) ? 0 : i;
        Log.i(TAG, "onclick: i = " + i);
        VectorDrawableCompat vectorDrawableCompat = VectorDrawableCompat.create(context.getResources(),
                R.drawable.ic_shuaige, context.getTheme());
        vectorDrawableCompat.setTint(COLORS[i]);
//        imageButton.setImageDrawable(vectorDrawableCompat);
    }
}
