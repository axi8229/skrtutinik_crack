package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KeyboardOptions.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0007\u0018\u0000 92\u00020\u0001:\u00019BU\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010B=\b\u0017\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000f\u0010\u0012J\u0019\u0010\u0017\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010\u001dR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b$\u0010%R\u001d\u0010\u0007\u001a\u00020\u00068\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b&\u0010\u001dR\u001d\u0010\t\u001a\u00020\b8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b'\u0010\u001dR\u0019\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010#\u001a\u0004\b(\u0010%R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010)\u001a\u0004\b*\u0010+R\u0014\u0010.\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u001a\u00100\u001a\u00020\u00028BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b/\u0010\u001dR\u001a\u00102\u001a\u00020\u00068BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b1\u0010\u001dR\u0014\u00104\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u0010+R\u001a\u00106\u001a\u00020\b8@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b5\u0010\u001dR\u0014\u00108\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b7\u0010-\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006:"}, d2 = {"Landroidx/compose/foundation/text/KeyboardOptions;", "", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "capitalization", "", "autoCorrectEnabled", "Landroidx/compose/ui/text/input/KeyboardType;", "keyboardType", "Landroidx/compose/ui/text/input/ImeAction;", "imeAction", "Landroidx/compose/ui/text/input/PlatformImeOptions;", "platformImeOptions", "showKeyboardOnFocus", "Landroidx/compose/ui/text/intl/LocaleList;", "hintLocales", "<init>", "(ILjava/lang/Boolean;IILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "autoCorrect", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "singleLine", "Landroidx/compose/ui/text/input/ImeOptions;", "toImeOptions$foundation_release", "(Z)Landroidx/compose/ui/text/input/ImeOptions;", "toImeOptions", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "I", "getCapitalization-IUNYP9k", "Ljava/lang/Boolean;", "getAutoCorrectEnabled", "()Ljava/lang/Boolean;", "getKeyboardType-PjHm6EE", "getImeAction-eUduSuo", "getShowKeyboardOnFocus", "Landroidx/compose/ui/text/intl/LocaleList;", "getHintLocales", "()Landroidx/compose/ui/text/intl/LocaleList;", "getAutoCorrectOrDefault", "()Z", "autoCorrectOrDefault", "getCapitalizationOrDefault-IUNYP9k", "capitalizationOrDefault", "getKeyboardTypeOrDefault-PjHm6EE", "keyboardTypeOrDefault", "getHintLocalesOrDefault", "hintLocalesOrDefault", "getImeActionOrDefault-eUduSuo$foundation_release", "imeActionOrDefault", "getShowKeyboardOnFocusOrDefault$foundation_release", "showKeyboardOnFocusOrDefault", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class KeyboardOptions {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KeyboardOptions Default = new KeyboardOptions(0, null, 0, 0, null, null, null, 127, null);
    private static final KeyboardOptions SecureTextField = new KeyboardOptions(0, Boolean.FALSE, KeyboardType.INSTANCE.m1927getPasswordPjHm6EE(), 0, null, null, null, 121, null);
    private final Boolean autoCorrectEnabled;
    private final int capitalization;
    private final LocaleList hintLocales;
    private final int imeAction;
    private final int keyboardType;
    private final Boolean showKeyboardOnFocus;

    public /* synthetic */ KeyboardOptions(int i, Boolean bool, int i2, int i3, PlatformImeOptions platformImeOptions, Boolean bool2, LocaleList localeList, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, bool, i2, i3, platformImeOptions, bool2, localeList);
    }

    @Deprecated
    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z, i2, i3, platformImeOptions);
    }

    private KeyboardOptions(int i, Boolean bool, int i2, int i3, PlatformImeOptions platformImeOptions, Boolean bool2, LocaleList localeList) {
        this.capitalization = i;
        this.autoCorrectEnabled = bool;
        this.keyboardType = i2;
        this.imeAction = i3;
        this.showKeyboardOnFocus = bool2;
        this.hintLocales = localeList;
    }

    public /* synthetic */ KeyboardOptions(int i, Boolean bool, int i2, int i3, PlatformImeOptions platformImeOptions, Boolean bool2, LocaleList localeList, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? KeyboardCapitalization.INSTANCE.m1913getUnspecifiedIUNYP9k() : i, (i4 & 2) != 0 ? null : bool, (i4 & 4) != 0 ? KeyboardType.INSTANCE.m1930getUnspecifiedPjHm6EE() : i2, (i4 & 8) != 0 ? ImeAction.INSTANCE.m1898getUnspecifiedeUduSuo() : i3, (i4 & 16) != 0 ? null : platformImeOptions, (i4 & 32) != 0 ? null : bool2, (i4 & 64) == 0 ? localeList : null, null);
    }

    /* compiled from: KeyboardOptions.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Landroidx/compose/foundation/text/KeyboardOptions$Companion;", "", "<init>", "()V", "Landroidx/compose/foundation/text/KeyboardOptions;", "Default", "Landroidx/compose/foundation/text/KeyboardOptions;", "getDefault", "()Landroidx/compose/foundation/text/KeyboardOptions;", "getDefault$annotations", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KeyboardOptions getDefault() {
            return KeyboardOptions.Default;
        }
    }

    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? KeyboardCapitalization.INSTANCE.m1911getNoneIUNYP9k() : i, (i4 & 2) != 0 ? Default.getAutoCorrectOrDefault() : z, (i4 & 4) != 0 ? KeyboardType.INSTANCE.m1929getTextPjHm6EE() : i2, (i4 & 8) != 0 ? ImeAction.INSTANCE.m1890getDefaulteUduSuo() : i3, (i4 & 16) != 0 ? null : platformImeOptions, null);
    }

    private KeyboardOptions(int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions) {
        this(i, Boolean.valueOf(z), i2, i3, platformImeOptions, Boolean.valueOf(Default.getShowKeyboardOnFocusOrDefault$foundation_release()), null, 64, null);
    }

    private final boolean getAutoCorrectOrDefault() {
        Boolean bool = this.autoCorrectEnabled;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    /* renamed from: getCapitalizationOrDefault-IUNYP9k, reason: not valid java name */
    private final int m417getCapitalizationOrDefaultIUNYP9k() {
        KeyboardCapitalization keyboardCapitalizationM1903boximpl = KeyboardCapitalization.m1903boximpl(this.capitalization);
        int value = keyboardCapitalizationM1903boximpl.getValue();
        KeyboardCapitalization.Companion companion = KeyboardCapitalization.INSTANCE;
        if (KeyboardCapitalization.m1906equalsimpl0(value, companion.m1913getUnspecifiedIUNYP9k())) {
            keyboardCapitalizationM1903boximpl = null;
        }
        return keyboardCapitalizationM1903boximpl != null ? keyboardCapitalizationM1903boximpl.getValue() : companion.m1911getNoneIUNYP9k();
    }

    /* renamed from: getKeyboardTypeOrDefault-PjHm6EE, reason: not valid java name */
    private final int m418getKeyboardTypeOrDefaultPjHm6EE() {
        KeyboardType keyboardTypeM1915boximpl = KeyboardType.m1915boximpl(this.keyboardType);
        int value = keyboardTypeM1915boximpl.getValue();
        KeyboardType.Companion companion = KeyboardType.INSTANCE;
        if (KeyboardType.m1918equalsimpl0(value, companion.m1930getUnspecifiedPjHm6EE())) {
            keyboardTypeM1915boximpl = null;
        }
        return keyboardTypeM1915boximpl != null ? keyboardTypeM1915boximpl.getValue() : companion.m1929getTextPjHm6EE();
    }

    /* renamed from: getImeActionOrDefault-eUduSuo$foundation_release, reason: not valid java name */
    public final int m419getImeActionOrDefaulteUduSuo$foundation_release() {
        ImeAction imeActionM1883boximpl = ImeAction.m1883boximpl(this.imeAction);
        int value = imeActionM1883boximpl.getValue();
        ImeAction.Companion companion = ImeAction.INSTANCE;
        if (ImeAction.m1886equalsimpl0(value, companion.m1898getUnspecifiedeUduSuo())) {
            imeActionM1883boximpl = null;
        }
        return imeActionM1883boximpl != null ? imeActionM1883boximpl.getValue() : companion.m1890getDefaulteUduSuo();
    }

    public final boolean getShowKeyboardOnFocusOrDefault$foundation_release() {
        Boolean bool = this.showKeyboardOnFocus;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    private final LocaleList getHintLocalesOrDefault() {
        LocaleList localeList = this.hintLocales;
        return localeList == null ? LocaleList.INSTANCE.getEmpty() : localeList;
    }

    public final ImeOptions toImeOptions$foundation_release(boolean singleLine) {
        return new ImeOptions(singleLine, m417getCapitalizationOrDefaultIUNYP9k(), getAutoCorrectOrDefault(), m418getKeyboardTypeOrDefaultPjHm6EE(), m419getImeActionOrDefaulteUduSuo$foundation_release(), null, getHintLocalesOrDefault(), null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeyboardOptions)) {
            return false;
        }
        KeyboardOptions keyboardOptions = (KeyboardOptions) other;
        if (!KeyboardCapitalization.m1906equalsimpl0(this.capitalization, keyboardOptions.capitalization) || !Intrinsics.areEqual(this.autoCorrectEnabled, keyboardOptions.autoCorrectEnabled) || !KeyboardType.m1918equalsimpl0(this.keyboardType, keyboardOptions.keyboardType) || !ImeAction.m1886equalsimpl0(this.imeAction, keyboardOptions.imeAction)) {
            return false;
        }
        keyboardOptions.getClass();
        return Intrinsics.areEqual(null, null) && Intrinsics.areEqual(this.showKeyboardOnFocus, keyboardOptions.showKeyboardOnFocus) && Intrinsics.areEqual(this.hintLocales, keyboardOptions.hintLocales);
    }

    public int hashCode() {
        int iM1907hashCodeimpl = KeyboardCapitalization.m1907hashCodeimpl(this.capitalization) * 31;
        Boolean bool = this.autoCorrectEnabled;
        int iHashCode = (((((iM1907hashCodeimpl + (bool != null ? bool.hashCode() : 0)) * 31) + KeyboardType.m1919hashCodeimpl(this.keyboardType)) * 31) + ImeAction.m1887hashCodeimpl(this.imeAction)) * 961;
        Boolean bool2 = this.showKeyboardOnFocus;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        LocaleList localeList = this.hintLocales;
        return iHashCode2 + (localeList != null ? localeList.hashCode() : 0);
    }

    public String toString() {
        return "KeyboardOptions(capitalization=" + ((Object) KeyboardCapitalization.m1908toStringimpl(this.capitalization)) + ", autoCorrectEnabled=" + this.autoCorrectEnabled + ", keyboardType=" + ((Object) KeyboardType.m1920toStringimpl(this.keyboardType)) + ", imeAction=" + ((Object) ImeAction.m1888toStringimpl(this.imeAction)) + ", platformImeOptions=" + ((Object) null) + "showKeyboardOnFocus=" + this.showKeyboardOnFocus + ", hintLocales=" + this.hintLocales + ')';
    }
}
