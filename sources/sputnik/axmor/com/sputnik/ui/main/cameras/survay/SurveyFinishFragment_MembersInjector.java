package sputnik.axmor.com.sputnik.ui.main.cameras.survay;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class SurveyFinishFragment_MembersInjector implements MembersInjector<SurveyFinishFragment> {
    public static void injectLocalizationScreen(SurveyFinishFragment surveyFinishFragment, LocalizationStorage localizationStorage) {
        surveyFinishFragment.localizationScreen = localizationStorage;
    }

    public static void injectFactory(SurveyFinishFragment surveyFinishFragment, MultiViewModelFactory multiViewModelFactory) {
        surveyFinishFragment.factory = multiViewModelFactory;
    }
}
