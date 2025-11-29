package com.huawei.location.lite.common.android.receiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.secure.android.common.util.SafeString;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class PackageReceiver extends SafeBroadcastReceiver {
    private static final byte[] SYNC_LOCK = new byte[0];
    private static volatile PackageReceiver instance;
    AtomicBoolean isRegisterBr = new AtomicBoolean(false);
    private List<PackageOperateCallback> callbackList = new CopyOnWriteArrayList();

    public static PackageReceiver getInstance() {
        if (instance == null) {
            synchronized (SYNC_LOCK) {
                try {
                    if (instance == null) {
                        instance = new PackageReceiver();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    private IntentFilter getPackageFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        return intentFilter;
    }

    @Override // com.huawei.location.lite.common.android.receiver.SafeBroadcastReceiver
    public void onSafeReceive(Intent intent) {
        if (intent == null) {
            LogLocation.e("PackageReceiver", "PackageReceiver receive null intent");
            return;
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        String dataString = safeIntent.getDataString();
        if (TextUtils.isEmpty(dataString)) {
            dataString = "";
        }
        String strReplace = SafeString.replace(dataString, "package:", "");
        if ("android.intent.action.PACKAGE_REMOVED".equals(safeIntent.getAction())) {
            LogLocation.d("PackageReceiver", "package_remove:" + strReplace);
            for (PackageOperateCallback packageOperateCallback : this.callbackList) {
                if (packageOperateCallback != null) {
                    packageOperateCallback.onRemoved(strReplace);
                }
            }
            return;
        }
        if ("android.intent.action.PACKAGE_ADDED".equals(safeIntent.getAction())) {
            LogLocation.d("PackageReceiver", "package_add:" + strReplace);
            for (PackageOperateCallback packageOperateCallback2 : this.callbackList) {
                if (packageOperateCallback2 != null) {
                    packageOperateCallback2.onAdded(strReplace);
                }
            }
            return;
        }
        if (!"android.intent.action.PACKAGE_REPLACED".equals(safeIntent.getAction())) {
            LogLocation.d("PackageReceiver", "action ===:" + safeIntent.getAction());
            return;
        }
        LogLocation.d("PackageReceiver", "package_replace:" + strReplace);
        for (PackageOperateCallback packageOperateCallback3 : this.callbackList) {
            if (packageOperateCallback3 != null) {
                packageOperateCallback3.onReplaced(strReplace);
            }
        }
    }

    @Override // com.huawei.location.lite.common.android.receiver.SafeBroadcastReceiver
    public String receiveThreadName() {
        return "Loc_Package_Listener";
    }

    public void registerCallback(PackageOperateCallback packageOperateCallback) {
        if (packageOperateCallback != null) {
            this.callbackList.add(packageOperateCallback);
        }
        if (this.isRegisterBr.get()) {
            return;
        }
        ContextUtil.getContext().registerReceiver(getInstance(), getPackageFilter());
        this.isRegisterBr.set(true);
    }

    @Override // com.huawei.location.lite.common.android.receiver.SafeBroadcastReceiver
    public int threadExitDelayTime() {
        return 0;
    }
}
