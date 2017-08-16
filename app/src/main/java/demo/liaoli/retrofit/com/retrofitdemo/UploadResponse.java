package demo.liaoli.retrofit.com.retrofitdemo;

/**
 * Created by Administrator on 2017/8/16 0016.
 */

public class UploadResponse {

    /**
     * state : true
     * data :
     * msg : state为false时返回，表示错误信息
     */

    private boolean state;
    private String data;
    private String msg;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
