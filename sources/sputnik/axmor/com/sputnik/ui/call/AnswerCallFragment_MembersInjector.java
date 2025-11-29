package sputnik.axmor.com.sputnik.ui.call;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;
import sputnik.axmor.com.sputnik.ui.call.viewmodel.CallViewModel;

/* loaded from: classes5.dex */
public final class AnswerCallFragment_MembersInjector implements MembersInjector<AnswerCallFragment> {
    public static void injectLocalizationScreen(AnswerCallFragment answerCallFragment, LocalizationStorage localizationStorage) {
        answerCallFragment.localizationScreen = localizationStorage;
    }

    public static void injectCamerasFactory(AnswerCallFragment answerCallFragment, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        answerCallFragment.camerasFactory = assistFactory;
    }

    public static void injectCallViewModelFactory(AnswerCallFragment answerCallFragment, CallViewModel.Factory.AssistFactory assistFactory) {
        answerCallFragment.callViewModelFactory = assistFactory;
    }

    public static void injectAnalytics(AnswerCallFragment answerCallFragment, Analytics analytics) {
        answerCallFragment.analytics = analytics;
    }

    public static void injectPrefManager(AnswerCallFragment answerCallFragment, PrefManager prefManager) {
        answerCallFragment.prefManager = prefManager;
    }

    public static void injectFactory(AnswerCallFragment answerCallFragment, MultiViewModelFactory multiViewModelFactory) {
        answerCallFragment.factory = multiViewModelFactory;
    }
}
