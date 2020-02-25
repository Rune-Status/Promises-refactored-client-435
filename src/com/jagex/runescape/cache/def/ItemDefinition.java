package com.jagex.runescape.cache.def;

import com.jagex.runescape.*;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;

import java.awt.*;

public class ItemDefinition extends SubNode {
    public static int anInt2797 = 0;
    public static int anInt2798 = 0;
    public static int[] anIntArray2814 = new int[50];
    public static int anInt2815;
    public static int anInt2846;
    public static int anInt2850 = -1;
    public static int anInt2854;
    public static int count;

    public int stackable;
    public RSString name;
    public RSString[] interfaceOptions;
    public int primaryMaleHeadPiece = -1;
    public int[] textureReplace;
    public RSString[] groundOptions;
    public int inventoryModelId;
    public int xOffset2d;
    public int noteTemplateId;
    public int yOffset2d;
    public int notedId;
    public int groundScaleX;
    public int[] textureFind;
    public int zoom2d;
    public int maleOffset;
    public int femaleModel1;
    public int maleModel1;
    public int secondaryFemaleHeadPiece;
    public int teamIndex;
    public int maleModel2;
    public int ambient;
    public int zan2d;
    public int cost;
    public int femaleOffset;
    public int yan2d;
    public int[] stackableIds;
    public int groundScaleZ;
    public int[] stackableAmounts;
    public int maleModel0;
    public int contrast;
    public int secondaryMaleHeadPiece;
    public int xan2d;
    public int femaleModel2;
    public int femaleModel0;
    public boolean members;
    public int primaryFemaleHeadPiece;
    public int anInt2852;
    public int groundScaleY;

    public ItemDefinition() {
        interfaceOptions = new RSString[]{null, null, null, null, Cache.dropStringInstance};
        stackable = 0;
        maleOffset = 0;
        name = Class61.aClass1_1437;
        yOffset2d = 0;
        cost = 1;
        xOffset2d = 0;
        femaleOffset = 0;
        ambient = 0;
        maleModel1 = -1;
        yan2d = 0;
        groundOptions = new RSString[]{null, null, Class27.takeStringInstance, null, null};
        groundScaleX = 128;
        noteTemplateId = -1;
        secondaryFemaleHeadPiece = -1;
        zoom2d = 2000;
        maleModel2 = -1;
        teamIndex = 0;
        zan2d = 0;
        contrast = 0;
        femaleModel1 = -1;
        femaleModel2 = -1;
        xan2d = 0;
        groundScaleZ = 128;
        secondaryMaleHeadPiece = -1;
        femaleModel0 = -1;
        members = false;
        primaryFemaleHeadPiece = -1;
        groundScaleY = 128;
        notedId = -1;
        maleModel0 = -1;
    }

    public static void method742(int arg0) {
        try {
            Graphics graphics = GameFrame.aCanvas1469.getGraphics();
            Landscape.aClass68_1185.method1044(arg0 ^ arg0, 0, graphics, 4);
            Class40_Sub5_Sub1.aClass68_2275.method1044(arg0 + -205, 0, graphics, 357);
            Class39.aClass68_908.method1044(0, 722, graphics, 4);
            GameObject.aClass68_3045.method1044(arg0 + -205, 743, graphics, 205);
            Class40_Sub5_Sub17_Sub6.aClass68_3243.method1044(0, 0, graphics, 0);
            Class40_Sub7.aClass68_2123.method1044(0, 516, graphics, 4);
            Class61.aClass68_1441.method1044(0, 516, graphics, 205);
            Class30.aClass68_714.method1044(0, 496, graphics, 357);
            Class17.aClass68_462.method1044(0, 0, graphics, 338);
        } catch(Exception exception) {
            GameFrame.aCanvas1469.repaint();
        }
    }

    public static void method744() {
        if(Class59.aClass54_1392 != null) {
            synchronized(Class59.aClass54_1392) {
                Class59.aClass54_1392 = null;
            }
        }
    }

    public static void method745() {
        anIntArray2814 = null;
    }

    public static boolean method746(Widget arg1) {
        if(arg1.alternateOperators == null) {
            return false;
        }
        for(int i = 0; arg1.alternateOperators.length > i; i++) {
            int i_10_ = HuffmanEncoding.method1029(i, false, arg1);
            int i_11_ = arg1.alternateRhs[i];
            if((arg1.alternateOperators[i] ^ 0xffffffff) == -3) {
                if((i_11_ <= i_10_)) {
                    return false;
                }
            } else if((arg1.alternateOperators[i] ^ 0xffffffff) == -4) {
                if((i_11_ >= i_10_)) {
                    return false;
                }
            } else if((arg1.alternateOperators[i] ^ 0xffffffff) == -5) {
                if(i_11_ == i_10_) {
                    return false;
                }
            } else if((i_11_ ^ 0xffffffff) != (i_10_ ^ 0xffffffff)) {
                return false;
            }
        }
        return true;
    }

    public static void method748(int arg1) {
        for(Renderable.anInt2866 += arg1; (Renderable.anInt2866 >= CollisionMap.anInt141); Renderable.anInt2866 -= CollisionMap.anInt141) {
            SubNode.anInt2081 -= SubNode.anInt2081 >> 2;
        }
        SubNode.anInt2081 -= 1000 * arg1;
        if((SubNode.anInt2081 ^ 0xffffffff) > -1) {
            SubNode.anInt2081 = 0;
        }
    }

    public static void method749(boolean arg0) {
        for(int i = 0; GameObjectDefinition.anInt2558 > i; i++) {
            Npc npc = (CacheIndex_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[Class40_Sub3.anIntArray2016[i]]);
            int i_15_ = (536870912 + (Class40_Sub3.anIntArray2016[i] << 14));
            if(npc != null && npc.isVisible(1) && !arg0 != (npc.aClass40_Sub5_Sub5_3300.hasRenderPriority) && npc.aClass40_Sub5_Sub5_3300.method571(-1)) {
                int i_16_ = (npc.anInt3098 >> 7);
                int i_17_ = npc.anInt3089 >> 7;
                if((i_16_ ^ 0xffffffff) <= -1 && (i_16_ ^ 0xffffffff) > -105 && (i_17_ ^ 0xffffffff) <= -1 && i_17_ < 104) {
                    if((npc.anInt3096 ^ 0xffffffff) == -2 && (npc.anInt3098 & 0x7f ^ 0xffffffff) == -65 && ((npc.anInt3089 & 0x7f) == 64)) {
                        if((Class40_Sub5_Sub11.anInt2628 ^ 0xffffffff) == (Class61.anIntArrayArray1435[i_16_][i_17_] ^ 0xffffffff)) {
                            continue;
                        }
                        Class61.anIntArrayArray1435[i_16_][i_17_] = Class40_Sub5_Sub11.anInt2628;
                    }
                    if(!npc.aClass40_Sub5_Sub5_3300.isClickable) {
                        i_15_ += -2147483648;
                    }
                    Npc.aScene_3301.method134(Player.anInt3267, npc.anInt3098, npc.anInt3089, (Class37.method430((byte) -126, Player.anInt3267, (npc.anInt3098 + ((-1 + npc.anInt3096) * 64)), (npc.anInt3096 * 64 + (-64 + (npc.anInt3089))))), -64 + (npc.anInt3096 * 64 + 60), npc, npc.anInt3118, i_15_, npc.aBoolean3105);
                }
            }
        }
    }

    public static ItemDefinition forId(int arg0, int arg1) {
        ItemDefinition definition = ((ItemDefinition) ISAAC.aClass9_516.method231((long) arg0, (byte) 100));
        if(definition != null) {
            return definition;
        }
        byte[] is = Class26.aCacheIndex_632.getFile(arg0, arg1);
        definition = new ItemDefinition();
        definition.anInt2852 = arg0;
        if(is != null) {
            definition.readValues(new Buffer(is));
        }
        if(definition.noteTemplateId != -1) {
            definition.itemToNote(forId(definition.noteTemplateId, 10), forId(definition.notedId, 10));
        }
        if(!IdentityKit.membersServer && definition.members) {
            definition.interfaceOptions = null;
            definition.teamIndex = 0;
            definition.groundOptions = null;
            definition.name = Class40_Sub5_Sub17_Sub3.aClass1_3069;
        }
        ISAAC.aClass9_516.method230(arg1 + -7218, (long) arg0, definition);
        return definition;
    }

    public boolean method738(byte arg0, boolean arg1) {
        if(arg0 != 44) {
            interfaceOptions = null;
        }
        int i = primaryMaleHeadPiece;
        int i_0_ = secondaryMaleHeadPiece;
        if(arg1) {
            i_0_ = secondaryFemaleHeadPiece;
            i = primaryFemaleHeadPiece;
        }
        if(i == -1) {
            return true;
        }
        boolean bool = true;
        if(!Class8.aCacheIndex_284.loaded(i, 0)) {
            bool = false;
        }
        if(i_0_ != -1 && !Class8.aCacheIndex_284.loaded(i_0_, 0)) {
            bool = false;
        }
        return bool;
    }

    public boolean method739(boolean arg0, byte arg1) {
        int i = maleModel0;
        int i_1_ = maleModel1;
        int i_2_ = maleModel2;
        if(arg0) {
            i_2_ = femaleModel2;
            i_1_ = femaleModel1;
            i = femaleModel0;
        }
        if((i ^ 0xffffffff) == 0) {
            return true;
        }
        boolean bool = true;
        if(arg1 <= 126) {
            return false;
        }
        if(!Class8.aCacheIndex_284.loaded(i, 0)) {
            bool = false;
        }
        if(i_1_ != -1 && !Class8.aCacheIndex_284.loaded(i_1_, 0)) {
            bool = false;
        }
        if(i_2_ != -1 && !Class8.aCacheIndex_284.loaded(i_2_, 0)) {
            bool = false;
        }
        return bool;
    }

    public Model method740(boolean arg0, int arg1) {
        int i = maleModel0;
        int i_3_ = maleModel1;
        int i_4_ = 11 / ((arg1 - 35) / 56);
        int i_5_ = maleModel2;
        if(arg0) {
            i = femaleModel0;
            i_3_ = femaleModel1;
            i_5_ = femaleModel2;
        }
        if(i == -1) {
            return null;
        }
        Model model1 = Model.getModel(Class8.aCacheIndex_284, i, 0);
        if(i_3_ != -1) {
            Model model2 = Model.getModel(Class8.aCacheIndex_284, i_3_, 0);
            if(i_5_ == -1) {
                Model[] models = {model1, model2};
                model1 = new Model(models, 2);
            } else {
                Model model3 = Model.getModel(Class8.aCacheIndex_284, i_5_, 0);
                Model[] models = {model1, model2, model3};
                model1 = new Model(models, 3);
            }
        }
        if(!arg0 && (maleOffset ^ 0xffffffff) != -1) {
            model1.method828(0, maleOffset, 0);
        }
        if(arg0 && femaleOffset != 0) {
            model1.method828(0, femaleOffset, 0);
        }
        if(textureReplace != null) {
            for(int i_8_ = 0; ((textureReplace.length > i_8_)); i_8_++) {
                model1.replaceColor(textureReplace[i_8_], textureFind[i_8_]);
            }
        }
        return model1;

    }


    public ItemDefinition method743(int arg1) {
        if(stackableIds != null && (arg1 ^ 0xffffffff) < -2) {
            int i = -1;
            for(int i_9_ = 0; (i_9_ ^ 0xffffffff) > -11; i_9_++) {
                if((arg1 >= stackableAmounts[i_9_]) && (stackableAmounts[i_9_] ^ 0xffffffff) != -1) {
                    i = stackableIds[i_9_];
                }
            }
            if((i ^ 0xffffffff) != 0) {
                return forId(i, 10);
            }
        }
        return this;

    }

    public Model method747(boolean arg0, byte arg1) {
        int i = primaryMaleHeadPiece;
        int i_12_ = secondaryMaleHeadPiece;
        if(arg1 != 25) {
            return null;
        }
        if(arg0) {
            i = primaryFemaleHeadPiece;
            i_12_ = secondaryFemaleHeadPiece;
        }
        if(i == -1) {
            return null;
        }
        Model model1 = Model.getModel(Class8.aCacheIndex_284, i, 0);
        if(i_12_ != -1) {
            Model model2 = Model.getModel(Class8.aCacheIndex_284, i_12_, 0);
            Model[] models = {model1, model2};
            model1 = new Model(models, 2);
        }
        if(textureReplace != null) {
            for(int j = 0; ((textureReplace.length > j)); j++) {
                model1.replaceColor(textureReplace[j], textureFind[j]);
            }
        }
        return model1;

    }

    public void readValue(int opcode, Buffer buffer) {
        if(opcode == 1) {
            inventoryModelId = buffer.getUnsignedShortBE();
        } else if(opcode == 2) {
            name = buffer.getRSString();
        } else if(opcode == 4) {
            zoom2d = buffer.getUnsignedShortBE();
        } else if(opcode == 5) {
            xan2d = buffer.getUnsignedShortBE();
        } else if(opcode == 6) {
            yan2d = buffer.getUnsignedShortBE();
        } else if(opcode == 7) {
            xOffset2d = buffer.getUnsignedShortBE();
            if(xOffset2d > 32767) {
                xOffset2d -= 65536;
            }
        } else if(opcode == 8) {
            yOffset2d = buffer.getUnsignedShortBE();
            if(yOffset2d > 32767) {
                yOffset2d -= 65536;
            }
        } else if(opcode == 11) {
            stackable = 1;
        } else if(opcode == 12) {
            cost = buffer.getIntBE();
        } else if(opcode == 16) {
            members = true;
        } else if(opcode == 23) {
            maleModel0 = buffer.getUnsignedShortBE();
            maleOffset = buffer.getUnsignedByte();
        } else if(opcode == 24) {
            maleModel1 = buffer.getUnsignedShortBE();
        } else if(opcode == 25) {
            femaleModel0 = buffer.getUnsignedShortBE();
            femaleOffset = buffer.getUnsignedByte();
        } else if(opcode == 26) {
            femaleModel1 = buffer.getUnsignedShortBE();
        } else if(opcode >= 30 && opcode < 35) {
            groundOptions[-30 + opcode] = buffer.getRSString();
            if(groundOptions[opcode + -30].equalsIgnoreCase(Class59.string_Hidden, true)) {
                groundOptions[opcode + -30] = null;
            }
        } else if(opcode >= 35 && opcode < 40) {
            interfaceOptions[opcode + -35] = buffer.getRSString();
        } else if(opcode == 40) {
            int colorCount = buffer.getUnsignedByte();
            textureFind = new int[colorCount];
            textureReplace = new int[colorCount];
            for(int colorIndex = 0; colorIndex < colorCount; colorIndex++) {
                textureReplace[colorIndex] = buffer.getUnsignedShortBE();
                textureFind[colorIndex] = buffer.getUnsignedShortBE();
            }
        } else if(opcode == 78) {
            maleModel2 = buffer.getUnsignedShortBE();
        } else if(opcode == 79) {
            femaleModel2 = buffer.getUnsignedShortBE();
        } else if(opcode == 90) {
            primaryMaleHeadPiece = buffer.getUnsignedShortBE();
        } else if(opcode == 91) {
            primaryFemaleHeadPiece = buffer.getUnsignedShortBE();
        } else if(opcode == 92) {
            secondaryMaleHeadPiece = buffer.getUnsignedShortBE();
        } else if(opcode == 93) {
            secondaryFemaleHeadPiece = buffer.getUnsignedShortBE();
        } else if(opcode == 95) {
            zan2d = (buffer.getUnsignedShortBE());
        } else if(opcode == 97) {
            notedId = (buffer.getUnsignedShortBE());
        } else if(opcode == 98) {
            noteTemplateId = (buffer.getUnsignedShortBE());
        } else if(opcode >= 100 && opcode < 110) {
            if(stackableIds == null) {
                stackableAmounts = new int[10];
                stackableIds = new int[10];
            }
            stackableIds[-100 + opcode] = (buffer.getUnsignedShortBE());
            stackableAmounts[-100 + opcode] = (buffer.getUnsignedShortBE());
        } else if(opcode == 110) {
            groundScaleX = (buffer.getUnsignedShortBE());
        } else if(opcode == 111) {
            groundScaleY = (buffer.getUnsignedShortBE());
        } else if(opcode == 112) {
            groundScaleZ = (buffer.getUnsignedShortBE());
        } else if(opcode == 113) {
            ambient = (buffer.getByte());
        } else if(opcode == 114) {
            contrast = ((buffer.getByte()) * 5);
        } else if(opcode == 115) {
            teamIndex = buffer.getUnsignedByte();
        }
    }

    public void readValues(Buffer itemDefinitionBuffer) {
        for(; ; ) {
            int opcode = itemDefinitionBuffer.getUnsignedByte();
            if(opcode == 0) {
                break;
            }
            readValue(opcode, itemDefinitionBuffer);
        }
    }

    public void itemToNote(ItemDefinition noteTemplate, ItemDefinition note) {
        xan2d = noteTemplate.xan2d;
        xOffset2d = noteTemplate.xOffset2d;
        zan2d = noteTemplate.zan2d;
        name = note.name;
        cost = note.cost;
        stackable = 1;
        zoom2d = noteTemplate.zoom2d;
        members = note.members;
        textureFind = noteTemplate.textureFind;
        textureReplace = noteTemplate.textureReplace;
        yan2d = noteTemplate.yan2d;
        yOffset2d = noteTemplate.yOffset2d;
        inventoryModelId = noteTemplate.inventoryModelId;
    }

    public Model method753(boolean arg0, int arg1, int arg2) {
        if(arg2 != 26910) {
            anIntArray2814 = null;
        }
        if(stackableIds != null && arg1 > 1) {
            int i = -1;
            for(int i_19_ = 0; (i_19_ ^ 0xffffffff) > -11; i_19_++) {
                if(arg1 >= stackableAmounts[i_19_] && (stackableAmounts[i_19_] ^ 0xffffffff) != -1) {
                    i = stackableIds[i_19_];
                }
            }
            if(i != -1) {
                return forId(i, 10).method753(arg0, 1, 26910);
            }
        }
        if(arg0) {
            Model model = ((Model) GameFrame.aClass9_1455.method231((long) anInt2852, (byte) 87));
            if(model != null) {
                return model;
            }
        }
        Model model = Model.getModel(Class8.aCacheIndex_284, inventoryModelId, 0);
        if(model == null) {
            return null;
        }
        if((groundScaleX ^ 0xffffffff) != -129 || groundScaleY != 128 || groundScaleZ != 128) {
            model.method821(groundScaleX, groundScaleY, groundScaleZ);
        }
        if(textureReplace != null) {
            for(int i = 0; i < textureReplace.length; i++) {
                model.replaceColor(textureReplace[i], textureFind[i]);
            }
        }
        if(arg0) {
            model.method802(ambient + 64, 768 + contrast, -50, -10, -50, true);
            model.aBoolean3164 = true;
            GameFrame.aClass9_1455.method230(-7208, (long) anInt2852, model);
        }
        return model;

    }
}
