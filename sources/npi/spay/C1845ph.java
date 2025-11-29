package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import retrofit2.Converter;

/* renamed from: npi.spay.ph, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1845ph implements Converter {
    public static final C1820oh a = new C1820oh();

    @Override // retrofit2.Converter
    public final Object convert(Object obj) {
        ResponseBody responseBody = (ResponseBody) obj;
        Intrinsics.checkNotNullParameter(responseBody, "responseBody");
        Document document = Jsoup.parse(responseBody.string());
        Intrinsics.checkNotNullExpressionValue(document, "parse(responseBody.string())");
        return new Hg(document);
    }
}
