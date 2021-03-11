package cn.chenzw.springboot.mybatisplus.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_user")
public class User {

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    private String name;


}
