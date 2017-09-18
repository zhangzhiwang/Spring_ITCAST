package com.asiainfo.proxy.practice;

import org.springframework.stereotype.Component;

/**
 * 渠道Dao实现类
 *
 * @author zhangzhiwang
 * @date 2017年7月12日 下午9:23:00
 */
@Component
public class ChannelDaoImpl implements IChannelDao {

	public void save() {
		System.out.println("保存渠道入库");
	}

}
