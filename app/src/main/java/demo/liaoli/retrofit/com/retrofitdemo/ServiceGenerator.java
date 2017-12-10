package demo.liaoli.retrofit.com.retrofitdemo;

import java.io.IOException;

import boomegg.cn.wawa.proto.PhpApi;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/8/17 0017.
 */

public class ServiceGenerator {

    public static final String BaseURL = "http://120.79.2.87/wawa/wawa/c/";

    private static Retrofit retrofit;

    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BaseURL).addConverterFactory(GsonConverterFactory.create());

    private static OkHttpClient.Builder httpClient = new OkHttpClient().newBuilder();

    /**
     * 请求返回log拦截器
     */
    private static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    public static <S> S createService(Class<S> serviceClass) {

        if (!httpClient.interceptors().contains(loggingInterceptor)) {
            httpClient.addInterceptor(loggingInterceptor).addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();


                    if (request.body() instanceof FormBody) {
                        FormBody.Builder bodyBuilder = new FormBody.Builder();
                        FormBody formBody = (FormBody) request.body();

                        //把原来的参数添加到新的构造器，（因为没找到直接添加，所以就new新的）
                        for (int i = 0; i < formBody.size(); i++) {
                            bodyBuilder.addEncoded(formBody.encodedName(i), formBody.encodedValue(i));
                        }

                        formBody = bodyBuilder
                                .add("loginType", "1")
                                .add("deviceId", "test_12345")
                                .add("_device", "2")
                                .add("_channel", "develop")
                                .add("_version", "1.0")
                                .add("_reversion", "1")
                                .build();

                        request = request.newBuilder().post(formBody).build();
                    }else{

                        FormBody.Builder bodyBuilder = new FormBody.Builder();

                        FormBody formBody = bodyBuilder
                                .add("loginType", "1")
                                .add("deviceId", "test_12345")
                                .add("_device", "2")
                                .add("_channel", "develop")
                                .add("_version", "1.0")
                                .add("_reversion", "1")
                                .build();

                        request = request.newBuilder().post(formBody).build();

                    }
                    Response response = chain.proceed(request);
//
                    byte[] bytes = response.body().bytes();
                    String s = new String(bytes);

                    PhpApi.UserInfoRsp userInfoRsp =  PhpApi.UserInfoRsp.parseFrom(bytes);

                    return response;
                }

            });
            builder.client(httpClient.build());
            retrofit = builder.build();
        }

        return retrofit.create(serviceClass);
    }

}
