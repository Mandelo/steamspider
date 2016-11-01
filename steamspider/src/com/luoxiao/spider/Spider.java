package com.luoxiao.spider;

/**
 * @author luoxiao
 * @Params gameUrl为steam游戏主页面的url
 */
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.luoxiao.bean.UserBean;
import com.luoxiao.util.Utils;

public class Spider {

	// 得到用户个人资料链接
	public List<String> getUserUrls(String gameUrl) throws IOException {
		org.jsoup.Connection conn = Jsoup.connect(gameUrl);
		String realLink;
		Document doc = conn.get();
		Elements links = doc.select(".persona_name >a");
		List<String> realUrls = new ArrayList<String>();
		for (Element link : links) {
			realLink = link.attr("href");
			realUrls.add(realLink);
		}
		return realUrls;
	}

	// 获取用户资料并存储数据到数据库
	public UserBean getAndSave(String gameUrl) throws IOException,
			SQLException, ClassNotFoundException {
		Connection connection;
		Statement stmt;
		Spider demo = new Spider();
		UserBean bean = new UserBean();
		// gameUrl = "http://store.steampowered.com/app/374320";
		List<String> userUrls = demo.getUserUrls(gameUrl);
		for (String userUrl : userUrls) {
			org.jsoup.Connection conn = Jsoup.connect(userUrl).timeout(4000);
			Document doc = conn.get();
			// 获取昵称
			Elements nickNames = doc.select(".actual_persona_name");
			String nickName = nickNames.text();
			bean.setUsername(nickName);
			// 获取等级
			Elements accountsLv = doc.select(".persona_level");
			Elements level = accountsLv.select("span");
			String accountLv = level.text();
			bean.setAccountLv(accountLv);
			// 获取拥有的游戏数量
			// 解析页面
			Elements gamesCount = doc.select("a[href*=/?tab=all]");
			Elements gameCount = gamesCount.select(".profile_count_link_total");
			// 提取游戏数量
			String ownedGames = gameCount.text();
			// 存入数据库
			bean.setOwned_games(ownedGames);
			String sql = "INSERT INTO STEAM_SPIDER( username,accountLv,owned_games) VALUES ('"
					+ bean.getUsername()
					+ "','"
					+ bean.getAccountLv()
					+ "','"
					+ bean.getOwned_games() + "')";
			connection = new Utils().getConnection();
			stmt = connection.createStatement();
			stmt.execute(sql);
			System.out.println("存入到数据库成功！" + bean);
			stmt.close();
			connection.close();
		}
		return bean;
	}

	// 得到图片URL
	public List<String> getPicRealUrls(String gameUrl) throws IOException {
		org.jsoup.Connection conn = Jsoup.connect(gameUrl);
		String picLink;
		List<String> realPicUrls = new ArrayList<String>();
		Document doc = conn.get();
		gameUrl = "http://store.steampowered.com/app/374320/";
		Elements links = doc.select(".highlight_screenshot_link");
		for (Element link : links) {
			picLink = link.attr("href");
			// 处理URL,去掉前缀得到真实地址
			String realPicLink = picLink.replace(
					"https://steamcommunity.com/linkfilter/?url=", "");
			//添加到图片地址集合
			realPicUrls.add(realPicLink);
		}
		return realPicUrls;
	}

	// 下载游戏图片
	public void downloadPic(String gameUrl) throws IOException {
		Spider spider = new Spider();
		List<String> urls = spider.getPicRealUrls(gameUrl);
		//i为总图片数
		for (int i = 1; i <= urls.size(); i++) {
			String imageUrl = urls.get(i - 1);
			URL url = new URL(imageUrl);
			// 打开网络输入流
			DataInputStream dis = new DataInputStream(url.openStream());
			//自定义保存地址，命名图片
			String newImageName = "W:/steamspider/" + "图片" + i + ".jpg";
			// 建立一个新的文件
			FileOutputStream fos = new FileOutputStream(new File(newImageName));
			byte[] buffer = new byte[8000];
			int length;
			System.out.println("正在下载......第 " + i + "张图片......请稍后");
			// 开始填充数据
			while ((length = dis.read(buffer)) > 0) {
				fos.write(buffer, 0, length);
			}
			dis.close();
			fos.close();
			System.out.println("第 " + i + "张图片下载完毕......");
		}
	}
}
