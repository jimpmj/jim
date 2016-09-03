/*
 */
package io.moquette.broker.server.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.ParseException;
import java.util.Properties;

/**
 * Configuration that loads file from the classpath
 *
 * @author andrea
 */
public class ClasspathConfig extends IConfig {

    private static final Logger LOG = LoggerFactory.getLogger(ClasspathConfig.class);

    private final Properties m_properties;

    public ClasspathConfig() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream is = classLoader.getResourceAsStream("config/moquette.conf");
        if (is == null) {
            throw new RuntimeException("Can't locate the resource \"config/moquette.conf\"");
        }
        Reader configReader = new InputStreamReader(is);
        ConfigurationParser confParser = new ConfigurationParser();
        //assignDefaults();
        try {
            confParser.parse(configReader);
        } catch (ParseException pex) {
            LOG.warn("An error occurred in parsing configuration, fallback on default configuration", pex);
        }
        m_properties = confParser.getProperties();
    }

    @Override
    public void setProperty(String name, String value) {
        m_properties.setProperty(name, value);
    }

    @Override
    public String getProperty(String name) {
        return m_properties.getProperty(name);
    }

    @Override
    public String getProperty(String name, String defaultValue) {
        return m_properties.getProperty(name, defaultValue);
    }
}
