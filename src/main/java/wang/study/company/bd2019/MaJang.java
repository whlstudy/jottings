package wang.study.company.bd2019;

import java.util.*;

/**
 * 小包最近迷上了一款叫做雀魂的麻将游戏，但是这个游戏规则太复杂，小包玩了几个月了还是输多赢少。
 * 于是生气的小包根据游戏简化了一下规则发明了一种新的麻将，只留下一种花色，并且去除了一些特殊和牌方式（例如七对子等），具体的规则如下：
 *
 * 总共有36张牌，每张牌是1~9。每个数字4张牌。
 * 你手里有其中的14张牌，如果这14张牌满足如下条件，即算作和牌
 * 14张牌中有2张相同数字的牌，称为雀头。
 * 除去上述2张牌，剩下12张牌可以组成4个顺子或刻子。顺子的意思是递增的连续3个数字牌（例如234,567等），刻子的意思是相同数字的3个数字牌（例如111,777）
 *
 * 例如：
 * 1 1 1 2 2 2 6 6 6 7 7 7 9 9 可以组成1,2,6,7的4个刻子和9的雀头，可以和牌
 * 1 1 1 1 2 2 3 3 5 6 7 7 8 9 用1做雀头，组123,123,567,789的四个顺子，可以和牌
 * 1 1 1 2 2 2 3 3 3 5 6 7 7 9 无论用1 2 3 7哪个做雀头，都无法组成和牌的条件。
 *
 * 现在，小包从36张牌中抽取了13张牌，他想知道在剩下的23张牌中，再取一张牌，取到哪几种数字牌可以和牌。
 *
 * 输入描述:
 * 输入只有一行，包含13个数字，用空格分隔，每个数字在1~9之间，数据保证同种数字最多出现4次。
 *
 * 输出描述:
 * 输出同样是一行，包含1个或以上的数字。代表他再取到哪些牌可以和牌。若满足条件的有多种牌，请按从小到大的顺序输出。若没有满足条件的牌，请输出一个数字0
 */
public class MaJang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for(int i = 0;i < 13;i++){
            int tmp = sc.nextInt();
            arr[tmp]++;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        for(int i = 1;i <= 9;i++){
            arr[i]++;
            if(isHu(arr)){
                ret.add(i);
            }
        }
        if(ret.size() == 0){
            ret.add(0);
        }

        for(Integer tmp: arr){
            System.out.print(tmp);
            System.out.print(" ");
        }
    }

    private static boolean isHu(int[] arr) {
        return true;
    }
}