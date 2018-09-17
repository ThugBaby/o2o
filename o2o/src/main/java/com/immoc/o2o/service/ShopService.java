package com.immoc.o2o.service;

import java.io.File;

import com.immoc.o2o.dto.ShopExecution;
import com.immoc.o2o.entity.Shop;

public interface ShopService {

	public ShopExecution addShop(Shop shop,File shopImg);
}
