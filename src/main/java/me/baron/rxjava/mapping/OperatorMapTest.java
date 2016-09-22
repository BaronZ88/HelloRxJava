package me.baron.rxjava.mapping;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * <p>GitHub:   <a href="https://github.com/BaronZ88"></p>
 * <p>知乎专栏:  <a href="https://zhuanlan.zhihu.com/baron"></p>
 * <p>个人博客:  <a href="http://www.jianshu.com/users/cfdc52ea3399/latest_articles"></p>
 *
 * @author baronzhang (baron[dot]zhanglei[at]gmail[dot]com)
 *         16/8/16
 */
public class OperatorMapTest {

    public static void main(String[] args) {

        Observable.just(1, 2, 3, 4, 5)
                .map(new Func1<Integer, String>() {
                    @Override
                    public String call(Integer i) {
                        return "This is " + i;
                    }
                }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        });


        Observable<Integer> observableA = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                subscriber.onNext(1);
                subscriber.onCompleted();
            }
        });

        Subscriber<String> mSubscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted!");
            }
            @Override
            public void onError(Throwable e) {
                System.out.println(e.getMessage());
            }
            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        };

        Observable<String> observableB =
                observableA.map(new Func1<Integer, String>() {
                        @Override
                        public String call(Integer integer) {
                            return "This is " + integer;
                        }
                    });

        observableB.subscribe(mSubscriber);

        Observable.create(new Observable.OnSubscribe<Integer>() {

            @Override
            public void call(Subscriber<? super Integer> subscriber) {

                subscriber.onNext(1);
                subscriber.onCompleted();
            }
        }).map(new Func1<Integer, String>() {

            @Override
            public String call(Integer integer) {
                return "This is " + integer;
            }
        }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted!");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        });
    }
}
