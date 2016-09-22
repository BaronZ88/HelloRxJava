package me.baron.rxjava.mapping;

import me.baron.rxjava.models.Community;
import me.baron.rxjava.models.House;
import me.baron.rxjava.utils.DataSimulator;
import rx.Observable;
import rx.Observer;
import rx.functions.Func1;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>GitHub:   <a href="https://github.com/BaronZ88"></p>
 * <p>知乎专栏:  <a href="https://zhuanlan.zhihu.com/baron"></p>
 * <p>个人博客:  <a href="http://www.jianshu.com/users/cfdc52ea3399"></p>
 *
 * @author baronzhang (baron[dot]zhanglei[at]gmail[dot]com)
 *         16/8/16
 */
public class OperatorConcatMapTest {

    public static void main(String[] args) {

        List<Community> communities = DataSimulator.getCommunities();
        Observable.from(communities)
                .concatMap(new Func1<Community, Observable<House>>() {
                    @Override
                    public Observable<House> call(Community community) {
                        return Observable.interval(500, TimeUnit.MILLISECONDS)
                                .map(new Func1<Long, House>() {

                                    @Override
                                    public House call(Long position) {
                                        return community.getHouses().get(position.intValue());
                                    }
                                }).take(community.getHouses().size());
                    }
                }).subscribe(new Observer<House>() {
                    @Override
                    public void onCompleted() {
                        System.exit(0);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("Error:"+e.getMessage());
                    }

                    @Override
                    public void onNext(House house) {
                        System.out.println(house.getCommunityName() + " " + "均价:" + house.getPrice());
                    }
                });

        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
