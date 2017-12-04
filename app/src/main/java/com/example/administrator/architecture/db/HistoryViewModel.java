package com.example.administrator.architecture.db;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.administrator.architecture.db.entity.MeiZhi;

import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 *     author : ZhaoMiXiang
 *     time   : 2017/12/04
 *     desc   : 描述
 *     version: 1.0
 * </pre>
 */
public class HistoryViewModel extends AndroidViewModel {
    private final MeiZhiDatabase meiZhiDatabase;
    private MediatorLiveData<List<MeiZhi>> liveData;

    public HistoryViewModel(@NonNull Application application, MeiZhiDatabase meiZhiDatabase) {
        super(application);
        this.meiZhiDatabase = meiZhiDatabase;
        liveData = new MediatorLiveData<>();
        liveData.setValue(null);
        MutableLiveData<MeiZhi> meiZhiLiveData = new MutableLiveData<>();
        List<MeiZhi> meiZhiList = Arrays.asList(meiZhiDatabase.getMeiZhiDao().queryAllMeiZhi());
        liveData.addSource(meiZhiLiveData,meiZhiLiveData::setValue);
    }

    public MediatorLiveData<List<MeiZhi>> getLiveData() {
        return liveData;
    }
}
