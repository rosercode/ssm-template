package cool.wangshuo.st.controller;

import cool.wangshuo.st.model.response.GlobalResult;
import cool.wangshuo.st.service.IMailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamSource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


/**
 * @author wangshuo
 * @date 2023/4/30 21:33
 */


@RestController
@Slf4j
@RequestMapping(value = "/iMail")
@Api(value = "邮件发送 接口测试", tags = "邮件发送 接口测试")
public class IMailController {

    @Resource
    private IMailService iMailService;

    private String to = "xxx@xxx.xxx";
    private String subject = "subject";


    @ApiOperation(value = "发送文本邮件")
    @PostMapping(value = "/test1")
    public GlobalResult<String> test1(String content) {
        return iMailService.sendSimpleMail(to, subject, content);
    }

    @ApiOperation(value = "发送HTML邮件")
    @PostMapping(value = "/test2")
    public GlobalResult<String> test2(String content) {
        return iMailService.sendHtmlMail(to, subject, content);
    }

    @ApiOperation(value = "发送带附件的邮件")
    @PostMapping(value = "/test3")
    public GlobalResult<String> test3(String content) {
        return iMailService.sendAttachmentsMail(to, subject, content, "1.jpg");
    }

    @ApiOperation(value = "带附件的邮件")
    @PostMapping(value = "/test4")
    public GlobalResult<String> test4(String content) throws FileNotFoundException {
        return iMailService.sendAttachmentsMail(to, subject, content, "1.jpg", (InputStreamSource) new FileInputStream("1.jpg"));
    }
}
