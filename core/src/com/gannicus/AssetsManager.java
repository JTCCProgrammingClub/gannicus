package com.gannicus;

/**
 *
 * @author roasstbeef (alex.s)
 */
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import java.util.HashMap;

public class AssetsManager {

    private static HashMap<String, TextureRegion> texturesMap = 
            new HashMap<String, TextureRegion>();
    private static HashMap<String, Animation> animationsMap = 
            new HashMap<String, Animation>();
    private static TextureAtlas textureAtlas;
    private static BitmapFont smallFont;
    private static BitmapFont smallestFont;
    private static BitmapFont largeFont;

    private AssetsManager() {

    }

    public static void loadAssets() {

        // Background
        texturesMap.put(Constants.BACKGROUND_ASSETS_ID,
                new TextureRegion(new Texture(Gdx.files.internal(
                        Constants.BACKGROUND_IMAGE_PATH))));


        textureAtlas = new TextureAtlas(Constants.SPRITES_ATLAS_PATH);



        // Fonts
        FreeTypeFontGenerator generator = 
                new FreeTypeFontGenerator(Gdx.files.internal(Constants.FONT_NAME));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = 
                new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 36;
        smallFont = generator.generateFont(parameter);
        smallFont.setColor(.21f, .22f, .21f, 1f);
        parameter.size = 72;
        largeFont = generator.generateFont(parameter);
        largeFont.setColor(.21f, .22f, .21f, 1f);
        parameter.size = 24;
        smallestFont = generator.generateFont(parameter);
        smallestFont.setColor(.21f, .22f, .21f, 1f);
        generator.dispose();

    }

    public static TextureRegion getTextureRegion(String key) {
        return texturesMap.get(key);
    }

    public static TextureAtlas getTextureAtlas() {
        return textureAtlas;
    }

    public static BitmapFont getSmallFont() {
        return smallFont;
    }

    public static BitmapFont getLargeFont() {
        return largeFont;
    }

    public static BitmapFont getSmallestFont() {
        return smallestFont;
    }

    public static void dispose() {
        textureAtlas.dispose();
        smallestFont.dispose();
        smallFont.dispose();
        largeFont.dispose();
        texturesMap.clear();
    }
}