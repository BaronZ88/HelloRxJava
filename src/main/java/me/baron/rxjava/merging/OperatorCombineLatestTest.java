package me.baron.rxjava.merging;

import me.baron.rxjava.models.Location;
import me.baron.rxjava.utils.DataSimulator;
import rx.Observable;
import rx.Observer;
import rx.functions.Func1;
import rx.functions.Func2;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>GitHub:   <a href="https://github.com/BaronZ88"></p>
 * <p>知乎专栏:  <a href="https://zhuanlan.zhihu.com/baron"></p>
 * <p>个人博客:  <a href="http://www.jianshu.com/users/cfdc52ea3399/latest_articles"></p>
 *
 * @author baronzhang (baron[dot]zhanglei[at]gmail[dot]com)
 *         16/8/16
 */
public class OperatorCombineLatestTest {

    public static void main(String[] args) {

        List<String> communityNames = DataSimulator.getCommunityNames();
        List<Location> locations = DataSimulator.getLocations();

        Observable<String> communityNameSequence = Observable.interval(1, TimeUnit.SECONDS)
                .map(new Func1<Long, String>() {
                    @Override
                    public String call(Long position) {
                        return communityNames.get(position.intValue());
                    }
                }).take(communityNames.size());
        Observable<Location> locationSequence = Observable.interval(1, TimeUnit.SECONDS)
                .map(new Func1<Long, Location>() {
                    @Override
                    public Location call(Long position) {
                        return locations.get(position.intValue());
                    }
                }).take(locations.size());

        Observable.combineLatest(
                communityNameSequence,
                locationSequence,
                new Func2<String, Location, String>() {
                    @Override
                    public String call(String communityName, Location location) {
                        return "小区名:" + communityName + ", 经纬度:" + location.toString();
                    }
                }).subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {
                        System.exit(0);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("Error:" + e.getMessage());
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println(s);
                    }
                });

        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
