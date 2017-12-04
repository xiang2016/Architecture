package com.example.administrator.architecture.adapter;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.example.administrator.architecture.R;

/**
 * <pre>
 *     author : ZhaoMiXiang
 *     time   : 2017/12/04
 *     desc   : 描述
 *     version: 1.0
 * </pre>
 */
public class ImageViewBindingAdapter {
    @BindingAdapter("netSrc")
    public static void setImageUri(ImageView view, String imageUri) {
        if (imageUri.equals("url")) {
            view.setImageResource(R.drawable.hl);
        } else {
            view.setImageResource(R.mipmap.ic_launcher);
        }
    }
}
