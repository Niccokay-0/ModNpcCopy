package net.nic.npc.gui.books;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.nic.npc.NpcMain;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BookLoader {

    public static List<Component> loadBook(ResourceLocation bookId) {
        // Look in: assets/npcmain/books/{bookId.getPath()}.json
        String path = "/assets/" + NpcMain.MODID + "/books/" + bookId.getPath() + ".json";

        InputStream stream = BookLoader.class.getResourceAsStream(path);
        if (stream == null) {
            return List.of(Component.literal("Book content not found!"));
        }

        try (InputStreamReader reader = new InputStreamReader(stream)) {
            JsonObject json = JsonParser.parseReader(reader).getAsJsonObject();
            JsonArray pagesJson = json.getAsJsonArray("pages");

            List<Component> pages = new ArrayList<>();
            for (JsonElement element : pagesJson) {
                pages.add(Component.translatable(element.getAsString()));
            }
            return pages;

        } catch (Exception e) {
            e.printStackTrace();
            return List.of(Component.literal("Failed to load book content."));
        }
    }
}