package Game.thread;

import Game.Game_Character.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HeroAttackThread extends Thread{
    public int Enemy_type;
    public Hero hero;
    public Enemy lowboss;
    public Enemy midboss;
    public Enemy highboss;
    public Turn turn;
    public boolean stop;



    public HeroAttackThread(int Enemy_type,
                            Hero hero,
                            Enemy lowboss,
                            Enemy midboss,
                            Enemy highboss,
                            Turn turn,
                            boolean stop){
        this.Enemy_type = Enemy_type;
        this.hero = hero;
        this.lowboss = lowboss;
        this.midboss = midboss;
        this.highboss = highboss;
        this.turn = turn;
        this.stop = stop;

    }

    public void attacktarget() throws IOException {
        while(stop) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while (true) {
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (turn.a % 8 == 1) {
                    break;
                }
            }

            Scanner scanner = new Scanner(System.in);
            if (Enemy_type == 1) { // 듀라한과 싸울 때
                try{
                    if (hero.Hp > 0 && lowboss.Hp > 0) {
                        System.out.println("주인공의 차례입니다.");
                        Thread.sleep(1000);
                        System.out.println("무엇을 하시겠습니까?");
                        Thread.sleep(1000);
                        System.out.println("1.공격하기 2.스킬쓰기");
                        Thread.sleep(1000);
                        int atk_choice = scanner.nextInt();
                        if (atk_choice == 1) {
                            System.out.println("<" + hero.name + "의 공격!>");
                            Thread.sleep(1000);
                            hero.attack(lowboss);
                            Thread.sleep(1000);
                            if(lowboss.Hp <= 0 ){
                                lowboss.Hp = 0;
                                stop = false;
                            }
                            else{
                                System.out.println(lowboss.name + "의 Hp : " + lowboss.Hp + " / " + lowboss.maxHp);
                                Thread.sleep(1000);
                                System.out.println("=======================================");
                                System.out.println();
                                turn.a += 1;
                            }
                        } else {
                            if (hero.Class.equals("전사")) {
                                System.out.println("<나의 검을 받아라 기가 슬레시!!!>");
                                Thread.sleep(1000);
                                hero.skill(lowboss);
                                if(lowboss.Hp <= 0 ){
                                    lowboss.Hp = 0;
                                    Thread.sleep(1000);
                                    System.out.println(lowboss.name + "의 Hp : " + lowboss.Hp + " / " + lowboss.maxHp);
                                    stop = false;
                                }
                                else{
                                    Thread.sleep(1000);
                                    System.out.println(lowboss.name + "의 Hp : " + lowboss.Hp + " / " + lowboss.maxHp);
                                    Thread.sleep(1000);
                                    turn.a += 1;
                                }
                                System.out.println("Mp를 30 사용하였습니다.");
                                Thread.sleep(1000);
                                System.out.println(hero.name + "남은 Mp : " + hero.Mp + " / " + hero.maxMp);
                                Thread.sleep(1000);
                                System.out.println("=======================================");
                                System.out.println();
                            } else if (hero.Class.equals("헌터")) {
                                System.out.println("<내 총은 빗나가지 않지 받아라 킬뎀올!!!>");
                                Thread.sleep(1000);
                                hero.skill(lowboss);
                                if(lowboss.Hp <= 0 ){
                                    lowboss.Hp = 0;
                                    Thread.sleep(1000);
                                    System.out.println(lowboss.name + "의 Hp : " + lowboss.Hp + " / " + lowboss.maxHp);
                                    stop = false;
                                    break;
                                }
                                else{
                                    Thread.sleep(1000);
                                    System.out.println(lowboss.name + "의 Hp : " + lowboss.Hp + " / " + lowboss.maxHp);
                                    Thread.sleep(1000);
                                    turn.a += 1;
                                }
                                System.out.println("Mp를 30 사용하였습니다.");
                                Thread.sleep(1000);
                                System.out.println(hero.name + "남은 Mp : " + hero.Mp + " / " + hero.maxMp);
                                Thread.sleep(1000);
                                System.out.println("=======================================");
                                System.out.println();
                            } else {
                                System.out.println("<불의 정령이여 나에게 힘을 하아아앗 메테오!!!>");
                                Thread.sleep(1000);
                                hero.skill(lowboss);
                                if(lowboss.Hp <= 0 ){
                                    lowboss.Hp = 0;
                                    Thread.sleep(1000);
                                    System.out.println(lowboss.name + "의 Hp : " + lowboss.Hp + " / " + lowboss.maxHp);
                                    stop = false;
                                    break;
                                }
                                else{
                                    Thread.sleep(1000);
                                    System.out.println(lowboss.name + "의 Hp : " + lowboss.Hp + " / " + lowboss.maxHp);
                                    Thread.sleep(1000);
                                    turn.a += 1;
                                }
                                System.out.println("Mp를 30 사용하였습니다.");
                                Thread.sleep(1000);
                                System.out.println(hero.name + "남은 Mp : " + hero.Mp + " / " + hero.maxMp);
                                Thread.sleep(1000);
                                System.out.println("=======================================");
                                System.out.println();
                            }
                        }
                    } else {
                        if (hero.Hp <= 0) {
                            hero.Hp = 0;
                        } else if (lowboss.Hp <= 0) {
                            lowboss.Hp = 0;
                        }
                        stop = false;
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run(){
        try{
            attacktarget(); // 이 메소드가 종료되면 run은 자동종료
        }catch(Exception e){

        }
    }
}


