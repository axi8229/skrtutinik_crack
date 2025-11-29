package sputnik.axmor.com.sputnik.ui.main.market.services.archive_service;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class SelectArchiveBottomSheet_MembersInjector implements MembersInjector<SelectArchiveBottomSheet> {
    public static void injectLocalizationScreen(SelectArchiveBottomSheet selectArchiveBottomSheet, LocalizationStorage localizationStorage) {
        selectArchiveBottomSheet.localizationScreen = localizationStorage;
    }

    public static void injectFactory(SelectArchiveBottomSheet selectArchiveBottomSheet, MultiViewModelFactory multiViewModelFactory) {
        selectArchiveBottomSheet.factory = multiViewModelFactory;
    }

    public static void injectCamerasFactory(SelectArchiveBottomSheet selectArchiveBottomSheet, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        selectArchiveBottomSheet.camerasFactory = assistFactory;
    }
}
