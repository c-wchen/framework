package com.wchen.util;


import com.wchen.pojo.Goods;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDUtils {

    // 基于关键字
    public static List<Goods> search(String keyword) throws IOException {
        String url = "https://search.jd.com/Search?keyword=" + keyword;
        return parseJd(url);
    }
    // 分页
    public static List<Goods> search(String keyword, int pageNum) throws IOException {
        String url = "https://search.jd.com/Search?keyword=" + keyword + "&page=" + pageNum;
        return parseJd(url);
    }
    public static List<Goods> parseJd(String url) throws IOException {
        Connection connect = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:5.0) Gecko/20100101 Firefox/5.0")
                .timeout(3000);
        Document document = connect.get();
        Element goodList = document.getElementById("J_goodsList");
        Elements goodsItem = goodList.getElementsByClass("gl-i-wrap");
        List<Goods> container = new ArrayList<>();
        for (Element element : goodsItem) {
            container.add(new Goods(
                    element.getElementsByTag("a").eq(0).attr("title"),
                    element.getElementsByTag("img").eq(0).attr("data-lazy-img")
            ));
        }
        return container;
    }

}
