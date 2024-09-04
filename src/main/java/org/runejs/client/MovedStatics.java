package org.runejs.client;

import org.runejs.client.cache.media.ImageRGB;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.cache.media.gameInterface.GameInterfaceArea;
import org.runejs.client.cache.media.gameInterface.GameInterfaceType;
import org.runejs.client.chat.ChatColorEffect;
import org.runejs.client.chat.ChatShapeEffect;
import org.runejs.client.frame.Minimap;
import org.runejs.client.frame.ScreenController;
import org.runejs.client.frame.ScreenMode;
import org.runejs.client.frame.tab.parts.TabParts;
import org.runejs.client.input.MouseHandler;
import org.runejs.client.io.Buffer;
import org.runejs.client.media.Rasterizer;
import org.runejs.client.media.renderable.Item;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.net.*;
import org.runejs.client.node.HashTable;
import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.media.IndexedImage;
import org.runejs.client.cache.media.TypeFace;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.language.English;
import org.runejs.client.language.Native;
import org.runejs.client.media.Rasterizer3D;
import org.runejs.client.media.VertexNormal;
import org.runejs.client.scene.*;
import org.runejs.client.scene.camera.CameraRotation;
import org.runejs.client.sound.MusicSystem;
import org.runejs.client.sound.SoundSystem;
import org.runejs.client.util.BitUtils;
import org.runejs.client.util.Signlink;
import org.runejs.client.util.SignlinkNode;
import org.runejs.client.cache.def.*;
import org.runejs.client.media.renderable.actor.*;
import org.runejs.Configuration;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;

public class MovedStatics {

    public static PacketBuffer packetBuffer = new PacketBuffer(5000);
    public static int[][] anIntArrayArray1435 = new int[104][104];
    public static ProducingGraphicsBuffer tabPieceUpperRight;
    public static ProducingGraphicsBuffer chatboxRight;
    public static int anInt2280 = 0;
    public static int chatEffectsDisabled = 0;
    public static int anInt321 = 5063219;
    public static boolean redrawChatbox = false;
    public static int pulseCycle = 0;
    public static boolean aBoolean2083 = false;
    public static ProducingGraphicsBuffer tabImageProducer;
    /**
     * The image used for the highlighted (selected) tab button,
     * for one of the tabs on the left-hand side of the bottom,
     * but not the furthest-left (see `tabHighlightImageBottomLeftEdge` for that).
     */
    public static IndexedImage tabHighlightImageBottomLeft;
    public static boolean aBoolean565 = false;
    public static int openWidgetChildTooltipId = -1;
    public static boolean menuOpen = false;
    public static volatile long aLong174 = 0L;

    /**
     * Position of the hint icon in world coordinates (e.g. 3222,3222).
     */
    public static int hintIconPosY = 0;
    public static int[] chatboxLineOffsets;
    public static volatile boolean aBoolean1575 = false;
    public static int anInt1586 = -1;
    public static boolean reportMutePlayer = false;
    public static long[] tickSamples = new long[32];
    /**
     * The image used for the highlighted (selected) tab button,
     * for the furthest-left tab on the top row.
     */
    public static IndexedImage tabHighlightImageTopLeftEdge;
    public static IndexedImage tabBottomBack;
    /**
     * Up/down arrow images for the scrollbar.
     */
    public static IndexedImage[] scrollbarArrowImages;
    public static boolean showChatPanelRedrawnText = false;
    public static int lastContinueTextWidgetId = -1;
    public static GameSocket gameServerSocket;
    /**
     * The image used for the highlighted (selected) tab button,
     * for the furthest-right tab on the top row.
     */
    public static IndexedImage tabHighlightImageTopRightEdge;
    /**
     * The overhead chat colours in RGB.
     *
     * Yellow, Red, Green, Cyan, Purple, White
     */
    public static int[] OVERHEAD_CHAT_COLORS = {16776960, 16711680, 65280, 65535, 16711935, 16777215};
    public static int[] anIntArray2113 = new int[128];
    public static int multiCombatState = 0;
    public static int placementX;
    public static int onBuildTimePlane = 0;
    public static int anInt1996 = 0;
    public static HashTable aClass23_805;
    /**
     * Whether to draw the right-click menu with item name separated
     *
     * TODO (jkm) what is this? it's never modified in code
     */
    public static int drawMenuSeparateName = 0;
    public static int[] anIntArray852;
    public static long localUsernameId;
    public static int anInt2621 = 0;
    public static volatile int eventClickY = 0;
    public static int anInt2628 = 0;
    public static volatile boolean clearScreen = true;
    public static ProducingGraphicsBuffer gameScreenImageProducer;
    public static int destinationX = 0;
    /**
     * The hint (arrow) icon sprites.
     */
    public static ImageRGB[] hintIconSprites;
    public static int childCount;
    public static int baseX;
    public static IndexedImage[] moderatorIcon;
    public static int[] anIntArray2764 = new int[128];
    public static int imageMaxHeight;
    public static IndexedImage inventoryBackgroundImage;
    public static int hoveredWidgetId = -1;
    public static ProducingGraphicsBuffer chatModes;
    public static int hintIconNpcTarget = 0;
    public static int[] sidebarOffsets;
    public static int menuActionRow = 0;
    /**
     * Draw height of the icon in 3d positions.
     */
    public static int hintIconPosZ = 0;
    public static int anInt2183 = 0;
    public static boolean membersServer;
    public static HuffmanEncoding aHuffmanEncoding_2590;
    public static int anInt2598 = 0;
    public static int height;
    public static int anInt2798 = 0;
    public static int selectedMask;
    public static int imageMaxWidth;
    public static int hoveredWidgetChildId = -1;
    /**
     * Something to do with key presses.
     */
    public static int anInt2854;
    public static int placementY;
    public static int crossIndex = 0;
    public static byte[][][] tile_flags = new byte[4][104][104];
    public static int tempHoveredWidgetChildId = -1;
    public static int[] directions = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
    public static int menuScreenArea;
    public static ProducingGraphicsBuffer framePieceTop;
    public static TypeFace fontNormal;
    /**
     * The image used for the highlighted (selected) tab button,
     * for one of the tabs on the right-hand side of the top,
     * but not the furthest-right (see `tabHighlightImageTopRightEdge` for that).
     */
    public static IndexedImage tabHighlightImageTopRight;
    public static int durationHoveredOverWidget = 0;
    public static IndexedImage bottomChatBack;
    public static int[] spriteOffsetX;
    public static LinkedList spotAnimQueue = new LinkedList();
    public static int runWeight = 0;
    public static int anInt1214 = 0;
    public static ImageRGB[] aClass40_Sub5_Sub14_Sub4Array603;
    public static SignlinkNode gameServerSignlinkNode;
    public static int openTabWidgetChildTooltipId = -1;
    public static LinkedList[][][] groundItems = new LinkedList[4][104][104];
    public static String[] menuActionTexts = new String[500];
    public static int tempOpenWidgetChildTooltipId = -1;
    public static int currentHoveredWidgetChildId = -1;
    public static int currentHoveredChatboxWidgetChildId = -1;
    public static int[] firstMenuOperand = new int[500];
    public static int[] secondMenuOperand = new int[500];
    public static int[] selectedMenuActions = new int[500];
    public static int menuWidth;
    public static int menuOffsetX;
    public static int menuHeight;
    public static ImageRGB multiCombatIcon;
    public static LinkedList interactiveObjectTemporaryNodeCache = new LinkedList();
    public static int crossType = 0;
    public static int hintIconPlayerTarget = 0;
    /**
     * Position of the hint icon within the specific tile.
     */
    public static int hintIconInnerPosY = 0;
    /**
     * Position of the hint icon within the specific tile.
     */
    public static int hintIconInnerPosX = 0;
    /**
     * Position of the hint icon in world coordinates (e.g. 3222,3222)
     */
    public static int hintIconPosX = 0;
    public static int systemUpdateTime = 0;
    public static LinkedList projectileQueue = new LinkedList();
    public static int bankInsertMode = 0;
    public static int width;
    public static SignlinkNode aSignlinkNode_394;
    /**
     * The image used for the highlighted (selected) tab button,
     * for one of the tabs on the right-hand side of the bottom,
     * but not the furthest-right (see `tabHighlightImageBottomRightEdge` for that).
     */
    public static IndexedImage tabHighlightImageBottomRight;
    public static ProducingGraphicsBuffer chatboxTop;
    public static int deregisterActorCount = 0;
    public static int[] spriteWidth;
    public static int regionY;
    public static int[] fullScreenTextureArray;
    public static Image loadingBoxImage;
    public static int baseY;
    /**
     * The image used for the highlighted (selected) tab button,
     * for the central tab on the top row.
     */
    public static IndexedImage tabHighlightImageTopMiddle;
    public static ImageRGB[] cursorCross;
    public static ProducingGraphicsBuffer mapbackLeft;
    public static int ticksPerLoop;
    public static boolean showIconsRedrawnText = false;
    public static IndexedImage[] tabIcons;
    public static boolean lastItemDragged = false;
    public static ProducingGraphicsBuffer mapBackRight;
    public static IndexedImage chatboxBackgroundImage;
    /**
     * Local player's membership status, used to allow for
     * increased friend limit sizes in non-member worlds.
     */
    public static int isLocalPlayerMember = 0;
    public static int regionX;
    /**
     * Last pressed key? maybe
     */
    public static int anInt1388;
    /**
     * Something to do with keyboard input
     */
    public static int anInt1389 = 0;
    public static boolean DEBUG_DISPLAY_ALL_ACTION_ROWS = false;
    public static ProducingGraphicsBuffer framePieceRight;
    /**
     * Something to do with minimap
     */
    public static int[] anIntArray1186;
    /**
     * Overhead icon sprites, e.g. overhead prayers
     */
    public static ImageRGB[] headIconSprites;
    public static ProducingGraphicsBuffer aProducingGraphicsBuffer_2213;
    public static int anInt57;
    public static ProducingGraphicsBuffer tabBottom;
    public static int[] keyCodes = new int[128];
    public static int tooltipDelay = 50;
    /**
     * The image used for the highlighted (selected) tab button,
     * for the furthest-right tab on the bottom.
     */
    public static IndexedImage tabHighlightImageBottomRightEdge;
    public static boolean aBoolean512;
    public static int[] spriteOffsetY;
    public static Signlink signlink;
    public static ProducingGraphicsBuffer tabPieveLowerRight;
    public static GameSocket lostConnectionSocket;
    public static ProducingGraphicsBuffer tabPieceLeft;
    public static boolean[] obfuscatedKeyStatus = new boolean[112];
    public static int[] crc8LookupTable = new int[256];
    public static int currentTickSample;
    public static boolean showFps = false;
    public static int anInt487 = 0;
    /**
     * Top row of sideicon tabs
     */
    public static ProducingGraphicsBuffer tabTop;
    public static byte[][] spritePixels;
    /**
     * Last varp handle cycle?
     */
    public static int anInt2480 = 0;
    public static ImageRGB[] aClass40_Sub5_Sub14_Sub4Array2474;
    public static IndexedImage tabTopBack;
    /**
     * Some kind of colour palette
     */
    public static int[] spritePalette;
    /**
     * Sprite heights?
     */
    public static int[] spriteHeight;
    /**
     * The image used for the highlighted (selected) tab button,
     * for the furthest-left tab on the bottom.
     */
    public static IndexedImage tabHighlightImageBottomLeftEdge;
    /**
     * Something to do with item drag tracking
     */
    public static int anInt2869 = 0;

    public static void method440() {
        if (aBoolean512) {
            LoginScreen.anIntArray1198 = null;
            LoginScreen.flameRightBackground = null;
            LoginScreen.aProducingGraphicsBuffer_1631 = null;
            LoginScreen.aProducingGraphicsBuffer_1206 = null;
            LoginScreen.anIntArray1168 = null;
            LoginScreen.anIntArray3255 = null;
            LoginScreen.imgLoginScreenButton = null;
            LoginScreen.anIntArray1445 = null;
            LoginScreen.loginScreenBox = null;
            LoginScreen.anIntArray2865 = null;
            LoginScreen.flameLeftBackground = null;
            LoginScreen.aProducingGraphicsBuffer_907 = null;
            LoginScreen.aProducingGraphicsBuffer_2524 = null;
            LoginScreen.aClass40_Sub5_Sub14_Sub4_918 = null;
            LoginScreen.aClass40_Sub5_Sub14_Sub2Array535 = null;
            LoginScreen.anIntArray3248 = null;
            LoginScreen.loginBoxGraphics = null;
            LoginScreen.aClass40_Sub5_Sub14_Sub4_2043 = null;
            LoginScreen.anIntArray178 = null;
            LoginScreen.aProducingGraphicsBuffer_1285 = null;
            LoginScreen.aProducingGraphicsBuffer_463 = null;
            LoginScreen.anIntArray1013 = null;
            MusicSystem.method405(10);
            Game.updateServerConnectionManager.updateServer.resetRequests(true);
            aBoolean512 = false;
        }
    }

    public static int[] menuActionTypes = new int[500];
    public static boolean showSidePanelRedrawnText = false;
    /**
     * The image used for the highlighted (selected) tab button,
     * for the central tab on the bottom row.
     */
    public static IndexedImage tabHighlightImageBottomMiddle;

    public static void addSplitPrivateChatActionRows() {
        if (ChatBox.splitPrivateChat != 0) {
            int currentRow = 0;
            if (systemUpdateTime != 0)
                currentRow = 1;
            for (int i = 0; i < 100; i++) {
                if (ChatBox.chatMessages[i] != null) {
                    int type = ChatBox.chatTypes[i];
                    String username = ChatBox.chatPlayerNames[i];
                    if (username != null && username.startsWith(Native.whiteCrown))
                        username = username.substring(5);
                    if (username != null && username.startsWith(Native.goldCrown))
                        username = username.substring(5);
                    if ((type == 3 || type == 7) && (type == 7 || ChatBox.privateChatMode == 0 || ChatBox.privateChatMode == 1 && Player.hasFriend(username))) {
                        int y = 329 + -(13 * currentRow);
                        currentRow++;
                        if (MouseHandler.mouseX > 4 && y + -10 < MouseHandler.mouseY + -4 && -4 + MouseHandler.mouseY <= y + 3) {
                            int x = 25 + fontNormal.getStringWidth(English.from + Native.prefixColon + username + ChatBox.chatMessages[i]);
                            if (x > 450)
                                x = 450;
                            if (MouseHandler.mouseX < 4 + x) {
                                int actionRowOffset = ActionRowType.LOW_PRIORITY_MODIFIER;
                                if (Game.playerRights >= 1) {
                                    addActionRow(English.reportAbuse, 0, 0, 0, actionRowOffset + ActionRowType.REPORT_ABUSE.getId(), Native.white + username);
                                }
                                addActionRow(English.addIgnore, 0, 0, 0, actionRowOffset + ActionRowType.ADD_IGNORE.getId(), Native.white + username);
                                addActionRow(English.addFriend, 0, 0, 0, actionRowOffset + ActionRowType.ADD_FRIEND.getId(), Native.white + username);
                            }
                        }
                        if (currentRow >= 5)
                            return;
                    }
                    if ((type == 5 || type == 6) && ChatBox.privateChatMode < 2 && ++currentRow >= 5)
                        return;
                }
            }
        }
    }

    public static void method996() {
        tabImageProducer.prepareRasterizer();
        if (ScreenController.frameMode == ScreenMode.FIXED) {
            inventoryBackgroundImage.drawImage(0, 0);

        } else {
            int currentX = 0;
            int currentY = 0;
            while (currentX < tabImageProducer.width || currentY < tabImageProducer.height) {
                ImageRGB part = TabParts.GetPart("side_panel_background");
                if (currentX > tabImageProducer.width) {
                    currentX = 0;
                    currentY += part.imageHeight;
                }
                part.drawImage(currentX, currentY);
                currentX += part.imageWidth;
            }
        }


        sidebarOffsets = Rasterizer3D.setLineOffsets(sidebarOffsets);
    }

    public static int getCutsceneCameraPlane() {
        if (!Configuration.ROOFS_ENABLED) {
            return Player.worldLevel;
        }

        Point3d cameraPos = Game.cutsceneCamera.getPosition();

        int i = Game.currentScene.getFloorDrawHeight(Player.worldLevel, cameraPos.x, cameraPos.y);
        if (i + -cameraPos.z < 800 && (tile_flags[Player.worldLevel][cameraPos.x >> 7][cameraPos.y >> 7] & 0x4) != 0)
            return Player.worldLevel;
        return 3;
    }

    public static IndexedImage createIndexedImageFromDecodedData() {
        IndexedImage image = new IndexedImage();
        image.maxWidth = imageMaxWidth;
        image.maxHeight = imageMaxHeight;
        image.xDrawOffset = spriteOffsetX[0];
        image.yDrawOffset = spriteOffsetY[0];
        image.imgWidth = spriteWidth[0];
        image.imgHeight = spriteHeight[0];
        image.palette = spritePalette;
        image.imgPixels = spritePixels[0];
        clearDecodedSpriteData();
        return image;
    }

    public static RSString intToStr(int arg0) {
        return RSString.method521(false, 10, arg0);
    }

    public static int calculateCrc8(int offset, int size, byte[] data) {
        int crc = -1;
        for (int currentByte = offset; currentByte < size; currentByte++) {
            int tableIndex = 0xff & (crc ^ data[currentByte]);
            crc = crc8LookupTable[tableIndex] ^ crc >>> 8;
        }
        crc ^= 0xffffffff;
        return crc;
    }

    /**
     * Iterate through the list of input options and return a new list containing
     * all 5 option indices with their value (including empty rows)
     *
     * @param inputOptions The available options
     * @return A list of all 5 option indices
     */
    public static String[] getAllOptionsWithIndices(String[] inputOptions) {
        String[] allOptions = new String[5];

        for (int i = 0; i < 5; i++) {
            allOptions[i] = i + Native.COLON_CHARACTER;
            if (inputOptions != null && inputOptions[i] != null)
                allOptions[i] = allOptions[i] + inputOptions[i];
        }

        return allOptions;
    }

    public static void printException(String arg0, Throwable exception) {
            try {
                String string = "";
                if (exception != null)
                    string = parseException(exception);
                if (arg0 != null) {
                    if (exception != null)
                        string += " | ";
                    string += arg0;
                }
                System.out.println("Error: " + string);
                string = string.replace(':', '.');
                string = string.replace('@', '_');
                string = string.replace('&', '_');
                string = string.replace('#', '_');
                SignlinkNode signlinkNode = signlink.putDataInputStreamNode(new URL(signlink.gameShell.getCodeBase(), "clienterror.ws?c=" + Game.clientVersion + "&u=" + localUsernameId + "&v1=" + Signlink.javaVendor + "&v2=" + Signlink.javaVersion + "&e=" + string));
                while (signlinkNode.status == SignlinkNode.Status.NOT_INITIALIZED)
                    threadSleep(1L);
                if (signlinkNode.status != SignlinkNode.Status.INITIALIZED)
                    return;
                DataInputStream datainputstream = (DataInputStream) signlinkNode.value;
                datainputstream.read();
                datainputstream.close();
            } catch (Exception ignored) { }
    }

    public static void decodeImageData(byte[] data) {
        Buffer buffer = new Buffer(data);
        buffer.currentPosition = -2 + data.length;
        childCount = buffer.getUnsignedShortBE();
        spriteOffsetY = new int[childCount];
        spritePixels = new byte[childCount][];
        spriteWidth = new int[childCount];
        spriteHeight = new int[childCount];
        spriteOffsetX = new int[childCount];

        buffer.currentPosition = data.length - 7 - (childCount * 8);
        imageMaxWidth = buffer.getUnsignedShortBE();
        imageMaxHeight = buffer.getUnsignedShortBE();
        int paletteSize = 1 + (buffer.getUnsignedByte() & 0xff);
        for (int c = 0; c < childCount; c++)
            spriteOffsetX[c] = buffer.getUnsignedShortBE();
        for (int c = 0; c < childCount; c++)
            spriteOffsetY[c] = buffer.getUnsignedShortBE();
        for (int c = 0; c < childCount; c++)
            spriteWidth[c] = buffer.getUnsignedShortBE();
        for (int c = 0; childCount > c; c++)
            spriteHeight[c] = buffer.getUnsignedShortBE();

        buffer.currentPosition = data.length - (7 + childCount * 8 + -3 + paletteSize * 3);
        spritePalette = new int[paletteSize];
        for (int p = 1; paletteSize > p; p++) {
            spritePalette[p] = buffer.getMediumBE();
            if (spritePalette[p] == 0)
                spritePalette[p] = 1;
        }
        buffer.currentPosition = 0;
        for (int c = 0; childCount > c; c++) {
            int h = spriteHeight[c];
            int w = spriteWidth[c];
            int area = h * w;
            byte[] pixels = new byte[area];
            spritePixels[c] = pixels;
            int pixelOrder = buffer.getUnsignedByte();
            if (pixelOrder == 0) {
                for (int p = 0; area > p; p++) {
                    pixels[p] = buffer.getByte();
                }
            } else if (pixelOrder == 1) {
                for (int x = 0; w > x; x++) {
                    for (int y = 0; h > y; y++) {
                        pixels[w * y + x] = buffer.getByte();
                    }
                }
            }
        }
    }

    public static String method204(int arg0) {
        return (0xff & arg0 >> 24) + Native.period + ((arg0 & 0xffca88) >> 16) + Native.period + ((0xfff8 & arg0) >> 8) + Native.period + (0xff & arg0);
    }

    public static void method527(int currentTabId, int[] tabWidgetIds, boolean arg3, int arg4) {
        tabTop.prepareRasterizer();
        tabTopBack.drawImage(0, 0);
        if (arg3) {
            if (tabWidgetIds[currentTabId] != -1) {
                if (currentTabId == 0)
                    tabHighlightImageTopLeftEdge.drawImage(22, 10);
                if (currentTabId == 1)
                    GameInterface.tabHighlightImageTopLeft.drawImage(54, 8);
                if (currentTabId == 2)
                    GameInterface.tabHighlightImageTopLeft.drawImage(82, 8);
                if (currentTabId == 3)
                    tabHighlightImageTopMiddle.drawImage(110, 8);
                if (currentTabId == 4)
                    tabHighlightImageTopRight.drawImage(153, 8);
                if (currentTabId == 5)
                    tabHighlightImageTopRight.drawImage(181, 8);
                if (currentTabId == 6)
                    tabHighlightImageTopRightEdge.drawImage(209, 9);
            }
            if (tabWidgetIds[0] != -1 && arg4 != 0)
                tabIcons[0].drawImage(29, 13);
            if (tabWidgetIds[1] != -1 && arg4 != 1)
                tabIcons[1].drawImage(53, 11);
            if (tabWidgetIds[2] != -1 && arg4 != 2)
                tabIcons[2].drawImage(82, 11);
            if (tabWidgetIds[3] != -1 && arg4 != 3)
                tabIcons[3].drawImage(115, 12);
            if (tabWidgetIds[4] != -1 && arg4 != 4)
                tabIcons[4].drawImage(153, 13);
            if (tabWidgetIds[5] != -1 && arg4 != 5)
                tabIcons[5].drawImage(180, 11);
            if (tabWidgetIds[6] != -1 && arg4 != 6)
                tabIcons[6].drawImage(208, 13);
        }
        tabBottom.prepareRasterizer();
        tabBottomBack.drawImage(0, 0);
        if (4 != 4)
            Player.hasFriend(null);
        if (arg3) {
            if (tabWidgetIds[currentTabId] != -1) {
                if (currentTabId == 7)
                    tabHighlightImageBottomLeftEdge.drawImage(42, 0);
                if (currentTabId == 8)
                    tabHighlightImageBottomLeft.drawImage(74, 0);
                if (currentTabId == 9)
                    tabHighlightImageBottomLeft.drawImage(102, 0);
                if (currentTabId == 10)
                    tabHighlightImageBottomMiddle.drawImage(130, 1);
                if (currentTabId == 11)
                    tabHighlightImageBottomRight.drawImage(173, 0);
                if (currentTabId == 12)
                    tabHighlightImageBottomRight.drawImage(201, 0);
                if (currentTabId == 13)
                    tabHighlightImageBottomRightEdge.drawImage(229, 0);
            }
            if (tabWidgetIds[8] != -1 && arg4 != 8)
                tabIcons[7].drawImage(74, 2);
            if (tabWidgetIds[9] != -1 && arg4 != 9)
                tabIcons[8].drawImage(102, 3);
            if (tabWidgetIds[10] != -1 && arg4 != 10)
                tabIcons[9].drawImage(137, 4);
            if (tabWidgetIds[11] != -1 && arg4 != 11)
                tabIcons[10].drawImage(174, 2);
            if (tabWidgetIds[12] != -1 && arg4 != 12)
                tabIcons[11].drawImage(201, 2);
            if (tabWidgetIds[13] != -1 && arg4 != 13)
                tabIcons[12].drawImage(226, 2);
        }
        try {
            Graphics graphics = Game.gameCanvas.getGraphics();
            if (ScreenController.frameMode == ScreenMode.FIXED) {
                tabTop.drawGraphics(516, 160, graphics);
                tabBottom.drawGraphics(496, 466, graphics);
            }
        } catch (Exception exception) {
            Game.gameCanvas.repaint();
        }
    }

    public static boolean method416() {
        synchronized (Game.keyFocusListener) {
            if (anInt1389 == anInt1214)
                return false;
            anInt2854 = anIntArray2113[anInt1389];
            anInt1388 = anIntArray2764[anInt1389];
            anInt1389 = anInt1389 + 1 & 0x7f;
            return true;
        }
    }

    public static int mixLightnessSigned(int hsl, int lightness) {
        if (hsl == -2)
            return 12345678;

        if (hsl == -1) {
            if (lightness < 0)
                lightness = 0;
            else if (lightness > 127)
                lightness = 127;
            lightness = -lightness + 127;
            return lightness;
        }

        lightness = lightness * (hsl & 0x7f) / 128;
        if (lightness < 2)
            lightness = 2;
        else if (lightness > 126)
            lightness = 126;
        return (0xff80 & hsl) + lightness;
    }

    public static void method1013() {
        int lasthash = -1;
        if (GameInterface.itemCurrentlySelected == 0 && Game.widgetSelected == 0) {
            String tileCoords = "";
            if (Configuration.DEBUG_CONTEXT) {
                tileCoords = MessageFormat.format("<col=8F8FFF>({0}, {1})</col>", Integer.toString(Game.currentScene.hoveredTileX + baseX), Integer.toString(Game.currentScene.hoveredTileY + baseY));
                if (Game.playerRights >= 2) {
                    addActionRow(English.teleportHere, 0, (Game.currentScene.hoveredTileX + baseX), (Game.currentScene.hoveredTileY + baseY), ActionRowType.TELEPORT_HERE.getId(), tileCoords);
                }
            }
            addActionRow(English.walkHere, 0, MouseHandler.mouseX, MouseHandler.mouseY, ActionRowType.WALK_HERE.getId(), tileCoords);
        }

        for (int idx = 0; Model.resourceCount > idx; idx++) {
            int hash = Model.hoveredHash[idx];
            int x = 0x7f & hash;
            int y = hash >> 7 & 0x7f;
            int type = hash >> 29 & 0x3;
            int index = (hash & 0x1fffcccc) >> 14;
            if (lasthash != hash) {
                lasthash = hash;
                if (type == 2 && Game.currentScene.getArrangement(Player.worldLevel, x, y, hash) >= 0) {
                    GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(index);
                    if (gameObjectDefinition.childIds != null)
                        gameObjectDefinition = gameObjectDefinition.getChildDefinition();
                    if (gameObjectDefinition == null)
                        continue;
                    if (GameInterface.itemCurrentlySelected == 1) {
                        addActionRow(English.use, hash, x, y, ActionRowType.USE_ITEM_ON_OBJECT.getId(), Native.selectedItemName + Native.toCyan + gameObjectDefinition.name);
                    } else if (Game.widgetSelected != 1) {
                        String[] options = gameObjectDefinition.actions;
                        if (DEBUG_DISPLAY_ALL_ACTION_ROWS)
                            options = getAllOptionsWithIndices(options);
                        if (options != null) {
                            for (int i_7_ = 4; i_7_ >= 0; i_7_--) {
                                if (options[i_7_] != null) {
                                    int actionType = 0;
                                    if (i_7_ == 0)
                                        actionType = ActionRowType.INTERACT_WITH_OBJECT_OPTION_1.getId();
                                    if (i_7_ == 1)
                                        actionType = ActionRowType.INTERACT_WITH_OBJECT_OPTION_2.getId();
                                    if (i_7_ == 2)
                                        actionType = ActionRowType.INTERACT_WITH_OBJECT_OPTION_3.getId();
                                    if (i_7_ == 3)
                                        actionType = ActionRowType.INTERACT_WITH_OBJECT_OPTION_4.getId();
                                    if (i_7_ == 4)
                                        actionType = ActionRowType.INTERACT_WITH_OBJECT_OPTION_5.getId();
                                    addActionRow(options[i_7_], hash, x, y, actionType, Native.cyan + gameObjectDefinition.name);
                                }
                            }
                        }
                        StringBuilder examineText = new StringBuilder();
                        examineText.append(MessageFormat.format("<col=00ffff>{0}</col>", gameObjectDefinition.name));
                        if (Configuration.DEBUG_CONTEXT) {
                            examineText.append(" <col=00ff00>(</col>");
                            examineText.append(
                                    MessageFormat.format("<col=ffffff>{0}</col>",
                                            Integer.toString(gameObjectDefinition.id)
                                    )
                            );
                            examineText.append("<col=00ff00>) (</col>");
                            examineText.append(
                                    MessageFormat.format("<col=ffffff>{0}, {1}</col>",
                                            Integer.toString(x + baseX),
                                            Integer.toString(y + baseY)
                                    )
                            );
                            examineText.append("<col=00ff00>)</col>");


                        }
                        addActionRow(English.examine, gameObjectDefinition.id << 14, x, y, ActionRowType.EXAMINE_OBJECT.getId(), examineText.toString());
                    } else if ((selectedMask & 0x4) == 4) {
                        addActionRow(Native.selectedSpellVerb, hash, x, y, ActionRowType.CAST_MAGIC_ON_OBJECT.getId(), Native.selectedSpellName + Native.toCyan + gameObjectDefinition.name);
                    }
                }
                if (type == 1) {
                    Npc npc = Player.npcs[index];
                    if (npc.actorDefinition.boundaryDimension == 1 && (npc.worldX & 0x7f) == 64 && (0x7f & npc.worldY) == 64) {
                        for (int i_9_ = 0; Player.npcCount > i_9_; i_9_++) {
                            Npc npc1 = Player.npcs[Player.npcIds[i_9_]];
                            if (npc1 != null && npc1 != npc && npc1.actorDefinition.boundaryDimension == 1 && npc1.worldX == npc.worldX && npc1.worldY == npc.worldY)
                                processNpcMenuOptions(npc1.actorDefinition, x, y, Player.npcIds[i_9_]);
                        }
                        for (int i_11_ = 0; i_11_ < Player.localPlayerCount; i_11_++) {
                            Player player = Player.trackedPlayers[Player.trackedPlayerIndices[i_11_]];
                            if (player != null && npc.worldX == player.worldX && player.worldY == npc.worldY)
                                Player.processPlayerMenuOptions(player, x, y, Player.trackedPlayerIndices[i_11_]);
                        }
                    }
                    processNpcMenuOptions(npc.actorDefinition, x, y, index);
                }
                if (type == 0) {
                    Player player1 = Player.trackedPlayers[index];
                    if ((0x7f & player1.worldX) == 64 && (0x7f & player1.worldY) == 64) {
                        for (int i_12_ = 0; i_12_ < Player.npcCount; i_12_++) {
                            Npc npc = Player.npcs[Player.npcIds[i_12_]];
                            if (npc != null && npc.actorDefinition.boundaryDimension == 1 && npc.worldX == player1.worldX && npc.worldY == player1.worldY)
                                processNpcMenuOptions(npc.actorDefinition, x, y, Player.npcIds[i_12_]);
                        }
                        for (int i_13_ = 0; i_13_ < Player.localPlayerCount; i_13_++) {
                            Player player = Player.trackedPlayers[Player.trackedPlayerIndices[i_13_]];
                            if (player != null && player != player1 && player1.worldX == player.worldX && player1.worldY == player.worldY)
                                Player.processPlayerMenuOptions(player, x, y, Player.trackedPlayerIndices[i_13_]);
                        }
                    }
                    Player.processPlayerMenuOptions(player1, x, y, index);
                }
                if (type == 3) {
                    LinkedList itemList = groundItems[Player.worldLevel][x][y];
                    if (itemList != null) {
                        for (Item item = (Item) itemList.peekLast(); item != null; item = (Item) itemList.pollLast()) {
                            ItemDefinition itemDefinition = ItemDefinition.forId(item.itemId, 10);
                            if (GameInterface.itemCurrentlySelected == 1) {
                                addActionRow(English.use, item.itemId, x, y, ActionRowType.USE_ITEM_ON_WORLD_ITEM.getId(), Native.selectedItemName + Native.toLightRed + itemDefinition.name);
                            } else if (Game.widgetSelected != 1) {
                                String[] class1s = itemDefinition.groundOptions;
                                if (DEBUG_DISPLAY_ALL_ACTION_ROWS)
                                    class1s = getAllOptionsWithIndices(class1s);
                                for (int i_15_ = 4; i_15_ >= 0; i_15_--) {
                                    if (class1s == null || class1s[i_15_] == null) {
                                        if (i_15_ == 2) {
                                            // TODO (jameskmonger) this is the same id as WORLD_ITEM_INTERACTION_OPTION_3
                                            addActionRow(English.take, item.itemId, x, y, 3, Native.lightRed + itemDefinition.name);
                                        }
                                    } else {
                                        int actionType = 0;
                                        if (i_15_ == 0)
                                            actionType = ActionRowType.INTERACT_WITH_WORLD_ITEM_OPTION_1.getId();
                                        if (i_15_ == 1)
                                            actionType = ActionRowType.INTERACT_WITH_WORLD_ITEM_OPTION_2.getId();
                                        if (i_15_ == 2)
                                            actionType = ActionRowType.INTERACT_WITH_WORLD_ITEM_OPTION_3.getId();
                                        if (i_15_ == 3)
                                            actionType = ActionRowType.INTERACT_WITH_WORLD_ITEM_OPTION_4.getId();
                                        if (i_15_ == 4)
                                            actionType = ActionRowType.INTERACT_WITH_WORLD_ITEM_OPTION_5.getId();
                                        addActionRow(class1s[i_15_], item.itemId, x, y, actionType, Native.lightRed +  itemDefinition.name);
                                    }
                                }
                                addActionRow(English.examine, item.itemId, x, y, ActionRowType.EXAMINE_ITEM.getId(), Native.lightRed + itemDefinition.name);
                            } else if ((0x1 & selectedMask) == 1) {
                                addActionRow(Native.selectedSpellVerb, item.itemId, x, y, ActionRowType.CAST_MAGIC_ON_WORLD_ITEM.getId(), Native.selectedSpellName + Native.toLightRed + itemDefinition.name);
                            }
                        }
                    }
                }
            }
        }

    }

    /**
     * Processes a new status code
     * @param statusCode Can be one of these values:
     *                 5 = Login background
     *                 10 = Login screen
     *                 20 = Empty login box
     *                 25 = Game overlay
     *                 30 = 3D game area
     *                 40 = Connection lost, attempting to re-establish
     *                 1000 = Client fatal error
     */
    public static void processGameStatus(int statusCode) {
        if (statusCode != Game.gameStatusCode) {
            if (Game.gameStatusCode == 0)
                Game.renderer.disposeLoadingText();
            if (statusCode == 20 || statusCode == 40) {
                Game.loginProtocol.reset();
            }
            if (statusCode != 20 && statusCode != 40 && lostConnectionSocket != null) {
                lostConnectionSocket.kill();
                lostConnectionSocket = null;
            }
            if (Game.gameStatusCode == 25 || Game.gameStatusCode == 40) {
                method1018();
                Rasterizer.resetPixels();
            }
            if (Game.gameStatusCode == 25) {
                Game.missingLandscapeFiles = 0;
                Game.totalMissingLandscapeFiles = 1;
                Game.missingGameObjectFiles = 0;
                Game.totalMissingGameObjectFiles = 1;
                Game.regionLoadingType = 0;
            }
            if (statusCode == 0 || statusCode == 35) {
                method344(-40);
                method440();
                if (aProducingGraphicsBuffer_2213 == null)
                    aProducingGraphicsBuffer_2213 = createGraphicsBuffer(765, 503, Game.gameCanvas);
            }
            if (statusCode == 5 || statusCode == 10 || statusCode == 20) {
                aProducingGraphicsBuffer_2213 = null;
                method344(-69);
                LoginScreen.renderLoginScreen(Game.gameCanvas, CacheArchive.huffmanCacheArchive, CacheArchive.gameImageCacheArchive);
            }
            if (statusCode == 25 || statusCode == 30 || statusCode == 40) {
                aProducingGraphicsBuffer_2213 = null;
                method440();
                method763(Game.gameCanvas, CacheArchive.gameImageCacheArchive);
            }
            Game.gameStatusCode = statusCode;
            clearScreen = true;
        }
    }

    public static void addActionRow(String string, int menuAction, int firstOperand, int secondOperand, int actionType, String arg6) {
        if (menuActionRow < 500) {
            if (arg6.length() <= 0)
                menuActionTexts[menuActionRow] = string;
            else
                menuActionTexts[menuActionRow] = string + Native.whitespace + arg6;
            menuActionTypes[menuActionRow] = actionType;
            selectedMenuActions[menuActionRow] = menuAction;
            firstMenuOperand[menuActionRow] = firstOperand;
            secondMenuOperand[menuActionRow] = secondOperand;
            menuActionRow++;
        }
    }


    public static ProducingGraphicsBuffer createGraphicsBuffer(int width, int height, Component component) {
        try {
            ProducingGraphicsBuffer producingGraphicsBuffer = new ProducingGraphicsBuffer_Sub2();
            producingGraphicsBuffer.method1041(13, width, component, height);
            return producingGraphicsBuffer;
        } catch(Throwable throwable) {
            ProducingGraphicsBuffer_Sub1 class68_sub1 = new ProducingGraphicsBuffer_Sub1();
            class68_sub1.method1041(44, width, component, height);
            return class68_sub1;
        }
    }

    /**
     * Count down any temporary scene objects and remove them if necessary.
     */
    public static void tickTemporaryObjects() {
        for(InteractiveObjectTemporary interactiveObjectTemporary = (InteractiveObjectTemporary) interactiveObjectTemporaryNodeCache.peekFirst(); interactiveObjectTemporary != null; interactiveObjectTemporary = (InteractiveObjectTemporary) interactiveObjectTemporaryNodeCache.pollFirst()) {
            if(interactiveObjectTemporary.duration > 0)
                interactiveObjectTemporary.duration--;
            if(interactiveObjectTemporary.duration == 0) {
                if(interactiveObjectTemporary.previousId < 0 || GameObjectDefinition.isObjectLoaded(interactiveObjectTemporary.previousType, interactiveObjectTemporary.previousId)) {
                    addObject(interactiveObjectTemporary.y, interactiveObjectTemporary.previousId, interactiveObjectTemporary.x, interactiveObjectTemporary.previousType, interactiveObjectTemporary.previousOrientation, interactiveObjectTemporary.typeKey, interactiveObjectTemporary.plane);
                    interactiveObjectTemporary.unlink();
                }
            } else {
                if(interactiveObjectTemporary.delay > 0)
                    interactiveObjectTemporary.delay--;
                if(interactiveObjectTemporary.delay == 0 && interactiveObjectTemporary.x >= 1 && interactiveObjectTemporary.y >= 1 && interactiveObjectTemporary.x <= 102 && interactiveObjectTemporary.y <= 102 && (interactiveObjectTemporary.id < 0 || GameObjectDefinition.isObjectLoaded(interactiveObjectTemporary.type, interactiveObjectTemporary.id))) {
                    addObject(interactiveObjectTemporary.y, interactiveObjectTemporary.id, interactiveObjectTemporary.x, interactiveObjectTemporary.type, interactiveObjectTemporary.orientation, interactiveObjectTemporary.typeKey, interactiveObjectTemporary.plane);
                    interactiveObjectTemporary.delay = -1;
                    if(interactiveObjectTemporary.previousId == interactiveObjectTemporary.id && interactiveObjectTemporary.previousId == -1)
                        interactiveObjectTemporary.unlink();
                    else if(interactiveObjectTemporary.previousId == interactiveObjectTemporary.id && interactiveObjectTemporary.previousOrientation == interactiveObjectTemporary.orientation && interactiveObjectTemporary.type == interactiveObjectTemporary.previousType)
                        interactiveObjectTemporary.unlink();
                }
            }
        }
    }

    public static ImageRGB method927(CacheArchive archive, int groupId, int fileId) {
	    if(!decodeImageFromArchive(archive, groupId, fileId))
	        return null;
	    return createImageRGBFromDecodedData();
	}

    public static void handleInterfaceActions(GameInterfaceArea area, int mouseX, int mouseY, int minX, int minY, int maxX, int maxY, GameInterface[] gameInterfaces, int parentId, int scrollPosition, int scrollWidth) {
        // Only try to handle actions if mouse is within this widget's boundaries
	    if(minX <= mouseX && mouseY >= minY && maxX > mouseX && maxY > mouseY) {
	        for(int i = 0; gameInterfaces.length > i; i++) {
	            GameInterface gameInterface = gameInterfaces[i];
	            if(gameInterface != null && parentId == gameInterface.layer) {
                    int adjustedX = gameInterface.x - scrollWidth + minX;
                    int adjustedY = gameInterface.y - (scrollPosition - minY);

                    boolean isTooltip = gameInterface.type == GameInterfaceType.IF1_TOOLTIP;
                    boolean isMouseWithinXBounds = mouseX >= adjustedX && mouseX < adjustedX + gameInterface.width;
                    boolean isMouseWithinYBounds = mouseY >= adjustedY && mouseY < adjustedY + gameInterface.height;

                    if (isTooltip && isMouseWithinXBounds && isMouseWithinYBounds) {
                        tempOpenWidgetChildTooltipId = i;
                    }
	                if((gameInterface.delegateHover >= 0 || gameInterface.hoverColor != 0) && adjustedX <= mouseX && adjustedY <= mouseY && mouseX < adjustedX + gameInterface.width && mouseY < gameInterface.height + adjustedY) {
	                    if(gameInterface.delegateHover >= 0)
	                        tempHoveredWidgetChildId = gameInterface.delegateHover;
	                    else
	                        tempHoveredWidgetChildId = i;
	                }
	                if(gameInterface.type == GameInterfaceType.LAYER) {
                        int areaId = area.getId();

	                    if(!gameInterface.hide || GameInterface.isHovering(areaId, i) || GameInterface.hiddenButtonTest) {
	                        handleInterfaceActions(area, mouseX, mouseY, adjustedX, adjustedY, adjustedX + gameInterface.width, adjustedY + gameInterface.height, gameInterfaces, i, gameInterface.scrollY, gameInterface.scrollX);
	                        if(gameInterface.createdComponents != null)
	                            handleInterfaceActions(area, mouseX, mouseY, adjustedX, adjustedY, gameInterface.width + adjustedX, adjustedY + gameInterface.height, gameInterface.createdComponents, gameInterface.id, gameInterface.scrollY, gameInterface.scrollX);
	                        if(gameInterface.height < gameInterface.scrollableHeight)
	                            GameInterface.scrollInterface(gameInterface.height, mouseY, mouseX, gameInterface.scrollableHeight, gameInterface, gameInterface.width + adjustedX, areaId, adjustedY);
	                    }
	                } else {
	                    if (Configuration.DEBUG_WIDGETS && gameInterface.type != GameInterfaceType.IF1_TOOLTIP && adjustedX <= mouseX && adjustedY <= mouseY && gameInterface.width + adjustedX > mouseX && gameInterface.height + adjustedY > mouseY) {
	                        hoveredWidgetId = gameInterface.id;
	                    }

                        // standard button type? this is used for 'Open House Options'
                        // also used for clickable text (e.g. music list)
	                    if(gameInterface.buttonType == 1 && adjustedX <= mouseX && adjustedY <= mouseY && gameInterface.width + adjustedX > mouseX && gameInterface.height + adjustedY > mouseY) {
	                        boolean bool = false;

                            // is this text vs not text? contentType is definitely 0 for text on music player
	                        if(gameInterface.contentType != 0)
	                            bool = method1051(300, gameInterface);

	                        if(!bool) {
	                            addActionRow(gameInterface.option, 0, 0, gameInterface.id, 42, "");
	                        }
	                    }

                        // spells
	                    if(gameInterface.buttonType == 2 && Game.widgetSelected == 0 && mouseX >= adjustedX && mouseY >= adjustedY && mouseX < gameInterface.width + adjustedX && mouseY < adjustedY + gameInterface.height) {
	                        addActionRow(gameInterface.spellAction, 0, 0, gameInterface.id, ActionRowType.SELECT_SPELL_ON_WIDGET.getId(), Native.green + gameInterface.spellName);
	                    }

                        // close button
	                    if(gameInterface.buttonType == 3 && mouseX >= adjustedX && mouseY >= adjustedY && adjustedX + gameInterface.width > mouseX && mouseY < adjustedY + gameInterface.height) {
	                        int actionType;
	                        if(area != GameInterfaceArea.PERMANENT_CHAT_BOX_WIDGET)
	                            actionType = ActionRowType.CLOSE_WIDGET.getId();
	                        else
                                actionType = ActionRowType.CLOSE_PERMANENT_CHATBOX_WIDGET.getId();
	                        addActionRow(English.close, 0, 0, gameInterface.id, actionType, "");
	                    }

                        // toggle varp
	                    if(gameInterface.buttonType == 4 && mouseX >= adjustedX && adjustedY <= mouseY && mouseX < gameInterface.width + adjustedX && gameInterface.height + adjustedY > mouseY) {
	                        addActionRow(gameInterface.option, 0, 0, gameInterface.id, ActionRowType.BUTTON_TOGGLE_VARP.getId(), "");
	                    }

                        // sets the varp to another value (stored in the `alternateRhs` of the button) when clicked
	                    if(gameInterface.buttonType == 5 && adjustedX <= mouseX && adjustedY <= mouseY && mouseX < adjustedX + gameInterface.width && adjustedY + gameInterface.height > mouseY) {
	                        addActionRow(gameInterface.option, 0, 0, gameInterface.id, ActionRowType.BUTTON_SET_VARP_VALUE.getId(), "");
	                    }

                        // "Please wait..." buttons
	                    if(gameInterface.buttonType == 6 && lastContinueTextWidgetId == -1 && adjustedX <= mouseX && adjustedY <= mouseY && mouseX < adjustedX + gameInterface.width && mouseY < gameInterface.height + adjustedY) {
	                        addActionRow(gameInterface.option, 0, 0, gameInterface.id, 54, "");
	                    }

	                    if(gameInterface.type == GameInterfaceType.INVENTORY) {
	                        int i_4_ = 0;
	                        for(int i_5_ = 0; i_5_ < gameInterface.height; i_5_++) {
	                            for(int i_6_ = 0; i_6_ < gameInterface.width; i_6_++) {
	                                int i_7_ = i_6_ * (gameInterface.invMarginX + 32) + adjustedX;
	                                int i_8_ = adjustedY + (32 + gameInterface.invMarginY) * i_5_;
	                                if(i_4_ < 20) {
	                                    i_7_ += gameInterface.invSlotImage[i_4_];
	                                    i_8_ += gameInterface.invSlotOffsetX[i_4_];
	                                }
	                                if(mouseX >= i_7_ && i_8_ <= mouseY && i_7_ + 32 > mouseX && mouseY < 32 + i_8_) {
	                                    GameInterface.lastActiveInvInterface = gameInterface.id;
	                                    Game.mouseInvInterfaceIndex = i_4_;
	                                    if(gameInterface.invSlotObjId[i_4_] > 0) {
	                                        ItemDefinition itemDefinition = ItemDefinition.forId(-1 + gameInterface.invSlotObjId[i_4_], 10);
	                                        if(GameInterface.itemCurrentlySelected != 1 || !gameInterface.invInteractable) {
	                                            if(Game.widgetSelected == 1 && gameInterface.invInteractable) {
	                                                if((selectedMask & 0x10) == 16) {
	                                                    addActionRow(Native.selectedSpellVerb, itemDefinition.id, i_4_, gameInterface.id, ActionRowType.CAST_MAGIC_ON_WIDGET_ITEM.getId(), Native.selectedSpellName + Native.toLightRed + itemDefinition.name);
	                                                }
	                                            } else {
	                                                String[] class1s = itemDefinition.interfaceOptions;
	                                                if(DEBUG_DISPLAY_ALL_ACTION_ROWS)
	                                                    class1s = getAllOptionsWithIndices(class1s);
	                                                if(gameInterface.invInteractable) {
	                                                    for(int i_9_ = 4; i_9_ >= 3; i_9_--) {
	                                                        if(class1s != null && class1s[i_9_] != null) {
	                                                            int actionType;
	                                                            if(i_9_ != 3)
	                                                                actionType = ActionRowType.DROP_ITEM.getId();
	                                                            else
	                                                                actionType = ActionRowType.INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_4.getId();
	                                                            addActionRow(class1s[i_9_], itemDefinition.id, i_4_, gameInterface.id, actionType, Native.lightRed + itemDefinition.name);
	                                                        } else if(i_9_ == 4) {
	                                                            addActionRow(English.drop, itemDefinition.id, i_4_, gameInterface.id, ActionRowType.DROP_ITEM.getId(), Native.lightRed + itemDefinition.name);
	                                                        }
	                                                    }
	                                                }
	                                                if(gameInterface.invUsable) {
	                                                    addActionRow(English.use, itemDefinition.id, i_4_, gameInterface.id, ActionRowType.SELECT_ITEM_ON_WIDGET.getId(), Native.lightRed + itemDefinition.name);
	                                                }
	                                                if(gameInterface.invInteractable && class1s != null) {
	                                                    for(int i_11_ = 2; i_11_ >= 0; i_11_--) {
	                                                        if(class1s[i_11_] != null) {
	                                                            int actionType = 0;
	                                                            if(i_11_ == 0)
	                                                                actionType = ActionRowType.INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_1.getId();
	                                                            if(i_11_ == 1)
	                                                                actionType = ActionRowType.INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_2.getId();
	                                                            if(i_11_ == 2)
	                                                                actionType = ActionRowType.INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_3.getId();
	                                                            addActionRow(class1s[i_11_], itemDefinition.id, i_4_, gameInterface.id, actionType, Native.lightRed + itemDefinition.name);
	                                                        }
	                                                    }
	                                                }
	                                                class1s = gameInterface.invOptions;
	                                                if(DEBUG_DISPLAY_ALL_ACTION_ROWS)
	                                                    class1s = getAllOptionsWithIndices(class1s);
	                                                if(class1s != null) {
	                                                    for(int i_13_ = 4; i_13_ >= 0; i_13_--) {
	                                                        if(class1s[i_13_] != null) {
	                                                            int actionType = 0;
	                                                            if(i_13_ == 0)
	                                                                actionType = ActionRowType.INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_1.getId();
	                                                            if(i_13_ == 1)
	                                                                actionType = ActionRowType.INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_2.getId();
	                                                            if(i_13_ == 2)
	                                                                actionType = ActionRowType.INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_3.getId();
	                                                            if(i_13_ == 3)
	                                                                actionType = ActionRowType.INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_4.getId();
	                                                            if(i_13_ == 4)
	                                                                actionType = ActionRowType.INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_5.getId();
	                                                            addActionRow(class1s[i_13_], itemDefinition.id, i_4_, gameInterface.id, actionType, Native.lightRed + itemDefinition.name);
	                                                        }
	                                                    }
	                                                }
	                                                StringBuilder examineText = new StringBuilder();
	                                                examineText.append(MessageFormat.format("<col=ff9040>{0}</col>", itemDefinition.name));
	                                                if (Configuration.DEBUG_CONTEXT) {
	                                                    examineText.append(" <col=00ff00>(</col>");
	                                                    examineText.append(
	                                                            MessageFormat.format("<col=ffffff>{0}</col>",
	                                                                    Integer.toString(itemDefinition.id)
	                                                            )
	                                                    );
	                                                    examineText.append("<col=00ff00>)</col>");
	                                                }
	                                                addActionRow(English.examine, itemDefinition.id, i_4_, gameInterface.id, ActionRowType.EXAMINE_ITEM_ON_V1_WIDGET.getId(), examineText.toString());
	                                            }
	                                        } else if(GameInterface.itemSelectedWidgetId != gameInterface.id || i_4_ != GameInterface.itemSelectedContainerSlot) {
	                                            addActionRow(English.use, itemDefinition.id, i_4_, gameInterface.id, ActionRowType.USE_ITEM_ON_INVENTORY_ITEM.getId(), Native.selectedItemName + Native.toLightRed + itemDefinition.name);
	                                        }
	                                    }
	                                }
	                                i_4_++;
	                            }
	                        }
	                    }
	                    if(gameInterface.if3 && gameInterface.itemId != -1 && mouseX >= adjustedX && mouseY >= adjustedY && mouseX < gameInterface.width + adjustedX && mouseY < adjustedY + gameInterface.height) {
	                        ItemDefinition itemDefinition = ItemDefinition.forId(gameInterface.itemId, 10);
	                        if(gameInterface.invInteractable) {
	                            String[] class1s = itemDefinition.interfaceOptions;
	                            if(DEBUG_DISPLAY_ALL_ACTION_ROWS)
	                                class1s = getAllOptionsWithIndices(class1s);
	                            if(class1s == null || class1s[4] == null)
	                                addActionRow(English.drop, itemDefinition.id, gameInterface.anInt2736 - 1, gameInterface.id, ActionRowType.DROP_ITEM.getId(), Native.lightRed +itemDefinition.name);
	                            else
	                                addActionRow(class1s[4], itemDefinition.id, gameInterface.anInt2736 - 1, gameInterface.id, ActionRowType.DROP_ITEM.getId(), Native.lightRed + itemDefinition.name);
	                            if(class1s != null && class1s[3] != null)
	                                addActionRow(class1s[3], itemDefinition.id, gameInterface.anInt2736 - 1, gameInterface.id, ActionRowType.INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_4.getId(), Native.lightRed + itemDefinition.name);
	                            if(class1s != null && class1s[2] != null)
	                                addActionRow(class1s[2], itemDefinition.id, gameInterface.anInt2736 - 1, gameInterface.id, ActionRowType.INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_3.getId(), Native.lightRed + itemDefinition.name);
	                            if(class1s != null && class1s[1] != null)
	                                addActionRow(class1s[1], itemDefinition.id, gameInterface.anInt2736 - 1, gameInterface.id, ActionRowType.INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_2.getId(), Native.lightRed + itemDefinition.name);
	                            if(class1s != null && class1s[0] != null)
	                                addActionRow(class1s[0], itemDefinition.id, gameInterface.anInt2736 - 1, gameInterface.id, ActionRowType.INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_1.getId(), Native.lightRed + itemDefinition.name);
	                        }
	                        if(gameInterface.id >= 0)
	                            addActionRow(English.examine, itemDefinition.id, -1, gameInterface.id, ActionRowType.EXAMINE_ITEM_ON_V2_WIDGET.getId(), Native.lightRed + itemDefinition.name);
	                        else
	                            addActionRow(English.examine, itemDefinition.id, gameInterface.id & 0x7fff, gameInterface.layer, ActionRowType.EXAMINE_ITEM_ON_V2_WIDGET.getId(), Native.lightRed + itemDefinition.name);
	                    }
	                    if(gameInterface.hasListeners && gameInterface.aClass1Array2661 != null && adjustedX <= mouseX && adjustedY <= mouseY && gameInterface.width + adjustedX > mouseX && mouseY < adjustedY + gameInterface.height) {
	                        String class1 = "";
	                        if(gameInterface.itemId != -1) {
	                            ItemDefinition class40_sub5_sub16 = ItemDefinition.forId(gameInterface.itemId, 0);
	                            class1 = Native.lightRed + class40_sub5_sub16.name;
	                        }
	                        for(int i_15_ = gameInterface.aClass1Array2661.length - 1; i_15_ >= 0; i_15_--) {
	                            if(gameInterface.aClass1Array2661[i_15_] != null) {
	                                if(gameInterface.id < 0)
	                                    addActionRow(gameInterface.aClass1Array2661[i_15_], i_15_ + 1, 0x7fff & gameInterface.id, gameInterface.layer, 50, class1);
	                                else
	                                    addActionRow(gameInterface.aClass1Array2661[i_15_], i_15_ + 1, 0, gameInterface.id, 50, class1);
	                            }
	                        }
	                    }
	                }
	            }
	        }
	    }

	}

    public static void setHighMemory() {
	    VertexNormal.lowMemory = false;
	    Scene.lowMemory = false;

	}

	public static void animateNpcs() {
	    for(int i = 0; i < Player.npcCount; i++) {
	        int i_0_ = Player.npcIds[i];
	        Npc class40_sub5_sub17_sub4_sub2 = Player.npcs[i_0_];
	        if(class40_sub5_sub17_sub4_sub2 != null)
	            Actor.handleActorAnimation(class40_sub5_sub17_sub4_sub2);
	    }

	}


    public static void drawMenu(int xOffSet, int yOffSet) {
	    int height = menuHeight;
	    int width = menuWidth;
	    int offsetX = menuOffsetX - (xOffSet);
	    int offsetY = (-yOffSet) + Game.menuOffsetY;
	    int colour = 0x5d5447;
	    ChatBox.redrawChatbox = true;
	    GameInterface.redrawTabArea = true;
	    Rasterizer.drawFilledRectangleAlpha(offsetX, offsetY, width, height, colour, 120);
	    Rasterizer.drawFilledRectangle(1 + offsetX, 1 + offsetY, -2 + width, 16, 0);
	    Rasterizer.drawUnfilledRectangle(offsetX + 1, 18 + offsetY, -2 + width, -19 + height, 0);
	    TypeFace.fontBold.drawString(English.chooseOption, offsetX + 3, 14 + offsetY, colour);
	    int x = MouseHandler.mouseX - (xOffSet);
	    int y = (-yOffSet) + MouseHandler.mouseY;
	    if(menuScreenArea == 0) {
	        x -= 4;
	        y -= 4;
	    }
	    if(menuScreenArea == 1) {
	        y -= 205;
	        x -= 553;
	    }
	    if(menuScreenArea == 2) {
	        y -= 357;
	        x -= 17;
	    }
	    for(int action = 0; action < menuActionRow; action++) {
	        int actionY = 15 * (-action + menuActionRow + -1) + offsetY + 31;
	        int actionColour = 16777215;
	        if(x > offsetX && offsetX + width > x && y > -13 + actionY && actionY + 3 > y)
	            actionColour = 16776960;
	        TypeFace.fontBold.drawShadowedString(menuActionTexts[action], offsetX + 3, actionY, true, actionColour);
	    }
	}

	public static void handleVarPlayers(int varPlayerIndex) {
	    do {
	        anInt2480 = pulseCycle;
	        SoundSystem.setObjectSounds();
	        int varPlayerType = VarPlayerDefinition.getDefinition(varPlayerIndex).type;
	        if(varPlayerType != 0) {
	            int varPlayerValue = VarPlayerDefinition.varPlayers[varPlayerIndex];
	            if(varPlayerType == 1) {
	                if(varPlayerValue == 1) {
	                    Rasterizer3D.createPalette(0.9);
	                    ((Class35) Rasterizer3D.interface3).setBrightness(0.9);
	                }
	                if(varPlayerValue == 2) {
	                    Rasterizer3D.createPalette(0.8);
	                    ((Class35) Rasterizer3D.interface3).setBrightness(0.8);
	                }
	                if(varPlayerValue == 3) {
	                    Rasterizer3D.createPalette(0.7);
	                    ((Class35) Rasterizer3D.interface3).setBrightness(0.7);
	                }
	                if(varPlayerValue == 4) {
	                    Rasterizer3D.createPalette(0.6);
	                    ((Class35) Rasterizer3D.interface3).setBrightness(0.6);
	                }
	                ItemDefinition.clearImageCache();
	                clearScreen = true;
	            }
	            if(varPlayerType == 3) {
	                int newMusicVolume = 0;
	                if(varPlayerValue == 0)
	                    newMusicVolume = 255;
	                if(varPlayerValue == 1)
	                    newMusicVolume = 192;
	                if(varPlayerValue == 2)
	                    newMusicVolume = 128;
	                if(varPlayerValue == 3)
	                    newMusicVolume = 64;
	                if(varPlayerValue == 4)
	                    newMusicVolume = 0;
	                if(newMusicVolume != MusicSystem.musicVolume) {
	                    if(MusicSystem.musicVolume != 0 || MusicSystem.currentSongId == -1) {
	                        if(newMusicVolume == 0) {
	                            MusicSystem.method402(false);
	                            MusicSystem.songTimeout = 0;
	                        } else
	                            MusicSystem.method456(newMusicVolume);
	                    } else {
	                        MusicSystem.playMusicTrack(false, 0, MusicSystem.currentSongId, newMusicVolume, 0, CacheArchive.musicCacheArchive);
	                        MusicSystem.songTimeout = 0;
	                    }
	                    MusicSystem.musicVolume = newMusicVolume;
                        Configuration.setSoundMuted(newMusicVolume == 0);
	                }
	            }
	            if(varPlayerType == 9)
	                bankInsertMode = varPlayerValue;
	            if(varPlayerType == 10) {
	            	SoundSystem.updateAreaSoundEffectVolume(varPlayerValue);
	            }
	            if(varPlayerType == 8) {
	                ChatBox.redrawChatbox = true;
	                ChatBox.splitPrivateChat = varPlayerValue;
	            }
	            if(varPlayerType == 4) {
	            	SoundSystem.updateSoundEffectVolume(varPlayerValue);
	            }
	            if(varPlayerType == 6)
	                chatEffectsDisabled = varPlayerValue;
	            if(varPlayerType != 5)
	                break;
	            Game.oneMouseButton = varPlayerValue;
	        }

	        break;
	    } while(false);
	}

	public static String method956(Buffer arg0) {
	    try {
	        int length = arg0.getSmart();
	        if(length > 32767)
	            length = 32767;
	        byte[] chars = new byte[length];
	        arg0.currentPosition += aHuffmanEncoding_2590.method1023(arg0.buffer, length, 0, chars, arg0.currentPosition, -1);
	        return new String(chars);
	    } catch(Exception exception) {
	        return English.cabbage;
	    }
	}

    public static int anInt537 = 0;
	public static boolean membersWorld = false;

    /**
     * Draws the 2d yellow arrow hint icon in the world.
     */
    public static void drawPositionHintIcon() {
        if (Game.currentHintIconType != 2) {
            return;
        }

        Point2d screenPos = MovedStatics.getProjectedScreenPosition(2 * hintIconPosZ, hintIconInnerPosY + (-baseY + hintIconPosY << 7), (hintIconPosX + -baseX << 7) + hintIconInnerPosX);

        if (screenPos == null) {
            return;
        }

        if (pulseCycle % 20 < 10)
            hintIconSprites[0].drawImage(screenPos.x - 12, screenPos.y - 28);
    }

    /**
     * Project 3d pos to 3d
     */
    public static Point2d getProjectedScreenPosition(int z, int y, int x) {
        if (x < 128 || y < 128 || x > 13056 || y > 13056) {
            return null;
        }

        int drawHeight = Game.currentScene.getFloorDrawHeight(Player.worldLevel, x, y) - z;

        Point3d cameraPos = Game.getActiveCamera().getPosition();
        CameraRotation rotation = Game.getActiveCamera().getRotation();

        x -= cameraPos.x;
        y -= cameraPos.y;
        drawHeight -= cameraPos.z;
        int cosinePitch = Model.COSINE[rotation.pitch];
        int sinePitch = Model.SINE[rotation.pitch];
        int sineYaw = Model.SINE[rotation.yaw];
        int cosineYaw = Model.COSINE[rotation.yaw];

        // rotate x/y/z according to camera pos
        int tmp = y * sineYaw + x * cosineYaw >> 16;
        y = cosineYaw * y - x * sineYaw >> 16;
        x = tmp;
        tmp = drawHeight * cosinePitch - y * sinePitch >> 16;
        y = y * cosinePitch + drawHeight * sinePitch >> 16;
        drawHeight = tmp;

        // TODO (jkm) why don't we draw below y=50?
        if (y < 50) {
            return null;
        }

        return new Point2d((x << 9) / y, (drawHeight << 9) / y)
            .add(getScreenMidpoint());
    }

    public static Point2d getScreenMidpoint() {
        if (ScreenController.frameMode == ScreenMode.FIXED) {
            return new Point2d(256, 167);
        } else {
            return new Point2d(ScreenController.drawWidth / 2, ScreenController.drawHeight / 2);
        }
    }

    private static void method344(int arg0) {
        if(aBoolean2083) {
            chatboxLineOffsets = null;
            aBoolean2083 = false;
            Minimap.anIntArray66 = null;
            Minimap.minimapBackgroundImage = null;
            anIntArray1186 = null;
            chatboxTop = null;
            tabBottom = null;
            tabPieceLeft = null;
            bottomChatBack = null;
            inventoryBackgroundImage = null;
            tabHighlightImageTopRight = null;
            tabIcons = null;
            tabHighlightImageBottomRight = null;
            Minimap.mapbackProducingGraphicsBuffer = null;
            Minimap.anIntArray62 = null;
            sidebarOffsets = null;
            mapbackLeft = null;
            tabHighlightImageBottomMiddle = null;
            tabBottomBack = null;
            framePieceRight = null;
            GameInterface.tabHighlightImageTopLeft = null;
            tabHighlightImageTopRightEdge = null;
            anIntArray852 = null;
            chatModes = null;
            tabTopBack = null;
            tabImageProducer = null;
            tabHighlightImageTopLeftEdge = null;
            gameScreenImageProducer = null;
            tabHighlightImageBottomRightEdge = null;
            ChatBox.chatBoxImageProducer = null;
            mapBackRight = null;
            tabTop = null;
            if(arg0 < -28) {
                chatboxRight = null;
                tabPieceUpperRight = null;
                tabHighlightImageTopMiddle = null;
                tabHighlightImageBottomLeft = null;
                tabHighlightImageBottomLeftEdge = null;
                fullScreenTextureArray = null;
                tabPieveLowerRight = null;
                framePieceTop = null;
                chatboxBackgroundImage = null;
            }
        }
    }

    private static void addObject(int arg0, int arg1, int arg2, int arg3, int arg4, int arg6, int arg7) {
        if(arg2 >= 1 && arg0 >= 1 && arg2 <= 102 && arg0 <= 102) {
            if(!VertexNormal.lowMemory || Player.worldLevel == arg7) {
                int i = -1;
                int i_0_ = 0;
                boolean bool = false;
                boolean bool_1_ = false;
                if(arg6 == 0)
                    i_0_ = Game.currentScene.getWallHash(arg7, arg2, arg0);
                if(arg6 == 1)
                    i_0_ = Game.currentScene.getWallDecorationHash(arg7, arg2, arg0);
                if(arg6 == 2)
                    i_0_ = Game.currentScene.getLocationHash(arg7, arg2, arg0);
                if(arg6 == 3)
                    i_0_ = Game.currentScene.getFloorDecorationHash(arg7, arg2, arg0);
                if(i_0_ != 0) {
                    i = (i_0_ & 0x1ffff138) >> 14;
                    int i_2_ = Game.currentScene.getArrangement(arg7, arg2, arg0, i_0_);
                    int i_3_ = i_2_ >> 6 & 0x3;
                    int i_4_ = 0x1f & i_2_;
                    if(arg6 == 0) {
                        Game.currentScene.removeWall(arg7, arg2, arg0);
                        GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(i);
                        if(gameObjectDefinition.solid)
                            Landscape.currentCollisionMap[arg7].markWall(arg2, i_3_, gameObjectDefinition.walkable, arg0, i_4_);
                    }
                    if(arg6 == 1)
                        Game.currentScene.removeWallDecoration(arg7, arg2, arg0);
                    if(arg6 == 2) {
                        Game.currentScene.removeInteractiveObject(arg7, arg2, arg0);
                        GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(i);
                        if(arg2 + gameObjectDefinition.sizeX > 103 || arg0 + gameObjectDefinition.sizeX > 103 || arg2 + gameObjectDefinition.sizeY > 103 || gameObjectDefinition.sizeY + arg0 > 103)
                            return;
                        if(gameObjectDefinition.solid)
                            Landscape.currentCollisionMap[arg7].markSolidOccupant(arg2, arg0, gameObjectDefinition.sizeX, gameObjectDefinition.sizeY, i_3_, gameObjectDefinition.walkable);
                    }
                    if(arg6 == 3) {
                        Game.currentScene.removeFloorDecoration(arg7, arg2, arg0);
                        GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(i);
                        if(gameObjectDefinition.solid && gameObjectDefinition.hasActions == 1)
                            Landscape.currentCollisionMap[arg7].unmarkConcealed(arg2, arg0);
                    }
                }
                if(arg1 >= 0) {
                    int i_5_ = arg7;
                    if(i_5_ < 3 && (tile_flags[1][arg2][arg0] & 0x2) == 2)
                        i_5_++;
                    Landscape.currentCollisionMap[arg7].addObject(arg1, i_5_, arg7, arg3, Game.currentScene,  arg4, arg0, arg2);
                }
            }
        }
    }

    public static void renderSplitPrivateMessages() {
        if(ChatBox.splitPrivateChat != 0) {
            TypeFace class40_sub5_sub14_sub1 = fontNormal;
            int i = 0;
            if(systemUpdateTime != 0)
                i = 1;
            for(int i_0_ = 0; i_0_ < 100; i_0_++) {
                if(ChatBox.chatMessages[i_0_] != null) {
                    String class1 = ChatBox.chatPlayerNames[i_0_];
                    int i_1_ = 0;
                    int i_2_ = ChatBox.chatTypes[i_0_];
                    if(class1 != null && class1.startsWith(Native.whiteCrown)) {
                        class1 = class1.substring(5);
                        i_1_ = 1;
                    }
                    if(class1 != null && class1.startsWith(Native.goldCrown)) {
                        class1 = class1.substring(5);
                        i_1_ = 2;
                    }
                    if((i_2_ == 3 || i_2_ == 7) && (i_2_ == 7 || ChatBox.privateChatMode == 0 || ChatBox.privateChatMode == 1 && Player.hasFriend(class1))) {
                        int i_3_ = 329 - 13 * i;
                        int i_4_ = 4;
                        i++;
                        class40_sub5_sub14_sub1.drawString(English.from, i_4_, i_3_, 0);
                        class40_sub5_sub14_sub1.drawString(English.from, i_4_, -1 + i_3_, 65535);
                        i_4_ += class40_sub5_sub14_sub1.getStringWidth(English.from);
                        i_4_ += class40_sub5_sub14_sub1.method689(32);
                        if(i_1_ == 1) {
                            moderatorIcon[0].drawImage(i_4_, i_3_ - 12);
                            i_4_ += 14;
                        }
                        if(i_1_ == 2) {
                            moderatorIcon[1].drawImage(i_4_, -12 + i_3_);
                            i_4_ += 14;
                        }
                        class40_sub5_sub14_sub1.drawString(class1 + Native.COLON_CHARACTER + ChatBox.chatMessages[i_0_], i_4_, i_3_, 0);
                        class40_sub5_sub14_sub1.drawString(class1 + Native.COLON_CHARACTER + ChatBox.chatMessages[i_0_], i_4_, -1 + i_3_, 65535);
                        if(i >= 5)
                            return;
                    }
                    if(i_2_ == 5 && ChatBox.privateChatMode < 2) {
                        int i_5_ = -(i * 13) + 329;
                        i++;
                        class40_sub5_sub14_sub1.drawString(ChatBox.chatMessages[i_0_], 4, i_5_, 0);
                        class40_sub5_sub14_sub1.drawString(ChatBox.chatMessages[i_0_], 4, i_5_ - 1, 65535);
                        if(i >= 5)
                            return;
                    }
                    if(i_2_ == 6 && ChatBox.privateChatMode < 2) {
                        int i_6_ = -(13 * i) + 329;
                        i++;
                        class40_sub5_sub14_sub1.drawString(English.to + Native.whitespace_b + class1 + Native.COLON_CHARACTER + ChatBox.chatMessages[i_0_], 4, i_6_, 0);
                        class40_sub5_sub14_sub1.drawString(English.to + Native.whitespace_b + class1 + Native.COLON_CHARACTER + ChatBox.chatMessages[i_0_], 4, i_6_ + -1, 65535);
                        if(i >= 5)
                            return;
                    }
                }
            }
        }
    }

    public static void draw3dScreen() {
        renderSplitPrivateMessages();
        if (crossType == 1) {
            cursorCross[crossIndex / 100].drawImage(GameInterface.crossX - 8 - 4, GameInterface.crossY - 8 - 4);
        }
        if (crossType == 2) {
            cursorCross[4 + crossIndex / 100].drawImage(GameInterface.crossX - 8 - 4, GameInterface.crossY - 8 - 4);
        }
        if (GameInterface.gameScreenInterfaceId != -1 || GameInterface.walkableWidgetId != -1) {
                int areaId = GameInterface.gameScreenInterfaceId != -1 ? 0 : 4;
                int id = GameInterface.gameScreenInterfaceId != -1 ? GameInterface.gameScreenInterfaceId : GameInterface.walkableWidgetId;
                GameInterface.handleSequences(id);
                int yOffset = (ScreenController.drawHeight /2) - (334/2) - (184/2);
                int xOffset = (ScreenController.drawWidth /2) - (512/2) - (234/3);
                if(ScreenController.frameMode == ScreenMode.FIXED) {
                    yOffset = 0;
                    xOffset = 0;
                }
                Game.drawParentInterface(areaId, xOffset, yOffset, 512+ xOffset, 334 + yOffset, id);
        }
        method1018();
        Player.setTutorialIslandFlag();
        if (!menuOpen) {
            processRightClick();
            drawMenuTooltip(4);
        } else  {
            if(ScreenController.frameMode == ScreenMode.FIXED && menuScreenArea == 0){
                drawMenu(4,4);
            }
        }
        if (multiCombatState == 1) {
            multiCombatIcon.drawImage(472, 296);
        }
        if (showFps) {
            int y = 20;
            int x = 507;
            if(ScreenController.frameMode != ScreenMode.FIXED) {
                x = ScreenController.drawWidth - 220;
            }

            int colour = 0xffff00;
            if (GameShell.fps < 30 && VertexNormal.lowMemory) {
                colour = 0xff0000;
            }
            if (GameShell.fps < 20 && !VertexNormal.lowMemory) {
                colour = 0xff0000;
            }
            fontNormal.drawStringRight("Fps: " + GameShell.fps, x, y, colour);
            colour = 0xffff00;
            y += 15;
            Runtime runtime = Runtime.getRuntime();
            int memoryUsed = (int) ((runtime.totalMemory() + -runtime.freeMemory()) / 1024L);
            if (memoryUsed > 32768 && VertexNormal.lowMemory) {
                colour = 0xff0000;
            }
            if (memoryUsed < 65536 && !VertexNormal.lowMemory) {
                colour = 0xff0000;
            }
            fontNormal.drawStringRight("Mem: " + memoryUsed + "k", x, y, colour);
            y += 15;

            fontNormal.drawStringRight("MouseX: " + MouseHandler.mouseX, x, y ,0xffff00);
            y += 15;

            fontNormal.drawStringRight("MouseY: " + MouseHandler.mouseY, x, y ,0xffff00);
            y += 15;
            fontNormal.drawStringRight("ClickX: " + MouseHandler.clickX, x, y ,0xffff00);
            y += 15;

            fontNormal.drawStringRight("ClickY: " + MouseHandler.clickY, x, y ,0xffff00);
            y += 15;
            if (showSidePanelRedrawnText) {
                fontNormal.drawStringRight(English.sidePanelRedrawn, x, y, 16711680);
                y += 15;
                showSidePanelRedrawnText = false;
            }
            if (showChatPanelRedrawnText) {
                fontNormal.drawStringRight(English.chatPanelRedrawn, x, y, 16711680);
                y += 15;
                showChatPanelRedrawnText = false;
            }
            if (showIconsRedrawnText) {
                fontNormal.drawStringRight(English.iconsRedrawn, x, y, 16711680);
                showIconsRedrawnText = false;
                y += 15;
            }
        }
        if (Configuration.DEBUG_WIDGETS) {
            int y = 20;
            int x = 507;
            if(ScreenController.frameMode != ScreenMode.FIXED) {
                x = ScreenController.drawWidth - 220;
            }
            int widgetParentId = hoveredWidgetId >> 16;
            int widgetChildId = hoveredWidgetId & 0x7fff;
            String typeAsString = "";

            // Gather widget metadata from the cached interfaces
            GameInterface[] parentInterface;
            GameInterface childInterface = null;
            if (widgetParentId >= 0 && widgetChildId < 469) {
                parentInterface = GameInterface.components[widgetParentId];

                if (parentInterface != null) {
                    childInterface = parentInterface[widgetChildId];
                }

                if (childInterface != null) {
                    switch (childInterface.type) {
                        case TEXT:
                            typeAsString = "TEXT";
                            break;
                        case GRAPHIC:
                            typeAsString = "GRAPHIC";
                            break;
                        case MODEL:
                            typeAsString = "MODEL";
                            break;
                        case RECTANGLE:
                            typeAsString = "RECTANGLE";
                            break;
                        case INVENTORY:
                            typeAsString = "INVENTORY";
                            break;
                        case LINE:
                            typeAsString = "LINE";
                            break;
                        case TEXT_INVENTORY:
                            typeAsString = "TEXT_INVENTORY";
                            break;
                        case LAYER:
                            typeAsString = "LAYER";
                            break;
                        case IF1_TOOLTIP:
                            typeAsString = "IF1_TOOLTIP";
                            break;
                        default:
                            typeAsString = "UNKNOWN";
                    }
                }
            }

            fontNormal.drawStringRight("Widget " + widgetParentId + ":" + widgetChildId, x, y, 0xffff00);
            y+= 15;
            if (childInterface != null) {
                fontNormal.drawStringRight("Parent ID: " + childInterface.layer, x, y, 0xffff00);
                y+= 15;
                fontNormal.drawStringRight("Type: " + typeAsString, x, y, 0xffff00);
                y+= 15;
            }

        }
        if (systemUpdateTime != 0) {
            int seconds = systemUpdateTime / 50;
            int minutes = seconds / 60;
            seconds %= 60;
            if (seconds < 10) {
                fontNormal.drawString(English.systemUpdateIn + minutes + Native.prefixColonZero + seconds, 4, 329, 16776960);
            } else {
                fontNormal.drawString(English.systemUpdateIn + minutes + Native.colon + seconds, 4, 329, 16776960);
            }
        }
    }

    public static void processNpcMenuOptions(ActorDefinition actorDefinition, int x, int y, int index) {
        if (menuActionRow < 400) {
            if (actorDefinition.childIds != null) {
                actorDefinition = actorDefinition.getChildDefinition();
            }
            if (actorDefinition != null && actorDefinition.isClickable) {
                String npcDisplayName = actorDefinition.name;
                if (actorDefinition.combatLevel != 0) {
                    npcDisplayName = npcDisplayName + getCombatLevelColour(Player.localPlayer.combatLevel, actorDefinition.combatLevel) + Native.leftParenthesisWithSpacePrefix + English.prefixLevel + actorDefinition.combatLevel + Native.rightParenthesis;
                }
                if (GameInterface.itemCurrentlySelected == 1) {
                    addActionRow(English.use, index, x, y, ActionRowType.USE_ITEM_ON_NPC.getId(), Native.selectedItemName + Native.toYellow + npcDisplayName);
                } else if (Game.widgetSelected == 1) {
                    if ((0x2 & selectedMask) == 2) {
                        addActionRow(Native.selectedSpellVerb, index, x, y, ActionRowType.CAST_MAGIC_ON_NPC.getId(), Native.selectedSpellName + Native.toYellow + npcDisplayName);
                    }
                } else {
                    String[] options = actorDefinition.options;
                    if (DEBUG_DISPLAY_ALL_ACTION_ROWS) {
                        options = getAllOptionsWithIndices(options);
                    }

                    // add non-attack options to NPC
                    if (options != null) {
                        for (int i = 4; i >= 0; i--) {
                            if (options[i] != null && !options[i].equalsIgnoreCase(English.attack)) {
                                int actionType = 0;
                                if (i == 0) {
                                    actionType = ActionRowType.INTERACT_WITH_NPC_OPTION_1.getId();
                                }
                                if (i == 1) {
                                    actionType = ActionRowType.INTERACT_WITH_NPC_OPTION_2.getId();
                                }
                                if (i == 2) {
                                    actionType = ActionRowType.INTERACT_WITH_NPC_OPTION_3.getId();
                                }
                                if (i == 3) {
                                    actionType = ActionRowType.INTERACT_WITH_NPC_OPTION_4.getId();
                                }
                                if (i == 4) {
                                    actionType = ActionRowType.INTERACT_WITH_NPC_OPTION_5.getId();
                                }
                                addActionRow(options[i], index, x, y, actionType, Native.yellow + npcDisplayName);
                            }
                        }
                    }

                    // add 'Attack' option to NPC
                    if (options != null) {
                        for (int i = 4; i >= 0; i--) {
                            if (options[i] != null && options[i].equalsIgnoreCase(English.attack)) {
                                int actionTypeOffset = 0;

                                // deprioritise the action in the list if the NPC is higher level than the player
                                if (Player.localPlayer.combatLevel < actorDefinition.combatLevel) {
                                    actionTypeOffset = ActionRowType.LOW_PRIORITY_MODIFIER;
                                }

                                int actionType = 0;
                                if (i == 0) {
                                    actionType = ActionRowType.INTERACT_WITH_NPC_OPTION_1.getId() + actionTypeOffset;
                                }
                                if (i == 1) {
                                    actionType = ActionRowType.INTERACT_WITH_NPC_OPTION_2.getId() + actionTypeOffset;
                                }
                                if (i == 2) {
                                    actionType = ActionRowType.INTERACT_WITH_NPC_OPTION_3.getId() + actionTypeOffset;
                                }
                                if (i == 3) {
                                    actionType = ActionRowType.INTERACT_WITH_NPC_OPTION_4.getId() + actionTypeOffset;
                                }
                                if (i == 4) {
                                    actionType = ActionRowType.INTERACT_WITH_NPC_OPTION_5.getId() + actionTypeOffset;
                                }
                                addActionRow(options[i], index, x, y, actionType, Native.yellow +npcDisplayName);
                            }
                        }
                    }
                    StringBuilder examineText = new StringBuilder();
                    examineText.append(MessageFormat.format("<col=ffff00>{0}</col>", actorDefinition.name));

                    if(actorDefinition.combatLevel != 0) {
                        String combatLevel = " " +
                            getCombatLevelColour(Player.localPlayer.combatLevel, actorDefinition.combatLevel)
                                + Native.leftParenthesis + English.prefixLevel + actorDefinition.combatLevel + Native.rightParenthesis;
                        examineText.append(combatLevel);
                    }


                    if (Configuration.DEBUG_CONTEXT) {
                        examineText.append(" <col=00ff00>(</col>");
                        examineText.append(
                                MessageFormat.format("<col=ffffff>{0}</col>",
                                        Integer.toString(actorDefinition.id)
                                )
                        );
                        examineText.append("<col=00ff00>) (</col>");
                        examineText.append(
                                MessageFormat.format("<col=ffffff>{0}, {1}</col>",
                                        Integer.toString(x + baseX),
                                        Integer.toString(y + baseY)
                                )
                        );
                        examineText.append("<col=00ff00>)</col>");


                    }
                    addActionRow(English.examine, index, x, y, ActionRowType.EXAMINE_NPC.getId(), examineText.toString());
                }
            }
        }
    }

    public static ImageRGB method1028(CacheArchive arg0, String arg1, String always_empty) {
        int i = arg0.getGroupIdByName(arg1);
        int i_13_ = arg0.getFileIdByName(i, always_empty);
        return method927(arg0, i, i_13_);
    }

    public static void spawnGroundItem(int arg1, int arg2) {
        LinkedList linkedList = groundItems[Player.worldLevel][arg2][arg1];
        if(linkedList == null)
            Game.currentScene.removeGroundItems(Player.worldLevel, arg2, arg1);
        else {
            int i = -99999999;
            Item item = null;
            for(Item item_32_ = (Item) linkedList.peekFirst(); item_32_ != null; item_32_ = (Item) linkedList.pollFirst()) {
                ItemDefinition class40_sub5_sub16 = ItemDefinition.forId(item_32_.itemId, 10);
                int i_33_ = class40_sub5_sub16.cost;
                if(class40_sub5_sub16.stackable == 1)
                    i_33_ *= item_32_.itemCount + 1;
                if(i_33_ > i) {
                    i = i_33_;
                    item = item_32_;
                }
            }
            if(item == null)
                Game.currentScene.removeGroundItems(Player.worldLevel, arg2, arg1);
            else {
                Item item_34_ = null;
                Item item_35_ = null;
                linkedList.addFirst(item);
                for(Item item_36_ = (Item) linkedList.peekFirst(); item_36_ != null; item_36_ = (Item) linkedList.pollFirst()) {
                    if(item.itemId != item_36_.itemId) {
                        if(item_35_ == null)
                            item_35_ = item_36_;
                        if(item_35_.itemId != item_36_.itemId && item_34_ == null)
                            item_34_ = item_36_;
                    }
                }
                int i_37_ = 1610612736 + (arg1 << 7) + arg2;
                Game.currentScene.addGroundItemTile(arg2, arg1, Player.worldLevel, Game.currentScene.getFloorDrawHeight(Player.worldLevel, 64 + 128 * arg2, 64 + 128 * arg1), i_37_, item, item_35_, item_34_);
            }
        }

    }

    public static void method744() {
        if(Game.keyFocusListener != null) {
            synchronized(Game.keyFocusListener) {
                Game.keyFocusListener = null;
            }
        }
    }

    public static void drawWelcomeScreenGraphics() {
        try {
            if(ScreenController.frameMode == ScreenMode.FIXED) {
                Graphics graphics = Game.gameCanvas.getGraphics();

                framePieceRight.drawGraphics(0, 4, graphics);
                chatboxRight.drawGraphics(0, 357, graphics);
                mapbackLeft.drawGraphics(722, 4, graphics);
                tabPieceLeft.drawGraphics(743, 205, graphics);
                framePieceTop.drawGraphics(0, 0, graphics);
                mapBackRight.drawGraphics(516, 4, graphics);
                tabPieceUpperRight.drawGraphics(516, 205, graphics);
                tabPieveLowerRight.drawGraphics(496, 357, graphics);
                chatboxTop.drawGraphics(0, 338, graphics);
            }
        } catch(Exception exception) {
            Game.gameCanvas.repaint();
        }
    }

    public static void method763(Component arg0, CacheArchive arg2) {
        if(!aBoolean2083) {
            inventoryBackgroundImage = Game.method359(Native.invback, Native.aClass1_305, arg2);
            chatboxBackgroundImage = Game.method359(Native.chatback, Native.aClass1_305, arg2);
            Minimap.minimapBackgroundImage = Game.method359(Native.mapBack, Native.aClass1_305, arg2);
            bottomChatBack = Game.method359(Native.imgBackbase1, Native.aClass1_305, arg2);
            tabBottomBack = Game.method359(Native.imgBackbase2, Native.aClass1_305, arg2);
            tabTopBack = Game.method359(Native.imgBackhmid1, Native.aClass1_305, arg2);
            ChatBox.chatBoxImageProducer = createGraphicsBuffer(479, 96, arg0);
            chatboxBackgroundImage.drawImage(0, 0);
            Minimap.mapbackProducingGraphicsBuffer = createGraphicsBuffer(172, 156, arg0);
            Rasterizer.resetPixels();
            Minimap.minimapBackgroundImage.drawImage(0, 0);
            tabImageProducer = createGraphicsBuffer(190, 261, arg0);
            inventoryBackgroundImage.drawImage(0, 0);
            gameScreenImageProducer = createGraphicsBuffer(ScreenController.frameMode == ScreenMode.FIXED ? 512 : ScreenController.drawWidth, ScreenController.frameMode == ScreenMode.FIXED ? 334 : ScreenController.drawHeight, arg0);
            Rasterizer.resetPixels();
            chatModes = createGraphicsBuffer(496, 50, arg0);
            tabBottom = createGraphicsBuffer(269, 37, arg0);
            tabTop = createGraphicsBuffer(249, 45, arg0);
            ImageRGB image = method1028(arg2, Native.imgBackleft1, Native.aClass1_305);
            framePieceRight = createGraphicsBuffer(image.imageWidth, image.imageHeight, arg0);
            image.drawInverse(0, 0);
            image = method1028(arg2, Native.imgBackleft2, Native.aClass1_305);
            chatboxRight = createGraphicsBuffer(image.imageWidth, image.imageHeight, arg0);
            image.drawInverse(0, 0);
            image = method1028(arg2, Native.imgBackright1, Native.aClass1_305);
            mapbackLeft = createGraphicsBuffer(image.imageWidth, image.imageHeight, arg0);
            image.drawInverse(0, 0);
            image = method1028(arg2, Native.imgBackright2, Native.aClass1_305);
            tabPieceLeft = createGraphicsBuffer(image.imageWidth, image.imageHeight, arg0);
            image.drawInverse(0, 0);
            image = method1028(arg2, Native.imgBacktop1, Native.aClass1_305);
            framePieceTop = createGraphicsBuffer(image.imageWidth, image.imageHeight, arg0);
            image.drawInverse(0, 0);
            image = method1028(arg2, Native.imgBackvmid1, Native.aClass1_305);
            mapBackRight = createGraphicsBuffer(image.imageWidth, image.imageHeight, arg0);
            image.drawInverse(0, 0);
            image = method1028(arg2, Native.imgBackvmid2, Native.aClass1_305);
            tabPieceUpperRight = createGraphicsBuffer(image.imageWidth, image.imageHeight, arg0);
            image.drawInverse(0, 0);
            image = method1028(arg2, Native.imgBackvmid3, Native.aClass1_305);
            tabPieveLowerRight = createGraphicsBuffer(image.imageWidth, image.imageHeight, arg0);
            image.drawInverse(0, 0);
            image = method1028(arg2, Native.imgBackhmid2, Native.aClass1_305);
            chatboxTop = createGraphicsBuffer(image.imageWidth, image.imageHeight, arg0);
            image.drawInverse(0, 0);
            tabHighlightImageTopLeftEdge = Game.method359(Native.redstone1, Native.aClass1_305, arg2);
            GameInterface.tabHighlightImageTopLeft = Game.method359(Native.redstone2, Native.aClass1_305, arg2);
            tabHighlightImageTopMiddle = Game.method359(Native.redstone3, Native.aClass1_305, arg2);
            tabHighlightImageTopRightEdge = tabHighlightImageTopLeftEdge.cloneImage();
            tabHighlightImageTopRightEdge.flipHorizontal();
            tabHighlightImageTopRight = GameInterface.tabHighlightImageTopLeft.cloneImage();
            tabHighlightImageTopRight.flipHorizontal();
            tabHighlightImageBottomLeftEdge = tabHighlightImageTopLeftEdge.cloneImage();
            tabHighlightImageBottomLeftEdge.flipVertical();
            tabHighlightImageBottomLeft = GameInterface.tabHighlightImageTopLeft.cloneImage();
            tabHighlightImageBottomLeft.flipVertical();
            tabHighlightImageBottomMiddle = tabHighlightImageTopMiddle.cloneImage();
            tabHighlightImageBottomMiddle.flipVertical();
            tabHighlightImageBottomRightEdge = tabHighlightImageTopLeftEdge.cloneImage();
            tabHighlightImageBottomRightEdge.flipHorizontal();
            tabHighlightImageBottomRightEdge.flipVertical();
            tabHighlightImageBottomRight = GameInterface.tabHighlightImageTopLeft.cloneImage();
            tabHighlightImageBottomRight.flipHorizontal();
            tabHighlightImageBottomRight.flipVertical();
            tabIcons = IndexedImage.getMultipleIndexedImages(arg2, Native.sideIcons, Native.aClass1_305);
            anIntArray1186 = new int[151];
            anIntArray852 = new int[151];
            Minimap.anIntArray66 = new int[33];
            Minimap.anIntArray62 = new int[33];
            for(int y = 0; y < 33; y++) {
                int i_15_ = 0;
                int i_16_ = 999;
                for(int x = 0; x < 34; x++) {
                    if(Minimap.minimapBackgroundImage.imgPixels[Minimap.minimapBackgroundImage.imgWidth * y + x] == 0) {
                        if(i_16_ == 999)
                            i_16_ = x;
                    } else if(i_16_ != 999) {
                        i_15_ = x;
                        break;
                    }
                }
                Minimap.anIntArray62[y] = i_16_;
                Minimap.anIntArray66[y] = -i_16_ + i_15_;
            }
            for(int y = 5; y < 156; y++) {
                int maxWidth = 0;
                int minWidth = 999;
                for(int x = 25; x < 172; x++) {
                    if(Minimap.minimapBackgroundImage.imgPixels[x + Minimap.minimapBackgroundImage.imgWidth * y] != 0 || x <= 34 && y <= 34) {
                        if(minWidth != 999) {
                            maxWidth = x;
                            break;
                        }
                    } else if(minWidth == 999)
                        minWidth = x;
                }
                anIntArray1186[-5 + y] = minWidth - 25;
                anIntArray852[-5 + y] = maxWidth + -minWidth;
            }
            aBoolean2083 = true;
        }
    }

    public static int getGameCameraPlane() {
        if(!Configuration.ROOFS_ENABLED) {
            return Player.worldLevel;
        }
        int i = 3;
        if(Game.playerCamera.getPitch() < 310) {
            Point3d cameraPos = Game.playerCamera.getPosition();
            int i_22_ = cameraPos.y >> 7;
            int i_23_ = cameraPos.x >> 7;
            if(i_22_ > 103) {
                i_22_ = 103;
            }
            if(i_23_ > 103) {
                i_23_ = 103;
            }
            if((tile_flags[Player.worldLevel][i_23_][i_22_] & 0x4) != 0)
                i = Player.worldLevel;
            int i_24_ = Player.localPlayer.worldX >> 7;
            int i_25_ = Player.localPlayer.worldY >> 7;
            int i_26_;
            if(i_24_ <= i_23_)
                i_26_ = -i_24_ + i_23_;
            else
                i_26_ = -i_23_ + i_24_;
            int i_27_;
            if(i_22_ < i_25_)
                i_27_ = i_25_ + -i_22_;
            else
                i_27_ = -i_25_ + i_22_;
            if(i_26_ <= i_27_) {
                int i_28_ = i_26_ * 65536 / i_27_;
                int i_29_ = 32768;
                while(i_22_ != i_25_) {
                    if(i_25_ <= i_22_) {
                        if(i_22_ > i_25_)
                            i_22_--;
                    } else
                        i_22_++;
                    if(i_22_ > 103) {
                        i_22_ = 103;
                    }
                    if(i_23_ > 103) {
                        i_23_ = 103;
                    }
                    i_29_ += i_28_;
                    if((tile_flags[Player.worldLevel][i_23_][i_22_] & 0x4) != 0)
                        i = Player.worldLevel;
                    if(i_29_ >= 65536) {
                        if(i_23_ < i_24_)
                            i_23_++;
                        else if(i_24_ < i_23_)
                            i_23_--;
                        i_29_ -= 65536;
                        if(i_22_ > 103) {
                            i_22_ = 103;
                        }
                        if(i_23_ > 103) {
                            i_23_ = 103;
                        }
                        if((0x4 & tile_flags[Player.worldLevel][i_23_][i_22_]) != 0)
                            i = Player.worldLevel;
                    }
                }
            } else {
                int i_30_ = i_27_ * 65536 / i_26_;
                int i_31_ = 32768;
                while(i_23_ != i_24_) {
                    if(i_23_ >= i_24_) {
                        if(i_24_ < i_23_)
                            i_23_--;
                    } else
                        i_23_++;
                    if((tile_flags[Player.worldLevel][i_23_][i_22_] & 0x4) != 0)
                        i = Player.worldLevel;
                    i_31_ += i_30_;
                    if(i_31_ >= 65536) {
                        i_31_ -= 65536;
                        if(i_25_ > i_22_)
                            i_22_++;
                        else if(i_22_ > i_25_)
                            i_22_--;
                        if((tile_flags[Player.worldLevel][i_23_][i_22_] & 0x4) != 0)
                            i = Player.worldLevel;
                    }
                }
            }
        }
        if((tile_flags[Player.worldLevel][Player.localPlayer.worldX >> 7][Player.localPlayer.worldY >> 7] & 0x4) != 0)
            i = Player.worldLevel;
        return i;

    }

    public static void drawLoadingBox(String topLine, String bottomLine, boolean blackBackground) {
        if(clearScreen) {
            clearScreen = false;
            drawWelcomeScreenGraphics();
            ChatBox.drawChatBoxGraphics();
            drawTabGraphics();
            Minimap.drawMapBack();
            Game.method943(ChatBox.tradeMode, fontNormal, ChatBox.privateChatMode, ChatBox.publicChatMode);
            method527(Game.currentTabId, Game.tabWidgetIds, GameInterface.tabAreaInterfaceId == -1, -1);
            showSidePanelRedrawnText = true;
            showIconsRedrawnText = true;
            showChatPanelRedrawnText = true;
        }

        int y = 151;
        method1018();
        y -= 3;
        fontNormal.drawStringLeft(topLine, 257, y, 0);
        fontNormal.drawStringLeft(topLine, 256, y + -1, 16777215);

        if(bottomLine != null) {
            y += 15;

            if(blackBackground) {
                int bottomWidth = 4 + fontNormal.getStringWidth(bottomLine);
                Rasterizer.drawFilledRectangle(257 - bottomWidth / 2, -11 + y, bottomWidth, 11, 0);
            }

            fontNormal.drawStringLeft(bottomLine, 257, y, 0);
            fontNormal.drawStringLeft(bottomLine, 256, y - 1, 16777215);
        }

        drawGameScreenGraphics();
    }

    public static String getCombatLevelColour(int arg0, int arg1) {
        int diff = -arg1 + arg0;
        if (diff < -9)
            return Native.red;
        if (diff < -6)
            return Native.orange3;
        if (diff < -3)
            return Native.orange2;
        if (diff < 0)
            return Native.orange1;
        if (diff > 9)
            return Native.green;
        if (diff > 6)
            return Native.green3;
        if (diff > 3)
            return Native.green2;
        if (diff > 0)
            return Native.green1;
        return Native.yellow;
    }

    public static void drawMenuTooltip(int arg0) {
        if (menuActionRow >= 2 || GameInterface.itemCurrentlySelected != 0 || Game.widgetSelected != 0) {
            String class1;
            if (GameInterface.itemCurrentlySelected == 1 && menuActionRow < 2)
                class1 = English.use + Native.whitespace + Native.selectedItemName + Native.targetThingArrow;
            else if (Game.widgetSelected != 1 || menuActionRow >= 2)
                class1 = menuActionTexts[-1 + menuActionRow];
            else
                class1 = Native.selectedSpellVerb + Native.whitespace + Native.selectedSpellName + Native.targetThingArrow;
            if (menuActionRow > 2)
                class1 = class1 + Native.whiteSlash + (menuActionRow + -2) + English.suffixMoreOptions;
            if (arg0 == 4)
                TypeFace.fontBold.drawShadowedSeededAlphaString(class1, 4, 15, 16777215, true, pulseCycle / 1000);
        }
    }

    public static void drawTabGraphics() {
        try {
            Graphics graphics = Game.gameCanvas.getGraphics();
            tabImageProducer.drawGraphics(553, 205, graphics);
        } catch(Exception exception) {
            Game.gameCanvas.repaint();
        }
    }

    public static String parseException(Throwable exception) throws IOException {
        String string;
        if(exception instanceof RSRuntimeException) {
            RSRuntimeException runtimeexception_sub1 = (RSRuntimeException) exception;
            string = runtimeexception_sub1.aString1653 + " | ";
            exception = runtimeexception_sub1.aThrowable1652;
        } else
            string = "";
        StringWriter stringwriter = new StringWriter();
        PrintWriter printwriter = new PrintWriter(stringwriter);
        exception.printStackTrace(printwriter);
        printwriter.close();
        String string_0_ = stringwriter.toString();
        BufferedReader bufferedreader = new BufferedReader(new StringReader(string_0_));
        String string_1_ = bufferedreader.readLine();
        for(; ; ) {
            String string_2_ = bufferedreader.readLine();
            if(string_2_ == null)
                break;
            int i = string_2_.indexOf('(');
            int i_3_ = string_2_.indexOf(')', i + 1);
            if(i >= 0 && i_3_ >= 0) {
                String string_4_ = string_2_.substring(1 + i, i_3_);
                int i_5_ = string_4_.indexOf(".java:");
                if(i_5_ >= 0) {
                    string_4_ = string_4_.substring(0, i_5_) + string_4_.substring(5 + i_5_);
                    string += string_4_ + ' ';
                    continue;
                }
                string_2_ = string_2_.substring(0, i);
            }
            string_2_ = string_2_.trim();
            string_2_ = string_2_.substring(1 + string_2_.lastIndexOf(' '));
            string_2_ = string_2_.substring(1 + string_2_.lastIndexOf('\t'));
            string += string_2_ + ' ';
        }
        string += "| " + string_1_;
        return string;
    }

    public static void threadSleep(long ms) {
        if (ms <= 0L) {
            return;
        }

        try {
            Thread.sleep(ms);
        } catch(InterruptedException interruptedexception) {
            /* empty */
        }
    }

    public static void drawTabArea() {
        showSidePanelRedrawnText = true;
        method996();
        if(GameInterface.tabAreaInterfaceId != -1) {
            boolean bool = Game.drawParentInterface(1, 0, 0, 190, 261, GameInterface.tabAreaInterfaceId);
            if(!bool)
                GameInterface.redrawTabArea = true;
        } else if(Game.tabWidgetIds[Game.currentTabId] != -1) {
            boolean bool = Game.drawParentInterface(1, 0, 0, 190, 261, Game.tabWidgetIds[Game.currentTabId]);
            if(!bool)
                GameInterface.redrawTabArea = true;
        }
        if(menuOpen && menuScreenArea == 1) {
            if(drawMenuSeparateName == 1)
                drawMenuItemSeparateName();
            else if(ScreenController.frameMode == ScreenMode.FIXED)
                drawMenu(0,0);
        }

        if(ScreenController.frameMode == ScreenMode.FIXED) {
            drawTabGraphics();
        }
    }

    public static void processRightClick() {
        if(GameInterface.activeInterfaceType == 0) {
            menuActionTexts[0] = English.cancel;
            menuActionTypes[0] = ActionRowType.CANCEL.getId();
            menuActionRow = 1;
            if(GameInterface.fullscreenInterfaceId == -1) {
                addSplitPrivateChatActionRows();
                tempOpenWidgetChildTooltipId = -1;
                tempHoveredWidgetChildId = -1;
                boolean bool = false;
                // Right game screen
                if(ScreenController.isCoordinatesIn3dScreen(MouseHandler.mouseX , MouseHandler.mouseY )) {
                    if(GameInterface.gameScreenInterfaceId == -1) {
                        method1013();
                    } else {
                        int yOffset = (ScreenController.drawHeight /2) - (334/2) - (184/2);
                        int xOffset = (ScreenController.drawWidth /2) - (512/2) - (234/3);
                        if(ScreenController.frameMode == ScreenMode.FIXED) {
                            yOffset = 0;
                            xOffset = 0;
                        }
                        handleInterfaceActions(GameInterfaceArea.GAME_AREA, MouseHandler.mouseX - xOffset, MouseHandler.mouseY - yOffset, 4, 4, 516, 338, GameInterface.gameScreenInterfaceId);
                    }
                }

                openWidgetChildTooltipId = tempOpenWidgetChildTooltipId;
                hoveredWidgetChildId = tempHoveredWidgetChildId;
                tempOpenWidgetChildTooltipId = -1;
                tempHoveredWidgetChildId = -1;
                // Right click tab
                if(ScreenController.isCoordinatesInTabArea(MouseHandler.mouseX, MouseHandler.mouseY)) {
                    ScreenController.handleTabClick(MouseHandler.mouseX, MouseHandler.mouseY);
                }
                if(tempHoveredWidgetChildId != currentHoveredWidgetChildId) {
                    GameInterface.redrawTabArea = true;
                    currentHoveredWidgetChildId = tempHoveredWidgetChildId;
                }
                tempHoveredWidgetChildId = -1;
                if(tempOpenWidgetChildTooltipId != openTabWidgetChildTooltipId) {
                    openTabWidgetChildTooltipId = tempOpenWidgetChildTooltipId;
                    GameInterface.redrawTabArea = true;
                }
                tempOpenWidgetChildTooltipId = -1;
                // right click chatbox
                if(ScreenController.isCoordinatesInChatArea(MouseHandler.mouseX , MouseHandler.mouseY)) {
                    ScreenController.handleChatBoxMouse(MouseHandler.mouseX , MouseHandler.mouseY);
                }

                // Set hovering for chat widgets
                if((GameInterface.chatboxInterfaceId != -1 || ChatBox.dialogueId != -1) && currentHoveredChatboxWidgetChildId != tempHoveredWidgetChildId) {
                    ChatBox.redrawChatbox = true;
                    currentHoveredChatboxWidgetChildId = tempHoveredWidgetChildId;
                }

                if((GameInterface.chatboxInterfaceId != -1 || ChatBox.dialogueId != -1) && tempOpenWidgetChildTooltipId != anInt1586) {
                    ChatBox.redrawChatbox = true;
                    anInt1586 = tempOpenWidgetChildTooltipId;
                }
                while(!bool) {
                    bool = true;
                    for(int i = 0; -1 + menuActionRow > i; i++) {
                        if(menuActionTypes[i] < 1000 && menuActionTypes[1 + i] > 1000) {
                            bool = false;
                            String class1 = menuActionTexts[i];
                            menuActionTexts[i] = menuActionTexts[i + 1];
                            menuActionTexts[i + 1] = class1;
                            int type = menuActionTypes[i];
                            menuActionTypes[i] = menuActionTypes[i + 1];
                            menuActionTypes[i + 1] = type;
                            int firstOperand = firstMenuOperand[i];
                            firstMenuOperand[i] = firstMenuOperand[1 + i];
                            firstMenuOperand[1 + i] = firstOperand;
                            int secondOperand = secondMenuOperand[i];
                            secondMenuOperand[i] = secondMenuOperand[1 + i];
                            secondMenuOperand[i + 1] = secondOperand;
                            int action = selectedMenuActions[i];
                            selectedMenuActions[i] = selectedMenuActions[i + 1];
                            selectedMenuActions[1 + i] = action;
                        }
                    }
                }
            } else {
                tempOpenWidgetChildTooltipId = -1;
                tempHoveredWidgetChildId = -1;
                handleInterfaceActions(GameInterfaceArea.GAME_AREA, MouseHandler.mouseX, MouseHandler.mouseY, 0, 0, 765, 503, GameInterface.fullscreenInterfaceId);
                hoveredWidgetChildId = tempHoveredWidgetChildId;
                openWidgetChildTooltipId = tempOpenWidgetChildTooltipId;
            }
        }
    }

    public static void drawMenuItemSeparateName() {
        String itemName = null;

        // find the item name by looking for coloured text within the options
        for(int i = 0; menuActionRow > i; i++) {
            if(menuActionTexts[i].contains(Native.lightRed)) {
                itemName = menuActionTexts[i].substring(menuActionTexts[i].indexOf(Native.lightRed));
                break;
            }
        }

        // if no name then draw the standard menu
        if(itemName == null)
            drawMenu(0,0);
        else {
            int width = menuWidth;
            int x = menuOffsetX;
            if(width > 190)
                width = 190;
            int height = menuHeight;
            int y = Game.menuOffsetY;
            if(x < 0)
                x = 0;

            int background = 0x5D5447;

            Rasterizer.drawFilledRectangle(x, y, width, height, background);
            Rasterizer.drawFilledRectangle(x + 1, y + 1, -2 + width, 16, 0);
            Rasterizer.drawUnfilledRectangle(x + 1, 18 + y, -2 + width, height + -19, 0);
            TypeFace.fontBold.drawShadowedString(itemName, 3 + x, 14 + y, false, background);

            int mouseX = MouseHandler.mouseX;
            int mouseY = MouseHandler.mouseY;

            if(menuScreenArea == 0) {
                mouseX -= 4;
                mouseY -= 4;
            }
            if(menuScreenArea == 1) {
                mouseX -= 553;
                mouseY -= 205;
            }
            if(menuScreenArea == 2) {
                mouseY -= 357;
                mouseX -= 17;
            }

            for(int row = 0; row < menuActionRow; row++) {
                int rowY = 31 + y + (menuActionRow - row - 1) * 15;
                String rowText = menuActionTexts[row];
                int rowBackground = 0xFFFFFF;

                if(rowText.endsWith(itemName)) {
                    rowText = rowText.substring(0, rowText.length() - itemName.length());
                    if(rowText.endsWith(Native.whitespace))
                        rowText = rowText.substring(0, rowText.length() + -Native.whitespace.length());
                }

                if(x < mouseX && mouseX < x + width && -13 + rowY < mouseY && 3 + rowY > mouseY)
                    rowBackground = 0xFFFF00;

                TypeFace.fontBold.drawShadowedString(rowText, 3 + x, rowY, true, rowBackground);
            }
        }
    }

    public static void handleInterfaceActions(GameInterfaceArea area, int mouseX, int mouseY, int minX, int minY, int maxX, int maxY, int widgetId) {
        if(GameInterface.load(widgetId)) {
            handleInterfaceActions(area, mouseX, mouseY, minX, minY, maxX, maxY, GameInterface.components[widgetId], -1, 0, 0);
        }
    }

    public static void animatePlayers(int playerIndex) {
        for(int currentPlayerIndex = playerIndex; Player.localPlayerCount > currentPlayerIndex; currentPlayerIndex++) {
            int actualIndex;
            if(currentPlayerIndex == -1)
                actualIndex = 2047;
            else
                actualIndex = Player.trackedPlayerIndices[currentPlayerIndex];
            Player player = Player.trackedPlayers[actualIndex];
            if(player != null)
                Actor.handleActorAnimation(player);
        }
    }

    public static void copyBytes(byte[] source, int sourceStart, byte[] destination, int destinationStart, int numBytes) {
        if(source == destination) {
            if(sourceStart == destinationStart)
                return;
            if(destinationStart > sourceStart && destinationStart < sourceStart + numBytes) {
                numBytes--;
                sourceStart += numBytes;
                destinationStart += numBytes;
                numBytes = sourceStart - numBytes;
                numBytes += 7;
                while(sourceStart >= numBytes) {
                    destination[destinationStart--] = source[sourceStart--];
                    destination[destinationStart--] = source[sourceStart--];
                    destination[destinationStart--] = source[sourceStart--];
                    destination[destinationStart--] = source[sourceStart--];
                    destination[destinationStart--] = source[sourceStart--];
                    destination[destinationStart--] = source[sourceStart--];
                    destination[destinationStart--] = source[sourceStart--];
                    destination[destinationStart--] = source[sourceStart--];
                }
                numBytes -= 7;
                while(sourceStart >= numBytes)
                    destination[destinationStart--] = source[sourceStart--];
                return;
            }
        }
        numBytes += sourceStart;
        numBytes -= 7;
        while(sourceStart < numBytes) {
            destination[destinationStart++] = source[sourceStart++];
            destination[destinationStart++] = source[sourceStart++];
            destination[destinationStart++] = source[sourceStart++];
            destination[destinationStart++] = source[sourceStart++];
            destination[destinationStart++] = source[sourceStart++];
            destination[destinationStart++] = source[sourceStart++];
            destination[destinationStart++] = source[sourceStart++];
            destination[destinationStart++] = source[sourceStart++];
        }
        numBytes += 7;
        while(sourceStart < numBytes)
            destination[destinationStart++] = source[sourceStart++];
    }

    public static boolean menuHasAddFriend(int arg1) {
        int i = menuActionTypes[arg1];
        if(i >= ActionRowType.LOW_PRIORITY_MODIFIER)
            i -= ActionRowType.LOW_PRIORITY_MODIFIER;
        return i == ActionRowType.ADD_FRIEND.getId();
    }

    /**
     * Renders headicons, chat, healthbar, hitsplats, etc.
     *
     * Anything that is a 2D item attached to an actor in the world.
     */
    public static void draw2DActorAttachments() {
        int overheadChatMessageCount = 0;
        for(int i = -1; Player.localPlayerCount + Player.npcCount > i; i++) {
            Actor actor;
            if(i == -1)
                actor = Player.localPlayer;
            else if(i < Player.localPlayerCount)
                actor = Player.trackedPlayers[Player.trackedPlayerIndices[i]];
            else
                actor = Player.npcs[Player.npcIds[i + -Player.localPlayerCount]];
            if(actor != null && actor.isInitialized()) {
                if(actor instanceof Npc) {
                    ActorDefinition npcDefinition = ((Npc) actor).actorDefinition;
                    if(npcDefinition.childIds != null)
                        npcDefinition = npcDefinition.getChildDefinition();
                    if(npcDefinition == null)
                        continue;
                }
                if(Player.localPlayerCount <= i) {
                    ActorDefinition npcDefinition = ((Npc) actor).actorDefinition;
                    if(npcDefinition.headIcon >= 0 && npcDefinition.headIcon < headIconSprites.length) {
                        Point2d screenPos = getProjectedScreenPosition(actor.anInt3117 + 15, actor.worldY, actor.worldX);

                        if(screenPos != null)
                            headIconSprites[npcDefinition.headIcon].drawImage(-12 + screenPos.x, screenPos.y + -30);
                    }
                    if(Game.currentHintIconType == 1 && hintIconNpcTarget == Player.npcIds[-Player.localPlayerCount + i] && pulseCycle % 20 < 10) {
                        Point2d screenPos = getProjectedScreenPosition(actor.anInt3117 + 15, actor.worldY, actor.worldX);
                        if(screenPos != null)
                            hintIconSprites[0].drawImage(screenPos.x + -12, screenPos.y + -28);
                    }
                } else {
                    Player targetPlayer = (Player) actor;
                    int drawHeight = 30;
                    if(targetPlayer.isSkulled != -1 || targetPlayer.headIcon != -1) {
                        Point2d screenPos = getProjectedScreenPosition(actor.anInt3117 + 15, actor.worldY, actor.worldX);

                        if (screenPos != null) {
                            if(targetPlayer.isSkulled != -1) {
                                aClass40_Sub5_Sub14_Sub4Array603[targetPlayer.isSkulled].drawImage(screenPos.x - 12, screenPos.y - drawHeight);
                                drawHeight += 25;
                            }
                            if(targetPlayer.headIcon != -1) {
                                headIconSprites[targetPlayer.headIcon].drawImage(screenPos.x - 12, screenPos.y - drawHeight);
                                drawHeight += 25;
                            }
                        }
                    }
                    if(i >= 0 && Game.currentHintIconType == 10 && hintIconPlayerTarget == Player.trackedPlayerIndices[i]) {
                        Point2d screenPos = getProjectedScreenPosition(actor.anInt3117 + 15, actor.worldY, actor.worldX);

                        if (screenPos != null) {
                            hintIconSprites[1].drawImage(screenPos.x - 12, screenPos.y - drawHeight);
                        }
                    }
                }
                if(actor.forcedChatMessage != null && (i >= Player.localPlayerCount || ChatBox.publicChatMode == 0 || ChatBox.publicChatMode == 3 || ChatBox.publicChatMode == 1 && Player.hasFriend(((Player) actor).playerName))) {
                    Point2d screenPos = getProjectedScreenPosition(actor.anInt3117, actor.worldY, actor.worldX);

                    if(screenPos != null && 50 > overheadChatMessageCount) {
                        Actor.overheadChatHalfWidth[overheadChatMessageCount] = TypeFace.fontBold.getStringWidth(actor.forcedChatMessage) / 2;
                        Actor.overheadChatLetterHeight[overheadChatMessageCount] = TypeFace.fontBold.characterDefaultHeight;
                        Actor.overheadChatX[overheadChatMessageCount] = screenPos.x;
                        Actor.overheadChatY[overheadChatMessageCount] = screenPos.y;
                        Actor.overheadChatColor[overheadChatMessageCount] = actor.chatcolor;
                        Actor.overheadChatShape[overheadChatMessageCount] = actor.chatEffects;
                        Actor.overheadChatTimer[overheadChatMessageCount] = actor.chatTimer;
                        Actor.overheadChatMessage[overheadChatMessageCount] = actor.forcedChatMessage;
                        overheadChatMessageCount++;
                    }
                }
                if(pulseCycle < actor.anInt3139) {
                    Point2d screenPos = getProjectedScreenPosition(actor.anInt3117 + 15, actor.worldY, actor.worldX);

                    if(screenPos != null) {
                        int i_1_ = 30 * actor.remainingHitpoints / actor.maximumHitpoints;
                        if(i_1_ > 30)
                            i_1_ = 30;
                        Rasterizer.drawFilledRectangle(-15 + screenPos.x, screenPos.y + -3, i_1_, 5, 65280);
                        Rasterizer.drawFilledRectangle(-15 + screenPos.x + i_1_, screenPos.y + -3, 30 + -i_1_, 5, 16711680);
                    }
                }
                for(int i_2_ = 0; i_2_ < 4; i_2_++) {
                    if(pulseCycle < actor.anIntArray3136[i_2_]) {
                        Point2d screenPos = getProjectedScreenPosition(actor.anInt3117 / 2, actor.worldY, actor.worldX);
                        if(screenPos != null) {
                            if(i_2_ == 1) {
                                screenPos = screenPos.addY(-20);
                            }
                            if(i_2_ == 2) {
                                screenPos = screenPos.add(new Point2d(-15, -10));
                            }
                            if(i_2_ == 3) {
                                screenPos = screenPos.add(new Point2d(15, -10));
                            }
                            aClass40_Sub5_Sub14_Sub4Array2474[actor.anIntArray3086[i_2_]].drawImage(screenPos.x + -12, -12 + screenPos.y);
                            TypeFace.fontSmall.drawStringLeft(Integer.toString(actor.anIntArray3087[i_2_]), screenPos.x, 4 + screenPos.y, 0);
                            TypeFace.fontSmall.drawStringLeft(Integer.toString(actor.anIntArray3087[i_2_]), screenPos.x - 1, screenPos.y + 3, 16777215);
                        }
                    }
                }
            }
        }
        for(int i = 0; overheadChatMessageCount > i; i++) {
            int i_3_ = Actor.overheadChatX[i];
            int i_4_ = Actor.overheadChatY[i];
            int i_5_ = Actor.overheadChatHalfWidth[i];
            int i_6_ = Actor.overheadChatLetterHeight[i];
            boolean bool = true;
            while(bool) {
                bool = false;
                for(int i_7_ = 0; i > i_7_; i_7_++) {
                    if(-Actor.overheadChatLetterHeight[i_7_] + Actor.overheadChatY[i_7_] < i_4_ + 2 && -i_6_ + i_4_ < 2 + Actor.overheadChatY[i_7_] && Actor.overheadChatX[i_7_] + Actor.overheadChatHalfWidth[i_7_] > -i_5_ + i_3_ && i_5_ + i_3_ > -Actor.overheadChatHalfWidth[i_7_] + Actor.overheadChatX[i_7_] && -Actor.overheadChatLetterHeight[i_7_] + Actor.overheadChatY[i_7_] < i_4_) {
                        bool = true;
                        i_4_ = -Actor.overheadChatLetterHeight[i_7_] + Actor.overheadChatY[i_7_];
                    }
                }
            }
            Actor.overheadChatY[i] = i_4_;

            Point2d screenPos = new Point2d(Actor.overheadChatX[i], Actor.overheadChatY[i]);
            String message = Actor.overheadChatMessage[i];
            if(chatEffectsDisabled == 0) {
                int textColor = OVERHEAD_CHAT_COLORS[0];
                // standard 6 colors (yellow, red, green, cyan, purple, white)
                // TODO (James) tie this into the ChatColorEffect enum
                if(Actor.overheadChatColor[i] < 6)
                    textColor = OVERHEAD_CHAT_COLORS[Actor.overheadChatColor[i]];
                if(Actor.overheadChatColor[i] == ChatColorEffect.FLASH1.getNetworkCode())
                    textColor = anInt2628 % 20 >= 10 ? OVERHEAD_CHAT_COLORS[0] : OVERHEAD_CHAT_COLORS[1];
                if(Actor.overheadChatColor[i] == ChatColorEffect.FLASH2.getNetworkCode())
                    textColor = anInt2628 % 20 < 10 ? 255 : OVERHEAD_CHAT_COLORS[3];
                if(Actor.overheadChatColor[i] == ChatColorEffect.FLASH3.getNetworkCode())
                    textColor = anInt2628 % 20 >= 10 ? 8454016 : 45056;
                if(Actor.overheadChatColor[i] == ChatColorEffect.GLOW1.getNetworkCode()) {
                    int i_9_ = 150 - Actor.overheadChatTimer[i];
                    if(i_9_ >= 50) {
                        if(i_9_ < 100)
                            textColor = -((-50 + i_9_) * 327680) + OVERHEAD_CHAT_COLORS[0];
                        else if(i_9_ < 150)
                            textColor = OVERHEAD_CHAT_COLORS[2] + 5 * (i_9_ + -100);
                    } else
                        textColor = OVERHEAD_CHAT_COLORS[1] + 1280 * i_9_;
                }
                if(Actor.overheadChatColor[i] == ChatColorEffect.GLOW2.getNetworkCode()) {
                    int i_10_ = 150 + -Actor.overheadChatTimer[i];
                    if(i_10_ >= 50) {
                        if(i_10_ >= 100) {
                            if(i_10_ < 150)
                                textColor = 255 - (-(327680 * (i_10_ - 100)) - 500) + -(5 * i_10_);
                        } else
                            textColor = OVERHEAD_CHAT_COLORS[4] - (327680 * i_10_ - 16384000);
                    } else
                        textColor = 5 * i_10_ + OVERHEAD_CHAT_COLORS[1];
                }
                if(Actor.overheadChatColor[i] == ChatColorEffect.GLOW3.getNetworkCode()) {
                    int i_11_ = -Actor.overheadChatTimer[i] + 150;
                    if(i_11_ >= 50) {
                        if(i_11_ < 100)
                            textColor = 327685 * (i_11_ - 50) + OVERHEAD_CHAT_COLORS[2];
                        else if(i_11_ < 150)
                            textColor = -((-100 + i_11_) * 327680) + OVERHEAD_CHAT_COLORS[5];
                    } else
                        textColor = -(327685 * i_11_) + OVERHEAD_CHAT_COLORS[5];
                }
                if(Actor.overheadChatShape[i] == ChatShapeEffect.NONE.getNetworkCode()) {
                    TypeFace.fontBold.drawStringLeft(message, screenPos.x, screenPos.y + 1, 0);
                    TypeFace.fontBold.drawStringLeft(message, screenPos.x, screenPos.y, textColor);
                }
                if(Actor.overheadChatShape[i] == ChatShapeEffect.WAVE.getNetworkCode()) {
                    TypeFace.fontBold.drawCenteredStringWaveY(message, screenPos.x, screenPos.y + 1, anInt2628, 0);
                    TypeFace.fontBold.drawCenteredStringWaveY(message, screenPos.x, screenPos.y, anInt2628, textColor);
                }
                if(Actor.overheadChatShape[i] == ChatShapeEffect.WAVE2.getNetworkCode()) {
                    TypeFace.fontBold.drawCenteredStringWaveXY(message, screenPos.x, 1 + screenPos.y, anInt2628, 0);
                    TypeFace.fontBold.drawCenteredStringWaveXY(message, screenPos.x, screenPos.y, anInt2628, textColor);
                }
                if(Actor.overheadChatShape[i] == ChatShapeEffect.SHAKE.getNetworkCode()) {
                    TypeFace.fontBold.drawCenteredStringWaveXYMove(message, screenPos.x, screenPos.y + 1, anInt2628, -Actor.overheadChatTimer[i] + 150, 0);
                    TypeFace.fontBold.drawCenteredStringWaveXYMove(message, screenPos.x, screenPos.y, anInt2628, -Actor.overheadChatTimer[i] + 150, textColor);
                }
                if(Actor.overheadChatShape[i] == ChatShapeEffect.SCROLL.getNetworkCode()) {
                    int i_12_ = TypeFace.fontBold.getStringWidth(message);
                    int i_13_ = (i_12_ + 100) * (150 + -Actor.overheadChatTimer[i]) / 150;
                    Rasterizer.setBounds(screenPos.x + -50, 0, 50 + screenPos.x, 334);
                    TypeFace.fontBold.drawString(message, -i_13_ + screenPos.x + 50, screenPos.y + 1, 0);
                    TypeFace.fontBold.drawString(message, 50 + screenPos.x + -i_13_, screenPos.y, textColor);
                    Rasterizer.resetBounds();
                }
                if(Actor.overheadChatShape[i] == ChatShapeEffect.SLIDE.getNetworkCode()) {
                    int i_14_ = 0;
                    int i_15_ = 150 + -Actor.overheadChatTimer[i];
                    Rasterizer.setBounds(0, -1 + -TypeFace.fontBold.characterDefaultHeight + screenPos.y, 512, 5 + screenPos.y);
                    if(i_15_ >= 25) {
                        if(i_15_ > 125)
                            i_14_ = i_15_ + -125;
                    } else
                        i_14_ = i_15_ + -25;
                    TypeFace.fontBold.drawStringLeft(message, screenPos.x, i_14_ + screenPos.y + 1, 0);
                    TypeFace.fontBold.drawStringLeft(message, screenPos.x, i_14_ + screenPos.y, textColor);
                    Rasterizer.resetBounds();
                }
            } else {
                TypeFace.fontBold.drawStringLeft(message, screenPos.x, screenPos.y + 1, 0);
                TypeFace.fontBold.drawStringLeft(message, screenPos.x, screenPos.y, OVERHEAD_CHAT_COLORS[0]);
            }
        }
    }

    public static boolean method438(int areaId, int arg1) {
        // (Jameskmonger) something to do with right clicking
        if(areaId == 0 && arg1 == openWidgetChildTooltipId)
            return true;
        if(areaId == 1 && openTabWidgetChildTooltipId == arg1)
            return true;
        if((areaId == 2 || areaId == 3) && anInt1586 == arg1)
            return true;
        return false;
    }

    public static void method434() {
        menuOpen = false;
        IncomingPackets.opcode = -1;
        menuActionRow = 0;
        IncomingPackets.incomingPacketSize = 0;
        OutgoingPackets.buffer.currentPosition = 0;
        IncomingPackets.lastOpcode = -1;
        IncomingPackets.secondLastOpcode = -1;
        IncomingPackets.cyclesSinceLastPacket = 0;
        IncomingPackets.thirdLastOpcode = -1;
        destinationX = 0;
        Minimap.minimapState = 0;
        systemUpdateTime = 0;
        IncomingPackets.incomingPacketBuffer.currentPosition = 0;
        for(int i = 0; Player.trackedPlayers.length > i; i++) {
            if(Player.trackedPlayers[i] != null)
                Player.trackedPlayers[i].facingActorIndex = -1;
        }
        for(int i = 0; Player.npcs.length > i; i++) {
            if(Player.npcs[i] != null)
                Player.npcs[i].facingActorIndex = -1;
        }
        processGameStatus(30);
    }

    public static boolean method735(int arg1) {
        if(arg1 >= 97 && arg1 <= 122)
            return true;
        if(arg1 >= 65 && arg1 <= 90)
            return true;
        if(arg1 >= 48 && arg1 <= 57)
            return true;
        return false;
    }

    public static int getVisibilityPlaneFor(int plane, int y, int x) {
        if((tile_flags[plane][x][y] & 0x8) != 0)
            return 0;
        if(plane > 0 && (tile_flags[1][x][y] & 0x2) != 0)
            return plane - 1;
        return plane;
    }

    public static void determineMenuSize() {
        int width = TypeFace.fontBold.getStringWidth(English.chooseOption);
        for(int i = 0; i < menuActionRow; i++) {
            int rowWidth = TypeFace.fontBold.getTextDisplayedWidth(menuActionTexts[i]);
            if(width < rowWidth)
                width = rowWidth;
        }
        width += 8;
        int height = menuActionRow * 15 + 21;
        if(ScreenController.frameMode == ScreenMode.FIXED){
            if(MouseHandler.clickX > 4 && MouseHandler.clickY > 4 && MouseHandler.clickX < 516 && MouseHandler.clickY < 338) {
                menuScreenArea = 0;
                menuHeight = menuActionRow * 15 + 22;
                menuOpen = true;
                int x = -(width / 2) + -4 + MouseHandler.clickX;
                menuWidth = width;
                if(width + x > 512)
                    x = 512 - width;
                if(x < 0)
                    x = 0;
                menuOffsetX = x;
                int y = MouseHandler.clickY + -4;
                if(y + height > 334)
                    y = 334 - height;
                if(y < 0)
                    y = 0;
                Game.menuOffsetY = y;
            }
            if(MouseHandler.clickX > 553 && MouseHandler.clickY > 205 && MouseHandler.clickX < 743 && MouseHandler.clickY < 466) {
                menuHeight = 22 + 15 * menuActionRow;
                menuScreenArea = 1;
                int y = -205 + MouseHandler.clickY;
                int x = -(width / 2) + -553 + MouseHandler.clickX;
                if(x < 0)
                    x = 0;
                else if(width + x > 190)
                    x = 190 - width;
                menuOpen = true;
                menuOffsetX = x;
                if(y >= 0) {
                    if(height + y > 261)
                        y = -height + 261;
                } else
                    y = 0;
                menuWidth = width;
                Game.menuOffsetY = y;
            }
            if(MouseHandler.clickX > 17 && MouseHandler.clickY > 357 && MouseHandler.clickX < 496 && MouseHandler.clickY < 453) {
                menuWidth = width;
                menuScreenArea = 2;
                menuHeight = menuActionRow * 15 + 22;
                int y = MouseHandler.clickY + -357;
                if(y >= 0) {
                    if(height + y > 96)
                        y = -height + 96;
                } else
                    y = 0;
                int x = -(width / 2) + -17 + MouseHandler.clickX;
                menuOpen = true;
                Game.menuOffsetY = y;
                if(x < 0)
                    x = 0;
                else if(x + width > 479)
                    x = -width + 479;
                menuOffsetX = x;
            }

        } else if(MouseHandler.clickX > 0 && MouseHandler.clickY > 0 && MouseHandler.clickX < GameShell.clientFrame.getWidth() && MouseHandler.clickY < GameShell.clientFrame.getHeight()) {
                        menuScreenArea = 0;
            int x = -(width / 2) + -4 + MouseHandler.clickX;
            if(width + x > GameShell.clientFrame.getWidth() - 4)
                x = GameShell.clientFrame.getWidth() - 4;
            if(x < 0)
                x = 0;
            int y = MouseHandler.clickY + -4;
            if(y + height > GameShell.clientFrame.getHeight() - 4)
                y = GameShell.clientFrame.getHeight() - 4;
            if(y + height > ScreenController.frameHeight-22)
                y = ScreenController.frameHeight-22 - height;
            if(y < 0)
                y = 0;
            if(width + x > ScreenController.drawWidth)
                x = ScreenController.drawWidth - width;
            menuOpen = true;
            menuOffsetX = x;
            Game.menuOffsetY = y;
            menuWidth = width;
            menuHeight = menuActionRow * 15 + 22;
        }
//        if(Class57.clickX > 553 && RSString.clickY > 205 && Class57.clickX < 743 && RSString.clickY < 466) {
//            CollisionMap.menuHeight = 22 + 15 * ActorDefinition.menuActionRow;
//            Class40_Sub5_Sub17_Sub1.menuScreenArea = 1;
//            int y = -205 + RSString.clickY;
//            int x = -(width / 2) + -553 + Class57.clickX;
//            if(x < 0)
//                x = 0;
//            else if(width + x > 190)
//                x = 190 - width;
//            Class4.menuOpen = true;
//            InteractiveObject.menuOffsetX = x;
//            if(y >= 0) {
//                if(height + y > 261)
//                    y = -height + 261;
//            } else
//                y = 0;
//            VertexNormal.menuWidth = width;
//            Game.menuOffsetY = y;
//        }
//        if(Class57.clickX > 17 && RSString.clickY > 357 && Class57.clickX < 496 && RSString.clickY < 453) {
//            VertexNormal.menuWidth = width;
//            Class40_Sub5_Sub17_Sub1.menuScreenArea = 2;
//            CollisionMap.menuHeight = ActorDefinition.menuActionRow * 15 + 22;
//            int y = RSString.clickY + -357;
//            if(y >= 0) {
//                if(height + y > 96)
//                    y = -height + 96;
//            } else
//                y = 0;
//            int x = -(width / 2) + -17 + Class57.clickX;
//            Class4.menuOpen = true;
//            Game.menuOffsetY = y;
//            if(x < 0)
//                x = 0;
//            else if(x + width > 479)
//                x = -width + 479;
//            InteractiveObject.menuOffsetX = x;
//        }
    }

    public static int getLoadedTitleImageCount(CacheArchive huffmanArchive, CacheArchive imageArchive) {
        int i = 0;
        if(huffmanArchive.loaded(Native.titleImage, ""))
            i++;
        if(imageArchive.loaded(Native.logo, ""))
            i++;
        if(imageArchive.loaded(Native.titleBox, ""))
            i++;
        if(imageArchive.loaded(Native.titleButton, ""))
            i++;
        if(imageArchive.loaded(Native.runes, ""))
            i++;
        return i;
    }

    public static void method1018() {
        gameScreenImageProducer.prepareRasterizer();
        fullScreenTextureArray = Rasterizer3D.setLineOffsets(fullScreenTextureArray);
    }

    public static boolean method1051(int arg0, GameInterface gameInterface) {
        if(arg0 != 300)
            return false;
        int i = gameInterface.contentType;
        if(i >= 1 && i <= 200 || i >= 701 && i <= 900) {
            if(i >= 801)
                i -= 701;
            else if(i >= 701)
                i -= 601;
            else if(i < 101)
                i--;
            else
                i -= 101;

            String username = Game.friendList.getPlayerUsername(i);

            addActionRow(English.remove, 0, 0, 0, ActionRowType.REMOVE_FRIEND.getId(), Native.white + username);
            addActionRow(English.message, 0, 0, 0, ActionRowType.MESSAGE_FRIEND.getId(), Native.white + username);
            return true;
        }
        if(i >= 401 && i <= 500) {
            addActionRow(English.remove, 0, 0, 0, ActionRowType.REMOVE_IGNORE.getId(), Native.white + gameInterface.text);
            return true;
        }
        return false;
    }

    public static int method1052(String value, Buffer buffer) {
        int startingPosition = buffer.currentPosition;
        byte[] strBytes = value.getBytes(StandardCharsets.UTF_8);
        buffer.putSmart(strBytes.length);
        buffer.currentPosition += aHuffmanEncoding_2590.encrypt(0, buffer.currentPosition, strBytes.length, strBytes, buffer.buffer);
        return buffer.currentPosition - startingPosition;

    }

    public static void drawGameScreenGraphics() {
        try {
            Graphics graphics = Game.gameCanvas.getGraphics();
            gameScreenImageProducer.drawGraphics(ScreenController.frameMode == ScreenMode.FIXED ? 4 : 0, ScreenController.frameMode == ScreenMode.FIXED ? 4 : 0, graphics);
        } catch(Exception exception) {
            Game.gameCanvas.repaint();
        }
    }

    /**
     * Something to do with checking validity of input characters,
     * if this returns false then chat/console/interface input is not accepted
     *
     * TODO (jkm) assign a better name to `arg1` when we understand the
     *            keypress obfuscation/mapping thing
     */
    public static boolean isValidInputCharacter(int arg1) {
        if(arg1 < 32)
            return false;
        if(arg1 == 127)
            return false;
        return arg1 < 129 || arg1 > 159;
    }

    public static IndexedImage loadIndexedImageFromArchive(CacheArchive imageArchive, int id) {
        if(!decodeImageFromArchive(imageArchive, id))
            return null;
        return createIndexedImageFromDecodedData();
    }


    public static void method778(HuffmanEncoding arg1) {
        aHuffmanEncoding_2590 = arg1;
    }

    public static int getLoadedFrameImageCount(CacheArchive archive) {
        int i = 0;
        if (archive.loaded(Native.invback, Native.aClass1_305)) {
            i++;
        }
        if (archive.loaded(Native.chatback, Native.aClass1_305)) {
            i++;
        }
        if (archive.loaded(Native.mapBack, Native.aClass1_305)) {
            i++;
        }
        if (archive.loaded(Native.imgBackbase1, Native.aClass1_305)) {
            i++;
        }
        if (archive.loaded(Native.imgBackbase2, Native.aClass1_305)) {
            i++;
        }
        if (archive.loaded(Native.imgBackhmid1, Native.aClass1_305)) {
            i++;
        }
        if (archive.loaded(Native.imgBackleft1, Native.aClass1_305)) {
            i++;
        }
        if (archive.loaded(Native.imgBackleft2, Native.aClass1_305)) {
            i++;
        }
        if (archive.loaded(Native.imgBackright1, Native.aClass1_305)) {
            i++;
        }
        if (archive.loaded(Native.imgBackright2, Native.aClass1_305)) {
            i++;
        }
        if (archive.loaded(Native.imgBacktop1, Native.aClass1_305)) {
            i++;
        }
        if (archive.loaded(Native.imgBackvmid1, Native.aClass1_305)) {
            i++;
        }
        if (archive.loaded(Native.imgBackvmid2, Native.aClass1_305)) {
            i++;
        }
        if (archive.loaded(Native.imgBackvmid3, Native.aClass1_305)) {
            i++;
        }
        if (archive.loaded(Native.imgBackhmid2, Native.aClass1_305)) {
            i++;
        }
        if (archive.loaded(Native.redstone1, Native.aClass1_305)) {
            i++;
        }
        if (archive.loaded(Native.redstone2, Native.aClass1_305)) {
            i++;
        }
        if (archive.loaded(Native.redstone3, Native.aClass1_305)) {
            i++;
        }
        if (archive.loaded(Native.sideIcons, Native.aClass1_305)) {
            i++;
        }
        return i;

    }

    public static void processMenuClick() {
        if(GameInterface.activeInterfaceType != 0) {
            return;
        }
        int meta = MouseHandler.clickType;
        if(Game.widgetSelected == 1 && MouseHandler.clickX >= 516 && MouseHandler.clickY >= 160 && MouseHandler.clickX <= 765 && MouseHandler.clickY <= 205)
            meta = 0;
        if(menuOpen) {
            if(meta != 1) {
                int x = MouseHandler.mouseX;
                int y = MouseHandler.mouseY;
                if(menuScreenArea == 0) {
                    x -= 4;
                    y -= 4;
                }
                if(menuScreenArea == 1) {
                    y -= 205;
                    x -= 553;
                }
                if(menuScreenArea == 2) {
                    y -= 357;
                    x -= 17;
                }
                if(-10 + menuOffsetX > x || 10 + menuWidth + menuOffsetX < x || y < Game.menuOffsetY + -10 || y > Game.menuOffsetY + menuHeight + 10) {
                    if(menuScreenArea == 1)
                        GameInterface.redrawTabArea = true;
                    menuOpen = false;
                    if(menuScreenArea == 2)
                        ChatBox.redrawChatbox = true;
                }
            }
            if(meta == 1) {
                int menuX = menuOffsetX;
                int menuY = Game.menuOffsetY;
                int dx = menuWidth;
                int x = MouseHandler.clickX;
                int y = MouseHandler.clickY;
                if(menuScreenArea == 0) {
                    x -= 4;
                    y -= 4;
                }
                if(menuScreenArea == 1) {
                    x -= 553;
                    y -= 205;
                }
                if(menuScreenArea == 2) {
                    x -= 17;
                    y -= 357;
                }
                int id = -1;
                for(int row = 0; row < menuActionRow; row++) {
                    int k3 = 31 + menuY + 15 * (menuActionRow + -1 - row);
                    if(x > menuX && x < dx + menuX && y > -13 + k3 && y < 3 + k3)
                        id = row;
                }
                if(id != -1)
                    GameInterface.processMenuActions(id);
                if(menuScreenArea == 1)
                    GameInterface.redrawTabArea = true;
                menuOpen = false;
                if(menuScreenArea == 2)
                    ChatBox.redrawChatbox = true;
            }
        } else {
            if(meta == 1 && menuActionRow > 0) {
                int action = menuActionTypes[menuActionRow - 1];
                if(
                    action == ActionRowType.INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_1.getId()
                        || action == ActionRowType.INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_2.getId()
                        || action == ActionRowType.INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_3.getId()
                        || action == ActionRowType.INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_4.getId()
                        || action == ActionRowType.INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_5.getId()
                        || action == ActionRowType.INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_1.getId()
                        || action == ActionRowType.INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_2.getId()
                        || action == ActionRowType.INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_3.getId()
                        || action == ActionRowType.INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_4.getId()
                        || action == ActionRowType.DROP_ITEM.getId()
                        || action == ActionRowType.SELECT_ITEM_ON_WIDGET.getId()
                        || action == ActionRowType.EXAMINE_ITEM_ON_V1_WIDGET.getId()
                ) {
                    int item = firstMenuOperand[menuActionRow - 1];
                    int id = secondMenuOperand[-1 + menuActionRow];
                    GameInterface gameInterface = GameInterface.getInterface(id);
                    if(gameInterface.invDraggable || gameInterface.invClearDragged) {
                        anInt2869 = MouseHandler.clickX;
                        lastItemDragged = false;
                        GameInterface.activeInterfaceType = 2;
                        GameInterface.modifiedWidgetId = id;
                        anInt2798 = MouseHandler.clickY;
                        GameInterface.selectedInventorySlot = item;
                        if(id >> 16 == GameInterface.gameScreenInterfaceId)
                            GameInterface.activeInterfaceType = 1;
                        if(GameInterface.chatboxInterfaceId == id >> 16)
                            GameInterface.activeInterfaceType = 3;
                        GameInterface.lastItemDragTime = 0;
                        return;
                    }
                }
            }
            if(meta == 1 && (Game.oneMouseButton == 1 || menuHasAddFriend(-1 + menuActionRow)) && menuActionRow > 2)
                meta = 2;
            if(meta == 1 && menuActionRow > 0)
                GameInterface.processMenuActions(menuActionRow - 1);
            if(meta == 2 && menuActionRow > 0)
                determineMenuSize();
        }
    }

    public static void resetGameTimer() {
        Game.gameTimer.reset();
        for(int i = 0; i < 32; i++)
            GameShell.tickSamples[i] = 0L;
        for(int i = 0; i < 32; i++)
            tickSamples[i] = 0L;
        ticksPerLoop = 0;
    }

    public static ImageRGB createImageRGBFromDecodedData() {
        ImageRGB image = new ImageRGB();
        image.maxWidth = imageMaxWidth;
        image.maxHeight = imageMaxHeight;
        image.offsetX = spriteOffsetX[0];
        image.offsetY = spriteOffsetY[0];
        image.imageWidth = spriteWidth[0];
        image.imageHeight = spriteHeight[0];
        byte[] is = spritePixels[0];
        int i = image.imageWidth * image.imageHeight;
        image.pixels = new int[i];
        for(int i_5_ = 0; i_5_ < i; i_5_++) {
            image.pixels[i_5_] = spritePalette[BitUtils.bitWiseAND(255, is[i_5_])];
        }
        clearDecodedSpriteData();
        return image;
    }

    public static void clearDecodedSpriteData() {
        spriteWidth = null;
        spritePixels = null;
        spriteHeight = null;
        spriteOffsetY = null;
        spritePalette = null;
        spriteOffsetX = null;
    }

    public static boolean walkToObject(int offsetX, int offsetY, int objectInfo) {
        int objectId = 0x7fff & objectInfo >> 14;

        int arrangement = Game.currentScene.getArrangement(Player.worldLevel, offsetX, offsetY, objectInfo);
        if(arrangement == -1) {
            return false;
        }

        int orientation = 0x3 & arrangement >> 6;
        int type = 0x1f & arrangement;

        if(type != 10 && type != 11 && type != 22) {
            Pathfinding.doObjectWalkTo(Player.localPlayer.pathY[0], Player.localPlayer.pathX[0], offsetX, offsetY, 0, 0, 0, 1 + type, orientation);
        } else {
            GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(objectId);
            int blockingMask = gameObjectDefinition.blockingMask;
            if(orientation != 0)
                blockingMask = (blockingMask >> 4 + -orientation) + (0xf & blockingMask << orientation);
            int sizeX;
            int sizeY;
            if(orientation == 0 || orientation == 2) {
                sizeY = gameObjectDefinition.sizeY;
                sizeX = gameObjectDefinition.sizeX;
            } else {
                sizeX = gameObjectDefinition.sizeY;
                sizeY = gameObjectDefinition.sizeX;
            }
            Pathfinding.doObjectWalkTo(Player.localPlayer.pathY[0], Player.localPlayer.pathX[0], offsetX, offsetY, sizeX, sizeY, blockingMask, 0, 0);
        }

        GameInterface.crossX = MouseHandler.clickX;
        GameInterface.crossY = MouseHandler.clickY;

        crossType = 2;
        crossIndex = 0;

        return true;
    }

    public static boolean decodeImageFromArchive(CacheArchive cacheArchive, int groupId, int fileId) {
        byte[] imageData = cacheArchive.getFile(groupId, fileId);
        if(imageData == null)
            return false;
        decodeImageData(imageData);
        return true;
    }

    public static boolean decodeImageFromArchive(CacheArchive imageArchive, int id) {
        byte[] imageData = imageArchive.getFile(id);
        if(imageData == null) {
            return false;
        }
        decodeImageData(imageData);
        return true;
    }

    public static void method789(int chunkLocalX, int chunkY, int chunkX, int chunkLocalY, int level) {
        if(chunkX != regionX || chunkY != regionY || onBuildTimePlane != level && VertexNormal.lowMemory) {
            onBuildTimePlane = level;
            regionX = chunkX;
            if(!VertexNormal.lowMemory)
                onBuildTimePlane = 0;
            regionY = chunkY;
            processGameStatus(25);
            drawLoadingBox(English.loadingPleaseWait, null, false);
            int i = baseY;
            int i_33_ = baseX;
            baseX = (chunkX - 6) * 8;
            int i_34_ = baseX + -i_33_;
            i_33_ = baseX;
            baseY = (-6 + chunkY) * 8;
            int i_35_ = baseY + -i;
            i = baseY;
            for(int i_36_ = 0; i_36_ < 32768; i_36_++) {
                Npc class40_sub5_sub17_sub4_sub2 = Player.npcs[i_36_];
                if(class40_sub5_sub17_sub4_sub2 != null) {
                    for(int i_37_ = 0; i_37_ < 10; i_37_++) {
                        class40_sub5_sub17_sub4_sub2.pathY[i_37_] -= i_34_;
                        class40_sub5_sub17_sub4_sub2.pathX[i_37_] -= i_35_;
                    }
                    class40_sub5_sub17_sub4_sub2.worldX -= 128 * i_34_;
                    class40_sub5_sub17_sub4_sub2.worldY -= i_35_ * 128;
                }
            }
            for(int i_38_ = 0; i_38_ < 2048; i_38_++) {
                Player class40_sub5_sub17_sub4_sub1 = Player.trackedPlayers[i_38_];
                if(class40_sub5_sub17_sub4_sub1 != null) {
                    for(int i_39_ = 0; i_39_ < 10; i_39_++) {
                        class40_sub5_sub17_sub4_sub1.pathY[i_39_] -= i_34_;
                        class40_sub5_sub17_sub4_sub1.pathX[i_39_] -= i_35_;
                    }
                    class40_sub5_sub17_sub4_sub1.worldY -= 128 * i_35_;
                    class40_sub5_sub17_sub4_sub1.worldX -= 128 * i_34_;
                }
            }
            Player.worldLevel = level;
            int i_40_ = 0;
            Player.localPlayer.method787(chunkLocalY, false, chunkLocalX);
            int i_41_ = 104;
            int i_42_ = 1;
            if(i_34_ < 0) {
                i_41_ = -1;
                i_40_ = 103;
                i_42_ = -1;
            }
            int i_43_ = 104;
            int i_44_ = 0;
            int i_45_ = 1;
            if(i_35_ < 0) {
                i_44_ = 103;
                i_43_ = -1;
                i_45_ = -1;
            }
            for(int i_46_ = i_40_; i_41_ != i_46_; i_46_ += i_42_) {
                for(int i_47_ = i_44_; i_43_ != i_47_; i_47_ += i_45_) {
                    int i_48_ = i_34_ + i_46_;
                    int i_49_ = i_35_ + i_47_;
                    for(int i_50_ = 0; i_50_ < 4; i_50_++) {
                        if(i_48_ < 0 || i_49_ < 0 || i_48_ >= 104 || i_49_ >= 104)
                            groundItems[i_50_][i_46_][i_47_] = null;
                        else
                            groundItems[i_50_][i_46_][i_47_] = groundItems[i_50_][i_48_][i_49_];
                    }
                }
            }
            for(InteractiveObjectTemporary obj = (InteractiveObjectTemporary) interactiveObjectTemporaryNodeCache.peekFirst(); obj != null; obj = (InteractiveObjectTemporary) interactiveObjectTemporaryNodeCache.pollFirst()) {
                obj.y -= i_35_;
                obj.x -= i_34_;
                if(obj.x < 0 || obj.y < 0 || obj.x >= 104 || obj.y >= 104)
                    obj.unlink();
            }
            Minimap.minimapLevel = -1;
            if(destinationX != 0) {
                destinationX -= i_34_;
                Game.destinationY -= i_35_;
            }
            Player.cutsceneActive = false;
            SoundSystem.reset();
            spotAnimQueue.clear();
            projectileQueue.clear();
        }
    }
}
