package demo.liaoli.retrofit.com.retrofitdemo;

/**
 * Created by Administrator on 2017/8/16 0016.
 */

public class UploadResponse {

    /**
     * state : true
     * data : {"video":"http://video.livestar.com/xxx.mp4","pic":"http://lscdn.r2games.com/uploads/xxxx.jpg","pic_w":640,"pic_h":320}
     * msg : state为false时返回，表示错误信息
     */

    private boolean state;
    private DataBean data;
    private String msg;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "msg:" + msg + ",state:" + state + data == null ? "": data.toString();
    }

    public static class DataBean {
        /**
         * video : http://video.livestar.com/xxx.mp4
         * pic : http://lscdn.r2games.com/uploads/xxxx.jpg
         * pic_w : 640
         * pic_h : 320
         */

        private String video;
        private String pic;
        private int pic_w;
        private int pic_h;

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public int getPic_w() {
            return pic_w;
        }

        public void setPic_w(int pic_w) {
            this.pic_w = pic_w;
        }

        public int getPic_h() {
            return pic_h;
        }

        public void setPic_h(int pic_h) {
            this.pic_h = pic_h;
        }

        @Override
        public String toString() {
            return "video:"+ video +" ,pic :"+ pic  +" ,pic_w:" + pic_w +",pic_h :"+ pic_h;
        }
    }


}
