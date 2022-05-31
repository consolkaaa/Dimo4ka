package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ProductItem {
//    PALTO_ONECOLOUR("Пальто Howick однотонне темно-синє кежуал"),
//    SHIRT("Сорочка Time of Style однотонна оливкова кежуал"),
    DRESS_ISSA_PLUS("Nenka жовта сукня з орнаментом короткий трикотаж — виробництво Україна", "Сукня Nenka");

    @Getter
    private String name;
    @Getter
    private String cartName;
}
