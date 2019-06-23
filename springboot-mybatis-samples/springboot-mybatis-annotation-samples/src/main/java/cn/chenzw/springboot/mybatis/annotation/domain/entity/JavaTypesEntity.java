package cn.chenzw.springboot.mybatis.annotation.domain.entity;

import cn.chenzw.springboot.mybatis.annotation.domain.enums.OSEnum;
import cn.chenzw.springboot.mybatis.annotation.support.MyBatisRepository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

/**
 * Java数据类型实体
 */
public class JavaTypesEntity {

    private Byte byteType;
    private Byte[] bytesType;
    private Boolean booleanType;
    private Short shortType;
    private Character characterType;
    private Integer integerType;
    private Float floatType;
    private Long longType;
    private Double doubleType;
    private BigDecimal bigDecimalType;
    private Date dateType;
    private OSEnum osEnum;

    public Byte getByteType() {
        return byteType;
    }

    public void setByteType(Byte byteType) {
        this.byteType = byteType;
    }

    public Boolean getBooleanType() {
        return booleanType;
    }

    public void setBooleanType(Boolean booleanType) {
        this.booleanType = booleanType;
    }

    public Short getShortType() {
        return shortType;
    }

    public void setShortType(Short shortType) {
        this.shortType = shortType;
    }

    public Character getCharacterType() {
        return characterType;
    }

    public void setCharacterType(Character characterType) {
        this.characterType = characterType;
    }

    public Integer getIntegerType() {
        return integerType;
    }

    public void setIntegerType(Integer integerType) {
        this.integerType = integerType;
    }

    public Float getFloatType() {
        return floatType;
    }

    public void setFloatType(Float floatType) {
        this.floatType = floatType;
    }

    public Long getLongType() {
        return longType;
    }

    public void setLongType(Long longType) {
        this.longType = longType;
    }

    public Double getDoubleType() {
        return doubleType;
    }

    public void setDoubleType(Double doubleType) {
        this.doubleType = doubleType;
    }

    public Byte[] getBytesType() {
        return bytesType;
    }

    public void setBytesType(Byte[] bytesType) {
        this.bytesType = bytesType;
    }

    public BigDecimal getBigDecimalType() {
        return bigDecimalType;
    }

    public void setBigDecimalType(BigDecimal bigDecimalType) {
        this.bigDecimalType = bigDecimalType;
    }

    public Date getDateType() {
        return dateType;
    }

    public void setDateType(Date dateType) {
        this.dateType = dateType;
    }


    public OSEnum getOsEnum() {
        return osEnum;
    }

    public void setOsEnum(OSEnum osEnum) {
        this.osEnum = osEnum;
    }

    @Override
    public String toString() {
        return "JavaTypesEntity{" +
                "byteType=" + byteType +
                ", bytesType=" + Arrays.toString(bytesType) +
                ", booleanType=" + booleanType +
                ", shortType=" + shortType +
                ", characterType=" + characterType +
                ", integerType=" + integerType +
                ", floatType=" + floatType +
                ", longType=" + longType +
                ", doubleType=" + doubleType +
                ", bigDecimalType=" + bigDecimalType +
                ", dateType=" + dateType +
                ", osEnum=" + osEnum +
                '}';
    }

}
