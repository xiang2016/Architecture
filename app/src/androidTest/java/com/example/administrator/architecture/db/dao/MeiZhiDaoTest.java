package com.example.administrator.architecture.db.dao;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.support.test.InstrumentationRegistry;

import com.example.administrator.architecture.db.MeiZhiDatabase;
import com.example.administrator.architecture.db.entity.MeiZhi;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


/**
 * <pre>
 *     author : ZhaoMiXiang
 *     time   : 2017/12/04
 *     desc   : 描述
 *     version: 1.0
 * </pre>
 */
public class MeiZhiDaoTest {

    private MeiZhiDatabase database;
    private MeiZhiDao meiZhiDao;

    @Before
    public void setUp() throws Exception {
        RoomDatabase.Builder<MeiZhiDatabase> meiZhiDatabaseBuilder = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(), MeiZhiDatabase.class);
        database = meiZhiDatabaseBuilder.build();
        meiZhiDao = database.getMeiZhiDao();
    }

    @After
    public void tearDown() throws Exception {
        database.close();
    }

    @Test
    public void insertMeiZhi() throws Exception {
        MeiZhi meiZhi = new MeiZhi();
        meiZhi.setSaveLocal(false);
        meiZhi.setName("meizhi1");
        meiZhi.setRating(4);
        meiZhi.setUrl("url");
        meiZhiDao.insertMeiZhi(meiZhi);
        assertThat(meiZhiDao.queryAllMeiZhi().length,is(equalTo(1)));
        MeiZhi meiZhi1 = meiZhiDao.queryAllMeiZhi()[0];
        meiZhi1.setSaveLocal(true);
        meiZhiDao.upDateMeiZhi(meiZhi1);
        assertTrue(meiZhiDao.queryAllMeiZhi()[0].isSaveLocal());
        assertThat(meiZhiDao.queryMeiZhiByRating(4)[0].getName(),is(equalTo("meizhi1")));
        MeiZhi meiZhi2 = new MeiZhi();
        meiZhi2.setId(1);
        meiZhiDao.deleteMeiZhi(meiZhi2);
        assertThat(meiZhiDao.queryAllMeiZhi().length,is(equalTo(0)));
    }

    @Test
    public void queryAllMeiZhi() throws Exception {
    }

    @Test
    public void upDateMeiZhi() throws Exception {
    }

    @Test
    public void queryMeiZhiByRating() throws Exception {
    }

    @Test
    public void deleteMeiZhi() throws Exception {
    }

}