package demo.liaoli.retrofit.com.retrofitdemo;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/8/17 0017.
 */

public class ServiceGenerator {

    public static final String BaseURL = "https://api.douban.com/v2/";

    private static Retrofit retrofit;

    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BaseURL).addConverterFactory(GsonConverterFactory.create());

    private static OkHttpClient.Builder httpClient = new OkHttpClient().newBuilder();

    private static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    public static <S> S createService(Class<S> serviceClass){

        if(!httpClient.interceptors().contains(loggingInterceptor)){
            httpClient.addInterceptor(loggingInterceptor);
            builder.client(httpClient.build());
            retrofit = builder.build();
        }

        return retrofit.create(serviceClass);
    }

}
