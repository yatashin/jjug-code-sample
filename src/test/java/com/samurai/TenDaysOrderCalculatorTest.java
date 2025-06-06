package com.samurai;

import org.junit.jupiter.api.Test;
import static com.google.common.truth.Truth.assertThat;

class TenDaysOrderCalculatorTest {

    @Test
    void dailySplitBy() {
        assertThat(1).isEqualTo(2);
    }
    public void _1月11日旬の数量が109だった場合_13日の日次が19になりそれ以外が18になる() {
    }
    public void _2月21日旬の数量が5だった場合_28日の日次が0になりそれ以外が1になる() {
    }
    public void _1月11日旬の場合_平日の数が6になる() {
    }
    public void _2026年2月21日旬の場合_平日の数が5になる() {
    }
    public void ある旬のデータが渡されたとき_日割りされた日次データを取得できる() {
    }
    // TODO: 複数の旬次から日割りを計算するテストを追加する
    // TODO: すでに日データが入っている場合を考慮する
    // TODO: 平日の数のパターンを追加する
}