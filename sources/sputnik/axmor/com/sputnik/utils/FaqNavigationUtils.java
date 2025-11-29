package sputnik.axmor.com.sputnik.utils;

import androidx.core.os.BundleKt;
import androidx.navigation.NavController;
import com.sputnik.common.extensions.NavControllerKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.R;

/* compiled from: FaqNavigationUtils.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lsputnik/axmor/com/sputnik/utils/FaqNavigationUtils;", "", "<init>", "()V", "Landroidx/navigation/NavController;", "navController", "", "categoryId", "questionId", "", "navigateToFaqQuestion", "(Landroidx/navigation/NavController;JJ)V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FaqNavigationUtils {
    public static final FaqNavigationUtils INSTANCE = new FaqNavigationUtils();

    private FaqNavigationUtils() {
    }

    public final void navigateToFaqQuestion(NavController navController, long categoryId, long questionId) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        NavControllerKt.safeNavigate$default(navController, R.id.action_global_to_faqCategoriesFragment, BundleKt.bundleOf(TuplesKt.to("faq_category_id", Long.valueOf(categoryId)), TuplesKt.to("faq_question_id", Long.valueOf(questionId))), null, 4, null);
    }
}
