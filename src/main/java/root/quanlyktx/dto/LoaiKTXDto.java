package root.quanlyktx.dto;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@ToString
@Getter
public class LoaiKTXDto {
    private Integer soGiuong;
    private Double giaPhong;
    private String Image;
}