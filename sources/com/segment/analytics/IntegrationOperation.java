package com.segment.analytics;

import android.app.Activity;
import android.os.Bundle;

/* loaded from: classes3.dex */
abstract class IntegrationOperation {
    static final IntegrationOperation FLUSH = new IntegrationOperation() { // from class: com.segment.analytics.IntegrationOperation.9
        public String toString() {
            return "Flush";
        }
    };
    static final IntegrationOperation RESET = new IntegrationOperation() { // from class: com.segment.analytics.IntegrationOperation.10
        public String toString() {
            return "Reset";
        }
    };

    static IntegrationOperation onActivityCreated(final Activity activity, final Bundle bundle) {
        return new IntegrationOperation() { // from class: com.segment.analytics.IntegrationOperation.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            public String toString() {
                return "Activity Created";
            }
        };
    }

    static IntegrationOperation onActivityStarted(final Activity activity) {
        return new IntegrationOperation() { // from class: com.segment.analytics.IntegrationOperation.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            public String toString() {
                return "Activity Started";
            }
        };
    }

    static IntegrationOperation onActivityResumed(final Activity activity) {
        return new IntegrationOperation() { // from class: com.segment.analytics.IntegrationOperation.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            public String toString() {
                return "Activity Resumed";
            }
        };
    }

    static IntegrationOperation onActivityPaused(final Activity activity) {
        return new IntegrationOperation() { // from class: com.segment.analytics.IntegrationOperation.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            public String toString() {
                return "Activity Paused";
            }
        };
    }

    static IntegrationOperation onActivityStopped(final Activity activity) {
        return new IntegrationOperation() { // from class: com.segment.analytics.IntegrationOperation.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            public String toString() {
                return "Activity Stopped";
            }
        };
    }

    static IntegrationOperation onActivitySaveInstanceState(final Activity activity, final Bundle bundle) {
        return new IntegrationOperation() { // from class: com.segment.analytics.IntegrationOperation.6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            public String toString() {
                return "Activity Save Instance";
            }
        };
    }

    static IntegrationOperation onActivityDestroyed(final Activity activity) {
        return new IntegrationOperation() { // from class: com.segment.analytics.IntegrationOperation.7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            public String toString() {
                return "Activity Destroyed";
            }
        };
    }

    private IntegrationOperation() {
    }
}
