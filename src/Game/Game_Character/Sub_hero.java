package Game.Game_Character;

public class Sub_hero extends Hero{
    public Sub_hero(String name, int Hp, int maxHp, int Mp, int maxMp, int physical_attack_power, int magical_attack_power, int physical_defense,
                    int magical_defense, String Class, String weapon, String armor, int plus_physical_attack_power,
                    int plus_magical_attack_power, int plus_physical_defense, int plus_magical_defense, int all_physical_attack_power,
                    int all_magical_attack_power, int all_physical_defense, int all_magical_defense){

        super(name, Hp, maxHp, Mp, maxMp, physical_attack_power, magical_attack_power, physical_defense, magical_defense, Class,
                weapon, armor, plus_physical_attack_power, plus_magical_attack_power, plus_physical_defense,
                plus_magical_defense, all_physical_attack_power, all_magical_attack_power, all_physical_defense, all_magical_defense);
    }

    @Override
    public void attack(Character target){ // 공격하기
        if(this.Class.equals("기사단장")){
            int damage = this.physical_attack_power - target.physical_defense;
            target.Hp = target.Hp - damage;
            System.out.println(target + "에게 " + damage + "만큼의 물리피해를 입혔습니다.");
        } else{
            int damage = this.magical_attack_power - target.magical_attack_power;
            target.Hp = target.Hp - damage;
            System.out.println(target.name + "에게 " + damage + "만큼의 마법피해를 입혔습니다.");
        }
    }

    @Override
    public void skill(Character target){ // 스킬쓰기
        if(this.Class.equals("기사단장")){
            target.physical_defense = target.physical_defense + 100;
            target.magical_defense = target.magical_defense + 100;
            this.Mp = this.Mp - 30;
        } else if(this.Class.equals("마법단장")){
            target.Hp = target.Hp - 1500;
            this.Mp = this.Mp - 25;
        } else {
            target.Hp = target.Hp + 1500;
            this.Mp = this.Mp - 30;
        }
    }

    @Override
    public void Status(){ // 스텟보여주기
        System.out.println("===========================================================================================");
        System.out.println("이름 : " + this.name);
        System.out.println("직업 : " + this.Class);
        System.out.println("무기 : " + this.weapon);
        System.out.println("방어구 : " + this.armor);
        System.out.println("Hp : " + this.Hp);
        System.out.println("Mp : " + this.Mp);
        System.out.println("물리공격력 : " + this.physical_attack_power);
        System.out.println("추가 물리공격력 : " + this.plus_physical_attack_power);
        System.out.println("물리방어력 : " + this.physical_defense);
        System.out.println("추가 물리방어력 : " + this.plus_physical_defense);
        System.out.println("마법공격력 : " + this.magical_attack_power);
        System.out.println("추가 마법공격력 : " + this.plus_magical_attack_power);
        System.out.println("마법방어력 : " + this.magical_defense);
        System.out.println("추가 마법방어력 : " + this.plus_magical_defense);
        System.out.println("총 물리공격력 : " + this.all_physical_attack_power);
        System.out.println("총 물리방어력 : " + this.all_physical_defense);
        System.out.println("총 마법공격력 : " + this.all_magical_attack_power);
        System.out.println("총 마법방어력 : " + this.all_magical_defense);
        System.out.println("===========================================================================================");
    }

    public void Special_Skill(Character target1, Character target2, Character target3, Character target4, Character enemy){ // 전투에서 한번밖에 쓸 수 없는 특수스킬
        if(this.Class.equals("기사단장")){ // 기사단장의 특수스킬 모든 아군한테 쉴드를 씌워줌
            target1.Hp = target1.Hp + 2500;
            target2.Hp = target2.Hp + 2500;
            target3.Hp = target3.Hp + 2500;
            target4.Hp = target4.Hp + 2500;
        }
        else if(this.Class.equals("마법단장")){ // 마법단장의 특수스킬 적한테 치명적 데미지를 입힘
            enemy.Hp = enemy.Hp - 5000;
        }
        if(this.Class.equals("신성단장")){
            target1.Hp = target1.Hp + 5000;
            target2.Hp = target2.Hp + 5000;
            target3.Hp = target3.Hp + 5000;
            target4.Hp = target4.Hp + 5000;
            System.out.println(target1.name + "," + target2.name + "," + target3.name + "," + target4.name + "의 체력을 3000만큼 회복했습니다.");
        }
    }


}
