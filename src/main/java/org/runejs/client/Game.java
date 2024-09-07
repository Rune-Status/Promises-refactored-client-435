package org.runejs.client;

import org.runejs.client.cache.CacheIndex;
import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.CacheFileChannel;
import org.runejs.client.cache.cs.ClientScript;
import org.runejs.client.chat.FriendList;
import org.runejs.client.chat.SocialList;
import org.runejs.client.frame.*;
import org.runejs.client.frame.console.Console;
import org.runejs.client.input.KeyFocusListener;
import org.runejs.client.input.MouseHandler;
import org.runejs.client.language.English;
import org.runejs.client.language.Native;
import org.runejs.client.login.*;
import org.runejs.client.media.Rasterizer;
import org.runejs.client.media.Rasterizer3D;
import org.runejs.client.media.VertexNormal;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.media.renderable.actor.*;
import org.runejs.client.message.handler.MessageHandlerRegistry;
import org.runejs.client.message.handler.rs435.RS435HandlerRegistry;
import org.runejs.client.message.outbound.misc.ClickFlashingTabIconOutboundMessage;
import org.runejs.client.message.outbound.widget.container.DragWidgetItemOutboundMessage;
import org.runejs.client.net.*;
import org.runejs.client.net.codec.MessagePacketCodec;
import org.runejs.client.net.codec.runejs435.RuneJS435PacketCodec;
import org.runejs.client.ondemand.js5.JS5UpdateServerConnectionManager;
import org.runejs.client.ondemand.js5.exceptions.*;
import org.runejs.client.renderer.ScreenRenderer;
import org.runejs.client.scene.*;
import org.runejs.client.scene.camera.Camera;
import org.runejs.client.scene.camera.CameraRotation;
import org.runejs.client.scene.camera.CutsceneCamera;
import org.runejs.client.scene.camera.SphericalCamera;
import org.runejs.client.sound.MusicSystem;
import org.runejs.client.sound.SoundSystem;
import org.runejs.client.util.Signlink;
import org.runejs.client.cache.def.*;
import org.runejs.client.cache.media.AnimationSequence;
import org.runejs.client.cache.media.ImageRGB;
import org.runejs.client.cache.media.IndexedImage;
import org.runejs.client.cache.media.TypeFace;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.cache.media.gameInterface.GameInterfaceType;
import org.runejs.client.cache.media.gameInterface.InterfaceModelType;
import org.runejs.Configuration;
import org.runejs.client.util.TextUtils;
import org.runejs.client.util.Timer;

import java.awt.*;

public class Game {

    public static ScreenRenderer renderer;

    /**
     * The codec currently in use to encode and decode packets.
     *
     * TODO (Jameskmonger) add a clear way to use different codecs
     */
    public static final MessagePacketCodec packetCodec = new RuneJS435PacketCodec();

    /**
     * The registry that holds all the InboundMessage handlers.
     */
    public static final MessageHandlerRegistry handlerRegistry = new RS435HandlerRegistry();

    /**
     * The main camera, orbiting on a sphere around the player.
     */
    public static final SphericalCamera playerCamera = new SphericalCamera();

    /**
     * A customisable cutscene camera.
     */
    public static final CutsceneCamera cutsceneCamera = new CutsceneCamera();

    public static FriendList friendList;

    public static final SocialList ignoreList = new SocialList(100);

    public static GameInterface chatboxInterface;
    public static boolean aBoolean871 = false;
    public static int modewhat = 0;
    public static int modewhere = 0;
    public static long lastClickTime = 0L;
    public static int mouseInvInterfaceIndex = 0;
    public static boolean isLoadingUpdates = true;
    public static MouseCapturer mouseCapturer;
    /**
     * Region loading type:
     *
     * - 0: ???
     * - 1: landscape files
     * - 2: game object definitions
     */
    public static int regionLoadingType = 0;
    public static int missingGameObjectFiles = 0;
    public static int totalMissingGameObjectFiles = 1;
    public static int missingLandscapeFiles = 0;
    public static int totalMissingLandscapeFiles = 1;
    public static int destinationY = 0;
    public static SceneRenderer sceneRenderer;
    public static Scene currentScene;
    public static int gameStatusCode = 0;
    public static KeyFocusListener keyFocusListener = new KeyFocusListener();
    public static int oneMouseButton = 0;
    public static int currentTabId = 3;
    public static int[] tabWidgetIds = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    public static int flashingTabId = -1;
    public static MouseHandler mouseHandler = new MouseHandler();
    public static Canvas gameCanvas;
    public static boolean accountFlagged = false;
    public static int clientVersion;
    public static int playerRights = 0;
    public static Timer gameTimer;
    public static int idleLogout = 0;

    /**
     * If the shift key has been pressed, this reflects the state, but only
     * `Game.isShiftModifierActive()` should be used for confirming that the key
     * is pressed as well as checking that player's client's configuration
     * allows shift modifiers to be leveraged.
     */
    public static boolean shiftPressed = false;
    /**
     * Backup port if the first one fails?
     */
    public static int someOtherPort;
    public static int gameServerPort;
    /**
     * Was the client focused last cycle?
     */
    public static boolean isClientFocused;
    /**
     * When the last 'focus' packet was sent, was the client focused?
     */
    public static boolean lastFocusTrackWasFocused = true;
    public static int currentHintIconType = 0;
    /**
     * Amount of mouse clicks since the last draw
     */
    public static int mouseClicksSinceLastDraw = 0;
    /**
     * Cycles between the last update and the current draw.
     */
    public static int deltaT = 0;
    private static int duplicateClickCount = 0;
    private static int lastClickY = 0;
    private static int lastClickX = 0;

    /**
     * Minimap rotation is always based on game camera
     */
    public static int getMinimapRotation() {
        return playerCamera.getRotation().yaw;
    }

    public static int menuOffsetY;
    public static int widgetSelected = 0;
    public static Signlink signlink;
    public static CacheIndex metaIndex;
    public static CacheFileChannel dataChannel;
    public static CacheFileChannel metaChannel;
    public static CacheFileChannel[] indexChannels = new CacheFileChannel[13];
    public static int currentPort;
    private static int drawCount = 0;

    public static GameStartup gameStartup = new GameStartup();

    private GameErrorHandler errorHandler;

    /**
     * This method is used to draw interfaces on the client. It uses the parent of -1,
     * which means it will render the widget on the top most level. It takes in a widget ID
     * and finds its children within the cached interfaces.
     *
     * @param areaId   Mostly used for logical checks
     *                 0 = Game area (the area that renders in 3D),
     *                 1 = Tab area (the widgets that display within the tab area),
     *                 2 = Chat area (the chat itself, as well as all sorts of dialogues and anything that renders over the chat)
     *                 3 = Permanent chat widget area (walkable chat widgets that replace the actual chat itself)
     *                 4 = ??? walkable widget?
     * @param minX     The top right X of this widget's boundaries
     * @param minY     The top right Y of this widget's boundaries
     * @param maxX     The bottom right Y of this widget's boundaries
     * @param maxY     The bottom right X of this widget's boundaries
     * @param widgetId The widget ID
     * @return The status of the drawing cycle, true for success and false for failure
     */
    public static boolean drawParentInterface(int areaId, int minX, int minY, int maxX, int maxY, int widgetId) {
        if (!GameInterface.load(widgetId))
            return false;

        return drawInterface(areaId, minX, minY, maxX, maxY, 0, 0, GameInterface.components[widgetId], -1, true);
    }

    /**
     * Recursive function that draws all the widgets within a GameInterface array.
     *
     * TODO (James) make this use GameInterfaceArea for the areaId param
     *
     * @param areaId              Mostly used for logical checks
     *                            0 = Game area (the area that renders in 3D),
     *                            1 = Tab area (the widgets that display within the tab area),
     *                            2 = Chat area (the chat itself, as well as all sorts of dialogues and anything that renders over the chat)
     *                            3 = Permanent chat widget area (walkable chat widgets that replace the actual chat itself)
     * @param minX                The top right X of this widget's boundaries
     * @param minY                The top right Y of this widget's boundaries
     * @param maxX                The bottom right X of this widget's boundaries
     * @param maxY                The bottom right Y of this widget's boundaries
     * @param scrollPosition      The current scroll position within this widget
     * @param scrollWidth         The current scroll width within this widget (unused)
     * @param interfaceCollection The GameInterface collection to draw
     * @param parentId            The parent ID, this will offset the widget's coordinates within its parent
     * @param drawSuccess         The status of the drawing cycle, true for success and false for failure
     * @return The status of the drawing cycle, true for success and false for failure
     */
    public static boolean drawInterface(int areaId, int minX, int minY, int maxX, int maxY, int scrollPosition, int scrollWidth, GameInterface[] interfaceCollection, int parentId, boolean drawSuccess) {
        Rasterizer.setBounds(minX, minY, maxX, maxY);

        boolean result = drawSuccess;
        for (int i = 0; interfaceCollection.length > i; i++) {
            GameInterface gameInterface = interfaceCollection[i];
            if (gameInterface != null && gameInterface.layer == parentId) {
                if (gameInterface.contentType > 0)
                    GameInterface.updateGameInterface(gameInterface);
                int absoluteX = minX + gameInterface.x;
                if (!gameInterface.lockScroll)
                    absoluteX -= scrollWidth;
                int absoluteY = minY + gameInterface.y;
                if (!gameInterface.lockScroll)
                    absoluteY -= scrollPosition;
                int opacity = gameInterface.transparency;
                if (gameInterface == GameInterface.aGameInterface_353) {
                    opacity = 128;
                    GameInterface gameInterface_3_ = GameInterface.method878(gameInterface);
                    int[] positionB = GameInterface.getAdjustedPosition(gameInterface_3_);
                    int[] positionA = GameInterface.getAdjustedPosition(gameInterface);
                    int i_5_ = MouseHandler.mouseY + -MovedStatics.anInt2621 + positionA[1] - positionB[1];
                    if (i_5_ < 0)
                        i_5_ = 0;
                    if (i_5_ + gameInterface.height > gameInterface_3_.height)
                        i_5_ = gameInterface_3_.height + -gameInterface.height;
                    absoluteY = i_5_ + positionB[1];
                    int i_6_ = MouseHandler.mouseX + -MovedStatics.anInt1996 + -positionB[0] + positionA[0];
                    if (i_6_ < 0)
                        i_6_ = 0;
                    if (i_6_ + gameInterface.width > gameInterface_3_.width)
                        i_6_ = -gameInterface.width + gameInterface_3_.width;
                    absoluteX = positionB[0] + i_6_;
                }
                if (!gameInterface.if3 || Rasterizer.viewportRight >= absoluteX && Rasterizer.viewportBottom >= absoluteY && Rasterizer.viewportLeft <= absoluteX + gameInterface.width && absoluteY + gameInterface.height >= Rasterizer.viewportTop) {
                    if (gameInterface.type == GameInterfaceType.LAYER) {
                        if (gameInterface.hide && !GameInterface.isHovering(areaId, i))
                            continue;
                        if (!gameInterface.if3) {
                            if (-gameInterface.height + gameInterface.scrollableHeight < gameInterface.scrollY)
                                gameInterface.scrollY = -gameInterface.height + gameInterface.scrollableHeight;
                            if (gameInterface.scrollY < 0)
                                gameInterface.scrollY = 0;
                        }
                        result &= drawInterface(areaId, absoluteX, absoluteY, gameInterface.width + absoluteX, gameInterface.height + absoluteY, gameInterface.scrollY, gameInterface.scrollX, interfaceCollection, i, drawSuccess);
                        if (gameInterface.createdComponents != null)
                            result &= drawInterface(areaId, absoluteX, absoluteY, gameInterface.width + absoluteX, absoluteY + gameInterface.height, gameInterface.scrollY, gameInterface.scrollX, gameInterface.createdComponents, gameInterface.id, true);
                        Rasterizer.setBounds(minX, minY, maxX, maxY);
                        if (gameInterface.height < gameInterface.scrollableHeight)
                            GameInterface.drawScrollBar(absoluteX + gameInterface.width, absoluteY, gameInterface.height, gameInterface.scrollY, gameInterface.scrollableHeight);
                    }
                    if (gameInterface.type == GameInterfaceType.UNKNOWN) {
                        continue;
                    }
                    if (gameInterface.type == GameInterfaceType.INVENTORY) {
                        int i_7_ = 0;
                        for (int i_8_ = 0; i_8_ < gameInterface.height; i_8_++) {
                            for (int i_9_ = 0; gameInterface.width > i_9_; i_9_++) {
                                int i_10_ = (gameInterface.invMarginX + 32) * i_9_ + absoluteX;
                                int i_11_ = (32 + gameInterface.invMarginY) * i_8_ + absoluteY;
                                if (i_7_ < 20) {
                                    i_10_ += gameInterface.invSlotImage[i_7_];
                                    i_11_ += gameInterface.invSlotOffsetX[i_7_];
                                }
                                if (gameInterface.invSlotObjId[i_7_] <= 0) {
                                    if (gameInterface.invSlotOffsetY != null && i_7_ < 20) {
                                        ImageRGB imageRGB = gameInterface.method638(i_7_);
                                        if (imageRGB == null) {
                                            if (GameInterface.aBoolean2177)
                                                result = false;
                                        } else
                                            imageRGB.drawImage(i_10_, i_11_);
                                    }
                                } else {
                                    int i_12_ = 0;
                                    int i_13_ = -1 + gameInterface.invSlotObjId[i_7_];
                                    int i_14_ = 0;
                                    if (-32 + Rasterizer.viewportLeft < i_10_ && Rasterizer.viewportRight > i_10_ && Rasterizer.viewportTop + -32 < i_11_ && Rasterizer.viewportBottom > i_11_ || GameInterface.activeInterfaceType != 0 && GameInterface.selectedInventorySlot == i_7_) {
                                        int i_15_ = 0;
                                        if (GameInterface.itemCurrentlySelected == 1 && i_7_ == GameInterface.itemSelectedContainerSlot && gameInterface.id == GameInterface.itemSelectedWidgetId)
                                            i_15_ = 16777215;
                                        ImageRGB imageRGB = ItemDefinition.sprite(gameInterface.invSlotObjCount[i_7_], i_13_, i_15_);
                                        if (imageRGB == null)
                                            result = false;
                                        else {
                                            if (GameInterface.activeInterfaceType != 0 && GameInterface.selectedInventorySlot == i_7_ && gameInterface.id == GameInterface.modifiedWidgetId) {
                                                i_14_ = MouseHandler.mouseY + -MovedStatics.anInt2798;
                                                i_12_ = MouseHandler.mouseX + -MovedStatics.anInt2869;
                                                if (i_12_ < 5 && i_12_ > -5)
                                                    i_12_ = 0;
                                                if (i_14_ < 5 && i_14_ > -5)
                                                    i_14_ = 0;
                                                if (GameInterface.lastItemDragTime < 5) {
                                                    i_14_ = 0;
                                                    i_12_ = 0;
                                                }
                                                imageRGB.drawImageWithOpacity(i_12_ + i_10_, i_11_ + i_14_, 128);
                                                if (parentId != -1) {
                                                    GameInterface gameInterface_16_ = interfaceCollection[parentId];
                                                    if (Rasterizer.viewportTop > i_14_ + i_11_ && gameInterface_16_.scrollY > 0) {
                                                        int i_17_ = deltaT * (Rasterizer.viewportTop + -i_11_ - i_14_) / 3;
                                                        if (10 * deltaT < i_17_)
                                                            i_17_ = 10 * deltaT;
                                                        if (gameInterface_16_.scrollY < i_17_)
                                                            i_17_ = gameInterface_16_.scrollY;
                                                        gameInterface_16_.scrollY -= i_17_;
                                                        MovedStatics.anInt2798 += i_17_;
                                                    }
                                                    if (32 + i_11_ + i_14_ > Rasterizer.viewportBottom && -gameInterface_16_.height + gameInterface_16_.scrollableHeight > gameInterface_16_.scrollY) {
                                                        int i_18_ = deltaT * (-Rasterizer.viewportBottom + 32 + i_11_ + i_14_) / 3;
                                                        if (deltaT * 10 < i_18_)
                                                            i_18_ = 10 * deltaT;
                                                        if (-gameInterface_16_.scrollY + gameInterface_16_.scrollableHeight + -gameInterface_16_.height < i_18_)
                                                            i_18_ = -gameInterface_16_.height + gameInterface_16_.scrollableHeight + -gameInterface_16_.scrollY;
                                                        MovedStatics.anInt2798 -= i_18_;
                                                        gameInterface_16_.scrollY += i_18_;
                                                    }
                                                }
                                            } else if (GameInterface.atInventoryInterfaceType == 0 || GameInterface.anInt1233 != i_7_ || gameInterface.id != GameInterface.anInt704)
                                                imageRGB.drawImage(i_10_, i_11_);
                                            else
                                                imageRGB.drawImageWithOpacity(i_10_, i_11_, 128);
                                            if (imageRGB.maxWidth == 33 || gameInterface.invSlotObjCount[i_7_] != 1) {
                                                int i_19_ = gameInterface.invSlotObjCount[i_7_];
//                                                TypeFace.fontSmall.drawString(GameInterface.getShortenedAmountText(i_19_), i_12_ + 1 + i_10_, i_11_ + 10 + i_14_, 0);
                                                TypeFace.fontSmall.drawShadowedString(GameInterface.getShortenedAmountText(i_19_), i_10_ + i_12_, i_14_ + i_11_ + 9, true, 16776960);
                                            }
                                        }
                                    }
                                }
                                i_7_++;
                            }
                        }
                    } else if (gameInterface.type == GameInterfaceType.RECTANGLE) {
                        int rectangleColor;
                        if (GameInterface.checkForAlternateAction(gameInterface)) {
                            rectangleColor = gameInterface.activeColor;
                            if (GameInterface.isHovering(areaId, i) && gameInterface.activeHoverColor != 0)
                                rectangleColor = gameInterface.activeHoverColor;
                        } else {
                            rectangleColor = gameInterface.textColor;
                            if (GameInterface.isHovering(areaId, i) && gameInterface.hoverColor != 0)
                                rectangleColor = gameInterface.hoverColor;
                        }
                        if (opacity == 0) {
                            if (!gameInterface.fill)
                                Rasterizer.drawUnfilledRectangle(absoluteX, absoluteY, gameInterface.width, gameInterface.height, rectangleColor);
                            else
                                Rasterizer.drawFilledRectangle(absoluteX, absoluteY, gameInterface.width, gameInterface.height, rectangleColor);
                        } else if (!gameInterface.fill)
                            Rasterizer.drawUnfilledRectangleAlpha(absoluteX, absoluteY, gameInterface.width, gameInterface.height, rectangleColor, -(0xff & opacity) + 256);
                        else
                            Rasterizer.drawFilledRectangleAlpha(absoluteX, absoluteY, gameInterface.width, gameInterface.height, rectangleColor, -(0xff & opacity) + 256);
                    } else if (gameInterface.type == GameInterfaceType.TEXT) {
                        TypeFace font = gameInterface.getTypeFace();
                        if (font == null) {
                            if (GameInterface.aBoolean2177)
                                result = false;
                        } else {
                            String text = gameInterface.text;
                            int textColor;
                            if (GameInterface.checkForAlternateAction(gameInterface)) {
                                textColor = gameInterface.activeColor;
                                if (GameInterface.isHovering(areaId, i) && gameInterface.activeHoverColor != 0)
                                    textColor = gameInterface.activeHoverColor;
                                if (gameInterface.activeText.length() > 0)
                                    text = gameInterface.activeText;
                            } else {
                                textColor = gameInterface.textColor;
                                if (GameInterface.isHovering(areaId, i) && gameInterface.hoverColor != 0)
                                    textColor = gameInterface.hoverColor;
                            }
                            if (gameInterface.if3 && gameInterface.itemId != -1) {
                                ItemDefinition itemDefinition = ItemDefinition.forId(gameInterface.itemId, 10);
                                text = itemDefinition.name;
                                if (text == null)
                                    text = "null";
                                if (itemDefinition.stackable == 1 || gameInterface.itemAmount != 1)
                                    text = text + Native.amountPrefixX + TextUtils.formatAmountString(gameInterface.itemAmount);
                            }
                            if (gameInterface.buttonType == 6 && MovedStatics.lastContinueTextWidgetId == gameInterface.id) {
                                textColor = gameInterface.textColor;
                                text = English.pleaseWait;
                            }
                            if (Rasterizer.destinationWidth == 479) {
                                if (textColor == 16776960)
                                    textColor = 255;
                                if (textColor == 49152)
                                    textColor = 16777215;
                            }

                            text = ClientScriptRunner.method532(gameInterface, text);
                            font.drawText(text, absoluteX, absoluteY, gameInterface.width, gameInterface.height, textColor, gameInterface.textShadow, gameInterface.textHorizontalAlignment, gameInterface.textVerticalAlignment, gameInterface.textLineHeight);
                        }
                    } else if (gameInterface.type == GameInterfaceType.GRAPHIC) {
                        if (gameInterface.if3) {
                            int maxWidth = 0;
                            int maxHeight = 0;
                            ImageRGB spriteRgb;

                            if (gameInterface.itemId == -1)
                                spriteRgb = gameInterface.getImageRgb(false);
                            else {
                                spriteRgb = ItemDefinition.sprite(gameInterface.itemAmount, gameInterface.itemId, 0);
                                maxWidth = spriteRgb.maxWidth;
                                maxHeight = spriteRgb.maxHeight;

                                // TODO find out why this is done
                                spriteRgb.maxHeight = 32;
                                spriteRgb.maxWidth = 32;
                            }

                            if (spriteRgb != null) {
                                int spriteHeight = spriteRgb.imageHeight;
                                int spriteWidth = spriteRgb.imageWidth;

                                if (gameInterface.tiled) {
                                    int[] viewportDimensions = new int[4];
                                    Rasterizer.getViewportDimensions(viewportDimensions);

                                    // Cap sprite to viewport dimensions
                                    int spriteTopX = absoluteX;
                                    if (viewportDimensions[0] > spriteTopX)
                                        spriteTopX = viewportDimensions[0];
                                    int spriteTopY = absoluteY;
                                    if (viewportDimensions[1] > spriteTopY)
                                        spriteTopY = viewportDimensions[1];
                                    int spriteBottomX = gameInterface.width + absoluteX;
                                    if (viewportDimensions[2] < spriteBottomX)
                                        spriteBottomX = viewportDimensions[2];
                                    int spriteBottomY = gameInterface.height + absoluteY;
                                    if (spriteBottomY > viewportDimensions[3])
                                        spriteBottomY = viewportDimensions[3];

                                    Rasterizer.setBounds(spriteTopX, spriteTopY, spriteBottomX, spriteBottomY);
                                    int i_31_ = (gameInterface.width - (1 + -spriteWidth)) / spriteWidth;
                                    int i_32_ = (gameInterface.height - (1 + -spriteHeight)) / spriteHeight;
                                    for (int row = 0; i_31_ > row; row++) {
                                        for (int col = 0; i_32_ > col; col++) {
                                            if (gameInterface.textureId == 0) {
                                                if (opacity == 0)
                                                    spriteRgb.drawImage(row * spriteWidth + absoluteX, col * spriteHeight + absoluteY);
                                                else
                                                    spriteRgb.drawImageWithOpacity(absoluteX + row * spriteWidth, absoluteY + spriteHeight * col, -(opacity & 0xff) + 256);
                                            } else
                                                spriteRgb.drawImageWithTexture(spriteWidth / 2 + row * spriteWidth + absoluteX, spriteHeight / 2 + absoluteY + spriteHeight * col, gameInterface.textureId, 4096);
                                        }
                                    }
                                    Rasterizer.setViewportDimensions(viewportDimensions);
                                } else {
                                    int i_26_ = 4096 * gameInterface.width / spriteWidth;
                                    if (gameInterface.textureId == 0) {
                                        if (opacity == 0) {
                                            if (gameInterface.width == spriteWidth && gameInterface.height == spriteHeight)
                                                spriteRgb.drawImage(absoluteX, absoluteY);
                                            else
                                                spriteRgb.method732(absoluteX, absoluteY, gameInterface.width, gameInterface.height);
                                        } else
                                            spriteRgb.method716(absoluteX, absoluteY, gameInterface.width, gameInterface.height, 256 + -(0xff & opacity));
                                    } else
                                        spriteRgb.drawImageWithTexture(gameInterface.width / 2 + absoluteX, gameInterface.height / 2 + absoluteY, gameInterface.textureId, i_26_);
                                }
                            } else if (GameInterface.aBoolean2177)
                                result = false;
                            if (gameInterface.itemId != -1) {
                                // TODO find out why this renders when maxWidth == 33
                                if (gameInterface.itemAmount != 1 || maxWidth == 33) {
                                    TypeFace.fontSmall.drawString(Integer.toString(gameInterface.itemAmount), absoluteX + 1, absoluteY + 10, 0);
                                    TypeFace.fontSmall.drawString(Integer.toString(gameInterface.itemAmount), absoluteX, 9 + absoluteY, 16776960);
                                }
                                spriteRgb.maxWidth = maxWidth;
                                spriteRgb.maxHeight = maxHeight;
                            }
                        } else {
                            ImageRGB imageRGB = gameInterface.getImageRgb(GameInterface.checkForAlternateAction(gameInterface));
                            if (imageRGB != null)
                                imageRGB.drawImage(absoluteX, absoluteY);
                            else if (GameInterface.aBoolean2177)
                                result = false;
                        }
                    } else if (gameInterface.type == GameInterfaceType.MODEL) {
                        boolean applyAlternateAction = GameInterface.checkForAlternateAction(gameInterface);
                        int animationId;
                        if (!applyAlternateAction)
                            animationId = gameInterface.modelSeqId;
                        else
                            animationId = gameInterface.activeModelSeqId;

                        Model model;
                        if (gameInterface.modelType != InterfaceModelType.PLAYER) {
                            if (animationId == -1) {
                                model = gameInterface.getModelForInterface(null, -1, applyAlternateAction, Player.localPlayer.playerAppearance);
                            } else {
                                AnimationSequence animationSequence = AnimationSequence.getAnimationSequence(animationId);
                                model = gameInterface.getModelForInterface(animationSequence, gameInterface.animationFrame, applyAlternateAction, Player.localPlayer.playerAppearance);
                            }
                            // TODO FramemapDefinition.aBoolean2177 might be object/model/sprite doesnt exist
                            if (model == null && GameInterface.aBoolean2177)
                                result = false;
                        } else if (gameInterface.modelId != 0) {
                            model = Player.localPlayer.getRotatedModel();
                        } else {
                            model = Player.activePlayerAppearance.getAnimatedModel(null, null, -1, -1);
                        }

                        int rotationX = gameInterface.modelXAngle;
                        int rotationY = gameInterface.modelZAngle;
                        int offsetY2d = gameInterface.modelYOffset;
                        int rotationZ = gameInterface.modelYAngle;
                        int offsetX2d = gameInterface.modelXOffset;
                        int modelZoom = gameInterface.modelZoom;
                        if (gameInterface.itemId != -1) {
                            ItemDefinition itemDefinition = ItemDefinition.forId(gameInterface.itemId, 10);
                            itemDefinition = itemDefinition.method743(gameInterface.itemAmount);
                            model = itemDefinition.asGroundStack(true, 1);
                            rotationY = itemDefinition.zan2d;
                            offsetY2d = itemDefinition.yOffset2d;
                            offsetX2d = itemDefinition.xOffset2d;
                            rotationX = itemDefinition.xan2d;
                            modelZoom = itemDefinition.zoom2d;
                            rotationZ = itemDefinition.yan2d;
                            if (gameInterface.width > 0)
                                modelZoom = 32 * modelZoom / gameInterface.width;
                        }
                        Rasterizer3D.setBounds(absoluteX + gameInterface.width / 2, gameInterface.height / 2 + absoluteY);

                        int camHeight = modelZoom * Rasterizer3D.sinetable[rotationX] >> 16;
                        int camDistance = modelZoom * Rasterizer3D.cosinetable[rotationX] >> 16;
                        if (model != null) {
                            if (gameInterface.if3) {
                                model.method799();
                                // For some reason, drawOrthogonalModel does the same thing as drawModel
                                if (gameInterface.modelOrthographic)
                                    model.drawOrthogonalModel(0, rotationZ, rotationY, rotationX, offsetX2d, offsetY2d + camHeight + model.modelHeight / 2, camDistance + offsetY2d, modelZoom);
                                else
                                    model.drawModel(0, rotationZ, rotationY, rotationX, offsetX2d, offsetY2d + model.modelHeight / 2 + camHeight, camDistance + offsetY2d);
                            } else {
                                model.drawModel(0, rotationZ, 0, rotationX, 0, camHeight, camDistance);
                            }
                        }
                        Rasterizer3D.resetBoundsTo3dViewport();
                    } else {
                        if (gameInterface.type == GameInterfaceType.TEXT_INVENTORY) {
                            TypeFace font = gameInterface.getTypeFace();
                            if (font == null) {
                                if (GameInterface.aBoolean2177)
                                    result = false;
                                continue;
                            }
                            int itemSlot = 0;
                            for (int row = 0; row < gameInterface.height; row++) {
                                for (int col = 0; col < gameInterface.width; col++) {
                                    if (gameInterface.invSlotObjId[itemSlot] > 0) {
                                        ItemDefinition itemDefinition = ItemDefinition.forId(-1 + gameInterface.invSlotObjId[itemSlot], 10);
                                        String itemName = itemDefinition.name;
                                        if (itemName == null)
                                            itemName = "null";
                                        if (itemDefinition.stackable == 1 || gameInterface.invSlotObjCount[itemSlot] != 1)
                                            itemName = itemName + Native.amountPrefixX + TextUtils.formatAmountString(gameInterface.invSlotObjCount[itemSlot]);
                                        int itemX = col * (gameInterface.invMarginX + 115) + absoluteX;
                                        int itemY = row * (gameInterface.invMarginY + 12) + absoluteY;
                                        if (gameInterface.textHorizontalAlignment == 0)
                                            font.drawShadowedString(itemName, itemX, itemY, gameInterface.textShadow, gameInterface.textColor);
                                        else if (gameInterface.textHorizontalAlignment == 1)
                                            font.drawShadowedStringCenter(itemName, itemX + gameInterface.width / 2, itemY, gameInterface.textColor, gameInterface.textShadow);
                                        else
                                            font.drawShadowedStringRight(itemName, -1 + gameInterface.width + itemX, itemY, gameInterface.textColor, gameInterface.textShadow);
                                    }
                                    itemSlot++;
                                }
                            }
                        }
                        if (gameInterface.type == GameInterfaceType.IF1_TOOLTIP && MovedStatics.method438(areaId, i) && MovedStatics.tooltipDelay == MovedStatics.durationHoveredOverWidget) {
                            int textWidth = 0;
                            int textHeight = 0;
                            TypeFace class40_sub5_sub14_sub1 = MovedStatics.fontNormal;
                            String text = gameInterface.text;
                            text = ClientScriptRunner.method532(gameInterface, text);
                            while (text.length() > 0) {
                                int lineBreakCharacter = text.indexOf(Native.lineBreak);
                                String textLine;
                                if (lineBreakCharacter == -1) {
                                    // Not a multiline text
                                    textLine = text;
                                    text = "";
                                } else {
                                    // Multiline text
                                    textLine = text.substring(0, lineBreakCharacter);
                                    text = text.substring(2 + lineBreakCharacter);
                                }
                                int lineWidth = class40_sub5_sub14_sub1.getTextDisplayedWidth(textLine);
                                textHeight += class40_sub5_sub14_sub1.characterDefaultHeight + 1;
                                if (textWidth < lineWidth)
                                    textWidth = lineWidth;
                            }
                            textHeight += 7;
                            int tooltipY = 5 + gameInterface.height + absoluteY;
                            if (tooltipY + textHeight > maxY)
                                tooltipY = maxY + -textHeight;
                            textWidth += 6;
                            int tooltipX = -5 + gameInterface.width + absoluteX - textWidth;
                            if (tooltipX < 5 + absoluteX)
                                tooltipX = 5 + absoluteX;
                            if (textWidth + tooltipX > maxX)
                                tooltipX = -textWidth + maxX;
                            Rasterizer.drawFilledRectangle(tooltipX, tooltipY, textWidth, textHeight, 16777120);
                            Rasterizer.drawUnfilledRectangle(tooltipX, tooltipY, textWidth, textHeight, 0);
                            text = gameInterface.text;
                            int tooltipTitleY = 2 + tooltipY + class40_sub5_sub14_sub1.characterDefaultHeight;
                            text = ClientScriptRunner.method532(gameInterface, text);
                            while (text.length() > 0) {
                                int lineBreakCharacter = text.indexOf(Native.lineBreak);
                                String textLine;
                                if (lineBreakCharacter == -1) {
                                    textLine = text;
                                    text = "";
                                } else {
                                    textLine = text.substring(0, lineBreakCharacter);
                                    text = text.substring(lineBreakCharacter + 2);
                                }
                                class40_sub5_sub14_sub1.drawShadowedString(textLine, tooltipX + 3, tooltipTitleY, false, 0);
                                tooltipTitleY += 1 + class40_sub5_sub14_sub1.characterDefaultHeight;
                            }
                        }
                        if (gameInterface.type == GameInterfaceType.LINE)
                            Rasterizer.drawDiagonalLine(absoluteX, absoluteY, gameInterface.width + absoluteX, gameInterface.height + absoluteY, gameInterface.textColor);
                    }

                    // Draw debug information for non layer widgets and non tooltip widgets
                    if (Configuration.DEBUG_WIDGETS && gameInterface.type != GameInterfaceType.LAYER && gameInterface.type != GameInterfaceType.IF1_TOOLTIP && MovedStatics.hoveredWidgetId == gameInterface.id) {
                        Rasterizer.drawUnfilledRectangle(absoluteX, absoluteY, gameInterface.width, gameInterface.height, 0xffff00);
                    }
                }
            }
        }
        return result;
    }


    public static void setConfigToDefaults() {
        lastClickTime = 0L;
        mouseCapturer.coord = 0;
        duplicateClickCount = 0;
        lastFocusTrackWasFocused = true;
        isClientFocused = true;
        ClientScriptRunner.clearClientScriptRunnerCache();
        IncomingPackets.secondLastOpcode = -1;
        MovedStatics.menuOpen = false;
        IncomingPackets.lastOpcode = -1;
        IncomingPackets.opcode = -1;
        MovedStatics.systemUpdateTime = 0;
        IncomingPackets.cyclesSinceLastPacket = 0;
        currentHintIconType = 0;
        OutgoingPackets.buffer.currentPosition = 0;
        idleLogout = 0;
        IncomingPackets.thirdLastOpcode = -1;
        IncomingPackets.incomingPacketBuffer.currentPosition = 0;
        MovedStatics.menuActionRow = 0;
        MouseHandler.setFramesSinceMouseInput(0);
        for (int i = 0; i < 100; i++)
            ChatBox.chatMessages[i] = null;
        GameInterface.itemCurrentlySelected = 0;
        MovedStatics.destinationX = 0;
        Minimap.minimapLevel = -1;
        Player.npcCount = 0;
        SoundSystem.reset();
        widgetSelected = 0;
        // TODO is this necessary? or should it be removed alongside other randomisation
        Game.playerCamera.setYaw(0x7ff & -10 + (int) (20.0 * Math.random()));
        Minimap.minimapState = 0;
        Player.localPlayerCount = 0;
        destinationY = 0;
        for (int i = 0; i < 2048; i++) {
            Player.trackedPlayers[i] = null;
            Player.trackedPlayerAppearanceCache[i] = null;
        }
        for (int i = 0; i < 32768; i++)
            Player.npcs[i] = null;
        Player.localPlayer = Player.trackedPlayers[2047] = new Player();
        MovedStatics.projectileQueue.clear();
        MovedStatics.spotAnimQueue.clear();
        for (int i = 0; i < 4; i++) {
            for (int i_82_ = 0; i_82_ < 104; i_82_++) {
                for (int i_83_ = 0; i_83_ < 104; i_83_++)
                    MovedStatics.groundItems[i][i_82_][i_83_] = null;
            }
        }
        MovedStatics.interactiveObjectTemporaryNodeCache = new LinkedList();

        // friends list size depends on membership status
        int friendsListSize = MovedStatics.isLocalPlayerMember == 1 ? 200 : 100;
        Game.friendList = new FriendList(200, friendsListSize);

        Player.friendListStatus = 0;
        GameInterface.resetInterface(ChatBox.dialogueId);
        ChatBox.dialogueId = -1;
        GameInterface.resetInterface(GameInterface.chatboxInterfaceId);
        GameInterface.chatboxInterfaceId = -1;
        GameInterface.resetInterface(GameInterface.gameScreenInterfaceId);
        GameInterface.gameScreenInterfaceId = -1;
        GameInterface.resetInterface(GameInterface.fullscreenInterfaceId);
        GameInterface.fullscreenInterfaceId = -1;
        GameInterface.resetInterface(GameInterface.fullscreenSiblingInterfaceId);
        GameInterface.fullscreenSiblingInterfaceId = -1;
        GameInterface.resetInterface(GameInterface.tabAreaInterfaceId);
        GameInterface.tabAreaInterfaceId = -1;
        GameInterface.resetInterface(GameInterface.walkableWidgetId);
        ChatBox.inputType = 0;
        ChatBox.messagePromptRaised = false;
        MovedStatics.menuOpen = false;
        GameInterface.walkableWidgetId = -1;
        Native.clickToContinueString = null;
        MovedStatics.lastContinueTextWidgetId = -1;
        flashingTabId = -1;
        MovedStatics.multiCombatState = 0;
        currentTabId = 3;
        Player.activePlayerAppearance.setPlayerAppearance(null, false, new int[5], -1);
        for (int i = 0; i < 5; i++) {
            Player.playerActions[i] = null;
            Player.playerActionsLowPriority[i] = false;
        }
        isLoadingUpdates = true;
    }

    public Game(String[] args) {
        Configuration.read();
        Native.username = Configuration.getUsername();
        Native.password = Configuration.getPassword();
        String[] params = new String[]{"1", "live", "live", "highmem", "members"};
        if (args.length != 0) {
            params = args;
        }
        if (params.length != 5) {
            Game.printHelp();
        }

        Player.worldId = Integer.parseInt(params[0]);

        // Location argument (to set server IP based on JMod location?)
        switch (params[1]) {
            case "live":
                Game.modewhere = 0;
                break;
            case "office":
                Game.modewhere = 1;
                break;
            case "local":
                Game.modewhere = 2;
                break;
            default:
                Game.printHelp();
                break;
        }

        switch (params[2]) {
            case "live":
                Game.modewhat = 0;
                break;
            case "rc":
                Game.modewhat = 1;
                break;
            case "wip":
                Game.modewhat = 2;
                break;
            default:
                Game.printHelp();
                break;
        }
        // Memory argument
        switch (params[3]) {
            case "lowmem":
                Game.setLowMemory();
                break;
            case "highmem":
                MovedStatics.setHighMemory();
                break;
            default:
                Game.printHelp();
                break;
        }

        // Memory argument
        switch (params[4]) {
            case "free":
                MovedStatics.membersWorld = false;
                break;
            case "members":
                MovedStatics.membersWorld = true;

                break;
            default:
                Game.printHelp();
                break;
        }
    }

    public static void method353() {
        MovedStatics.anInt2628++;
        renderPlayers(0, true);
        renderNPCs(true);
        renderPlayers(0, false);
        renderNPCs(false);
        renderProjectiles();
        renderSpotAnims();
        if (!Player.cutsceneActive) {
            int pitch = Game.playerCamera.getPitch();
            if (SceneCamera.cameraTerrainMinScaledPitch / 256 > pitch) {
                pitch = SceneCamera.cameraTerrainMinScaledPitch / 256;
            }

            if (SceneCamera.customCameraActive[4] && 128 + SceneCamera.customCameraAmplitude[4] > pitch) {
                pitch = 128 + SceneCamera.customCameraAmplitude[4];
            }

            Game.playerCamera.setPitch(pitch);
        }

        int plane;
        if (!Player.cutsceneActive) {
            plane = MovedStatics.getGameCameraPlane();
        } else {
            plane = MovedStatics.getCutsceneCameraPlane();
        }

        Camera activeCamera = getActiveCamera();

        Point3d shakeOffsetPosition = new Point3d(0, 0, 0);
        CameraRotation shakeOffsetRotation = new CameraRotation(0, 0);

        for (int cameraType = 0; cameraType < 5; cameraType++) {
            if (SceneCamera.customCameraActive[cameraType]) {
                int shakeAmount = (int) ((double) (SceneCamera.customCameraJitter[cameraType] * 2 + 1) * Math.random() - (double) SceneCamera.customCameraJitter[cameraType] + Math.sin((double) SceneCamera.customCameraTimer[cameraType] * ((double) SceneCamera.customCameraFrequency[cameraType] / 100.0)) * (double) SceneCamera.customCameraAmplitude[cameraType]);
                if (cameraType == 1) {
                    shakeOffsetPosition = shakeOffsetPosition.addZ(shakeAmount);
                }
                if (cameraType == 0) {
                    shakeOffsetPosition = shakeOffsetPosition.addX(shakeAmount);
                }
                if (cameraType == 2) {
                    shakeOffsetPosition = shakeOffsetPosition.addY(shakeAmount);
                }
                if (cameraType == 4) {
                    shakeOffsetRotation = shakeOffsetRotation.addPitch(shakeAmount);
                }
                if (cameraType == 3) {
                    shakeOffsetRotation = shakeOffsetRotation.addYaw(shakeAmount);
                }
            }
        }

        activeCamera.setOffsetPosition(shakeOffsetPosition);
        activeCamera.setOffsetRotation(shakeOffsetRotation);

        MovedStatics.method1018();
        MouseHandler.cursorY = MouseHandler.mouseY - 4;
        MouseHandler.gameScreenClickable = true;
        MouseHandler.cursorX = MouseHandler.mouseX - 4;
        Model.resourceCount = 0;
        Rasterizer.resetPixels();

        sceneRenderer.render(activeCamera, plane);
        currentScene.clearInteractiveObjectCache();
        MovedStatics.draw2DActorAttachments();
        MovedStatics.drawPositionHintIcon();
        ((Class35) Rasterizer3D.interface3).animateTextures(deltaT);
        MovedStatics.draw3dScreen();

        DebugTools.drawWalkPath();
        DebugTools.drawClipping();

        if (ScreenController.frameMode == ScreenMode.FIXED) {
            Console.console.drawConsole(512, 334);
            Console.console.drawConsoleArea(512, 334);
        } else {
            ScreenController.RenderResizableUI();
            Console.console.drawConsole(ScreenController.drawWidth, 334);
            Console.console.drawConsoleArea(ScreenController.drawWidth, 334);
        }


        if (isLoadingUpdates && updateServerConnectionManager.updateServer.getActiveTaskCount(false, true) == 0) {
            isLoadingUpdates = false;
        }
        if (isLoadingUpdates) {
            MovedStatics.method1018();
            Rasterizer.resetPixels();
            MovedStatics.drawLoadingBox(English.loadingPleaseWait, null, false);
        }

        MovedStatics.drawGameScreenGraphics();
    }

    /**
     * Get the currently active camera.
     */
    public static Camera getActiveCamera() {
        return Player.cutsceneActive ? Game.cutsceneCamera : Game.playerCamera;
    }

    public static IndexedImage method359(String arg0, String always_empty, CacheArchive arg2) {
        int i = arg2.getGroupIdByName(arg0);
        int i_23_ = arg2.getFileIdByName(i, always_empty);
        return method363(arg2, i, i_23_);
    }

    public static IndexedImage method363(CacheArchive archive, int groupId, int fileId) {
        if (!MovedStatics.decodeImageFromArchive(archive, groupId, fileId)) {
            return null;
        }
        return MovedStatics.createIndexedImageFromDecodedData();

    }

    public static void drawGameScreen() {
        if (MovedStatics.clearScreen) {
            MovedStatics.clearScreen = false;
            MovedStatics.drawWelcomeScreenGraphics();
            GameInterface.drawTabIcons = true;
            ChatBox.redrawChatbox = true;
            GameInterface.redrawTabArea = true;
            MovedStatics.redrawChatbox = true;
            drawCount++;
        } else if (drawCount != 0) {
            MovedStatics.method763(gameCanvas, CacheArchive.gameImageCacheArchive);
        }
        if (GameInterface.chatboxInterfaceId == -1) {
            chatboxInterface.scrollY = -77 + -ChatBox.chatboxScroll + ChatBox.chatboxScrollMax;
            if (MouseHandler.mouseX > 448 && MouseHandler.mouseX < 560 && MouseHandler.mouseY > 332) {
                GameInterface.scrollInterface(77, MouseHandler.mouseY + -357, -17 + MouseHandler.mouseX, ChatBox.chatboxScrollMax, chatboxInterface, 463, -1, 0);
            }
            int currentScroll = ChatBox.chatboxScrollMax - 77 - chatboxInterface.scrollY;
            if (currentScroll < 0) {
                currentScroll = 0;
            }
            if (currentScroll > ChatBox.chatboxScrollMax + -77) {
                currentScroll = -77 + ChatBox.chatboxScrollMax;
            }
            if (currentScroll != ChatBox.chatboxScroll) {
                ChatBox.chatboxScroll = currentScroll;
                ChatBox.redrawChatbox = true;
            }
        }
        if (GameInterface.chatboxInterfaceId == -1 && ChatBox.inputType == 3) {
            chatboxInterface.scrollY = ChatBox.itemSearchScroll;
            int scrollMax = 14 * ChatBox.itemSearchResultCount + 7;
            if (MouseHandler.mouseX > 448 && MouseHandler.mouseX < 560 && MouseHandler.mouseY > 332) {
                GameInterface.scrollInterface(77, MouseHandler.mouseY - 357, -17 + MouseHandler.mouseX, scrollMax, chatboxInterface, 463, -1, 0);
            }
            int currentScroll = chatboxInterface.scrollY;
            if (currentScroll < 0) {
                currentScroll = 0;
            }
            if (currentScroll > scrollMax - 77) {
                currentScroll = scrollMax - 77;
            }
            if (currentScroll != ChatBox.itemSearchScroll) {
                ChatBox.itemSearchScroll = currentScroll;
                ChatBox.redrawChatbox = true;
            }
        }

        if (GameInterface.tabAreaInterfaceId != -1) {
            boolean bool = GameInterface.handleSequences(GameInterface.tabAreaInterfaceId);
            if (bool) {
                GameInterface.redrawTabArea = true;
            }
        }

        if (GameInterface.chatboxInterfaceId != -1) {
            boolean bool = GameInterface.handleSequences(GameInterface.chatboxInterfaceId);
            if (bool) {
                ChatBox.redrawChatbox = true;
            }
        }

        if (ChatBox.dialogueId != -1) {
            boolean bool = GameInterface.handleSequences(ChatBox.dialogueId);
            if (bool) {
                ChatBox.redrawChatbox = true;
            }
        }

        if (flashingTabId != -1) {
            GameInterface.drawTabIcons = true;
        }

        if (ScreenController.frameMode == ScreenMode.FIXED) {

            if (MovedStatics.menuOpen && MovedStatics.menuScreenArea == 1) {
                GameInterface.redrawTabArea = true;
            }
            method353();

            if (GameInterface.atInventoryInterfaceType == -3) {
                GameInterface.redrawTabArea = true;
            }
            if (GameInterface.activeInterfaceType == 2) {
                GameInterface.redrawTabArea = true;
            }
            MovedStatics.drawTabArea();

            if (GameInterface.atInventoryInterfaceType == 3) {
                ChatBox.redrawChatbox = true;
            }
            if (GameInterface.activeInterfaceType == 3) {
                ChatBox.redrawChatbox = true;
            }
            if (Native.clickToContinueString != null) {
                ChatBox.redrawChatbox = true;
            }
            if (MovedStatics.menuOpen && MovedStatics.menuScreenArea == 2) {
                ChatBox.redrawChatbox = true;
            }
            if (ChatBox.redrawChatbox) {
                ChatBox.redrawChatbox = false;
                ChatBox.renderChatbox();
                //            Console.console.drawConsoleArea();
            }

            Minimap.renderMinimap();

            if (GameInterface.drawTabIcons) {
                if (flashingTabId != -1 && flashingTabId == currentTabId) {
                    flashingTabId = -1;
                    OutgoingPackets.sendMessage(new ClickFlashingTabIconOutboundMessage(currentTabId));
                }
                GameInterface.drawTabIcons = false;
                MovedStatics.showIconsRedrawnText = true;
                MovedStatics.method527(currentTabId, tabWidgetIds, GameInterface.tabAreaInterfaceId == -1, MovedStatics.pulseCycle % 20 >= 10 ? flashingTabId : -1);
            }
            if (MovedStatics.redrawChatbox) {
                MovedStatics.showIconsRedrawnText = true;
                MovedStatics.redrawChatbox = false;
                method943(ChatBox.tradeMode, MovedStatics.fontNormal, ChatBox.privateChatMode, ChatBox.publicChatMode);
            }

            SoundSystem.updateObjectSounds(Player.localPlayer.worldX, Player.worldLevel, deltaT, Player.localPlayer.worldY);
            deltaT = 0;

        } else {
            method353();
            ChatBox.renderChatbox();

            MovedStatics.drawTabArea();

            // this render is  handled in `ResizableFrameRenderer`
            //Minimap.renderMinimap();

            if (GameInterface.drawTabIcons) {
                if (flashingTabId != -1 && flashingTabId == currentTabId) {
                    flashingTabId = -1;
                    OutgoingPackets.sendMessage(new ClickFlashingTabIconOutboundMessage(currentTabId));
                }
                GameInterface.drawTabIcons = false;
                MovedStatics.showIconsRedrawnText = true;
                MovedStatics.method527(currentTabId, tabWidgetIds, GameInterface.tabAreaInterfaceId == -1, MovedStatics.pulseCycle % 20 >= 10 ? flashingTabId : -1);
            }
            if (MovedStatics.redrawChatbox) {
                MovedStatics.showIconsRedrawnText = true;
                MovedStatics.redrawChatbox = false;
                method943(ChatBox.tradeMode, MovedStatics.fontNormal, ChatBox.privateChatMode, ChatBox.publicChatMode);
            }

            SoundSystem.updateObjectSounds(Player.localPlayer.worldX, Player.worldLevel, deltaT, Player.localPlayer.worldY);
            deltaT = 0;
        }

    }

    public static void drawFullScreenWidget() {
        GameInterface.handleSequences(GameInterface.fullscreenInterfaceId);
        if (GameInterface.fullscreenSiblingInterfaceId != -1)
            GameInterface.handleSequences(GameInterface.fullscreenSiblingInterfaceId);
        deltaT = 0;
        MovedStatics.aProducingGraphicsBuffer_2213.prepareRasterizer();
        Player.viewportOffsets = Rasterizer3D.setLineOffsets(Player.viewportOffsets);
        Rasterizer.resetPixels();
        drawParentInterface(0, 0, 0, 765, 503, GameInterface.fullscreenInterfaceId);
        if (GameInterface.fullscreenSiblingInterfaceId != -1)
            drawParentInterface(0, 0, 0, 765, 503, GameInterface.fullscreenSiblingInterfaceId);
        if (!MovedStatics.menuOpen) {
            MovedStatics.processRightClick();
            MovedStatics.drawMenuTooltip(4);
        } else if (ScreenController.frameMode == ScreenMode.FIXED && MovedStatics.menuScreenArea == 0) {
            MovedStatics.drawMenu(4, 4); // might be 0,0
        }
        try {
            Graphics graphics = gameCanvas.getGraphics();
            MovedStatics.aProducingGraphicsBuffer_2213.drawGraphics(0, 0, graphics);
        } catch (Exception exception) {
            gameCanvas.repaint();
        }
    }

    public static void moveTowardsTarget() {
        // TODO (James) this moves the cutscene camera towards its target, we should move this into the CutsceneCamera class
        CutsceneCamera camera = Game.cutsceneCamera;

        int i = camera.getMoveTo().y;
        int i_3_ = camera.getMoveTo().x;
        int i_4_ = Game.currentScene.getFloorDrawHeight(Player.worldLevel, i_3_, i) - camera.getMoveTo().z;

        int newX = camera.getPosition().x;
        int newY = camera.getPosition().y;
        int newZ = camera.getPosition().z;

        if (i_3_ > newX) {
            newX += camera.getMovementSpeed().scale * (i_3_ - newX) / 1000 + camera.getMovementSpeed().base;
            if (newX > i_3_) {
                newX = i_3_;
            }
        }
        if (i_4_ > newZ) {
            newZ += camera.getMovementSpeed().scale * (i_4_ - newZ) / 1000 + camera.getMovementSpeed().base;
            if (i_4_ < newZ)
                newZ = i_4_;
        }
        if (newX > i_3_) {
            newX -= camera.getMovementSpeed().base + camera.getMovementSpeed().scale * (newX + -i_3_) / 1000;
            if (i_3_ > newX) {
                newX = i_3_;
            }
        }
        if (newY < i) {
            newY += camera.getMovementSpeed().base + camera.getMovementSpeed().scale * (-newY + i) / 1000;
            if (newY > i)
                newY = i;
        }
        if (newZ > i_4_) {
            newZ -= (newZ + -i_4_) * camera.getMovementSpeed().scale / 1000 + camera.getMovementSpeed().base;
            if (i_4_ > newZ)
                newZ = i_4_;
        }
        if (newY > i) {
            newY -= camera.getMovementSpeed().base + camera.getMovementSpeed().scale * (newY - i) / 1000;
            if (newY < i)
                newY = i;
        }

        camera.setPosition(new Point3d(newX, newY, newZ));

        i_3_ = camera.getLookAt().x;
        i = camera.getLookAt().y;
        i_4_ = Game.currentScene.getFloorDrawHeight(Player.worldLevel, i_3_, i) - camera.getLookAt().z;
        int i_5_ = -newZ + i_4_;
        int i_6_ = i - newY;
        int i_7_ = i_3_ - newX;
        int i_8_ = (int) Math.sqrt((double) (i_7_ * i_7_ + i_6_ * i_6_));
        int i_9_ = 0x7ff & (int) (Math.atan2((double) i_5_, (double) i_8_) * 325.949);
        if (i_9_ < 128)
            i_9_ = 128;
        int i_10_ = 0x7ff & (int) (-325.949 * Math.atan2((double) i_7_, (double) i_6_));
        if (i_9_ > 383)
            i_9_ = 383;
        int i_11_ = -camera.getRotation().yaw + i_10_;
        if (i_11_ > 1024)
            i_11_ -= 2048;
        if (i_11_ < -1024)
            i_11_ += 2048;

        int newYaw = camera.getRotation().yaw;
        int newPitch = camera.getRotation().pitch;

        if (i_11_ > 0) {
            newYaw += camera.getTurnSpeed().scale * i_11_ / 1000 + camera.getTurnSpeed().base;
            newYaw &= 0x7ff;
        }
        if (true) {
            if (i_11_ < 0) {
                newYaw -= camera.getTurnSpeed().base + camera.getTurnSpeed().scale * -i_11_ / 1000;
                newYaw &= 0x7ff;
            }
            if (i_9_ > newPitch) {
                newPitch += camera.getTurnSpeed().base + camera.getTurnSpeed().scale * (i_9_ - newPitch) / 1000;
                if (newPitch > i_9_)
                    newPitch = i_9_;
            }
            if (newPitch > i_9_) {
                newPitch -= camera.getTurnSpeed().scale * (newPitch + -i_9_) / 1000 + camera.getTurnSpeed().base;
                if (newPitch < i_9_)
                    newPitch = i_9_;
            }
            int i_12_ = i_10_ + -newYaw;
            if (i_12_ > 1024)
                i_12_ -= 2048;
            if (i_12_ < -1024)
                i_12_ += 2048;
            if (i_12_ < 0 && i_11_ > 0 || i_12_ > 0 && i_11_ < 0)
                newYaw = i_10_;
        }

        camera.rotate(newYaw, newPitch);
    }

    public static void updateGame() {
        if (MovedStatics.systemUpdateTime > 1)
            MovedStatics.systemUpdateTime--;
        if (idleLogout > 0)
            idleLogout--;
        if (aBoolean871) {
            aBoolean871 = false;
            dropClient();
        } else {
            for (int i = 0; i < 100; i++) {
                if (!IncomingPackets.parseIncomingPackets())
                    break;
            }
            if (gameStatusCode == 30 || gameStatusCode == 35) {
                if (isLoadingUpdates && gameStatusCode == 30) {
                    MouseHandler.currentMouseButtonPressed = 0;
                    MouseHandler.clickType = 0;
                    while (MovedStatics.method416()) {
                        /* empty */
                    }
                    for (int i = 0; i < MovedStatics.obfuscatedKeyStatus.length; i++)
                        MovedStatics.obfuscatedKeyStatus[i] = false;
                }
                ClientScriptRunner.createClientScriptCheckPacket(205, OutgoingPackets.buffer);
                synchronized (mouseCapturer.objectLock) {
                    if (accountFlagged) {
                        if (MouseHandler.clickType != 0 || mouseCapturer.coord >= 40) {
                            int coordinateCount = 0;
                            OutgoingPackets.buffer.putPacket(210);
                            OutgoingPackets.buffer.putByte(0);
                            int originalOffset = OutgoingPackets.buffer.currentPosition;
                            for (int c = 0; c < mouseCapturer.coord; c++) {
                                if (-originalOffset + OutgoingPackets.buffer.currentPosition >= 240)
                                    break;
                                coordinateCount++;
                                int pixelOffset = mouseCapturer.coordsY[c];
                                if (pixelOffset >= 0) {
                                    if (pixelOffset > 502)
                                        pixelOffset = 502;
                                } else
                                    pixelOffset = 0;
                                int x = mouseCapturer.coordsX[c];
                                if (x < 0)
                                    x = 0;
                                else if (x > 764)
                                    x = 764;
                                int y = pixelOffset * 765 + x;
                                if (mouseCapturer.coordsY[c] == -1 && mouseCapturer.coordsX[c] == -1) {
                                    x = -1;
                                    y = -1;
                                    pixelOffset = 0x7ffff;
                                }
                                if (x == lastClickX && y == lastClickY) {
                                    if (duplicateClickCount < 2047)
                                        duplicateClickCount++;
                                } else {
                                    int differenceX = x - lastClickX;
                                    lastClickX = x;
                                    int differenceY = pixelOffset - lastClickY;
                                    lastClickY = pixelOffset;
                                    if (duplicateClickCount < 8 && differenceX >= -32 && differenceX <= 31 && differenceY >= -32 && differenceY <= 31) {
                                        differenceX += 32;
                                        differenceY += 32;
                                        OutgoingPackets.buffer.putShortBE(differenceY + (differenceX << 6) + (duplicateClickCount << 12));
                                        duplicateClickCount = 0;
                                    } else if (duplicateClickCount < 8) {
                                        OutgoingPackets.buffer.putMediumBE(y + 8388608 + (duplicateClickCount << 19));
                                        duplicateClickCount = 0;
                                    } else {
                                        OutgoingPackets.buffer.putIntBE((duplicateClickCount << 19) + -1073741824 + y);
                                        duplicateClickCount = 0;
                                    }
                                }
                            }
                            OutgoingPackets.buffer.finishVarByte(OutgoingPackets.buffer.currentPosition + -originalOffset);
                            if (coordinateCount < mouseCapturer.coord) {
                                mouseCapturer.coord -= coordinateCount;
                                for (int i_9_ = 0; mouseCapturer.coord > i_9_; i_9_++) {
                                    mouseCapturer.coordsX[i_9_] = mouseCapturer.coordsX[coordinateCount + i_9_];
                                    mouseCapturer.coordsY[i_9_] = mouseCapturer.coordsY[i_9_ + coordinateCount];
                                }
                            } else
                                mouseCapturer.coord = 0;
                        }
                    } else {
                        mouseCapturer.coord = 0;
                    }
                }
                if (MouseHandler.clickType != 0) {
                    long delta = (MouseHandler.clickTime - lastClickTime) / 50L;
                    int i = MouseHandler.clickX;
                    int i_10_ = MouseHandler.clickY;
                    lastClickTime = MouseHandler.clickTime;
                    if (i >= 0) {
                        if (i > 764)
                            i = 764;
                    } else
                        i = 0;
                    if (i_10_ >= 0) {
                        if (i_10_ > 502)
                            i_10_ = 502;
                    } else
                        i_10_ = 0;
                    int i_11_ = 0;
                    if (MouseHandler.clickType == 2)
                        i_11_ = 1;
                    if (delta > 4095)
                        delta = 4095L;
                    int i_12_ = (int) delta;
                    OutgoingPackets.buffer.putPacket(234);
                    int i_13_ = i_10_ * 765 + i;
                    OutgoingPackets.buffer.putIntLE((i_11_ << 19) + (i_12_ << 20) + i_13_);
                }
                if (MovedStatics.anInt487 > 0)
                    MovedStatics.anInt487--;
                if (MovedStatics.obfuscatedKeyStatus[96] || MovedStatics.obfuscatedKeyStatus[97] || MovedStatics.obfuscatedKeyStatus[98] || MovedStatics.obfuscatedKeyStatus[99])
                    MovedStatics.aBoolean565 = true;
                if (MovedStatics.aBoolean565 && MovedStatics.anInt487 <= 0) {
                    MovedStatics.anInt487 = 20;
                    MovedStatics.aBoolean565 = false;
                    OutgoingPackets.buffer.putPacket(58);
                    OutgoingPackets.buffer.putShortBE(Game.playerCamera.getYaw());
                    OutgoingPackets.buffer.putShortBE(Game.playerCamera.getPitch());
                }
                if (isClientFocused && !lastFocusTrackWasFocused) {
                    lastFocusTrackWasFocused = true;
                    OutgoingPackets.buffer.putPacket(160);
                    OutgoingPackets.buffer.putByte(1);
                }
                if (!isClientFocused && lastFocusTrackWasFocused) {
                    lastFocusTrackWasFocused = false;
                    OutgoingPackets.buffer.putPacket(160);
                    OutgoingPackets.buffer.putByte(0);
                }
                method910();
                if (gameStatusCode == 30 || gameStatusCode == 35) {
                    MovedStatics.tickTemporaryObjects();
                    SoundSystem.processSounds();
                    MusicSystem.processMusic();
                    IncomingPackets.cyclesSinceLastPacket++;
                    if (IncomingPackets.cyclesSinceLastPacket > 750) {
                        dropClient();
                    } else {
                        MovedStatics.animatePlayers(-1);
                        MovedStatics.animateNpcs();
                        Actor.tickChatTimers();
                        if (MovedStatics.crossType != 0) {
                            MovedStatics.crossIndex += 20;
                            if (MovedStatics.crossIndex >= 400)
                                MovedStatics.crossType = 0;
                        }
                        if (GameInterface.atInventoryInterfaceType != 0) {
                            GameInterface.anInt1651++;
                            if (GameInterface.anInt1651 >= 15) {
                                if (GameInterface.atInventoryInterfaceType == 2)
                                    GameInterface.redrawTabArea = true;
                                if (GameInterface.atInventoryInterfaceType == 3)
                                    ChatBox.redrawChatbox = true;
                                GameInterface.atInventoryInterfaceType = 0;
                            }
                        }
                        deltaT++;
                        if (GameInterface.activeInterfaceType != 0) {
                            GameInterface.lastItemDragTime++;
                            if (MouseHandler.mouseX > MovedStatics.anInt2869 + 5 || MovedStatics.anInt2869 + -5 > MouseHandler.mouseX || MovedStatics.anInt2798 + 5 < MouseHandler.mouseY || MovedStatics.anInt2798 - 5 > MouseHandler.mouseY)
                                MovedStatics.lastItemDragged = true;
                            if (MouseHandler.currentMouseButtonPressed == 0) {
                                if (GameInterface.activeInterfaceType == 3)
                                    ChatBox.redrawChatbox = true;
                                if (GameInterface.activeInterfaceType == 2)
                                    GameInterface.redrawTabArea = true;
                                GameInterface.activeInterfaceType = 0;
                                if (MovedStatics.lastItemDragged && GameInterface.lastItemDragTime >= 5) {
                                    GameInterface.lastActiveInvInterface = -1;
                                    MovedStatics.processRightClick();
                                    if (GameInterface.lastActiveInvInterface == GameInterface.modifiedWidgetId && mouseInvInterfaceIndex != GameInterface.selectedInventorySlot) {
                                        GameInterface childInterface = GameInterface.getInterface(GameInterface.modifiedWidgetId);
                                        int moveItemInsertionMode = 0;
                                        if (MovedStatics.bankInsertMode == 1 && childInterface.contentType == 206)
                                            moveItemInsertionMode = 1;
                                        if (childInterface.invSlotObjId[mouseInvInterfaceIndex] <= 0)
                                            moveItemInsertionMode = 0;
                                        if (childInterface.invClearDragged) {
                                            int i_16_ = mouseInvInterfaceIndex;
                                            int i_17_ = GameInterface.selectedInventorySlot;
                                            childInterface.invSlotObjId[i_16_] = childInterface.invSlotObjId[i_17_];
                                            childInterface.invSlotObjCount[i_16_] = childInterface.invSlotObjCount[i_17_];
                                            childInterface.invSlotObjId[i_17_] = -1;
                                            childInterface.invSlotObjCount[i_17_] = 0;
                                        } else if (moveItemInsertionMode == 1) {
                                            int slotStart = GameInterface.selectedInventorySlot;
                                            int slotEnd = mouseInvInterfaceIndex;
                                            while (slotEnd != slotStart) {
                                                if (slotStart <= slotEnd) {
                                                    if (slotStart < slotEnd) {
                                                        childInterface.swapItems(1 + slotStart, false, slotStart);
                                                        slotStart++;
                                                    }
                                                } else {
                                                    childInterface.swapItems(-1 + slotStart, false, slotStart);
                                                    slotStart--;
                                                }
                                            }
                                        } else
                                            childInterface.swapItems(mouseInvInterfaceIndex, false, GameInterface.selectedInventorySlot);

                                        OutgoingPackets.sendMessage(new DragWidgetItemOutboundMessage(
                                                moveItemInsertionMode,
                                                GameInterface.modifiedWidgetId,
                                                GameInterface.selectedInventorySlot,
                                                mouseInvInterfaceIndex
                                        ));
                                    }
                                } else {
                                    if ((oneMouseButton == 1 || MovedStatics.menuHasAddFriend(MovedStatics.menuActionRow - 1)) && MovedStatics.menuActionRow > 2)
                                        MovedStatics.determineMenuSize();
                                    else if (MovedStatics.menuActionRow > 0)
                                        GameInterface.processMenuActions(MovedStatics.menuActionRow - 1);
                                }
                                GameInterface.anInt1651 = 10;
                                MouseHandler.clickType = 0;
                            }
                        }

                        if (currentScene.clickedTileX != -1) {
                            int i = currentScene.clickedTileX;
                            int i_18_ = currentScene.clickedTileY;
                            boolean bool = Pathfinding.doTileWalkTo(Player.localPlayer.pathY[0], Player.localPlayer.pathX[0], i, i_18_);
                            if (bool) {
                                GameInterface.crossY = MouseHandler.clickY;
                                MovedStatics.crossIndex = 0;
                                GameInterface.crossX = MouseHandler.clickX;
                                MovedStatics.crossType = 1;
                            }
                            currentScene.clickedTileX = -1;
                        }

                        if (MouseHandler.clickType == 1 && Native.clickToContinueString != null) {
                            MouseHandler.clickType = 0;
                            ChatBox.redrawChatbox = true;
                            Native.clickToContinueString = null;
                        }

                        MovedStatics.processMenuClick();
                        if (GameInterface.fullscreenInterfaceId == -1) {
                            ScreenController.handleMinimapMouse();
                            ScreenController.handleTabClick();
                            ScreenController.handleChatButtonsClick();
                        }

                        if (MouseHandler.currentMouseButtonPressed == 1 || MouseHandler.clickType == 1)
                            mouseClicksSinceLastDraw++;

                        int i = 34;
                        if (GameInterface.gameScreenInterfaceId != -1)
                            GameInterface.runClientScriptsForParentInterface(516, i, 338, GameInterface.gameScreenInterfaceId, 4, 4);

                        if (GameInterface.tabAreaInterfaceId == -1) {
                            if (tabWidgetIds[currentTabId] != -1)
                                GameInterface.runClientScriptsForParentInterface(743, i, 466, tabWidgetIds[currentTabId], 205, 553);
                        } else
                            GameInterface.runClientScriptsForParentInterface(743, i, 466, GameInterface.tabAreaInterfaceId, 205, 553);

                        if (GameInterface.chatboxInterfaceId != -1)
                            GameInterface.runClientScriptsForParentInterface(496, i, 453, GameInterface.chatboxInterfaceId, 357, 17);
                        else if (ChatBox.dialogueId != -1)
                            GameInterface.runClientScriptsForParentInterface(496, i, 453, ChatBox.dialogueId, 357, 17);

                        if (GameInterface.gameScreenInterfaceId != -1)
                            GameInterface.runClientScriptsForParentInterface(516, i ^ 0xffffffff, 338, GameInterface.gameScreenInterfaceId, 4, 4);

                        if (GameInterface.tabAreaInterfaceId != -1)
                            GameInterface.runClientScriptsForParentInterface(743, i ^ 0xffffffff, 466, GameInterface.tabAreaInterfaceId, 205, 553);

                        else if (tabWidgetIds[currentTabId] != -1)
                            GameInterface.runClientScriptsForParentInterface(743, i ^ 0xffffffff, 466, tabWidgetIds[currentTabId], 205, 553);

                        if (GameInterface.chatboxInterfaceId != -1)
                            GameInterface.runClientScriptsForParentInterface(496, i ^ 0xffffffff, 453, GameInterface.chatboxInterfaceId, 357, 17);
                        else if (ChatBox.dialogueId != -1)
                            GameInterface.runClientScriptsForParentInterface(496, i ^ 0xffffffff, 453, ChatBox.dialogueId, 357, 17);

                        // If hovering over a widget
                        if (MovedStatics.anInt1586 != -1 || MovedStatics.openTabWidgetChildTooltipId != -1 || MovedStatics.openWidgetChildTooltipId != -1) {
                            if (MovedStatics.tooltipDelay > MovedStatics.durationHoveredOverWidget) {
                                MovedStatics.durationHoveredOverWidget++;
                                if (MovedStatics.tooltipDelay == MovedStatics.durationHoveredOverWidget) {
                                    if (MovedStatics.anInt1586 != -1)
                                        ChatBox.redrawChatbox = true;
                                    if (MovedStatics.openTabWidgetChildTooltipId != -1)
                                        GameInterface.redrawTabArea = true;
                                }
                            }
                        } else if (MovedStatics.durationHoveredOverWidget > 0)
                            MovedStatics.durationHoveredOverWidget--;
                        calculateCameraPosition();
                        if (Player.cutsceneActive)
                            moveTowardsTarget();
                        for (int i_19_ = 0; i_19_ < 5; i_19_++)
                            SceneCamera.customCameraTimer[i_19_]++;
                        GameInterface.manageTextInputs();
                        int i_20_ = MouseHandler.resetFramesSinceMouseInput();
                        int i_21_ = KeyFocusListener.resetFramesSinceKeyboardInput();
                        if (i_20_ > 4500 && i_21_ > 4500) {
                            idleLogout = 250;
                            MouseHandler.setFramesSinceMouseInput(4000);
                            OutgoingPackets.buffer.putPacket(216);
                        }

                        // antibot camera/minimap randomisation used to happen here

                        MovedStatics.anInt537++;
                        if (MovedStatics.anInt537 > 50) {
                            OutgoingPackets.buffer.putPacket(13);
                        }
                        do {
                            try {
                                if (MovedStatics.gameServerSocket == null || OutgoingPackets.buffer.currentPosition <= 0)
                                    break;
                                MovedStatics.gameServerSocket.sendDataFromBuffer(OutgoingPackets.buffer.currentPosition, 0, OutgoingPackets.buffer.buffer);
                                MovedStatics.anInt537 = 0;
                                OutgoingPackets.buffer.currentPosition = 0;
                            } catch (java.io.IOException ioexception) {
                                dropClient();
                                break;
                            }
                            break;
                        } while (false);
                    }
                }
            }
        }
    }

    public static void printHelp() {
        System.out.println("Usage: worldid, [live/office/local], [live/rc/wip], [lowmem/highmem], [free/members]");
        System.exit(1);
    }

    private static void renderNPCs(boolean arg0) {
        for (int i = 0; Player.npcCount > i; i++) {
            Npc npc = Player.npcs[Player.npcIds[i]];
            int i_15_ = 536870912 + (Player.npcIds[i] << 14);
            if (npc != null && npc.isInitialized() && arg0 == npc.actorDefinition.hasRenderPriority && npc.actorDefinition.isVisible()) {
                int i_16_ = npc.worldX >> 7;
                int i_17_ = npc.worldY >> 7;
                if (i_16_ >= 0 && i_16_ < 104 && i_17_ >= 0 && i_17_ < 104) {
                    if (npc.size == 1 && (npc.worldX & 0x7f) == 64 && (npc.worldY & 0x7f) == 64) {
                        if (MovedStatics.anIntArrayArray1435[i_16_][i_17_] == MovedStatics.anInt2628) {
                            continue;
                        }
                        MovedStatics.anIntArrayArray1435[i_16_][i_17_] = MovedStatics.anInt2628;
                    }
                    if (!npc.actorDefinition.isClickable) {
                        i_15_ += -2147483648;
                    }
                    currentScene.method134(Player.worldLevel, npc.worldX, npc.worldY, Game.currentScene.getFloorDrawHeight(Player.worldLevel, npc.worldX + (-1 + npc.size) * 64, npc.size * 64 + -64 + npc.worldY), -64 + npc.size * 64 + 60, npc, npc.anInt3118, i_15_, npc.aBoolean3105);
                }
            }
        }
    }

    private static void renderPlayers(int arg0, boolean arg1) {
        if (Player.localPlayer.worldX >> 7 == MovedStatics.destinationX && Player.localPlayer.worldY >> 7 == destinationY) {
            MovedStatics.destinationX = 0;

            DebugTools.walkpathX = null;
            DebugTools.walkpathY = null;
        }
        int i = Player.localPlayerCount;
        if (arg1)
            i = 1;
        int i_0_ = arg0;
        for (/**/; i > i_0_; i_0_++) {
            int i_1_;
            Player player;
            if (arg1) {
                i_1_ = 33538048;
                player = Player.localPlayer;
            } else {
                i_1_ = Player.trackedPlayerIndices[i_0_] << 14;
                player = Player.trackedPlayers[Player.trackedPlayerIndices[i_0_]];
            }
            if (player != null && player.isInitialized()) {
                player.aBoolean3287 = false;
                int tileX = player.worldX >> 7;
                int tileY = player.worldY >> 7;
                if ((VertexNormal.lowMemory && Player.localPlayerCount > 50 || Player.localPlayerCount > 200) && !arg1 && player.anInt3077 == player.idleAnimation)
                    player.aBoolean3287 = true;
                if (tileX >= 0 && tileX < 104 && tileY >= 0 && tileY < 104) {
                    if (player.playerModel != null && player.anInt3283 <= MovedStatics.pulseCycle && MovedStatics.pulseCycle < player.anInt3274) {
                        player.aBoolean3287 = false;
                        player.anInt3276 = Game.currentScene.getFloorDrawHeight(Player.worldLevel, player.worldX, player.worldY);
                        currentScene.method112(Player.worldLevel, player.worldX, player.worldY, player.anInt3276, 60, player, player.anInt3118, i_1_, player.anInt3258, player.anInt3281, player.anInt3262, player.anInt3289);
                    } else {
                        if ((0x7f & player.worldX) == 64 && (player.worldY & 0x7f) == 64) {
                            if (MovedStatics.anInt2628 == MovedStatics.anIntArrayArray1435[tileX][tileY])
                                continue;
                            MovedStatics.anIntArrayArray1435[tileX][tileY] = MovedStatics.anInt2628;
                        }
                        player.anInt3276 = Game.currentScene.getFloorDrawHeight(Player.worldLevel, player.worldX, player.worldY);
                        currentScene.method134(Player.worldLevel, player.worldX, player.worldY, player.anInt3276, 60, player, player.anInt3118, i_1_, player.aBoolean3105);
                    }
                }
            }
        }

    }

    public static void method943(int arg0, TypeFace arg2, int arg3, int arg4) {
        MovedStatics.chatModes.prepareRasterizer();
        MovedStatics.bottomChatBack.drawImage(0, 0);
        arg2.drawShadowedStringCenter(English.publicChat, 55, 28, 16777215, true);
        if (arg4 == 0)
            arg2.drawShadowedStringCenter(English.on, 55, 41, 65280, true);
        if (arg4 == 1)
            arg2.drawShadowedStringCenter(English.friends, 55, 41, 16776960, true);
        if (arg4 == 2)
            arg2.drawShadowedStringCenter(English.off, 55, 41, 16711680, true);
        if (arg4 == 3)
            arg2.drawShadowedStringCenter(English.hide, 55, 41, 65535, true);
        arg2.drawShadowedStringCenter(English.privateChat, 184, 28, 16777215, true);
        if (arg3 == 0)
            arg2.drawShadowedStringCenter(English.on, 184, 41, 65280, true);
        if (arg3 == 1)
            arg2.drawShadowedStringCenter(English.friends, 184, 41, 16776960, true);
        if (arg3 == 2)
            arg2.drawShadowedStringCenter(English.off, 184, 41, 16711680, true);
        arg2.drawShadowedStringCenter(English.trade, 324, 28, 16777215, true);
        if (arg0 == 0)
            arg2.drawShadowedStringCenter(English.on, 324, 41, 65280, true);
        if (arg0 == 1)
            arg2.drawShadowedStringCenter(English.friends, 324, 41, 16776960, true);
        if (arg0 == 2)
            arg2.drawShadowedStringCenter(English.off, 324, 41, 16711680, true);
        arg2.drawText(English.reportAbuse, 417, 17, 85, 25, 16777215, true, 1, 1, 0);
        try {
            Graphics graphics = gameCanvas.getGraphics();
            if (ScreenController.frameMode == ScreenMode.FIXED) {
                MovedStatics.chatModes.drawGraphics(0, 453, graphics);
            }
        } catch (Exception exception) {
            gameCanvas.repaint();
        }
    }

    public static void method910() {
        if (true) {
            if (VertexNormal.lowMemory && MovedStatics.onBuildTimePlane != Player.worldLevel)
                MovedStatics.method789(Player.localPlayer.pathY[0], MovedStatics.regionY, MovedStatics.regionX, Player.localPlayer.pathX[0], Player.worldLevel);
            else if (Minimap.minimapLevel != Player.worldLevel) {
                Minimap.minimapLevel = Player.worldLevel;
                Minimap.createMinimap(Player.worldLevel);
            }
        }
    }

    public static void logout() {
        if (MovedStatics.gameServerSocket != null) {
            MovedStatics.gameServerSocket.kill();
            MovedStatics.gameServerSocket = null;
        }
        clearCaches();
        currentScene.initToNull();
        int i = 0;
        for (/**/; i < 4; i++)
            Landscape.currentCollisionMap[i].reset();
        System.gc();
        MusicSystem.method405(10);
        MusicSystem.songTimeout = 0;
        MusicSystem.currentSongId = -1;
        SoundSystem.clearObjectSounds();
        MovedStatics.processGameStatus(10);
    }

    public static void method249() {
        if (mouseHandler != null) {
            synchronized (mouseHandler) {
                mouseHandler = null;
            }
        }
    }

    public static void dropClient() {
        if (idleLogout > 0) {
            // Instant logout
            logout();
        } else {
            // Connection lost
            MovedStatics.processGameStatus(40);
            MovedStatics.lostConnectionSocket = MovedStatics.gameServerSocket;
            MovedStatics.gameServerSocket = null;
        }
    }

    public static void setLowMemory() {
        Scene.lowMemory = true;
        VertexNormal.lowMemory = true;
    }

    public static void method992() {
        gameTimer.start();
        for (int i = 0; i < 32; i++)
            GameShell.tickSamples[i] = 0L;
        for (int i = 0; i < 32; i++)
            MovedStatics.tickSamples[i] = 0L;
        MovedStatics.ticksPerLoop = 0;
    }

    public static void calculateCameraPosition() {
        int originX = playerCamera.getOriginX();
        int originY = playerCamera.getOriginY();

        int localPlayer3dPosX = Player.localPlayer.worldX;
        int localPlayer3dPosY = Player.localPlayer.worldY;

        // if the local player's position in 3d space is too far from the camera's origin, snap it
        if (originX - localPlayer3dPosX < -500 || -localPlayer3dPosX + originX > 500 || originY + -localPlayer3dPosY < -500 || -localPlayer3dPosY + originY > 500) {
            originY = localPlayer3dPosY;
            originX = localPlayer3dPosX;
        }

        // otherwise, slowly move the camera origin towards local player pos
        if (originX != localPlayer3dPosX)
            originX += (-originX + localPlayer3dPosX) / 16;
        if (originY != localPlayer3dPosY)
            originY += (-originY + localPlayer3dPosY) / 16;

        // update the camera's Z origin - this wasn't originally here, but it makes sense to do it with the other origins
        int cameraOriginZ = Game.currentScene.getFloorDrawHeight(Player.worldLevel, Player.localPlayer.worldX, Player.localPlayer.worldY) - 50;

        playerCamera.setOrigin(originX, originY, cameraOriginZ);

        // increase rotational velocity if key pressed, otherwise fall off
        if (MovedStatics.obfuscatedKeyStatus[96] && !Console.console.consoleOpen)
            SceneCamera.cameraVelocityYaw += (-24 - SceneCamera.cameraVelocityYaw) / 2;
        else if (MovedStatics.obfuscatedKeyStatus[97] && !Console.console.consoleOpen)
            SceneCamera.cameraVelocityYaw += (24 - SceneCamera.cameraVelocityYaw) / 2;
        else
            SceneCamera.cameraVelocityYaw /= 2;
        if (MovedStatics.obfuscatedKeyStatus[98] && !Console.console.consoleOpen)
            SceneCamera.cameraVelocityPitch += (12 + -SceneCamera.cameraVelocityPitch) / 2;
        else if (MovedStatics.obfuscatedKeyStatus[99] && !Console.console.consoleOpen)
            SceneCamera.cameraVelocityPitch += (-12 - SceneCamera.cameraVelocityPitch) / 2;
        else
            SceneCamera.cameraVelocityPitch /= 2;

        int zoomVelocity = SceneCamera.cameraVelocityZoom;
        SceneCamera.cameraVelocityZoom /= 1.5;

        // apply velocities to camera's target position
        int yaw = 0x7ff & (SceneCamera.cameraVelocityYaw / 2 + playerCamera.getYaw() & 0x7ff);
        int pitch = playerCamera.getPitch() + SceneCamera.cameraVelocityPitch / 2;
        int zoom = playerCamera.getZoom() + zoomVelocity;

        playerCamera.rotate(yaw, pitch);
        playerCamera.setZoom(zoom);

        // figure out minimum allowed pitch based on surrounding heights
        int i_3_ = 0;
        int i_1_ = originY >> 7;
        int i_2_ = originX >> 7;
        int i_4_ = Game.currentScene.getFloorDrawHeight(Player.worldLevel, originX, originY);
        if (i_2_ > 3 && i_1_ > 3 && i_2_ < 100 && i_1_ < 100) {
            for (int i_5_ = -4 + i_2_; i_5_ <= 4 + i_2_; i_5_++) {
                for (int i_6_ = -4 + i_1_; 4 + i_1_ >= i_6_; i_6_++) {
                    int i_7_ = Player.worldLevel;
                    if (i_7_ < 3 && (0x2 & MovedStatics.tile_flags[1][i_5_][i_6_]) == 2)
                        i_7_++;
                    int i_8_ = i_4_ + -currentScene.landscape.tile_height[i_7_][i_5_][i_6_];
                    if (i_8_ > i_3_)
                        i_3_ = i_8_;
                }
            }
        }

        SceneCamera.setMaxSurroundingTerrainHeight(i_3_);
    }

    public static void clearCaches() {
        OverlayDefinition.clearOverlayDefinitionCache();
        UnderlayDefinition.clearUnderlayDefinitionCache();
        IdentityKit.clearIdentityKitCache();
        GameObjectDefinition.clearGameObjectModelCache();
        ActorDefinition.clearActorCache();
        ItemDefinition.clearItemCache();
        AnimationSequence.clearAnimationCache();
        SpotAnimDefinition.clearSpotAnimCache();
        VarbitDefinition.clearVarbitDefinitionCache();
        VarPlayerDefinition.clearVarPlayerDefinitionCache();
        PlayerAppearance.clearPlayerModelCache();
        GameInterface.clearInterfaceCaches();
        ((Class35) Rasterizer3D.interface3).clearTextures();
        ClientScript.clearClientScriptCache();
        CacheArchive.skeletonCacheArchive.clearFileContentCache();
        CacheArchive.skinDefinitionCacheArchive.clearFileContentCache();
        CacheArchive.gameInterfaceCacheArchive.clearFileContentCache();
        CacheArchive.soundEffectCacheArchive.clearFileContentCache();
        CacheArchive.gameWorldMapCacheArchive.clearFileContentCache();
        CacheArchive.musicCacheArchive.clearFileContentCache();
        CacheArchive.modelCacheArchive.clearFileContentCache();
        CacheArchive.gameImageCacheArchive.clearFileContentCache();
        CacheArchive.gameTextureCacheArchive.clearFileContentCache();
        CacheArchive.huffmanCacheArchive.clearFileContentCache();
        CacheArchive.jingleCacheArchive.clearFileContentCache();
        CacheArchive.clientScriptCacheArchive.clearFileContentCache();
    }

    public static void renderProjectiles() {
        Projectile projectile = (Projectile) MovedStatics.projectileQueue.peekFirst();
        for (/**/; projectile != null; projectile = (Projectile) MovedStatics.projectileQueue.pollFirst()) {
            if (Player.worldLevel == projectile.anInt2981 && MovedStatics.pulseCycle <= projectile.endCycle) {
                if (projectile.delay <= MovedStatics.pulseCycle) {
                    if (projectile.entityIndex > 0) {
                        Npc npc = Player.npcs[-1 + projectile.entityIndex];
                        if (npc != null && npc.worldX >= 0 && npc.worldX < 13312 && npc.worldY >= 0 && npc.worldY < 13312)
                            projectile.trackTarget(MovedStatics.pulseCycle, 61 + -61, npc.worldY, Game.currentScene.getFloorDrawHeight(projectile.anInt2981, npc.worldX, npc.worldY) - projectile.endHeight, npc.worldX);
                    }
                    if (projectile.entityIndex < 0) {
                        int i = -1 + -projectile.entityIndex;
                        Player player;
                        if (i != Player.localPlayerId)
                            player = Player.trackedPlayers[i];
                        else
                            player = Player.localPlayer;
                        if (player != null && player.worldX >= 0 && player.worldX < 13312 && player.worldY >= 0 && player.worldY < 13312)
                            projectile.trackTarget(MovedStatics.pulseCycle, 0, player.worldY, Game.currentScene.getFloorDrawHeight(projectile.anInt2981, player.worldX, player.worldY) - projectile.endHeight, player.worldX);
                    }
                    projectile.move(deltaT);
                    currentScene.method134(Player.worldLevel, (int) projectile.currentX, (int) projectile.currentY, (int) projectile.currentHeight, 60, projectile, projectile.anInt3013, -1, false);
                }
            } else
                projectile.unlink();
        }
    }

    public static void renderSpotAnims() {
        for (SpotAnim spotAnim = (SpotAnim) MovedStatics.spotAnimQueue.peekFirst(); spotAnim != null; spotAnim = (SpotAnim) MovedStatics.spotAnimQueue.pollFirst()) {
            if (Player.worldLevel == spotAnim.plane && !spotAnim.animationFinished) {
                if (MovedStatics.pulseCycle >= spotAnim.startCycle) {
                    spotAnim.method834(deltaT);
                    if (spotAnim.animationFinished)
                        spotAnim.unlink();
                    else
                        currentScene.method134(spotAnim.plane, spotAnim.x, spotAnim.y, spotAnim.z, 60, spotAnim, 0, -1, false);
                }
            } else
                spotAnim.unlink();
        }
    }

    public static LoginProtocol loginProtocol = new RS435LoginProtocol();
    public static JS5UpdateServerConnectionManager updateServerConnectionManager;

    public static CacheArchive loadArchive(int cacheIndexId, boolean clearGroupContentCache, boolean clearFileContentCache, boolean forceHighPriority) {
        CacheIndex dataIndex = null;
        if (dataChannel != null) {
            dataIndex = new CacheIndex(cacheIndexId, indexChannels[cacheIndexId], dataChannel, 1000000);
        }
        return new CacheArchive(cacheIndexId, metaIndex, dataIndex, clearGroupContentCache, clearFileContentCache, forceHighPriority);
    }

    public void processGameLoop() {
        MovedStatics.pulseCycle++;

        if (gameStatusCode != 1000) {
            processJS5Connection(updateServerConnectionManager);
        }

        OnDemandRequestProcessor.handleRequests();
        MusicSystem.handleMusic();
        SoundSystem.handleSounds();
        GameInterface.method639();
        MouseHandler.method1015();

        if (gameStatusCode == 0) {
            Game.gameStartup.process();
            method992();
        } else if (gameStatusCode == 5) {
            Game.gameStartup.process();
            method992();
        } else if (gameStatusCode == 10) {
            LoginScreen.updateLogin();
        } else if (gameStatusCode == 20) {
            LoginScreen.updateLogin();
            loginProtocol.process();
        } else if (gameStatusCode == 25)
            currentScene.landscape.loadRegion();
        if (gameStatusCode == 30) {
            ScreenController.refreshFrameSize();
            updateGame();
        } else if (gameStatusCode == 35) {
            ScreenController.refreshFrameSize();
            updateGame();
        } else if (gameStatusCode == 40) {
            // Connection lost
            loginProtocol.process();
        }
    }

    /**
     * Draw the game screen
     */
    public void draw() {
        if (MovedStatics.aBoolean1575) {
            KeyFocusListener.removeListeners(gameCanvas);
            MouseHandler.removeListeners(gameCanvas);
//            this.setCanvas();
            KeyFocusListener.addListeners(gameCanvas);
            MouseHandler.addListeners(gameCanvas);
        }
        if (gameStatusCode == 0)
            renderer.drawLoadingText(gameStartup.loadingBarPercentage, null, Game.gameStartup.currentLoadingText);
        else if (gameStatusCode == 5 || gameStatusCode == 10 || gameStatusCode == 20) {
            LoginScreen.drawLoadingScreen(TypeFace.fontBold, TypeFace.fontSmall);
        } else if (gameStatusCode == 25) {
            if (regionLoadingType == 1) {
                if (missingLandscapeFiles > totalMissingLandscapeFiles)
                    totalMissingLandscapeFiles = missingLandscapeFiles;
                int i = (-missingLandscapeFiles + totalMissingLandscapeFiles) * 50 / totalMissingLandscapeFiles;
                MovedStatics.drawLoadingBox(English.loadingPleaseWait, Native.leftParenthesis + i + Native.percent_b, true);
            } else if (regionLoadingType == 2) {
                if (missingGameObjectFiles > totalMissingGameObjectFiles)
                    totalMissingGameObjectFiles = missingGameObjectFiles;
                int i = 50 * (-missingGameObjectFiles + totalMissingGameObjectFiles) / totalMissingGameObjectFiles + 50;
                MovedStatics.drawLoadingBox(English.loadingPleaseWait, Native.leftParenthesis + i + Native.percent_b, true);
            } else
                MovedStatics.drawLoadingBox(English.loadingPleaseWait, null, false);
        } else if (gameStatusCode == 30) {
            drawGameScreen();
        } else if (gameStatusCode == 35) {
            drawFullScreenWidget();
        } else if (gameStatusCode == 40)
            MovedStatics.drawLoadingBox(English.connectionLost, English.pleaseWaitAttemptingToReestablish, false);
        mouseClicksSinceLastDraw = 0;
    }

    /**
     * Processes the JS5 connection by deferring to the manager,
     * this method is responsible for changing the game state based on errors.
     *
     * TODO (jkm) get this further away from the Game class so we can support non-JS5
     *            update servers more easily
     */
    private void processJS5Connection(JS5UpdateServerConnectionManager manager) {
        try {
            manager.process(gameStatusCode);
        } catch (JS5CRCException e) {
            this.openErrorPage("js5crc");
            gameStatusCode = 1000;
        } catch (JS5IOException e) {
            this.openErrorPage("js5io");
            gameStatusCode = 1000;
        } catch (JS5ConnectException e) {
            // we don't set game to error state for this one
            this.openErrorPage("js5connect");
        } catch (JS5ConnectOutOfDateException e) {
            this.openErrorPage("js5connect_outofdate");
            gameStatusCode = 1000;
        } catch (JS5ConnectFullException e) {
            this.openErrorPage("js5connect_full");
            gameStatusCode = 1000;
        } catch (Exception e) {
            throw new RuntimeException("Unrecognised exception within JS5 connection", e);
        }
    }

    public void setErrorHandler(GameErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    private void openErrorPage(String error) {
        if (this.errorHandler == null) {
            return;
        }

        this.errorHandler.handleGameError(error);
    }

    public void close() {
        if (mouseCapturer != null)
            mouseCapturer.aBoolean913 = false;
        mouseCapturer = null;
        if (MovedStatics.gameServerSocket != null) {
            MovedStatics.gameServerSocket.kill();
            MovedStatics.gameServerSocket = null;
        }
        MovedStatics.method744();
        method249();
        MusicSystem.syncedStop(false);
        SoundSystem.stop();
        updateServerConnectionManager.close();
        OnDemandRequestProcessor.wait(-1);
        do {
            try {
                if (dataChannel != null)
                    dataChannel.close();
                if (indexChannels != null) {
                    for (int i = 0; i < indexChannels.length; i++) {
                        if (indexChannels[i] != null)
                            indexChannels[i].close();
                    }
                }
                if (metaChannel == null)
                    break;
                metaChannel.close();
            } catch (java.io.IOException ioexception) {
                break;
            }
            break;
        } while (false);
    }


    public void startup() {
        // Define ports
        someOtherPort = modewhere == 0 ? 443 : 50000 + Player.worldId;
        gameServerPort = modewhere == 0 ? Configuration.GAME_PORT : Player.worldId + 40000;
        currentPort = gameServerPort;

        updateServerConnectionManager = new JS5UpdateServerConnectionManager(
                signlink,
                gameServerPort,
                someOtherPort
        );

        KeyFocusListener.method997();
        KeyFocusListener.addListeners(gameCanvas);
        MouseHandler.addListeners(gameCanvas);
        MovedStatics.anInt57 = Signlink.anInt737;
        try {
            if (signlink.cacheDataAccessFile != null) {
                dataChannel = new CacheFileChannel(signlink.cacheDataAccessFile, 5200);
                for (int i = 0; i < 13; i++)
                    indexChannels[i] = new CacheFileChannel(signlink.dataIndexAccessFiles[i], 6000);
                metaChannel = new CacheFileChannel(signlink.metaIndexAccessFile, 6000);
                metaIndex = new CacheIndex(255, metaChannel, dataChannel, 500000);
                signlink.dataIndexAccessFiles = null;
                signlink.metaIndexAccessFile = null;
                signlink.cacheDataAccessFile = null;
            }
        } catch (java.io.IOException ioexception) {
            metaIndex = null;
            dataChannel = null;
            metaChannel = null;
        }
        if (modewhere != 0)
            MovedStatics.showFps = true;
        chatboxInterface = new GameInterface();
    }

    /**
     * Checks if the shift modifiers are enabled and active.
     *
     * @return true if the player is currently pressing the shift key and if
     * player has configured their client to accept shift modifiers.
     */
    public static boolean isShiftModifierActive() {
        return Game.shiftPressed == true && Configuration.SHIFT_CLICK_MODIFIER;
    }
}
