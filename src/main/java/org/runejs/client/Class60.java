package org.runejs.client;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.media.ImageRGB;
import org.runejs.client.cache.media.IndexedImage;
import org.runejs.client.cache.media.TypeFace;
import org.runejs.client.frame.ScreenController;
import org.runejs.client.frame.ScreenMode;
import org.runejs.client.frame.tab.parts.TabParts;
import org.runejs.client.input.KeyFocusListener;
import org.runejs.client.input.MouseHandler;
import org.runejs.client.language.English;
import org.runejs.client.language.Native;
import org.runejs.client.media.Rasterizer;
import org.runejs.client.media.VertexNormal;
import org.runejs.client.media.renderable.GameObject;
import org.runejs.client.media.renderable.Renderable;
import org.runejs.client.net.ISAAC;
import org.runejs.client.net.UpdateServer;
import org.runejs.client.sound.MusicSystem;
import org.runejs.Configuration;
import org.runejs.whitelabel.Images;

import java.awt.*;

public class Class60 {
    public static int loginScreenState = 0;
    public static int loginScreenFocus = 0;
    public static ProducingGraphicsBuffer muteButton;
    /**
     * Part of login screen
     */
    public static ProducingGraphicsBuffer aProducingGraphicsBuffer_1631;
    /**
     * Part of login screen
     */
    public static ProducingGraphicsBuffer aProducingGraphicsBuffer_1206;

    public static void updateLogin() {
        method836(1);

        if(MouseHandler.clickType == 1 && MouseHandler.clickY >= ScreenController.drawHeight-42 && MouseHandler.clickX>=ScreenController.drawWidth-42 ){
            int newVolume = 0;
            if(MusicSystem.musicVolume == 0) {
                newVolume = 255;
            }

            if(MusicSystem.musicVolume != 0 || MusicSystem.currentSongId == -1) {
                if(newVolume == 0) {
                    MusicSystem.method402(false);
                    MusicSystem.songTimeout = 0;
                } else {
                    MusicSystem.method412(false, CacheArchive.musicCacheArchive, 0, Native.titleSong, 10, "", MusicSystem.musicVolume);
                    MusicSystem.method456(newVolume);
                }
            } else {
                MusicSystem.playMusicTrack(false, 0, MusicSystem.currentSongId, newVolume, 0, CacheArchive.musicCacheArchive);
                MusicSystem.songTimeout = 0;
            }

            MusicSystem.musicVolume = newVolume;
            Configuration.setSoundMuted(newVolume == 0);

        }

        if(Game.gameStatusCode == 10) {
            int i = MouseHandler.clickX + -202;
            int clickType = MouseHandler.clickType;
            int clickY = -171 + MouseHandler.clickY;
            if(loginScreenState == 0) {
                /*int i_14_ = 100;
                int i_15_ = 120;
                if(clickType == 1 && i >= i_14_ - 75 && i_14_ + 75 >= i && clickY >= -20 + i_15_ && i_15_ + 20 >= clickY) {
                    MovedStatics.loginScreenFocus = 0;
                    Class26.loginScreenState = 3;
                }
                i_14_ = 260;
                if(clickType == 1 && i >= -75 + i_14_ && i <= 75 + i_14_ && clickY >= -20 + i_15_ && 20 + i_15_ >= clickY) {
                    Class26.loginScreenState = 2;
                    MovedStatics.loginScreenFocus = 0;
                    Native.loginScreenMessageLineOne = "";
                    Native.loginScreenMessageLineTwo = English.enterYourUsernameAndPassword;
                    Native.loginScreenMessageLineThree = "";
                }*/
                int i_20_ = 150;
                int i_21_ = 180;
                if(clickType == 1 && i >= -75 + i_21_ && 75 + i_21_ >= i && -20 + i_20_ <= clickY && 20 + i_20_ >= clickY) {
                    loginScreenState = 2;
                    loginScreenFocus = 0;
                    Native.loginScreenMessageLineOne = "";
                    Native.loginScreenMessageLineTwo = English.enterYourUsernameAndPassword;
                    Native.loginScreenMessageLineThree = "";
                }
            } else if(loginScreenState == 2) {
                int y = 60;
                int clickX = 100;
                y += 30;
                if(clickType == 1 && -15 + y <= clickY && clickY < y)
                    loginScreenFocus = 0;
                int i_18_ = 150;
                y += 15;
                if(clickType == 1 && -15 + y <= clickY && y > clickY)
                    loginScreenFocus = 1;
                y += 15;
                if(clickType == 1 && clickX + -75 <= i && i <= clickX + 75 && clickY >= i_18_ + -20 && clickY <= i_18_ + 20) {
                    Native.username = Native.username.method62().method85();
                    setLoginScreenMessage("", English.connectingToServer, "");
                    MovedStatics.processGameStatus(20);
                } else {
                    clickX = 260;
                    if(clickType == 1 && i >= -75 + clickX && clickX + 75 >= i && clickY >= -20 + i_18_ && clickY <= i_18_ + 20) {
                        Native.username = Configuration.getUsername();
                        Native.password = Configuration.getPassword();
                        loginScreenState = 0;
                    }
                    while(MovedStatics.method416()) {
                        boolean bool = false;
                        for(int i_19_ = 0; Native.supportedCharacters.length() > i_19_; i_19_++) {
                            if(Native.supportedCharacters.charAt(i_19_) == MovedStatics.anInt1388) {
                                bool = true;
                                break;
                            }
                        }
                        if(loginScreenFocus == 0) {
                            if(MovedStatics.anInt2854 == 85 && Native.username.length() > 0)
                                Native.username = Native.username.substring(0, -1 + Native.username.length());
                            if(MovedStatics.anInt2854 == 84 || MovedStatics.anInt2854 == 80)
                                loginScreenFocus = 1;
                            if(bool && Native.username.length() < 18)
                                Native.username = Native.username.addChar(MovedStatics.anInt1388);
                        } else if(loginScreenFocus == 1) {
                            if(MovedStatics.anInt2854 == 85 && Native.password.length() > 0)
                                Native.password = Native.password.substring(0, Native.password.length() + -1);
                            if(MovedStatics.anInt2854 == 80)
                                loginScreenFocus = 0;
                            if(MovedStatics.anInt2854 == 84) {
                                Native.username = Native.username.method62().method85();
                                setLoginScreenMessage("", English.connectingToServer, "");
                                MovedStatics.processGameStatus(20);
                            }
                            if(bool && Native.password.length() < 20)
                                Native.password = Native.password.addChar(MovedStatics.anInt1388);
                        }
                    }
                }
            } else if(loginScreenState == 3) {
                int i_20_ = 150;
                int i_21_ = 180;
                if(clickType == 1 && i >= -75 + i_21_ && 75 + i_21_ >= i && -20 + i_20_ <= clickY && 20 + i_20_ >= clickY)
                    loginScreenState = 0;
            }
        }
    }

    public static void drawLoadingScreen(TypeFace fontBold, TypeFace fontSmall) {
        MovedStatics.loginBoxGraphics.prepareRasterizer();
//            Rasterizer.drawFilledRectangle(0,0, ScreenController.frameWidth, ScreenController.frameHeight, 0);
        if (Game.gameStatusCode == 0 || Game.gameStatusCode == 5) {
            int i = 20;
            fontBold.drawStringLeft(English.gameIsLoadingPleaseWait, 180, 74 + -i, 16777215);
            int i_89_ = -i + 82;
            Rasterizer.drawUnfilledRectangle(28, i_89_, 304, 34, 9179409);
            Rasterizer.drawUnfilledRectangle(29, 1 + i_89_, 302, 32, 0);
            Rasterizer.drawFilledRectangle(30, 2 + i_89_, MovedStatics.anInt1607 * 3, 30, 9179409);
            Rasterizer.drawFilledRectangle(3 * MovedStatics.anInt1607 + 30, i_89_ + 2, -(MovedStatics.anInt1607 * 3) + 300, 30, 0);
            fontBold.drawStringLeft(Native.currentLoadingText, 180, -i + 105, 16777215);
        }
        if (Game.gameStatusCode == 20) {
            int drawY = 40;
            MovedStatics.loginScreenBox.drawImage(0, 0);
            fontBold.drawShadowedStringCenter(Native.loginScreenMessageLineOne, 180, drawY, 16776960, true);
            drawY += 15;
            fontBold.drawShadowedStringCenter(Native.loginScreenMessageLineTwo, 180, drawY, 16776960, true);
            drawY += 15;
            fontBold.drawShadowedStringCenter(Native.loginScreenMessageLineThree, 180, drawY, 16776960, true);
            drawY += 15;
            drawY += 10;
            fontBold.drawShadowedString(English.username + Native.username, 90, drawY, true, 16777215);
            drawY += 15;
            fontBold.drawShadowedString(English.password + Native.password.method61(), 92, drawY, true, 16777215);
            drawY += 15;
        }
        if (Game.gameStatusCode == 10) {
            MovedStatics.loginScreenBox.drawImage(0, 0);
            if (loginScreenState == 0) {
                /*fontBold.drawShadowedStringCenter(English.welcomeTo, 180, 80, 16776960, true);
                int drawX = 100;
                int drawY = 120;
                Class59.imgLoginScreenButton.drawImage(drawX - 73, drawY - 20);
                fontBold.drawText(English.newUser, drawX + -73, -20 + drawY, 144, 40, 16777215, true, 1, 1, 0);
                drawX = 260;
                Class59.imgLoginScreenButton.drawImage(drawX - 73, drawY + -20);
                fontBold.drawText(English.existingUser, drawX - 73, -20 + drawY, 144, 40, 16777215, true, 1, 1, 0);*/

                fontBold.drawShadowedStringCenter(English.welcomeTo, 180, 40, 16776960, true);
                int i = 180;
                int i_92_ = 150;
                int i_93_ = 65;

                for(int textIndex = 0; textIndex < English.customLoginText.length; textIndex++) {
                    fontBold.drawShadowedStringCenter(English.customLoginText[textIndex], 180, i_93_, 16777215, true);
                    i_93_ += 15;
                }

                MovedStatics.imgLoginScreenButton.drawImage(-73 + i, i_92_ - 20);
                fontBold.drawShadowedStringCenter(English.login, i, 5 + i_92_, 16777215, true);

            } else if (loginScreenState == 2) {
                int y1 = 40;
                int drawX = 100;
                fontBold.drawShadowedStringCenter(Native.loginScreenMessageLineOne, 180, y1, 16776960, true);
                y1 += 15;
                int y2 = 150;
                fontBold.drawShadowedStringCenter(Native.loginScreenMessageLineTwo, 180, y1, 16776960, true);
                y1 += 15;
                fontBold.drawShadowedStringCenter(Native.loginScreenMessageLineThree, 180, y1, 16776960, true);
                y1 += 15;
                y1 += 10;
                int width = fontBold.getStringWidth(English.username + Native.username + Native.justAnotherYellowBar);
                int offset = 0;
                while (width > 250) {
                    offset++;
                    width = fontBold.getStringWidth(English.username + Native.username.substring(offset) + Native.justAnotherYellowBar);
                }
                fontBold.drawShadowedString(English.username + Native.username.substring(offset) + (MovedStatics.pulseCycle % 40 < 20 & loginScreenFocus == 0 ? Native.justAnotherYellowBar : ""), 90, y1, true, 16777215);
                y1 += 15;
                String starredPassword = Native.password.method61().toString();
                width = fontBold.getStringWidth(English.password + starredPassword + Native.justAnotherYellowBar);
                offset = 0;
                while (width > 250) {
                    offset++;
                    width = fontBold.getStringWidth(English.password + starredPassword.substring(offset) + Native.justAnotherYellowBar);
                }
                fontBold.drawShadowedString(English.password + starredPassword.substring(offset) + (MovedStatics.pulseCycle % 40 < 20 & loginScreenFocus == 1 ? Native.justAnotherYellowBar : ""), 92, y1, true, 16777215);
                MovedStatics.imgLoginScreenButton.drawImage(-73 + drawX, y2 + -20);
                y1 += 15;
                fontBold.drawShadowedStringCenter(English.login, drawX, y2 + 5, 16777215, true);
                drawX = 260;
                MovedStatics.imgLoginScreenButton.drawImage(-73 + drawX, y2 + -20);
                fontBold.drawShadowedStringCenter(English.cancel, drawX, 5 + y2, 16777215, true);
            } else if (loginScreenState == 3) {
                fontBold.drawShadowedStringCenter(English.createAFreeAccount, 180, 40, 16776960, true);
                int i = 180;
                int i_92_ = 150;
                int i_93_ = 65;

                for(int textIndex = 0; textIndex < English.createAccountText.length; textIndex++) {
                    fontBold.drawShadowedStringCenter(English.createAccountText[textIndex], 180, i_93_, 16777215, true);
                    i_93_ += 15;
                }

                MovedStatics.imgLoginScreenButton.drawImage(-73 + i, i_92_ - 20);
                fontBold.drawShadowedStringCenter(English.cancel, i, 5 + i_92_, 16777215, true);
            }
        }

        muteButton.prepareRasterizer();
        ImageRGB musicIcon = TabParts.GetPart("music");

        if(ScreenController.frameMode == ScreenMode.RESIZABLE) {
            Rasterizer.drawFilledRectangle(0, 0, ScreenController.drawWidth, ScreenController.drawHeight, 0);
        }

        Rasterizer.drawFilledRectangle(0, 0, 42, 42, 0x4d4431);
        Rasterizer.drawUnfilledRectangle(0, 0, 42, 42, 0x242017);
        musicIcon.drawImage(4, 3);

        if(MusicSystem.musicVolume == 0) {
            Rasterizer.drawDiagonalLine(0,0, 42,42, 0xFF0000);
        }

        Game.renderFlames();

        try {
            int offsetX = 0;
            int offsetY = 0;
            if(ScreenController.frameMode == ScreenMode.RESIZABLE) {
                int drawWidth = ScreenController.drawWidth;
                int drawHeight = ScreenController.drawHeight;
                int middleX = drawWidth / 2;
                int middleY = drawHeight / 2;
                int loginScreenOffsetX = 765 / 2;
                int loginScreenOffsetY = 503 / 2;
                offsetX = middleX - loginScreenOffsetX;
                offsetY = middleY - loginScreenOffsetY;
            }
            Graphics graphics = MouseHandler.gameCanvas.getGraphics();
            muteButton.drawGraphics(ScreenController.drawWidth-42, ScreenController.drawHeight-42, graphics);

            MovedStatics.loginBoxGraphics.drawGraphics(offsetX + 202, offsetY + 171, graphics);
            MovedStatics.flameLeftBackground.drawGraphics(offsetX, offsetY, graphics);
            GameObject.flameRightBackground.drawGraphics(offsetX + 637, offsetY, graphics);

            if (!MovedStatics.clearScreen)
                return;
            MovedStatics.clearScreen = false;

            MovedStatics.aProducingGraphicsBuffer_907.drawGraphics(offsetX + 128, offsetY, graphics);
            aProducingGraphicsBuffer_1206.drawGraphics(offsetX + 202, offsetY + 371, graphics);
            MovedStatics.aProducingGraphicsBuffer_463.drawGraphics(offsetX, offsetY + 265, graphics);
            KeyFocusListener.aProducingGraphicsBuffer_1285.drawGraphics(offsetX + 562, offsetY + 265, graphics);
            MovedStatics.aProducingGraphicsBuffer_2524.drawGraphics(offsetX + 128, offsetY + 171, graphics);
            aProducingGraphicsBuffer_1631.drawGraphics(offsetX + 562, offsetY + 171, graphics);
            muteButton.drawGraphics(ScreenController.drawWidth-42, ScreenController.drawHeight-42, graphics);
        } catch (Exception exception) {
            MouseHandler.gameCanvas.repaint();
        }
    }

    public static void setLoginScreenMessage(String line1, String line2, String line3) {
        Native.loginScreenMessageLineOne = line1;
        Native.loginScreenMessageLineTwo = line2;
        Native.loginScreenMessageLineThree = line3;
    }

    /**
     * Login screen flames?
     */
    private static void method836(int arg0) {
        int i = 256;
        for (int i_0_ = 10; i_0_ < 117; i_0_++) {
            int i_1_ = (int) (Math.random() * 100.0);
            if (i_1_ < 50)
                MovedStatics.anIntArray178[(i - 2 << 7) + i_0_] = 255;
        }
        for (int i_2_ = 0; i_2_ < 100; i_2_++) {
            int i_3_ = (int) (Math.random() * 124.0) + 2;
            int i_4_ = 128 + (int) (Math.random() * 128.0);
            int i_5_ = i_3_ + (i_4_ << 7);
            MovedStatics.anIntArray178[i_5_] = 192;
        }
        for (int i_6_ = 1; i_6_ < i - 1; i_6_++) {
            for (int i_7_ = 1; i_7_ < 127; i_7_++) {
                int i_8_ = i_7_ + (i_6_ << 7);
                MovedStatics.anIntArray3255[i_8_] = (MovedStatics.anIntArray178[i_8_ + 1] + MovedStatics.anIntArray178[i_8_ - 1] - (-MovedStatics.anIntArray178[-128 + i_8_] - MovedStatics.anIntArray178[128 + i_8_])) / 4;
            }
        }
        RSRuntimeException.anInt1641 += 128;
        if (RSRuntimeException.anInt1641 > MovedStatics.anIntArray1168.length) {
            RSRuntimeException.anInt1641 -= MovedStatics.anIntArray1168.length;
            int i_9_ = (int) (12.0 * Math.random());
            method879(MovedStatics.aClass40_Sub5_Sub14_Sub2Array535[i_9_]);
        }
        for (int i_10_ = 1; i_10_ < -1 + i; i_10_++) {
            for (int i_11_ = 1; i_11_ < 127; i_11_++) {
                int i_12_ = i_11_ + (i_10_ << 7);
                int i_13_ = -(MovedStatics.anIntArray1168[i_12_ + RSRuntimeException.anInt1641 & -1 + MovedStatics.anIntArray1168.length] / 5) + MovedStatics.anIntArray3255[i_12_ + 128];
                if (i_13_ < 0)
                    i_13_ = 0;
                MovedStatics.anIntArray178[i_12_] = i_13_;
            }
        }
        for (int i_14_ = 0; i_14_ < i + -1; i_14_++)
            MovedStatics.anIntArray466[i_14_] = MovedStatics.anIntArray466[i_14_ + 1];
        MovedStatics.anIntArray466[i - arg0] = (int) (16.0 * Math.sin((double) MovedStatics.pulseCycle / 14.0) + 14.0 * Math.sin((double) MovedStatics.pulseCycle / 15.0) + 12.0 * Math.sin((double) MovedStatics.pulseCycle / 16.0));
        if (MovedStatics.anInt2452 > 0)
            MovedStatics.anInt2452 -= 4;
        if (MovedStatics.anInt2613 > 0)
            MovedStatics.anInt2613 -= 4;
        if (MovedStatics.anInt2452 == 0 && MovedStatics.anInt2613 == 0) {
            int i_15_ = (int) (2000.0 * Math.random());
            if (i_15_ == 0)
                MovedStatics.anInt2452 = 1024;
            if (i_15_ == 1)
                MovedStatics.anInt2613 = 1024;
        }
    }

    public static void renderLoginScreen(Component arg0, CacheArchive huffmanCacheArchive, CacheArchive gameImageCacheArchive) {
        if (!ISAAC.aBoolean512) {
            MovedStatics.flameLeftBackground = MovedStatics.createGraphicsBuffer(128, 265, arg0);
            Rasterizer.resetPixels();
            GameObject.flameRightBackground = MovedStatics.createGraphicsBuffer(128, 265, arg0);
            Rasterizer.resetPixels();
            MovedStatics.aProducingGraphicsBuffer_907 = MovedStatics.createGraphicsBuffer(509, 171, arg0);
            Rasterizer.resetPixels();
            aProducingGraphicsBuffer_1206 = MovedStatics.createGraphicsBuffer(360, 132, arg0);
            Rasterizer.resetPixels();
            MovedStatics.loginBoxGraphics = MovedStatics.createGraphicsBuffer(360, 200, arg0);
            Rasterizer.resetPixels();
            MovedStatics.aProducingGraphicsBuffer_463 = MovedStatics.createGraphicsBuffer(202, 238, arg0);
            Rasterizer.resetPixels();
            KeyFocusListener.aProducingGraphicsBuffer_1285 = MovedStatics.createGraphicsBuffer(203, 238, arg0);
            Rasterizer.resetPixels();
            MovedStatics.aProducingGraphicsBuffer_2524 = MovedStatics.createGraphicsBuffer(74, 94, arg0);
            Rasterizer.resetPixels();
            aProducingGraphicsBuffer_1631 = MovedStatics.createGraphicsBuffer(75, 94, arg0);
            Rasterizer.resetPixels();
            muteButton = MovedStatics.createGraphicsBuffer(42, 42, arg0);
            Rasterizer.resetPixels();
            byte[] is = huffmanCacheArchive.method170("", Native.titleImage);
            ImageRGB titleImg = new ImageRGB(is, arg0);
            MovedStatics.flameLeftBackground.prepareRasterizer();
            titleImg.drawInverse(0, 0);
            GameObject.flameRightBackground.prepareRasterizer();
            titleImg.drawInverse(-637, 0);
            MovedStatics.aProducingGraphicsBuffer_907.prepareRasterizer();
            titleImg.drawInverse(-128, 0);
            aProducingGraphicsBuffer_1206.prepareRasterizer();
            titleImg.drawInverse(-202, -371);
            MovedStatics.loginBoxGraphics.prepareRasterizer();
            titleImg.drawInverse(-202, -171);
            MovedStatics.aProducingGraphicsBuffer_463.prepareRasterizer();
            titleImg.drawInverse(0, -265);
            KeyFocusListener.aProducingGraphicsBuffer_1285.prepareRasterizer();
            titleImg.drawInverse(-562, -265);
            MovedStatics.aProducingGraphicsBuffer_2524.prepareRasterizer();
            titleImg.drawInverse(-128, -171);
            aProducingGraphicsBuffer_1631.prepareRasterizer();
            titleImg.drawInverse(-562, -171);
            int[] is_18_ = new int[titleImg.imageWidth];
            for (int i = 0; i < titleImg.imageHeight; i++) {
                for (int i_19_ = 0; i_19_ < titleImg.imageWidth; i_19_++)
                    is_18_[i_19_] = titleImg.pixels[i * titleImg.imageWidth + titleImg.imageWidth + -i_19_ - 1];
                for (int i_20_ = 0; i_20_ < titleImg.imageWidth; i_20_++)
                    titleImg.pixels[i_20_ + titleImg.imageWidth * i] = is_18_[i_20_];
            }
            MovedStatics.flameLeftBackground.prepareRasterizer();
            titleImg.drawInverse(382, 0);
            GameObject.flameRightBackground.prepareRasterizer();
            titleImg.drawInverse(-255, 0);
            MovedStatics.aProducingGraphicsBuffer_907.prepareRasterizer();
            titleImg.drawInverse(254, 0);
            aProducingGraphicsBuffer_1206.prepareRasterizer();
            titleImg.drawInverse(180, -371);
            MovedStatics.loginBoxGraphics.prepareRasterizer();
            titleImg.drawInverse(180, -171);
            MovedStatics.aProducingGraphicsBuffer_463.prepareRasterizer();
            titleImg.drawInverse(382, -265);
            KeyFocusListener.aProducingGraphicsBuffer_1285.prepareRasterizer();
            titleImg.drawInverse(-180, -265);
            MovedStatics.aProducingGraphicsBuffer_2524.prepareRasterizer();
            titleImg.drawInverse(254, -171);
            aProducingGraphicsBuffer_1631.prepareRasterizer();
            titleImg.drawInverse(-180, -171);
            muteButton.prepareRasterizer();
            ImageRGB musicIcon = TabParts.GetPart("music");
            Rasterizer.drawFilledRectangle(0, 0, 42, 42, 0x4d4431);
            Rasterizer.drawUnfilledRectangle(0, 0, 42, 42, 0x242017);
            musicIcon.drawImage(4, 3);
            titleImg = MovedStatics.method1028(gameImageCacheArchive, Native.logo, "");
            MovedStatics.aProducingGraphicsBuffer_907.prepareRasterizer();
            // UNCOMMENT LINE UNDER FOR LOGO
            // class40_sub5_sub14_sub4.drawImage(-128 + 382 + -(class40_sub5_sub14_sub4.imageWidth / 2), 18);
            // Comment line under to remove custom logo:
            ImageRGB logo = Images.GetPart("logo");

            logo.drawImage(-128 + 382 + -(logo.imageWidth / 2), 18);

            MovedStatics.loginScreenBox = Game.method359(Native.titleBox, "", gameImageCacheArchive);
            MovedStatics.imgLoginScreenButton = Game.method359(Native.titleButton, "", gameImageCacheArchive);
            MovedStatics.aClass40_Sub5_Sub14_Sub2Array535 = IndexedImage.getMultipleIndexedImages(gameImageCacheArchive, Native.runes, "");

            MovedStatics.aClass40_Sub5_Sub14_Sub4_918 = new ImageRGB(128, 265);
            MovedStatics.aClass40_Sub5_Sub14_Sub4_2043 = new ImageRGB(128, 265);
            for (int i = 0; i < 33920; i++)
                MovedStatics.aClass40_Sub5_Sub14_Sub4_918.pixels[i] = MovedStatics.flameLeftBackground.pixels[i];
            for (int i = 0; i < 33920; i++)
                MovedStatics.aClass40_Sub5_Sub14_Sub4_2043.pixels[i] = GameObject.flameRightBackground.pixels[i];
            MovedStatics.anIntArray1198 = new int[256];
            for (int i = 0; i < 64; i++)
                MovedStatics.anIntArray1198[i] = i * 262144;
            for (int i = 0; i < 64; i++)
                MovedStatics.anIntArray1198[64 + i] = 1024 * i + 16711680;
            for (int i = 0; i < 64; i++)
                MovedStatics.anIntArray1198[128 + i] = 16776960 + i * 4;
            for (int i = 0; i < 64; i++)
                MovedStatics.anIntArray1198[i + 192] = 16777215;
            Renderable.anIntArray2865 = new int[256];
            for (int i = 0; i < 64; i++)
                Renderable.anIntArray2865[i] = i * 1024;
            for (int i = 0; i < 64; i++)
                Renderable.anIntArray2865[i + 64] = 4 * i + 65280;
            for (int i = 0; i < 64; i++)
                Renderable.anIntArray2865[128 + i] = i * 262144 + 65535;
            for (int i = 0; i < 64; i++)
                Renderable.anIntArray2865[i + 192] = 16777215;
            MovedStatics.anIntArray3248 = new int[256];
            for (int i = 0; i < 64; i++)
                MovedStatics.anIntArray3248[i] = i * 4;
            for (int i = 0; i < 64; i++)
                MovedStatics.anIntArray3248[64 + i] = 255 + i * 262144;
            for (int i = 0; i < 64; i++)
                MovedStatics.anIntArray3248[128 + i] = i * 1024 + 16711935;
            for (int i = 0; i < 64; i++)
                MovedStatics.anIntArray3248[192 + i] = 16777215;
            MovedStatics.anIntArray1013 = new int[256];
            MovedStatics.anIntArray1445 = new int[32768];
            MovedStatics.anIntArray1168 = new int[32768];
            method879(null);
            MovedStatics.anIntArray3255 = new int[32768];
            Native.username = Configuration.getUsername();
            Native.password = Configuration.getPassword();
            MovedStatics.anIntArray178 = new int[32768];
            loginScreenState = 0;
            if (MusicSystem.musicVolume != 0 && !VertexNormal.lowMemory)
                MusicSystem.method412(false, CacheArchive.musicCacheArchive, 0, Native.titleSong, 10, "", MusicSystem.musicVolume);
            else
                MusicSystem.method405(10);
            UpdateServer.resetUpdateServerRequests(false);
            MovedStatics.clearScreen = true;
            ISAAC.aBoolean512 = true;
        }
    }

    public static void method879(IndexedImage arg1) {
        int i = 0;
        for(/**/; i < MovedStatics.anIntArray1168.length; i++)
            MovedStatics.anIntArray1168[i] = 0;
        int i_19_ = 256;
        for(int i_20_ = 0; i_20_ < 5000; i_20_++) {
            int i_21_ = (int) ((double) i_19_ * (128.0 * Math.random()));
            MovedStatics.anIntArray1168[i_21_] = (int) (256.0 * Math.random());
        }
        for(int i_22_ = 0; i_22_ < 20; i_22_++) {
            for(int i_23_ = 1; -1 + i_19_ > i_23_; i_23_++) {
                for(int i_24_ = 1; i_24_ < 127; i_24_++) {
                    int i_25_ = (i_23_ << 7) + i_24_;
                    MovedStatics.anIntArray1445[i_25_] = (MovedStatics.anIntArray1168[i_25_ - 128] + MovedStatics.anIntArray1168[i_25_ + -1] + MovedStatics.anIntArray1168[i_25_ + 1] + MovedStatics.anIntArray1168[128 + i_25_]) / 4;
                }
            }
            int[] is = MovedStatics.anIntArray1168;
            MovedStatics.anIntArray1168 = MovedStatics.anIntArray1445;
            MovedStatics.anIntArray1445 = is;
        }
        if(arg1 != null) {
            int i_26_ = 0;
            for(int i_27_ = 0; arg1.imgHeight > i_27_; i_27_++) {
                for(int i_28_ = 0; i_28_ < arg1.imgWidth; i_28_++) {
                    if(arg1.imgPixels[i_26_++] != 0) {
                        int i_29_ = arg1.yDrawOffset + i_27_ + 16;
                        int i_30_ = arg1.xDrawOffset + i_28_ + 16;
                        int i_31_ = i_30_ + (i_29_ << 7);
                        MovedStatics.anIntArray1168[i_31_] = 0;
                    }
                }
            }
        }
    }
}
