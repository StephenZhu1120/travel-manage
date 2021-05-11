package com.ruoyi.travel.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 测试功能对象 test_travel
 * 
 * @author buaa_travel
 * @date 2021-05-11
 */
public class TestTravel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String textVarchar;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String textLongtext;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String hunVarchar;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String hunLongtext;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTextVarchar(String textVarchar) 
    {
        this.textVarchar = textVarchar;
    }

    public String getTextVarchar() 
    {
        return textVarchar;
    }
    public void setTextLongtext(String textLongtext) 
    {
        this.textLongtext = textLongtext;
    }

    public String getTextLongtext() 
    {
        return textLongtext;
    }
    public void setHunVarchar(String hunVarchar) 
    {
        this.hunVarchar = hunVarchar;
    }

    public String getHunVarchar() 
    {
        return hunVarchar;
    }
    public void setHunLongtext(String hunLongtext) 
    {
        this.hunLongtext = hunLongtext;
    }

    public String getHunLongtext() 
    {
        return hunLongtext;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("textVarchar", getTextVarchar())
            .append("textLongtext", getTextLongtext())
            .append("hunVarchar", getHunVarchar())
            .append("hunLongtext", getHunLongtext())
            .toString();
    }
}
