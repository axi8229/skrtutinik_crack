package npi.spay;

/* renamed from: npi.spay.xd, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2040xd extends IllegalStateException {
    public static final C2040xd a = new C2040xd();

    public C2040xd() {
        super("Trying to access viewBinding outside of lifecycle");
    }
}
