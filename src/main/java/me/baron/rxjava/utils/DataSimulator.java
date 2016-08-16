package me.baron.rxjava.utils;


import me.baron.rxjava.models.Location;
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

    /**
     * 构造一组房源信息
     *
     * @return 房源列表
     */
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

    /**
     * 构造一组小区名
     *
     * @return 小区名称列表
     */
    public static List<String> getCommunityNames() {

        List<String> communityNames = new ArrayList<>();
        communityNames.add("竹园新村");
        communityNames.add("康桥半岛");
        communityNames.add("中粮·海景壹号");
        communityNames.add("浦江名苑");
        communityNames.add("南辉小区");
        return communityNames;
    }

    /**
     * 构造一组经纬度
     *
     * @return 经纬度列表
     */
    public static List<Location> getLocations() {
        List<Location> locations = new ArrayList<>();
        locations.add(new Location(21.827, 23.323));
        locations.add(new Location(11.923, 16.309));
        locations.add(new Location(22.273, 53.623));
        return locations;
    }
}
