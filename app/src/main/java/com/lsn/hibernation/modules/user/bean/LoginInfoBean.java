package com.lsn.hibernation.modules.user.bean;

import java.util.List;

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/13 11:00
 * Description
 */
public class LoginInfoBean {


    /**
     * loginType : 1
     * code : 200
     * account : {"id":366231393,"userName":"1_13361634880","type":1,"status":0,"whitelistAuthority":0,"createTime":1484888693527,"salt":"[B@66c781c3","tokenVersion":1,"ban":0,"baoyueVersion":0,"donateVersion":0,"vipType":0,"viptypeVersion":0,"anonimousUser":false}
     * token : fe752537d6e1c3315ab7f29fecd2ef36cd81a71b72c63cd589fac216b4f82c85e97c93d78c825bb7cbbea0e4a77df43e63531a931aa80ad0
     * profile : {"avatarImgIdStr":"109951164759877274","backgroundImgIdStr":"109951164759857049","description":"","vipType":0,"gender":1,"accountStatus":0,"avatarImgId":109951164759877280,"birthday":801320309004,"nickname":"lsener","city":360100,"userType":0,"backgroundImgId":109951164759857060,"avatarUrl":"http://p4.music.126.net/4M1kGbSNaZgPMrqACv7VWQ==/109951164759877274.jpg","province":360000,"defaultAvatar":false,"djStatus":0,"experts":{},"mutual":false,"remarkName":null,"expertTags":null,"authStatus":0,"detailDescription":"","followed":false,"backgroundUrl":"http://p2.music.126.net/wch5hdxbl7hl9jhZbupQsg==/109951164759857049.jpg","signature":"听歌最怕旋律暗入人心的那一刻，那发自内心的刺痛，已然分不清是歌还是人。","authority":0,"userId":366231393,"avatarImgId_str":"109951164759877274","followeds":5,"follows":7,"eventCount":1,"playlistCount":10,"playlistBeSubscribedCount":1}
     * bindings : [{"url":"","expired":false,"refreshTime":1484888693,"tokenJsonStr":"{\"countrycode\":\"\",\"cellphone\":\"13361634880\",\"hasPassword\":true}","expiresIn":2147483647,"id":2965460729,"type":1,"userId":366231393,"bindingTime":1484888693529}]
     */

    private int loginType;
    private int code;
    private AccountBean account;
    private String token;
    private ProfileBean profile;
    private List<BindingsBean> bindings;

    public int getLoginType() {
        return loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public AccountBean getAccount() {
        return account;
    }

    public void setAccount(AccountBean account) {
        this.account = account;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ProfileBean getProfile() {
        return profile;
    }

    public void setProfile(ProfileBean profile) {
        this.profile = profile;
    }

    public List<BindingsBean> getBindings() {
        return bindings;
    }

    public void setBindings(List<BindingsBean> bindings) {
        this.bindings = bindings;
    }

    public static class AccountBean {
        /**
         * id : 366231393
         * userName : 1_13361634880
         * type : 1
         * status : 0
         * whitelistAuthority : 0
         * createTime : 1484888693527
         * salt : [B@66c781c3
         * tokenVersion : 1
         * ban : 0
         * baoyueVersion : 0
         * donateVersion : 0
         * vipType : 0
         * viptypeVersion : 0
         * anonimousUser : false
         */

        private int id;
        private String userName;
        private int type;
        private int status;
        private int whitelistAuthority;
        private long createTime;
        private String salt;
        private int tokenVersion;
        private int ban;
        private int baoyueVersion;
        private int donateVersion;
        private int vipType;
        private int viptypeVersion;
        private boolean anonimousUser;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getWhitelistAuthority() {
            return whitelistAuthority;
        }

        public void setWhitelistAuthority(int whitelistAuthority) {
            this.whitelistAuthority = whitelistAuthority;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getSalt() {
            return salt;
        }

        public void setSalt(String salt) {
            this.salt = salt;
        }

        public int getTokenVersion() {
            return tokenVersion;
        }

        public void setTokenVersion(int tokenVersion) {
            this.tokenVersion = tokenVersion;
        }

        public int getBan() {
            return ban;
        }

        public void setBan(int ban) {
            this.ban = ban;
        }

        public int getBaoyueVersion() {
            return baoyueVersion;
        }

        public void setBaoyueVersion(int baoyueVersion) {
            this.baoyueVersion = baoyueVersion;
        }

        public int getDonateVersion() {
            return donateVersion;
        }

        public void setDonateVersion(int donateVersion) {
            this.donateVersion = donateVersion;
        }

        public int getVipType() {
            return vipType;
        }

        public void setVipType(int vipType) {
            this.vipType = vipType;
        }

        public int getViptypeVersion() {
            return viptypeVersion;
        }

        public void setViptypeVersion(int viptypeVersion) {
            this.viptypeVersion = viptypeVersion;
        }

        public boolean isAnonimousUser() {
            return anonimousUser;
        }

        public void setAnonimousUser(boolean anonimousUser) {
            this.anonimousUser = anonimousUser;
        }
    }

    public static class ProfileBean {
        /**
         * avatarImgIdStr : 109951164759877274
         * backgroundImgIdStr : 109951164759857049
         * description :
         * vipType : 0
         * gender : 1
         * accountStatus : 0
         * avatarImgId : 109951164759877280
         * birthday : 801320309004
         * nickname : lsener
         * city : 360100
         * userType : 0
         * backgroundImgId : 109951164759857060
         * avatarUrl : http://p4.music.126.net/4M1kGbSNaZgPMrqACv7VWQ==/109951164759877274.jpg
         * province : 360000
         * defaultAvatar : false
         * djStatus : 0
         * experts : {}
         * mutual : false
         * remarkName : null
         * expertTags : null
         * authStatus : 0
         * detailDescription :
         * followed : false
         * backgroundUrl : http://p2.music.126.net/wch5hdxbl7hl9jhZbupQsg==/109951164759857049.jpg
         * signature : 听歌最怕旋律暗入人心的那一刻，那发自内心的刺痛，已然分不清是歌还是人。
         * authority : 0
         * userId : 366231393
         * avatarImgId_str : 109951164759877274
         * followeds : 5
         * follows : 7
         * eventCount : 1
         * playlistCount : 10
         * playlistBeSubscribedCount : 1
         */

        private String avatarImgIdStr;
        private String backgroundImgIdStr;
        private String description;
        private int vipType;
        private int gender;
        private int accountStatus;
        private long avatarImgId;
        private long birthday;
        private String nickname;
        private int city;
        private int userType;
        private long backgroundImgId;
        private String avatarUrl;
        private int province;
        private boolean defaultAvatar;
        private int djStatus;
        private ExpertsBean experts;
        private boolean mutual;
        private Object remarkName;
        private Object expertTags;
        private int authStatus;
        private String detailDescription;
        private boolean followed;
        private String backgroundUrl;
        private String signature;
        private int authority;
        private int userId;
        private String avatarImgId_str;
        private int followeds;
        private int follows;
        private int eventCount;
        private int playlistCount;
        private int playlistBeSubscribedCount;

        public String getAvatarImgIdStr() {
            return avatarImgIdStr;
        }

        public void setAvatarImgIdStr(String avatarImgIdStr) {
            this.avatarImgIdStr = avatarImgIdStr;
        }

        public String getBackgroundImgIdStr() {
            return backgroundImgIdStr;
        }

        public void setBackgroundImgIdStr(String backgroundImgIdStr) {
            this.backgroundImgIdStr = backgroundImgIdStr;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getVipType() {
            return vipType;
        }

        public void setVipType(int vipType) {
            this.vipType = vipType;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getAccountStatus() {
            return accountStatus;
        }

        public void setAccountStatus(int accountStatus) {
            this.accountStatus = accountStatus;
        }

        public long getAvatarImgId() {
            return avatarImgId;
        }

        public void setAvatarImgId(long avatarImgId) {
            this.avatarImgId = avatarImgId;
        }

        public long getBirthday() {
            return birthday;
        }

        public void setBirthday(long birthday) {
            this.birthday = birthday;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getCity() {
            return city;
        }

        public void setCity(int city) {
            this.city = city;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public long getBackgroundImgId() {
            return backgroundImgId;
        }

        public void setBackgroundImgId(long backgroundImgId) {
            this.backgroundImgId = backgroundImgId;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public int getProvince() {
            return province;
        }

        public void setProvince(int province) {
            this.province = province;
        }

        public boolean isDefaultAvatar() {
            return defaultAvatar;
        }

        public void setDefaultAvatar(boolean defaultAvatar) {
            this.defaultAvatar = defaultAvatar;
        }

        public int getDjStatus() {
            return djStatus;
        }

        public void setDjStatus(int djStatus) {
            this.djStatus = djStatus;
        }

        public ExpertsBean getExperts() {
            return experts;
        }

        public void setExperts(ExpertsBean experts) {
            this.experts = experts;
        }

        public boolean isMutual() {
            return mutual;
        }

        public void setMutual(boolean mutual) {
            this.mutual = mutual;
        }

        public Object getRemarkName() {
            return remarkName;
        }

        public void setRemarkName(Object remarkName) {
            this.remarkName = remarkName;
        }

        public Object getExpertTags() {
            return expertTags;
        }

        public void setExpertTags(Object expertTags) {
            this.expertTags = expertTags;
        }

        public int getAuthStatus() {
            return authStatus;
        }

        public void setAuthStatus(int authStatus) {
            this.authStatus = authStatus;
        }

        public String getDetailDescription() {
            return detailDescription;
        }

        public void setDetailDescription(String detailDescription) {
            this.detailDescription = detailDescription;
        }

        public boolean isFollowed() {
            return followed;
        }

        public void setFollowed(boolean followed) {
            this.followed = followed;
        }

        public String getBackgroundUrl() {
            return backgroundUrl;
        }

        public void setBackgroundUrl(String backgroundUrl) {
            this.backgroundUrl = backgroundUrl;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public int getAuthority() {
            return authority;
        }

        public void setAuthority(int authority) {
            this.authority = authority;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getAvatarImgId_str() {
            return avatarImgId_str;
        }

        public void setAvatarImgId_str(String avatarImgId_str) {
            this.avatarImgId_str = avatarImgId_str;
        }

        public int getFolloweds() {
            return followeds;
        }

        public void setFolloweds(int followeds) {
            this.followeds = followeds;
        }

        public int getFollows() {
            return follows;
        }

        public void setFollows(int follows) {
            this.follows = follows;
        }

        public int getEventCount() {
            return eventCount;
        }

        public void setEventCount(int eventCount) {
            this.eventCount = eventCount;
        }

        public int getPlaylistCount() {
            return playlistCount;
        }

        public void setPlaylistCount(int playlistCount) {
            this.playlistCount = playlistCount;
        }

        public int getPlaylistBeSubscribedCount() {
            return playlistBeSubscribedCount;
        }

        public void setPlaylistBeSubscribedCount(int playlistBeSubscribedCount) {
            this.playlistBeSubscribedCount = playlistBeSubscribedCount;
        }

        public static class ExpertsBean {
        }
    }

    public static class BindingsBean {
        /**
         * url :
         * expired : false
         * refreshTime : 1484888693
         * tokenJsonStr : {"countrycode":"","cellphone":"13361634880","hasPassword":true}
         * expiresIn : 2147483647
         * id : 2965460729
         * type : 1
         * userId : 366231393
         * bindingTime : 1484888693529
         */

        private String url;
        private boolean expired;
        private int refreshTime;
        private String tokenJsonStr;
        private int expiresIn;
        private long id;
        private int type;
        private int userId;
        private long bindingTime;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isExpired() {
            return expired;
        }

        public void setExpired(boolean expired) {
            this.expired = expired;
        }

        public int getRefreshTime() {
            return refreshTime;
        }

        public void setRefreshTime(int refreshTime) {
            this.refreshTime = refreshTime;
        }

        public String getTokenJsonStr() {
            return tokenJsonStr;
        }

        public void setTokenJsonStr(String tokenJsonStr) {
            this.tokenJsonStr = tokenJsonStr;
        }

        public int getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(int expiresIn) {
            this.expiresIn = expiresIn;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public long getBindingTime() {
            return bindingTime;
        }

        public void setBindingTime(long bindingTime) {
            this.bindingTime = bindingTime;
        }
    }
}
