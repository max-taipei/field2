package com.livehereandnow.ages.field;

//import com.livehereandnow.ages.components.CardArray;
import com.livehereandnow.ages.card.AgesCard;
import com.livehereandnow.ages.card.AgesCardFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//import com.livehereandnow.ages.components.Points;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mark
 */
public class Field {

    private List<AgesCard> allCards;
    private List<AgesCard> qryCards;
    private List<AgesCard> 卡牌列;
    private List<AgesCard> 時代A內政牌;
    private List<AgesCard> 時代I內政牌;
    private List<AgesCard> 時代II內政牌;
    private List<AgesCard> 時代III內政牌;
    private List<AgesCard> 時代A軍事牌;
    private List<AgesCard> 時代I軍事牌;
    private List<AgesCard> 時代II軍事牌;
    private List<AgesCard> 時代III軍事牌;
    private List<AgesCard> 未來事件;
    private List<AgesCard> 當前事件;

    private FieldPlayer p1;
    private FieldPlayer p2;
    private FieldPlayer currentPlayer;

    private Points round;

    public void 交換玩家() {
        if (currentPlayer == p1) {
            currentPlayer = p2;
            return;
        }
        if (currentPlayer == p2) {
            currentPlayer = p1;
//            System.out.println("auto to next 回合");
            round.addPoints(1);
            return;
        }

    }

    public List<AgesCard> getAllCards() {
        return allCards;
    }

    public void removeCardById(List<AgesCard> list, int id) {
        for (AgesCard card : list) {
            if (card.getId() == id) {
                list.remove(card);
                return;
            }
        }
    }

    public void moveOneCard(List<AgesCard> from, int index, List<AgesCard> to) {
        to.add(from.remove(index));
    }

    public List<AgesCard> getCardRow() {
        return 卡牌列;
    }

    public List<AgesCard> get時代A內政牌() {
        return 時代A內政牌;
    }

    public List<AgesCard> get時代I內政牌() {
        return 時代I內政牌;
    }

    public List<AgesCard> get時代II內政牌() {
        return 時代II內政牌;
    }

    public List<AgesCard> get時代III內政牌() {
        return 時代III內政牌;
    }

    public List<AgesCard> get時代A軍事牌() {
        return 時代A軍事牌;
    }

    public AgesCard getCardByName(List<AgesCard> list, String name) {
        //   List<Card> list=new List<>();
        for (int k = 0; k < list.size(); k++) {
            if (list.get(k).getName().equals(name)) {
                return list.get(k);
            }
        }
        return null;
    }

    public List<AgesCard> get時代I軍事牌() {
        return 時代I軍事牌;
    }

    public List<AgesCard> get時代II軍事牌() {
        return 時代II軍事牌;
    }

    public List<AgesCard> get時代III軍事牌() {
        return 時代III軍事牌;
    }

    public List<AgesCard> get未來事件() {
        return 未來事件;
    }

    public List<AgesCard> get當前事件() {
        return 當前事件;
    }

    public FieldPlayer getP1() {
        return p1;
    }

    public FieldPlayer getP2() {
        return p2;
    }

    public FieldPlayer getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(FieldPlayer currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

//    public FieldPlayer getCurrentPlayer() {
//        return currentPlayer;
//    }
    public Points getRound() {
        return round;
    }

    public List<AgesCard> getAgeCivil(List<AgesCard> list, int age) {
        List<AgesCard> newList = new ArrayList<>();
        for (AgesCard card : list) {
            if (card.getCivilMilitary().endsWith("內政")) {
                if (card.getAge() == age) {
                    newList.add(card);
                    list.remove(card);
                }
            }
        }
        return newList;
    }

    public List<AgesCard> getAgeMilitary(List<AgesCard> list, int age) {
        List<AgesCard> newList = new ArrayList<>();
        for (AgesCard card : list) {
            if (card.getCivilMilitary().endsWith("軍事")) {
                if (card.getAge() == age) {
                    newList.add(card);
                }
            }
        }
        return newList;
    }

    public void showCardInfo(int id) {
        System.out.println(" qry card id=" + id);
        System.out.println(" size=" + qryCards.size());

        for (AgesCard card : qryCards) {
            if (card.getId() == id) {
                System.out.println(card.toString());

                return;
            }
        }
    }

    public Field() {
        initField();
    }

    public void initField() {
        AgesCardFactory factory = new AgesCardFactory();
//        allCards = new AgesCardList("All Cards");
//        qryCards = new AgesCardList("qryCards");

//        allCards = CardBank.getInstance().getAllCards();
        allCards = new AgesCardFactory().getAgesCardArrayList();
        qryCards = new AgesCardFactory().getAgesCardArrayList();
        System.out.println("all/qry" + allCards.size() + "/" + qryCards.size());

        卡牌列 = new ArrayList<>();

        時代A內政牌 = new ArrayList<>();
        時代I內政牌 = new ArrayList<>();
        時代II內政牌 = new ArrayList<>();
        時代III內政牌 = new ArrayList<>();
        時代A軍事牌 = new ArrayList<>();
        時代I軍事牌 = new ArrayList<>();
        時代II軍事牌 = new ArrayList<>();
        時代III軍事牌 = new ArrayList<>();
//        未來事件 = new AgesCardList("未來事件");
//        當前事件 = new AgesCardList("當前事件");
        未來事件 = new ArrayList<>();
        當前事件 = new ArrayList<>();

        round = new Points("回合");
//        round.setPoints(1);
        p1 = new FieldPlayer("max");
        p2 = new FieldPlayer("amy");

        currentPlayer = p1;
        AgesCard card;
        AgesCard card1;
        AgesCard card2;
        List<AgesCard> list;

        // 1
        card = getCardByName(allCards, "哲學");
        p1.實驗室.add(card);
        p2.實驗室.add(card);
//        allCards.remove(card);

        // 2
        card = getCardByName(allCards, "宗教");
        p1.神廟區.add(card);
        p2.神廟區.add(card);
//        allCards.remove(card);

//        農業  戰士
        card = getCardByName(allCards, "青銅");
        p1.礦山區.add(card);
        p2.礦山區.add(card);
//        allCards.remove(card);
        card = getCardByName(allCards, "戰士");

        p1.步兵區.add(card);
        p2.步兵區.add(card);
//        allCards.remove(card);
//            ca.add(new AgesCard(2554, 1007, "農業", 0, "內政", "農場", "", "石頭:2", "食物:1", "null", "棕色", 1, 0, 0, 0, 0, 0, 1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0));

        card1 = new AgesCard(2554, 1007, "農業", 0, "內政", "農場", "", "石頭:2", "食物:1", "null", "棕色", 1, 0, 0, 0, 0, 0, 1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0);
        card2 = new AgesCard(2554, 1007, "農業", 0, "內政", "農場", "", "石頭:2", "食物:1", "null", "棕色", 1, 0, 0, 0, 0, 0, 1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0);
        p1.農場區.add(card1);
        p2.農場區.add(card2);
        allCards.remove(card);

        card = getCardByName(allCards, "專制");

        p1.政府區.add(card);
        p2.政府區.add(card);
//        allCards.remove(card);
        System.out.println("all/qry" + allCards.size() + "/" + qryCards.size());

        時代A內政牌 = factory.getAgeCivil(0);

        時代I內政牌 = factory.getAgeCivil(1);
        時代II內政牌 = factory.getAgeCivil(2);
        時代III內政牌 = factory.getAgeCivil(3);
        時代A軍事牌 = factory.getAgeMilitary(0);
        時代I軍事牌 = factory.getAgeMilitary(1);
        時代II軍事牌 = factory.getAgeMilitary(2);
        時代III軍事牌 = factory.getAgeMilitary(3);
        removeCardById(時代A內政牌, 1001);
        removeCardById(時代A內政牌, 1010);
        removeCardById(時代A內政牌, 1011);
        removeCardById(時代A內政牌, 1007);
        removeCardById(時代A內政牌, 1032);
        removeCardById(時代A內政牌, 1018);

        System.out.println(" after... all/qry: " + allCards.size() + "/" + qryCards.size());
//        System.exit(0);
//
//        時代A內政牌.setTitle("時代A內政牌");
//        時代A軍事牌.setTitle("時代A軍事牌");
//        時代I內政牌.setTitle("時代I內政牌");
//        時代I軍事牌.setTitle("時代I軍事牌");
//        時代II內政牌.setTitle("時代II內政牌");
//        時代II軍事牌.setTitle("時代II軍事牌");
//        時代III內政牌.setTitle("時代III內政牌");
//        時代III軍事牌.setTitle("時代III軍事牌");

//        Collections.shuffle(時代A內政牌);
//        Collections.shuffle(時代A軍事牌);
//        Collections.shuffle(時代I內政牌);
//        Collections.shuffle(時代I軍事牌);
//        Collections.shuffle(時代II內政牌);
//        Collections.shuffle(時代II軍事牌);
//        Collections.shuffle(時代III內政牌);
//        Collections.shuffle(時代III軍事牌);
//        for (int k = 0; k < 13; k++) {
//            卡牌列.add(時代A內政牌.remove(k));
//        }
        p1.get步兵區().get(0).setTokenYellow(1);
        p1.get實驗室().get(0).setTokenYellow(1);
        p1.get礦山區().get(0).setTokenYellow(2);
        p1.get農場區().get(0).setTokenYellow(2);
        p1.get人力庫_黃點().setPoints(18);
        p1.get工人區_黃點().setPoints(1);
        p1.get資源庫_藍點().setPoints(18);

        p2.get步兵區().get(0).setTokenYellow(1);
        p2.get實驗室().get(0).setTokenYellow(1);
        p2.get礦山區().get(0).setTokenYellow(2);
        p2.get農場區().get(0).setTokenYellow(2);
        p2.get人力庫_黃點().setPoints(18);
        p2.get工人區_黃點().setPoints(1);
        p2.get資源庫_藍點().setPoints(18);

        //
        AgesCard NOCARD = new AgesCard();
        NOCARD.setId(1000);
        NOCARD.setAge(4);

        allCards.add(NOCARD);

    }

    public void show(List<AgesCard> list, String title, int style) {

        switch (title) {
            case "卡牌列":
                System.out.println("");
                System.out.print(title + " (" + list.size() + ")");
                if (list.size() == 0) {
                    return;
                }
                System.out.print("\n (1)");
                for (int k = 0; k <= 4; k++) {
                    System.out.print("" + k + list.get(k).toString(2));
                }
                System.out.print("\n (2)");
                for (int k = 5; k <= 8; k++) {
                    System.out.print("" + k + list.get(k).toString(2));
                }
                System.out.print("\n (3)");
                for (int k = 9; k <= 12; k++) {
                    System.out.print("" + k + list.get(k).toString(2));
                }
//                System.out.println("");
                break;
            default:
                System.out.println("");
                System.out.print(title + " (" + list.size() + ")");
                for (AgesCard card : list) {
                    System.out.print("" + card.toString(2));
                }

        }

    }
//    
//    public void show(int style) {
//        switch (style) {
//            case 0:
//                round.show();
//                卡牌列.show(1);
//                System.out.println("Current Player: " + currentPlayer.name);
//                break;
//            case 1:
//                p1.show(1);
//                break;
//            case 2:
//                p2.show(1);
//                break;
//            case 11:
//                p1.show(2);
//                break;
//            case 22:
//                p2.show(2);
//                break;
//
//            default:
//                show();
//        }
//    }

    public void show() {
        round.show();
        System.out.println("Current Player: " + currentPlayer.name);
        show(卡牌列, "卡牌列", 2);
        show(時代A內政牌, "時代A內政牌", 1);
        show(時代I內政牌, "時代I內政牌", 1);
        show(時代II內政牌, "時代II內政牌", 1);
        show(時代III內政牌, "時代III內政牌", 1);
        show(時代A軍事牌, "時代A軍事牌", 1);
        show(時代I軍事牌, "時代I軍事牌", 1);
        show(時代II軍事牌, "時代II軍事牌", 1);
        show(時代III軍事牌, "時代III軍事牌", 1);

        p1.show(1);
        p2.show(1);
    }

    public final class FieldPlayer {

        public String getName() {
            return name;
        }

        public void pay內政點數(int cost) {
            內政點數.addPoints((-1) * cost);
        }

        public Points get內政點數() {
            return 內政點數;
        }

        public Points get軍事點數() {
            return 軍事點數;
        }

        public Points get建築上限() {
            return 建築上限;
        }

        public Points get內政手牌上限() {
            return 內政手牌上限;
        }

        public Points get軍事手牌上限() {
            return 軍事手牌上限;
        }

        public Points get殖民點數() {
            return 殖民點數;
        }

        public void produce文化() {
            get文化().addPoints(get文化生產_當回合().getPoints());
        }

        public void produce科技() {
            get科技().addPoints(get科技生產_當回合().getPoints());
        }

        public Points get文化() {
            return 文化;
        }

        public Points get文化生產_當回合() {
            return 文化生產_當回合;
        }

        public Points get科技() {
            return 科技;
        }

        public Points get科技生產_當回合() {
            return 科技生產_當回合;
        }

        public Points get軍力() {
            return 軍力;
        }

        public Points get資源庫_藍點() {
            return 資源庫_藍點;
        }

        public Points get人力庫_黃點() {
            return 人力庫_黃點;
        }

        public Points get笑臉_幸福指數() {
            return 笑臉_幸福指數;
        }

        public Points get工人區_黃點() {
            return 工人區_黃點;
        }

        public List<AgesCard> get領袖區() {
            return 領袖區;
        }

        public List<AgesCard> get政府區() {
            return 政府區;
        }

        public List<AgesCard> get實驗室() {
            return 實驗室;
        }

        public List<AgesCard> get神廟區() {
            return 神廟區;
        }

        public List<AgesCard> get農場區() {
            return 農場區;
        }

        public List<AgesCard> get礦山區() {
            return 礦山區;
        }

        public List<AgesCard> get步兵區() {
            return 步兵區;
        }

        public List<AgesCard> get建造中的奇蹟區() {
            return 建造中的奇蹟區;
        }

        public List<AgesCard> get已完成的奇蹟() {
            return 已完成的奇蹟;
        }

        public List<AgesCard> get殖民領土區() {
            return 殖民領土區;
        }

        public List<AgesCard> get特殊科技區() {
            return 特殊科技區;
        }

        public List<AgesCard> get手牌內政牌區() {
            return 手牌內政牌區;
        }

        public List<AgesCard> get手牌軍事牌區() {
            return 手牌軍事牌區;
        }

        public void setName(String name) {
            this.name = name;
        }

        public FieldPlayer(String str) {
            name = str;
            init();
        }

        private String name;
        private Points 內政點數;
        private Points 軍事點數;
        private Points 建築上限;
        private Points 內政手牌上限;
        private Points 軍事手牌上限;
        private Points 殖民點數;
        private Points 文化;
        private Points 文化生產_當回合;
        private Points 科技;
        private Points 科技生產_當回合;
        private Points 軍力;
        private Points 資源庫_藍點;
        private Points 人力庫_黃點;
        private Points 笑臉_幸福指數;
        private Points 工人區_黃點;
        private List<AgesCard> 領袖區;
        private List<AgesCard> 政府區;
        private List<AgesCard> 實驗室;
        private List<AgesCard> 神廟區;
        private List<AgesCard> 農場區;
        private List<AgesCard> 礦山區;
        private List<AgesCard> 步兵區;

// [09:54:37] maxchen20041: 請按照步兵區方式
// [09:55:19] maxchen20041: 建立騎兵區、炮兵區、飛機區、劇院區、圖書館區、競技場區
        private List<AgesCard> 騎兵區;
        private List<AgesCard> 炮兵區;
        private List<AgesCard> 飛機區;
        private List<AgesCard> 劇院區;
        private List<AgesCard> 圖書館區;
        private List<AgesCard> 競技場區;

        private List<AgesCard> 建造中的奇蹟區;
        private List<AgesCard> 已完成的奇蹟;
        private List<AgesCard> 殖民領土區;
        private List<AgesCard> 特殊科技區;
        private List<AgesCard> 手牌內政牌區;
        private List<AgesCard> 手牌軍事牌區;

        public void init() {
            內政點數 = new Points("內政點數");
            軍事點數 = new Points("軍事點數");
            建築上限 = new Points("建築上限");
            內政手牌上限 = new Points("內政手牌上限");
            軍事手牌上限 = new Points("軍事手牌上限");
            殖民點數 = new Points("殖民點數");
            文化 = new Points("文化");
            文化生產_當回合 = new Points("文化生產_當回合");
            科技 = new Points("科技");
            科技生產_當回合 = new Points("科技生產_當回合");
            軍力 = new Points("軍力");
            資源庫_藍點 = new Points("資源庫_藍點");
            人力庫_黃點 = new Points("人力庫_黃點");
            笑臉_幸福指數 = new Points("笑臉_幸福指數");
            工人區_黃點 = new Points("工人區_黃點");
            領袖區 = new ArrayList<AgesCard>();
            政府區 = new ArrayList<AgesCard>();
            實驗室 = new ArrayList<AgesCard>();
            神廟區 = new ArrayList<AgesCard>();
            農場區 = new ArrayList<AgesCard>();
            礦山區 = new ArrayList<AgesCard>();
            步兵區 = new ArrayList<AgesCard>();

// [09:54:37] maxchen20041: 請按照步兵區方式
// [09:55:19] maxchen20041: 建立 騎兵區、炮兵區、飛機區、劇院區、圖書館區、競技場區            
            騎兵區 = new ArrayList<AgesCard>();
            炮兵區 = new ArrayList<AgesCard>();
            飛機區 = new ArrayList<AgesCard>();
            劇院區 = new ArrayList<AgesCard>();
            圖書館區 = new ArrayList<AgesCard>();
            競技場區 = new ArrayList<>();

            建造中的奇蹟區 = new ArrayList<>();
            已完成的奇蹟 = new ArrayList<>();
            殖民領土區 = new ArrayList<>();
            特殊科技區 = new ArrayList<>();
            手牌內政牌區 = new ArrayList<>();
            手牌軍事牌區 = new ArrayList<>();

        }

        public void show(List<AgesCard> list, String title, int style) {

            switch (title) {
                case "政府區":
                    System.out.println("");
                    System.out.print("" + title + " ");
                    for (AgesCard card : list) {
                        System.out.print("" + card.toString(1));
                    }
                    break;
                case "農場區":
                    System.out.println("");
                    System.out.print("" + title + " ");
                    for (AgesCard card : list) {
                        System.out.print("" + card.toString(8));
                    }
                    break;
                case "礦山區":
                    System.out.println("");
                    System.out.print("" + title + " ");
                    for (AgesCard card : list) {
                        System.out.print("" + card.toString(8));
                    }
                    break;
                default:
                    System.out.println("");
                    System.out.print("" + title + " ");
                    for (AgesCard card : list) {
                        System.out.print("" + card.toString(4));
                    }
            }

        }

        public void show(int style) {
            switch (style) {
                case 1:
                default:
                    System.out.println("=== " + name + " ===");
                    內政點數.show();
                    軍事點數.show();
                    建築上限.show();
                    內政手牌上限.show();
                    軍事手牌上限.show();
                    殖民點數.show();
                    文化.show();
                    文化生產_當回合.show();
                    科技.show();
                    科技生產_當回合.show();
                    軍力.show();
                    資源庫_藍點.show();
                    人力庫_黃點.show();
                    笑臉_幸福指數.show();
                    工人區_黃點.show();

                    show(領袖區, "領袖區", 2);
                    show(政府區, "政府區", 1);
                    show(實驗室, "實驗室", 3);
                    show(神廟區, "神廟區", 2);
                    show(農場區, "農場區", 2);
                    show(礦山區, "礦山區", 2);
                    show(步兵區, "步兵區", 2);
                    show(手牌內政牌區, "手牌內政牌區", 2);
                    show(手牌軍事牌區, "手牌軍事牌區", 2);
                    System.out.println("");
            }
        }

    }
}
