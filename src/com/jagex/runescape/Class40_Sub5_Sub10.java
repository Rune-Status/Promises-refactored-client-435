package com.jagex.runescape;

import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Model;

public class Class40_Sub5_Sub10 extends SubNode {
    public static int anInt2585;
    public static RSString aClass1_2587;
    public static RSString aClass1_2588;
    public static int anInt2589;
    public static Class66 aClass66_2590;
    public static int anInt2591;
    public static RSString aClass1_2592;
    public static RSString aClass1_2593;
    public static RSString aClass1_2595;
    public static int anInt2596;
    public static boolean aBoolean2597;
    public static int anInt2598 = 0;
    public static int anInt2601;
    public static int[] anIntArray2602;
    public static int anInt2603;
    public static Class45 aClass45_2604;
    public static int height;
    public static int anInt2607;
    public static int anInt2608;
    public static Class6_Sub1 aClass6_Sub1_2609;
    public static RSString aClass1_2611;
    public static int anInt2612;
    public static int anInt2613;
    public static RSString aClass1_2614;
    public static RSString aClass1_2615;
    public static RSString aClass1_2616;
    public static boolean membersServer;

    static {
        aBoolean2597 = false;
        aClass1_2592 = Class58.method978("Anmelde)2Zeitlimit -Uberschritten)3");
        aClass1_2611 = Class58.method978("Bitte versuchen Sie es in ");
        anIntArray2602 = new int[50];
        anInt2591 = 0;
        aClass1_2595 = Class58.method978("K");
        aClass1_2593 = aClass1_2595;
        aClass1_2588 = Class58.method978("backvmid2");
        aClass1_2587 = aClass1_2595;
        aClass45_2604 = new Class45();
        aClass1_2614 = Class58.method978("Wen m-Ochten Sie entfernen?");
        anInt2613 = 0;
        aClass1_2616 = Class58.method978("Bad session id)3");
        aClass1_2615 = aClass1_2616;
    }

    public int[] anIntArray2586 = new int[6];
    public int[] anIntArray2594;
    public int anInt2599 = -1;
    public int[] anIntArray2600;
    public boolean aBoolean2606 = false;
    public int[] anIntArray2610 = {-1, -1, -1, -1, -1};

    public Class40_Sub5_Sub10() {
        anIntArray2594 = new int[6];
    }

    public static void method625(int arg0) {
            aClass1_2595 = null;
            aClass1_2615 = null;
            aClass1_2611 = null;
            aClass1_2588 = null;
            aClass6_Sub1_2609 = null;
            aClass66_2590 = null;
            aClass1_2616 = null;
            aClass1_2614 = null;
            aClass1_2592 = null;
            if(arg0 != 0)
                method625(-67);
            aClass1_2587 = null;
            aClass45_2604 = null;
            anIntArray2602 = null;
            aClass1_2593 = null;
    }

    public static Class40_Sub5_Sub1 method626(int arg0, int arg1, int arg2) {
            long l = (long) (arg0 + (arg1 << -637173104));
            anInt2612++;
            Class40_Sub5_Sub1 class40_sub5_sub1 = ((Class40_Sub5_Sub1) Class17.aClass9_449.method231(l, (byte) 72));
            if(class40_sub5_sub1 != null)
                return class40_sub5_sub1;
            byte[] is = (Class56.aClass6_Sub1_1323.method170(GameObject.aClass1_3044, (Class40_Sub5_Sub17_Sub6.method832(53, new RSString[]{HashTable.method334(arg1, -1), SubNode.aClass1_2084, HashTable.method334(arg0, -1)})), 1));
            if(arg2 <= 4)
                return null;
            Buffer class40_sub1 = new Buffer(is);
            class40_sub5_sub1 = new Class40_Sub5_Sub1();
        class40_sub1.currentPosition = class40_sub1.buffer.length + -12;
        int i = class40_sub1.getIntBE();
            int i_0_ = 0;
        class40_sub5_sub1.anInt2271 = class40_sub1.getUnsignedShortBE();
        class40_sub5_sub1.anInt2267 = class40_sub1.getUnsignedShortBE();
        class40_sub5_sub1.anInt2263 = class40_sub1.getUnsignedShortBE();
        class40_sub5_sub1.anInt2266 = class40_sub1.getUnsignedShortBE();
            class40_sub5_sub1.aClass1Array2270 = new RSString[i];
            class40_sub5_sub1.anIntArray2262 = new int[i];
        class40_sub1.currentPosition = 0;
            class40_sub5_sub1.anIntArray2272 = new int[i];
        while(class40_sub1.currentPosition < -12 + class40_sub1.buffer.length) {
            int i_1_ = class40_sub1.getUnsignedShortBE();
                if(i_1_ != 3) {
                    if(i_1_ >= 100 || i_1_ == 21 || (i_1_ ^ 0xffffffff) == -39 || i_1_ == 39)
                        class40_sub5_sub1.anIntArray2262[i_0_] = class40_sub1.getUnsignedByte();
                    else
                        class40_sub5_sub1.anIntArray2262[i_0_] = class40_sub1.getIntBE();
                } else
                    class40_sub5_sub1.aClass1Array2270[i_0_] = class40_sub1.getRSString();
                class40_sub5_sub1.anIntArray2272[i_0_++] = i_1_;
            }
            Class17.aClass9_449.method230(-7208, l, class40_sub5_sub1);
            return class40_sub5_sub1;
    }

    public static RSString method627(int arg0, int arg1, int arg2, RSString[] arg3) {
            anInt2608++;
            int i = 0;
            int i_2_ = 6 / ((arg0 - 6) / 52);
            for(int i_3_ = 0; i_3_ < arg1; i_3_++) {
                if(arg3[arg2 + i_3_] == null)
                    arg3[i_3_ + arg2] = RSApplet.aClass1_28;
                i += arg3[i_3_ + arg2].length;
            }
            byte[] is = new byte[i];
            int i_4_ = 0;
            for(int i_5_ = 0; i_5_ < arg1; i_5_++) {
                RSString class1 = arg3[arg2 + i_5_];
                Class18.method278(class1.chars, 0, is, i_4_, class1.length);
                i_4_ += class1.length;
            }
            RSString class1 = new RSString();
        class1.length = i;
        class1.chars = is;
            return class1;
    }

    public void method622(byte arg0, Buffer arg1) {
        anInt2596++;
        for(; ; ) {
            int i = arg1.getUnsignedByte();
            if(i == 0)
                break;
            method628(arg1, i, arg0 + 1341);
        }
        if(arg0 != 58)
            method629((byte) -73);
    }

    public boolean method623(boolean arg0) {
            anInt2601++;
            if(anIntArray2600 == null)
                return true;
            boolean bool = arg0;
        for(int i = 0; anIntArray2600.length > i; i++) {
                if(!Class27.aClass6_654.method173(anIntArray2600[i], (byte) -10, 0))
                    bool = false;
            }
            return bool;
    }

    public boolean method624(boolean arg0) {
            boolean bool = true;
            anInt2603++;
            int i = 0;
            if(arg0 != false)
                return false;
            for(/**/; i < 5; i++) {
                if(anIntArray2610[i] != -1 && !Class27.aClass6_654.method173(anIntArray2610[i], (byte) -10, 0))
                    bool = false;
            }
            return bool;
    }

    public void method628(Buffer arg0, int arg1, int arg2) {
            if(arg2 != 1399)
                method626(-122, -98, -44);
            if((arg1 ^ 0xffffffff) != -2) {
                if((arg1 ^ 0xffffffff) != -3) {
                    if(arg1 != 3) {
                        if(arg1 < 40 || arg1 >= 50) {
                            if(arg1 >= 50 && (arg1 ^ 0xffffffff) > -61)
                                anIntArray2594[-50 + arg1] = arg0.getUnsignedShortBE();
                            else if(arg1 >= 60 && arg1 < 70)
                                anIntArray2610[-60 + arg1] = arg0.getUnsignedShortBE();
                        } else
                            anIntArray2586[arg1 + -40] = arg0.getUnsignedShortBE();
                    } else
                        aBoolean2606 = true;
                } else {
                    int i = arg0.getUnsignedByte();
                    anIntArray2600 = new int[i];
                    for(int i_6_ = 0; (i ^ 0xffffffff) < (i_6_ ^ 0xffffffff); i_6_++)
                        anIntArray2600[i_6_] = arg0.getUnsignedShortBE();
                }
            } else
                anInt2599 = arg0.getUnsignedByte();
            anInt2589++;
    }

    public Model method629(byte arg0) {
            anInt2607++;
            Model[] class40_sub5_sub17_sub5s = new Model[5];
            int i = 0;
            if(arg0 != -100)
                return null;
            for(int i_7_ = 0; (i_7_ ^ 0xffffffff) > -6; i_7_++) {
                if(anIntArray2610[i_7_] != -1)
                    class40_sub5_sub17_sub5s[i++] = Model.getModel((Class27.aClass6_654), (anIntArray2610[i_7_]), 0);
            }
            Model class40_sub5_sub17_sub5 = new Model(class40_sub5_sub17_sub5s, i);
            for(int i_8_ = 0; i_8_ < 6; i_8_++) {
                if(anIntArray2586[i_8_] == 0)
                    break;
                class40_sub5_sub17_sub5.method803(anIntArray2586[i_8_], anIntArray2594[i_8_]);
            }
            return class40_sub5_sub17_sub5;
    }

    public Model method630(boolean arg0) {
            anInt2585++;
            if(anIntArray2600 == null)
                return null;
            Model[] class40_sub5_sub17_sub5s = new Model[anIntArray2600.length];
            for(int i = 0; i < anIntArray2600.length; i++)
                class40_sub5_sub17_sub5s[i] = Model.getModel(Class27.aClass6_654, anIntArray2600[i], 0);
            Model class40_sub5_sub17_sub5;
            if(class40_sub5_sub17_sub5s.length != 1)
                class40_sub5_sub17_sub5 = (new Model(class40_sub5_sub17_sub5s, class40_sub5_sub17_sub5s.length));
            else
                class40_sub5_sub17_sub5 = class40_sub5_sub17_sub5s[0];
            if(arg0 != false)
                return null;
            for(int i = 0; (i ^ 0xffffffff) > -7; i++) {
                if(anIntArray2586[i] == 0)
                    break;
                class40_sub5_sub17_sub5.method803(anIntArray2586[i], anIntArray2594[i]);
            }
            return class40_sub5_sub17_sub5;
    }
}