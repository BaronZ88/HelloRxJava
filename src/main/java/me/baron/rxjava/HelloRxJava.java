package me.baron.rxjava;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * <p>GitHub:   <a href="https://github.com/BaronZ88"></p>
 * <p>知乎专栏:  <a href="https://zhuanlan.zhihu.com/baron"></p>
 * <p>个人博客:  <a href="http://www.jianshu.com/users/cfdc52ea3399/latest_articles"></p>
 *
 * @author baronzhang (baron[dot]zhanglei[at]gmail[dot]com)
 *         16/8/17
 */
public class HelloRxJava {


    public static void main(String[] args) {

//        Observable.create(new Observable.OnSubscribe<String>() {
//
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//
//                subscriber.onNext("onNext");
//                subscriber.onCompleted();
//            }
//        }).map(new Func1<String, String>() {
//
//            @Override
//            public String call(String s) {
//                return s +  " -> map1";
//            }
//        }).map(new Func1<String, String>() {
//
//            @Override
//            public String call(String s) {
//                return s +  " -> map2";
//            }
//        }).map(new Func1<String, String>() {
//
//            @Override
//            public String call(String s) {
//                return s +  " -> map3";
//            }
//        }).subscribe(new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//                System.out.println("onCompleted!");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(String s) {
//                System.out.println("Subscriber -> " + s);
//            }
//        });

//        Observable.create(new Observable.OnSubscribe<String>() {
//
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//
//                subscriber.onNext("onNext");
//                subscriber.onCompleted();
//            }
//        }).subscribeOn(Schedulers.io())
//                .observeOn(Schedulers.newThread())
//                .subscribe(new Subscriber<String>() {
//                    @Override
//                    public void onCompleted() {
//                        System.out.println("onCompleted!");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        System.out.println("Subscriber -> " + s);
//                    }
//                });


//        Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                System.out.println("call ThreadId=" + Thread.currentThread().getId());
//                subscriber.onNext("Hello RxJava!");
//                subscriber.onCompleted();
//            }
//        }).subscribeOn(Schedulers.io())
//                .observeOn(Schedulers.newThread())
//                .subscribe(new Subscriber<String>() {
//                    @Override
//                    public void onCompleted() {
//                        System.out.println("onNext ThreadId=" + Thread.currentThread().getId());
//                        System.out.println("completed!");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        System.out.println("onNext ThreadId=" + Thread.currentThread().getId());
//                        System.out.println(s);
//                    }
//                });

        Observable.interval(200, TimeUnit.MILLISECONDS)
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        System.out.println(aLong+"");
                    }
                });

        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
