package com.huawei.location.callback;

import com.huawei.location.base.activity.callback.ARCallback;

/* loaded from: classes3.dex */
public class yn<ARCallBackInfo> extends FB {
    private static volatile yn FB;
    private static final byte[] Vw = new byte[0];

    /* renamed from: com.huawei.location.callback.yn$yn, reason: collision with other inner class name */
    public static class C0083yn extends LW {
        private ARCallback FB;

        public ARCallback FB() {
            return this.FB;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if ((obj instanceof C0083yn) && this.FB.equals(((C0083yn) obj).FB)) {
                return true;
            }
            return super.equals(obj);
        }

        public int hashCode() {
            return super.hashCode();
        }

        public void yn(ARCallback aRCallback) {
            this.FB = aRCallback;
        }
    }

    private yn() {
    }

    public static yn Vw() {
        if (FB == null) {
            synchronized (Vw) {
                try {
                    if (FB == null) {
                        FB = new yn();
                    }
                } finally {
                }
            }
        }
        return FB;
    }

    @Override // com.huawei.location.callback.FB
    public String yn() {
        return "ARCallbackManager";
    }
}
