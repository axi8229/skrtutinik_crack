package com.huawei.wisesecurity.ucs_credential;

import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.utils.StringUtil;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;

/* loaded from: classes3.dex */
public class c0 {
    public static boolean a(Certificate[] certificateArr) throws UcsException {
        String strSubstring;
        if (certificateArr == null || certificateArr.length <= 0) {
            throw new UcsException(1022L, "isRootCertSupport params certificates is null!");
        }
        Certificate certificate = certificateArr[certificateArr.length - 1];
        if (certificate == null) {
            throw new UcsException(1022L, "params certificate is null!");
        }
        try {
            int i = 0;
            String[] strArrSplit = g.a(StringUtil.base64EncodeToString(certificate.getEncoded(), 0)).getSubjectDN().getName().split(",");
            String str = "CN" + ContainerUtils.KEY_VALUE_DELIMITER;
            int length = strArrSplit.length;
            while (true) {
                if (i >= length) {
                    strSubstring = null;
                    break;
                }
                String str2 = strArrSplit[i];
                if (str2.startsWith(str)) {
                    strSubstring = str2.substring(str.length());
                    break;
                }
                i++;
            }
            return "Android Keystore Software Attestation Root".equals(strSubstring);
        } catch (CertificateEncodingException e) {
            StringBuilder sbA = f.a("get certificate param fail: ");
            sbA.append(e.getMessage());
            throw new UcsException(1022L, sbA.toString());
        }
    }
}
