package com.mtelnet.baselibrary.net;

/**
 * Created by hongzhenyue on 16/8/25.
 */
public class ApiManager {
    public final static String WEB_SERVICE_URL_HTTPS = "http://devsvr6.mtel.ws/hkco/api/";

    public final static String url_getBanner = WEB_SERVICE_URL_HTTPS + "getBanner/";

    public final static String url_getGuest = WEB_SERVICE_URL_HTTPS + "user/getGuest";
    public final static String url_login = WEB_SERVICE_URL_HTTPS + "user/login";
    public final static String url_register = WEB_SERVICE_URL_HTTPS + "user/register";
    public final static String url_userinfo = WEB_SERVICE_URL_HTTPS + "user/detail";
    public final static String url_forgetPassword = WEB_SERVICE_URL_HTTPS + "user/forgetPassword";
    public final static String url_checkPasswordCode = WEB_SERVICE_URL_HTTPS + "user/checkPasswordCode";
    public final static String url_resetPassword = WEB_SERVICE_URL_HTTPS + "user/resetPassword";
    public final static String url_updateProfile = WEB_SERVICE_URL_HTTPS + "user/updateProfile";
    public final static String url_changePassword = WEB_SERVICE_URL_HTTPS + "user/changePassword";
    public final static String url_getBannerList = WEB_SERVICE_URL_HTTPS + "app/getBannerList";
    public final static String url_getEventList = WEB_SERVICE_URL_HTTPS + "event/list";
    public final static String url_getEventDetail = WEB_SERVICE_URL_HTTPS + "event/detail";
    public final static String url_getEventRemoveOrAddWish = WEB_SERVICE_URL_HTTPS + "/event/wish";//1”= add.    “0” = remove
    public final static String url_getVideoList = WEB_SERVICE_URL_HTTPS + "video/list";
    public final static String url_getVideoVote = WEB_SERVICE_URL_HTTPS + "video/vote";
    public final static String url_getVideoDetail = WEB_SERVICE_URL_HTTPS + "video/detail";
    public final static String url_videoUpload = WEB_SERVICE_URL_HTTPS + "video/upload";
    public final static String url_getVideoRemoveOrAddWish = WEB_SERVICE_URL_HTTPS + "video/wish";
    public final static String url_getMusicList = WEB_SERVICE_URL_HTTPS + "music/list";
    public final static String url_getMusicCategoryList = WEB_SERVICE_URL_HTTPS + "music/getCategoryList";
    public final static String url_getMusicDetail = WEB_SERVICE_URL_HTTPS + "music/detail";
    public final static String url_getMusicWishScores = WEB_SERVICE_URL_HTTPS + "music/getWishScores";
    public final static String url_getMusicRemoveOrAddWish = WEB_SERVICE_URL_HTTPS + "music/updateWishScore";
    public final static String url_getContent = WEB_SERVICE_URL_HTTPS + "app/getContent";
    public final static String url_getScoreList = WEB_SERVICE_URL_HTTPS + "music/getScoreList";
}
