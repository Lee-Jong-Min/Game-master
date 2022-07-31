package Game.Game_Character;

public class Hero extends Character{ // 주인공 클래스
    public String Class; // 직업
    public String weapon; // 사용하는 무기
    public String armor; // 사용하는 방어구
    public int plus_physical_attack_power; // 무기에 따른 추가 물리공격력
    public int plus_magical_attack_power; // 무기에 따른 추가 마법공격력
    public int plus_physical_defense; // 방어구에 따른 추가 물리방어력
    public int plus_magical_defense; // 방어구에 따른 추가 마법방어력
    public int all_physical_attack_power; // 기본 물리공격력 + 추가 물리공격력
    public int all_magical_attack_power; // 기본 마법공격력 + 추가 마법공격력
    public int all_physical_defense; // 기본 물리방어력 + 추가 물리방어력
    public int all_magical_defense; // 기본 마법방어력 + 추가 마법방어력

    public Hero(String name, int Hp, int maxHp, int Mp, int maxMp, int physical_attack_power, int magical_attack_power, int physical_defense,
                int magical_defense, String Class, String weapon, String armor, int plus_physical_attack_power,
                int plus_magical_attack_power, int plus_physical_defense, int plus_magical_defense, int all_physical_attack_power,
                int all_magical_attack_power, int all_physical_defense, int all_magical_defense){
        super(name, Hp, maxHp, Mp, maxMp, physical_attack_power, magical_attack_power, physical_defense, magical_defense);
        this.Class = Class;
        this.weapon = weapon;
        this.armor = armor;
        this.plus_physical_attack_power = plus_physical_attack_power;
        this.plus_magical_attack_power = plus_magical_attack_power;
        this.plus_physical_defense = plus_physical_defense;
        this.plus_magical_defense = plus_magical_defense;
        this.all_physical_attack_power = all_physical_attack_power;
        this.all_magical_attack_power = all_magical_attack_power;
        this.all_physical_defense = all_physical_defense;
        this.all_magical_defense = all_magical_defense;
    }

    @Override
    public void attack(Character target){ // 공격하기
            if(this.Class.equals("전사") || this.Class.equals("헌터")){
                int damage = this.physical_attack_power - target.physical_defense;
                target.Hp = target.Hp - damage;
                System.out.println(target.name + "에게 " + damage + " 만큼의 물리피해를 입혔습니다.");
            }
            else{
                int damage = this.magical_attack_power - target.magical_attack_power;
                target.Hp = target.Hp - damage;
                System.out.println(target.name + "에게 " + damage + " 만큼의 마법피해를 입혔습니다.");
            }
    }

    @Override
    public void skill(Character target){ // 스킬쓰기
            if(this.Class.equals("전사") || this.Class.equals("헌터") || this.Class.equals("마법사")){
                target.Hp = target.Hp - 2500;
                System.out.println(target.name + "에게 " + 2500 + " 만큼의 피해를 입혔습니다.");
                if(this.Class.equals("마법사")){
                    this.Mp = this.Mp - 25;
                }
                else{
                    this.Mp = this.Mp - 30;
                }
            }

    }

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


}

