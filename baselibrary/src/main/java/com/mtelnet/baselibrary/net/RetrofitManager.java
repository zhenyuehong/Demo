package com.mtelnet.baselibrary.net;

import com.mtelnet.baselibrary.net.bean.BannerList;
import com.mtelnet.baselibrary.net.bean.BaseCallBackListData;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hongzhenyue on 16/8/29.
 */
public class RetrofitManager {
    public static final String BASE_URL = ApiManager.WEB_SERVICE_URL_HTTPS;
//    private Retrofit retrofit;
    private static RetrofitManager instance;
    public static APISercive mAPISercive;

    private RetrofitManager() {

//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .connectTimeout(30, TimeUnit.SECONDS)//time out
//                .readTimeout(30, TimeUnit.SECONDS)
//                .addInterceptor(logging) //打印日志
//                .build();
//
//        retrofit = new Retrofit.Builder()
//                .baseUrl(BASE_URL)//这里建议：- Base URL: 总是以/结尾；- @Url: 不要以/开头
//                .addConverterFactory(GsonConverterFactory.create())//gson转化器
////                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//Rx
//                .client(okHttpClient) //设置OKHttpClient
//                .build();

        OkHttpClient.Builder okHttpClientBuilder = OKHttpClientBuilderHelper.getBuilder();
        OkHttpClient okHttpClient = okHttpClientBuilder.build();

        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .client(okHttpClient)
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .addConverterFactory(ScalarsConverterFactory.create())//添加这个就返回String
                        .addConverterFactory(GsonConverterFactory.create());//
        Retrofit retrofit = builder.build();

        mAPISercive = retrofit.create(APISercive.class);

    }

    public static RetrofitManager getInstance() {
        if (instance == null) {
            synchronized (RetrofitManager.class) {
                if (instance == null) {
                    instance = new RetrofitManager();
                }
            }
        }
        return instance;
    }

//    public Call<ResponseBody> downLoadPdf(String url) {
//        return mAPISercive.downLoadPdf(url);
//    }
//
//    public void getGuest(ApiCallBack<BaseCallBackData<GuestInfo>> result, String lang) {
//        mAPISercive.getGuest(lang)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
//    public void doLogin(ApiCallBack<BaseCallBackData<UserInfo>> result, String email, String password, String lang) {
//        mAPISercive.loginResult(email, password, lang)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
//    public void doRegsit(ApiCallBack<BaseCallBackData<UserInfo>> result, String name, String email, String phone, String password, String lang, String access_token, String user_id) {
//        mAPISercive.regsitResult(name, email, phone, password, lang,access_token,user_id)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
//    public void getMemberInfoResult(ApiCallBack<BaseCallBackData<MemberInfo>> result, String id, String token, String lang) {
//        mAPISercive.getMemberInfoResult(id, token, lang)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
//    public void forgetPassword(ApiCallBack<BaseCallBackData<BaseResult>> result, String email, String lang) {
//        mAPISercive.forgetPassword(email, lang)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
//    public void checkPasswordCode(ApiCallBack<BaseCallBackData<BaseResult>> result, String email, String code, String lang) {
//        mAPISercive.checkPasswordCode(email, code, lang)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
//    public void resetPassword(ApiCallBack<BaseCallBackData<BaseResult>> result, String email, String code, String password, String lang) {
//        mAPISercive.resetPassword(email, code, password, lang)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
//    public void updateMemberProfileAll(ApiCallBack<BaseCallBackData<BaseResult>> result, String access_token, String lang, String user_id,
//                                       String email, String username, String phone, MultipartBody.Part file1, MultipartBody.Part file2) {
//        mAPISercive.updateMemberProfileAll(access_token, lang, user_id,email, username, phone, file1, file2)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
//    public void updateMemberProfileHeadImage(ApiCallBack<BaseCallBackData<BaseResult>> result, String access_token, String lang, String user_id,
//                                             String email, String username, String phone, MultipartBody.Part file) {
//        mAPISercive.updateMemberProfileHead(access_token, lang, user_id,email, username, phone, file)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
//    public void updateMemberProfileBg(ApiCallBack<BaseCallBackData<BaseResult>> result, String access_token, String lang, String user_id,
//                                      String email, String username, String phone, MultipartBody.Part file) {
//        mAPISercive.updateMemberProfileBg(access_token, lang, user_id,email, username, phone, file)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
//    public void updateMemberProfileOnly(ApiCallBack<BaseCallBackData<BaseResult>> result, String access_token, String lang, String user_id,
//                                        String email, String username, String phone) {
//        mAPISercive.updateMemberProfileOnly(access_token, lang, user_id,email, username, phone)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
//    public void changePwd(ApiCallBack<BaseCallBackData<BaseResult>> result, String user_id, String access_token, String password_old,
//                          String password,
//                          String lang) {
//        mAPISercive.changePwd(user_id, access_token, password_old, password, lang)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
    public void getBanner(ApiCallBack<BaseCallBackListData<BannerList>> result, String lang) {
        mAPISercive.getBanner(lang)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new UIObserver<>(result));
    }
//
//    public void getEvent(ApiCallBack<BaseCallBackListData<EventListData>> result, String access_token, String user_id, String lang,
//                         String type) {
//        mAPISercive.getEvent(access_token, user_id, lang, type)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
//    public void getCalendarEvent(ApiCallBack<BaseCallBackListData<EventListData>> result, String access_token, String user_id, String lang,
//                                 String start_date, String end_date) {
//        mAPISercive.getCalendarEvent(access_token, user_id, lang, start_date, end_date)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
//    public void getEventWish(ApiCallBack<BaseCallBackListData<EventListData>> result, String access_token, String user_id, String lang,
//                             String type, String mine_wish) {
//        mAPISercive.getEventWish(access_token, user_id, lang, type, mine_wish)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
//    public void searchEvent(ApiCallBack<BaseCallBackListData<EventListData>> result, String access_token, String user_id, String lang,
//                            String type, String search) {
//        mAPISercive.searchEvent(access_token, user_id, lang, type, search)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
//    public void searchEventByTime(ApiCallBack<BaseCallBackListData<EventListData>> result, String access_token, String user_id, String lang,
//                                  String type, String start_date, String end_date) {
//        mAPISercive.searchEventByTime(access_token, user_id, lang, type, start_date, end_date)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
//    public void getEventInfo(ApiCallBack<BaseCallBackData<EventInfo>> result, String event_id, String access_token, String user_id,
//                             String lang) {
//        mAPISercive.getEventInfo(event_id, access_token, user_id, lang)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
//    public void addOrRemoveWishlist(ApiCallBack<BaseCallBackData<BaseResult>> result, String access_token, String user_id, String event_id,
//                                    String wish, String lang) {
//        mAPISercive.addOrRemoveWishlist(access_token, user_id, event_id, wish, lang)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
//    public void getMyVideoList(ApiCallBack<BaseCallBackListData<VideoListData>> result, String access_token, String user_id, String mine_upload, String lang) {
//        mAPISercive.getMyVideoList(access_token, user_id, mine_upload, lang)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
//    public void getVotingVideoList(ApiCallBack<BaseCallBackListData<VideoListData>> result, String access_token, String user_id, String is_voting, String lang) {
//        mAPISercive.getVotingVideoList(access_token, user_id, is_voting, lang)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
//    public void getMyWishVideoList(ApiCallBack<BaseCallBackListData<VideoListData>> result, String access_token, String user_id, String mine_wish, String lang) {
//        mAPISercive.getMyWishVideoList(access_token, user_id, mine_wish, lang)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
//    public void searchVideoList(ApiCallBack<BaseCallBackListData<VideoListData>> result, String access_token, String user_id, String search, String lang) {
//        mAPISercive.searchVideoList(access_token, user_id, search, lang)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
//    public void getVideoDetail(ApiCallBack<BaseCallBackData<VideoDetailInfo>> result, String access_token, String user_id, String lang, String video_id) {
//        mAPISercive.getVideoDetail(access_token, user_id, lang, video_id)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
//    public void operateVideoWishList(ApiCallBack<BaseCallBackData<BaseResult>> result, String access_token, String user_id, String video_id, String wish, String lang) {
//        mAPISercive.operateVideoWishList(access_token, user_id, video_id, wish, lang)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
//    public void operateVideoVoting(ApiCallBack<BaseCallBackData<BaseResult>> result, String access_token, String user_id, String video_id, String wish, String lang) {
//        mAPISercive.operateVideoVoting(access_token, user_id, video_id, wish, lang)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
//    public void uploadVideo(ApiCallBack<BaseCallBackData<BaseResult>> result, String access_token, String user_id, String lang, String title, String description, MultipartBody.Part file) {
//        mAPISercive.uploadVideo(access_token, user_id, lang, title, description, file)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
//    public void getMusicList(ApiCallBack<BaseCallBackListData<MusicScoreListData>> result, String access_token, String user_id, String lang) {
//        mAPISercive.getMusicList(access_token, user_id, lang)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
//    public void searchMusicList(ApiCallBack<BaseCallBackListData<MusicScoreListData>> result, String access_token, String user_id, String lang, String search) {
//        mAPISercive.searchMusicList(access_token, user_id, lang, search)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
//    public void getMusicDetialInfo(ApiCallBack<BaseCallBackData<MusicScoreDetailData>> result, String access_token, String user_id, String lang, String music_id, String category_id) {
//        mAPISercive.getMusicDetialInfo(access_token, user_id, lang, music_id, category_id)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
//    public void getMusicDetialInfoByCategory(ApiCallBack<BaseCallBackData<MusicScoreDetailData>> result, String access_token, String user_id, String lang, String music_id, String category_id) {
//        mAPISercive.getMusicDetialInfoByCategory(access_token, user_id, lang, music_id, category_id)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
//    public void operateMusicScoreWish(ApiCallBack<BaseCallBackData<BaseResult>> result, String access_token, String user_id, String music_score_id, String wish, String lang) {
//        mAPISercive.operateMusicScoreWish(access_token, user_id, music_score_id, wish, lang)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
//    public void getMusicWishScores(ApiCallBack<BaseCallBackListData<MusicWishListData>> result, String access_token, String user_id, String lang) {
//        mAPISercive.getMusicWishScores(access_token, user_id, lang)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
//
//    public void searchMusicScores(ApiCallBack<BaseCallBackListData<ScoreDetail>> result, String music_id, String search, String lang) {
//        mAPISercive.searchMusicScoreList(music_id, search, lang)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
//    public void getMusicCategoryList(ApiCallBack<BaseCallBackListData<CategoryData>> result, String lang) {
//        mAPISercive.getMusicCategoryList(lang)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
//
//    public void getContent(ApiCallBack<BaseCallBackData<AboutInfoContent>> result, String lang, String page) {
//        mAPISercive.getContent(lang, page)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new UIObserver<>(result));
//    }
}
