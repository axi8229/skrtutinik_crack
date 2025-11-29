package androidx.compose.ui.text.font;

import androidx.compose.ui.text.font.AsyncTypefaceCache;
import androidx.compose.ui.text.font.FontLoadingStrategy;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* compiled from: FontListFontFamilyTypefaceAdapter.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aR\u0010\u0000\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\fH\u0002¨\u0006\r"}, d2 = {"firstImmediatelyAvailable", "Lkotlin/Pair;", "", "Landroidx/compose/ui/text/font/Font;", "", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "asyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "createDefaultTypeface", "Lkotlin/Function1;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FontListFontFamilyTypefaceAdapterKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<List<Font>, Object> firstImmediatelyAvailable(List<? extends Font> list, TypefaceRequest typefaceRequest, AsyncTypefaceCache asyncTypefaceCache, PlatformFontLoader platformFontLoader, Function1<? super TypefaceRequest, ? extends Object> function1) {
        Object objLoadBlocking;
        Font font;
        Object objM2628constructorimpl;
        Font font2;
        int size = list.size();
        List listMutableListOf = null;
        for (int i = 0; i < size; i++) {
            Font font3 = list.get(i);
            int loadingStrategy = font3.getLoadingStrategy();
            FontLoadingStrategy.Companion companion = FontLoadingStrategy.INSTANCE;
            if (FontLoadingStrategy.m1837equalsimpl0(loadingStrategy, companion.m1841getBlockingPKNRLFQ())) {
                synchronized (asyncTypefaceCache.cacheLock) {
                    try {
                        AsyncTypefaceCache.Key key = new AsyncTypefaceCache.Key(font3, platformFontLoader.getCacheKey());
                        AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResult = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.resultCache.get(key);
                        if (asyncTypefaceResult == null) {
                            asyncTypefaceResult = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.permanentCache.get(key);
                        }
                        if (asyncTypefaceResult != null) {
                            objLoadBlocking = asyncTypefaceResult.getResult();
                            font = font3;
                        } else {
                            Unit unit = Unit.INSTANCE;
                            try {
                                objLoadBlocking = platformFontLoader.loadBlocking(font3);
                                font = font3;
                                AsyncTypefaceCache.put$default(asyncTypefaceCache, font3, platformFontLoader, objLoadBlocking, false, 8, null);
                            } catch (Exception e) {
                                throw new IllegalStateException("Unable to load font " + font3, e);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (objLoadBlocking != null) {
                    return TuplesKt.to(listMutableListOf, FontSynthesis_androidKt.m1866synthesizeTypefaceFxwP2eA(typefaceRequest.getFontSynthesis(), objLoadBlocking, font, typefaceRequest.getFontWeight(), typefaceRequest.getFontStyle()));
                }
                throw new IllegalStateException("Unable to load font " + font);
            }
            if (FontLoadingStrategy.m1837equalsimpl0(loadingStrategy, companion.m1842getOptionalLocalPKNRLFQ())) {
                synchronized (asyncTypefaceCache.cacheLock) {
                    try {
                        AsyncTypefaceCache.Key key2 = new AsyncTypefaceCache.Key(font3, platformFontLoader.getCacheKey());
                        AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResult2 = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.resultCache.get(key2);
                        if (asyncTypefaceResult2 == null) {
                            asyncTypefaceResult2 = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.permanentCache.get(key2);
                        }
                        if (asyncTypefaceResult2 != null) {
                            objM2628constructorimpl = asyncTypefaceResult2.getResult();
                            font2 = font3;
                        } else {
                            Unit unit2 = Unit.INSTANCE;
                            try {
                                Result.Companion companion2 = Result.INSTANCE;
                                objM2628constructorimpl = Result.m2628constructorimpl(platformFontLoader.loadBlocking(font3));
                            } catch (Throwable th2) {
                                Result.Companion companion3 = Result.INSTANCE;
                                objM2628constructorimpl = Result.m2628constructorimpl(ResultKt.createFailure(th2));
                            }
                            if (Result.m2633isFailureimpl(objM2628constructorimpl)) {
                                objM2628constructorimpl = null;
                            }
                            font2 = font3;
                            AsyncTypefaceCache.put$default(asyncTypefaceCache, font3, platformFontLoader, objM2628constructorimpl, false, 8, null);
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                if (objM2628constructorimpl != null) {
                    return TuplesKt.to(listMutableListOf, FontSynthesis_androidKt.m1866synthesizeTypefaceFxwP2eA(typefaceRequest.getFontSynthesis(), objM2628constructorimpl, font2, typefaceRequest.getFontWeight(), typefaceRequest.getFontStyle()));
                }
            } else {
                if (!FontLoadingStrategy.m1837equalsimpl0(loadingStrategy, companion.m1840getAsyncPKNRLFQ())) {
                    throw new IllegalStateException("Unknown font type " + font3);
                }
                AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResultM1823get1ASDuI8 = asyncTypefaceCache.m1823get1ASDuI8(font3, platformFontLoader);
                if (asyncTypefaceResultM1823get1ASDuI8 != null) {
                    if (!AsyncTypefaceCache.AsyncTypefaceResult.m1828isPermanentFailureimpl(asyncTypefaceResultM1823get1ASDuI8.getResult()) && asyncTypefaceResultM1823get1ASDuI8.getResult() != null) {
                        return TuplesKt.to(listMutableListOf, FontSynthesis_androidKt.m1866synthesizeTypefaceFxwP2eA(typefaceRequest.getFontSynthesis(), asyncTypefaceResultM1823get1ASDuI8.getResult(), font3, typefaceRequest.getFontWeight(), typefaceRequest.getFontStyle()));
                    }
                } else if (listMutableListOf == null) {
                    listMutableListOf = CollectionsKt.mutableListOf(font3);
                } else {
                    listMutableListOf.add(font3);
                }
            }
        }
        return TuplesKt.to(listMutableListOf, function1.invoke(typefaceRequest));
    }
}
