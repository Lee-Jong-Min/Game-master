package Game.thread;

import Game.Game_Character.*;
import java.util.Scanner;

public class SubHeroAttackThread extends Thread{
    public int Character_type;
    public int Enemy_type;
    public Hero hero;
    public Sub_hero subhero1;
    public Sub_hero subhero2;
    public Sub_hero subhero3;
    public Enemy lowboss;
    public Enemy midboss;
    public Enemy highboss;
    public Turn turn;
    public boolean stop;

    public SubHeroAttackThread(int Character_type,
                               int Enemy_type,
                               Hero hero,
                               Sub_hero subhero1,
                               Sub_hero subhero2,
                               Sub_hero subhero3,
                               Enemy lowboss,
                               Enemy midboss,
                               Enemy highboss,
                               Turn turn,
                               boolean stop){
        this.Character_type = Character_type;
        this.Enemy_type = Enemy_type;
        this.hero = hero;
        this.subhero1 = subhero1;
        this.subhero2 = subhero2;
        this.subhero3 = subhero3;
        this.lowboss = lowboss;
        this.midboss = midboss;
        this.highboss = highboss;
        this.turn = turn;
        this.stop = stop;
    }

    public void attacktarget(){
        while(stop){
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            while (true) {
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (turn.a % 8 == 3 || turn.a % 8 == 5 || turn.a % 8 == 7) {
                    break;
                }
            }

            if(Enemy_type == 1){ // 듀라한과 싸울때
                Scanner scanner = new Scanner(System.in);
                if(turn.a % 8 == 3 && Character_type == 1){ // 제로가 싸울때
                    try{
                        if(subhero1.Hp > 0 && lowboss.Hp > 0){
                            System.out.println("제로의 차례입니다.");
                            Thread.sleep(1000);
                            System.out.println("1. 공격 2. 스킬 3. 특수스킬");
                            Thread.sleep(1000);
                            int atk_choice = scanner.nextInt();
                            if(atk_choice == 1){ // 기본공격
                                System.out.println("<" + subhero1.name + "의 공격!>");
                                Thread.sleep(1000);
                                subhero1.attack(lowboss);
                                Thread.sleep(1000);
                                if(lowboss.Hp <= 0){
                                    lowboss.Hp = 0;
                                    Thread.sleep(1000);
                                    System.out.println(lowboss.name + "의 Hp : " + lowboss.Hp + " / " + lowboss.maxHp);
                                    stop = false;
                                } else{
                                    System.out.println(lowboss.name + "의 Hp : " + lowboss.Hp + " / " + lowboss.maxHp);
                                    Thread.sleep(1000);
                                    System.out.println("=======================================");
                                    System.out.println();
                                }
                                turn.a += 1;
                            } else if(atk_choice == 2){ // 스킬사용
                                System.out.println("스킬을 사용할 대상을 고르세요.");
                                Thread.sleep(1000);
                                System.out.println("1.이상준 2.제로 3.마리 4.그랑디엘");
                                Thread.sleep(1000);
                                int character_choice = scanner.nextInt();
                                System.out.println("<적의 공격은 제가 방어하겠습니다. 매직 디펜스!!!>");
                                Thread.sleep(1000);
                                switch(character_choice){
                                    case 1:
                                        subhero1.skill(hero);
                                        System.out.println(hero.name + "의 물리방어력과 마법방어력이 100 증가했습니다.");
                                        Thread.sleep(1000);
                                        break;
                                    case 2:
                                        subhero1.skill(subhero1);
                                        System.out.println(subhero1.name + "의 물리방어력과 마법방어력이 100 증가했습니다.");
                                        Thread.sleep(1000);
                                        break;
                                    case 3:
                                        subhero1.skill(subhero2);
                                        System.out.println(subhero2.name + "의 물리방어력과 마법방어력이 100 증가했습니다.");
                                        Thread.sleep(1000);
                                        break;
                                    case 4:
                                        subhero1.skill(subhero3);
                                        System.out.println(subhero3.name + "의 물리방어력과 마법방어력이 100 증가했습니다.");
                                        Thread.sleep(1000);
                                        break;
                                }
                                System.out.println("Mp를 30 사용하였습니다.");
                                Thread.sleep(1000);
                                System.out.println(subhero1.name + "남은 Mp : " + subhero1.Mp + " / " + subhero1.maxMp);
                                Thread.sleep(1000);
                                System.out.println("=======================================");
                                System.out.println();
                                turn.a += 1;
                            } else{ // 특수스킬 사용
                                System.out.println("<모두를 반드시 지켜내겠습니다. 인바인 쉴드!!!>");
                                Thread.sleep(1000);
                                subhero1.Special_Skill(hero, subhero1, subhero2, subhero3, lowboss);
                                System.out.println(hero.name + " " + subhero1.name + " " + subhero2.name + " " + subhero3.name + "에게 2500만큼의 쉴드를 부여했습니다.");
                                Thread.sleep(1000);
                                System.out.println("=======================================");
                                System.out.println();
                                turn.a += 1;
                            }
                        }
                        else{
                            if(subhero1.Hp <= 0){
                                subhero1.Hp = 0;
                            } else if(lowboss.Hp <= 0){
                                lowboss.Hp = 0;
                            }
                            stop = false;
                            break;
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
                else if(turn.a % 8 == 5 && Character_type == 2){ // 마리가 싸울때
                    try{
                        if(subhero2.Hp > 0 && lowboss.Hp > 0){
                            System.out.println("마리의 차례입니다.");
                            Thread.sleep(1000);
                            System.out.println("1. 공격 2. 스킬 3. 특수스킬");
                            Thread.sleep(1000);
                            int atk_choice = scanner.nextInt();
                            if(atk_choice == 1){ // 기본공격
                                System.out.println("<" + subhero2.name + "의 공격!>");
                                Thread.sleep(1000);
                                subhero2.attack(lowboss);
                                if(lowboss.Hp <= 0){
                                    lowboss.Hp = 0;
                                    Thread.sleep(1000);
                                    System.out.println(lowboss.name + "의 Hp : " + lowboss.Hp + " / " + lowboss.maxHp);
                                    stop = false;
                                } else{
                                    System.out.println(lowboss.name + "의 Hp : " + lowboss.Hp + " / " + lowboss.maxHp);
                                    Thread.sleep(1000);
                                    System.out.println("=======================================");
                                    System.out.println();
                                }
                                turn.a += 1;
                            } else if(atk_choice == 2){ // 스킬사용
                                System.out.println("<나의 마법을 받아라 익스플로젼!!!>");
                                Thread.sleep(1000);
                                subhero2.skill(lowboss);
                                System.out.println(lowboss.name + "에게 1500의 데미지를 입혔습니다.");
                                Thread.sleep(1000);
                                if(lowboss.Hp <= 0){
                                    lowboss.Hp = 0;
                                    Thread.sleep(1000);
                                    System.out.println(lowboss.name + "의 Hp : " + lowboss.Hp + " / " + lowboss.maxHp);
                                    stop = false;
                                } else{
                                    System.out.println(lowboss.name + "의 Hp : " + lowboss.Hp + " / " + lowboss.maxHp);
                                    Thread.sleep(1000);
                                }
                                System.out.println("Mp를 25 사용하였습니다.");
                                Thread.sleep(1000);
                                System.out.println(subhero2.name + "남은 Mp : " + subhero2.Mp + " / " + subhero2.maxMp);
                                Thread.sleep(1000);
                                System.out.println("=======================================");
                                System.out.println();
                                turn.a += 1;
                            } else{
                                System.out.println("<이 마법으로 모든걸 불태우겠어 헬파이어!!!>");
                                Thread.sleep(1000);
                                subhero2.Special_Skill(hero, subhero1, subhero2, subhero3, lowboss);
                                Thread.sleep(1000);
                                System.out.println(lowboss.name + "에게 5000의 데미지를 입혔습니다.");
                                Thread.sleep(1000);
                                if(lowboss.Hp <= 0){
                                    lowboss.Hp = 0;
                                    Thread.sleep(1000);
                                    System.out.println(lowboss.name + "의 Hp : " + lowboss.Hp + " / " + lowboss.maxHp);
                                    stop = false;
                                } else{
                                    System.out.println(lowboss.name + "의 Hp : " + lowboss.Hp + " / " + lowboss.maxHp);
                                    Thread.sleep(1000);
                                    System.out.println("=======================================");
                                    System.out.println();
                                }
                                turn.a += 1;
                            }
                        }
                        else{
                            if(subhero2.Hp <= 0){
                                subhero2.Hp = 0;
                            } else if(lowboss.Hp <= 0){
                                lowboss.Hp = 0;
                            }
                            stop = false;
                            break;
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
                else if(turn.a % 8 == 7 && Character_type == 3){ // 그랑디엘이 싸울때
                    try{
                        if(subhero3.Hp > 0 && lowboss.Hp > 0){
                            System.out.println("그랑디엘의  차례입니다.");
                            System.out.println("1. 공격 2. 스킬 3. 특수스킬");
                            int atk_choice = scanner.nextInt();
                            if(atk_choice == 1) { // 기본공격
                                System.out.println("<" + subhero3.name + "의 공격!>");
                                subhero3.attack(lowboss);
                                if(lowboss.Hp <= 0){
                                    lowboss.Hp = 0;
                                    Thread.sleep(1000);
                                    System.out.println(lowboss.name + "의 Hp : " + lowboss.Hp + " / " + lowboss.maxHp);
                                    stop = false;
                                } else{
                                    System.out.println(lowboss.name + "의 Hp : " + lowboss.Hp + " / " + lowboss.maxHp);
                                    Thread.sleep(1000);
                                    System.out.println("=======================================");
                                    System.out.println();
                                }
                                turn.a += 1;
                            }
                            else if(atk_choice == 2){
                                System.out.println("스킬을 사용할 대상을 고르세요.");
                                System.out.println("1.이상준 2.제로 3.마리 4.그랑디엘");
                                int character_choice = scanner.nextInt();
                                System.out.println("제가 당신의 상처를 치료해 드리죠 블래스!!!");
                                switch(character_choice){
                                    case 1:
                                        subhero3.skill(hero);
                                        System.out.println(hero.name + "의 체력을 1500 회복시켰습니다.");
                                        if(hero.Hp >= hero.maxHp){
                                            hero.Hp = hero.maxHp;
                                            System.out.println(hero.name + " 의 남은 Hp : " + hero.Hp + " / " + hero.maxHp);
                                        } else{
                                            System.out.println(hero.name + " 의 남은 Hp : " + hero.Hp + " / " + hero.maxHp);
                                        }
                                        break;
                                    case 2:
                                        subhero3.skill(subhero1);
                                        System.out.println(subhero1.name + "의 체력을 1500 회복시켰습니다.");
                                        if(subhero1.Hp >= subhero1.maxHp){
                                            subhero1.Hp = subhero1.maxHp;
                                            System.out.println(subhero1.name + " 의 남은 Hp : " + subhero1.Hp + " / " + subhero1.maxHp);
                                        } else{
                                            System.out.println(subhero1.name + " 의 남은 Hp : " + subhero1.Hp + " / " + subhero1.maxHp);
                                        }
                                        break;
                                    case 3:
                                        subhero3.skill(subhero2);
                                        System.out.println(subhero2.name + "의 체력을 1500 회복시켰습니다.");
                                        if(subhero2.Hp >= subhero2.maxHp){
                                            subhero2.Hp = subhero2.maxHp;
                                            System.out.println(subhero2.name + " 의 남은 Hp : " + subhero2.Hp + " / " + subhero2.maxHp);
                                        } else{
                                            System.out.println(subhero2.name + " 의 남은 Hp : " + subhero2.Hp + " / " + subhero2.maxHp);
                                        }
                                        break;
                                    case 4:
                                        subhero3.skill(subhero3);
                                        System.out.println(subhero3.name + "의 체력을 1500 회복시켰습니다.");
                                        if(subhero3.Hp >= subhero3.maxHp){
                                            subhero3.Hp = subhero3.maxHp;
                                            System.out.println(subhero3.name + " 의 남은 Hp : " + subhero3.Hp + " / " + subhero3.maxHp);
                                        } else{
                                            System.out.println(subhero3.name + " 의 남은 Hp : " + subhero3.Hp + " / " + subhero3.maxHp);
                                        }
                                        break;
                                }
                                System.out.println("Mp를 30 사용하였습니다.");
                                System.out.println(subhero3.name + "남은 Mp : " + subhero3.Mp + " / " + subhero3.maxMp);
                                System.out.println("=======================================");
                                System.out.println();
                                turn.a += 1;
                            }
                            else{
                                System.out.println("<지금까지 받은 피해 제가 다 회복시켜 드리겠습니다. 베네딕션!!!>");
                                subhero3.Special_Skill(hero, subhero1, subhero2, subhero3, lowboss);
                                System.out.println(hero.name + " " + subhero1.name + " " + subhero2.name + " " + subhero3.name + "의 체력을 5000 회복했습니다.");
                                if(hero.Hp >= hero.maxHp){
                                    hero.Hp = hero.maxHp;
                                    System.out.println(hero.name + " 의 남은 Hp : " + hero.Hp + " / " + hero.maxHp);
                                } else{
                                    System.out.println(hero.name + " 의 남은 Hp : " + hero.Hp + " / " + hero.maxHp);
                                }
                                if(subhero1.Hp >= subhero1.maxHp){
                                    subhero1.Hp = subhero1.maxHp;
                                    System.out.println(subhero1.name + " 의 남은 Hp : " + subhero1.Hp + " / " + subhero1.maxHp);
                                } else{
                                    System.out.println(subhero1.name + " 의 남은 Hp : " + subhero1.Hp + " / " + subhero1.maxHp);
                                }
                                if(subhero2.Hp >= subhero2.maxHp){
                                    subhero2.Hp = subhero2.maxHp;
                                    System.out.println(subhero2.name + " 의 남은 Hp : " + subhero2.Hp + " / " + subhero2.maxHp);
                                } else{
                                    System.out.println(subhero2.name + " 의 남은 Hp : " + subhero2.Hp + " / " + subhero2.maxHp);
                                }
                                if(subhero3.Hp >= subhero3.maxHp){
                                    subhero3.Hp = subhero3.maxHp;
                                    System.out.println(subhero3.name + " 의 남은 Hp : " + subhero3.Hp + " / " + subhero3.maxHp);
                                } else{
                                    System.out.println(subhero3.name + " 의 남은 Hp : " + subhero3.Hp + " / " + subhero3.maxHp);
                                }
                                System.out.println("=======================================");
                                System.out.println();
                                turn.a += 1;
                            }
                        } else{
                            if(subhero3.Hp <= 0){
                                subhero3.Hp = 0;
                            } else if(lowboss.Hp <= 0){
                                lowboss.Hp = 0;
                            }
                            stop = false;
                            break;
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run(){
        try{
            attacktarget();
        }catch(Exception e){

        }
    }
}