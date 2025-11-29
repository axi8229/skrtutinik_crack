package com.airbnb.lottie.utils;

import kotlin.KotlinVersion;

/* loaded from: classes.dex */
public class GammaEvaluator {
    private static float OECF_sRGB(float f) {
        return f <= 0.0031308f ? f * 12.92f : (float) ((Math.pow(f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    private static float EOCF_sRGB(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static int evaluate(float f, int i, int i2) {
        if (i == i2) {
            return i;
        }
        float f2 = ((i >> 24) & KotlinVersion.MAX_COMPONENT_VALUE) / 255.0f;
        float f3 = ((i >> 16) & KotlinVersion.MAX_COMPONENT_VALUE) / 255.0f;
        float f4 = ((i >> 8) & KotlinVersion.MAX_COMPONENT_VALUE) / 255.0f;
        float f5 = ((i2 >> 24) & KotlinVersion.MAX_COMPONENT_VALUE) / 255.0f;
        float f6 = ((i2 >> 16) & KotlinVersion.MAX_COMPONENT_VALUE) / 255.0f;
        float f7 = ((i2 >> 8) & KotlinVersion.MAX_COMPONENT_VALUE) / 255.0f;
        float fEOCF_sRGB = EOCF_sRGB(f3);
        float fEOCF_sRGB2 = EOCF_sRGB(f4);
        float fEOCF_sRGB3 = EOCF_sRGB((i & KotlinVersion.MAX_COMPONENT_VALUE) / 255.0f);
        float fEOCF_sRGB4 = EOCF_sRGB(f6);
        float f8 = f2 + ((f5 - f2) * f);
        float fEOCF_sRGB5 = fEOCF_sRGB2 + ((EOCF_sRGB(f7) - fEOCF_sRGB2) * f);
        float fEOCF_sRGB6 = fEOCF_sRGB3 + (f * (EOCF_sRGB((i2 & KotlinVersion.MAX_COMPONENT_VALUE) / 255.0f) - fEOCF_sRGB3));
        return (Math.round(OECF_sRGB(fEOCF_sRGB + ((fEOCF_sRGB4 - fEOCF_sRGB) * f)) * 255.0f) << 16) | (Math.round(f8 * 255.0f) << 24) | (Math.round(OECF_sRGB(fEOCF_sRGB5) * 255.0f) << 8) | Math.round(OECF_sRGB(fEOCF_sRGB6) * 255.0f);
    }
}
