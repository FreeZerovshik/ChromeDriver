package org.example

import io.github.bonigarcia.wdm.WebDriverManager
import org.jsoup.Jsoup
import org.openqa.selenium.chrome.ChromeDriver

class App

fun main(args: Array<String>) {


//    System.setProperty("phantomjs.binary.path", "src/main/resources/drivers/phantomjs.exe");
    System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers");

    //запуск chromedriver в docker
    val wdm = WebDriverManager.chromedriver().browserInDocker()
    val driver = wdm.create()

    // запуск chromedriver на локальной машине
//    WebDriverManager.chromedriver().setup();
//    val driver = ChromeDriver()

    driver.get("https://ohtapark.ru/news")

    val doc = Jsoup.parse(driver.pageSource)
    val items = doc.select(".news__list-item__content")

    items.forEach {
        val  name = it.select(".news__list-item__title").text()
        println(name)
    }


    driver.quit();
    driver.close();

}
