package cn.chenzw.springboot.swagger.controllers;

import cn.chenzw.springboot.swagger.domain.entify.SwaggerEntity;
import cn.chenzw.springboot.swagger.domain.entify.SwaggerParamEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "@Api-value", tags = {"@Api-tags1", "@Api-tags2"}, protocols = "https")
@RestController
@RequestMapping("/swagger-test")
public class SwaggerController {

    @ApiOperation(value = "@ApiOperation-value", notes = "@ApiOperation-notes", tags = {"@ApiOperation-tags1", "@ApiOperation-tags2"},
            response = SwaggerEntity.class, nickname = "@ApiOperation-nickname")
    @GetMapping("/basic")
    public SwaggerEntity basic() {
        return new SwaggerEntity();
    }


    @ApiOperation(value = "带参数的GET请求", notes = "带参数的GET请求notes")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sex", value = "@ApiImplictParam-value", defaultValue = "@ApiImplictParam-defaultValue",
                    allowableValues = "男,女", required = true
            ),
            @ApiImplicitParam(name = "query", value = "@ApiImplictParam-value", defaultValue = "@ApiImplictParam-defaultValue",
            access = "test")
    })
    @GetMapping("/get-with-args")
    public SwaggerEntity testGetWithArgs(SwaggerParamEntity swaggerParamEntity, String sex, String query) {
        return new SwaggerEntity();
    }

    // post测试
    // @TODO

    // 上传文件
    // @TODO

}
