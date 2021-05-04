package com.wgh.springboot.mapper;

import com.wgh.springboot.bean.Goods;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by wgh on 2021/5/3.
 */
@Mapper
public interface GoodsMapper {
    Goods getGoods(Integer goodsId);
}
