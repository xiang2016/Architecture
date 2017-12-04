package com.example.administrator.architecture.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.administrator.architecture.db.entity.MeiZhi;

/**
 * <pre>
 *     author : ZhaoMiXiang
 *     time   : 2017/12/01
 *     desc   : 描述
 *     version: 1.0
 * </pre>
 */
@Dao
public interface MeiZhiDao {
    @Insert
    void insertMeiZhi(MeiZhi meiZhi);

    @Delete
    void deleteMeiZhi(MeiZhi meiZhi);

    @Update
    void upDateMeiZhi(MeiZhi meiZhi);

    @Query("select * from meizhi")
    MeiZhi[] queryAllMeiZhi();

    @Query("select * from   meizhi where :rating")
    MeiZhi[] queryMeiZhiByRating(int rating);
}
