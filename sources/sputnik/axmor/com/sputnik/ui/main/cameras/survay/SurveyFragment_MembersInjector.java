package sputnik.axmor.com.sputnik.ui.main.cameras.survay;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class SurveyFragment_MembersInjector implements MembersInjector<SurveyFragment> {
    public static void injectLocalizationScreen(SurveyFragment surveyFragment, LocalizationStorage localizationStorage) {
        surveyFragment.localizationScreen = localizationStorage;
    }

    public static void injectFactory(SurveyFragment surveyFragment, MultiViewModelFactory multiViewModelFactory) {
        surveyFragment.factory = multiViewModelFactory;
    }
}
