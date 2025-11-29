package sputnik.axmor.com.sputnik.utils;

import com.axmor.axvoip.mojo.pjm.common.PjmAccountConfig;
import org.pjsip.pjsua2.AccountConfig;
import org.pjsip.pjsua2.AccountRegConfig;
import org.pjsip.pjsua2.AccountSipConfig;
import org.pjsip.pjsua2.AuthCredInfo;

/* loaded from: classes5.dex */
public class SipConfigUtils {
    public static AccountConfig generateSipAccountConfig(String str, String str2, String str3, int i) {
        String idUri = i == -1 ? PjmAccountConfig.formatIdUri(str, str3) : PjmAccountConfig.formatIdUri(str, str3, i);
        String registrarUri = i == -1 ? PjmAccountConfig.formatRegistrarUri(str3) : PjmAccountConfig.formatRegistrarUri(str3, i);
        AccountConfig accountConfig = new AccountConfig();
        accountConfig.setIdUri(idUri);
        accountConfig.getCallConfig().setTimerMinSESec(90L);
        accountConfig.getCallConfig().setTimerSessExpiresSec(90L);
        AccountRegConfig regConfig = accountConfig.getRegConfig();
        regConfig.setRegistrarUri(registrarUri);
        regConfig.setTimeoutSec(600L);
        AuthCredInfo authCredInfo = new AuthCredInfo();
        authCredInfo.setUsername(str);
        authCredInfo.setData(str2);
        AccountSipConfig sipConfig = accountConfig.getSipConfig();
        sipConfig.getAuthCreds().clear();
        sipConfig.getAuthCreds().add(authCredInfo);
        accountConfig.getNatConfig().setIceEnabled(true);
        return accountConfig;
    }
}
