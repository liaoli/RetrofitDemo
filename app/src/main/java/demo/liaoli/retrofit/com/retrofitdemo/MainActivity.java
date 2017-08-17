package demo.liaoli.retrofit.com.retrofitdemo;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    private Callback<BookSearchResponse> callback = new Callback<BookSearchResponse>() {
        @Override
        public void onResponse(Call<BookSearchResponse> call, Response<BookSearchResponse> response) {

            List<BookSearchResponse.BooksBean> books = response.body().getBooks();

            for (BookSearchResponse.BooksBean booksBean : books) {
                Log.e(TAG, booksBean.getImage() + booksBean.getAuthor() + booksBean.getPublisher());
            }


        }

        @Override
        public void onFailure(Call<BookSearchResponse> call, Throwable t) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // QueryMapTest();

        pathtest();


        if (isGranted(Manifest.permission.WRITE_EXTERNAL_STORAGE) && isGranted(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            DoubanAPIManager.uploadMultipleFiles("http://tools.livestar.com/upload/?ac=s3", "/storage/emulated/0/outputVideo1502877596964.mp4", new Callback<UploadResponse>() {
                @Override
                public void onResponse(Call<UploadResponse> call, Response<UploadResponse> response) {

                    UploadResponse uploadResponse = response.body();

                    Log.e(TAG, "response.isSuccessful() = " + response.isSuccessful() + ",response.code() = " + response.code() + "uploadResponse---> " + uploadResponse == null ? "null" : uploadResponse.toString());

                }

                @Override
                public void onFailure(Call<UploadResponse> call, Throwable t) {
                    Log.e(TAG, t.toString());
                }
            });
        } else {
            ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE);
        }
    }

    private void pathtest() {
        DoubanAPIManager.getBookById("1003078", new Callback<BookSResponse>() {
            @Override
            public void onResponse(Call<BookSResponse> call, Response<BookSResponse> response) {
                BookSResponse bookSResponse = response.body();
                Log.e(TAG, bookSResponse.getImage() + bookSResponse.getAuthor() + bookSResponse.getPublisher());
            }

            @Override
            public void onFailure(Call<BookSResponse> call, Throwable t) {

            }
        });
    }


    /**
     * 如果Query参数比较多，那么可以通过@QueryMap方式将所有的参数集成在一个Map统一传递，还以上文中的get请求方法为例
     */
    private void QueryMapTest() {
        Map<String, String> options = new HashMap<>();

        options.put("q", "小王子");
        options.put("tag", "");
        options.put("start", "0");
        options.put("count", "3");

        DoubanAPIManager.SearchBookQueryMap(options, callback);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


    }

    private void test() {
       /* 4. Query非必填

        如果请求参数为非必填，也就是说即使不传该参数，服务端也可以正常解析，那么如何实现呢？其实也很简单，
        请求方法定义处还是需要完整的Query注解，某次请求如果不需要传该参数的话，只需填充null即可。
        针对文章开头提到的get的请求，加入按以下方式调用

        那么得到的url地址为

        https://api.douban.com/v2/book/search?q=%E5%B0%8F%E7%8E%8B%E5%AD%90&start=0&count=3
        */
        DoubanAPIManager.SearchBookPost("小王子", "", 0, 3, callback);
    }

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};


    public boolean isGranted(String permission) {
        return !isMarshmallow() || isGranted_(permission);
    }

    private boolean isMarshmallow() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }

    private boolean isGranted_(String permission) {
        int checkSelfPermission = ActivityCompat.checkSelfPermission(this, permission);
        return checkSelfPermission == PackageManager.PERMISSION_GRANTED;
    }

}
