package com.sky.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import com.sky.common.util.zxing.ZxingUtil;
import org.apache.log4j.Logger;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.Resource;
import com.aliyun.oss.OSSClient;
import com.sky.common.bean.StatusBean;
import com.sky.common.util.StringUtil;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FastDFUploadUtil {

	private static Logger log = Logger.getLogger("FastDFUploadUtil");

	static Logger logger = Logger.getLogger(FastDFUploadUtil.class);
	// endpoint是访问OSS的域名。如果您已经在OSS的控制台上 创建了Bucket，请在控制台上查看域名。
	// 如果您还没有创建Bucket，endpoint选择请参看文档中心的“开发人员指南 > 基本概念 > 访问域名”，
	// 链接地址是：https://help.aliyun.com/document_detail/oss/user_guide/oss_concept/endpoint.html?spm=5176.docoss/user_guide/endpoint_region
	// endpoint的格式形如“http://oss-cn-hangzhou.aliyuncs.com/”，注意http://后不带bucket名称，
	// 比如“http://bucket-name.oss-cn-hangzhou.aliyuncs.com”，是错误的endpoint，请去掉其中的“bucket-name”。
	private static String endpoint = "http://oss-cn-beijing.aliyuncs.com";

	// accessKeyId和accessKeySecret是OSS的访问密钥，您可以在控制台上创建和查看，
	// 创建和查看访问密钥的链接地址是：https://ak-console.aliyun.com/#/。
	// 注意：accessKeyId和accessKeySecret前后都没有空格，从控制台复制时请检查并去除多余的空格。
	private static String accessKeyId = "LTAIRguazZ8sktRM";
	private static String accessKeySecret = "Czo9PhL4Px7Xj91FYaB7ffahjCamJd";

	// Bucket用来管理所存储Object的存储空间，详细描述请参看“开发人员指南 > 基本概念 > OSS基本概念介绍”。
	// Bucket命名规范如下：只能包括小写字母，数字和短横线（-），必须以小写字母或者数字开头，长度必须在3-63字节之间。
	private static String bucketName = "sky-kanger-odo";

	/**
	 * 
	* @Title: uploadUserEqCode    
	* @Description: TODO    
	* @param @param url
	* @param @param userImage
	* @param @return 
	* @return String
	* @throws
	 */
	public static String uploadUserEqCode(String urlContent, String userImage,String invitationCode,int videoId,HttpServletRequest req) throws Exception {
		// 文件名
		String tempFileName = invitationCode+""+videoId+".png";
		String fileExtName = "png"; // 图片格式
		
		//生成 二维码路径
		String imgPath=req.getSession().getServletContext().getRealPath("") +"image";
		if(StringUtil.isNull(userImage)){
			//取默认图片路径
			userImage = req.getSession().getServletContext().getRealPath("") +"image/defoult_user.png";
		}
		
		//1.生成 二维码
		String imgPash = ZxingUtil.encode(urlContent, userImage, imgPath, true, tempFileName);
		File qrcodeFile = new File(imgPash);   
		
		//2.上传图片
		FileInputStream fis = new FileInputStream(qrcodeFile);
		byte[] buf = new byte[(int) qrcodeFile.length()];
		fis.read(buf);
	    fis.close();
	    
		//2.1设置元信息 上传图片
		NameValuePair[] metaList = new NameValuePair[3];
		metaList[0] = new NameValuePair("fileName", tempFileName);
		metaList[1] = new NameValuePair("fileExtName", fileExtName);
		metaList[2] = new NameValuePair("fileLength", qrcodeFile.length()+"");
//		String uploadPash = upload(buf, fileExtName, metaList);
		String uploadPash = "";
		StatusBean upload = upload(qrcodeFile);
//		if(!StringUtil.isNull(uploadPash)){
//			deleteFile(qrcodeFile);
//		}
		if (upload.getStatus()){
			uploadPash = upload.getMsg();
		}
		return uploadPash;
	}
	/**
	 * @param @param  url
	 * @param @param  userImage
	 * @param @return
	 * @return String
	 * @throws
	 * @Title: uploadMemberEqCode
	 * @Description: 生成用户注册二维码
	 */
	public static String uploadMemberEqCode(String invitCode, HttpServletRequest req) throws Exception {
		// 文件名
		String tempFileName = invitCode + ".png";
		String fileExtName = "png"; // 图片格式

		//生成 二维码路径
		String imgPath = req.getSession().getServletContext().getRealPath("") + "image";

		String urlContent =SpringValuesUtil.getValue("qrCode_url");
		urlContent = urlContent+invitCode;
		//1.生成 二维码
		String imgPash = ZxingUtil.encode(urlContent, imgPath, tempFileName);
		File qrcodeFile = new File(imgPash);

		//2.上传图片
		FileInputStream fis = new FileInputStream(qrcodeFile);
		byte[] buf = new byte[(int) qrcodeFile.length()];
		fis.read(buf);
		fis.close();

		//2.1设置元信息 上传图片
		NameValuePair[] metaList = new NameValuePair[3];
		metaList[0] = new NameValuePair("fileName", tempFileName);
		metaList[1] = new NameValuePair("fileExtName", fileExtName);
		metaList[2] = new NameValuePair("fileLength", qrcodeFile.length() + "");
//		String uploadPash = upload(buf, fileExtName, metaList);
//		if (!StringUtil.isNull(uploadPash)) {
//			deleteFile(qrcodeFile);
//		}
		String uploadPash = "";
		StatusBean upload = upload(qrcodeFile);
		if (upload.getStatus()){
			uploadPash = upload.getMsg();
		}
		return uploadPash;
	}
	
	/** 
	 * 删除单个文件 
	 * @param   file    被删除文件的文件名
	 * @return 单个文件删除成功返回true，否则返回false 
	 */  
	public static boolean deleteFile(File file) {  
	    boolean flag = false;  
	    // 路径为文件且不为空则进行删除  
	    if (file.isFile() && file.exists()) {  
	        file.delete();  
	        flag = true;  
	    }  
	    return flag;  
	} 

//	/**
//	 * 上传头像到 fastDF
//	 *
//	 * @param file_buff
//	 * @param file_ext_name
//	 *            文件格式名称,可以为空
//	 * @param meta_list
//	 *            文件参数,可以为空
//	 * @return
//	 */
//	public static String upload(byte[] fileBuff, String fileExtname, NameValuePair[] metaList) {
//		String fileid = "";
//		try {
//			ResouceUtils fasteDb = SpringUtils.getBean("fastDbResource");
//			Resource resource = fasteDb.getFastDbResource();
//			File path = resource.getFile();
//			String pathstr = path.getPath();
//			log.info(pathstr);
//			ClientGlobal.init(pathstr);
//			TrackerClient tc = new TrackerClient(ClientGlobal.g_tracker_group);
//			TrackerServer ts = tc.getConnection();
//			if (ts == null) {
//				log.info("getConnection return null");
//				return fileid;
//			}
//
//			StorageServer ss = tc.getStoreStorage(ts);
//			if (ss == null) {
//				log.info("getStoreStorage return null");
//			}
//			StorageClient1 sc1 = new StorageClient1(ts, ss);
//			fileid = sc1.upload_file1(fileBuff, fileExtname, metaList); // 上传
//		} catch (Exception ex) {
//			log.error(ex.getMessage());
//		}
//		return fileid;
//	}

	public static StatusBean upload(MultipartFile files){
		String url = "http://sky-kanger-odo.oss-cn-beijing.aliyuncs.com";
		try {
			log.info("开始上传图片");
			CommonsMultipartFile cf = (CommonsMultipartFile)files;
			//这个myfile是MultipartFile的
			DiskFileItem fi = (DiskFileItem) cf.getFileItem();
			File file = fi.getStoreLocation();
			String tempFileName = files.getOriginalFilename();   //文件名
			String fileExtName = tempFileName.substring(tempFileName.lastIndexOf(".")+1,tempFileName.length());//格式
			String fileName= StringUtil.getUUID();
			log.info("开始链接oss");
//            file.renameTo(new File(file.getParent() + File.separator  + fileName));

			OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
			log.info("链接oss成功");
			if (ossClient.doesBucketExist(bucketName)) {
				logger.info("您已经创建Bucket：" + bucketName + "。");
			} else {
				logger.info("您的Bucket不存在，创建Bucket：" + bucketName + "。");
				// 创建Bucket。详细请参看“SDK手册 > Java-SDK > 管理Bucket”。
				// 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/manage_bucket.html?spm=5176.docoss/sdk/java-sdk/init
			}
			ossClient.createBucket(bucketName);
			InputStream inputStream = files.getInputStream();
			log.info("开始上传图片，文件名："+ fileName + "."+ fileExtName);
			ossClient.putObject(bucketName, fileName + "."+ fileExtName, inputStream);
			log.info("上传成功");
			url = url + "/"+ fileName + "."+ fileExtName;

		} catch (Exception e){
			return new StatusBean(false,"上传失败");
		}
		return new StatusBean(true,url);


	}

	public static StatusBean upload(File files){
		String url = "http://sky-kanger-odo.oss-cn-beijing.aliyuncs.com";
		try {
			logger.info("开始上传图片" );
			String tempFileName = files.getName();
			logger.info("文件名称：" + tempFileName );
			String fileExtName = tempFileName.substring(tempFileName.lastIndexOf(".")+1,tempFileName.length());//格式
			String fileName= StringUtil.getUUID();
			logger.info("开始链接OSS" );
//            file.renameTo(new File(file.getParent() + File.separator  + fileName));

			OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
			logger.info("链接OSS成功" );
			if (ossClient.doesBucketExist(bucketName)) {
				logger.info("您已经创建Bucket：" + bucketName + "。");
			} else {
				logger.info("您的Bucket不存在，创建Bucket：" + bucketName + "。");
			}
			ossClient.createBucket(bucketName);
			log.info("----开始上传图片----");
			ossClient.putObject(bucketName, fileName + "."+ fileExtName, files);
			log.info("-----上传成功----");
			url = url + "/"+ fileName + "."+ fileExtName;
		} catch (Exception e){
			return new StatusBean(false,"上传失败");
		}
		return new StatusBean(true,url);


	}


//	public static void main(String[] args) {
//		upload(null, null, null);
//	}

	public static void main(String[] args) {

	}
}
