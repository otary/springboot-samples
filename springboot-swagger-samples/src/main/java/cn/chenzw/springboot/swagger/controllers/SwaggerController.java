package cn.chenzw.springboot.swagger.controllers;

import cn.chenzw.springboot.swagger.domain.entify.SwaggerEntity;
import cn.chenzw.springboot.swagger.domain.entify.SwaggerParamEntity;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(value = "@Api-value", tags = {"@Api-tags1", "@Api-tags2"}, protocols = "https")
@RestController
@RequestMapping("/swagger-test")
public class SwaggerController {

    @ApiOperation(value = "@ApiOperation-value", notes = "@ApiOperation-notes", tags = {"@ApiOperation-tags1",
            "@ApiOperation-tags2"}, response = SwaggerEntity.class, nickname = "@ApiOperation-nickname")
    @GetMapping("/basic")
    public SwaggerEntity basic() {
        return new SwaggerEntity();
    }


    @ApiOperation(value = "带参数的GET请求", notes = "带参数的GET请求notes")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sex", value = "@ApiImplictParam-value", defaultValue = "@ApiImplictParam-defaultValue", allowableValues = "男,女", required = true, example = "女"),
            @ApiImplicitParam(name = "query", value = "@ApiImplictParam-value", defaultValue = "@ApiImplictParam-defaultValue", access = "test", example = "example")})
    @GetMapping("/get-with-args")
    public SwaggerEntity testGetWithArgs(SwaggerParamEntity swaggerParamEntity, String sex, String query) {
        return new SwaggerEntity();
    }

    @ApiOperation(value = "Map参数测试", notes = "Map请求参数和响应值测试")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "map2", paramType = "body", examples = @Example({
            @ExampleProperty(value = "{'user':'id'}", mediaType = "application/json")}))})
    @PostMapping("/post-map-args")
    public Map<String, String> testMapArgs(@RequestBody Map<String, String> map2) {
        return map2;
    }


    // post测试
    // @TODO

    // 上传文件
    // @TODO

}
