package us.spaceclouds42.disableportals;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Simple config
 */
public class Config {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Config options
     */
    public static class Main {
        public boolean disableNetherPortals = false;
        public boolean disableEndPortals = false;
        public boolean disableEndGateways = false;
    }

    public final Config.Main main = new Main();

    public static Config loadConfig(File configFile) {
        Config config;
        if(configFile.exists() && configFile.isFile()) {
            try(
                    FileInputStream fileInputStream = new FileInputStream(configFile);
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
            ) {
                config = GSON.fromJson(bufferedReader, Config.class);
            }
            catch (IOException e) {
                throw new RuntimeException("[DP] Problem occurred when trying to load config: ", e);
            }
        }
        else {
            config = new Config();
        }
        config.saveConfig(configFile);

        return config;
    }

    public void saveConfig(File configFile) {
        try (
                FileOutputStream stream = new FileOutputStream(configFile);
                Writer writer = new OutputStreamWriter(stream, StandardCharsets.UTF_8)
        ) {
            GSON.toJson(this, writer);
        } catch (IOException e) {
            System.out.println("[DP] Problem occurred when saving config: " + e.getMessage());
        }
    }
}
