package ru.yoomoney.sdk.yoopinning;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EtagRepository.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lru/yoomoney/sdk/yoopinning/ETagRepositoryImpl;", "Lru/yoomoney/sdk/yoopinning/ETagRepository;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "sharedPref", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getLastETag", "", "saveETag", "", "eTag", "Companion", "yoopinning_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ETagRepositoryImpl implements ETagRepository {
    private final SharedPreferences sharedPref;

    public ETagRepositoryImpl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.sharedPref = context.getSharedPreferences("ru.yoomoney.sdk.yoopinning.PREFERENCE_FILE_KEY", 0);
    }

    @Override // ru.yoomoney.sdk.yoopinning.ETagRepository
    public void saveETag(String eTag) {
        Intrinsics.checkNotNullParameter(eTag, "eTag");
        SharedPreferences.Editor editorEdit = this.sharedPref.edit();
        editorEdit.putString("ru.yoomoney.sdk.yoopinning.PREFERENCE_ETAG_KEY", eTag);
        editorEdit.apply();
    }

    @Override // ru.yoomoney.sdk.yoopinning.ETagRepository
    public String getLastETag() {
        String string = this.sharedPref.getString("ru.yoomoney.sdk.yoopinning.PREFERENCE_ETAG_KEY", "");
        return string == null ? "" : string;
    }
}
