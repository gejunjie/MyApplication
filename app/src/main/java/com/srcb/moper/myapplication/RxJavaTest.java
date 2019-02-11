package com.srcb.moper.myapplication;

import android.util.Log;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
//RxJava 2 features several base classes you can discover operators on:
//
//io.reactivex.Flowable: 0..N flows, supporting Reactive-Streams and backpressure
//io.reactivex.Observable: 0..N flows, no backpressure,
//io.reactivex.Single: a flow of exactly 1 item or an error,
//io.reactivex.Completable: a flow without items but only a completion or error signal,
//io.reactivex.Maybe: a flow with no items, exactly one item or an error.
/**
 * Created by Gjj on 2018/12/14.
 */
public class RxJavaTest {
    private static final String TAG = "rxjava";
    public static void just(){
        Flowable.just("abc")
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.i(TAG, s);
                    }
                });
    }

    /**
     * Assembly time
     *
     * The preparation of dataflows by applying various intermediate operators happens in the so-called assembly time:
     */
    public static void assembly(){
        Flowable<Integer> flow = Flowable.range(1, 5)
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        integer = integer + integer;
                        return integer;
                    }
                }).filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        if(integer % 3 == 0){
                            Log.i(TAG, integer.toString());
                            return true;
                        }
                        return false;
                    }
                });

    }
}
