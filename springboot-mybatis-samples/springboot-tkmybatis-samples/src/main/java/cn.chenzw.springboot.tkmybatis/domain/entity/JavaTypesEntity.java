package cn.chenzw.springboot.tkmybatis.domain.entity;

import cn.chenzw.springboot.tkmybatis.support.generator.CustIdGenerator;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Java数据类型实体
 */
@Data
public class JavaTypesEntity {

    @Id
    @KeySql(genId = CustIdGenerator.class)
    private String id;

    private Byte byteType;
    private Byte[] bytesType;
    private Boolean booleanType;
    private Short shortType;
    private Character characterType;
    private Integer integerType;
    private Float floatType;
    private Long longType;
    private Double doubleType;

    @Column
    private EnumType enumType;

    @Column(name = "bigdecimal_type")
    private BigDecimal bigDecimalType;

    private Date dateType;

    public static enum EnumType {
        MAN, WONMAN;
    }
}
