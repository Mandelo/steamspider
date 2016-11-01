package com.luoxiao.main;

/**主方法
 * gameUrl为steam商店页面游戏地址
 */
import java.io.IOException;
import java.sql.SQLException;

import com.luoxiao.spider.Spider;

public class MainMethod {

	public static void main(String[] args) throws IOException,
			ClassNotFoundException, SQLException {
		Spider demo = new Spider();

		String gameUrl = "http://store.steampowered.com/app/374320";
		// 获取并存储用户基本资料
		demo.getAndSave(gameUrl);
		// 下载商店页面的游戏图片
		demo.downloadPic(gameUrl);
	}

}
