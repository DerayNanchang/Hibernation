package com.lsn.hibernation.modules.music.bean.easy;

import java.util.List;

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/21 15:59
 * Description
 */
public class EasePlaylist {

    /**
     * subscribers : []
     * subscribed : false
     * creator : {"defaultAvatar":false,"province":360000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/bmJqOw7m92ZINsQlGCPrAg==/109951164919639189.jpg","accountStatus":0,"gender":1,"city":360100,"birthday":801320309004,"userId":366231393,"userType":0,"nickname":"lsener","signature":"听歌最怕旋律暗入人心的那一刻，那发自内心的刺痛，已然分不清是歌还是人。","description":"","detailDescription":"","avatarImgId":109951164919639180,"backgroundImgId":109951164919636210,"backgroundUrl":"http://p1.music.126.net/OxqM54MCZ7PfDYGlBfoSrA==/109951164919636203.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"backgroundImgIdStr":"109951164919636203","avatarImgIdStr":"109951164919639189","avatarImgId_str":"109951164919639189"}
     * artists : null
     * tracks : null
     * updateFrequency : null
     * backgroundCoverId : 0
     * backgroundCoverUrl : null
     * titleImage : 0
     * titleImageUrl : null
     * englishTitle : null
     * opRecommend : false
     * recommendInfo : null
     * adType : 0
     * trackNumberUpdateTime : 1582880462357
     * subscribedCount : 0
     * cloudTrackCount : 0
     * userId : 366231393
     * updateTime : 1582880462357
     * coverImgId : 109951164232791600
     * createTime : 1479800726584
     * highQuality : false
     * newImported : false
     * anonimous : false
     * totalDuration : 0
     * specialType : 5
     * coverImgUrl : http://p1.music.126.net/DY63DJtbtRQZLmtoucmLig==/109951164232791600.jpg
     * trackCount : 30
     * commentThreadId : A_PL_0_516736946
     * privacy : 0
     * trackUpdateTime : 1587451818783
     * playCount : 159
     * ordered : true
     * tags : []
     * description : null
     * status : 0
     * name : lsener喜欢的音乐
     * id : 516736946
     * coverImgId_str : 109951164232791600
     */

    private boolean subscribed;
    private CreatorBean creator;
    private Object artists;
    private Object tracks;
    private Object updateFrequency;
    private int backgroundCoverId;
    private Object backgroundCoverUrl;
    private int titleImage;
    private Object titleImageUrl;
    private Object englishTitle;
    private boolean opRecommend;
    private Object recommendInfo;
    private int adType;
    private long trackNumberUpdateTime;
    private int subscribedCount;
    private int cloudTrackCount;
    private int userId;
    private long updateTime;
    private long coverImgId;
    private long createTime;
    private boolean highQuality;
    private boolean newImported;
    private boolean anonimous;
    private int totalDuration;
    private int specialType;
    private String coverImgUrl;
    private int trackCount;
    private String commentThreadId;
    private int privacy;
    private long trackUpdateTime;
    private int playCount;
    private boolean ordered;
    private Object description;
    private int status;
    private String name;
    private int id;
    private String coverImgId_str;
    private List<?> subscribers;
    private List<?> tags;

    public boolean isSubscribed() {
        return subscribed;
    }

    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }

    public CreatorBean getCreator() {
        return creator;
    }

    public void setCreator(CreatorBean creator) {
        this.creator = creator;
    }

    public Object getArtists() {
        return artists;
    }

    public void setArtists(Object artists) {
        this.artists = artists;
    }

    public Object getTracks() {
        return tracks;
    }

    public void setTracks(Object tracks) {
        this.tracks = tracks;
    }

    public Object getUpdateFrequency() {
        return updateFrequency;
    }

    public void setUpdateFrequency(Object updateFrequency) {
        this.updateFrequency = updateFrequency;
    }

    public int getBackgroundCoverId() {
        return backgroundCoverId;
    }

    public void setBackgroundCoverId(int backgroundCoverId) {
        this.backgroundCoverId = backgroundCoverId;
    }

    public Object getBackgroundCoverUrl() {
        return backgroundCoverUrl;
    }

    public void setBackgroundCoverUrl(Object backgroundCoverUrl) {
        this.backgroundCoverUrl = backgroundCoverUrl;
    }

    public int getTitleImage() {
        return titleImage;
    }

    public void setTitleImage(int titleImage) {
        this.titleImage = titleImage;
    }

    public Object getTitleImageUrl() {
        return titleImageUrl;
    }

    public void setTitleImageUrl(Object titleImageUrl) {
        this.titleImageUrl = titleImageUrl;
    }

    public Object getEnglishTitle() {
        return englishTitle;
    }

    public void setEnglishTitle(Object englishTitle) {
        this.englishTitle = englishTitle;
    }

    public boolean isOpRecommend() {
        return opRecommend;
    }

    public void setOpRecommend(boolean opRecommend) {
        this.opRecommend = opRecommend;
    }

    public Object getRecommendInfo() {
        return recommendInfo;
    }

    public void setRecommendInfo(Object recommendInfo) {
        this.recommendInfo = recommendInfo;
    }

    public int getAdType() {
        return adType;
    }

    public void setAdType(int adType) {
        this.adType = adType;
    }

    public long getTrackNumberUpdateTime() {
        return trackNumberUpdateTime;
    }

    public void setTrackNumberUpdateTime(long trackNumberUpdateTime) {
        this.trackNumberUpdateTime = trackNumberUpdateTime;
    }

    public int getSubscribedCount() {
        return subscribedCount;
    }

    public void setSubscribedCount(int subscribedCount) {
        this.subscribedCount = subscribedCount;
    }

    public int getCloudTrackCount() {
        return cloudTrackCount;
    }

    public void setCloudTrackCount(int cloudTrackCount) {
        this.cloudTrackCount = cloudTrackCount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public long getCoverImgId() {
        return coverImgId;
    }

    public void setCoverImgId(long coverImgId) {
        this.coverImgId = coverImgId;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public boolean isHighQuality() {
        return highQuality;
    }

    public void setHighQuality(boolean highQuality) {
        this.highQuality = highQuality;
    }

    public boolean isNewImported() {
        return newImported;
    }

    public void setNewImported(boolean newImported) {
        this.newImported = newImported;
    }

    public boolean isAnonimous() {
        return anonimous;
    }

    public void setAnonimous(boolean anonimous) {
        this.anonimous = anonimous;
    }

    public int getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(int totalDuration) {
        this.totalDuration = totalDuration;
    }

    public int getSpecialType() {
        return specialType;
    }

    public void setSpecialType(int specialType) {
        this.specialType = specialType;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }

    public int getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(int trackCount) {
        this.trackCount = trackCount;
    }

    public String getCommentThreadId() {
        return commentThreadId;
    }

    public void setCommentThreadId(String commentThreadId) {
        this.commentThreadId = commentThreadId;
    }

    public int getPrivacy() {
        return privacy;
    }

    public void setPrivacy(int privacy) {
        this.privacy = privacy;
    }

    public long getTrackUpdateTime() {
        return trackUpdateTime;
    }

    public void setTrackUpdateTime(long trackUpdateTime) {
        this.trackUpdateTime = trackUpdateTime;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public boolean isOrdered() {
        return ordered;
    }

    public void setOrdered(boolean ordered) {
        this.ordered = ordered;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCoverImgId_str() {
        return coverImgId_str;
    }

    public void setCoverImgId_str(String coverImgId_str) {
        this.coverImgId_str = coverImgId_str;
    }

    public List<?> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<?> subscribers) {
        this.subscribers = subscribers;
    }

    public List<?> getTags() {
        return tags;
    }

    public void setTags(List<?> tags) {
        this.tags = tags;
    }

    public static class CreatorBean {
        /**
         * defaultAvatar : false
         * province : 360000
         * authStatus : 0
         * followed : false
         * avatarUrl : http://p1.music.126.net/bmJqOw7m92ZINsQlGCPrAg==/109951164919639189.jpg
         * accountStatus : 0
         * gender : 1
         * city : 360100
         * birthday : 801320309004
         * userId : 366231393
         * userType : 0
         * nickname : lsener
         * signature : 听歌最怕旋律暗入人心的那一刻，那发自内心的刺痛，已然分不清是歌还是人。
         * description :
         * detailDescription :
         * avatarImgId : 109951164919639180
         * backgroundImgId : 109951164919636210
         * backgroundUrl : http://p1.music.126.net/OxqM54MCZ7PfDYGlBfoSrA==/109951164919636203.jpg
         * authority : 0
         * mutual : false
         * expertTags : null
         * experts : null
         * djStatus : 0
         * vipType : 0
         * remarkName : null
         * backgroundImgIdStr : 109951164919636203
         * avatarImgIdStr : 109951164919639189
         * avatarImgId_str : 109951164919639189
         */

        private boolean defaultAvatar;
        private int province;
        private int authStatus;
        private boolean followed;
        private String avatarUrl;
        private int accountStatus;
        private int gender;
        private int city;
        private long birthday;
        private int userId;
        private int userType;
        private String nickname;
        private String signature;
        private String description;
        private String detailDescription;
        private long avatarImgId;
        private long backgroundImgId;
        private String backgroundUrl;
        private int authority;
        private boolean mutual;
        private Object expertTags;
        private Object experts;
        private int djStatus;
        private int vipType;
        private Object remarkName;
        private String backgroundImgIdStr;
        private String avatarImgIdStr;
        private String avatarImgId_str;

        public boolean isDefaultAvatar() {
            return defaultAvatar;
        }

        public void setDefaultAvatar(boolean defaultAvatar) {
            this.defaultAvatar = defaultAvatar;
        }

        public int getProvince() {
            return province;
        }

        public void setProvince(int province) {
            this.province = province;
        }

        public int getAuthStatus() {
            return authStatus;
        }

        public void setAuthStatus(int authStatus) {
            this.authStatus = authStatus;
        }

        public boolean isFollowed() {
            return followed;
        }

        public void setFollowed(boolean followed) {
            this.followed = followed;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public int getAccountStatus() {
            return accountStatus;
        }

        public void setAccountStatus(int accountStatus) {
            this.accountStatus = accountStatus;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getCity() {
            return city;
        }

        public void setCity(int city) {
            this.city = city;
        }

        public long getBirthday() {
            return birthday;
        }

        public void setBirthday(long birthday) {
            this.birthday = birthday;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDetailDescription() {
            return detailDescription;
        }

        public void setDetailDescription(String detailDescription) {
            this.detailDescription = detailDescription;
        }

        public long getAvatarImgId() {
            return avatarImgId;
        }

        public void setAvatarImgId(long avatarImgId) {
            this.avatarImgId = avatarImgId;
        }

        public long getBackgroundImgId() {
            return backgroundImgId;
        }

        public void setBackgroundImgId(long backgroundImgId) {
            this.backgroundImgId = backgroundImgId;
        }

        public String getBackgroundUrl() {
            return backgroundUrl;
        }

        public void setBackgroundUrl(String backgroundUrl) {
            this.backgroundUrl = backgroundUrl;
        }

        public int getAuthority() {
            return authority;
        }

        public void setAuthority(int authority) {
            this.authority = authority;
        }

        public boolean isMutual() {
            return mutual;
        }

        public void setMutual(boolean mutual) {
            this.mutual = mutual;
        }

        public Object getExpertTags() {
            return expertTags;
        }

        public void setExpertTags(Object expertTags) {
            this.expertTags = expertTags;
        }

        public Object getExperts() {
            return experts;
        }

        public void setExperts(Object experts) {
            this.experts = experts;
        }

        public int getDjStatus() {
            return djStatus;
        }

        public void setDjStatus(int djStatus) {
            this.djStatus = djStatus;
        }

        public int getVipType() {
            return vipType;
        }

        public void setVipType(int vipType) {
            this.vipType = vipType;
        }

        public Object getRemarkName() {
            return remarkName;
        }

        public void setRemarkName(Object remarkName) {
            this.remarkName = remarkName;
        }

        public String getBackgroundImgIdStr() {
            return backgroundImgIdStr;
        }

        public void setBackgroundImgIdStr(String backgroundImgIdStr) {
            this.backgroundImgIdStr = backgroundImgIdStr;
        }

        public String getAvatarImgIdStr() {
            return avatarImgIdStr;
        }

        public void setAvatarImgIdStr(String avatarImgIdStr) {
            this.avatarImgIdStr = avatarImgIdStr;
        }

        public String getAvatarImgId_str() {
            return avatarImgId_str;
        }

        public void setAvatarImgId_str(String avatarImgId_str) {
            this.avatarImgId_str = avatarImgId_str;
        }
    }
}
