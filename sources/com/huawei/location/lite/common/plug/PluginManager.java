package com.huawei.location.lite.common.plug;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class PluginManager {
    private PluginServiceLoader<IPlugin> pluginServiceLoader;

    private static final class PluginManagerHolder {
        private static final PluginManager PLUGIN_MANAGER = new PluginManager();
    }

    private PluginManager() {
        this.pluginServiceLoader = PluginServiceLoader.load(IPlugin.class);
    }

    public static PluginManager getInstance() {
        return PluginManagerHolder.PLUGIN_MANAGER;
    }

    public <T> void startFunction(int i, String str, PluginReqMessage pluginReqMessage, IPluginResult<T> iPluginResult) {
        List<IPlugin> listLoadService = this.pluginServiceLoader.loadService(i);
        if (listLoadService.isEmpty()) {
            return;
        }
        Iterator<IPlugin> it = listLoadService.iterator();
        while (it.hasNext()) {
            it.next().startFunction(str, pluginReqMessage, iPluginResult);
        }
    }
}
