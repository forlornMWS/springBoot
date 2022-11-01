package xyz.mwszksnmdys.bean;

import lombok.*;

@NoArgsConstructor
//@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class User {
    private String name;
    private Integer age;

    public User(String name, Integer age){
        this.name = name;
        this.age =age;
    }
}
