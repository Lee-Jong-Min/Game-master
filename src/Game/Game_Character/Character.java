package Game.Game_Character;

public class Character {
    public String name; // 캐릭터 이름
    public int Hp; // 체력
    public int maxHp;
    public int Mp; // 마력
    public int maxMp;
    public int physical_attack_power; // 물리공격력
    public int magical_attack_power; // 마법공격력
    public int physical_defense; // 물리방어력
    public int magical_defense; // 마법방어력

    public Character(String name,
                     int Hp,
                     int maxHp,
                     int Mp,
                     int maxMp,
                     int physical_attack_power,
                     int magical_attack_power,
                     int physical_defense,
                     int magical_defense){
        this.name = name;
        this.Hp = Hp;
        this.maxHp = maxHp;
        this.Mp = Mp;
        this.maxMp = maxMp;
        this.physical_attack_power = physical_attack_power;
        this.magical_attack_power = magical_attack_power;
        this.physical_defense = physical_defense;
        this.magical_defense = magical_defense;
    }

    public void attack(Character target){ // 공격하기
        int damage = this.physical_attack_power - target.physical_defense;
    }

    public void skill(Character target){ // 스킬쓰기
        int damage = 2000;
    }
}