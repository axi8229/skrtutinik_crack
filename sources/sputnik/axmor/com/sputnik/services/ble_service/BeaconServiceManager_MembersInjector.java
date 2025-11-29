package sputnik.axmor.com.sputnik.services.ble_service;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class BeaconServiceManager_MembersInjector implements MembersInjector<BeaconServiceManager> {
    public static void injectPrefManager(BeaconServiceManager beaconServiceManager, PrefManager prefManager) {
        beaconServiceManager.prefManager = prefManager;
    }

    public static void injectLocalizationStorage(BeaconServiceManager beaconServiceManager, LocalizationStorage localizationStorage) {
        beaconServiceManager.localizationStorage = localizationStorage;
    }
}
