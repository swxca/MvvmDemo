package zhangtao.com.MvvmDemo.entity;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.io.Serializable;
import java.util.List;

import zhangtao.com.MvvmDemo.BR;

/**
 * Created by zhangtao on 16/11/7.
 */

public class Status extends BaseObservable implements Serializable {
    private int id,userId,userCategory,feedType,commentCount,likeCount,opState,feedCategory
            ,likeState,privateType,followerCount,favoiteState;
    private String content,pubTimeNice,userLogo,userName,shareUrl;
    List<FeedResource> resList;
    Long createTime;
    public Status(int id){
        this.id=id;
    }

    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
        notifyPropertyChanged(BR.userId);
    }
    @Bindable
    public int getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(int userCategory) {
        this.userCategory = userCategory;
        notifyPropertyChanged(BR.userCategory);
    }
    @Bindable
    public int getFeedType() {
        return feedType;
    }

    public void setFeedType(int feedType) {
        this.feedType = feedType;
        notifyPropertyChanged(BR.feedType);
    }
    @Bindable
    public String getCommentCount() {
        return commentCount+"";
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }
    @Bindable
    public String getLikeCount() {
        return likeCount+"";
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
    @Bindable
    public int getOpState() {
        return opState;
    }

    public void setOpState(int opState) {
        this.opState = opState;
    }
    @Bindable
    public int getFeedCategory() {
        return feedCategory;
    }

    public void setFeedCategory(int feedCategory) {
        this.feedCategory = feedCategory;
    }
    @Bindable
    public int getLikeState() {
        return likeState;
    }

    public void setLikeState(int likeState) {
        this.likeState = likeState;
    }
    @Bindable
    public int getPrivateType() {
        return privateType;
    }

    public void setPrivateType(int privateType) {
        this.privateType = privateType;
    }
    @Bindable
    public int getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(int followerCount) {
        this.followerCount = followerCount;
    }
    @Bindable
    public int getFavoiteState() {
        return favoiteState;
    }

    public void setFavoiteState(int favoiteState) {
        this.favoiteState = favoiteState;
    }
    @Bindable
    public String getContent() {
        return "\u3000\u3000"+content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    @Bindable
    public String getPubTimeNice() {
        return pubTimeNice;
    }

    public void setPubTimeNice(String pubTimeNice) {
        this.pubTimeNice = pubTimeNice;
    }
    @Bindable
    public String getUserLogo() {
        return userLogo;
    }

    public void setUserLogo(String userLogo) {
        this.userLogo = userLogo;
    }
    @Bindable
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Bindable
    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }
    @Bindable
    public List<FeedResource> getResList() {
        return resList;
    }

    public void setResList(List<FeedResource> resList) {
        this.resList = resList;
    }
    @Bindable
    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
