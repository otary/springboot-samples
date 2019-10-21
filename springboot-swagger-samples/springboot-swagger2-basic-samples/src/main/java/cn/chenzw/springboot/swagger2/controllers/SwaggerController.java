package cn.chenzw.springboot.swagger2.controllers;

import cn.chenzw.springboot.swagger2.domain.dto.input.SwaggerRespDto;
import cn.chenzw.springboot.swagger2.domain.dto.output.SwaggerParamDto;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(value = "@Api-value", tags = {"@Api-tags1", "@Api-tags2"}, protocols = "https")
@RestController
@RequestMapping("/swagger-test")
public class SwaggerController {

    @ApiOperation(value = "@ApiOperation-value", notes = "@ApiOperation-notes", tags = {"@ApiOperation-tags1",
            "@ApiOperation-tags2"}, response = SwaggerRespDto.class, nickname = "@ApiOperation-nickname"
    )
    @GetMapping("/basic")
    public SwaggerRespDto basic() {
        return new SwaggerRespDto();
    }


    @ApiOperation(value = "带参数的GET请求", notes = "带参数的GET请求notes",
            produces = "application/json, application/xml",
            consumes = "application/json, application/xml",
            response = SwaggerRespDto.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sex", value = "@ApiImplictParam-value", defaultValue = "@ApiImplictParam-defaultValue", allowableValues = "男,女", required = true, example = "女"),
            @ApiImplicitParam(name = "query", value = "@ApiImplictParam-value", defaultValue = "@ApiImplictParam-defaultValue", access = "test", example = "example")})
    @ApiResponses({
            @ApiResponse(code = 100, message = "请求参数有误"),
            @ApiResponse(code = 101, message = "未授权"),
            @ApiResponse(code = 103, message = "禁止访问"),
            @ApiResponse(code = 104, message = "请求路径不存在"),
            @ApiResponse(code = 200, message = "服务器内部错误")
    })
    @GetMapping("/get-with-args")
    public SwaggerRespDto testGetWithArgs(SwaggerParamDto swaggerParamEntity, String sex, String query) {
        return new SwaggerRespDto();
    }

    @ApiOperation(value = "Map参数测试", notes = "Map请求参数和响应值测试")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "map2", paramType = "body", examples = @Example({
                    @ExampleProperty(value = "{'user':'id'}", mediaType = "application/json")}))})
    @PostMapping("/post-map-args")
    public Map<String, String> testMapArgs(@RequestBody Map<String, String> map2) {
        return map2;
    }

    @ApiOperation(value = "带basic认证的GET请求", notes = "带basic认证的GET请求notes",
            produces = "application/json, application/xml",
            consumes = "application/json, application/xml",
            response = SwaggerRespDto.class,
            authorizations = {@Authorization(value = "basicAuth")})
    @GetMapping("/get-with-basic-auth")
    public SwaggerRespDto testGetWithBasicAuth(SwaggerParamDto swaggerParamEntity, String sex, String query) {
        return new SwaggerRespDto();
    }

    // post测试
    // @TODO

    // 上传文件
    // @TODO

}
