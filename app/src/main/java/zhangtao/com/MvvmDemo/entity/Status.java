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
            ,likeState,privateType,followerCount,favoriteState;
    private String content,pubTimeNice,userLogo,userName,shareUrl,title,link,description,userTag,tag;
    List<FeedResource> resList;
    Long createTime;
    @Bindable
    public String getTag() {
        return tag;
    }


    public void setTag(String tag) {
        this.tag = tag;
        notifyPropertyChanged(BR.tag);
    }

    @Bindable
    public String getUserTag() {
        return userTag;
    }

    public void setUserTag(String userTag) {
        this.userTag = userTag;
        notifyPropertyChanged(BR.userTag);
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(BR.description);
    }

    @Bindable
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
        notifyPropertyChanged(BR.link);
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
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
        notifyPropertyChanged(BR.commentCount);
    }
    @Bindable
    public String getLikeCount() {
        return likeCount+"";
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
        notifyPropertyChanged(BR.likeCount);
    }
    @Bindable
    public int getOpState() {
        return opState;
    }

    public void setOpState(int opState) {
        this.opState = opState;
        notifyPropertyChanged(BR.opState);
    }
    @Bindable
    public int getFeedCategory() {
        return feedCategory;
    }

    public void setFeedCategory(int feedCategory) {
        this.feedCategory = feedCategory;
        notifyPropertyChanged(BR.feedCategory);
    }
    @Bindable
    public int getLikeState() {
        return likeState;
    }

    public void setLikeState(int likeState) {
        this.likeState = likeState;
        notifyPropertyChanged(BR.likeState);
    }
    @Bindable
    public int getPrivateType() {
        return privateType;
    }

    public void setPrivateType(int privateType) {
        this.privateType = privateType;
        notifyPropertyChanged(BR.privateType);
    }
    @Bindable
    public int getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(int followerCount) {
        this.followerCount = followerCount;
        notifyPropertyChanged(BR.followerCount);
    }
    @Bindable
    public int getFavoiteState() {
        return favoriteState;
    }

    public void setFavoiteState(int favoiteState) {
        this.favoriteState = favoiteState;
        notifyPropertyChanged(BR.favoiteState);
    }
    @Bindable
    public String getContent() {
        return "\u3000\u3000"+content;
    }

    public void setContent(String content) {
        this.content = content;
        notifyPropertyChanged(BR.content);
    }
    @Bindable
    public String getPubTimeNice() {
        return pubTimeNice;
    }

    public void setPubTimeNice(String pubTimeNice) {
        this.pubTimeNice = pubTimeNice;
        notifyPropertyChanged(BR.pubTimeNice);
    }
    @Bindable
    public String getUserLogo() {
        return userLogo;
    }

    public void setUserLogo(String userLogo) {
        this.userLogo = userLogo;
        notifyPropertyChanged(BR.userLogo);
    }
    @Bindable
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
    }
    @Bindable
    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
        notifyPropertyChanged(BR.shareUrl);
    }
    @Bindable
    public List<FeedResource> getResList() {
        return resList;
    }

    public void setResList(List<FeedResource> resList) {
        this.resList = resList;
        notifyPropertyChanged(BR.resList);
    }
    @Bindable
    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
        notifyPropertyChanged(BR.createTime);
    }
}
