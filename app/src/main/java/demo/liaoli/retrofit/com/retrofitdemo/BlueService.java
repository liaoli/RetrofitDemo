package demo.liaoli.retrofit.com.retrofitdemo;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by Administrator on 2017/8/16 0016.
 */

public interface BlueService {
    @GET("book/search")
    Call<BookSearchResponse> getSearchBooks(@Query("q") String name,
                                            @Query("tag") String tag, @Query("start") int start,
                                            @Query("count") int count);

    @FormUrlEncoded
    @POST("book/search")
    Call<BookSearchResponse> getSearchBooksPost(@Field("q") String name,
                                                @Field("tag") String tag, @Field("start") int start,
                                                @Field("count") int count);
    @POST()
    @Multipart
    Call<UploadResponse> uploadFile(@Url String url,
                                  @PartMap() Map<String, String> partMap,
                                  @Part MultipartBody.Part file1);
}


