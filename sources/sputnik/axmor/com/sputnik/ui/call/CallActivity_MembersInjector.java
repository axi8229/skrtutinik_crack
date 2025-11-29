package sputnik.axmor.com.sputnik.ui.call;

import dagger.MembersInjector;
import sputnik.axmor.com.sputnik.ui.call.viewmodel.CallViewModel;

/* loaded from: classes5.dex */
public final class CallActivity_MembersInjector implements MembersInjector<CallActivity> {
    public static void injectCallFactory(CallActivity callActivity, CallViewModel.Factory.AssistFactory assistFactory) {
        callActivity.callFactory = assistFactory;
    }
}
