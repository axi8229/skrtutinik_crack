package sputnik.axmor.com.sputnik.services.ble_service;

import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class RebootBroadcastReceiver_MembersInjector implements MembersInjector<RebootBroadcastReceiver> {
    public static void injectPreferences(RebootBroadcastReceiver rebootBroadcastReceiver, PrefManager prefManager) {
        rebootBroadcastReceiver.preferences = prefManager;
    }
}
