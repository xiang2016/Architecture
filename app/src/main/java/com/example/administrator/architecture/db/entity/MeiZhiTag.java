package com.example.administrator.architecture.db.entity;

/**
 * <pre>
 *     author : ZhaoMiXiang
 *     time   : 2017/11/29
 *     desc   : 描述
 *     version: 1.0
 * </pre>
 */
public class MeiZhiTag {
    private String title;
    private String content;
    private String tagId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }
}
