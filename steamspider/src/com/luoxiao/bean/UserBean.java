package com.luoxiao.bean;

/**
 * 
 * @author luoxiao
 * @params	用户名 账户等级 拥有的游戏数量
 *
 */

public class UserBean {

	private String username;
	private String accountLv;
	private String owned_games;

	@Override
	public String toString() {
		return "UserBean [ username=" + username + ", accountLv=" + accountLv
				+ ", owned_games=" + owned_games + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAccountLv() {
		return accountLv;
	}

	public void setAccountLv(String accountLv) {
		this.accountLv = accountLv;
	}

	public String getOwned_games() {
		return owned_games;
	}

	public void setOwned_games(String owned_games) {
		this.owned_games = owned_games;
	}

}
