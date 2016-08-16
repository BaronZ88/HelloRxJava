package me.baron.rxjava.utils;


import me.baron.rxjava.models.House;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>GitHub:   <a href="https://github.com/BaronZ88"></p>
 * <p>知乎专栏:  <a href="https://zhuanlan.zhihu.com/baron"></p>
 * <p>个人博客:  <a href="http://www.jianshu.com/users/cfdc52ea3399/latest_articles"></p>
 *
 * @author baronzhang (baron[dot]zhanglei[at]gmail[dot]com)
 *         16/8/15
 */
public class DataSimulator {

    public static List<House> getHouses() {

        List<House> houses = new ArrayList<>();
        //House构造函数中的第一个参数为该房源所属小区名，第二个参数为房源描述
        houses.add(new House(65000, 250, "中粮·海景壹号", "中粮海景壹号新出大平层！总价4500W起"));
        houses.add(new House(35000, 65, "竹园新村", "满五唯一，黄金地段"));
        houses.add(new House(32000, 66, "竹园新村", "一楼自带小花园"));
        houses.add(new House(90000, 235, "中粮·海景壹号", "毗邻汤臣一品"));
        houses.add(new House(75000, 350, "中粮·海景壹号", "顶级住宅，给您总统般尊贵体验"));
        houses.add(new House(25000, 78, "竹园新村", "顶层户型，两室一厅"));
        houses.add(new House(85000, 222, "中粮·海景壹号", "南北通透，豪华五房"));

        return houses;
    }
}
