package com.example.administrator.architecture.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.architecture.R;
import com.example.administrator.architecture.databinding.ActivityHistoryBinding;

/**
 * <pre>
 *     author : ZhaoMiXiang
 *     time   : 2017/12/04
 *     desc   : 描述
 *     version: 1.0
 * </pre>
 */
public class HistoryActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        ActivityHistoryBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_history);

    }
}
