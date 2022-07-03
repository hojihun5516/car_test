package domain;

import java.util.Arrays;
import java.util.List;

public enum Gear {
    PARK("주차", "P"),RETURN("후진", "R"),NEUTRAL("중립","N"),DRIVE("주행","D");

    private final String label;
    private final String sign;

    Gear(String label, String sign) {
        this.label = label;
        this.sign = sign;
    }

    public static final List<Gear> movable = Arrays.asList(RETURN, DRIVE);

    public static boolean movable(Gear gear){
        if (!movable.contains(gear)) {
            throw new RuntimeException("기어를 변경해주세요");
        }
        return true;
    }
    public String getLabel() {
        return label;
    }

    public String getSign() {
        return sign;
    }
}
