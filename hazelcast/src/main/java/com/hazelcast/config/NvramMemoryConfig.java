package com.hazelcast.config;

import java.io.File;

import static com.hazelcast.util.Preconditions.checkNotNull;

/**
 * Configures Nvram memory region.
 */
public class NvramMemoryConfig {

    /**
     * Default directory for NVRAM memory
     */
    public static final String NVRAM_BASE_DIR_DEFAULT = "/mnt/mem";

    private boolean enabled;
    private File baseDir = new File(NVRAM_BASE_DIR_DEFAULT);

    public NvramMemoryConfig() {
    }

    public NvramMemoryConfig(NvramMemoryConfig nvramMemoryConfig) {
        enabled = nvramMemoryConfig.enabled;
        baseDir = nvramMemoryConfig.baseDir;
    }

    /**
     * Returns {@code true} if nvram memory allocation is enabled, {@code false} otherwise.
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Enables or disables nvram memory allocation
     *
     * @return this {@link NativeMemoryConfig} instance
     */
    public NvramMemoryConfig setEnabled(final boolean enabled) {
        this.enabled = enabled;
        return this;
    }


    /**
     * Base directory for NVRam allocations.
     */
    public File getBaseDir() {
        return baseDir;
    }

    /**
     * Sets base directory for NVRam allocations.
     *
     * @param baseDir base directory
     * @return NativeMemoryConfig
     */
    public NvramMemoryConfig setBaseDir(File baseDir) {
        checkNotNull(baseDir, "Nvram base directory cannot be null!");
        this.baseDir = baseDir;
        return this;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NvramMemoryConfig)) {
            return false;
        }

        NvramMemoryConfig that = (NvramMemoryConfig) o;
        if (enabled != that.enabled) {
            return false;
        }
        return baseDir != null ? baseDir.equals(that.baseDir) : that.baseDir == null;
    }

    @Override
    public final int hashCode() {
        int result = (enabled ? 1 : 0);
        result = 31 * result + (baseDir != null ? baseDir.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "NvramMemoryConfig{" + "enabled=" + enabled + ", baseDir=" + baseDir + '}';
    }
}
