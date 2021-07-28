package vladislav.kisliy.jff.test.codeforces;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.TreeMap;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class MagicPresentTest {

    private MagicPresent testTarget;

    @Before
    public void setUp() throws Exception {
        testTarget = new MagicPresent();
    }

    @Test
    public void calculatePath02() {
        NavigableMap<Integer, NavigableSet<MagicPresent.Envelope>> envelops = new TreeMap<>();

        envelops.clear();
        NavigableSet<MagicPresent.Envelope> set01 = new TreeSet();
        set01.add(new MagicPresent.Envelope(900000, 900000, 1));
        envelops.put(900000, set01);
        NavigableSet<MagicPresent.Envelope> set02 = new TreeSet();
        set02.add(new MagicPresent.Envelope(902400, 902400, 2));
        envelops.put(902400, set02);

        NavigableSet<MagicPresent.Envelope> set03 = new TreeSet<>();
        set03.add(new MagicPresent.Envelope(901200, 901200, 3));
        envelops.put(901200, set03);

        NavigableSet<MagicPresent.Envelope> set04 = new TreeSet<>();
        set04.add(new MagicPresent.Envelope(903600, 903600, 4));
        envelops.put(903600, set04);

        NavigableSet<MagicPresent.Envelope> set05 = new TreeSet<>();
        set05.add(new MagicPresent.Envelope(906000, 906000, 5));
        envelops.put(906000, set05);

        NavigableSet<MagicPresent.Envelope> set06 = new TreeSet<>();
        set06.add(new MagicPresent.Envelope(904800, 904800, 6));
        envelops.put(904800, set06);


        assertEquals(6, testTarget.calculatePath(testTarget.getEnvelopeList(envelops)).length);
    }

    @Test
    public void calculatePath03() {
        NavigableMap<Integer, NavigableSet<MagicPresent.Envelope>> envelops = new TreeMap<>();
        NavigableSet<MagicPresent.Envelope> set01 = new TreeSet();
        NavigableSet<MagicPresent.Envelope> set02 = new TreeSet();

        set01.add(new MagicPresent.Envelope(5002, 5005, 1));
        set01.add(new MagicPresent.Envelope(5002, 5001, 4));
        set01.add(new MagicPresent.Envelope(5002, 5002, 5));
        envelops.put(5002, set01);

        set02.add(new MagicPresent.Envelope(5003, 5004, 2));
        set02.add(new MagicPresent.Envelope(5003, 5002, 3));
        envelops.put(5003, set02);
        assertEquals(2, testTarget.calculatePath(testTarget.getEnvelopeList(envelops)).length);
    }

    @Test
    public void calculatePath01Input() {
        String data = "2 1 1\n" +
                "2 2\n" +
                "2 2";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
        List<MagicPresent.Envelope> envelopes = testTarget.readEnvelops(inputStream);
        MagicPresent.Envelope[] calculatePath = testTarget.calculatePath(envelopes);
        assertEquals(1, calculatePath.length);
        assertEquals(1, calculatePath[0].number);
    }

    @Test
    public void calculatePath03Input() {
        MagicPresent.Envelope postCard = new MagicPresent.Envelope(10, 10, 0);

        String data = "5 10 10\n" +
                "22 23\n" +
                "17 19\n" +
                "13 17\n" +
                "8 12\n" +
                "2 6";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
        List<MagicPresent.Envelope> envelopes = testTarget.readEnvelops(inputStream);
        MagicPresent.Envelope[] calculatePath = testTarget.calculatePath(envelopes);
        assertEquals(3, calculatePath.length);
        assertEquals(3, calculatePath[0].number);
        assertEquals(2, calculatePath[1].number);
        assertEquals(1, calculatePath[2].number);
    }

    @Test
    public void calculatePath04Input() {
        MagicPresent.Envelope postCard = new MagicPresent.Envelope(13, 13, 0);

        String data = "5 13 13\n" +
                "4 4\n" +
                "10 10\n" +
                "7 7\n" +
                "1 1\n" +
                "13 13";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
        List<MagicPresent.Envelope> envelopes = testTarget.readEnvelops(inputStream);
        MagicPresent.Envelope[] calculatePath = testTarget.calculatePath(envelopes);
        assertEquals(0, calculatePath.length);
    }

    @Test
    public void calculatePath05Input() {
        MagicPresent.Envelope postCard = new MagicPresent.Envelope(12, 140, 0);

        String data = "4 12 140\n" +
                "172 60\n" +
                "71 95\n" +
                "125 149\n" +
                "53 82";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
        List<MagicPresent.Envelope> envelopes = testTarget.readEnvelops(inputStream);
        assertEquals(1, testTarget.calculatePath(envelopes).length);
    }

    @Test
    public void calculatePath07Input() {
        MagicPresent.Envelope postCard = new MagicPresent.Envelope(100, 100, 0);

        String data = "4 100 100\n" +
                "332 350\n" +
                "232 250\n" +
                "32 50\n" +
                "132 150";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
        List<MagicPresent.Envelope> envelopes = testTarget.readEnvelops(inputStream);
        MagicPresent.Envelope[] calculatePath = testTarget.calculatePath(envelopes);

        assertEquals(3, calculatePath.length);
        assertEquals(4, calculatePath[0].number);
        assertEquals(2, calculatePath[1].number);
        assertEquals(1, calculatePath[2].number);
    }

    @Test
    public void calculatePath09Input() {
        String data = "6 1 1\n" +
                "900000 900000\n" +
                "902400 902400\n" +
                "901200 901200\n" +
                "903600 903600\n" +
                "906000 906000\n" +
                "904800 904800";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
        List<MagicPresent.Envelope> envelopes = testTarget.readEnvelops(inputStream);
        MagicPresent.Envelope[] calculatePath = testTarget.calculatePath(envelopes);
        assertEquals(6, calculatePath.length);
        assertEquals(1, calculatePath[0].number);
        assertEquals(3, calculatePath[1].number);
        assertEquals(2, calculatePath[2].number);
        assertEquals(4, calculatePath[3].number);
        assertEquals(6, calculatePath[4].number);
        assertEquals(5, calculatePath[5].number);
    }

    @Test
    public void calculatePath10Input() {
        String data = "5 1000 998\n" +
                "5002 5005\n" +
                "5003 5004\n" +
                "5003 5002\n" +
                "5002 5001\n" +
                "5002 5002";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
        List<MagicPresent.Envelope> envelopes = testTarget.readEnvelops(inputStream);
        // 4 3
        assertEquals(2, testTarget.calculatePath(envelopes).length);
    }

    @Test
    public void calculatePath11Input() {
        String data = "3 5 5\n" +
                "6 2\n" +
                "7 8\n" +
                "10 2";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
        List<MagicPresent.Envelope> envelopes = testTarget.readEnvelops(inputStream);

        MagicPresent.Envelope[] calculatePath = testTarget.calculatePath(envelopes);
        assertEquals(1, calculatePath.length);
        assertEquals(2, calculatePath[0].number);
    }

    @Test
    public void calculatePath12Input() {
        String data = "14 12 800\n" +
                "166 847\n" +
                "205 889\n" +
                "223 907\n" +
                "93 785\n" +
                "110 803\n" +
                "136 829\n" +
                "189 871\n" +
                "149 839\n" +
                "40 740\n" +
                "48 750\n" +
                "180 857\n" +
                "76 777\n" +
                "125 820\n" +
                "63 766";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
        List<MagicPresent.Envelope> envelopes = testTarget.readEnvelops(inputStream);
        MagicPresent.Envelope[] calculatePath = testTarget.calculatePath(envelopes);
        assertEquals(9, calculatePath.length);
//        5 13 6 8 1 11 7 2 3
        assertEquals(5, calculatePath[0].number);
        assertEquals(13, calculatePath[1].number);
        assertEquals(6, calculatePath[2].number);
        assertEquals(8, calculatePath[3].number);
        assertEquals(1, calculatePath[4].number);
        assertEquals(11, calculatePath[5].number);
        assertEquals(7, calculatePath[6].number);
        assertEquals(2, calculatePath[7].number);
        assertEquals(3, calculatePath[8].number);
    }

    @Test
    public void calculatePath13Input() {
        String data = "15 600 875\n" +
                "1200 451\n" +
                "1664 852\n" +
                "1763 1355\n" +
                "1374 1724\n" +
                "1374 1587\n" +
                "1003 1513\n" +
                "1636 1002\n" +
                "431 367\n" +
                "1632 690\n" +
                "1257 778\n" +
                "410 1632\n" +
                "1045 1279\n" +
                "1762 1763\n" +
                "841 576\n" +
                "1165 705";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
        List<MagicPresent.Envelope> envelopes = testTarget.readEnvelops(inputStream);
        MagicPresent.Envelope[] calculatePath = testTarget.calculatePath(envelopes);
        assertEquals(3, calculatePath.length);
//        5 13 6 8 1 11 7 2 3
        assertEquals(6, calculatePath[0].number);
        assertEquals(5, calculatePath[1].number);
        assertEquals(13, calculatePath[2].number);
    }

    @Test
    public void calculatePathManualTest01() {
        String data = "15 600 875\n" +
                "1370 1720\n" +
                "1664 852\n" +
                "1763 1355\n" +
                "1374 1724\n" +
                "1374 1587\n" +
                "1003 1513\n" +
                "1636 1002\n" +
                "431 367\n" +
                "1632 690\n" +
                "1257 778\n" +
                "410 1632\n" +
                "1045 1279\n" +
                "1762 1763\n" +
                "841 576\n" +
                "1165 705";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
        List<MagicPresent.Envelope> envelopes = testTarget.readEnvelops(inputStream);
        MagicPresent.Envelope[] calculatePath = testTarget.calculatePath(envelopes);
        assertEquals(4, calculatePath.length);
//        5 13 6 8 1 11 7 2 3
        assertEquals(6, calculatePath[0].number);
        assertEquals(1, calculatePath[1].number);
        assertEquals(4, calculatePath[2].number);
        assertEquals(13, calculatePath[3].number);
    }

    @Test
    public void calculatePath14Input() {
        MagicPresent.Envelope postCard = new MagicPresent.Envelope(900, 15, 0);

        String data = "30 900 15\n" +
                "1396 562\n" +
                "1265 475\n" +
                "3329 2605\n" +
                "1016 340\n" +
                "2369 1595\n" +
                "2085 1245\n" +
                "2677 1934\n" +
                "1953 1154\n" +
                "3002 2199\n" +
                "1688 855\n" +
                "1147 407\n" +
                "2762 2064\n" +
                "2202 1359\n" +
                "700 30\n" +
                "3265 2488\n" +
                "1884 1034\n" +
                "2571 1836\n" +
                "3067 2269\n" +
                "882 212\n" +
                "3505 2793\n" +
                "1602 785\n" +
                "2292 1460\n" +
                "2442 1712\n" +
                "2889 2127\n" +
                "3187 2361\n" +
                "1770 932\n" +
                "3624 2891\n" +
                "783 104\n" +
                "3410 2704\n" +
                "1521 696";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
        List<MagicPresent.Envelope> envelopes = testTarget.readEnvelops(inputStream);
        MagicPresent.Envelope[] calculatePath = testTarget.calculatePath(envelopes);
        assertEquals(27, calculatePath.length);
//        4 11 2 1 30 21 10 26 16 8 6 13 22 5 23 17 7 12 24 9 18 25 15 3 29 20 27
        assertEquals(4, calculatePath[0].number);
        assertEquals(11, calculatePath[1].number);
        assertEquals(2, calculatePath[2].number);
        assertEquals(1, calculatePath[3].number);
        assertEquals(30, calculatePath[4].number);
        assertEquals(21, calculatePath[5].number);
        assertEquals(10, calculatePath[6].number);
        assertEquals(26, calculatePath[7].number);
        assertEquals(16, calculatePath[8].number);
        assertEquals(8, calculatePath[9].number);
        assertEquals(6, calculatePath[10].number);
    }

    @Test
    public void calculatePath16Input() {
        MagicPresent.Envelope postCard = new MagicPresent.Envelope(6134, 8495, 0);

        String data = "45 6134 8495\n" +
                "9045 8632\n" +
                "4145 4991\n" +
                "5368 5303\n" +
                "6245 4894\n" +
                "8529 6378\n" +
                "5797 6165\n" +
                "5444 6826\n" +
                "7091 4030\n" +
                "6680 9984\n" +
                "4155 6711\n" +
                "5100 5977\n" +
                "7333 6514\n" +
                "9729 4141\n" +
                "8171 6185\n" +
                "6146 6016\n" +
                "4488 7588\n" +
                "9333 4921\n" +
                "7368 6350\n" +
                "6552 8552\n" +
                "9900 8327\n" +
                "3310 7281\n" +
                "6402 5749\n" +
                "6124 4381\n" +
                "8190 3834\n" +
                "7421 3816\n" +
                "3475 4977\n" +
                "6239 6577\n" +
                "9277 4139\n" +
                "4037 5329\n" +
                "6808 7446\n" +
                "7679 5283\n" +
                "6775 3023\n" +
                "6777 8500\n" +
                "5921 6975\n" +
                "4501 4383\n" +
                "4623 8409\n" +
                "7070 6430\n" +
                "9429 8736\n" +
                "7353 7760\n" +
                "3942 3683\n" +
                "4859 8424\n" +
                "6348 7379\n" +
                "9043 9054\n" +
                "9012 7114\n" +
                "7050 9454";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
        List<MagicPresent.Envelope> envelopes = testTarget.readEnvelops(inputStream);
        assertEquals(3, testTarget.calculatePath(envelopes).length);
    }

    @Test
    public void calculatePath19Input() {
//        String data = "483 103232 75323\n" +
        String data = "483 103232 75323\n" +
                "81079 66738\n" +
                "100815 103673\n" +
                "108591 78159\n" +
                "97236 70961\n" +
                "74277 109811\n" +
                "119182 102307\n" +
                "79330 66270\n" +
                "100244 115904\n" +
                "112983 64533\n" +
                "94748 77395\n" +
                "66742 70559\n" +
                "103012 79520\n" +
                "71361 113431\n" +
                "88083 66534\n" +
                "94452 84655\n" +
                "90828 98645\n" +
                "79756 60749\n" +
                "72096 72131\n" +
                "71932 104782\n" +
                "101620 63612\n" +
                "73318 90594\n" +
                "92636 60097\n" +
                "118190 86426\n" +
                "113295 81705\n" +
                "67266 97142\n" +
                "80273 87258\n" +
                "113102 69041\n" +
                "87186 73633\n" +
                "83948 91052\n" +
                "95788 105898\n" +
                "89298 86449\n" +
                "96871 65999\n" +
                "104847 60971\n" +
                "93781 78337\n" +
                "61815 106018\n" +
                "109432 105466\n" +
                "67562 84127\n" +
                "96546 110423\n" +
                "102005 69219\n" +
                "105184 70059\n" +
                "85708 105956\n" +
                "114679 91691\n" +
                "80025 74175\n" +
                "95696 111694\n" +
                "62245 98577\n" +
                "72539 66832\n" +
                "88739 85130\n" +
                "64211 60218\n" +
                "82477 60107\n" +
                "77028 106366\n" +
                "98958 82266\n" +
                "103102 96711\n" +
                "97612 66436\n" +
                "113643 104280\n" +
                "116526 97263\n" +
                "71901 65051\n" +
                "65480 111902\n" +
                "92328 71692\n" +
                "78829 106809\n" +
                "112417 108368\n" +
                "78880 100417\n" +
                "82156 118402\n" +
                "61699 100896\n" +
                "93064 61271\n" +
                "81248 74645\n" +
                "102713 94925\n" +
                "78959 92896\n" +
                "98597 112182\n" +
                "117503 69972\n" +
                "116937 80570\n" +
                "115259 94225\n" +
                "98018 77367\n" +
                "76338 105845\n" +
                "63556 67530\n" +
                "82634 64932\n" +
                "77822 112554\n" +
                "106939 85279\n" +
                "103769 101182\n" +
                "113834 77141\n" +
                "75402 113278\n" +
                "87179 100367\n" +
                "99791 114250\n" +
                "70227 72981\n" +
                "82753 74517\n" +
                "66319 113874\n" +
                "101870 86364\n" +
                "73979 101180\n" +
                "76541 80591\n" +
                "93539 65995\n" +
                "83626 118867\n" +
                "105990 65972\n" +
                "94048 83660\n" +
                "110236 77398\n" +
                "102743 113746\n" +
                "104403 65711\n" +
                "79999 84772\n" +
                "118085 61216\n" +
                "84769 61153\n" +
                "78085 105684\n" +
                "92394 68837\n" +
                "79171 70004\n" +
                "65922 118440\n" +
                "105605 63862\n" +
                "65488 75709\n" +
                "102163 116364\n" +
                "99054 77863\n" +
                "71941 100230\n" +
                "80831 77082\n" +
                "101327 99782\n" +
                "81738 88105\n" +
                "94784 86427\n" +
                "70423 65566\n" +
                "114894 61878\n" +
                "106217 109736\n" +
                "101839 83471\n" +
                "74161 113563\n" +
                "105002 75827\n" +
                "61741 90033\n" +
                "115817 89757\n" +
                "103634 106313\n" +
                "77489 60162\n" +
                "88796 88466\n" +
                "110451 85867\n" +
                "70563 69202\n" +
                "90474 91265\n" +
                "75818 92323\n" +
                "77535 65561\n" +
                "62031 110558\n" +
                "88125 80147\n" +
                "91827 68806\n" +
                "113037 110690\n" +
                "101842 91303\n" +
                "106628 66611\n" +
                "66294 77449\n" +
                "66188 72504\n" +
                "75101 78421\n" +
                "84616 74974\n" +
                "61374 108681\n" +
                "63529 72189\n" +
                "86376 119442\n" +
                "83784 101292\n" +
                "104842 101376\n" +
                "93507 85037\n" +
                "69069 67275\n" +
                "64153 108002\n" +
                "84083 81414\n" +
                "87395 68552\n" +
                "86545 72330\n" +
                "88318 106634\n" +
                "102836 74007\n" +
                "103058 63295\n" +
                "89580 94592\n" +
                "74858 110727\n" +
                "90426 63318\n" +
                "94599 78751\n" +
                "119330 64702\n" +
                "83022 89217\n" +
                "94200 100902\n" +
                "73805 62698\n" +
                "92913 93949\n" +
                "95917 116764\n" +
                "66326 76797\n" +
                "90058 77908\n" +
                "60098 115264\n" +
                "82028 80414\n" +
                "71745 73140\n" +
                "104629 68155\n" +
                "118518 88358\n" +
                "112823 100856\n" +
                "64057 61146\n" +
                "60979 70627\n" +
                "109345 90138\n" +
                "85304 72763\n" +
                "64246 100616\n" +
                "81229 114024\n" +
                "69689 87741\n" +
                "72710 63097\n" +
                "94585 60855\n" +
                "113819 98710\n" +
                "107009 63192\n" +
                "68328 85812\n" +
                "84903 65983\n" +
                "103089 88637\n" +
                "64074 81520\n" +
                "60962 101285\n" +
                "83339 89660\n" +
                "84898 72345\n" +
                "119534 112322\n" +
                "60178 110288\n" +
                "108087 110629\n" +
                "85846 70634\n" +
                "111200 87784\n" +
                "62268 89804\n" +
                "113363 68352\n" +
                "67088 80833\n" +
                "66773 77009\n" +
                "71692 79299\n" +
                "102508 80240\n" +
                "76400 81262\n" +
                "67636 77490\n" +
                "89824 65440\n" +
                "82453 84977\n" +
                "116911 70858\n" +
                "72124 87304\n" +
                "107311 80062\n" +
                "85917 75275\n" +
                "102180 75232\n" +
                "115927 95533\n" +
                "69077 108189\n" +
                "79336 80051\n" +
                "79129 102314\n" +
                "95484 96326\n" +
                "108336 68797\n" +
                "84133 74261\n" +
                "86525 86806\n" +
                "74659 97484\n" +
                "94333 87800\n" +
                "110842 81493\n" +
                "86408 80033\n" +
                "97071 102506\n" +
                "110833 84069\n" +
                "92709 104140\n" +
                "77683 69057\n" +
                "118340 76346\n" +
                "94985 115918\n" +
                "80451 117296\n" +
                "78594 76078\n" +
                "86345 98319\n" +
                "90568 96565\n" +
                "115103 75263\n" +
                "64466 75472\n" +
                "119063 92761\n" +
                "104345 104195\n" +
                "64156 88083\n" +
                "110979 80597\n" +
                "80834 109930\n" +
                "103581 74533\n" +
                "65319 87017\n" +
                "118538 105058\n" +
                "104721 74802\n" +
                "98172 111455\n" +
                "102907 108682\n" +
                "72902 116232\n" +
                "93771 63435\n" +
                "75828 86066\n" +
                "86379 89893\n" +
                "85324 81902\n" +
                "104680 119719\n" +
                "79816 106359\n" +
                "113638 78353\n" +
                "69266 83039\n" +
                "82836 78914\n" +
                "90152 79968\n" +
                "115080 60351\n" +
                "107446 116430\n" +
                "98004 67689\n" +
                "85143 72566\n" +
                "69268 66298\n" +
                "110222 74977\n" +
                "72117 66890\n" +
                "65804 116033\n" +
                "106197 89651\n" +
                "97300 79655\n" +
                "89824 115323\n" +
                "65230 79652\n" +
                "104994 81731\n" +
                "74128 103111\n" +
                "69954 78069\n" +
                "101267 97527\n" +
                "72661 66198\n" +
                "89478 90882\n" +
                "117697 109295\n" +
                "88930 94965\n" +
                "112325 70496\n" +
                "89406 76969\n" +
                "113696 65594\n" +
                "100247 101371\n" +
                "69501 70093\n" +
                "70007 61237\n" +
                "81054 78955\n" +
                "65072 70045\n" +
                "97869 75739\n" +
                "79280 104564\n" +
                "86541 81037\n" +
                "91236 94152\n" +
                "117722 90501\n" +
                "110611 85262\n" +
                "109534 107929\n" +
                "77466 67172\n" +
                "88636 60662\n" +
                "103988 115706\n" +
                "109285 86587\n" +
                "117998 81970\n" +
                "114134 112021\n" +
                "88160 62596\n" +
                "101485 106748\n" +
                "109282 105696\n" +
                "68380 74825\n" +
                "63382 105202\n" +
                "79625 61436\n" +
                "100316 105464\n" +
                "116526 106043\n" +
                "116475 116621\n" +
                "73081 98339\n" +
                "95308 94094\n" +
                "95689 105221\n" +
                "119838 107361\n" +
                "89361 62330\n" +
                "77005 61933\n" +
                "104098 96466\n" +
                "95989 92450\n" +
                "69010 64471\n" +
                "88316 92781\n" +
                "67954 103948\n" +
                "79766 72315\n" +
                "98930 63773\n" +
                "95157 107015\n" +
                "117210 86861\n" +
                "119502 110785\n" +
                "99772 61058\n" +
                "83385 71802\n" +
                "60892 82647\n" +
                "89006 62377\n" +
                "94243 104650\n" +
                "68693 72418\n" +
                "82435 69511\n" +
                "80613 89658\n" +
                "104792 96486\n" +
                "91055 117373\n" +
                "60947 94432\n" +
                "102162 87142\n" +
                "116349 119252\n" +
                "84856 91144\n" +
                "116604 103047\n" +
                "78423 110939\n" +
                "104605 81222\n" +
                "76393 119618\n" +
                "69169 68857\n" +
                "94393 78777\n" +
                "113525 113392\n" +
                "114896 109900\n" +
                "76191 70195\n" +
                "60431 98995\n" +
                "99505 113959\n" +
                "78743 110118\n" +
                "98560 118867\n" +
                "62501 60142\n" +
                "112390 88973\n" +
                "118683 109764\n" +
                "60389 62715\n" +
                "81891 110861\n" +
                "80434 91458\n" +
                "78914 67673\n" +
                "87388 89176\n" +
                "78454 69669\n" +
                "118009 62302\n" +
                "69134 69477\n" +
                "78118 90392\n" +
                "81025 64969\n" +
                "70575 119143\n" +
                "111055 71968\n" +
                "63691 104700\n" +
                "90433 75296\n" +
                "81360 73475\n" +
                "91540 77031\n" +
                "99119 75082\n" +
                "100868 77442\n" +
                "118056 85675\n" +
                "65622 65346\n" +
                "115974 95246\n" +
                "94153 91031\n" +
                "78061 88905\n" +
                "86896 68600\n" +
                "100471 110632\n" +
                "112514 109755\n" +
                "75742 95354\n" +
                "63916 71293\n" +
                "99938 79733\n" +
                "117775 91643\n" +
                "76375 88940\n" +
                "103965 102249\n" +
                "93993 100714\n" +
                "80858 113587\n" +
                "108162 108357\n" +
                "93780 100905\n" +
                "119495 62237\n" +
                "116382 81561\n" +
                "61606 110175\n" +
                "108116 95840\n" +
                "94836 88623\n" +
                "110865 104165\n" +
                "103322 63007\n" +
                "90168 70604\n" +
                "83668 87029\n" +
                "93243 108133\n" +
                "64540 92590\n" +
                "89146 79777\n" +
                "109923 90018\n" +
                "82912 113967\n" +
                "109821 115463\n" +
                "70536 78429\n" +
                "109424 96717\n" +
                "76354 105658\n" +
                "102123 67924\n" +
                "113649 72932\n" +
                "86190 106554\n" +
                "110639 82751\n" +
                "105234 108495\n" +
                "118403 63955\n" +
                "80965 68859\n" +
                "89266 116437\n" +
                "61949 81196\n" +
                "90192 83473\n" +
                "61932 93200\n" +
                "68749 65427\n" +
                "77246 115124\n" +
                "77517 114531\n" +
                "90884 99092\n" +
                "102887 104176\n" +
                "111273 86413\n" +
                "88953 117585\n" +
                "78700 63250\n" +
                "111697 84789\n" +
                "116004 86977\n" +
                "116792 79666\n" +
                "73358 90778\n" +
                "83363 60629\n" +
                "91722 116621\n" +
                "93709 103855\n" +
                "98124 103461\n" +
                "82517 91697\n" +
                "119520 94941\n" +
                "73784 118774\n" +
                "87992 61720\n" +
                "87357 89745\n" +
                "112965 94667\n" +
                "78905 80268\n" +
                "66476 77969\n" +
                "116628 70108\n" +
                "81679 114452\n" +
                "67234 110146\n" +
                "119132 92600\n" +
                "111601 66269\n" +
                "72566 65193\n" +
                "115770 84782\n" +
                "74556 86648\n" +
                "75956 87736\n" +
                "107894 74086\n" +
                "96095 87462\n" +
                "105330 77311\n" +
                "68422 88440\n" +
                "102053 116744\n" +
                "92688 108919\n" +
                "92491 90470\n" +
                "69991 66527\n" +
                "86866 108727\n" +
                "81628 99907\n" +
                "94144 61642\n" +
                "85187 110640\n" +
                "71096 104836\n" +
                "85617 106446\n" +
                "92401 79883\n" +
                "71623 94102\n" +
                "80325 109145\n" +
                "65375 76850\n" +
                "61589 70843\n" +
                "95413 70291\n" +
                "80887 98843\n" +
                "88369 69047\n" +
                "76735 64160\n" +
                "92577 89980\n" +
                "100955 97536\n" +
                "107046 87097\n" +
                "83930 93583\n" +
                "109867 83797\n" +
                "88964 92436\n" +
                "89620 89298\n" +
                "101298 81626\n" +
                "64525 103819\n" +
                "100027 76897\n" +
                "90509 96140\n" +
                "89338 118207\n" +
                "71478 94720";

//        System.out.println("data ="+data);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
        List<MagicPresent.Envelope> envelopes = testTarget.readEnvelops(inputStream);
        MagicPresent.Envelope[] calculatePath = testTarget.calculatePath(envelopes);
        // postcard = 103232 75323
        // 292 172 402 36 288 60 375 131 294 188 - 10
        // 109285x86587, 109345x90138, 109424x96717, 109432x105466, 109534x107929, 112417x108368, 112514x109755,
        // 113037x110690, 114134x112021, 119534x112322

        // 117 450 205 475 123 192 348 42 71 208 55 334 272 349 319 188
        // 105002x75827, 105330x77311, 107311x80062, 109867x83797, 110451x85867, 111200x87784, 112390x88973, 114679x91691,
        // 115259x94225, 115927x95533, 116526x97263, 116604x103047, 117697x109295, 118683x109764, 119502x110785, 119534x112322
        System.out.println("Result ="+Arrays.toString(calculatePath));
        assertEquals(16, calculatePath.length);
        assertEquals(117, calculatePath[0].number);
        assertEquals(450, calculatePath[1].number);
        assertEquals(205, calculatePath[2].number);
        assertEquals(475, calculatePath[3].number);
        assertEquals(123, calculatePath[4].number);
        assertEquals(192, calculatePath[5].number);
        assertEquals(348, calculatePath[6].number);
    }

}