package org.jivesoftware.openfire.plugin.fwexample;

import org.jivesoftware.openfire.container.Plugin;
import org.jivesoftware.openfire.container.PluginManager;
import org.jivesoftware.openfire.interceptor.InterceptorManager;
import org.jivesoftware.openfire.interceptor.PacketInterceptor;
import org.jivesoftware.openfire.interceptor.PacketRejectedException;
import org.jivesoftware.openfire.session.Session;
import org.jivesoftware.util.SystemProperty;
import org.xmpp.packet.Packet;

import java.io.File;

public class ExamplePlugin implements Plugin, PacketInterceptor {


    private static final String PLUGIN_NAME = "fwexample"; // 与plugin.xml一致

    // region Constructor
    private static ExamplePlugin instance;

    public static ExamplePlugin getInstance() {
        return instance;
    }

    public ExamplePlugin() {
        // We may only have one instance of the plugin running on the JVM
        if (instance != null) {
            throw new IllegalStateException("A example plugin is already running");
        }
        instance = this;
    }
    // endregion Constructor

    // region Plugin接口实现
    @Override
    public void initializePlugin(PluginManager manager, File pluginDirectory) {
        int a = 10;
        a++;
        System.out.println("initialize example plugin...");
        InterceptorManager.getInstance().addInterceptor(this);
        int k = 100;
        System.out.println("i say heiheihei @@@@@@@@@@@@@@@@@");
    }

    @Override
    public void destroyPlugin() {
        System.out.println("destroy example plugin...");
        System.out.println("i say lalala @@@@@@@@@@@@@@@@@");

    }
    // endregion Plugin接口实现

    // region 插件属性配置
    // 对于一个final变量，如果是基本数据类型的变量，则其数值一旦在初始化之后便不能更改；如果是引用类型的变量，则在对其初始化之后便不能再让其指向另一个对象。
    private static final String PROPERTY_PREFIX = "plugin.fwexample.";
    private boolean logToConsole;
    private boolean logToFile;

    public boolean isLogToConsole() {
        return logToConsole;
    }

    public void setLogToConsole(boolean logToConsole) {
        this.logToConsole = logToConsole;
    }

    public boolean isLogToFile() {
        return logToFile;
    }

    public void setLogToFile(boolean logToFile) {
        this.logToFile = logToFile;
    }

    private final SystemProperty<Boolean> logToConsoleProp = SystemProperty.Builder.ofType(Boolean.class)
        .setKey(PROPERTY_PREFIX + "logToConsole")
        .setDefaultValue(Boolean.TRUE)
        .setDynamic(true)
        .setPlugin(PLUGIN_NAME)
        .addListener(enabled -> ExamplePlugin.this.logToConsole = enabled)
        .build();

    private final SystemProperty<Boolean> logToFileProp = SystemProperty.Builder.ofType(Boolean.class)
        .setKey(PROPERTY_PREFIX + "logToFile")
        .setDefaultValue(Boolean.FALSE)
        .setDynamic(true)
        .setPlugin(PLUGIN_NAME)
        .addListener(enabled -> ExamplePlugin.this.logToFile = enabled)
        .build();
    // endregion 插件属性配置

    @Override
    public void interceptPacket(Packet packet, Session session, boolean incoming, boolean processed) throws PacketRejectedException {
        System.out.println("intercept packet by example plugin...");
        System.out.println("intercept packet by example plugin.@@@@@@@@@@@@@@@@@@@@..");
    }

}
