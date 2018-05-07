package com.sky.api.version;

import com.sky.common.massage.ResponseUtil;
import com.sky.dao.vo.VersionVo;
import com.sky.common.util.RegexUtils;
import com.sky.common.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * VersionAction
 * 
 * @author qiujingwang
 * @version 1.0
 */
@Controller
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@RequestMapping(value = "/version", produces = "application/json")
public class VersionAction {

	private static Logger log = Logger.getLogger("VersionAction");

	public static final String DEFAULT_VERSION = "1.0";

	public static final String YES_UPDATE = "Y";

	//当前版本号x.x或x.x.x
	@Value("#{commonProperties['version.current']}")
	private String currentVersion=DEFAULT_VERSION;

	//是否更新(Y/N)
	@Value("#{commonProperties['version.update']}")
	private String update="N";

	//是否包含x.x,x.x.x版本(多个则逗号分割)
	@Value("#{commonProperties['version.contain']}")
	private String containVersion;

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ResponseBody
	public String get() throws Exception {
		return ResponseUtil.success("当前API版本号："+currentVersion);
	}

	@RequestMapping(value = "/updateVersion", method = RequestMethod.GET)
	@ResponseBody
	public String updateVersion(String version, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		if(StringUtil.isNull(currentVersion)){
			currentVersion = DEFAULT_VERSION;
		}
		VersionVo versionVo = new VersionVo(currentVersion);
		if(!StringUtils.equalsIgnoreCase(YES_UPDATE, update)){
			return ResponseUtil.data(versionVo);
		}
		if(StringUtil.isNull(version) || !RegexUtils.checkVersion(version)){
			return ResponseUtil.unknownVersion();
		}
		if(StringUtils.isNotBlank(containVersion)){
			String[] contains = containVersion.split(",");
			for(String v : contains){
				if(StringUtils.equalsIgnoreCase(v, version)){
					return ResponseUtil.data(versionVo);
				}
			}
		}
		if(currentVersion.compareToIgnoreCase(version) > 0){
			versionVo.setNeedUpdate(true);//需要更新
			versionVo.setMsg("版本过低，请更新后使用！");
			return ResponseUtil.data(versionVo);
		}
		return ResponseUtil.data(versionVo);
	}
}
