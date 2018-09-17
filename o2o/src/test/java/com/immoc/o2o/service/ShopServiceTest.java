package com.immoc.o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.immoc.o2o.BaseTest;
import com.immoc.o2o.dto.ShopExecution;
import com.immoc.o2o.entity.Area;
import com.immoc.o2o.entity.PersonInfo;
import com.immoc.o2o.entity.Shop;
import com.immoc.o2o.entity.ShopCategory;
import com.immoc.o2o.enums.ShopStateEnum;

public class ShopServiceTest extends BaseTest{

	@Autowired
	private ShopService shopService;
	@Test
	public void addShop()
	{
		Shop shop=new Shop();
		PersonInfo owner=new PersonInfo();
		Area area=new Area();
		ShopCategory shopCategory=new ShopCategory();
		owner.setUserId(12L);
		area.setAreaId(3);
		shopCategory.setShopCategoryId(33L);
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("测试的店铺");
		shop.setShopDesc("test2");
		shop.setPhone("test2");
		shop.setShopAddr("test2");
		shop.setShopImg("test2");
		shop.setEnableStatus(ShopStateEnum.CHECK.getState());
		shop.setAdvice("审核中");
		File shopImg=new File("D:/test_image/xiao.jpg");
		ShopExecution e=shopService.addShop(shop, shopImg);
		assertEquals(ShopStateEnum.CHECK.getState(),e.getState());
	}
}
