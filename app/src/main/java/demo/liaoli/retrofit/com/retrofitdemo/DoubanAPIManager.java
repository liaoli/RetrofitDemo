package demo.liaoli.retrofit.com.retrofitdemo;

import android.support.annotation.NonNull;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import boomegg.cn.wawa.proto.PhpApi;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Administrator on 2017/8/16 0016.
 */

public class DoubanAPIManager {

    //private static  BlueService mBlueService =  RetrofitBase.getRetrofit().create(BlueService.class);

    private static  BlueService mBlueService = ServiceGenerator.createService(BlueService.class);

    public static BlueService getBlueService(){
        return mBlueService;
    }

    public static Call<BookSearchResponse> SearchBook(String name,String tag,int start,int count){
       return getBlueService().getSearchBooksGet(name,tag,start,count);
    }

    public static void getBookById(String id, Callback<BookSResponse> callback){
        getBlueService().getBookById(id).enqueue(callback);
    }


    public static void test(Callback<PhpApi.UserInfoRsp> callback){
        getBlueService().test().enqueue(callback);
    }

    public static void SearchBook(String name, String tag, int start, int count, Callback<BookSearchResponse> callback){
        getBlueService().getSearchBooksGet(name,tag,start,count).enqueue(callback);
    }

    public static void SearchBookPost(String name, String tag, int start, int count, Callback<BookSearchResponse> callback){
        getBlueService().getSearchBooksPost(name,tag,start,count).enqueue(callback);
    }

    public static void SearchBookQueryMap(Map<String, String> options, Callback<BookSearchResponse> callback){
        getBlueService().getSearchBookQueryMap(options).enqueue(callback);
    }

    public static void uploadMultipleFiles(String url,String filePath, Callback<UploadResponse> callback){




        Map<String, RequestBody> paramMap = new HashMap<>();

        RequestBody requestBody1 = RequestBody.create(null, "short");
        RequestBody requestBody2 = RequestBody.create(null, "azVUQkg2a3J1UjUvb0FYZWt1R1FxT2NpUzNpUGIrLzJrM2FkVExSaE5Qc2I5ekxzalFubm1FRzZwUTVTUHl4bFpWRDJSQmM5eFI0WmUrK0dpZmlHVGlMWndybjRmbGhEcUVJYTdvLzgxaDZ2L1U1N0NoQXUrTWRyS3FXb09VNkU");

        paramMap.put("type",requestBody1);
        paramMap.put("token",requestBody2);


        File file = new File(filePath);

        RequestBody requestFile =
                RequestBody.create(MediaType.parse("video/*"), file);
        final MultipartBody.Part filePart = MultipartBody.Part.createFormData("fileData", file.getName(), requestFile);


        getBlueService().uploadFile(url,paramMap,filePart).enqueue(callback);

    }

    public static final String MULTIPART_FORM_DATA = "multipart/form-data";

    @NonNull
    private static RequestBody createPartFromString(String descriptionString) {
        return RequestBody.create(
                MediaType.parse(MULTIPART_FORM_DATA), descriptionString);
    }

    @NonNull
    private static MultipartBody.Part prepareFilePart(String partName, String filePath) {
        File file = new File(filePath);

        // 为file建立RequestBody实例
        RequestBody requestFile =
                RequestBody.create(MediaType.parse(MULTIPART_FORM_DATA), file);

        // MultipartBody.Part借助文件名完成最终的上传
        return MultipartBody.Part.createFormData(partName, file.getName(), requestFile);
    }


}
