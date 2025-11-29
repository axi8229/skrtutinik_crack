package sputnik.axmor.com.sputnik.ui.main.cameras.survay;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class SurveyCommentFragment_MembersInjector implements MembersInjector<SurveyCommentFragment> {
    public static void injectFactory(SurveyCommentFragment surveyCommentFragment, MultiViewModelFactory multiViewModelFactory) {
        surveyCommentFragment.factory = multiViewModelFactory;
    }

    public static void injectLocalizationScreen(SurveyCommentFragment surveyCommentFragment, LocalizationStorage localizationStorage) {
        surveyCommentFragment.localizationScreen = localizationStorage;
    }
}
