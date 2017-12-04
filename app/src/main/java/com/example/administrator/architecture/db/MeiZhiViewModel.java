package com.example.administrator.architecture.db;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.administrator.architecture.db.entity.MeiZhi;

/**
 * <pre>
 *     author : ZhaoMiXiang
 *     time   : 2017/12/01
 *     desc   : 描述
 *     version: 1.0
 * </pre>
 */
public class MeiZhiViewModel extends AndroidViewModel {
    private MutableLiveData<MeiZhi> meiZhiLiveData;
    public MeiZhiViewModel(@NonNull Application application) {
        super(application);
        meiZhiLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<MeiZhi> getMeiZhiLiveData() {
        return meiZhiLiveData;
    }
}
