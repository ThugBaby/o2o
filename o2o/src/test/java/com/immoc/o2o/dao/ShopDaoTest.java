package com.immoc.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.immoc.o2o.BaseTest;
import com.immoc.o2o.entity.Area;
import com.immoc.o2o.entity.PersonInfo;
import com.immoc.o2o.entity.Shop;
import com.immoc.o2o.entity.ShopCategory;

public class ShopDaoTest extends BaseTest{

	@Autowired
	private ShopDao shopDao;
	@Test
	@Ignore
	public void testInsertShop()
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
		shop.setShopDesc("test");
		shop.setPhone("test");
		shop.setShopAddr("test");
		shop.setShopImg("test");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("审核中");
		int effectedNum=shopDao.insertShop(shop);
		assertEquals(1,effectedNum);
	}
	
	@Test
	public void testUpdateShop()
	{
		Shop shop=new Shop();

		Area area=new Area();
		ShopCategory shopCategory=new ShopCategory();
		area.setAreaId(5);
		shopCategory.setShopCategoryId(33L);
		shop.setShopId(38L);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("测试店铺更新");
		shop.setShopDesc("test1");
		shop.setPhone("test1");
		shop.setShopAddr("test1");
		shop.setShopImg("test1");
		shop.setLastEditTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("审核中");
		int effectedNum=shopDao.updateShop(shop);
		assertEquals(1,effectedNum);
	}
}
