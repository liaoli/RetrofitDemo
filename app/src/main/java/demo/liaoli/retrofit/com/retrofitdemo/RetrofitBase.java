package demo.liaoli.retrofit.com.retrofitdemo;

import retrofit2.Retrofit;
import retrofit2.converter.wire.WireConverterFactory;

/**
 * Created by Administrator on 2017/8/16 0016.
 */

public class RetrofitBase {
    public static Retrofit getRetrofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://120.79.2.87/wawa/wawa/c/")
                .addConverterFactory(WireConverterFactory.create())
                .build();

        return retrofit;
    }

}
