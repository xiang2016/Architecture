package com.example.administrator.architecture.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * <pre>
 *     author : ZhaoMiXiang
 *     time   : 2017/11/29
 *     desc   : 描述
 *     version: 1.0
 * </pre>
 */
@Entity
public class MeiZhi {
    private String name;
    private boolean saveLocal;
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String url;
    private int rating;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSaveLocal() {
        return saveLocal;
    }

    public void setSaveLocal(boolean saveLocal) {
        this.saveLocal = saveLocal;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "MeiZhi{" +
                "name='" + name + '\'' +
                ", saveLocal=" + saveLocal +
                ", id=" + id +
                ", url='" + url + '\'' +
                ", rating=" + rating +
                '}';
    }
}
