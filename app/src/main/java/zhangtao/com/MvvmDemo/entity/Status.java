package zhangtao.com.MvvmDemo.entity;

import java.util.List;

/**
 * Created by zhangtao on 16/11/7.
 */

public class Status {
    int id,userId,userCategory,feedType,commentCount,likeCount,opState,feedCategory
            ,likeState,privateType,followerCount,favoiteState;
    String content,pubTimeNice,userLogo,userName,shareUrl;
    List<FeedResource> resList;
    Long createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(int userCategory) {
        this.userCategory = userCategory;
    }

    public int getFeedType() {
        return feedType;
    }

    public void setFeedType(int feedType) {
        this.feedType = feedType;
    }

    public String getCommentCount() {
        return commentCount+"";
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getLikeCount() {
        return likeCount+"";
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getOpState() {
        return opState;
    }

    public void setOpState(int opState) {
        this.opState = opState;
    }

    public int getFeedCategory() {
        return feedCategory;
    }

    public void setFeedCategory(int feedCategory) {
        this.feedCategory = feedCategory;
    }

    public int getLikeState() {
        return likeState;
    }

    public void setLikeState(int likeState) {
        this.likeState = likeState;
    }

    public int getPrivateType() {
        return privateType;
    }

    public void setPrivateType(int privateType) {
        this.privateType = privateType;
    }

    public int getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(int followerCount) {
        this.followerCount = followerCount;
    }

    public int getFavoiteState() {
        return favoiteState;
    }

    public void setFavoiteState(int favoiteState) {
        this.favoiteState = favoiteState;
    }

    public String getContent() {
        return "\u3000\u3000"+content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPubTimeNice() {
        return pubTimeNice;
    }

    public void setPubTimeNice(String pubTimeNice) {
        this.pubTimeNice = pubTimeNice;
    }

    public String getUserLogo() {
        return userLogo;
    }

    public void setUserLogo(String userLogo) {
        this.userLogo = userLogo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public List<FeedResource> getResList() {
        return resList;
    }

    public void setResList(List<FeedResource> resList) {
        this.resList = resList;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
