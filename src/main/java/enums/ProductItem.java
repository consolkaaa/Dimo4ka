package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ProductItem {
    PALTO_ONECOLOUR("Пальто Howick однотонне темно-синє кежуал"),
    SHIRT("Сорочка Time of Style однотонна оливкова кежуал"),
    DRESS_ISSA_PLUS("ISSA PLUS чорня кежуал плаття квітковий — виробництво Україна");

    @Getter
    private String name;
}
