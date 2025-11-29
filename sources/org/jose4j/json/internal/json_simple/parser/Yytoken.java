package org.jose4j.json.internal.json_simple.parser;

/* loaded from: classes4.dex */
public class Yytoken {
    public int type;
    public Object value;

    public Yytoken(int i, Object obj) {
        this.type = i;
        this.value = obj;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        switch (this.type) {
            case -1:
                sb.append("END OF FILE");
                break;
            case 0:
                sb.append("VALUE(");
                sb.append(this.value);
                sb.append(")");
                break;
            case 1:
                sb.append("LEFT BRACE({)");
                break;
            case 2:
                sb.append("RIGHT BRACE(})");
                break;
            case 3:
                sb.append("LEFT SQUARE([)");
                break;
            case 4:
                sb.append("RIGHT SQUARE(])");
                break;
            case 5:
                sb.append("COMMA(,)");
                break;
            case 6:
                sb.append("COLON(:)");
                break;
        }
        return sb.toString();
    }
}
