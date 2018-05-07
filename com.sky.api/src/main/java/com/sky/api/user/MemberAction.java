package com.sky.api.user;

import com.sky.api.Constants;
import com.sky.common.MsgHelp;
import com.sky.common.bean.StatusBean;
import com.sky.common.massage.ResponseUtil;
import com.sky.common.massage.Status;
import com.sky.common.piting.Pager;
import com.sky.common.util.*;
import com.sky.dao.enums.DataBaseType;
import com.sky.dao.vo.*;
import com.sky.service.directsale.IMemberMessageService;
import com.sky.service.directsale.MemberService;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.csource.common.NameValuePair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * MemberAction
 *
 * @author dao
 * @version 1.0
 */
@Controller
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@RequestMapping(value = "/user", produces = "application/json")
public class MemberAction {



    private static Logger log = Logger.getLogger("MemberAction");

    @Resource
    private IMemberMessageService memberMessageService;
    /**
     * 用户服务接口
     */
    @Resource
    MemberService memberService;

    @RequestMapping(value = "/getVersion", method = RequestMethod.GET)
    @ResponseBody
    public String getVersion(String version, HttpServletRequest req,
                             HttpServletResponse res) throws Exception {

        return ResponseUtil.success(Constants.CHECK_VERSION);
    }

    /**
     * 上传图像
     *
     * @param file
     * @param version
     * @param req
     * @param res
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/uploadHead", method = RequestMethod.POST)
    @ResponseBody
    @RequiresAuthentication
    public String uploadHead(@RequestParam MultipartFile file, String version,
                             HttpServletRequest req, HttpServletResponse res) throws Exception {
        log.error("----进入上传图片方法--------：" + version);

        if (Version.V10.equals(version)) {
            log.info("----uploadHead---");
            byte[] fileBuff = file.getBytes();
            // 文件名
            String tempFileName = file.getOriginalFilename();
            String fileExtName = tempFileName.substring(
                    tempFileName.lastIndexOf(".") + 1, tempFileName.length()); // 图片格式
            // 设置元信息
            NameValuePair[] metaList = new NameValuePair[3];
            metaList[0] = new NameValuePair("fileName", tempFileName);
            metaList[1] = new NameValuePair("fileExtName", fileExtName);
            metaList[2] = new NameValuePair("fileLength", String.valueOf(file.getSize()));
//			String filedId = FastDFUploadUtil.upload(fileBuff, fileExtName,
//					metaList);
//            log.info("------将要进入方法------");
            StatusBean statusBean = FastDFUploadUtil.upload(file);
            if (!statusBean.getStatus()) {
                return ResponseUtil.error(MsgHelp.UPLOAD_HEAD_IMAGE_FAIL);
            } else {
                String url = SpringValuesUtil.getValue("image_path");
                log.error("上传头像进程11111111111111");

                memberService.updateHead(statusBean.getMsg());
                log.error("上传头像进程3333333333");

                APIImageUrlBean imageUrlBean = new APIImageUrlBean();
                imageUrlBean.setImgUrl(statusBean.getMsg());
                return ResponseUtil.data(imageUrlBean, MsgHelp.UPLOAD_HEAD_IMAGE_SUCCESS);
            }
        }
        return ResponseUtil.unknownVersion();
    }






    /**
     * 用户密码修改
     *
     * @param password
     * @return
     */
    @RequestMapping(value = "/chagesUserPassowrd", method = RequestMethod.POST)
    @ResponseBody
//    @RequiresAuthentication
    public String chagesUserPassowrd(String username ,String password, String newPass, String version, HttpServletRequest req, HttpServletResponse res)
            throws Exception {

//        log.error("修改密码接收的参数：" + "密码：" + password + "新密码：" + newPass + "二级密码：" + secondpwd + "新二级：" + newsecondpwd);

        if (StringUtil.isNull(password) || StringUtil.isNull(newPass)) {
            return ResponseUtil.error(MsgHelp.PASSWORD_NOT_NULL);
        }

        FoodWareHouse bean = SessionUtil.getSessionByUserName(username);
        /***** 校验用户输入的密码 ****/

        String passwordMd5 = MD5Util.MD5(password);
        if (!bean.getPassword().equals(passwordMd5)) {
            return ResponseUtil.error(MsgHelp.PASSWORD_ERROR);
        }
        if (Version.V10.equals(version)) {
            FoodWareHouse breans = new FoodWareHouse();
            breans.setUsername(bean.getUsername());
            String newPassMd5 = MD5Util.MD5(newPass);
            breans.setPassword(newPassMd5);
            if (memberService.update(breans).getStatus()) {

                return ResponseUtil.success("修改成功");

            } else
                return ResponseUtil.error();
        }
        return ResponseUtil.unknownVersion();
    }


    /**
     * 用户密码验证
     *
     * @param password
     * @return
     */
    @RequestMapping(value = "/checkPassowrd", method = RequestMethod.POST)
    @ResponseBody
//    @RequiresAuthentication
    public String chagesUserPassowrd(String username ,String password, HttpServletRequest req, HttpServletResponse res)
            throws Exception {

//        log.error("修改密码接收的参数：" + "密码：" + password + "新密码：" + newPass + "二级密码：" + secondpwd + "新二级：" + newsecondpwd);

        if (StringUtil.isNull(password)) {
            return ResponseUtil.error(MsgHelp.PASSWORD_NOT_NULL);
        }

        FoodWareHouse bean = SessionUtil.getSessionByUserName(username);
        /***** 校验用户输入的密码 ****/

        String passwordMd5 = MD5Util.MD5(password);
        if (!bean.getPassword().equals(passwordMd5)) {
            return ResponseUtil.error(MsgHelp.PASSWORD_ERROR);
        }else {
            return ResponseUtil.success("密码正确");
        }
    }












    private int getRegisterCounts(String phone) {

        String phonePure=phone;
//			判断代报的手机号是否带字母
        if (judgeContainsStr(phone)){ phonePure=phone.substring(0,11); }

        String sql="select count(member_id) from member where phone like '"+phonePure+"%'";

        return JdbcTemplateDaoSupport.count(sql,null);
    }

    /**
     * 该方法主要使用正则表达式来判断字符串中是否包含字母
     * @author
     * @param cardNum 待检验的原始手机号
     * @return 返回是否包含
     */
    public boolean judgeContainsStr(String cardNum) {
        String regex=".*[a-zA-Z]+.*";
        Matcher m= Pattern.compile(regex).matcher(cardNum);
        return m.matches();
    }







}
