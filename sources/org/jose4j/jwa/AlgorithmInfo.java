package org.jose4j.jwa;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.jose4j.keys.KeyPersuasion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: classes4.dex */
public abstract class AlgorithmInfo implements Algorithm {
    private String algorithmIdentifier;
    private String javaAlgorithm;
    private KeyPersuasion keyPersuasion;
    private String keyType;
    protected final Logger log = LoggerFactory.getLogger(getClass());

    public void setAlgorithmIdentifier(String str) {
        this.algorithmIdentifier = str;
    }

    public void setJavaAlgorithm(String str) {
        this.javaAlgorithm = str;
    }

    public String getJavaAlgorithm() {
        return this.javaAlgorithm;
    }

    @Override // org.jose4j.jwa.Algorithm
    public String getAlgorithmIdentifier() {
        return this.algorithmIdentifier;
    }

    public void setKeyPersuasion(KeyPersuasion keyPersuasion) {
        this.keyPersuasion = keyPersuasion;
    }

    public void setKeyType(String str) {
        this.keyType = str;
    }

    public String toString() {
        return getClass().getName() + "(" + this.algorithmIdentifier + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.javaAlgorithm + ")";
    }
}
