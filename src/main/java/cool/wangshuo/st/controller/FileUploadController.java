package cool.wangshuo.st.controller;

import cool.wangshuo.st.model.response.GlobalResult;
import cool.wangshuo.st.utils.FileType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author wangshuo
 * @date 2023/4/30 20:37
 */

@RestController
@Slf4j
@RequestMapping(value = "/upload")
@Api(value = "文件上传 接口测试", tags = "文件上传 接口测试")
public class FileUploadController {

    private static final long MAX_FILE_SIZE = 10 * 1024 * 1024; // 10MB
    private static final String[] ALLOWED_EXTENSIONS = { "jpg", "jpeg", "png", "gif"};


    @ApiOperation(value = "文件上传测试1 - 普通文件上传")
    @PostMapping(value = "/test1")
    public GlobalResult<String> test1(@RequestParam("file") MultipartFile file){
        return uploadFile(file);
    }

    @ApiOperation(value = "文件上传测试2 - 图片上传")
    @PostMapping(value = "/test2")
    public GlobalResult<String> test2(@RequestParam("imageFile") MultipartFile imageFile){
        String format = "";
        try {
            format = FileType.getFileType(imageFile.getInputStream());
            if (!Arrays.asList(ALLOWED_EXTENSIONS).contains(format)){
                return GlobalResult.error("格式错误，只能上传以下格式的文件：" + String.join(",", ALLOWED_EXTENSIONS));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uploadFile(imageFile);
    }

    private GlobalResult<String> uploadFile(MultipartFile file) {
        if (file.isEmpty()) {
            return GlobalResult.error("文件不能为空");
        }
        if (file.getSize() > MAX_FILE_SIZE) {
            return GlobalResult.error("文件大小不能超过10MB");
        }
        try {
            // 保存文件
            file.transferTo(new java.io.File(Objects.requireNonNull(file.getOriginalFilename())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return GlobalResult.success();
    }
}
