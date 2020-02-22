package com.jagex.runescape.cache.def;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.util.Signlink;

import java.awt.*;

public class NpcDefinition extends SubNode {
    public static int anInt2373;
    public static Class6_Sub1 aClass6_Sub1_2377;
    public static int anInt2378;
    public static int anInt2379;
    public static RSString aClass1_2380;
    public static RSString aClass1_2383 = Class58.method978("Please wait 1 minute and try again)3");
    public static RSString aClass1_2384;
    public static int[] anIntArray2386;
    public static RSString aClass1_2388;
    public static int anInt2390;
    public static RSString aClass1_2392;
    public static int anInt2394;
    public static RSString aClass1_2396;
    public static int anInt2398;
    public static RSString aClass1_2399;
    public static int anInt2400;
    public static RSString aClass1_2401;
    public static int anInt2403;
    public static int anInt2404;
    public static RSString aClass1_2408;
    public static RSString aClass1_2410;
    public static int anInt2412;
    public static int anInt2414;
    public static byte[] aByteArray2416;
    public static RSString aClass1_2417;
    public static int anInt2419;
    public static int anInt2420;
    public static int anInt2422;
    public static RSString aClass1_2423;
    public static int anInt2424;
    public static int anInt2429;
    public static int anInt2431;
    public static RSString aClass1_2432;
    public static int anInt2433;

    static {
        aClass1_2380 = (Class58.method978("Moderator option: Mute player for 48 hours: <ON>"));
        aClass1_2399 = Class58.method978("Loaded fonts");
        aClass1_2401 = aClass1_2383;
        aClass1_2384 = aClass1_2380;
        anInt2394 = 0;
        anInt2404 = 0;
        aClass1_2410 = aClass1_2383;
        aClass1_2392 = aClass1_2399;
        aClass1_2408 = Class58.method978("Unexpected server response");
        aByteArray2416 = new byte[520];
        aClass1_2417 = Class58.method978("Versteckt");
        aClass1_2423 = Class58.method978("(X100(U(Y");
        aClass1_2388 = Class58.method978("Checking for updates )2 ");
        aClass1_2396 = aClass1_2388;
        anInt2433 = -1;
        aClass1_2432 = aClass1_2408;
    }

    public boolean isClickable = true;
    public int tileSpacesOccupied = 1;
    public int[] models_2;
    public RSString[] options = new RSString[5];
    public int headIcon;
    public int stanceAnimation = -1;
    public int settingId;
    public int ambient;
    public int anInt2389;
    public int degreesToTurn;
    public int combatLevel;
    public int[] recolorToFind;
    public boolean hasRenderPriority;
    public RSString name;
    public int[] models;
    public int rotate180Animation;
    public int resizeX;
    public int contrast;
    public int varBitId;
    public int rotate90LeftAnimation;
    public int resizeY;
    public int rotate90RightAnimation;
    public int anInt2421;
    public int walkAnimation;
    public int[] childrenIds;
    public int anInt2427;
    public int[] recolorToReplace;
    public boolean renderOnMinimap;

    public NpcDefinition() {
        headIcon = -1;
        degreesToTurn = 32;
        ambient = 0;
        rotate180Animation = -1;
        settingId = -1;
        contrast = 0;
        resizeX = 128;
        hasRenderPriority = false;
        combatLevel = -1;
        anInt2389 = -1;
        rotate90LeftAnimation = -1;
        varBitId = -1;
        resizeY = 128;
        walkAnimation = -1;
        anInt2421 = -1;
        name = Class35.aClass1_1725;
        rotate90RightAnimation = -1;
        renderOnMinimap = true;
    }

    public static void method567(int arg0) {
        anInt2400++;
        if(arg0 != 1) {
            aClass1_2432 = null;
        }
        if(Class57.aClass64_1345 != null) {
            Class57.aClass64_1345.method1009(90);
        }
    }

    public static void method569(boolean arg0) {
        Class17.anIntArray456 = null;
        Class58.aByteArrayArray1370 = null;
        Npc.anIntArray3312 = null;
        if(arg0 == true) {
            Actor.anIntArray3111 = null;
            Buffer.anIntArray1972 = null;
            Class57.anIntArray1347 = null;
            anInt2403++;
        }
    }

    public static void method570(int arg0, int arg1, Player arg2, int arg3) {
        anInt2431++;
        if(arg3 == -1) {
            if(arg2.anInt3141 == arg0 && arg0 != -1) {
                int i = Class68_Sub1.method1050(arg0, 2).anInt2483;
                if(i == 1) {
                    arg2.anInt3104 = 0;
                    arg2.anInt3095 = 0;
                    arg2.anInt3122 = arg1;
                    arg2.anInt3115 = 0;
                }
                if(i == 2) {
                    arg2.anInt3095 = 0;
                }
            } else if((arg0 ^ 0xffffffff) == 0 || arg2.anInt3141 == -1 || (Class68_Sub1.method1050(arg0, 2).anInt2494 >= (Class68_Sub1.method1050(arg2.anInt3141, 2).anInt2494))) {
                arg2.anInt3094 = arg2.anInt3109;
                arg2.anInt3104 = 0;
                arg2.anInt3115 = 0;
                arg2.anInt3095 = 0;
                arg2.anInt3122 = arg1;
                arg2.anInt3141 = arg0;
            }
        }
    }

    public static void method574(int arg0) {
        if(arg0 != 4) {
            method576(true);
        }
        try {
            Graphics graphics = Class62.aCanvas1469.getGraphics();
            RSString.aClass68_1665.method1044(0, 550, graphics, 4);
        } catch(Exception exception) {
            Class62.aCanvas1469.repaint();
        }
        anInt2429++;
    }

    public static int method576(boolean arg0) {
        if(arg0 != false) {
            aClass1_2432 = null;
        }
        anInt2422++;
        return 19;
    }

    public static ImageRGB method578(int arg0) {
        anInt2379++;
        ImageRGB class40_sub5_sub14_sub4 = new ImageRGB();
        class40_sub5_sub14_sub4.maxWidth = ItemDefinition.anInt2846;
        class40_sub5_sub14_sub4.maxHeight = RSApplet.anInt31;
        class40_sub5_sub14_sub4.offsetX = Class57.anIntArray1347[0];
        class40_sub5_sub14_sub4.offsetY = Actor.anIntArray3111[0];
        if(arg0 > -85) {
            method578(79);
        }
        class40_sub5_sub14_sub4.image_width = Class17.anIntArray456[0];
        class40_sub5_sub14_sub4.image_height = Npc.anIntArray3312[0];
        byte[] is = Class58.aByteArrayArray1370[0];
        int i = (class40_sub5_sub14_sub4.image_width * class40_sub5_sub14_sub4.image_height);
        class40_sub5_sub14_sub4.pixels = new int[i];
        for(int i_5_ = 0; i_5_ < i; i_5_++) {
            class40_sub5_sub14_sub4.pixels[i_5_] = (Buffer.anIntArray1972[Class66.method1021(255, is[i_5_])]);
        }
        method569(true);
        return class40_sub5_sub14_sub4;
    }

    public static void method580(Signlink arg0, byte arg1, Buffer arg2, int arg3) {
        Class40_Sub11 class40_sub11 = new Class40_Sub11();
        class40_sub11.anInt2160 = arg2.getUnsignedByte();
        anInt2424++;
        class40_sub11.anInt2166 = arg2.getIntBE();
        class40_sub11.anIntArray2154 = new int[class40_sub11.anInt2160];
        int i = 123 / ((-34 - arg1) / 43);
        class40_sub11.aClass15Array2157 = new Class15[class40_sub11.anInt2160];
        class40_sub11.anIntArray2165 = new int[class40_sub11.anInt2160];
        class40_sub11.aByteArrayArrayArray2159 = new byte[class40_sub11.anInt2160][][];
        class40_sub11.aClass15Array2156 = new Class15[class40_sub11.anInt2160];
        class40_sub11.anIntArray2155 = new int[class40_sub11.anInt2160];
        for(int i_6_ = 0; (i_6_ ^ 0xffffffff) > (class40_sub11.anInt2160 ^ 0xffffffff); i_6_++) {
            try {
                int i_7_ = arg2.getUnsignedByte();
                if(i_7_ != 0 && i_7_ != 1 && (i_7_ ^ 0xffffffff) != -3) {
                    if(i_7_ == 3 || (i_7_ ^ 0xffffffff) == -5) {
                        String string = new String(arg2.getRSString().method80(0));
                        String string_8_ = new String(arg2.getRSString().method80(0));
                        int i_9_ = arg2.getUnsignedByte();
                        String[] strings = new String[i_9_];
                        for(int i_10_ = 0; i_9_ > i_10_; i_10_++) {
                            strings[i_10_] = new String(arg2.getRSString().method80(0));
                        }
                        byte[][] is = new byte[i_9_][];
                        if(i_7_ == 3) {
                            for(int i_11_ = 0; ((i_11_ ^ 0xffffffff) > (i_9_ ^ 0xffffffff)); i_11_++) {
                                int i_12_ = arg2.getIntBE();
                                is[i_11_] = new byte[i_12_];
                                arg2.getBytes(i_12_, 0, is[i_11_]);
                            }
                        }
                        class40_sub11.anIntArray2154[i_6_] = i_7_;
                        Class[] var_classes = new Class[i_9_];
                        for(int i_13_ = 0; (i_13_ ^ 0xffffffff) > (i_9_ ^ 0xffffffff); i_13_++) {
                            var_classes[i_13_] = Class26.method349((byte) 91, strings[i_13_]);
                        }
                        class40_sub11.aClass15Array2156[i_6_] = arg0.method386(var_classes, string_8_, Class26.method349((byte) 91, string), (byte) -64);
                        class40_sub11.aByteArrayArrayArray2159[i_6_] = is;
                    }
                } else {
                    int i_14_ = 0;
                    String string = new String(arg2.getRSString().method80(0));
                    String string_15_ = new String(arg2.getRSString().method80(0));
                    if((i_7_ ^ 0xffffffff) == -2) {
                        i_14_ = arg2.getIntBE();
                    }
                    class40_sub11.anIntArray2154[i_6_] = i_7_;
                    class40_sub11.anIntArray2165[i_6_] = i_14_;
                    class40_sub11.aClass15Array2157[i_6_] = arg0.method392(Class26.method349((byte) 91, string), string_15_, true);
                }
            } catch(ClassNotFoundException classnotfoundexception) {
                class40_sub11.anIntArray2155[i_6_] = -1;
            } catch(SecurityException securityexception) {
                class40_sub11.anIntArray2155[i_6_] = -2;
            } catch(NullPointerException nullpointerexception) {
                class40_sub11.anIntArray2155[i_6_] = -3;
            } catch(Exception exception) {
                class40_sub11.anIntArray2155[i_6_] = -4;
            } catch(Throwable throwable) {
                class40_sub11.anIntArray2155[i_6_] = -5;
            }
        }
        Class54.aClass45_1278.method904(class40_sub11, 92);
    }

    public static void method581(int arg0) {

        anIntArray2386 = null;
        aClass6_Sub1_2377 = null;
        aClass1_2388 = null;
        aClass1_2399 = null;
        aClass1_2432 = null;
        aClass1_2380 = null;
        aClass1_2396 = null;
        aClass1_2423 = null;
        aClass1_2417 = null;
        if(arg0 == -96) {
            aClass1_2410 = null;
            aClass1_2383 = null;
            aByteArray2416 = null;
            aClass1_2401 = null;
            aClass1_2392 = null;
            aClass1_2408 = null;
            aClass1_2384 = null;
        }

    }

    public Model method568(byte arg0, Class40_Sub5_Sub7 arg1, Class40_Sub5_Sub7 arg2, int arg3, int arg4) {

        anInt2412++;
        if(arg0 != -50) {
            degreesToTurn = 31;
        }
        if(childrenIds != null) {
            NpcDefinition class40_sub5_sub5 = method577(arg0 ^ 0x31);
            if(class40_sub5_sub5 == null) {
                return null;
            }
            return class40_sub5_sub5.method568((byte) -50, arg1, arg2, arg3, arg4);
        }
        Model class40_sub5_sub17_sub5 = ((Model) Class67.aClass9_1611.method231((long) anInt2427, (byte) 75));
        if(class40_sub5_sub17_sub5 == null) {
            boolean bool = false;
            for(int i = 0; i < models.length; i++) {
                if(!Class67.aClass6_1577.loaded(models[i], 0)) {
                    bool = true;
                }
            }
            if(bool) {
                return null;
            }
            Model[] class40_sub5_sub17_sub5s = new Model[models.length];
            for(int i = 0; models.length > i; i++) {
                class40_sub5_sub17_sub5s[i] = Model.getModel((Class67.aClass6_1577), models[i], 0);
            }
            if(class40_sub5_sub17_sub5s.length == 1) {
                class40_sub5_sub17_sub5 = class40_sub5_sub17_sub5s[0];
            } else {
                class40_sub5_sub17_sub5 = (new Model(class40_sub5_sub17_sub5s, class40_sub5_sub17_sub5s.length));
            }
            if(recolorToReplace != null) {
                for(int i = 0; (i < recolorToReplace.length); i++) {
                    class40_sub5_sub17_sub5.method803(recolorToReplace[i], recolorToFind[i]);
                }
            }
            class40_sub5_sub17_sub5.method810();
            class40_sub5_sub17_sub5.method802(ambient + 64, 850 + contrast, -30, -50, -30, true);
            Class67.aClass9_1611.method230(-7208, (long) anInt2427, class40_sub5_sub17_sub5);
        }
        Model class40_sub5_sub17_sub5_0_;
        if(arg1 != null && arg2 != null) {
            class40_sub5_sub17_sub5_0_ = arg1.method590(class40_sub5_sub17_sub5, arg2, arg4, arg3, (byte) 63);
        } else if(arg1 != null) {
            class40_sub5_sub17_sub5_0_ = arg1.method599(arg4, class40_sub5_sub17_sub5, false);
        } else if(arg2 == null) {
            class40_sub5_sub17_sub5_0_ = class40_sub5_sub17_sub5.method817(true);
        } else {
            class40_sub5_sub17_sub5_0_ = arg2.method599(arg3, class40_sub5_sub17_sub5, false);
        }
        if((resizeX ^ 0xffffffff) != -129 || resizeY != 128) {
            class40_sub5_sub17_sub5_0_.method821(resizeX, resizeY, resizeX);
        }
        return class40_sub5_sub17_sub5_0_;

    }

    public boolean method571(int arg0) {

        anInt2378++;
        if(childrenIds == null) {
            return true;
        }
        int i = arg0;
        if(varBitId != -1) {
            i = Class40_Sub5_Sub6.method585(varBitId, 1369);
        } else if((settingId ^ 0xffffffff) != 0) {
            i = Class58.varbitmasks[settingId];
        }
        return i >= 0 && childrenIds.length > i && (childrenIds[i] ^ 0xffffffff) != 0;

    }

    public void readValue(Buffer buffer, int opcode) {
        if(opcode == 1) {
            int length = buffer.getUnsignedByte();
            models = new int[length];
            for(int idx = 0; idx < length; ++idx) {
                models[idx] = buffer.getUnsignedShortBE();
            }
        } else if(opcode == 2) {
            name = buffer.getRSString();
        } else if(opcode == 12) {
            tileSpacesOccupied = buffer.getUnsignedByte();
        } else if(opcode == 13) {
            stanceAnimation = buffer.getUnsignedShortBE();
        } else if(opcode == 14) {
            walkAnimation = buffer.getUnsignedShortBE();
        } else if(opcode == 15) {
            anInt2421 = buffer.getUnsignedShortBE();
        } else if(opcode == 16) {
            anInt2389 = buffer.getUnsignedShortBE();
        } else if(opcode == 17) {
            walkAnimation = buffer.getUnsignedShortBE();
            rotate180Animation = buffer.getUnsignedShortBE();
            rotate90RightAnimation = buffer.getUnsignedShortBE();
            rotate90LeftAnimation = buffer.getUnsignedShortBE();
        } else if(opcode >= 30 && opcode < 35) {
            options[opcode - 30] = buffer.getRSString();
            if(options[opcode - 30].equalsIgnoreCase(Class59.string_Hidden, true)) {
                options[-30 + opcode] = null;
            }
        } else if(opcode == 40) {
            int length = buffer.getUnsignedByte();
            recolorToFind = new int[length];
            recolorToReplace = new int[length];
            for(int i_2_ = 0; i_2_ < length; i_2_++) {
                recolorToReplace[i_2_] = buffer.getUnsignedShortBE();
                recolorToFind[i_2_] = buffer.getUnsignedShortBE();
            }
        } else if(opcode == 60) {
            int length = buffer.getUnsignedByte();
            models_2 = new int[length];
            for(int i_4_ = 0; length > i_4_; i_4_++) {
                models_2[i_4_] = buffer.getUnsignedShortBE();
            }
        } else if(opcode == 93) {
            renderOnMinimap = false;
        } else if(opcode == 95) {
            combatLevel = buffer.getUnsignedShortBE();
        } else if(opcode == 97) {
            resizeX = buffer.getUnsignedShortBE();
        } else if(opcode == 98) {
            resizeY = buffer.getUnsignedShortBE();
        } else if(opcode == 99) {
            hasRenderPriority = true;
        } else if(opcode == 100) {
            ambient = buffer.getByte();
        } else if(opcode == 101) {
            contrast = (buffer.getByte()) * 5;
        } else if(opcode == 102) {
            headIcon = (buffer.getUnsignedShortBE());
        } else if(opcode == 103) {
            degreesToTurn = (buffer.getUnsignedShortBE());
        } else if(opcode == 106) {
            varBitId = (buffer.getUnsignedShortBE());
            if(varBitId == 65535) {
                varBitId = -1;
            }
            settingId = (buffer.getUnsignedShortBE());
            if(settingId == 65535) {
                settingId = -1;
            }
            int childrenCount = (buffer.getUnsignedByte());
            childrenIds = new int[childrenCount + 1];
            for(int idx = 0; childrenCount >= idx; idx++) {
                childrenIds[idx] = (buffer.getUnsignedShortBE());
                if(childrenIds[idx] == 0xFFFF) {
                    childrenIds[idx] = -1;
                }
            }
        } else if(opcode == 107) {
            isClickable = false;
        }
        anInt2414++;
    }

    public void readValues(Buffer npcDefinitionBuffer) {

        for(; ; ) {
            int opcode = npcDefinitionBuffer.getUnsignedByte();
            if(opcode == 0) {
                break;
            }
            readValue(npcDefinitionBuffer, opcode);
        }
        anInt2420++;

    }

    public Model method575(byte arg0) {

        anInt2419++;
        if(childrenIds != null) {
            NpcDefinition class40_sub5_sub5 = method577(-1);
            if(class40_sub5_sub5 == null) {
                return null;
            }
            return class40_sub5_sub5.method575((byte) 112);
        }
        if(models_2 == null) {
            return null;
        }
        boolean bool = false;
        for(int i = 0; i < models_2.length; i++) {
            if(!Class67.aClass6_1577.loaded(models_2[i], 0)) {
                bool = true;
            }
        }
        if(arg0 < 108) {
            method570(-116, 79, null, -61);
        }
        if(bool) {
            return null;
        }
        Model[] class40_sub5_sub17_sub5s = new Model[models_2.length];
        for(int i = 0; i < models_2.length; i++) {
            class40_sub5_sub17_sub5s[i] = Model.getModel(Class67.aClass6_1577, models_2[i], 0);
        }
        Model class40_sub5_sub17_sub5;
        if(class40_sub5_sub17_sub5s.length != 1) {
            class40_sub5_sub17_sub5 = (new Model(class40_sub5_sub17_sub5s, class40_sub5_sub17_sub5s.length));
        } else {
            class40_sub5_sub17_sub5 = class40_sub5_sub17_sub5s[0];
        }
        if(recolorToReplace != null) {
            for(int i = 0; i < recolorToReplace.length; i++) {
                class40_sub5_sub17_sub5.method803(recolorToReplace[i], recolorToFind[i]);
            }
        }
        return class40_sub5_sub17_sub5;

    }

    public NpcDefinition method577(int arg0) {

        int i = arg0;
        anInt2398++;
        if(varBitId != -1) {
            i = Class40_Sub5_Sub6.method585(varBitId, 1369);
        } else if(settingId != -1) {
            i = Class58.varbitmasks[settingId];
        }
        if((i ^ 0xffffffff) > -1 || childrenIds.length <= i || (childrenIds[i] ^ 0xffffffff) == 0) {
            return null;
        }
        return Landscape.method932((byte) -114, childrenIds[i]);

    }

    public void method579(byte arg0) {

        anInt2373++;
        int i = -82 % ((arg0 - 15) / 41);

    }
}