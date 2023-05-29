package cool.wangshuo.st.service;

import cool.wangshuo.st.model.response.GlobalResult;
import org.springframework.core.io.InputStreamSource;

/**
 * @author wangshuo
 * @date 2023/4/30 21:30
 */

public interface IMailService {

    /**
     * 发送文本邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     */
    public GlobalResult<String> sendSimpleMail(String to, String subject, String content);

    /**
     * 发送HTML邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     */
    public GlobalResult<String> sendHtmlMail(String to, String subject, String content);


    /**
     * 发送带附件的邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     * @param filePath 附件
     */
    public GlobalResult<String> sendAttachmentsMail(String to, String subject, String content, String filePath);

    /**
     * 带附件的邮件
     *
     * @param to       收件人
     * @param subject  主题
     * @param content  内容
     * @param attachmentName 复附件名称
     * @param iss 附件内存数据流
     */
    public GlobalResult<String> sendAttachmentsMail(String to, String subject, String content, String attachmentName, InputStreamSource iss);
}
