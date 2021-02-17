package com.itcat.Exams.QuNarCom;

import java.util.*;

class Card {
    private String suit;
    private int num;

    public Card(String suit, String num) {
        super();
        this.suit = suit;

        if(num.equals("J")) {
            this.num = 11;
        } else if(num.equals("Q")) {
            this.num = 12;
        } else if(num.equals("K")) {
            this.num = 13;
        } else if(num.equals("A")) {
            this.num = 14;
        } else {
            this.num = Integer.parseInt(num);
        }
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Card [suit=" + suit + ", num=" + num + "]";
    }
}
public class Main {

    public static void main(String[] args) {
//        int SIZE = 5;

        Scanner sc = new Scanner(System.in);
        String  str = sc.nextLine();
        int SIZE = Integer.parseInt(str);
        List<Card> cards = new ArrayList<Card>();

        String input = sc.nextLine();
        String[] ss = input.split(" ");

        for(int i = 0; i < ss.length; i++) {
//            String suit = ss[2*i];
//            String num = ss[2*i+1];

            String suit = Character.toString(ss[i].charAt(0));
            String num = Character.toString(ss[i].charAt(1));
            System.out.println(suit+" "+num);
            Card card = new Card(suit, num);
            cards.add(card);
        }

        Collections.sort(cards, new Comparator<Card>(){
            public int compare(Card c1, Card c2) {
                if(c1.getNum() < c2.getNum()) {
                    return 1;
                }

                if(c1.getNum() == c2.getNum()) {
                    return 0;
                }

                return -1;
            }
        });

        // 判断牌型
        if(isSF(cards)) { //牌型1
            System.out.println("同一花色顺子");
            System.out.println(1);
        } else if(isST(cards)) {
            System.out.println("四张相同的数字+单张");
            System.out.println(2);
        } else if(isHL(cards)) {
            System.out.println("三张相同的数字+一对");
            System.out.println(3);
        } else if(isSZ(cards)) {
            System.out.println("同一花色");
            System.out.println(4);
        } else if(isTHX(cards)) {
            System.out.println("花色不一样的顺子");
            System.out.println(5);
        } else if(isTH(cards)) {
            System.out.println("三张相同两张单");
            System.out.println(6);
        }else if (isEqual(cards)){
            System.out.println("一对");
            System.out.println(2);
        }else {
            System.out.println(7);
        }

    }

    //  牌型1 同一花色的顺子
    public static boolean isSF(List<Card> cards) {
        String suit = cards.get(0).getSuit();
        int min = cards.get(0).getNum();
        int max = cards.get(0).getNum();


        for(int i = 1; i < cards.size(); i++) {
            // 有花色异常就退出
            if(!suit.equals(cards.get(i).getSuit())){
                return false;
            }

            int num = cards.get(i).getNum();
            if(num > max) {
                max = num;
            } else if(num < min) {
                min = num;
            }
        }

        if((max-min) == 4) {
            return true;
        } else {
            return false;
        }
    }


    // 牌型2 四条 四张相同的数字+单张
    public static boolean isST(List<Card> cards) {
        if(cards.size() >= 4&&cards.get(0).getNum() == cards.get(3).getNum()) {
            return true;
        } else if(cards.size() >= 4&&cards.get(1).getNum() == cards.get(4).getNum()) {
            return true;
        } else {
            return false;
        }
    }

    // 牌型3 葫芦 三张相同的数字+一对
    public static boolean isHL(List<Card> cards) {
        if(cards.size() > 3&&cards.get(0).getNum() == cards.get(2).getNum() && cards.get(3).getNum() == cards.get(4).getNum()) {
            return true;
        } else if(cards.size() > 3&&cards.get(0).getNum() == cards.get(1).getNum() && cards.get(2).getNum() == cards.get(4).getNum()) {
            return true;
        }
        return false;
    }

    //一对
    public static boolean isEqual(List<Card> cards){
        if(cards.size()<=2&&cards.get(0).getNum() == cards.get(1).getNum()){
            return true;
        }
        return false;
    }

    // 牌型4 同一花色
    public static boolean isSZ(List<Card> cards) {
        for(int i = 0; i < cards.size()-1; i++) {
            if(!cards.get(i).getSuit().equals(cards.get(i+1).getSuit())){
                return false;
            }
        }
        return true;
    }

    //牌型5 花色不一样的顺子
    public static boolean isTHX(List<Card> cards) {
        for(int i = 0; i < cards.size()-1; i++) {
            if(cards.get(i).getNum() != cards.get(i+1).getNum()-1) {
                return false;
            }
        }

        return true;
    }

    //牌型6 三张相同两张单
    public static boolean isTH(List<Card> cards) {
        if(cards.size() >= 3&&cards.get(0).getNum() == cards.get(2).getNum() &&
                cards.get(3).getNum() != cards.get(4).getNum() &&
                cards.get(3).getNum() != cards.get(0).getNum() &&
                cards.get(4).getNum() != cards.get(0).getNum()) {
            return true;
        } else if(cards.size() >= 3&&cards.get(1).getNum() == cards.get(3).getNum() &&
                cards.get(0).getNum() != cards.get(4).getNum()&&
                cards.get(0).getNum() != cards.get(1).getNum()&&
                cards.get(4).getNum() != cards.get(4).getNum()) {
            return true;
        } else if(cards.size() >= 3&&cards.get(2).getNum() == cards.get(4).getNum() &&
                cards.get(0).getNum() != cards.get(1).getNum()&&
                cards.get(0).getNum() != cards.get(2).getNum()&&
                cards.get(1).getNum() != cards.get(2).getNum()) {
            return true;
        }

        return false;
    }

}