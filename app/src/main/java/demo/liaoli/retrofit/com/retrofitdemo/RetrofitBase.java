package demo.liaoli.retrofit.com.retrofitdemo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.protobuf.ProtoConverterFactory;

/**
 * Created by Administrator on 2017/8/16 0016.
 */

public class RetrofitBase {
    public static Retrofit getRetrofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://120.79.2.87/wawa/wawa/c/")
                .addConverterFactory(ProtoConverterFactory.create())
                .build();

        return retrofit;
    }

}
