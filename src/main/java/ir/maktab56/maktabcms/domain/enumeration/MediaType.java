package ir.maktab56.maktabcms.domain.enumeration;

import java.util.Arrays;

public enum MediaType {
    ARTICLE(1), VIDEO(2), VOICE(3), GALLERY(4);

    private int order;

    MediaType(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public int getOrder() {
        return this.order;
    }

    public MediaType getByOrder(int order) {
        /*MediaType[] values = MediaType.values();
        for (MediaType type : values) {
            if (type.getOrder() == order)
                return type;
        }
        return null;*/
        return Arrays.stream(MediaType.values()).filter(type -> type.getOrder() == order)
                .findAny().orElse(null);

    }
}
