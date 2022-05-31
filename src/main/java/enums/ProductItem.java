package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ProductItem {
    PALTO_ONECOLOUR("Пальто Howick однотонне темно-синє кежуал"),
    SHIRT("Сорочка Time of Style однотонна оливкова кежуал");

    @Getter
    private String name;
}
