package com.rainsunset.service.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author ChenYanRui
 * @since 2020/5/9
 */
@ApiModel("demo入参")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DemoReq implements Serializable {
    @ApiModelProperty(value = "姓名", example = "''")
    @NotBlank(message = "姓名不能为空")
    @Length(message = "姓名长度不能超过10位", max = 10)
    private String name;
    @ApiModelProperty(value = "年龄", example = "18")
    @Pattern(regexp = "\\d*", message = "年龄必须为正整数")
    private String age;
}
