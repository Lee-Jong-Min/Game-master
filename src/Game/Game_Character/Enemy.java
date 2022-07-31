package Game.Game_Character;

import java.util.Random;

public class Enemy extends Character{
    public Enemy(String name, int Hp, int maxHp, int Mp, int maxMp, int physical_attack_power, int magical_attack_power, int physical_defense, int magical_defense){
        super(name, Hp, maxHp, Mp, maxMp, physical_attack_power, magical_attack_power, physical_defense, magical_defense);
    }

    @Override
    public void attack(Character target){ // 공격하기
        if(this.name.equals("듀라한")){ // 듀라한은 마법공격을 하는 적
            int damage = this.magical_attack_power - target.magical_defense;
            target.Hp = target.Hp - damage;
            System.out.println(target.name + "에게 " + damage + "만큼의 마법피해를 입혔습니다.");
        }
        else if(this.name.equals("발자크")){ // 발자크는 물리공격을 하는 적
            int damage = this.physical_attack_power - target.physical_defense;
            target.Hp = target.Hp - damage;
            System.out.println(target.name + "에게 " + damage + "만큼의 물리피해를 입혔습니다.");
        }
        else{ // 헤이타로스는 물리공격 or 마법공격을 하는 적
            Random random = new Random();
            int atk_num = random.nextInt(2);
            if(atk_num == 0){
                int damage = this.physical_attack_power - target.physical_defense;
                target.Hp = target.Hp - damage;
                System.out.println(target.name + "에게  " + damage + "만큼의 물리피해를 입혔습니다.");
            }
            else{
                int damage = this.magical_attack_power - target.magical_defense;
                target.Hp = target.Hp - damage;
                System.out.println(target.name + "에게 " + damage + "만큼의 마법피해를 입혔습니다.");
            }
        }
    }

    @Override
    public void skill(Character target){ // 스킬쓰기
        target.Hp = target.Hp - 200;
        System.out.println(target.name + "에게 " + 200 + "만큼의 피해를 입혔습니다.");
        if(this.name.equals("듀라한")){ // 듀라한은 3번의 스킬사용이 가능
            this.Mp = this.Mp - 30;
        }
        else if(this.name.equals("발자크")){ // 발자크는 4번의 스킬사용이 가능
            this.Mp = this.Mp - 25;
        }
        else{ // 헤이타로스는 5번의 스킬사용이 가능
            this.Mp = this.Mp - 20;
        }
    }

    public void demonization(Character target1, Character target2, Character target3, Character target4){ // 5턴에 한번씩 이 스킬을 사용함
        if(this.name.equals("듀라한")){ // 듀라한은 적의 마법방어력을 깎음
            target1.magical_defense = target1.magical_defense - 150;
            target2.magical_defense = target2.magical_defense - 150;
            target3.magical_defense = target3.magical_defense - 150;
            target4.magical_defense = target4.magical_defense - 150;
            System.out.println(target1.name + "," + target2.name + "," + target3.name + "," + target4.name + "의 마법방어력이 150만큼 하락했습니다.");
        }
        else if(this.name.equals("발자크")){ // 발자크는 적의 마법방어력을 깎음
            target1.physical_defense = target1.physical_defense - 200;
            target2.physical_defense = target2.physical_defense - 200;
            target3.physical_defense = target3.physical_defense - 200;
            target4.physical_defense = target4.physical_defense - 200;
            System.out.println(target1.name + "," + target2.name + "," + target3.name + "," + target4.name + "의 물리방어력이 200만큼 하락했습니다.");
        }
        else{ // 헤이타로스는 물리방어력, 마법방어력을 깎음
            target1.physical_defense = target1.physical_defense - 100;
            target2.physical_defense = target2.physical_defense - 100;
            target3.physical_defense = target3.physical_defense - 100;
            target4.physical_defense = target4.physical_defense - 100;
            System.out.println(target1.name + "," + target2.name + "," + target3.name + "," + target4.name + "의 물리방어력이 100만큼 하락했습니다.");

            target1.magical_defense = target1.magical_defense - 100;
            target2.magical_defense = target2.magical_defense - 100;
            target3.magical_defense = target3.magical_defense - 100;
            target4.magical_defense = target4.magical_defense - 100;
            System.out.println(target1.name + "," + target2.name + "," + target3.name + "," + target4.name + "의 마법방어력이 100만큼 하락했습니다.");
        }
    }
}

