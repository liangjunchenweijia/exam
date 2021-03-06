package com.exam.exam_system.common.enums;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;


/**
 * @Author : liang_Jun
 * @ClassName : ErrorMsgEnum
 * @Description :
 * @Date : 2020/3/20 14:37
 */
public enum ErrorMsgEnum {

    //接口异常导致服务不可用
    SERVICE_UNAVAILABILITY("000000", "服务不可用"),
    //参数异常
    PARAMETER_EXCEPTION("000001", "参数异常"),
    //用户已存在,请重新注册
    USER_ALREADY_EXISTED("000002", "用户已存在,请重新注册"),
    //用户名或密码错误,请重新输入
    USER_PWD_OR_USER_NAME_ERROR("000003", "用户名或密码错误,请重新输入"),
    //用户不存在
    USER_INEXISTENCE("000004", "用户名不存在"),
    //学号错误,请重新输入
    USER_SNO_ERROR("000005", "学号错误,请重新输入"),
    //权限不足,请先登录
    NOT_LOGIN("000006", "权限不足,请先登录"),
    //请重新登录
    LOGIN_AGAIN("000007", "修改成功,请重新登录"),
    //用户信息修改失败
    UPDATE_USER_ERROR("000008", "用户信息修改失败"),
    //您的账号已被锁定,请联系管理员
    PWD_MODIFY("000009", "您的账号已被锁定,请联系管理员"),

    USER_SNO_ALREADY_EXISTED("000010", "学号已存在,请重新输入"),

    SUBJECTNAME_ALREADY_EXISTED("000011", "学科已存在,请重新输入"),

    USER_NAME_ALREADY_EXISTED("000012", "账号已存在,请重新输入"),

    EXAM_TYPE_NAME_ALREADY_EXISTED("000013", "考试类型名称已存在,请重新输入"),

    EXAM_TYPE_ERROR("000014", "该类型下,已存在考试场次"),

    SAVE_ERROR("000015", "保存失败"),

    EXAM_ALREADY_APPLY("000016", "选中的考试,已有学生报名,请重新选择"),

    TESTPAPER_ALREADY_APPLY("000017", "选中的试卷,已有学生报名,请重新选择"),

    EXAM_UNDERWAY("000018", "该试卷正在考试中"),

    TESTPARPER_ALREADY_ISSUEI("000019", "试卷已发布并且正在考试中"),

    EXAM_ALREADY_EXISTED("000020", "考试已存在"),

    EXAM_HAVE_NOT_STARTED("000021", "该场考试未开始"),

    EXAM_FINISHED("000022", "该场考试已结束"),

    ALREADY_GO_IN_FOR_EXAM("000023", "您已参加过该场考试");
    /**
     * 错误编码为key的所有错误枚举对象的map集合
     */
    private static Map<String, String> enums = new HashMap<>(ErrorMsgEnum.values().length);

    static {
        for (ErrorMsgEnum e : ErrorMsgEnum.values()) {
            enums.put(e.getCode(), e.getMsg());
        }
    }

    /**
     * 通过错误编码获取错误消息内容
     *
     * @param code 错误编码
     * @return 错误消息内容
     */
    public static String getMsgByCode(String code) {
        return enums.get(code);
    }

    /**
     * 通过错误码枚举，返回一个格式化后的错误信息
     *
     * @param constants 错误码枚举
     * @param args      错误信息格式中需要的参数
     * @return 格式化后的错误信息
     */
    public static String getMsg(ErrorMsgEnum constants, Object... args) {
        return MessageFormat.format(constants.getMsg(), args);
    }

    /**
     * 错误编码
     */
    private String code;
    /**
     * 错误消息提示
     */
    private String msg;

    ErrorMsgEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
