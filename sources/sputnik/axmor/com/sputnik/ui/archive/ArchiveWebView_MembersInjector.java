package sputnik.axmor.com.sputnik.ui.archive;

import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class ArchiveWebView_MembersInjector implements MembersInjector<ArchiveWebView> {
    public static void injectFactory(ArchiveWebView archiveWebView, MultiViewModelFactory multiViewModelFactory) {
        archiveWebView.factory = multiViewModelFactory;
    }
}
