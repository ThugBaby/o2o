package com.immoc.o2o.service.impl;

import java.io.File;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.immoc.o2o.dao.ShopDao;
import com.immoc.o2o.dto.ShopExecution;
import com.immoc.o2o.entity.Shop;
import com.immoc.o2o.enums.ShopStateEnum;
import com.immoc.o2o.exceptions.ShopOperationException;
import com.immoc.o2o.service.ShopService;
import com.immoc.o2o.util.ImageUtil;
import com.immoc.o2o.util.PathUtil;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDao shopDao;

	@Override
	@Transactional
	public ShopExecution addShop(Shop shop, File shopImg) {
		// TODO Auto-generated method stub
		// 空值判断
		if (shop == null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		}
		try {
			// 给店铺信息赋初始值
			shop.setEnableStatus(0);
			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());
			int effectedNum = shopDao.insertShop(shop);
			if (effectedNum <= 0) {
				throw new ShopOperationException("店铺创建失败");
			} else {
				if (shopImg != null)
					// 存储图片
					try {
						addShopImg(shop, shopImg);
					} catch (Exception e) {
						throw new ShopOperationException("addShopImg error"
								+ e.getMessage());
					}
				// 更新店铺的图片地址
				effectedNum = shopDao.updateShop(shop);
				if (effectedNum <= 0) {
					throw new ShopOperationException("更新图片地址失败");
				}
			}
		} catch (Exception e) {
			throw new ShopOperationException("addShop error" + e.getMessage());
		}
		return new ShopExecution(ShopStateEnum.CHECK);
	}

	private void addShopImg(Shop shop,File shopImg)
	{
		//获取图片的相对路径
		String dest=PathUtil.getShopImagePath(shop.getShopId());
		//上传图片
		String shopAddr=ImageUtil.generateThumbnails(shopImg, dest);
		shop.setShopImg(shopAddr);
	}
}
