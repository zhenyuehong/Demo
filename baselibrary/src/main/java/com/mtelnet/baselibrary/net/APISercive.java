package com.mtelnet.baselibrary.net;


import com.mtelnet.baselibrary.net.bean.BannerList;
import com.mtelnet.baselibrary.net.bean.BaseCallBackListData;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by hongzhenyue on 16/9/26.
 */

public interface APISercive {
//    @POST(ApiManager.url_login)
//    @FormUrlEncoded
//    Observable<BaseCallBackData<UserInfo>> loginResult(@Field("email") String email, @Field("password") String password, @Field("lang") String lang);
//
//    @POST(ApiManager.url_register)
//    @FormUrlEncoded
//    Observable<BaseCallBackData<UserInfo>> regsitResult(@Field("username") String name,
//                                                        @Field("email") String email,
//                                                        @Field("phone") String phone,
//                                                        @Field("password") String password,
//                                                        @Field("lang") String lang,
//                                                        @Field("access_token") String access_token,
//                                                        @Field("user_id") String user_id
//    );
//
//    @POST(ApiManager.url_userinfo)
//    @FormUrlEncoded
//    Observable<BaseCallBackData<MemberInfo>> getMemberInfoResult(@Field("user_id") String id, @Field("access_token") String access_token, @Field("lang") String lang);
//
//    @POST(ApiManager.url_forgetPassword)
//    @FormUrlEncoded
//    Observable<BaseCallBackData<BaseResult>> forgetPassword(@Field("email") String email, @Field("lang") String lang);
//
//    @POST(ApiManager.url_checkPasswordCode)
//    @FormUrlEncoded
//    Observable<BaseCallBackData<BaseResult>> checkPasswordCode(@Field("email") String email, @Field("code") String code, @Field("lang") String lang);
//
//    @POST(ApiManager.url_resetPassword)
//    @FormUrlEncoded
//    Observable<BaseCallBackData<BaseResult>> resetPassword(@Field("email") String email, @Field("code") String code, @Field("password") String password, @Field("lang") String lang);
//
//    // 上传多个文件
//    @Multipart
//    @POST(ApiManager.url_updateProfile)
//    Observable<BaseCallBackData<BaseResult>> updateMemberProfileAll(@Query("access_token") String access_token,
//                                                                    @Query("lang") String lang,
//                                                                    @Query("user_id") String user_id,
//                                                                    @Query("email") String email,
//                                                                    @Query("username") String username,
//                                                                    @Query("phone") String phone,
//
//                                                                    @Part MultipartBody.Part file1,
//                                                                    @Part MultipartBody.Part file2
//    );
//
//    // 上传单个文件
//    @Multipart
//    @POST(ApiManager.url_updateProfile)
//    Observable<BaseCallBackData<BaseResult>> updateMemberProfileHead(@Query("access_token") String access_token,
//                                                                     @Query("lang") String lang,
//                                                                     @Query("user_id") String user_id,
//                                                                     @Query("email") String email,
//                                                                     @Query("username") String username,
//                                                                     @Query("phone") String phone,
//
//                                                                     @Part MultipartBody.Part file
//    );
//
//    // 上传单个文件
//    @Multipart
//    @POST(ApiManager.url_updateProfile)
//    Observable<BaseCallBackData<BaseResult>> updateMemberProfileBg(@Query("access_token") String access_token,
//                                                                   @Query("lang") String lang,
//                                                                   @Query("user_id") String user_id,
//                                                                   @Query("email") String email,
//                                                                   @Query("username") String username,
//                                                                   @Query("phone") String phone,
//
//                                                                   @Part MultipartBody.Part file
//    );
//
//    @POST(ApiManager.url_updateProfile)
//    @FormUrlEncoded
//    Observable<BaseCallBackData<BaseResult>> updateMemberProfileOnly(@Field("access_token") String access_token,
//                                                                     @Field("lang") String lang,
//                                                                     @Field("user_id") String user_id,
//                                                                     @Field("email") String email,
//                                                                     @Field("username") String username,
//                                                                     @Field("phone") String phone);
//
//    @POST(ApiManager.url_changePassword)
//    @FormUrlEncoded
//    Observable<BaseCallBackData<BaseResult>> changePwd(@Field("user_id") String user_id, @Field("access_token") String access_token,
//                                                       @Field("password_old") String password_old, @Field("password") String password,
//                                                       @Field("lang") String lang);

    @POST(ApiManager.url_getBannerList)
    @FormUrlEncoded
    Observable<BaseCallBackListData<BannerList>> getBanner(@Field("lang") String lang);

//    @POST(ApiManager.url_getEventList)
//    @FormUrlEncoded
//    Observable<BaseCallBackListData<EventListData>> getEvent(@Field("access_token") String access_token,
//                                                             @Field("user_id") String user_id,
//                                                             @Field("lang") String lang,
//                                                             @Field("type") String type);
//
//    @POST(ApiManager.url_getEventList)
//    @FormUrlEncoded
//    Observable<BaseCallBackListData<EventListData>> getCalendarEvent(@Field("access_token") String access_token,
//                                                                     @Field("user_id") String user_id,
//                                                                     @Field("lang") String lang,
//                                                                     @Field("start_date") String start_date,
//                                                                     @Field("end_date") String end_date);
//
//    @POST(ApiManager.url_getEventList)
//    @FormUrlEncoded
//    Observable<BaseCallBackListData<EventListData>> getEventWish(@Field("access_token") String access_token,
//                                                                 @Field("user_id") String user_id,
//                                                                 @Field("lang") String lang,
//                                                                 @Field("type") String type,
//                                                                 @Field("mine_wish") String mine_wish);
//
//    @POST(ApiManager.url_getEventList)
//    @FormUrlEncoded
//    Observable<BaseCallBackListData<EventListData>> searchEvent(@Field("access_token") String access_token,
//                                                                @Field("user_id") String user_id,
//                                                                @Field("lang") String lang,
//                                                                @Field("type") String type,
//                                                                @Field("search") String search);
//
//    @POST(ApiManager.url_getEventList)
//    @FormUrlEncoded
//    Observable<BaseCallBackListData<EventListData>> searchEventByTime(@Field("access_token") String access_token,
//                                                                      @Field("user_id") String user_id,
//                                                                      @Field("lang") String lang,
//                                                                      @Field("type") String type,
//                                                                      @Field("start_date") String start_date,
//                                                                      @Field("end_date") String end_date);
//
//    @POST(ApiManager.url_getEventDetail)
//    @FormUrlEncoded
//    Observable<BaseCallBackData<EventInfo>> getEventInfo(@Field("event_id") String event_id, @Field("access_token") String access_token,
//                                                         @Field("user_id") String user_id, @Field("lang") String lang);
//
//
//    @POST(ApiManager.url_getEventRemoveOrAddWish)
//    @FormUrlEncoded
//    Observable<BaseCallBackData<BaseResult>> addOrRemoveWishlist(@Field("access_token") String access_token, @Field("user_id") String user_id,
//                                                                 @Field("event_id") String event_id, @Field("wish") String wish, @Field("lang") String lang);
//
//    @POST(ApiManager.url_getVideoList)
//    @FormUrlEncoded
//    Observable<BaseCallBackListData<VideoListData>> getMyVideoList(@Field("access_token") String access_token, @Field("user_id") String user_id,
//                                                                   @Field("mine_upload") String mine_upload, @Field("lang") String lang);
//
//    @POST(ApiManager.url_getVideoList)
//    @FormUrlEncoded
//    Observable<BaseCallBackListData<VideoListData>> getVotingVideoList(@Field("access_token") String access_token, @Field("user_id") String user_id,
//                                                                       @Field("is_voting") String is_voting, @Field("lang") String lang);
//
//    @POST(ApiManager.url_getVideoList)
//    @FormUrlEncoded
//    Observable<BaseCallBackListData<VideoListData>> getMyWishVideoList(@Field("access_token") String access_token, @Field("user_id") String user_id,
//                                                                       @Field("mine_wish") String mine_wish, @Field("lang") String lang);
//
//    @POST(ApiManager.url_getVideoList)
//    @FormUrlEncoded
//    Observable<BaseCallBackListData<VideoListData>> searchVideoList(@Field("access_token") String access_token, @Field("user_id") String user_id,
//                                                                    @Field("search") String search, @Field("lang") String lang);
//
//    @POST(ApiManager.url_getVideoDetail)
//    @FormUrlEncoded
//    Observable<BaseCallBackData<VideoDetailInfo>> getVideoDetail(@Field("access_token") String access_token, @Field("user_id") String user_id,
//                                                                 @Field("lang") String lang, @Field("video_id") String video_id);
//
//    @POST(ApiManager.url_getVideoRemoveOrAddWish)
//    @FormUrlEncoded
//    Observable<BaseCallBackData<BaseResult>> operateVideoWishList(@Field("access_token") String access_token, @Field("user_id") String user_id,
//                                                                  @Field("video_id") String video_id, @Field("wish") String wish,
//                                                                  @Field("lang") String lang);
//
//    @POST(ApiManager.url_getVideoVote)
//    @FormUrlEncoded
//    Observable<BaseCallBackData<BaseResult>> operateVideoVoting(@Field("access_token") String access_token, @Field("user_id") String user_id,
//                                                                @Field("video_id") String video_id, @Field("vote") String vote,
//                                                                @Field("lang") String lang);
//
//    @Multipart
//    @POST(ApiManager.url_videoUpload)
//    Observable<BaseCallBackData<BaseResult>> uploadVideo(@Query("access_token") String access_token,
//                                                         @Query("user_id") String user_id,
//                                                         @Query("lang") String lang,
//                                                         @Query("title") String title,
//                                                         @Query("description") String description,
//                                                         @Part MultipartBody.Part file
//    );
//
//    @POST(ApiManager.url_getMusicList)
//    @FormUrlEncoded
//    Observable<BaseCallBackListData<MusicScoreListData>> getMusicList(@Field("access_token") String access_token, @Field("user_id") String user_id,
//                                                                      @Field("lang") String lang);
//
//    @POST(ApiManager.url_getMusicList)
//    @FormUrlEncoded
//    Observable<BaseCallBackListData<MusicScoreListData>> searchMusicList(@Field("access_token") String access_token, @Field("user_id") String user_id,
//                                                                         @Field("lang") String lang, @Field("search") String search);
//
//    @POST(ApiManager.url_getMusicDetail)
//    @FormUrlEncoded
//    Observable<BaseCallBackData<MusicScoreDetailData>> getMusicDetialInfo(@Field("access_token") String access_token,
//                                                                          @Field("user_id") String user_id,
//                                                                          @Field("lang") String lang,
//                                                                          @Field("music_id") String music_id,
//                                                                          @Field("category_id") String category_id);
//
//    @POST(ApiManager.url_getMusicDetail)
//    @FormUrlEncoded
//    Observable<BaseCallBackData<MusicScoreDetailData>> getMusicDetialInfoByCategory(@Field("access_token") String access_token,
//                                                                                    @Field("user_id") String user_id,
//                                                                                    @Field("lang") String lang,
//                                                                                    @Field("music_id") String music_id,
//                                                                                    @Field("category_id") String category_id);
//
//    @POST(ApiManager.url_getMusicRemoveOrAddWish)
//    @FormUrlEncoded
//    Observable<BaseCallBackData<BaseResult>> operateMusicScoreWish(@Field("access_token") String access_token,
//                                                                   @Field("user_id") String user_id,
//                                                                   @Field("music_score_id") String music_score_id,
//                                                                   @Field("wish") String wish,
//                                                                   @Field("lang") String lang);
//
//    @POST(ApiManager.url_getMusicWishScores)
//    @FormUrlEncoded
//    Observable<BaseCallBackListData<MusicWishListData>> getMusicWishScores(@Field("access_token") String access_token,
//                                                                           @Field("user_id") String user_id,
//                                                                           @Field("lang") String lang);
//
//    @POST(ApiManager.url_getScoreList)
//    @FormUrlEncoded
//    Observable<BaseCallBackListData<ScoreDetail>> searchMusicScoreList(
//            @Field("music_id") String music_id,
//            @Field("search") String search,
//            @Field("lang") String lang);
//
//    @POST(ApiManager.url_getMusicCategoryList)
//    @FormUrlEncoded
//    Observable<BaseCallBackListData<CategoryData>> getMusicCategoryList(
//            @Field("lang") String lang);

    @Streaming
    @GET
    Call<ResponseBody> downLoadPdf(@Url String file);

//
//    @POST(ApiManager.url_getGuest)
//    @FormUrlEncoded
//    Observable<BaseCallBackData<GuestInfo>> getGuest(
//            @Field("lang") String lang);
//
//    @POST(ApiManager.url_getContent)
//    @FormUrlEncoded
//    Observable<BaseCallBackData<AboutInfoContent>> getContent(
//            @Field("lang") String lang, @Field("page") String page);
}
