package com.lss233.phoenix.config;

import com.lss233.phoenix.Phoenix;
import com.lss233.phoenix.config.json.JsonConfiguration;
import com.lss233.phoenix.module.Module;
import com.lss233.phoenix.module.ModuleManager;

import java.io.File;
import java.io.IOException;

/**
 *
 */
public class ConfigurationManager {
    private final File moduleDataDir;
    public ConfigurationManager() {
        if (Phoenix.getConfigurationManager() != null)
            throw new UnsupportedOperationException("ConfigurationManager already defined.");
        this.moduleDataDir = new File(Phoenix.getServer().getPhoenixDataDir(), "config");
        if(!moduleDataDir.isDirectory()){
            if (!moduleDataDir.mkdirs())
                throw new RuntimeException("Failed to create module data directory.");
        }
    }

    /**
     * Gets the config directory of module.
     * @param module The module.
     * @return The directory.
     */
    public File getConfigurationDirectory(Module module) {
        File dir = new File(moduleDataDir, ModuleManager.getModuleInfo(module).getId());
        if(!dir.exists())
            dir.mkdirs();
        return dir;
    }

    /**
     * Gets the config.json file from the config directory of module.
     * @param module The module.
     * @return The config.json file instance.
     */
    public File getDefaultConfigurationFile(Module module) {
        return new File(getConfigurationDirectory(module), "config.json");
    }

    /**
     * Gets the default config file of the module.
     * @param module The module.
     * @return The config instance.
     * @throws IOException Failed to load config.
     */
    public JsonConfiguration getConfig(Module module) throws IOException {
        File file = getDefaultConfigurationFile(module);
        if(!file.exists())
            if(!file.createNewFile())
                throw new IOException("Failed to create file, check your disk space or something.");
        return JsonConfiguration.load(file);
    }
}
