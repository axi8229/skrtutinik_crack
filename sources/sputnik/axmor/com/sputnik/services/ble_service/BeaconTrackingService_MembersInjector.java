package sputnik.axmor.com.sputnik.services.ble_service;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.repositories.cameras.ICamerasRepository;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class BeaconTrackingService_MembersInjector implements MembersInjector<BeaconTrackingService> {
    public static void injectCamerasRepository(BeaconTrackingService beaconTrackingService, ICamerasRepository iCamerasRepository) {
        beaconTrackingService.camerasRepository = iCamerasRepository;
    }

    public static void injectPrefs(BeaconTrackingService beaconTrackingService, PrefManager prefManager) {
        beaconTrackingService.prefs = prefManager;
    }

    public static void injectAnalytics(BeaconTrackingService beaconTrackingService, Analytics analytics) {
        beaconTrackingService.analytics = analytics;
    }

    public static void injectLocalizationStorage(BeaconTrackingService beaconTrackingService, LocalizationStorage localizationStorage) {
        beaconTrackingService.localizationStorage = localizationStorage;
    }
}
