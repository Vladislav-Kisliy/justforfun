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
    public void calculatePath01Input() {
        String data = "2 1 1\n" +
                "2 2\n" +
                "2 2";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
        MagicPresent.Envelope[] envelopes = testTarget.readEnvelops(inputStream);
        MagicPresent.Envelope[] calculatePath = testTarget.calculatePath(envelopes);
        assertEquals(1, calculatePath.length);
        assertEquals(1, calculatePath[0].number);
    }

    @Test
    public void calculatePath03Input() {
        String data = "5 10 10\n" +
                "22 23\n" +
                "17 19\n" +
                "13 17\n" +
                "8 12\n" +
                "2 6";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
        MagicPresent.Envelope[] envelopes = testTarget.readEnvelops(inputStream);
        MagicPresent.Envelope[] calculatePath = testTarget.calculatePath(envelopes);
        assertEquals(3, calculatePath.length);
        assertEquals(3, calculatePath[0].number);
        assertEquals(2, calculatePath[1].number);
        assertEquals(1, calculatePath[2].number);
    }

    @Test
    public void calculatePath04Input() {
        String data = "5 13 13\n" +
                "4 4\n" +
                "10 10\n" +
                "7 7\n" +
                "1 1\n" +
                "13 13";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
        MagicPresent.Envelope[] envelopes = testTarget.readEnvelops(inputStream);
        MagicPresent.Envelope[] calculatePath = testTarget.calculatePath(envelopes);
        assertEquals(0, calculatePath.length);
    }

    @Test
    public void calculatePath05Input() {
        String data = "4 12 140\n" +
                "172 60\n" +
                "71 95\n" +
                "125 149\n" +
                "53 82";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
        MagicPresent.Envelope[] envelopes = testTarget.readEnvelops(inputStream);
        assertEquals(1, testTarget.calculatePath(envelopes).length);
    }

    @Test
    public void calculatePath07Input() {
        String data = "4 100 100\n" +
                "332 350\n" +
                "232 250\n" +
                "32 50\n" +
                "132 150";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
        MagicPresent.Envelope[] envelopes = testTarget.readEnvelops(inputStream);
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
        MagicPresent.Envelope[] envelopes = testTarget.readEnvelops(inputStream);
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
        MagicPresent.Envelope[] envelopes = testTarget.readEnvelops(inputStream);
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
        MagicPresent.Envelope[] envelopes = testTarget.readEnvelops(inputStream);

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
        MagicPresent.Envelope[] envelopes = testTarget.readEnvelops(inputStream);
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
        MagicPresent.Envelope[] envelopes = testTarget.readEnvelops(inputStream);
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
        MagicPresent.Envelope[] envelopes = testTarget.readEnvelops(inputStream);
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
        MagicPresent.Envelope[] envelopes = testTarget.readEnvelops(inputStream);
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
        MagicPresent.Envelope[] envelopes = testTarget.readEnvelops(inputStream);
        MagicPresent.Envelope[] calculatePath = testTarget.calculatePath(envelopes);
        assertEquals(3, calculatePath.length);
        assertEquals(19, calculatePath[0].number);
        assertEquals(1, calculatePath[1].number);
        assertEquals(38, calculatePath[2].number);
    }

    @Test
    public void calculatePath19Input() {
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
        MagicPresent.Envelope[] envelopes = testTarget.readEnvelops(inputStream);
        MagicPresent.Envelope[] calculatePath = testTarget.calculatePath(envelopes);

        // 117 450 205 475 123 192 348 42 71 208 55 334 272 349 319 188
        // 105002x75827, 105330x77311, 107311x80062, 109867x83797, 110451x85867, 111200x87784, 112390x88973, 114679x91691,
        // 115259x94225, 115927x95533, 116526x97263, 116604x103047, 117697x109295, 118683x109764, 119502x110785, 119534x112322
        System.out.println("Result =" + Arrays.toString(calculatePath));
        assertEquals(16, calculatePath.length);
        assertEquals(117, calculatePath[0].number);
        assertEquals(450, calculatePath[1].number);
        assertEquals(205, calculatePath[2].number);
        assertEquals(475, calculatePath[3].number);
        assertEquals(123, calculatePath[4].number);
        assertEquals(192, calculatePath[5].number);
        assertEquals(348, calculatePath[6].number);
        assertEquals(42, calculatePath[7].number);
        assertEquals(71, calculatePath[8].number);
        assertEquals(208, calculatePath[9].number);
        assertEquals(55, calculatePath[10].number);
        assertEquals(334, calculatePath[11].number);
        assertEquals(272, calculatePath[12].number);
        assertEquals(349, calculatePath[13].number);
        assertEquals(319, calculatePath[14].number);
        assertEquals(188, calculatePath[15].number);
    }

//    @Test(timeout = 1000)
    @Test
    public void calculatePath26Input() {
//        String data = "5000 400000 400000\n" +
        String data = "1241 400000 400000\n" +
                "655697 346728\n" +
                "506146 408577\n" +
                "644909 417372\n" +
                "737388 349307\n" +
                "307574 545826\n" +
                "976334 350867\n" +
                "790736 749681\n" +
                "735758 839845\n" +
                "442610 886287\n" +
                "611806 853295\n" +
                "334932 994166\n" +
                "478899 781905\n" +
                "506900 755223\n" +
                "576200 925071\n" +
                "975354 796998\n" +
                "849372 526506\n" +
                "613564 598990\n" +
                "451667 664885\n" +
                "408210 425145\n" +
                "711699 305775\n" +
                "333288 845965\n" +
                "479027 998376\n" +
                "577147 776889\n" +
                "497805 589263\n" +
                "603148 768897\n" +
                "383724 514590\n" +
                "791323 509870\n" +
                "767586 510796\n" +
                "541176 617378\n" +
                "524035 875525\n" +
                "321091 750643\n" +
                "487561 580093\n" +
                "986052 515610,\n" +
                "552910 392142,\n" +
                "496520 700943,\n" +
                "902904 385288,\n" +
                "703393 625445,\n" +
                "388461 838809,\n" +
                "798688 542839,\n" +
                "867908 490684,\n" +
                "883216 593637,\n" +
                "310397 682446,\n" +
                "736567 820349,\n" +
                "861711 361497,\n" +
                "415957 326581,\n" +
                "519183 896217,\n" +
                "551211 709748,\n" +
                "381948 883902,\n" +
                "540570 325681,\n" +
                "926970 898687,\n" +
                "880107 539103,\n" +
                "959310 964133,\n" +
                "923798 669068,\n" +
                "937062 712505,\n" +
                "831126 917300,\n" +
                "466348 418668,\n" +
                "608466 938598,\n" +
                "844029 345314,\n" +
                "627952 615175,\n" +
                "901697 912674,\n" +
                "914635 338843,\n" +
                "514412 881295,\n" +
                "720689 494593,\n" +
                "635283 442445,\n" +
                "358942 302074,\n" +
                "835939 528409,\n" +
                "439471 795678,\n" +
                "589862 861466,\n" +
                "518742 888973,\n" +
                "490281 518883,\n" +
                "861807 842864,\n" +
                "489779 972907,\n" +
                "585432 955868,\n" +
                "854546 773346,\n" +
                "987146 760793,\n" +
                "577491 576433,\n" +
                "558730 852541,\n" +
                "850816 405970,\n" +
                "544499 557273,\n" +
                "606215 387898,\n" +
                "430999 625254,\n" +
                "328465 842354,\n" +
                "803956 490371,\n" +
                "755097 574555,\n" +
                "889925 550110,\n" +
                "966649 801716,\n" +
                "821782 652279,\n" +
                "319913 558716,\n" +
                "508655 397607,\n" +
                "665481 547449,\n" +
                "915026 740883,\n" +
                "556956 490874,\n" +
                "675412 908416,\n" +
                "549006 780736,\n" +
                "529801 890805,\n" +
                "758350 424572,\n" +
                "955426 345811,\n" +
                "833990 745799,\n" +
                "505979 853857,\n" +
                "658080 922825,\n" +
                "808336 388867,\n" +
                "501098 521849,\n" +
                "408600 612578,\n" +
                "898865 549304,\n" +
                "736661 714211,\n" +
                "954638 939381,\n" +
                "988367 502254,\n" +
                "681018 787690,\n" +
                "455338 302471,\n" +
                "905854 884247,\n" +
                "932766 731324,\n" +
                "839661 461272,\n" +
                "523460 760924,\n" +
                "677046 496330,\n" +
                "847400 719425,\n" +
                "764310 694994,\n" +
                "754449 961489,\n" +
                "537665 445363,\n" +
                "375681 552713,\n" +
                "328336 659949,\n" +
                "813382 516293,\n" +
                "450828 884773,\n" +
                "561199 471680,\n" +
                "628566 549660,\n" +
                "898422 656422,\n" +
                "439040 597429,\n" +
                "656231 682907,\n" +
                "714071 354056,\n" +
                "901210 624739,\n" +
                "839505 730819,\n" +
                "333850 708558,\n" +
                "922822 777500,\n" +
                "994920 773740,\n" +
                "844942 306276,\n" +
                "306461 778852,\n" +
                "621779 684527,\n" +
                "982518 480153,\n" +
                "369959 888338,\n" +
                "979919 906594,\n" +
                "877879 772656,\n" +
                "988335 686493,\n" +
                "991245 931310,\n" +
                "361060 548015,\n" +
                "607116 426707,\n" +
                "337088 315734,\n" +
                "697632 805523,\n" +
                "871126 734269,\n" +
                "847837 995944,\n" +
                "364203 851181,\n" +
                "764321 892231,\n" +
                "483395 475404,\n" +
                "697888 470314,\n" +
                "576388 411429,\n" +
                "826188 380210,\n" +
                "639650 873961,\n" +
                "737837 983414,\n" +
                "646775 450284,\n" +
                "623814 949856,\n" +
                "808097 467583,\n" +
                "421031 906905,\n" +
                "678370 821064,\n" +
                "779825 668092,\n" +
                "583239 461032,\n" +
                "327917 881931,\n" +
                "704358 406579,\n" +
                "367785 951239,\n" +
                "771744 445434,\n" +
                "355237 952070,\n" +
                "775846 816801,\n" +
                "607247 417818,\n" +
                "735013 380239,\n" +
                "456494 486152,\n" +
                "949216 832406,\n" +
                "660133 638903,\n" +
                "774231 690460,\n" +
                "390380 855895,\n" +
                "526049 487506,\n" +
                "936342 670458,\n" +
                "502847 921893,\n" +
                "752512 344698,\n" +
                "478212 657980,\n" +
                "829742 492367,\n" +
                "871967 814635,\n" +
                "538190 910908,\n" +
                "378638 915340,\n" +
                "715394 423987,\n" +
                "592233 573322,\n" +
                "656006 970514,\n" +
                "673474 445124,\n" +
                "898668 594524,\n" +
                "523720 900909,\n" +
                "609833 867879,\n" +
                "696424 543362,\n" +
                "844806 679402,\n" +
                "985916 830141,\n" +
                "706855 665499,\n" +
                "921425 806713,\n" +
                "827944 501203,\n" +
                "550852 466408,\n" +
                "567417 631301,\n" +
                "464055 865741,\n" +
                "311381 525925,\n" +
                "434483 964539,\n" +
                "467235 637620,\n" +
                "609752 400832,\n" +
                "917433 657482,\n" +
                "686668 411394,\n" +
                "724825 362887,\n" +
                "979234 415073,\n" +
                "350028 405691,\n" +
                "662815 434565,\n" +
                "584250 566643,\n" +
                "787338 440834,\n" +
                "574984 768660,\n" +
                "405307 384257,\n" +
                "761694 463453,\n" +
                "443700 861314,\n" +
                "385208 611026,\n" +
                "695539 664379,\n" +
                "707229 595274,\n" +
                "497701 644160,\n" +
                "406405 695234,\n" +
                "462611 919237,\n" +
                "355506 749371,\n" +
                "580195 925516,\n" +
                "978446 517287,\n" +
                "785544 530422,\n" +
                "686141 797494,\n" +
                "933627 348962,\n" +
                "598297 776326,\n" +
                "793280 633983,\n" +
                "401990 683791,\n" +
                "686223 718533,\n" +
                "991048 767037,\n" +
                "860865 344090,\n" +
                "481601 979983,\n" +
                "430757 997649,\n" +
                "349620 721338,\n" +
                "364297 703327,\n" +
                "519518 841443,\n" +
                "360111 634549,\n" +
                "509190 923559,\n" +
                "639493 305275,\n" +
                "433751 636860,\n" +
                "318253 914892,\n" +
                "928399 572825,\n" +
                "308945 894942,\n" +
                "745098 938517,\n" +
                "711661 430457,\n" +
                "625478 572083,\n" +
                "934688 527497,\n" +
                "485144 367531,\n" +
                "845756 783596,\n" +
                "999264 807039,\n" +
                "547748 826448,\n" +
                "513286 365259,\n" +
                "819518 658345,\n" +
                "397453 646483,\n" +
                "826121 688114,\n" +
                "459700 795827,\n" +
                "334319 800282,\n" +
                "483189 387294,\n" +
                "602713 486459,\n" +
                "768822 952238,\n" +
                "698586 838921,\n" +
                "575698 897166,\n" +
                "404368 625228,\n" +
                "307922 685175,\n" +
                "457510 940035,\n" +
                "477138 569093,\n" +
                "882503 319407,\n" +
                "828068 978306,\n" +
                "924551 428064,\n" +
                "654499 446333,\n" +
                "751910 591574,\n" +
                "841328 847694,\n" +
                "385251 669297,\n" +
                "854692 814460,\n" +
                "620264 423889,\n" +
                "474542 972115,\n" +
                "780272 865791,\n" +
                "824655 613889,\n" +
                "460895 804960,\n" +
                "561915 337591,\n" +
                "462134 974043,\n" +
                "309863 788627,\n" +
                "911041 809602,\n" +
                "705108 438978,\n" +
                "308501 613704,\n" +
                "802269 528541,\n" +
                "829975 996298,\n" +
                "575150 789377,\n" +
                "687266 765369,\n" +
                "850107 814511,\n" +
                "431055 633889,\n" +
                "849454 318826,\n" +
                "973091 429968,\n" +
                "806735 731179,\n" +
                "780738 762327,\n" +
                "890827 312132,\n" +
                "743595 509194,\n" +
                "885643 970279,\n" +
                "387242 967345,\n" +
                "309027 611408,\n" +
                "420376 520324,\n" +
                "662327 749693,\n" +
                "423890 870136,\n" +
                "398833 901806,\n" +
                "495671 404694,\n" +
                "882846 332107,\n" +
                "792376 974114,\n" +
                "305587 675955,\n" +
                "516250 417645,\n" +
                "429080 707090,\n" +
                "486143 302634,\n" +
                "803341 717264,\n" +
                "829593 809176,\n" +
                "772891 807160,\n" +
                "778793 944158,\n" +
                "715090 937084,\n" +
                "513211 516405,\n" +
                "338818 940649,\n" +
                "368231 826570,\n" +
                "706749 825252,\n" +
                "964232 763593,\n" +
                "848024 779746,\n" +
                "950408 792713,\n" +
                "411570 844450,\n" +
                "882601 518887,\n" +
                "512437 822642,\n" +
                "358091 854252,\n" +
                "844907 842031,\n" +
                "328350 395541,\n" +
                "676948 608431,\n" +
                "435010 725929,\n" +
                "798195 602874,\n" +
                "909534 828794,\n" +
                "719242 673423,\n" +
                "428433 582057,\n" +
                "918849 775393,\n" +
                "900254 466088,\n" +
                "337207 665487,\n" +
                "745818 739794,\n" +
                "351589 554923,\n" +
                "978461 639794,\n" +
                "800534 469579,\n" +
                "300451 681210,\n" +
                "857025 609884,\n" +
                "359363 663962,\n" +
                "536335 613256,\n" +
                "757458 452817,\n" +
                "455161 756449,\n" +
                "373538 469764,\n" +
                "966347 561708,\n" +
                "398524 669111,\n" +
                "720807 368519,\n" +
                "516797 337219,\n" +
                "754147 507352,\n" +
                "684478 368229,\n" +
                "829558 764456,\n" +
                "778573 642144,\n" +
                "975370 964236,\n" +
                "428683 333277,\n" +
                "675063 447725,\n" +
                "401002 472285,\n" +
                "540568 906226,\n" +
                "913659 340397,\n" +
                "848153 718085,\n" +
                "521565 778226,\n" +
                "727824 666331,\n" +
                "799335 628875,\n" +
                "315736 954431,\n" +
                "538860 565278,\n" +
                "344535 928021,\n" +
                "370972 650497,\n" +
                "661650 394707,\n" +
                "308341 994559,\n" +
                "554652 314150,\n" +
                "567995 498150,\n" +
                "730103 655114,\n" +
                "912664 846513,\n" +
                "784621 441479,\n" +
                "395334 586976,\n" +
                "361990 539868,\n" +
                "991753 964912,\n" +
                "378882 673184,\n" +
                "453426 981756,\n" +
                "430657 452666,\n" +
                "770765 985143,\n" +
                "416036 816786,\n" +
                "404334 987780,\n" +
                "578095 890477,\n" +
                "538876 351149,\n" +
                "753408 910788,\n" +
                "320682 682407,\n" +
                "411622 708118,\n" +
                "776663 400328,\n" +
                "747852 765387,\n" +
                "739168 540408,\n" +
                "660269 958391,\n" +
                "799541 832879,\n" +
                "621452 317826,\n" +
                "557592 755241,\n" +
                "412213 779919,\n" +
                "811697 651110,\n" +
                "305384 913547,\n" +
                "400632 912757,\n" +
                "549283 561313,\n" +
                "432219 547485,\n" +
                "875284 910955,\n" +
                "923514 642123,\n" +
                "414797 879836,\n" +
                "531199 872541,\n" +
                "567822 447937,\n" +
                "392089 667599,\n" +
                "961169 800638,\n" +
                "610602 966053,\n" +
                "935684 763149,\n" +
                "699036 889766,\n" +
                "499463 558455,\n" +
                "796521 991987,\n" +
                "838642 921214,\n" +
                "374882 604087,\n" +
                "479383 704728,\n" +
                "441117 618241,\n" +
                "542792 953020,\n" +
                "690805 900517,\n" +
                "629222 637312,\n" +
                "303648 919822,\n" +
                "738594 376744,\n" +
                "980823 592214,\n" +
                "464530 438731,\n" +
                "954983 770755,\n" +
                "649247 640221,\n" +
                "463323 624079,\n" +
                "921862 399199,\n" +
                "443004 333357,\n" +
                "619118 314936,\n" +
                "452713 494581,\n" +
                "691237 948404,\n" +
                "433761 673909,\n" +
                "537836 314288,\n" +
                "647553 773505,\n" +
                "987017 738602,\n" +
                "376652 760397,\n" +
                "684496 492798,\n" +
                "800742 787533,\n" +
                "404425 939607,\n" +
                "983893 762967,\n" +
                "600664 606265,\n" +
                "805437 936350,\n" +
                "957796 362930,\n" +
                "685474 624441,\n" +
                "824965 363223,\n" +
                "935551 971640,\n" +
                "792391 740966,\n" +
                "334227 979767,\n" +
                "381181 925505,\n" +
                "931734 962872,\n" +
                "380484 381005,\n" +
                "535136 759410,\n" +
                "658363 936376,\n" +
                "614786 440405,\n" +
                "611252 402375,\n" +
                "628869 353203,\n" +
                "334054 601756,\n" +
                "598977 503609,\n" +
                "537727 554389,\n" +
                "934310 632109,\n" +
                "717905 387622,\n" +
                "662525 590811,\n" +
                "654711 594784,\n" +
                "874265 974497,\n" +
                "702770 826499,\n" +
                "864327 737935,\n" +
                "433355 849457,\n" +
                "662628 365241,\n" +
                "773509 712375,\n" +
                "752260 370357,\n" +
                "496420 690634,\n" +
                "656044 593655,\n" +
                "874298 349858,\n" +
                "442669 442151,\n" +
                "885571 400311,\n" +
                "799541 417178,\n" +
                "842231 492558,\n" +
                "403574 545670,\n" +
                "816888 360819,\n" +
                "332663 626990,\n" +
                "951002 959552,\n" +
                "988528 965398,\n" +
                "699833 802457,\n" +
                "579667 684602,\n" +
                "543655 798853,\n" +
                "750733 378058,\n" +
                "471784 477672,\n" +
                "489747 322931,\n" +
                "353033 629779,\n" +
                "825601 779891,\n" +
                "910482 973989,\n" +
                "446086 319615,\n" +
                "570862 889081,\n" +
                "485199 922691,\n" +
                "817041 755506,\n" +
                "827718 999777,\n" +
                "834587 465062,\n" +
                "615508 447116,\n" +
                "425930 891202,\n" +
                "534428 630896,\n" +
                "934265 525418,\n" +
                "423053 574153,\n" +
                "927613 836186,\n" +
                "470055 637133,\n" +
                "831592 553611,\n" +
                "772070 554314,\n" +
                "608759 728968,\n" +
                "887879 948319,\n" +
                "644583 878060,\n" +
                "614392 379409,\n" +
                "789945 655613,\n" +
                "541900 764246,\n" +
                "619886 789708,\n" +
                "703432 683743,\n" +
                "871653 580325,\n" +
                "832514 347303,\n" +
                "399516 630776,\n" +
                "906291 448184,\n" +
                "348192 591336,\n" +
                "496189 572157,\n" +
                "497087 381156,\n" +
                "884026 381240,\n" +
                "421952 356964,\n" +
                "574783 854606,|\n" +
                "758339 521491,\n" +
                "729409 446418,\n" +
                "413791 395584,\n" +
                "877315 544817,\n" +
                "499671 363875,\n" +
                "859538 771496,\n" +
                "553728 579503,\n" +
                "599558 628353,\n" +
                "858814 306648,\n" +
                "477536 468313,\n" +
                "802500 393083,\n" +
                "867929 856950,\n" +
                "443685 607423,\n" +
                "963350 593756,\n" +
                "557246 690851,\n" +
                "979542 350915,\n" +
                "429286 446843,\n" +
                "524456 779514,\n" +
                "379300 859556,\n" +
                "526055 446934,\n" +
                "514315 980168,\n" +
                "816138 976673,\n" +
                "463574 755054,\n" +
                "947312 904313,\n" +
                "509897 634749,\n" +
                "536566 529556,\n" +
                "571129 858592,\n" +
                "894649 308061,\n" +
                "330260 875704,\n" +
                "920090 391026,\n" +
                "430125 819789,\n" +
                "774610 350346,\n" +
                "336021 490104,\n" +
                "695832 943140,\n" +
                "313133 358689,\n" +
                "945000 483531,\n" +
                "843973 664257,\n" +
                "376566 765606,\n" +
                "408948 745028,\n" +
                "914698 469275,\n" +
                "953599 641665,\n" +
                "496259 307230,\n" +
                "680671 353683,\n" +
                "611982 725772,\n" +
                "663838 412854,\n" +
                "787713 875030,\n" +
                "787278 303173,\n" +
                "467507 373403,\n" +
                "310260 374450,\n" +
                "307085 552802,\n" +
                "475842 568296,\n" +
                "739628 666560,\n" +
                "859190 980570,\n" +
                "320063 791610,\n" +
                "372506 599695,\n" +
                "517408 913333,\n" +
                "579604 562672,\n" +
                "496415 885765,\n" +
                "426936 655621,\n" +
                "525015 888099,\n" +
                "557548 532864,\n" +
                "852213 912945,\n" +
                "313594 438196,\n" +
                "784196 312628,\n" +
                "316175 605517,\n" +
                "459457 665133,\n" +
                "530097 893045,\n" +
                "313947 772316,\n" +
                "406236 571970,\n" +
                "732681 391576,\n" +
                "927744 944135,\n" +
                "533868 739985,\n" +
                "509512 974932,\n" +
                "698055 801969,\n" +
                "924363 768176,\n" +
                "627160 685617,\n" +
                "416321 418273,\n" +
                "771493 566050,\n" +
                "499396 540225,\n" +
                "731993 883596,\n" +
                "309711 707148,\n" +
                "518825 474145,\n" +
                "998436 498881,\n" +
                "746547 721744,\n" +
                "373199 582826,\n" +
                "918279 952167,\n" +
                "514017 528055,\n" +
                "859557 543182,\n" +
                "385635 670875,\n" +
                "670792 445519,\n" +
                "538298 850319,\n" +
                "688227 408056,\n" +
                "710890 581021,\n" +
                "643165 725373,\n" +
                "858347 850977,\n" +
                "803679 747582,\n" +
                "828480 484168,\n" +
                "304913 793842,\n" +
                "321301 954775,\n" +
                "645861 913872,\n" +
                "605683 557132,\n" +
                "697030 568142,\n" +
                "573339 513645,\n" +
                "977555 581746,\n" +
                "985629 689145,\n" +
                "707971 710200,\n" +
                "594511 793739,\n" +
                "921781 753101,\n" +
                "770252 898432,\n" +
                "307682 323436,\n" +
                "676439 748374,\n" +
                "316512 462653,\n" +
                "727343 780325,\n" +
                "509167 986485,\n" +
                "691940 337881,\n" +
                "569606 427080,\n" +
                "714007 851791,\n" +
                "506514 448973,\n" +
                "693284 708007,\n" +
                "937031 968856,\n" +
                "844257 571991,\n" +
                "879451 932822,\n" +
                "968745 408697,\n" +
                "555792 776068,\n" +
                "452289 489874,\n" +
                "924206 380934,\n" +
                "603333 890543,\n" +
                "656573 570403,\n" +
                "515640 546445,\n" +
                "462168 629273,\n" +
                "838587 817201,\n" +
                "932165 609070,\n" +
                "603479 610269,\n" +
                "706848 531387,\n" +
                "871106 824221,\n" +
                "523738 970250,\n" +
                "752745 361296,\n" +
                "784665 704769,\n" +
                "760671 800256,\n" +
                "925448 856696,\n" +
                "996906 432631,\n" +
                "837160 848933,\n" +
                "649541 352778,\n" +
                "916269 639237,\n" +
                "517799 403753,\n" +
                "821015 687855,\n" +
                "519452 717157,\n" +
                "953823 456993,\n" +
                "618497 509660,\n" +
                "524323 881937,\n" +
                "512111 942344,\n" +
                "354968 645626,\n" +
                "626436 643385,\n" +
                "918102 835287,\n" +
                "303241 336328,\n" +
                "477950 465071,\n" +
                "851511 548568,\n" +
                "834942 975280,\n" +
                "315254 362722,\n" +
                "598336 620984,\n" +
                "402530 639732,\n" +
                "773209 344759,\n" +
                "587317 384899,\n" +
                "436798 886282,\n" +
                "573789 693347,\n" +
                "740830 960878,\n" +
                "468647 921358,\n" +
                "672311 454103,\n" +
                "733509 990720,\n" +
                "518536 948553,\n" +
                "659342 325519,\n" +
                "393677 450466,\n" +
                "701351 977559,\n" +
                "763380 335511,\n" +
                "535733 792568,\n" +
                "893589 499994,\n" +
                "926716 815654,\n" +
                "860503 795824,\n" +
                "766931 834626,\n" +
                "824855 909053,\n" +
                "890772 471268,\n" +
                "405275 459533,\n" +
                "804648 872223,\n" +
                "675391 505778,\n" +
                "789099 549474,\n" +
                "888961 910174,\n" +
                "373261 625630,\n" +
                "838755 384677,\n" +
                "672191 605187,\n" +
                "870186 674359,\n" +
                "964134 499033,\n" +
                "647466 497307,\n" +
                "953685 448409,\n" +
                "796938 604443,\n" +
                "463178 692724,\n" +
                "689712 601219,\n" +
                "607434 650425,\n" +
                "704392 934913,\n" +
                "851237 581870,\n" +
                "914578 952139,\n" +
                "491067 832710,\n" +
                "539087 645719,\n" +
                "790047 300784,\n" +
                "339788 444784,\n" +
                "318411 565614,\n" +
                "478939 608843,\n" +
                "368007 409649,\n" +
                "391639 950780,\n" +
                "441539 945737,\n" +
                "584517 959757,\n" +
                "320878 706325,\n" +
                "898142 998594,\n" +
                "873919 991259,\n" +
                "380773 943035,\n" +
                "962670 373078,\n" +
                "744089 947785,\n" +
                "601751 431293,\n" +
                "562615 630426,\n" +
                "690834 792712,\n" +
                "642463 742604,\n" +
                "464045 707411,\n" +
                "541598 806032,\n" +
                "643811 315062,\n" +
                "553700 666806,\n" +
                "311664 351685,\n" +
                "909447 734388,\n" +
                "770729 388599,\n" +
                "569919 965178,\n" +
                "899308 771933,\n" +
                "887978 608357,\n" +
                "741011 643422,\n" +
                "695224 373321,\n" +
                "810190 569260,\n" +
                "931279 993263,\n" +
                "929096 379490,\n" +
                "675787 820800,\n" +
                "384585 434557,\n" +
                "617654 416591,\n" +
                "389729 643604,\n" +
                "628999 548008,\n" +
                "484389 648394,\n" +
                "791388 984972,\n" +
                "354994 366314,\n" +
                "974717 345804,\n" +
                "681204 642566,\n" +
                "412274 766672,\n" +
                "789268 876031,\n" +
                "968252 417966,\n" +
                "582091 427367,\n" +
                "348865 950414,\n" +
                "552738 606694,\n" +
                "525425 540315,\n" +
                "428114 824037,\n" +
                "567737 466469,\n" +
                "307233 605933,\n" +
                "588828 314825,\n" +
                "991939 390406,\n" +
                "352099 977450,\n" +
                "378173 808775,\n" +
                "578117 449225,\n" +
                "472901 945615,\n" +
                "773199 549919,\n" +
                "966307 726527,\n" +
                "644430 915505,\n" +
                "887365 680066,\n" +
                "680286 369653,\n" +
                "963050 625431,\n" +
                "981652 998542,\n" +
                "813144 346707,\n" +
                "960260 707277,\n" +
                "466739 980201,\n" +
                "331337 400172,\n" +
                "303168 628355,\n" +
                "804058 546452,\n" +
                "628724 675544,\n" +
                "810053 727157,\n" +
                "869287 403886,\n" +
                "971336 522148,\n" +
                "309059 565250,\n" +
                "580745 995325,\n" +
                "618286 506467,\n" +
                "718293 589358,\n" +
                "995431 566844,\n" +
                "685671 332998,\n" +
                "488096 639549,\n" +
                "850767 554950,\n" +
                "746661 586711,\n" +
                "891116 660331,\n" +
                "583856 929235,\n" +
                "849773 604675,\n" +
                "915036 864966,\n" +
                "779452 430419,\n" +
                "449752 358196,\n" +
                "831428 399122,\n" +
                "423473 579144,\n" +
                "638389 925631,\n" +
                "988149 492396,\n" +
                "928142 487824,\n" +
                "942783 301184,\n" +
                "886505 516906,|\n" +
                "925757 400614,\n" +
                "710256 779280,\n" +
                "663787 425421,\n" +
                "549760 758902,\n" +
                "488191 850107,\n" +
                "426289 869812,\n" +
                "450146 584365,\n" +
                "372485 525106,\n" +
                "903901 733802,\n" +
                "734448 816195,\n" +
                "878691 539653,\n" +
                "919188 732907,\n" +
                "708927 867615,\n" +
                "910496 343167,\n" +
                "658943 711021,\n" +
                "335084 743179,\n" +
                "657045 479989,\n" +
                "609698 795339,\n" +
                "569241 922367,\n" +
                "541050 883505,\n" +
                "724663 760854,\n" +
                "399235 571629,\n" +
                "489543 318158,\n" +
                "935849 633382,\n" +
                "630778 770104,\n" +
                "809065 840964,\n" +
                "528236 538970,\n" +
                "852287 594133,\n" +
                "961039 614706,\n" +
                "858783 704686,\n" +
                "782452 913089,\n" +
                "436448 877984,\n" +
                "648463 729396,\n" +
                "975838 683471,\n" +
                "971704 436008,\n" +
                "468717 960767,\n" +
                "517209 745581,\n" +
                "963214 527037,\n" +
                "737130 801114,\n" +
                "788292 380968,\n" +
                "840322 323763,\n" +
                "683948 917695,\n" +
                "976173 428242,\n" +
                "649943 685831,\n" +
                "561535 790805,\n" +
                "737692 741191,\n" +
                "482102 452527,\n" +
                "946962 483307,\n" +
                "348993 928394,\n" +
                "377974 775229,\n" +
                "800990 753105,\n" +
                "704315 920581,\n" +
                "899021 389015,\n" +
                "908255 767180,\n" +
                "984857 325463,\n" +
                "369644 380865,\n" +
                "708916 335095,\n" +
                "766427 308979,\n" +
                "553738 582387,\n" +
                "938796 961229,\n" +
                "735109 304474,\n" +
                "894980 972670,\n" +
                "645148 484608,\n" +
                "638346 447917,\n" +
                "483583 810954,\n" +
                "427769 367869,\n" +
                "527028 630875,\n" +
                "986960 858638,\n" +
                "437546 705602,\n" +
                "476096 438320,\n" +
                "601093 994909,\n" +
                "562720 998531,\n" +
                "342958 829027,\n" +
                "359666 755531,\n" +
                "973997 753249,\n" +
                "968064 470621,\n" +
                "972814 599622,\n" +
                "974979 920666,\n" +
                "684398 590002,\n" +
                "867896 648502,\n" +
                "802457 907478,\n" +
                "812933 304807,\n" +
                "855113 561722,\n" +
                "864340 370568,\n" +
                "456214 653610,\n" +
                "882528 851853,\n" +
                "555575 934791,\n" +
                "375049 753303,\n" +
                "887843 434691,\n" +
                "583881 433232,\n" +
                "383354 982399,\n" +
                "543662 706969,\n" +
                "429532 542113,\n" +
                "504260 647789,\n" +
                "446218 758116,\n" +
                "967950 441520,\n" +
                "426565 967764,\n" +
                "641027 381721,\n" +
                "318310 603685,\n" +
                "346314 942608,\n" +
                "929097 724964,\n" +
                "565494 785777,\n" +
                "526125 843365,\n" +
                "307101 781860,\n" +
                "528427 781340,\n" +
                "961288 564251,\n" +
                "746441 466340,\n" +
                "539250 333518,\n" +
                "550916 349353,\n" +
                "340165 526660,\n" +
                "962649 523399,\n" +
                "366781 579428,\n" +
                "696413 957681,\n" +
                "417161 738036,\n" +
                "601498 539228,\n" +
                "489053 752704,\n" +
                "527642 370529,\n" +
                "324493 724592,\n" +
                "744844 888508,\n" +
                "983236 999080,\n" +
                "815491 718678,\n" +
                "479865 567150,\n" +
                "450181 939615,\n" +
                "405068 578404,\n" +
                "655569 400250,\n" +
                "533224 426111,\n" +
                "520943 827970,\n" +
                "689906 702262,\n" +
                "594703 917377,\n" +
                "531800 841025,\n" +
                "826610 355135,\n" +
                "708292 911647,\n" +
                "623844 553589,\n" +
                "643987 697305,\n" +
                "993043 795099,\n" +
                "333207 579200,\n" +
                "706014 943657,\n" +
                "362605 722216,\n" +
                "763552 771479,\n" +
                "520671 850113,\n" +
                "791355 791051,\n" +
                "946646 301590,\n" +
                "316066 681855,\n" +
                "728737 473008,\n" +
                "511192 337820,\n" +
                "485355 730059,\n" +
                "833586 592484,\n" +
                "342555 511723,\n" +
                "623149 480505,\n" +
                "463461 823721,\n" +
                "543466 403048,\n" +
                "991760 634375,\n" +
                "604215 518662,\n" +
                "576727 495220,\n" +
                "349566 819315,\n" +
                "384293 461666,\n" +
                "824635 535610,\n" +
                "595495 766894,\n" +
                "384674 424326,\n" +
                "370241 607760,\n" +
                "664849 870766,\n" +
                "700584 911743,\n" +
                "472079 320604,\n" +
                "326057 315398,\n" +
                "753798 381897,\n" +
                "340210 597691,\n" +
                "579376 718899,\n" +
                "626450 577596,\n" +
                "758145 996150,\n" +
                "609538 876389,\n" +
                "338747 517934,\n" +
                "604369 853360,\n" +
                "861876 941681,\n" +
                "681780 767195,\n" +
                "357988 824596,\n" +
                "519173 907914,\n" +
                "304164 362849,\n" +
                "888282 418096,\n" +
                "736410 511280,\n" +
                "711586 954436,\n" +
                "949973 587521,\n" +
                "672388 433994,\n" +
                "560919 571121,\n" +
                "850523 454885,\n" +
                "421115 590033,\n" +
                "659041 977799,\n" +
                "835403 842140,\n" +
                "488842 965938,\n" +
                "448840 898588,\n" +
                "646331 611081,\n" +
                "979638 725344,\n" +
                "933755 509474,\n" +
                "545333 723114,\n" +
                "387157 396199,\n" +
                "911281 667943,\n" +
                "522480 804959,\n" +
                "446738 573992,\n" +
                "353615 655085,\n" +
                "823719 384194,\n" +
                "719375 309396,\n" +
                "724031 837012,\n" +
                "416410 523672,\n" +
                "882501 646914,\n" +
                "956050 692921,\n" +
                "757497 763252,\n" +
                "700060 773756,\n" +
                "300651 564451,\n" +
                "559744 614982,\n" +
                "852666 608857,\n" +
                "776442 960885,\n" +
                "496665 393948,\n" +
                "676907 375872,\n" +
                "349363 606202,\n" +
                "835397 983210,\n" +
                "969400 736968,\n" +
                "992650 973051,\n" +
                "731980 504641,\n" +
                "960314 901995,\n" +
                "956432 342030,\n" +
                "823980 419306,\n" +
                "411676 648896,\n" +
                "649702 405893,\n" +
                "797683 939551,\n" +
                "336207 939646,\n" +
                "931637 973027,\n" +
                "576278 795416,\n" +
                "626959 684833,\n" +
                "738336 773222,\n" +
                "375598 671000,\n" +
                "854147 630651,\n" +
                "304843 953419,\n" +
                "321667 506589,\n" +
                "336948 947606,\n" +
                "384839 311933,\n" +
                "948499 463706,\n" +
                "640520 684056,\n" +
                "583935 517894,\n" +
                "302934 322371,\n" +
                "651856 989637,\n" +
                "816193 501260,\n" +
                "447650 585316,\n" +
                "946073 856953,\n" +
                "827551 993562,\n" +
                "718894 636156,\n" +
                "894659 962834,\n" +
                "868907 773025,\n" +
                "834545 964082,\n" +
                "938414 570073,\n" +
                "909574 571891,\n" +
                "819851 344451,\n" +
                "931663 477786,\n" +
                "472664 848385,\n" +
                "367094 738471,\n" +
                "351451 438393,\n" +
                "747954 680656,\n" +
                "603755 627225,\n" +
                "776862 453621,\n" +
                "551211 774640,\n" +
                "865650 372228,\n" +
                "311811 448851,\n" +
                "794510 464548,\n" +
                "860780 365334,\n" +
                "385176 519288,\n" +
                "756254 964115,\n" +
                "989921 388909,\n" +
                "459728 683947,\n" +
                "930518 863441,\n" +
                "917284 346088,\n" +
                "955831 484380,\n" +
                "888787 796204,\n" +
                "837128 569298,\n" +
                "328205 541293,\n" +
                "638069 302697,\n" +
                "624835 666101,\n" +
                "380287 567319,\n" +
                "751534 526926,\n" +
                "987618 460726,\n" +
                "707117 315866,\n" +
                "677454 528435,\n" +
                "946984 976334,\n" +
                "356712 332872,\n" +
                "570915 462517,\n" +
                "643492 408975,\n" +
                "529118 817358,\n" +
                "889323 592635,\n" +
                "628404 386742,\n" +
                "936454 929045,\n" +
                "484262 528580,\n" +
                "587697 930857,\n" +
                "478559 427138,\n" +
                "464834 813747,\n" +
                "347570 915758,\n" +
                "586726 801551,\n" +
                "678584 389223,\n" +
                "391371 437452,\n" +
                "629603 559709,\n" +
                "432699 471018,\n" +
                "666117 676971,\n" +
                "865384 304678,\n" +
                "789755 991590,\n" +
                "598149 492334,\n" +
                "756537 739560,\n" +
                "394931 812677,\n" +
                "559870 941459,\n" +
                "984233 365587,\n" +
                "511145 445643,\n" +
                "348097 898977,\n" +
                "465410 546769,\n" +
                "477361 382682,\n" +
                "463432 522553,\n" +
                "345695 326490,\n" +
                "599485 599634,\n" +
                "435422 660578,\n" +
                "496138 555576,\n" +
                "678631 528359,\n" +
                "938469 647888,\n" +
                "453982 649804,\n" +
                "743559 649422,\n" +
                "454580 763408,\n" +
                "446445 622555,\n" +
                "638080 694338,\n" +
                "582654 521746,\n" +
                "911423 331717,\n" +
                "417134 644460,\n" +
                "721536 875661,\n" +
                "859292 829182,\n" +
                "959231 787549,\n" +
                "485793 912869,\n" +
                "516584 709302,\n" +
                "486052 945817,\n" +
                "631304 911405,\n" +
                "718820 585715,\n" +
                "423533 381937,\n" +
                "873581 468271,\n" +
                "619709 595528,\n" +
                "472722 729797,\n" +
                "320154 977688,\n" +
                "867116 315073,\n" +
                "759745 691423,\n" +
                "443724 749671,\n" +
                "816420 554907,\n" +
                "595074 382395,\n" +
                "696200 386392,\n" +
                "852194 748812,\n" +
                "391460 333170,\n" +
                "555975 338256,\n" +
                "778030 797519,\n" +
                "328864 695555,\n" +
                "686450 724682,\n" +
                "710262 675616,\n" +
                "860141 807156,\n" +
                "529734 978563,\n" +
                "483128 495941,\n" +
                "631844 901153,\n" +
                "631525 413383,\n" +
                "384753 854746,\n" +
                "784227 372342,\n" +
                "498072 439087,\n" +
                "690505 959759,\n" +
                "858846 506148,\n" +
                "773431 811871,\n" +
                "919207 966782,\n" +
                "371698 392710,\n" +
                "570599 714516,\n" +
                "596313 775531,\n" +
                "439104 453122,\n" +
                "439116 701323,\n" +
                "310687 482966,\n" +
                "769532 916964,\n" +
                "314691 529703,\n" +
                "482070 726501,\n" +
                "942671 338412,\n" +
                "439382 589771,\n" +
                "365953 349365,\n" +
                "348294 577434,\n" +
                "698723 438207,\n" +
                "982030 857969,\n" +
                "906720 783784,\n" +
                "356942 419566,\n" +
                "474894 790631,\n" +
                "944422 968843,\n" +
                "810016 798785,\n" +
                "664442 839185,\n" +
                "486611 456001,\n" +
                "510193 580901,\n" +
                "350270 933807,\n" +
                "705735 868401,\n" +
                "889820 945592,\n" +
                "528644 661776,\n" +
                "931486 603110,\n" +
                "479851 400790,\n" +
                "686502 964988,\n" +
                "517279 895450,\n" +
                "333073 395204,\n" +
                "992078 559856,\n" +
                "453784 342825,\n" +
                "827832 319357,\n" +
                "372893 867625,\n" +
                "575031 904465,\n" +
                "916325 753458,\n" +
                "548375 561517,\n" +
                "407727 705034,\n" +
                "692662 697867,\n" +
                "831231 472739,\n" +
                "339811 312328,\n" +
                "870998 781913,\n" +
                "362250 964440,\n" +
                "563517 554469,";

//        System.out.println("data =" + data);

        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
        MagicPresent.Envelope[] envelopes = testTarget.readEnvelops(inputStream);
        MagicPresent.Envelope[] calculatePath = testTarget.calculatePath(envelopes);
        assertEquals(57, calculatePath.length);
//        assertEquals(120, calculatePath.length);

//        assertEquals(2087, calculatePath[0].number);
//        assertEquals(2575, calculatePath[1].number);
//        assertEquals(2098, calculatePath[2].number);
//        assertEquals(4521, calculatePath[3].number);
//        assertEquals(4354, calculatePath[4].number);
//        assertEquals(4967, calculatePath[5].number);
//        assertEquals(551, calculatePath[6].number);
//        assertEquals(1755, calculatePath[7].number);
//        assertEquals(388, calculatePath[8].number);
//        assertEquals(1200, calculatePath[9].number);
//        assertEquals(2633, calculatePath[10].number);
//        assertEquals(3306, calculatePath[11].number);
//        assertEquals(1457, calculatePath[12].number);
//        assertEquals(1499, calculatePath[13].number);
//        assertEquals(1356, calculatePath[14].number);
//        assertEquals(1644, calculatePath[15].number);
//        assertEquals(4140, calculatePath[16].number);
//        assertEquals(1187, calculatePath[17].number);
//        assertEquals(1859, calculatePath[18].number);
//        assertEquals(1955, calculatePath[19].number);
//        assertEquals(4054, calculatePath[20].number);
//        assertEquals(4074, calculatePath[21].number);
//        assertEquals(321, calculatePath[22].number);
    }

    // 26
    // 120
    // 2087 2575 2098 4521 4354 4967 551 1755 388 1200 2633 3306 1457 1499 1356 1644 4140 1187 1859 1955 4054 4074 321
    // 3978 1795 1952 3285 468 79 1235 540 893 3689 1261 4318 3945 2379 2965 1853 4130 1546 3314 1639 4408 2278 4160
    // 1906 136 1061 610 3163 1155 968 1685 2608 2860 867 2284 2273 4888 306 2851 2639 3722 293 1918 4476 2211 3204
    // 3705 4974 873 3472 3587 3043 318 1195 169 3059 2429 3996 401 1313 2352 1946 2818 2655 1630 714 2193 55 2467 4853
    // 422 2983 2279 4385 1408 1007 1619 1891 517 2553 2005 734 620

}