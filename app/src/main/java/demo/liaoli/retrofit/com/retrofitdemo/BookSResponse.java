package demo.liaoli.retrofit.com.retrofitdemo;

import java.util.List;

/**
 * Created by Administrator on 2017/8/17 0017.
 */

public class BookSResponse {

    /**
     * rating : {"max":10,"numRaters":11318,"average":"9.2","min":0}
     * subtitle :
     * author : ["（法）圣埃克苏佩里"]
     * pubdate : 2000-9-1
     * tags : [{"count":2924,"name":"小王子","title":"小王子"},{"count":2312,"name":"童话","title":"童话"},{"count":1427,"name":"圣埃克苏佩里","title":"圣埃克苏佩里"},{"count":1078,"name":"法国","title":"法国"},{"count":856,"name":"经典","title":"经典"},{"count":744,"name":"外国文学","title":"外国文学"},{"count":621,"name":"感动","title":"感动"},{"count":474,"name":"寓言","title":"寓言"}]
     * origin_title :
     * image : https://img3.doubanio.com/mpic/s3294754.jpg
     * binding : 平装
     * translator : ["胡雨苏"]
     * catalog : 序言法兰西玫瑰 小王子 圣埃克苏佩里年表
     * pages : 111
     * images : {"small":"https://img3.doubanio.com/spic/s3294754.jpg","large":"https://img3.doubanio.com/lpic/s3294754.jpg","medium":"https://img3.doubanio.com/mpic/s3294754.jpg"}
     * alt : https://book.douban.com/subject/1003078/
     * id : 1003078
     * publisher : 中国友谊出版公司
     * isbn10 : 7505715666
     * isbn13 : 9787505715660
     * title : 小王子
     * url : https://api.douban.com/v2/book/1003078
     * alt_title :
     * author_intro : 圣埃克苏佩里（1900－1944）1900年，尼采逝世。这一年，安德烈・纪德在布鲁塞尔一次会议上宣称：“当今文学土地的面貌可以说是一片沼泽。”1900年，圣埃克苏佩里诞生。净化沼泽的意愿和能力历史地落在这个“世纪儿”的身上，圣埃克苏佩里是尼采式的第二代法国作家，拿但业的儿子，琐罗亚斯德的孙子，这个飞行员受到极大的遗传影响。灾种影响使他在探索、忧虑和英雄主义的道路上走到尽头。如尼采所说：“你应该超截止自己，走得更远，登得更高，直至群星在你脚下。”尼采成为他座舱中想象的伙伴。这个飞越沙漠和海洋的年轻驾驶员同样也遵循着纪德的教诲：“与其过宁静的生活，不如过悲怆的生活。”圣埃克苏佩里在他整个的一生中都在反复思考力量和热诚的真谛。 圣埃克苏佩里（AntoinedeSaiot-Exupery），1900年出生于法国里昂，1921-1923年在法国空军中服役，曾是后备飞行员，后来又成为民用航空驾驶员，参加了开辟法国――非洲――南美国际航线的工作，其间他还从事文学写作，作品有《南线班机》（1930），《夜航》（1931）等等。 1939年德国法西斯入侵法国，鉴于圣埃克苏佩里曾多次受伤，医生认为他不能再入伍参战；但经他坚决要求，参加了抗德战争，被编入2/33空军侦察大队。1940年法国在战争中溃败，他所在的部队损失惨重，该部被调往阿尔及尔，随后即被复员，他只身流亡美国。在美国期间，他继续从事写作，1940年发表了《战斗飞行员》，1943年发表了《给一个人质的信》以及《小王子》。 1943年，在他的强烈要求下，他回到法国在北非的抗战基地阿尔及尔。他的上级考虑到他的身体和年龄状况，只同意他执行五次飞行任务，他却要求到八次，1944年7月31日上午，他出航执行第八次任务，从此再也没有回来，牺牲时，年仅44岁。 在欧洲某地的一个湖中，发现了圣・德克旭贝里的飞机残骸。这次搜索是经过对他最后一次出航的线路和德军当时的空军记录研究以后进行的，经过认证确认是那架失踪了半个世纪的侦察机。为了纪念这位伟大的战士和文学家，当地决定为这架飞机的残骸建立一个博物馆，以他的名字命名，陈列他的作品和遗物。
     * summary :
     * price : 19.8
     */

    private RatingBean rating;
    private String subtitle;
    private String pubdate;
    private String origin_title;
    private String image;
    private String binding;
    private String catalog;
    private String pages;
    private ImagesBean images;
    private String alt;
    private String id;
    private String publisher;
    private String isbn10;
    private String isbn13;
    private String title;
    private String url;
    private String alt_title;
    private String author_intro;
    private String summary;
    private String price;
    private List<String> author;
    private List<TagsBean> tags;
    private List<String> translator;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getOrigin_title() {
        return origin_title;
    }

    public void setOrigin_title(String origin_title) {
        this.origin_title = origin_title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlt_title() {
        return alt_title;
    }

    public void setAlt_title(String alt_title) {
        this.alt_title = alt_title;
    }

    public String getAuthor_intro() {
        return author_intro;
    }

    public void setAuthor_intro(String author_intro) {
        this.author_intro = author_intro;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }

    public List<String> getTranslator() {
        return translator;
    }

    public void setTranslator(List<String> translator) {
        this.translator = translator;
    }

    public static class RatingBean {
        /**
         * max : 10
         * numRaters : 11318
         * average : 9.2
         * min : 0
         */

        private int max;
        private int numRaters;
        private String average;
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public int getNumRaters() {
            return numRaters;
        }

        public void setNumRaters(int numRaters) {
            this.numRaters = numRaters;
        }

        public String getAverage() {
            return average;
        }

        public void setAverage(String average) {
            this.average = average;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }

    public static class ImagesBean {
        /**
         * small : https://img3.doubanio.com/spic/s3294754.jpg
         * large : https://img3.doubanio.com/lpic/s3294754.jpg
         * medium : https://img3.doubanio.com/mpic/s3294754.jpg
         */

        private String small;
        private String large;
        private String medium;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }
    }

    public static class TagsBean {
        /**
         * count : 2924
         * name : 小王子
         * title : 小王子
         */

        private int count;
        private String name;
        private String title;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
