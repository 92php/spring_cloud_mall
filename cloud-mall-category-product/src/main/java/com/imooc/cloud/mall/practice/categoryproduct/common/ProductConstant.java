package com.imooc.cloud.mall.practice.categoryproduct.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 商品常量类
 */
@Component
public class ProductConstant {

  public static String FILE_UPLOAD_DIR;

  @Value(value = "${file.upload.dir}")
  public void setFileUploadDir(String fileUploadDir){
    FILE_UPLOAD_DIR = fileUploadDir;
  }
}
