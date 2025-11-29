package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.DataSource;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public interface HttpDataSource extends DataSource {

    public interface Factory extends DataSource.Factory {
        @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
        HttpDataSource createDataSource();
    }

    void setRequestProperty(String name, String value);

    public static final class RequestProperties {
        private final Map<String, String> requestProperties = new HashMap();
        private Map<String, String> requestPropertiesSnapshot;

        public synchronized void set(String name, String value) {
            this.requestPropertiesSnapshot = null;
            this.requestProperties.put(name, value);
        }

        public synchronized Map<String, String> getSnapshot() {
            try {
                if (this.requestPropertiesSnapshot == null) {
                    this.requestPropertiesSnapshot = Collections.unmodifiableMap(new HashMap(this.requestProperties));
                }
            } catch (Throwable th) {
                throw th;
            }
            return this.requestPropertiesSnapshot;
        }
    }

    public static abstract class BaseFactory implements Factory {
        private final RequestProperties defaultRequestProperties = new RequestProperties();

        protected abstract HttpDataSource createDataSourceInternal(RequestProperties defaultRequestProperties);

        @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
        public final HttpDataSource createDataSource() {
            return createDataSourceInternal(this.defaultRequestProperties);
        }
    }

    public static class HttpDataSourceException extends IOException {
        public final DataSpec dataSpec;
        public final int type;

        public HttpDataSourceException(String message, DataSpec dataSpec, int type) {
            super(message);
            this.dataSpec = dataSpec;
            this.type = type;
        }

        public HttpDataSourceException(IOException cause, DataSpec dataSpec, int type) {
            super(cause);
            this.dataSpec = dataSpec;
            this.type = type;
        }

        public HttpDataSourceException(String message, IOException cause, DataSpec dataSpec, int type) {
            super(message, cause);
            this.dataSpec = dataSpec;
            this.type = type;
        }
    }

    public static final class InvalidResponseCodeException extends HttpDataSourceException {
        public final Map<String, List<String>> headerFields;
        public final int responseCode;
        public final String responseMessage;

        public InvalidResponseCodeException(int responseCode, String responseMessage, Map<String, List<String>> headerFields, DataSpec dataSpec) {
            super("Response code: " + responseCode, dataSpec, 1);
            this.responseCode = responseCode;
            this.responseMessage = responseMessage;
            this.headerFields = headerFields;
        }
    }
}
