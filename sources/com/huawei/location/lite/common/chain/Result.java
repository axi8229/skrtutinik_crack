package com.huawei.location.lite.common.chain;

/* loaded from: classes3.dex */
public abstract class Result {
    protected Data outputData;

    public static final class Failure extends Result {
        public Failure() {
            this(Data.EMPTY);
        }

        public Failure(Data data) {
            this.outputData = data;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && Failure.class == obj.getClass() && (obj instanceof Failure)) {
                return this.outputData.equals(((Failure) obj).outputData);
            }
            return false;
        }

        public int hashCode() {
            return this.outputData.hashCode() - 1087636498;
        }

        public String toString() {
            return "Failure {outputData=" + this.outputData + '}';
        }
    }

    public static final class Success extends Result {
        public Success() {
            this(Data.EMPTY);
        }

        public Success(Data data) {
            this.outputData = data;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && Success.class == obj.getClass() && (obj instanceof Success)) {
                return this.outputData.equals(((Success) obj).outputData);
            }
            return false;
        }

        public int hashCode() {
            return this.outputData.hashCode() + 483703957;
        }

        public String toString() {
            return "Success {outputData=" + this.outputData + '}';
        }
    }

    Result() {
    }

    public static Result failure() {
        return new Failure();
    }

    public static Result failure(Data data) {
        return new Failure(data);
    }

    public static Result success(Data data) {
        return new Success(data);
    }

    public Data getOutputData() {
        return this.outputData;
    }
}
