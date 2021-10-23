package com.heriec.easyblogmaster.pojo;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

public class Article {
    private Long id;
    private String title;
    private String mdContent;
    private String htmlContent;
    private String summary;
    private Long cid;
    private Long uid;
    private Timestamp publishDate;
    private Timestamp editTime;
    /**
     * 0表示草稿箱，1表示已发表，2表示已删
     */
    private Long state;
    private Long pageView;
    private List<Tags> tags;

    private String[] dynamicTags;
    private String nickname;
    private String cateName;
    private String stateStr;

    public Article() {
    }

    public Article(Long id, String title, String mdContent, String htmlContent, String summary, Long cid, Long uid, Timestamp publishDate, Timestamp editTime, Long state, Long pageView, List<Tags> tags, String[] dynamicTags, String nickname, String cateName, String stateStr) {
        this.id = id;
        this.title = title;
        this.mdContent = mdContent;
        this.htmlContent = htmlContent;
        this.summary = summary;
        this.cid = cid;
        this.uid = uid;
        this.publishDate = publishDate;
        this.editTime = editTime;
        this.state = state;
        this.pageView = pageView;
        this.tags = tags;
        this.dynamicTags = dynamicTags;
        this.nickname = nickname;
        this.cateName = cateName;
        this.stateStr = stateStr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMdContent() {
        return mdContent;
    }

    public void setMdContent(String mdContent) {
        this.mdContent = mdContent;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Timestamp getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Timestamp publishDate) {
        this.publishDate = publishDate;
    }

    public Timestamp getEditTime() {
        return editTime;
    }

    public void setEditTime(Timestamp editTime) {
        this.editTime = editTime;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public Long getPageView() {
        return pageView;
    }

    public void setPageView(Long pageView) {
        this.pageView = pageView;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public String[] getDynamicTags() {
        return dynamicTags;
    }

    public void setDynamicTags(String[] dynamicTags) {
        this.dynamicTags = dynamicTags;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getStateStr() {
        return stateStr;
    }

    public void setStateStr(String stateStr) {
        this.stateStr = stateStr;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", mdContent='" + mdContent + '\'' +
                ", htmlContent='" + htmlContent + '\'' +
                ", summary='" + summary + '\'' +
                ", cid=" + cid +
                ", uid=" + uid +
                ", publishDate=" + publishDate +
                ", editTime=" + editTime +
                ", state=" + state +
                ", pageView=" + pageView +
                ", tags=" + tags +
                ", dynamicTags=" + Arrays.toString(dynamicTags) +
                ", nickname='" + nickname + '\'' +
                ", cateName='" + cateName + '\'' +
                ", stateStr='" + stateStr + '\'' +
                '}';
    }
}
