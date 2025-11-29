package org.jose4j.json.internal.json_simple.parser;

/* loaded from: classes4.dex */
public class ParseException extends Exception {
    private int errorType;
    private int position;
    private Object unexpectedObject;

    public ParseException(int i, int i2, Object obj) {
        this.position = i;
        this.errorType = i2;
        this.unexpectedObject = obj;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        int i = this.errorType;
        if (i == 0) {
            sb.append("Unexpected character (");
            sb.append(this.unexpectedObject);
            sb.append(") at position ");
            sb.append(this.position);
            sb.append(".");
        } else if (i == 1) {
            sb.append("Unexpected token ");
            sb.append(this.unexpectedObject);
            sb.append(" at position ");
            sb.append(this.position);
            sb.append(".");
        } else if (i == 2) {
            sb.append("Unexpected exception at position ");
            sb.append(this.position);
            sb.append(": ");
            sb.append(this.unexpectedObject);
        } else {
            sb.append("Unknown error at position ");
            sb.append(this.position);
            sb.append(".");
        }
        return sb.toString();
    }
}
