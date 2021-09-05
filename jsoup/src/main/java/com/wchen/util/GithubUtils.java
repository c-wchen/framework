package com.wchen.util;


import com.wchen.pojo.RepoDto;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GithubUtils {
    public static void parse(String kw) throws IOException {


        System.setProperty("webdriver.chrome.driver", "D:\\Software\\browser_driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-headless");
        WebDriver webDriver = new ChromeDriver(options);
        ArrayList<RepoDto> repoDtos = new ArrayList<>(1000);
        for (int i = 1; i < 2; i++) {
            String url =  String.format("https://github.com/search?p=%d&q=%s&type=Repositories",i, kw);
            webDriver.get(url);
            List<WebElement> elements = webDriver.findElements(By.cssSelector(".repo-list .repo-list-item"));
            elements.forEach(item -> {
                String star = item.findElement(By.cssSelector(".mr-3:first-child .Link--muted")).getText();
                if (star.contains("k")) {
                    double floor = Math.floor(Float.parseFloat(star.substring(0, star.length() - 1)) * 1000);
                    star = String.valueOf((long)floor);
                }
                repoDtos.add(new RepoDto(
                        item.findElement(By.cssSelector(".f4 a")).getText(),
                        star,
                        item.findElement(By.cssSelector("mt-n1 > p")).getText(),
                        ""
                ));
            });
        }
        repoDtos.forEach(System.out::println);
    }

}
