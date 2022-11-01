package xyz.mwszksnmdys.admin.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class City {
    private Long id;
    private String name;
    private String state;
    private String country;
}
