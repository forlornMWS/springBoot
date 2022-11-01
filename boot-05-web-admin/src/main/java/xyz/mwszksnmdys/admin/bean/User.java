package xyz.mwszksnmdys.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("user")
public class User implements Serializable {

    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String password;

    //    below is database related field
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
