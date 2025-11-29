package ru.yoomoney.sdk.auth.phone.enter.utils;

import android.text.Editable;
import android.widget.EditText;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.yoomoney.sdk.auth.utils.PhoneUtilsKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/phone/enter/utils/PhoneNumberWatcher;", "Lru/yoomoney/sdk/auth/phone/enter/utils/PhoneNumberDetectionWatcher;", "editText", "Landroid/widget/EditText;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "", "", "prefix", "", "region", "(Landroid/widget/EditText;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Ljava/lang/String;)V", "prevValid", "prevValidNumber", "afterTextChanged", "editable", "Landroid/text/Editable;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PhoneNumberWatcher extends PhoneNumberDetectionWatcher {
    private final Function1<Boolean, Unit> listener;
    private final String prefix;
    private boolean prevValid;
    private String prevValidNumber;
    private final String region;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PhoneNumberWatcher(EditText editText, Function1<? super Boolean, Unit> listener, String prefix, String region) {
        super(editText, region);
        Intrinsics.checkNotNullParameter(editText, "editText");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(region, "region");
        this.listener = listener;
        this.prefix = prefix;
        this.region = region;
    }

    @Override // ru.yoomoney.sdk.auth.phone.enter.utils.PhoneNumberDetectionWatcher, android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable == null) {
            return;
        }
        boolean z = false;
        if (!StringsKt.startsWith$default(editable.toString(), this.prefix, false, 2, (Object) null)) {
            editable.replace(0, editable.length(), this.prefix);
            return;
        }
        super.afterTextChanged(editable);
        String string = editable.toString();
        try {
            if (PhoneUtilsKt.getPhoneUtil().isPossibleNumberWithReason(PhoneUtilsKt.getPhoneUtil().parse(string, this.region)) == PhoneNumberUtil.ValidationResult.IS_POSSIBLE) {
                z = true;
            }
        } catch (Exception unused) {
        }
        if (this.prevValid != z || (z && !Intrinsics.areEqual(string, this.prevValidNumber))) {
            this.listener.invoke(Boolean.valueOf(z));
            this.prevValid = z;
            if (z) {
                this.prevValidNumber = string;
            }
        }
    }
}
