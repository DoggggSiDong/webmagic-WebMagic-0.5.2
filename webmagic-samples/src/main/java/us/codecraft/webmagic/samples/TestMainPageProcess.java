package us.codecraft.webmagic.samples;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriverService;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.Downloader;
import us.codecraft.webmagic.downloader.selenium.SeleniumDownloader;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable; 
  
public class TestMainPageProcess implements PageProcessor{  
	private Site site = Site.me().setRetryTimes(3).setSleepTime(5000).setTimeOut(10000000);
	private static List<String> urls = new ArrayList<String>();
	private int index = 0;
/*	private static volatile MysqlUtils my;*/
    public static void main(String[] args) {
    	
// TODO Auto-generated method stub  
//selenium系统配置，其中的路径写自己config文件的路径  
//     System.setProperty("selenuim_config", "D:\\jse-workspace\\WebMagicTest\\Study\\src\\main\\java\\Four\\config.ini");   
        //my=new MysqlUtils();
/*        MysqlUtils.connect("10.5.211.144:3306");
        List<Map<String,Object>> res=MysqlUtils.queryForList("select distinct restaurant from user_comment");
        for(Map m:res) {
        	urls.add(m.get("restaurant").toString());
        }
        urls = urls.subList(886, urls.size());
   */
    	Spider.create(new TestMainPageProcess())//
        .addUrl("https://www.qichacha.com/").thread(1)//要爬取的网页  
        .setDownloader(new SeleniumDownloader("D:\\chromedriver\\chromedriver.exe"))
        .run();
        } 	

	@SuppressWarnings("unlikely-arg-type")
	public void process(Page page) {
		page.getHandler().sendKey("//*[@id=\"searchkey\"]", "小米");
		page.getHandler().click("//*[@id=\"V3_Index_S\"]/div/span");
/*		if(page.getUrl().toString().equals("https://www.dianping.com/beijing")) {
			for(String requestText: urls) {
				page.addTargetRequest("https://www.dianping.com/search/keyword/2/0_"+requestText);
			}
		}
		else {
			String restaurant = urls.get(index);
			System.out.println(restaurant);
			String comment_number = page.getHtml().xpath("//*[@id=\"shop-all-list\"]/ul/li[1]/div[2]/div[2]/a[1]/b/text()").get();
			String average_cost= page.getHtml().xpath("//*[@id=\"shop-all-list\"]/ul/li[1]/div[2]/div[2]/a[2]/b/text()").get();
			String type = page.getHtml().xpath("//*[@id=\"shop-all-list\"]/ul/li[1]/div[2]/div[3]/a[1]/span/text()").get();
			String location = page.getHtml().xpath("//*[@id=\"shop-all-list\"]/ul/li[1]/div[2]/div[3]/a[2]/span/text()").get();

			System.out.println(restaurant + " " + comment_number);
			if(comment_number != null && !comment_number.equals("") && average_cost!=null && !average_cost.equals("") && average_cost.contains("￥")) {
				average_cost = average_cost.replace("￥", "");
				MysqlUtils.executeNonQuery("insert into restaurant(restaurant,cost,comment_number,type,location,idx) values('"+restaurant+"',"+average_cost+","+comment_number+",'"+type+"','"+location+"',"+(index+886)+")");

			}
			System.out.println("!");
			index++;			
			}*/
	}

	public Site getSite() {
		// TODO Auto-generated method stub
		return site;
	}

	public static void main1(String args[])  {
		// TODO Auto-generated method stub
//启动爬虫，会阻塞当前线程执行（及n个线程不是同时执行的）  
//      。runAsync();//启动爬虫，当前线程继续执行（及n个线程同时执行） 
	}  
}  
 