package Game;

import Game.Game_Character.*;
import Game.thread.*;
import java.util.Scanner;
import java.util.Random;

public class game_main {
    public static void main(String[] args){
        Turn turn = new Turn(1);
        //--------------------------------------------- 캐릭터 객체 생성 ---------------------------------------------
        Hero hero;
        try{
            System.out.println("한여름 밤의 꿈에 오신것을 환영합니다.");
            Thread.sleep(2000);
            System.out.println("당신은 아크 왕국을 침공한 악마를 헤치울 용사로서 다른 차원으로 향하게 됩니다.");
            Thread.sleep(2000);
            System.out.println("게임을 시작하기 전에 플레이하고 싶은 직업을 선택하세요");
            Thread.sleep(2000);
            System.out.println("당신이 플레이할 직업은? : 1. 전사 2. 헌터 3. 마법사");
        }catch(Exception e){
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        int hero_choice = scanner.nextInt();
        try{
            Thread.sleep(2000);
            System.out.println("직업 선택을 완료하셨군요 그럼 지금부터 아크 왕국에서의 여정을 응원하겠습니다.");
            Thread.sleep(2000);
            System.out.println("--------------------------------------------로딩중--------------------------------------------");
            Thread.sleep(2000);
        }catch(Exception e){
            e.printStackTrace();
        }

        for(int i=0; i<60; i++){
            System.out.println();
        }

        if(hero_choice == 1){
            hero = new Hero("이상준", 15000, 15000,200, 200,1000, 0,
                    3000, 1000, "전사", "한손검", "갑옷",
                    1500, 0, 1500, 1000,
                    6500, 0, 4000, 2000);

        }
        else if(hero_choice == 2){
            hero = new Hero("이상준", 15000, 15000,200, 200,6500, 0,
                    2000, 1000, "헌터", "활", "천",
                    2000, 0, 1000, 1000,
                    8500, 0, 3000, 2000);
        }
        else{
            hero = new Hero("이상준", 15000, 15000,200, 200,0, 5000,
                    1000, 2000, "마법사", "지팡이", "로브",
                    0, 2000, 1000, 2000,
                    0, 7000, 2000, 4000);
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Sub_hero zero = new Sub_hero("제로", 4500, 4500,100, 100,3000, 0,
                2000, 1000, "기사단장", "한손검 방패", "갑옷", 2500,
                0, 1500, 1500, 5500, 0,
                3500, 2500);

        Sub_hero mari = new Sub_hero("마리", 4000, 4000,150, 150,0, 3000,
                1000, 1500, "마법단장", "장지팡이", "로브", 0,
                2000, 1000, 1500, 0, 5000,
                2000, 3500);

        Sub_hero grandiel = new Sub_hero("그랑디엘", 4000, 4000,120, 120,0, 2500,
                1500, 1500, "신성단장", "바이블", "로브", 0,
                1500, 1000, 1500, 0, 4000,
                2500, 3000);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Enemy Durahhan = new Enemy("듀라한", 10000, 10000, 100, 100,0, 2500,
                0, 2000);

        Enemy Balzac = new Enemy("발자크", 15000, 15000,100, 100,2500, 0,
                2000, 0);

        Enemy Heitaros = new Enemy("헤이타로스", 20000, 20000,100, 100,3500, 3500,
                2000, 2000);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //---------------------------------------- 주인공 공격 스레드 -------------------------------------------------
        HeroAttackThread heroAttackThread1 = new HeroAttackThread(1, hero, Durahhan, Balzac, Heitaros, turn, true);
        HeroAttackThread heroAttackThread2 = new HeroAttackThread(2, hero, Durahhan, Balzac, Heitaros, turn, true);
        HeroAttackThread heroAttackThread3 = new HeroAttackThread(3, hero, Durahhan, Balzac, Heitaros, turn, true);
        //---------------------------------------- 보조캐릭 공격 스레드 ------------------------------------------------
        SubHeroAttackThread subHeroAttackThread1 = new SubHeroAttackThread(1, 1, hero, zero, mari, grandiel, Durahhan, Balzac, Heitaros, turn, true);
        SubHeroAttackThread subHeroAttackThread2 = new SubHeroAttackThread(1, 2, hero, zero, mari, grandiel, Durahhan, Balzac, Heitaros, turn, true);
        SubHeroAttackThread subHeroAttackThread3 = new SubHeroAttackThread(1, 3, hero, zero, mari, grandiel, Durahhan, Balzac, Heitaros, turn, true);
        SubHeroAttackThread subHeroAttackThread4 = new SubHeroAttackThread(2, 1, hero, zero, mari, grandiel, Durahhan, Balzac, Heitaros, turn, true);
        SubHeroAttackThread subHeroAttackThread5 = new SubHeroAttackThread(2, 2, hero, zero, mari, grandiel, Durahhan, Balzac, Heitaros, turn, true);
        SubHeroAttackThread subHeroAttackThread6 = new SubHeroAttackThread(2, 3, hero, zero, mari, grandiel, Durahhan, Balzac, Heitaros, turn, true);
        SubHeroAttackThread subHeroAttackThread7 = new SubHeroAttackThread(3, 1, hero, zero, mari, grandiel, Durahhan, Balzac, Heitaros, turn, true);
        SubHeroAttackThread subHeroAttackThread8 = new SubHeroAttackThread(3, 2, hero, zero, mari, grandiel, Durahhan, Balzac, Heitaros, turn, true);
        SubHeroAttackThread subHeroAttackThread9 = new SubHeroAttackThread(3, 3, hero, zero, mari, grandiel, Durahhan, Balzac, Heitaros, turn, true);
        //---------------------------------------- 적 공격 스레드 -----------------------------------------------------
        EnemyAttackThread enemyAttackThread1 = new EnemyAttackThread(1, hero, zero, mari, grandiel, Durahhan, Balzac, Heitaros, true, turn);
        EnemyAttackThread enemyAttackThread2 = new EnemyAttackThread(2, hero, zero, mari, grandiel, Durahhan, Balzac, Heitaros, true,turn);
        EnemyAttackThread enemyAttackThread3 = new EnemyAttackThread(3, hero, zero, mari, grandiel, Durahhan, Balzac, Heitaros, true,turn);
        //--------------------------------------메인------------------------------------------------------------------
/*        try{
            System.out.println("??? : ..................요");
            Thread.sleep(3000);
            System.out.println("??? : ...............나세요");
            Thread.sleep(3000);
            System.out.println("??? : 일어나세요!!!!");
            Thread.sleep(3000);
            System.out.println("이상준 : 으앗 깜짝이야... 누... 누구세요?");
            Thread.sleep(3000);
            System.out.println("??? : 저야말로 묻고 싶은 질문이에요 당신은 누구시죠?");
            Thread.sleep(3000);
            System.out.println("이상준 : '뭐야... 내가 먼저 질문했는데 역으로 질문하는건 예의가 아닌거 아니야...?'");
            Thread.sleep(3000);
            System.out.println("이상준 : 전 이상준이라고 해요. 여긴 어디죠? 제가 살던 지구는 아닌거 같은데.....");
            Thread.sleep(3000);
            System.out.println("??? : 이상준... 지구.... 아? 설마 당신이 그 지구에서 온다는 이상준?");
            Thread.sleep(3000);
            System.out.println("이상준 : ??? 저를 아세요 ???");
            Thread.sleep(3000);
            System.out.println("그랑디엘 : 아 제 소개가 늦었군요. 반갑습니다. 저는 아크 왕국의 신성단장 그랑디엘이라고 합니다.");
            Thread.sleep(3000);
            System.out.println("그랑디엘 : 여기는 아크왕국입니다. 지구와는 다른 차원의 세계입니다. 저희 왕국에 악마가 침공해와서 당신이 이곳으로 오게 되었습니다.");
            Thread.sleep(3000);
            System.out.println("이상준 : 네...? 아크왕국이요...? 다른 차원...? 이게 다 무슨 소리에요 전 그냥 평범한 고등학생이라고요!!!");
            Thread.sleep(3000);
            System.out.println("그랑디엘 : 당신이 살던 지구에서 당신은 평범한 고등학생이였을지 모르지만 당신이 있는 이 차원에서는 당신은 아크왕국을 구할 영웅이랍니다.");
            Thread.sleep(3000);
            System.out.println("그랑디엘 : 우선 장소를 옮기죠 여긴 이야기 하기에는 좋은 곳이 아니네요. 왕국으로 갑시다. 폐하께서 당신을 기다리고 있습니다.");
            Thread.sleep(3000);
            System.out.println("이상준 : 와... 왕국이요? 폐하? 뭐야 그게 악 뭐하는거에요 으아아아아악!!!");
            Thread.sleep(3000);
            System.out.println("그랑디엘 : 시간이 없습니다. 실례를 범한것에 대해 양해를 구합니다. 그럼");
            Thread.sleep(3000);
            System.out.println("--------------------------------------------로딩중--------------------------------------------");
            Thread.sleep(3000);
        }catch(Exception e){
            e.printStackTrace();
        }

        for(int i=0; i<60; i++){
            System.out.println();
        }

        try{
            System.out.println("잠시 후 폐하의 알현실");
            Thread.sleep(3000);
            System.out.println("이상준 : '우와 여기가 왕국이야...? 으리으리하네 나도 여기서 살고십다. 어 저기 있는 사람은 누구지?'");
            Thread.sleep(3000);
            System.out.println("그랑디엘 : 신성단장 그랑디엘 폐하를 알현합니다.");
            Thread.sleep(3000);
            System.out.println("이상준 : 폐하...? 저사람이 아크3세 폐하?");
            Thread.sleep(3000);
            System.out.println("그랑디엘 : 폐하한테 예의를 갖추세요 이상준씨!!!");
            Thread.sleep(3000);
            System.out.println("아크3세 : 괜찮네 그랑디엘 저자는 누군가?");
            Thread.sleep(3000);
            System.out.println("그랑디엘 : 지구에서 온 이상준입니다.");
            Thread.sleep(3000);
            System.out.println("아크3세 : 오 저자가 그 이상준이라고? 드디어 우리 왕국에 영웅이 나타난 것인가!!!");
            Thread.sleep(3000);
            System.out.println("이상준 : 아니 전 그냥 평범한 고등학생이라니까요? 왜 자꾸 저한테 영웅이라는 거에요 저 집으로 보내주세요");
            Thread.sleep(3000);
            System.out.println("아크3세 : 이상준이라고 당신은 영웅이 맞네 신의 신탁에 지구에서 이상준이라는 사람이 와서 우리 왕국을 침공한 악마를 물리칠 것이라 했거든");
            Thread.sleep(3000);
            System.out.println("이상준 : 네? 그게 무슨...");
            Thread.sleep(3000);
            System.out.println("그랑디엘 : 사실입니다. 악마가 침공한 다음 얼마 안되어 왕국 근처에 마력장이 발생했는데 그곳에 차원포탈이 열렸습니다. 그곳에 조사를 가보니 당신이 있었고요");
            Thread.sleep(3000);
            System.out.println("이상준 : '뭐야... 그럼 나 진짜 악마 물리치기 위해서 여기 온거야...? X됐다...'");
            Thread.sleep(3000);
            System.out.println("이상준 : 전 악마는 관심없고 집에나 가야겠어요 집으로 보내줘요.");
            Thread.sleep(3000);
            System.out.println("그랑디엘 : 그건 불가능합니다. 저희도 방법이 모릅니다. 당신이 건너온 차원포탈이 다시 열리기를 기도해야해요.");
            Thread.sleep(3000);
            System.out.println("아크3세 : 그랑디엘의 말이 맞네. 악마가 침공한 후 원인모를 차원포탈이 갑자기 열린것이라 우리 왕국에는 차원포탈을 열 수 있는 사람이 없어.");
            System.out.println("아크3세 : 그저 다시 자연적으로 열리길 기다리는 수 밖에");
            Thread.sleep(3000);
            System.out.println("이상준 : 뭐야 그럼 나 진짜 악마랑 싸워야하는 거에요...? 나 죽기 싫어요!!!");
            Thread.sleep(3000);
            System.out.println("그랑디엘 : 악마랑 싸우다 죽나 아무것도 안하다 악마한테 죽나 죽는건 마찬가지일껄요? 싸운다면 악마한테 죽지 않을 가능성이라도 있습니다.");
            Thread.sleep(3000);
            System.out.println("아크3세 : 이상준 부탁하네 우리 왕국을 위해 악마를 무찔러 주게 자네가 우리 왕국이 기댈 마지막 희망이야");
            Thread.sleep(3000);
            System.out.println("이상준 : '악마랑 싸우다 죽나 그냥 죽나 결국 죽는거네.... 그럼 진짜 싸워야하나... 아 진짜 이런거 하기 싫은데... 후....'");
            Thread.sleep(3000);
            System.out.println("이상준 : 어쩔 수 없죠 가만히 있어도 죽는다면 싸우는 수 밖에 그래요 악마 까짓꺼 다 물리쳐 줄게요!!!");
            Thread.sleep(3000);
            System.out.println("아크3세 : 고맙네 정말 고마워... 오늘은 늦었으니 내일 그랑디엘과 만나서 얘기를 마저하게나..");
            Thread.sleep(3000);
            System.out.println("그랑디엘 : 그럼 제가 침실까지 안내하겠습니다. 저를 따라오세요.");
            Thread.sleep(3000);
            System.out.println("--------------------------------------------로딩중--------------------------------------------");
            Thread.sleep(3000);
        }catch(Exception e){
            e.printStackTrace();
        }

        for(int i=0; i<60; i++){
            System.out.println();
        }

        try{
            System.out.println("왕국 내 이상준의 침실");
            Thread.sleep(3000);
            System.out.println("그랑디엘 : 여기가 한동안 당신이 사용하게될 침실입니다. 탁자위에 놓인 버튼을 누르면 제가 응답할겁니다. 물어보고 싶은 것이 있을 때 언제든지 누르세요");
            Thread.sleep(3000);
            System.out.println("그랑디엘 : 오늘은 늦었으니 이만 쉬시고 내일 만나서 얘기합시다.");
            Thread.sleep(3000);
            System.out.println("이상준 : 저...저기 질문 하나만...");
            Thread.sleep(3000);
            System.out.println("그랑디엘 : 그럼 편히 쉬십시오. 끼이이익");
            Thread.sleep(3000);
            System.out.println("이상준 : 아... 결국 못물어봤네... 그나저나 나 진짜 망했네... 악마라니... 내가 잡을 수 있을까...? 하");
            Thread.sleep(3000);
            System.out.println("이상준 : 에이 모르겠다... 내일되면 답이 나오겠지 일단 자자... 피곤해");
            Thread.sleep(3000);
            System.out.println("--------------------------------------------로딩중--------------------------------------------");
            Thread.sleep(3000);
        }catch(Exception e){
            e.printStackTrace();
        }

        for(int i=0; i<60; i++){
            System.out.println();
        }

        try{
            System.out.println("왕국 내 그랑디엘의 집무실");
            Thread.sleep(3000);
            System.out.println("똑똑똑 끼이이익");
            Thread.sleep(3000);
            System.out.println("그랑디엘 : 아 이상준씨 어서와요. 여기가 저의 집무실이랍니다.");
            Thread.sleep(3000);
            System.out.println("마리 : 쟤가 이상준이야? 기대했던것보다 별로네.");
            Thread.sleep(3000);
            System.out.println("제로 : 마리 그러면 못써. 우리 왕국을 지켜줄 영웅인데 예의를 갖춰야지.");
            Thread.sleep(3000);
            System.out.println("이상준 : '뭐야 초면에 반말이네 기분나빠'");
            Thread.sleep(3000);
            System.out.println("이상준 : 그랑디엘 저 두사람은 누구...?");
            Thread.sleep(3000);
            System.out.println("그랑디엘 : 두 사람은 처음보죠? 이쪽은 기사단장 제로 이쪽은 마법단장 마리 저희랑 같이 악마를 물리치러갈 조력자랍니다.");
            Thread.sleep(3000);
            System.out.println("마리 : 안녕 난 아크 왕국의 마법단장 마리 믿음이 썩 가는건 아니지만 잘부탁해");
            Thread.sleep(3000);
            System.out.println("제로 : 난 아크 왕국의 기사단장 제로 잘부탁한다 이상준");
            Thread.sleep(3000);
            System.out.println("이상준 : 이상준이라고 합니다. 잘부탁해요");
            Thread.sleep(3000);
            System.out.println("그랑디엘 : 더 많은 얘기를 나누고 싶지만 우리한테 남은 시간이 얼마 없어요. 바로 적의 전력을 분석해야할꺼 같습니다. 마리 부탁해요");
            Thread.sleep(3000);
            System.out.println("마리 : 얘기를 더 하고 싶지만 시간이 촉박해서 어쩔 수 없네. 그럼 적의 상황을 얘기해 줄게");
            Thread.sleep(3000);
            System.out.println("마리 : 아크 왕국을 침공한 적은 총 셋 듀라한 발자크 헤이타로스 이 셋이야");
            Thread.sleep(3000);
            System.out.println("마리 : 이 셋 중에서 가장 약하다고 판단내려 지는 것은 듀라한 우리가 가장 먼저 잡으러 갈 상대야 우리 왕국에서 가장 가까운 곳에 있기도 하고");
            Thread.sleep(3000);
            System.out.println("제로 : 듀라한을 접했던 사람들의 말에 의하면 듀라한은 마법공격을 사용한다고 해. 마법을 사용하는 만큼 물리공격에 취약하다는 것으로 판단되고");
            Thread.sleep(3000);
            System.out.println("그랑디엘 : 듀라한이라 첫 상대부터 어려운 상대군 하지만 그래도 물리쳐야해 그럼 지금 바로 출발해볼까?");
            Thread.sleep(3000);
            System.out.println("이상준 : 네...? 지금 바로요...? 저 장비도 없는데요?");
            Thread.sleep(3000);
            System.out.println("제로 : 아 맞다 장비를 주는걸 깜박했네 잠시 정비 시간을 가지자고 따라와 이상준 내가 장비를 전달해 줄게. 정비를 마친 후 모이는 것으로 하자");
            Thread.sleep(3000);
            System.out.println("--------------------------------------------로딩중--------------------------------------------");
            Thread.sleep(3000);
        }catch(Exception e){
            e.printStackTrace();
        }

        for(int i=0; i<60; i++){
            System.out.println();
        }

        System.out.println("지금부터 무엇을 할까? 1. 정비한다. 2. 정비를 마친다.");
        int yes = scanner.nextInt();
        if(yes == 1){
            while(true){
                int number;
                System.out.println("1. 이상준 2. 제로 3. 마리 4. 그랑디엘");
                int choose = scanner.nextInt();
                switch(choose){
                    case 1:
                        System.out.println("1. 스텟보기 2. 그만두기");
                        number = scanner.nextInt();
                        if(number == 1){
                            hero.Status();
                            break;
                        }
                        else{
                            break;
                        }
                    case 2:
                        System.out.println("1. 스텟보기 2. 그만두기");
                        number = scanner.nextInt();
                        if(number == 1){
                            zero.Status();
                            break;
                        }
                        else{
                            break;
                        }
                    case 3:
                        System.out.println("1. 스텟보기 2. 그만두기");
                        number = scanner.nextInt();
                        if(number == 1){
                            mari.Status();
                            break;
                        }
                        else{
                            break;
                        }
                    case 4:
                        System.out.println("1. 스텟보기 2. 그만두기");
                        number = scanner.nextInt();
                        if(number == 1){
                            grandiel.Status();
                            break;
                        }
                        else{
                            break;
                        }
                }
                System.out.println("계속해서 정비하겠습니까? 1. 네 아직 부족한것 같습니다. 2. 아니오 이제 싸우러 가겠습니다.");
                yes = scanner.nextInt();
                if(yes == 1){
                    continue;
                }
                else{
                    System.out.println("===========================================================================================");
                    System.out.println("--------------------------------------------이동중--------------------------------------------");
                    break;
                }
            }
        }
        else{
            System.out.println("===========================================================================================");
            System.out.println("--------------------------------------------이동중--------------------------------------------");
        }

        try{
            Thread.sleep(3000);

            for(int i=0; i<60; i++){
                System.out.println();
            }

            System.out.println("아크 왕국의 인근 숲 듀라한의 근거지");
            Thread.sleep(3000);
            System.out.println("이상준 : 여기가 듀라한의 근거지인가? 진짜 으스스하게 생겼군");
            Thread.sleep(3000);
            System.out.println("제로 : 조심하면서 가세요 듀라한이 갑자기 습격할 수 있습니다.");
            Thread.sleep(3000);
            System.out.println("마리 : 그건 걱정 안해도 될꺼 같은데? 앞을봐 누가 있는지");
            Thread.sleep(3000);
            System.out.println("그랑디엘 : 듀라한이군 모두 전투 준비!");
            Thread.sleep(3000);
            System.out.println("듀라한 : 너희가 나를 잡으러 온 용사인지 뭐시기인가? 겁도없이 찾아왔군 모두 여기서 죽여주마");
            Thread.sleep(3000);
            System.out.println(Durahhan.name + "과의 전투가 시작되었습니다.");
            Thread.sleep(3000);
            System.out.println("--------------------------------------------로딩중--------------------------------------------");
            Thread.sleep(3000);
        }catch(Exception e){
            e.printStackTrace();
        }

        for(int i=0; i<60; i++){
            System.out.println();
        }
*/
        loop:
        while(true) {
            while (Durahhan.Hp >= 0) {
                try {
                    heroAttackThread1.start();
                    Thread.sleep(1000);
                    enemyAttackThread1.start();
                    Thread.sleep(1000);
                    subHeroAttackThread1.start();
                    Thread.sleep(1000);
                    subHeroAttackThread4.start();
                    Thread.sleep(1000);
                    subHeroAttackThread7.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    heroAttackThread1.join();
                    enemyAttackThread1.join();
                    subHeroAttackThread1.join();
                    subHeroAttackThread4.join();
                    subHeroAttackThread7.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (Durahhan.Hp <= 0) {
                System.out.println(Durahhan.name + "을 물리쳤다!");
                try {
                    Thread.sleep(1000);
                    break loop;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (hero.Hp <= 0) {
                hero.Hp = hero.maxHp;
                hero.Mp = hero.maxMp;
                zero.Hp = zero.maxHp;
                zero.Mp = zero.maxMp;
                mari.Hp = mari.maxHp;
                mari.Mp = mari.maxMp;
                grandiel.Hp = grandiel.maxHp;
                grandiel.Mp = grandiel.maxMp;
                continue loop;
            }
            System.out.println("끝났다.");
        }

//            try{
//                subHeroAttackThread1.start();
//                Thread.sleep(1000);
//            }catch(Exception e){
//                e.printStackTrace();
//            }
//            try{
//                subHeroAttackThread1.join();
//            }catch(InterruptedException e){
//                e.printStackTrace();
//            }
//            try{
//                subHeroAttackThread4.start();
//                Thread.sleep(1000);
//            }catch(InterruptedException e){
//                e.printStackTrace();
//            }
//            try{
//                subHeroAttackThread4.join();
//            }catch(Exception e){
//                e.printStackTrace();
//            }
//            try{
//                subHeroAttackThread7.start();
//                Thread.sleep(1000);
//            }catch(InterruptedException e){
//                e.printStackTrace();
//            }
//            try{
//                subHeroAttackThread7.join();
//            }catch(Exception e){
//                e.printStackTrace();
//            }
        }


//        System.out.println("우리가 무찔러야하는 적이 듀라한, 발자크, 헤이타로스가 있어. 지금 우리의 실력으로는 듀라한이 적합할꺼 같군" +
//                "누구를 잡으러 갈까? : 1. 정비한다 2. 듀라한 3. 발자크 4. 헤이타로스");

//        if(yes == 2){ // 2번을 누르면 듀라한과의 전투가 벌어짐
//            System.out.println("==================================================");
//            System.out.println("주인공 : 여기가 듀라한의 근거지인가? 진짜 으스스하게 생겼군");
//            System.out.println("제로 : 조심하면서 가세요 듀라한이 갑자기 습격할 수 있습니다.");
//            System.out.println("마리 : 그건 걱정 안해도 될꺼 같은데? 앞을봐 누가 있는지");
//            System.out.println("그랑디엘 : 듀라한이군 모두 전투 준비!");
//            System.out.println("듀라한 : 너희가 나를 잡으러 온 용사인지 뭐시기인가? 겁도없이 찾아왔군 모두 여기서 죽여주마");
//            System.out.println("==================================================");
//            System.out.println("지금부터 전투가 시작됩니다.");
//
//            loop:
//            while(true){
//                int hero_turn = 1; // 아군의 공격 순서 1이면 주인공, 2이면 제로, 3이면 마리, 4이면 그랑디엘의 순서이다.
//                int enemy_turn = 1; // 적의 특수 스킬을 사용하기 위한 카운트 5,10,15,20이 될때마다 특수스킬을 사용
//                int zero_count = 1; // 제로의 특수스킬을 카운트 하기 위함 전투마다 1번씩밖에 사용 못함
//                int mari_count = 1; // 마리의 특수스킬을 카운트 하기 위함 전투마다 1번씩맊에 사용 못함
//                int grandiel_count = 1; // 그랑디엘의 특수스킬을 카운트 하기 위함 전투마다 1번씩밖에 사용 못함
//
//                loop1:
//                while(hero.Hp > 0){
//                    System.out.println("듀라한의 턴입니다.");
//                    if(enemy_turn % 5 == 0) {
//                        Durahhan.demonization(hero, zero, mari, grandiel);
//                        enemy_turn++;
//                        if (hero_turn == 1) {
//                            hero_turn = 2;
//                            if (zero.Hp > 0) {
//                                break;
//                            }
//                        } else if (hero_turn == 2) {
//                            hero_turn = 3;
//                            if (mari.Hp > 0) {
//                                break;
//                            }
//                        } else if (hero_turn == 3) {
//                            hero_turn = 4;
//                            if (grandiel.Hp > 0) {
//                                break;
//                            }
//                        } else {
//                            hero_turn = 1;
//                            if (hero.Hp > 0) {
//                                break;
//                            }
//                        }
//                    }
//                    else{
//                        Random random = new Random();
//                        int choose_behavior = random.nextInt(2);
//                        int choose_person = random.nextInt(4);
//                        if(choose_behavior == 0){ // Durahhan의 기본공격
//                            switch(choose_person){
//                                case 0:
//                                    Durahhan.attack(hero);
//                                    enemy_turn++;
//                                    break;
//                                case 1:
//                                    if(zero.Hp > 0){
//                                        Durahhan.attack(zero);
//                                        enemy_turn++;
//                                        break;
//                                    }
//                                    else{
//                                        System.out.println("듀라한이 제로를 공격하려 했지만 제로는 이미 죽었습니다.");
//                                        enemy_turn++;
//                                        break;
//                                    }
//                                case 2:
//                                    if(mari.Hp > 0){
//                                        Durahhan.attack(mari);
//                                        enemy_turn++;
//                                        break;
//                                    }
//                                    else{
//                                        System.out.println("듀라한이 마리를 공격하려 했지만 마리는 이미 죽었습니다.");
//                                        enemy_turn++;
//                                        break;
//                                    }
//                                case 3:
//                                    if(grandiel.Hp > 0){
//                                        Durahhan.attack(grandiel);
//                                        enemy_turn++;
//                                        break;
//                                    }
//                                    else{
//                                        System.out.println("듀라한이 그랑디엘을 공격하려 했지만 그랑디엘은 이미 죽었습니다.");
//                                        enemy_turn++;
//                                        break;
//                                    }
//                            }
//                            if(hero_turn == 2){
//                                if(zero.Hp > 0){
//                                    continue;
//                                }
//                                else {
//                                    hero_turn++;
//                                    if(mari.Hp > 0){
//                                        continue;
//                                    }
//                                    else{
//                                        hero_turn++;
//                                        if(grandiel.Hp > 0){
//                                            continue;
//                                        }
//                                        else{
//                                            hero_turn++;
//                                        }
//                                    }
//                                }
//                            }
//                            else if(hero_turn == 3){
//                                if(mari.Hp > 0){
//                                    continue;
//                                }
//                                else{
//                                    hero_turn++;
//                                    if(grandiel.Hp > 0){
//                                        continue;
//                                    }
//                                    else{
//                                        hero_turn = 1;
//                                    }
//                                }
//                            }
//                            else if(hero_turn == 4){
//                                if(grandiel.Hp > 0){
//                                    continue;
//                                }
//                                else{
//                                    hero_turn = 1;
//                                }
//                            }
//                        }
//
//                        if(choose_behavior == 1){ // Durahhan의 스킬사용
//                            switch(choose_person){
//                                case 0:
//                                    Durahhan.skill(hero);
//                                    enemy_turn++;
//                                    break;
//                                case 1:
//                                    if(zero.Hp > 0){
//                                        Durahhan.skill(zero);
//                                        enemy_turn++;
//                                        break;
//                                    }
//                                    else{
//                                        System.out.println("듀라한이 제로를 공격하려 했지만 제로는 이미 죽었습니다.");
//                                        enemy_turn++;
//                                        break;
//                                    }
//                                case 2:
//                                    if(mari.Hp > 0){
//                                        Durahhan.skill(mari);
//                                        enemy_turn++;
//                                        break;
//                                    }
//                                    else{
//                                        System.out.println("듀라한이 마리를 공격하려 했지만 마리는 이미 죽었습니다.");
//                                        enemy_turn++;
//                                        break;
//                                    }
//                                case 3:
//                                    if(grandiel.Hp > 0){
//                                        Durahhan.skill(grandiel);
//                                        enemy_turn++;
//                                        break;
//                                    }
//                                    else{
//                                        System.out.println("듀라한이 그랑디엘을 공격하려 했지만 그랑디엘은 이미 죽었습니다.");
//                                        enemy_turn++;
//                                        break;
//                                    }
//                            }
//                            if(hero_turn == 2){
//                                if(zero.Hp > 0){
//                                    continue;
//                                }
//                                else {
//                                    hero_turn++;
//                                    if(mari.Hp > 0){
//                                        continue;
//                                    }
//                                    else{
//                                        hero_turn++;
//                                        if(grandiel.Hp > 0){
//                                            continue;
//                                        }
//                                        else{
//                                            hero_turn++;
//                                        }
//                                    }
//                                }
//                            }
//                            else if(hero_turn == 3){
//                                if(mari.Hp > 0){
//                                    continue;
//                                }
//                                else{
//                                    hero_turn++;
//                                    if(grandiel.Hp > 0){
//                                        continue;
//                                    }
//                                    else{
//                                        hero_turn = 1;
//                                    }
//                                }
//                            }
//                            else if(hero_turn == 4){
//                                if(grandiel.Hp > 0){
//                                    continue;
//                                }
//                                else{
//                                    hero_turn = 1;
//                                }
//                            }
//                        }
//                    }
//
//                    loop2:
//                    while(hero_turn == 1 && Durahhan.Hp > 0){ // 주인공의 공격하는 순서
//                        System.out.println("주인공의 차례입니다.");
//                        System.out.println("1. 공격한다. 2. 스킬을쓴다.");
//                        int attack_or_skill = scanner.nextInt();
//                        if(attack_or_skill == 1) { // 주인공의 기본 공격
//                            hero.attack(Durahhan);
//                            if(Durahhan.Hp <= 0){ // 주인공의 공격으로 적의 체력이 0이되면 전투 종료
//                                System.out.println("축하합니다. 적 듀라한을 물리쳤습니다.!");
//                                break loop;
//                            }
//                            else{ // 그렇지 않으면 hero_turn은 2가되고 적의 턴으로 넘어감
//                                hero_turn = 2;
//                                continue loop1;
//                            }
//                        }
//                        if(attack_or_skill ==2){ // 주인공의 스킬사용
//                            if(hero.Mp >= 30) { // 주인공의 Mp가 30보다 클 경우 스킬사용이 가능
//                                hero.skill(Durahhan);
//                                if (Durahhan.Hp <= 0) { // 주인공의 스킬사용으로 적의 체력이 0이되면 전투 종료
//                                    System.out.println("축하합니다. 적 듀라한을 물리쳤습니다.!");
//                                    break loop;
//                                }
//                                else { // 그렇지 않으면 hero_turn은 2가되고 적의 턴으로 넘어감
//                                    hero_turn = 2;
//                                    continue loop1;
//                                }
//                            }
//                            else{ // 주인공의 Mp가 부족하여 스킬사용이 불가능
//                                System.out.println("주인공의 Mp가 부족하여 스킬을 사용할 수 없습니다.");
//                                continue loop2;
//                            }
//                        }
//                    }
//
//                    loop3:
//                    while(hero_turn == 2 && Durahhan.Hp >0){ // 제로의 공격순서
//                        System.out.println("제로의 턴입니다.");
//                        System.out.println("1. 공격한다. 2. 스킬을쓴다. 3. 특수스킬을 쓴다.");
//                        int attack_or_skill1 = scanner.nextInt();
//                        if(attack_or_skill1 == 1) { // 제로의 기본공격
//                            zero.attack(Durahhan);
//                            if(Durahhan.Hp <= 0){ // 제로의 공격으로 적의 체력이 0이되면 전투종료
//                                System.out.println("축하합니다. 적 듀라한을 물리쳤습니다.!");
//                                break loop;
//                            }
//                            else{ // 그렇지 않으면 hero_turn은 3이되고 적의 턴으로 넘어감
//                                hero_turn = 3;
//                                continue loop1;
//                            }
//                        }
//                        if(attack_or_skill1 ==2) { // 제로의 스킬사용
//                            if (zero.Mp >= 30) { // 제로의 Mp가 30보다 클 경우에 스킬사용이 가능
//                                System.out.println("스킬을 사용할 대상을 고르시오. 1. 이상준 2. 제로 3. 마리 4. 그랑디엘"); // 제로의 스킬은 아군 중 한명의 물리방어력, 마법방어력을 올려주는 것이므로 한명을 선택해야함
//                                int choose_one = scanner.nextInt();
//                                switch (choose_one) {
//                                    case 1:
//                                        zero.skill(hero);
//                                        hero_turn = 2;
//                                        break;
//                                    case 2:
//                                        zero.skill(zero);
//                                        hero_turn = 2;
//                                        break;
//                                    case 3:
//                                        zero.skill(mari);
//                                        hero_turn = 2;
//                                        break;
//                                    case 4:
//                                        zero.skill(grandiel);
//                                        hero_turn = 2;
//                                        break;
//                                }
//                                continue loop1;
//                            }
//                            else { // 제로의 Mp가 부족하여 스킬사용이 불가능
//                                System.out.println("제로의 Mp가 부족하여 스킬을 사용할 수 없습니다.");
//                                continue loop3;
//                            }
//                        }
//                        if(attack_or_skill1 == 3 && zero_count == 1){ // 제로의 특수스킬 사용
//                            zero.Special_Skill(hero, zero, mari, grandiel, Durahhan);
//                            zero_count = 0;
//                            hero_turn = 3;
//                            continue loop1;
//                        }
//                        else{
//                            System.out.println("특수스킬의 사용횟수를 초과하였습니다.");
//                            continue loop3;
//                        }
//                    }
//
//                    loop4:
//                    while(hero_turn == 3 && Durahhan.Hp >0){ // 마리의 공격순서
//                        System.out.println("마리의 턴입니다.");
//                        System.out.println("1. 공격한다. 2. 스킬을쓴다. 3. 특수스킬을 쓴다.");
//                        int attack_or_skill2 = scanner.nextInt();
//                        if(attack_or_skill2 == 1) { // 마리의 기본공격
//                            mari.attack(Durahhan);
//                            if(Durahhan.Hp <= 0){ // 마리의 공격으로 적의 체력이 0이되면 전투종료
//                                System.out.println("축하합니다. 적 듀라한을 물리쳤습니다.!");
//                                break loop;
//                            }
//                            else{ // 그렇지 않으면 hero_turn은 4이되고 적의 턴으로 넘어감
//                                hero_turn = 4;
//                                continue loop1;
//                            }
//                        }
//
//                        if(attack_or_skill2 ==2){ // 마리의 스킬사용
//                            if(mari.Mp >= 30) { // 마리의 Mp가 30보다 클 경우에 스킬사용이 가능
//                                mari.skill(Durahhan);
//                                if(Durahhan.Hp <= 0){ // 마리의 스킬로 Durahhan의 체력이 0보다 작아지면 전투 종료
//                                    System.out.println("축하합니다. 적 듀라한을 물리쳤습니다.!");
//                                    break loop;
//                                }
//                                else{
//                                    hero_turn = 4;
//                                    continue loop1;
//                                }
//                            }
//                        }
//                        else{ // 마리의 Mp가 부족하여 스킬사용이 불가능
//                            System.out.println("마리의 Mp가 부족하여 스킬을 사용할 수 없습니다.");
//                            continue loop4;
//                        }
//
//                        if(attack_or_skill2 == 3 && mari_count == 1){ // 마리의 특수스킬 사용
//                            mari.Special_Skill(hero, zero, mari, grandiel, Durahhan);
//                            mari_count = 0;
//                            if(Durahhan.Hp <= 0){
//                                System.out.println("축하합니다. 적 듀라한을 물리쳤습니다.!");
//                                break loop;
//                            }
//                            else{
//                                hero_turn = 4;
//                                continue loop1;
//                            }
//                        }
//                        else{
//                            System.out.println("특수스킬의 사용횟수를 초과하였습니다.");
//                            continue loop4;
//                        }
//                    }
//
//                    loop5:
//                    while(hero_turn == 4 && Durahhan.Hp >0){ // 그랑디엘의 공격순서
//                        System.out.println("그랑디엘의 턴입니다.");
//                        System.out.println("1. 공격한다. 2. 스킬을쓴다. 3. 특수스킬을 쓴다.");
//                        int attack_or_skill3 = scanner.nextInt();
//                        if(attack_or_skill3 == 1) { // 마리의 기본공격
//                            grandiel.attack(Durahhan);
//                            if(Durahhan.Hp <= 0){ // 그랑디엘의 공격으로 적의 체력이 0이되면 전투종료
//                                System.out.println("축하합니다. 적 듀라한을 물리쳤습니다.!");
//                                break loop;
//                            }
//                            else{ // 그렇지 않으면 hero_turn은 1이되고 적의 턴으로 넘어감
//                                hero_turn = 1;
//                                continue loop1;
//                            }
//                        }
//                        if(attack_or_skill3 == 2){ // 그랑디엘의 스킬사용
//                            if(grandiel.Mp >= 30) { // 그랑디엘의 Mp가 30보다 클 경우에 스킬사용이 가능
//                                System.out.println("스킬을 사용할 대상을 고르시오. 1. 이상준 2. 제로 3. 마리 4. 그랑디엘"); // 그랑디엘의 스킬은 아군 중 한명한테 힐을 해주는 것이기 때문에 한명을 선택
//                                int choose_one = scanner.nextInt();
//                                switch(choose_one){
//                                    case 1:
//                                        grandiel.skill(hero);
//                                        hero_turn = 1;
//                                        break;
//                                    case 2:
//                                        grandiel.skill(zero);
//                                        hero_turn = 1;
//                                        break;
//                                    case 3:
//                                        grandiel.skill(mari);
//                                        hero_turn = 1;
//                                        break;
//                                    case 4:
//                                        grandiel.skill(grandiel);
//                                        hero_turn = 1;
//                                        break;
//                                }
//                                continue loop1;
//                            }
//                        }
//                        else{ // 그랑디엘의 Mp가 부족하여 스킬사용이 불가능
//                            System.out.println("그랑디엘의 Mp가 부족하여 스킬을 사용할 수 없습니다.");
//                            continue loop5;
//                        }
//
//                        if(attack_or_skill3 == 3 && grandiel_count == 1){ // 그랑디엘의 특수스킬 사용
//                            grandiel.Special_Skill(hero, zero, mari, grandiel, Durahhan);
//                            grandiel_count = 0;
//                            continue loop1;
//                        }
//                        else{
//                            System.out.println("특수스킬의 사용횟수를 초과하였습니다.");
//                            continue loop5;
//                        }
//                    }
//
//                }
//            }
//        }
//        System.out.println("주인공 : 듀라한을 물리쳤어. 이제 성으로 돌아가서 조금 쉬자.");
//        System.out.println("제로 : 그래 힘든 전투였어. 침대가 그리운걸");
//        System.out.println("마리 : 마법을 많이 써서 그런지 머리가 다 아파. 빨리가서 쉬고싶다.");
//        System.out.println("그랑디엘 : 모두 전투를 하느라 고생많으셨어요 돌아가서 푹 쉬어요");
//
//        hero.Hp = 15000;
//        hero.Mp = 200;
//        zero.Hp = 4500;
//        zero.Mp = 100;
//        mari.Hp = 4000;
//        mari.Mp = 150;
//        grandiel.Hp = 4000;
//        grandiel.Mp = 120;
//
//        System.out.println("---------------------------휴식 후 ------------------------");
//        System.out.println("이제 충분히 쉰거 같아. 다음 적을 잡으러 갈까?");
//        System.out.println("1. 정비한다 2. 듀라한(토벌완료) 3. 발자크 4. 헤이타로스");
//        yes = scanner.nextInt();
//        while(yes == 1){
//            int number;
//            System.out.println("1. 이상준 2. 제로 3. 마리 4. 그랑디엘");
//            int choose = scanner.nextInt();
//            switch(choose){
//                case 1:
//                    System.out.println("1. 스텟보기 2. 그만두기");
//                    number = scanner.nextInt();
//                    if(number == 1){
//                        hero.Status();
//                        break;
//                    }
//                    else{
//                        break;
//                    }
//                case 2:
//                    System.out.println("1. 스텟보기 2. 그만두기");
//                    number = scanner.nextInt();
//                    if(number == 1){
//                        zero.Status();
//                        break;
//                    }
//                    else{
//                        break;
//                    }
//                case 3:
//                    System.out.println("1. 스텟보기 2. 그만두기");
//                    number = scanner.nextInt();
//                    if(number == 1){
//                        mari.Status();
//                        break;
//                    }
//                    else{
//                        break;
//                    }
//                case 4:
//                    System.out.println("1. 스텟보기 2. 그만두기");
//                    number = scanner.nextInt();
//                    if(number == 1){
//                        grandiel.Status();
//                        break;
//                    }
//                    else{
//                        break;
//                    }
//            }
//            System.out.println("계속해서 정비하겠습니까? 1. 네 아직 부족한것 같습니다. 2. 아니오 이제 싸우러 가겠습니다.");
//            yes = scanner.nextInt();
//            if(yes == 1){
//                continue;
//            }
//            else{
//                break;
//            }
//        }
//        if(yes == 3){ // 3번을 누르면 발자크와의 전투가 벌어짐
//            loop:
//            while(true){
//                System.out.println("지금부터 전투가 시작됩니다.");
//
//                int hero_turn = 1; // 아군의 공격 순서 1이면 주인공, 2이면 제로, 3이면 마리, 4이면 그랑디엘의 순서이다.
//                int enemy_turn = 1; // 적의 특수 스킬을 사용하기 위한 카운트 5,10,15,20이 될때마다 특수스킬을 사용
//                int zero_count = 1; // 제로의 특수스킬을 카운트 하기 위함 전투마다 1번씩밖에 사용 못함
//                int mari_count = 1; // 마리의 특수스킬을 카운트 하기 위함 전투마다 1번씩맊에 사용 못함
//                int grandiel_count = 1; // 그랑디엘의 특수스킬을 카운트 하기 위함 전투마다 1번씩밖에 사용 못함
//
//                loop1:
//                while(hero.Hp > 0){
//                    System.out.println("발자크의 턴입니다.");
//                    if(enemy_turn % 5 == 0) {
//                        Balzac.demonization(hero, zero, mari, grandiel);
//                        enemy_turn++;
//                        if (hero_turn == 1) {
//                            hero_turn = 2;
//                            if (zero.Hp > 0) {
//                                continue;
//                            }
//                        } else if (hero_turn == 2) {
//                            hero_turn = 3;
//                            if (mari.Hp > 0) {
//                                continue;
//                            }
//                        } else if (hero_turn == 3) {
//                            hero_turn = 4;
//                            if (grandiel.Hp > 0) {
//                                continue;
//                            }
//                        } else {
//                            hero_turn = 1;
//                            if (hero.Hp > 0) {
//                                continue;
//                            }
//                        }
//                    }
//                    else{
//                        Random random = new Random();
//                        int choose_behavior = random.nextInt(2);
//                        int choose_person = random.nextInt(4);
//                        if(choose_behavior == 0){ // Balzac의 기본공격
//                            switch(choose_person){
//                                case 0:
//                                    Balzac.attack(hero);
//                                    enemy_turn++;
//                                    break;
//                                case 1:
//                                    if(zero.Hp > 0){
//                                        Balzac.attack(zero);
//                                        enemy_turn++;
//                                        break;
//                                    }
//                                    else{
//                                        System.out.println("발자크가 제로를 공격하려 했지만 제로는 이미 죽었습니다.");
//                                        enemy_turn++;
//                                        break;
//                                    }
//                                case 2:
//                                    if(mari.Hp > 0){
//                                        Balzac.attack(mari);
//                                        enemy_turn++;
//                                        break;
//                                    }
//                                    else{
//                                        System.out.println("발자크가 마리를 공격하려 했지만 마리는 이미 죽었습니다.");
//                                        enemy_turn++;
//                                        break;
//                                    }
//                                case 3:
//                                    if(grandiel.Hp > 0){
//                                        Balzac.attack(grandiel);
//                                        enemy_turn++;
//                                        break;
//                                    }
//                                    else{
//                                        System.out.println("발자크가 그랑디엘을 공격하려 했지만 그랑디엘은 이미 죽었습니다.");
//                                        enemy_turn++;
//                                        break;
//                                    }
//                            }
//                            if(hero_turn == 2){
//                                if(zero.Hp > 0){
//                                    continue;
//                                }
//                                else {
//                                    hero_turn++;
//                                    if(mari.Hp > 0){
//                                        continue;
//                                    }
//                                    else{
//                                        hero_turn++;
//                                        if(grandiel.Hp > 0){
//                                            continue;
//                                        }
//                                        else{
//                                            hero_turn++;
//                                        }
//                                    }
//                                }
//                            }
//                            else if(hero_turn == 3){
//                                if(mari.Hp > 0){
//                                    continue;
//                                }
//                                else{
//                                    hero_turn++;
//                                    if(grandiel.Hp > 0){
//                                        continue;
//                                    }
//                                    else{
//                                        hero_turn = 1;
//                                    }
//                                }
//                            }
//                            else if(hero_turn == 4){
//                                if(grandiel.Hp > 0){
//                                    continue;
//                                }
//                                else{
//                                    hero_turn = 1;
//                                }
//                            }
//                        }
//
//                        if(choose_behavior == 1){ // Balzac의 스킬사용
//                            switch(choose_person){
//                                case 0:
//                                    Balzac.skill(hero);
//                                    enemy_turn++;
//                                    break;
//                                case 1:
//                                    if(zero.Hp > 0){
//                                        Balzac.skill(zero);
//                                        enemy_turn++;
//                                        break;
//                                    }
//                                    else{
//                                        System.out.println("발자크가 제로를 공격하려 했지만 제로는 이미 죽었습니다.");
//                                        enemy_turn++;
//                                        break;
//                                    }
//                                case 2:
//                                    if(mari.Hp > 0){
//                                        Balzac.skill(mari);
//                                        enemy_turn++;
//                                        break;
//                                    }
//                                    else{
//                                        System.out.println("발자크가 마리를 공격하려 했지만 마리는 이미 죽었습니다.");
//                                        enemy_turn++;
//                                        break;
//                                    }
//                                case 3:
//                                    if(grandiel.Hp > 0){
//                                        Balzac.skill(grandiel);
//                                        enemy_turn++;
//                                        break;
//                                    }
//                                    else{
//                                        System.out.println("발자크가 그랑디엘을 공격하려 했지만 그랑디엘은 이미 죽었습니다.");
//                                        enemy_turn++;
//                                        break;
//                                    }
//                            }
//                            if(hero_turn == 2){
//                                if(zero.Hp > 0){
//                                    continue;
//                                }
//                                else {
//                                    hero_turn++;
//                                    if(mari.Hp > 0){
//                                        continue;
//                                    }
//                                    else{
//                                        hero_turn++;
//                                        if(grandiel.Hp > 0){
//                                            continue;
//                                        }
//                                        else{
//                                            hero_turn++;
//                                        }
//                                    }
//                                }
//                            }
//                            else if(hero_turn == 3){
//                                if(mari.Hp > 0){
//                                    continue;
//                                }
//                                else{
//                                    hero_turn++;
//                                    if(grandiel.Hp > 0){
//                                        continue;
//                                    }
//                                    else{
//                                        hero_turn = 1;
//                                    }
//                                }
//                            }
//                            else if(hero_turn == 4){
//                                if(grandiel.Hp > 0){
//                                    continue;
//                                }
//                                else{
//                                    hero_turn = 1;
//                                }
//                            }
//                        }
//                    }
//
//                    loop2:
//                    while(hero_turn == 1 && Balzac.Hp > 0){ // 주인공의 공격하는 순서
//                        System.out.println("주인공의 턴입니다.");
//                        System.out.println("1. 공격한다. 2. 스킬을쓴다.");
//                        int attack_or_skill = scanner.nextInt();
//                        if(attack_or_skill == 1) { // 주인공의 기본 공격
//                            hero.attack(Balzac);
//                            if(Balzac.Hp <= 0){ // 주인공의 공격으로 적의 체력이 0이되면 전투 종료
//                                System.out.println("축하합니다. 적 발자크를 물리쳤습니다.!");
//                                break loop;
//                            }
//                            else{ // 그렇지 않으면 hero_turn은 2가되고 적의 턴으로 넘어감
//                                hero_turn = 2;
//                                continue loop1;
//                            }
//                        }
//                        if(attack_or_skill ==2){ // 주인공의 스킬사용
//                            if(hero.Mp >= 30) { // 주인공의 Mp가 30보다 클 경우 스킬사용이 가능
//                                hero.skill(Balzac);
//                                if (Balzac.Hp <= 0) { // 주인공의 스킬사용으로 적의 체력이 0이되면 전투 종료
//                                    System.out.println("축하합니다. 적 발자크를 물리쳤습니다.!");
//                                    break loop;
//                                }
//                                else { // 그렇지 않으면 hero_turn은 2가되고 적의 턴으로 넘어감
//                                    hero_turn = 2;
//                                    continue loop1;
//                                }
//                            }
//                            else{ // 주인공의 Mp가 부족하여 스킬사용이 불가능
//                                System.out.println("주인공의 Mp가 부족하여 스킬을 사용할 수 없습니다.");
//                                continue loop2;
//                            }
//                        }
//                    }
//
//                    loop3:
//                    while(hero_turn == 2 && Balzac.Hp >0){ // 제로의 공격순서
//                        System.out.println("1. 공격한다. 2. 스킬을쓴다. 3. 특수스킬을 쓴다.");
//                        int attack_or_skill1 = scanner.nextInt();
//                        if(attack_or_skill1 == 1) { // 제로의 기본공격
//                            zero.attack(Durahhan);
//                            if(Balzac.Hp <= 0){ // 제로의 공격으로 적의 체력이 0이되면 전투종료
//                                System.out.println("축하합니다. 적 발자크를 물리쳤습니다.!");
//                                break loop;
//                            }
//                            else{ // 그렇지 않으면 hero_turn은 3이되고 적의 턴으로 넘어감
//                                hero_turn = 3;
//                                continue loop1;
//                            }
//                        }
//                        if(attack_or_skill1 ==2) { // 제로의 스킬사용
//                            if (zero.Mp >= 30) { // 제로의 Mp가 30보다 클 경우에 스킬사용이 가능
//                                System.out.println("스킬을 사용할 대상을 고르시오. 1. 이상준 2. 제로 3. 마리 4. 그랑디엘"); // 제로의 스킬은 아군 중 한명의 물리방어력, 마법방어력을 올려주는 것이므로 한명을 선택해야함
//                                int choose_one = scanner.nextInt();
//                                switch (choose_one) {
//                                    case 1:
//                                        zero.skill(hero);
//                                        hero_turn = 2;
//                                        break;
//                                    case 2:
//                                        zero.skill(zero);
//                                        hero_turn = 2;
//                                        break;
//                                    case 3:
//                                        zero.skill(mari);
//                                        hero_turn = 2;
//                                        break;
//                                    case 4:
//                                        zero.skill(grandiel);
//                                        hero_turn = 2;
//                                        break;
//                                }
//                                continue loop1;
//                            }
//                            else { // 제로의 Mp가 부족하여 스킬사용이 불가능
//                                System.out.println("제로의 Mp가 부족하여 스킬을 사용할 수 없습니다.");
//                                continue loop3;
//                            }
//                        }
//                        if(attack_or_skill1 == 3 && zero_count == 1){ // 제로의 특수스킬 사용
//                            zero.Special_Skill(hero, zero, mari, grandiel, Balzac);
//                            zero_count = 0;
//                            hero_turn = 3;
//                            continue loop1;
//                        }
//                        else{
//                            System.out.println("특수스킬의 사용횟수를 초과하였습니다.");
//                            continue loop3;
//                        }
//                    }
//
//                    loop4:
//                    while(hero_turn == 3 && Balzac.Hp >0){ // 마리의 공격순서
//                        System.out.println("1. 공격한다. 2. 스킬을쓴다. 3. 특수스킬을 쓴다.");
//                        int attack_or_skill2 = scanner.nextInt();
//                        if(attack_or_skill2 == 1) { // 마리의 기본공격
//                            mari.attack(Balzac);
//                            if(Durahhan.Hp <= 0){ // 마리의 공격으로 적의 체력이 0이되면 전투종료
//                                System.out.println("축하합니다. 적 발자크를 물리쳤습니다.!");
//                                break loop;
//                            }
//                            else{ // 그렇지 않으면 hero_turn은 4이되고 적의 턴으로 넘어감
//                                hero_turn = 4;
//                                continue loop1;
//                            }
//                        }
//
//                        if(attack_or_skill2 ==2){ // 마리의 스킬사용
//                            if(mari.Mp >= 30) { // 마리의 Mp가 30보다 클 경우에 스킬사용이 가능
//                                mari.skill(Balzac);
//                                if(Durahhan.Hp <= 0){ // 마리의 스킬로 Balzac의 체력이 0보다 작아지면 전투 종료
//                                    System.out.println("축하합니다. 적 발자크를 물리쳤습니다.!");
//                                    break loop;
//                                }
//                                else{
//                                    hero_turn = 4;
//                                    continue loop1;
//                                }
//                            }
//                        }
//                        else{ // 마리의 Mp가 부족하여 스킬사용이 불가능
//                            System.out.println("마리의 Mp가 부족하여 스킬을 사용할 수 없습니다.");
//                            continue loop4;
//                        }
//
//                        if(attack_or_skill2 == 3 && mari_count == 1){ // 마리의 특수스킬 사용
//                            mari.Special_Skill(hero, zero, mari, grandiel, Balzac);
//                            mari_count = 0;
//                            if(Durahhan.Hp <= 0){
//                                System.out.println("축하합니다. 적 발자크를 물리쳤습니다.!");
//                                break loop;
//                            }
//                            else{
//                                hero_turn = 4;
//                                System.out.println("발자크의 턴입니다.");
//                                continue loop1;
//                            }
//                        }
//                        else{
//                            System.out.println("특수스킬의 사용횟수를 초과하였습니다.");
//                            continue loop4;
//                        }
//                    }
//
//                    loop5:
//                    while(hero_turn == 4 && Balzac.Hp >0){ // 그랑디엘의 공격순서
//                        System.out.println("1. 공격한다. 2. 스킬을쓴다. 3. 특수스킬을 쓴다.");
//                        int attack_or_skill3 = scanner.nextInt();
//                        if(attack_or_skill3 == 1) { // 마리의 기본공격
//                            grandiel.attack(Balzac);
//                            if(Durahhan.Hp <= 0){ // 그랑디엘의 공격으로 적의 체력이 0이되면 전투종료
//                                System.out.println("축하합니다. 적 발자크를 물리쳤습니다.!");
//                                break loop;
//                            }
//                            else{ // 그렇지 않으면 hero_turn은 1이되고 적의 턴으로 넘어감
//                                hero_turn = 1;
//                                continue loop1;
//                            }
//                        }
//                        if(attack_or_skill3 == 2){ // 그랑디엘의 스킬사용
//                            if(grandiel.Mp >= 30) { // 그랑디엘의 Mp가 30보다 클 경우에 스킬사용이 가능
//                                System.out.println("스킬을 사용할 대상을 고르시오. 1. 이상준 2. 제로 3. 마리 4. 그랑디엘"); // 그랑디엘의 스킬은 아군 중 한명한테 힐을 해주는 것이기 때문에 한명을 선택
//                                int choose_one = scanner.nextInt();
//                                switch(choose_one){
//                                    case 1:
//                                        grandiel.skill(hero);
//                                        hero_turn = 1;
//                                        break;
//                                    case 2:
//                                        grandiel.skill(zero);
//                                        hero_turn = 1;
//                                        break;
//                                    case 3:
//                                        grandiel.skill(mari);
//                                        hero_turn = 1;
//                                        break;
//                                    case 4:
//                                        grandiel.skill(grandiel);
//                                        hero_turn = 1;
//                                        break;
//                                }
//                                continue loop1;
//                            }
//                        }
//                        else{ // 그랑디엘의 Mp가 부족하여 스킬사용이 불가능
//                            System.out.println("그랑디엘의 Mp가 부족하여 스킬을 사용할 수 없습니다.");
//                            continue loop5;
//                        }
//
//                        if(attack_or_skill3 == 3 && grandiel_count == 1){ // 그랑디엘의 특수스킬 사용
//                            grandiel.Special_Skill(hero, zero, mari, grandiel, Balzac);
//                            grandiel_count = 0;
//                            continue loop1;
//                        }
//                        else{
//                            System.out.println("특수스킬의 사용횟수를 초과하였습니다.");
//                            continue loop5;
//                        }
//                    }
//                }
//            }
//        }
//        System.out.println("주인공 : 발자크를 물리쳤어. 이제 드디어 헤이타로스만 남은건가.");
//        System.out.println("제로 : 이제 진짜 마지막 적만 남았군");
//        System.out.println("마리 : 뭘 그리 고민하고 있어? 헤이타로스도 가뿐히 이겨버리자고");
//        System.out.println("그랑디엘 : 전투도 체력이 있어야 할 수 있는 거에요 일단 돌아가서 휴식을 취해요");
//
//        hero.Hp = 15000;
//        hero.Mp = 200;
//        zero.Hp = 4500;
//        zero.Mp = 100;
//        mari.Hp = 4000;
//        mari.Mp = 150;
//        grandiel.Hp = 4000;
//        grandiel.Mp = 120;
//
//        System.out.println("--------------------------- 휴식 후 ------------------------");
//        System.out.println("이제 충분히 쉰거 같아. 마지막으로 헤이타로스를 잡으러 가볼까?");
//        System.out.println("1. 정비한다 2. 듀라한(토벌완료) 3. 발자크(토벌완료) 4. 헤이타로스");
//        yes = scanner.nextInt();
//        while(yes == 1){
//            int number;
//            System.out.println("1. 이상준 2. 제로 3. 마리 4. 그랑디엘");
//            int choose = scanner.nextInt();
//            switch(choose){
//                case 1:
//                    System.out.println("1. 스텟보기 2. 그만두기");
//                    number = scanner.nextInt();
//                    if(number == 1){
//                        hero.Status();
//                        break;
//                    }
//                    else{
//                        break;
//                    }
//                case 2:
//                    System.out.println("1. 스텟보기 2. 그만두기");
//                    number = scanner.nextInt();
//                    if(number == 1){
//                        zero.Status();
//                        break;
//                    }
//                    else{
//                        break;
//                    }
//                case 3:
//                    System.out.println("1. 스텟보기 2. 그만두기");
//                    number = scanner.nextInt();
//                    if(number == 1){
//                        mari.Status();
//                        break;
//                    }
//                    else{
//                        break;
//                    }
//                case 4:
//                    System.out.println("1. 스텟보기 2. 그만두기");
//                    number = scanner.nextInt();
//                    if(number == 1){
//                        grandiel.Status();
//                        break;
//                    }
//                    else{
//                        break;
//                    }
//            }
//            System.out.println("계속해서 정비하겠습니까? 1. 네 아직 부족한것 같습니다. 2. 아니오 이제 싸우러 가겠습니다.");
//            yes = scanner.nextInt();
//            if(yes == 1){
//                continue;
//            }
//            else{
//                break;
//            }
//        }
//        if(yes == 4){
//            loop:
//            while(true){
//                int hero_turn = 1; // 아군의 공격 순서 1이면 주인공, 2이면 제로, 3이면 마리, 4이면 그랑디엘의 순서이다.
//                int enemy_turn = 1; // 적의 특수 스킬을 사용하기 위한 카운트 5,10,15,20이 될때마다 특수스킬을 사용
//                int zero_count = 1; // 제로의 특수스킬을 카운트 하기 위함 전투마다 1번씩밖에 사용 못함
//                int mari_count = 1; // 마리의 특수스킬을 카운트 하기 위함 전투마다 1번씩맊에 사용 못함
//                int grandiel_count = 1; // 그랑디엘의 특수스킬을 카운트 하기 위함 전투마다 1번씩밖에 사용 못함
//
//                loop1:
//                while(hero.Hp > 0){
//                    System.out.println("헤이타로스의 턴입니다.");
//                    if(enemy_turn % 5 == 0) {
//                        Heitaros.demonization(hero, zero, mari, grandiel);
//                        enemy_turn++;
//                        if (hero_turn == 1) {
//                            hero_turn = 2;
//                            if (zero.Hp > 0) {
//                                continue;
//                            }
//                        } else if (hero_turn == 2) {
//                            hero_turn = 3;
//                            if (mari.Hp > 0) {
//                                continue;
//                            }
//                        } else if (hero_turn == 3) {
//                            hero_turn = 4;
//                            if (grandiel.Hp > 0) {
//                                continue;
//                            }
//                        } else {
//                            hero_turn = 1;
//                            if (hero.Hp > 0) {
//                                continue;
//                            }
//                        }
//                    }
//                    else{
//                        Random random = new Random();
//                        int choose_behavior = random.nextInt(2);
//                        int choose_person = random.nextInt(4);
//                        if(choose_behavior == 0){ // Durahhan의 기본공격
//                            switch(choose_person){
//                                case 0:
//                                    Heitaros.attack(hero);
//                                    enemy_turn++;
//                                    break;
//                                case 1:
//                                    if(zero.Hp > 0){
//                                        Heitaros.attack(zero);
//                                        enemy_turn++;
//                                        break;
//                                    }
//                                    else{
//                                        System.out.println("헤이타로스가 제로를 공격하려 했지만 제로는 이미 죽었습니다.");
//                                        enemy_turn++;
//                                        break;
//                                    }
//                                case 2:
//                                    if(mari.Hp > 0){
//                                        Heitaros.attack(mari);
//                                        enemy_turn++;
//                                        break;
//                                    }
//                                    else{
//                                        System.out.println("헤이타로스가 마리를 공격하려 했지만 마리는 이미 죽었습니다.");
//                                        enemy_turn++;
//                                        break;
//                                    }
//                                case 3:
//                                    if(grandiel.Hp > 0){
//                                        Heitaros.attack(grandiel);
//                                        enemy_turn++;
//                                        break;
//                                    }
//                                    else{
//                                        System.out.println("헤이타로스가 그랑디엘을 공격하려 했지만 그랑디엘은 이미 죽었습니다.");
//                                        enemy_turn++;
//                                        break;
//                                    }
//                            }
//                            if(hero_turn == 2){
//                                if(zero.Hp > 0){
//                                    continue;
//                                }
//                                else {
//                                    hero_turn++;
//                                    if(mari.Hp > 0){
//                                        continue;
//                                    }
//                                    else{
//                                        hero_turn++;
//                                        if(grandiel.Hp > 0){
//                                            continue;
//                                        }
//                                        else{
//                                            hero_turn++;
//                                        }
//                                    }
//                                }
//                            }
//                            else if(hero_turn == 3){
//                                if(mari.Hp > 0){
//                                    continue;
//                                }
//                                else{
//                                    hero_turn++;
//                                    if(grandiel.Hp > 0){
//                                        continue;
//                                    }
//                                    else{
//                                        hero_turn = 1;
//                                    }
//                                }
//                            }
//                            else if(hero_turn == 4){
//                                if(grandiel.Hp > 0){
//                                    continue;
//                                }
//                                else{
//                                    hero_turn = 1;
//                                }
//                            }
//                        }
//
//                        if(choose_behavior == 1){ // Durahhan의 스킬사용
//                            switch(choose_person){
//                                case 0:
//                                    Heitaros.skill(hero);
//                                    enemy_turn++;
//                                    break;
//                                case 1:
//                                    if(zero.Hp > 0){
//                                        Heitaros.skill(zero);
//                                        enemy_turn++;
//                                        break;
//                                    }
//                                    else{
//                                        System.out.println("헤이타로스가 제로를 공격하려 했지만 제로는 이미 죽었습니다.");
//                                        enemy_turn++;
//                                        break;
//                                    }
//                                case 2:
//                                    if(mari.Hp > 0){
//                                        Heitaros.skill(mari);
//                                        enemy_turn++;
//                                        break;
//                                    }
//                                    else{
//                                        System.out.println("헤이타로스가 마리를 공격하려 했지만 마리는 이미 죽었습니다.");
//                                        enemy_turn++;
//                                        break;
//                                    }
//                                case 3:
//                                    if(grandiel.Hp > 0){
//                                        Heitaros.skill(grandiel);
//                                        enemy_turn++;
//                                        break;
//                                    }
//                                    else{
//                                        System.out.println("헤이타로스가 그랑디엘을 공격하려 했지만 그랑디엘은 이미 죽었습니다.");
//                                        enemy_turn++;
//                                        break;
//                                    }
//                            }
//                            if(hero_turn == 2){
//                                if(zero.Hp > 0){
//                                    continue;
//                                }
//                                else {
//                                    hero_turn++;
//                                    if(mari.Hp > 0){
//                                        continue;
//                                    }
//                                    else{
//                                        hero_turn++;
//                                        if(grandiel.Hp > 0){
//                                            continue;
//                                        }
//                                        else{
//                                            hero_turn++;
//                                        }
//                                    }
//                                }
//                            }
//                            else if(hero_turn == 3){
//                                if(mari.Hp > 0){
//                                    continue;
//                                }
//                                else{
//                                    hero_turn++;
//                                    if(grandiel.Hp > 0){
//                                        continue;
//                                    }
//                                    else{
//                                        hero_turn = 1;
//                                    }
//                                }
//                            }
//                            else if(hero_turn == 4){
//                                if(grandiel.Hp > 0){
//                                    continue;
//                                }
//                                else{
//                                    hero_turn = 1;
//                                }
//                            }
//                        }
//                    }
//
//                    loop2:
//                    while((hero_turn == 0 || hero_turn == 1) && Heitaros.Hp > 0){ // 주인공의 공격하는 순서
//                        System.out.println("주인공의 차례입니다.");
//                        System.out.println("1. 공격한다. 2. 스킬을쓴다.");
//                        int attack_or_skill = scanner.nextInt();
//                        if(attack_or_skill == 1) { // 주인공의 기본 공격
//                            hero.attack(Heitaros);
//                            if(Heitaros.Hp <= 0){ // 주인공의 공격으로 적의 체력이 0이되면 전투 종료
//                                System.out.println("축하합니다. 적 헤이타로스를 물리쳤습니다.!");
//                                break loop;
//                            }
//                            else{ // 그렇지 않으면 hero_turn은 2가되고 적의 턴으로 넘어감
//                                hero_turn = 2;
//                                continue loop1;
//                            }
//                        }
//                        if(attack_or_skill ==2){ // 주인공의 스킬사용
//                            if(hero.Mp >= 30) { // 주인공의 Mp가 30보다 클 경우 스킬사용이 가능
//                                hero.skill(Heitaros);
//                                if (Heitaros.Hp <= 0) { // 주인공의 스킬사용으로 적의 체력이 0이되면 전투 종료
//                                    System.out.println("축하합니다. 적 헤이타로스를 물리쳤습니다.!");
//                                    break loop;
//                                }
//                                else { // 그렇지 않으면 hero_turn은 2가되고 적의 턴으로 넘어감
//                                    hero_turn = 2;
//                                    continue loop1;
//                                }
//                            }
//                            else{ // 주인공의 Mp가 부족하여 스킬사용이 불가능
//                                System.out.println("주인공의 Mp가 부족하여 스킬을 사용할 수 없습니다.");
//                                continue loop2;
//                            }
//                        }
//                    }
//
//                    loop3:
//                    while(hero_turn == 2 && Heitaros.Hp >0){ // 제로의 공격순서
//                        System.out.println("제로의 턴입니다.");
//                        System.out.println("1. 공격한다. 2. 스킬을쓴다. 3. 특수스킬을 쓴다.");
//                        int attack_or_skill1 = scanner.nextInt();
//                        if(attack_or_skill1 == 1) { // 제로의 기본공격
//                            zero.attack(Heitaros);
//                            if(Heitaros.Hp <= 0){ // 제로의 공격으로 적의 체력이 0이되면 전투종료
//                                System.out.println("축하합니다. 적 헤이타로스를 물리쳤습니다.!");
//                                break loop;
//                            }
//                            else{ // 그렇지 않으면 hero_turn은 3이되고 적의 턴으로 넘어감
//                                hero_turn = 3;
//                                continue loop1;
//                            }
//                        }
//                        if(attack_or_skill1 ==2) { // 제로의 스킬사용
//                            if (zero.Mp >= 30) { // 제로의 Mp가 30보다 클 경우에 스킬사용이 가능
//                                System.out.println("스킬을 사용할 대상을 고르시오. 1. 이상준 2. 제로 3. 마리 4. 그랑디엘"); // 제로의 스킬은 아군 중 한명의 물리방어력, 마법방어력을 올려주는 것이므로 한명을 선택해야함
//                                int choose_one = scanner.nextInt();
//                                switch (choose_one) {
//                                    case 1:
//                                        zero.skill(hero);
//                                        hero_turn = 2;
//                                        break;
//                                    case 2:
//                                        zero.skill(zero);
//                                        hero_turn = 2;
//                                        break;
//                                    case 3:
//                                        zero.skill(mari);
//                                        hero_turn = 2;
//                                        break;
//                                    case 4:
//                                        zero.skill(grandiel);
//                                        hero_turn = 2;
//                                        break;
//                                }
//                                continue loop1;
//                            }
//                            else { // 제로의 Mp가 부족하여 스킬사용이 불가능
//                                System.out.println("제로의 Mp가 부족하여 스킬을 사용할 수 없습니다.");
//                                continue loop3;
//                            }
//                        }
//                        if(attack_or_skill1 == 3 && zero_count == 1){ // 제로의 특수스킬 사용
//                            zero.Special_Skill(hero, zero, mari, grandiel, Heitaros);
//                            zero_count = 0;
//                            hero_turn = 3;
//                            continue loop1;
//                        }
//                        else{
//                            System.out.println("특수스킬의 사용횟수를 초과하였습니다.");
//                            continue loop3;
//                        }
//                    }
//
//                    loop4:
//                    while(hero_turn == 3 && Heitaros.Hp >0){ // 마리의 공격순서
//                        System.out.println("마리의 턴입니다.");
//                        System.out.println("1. 공격한다. 2. 스킬을쓴다. 3. 특수스킬을 쓴다.");
//                        int attack_or_skill2 = scanner.nextInt();
//                        if(attack_or_skill2 == 1) { // 마리의 기본공격
//                            mari.attack(Heitaros);
//                            if(Heitaros.Hp <= 0){ // 마리의 공격으로 적의 체력이 0이되면 전투종료
//                                System.out.println("축하합니다. 적 헤이타로스를 물리쳤습니다.!");
//                                break loop;
//                            }
//                            else{ // 그렇지 않으면 hero_turn은 4이되고 적의 턴으로 넘어감
//                                hero_turn = 4;
//                                continue loop1;
//                            }
//                        }
//
//                        if(attack_or_skill2 ==2){ // 마리의 스킬사용
//                            if(mari.Mp >= 30) { // 마리의 Mp가 30보다 클 경우에 스킬사용이 가능
//                                mari.skill(Heitaros);
//                                if(Heitaros.Hp <= 0){ // 마리의 스킬로 헤이타로스의 체력이 0보다 작아지면 전투 종료
//                                    System.out.println("축하합니다. 적 헤이타로스를 물리쳤습니다.!");
//                                    break loop;
//                                }
//                                else{
//                                    hero_turn = 4;
//                                    continue loop1;
//                                }
//                            }
//                        }
//                        else{ // 마리의 Mp가 부족하여 스킬사용이 불가능
//                            System.out.println("마리의 Mp가 부족하여 스킬을 사용할 수 없습니다.");
//                            continue loop4;
//                        }
//
//                        if(attack_or_skill2 == 3 && mari_count == 1){ // 마리의 특수스킬 사용
//                            mari.Special_Skill(hero, zero, mari, grandiel, Heitaros);
//                            mari_count = 0;
//                            if(Heitaros.Hp <= 0){
//                                System.out.println("축하합니다. 적 헤이타로스를 물리쳤습니다.!");
//                                break loop;
//                            }
//                            else{
//                                hero_turn = 4;
//                                continue loop1;
//                            }
//                        }
//                        else{
//                            System.out.println("특수스킬의 사용횟수를 초과하였습니다.");
//                            continue loop4;
//                        }
//                    }
//
//                    loop5:
//                    while(hero_turn == 4 && Heitaros.Hp >0){ // 그랑디엘의 공격순서
//                        System.out.println("그랑디엘의 턴입니다.");
//                        System.out.println("1. 공격한다. 2. 스킬을쓴다. 3. 특수스킬을 쓴다.");
//                        int attack_or_skill3 = scanner.nextInt();
//                        if(attack_or_skill3 == 1) { // 마리의 기본공격
//                            grandiel.attack(Heitaros);
//                            if(Heitaros.Hp <= 0){ // 그랑디엘의 공격으로 적의 체력이 0이되면 전투종료
//                                System.out.println("축하합니다. 적 헤이타로스를 물리쳤습니다.!");
//                                break loop;
//                            }
//                            else{ // 그렇지 않으면 hero_turn은 1이되고 적의 턴으로 넘어감
//                                hero_turn = 1;
//                                continue loop1;
//                            }
//                        }
//                        if(attack_or_skill3 == 2){ // 그랑디엘의 스킬사용
//                            if(grandiel.Mp >= 30) { // 그랑디엘의 Mp가 30보다 클 경우에 스킬사용이 가능
//                                System.out.println("스킬을 사용할 대상을 고르시오. 1. 이상준 2. 제로 3. 마리 4. 그랑디엘"); // 그랑디엘의 스킬은 아군 중 한명한테 힐을 해주는 것이기 때문에 한명을 선택
//                                int choose_one = scanner.nextInt();
//                                switch(choose_one){
//                                    case 1:
//                                        grandiel.skill(hero);
//                                        hero_turn = 1;
//                                        break;
//                                    case 2:
//                                        grandiel.skill(zero);
//                                        hero_turn = 1;
//                                        break;
//                                    case 3:
//                                        grandiel.skill(mari);
//                                        hero_turn = 1;
//                                        break;
//                                    case 4:
//                                        grandiel.skill(grandiel);
//                                        hero_turn = 1;
//                                        break;
//                                }
//                                continue loop1;
//                            }
//                        }
//                        else{ // 그랑디엘의 Mp가 부족하여 스킬사용이 불가능
//                            System.out.println("그랑디엘의 Mp가 부족하여 스킬을 사용할 수 없습니다.");
//                            continue loop5;
//                        }
//
//                        if(attack_or_skill3 == 3 && grandiel_count == 1){ // 그랑디엘의 특수스킬 사용
//                            grandiel.Special_Skill(hero, zero, mari, grandiel, Heitaros);
//                            grandiel_count = 0;
//                            continue loop1;
//                        }
//                        else{
//                            System.out.println("특수스킬의 사용횟수를 초과하였습니다.");
//                            continue loop5;
//                        }
//                    }
//                }
//            }
//        }
//        System.out.println("이상준 : 드디어 헤이타로스를 물리쳤어!!!! 나 이제 집으로 돌아갈 수 있는거야?");
//        System.out.println("마리 : 음 그런가...? 하지만 아직 딱히 이전과 다른점을 모르겠는걸...?");
//        System.out.println("그랑디엘 : 앗!!! 저기를 보세요");
//        System.out.println("제로 : 아니 저기에 포탈이....?");
//        System.out.println("이상준 : 오 저게 집으로 돌아가는 포탈 아닐까...?");
//        System.out.println("마리 : 이상하긴 하지만 지금 상황에선 그게 가장 합리적인 판단이군");
//        System.out.println("이상준 : 나 이제 집으로 돌아간다 다들 그동안 고마웠어");
//        System.out.println("제로 : 아니야 너는 우리의 왕국을 지켜준 영웅이잖아 우리가 더 고맙지");
//        System.out.println("그랑디엘 : 저희가 만난지도 얼마 안된거 같은데 벌써 이별이라니 슬프네요. 만남이 있으면 이별도 있는 법이니까요");
//        System.out.println("마리 : 집으로 돌아가서 내가 생각나서 울지 말라구");
//        System.out.println("이상준 : 모두들..... 그동안 정말 고마웠어 나 이제 진짜 가볼게");
//        System.out.println("제로 마리 그랑디엘 : 그동안 즐거웠습니다. 부디 몸조심히 원래 있던 세계로 돌아가시길");
//        System.out.println("=======================================================================");
//        System.out.println("Game Clear!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }