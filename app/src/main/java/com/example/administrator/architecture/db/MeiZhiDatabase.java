package com.example.administrator.architecture.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.administrator.architecture.db.dao.MeiZhiDao;
import com.example.administrator.architecture.db.entity.MeiZhi;

/**
 * <pre>
 *     author : ZhaoMiXiang
 *     time   : 2017/12/01
 *     desc   : 描述
 *     version: 1.0
 * </pre>
 */
@Database(version = 1,entities = {MeiZhi.class},exportSchema = false)
public abstract class MeiZhiDatabase extends RoomDatabase {
    public abstract MeiZhiDao getMeiZhiDao();
}
