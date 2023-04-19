package cool.wangshuo.st.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cool.wangshuo.st.model.enums.SortTypeEnum;
import cool.wangshuo.st.model.vo.base.BaseSortVo;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wangshuo
 * @description Mp 使用到的工具类
 * @date 2022/10/26 13:45
 */
public class MPUtils {

    private static final Pattern humpPattern = Pattern.compile("[A-Z]");

    /**
     * 驼峰转下划线
     */
    public static String humpToLine(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    // 更新 mp 查询容器
    public static void updateQueryWrapper(QueryWrapper queryWrapper, BaseSortVo sortRequest){

        if (StringUtils.isNotBlank(sortRequest.getColumn()) && sortRequest.getSortType()!=null){
            if (sortRequest.getSortType() == SortTypeEnum.DESC){
                queryWrapper.orderByDesc(MPUtils.humpToLine(sortRequest.getColumn()));
            }
            if (sortRequest.getSortType() == SortTypeEnum.ASC){
                queryWrapper.orderByAsc(MPUtils.humpToLine(sortRequest.getColumn()));
            }
            sortRequest.setColumn(MPUtils.humpToLine(sortRequest.getColumn()));
            return;
        }
        queryWrapper.orderByDesc(humpToLine("createTime"));
    }

    // 基于判断一个类里是否存在某个属性
    public static Boolean isExistField(String field, Class clazz) {

        while (clazz != null) {  // 遍历所有父类字节码对象
            Field[] declaredFields = clazz.getDeclaredFields();  // 获取字节码对象的属性对象数组
            for (int i = 0; i < declaredFields.length; i++) {
                if (declaredFields[i].getName().equals(field)) {
                    return true;
                }
            }
            clazz = clazz.getSuperclass();  // 获得父类的字节码对象
        }
        return false;
    }
}
