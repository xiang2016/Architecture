package com.example.administrator.architecture;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.architecture.databinding.ActivityMainBinding;
import com.example.administrator.architecture.db.MeiZhiDatabase;
import com.example.administrator.architecture.db.MeiZhiGenerator;
import com.example.administrator.architecture.db.MeiZhiViewModel;
import com.example.administrator.architecture.db.entity.MeiZhi;

import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private MeiZhiDatabase meiZhiDatabase;
    private MeiZhiViewModel meiZhiViewModel;
    private ExecutorService executor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        executor = Executors.newSingleThreadExecutor();
        MyHandler myHandler = new MyHandler(this);
        binding.setHandler(myHandler);
        getLifecycle().addObserver(new LifecycleObserver() {
            @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
            public void connectListener() {
                RoomDatabase.Builder<MeiZhiDatabase> mMeiZhiDatabase = Room.databaseBuilder(MainActivity.this, MeiZhiDatabase.class, "meizhi");
                meiZhiDatabase = mMeiZhiDatabase.build();
                getMeiZhi();
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public void disconnectListener() {
                meiZhiDatabase.close();
            }
        });
        meiZhiViewModel = ViewModelProviders.of(this).get(MeiZhiViewModel.class);
        meiZhiViewModel.getMeiZhiLiveData().observe(this, meiZhi -> {
            binding.setMeizhi(meiZhi);
            binding.executePendingBindings();
        });
    }

    private void getMeiZhi() {
        MeiZhi meiZhi = MeiZhiGenerator.generateMeiZhi();
        executor.execute(() -> {
            meiZhiDatabase.getMeiZhiDao().insertMeiZhi(meiZhi);
        });
        meiZhiViewModel.getMeiZhiLiveData().setValue(meiZhi);
    }

    public static class MyHandler extends Handler {
        private WeakReference<MainActivity> mainActivityWeakReference;

        public MyHandler(MainActivity mainActivity) {
            mainActivityWeakReference = new WeakReference<>(mainActivity);
        }

        @Override
        public void handleMessage(Message msg) {
            MainActivity mainActivity = mainActivityWeakReference.get();
            switch (msg.what) {
                case 1:
                    break;
                case 2:
                    MeiZhi value = mainActivity.meiZhiViewModel.getMeiZhiLiveData().getValue();
                    value.setRating(1);
                    mainActivity.meiZhiViewModel.getMeiZhiLiveData().setValue(value);
                    break;
                default:

                    break;
            }
        }

        public void nextMeiZhi() {
            MainActivity mainActivity = mainActivityWeakReference.get();
            mainActivity.getMeiZhi();
        }

        public void onCheckedChange(boolean isChecked, MeiZhi meizhi) {
            meizhi.setSaveLocal(isChecked);
            MainActivity mainActivity = mainActivityWeakReference.get();
            mainActivity.executor.execute(() -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mainActivity.meiZhiDatabase.getMeiZhiDao().upDateMeiZhi(meizhi);
            });
            MyHandler.this.sendEmptyMessage(1);
            MutableLiveData<MeiZhi> meiZhiLiveData = mainActivity.meiZhiViewModel.getMeiZhiLiveData();
            meiZhiLiveData.setValue(meizhi);
        }
    }

}

