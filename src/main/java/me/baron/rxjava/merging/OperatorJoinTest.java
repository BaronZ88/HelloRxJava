package me.baron.rxjava.merging;

import me.baron.rxjava.models.House;
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
 *         16/8/15
 */
public class OperatorJoinTest {

    public static void main(String[] args) {

        final List<House> houses = DataSimulator.getHouses();

        //用来每秒从houses总取出一套房源并发射出去
        Observable<House> houseSequence =
                Observable.interval(1, TimeUnit.SECONDS)
                        .map(new Func1<Long, House>() {
                            @Override
                            public House call(Long position) {
                                return houses.get(position.intValue());
                            }
                        }).take(houses.size());//这里的take是为了防止houses.get(position.intValue())数组越界

        //用来实现每秒发送一个新的Long型数据
        Observable<Long> tictoc = Observable.interval(1, TimeUnit.SECONDS);

        houseSequence.join(tictoc,
                new Func1<House, Observable<Long>>() {
                    @Override
                    public Observable<Long> call(House house) {
                        return Observable.timer(2, TimeUnit.SECONDS);
                    }
                },
                new Func1<Long, Observable<Long>>() {
                    @Override
                    public Observable<Long> call(Long aLong) {
                        return Observable.timer(0, TimeUnit.SECONDS);
                    }
                },
                new Func2<House, Long, String>() {
                    @Override
                    public String call(House house, Long aLong) {
                        return aLong + "-->" + house.getDesc();
                    }
                }
        ).subscribe(new Observer<String>() {
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
