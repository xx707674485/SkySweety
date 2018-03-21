package com.xjst.skysweety.http;

import android.util.Log;

import com.xjst.skysweety.Constants;
import com.xjst.skysweety.SkySweetyApplication;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * RetrofitFactory
 * 网络请求工厂类
 */
public class RetrofitApiHelp {
    private static final String TAG = RetrofitApiHelp.class.getSimpleName();
    private static final String BASE_URL = Constants.url;
    private static final long TIMEOUT = 3000;
    private static RetrofitApiHelp mRetrofitInstance;
    private Retrofit retrofit;

    /**
     * 定义不同的Retrofit接口
     */
//    private static RetrofitService mRetrofitService;
//    private static WulianService mWulianService;
//    private static VideoService mVideoService;

    Interceptor mInterceptor = new Interceptor() {
        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request.Builder builder = chain.request().newBuilder();
            // 替换为自己的token
            builder.addHeader("tookie", "zx");
            return chain.proceed(builder.build());
        }
    };

    File cacheFile = new File(SkySweetyApplication.getInstance().getApplicationContext().getCacheDir(), "cache");
    Cache cache = new Cache(cacheFile, 1024 * 1024 * 100); //100Mb
    // Retrofit是基于OkHttpClient的，可以创建一个OkHttpClient进行一些配置
    public OkHttpClient httpClient = new OkHttpClient.Builder()
            // 添加通用的Header
            .addInterceptor(mInterceptor)
            /*
            这里可以添加一个HttpLoggingInterceptor，因为Retrofit封装好了从Http请求到解析，
            出了bug很难找出来问题，添加HttpLoggingInterceptor拦截器方便调试接口
             */
            .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    Log.w(TAG, "log: " + message);
                }
            }).setLevel(HttpLoggingInterceptor.Level.BASIC))
            .cache(cache)
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .build();


    /**
     * 单例模式下的RetrofitFactory
     *
     * @return
     */
    public static RetrofitApiHelp getRetrofitInstance() {
        if (mRetrofitInstance == null) {
            mRetrofitInstance = new RetrofitApiHelp();
        }
        return mRetrofitInstance;
    }

    public <T> T configRetrofit(Class<T> service) {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient)
                .build();

        return retrofit.create(service);

    }


    /**
     * 统一线程处理
     *
     * @param <T> public static <T> ObservableTransformer<T, T> applySchedulers() {
     *            return new ObservableTransformer<T, T>() {
     * @return
     * @Override public ObservableSource<T> apply(Observable<T> upstream) {
     * return upstream.subscribeOn(Schedulers.io())
     * .observeOn(AndroidSchedulers.mainThread());
     * }
     * };
     * }
     */
    public static <T> ObservableTransformer<T, T> applySchedulers() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };

    }

    /**
     * 处理不同逻辑的api分类
     * @return
     */

//    public RetrofitService getRetrofitService() {
//        return mRetrofitService == null ? configRetrofit(RetrofitService.class) : mRetrofitService;
//    }
//
//    public WulianService getWulianService() {
//        return mWulianService == null ? configRetrofit(WulianService.class) : mWulianService;
//    }
//
//    public VideoService getVideoService() {
//        return mVideoService == null ? configRetrofit(VideoService.class) : mVideoService;
//    }
}
