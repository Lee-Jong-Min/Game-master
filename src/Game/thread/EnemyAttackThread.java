package Game.thread;

import Game.Game_Character.*;
import java.util.Random;

public class EnemyAttackThread extends Thread{
    public int Enemy_type;
    public Hero hero;
    public Sub_hero subhero1;
    public Sub_hero subhero2;
    public Sub_hero subhero3;
    public Enemy lowboss;
    public Enemy midboss;
    public Enemy highboss;
    public boolean stop;
    public Turn turn;

    public EnemyAttackThread(int Enemy_type,
                             Hero hero,
                             Sub_hero subhero1,
                             Sub_hero subhero2,
                             Sub_hero subhero3,
                             Enemy lowboss,
                             Enemy midboss,
                             Enemy highboss,
                             boolean stop, Turn turn) {
        this.Enemy_type = Enemy_type;
        this.hero = hero;
        this.subhero1 = subhero1;
        this.subhero2 = subhero2;
        this.subhero3 = subhero3;
        this.lowboss = lowboss;
        this.midboss = midboss;
        this.highboss = highboss;
        this.stop = stop;
        this.turn = turn;
    }
    public void Enemy_attack(){
        while(stop){ // 적의 공격
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            while(true){
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(turn.a % 8 == 2 || turn.a % 8 == 4 || turn.a % 8 == 6 || turn.a % 8 == 0){
                    break;
                }
            }

            Random random = new Random();
            int choose_behavior = random.nextInt(2);
            int choose_person = random.nextInt(4);

            if(Enemy_type == 1) {
                    try{
                        if (hero.Hp > 0 && lowboss.Hp > 0) { // 주인공과 듀라한의 체력이 0보다 클때 실행
                            System.out.println("듀라한의 차례입니다.");
                            Thread.sleep(1000);
                            if (turn.a % 8 != 0 && choose_behavior == 0) { // 듀라한의 일반공격
                                System.out.println("듀라한 : 나의 공격을 막을 수 있을까? 크하하하하");
                                Thread.sleep(1000);
                                if (choose_person == 0) { // 주인공한테 공격
                                    System.out.println("듀라한이 " + hero.name + "에게 공격을 실행합니다.");
                                    Thread.sleep(1000);
                                    lowboss.attack(hero);
                                    if (hero.Hp > 0) {
                                        System.out.println(hero.name + "의 남은 Hp : " + hero.Hp + " / " + hero.maxHp);
                                        System.out.println("=======================================");
                                        System.out.println();
                                    } else {
                                        hero.Hp = 0;
                                        System.out.println("듀라한의 공격으로 이상준이 죽었습니다.");
                                        System.out.println("=======================================");
                                        System.out.println();
                                        stop = false;
                                    }
                                }
                                else if (choose_person == 1) { // 제로한테 공격
                                    System.out.println("듀라한이 " + subhero1.name + "에게 공격을 실행합니다.");
                                    Thread.sleep(1000);
                                    if (subhero1.Hp > 0) {
                                        lowboss.attack(subhero1);
                                        if (subhero1.Hp > 0) {
                                            System.out.println(subhero1.name + "의 남은 Hp : " + subhero1.Hp + " / " + subhero1.maxHp);
                                            System.out.println("=======================================");
                                            System.out.println();
                                        } else {
                                            subhero1.Hp = 0;
                                            System.out.println("듀라한의 공격으로 제로가 죽었습니다.");
                                            System.out.println("=======================================");
                                            System.out.println();
                                        }
                                    } else {
                                        System.out.println("듀라한이 제로를 공격하려했지만 제로는 이미 죽었습니다.");
                                        System.out.println("=======================================");
                                        System.out.println();
                                    }
                                }
                                else if (choose_person == 2) { // 마리한테 공격
                                    System.out.println("듀라한이 " + subhero2.name + "에게 공격을 실행합니다.");
                                    Thread.sleep(1000);
                                    if (subhero2.Hp > 0) {
                                        lowboss.attack(subhero2);
                                        if (subhero2.Hp > 0) {
                                            System.out.println(subhero2.name + "의 남은 Hp : " + subhero2.Hp + " / " + subhero2.maxHp);
                                            System.out.println("=======================================");
                                            System.out.println();
                                        } else {
                                            subhero2.Hp = 0;
                                            System.out.println("듀라한의 공격으로 마리가 죽었습니다.");
                                            System.out.println("=======================================");
                                            System.out.println();
                                        }
                                    } else {
                                        System.out.println("듀라한이 마리를 공격하려했지만 마리는 이미 죽었습니다.");
                                        System.out.println("=======================================");
                                        System.out.println();
                                    }
                                }
                                else {
                                    System.out.println("듀라한이 " + subhero3.name + "에게 공격을 실행합니다.");
                                    Thread.sleep(1000);
                                    if (subhero3.Hp > 0) {
                                        lowboss.attack(subhero3);
                                        if (subhero3.Hp > 0) {
                                            System.out.println(subhero3.name + "의 남은 Hp : " + subhero3.Hp + " / " + subhero3.maxHp);
                                            System.out.println("=======================================");
                                            System.out.println();
                                        } else {
                                            subhero3.Hp = 0;
                                            System.out.println("듀라한의 공격으로 그랑디엘이 죽었습니다.");
                                            System.out.println("=======================================");
                                            System.out.println();
                                        }
                                    } else {
                                        System.out.println("듀라한이 그랑디엘을 공격하려했지만 그랑디엘은 이미 죽었습니다.");
                                        System.out.println("=======================================");
                                        System.out.println();
                                    }
                                }
                            }
                            else if (turn.a % 8 != 0 && choose_behavior == 1) { // 듀라한의 스킬공격
                                System.out.println("듀라한 : 아직 살만한가보지? 더 강력한 공격을 퍼부어주지!!!!");
                                Thread.sleep(1000);
                                if (choose_person == 0) {
                                    lowboss.skill(hero);
                                    if (hero.Hp > 0) {
                                        System.out.println(hero.name + "의 남은 Hp : " + hero.Hp + " / " + hero.maxHp);
                                        System.out.println("=======================================");
                                        System.out.println();
                                    } else {
                                        hero.Hp = 0;
                                        System.out.println("듀라한의 공격으로 이상준이 죽었습니다.");
                                        System.out.println("=======================================");
                                        System.out.println();
                                        stop = false;
                                    }
                                } else if (choose_person == 1) { // 제로한테 공격
                                    System.out.println("듀라한이 " + subhero1.name + "에게 강력한 공격을 실행합니다.");
                                    Thread.sleep(1000);
                                    if (subhero1.Hp > 0) {
                                        lowboss.skill(subhero1);
                                        if (subhero1.Hp > 0) {
                                            System.out.println(subhero1.name + "의 남은 Hp : " + subhero1.Hp + " / " + subhero1.maxHp);
                                            System.out.println("=======================================");
                                            System.out.println();
                                        } else {
                                            subhero1.Hp = 0;
                                            System.out.println("듀라한의 공격으로 제로가 죽었습니다.");
                                            System.out.println("=======================================");
                                            System.out.println();
                                        }
                                    } else {
                                        System.out.println("듀라한이 제로를 공격하려했지만 제로는 이미 죽었습니다.");
                                        System.out.println("=======================================");
                                        System.out.println();
                                    }

                                } else if (choose_person == 2) { // 마리한테 공격
                                    System.out.println("듀라한이 " + subhero2.name + "에게 강력한 공격을 실행합니다.");
                                    Thread.sleep(1000);
                                    if (subhero2.Hp > 0) {
                                        lowboss.skill(subhero2);
                                        if (subhero2.Hp > 0) {
                                            System.out.println(subhero2.name + "의 남은 Hp : " + subhero2.Hp + " / " + subhero2.maxHp);
                                            System.out.println("=======================================");
                                            System.out.println();
                                        } else {
                                            subhero2.Hp = 0;
                                            System.out.println("듀라한의 공격으로 마리가 죽었습니다.");
                                            System.out.println("=======================================");
                                            System.out.println();
                                        }
                                    } else {
                                        System.out.println("듀라한이 마리를 공격하려했지만 마리는 이미 죽었습니다.");
                                        System.out.println("=======================================");
                                        System.out.println();
                                    }
                                } else {
                                    System.out.println("듀라한이 " + subhero3.name + "에게 강력한 공격을 실행합니다.");
                                    Thread.sleep(1000);
                                    if (subhero3.Hp > 0) {
                                        lowboss.skill(subhero3);
                                        if (subhero3.Hp > 0) {
                                            System.out.println(subhero3.name + "의 남은 Hp : " + subhero3.Hp + " / " + subhero3.maxHp);
                                            System.out.println("=======================================");
                                            System.out.println();
                                        } else {
                                            subhero3.Hp = 0;
                                            System.out.println("듀라한의 공격으로 그랑디엘이 죽었습니다.");
                                            System.out.println("=======================================");
                                            System.out.println();
                                        }
                                    } else {
                                        System.out.println("듀라한이 그랑디엘을 공격하려했지만 그랑디엘은 이미 죽었습니다.");
                                        System.out.println("=======================================");
                                        System.out.println();
                                    }
                                }
                            }
                            else{ // 적이 4턴마다 특수공격을 사용함
                                System.out.println("듀라한 : 크하하 지금까지의 공격을 버텨내다니 대단하군 하지만 이건 어떨까!!!!!!!");
                                Thread.sleep(1000);
                                lowboss.demonization(hero, subhero1, subhero2, subhero3);
                                System.out.println("=======================================");
                                System.out.println();
                            }
                            turn.a += 1;
                        } else {
                            if (hero.Hp <= 0) {
                                hero.Hp = 0;
                            } else if (lowboss.Hp <= 0) {
                                lowboss.Hp = 0;
                            }
                            stop = false;
                            turn.a += 1;
                            break;
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                    }
            }
            try{
                Thread.sleep(2000);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run(){
        try{
            Enemy_attack();
        }catch(Exception e){

        }
    }
}
